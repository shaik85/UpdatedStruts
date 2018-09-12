package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

public class MCTypeKey implements java.io.Serializable {

	public java.lang.String mcType;

	public MCTypeKey() {
	}

	public MCTypeKey(java.lang.String mcType) {
		this.mcType = mcType;
	}

	public java.lang.String getMcType() {
		return mcType;
	}

	public void setMcType(java.lang.String mcType) {
		this.mcType = mcType;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof MCTypeKey) {
			MCTypeKey r = (MCTypeKey) o;

			if (mcType != null) {
				if (!mcType.equals(r.mcType)) {
					return false;
				}
			} else {
				return (r.mcType == null ? true : false);
			}
			return true;
		}
		return false;
	}

	public int hashCode() {
		int hash = 1;
		hash = hash * 31 + (mcType == null ? 0 : mcType.hashCode());
		return hash;
	}
}
