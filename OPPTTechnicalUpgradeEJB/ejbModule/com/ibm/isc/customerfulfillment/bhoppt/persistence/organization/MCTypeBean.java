// @annotations-disabled tagSet="ejb"
 package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
import javax.ejb.EntityContext;
import javax.ejb.CreateException;
import javax.ejb.RemoveException;

/**
 * Bean implementation class for Entity Bean: MCType
 * 
 * @author Bhanu
 *
 * @ejb.bean
 *	name="MCType"
 *	type="CMP"
 *  cmp-version="2.x"
 *  schema="MCType"
 *	local-jndi-name="ejb/com/ibm/isc/customerfulfillment/bhoppt/persistence/organization/MCTypeLocalHome"
 *	view-type="local"
 *	reentrant="true"
 *
 * @ejb.home
 *	local-class="com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocalHome"
 *
 * @ejb.interface
 *	local-class="com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocal"
 *
 * @ejb.pk
 *  class="com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey"
 *
 */
public abstract class MCTypeBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeKey ejbCreate(java.lang.String mcType) throws CreateException {
     	setMcType(mcType);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String mcType) throws CreateException {
	}
	     		
    /**
	 * Get accessor for persistent attribute: mcType
	 * @ejb.persistence 
	 *  read-only="false" 
	 * @ejb.pk-field
	 */
    public abstract java.lang.String getMcType();
    
    /**
	 * Set accessor for persistent attribute: mcType
	 * @ejb.persistence 
	 */
    public abstract void setMcType(java.lang.String newMcType);
     		
    /**
	 * Get accessor for persistent attribute: mcDesc
	 * @ejb.persistence 
	 *  read-only="false"
	 * @ejb.interface-method
	 *  view-type="local"
	 */
    public abstract java.lang.String getMcDesc();
    
    /**
	 * Set accessor for persistent attribute: mcDesc
	 * @ejb.persistence 
	 * @ejb.interface-method
	 *  view-type="local"
	 */
    public abstract void setMcDesc(java.lang.String newMcDesc);

}