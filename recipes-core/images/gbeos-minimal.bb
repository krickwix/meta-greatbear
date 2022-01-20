DESCRIPTION = "GBEOS minimal image"

IMAGE_FSTYPES = "wic.vmdk"

IMAGE_FEATURES:append = " splash ssh-server-openssh package-management"
IMAGE_FEATURES:append = " debug-tweaks empty-root-password allow-empty-password allow-root-login post-install-logging"
IMAGE_ROOTFS_EXTRA_SPACE = "21943040"
IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-core-ssh-openssh \
    tzdata python3-pip perl-misc \
    parted curl k3s \
    linux-firmware kernel-modules \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image setuptools3
