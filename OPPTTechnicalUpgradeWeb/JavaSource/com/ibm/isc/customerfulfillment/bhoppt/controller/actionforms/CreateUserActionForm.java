/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.SalesOrgConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;


/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 2, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class CreateUserActionForm extends OPPTActionForm {
	private UserDataBean userDataBean = null;
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public UserDataBean getUserDataBean() {
		if(null == userDataBean){
			userDataBean = new UserDataBean();
		}
		return userDataBean;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bean 
	 */
	public void setUserDataBean(UserDataBean bean) {
		userDataBean = bean;
	}
	
	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#validate()
	 */
	public ErrorReport validate() {
		
		ErrorReport errorReport = new ErrorReport();

		if(isFieldEmpty(getUserDataBean().getUserId())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF44, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		
		if(isSelectEmpty(getUserDataBean().getUserType())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF110, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
				
		if(isSelectEmpty(getUserDataBean().getPrimarySalesOrganization())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF46, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}

		if(getUserDataBean().getUserType().equals(Constants.BASE_CONTRACT_USER)&& (!(getUserDataBean().getPrimarySalesOrganization().equals(SalesOrgConstants.USA) || getUserDataBean().getPrimarySalesOrganization().equals(SalesOrgConstants.CANADA)))){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF112, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		
		return errorReport;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		userDataBean = null;
	}
}
