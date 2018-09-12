package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local Home interface for Enterprise Bean: ProposalCount
 */
public interface ProposalCountLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: ProposalCount
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountLocal create(
		java.lang.String salesOrg,
		java.lang.String proposalContent,
		java.lang.String customerName) throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: ProposalCount
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey primaryKey)
		throws javax.ejb.FinderException;
}
