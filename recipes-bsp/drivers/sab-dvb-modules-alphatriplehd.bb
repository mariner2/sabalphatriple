SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.1.24"
GCCREV = "6.2.0"
SRCDATE = "20170323"

SRC_URI[md5sum] = "104750ce5824a125f98e4842c58b11fa"
SRC_URI[sha256sum] = "e2a57fb810fad77d3100887887cf734dc842471aa4e75940357d57d5236543b5"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI = "http://source.mynonpublic.com/alphatriple/alphatriple-drivers-${KV}-${GCCREV}-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -d ${D}/${sysconfdir}/modules-load.d
    install -m 0755 ${WORKDIR}/linuxtv.ko ${D}/lib/modules/${KV}/extra
    echo linuxtv >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"

