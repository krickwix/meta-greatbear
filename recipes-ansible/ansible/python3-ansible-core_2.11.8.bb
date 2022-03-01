
SUMMARY = "Radically simple IT automation"
HOMEPAGE = "https://ansible.com/"
AUTHOR = "Ansible, Inc. <info@ansible.com>"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

#SRC_URI = "https://files.pythonhosted.org/packages/2a/3f/74189f84fc9a4a203fc9644cd62146ba735fd9dd17f94867a272075c3cc7/ansible-core-2.11.8.tar.gz"
#SRC_URI[md5sum] = "8ad783b2c53afbc65ab9ccec182b245d"
SRC_URI[sha256sum] = "5f360f090a6f2e3169e583542413bdd40b8122dbc4153603048e7747d1ba9604"

#S = "${WORKDIR}/ansible-core-2.11.8"

RDEPENDS_${PN} = ""

inherit pypi setuptools3
BBCLASSEXTEND = "native nativesdk"
