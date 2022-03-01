
SUMMARY = "Python parsing module"
HOMEPAGE = "https://github.com/pyparsing/pyparsing/"
AUTHOR = "Paul McGuire <ptmcg.gm+pyparsing@gmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=657a566233888513e1f07ba13e2f47f1"

#SRC_URI = "https://files.pythonhosted.org/packages/d6/60/9bed18f43275b34198eb9720d4c1238c68b3755620d20df0afd89424d32b/pyparsing-3.0.7.tar.gz"
#SRC_URI[md5sum] = "9d38774991175444e21a3dfa865876cc"
SRC_URI[sha256sum] = "18ee9022775d270c55187733956460083db60b37d0d0fb357445f3094eed3eea"

#S = "${WORKDIR}/pyparsing-3.0.7"

RDEPENDS_${PN} = ""

inherit pypi setuptools3
BBCLASSEXTEND = "native nativesdk"
