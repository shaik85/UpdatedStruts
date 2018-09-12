package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Key class for Entity Bean: ProposalCount
 */
public class ProposalCountKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: salesOrg
	 */
	public java.lang.String salesOrg;
	/**
	 * Implementation field for persistent attribute: proposalContent
	 */
	public java.lang.String proposalContent;
	/**
	 * Implementation field for persistent attribute: customerName
	 */
	public java.lang.String customerName;
	/**
	 * Creates an empty key for Entity Bean: ProposalCount
	 */
	public ProposalCountKey() {
	}
	/**
	 * Creates a key for Entity Bean: ProposalCount
	 */
	public ProposalCountKey(
		java.lang.String salesOrg,
		java.lang.String proposalContent,
		java.lang.String customerName) {
		this.salesOrg = salesOrg;
		this.proposalContent = proposalContent;
		this.customerName = customerName;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey) otherKey;
			return ((this.salesOrg.equals(o.salesOrg))
				&& (this.proposalContent.equals(o.proposalContent)) && (this.customerName
				.equals(o.customerName)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (salesOrg.hashCode() + proposalContent.hashCode() + customerName
			.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: salesOrg
	 */
	public java.lang.String getSalesOrg() {
		return salesOrg;
	}
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public void setSalesOrg(java.lang.String newSalesOrg) {
		salesOrg = newSalesOrg;
	}
	/**
	 * Get accessor for persistent attribute: proposalContent
	 */
	public java.lang.String getProposalContent() {
		return proposalContent;
	}
	/**
	 * Set accessor for persistent attribute: proposalContent
	 */
	public void setProposalContent(java.lang.String newProposalContent) {
		proposalContent = newProposalContent;
	}
	/**
	 * Get accessor for persistent attribute: customerName
	 */
	public java.lang.String getCustomerName() {
		return customerName;
	}
	/**
	 * Set accessor for persistent attribute: customerName
	 */
	public void setCustomerName(java.lang.String newCustomerName) {
		customerName = newCustomerName;
	}
}
