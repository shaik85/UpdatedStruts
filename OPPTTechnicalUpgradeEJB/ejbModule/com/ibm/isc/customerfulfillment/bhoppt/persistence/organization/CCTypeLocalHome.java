package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

/**
 * Local Home interface for CCType
 */
public interface CCTypeLocalHome extends javax.ejb.EJBLocalHome {

	public static final String COMP_NAME = "java:comp/env/ejb/CCType";

	public static final String JNDI_NAME = "ejb/com/ibm/isc/customerfulfillment/bhoppt/persistence/organization/CCTypeLocalHome";

	/**
	 * Creates an instance from a key for Entity Bean: CCType
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocal create(
		java.lang.String ccType) throws javax.ejb.CreateException;
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocal findByPrimaryKey(
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey key)
			throws javax.ejb.FinderException;
	public java.util.Collection findAllCCType()
		throws javax.ejb.FinderException;
}