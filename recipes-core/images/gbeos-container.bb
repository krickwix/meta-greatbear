DESCRIPTION = "GBEOS container image"
BUILD_OPTIMIZATION = "-Os"
DISTRO_FEATURES:append = " opengl"
IMAGE_FEATURES:append = " x11 x11-base hwcodecs"
IMAGE_FSTYPES = "container"
PREFERRED_PROVIDER_virtual/kernel = "linux-dummy"

IMAGE_INSTALL = "\
    packagegroup-core-full-cmdline \
    bash curl wget \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image

# Workaround /var/volatile for now
ROOTFS_POSTPROCESS_COMMAND += "rootfs_fixup_var_volatile ; "
rootfs_fixup_var_volatile () {
  install -m 1777 -d ${IMAGE_ROOTFS}/${localstatedir}/volatile/tmp
  install -m 755 -d ${IMAGE_ROOTFS}/${localstatedir}/volatile/log
}
fakeroot do_mklinks_lib () {
	cd ${IMAGE_ROOTFS}
	ln -s lib lib64
}

IMAGE_PREPROCESS_COMMAND += "do_mklinks_lib; "

BUILD_OPTIMIZATION = "-Os"
