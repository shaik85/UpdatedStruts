package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

/**
 * Local interface for Enterprise Bean: PaymentMethod
 */
public interface PaymentMethodLocal extends javax.ejb.EJBLocalObject {

	/**
	 * Get accessor for persistent attribute: description
	 */
	
	public java.lang.String getId();

	/**
	 * Set accessor for persistent attribute: description
	 */
	public void setId(java.lang.String newId);
	
	
	
	public java.lang.String getDescription();

	/**
	 * Set accessor for persistent attribute: description
	 */
	public void setDescription(java.lang.String newDescription);

	/**
	 * Get accessor for persistent attribute: status
	 */
	public java.lang.String getStatus();

	/**
	 * Set accessor for persistent attribute: status
	 */
	public void setStatus(java.lang.String newStatus);
}
