package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Bean implementation class for Enterprise Bean: ProposalCount
 */
public abstract class ProposalCountBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey ejbCreate(
		java.lang.String salesOrg,
		java.lang.String proposalContent,
		java.lang.String customerName) throws javax.ejb.CreateException {
		setSalesOrg(salesOrg);
		setProposalContent(proposalContent);
		setCustomerName(customerName);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String salesOrg,
		java.lang.String proposalContent,
		java.lang.String customerName) throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: proposalCount
	 */
	public abstract int getProposalCount();
	/**
	 * Set accessor for persistent attribute: proposalCount
	 */
	public abstract void setProposalCount(int newProposalCount);
	/**
	 * Get accessor for persistent attribute: salesOrg
	 */
	public abstract java.lang.String getSalesOrg();
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public abstract void setSalesOrg(java.lang.String newSalesOrg);
	/**
	 * Get accessor for persistent attribute: proposalContent
	 */
	public abstract java.lang.String getProposalContent();
	/**
	 * Set accessor for persistent attribute: proposalContent
	 */
	public abstract void setProposalContent(java.lang.String newProposalContent);
	/**
	 * Get accessor for persistent attribute: customerName
	 */
	public abstract java.lang.String getCustomerName();
	/**
	 * Set accessor for persistent attribute: customerName
	 */
	public abstract void setCustomerName(java.lang.String newCustomerName);
}
