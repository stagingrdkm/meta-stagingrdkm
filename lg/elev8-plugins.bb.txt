# ============================================================================
# Copyright (c) 2016 Liberty Global. All rights reserved.
# ============================================================================
#
SUMMARY = "EFL API extensions"
DESCRIPTION = "LGi custom API extensions"
LICENSE = "CLOSED"

DEPENDS_append_class-native = " qtbase efl rapidjson libconfig curl nodejs-modules ${@base_conditional('PREFERRED_VERSION_efl', '1.18.0', '', 'elementary', d)} ${@bb.utils.contains('ENABLE_NODEJS_BINDINGS', '1', 'nodejs', 'libv8', d)} gtest-native"
DEPENDS_append_class-target = " qtbase efl rapidjson libconfig ecore wayland iarmbus servicemanager slauncher devupdate rdk-logger"

RDEPENDS_${PN} = "libconfig devupdate rdk-logger"
RDEPENDS_${PN}_class-native = "libconfig"

# output is stored in the same dir as sources, so we have to introduce dependency just to have only one build at a time
DEPENDS_class-target += "${PN}-native"

ONEMW_SRC_SUBPATH = "${BPN}"

inherit onemwsrc pkgconfig binconfig

OM_ELEV8_PLUGINS_EXTRADIRS = ""

HAVE_NODEJS="${@bb.utils.contains('ENABLE_NODEJS_BINDINGS', '1', '1', '', d)}"
HAVE_PXSCENE="${@bb.utils.contains('ENABLE_NODEJS_PXSCENE', '1', '1', '', d)}"

do_compile() {
    make -C ${S} PREFIX="${prefix}" WORKDIR="${B}" DESTDIR="${D}" SYSROOT_DIR="${PKG_CONFIG_SYSROOT_DIR}" HAVE_NODEJS="${HAVE_NODEJS}" HAVE_PXSCENE="${HAVE_PXSCENE}" EXTRADIRS="${OM_ELEV8_PLUGINS_EXTRADIRS}"
#    make -C ${S} PREFIX="${prefix}" WORKDIR="${B}" DESTDIR="${D}" SYSROOT_DIR="${PKG_CONFIG_SYSROOT_DIR}" HAVE_NODEJS="${HAVE_NODEJS}" HAVE_PXSCENE="${HAVE_PXSCENE}" EXTRADIRS="${OM_ELEV8_PLUGINS_EXTRADIRS}" RDK_LOGGER_ENABLED=1
}

do_compile_class-native() {
    make -C ${S} PREFIX="${prefix}" WORKDIR="${B}" DESTDIR="${D}" SYSROOT_DIR="${PKG_CONFIG_SYSROOT_DIR}" HAVE_NODEJS="${HAVE_NODEJS}" HAVE_PXSCENE="${HAVE_PXSCENE}" EXTRADIRS="${OM_ELEV8_PLUGINS_EXTRADIRS}" NATIVE_BUILD=1
    cmake -Dincludedir=${includedir} -Dlibdir=${libdir} -Dsrcdir=${S} ${S}/unit-tests
    make
    ./elev8-unit-tests
    npm -C ${S}/js_tests install
    npm -C ${S}/js_tests run test:framework
}

do_install() {
#    make -C ${S} PREFIX="${prefix}" WORKDIR="${B}" DESTDIR="${D}" SYSROOT_DIR="${PKG_CONFIG_SYSROOT_DIR}" HAVE_NODEJS="${HAVE_NODEJS}" HAVE_PXSCENE="${HAVE_PXSCENE}" EXTRADIRS="${OM_ELEV8_PLUGINS_EXTRADIRS}" RDK_LOGGER_ENABLED=1 install
    make -C ${S} PREFIX="${prefix}" WORKDIR="${B}" DESTDIR="${D}" SYSROOT_DIR="${PKG_CONFIG_SYSROOT_DIR}" HAVE_NODEJS="${HAVE_NODEJS}" HAVE_PXSCENE="${HAVE_PXSCENE}" EXTRADIRS="${OM_ELEV8_PLUGINS_EXTRADIRS}" install
}

do_install_class-native() {
    make -C ${S} PREFIX="${prefix}" WORKDIR="${B}" DESTDIR="${D}" SYSROOT_DIR="${PKG_CONFIG_SYSROOT_DIR}" HAVE_NODEJS="${HAVE_NODEJS}" HAVE_PXSCENE="${HAVE_PXSCENE}" EXTRADIRS="${OM_ELEV8_PLUGINS_EXTRADIRS}" NATIVE_BUILD=1 install
}

FILES_${PN} = "${bindir}/*"
FILES_${PN} += "${libdir}/elev8/*/lib*.so*"
FILES_${PN} += "${libdir}/lib*.so*"
FILES_${PN} += "${libdir}/node_modules/*.node"
FILES_${PN} += "${libdir}/node_modules/*.js"
FILES_${PN} += "${libdir}/node_modules/*/*.js"
FILES_${PN} += "${libdir}/node_modules/*/*/*.js"
FILES_${PN} += "${sysconfdir}/awc.config"

FILES_${PN}-dbg += "${libdir}/elev8/*/.debug/lib*.so*"
FILES_${PN}-dbg += "${libdir}/.debug/lib*.so*"
FILES_${PN}-dbg += "${libdir}/node_modules/.debug/*.node"


FILES_${PN}-dev = "${includedir}/awc/"

BBCLASSEXTEND = "native"
