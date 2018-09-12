/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractMaintenanceDateRangeViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ContractMaintenanceDateRangeAction extends OPPTLongAction 
{
	public static int rol =0;
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
		OPPTViewBean viewBean;

		viewBean = new ContractMaintenanceDateRangeViewBean();
		setDateInViewBean(viewBean);
	
		ContractMaintenanceDateRangeAction action = new ContractMaintenanceDateRangeAction();
		  action.rol= getRole(session);
		  setForwardName(getRole(session));
		return viewBean;
	}
	
	/**
	 *  
	 * For setting the date range
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param viewBean
	 */
	private void setDateInViewBean(OPPTViewBean viewBean){
		ArrayList yearList = new ArrayList();
		Calendar cal = Calendar.getInstance();
		ContractMaintenanceDateRangeViewBean dateBean = (ContractMaintenanceDateRangeViewBean)viewBean;
				if(rol==RoleConstants.DATA_MIGRATOR){
				int initialYear = cal.get(Calendar.YEAR) -5;
				int finalYear = initialYear + 15;
			
				for (int i = initialYear; i <= finalYear; i++){
				yearList.add(new Integer(i));
			}
		
		}
		else
		{		
		
			int initialYear = cal.get(Calendar.YEAR) -1;
			int finalYear = initialYear + 11;
			
			for (int i = initialYear; i <= finalYear; i++){
				yearList.add(new Integer(i));
			}
			
		}
		
		dateBean.setYearRange(yearList);
		rol=0;
		
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
		return ActionNameConstants.CONTRACT_MAINTENANCE_DATE_RANGE;
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_DATE_RANGE);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CONTRACT_DATE_RANGE);
								break;
		}
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
