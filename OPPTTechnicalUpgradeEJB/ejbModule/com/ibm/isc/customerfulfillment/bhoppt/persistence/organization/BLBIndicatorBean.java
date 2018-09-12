// @annotations-disabled tagSet="ejb"
 package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
import javax.ejb.EntityContext;
import javax.ejb.CreateException;
import javax.ejb.RemoveException;

/**
 * Bean implementation class for Entity Bean: BLBIndicator
 *
 * @ejb.bean
 *	name="BLBIndicator"
 *	type="CMP"
 *  cmp-version="2.x"
 *  schema="BLBIndicator"
 *	local-jndi-name="ejb/com/ibm/isc/customerfulfillment/bhoppt/persistence/organization/BLBIndicatorLocalHome"
 *	view-type="local"
 *	reentrant="true"
 *
 * @ejb.home
 *	local-class="com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocalHome"
 *
 * @ejb.interface
 *	local-class="com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal"
 *
 * @ejb.pk
 *  class="com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey"
 *
 */
public abstract class BLBIndicatorBean implements javax.ejb.EntityBean {
   private EntityContext myEntityCtx;
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
	public void ejbRemove() throws RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * getEntityContext
	 */
	public EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * setEntityContext
	 */
	public void setEntityContext(EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}		
 	/**
	 * ejbCreate
	 * @ejb.create-method
	 *  view-type="local"
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey ejbCreate(java.lang.String blbType) throws CreateException {
     	setBlbType(blbType);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String blbType) throws CreateException {
	}
	     		
    /**
	 * Get accessor for persistent attribute: blbType
	 * @ejb.persistence 
	 *  read-only="false" 
	 * @ejb.pk-field
	 */
    public abstract java.lang.String getBlbType();
    
    /**
	 * Set accessor for persistent attribute: blbType
	 * @ejb.persistence 
	 */
    public abstract void setBlbType(java.lang.String newBlbType);
     		
    /**
	 * Get accessor for persistent attribute: blbDesc
	 * @ejb.persistence 
	 *  read-only="false"
	 * @ejb.interface-method
	 *  view-type="local"
	 */
    public abstract java.lang.String getBlbDesc();
    
    /**
	 * Set accessor for persistent attribute: blbDesc
	 * @ejb.persistence 
	 * @ejb.interface-method
	 *  view-type="local"
	 */
    public abstract void setBlbDesc(java.lang.String newBlbDesc);

}