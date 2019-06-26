SUMMARY = "Depot tools for Cobalt" 
HOMEPAGE = "https://cobalt.googlesource.com/"
BUGTRACKER = "https://cobalt.googlesource.com/"
SECTION = "console/network"
#TODO Check the license
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c2c05f9bdd5fc0b458037c2d1fb8d95e"

DEPENDS = "python-native"

SRC_URI = "git://cobalt.googlesource.com/depot_tools.git;protocol=https;rev=master"

SRC_URI[md5sum] = ""
SRC_URI[sha256sum] = ""

S = "${WORKDIR}/git"

inherit autotools native

do_compile() {
}

do_install() {
    install -d ${D}${bindir}
    cd ${S}
    for i in `find . -type d -not -path "./.git*"`; do
        install -d ${D}${bindir}/${i}
    done

    for i in `find . -type d -not -path "./.git*"`; do
        find ${i} -maxdepth 1 -type f -exec install {} ${D}${bindir}/${i} \;
    done
    rm -f ${D}${bindir}/ninja
}


BBCLASSEXTEND = "native nativesdk"
