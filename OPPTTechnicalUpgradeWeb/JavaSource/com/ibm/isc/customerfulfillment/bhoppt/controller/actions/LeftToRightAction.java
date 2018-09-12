/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Date;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SSPlanningActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SSPlanningViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SAndSEECustomDTO;



/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class LeftToRightAction extends OPPTAction 
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
		TreeMap leftTree;
		TreeMap rightTree;
		String [] leftDataTransfetList=null;
		SAndSDetailsCustomDTO customDto = getFromSession(session);
		setTransactionInformation(customDto, session);
		SAndSEECustomDTO selectedUserDto = customDto.getSelected();
		SSPlanningActionForm actionForm = (SSPlanningActionForm)form;
		
		selectedUserDto.setSAndSDiscountPercent(Double.parseDouble(actionForm.getDiscount()));
		leftTree = customDto.getLeftDataTree();
		rightTree = customDto.getRightDataTree();
		
		leftDataTransfetList = actionForm.getLeftSelectData();
	
		if(null != leftDataTransfetList && null != leftTree){
			if(null == rightTree){
				rightTree = new TreeMap();
			}
			
			int length = leftDataTransfetList.length; 
			
			for(int i=0; i < length; i++){
				rightTree.put(leftDataTransfetList[i], leftTree.get(leftDataTransfetList[i]));
				leftTree.remove(leftDataTransfetList[i]);
			}
		}
		
		customDto.setLeftDataTree(leftTree);
		customDto.setRightDataTree(rightTree);
		customDto.setSelected(selectedUserDto);
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
		return "LeftToRightAction";  //$NON-NLS-1$
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
