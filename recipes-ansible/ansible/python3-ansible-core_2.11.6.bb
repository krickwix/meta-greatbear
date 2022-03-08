SUMMARY = "Radically simple IT automation"
HOMEPAGE = "https://ansible.com/"
AUTHOR = "Ansible, Inc. <info@ansible.com>"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

SRC_URI[sha256sum] = "93d50283c7c5b476debf83dc089b3f679b939a8b9a7b5d628d28daafbb3d303a"

INSANE_SKIP:${PN} += "file-rdeps"

PYPI_PACKAGE = "ansible-core"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"

RDEPENDS_${PN} = ""


