package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

/**
 * Local Home interface for BLBIndicator
 */
public interface BLBIndicatorLocalHome extends javax.ejb.EJBLocalHome {

	public static final String COMP_NAME = "java:comp/env/ejb/BLBIndicator";

	public static final String JNDI_NAME = "ejb/com/ibm/isc/customerfulfillment/bhoppt/persistence/organization/BLBIndicatorLocalHome";

	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal create(
			java.lang.String blbType) throws javax.ejb.CreateException;

	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal findByPrimaryKey(
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey key)
			throws javax.ejb.FinderException;

	public java.util.Collection findAllBLBIndicator() throws javax.ejb.FinderException;
}