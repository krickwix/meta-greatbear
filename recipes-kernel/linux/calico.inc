FILESEXTRAPATHS_prepend := "${THISDIR}/linux-greatbear:"

SRC_URI += "file://ip_set.scc \
            file://nftables.scc \
	    "

KERNEL_FEATURES_append = " ip_set.scc"
KERNEL_FEATURES_append = " nftables.scc"


