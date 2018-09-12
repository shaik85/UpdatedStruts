package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

/**
 * Key class for Entity Bean: DstrChannel
 */
public class DstrChannelKey implements java.io.Serializable {

	static final long serialVersionUID = 3206093459760846163L;

	/**
	 * Implementation field for persistent attribute: salesGroup
	 */
	public java.lang.String salesGroup;

	/**
	 * Implementation field for persistent attribute: channelRole
	 */
	public java.lang.String channelRole;

	/**
	 * Implementation field for persistent attribute: submitterRole
	 */
	public java.lang.String submitterRole;

	/**
	 * Implementation field for persistent attribute: distributionChannel
	 */
	public java.lang.String distributionChannel;

	/**
	 * Creates an empty key for Entity Bean: DstrChannel
	 */
	public DstrChannelKey() {
	}

	/**
	 * Creates a key for Entity Bean: DstrChannel
	 */
	public DstrChannelKey(
		java.lang.String distributionChannel,
		java.lang.String salesGroup,
		java.lang.String channelRole,
		java.lang.String submitterRole) {
		this.distributionChannel = distributionChannel;
		this.salesGroup = salesGroup;
		this.channelRole = channelRole;
		this.submitterRole = submitterRole;
	}

	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey) otherKey;
			return ((this.distributionChannel.equals(o.distributionChannel))
				&& (this.salesGroup.equals(o.salesGroup))
				&& (this.channelRole.equals(o.channelRole)) && (this.submitterRole
				.equals(o.submitterRole)));
		}
		return false;
	}

	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (distributionChannel.hashCode()
			+ salesGroup.hashCode()
			+ channelRole.hashCode() + submitterRole.hashCode());
	}

	/**
	 * Get accessor for persistent attribute: salesGroup
	 */
	public java.lang.String getSalesGroup() {
		return salesGroup;
	}

	/**
	 * Set accessor for persistent attribute: salesGroup
	 */
	public void setSalesGroup(java.lang.String newSalesGroup) {
		salesGroup = newSalesGroup;
	}

	/**
	 * Get accessor for persistent attribute: channelRole
	 */
	public java.lang.String getChannelRole() {
		return channelRole;
	}

	/**
	 * Set accessor for persistent attribute: channelRole
	 */
	public void setChannelRole(java.lang.String newChannelRole) {
		channelRole = newChannelRole;
	}

	/**
	 * Get accessor for persistent attribute: submitterRole
	 */
	public java.lang.String getSubmitterRole() {
		return submitterRole;
	}

	/**
	 * Set accessor for persistent attribute: submitterRole
	 */
	public void setSubmitterRole(java.lang.String newSubmitterRole) {
		submitterRole = newSubmitterRole;
	}
}
