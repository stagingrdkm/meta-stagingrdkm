SUMMARY = "Cobalt with wayland-egl on rpi"
HOMEPAGE = "https://cobalt.googlesource.com/"
BUGTRACKER = "https://cobalt.googlesource.com/"
#TODO Check the license
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2d164565cc10f298390174d9cb6d18d"

DEPENDS = "depot-tools userland wayland"

SRC_URI += "git://github.com/stagingrdkm/rpi-cobalt-wayland;protocol=https;rev=master;name=wayland;destsuffix=wayland"
SRC_URI += "git://cobalt.googlesource.com/cobalt;protocol=https;rev=master;name=cobalt"

S = "${WORKDIR}/git/src/"

PLATFORM ?= "raspi-wayland"
BUILD_TYPE ?= "debug"

do_configure() {
    mkdir -p ${S}/third_party/starboard/raspi/
    cp -rf ${S}/../../wayland ${S}/third_party/starboard/raspi/
    ${S}/cobalt/build/gyp_cobalt -C ${BUILD_TYPE} ${PLATFORM}
}
do_compile() {
    ninja -C ${S}/out/${PLATFORM}_${BUILD_TYPE} cobalt
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/out/${PLATFORM}_${BUILD_TYPE}/cobalt ${D}${bindir}
    cp -rf ${S}/out/${PLATFORM}_${BUILD_TYPE}/content ${D}${bindir}
}


FILES_${PN} = "${bindir}/cobalt"
FILES_${PN} += "${bindir}/content/*"
