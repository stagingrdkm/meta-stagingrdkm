SUMMARY = "Cobalt (with wayland-egl backend)"
HOMEPAGE = "https://cobalt.googlesource.com/"
BUGTRACKER = "https://cobalt.googlesource.com/"
#TODO Check the license
LICENSE = "BSD-3-Clause & LGPL-2.0 & LGPL-2.1"
LIC_FILES_CHKSUM = "file://src/LICENSE;md5=d2d164565cc10f298390174d9cb6d18d"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS = "${@bb.utils.contains('ONEMW_SUPPORT', '1', \
    'wayland-egl virtual/egl virtual/libgles2 gstreamer1.0 gstreamer1.0-plugins-base python-native', \
    'userland wayland gstreamer1.0 gstreamer1.0-plugins-base python-native' \
    , d)}"

SRC_URI += "git://cobalt.googlesource.com/depot_tools.git;protocol=https;rev=master;destsuffix=depot_tools;name=depot_tools"
SRC_URI += "git://github.com/stagingrdkm/rpi-cobalt-wayland;protocol=https;rev=master;name=wayland;destsuffix=wayland"
SRC_URI += "git://cobalt.googlesource.com/cobalt;protocol=https;rev=master;name=cobalt"
SRC_URI += "file://resolution-fix.patch"
SRC_URI += "file://0001-Do-not-use-clang-compiler.patch"

S = "${WORKDIR}/git/"

PLATFORM ?= "raspi-wayland"
BUILD_TYPE ?= "gold"

do_configure() {
    export PATH=$PATH:${S}/../depot_tools
    mkdir -p ${S}/src/third_party/starboard/raspi/
    cp -rf ${S}/../wayland ${S}/src/third_party/starboard/raspi/
    ${S}/src/cobalt/build/gyp_cobalt -C ${BUILD_TYPE} ${PLATFORM}
}

do_compile() {
    export PATH=$PATH:${S}/../depot_tools
    ninja -v -C ${S}/src/out/${PLATFORM}_${BUILD_TYPE} cobalt
}

do_install() {
    export PATH=$PATH:${S}/../depot_tools
    install -d ${D}${bindir}
    install -m 0755 ${S}/src/out/${PLATFORM}_${BUILD_TYPE}/cobalt ${D}${bindir}
    cp -rf ${S}/src/out/${PLATFORM}_${BUILD_TYPE}/content ${D}${bindir}
}

FILES_${PN} = "${bindir}/cobalt"
FILES_${PN} += "${bindir}/content/*"
