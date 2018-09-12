/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SSPlanningActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SSPlanningViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSEECustomDTO;



/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ChangeSSPAction extends OPPTLongAction 
{
   
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
		throws Exception {
		
		OPPTViewBean viewBean=null;
		TreeMap mainTree;
		SAndSEECustomDTO selectedDto;
		String selectedSWOId;
		
		SAndSDetailsCustomDTO customDto = getFromSession(session);
		setTransactionInformation(customDto, session);
		SSPlanningActionForm actionForm = (SSPlanningActionForm)form;
		selectedSWOId = actionForm.getSwoList();
		mainTree = customDto.getSAndSEEMap();
		
		selectedDto = (SAndSEECustomDTO)mainTree.get(new Integer(Integer.parseInt(selectedSWOId)));
		customDto.setSelected(selectedDto);
		saveInSession(session, customDto);
		
		viewBean = new SSPlanningViewBean(customDto);
		setForwardName("ssplanning");  //$NON-NLS-1$
			
		return viewBean;	
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return 
	 * 
	 */
	protected String getActionName() {
		return "ChangeSSPAction";  //$NON-NLS-1$
	}
	

	
	private void saveInSession(OPPTSession session, SAndSDetailsCustomDTO dto) {
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.SS_PLANNING, dto);
		}
	}

	private SAndSDetailsCustomDTO getFromSession(OPPTSession session){
		SAndSDetailsCustomDTO customDTO = null;

		if(null != session){
			customDTO = (SAndSDetailsCustomDTO)session.getObjectFromSession(SessionConstants.SS_PLANNING);
		}
		return customDTO;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param session
	 * @return 
	 * 
	 */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		return true;
	}
}
