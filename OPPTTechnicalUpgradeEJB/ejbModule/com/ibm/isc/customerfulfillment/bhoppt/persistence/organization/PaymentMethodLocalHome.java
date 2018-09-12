package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

/**
 * Local Home interface for Enterprise Bean: PaymentMethod
 */
public interface PaymentMethodLocalHome extends javax.ejb.EJBLocalHome {

	/**
	 * Creates an instance from a key for Entity Bean: PaymentMethod
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentMethodLocal create(
		java.lang.String id) throws javax.ejb.CreateException;

	/**
	 * Finds an instance using a key for Entity Bean: PaymentMethod
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentMethodLocal findByPrimaryKey(
		java.lang.String primaryKey) throws javax.ejb.FinderException;

	public java.util.Collection findAllPaymentMethod() throws javax.ejb.FinderException;
}
