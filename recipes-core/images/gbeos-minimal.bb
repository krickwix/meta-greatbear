DESCRIPTION = "GBEOS minimal image"

IMAGE_FSTYPES = "wic.vmdk"

IMAGE_FEATURES += "splash ssh-server-openssh"
IMAGE_FEATURES += "debug-tweaks empty-root-password allow-empty-password allow-root-login post-install-logging"
IMAGE_ROOTFS_EXTRA_SPACE = "41943040"
IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-core-ssh-openssh \
    tzdata python3-pip perl-misc \
    parted curl k3s \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image setuptools3
