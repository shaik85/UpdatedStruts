// @annotations-disabled tagSet="ejb"
 package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;
import javax.ejb.EntityContext;
import javax.ejb.CreateException;
import javax.ejb.RemoveException;

/**
 * Bean implementation class for Entity Bean: CCType
 *
 * @ejb.bean
 *	name="CCType"
 *	type="CMP"
 *  cmp-version="2.x"
 *  schema="CCType"
 *	local-jndi-name="ejb/com/ibm/isc/customerfulfillment/bhoppt/persistence/organization/CCTypeLocalHome"
 *	view-type="local"
 *	reentrant="true"
 *
 * @ejb.home
 *	local-class="com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocalHome"
 *
 * @ejb.interface
 *	local-class="com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocal"
 *
 * @ejb.pk
 *  class="com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey"
 *
 */
public abstract class CCTypeBean implements javax.ejb.EntityBean {
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
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeKey ejbCreate(
		java.lang.String ccType) throws javax.ejb.CreateException {
		setCcType(ccType);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String ccType)
		throws javax.ejb.CreateException {
	}
	/**
	 * Get accessor for persistent attribute: ccDesc
	 */
	public abstract java.lang.String getCcDesc();
	/**
	 * Set accessor for persistent attribute: ccDesc
	 */
	public abstract void setCcDesc(java.lang.String newCcDesc);
	/**
	 * Get accessor for persistent attribute: ccType
	 */
	public abstract java.lang.String getCcType();
	/**
	 * Set accessor for persistent attribute: ccType
	 */
	public abstract void setCcType(java.lang.String newCcType);
}