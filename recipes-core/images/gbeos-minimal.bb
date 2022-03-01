DESCRIPTION = "GBEOS minimal image"
IMAGE_FEATURES:append = " splash ssh-server-openssh package-management"
IMAGE_FEATURES:append = " debug-tweaks empty-root-password allow-empty-password allow-root-login post-install-logging"
IMAGE_FEATURES:append = " x11-base hwcodecs"
MACHINE_FEATURES:append = " vc4graphics"
IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-core-ssh-openssh \
    tzdata python3 python3-pip perl-misc \
    bash parted curl k3s \
    e2fsprogs e2fsprogs-resize2fs \
    linux-firmware kernel-modules \
    alsa-oss libsdl2 userland \
    python3-ansible python3-ansible-core \
    python3-cffi python3-cryptography \
    python3-jinja2 python3-markupsafe \
    python3-packaging python3-pycparser \
    python3-pyparsing python3-pyyaml \
    python3-resolvelib \
    python3-distutils python3-distutils-extra \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image setuptools3

fakeroot do_mklinks_lib () {
	cd ${IMAGE_ROOTFS}
	ln -s lib lib64
}

fakeroot add_rootpart_resize () {
  cat > ${IMAGE_ROOTFS}/usr/local/bin/resizerootpart.sh << EOF
#!/bin/bash

/usr/sbin/parted /dev/mmcblk0 -s 'resizepart 2 -1'
/sbin/resize2fs /dev/mmcblk0p2
EOF
  cat > ${IMAGE_ROOTFS}/etc/systemd/system/fb-resize-root.service << EOF
[Unit]
Before=systemd-user-sessions.service
Wants=network-online.target
After=network-online.target
ConditionPathExists=!/var/lib/resizerootpart

[Service]
Type=oneshot
ExecStart=/usr/local/bin/resizerootpart.sh
ExecStartPost=/bin/touch /var/lib/resizerootpart
RemainAfterExit=yes

[Install]
WantedBy=multi-user.target
EOF
  chmod a+rx ${IMAGE_ROOTFS}/usr/local/bin/resizerootpart.sh
  ln -s /etc/systemd/system/fb-resize-root.service ${IMAGE_ROOTFS}/etc/systemd/system/multi-user.target.wants/fb-resize-root.service
}

IMAGE_PREPROCESS_COMMAND += "do_mklinks_lib; "
IMAGE_PREPROCESS_COMMAND += "add_rootpart_resize; "


