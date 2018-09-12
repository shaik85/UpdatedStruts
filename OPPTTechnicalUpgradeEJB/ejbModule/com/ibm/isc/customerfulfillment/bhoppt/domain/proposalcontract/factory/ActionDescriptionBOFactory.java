/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
/*
* Created on Jan 10th 2011 by Nomita as a part of Activity Log changes
*/

package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ActionDescriptionBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ActionDescriptionLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ActionDescriptionLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/** 
 * This class is to Create, Update, Remove and Find ActionDescription entities.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 10th 2011
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Nomita
 
 */
public class ActionDescriptionBOFactory {
	private static final String CLASS_NAME = "ActionDescriptionBOFactory";

	

	/**
	 * @param actionDescriptionBO
	 * @throws DomainException
	 */
	public void create(ActionDescriptionBO actionDescriptionBO) throws DomainException {
		String methodName = "create";
       		ActionDescriptionLocalHome actionDescriptionLocalHome = getActionDescriptionLocalHome();
		ActionDescriptionLocal actionDescriptionLocal = null;

		
		actionDescriptionLocal.setOperationPerformed(actionDescriptionBO.getOperationPerformed());
	}

	/** 
	 * find if User has touched the proposal in the past.  
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Jan 11 2011
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	* @return boolean
	 * 
	 */

	public List findActionDescriptionForAction(int proposalId, String userId) throws DomainException {
		boolean userAccessTheProposal = true;
		ActionDescriptionLocalHome actionDescriptionLocalHome = getActionDescriptionLocalHome();
		List actionDescriptionList = new ArrayList();
		Collection actionDescCol = null;

		try {
				actionDescCol = actionDescriptionLocalHome.findAllActions();
						
		} catch (FinderException ex) {
			// left it blank for purpose. If null, it means that for this proposal, the user has not accessed it.
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0417); 
		}
		
		Iterator iter = actionDescCol.iterator();
		ActionDescriptionLocal actionDescriptionLocal = null;

		while (iter.hasNext()) {
			ActionDescriptionBO actionDescriptionBO = new ActionDescriptionBO();
			actionDescriptionLocal = (ActionDescriptionLocal) iter.next();
			actionDescriptionBO.setDescription(actionDescriptionLocal.getDescription());
			actionDescriptionBO.setOperationPerformed(actionDescriptionLocal.getOperationPerformed());
			actionDescriptionList.add(actionDescriptionBO);
		}

		return actionDescriptionList;

	}
	


	private ActionDescriptionLocalHome getActionDescriptionLocalHome() {
		return (ActionDescriptionLocalHome) HomeProvider.getLocal(HomeProvider.ACTION_DESCRIPTION_LOCAL_HOME);
	}

	
	}
