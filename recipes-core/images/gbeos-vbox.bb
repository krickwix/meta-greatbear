DESCRIPTION = "GBEOS minimal image"

DISTRO_FEATURES += "opengl"
CORE_IMAGE_EXTRA_INSTALL += " gcc cloud-init kernel-dev kernel-devsrc packagegroup-self-hosted"
IMAGE_FEATURES:append = " splash ssh-server-openssh package-management"
IMAGE_FEATURES:append = " debug-tweaks empty-root-password allow-empty-password allow-root-login post-install-logging"
IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-core-ssh-openssh \
    tzdata python3 python3-pip perl-misc \
    bash parted curl k3s \
    e2fsprogs e2fsprogs-resize2fs \
    linux-firmware kernel-modules \
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

IMAGE_PREPROCESS_COMMAND += "do_mklinks_lib; "
