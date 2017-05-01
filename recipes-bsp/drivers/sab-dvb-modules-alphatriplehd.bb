SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.1.24"
GCCREV = "4.9.1"
SRCDATE = "20170501"

SRC_URI[md5sum] = "4463b322bc4b732e119d0f2ad743e57d"
SRC_URI[sha256sum] = "db8123359b6447fa6a16fb570ee2b2e70e194c3fd22daa95e725fccfbd0110c8"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI = "http://dvbstand.com/alphatriplehd/drivers/alphatriple-drivers-${KV}-${GCCREV}-${SRCDATE}.zip"

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

