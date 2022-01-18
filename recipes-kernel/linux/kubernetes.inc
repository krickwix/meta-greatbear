FILESEXTRAPATHS_prepend := "${THISDIR}/linux-greatbear:"

SRC_URI += "file://kubernetes.scc \
	    "

KERNEL_FEATURES_append = " kubernetes.scc"


