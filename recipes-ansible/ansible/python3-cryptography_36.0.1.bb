
SUMMARY = "cryptography is a package which provides cryptographic recipes and primitives to Python developers."
HOMEPAGE = "https://github.com/pyca/cryptography"
AUTHOR = "The Python Cryptographic Authority and individual contributors <cryptography-dev@python.org>"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.APACHE;md5=4e168cce331e5c827d4c2b68a6200e1b"

SRC_URI = "https://files.pythonhosted.org/packages/f9/4b/1cf8e281f7ae4046a59e5e39dd7471d46db9f61bb564fddbff9084c4334f/cryptography-36.0.1.tar.gz"
SRC_URI[md5sum] = "71c126b9d2e59d201fe2688a525f7dc6"
SRC_URI[sha256sum] = "53e5c1dc3d7a953de055d77bef2ff607ceef7a2aac0353b5d630ab67f7423638"

S = "${WORKDIR}/cryptography-36.0.1"

RDEPENDS_${PN} = "python3-cffi"

inherit setuptools3
