package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

public class BLBIndicatorKey implements java.io.Serializable {

	public java.lang.String blbType;

	public BLBIndicatorKey() {
	}

	public BLBIndicatorKey(java.lang.String blbType) {
		this.blbType = blbType;
	}

	public java.lang.String getBlbType() {
		return blbType;
	}

	public void setBlbType(java.lang.String blbType) {
		this.blbType = blbType;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof BLBIndicatorKey) {
			BLBIndicatorKey r = (BLBIndicatorKey) o;

			if (blbType != null) {
				if (!blbType.equals(r.blbType)) {
					return false;
				}
			} else {
				return (r.blbType == null ? true : false);
			}
			return true;
		}
		return false;
	}

	public int hashCode() {
		int hash = 1;
		hash = hash * 31 + (blbType == null ? 0 : blbType.hashCode());
		return hash;
	}
}
