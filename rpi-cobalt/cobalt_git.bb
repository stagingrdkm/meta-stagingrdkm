SUMMARY = "Cobalt with wayland-egl on rpi"
HOMEPAGE = "https://cobalt.googlesource.com/"
BUGTRACKER = "https://cobalt.googlesource.com/"
#TODO Check the license
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/LICENSE;md5=d2d164565cc10f298390174d9cb6d18d"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS = "depot-tools userland wayland gstreamer1.0 gstreamer1.0-plugins-base"

SRC_URI += "git://github.com/stagingrdkm/rpi-cobalt-wayland;protocol=https;rev=master;name=wayland;destsuffix=wayland"
SRC_URI += "git://cobalt.googlesource.com/cobalt;protocol=https;rev=master;name=cobalt"
SRC_URI += "file://resolution-fix.patch"

S = "${WORKDIR}/git/"

PLATFORM ?= "raspi-wayland"
BUILD_TYPE ?= "debug"

do_configure() {
    mkdir -p ${S}/src/third_party/starboard/raspi/
    cp -rf ${S}/../wayland ${S}/src/third_party/starboard/raspi/
    ${S}/src/cobalt/build/gyp_cobalt -C ${BUILD_TYPE} ${PLATFORM}
}
do_compile() {
    ninja -C ${S}/src/out/${PLATFORM}_${BUILD_TYPE} cobalt
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/src/out/${PLATFORM}_${BUILD_TYPE}/cobalt ${D}${bindir}
    cp -rf ${S}/src/out/${PLATFORM}_${BUILD_TYPE}/content ${D}${bindir}
}


FILES_${PN} = "${bindir}/cobalt"
FILES_${PN} += "${bindir}/content/*"
