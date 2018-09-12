package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * @author Nomita
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class ActionDescriptionBean implements javax.ejb.EntityBean {
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
	public java.lang.String ejbCreate(java.lang.String actionDescription)
		throws javax.ejb.CreateException {
		
		setDescription(actionDescription);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String actionDescription)
		throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: operationperformed
	 */
	public abstract java.lang.String getOperationPerformed();
	/**
	 * Set accessor for persistent attribute: operationperformed
	 */
	public abstract void setOperationPerformed(java.lang.String newOperationPerformed);
	/**
	 * Get accessor for persistent attribute: description
	 */
	public abstract java.lang.String getDescription();
	/**
	 * Set accessor for persistent attribute: description
	 */
	public abstract void setDescription(java.lang.String newDescription);
	
	


}
