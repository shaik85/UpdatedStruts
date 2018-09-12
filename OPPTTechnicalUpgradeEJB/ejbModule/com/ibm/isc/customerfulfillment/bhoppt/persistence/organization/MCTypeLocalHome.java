package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

/**
 * Local Home interface for MCType
 */
public interface MCTypeLocalHome extends javax.ejb.EJBLocalHome {

	public static final String COMP_NAME = "java:comp/env/ejb/MCType";

	public static final String JNDI_NAME = "ejb/com/ibm/isc/customerfulfillment/bhoppt/persistence/organization/MCTypeLocalHome";

	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocal create(
			java.lang.String mcType) throws javax.ejb.CreateException;

	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocal findByPrimaryKey(
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey key)
			throws javax.ejb.FinderException;

	public java.util.Collection findAllMCType()
		throws javax.ejb.FinderException;
}