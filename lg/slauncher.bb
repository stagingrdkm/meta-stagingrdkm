# ============================================================================
# Copyright (c) 2016 Liberty Global. All rights reserved.
# ============================================================================
#
SUMMARY = "SLauncher"
LICENSE = "CLOSED"
DEPENDS = "libxml2 dbus wayland lxccpid rdk-logger"

ONEMW_SRC_SUBPATH = "${BPN}"

OM_WAYLAND_COMPOSITOR ??= "weston"

DEPENDS_append = "${@bb.utils.contains('OM_WAYLAND_COMPOSITOR', 'weston', ' weston weston-nsc-backend cairo', '', d)}"
DEPENDS_append = "${@bb.utils.contains('OM_WAYLAND_COMPOSITOR', 'westeros', ' westeros', '', d)}"

SRC_URI += "file://slauncher.service"
SRC_URI += "file://slauncher.xml"

#
# onemwsrc          - external source folder used
# pkgconfig         - pkgconfig used in cmake (adds dependency)
# cmake             - cmake build system used
#

inherit onemwsrc pkgconfig cmake

#
# extra options for cmake
#

EXTRA_OECMAKE += "-DSLAUNCHER_ENV=RDK"
EXTRA_OECMAKE += "-DWAYLAND_COMPOSITOR=${OM_WAYLAND_COMPOSITOR}"
EXTRA_OECMAKE += "-DRDK_LOGGER_ENABLED=1"

INCLUDEDIRS += "-I=${includedir}/dbus-1.0/"
INCLUDEDIRS += "-I=${libdir}/dbus-1.0/include/"
INCLUDEDIRS += "-I=${includedir}/libxml2"

INCLUDEDIRS += "${@bb.utils.contains('OM_WAYLAND_COMPOSITOR', 'weston', ' -I=${includedir}/weston/', '', d)}"
INCLUDEDIRS += "${@bb.utils.contains('OM_WAYLAND_COMPOSITOR', 'weston', ' -I=${includedir}/weston-nsc-backend/', '', d)}"
INCLUDEDIRS += "${@bb.utils.contains('OM_WAYLAND_COMPOSITOR', 'weston', ' -I=${includedir}/weston/build/', '', d)}"
INCLUDEDIRS += "${@bb.utils.contains('OM_WAYLAND_COMPOSITOR', 'weston', ' -I=${includedir}/cairo/', '', d)}"
INCLUDEDIRS += "-I=${datadir}/src/"
INCLUDEDIRS += "${@bb.utils.contains('OM_WAYLAND_COMPOSITOR', 'weston', ' -I=${datadir}/weston/source/shared/', '', d)}"
INCLUDEDIRS += "${@bb.utils.contains('OM_WAYLAND_COMPOSITOR', 'weston', ' -I=${datadir}/weston/', '', d)}"
INCLUDEDIRS += "${@bb.utils.contains('OM_WAYLAND_COMPOSITOR', 'weston', ' -I=${datadir}/weston/build/', '', d)}"

CFLAGS += "${INCLUDEDIRS}"
CXXFLAGS += "${CFLAGS}"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${B}/bin/slauncher ${D}${bindir}/
    install -m 0755 ${B}/bin/cpid ${D}${bindir}/
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/slauncher.service ${D}${systemd_unitdir}/system/
    install -d ${D}${libdir}
    install -m 0755 ${B}/libs/libslauncher_client.so ${D}${libdir}/
    install -m 0755 ${B}/libs/libdisplay_manager.so ${D}${libdir}/
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/slauncher.xml ${D}${sysconfdir}/
    install -d ${D}${includedir}/awc
    install -m 0644 ${S}/client/AWCClient.h ${D}${includedir}/awc/
    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${S}/client/libslauncher_client.pc ${D}${libdir}/pkgconfig/
#SLAUNCHER DBUS API disabled
#    install -m 0755 ${B}/bin/slauncher_cli ${D}${bindir}
#    install -d ${D}${includedir}/slauncher
#    install -m 0644 ${S}/client/slauncher_client.h ${D}${includedir}/slauncher/
}

FILES_${PN} = "${libdir}/libslauncher_client.so"
FILES_${PN} += "${libdir}/libdisplay_manager.so"
FILES_${PN} += "${bindir}"
FILES_${PN} += "${systemd_unitdir}/system/slauncher.service"
FILES_${PN} += "${sysconfdir}/slauncher.xml"
#FILES_${PN}-dev = "${includedir}/slauncher"
FILES_${PN}-dev = "${includedir}/awc"
FILES_${PN}-dev += "${libdir}/pkgconfig/libslauncher_client.pc"
