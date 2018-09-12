/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.NonBPUserDataBean;
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
 * date Jan 7, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class NonBPUserActionForm extends OPPTActionForm {
	private NonBPUserDataBean nonBPUserDataBean;
	private String source = null;

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
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public NonBPUserDataBean getNonBPUserDataBean() {
		if (null == nonBPUserDataBean) {
			nonBPUserDataBean = new NonBPUserDataBean();
		}
		return nonBPUserDataBean;
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
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bean 
	 */
	public void setNonBPUserDataBean(NonBPUserDataBean bean) {
		nonBPUserDataBean = bean;
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
	 * date Feb 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSource() {
		return source;
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
	 * date Feb 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSource(String string) {
		source = string;
	}

	public ErrorReport validate() {

		ErrorReport errorReport = new ErrorReport();

		//		if (isSelectEmpty(nonBPUserDataBean.getGroupName())) {
		//			nonBPUserDataBean.setGroupName(null);
		//		}

		if ("create".equalsIgnoreCase(getSource()) && isFieldEmpty(nonBPUserDataBean.getUserId())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF44, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (isSelectEmpty(nonBPUserDataBean.getRole())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF45, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (isSelectEmpty(nonBPUserDataBean.getPrimarySalesOrganization())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF47, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		if (isSelectEmpty(nonBPUserDataBean.getPrimaryAccessType())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF48, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (isSelectEmpty(nonBPUserDataBean.getManager())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF50, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if(nonBPUserDataBean.getUserType().equals(Constants.BASE_CONTRACT_USER)&& (!(nonBPUserDataBean.getPrimarySalesOrganization().equals(SalesOrgConstants.USA) || nonBPUserDataBean.getPrimarySalesOrganization().equals(SalesOrgConstants.CANADA)))){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF112, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}

		if(nonBPUserDataBean.getUserType().equals(Constants.SOFTWARE_USER)) {
			if (checkSalesAccessType()) {
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF49, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
	
			if (checkDuplicateSalesOrg()) {
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF99, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
	
			// UD
			if (checkDuplicateGroup()) {
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF109, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		return errorReport;
	}

	/**
	 * @return
	 */
	private boolean checkSalesAccessType() {
		boolean condition = false;

		int arrayLength = nonBPUserDataBean.getAccessType().length;

		for (int i = 0; i < arrayLength; i++) {
			//			if((!isSelectEmpty(nonBPUserDataBean.getAccessType()[i]) && isSelectEmpty(nonBPUserDataBean.getSalesArea()[i]))
			//				|| (isSelectEmpty(nonBPUserDataBean.getAccessType()[i]) && !isSelectEmpty(nonBPUserDataBean.getSalesArea()[i]))){
			//					condition=true;
			//			}

			if (isSelectEmpty(nonBPUserDataBean.getAccessType()[i]) && !isSelectEmpty(nonBPUserDataBean.getSalesArea()[i])) {
				condition = true;
			}
		}

		return condition;
	}

	/**
	 * @return
	 */
	private boolean checkDuplicateSalesOrg() {
		boolean condition = false;

		int arrayLength = nonBPUserDataBean.getSalesArea().length;

		for (int i = 0; i < arrayLength; i++) {
			String outerSalesArea = nonBPUserDataBean.getSalesArea()[i];
			for (int j = 0; j < arrayLength; j++) {
				String innerSalesArea = nonBPUserDataBean.getSalesArea()[j];
				if (i != j && !isSelectEmpty(outerSalesArea) && (outerSalesArea.equals(innerSalesArea) || outerSalesArea.equals(nonBPUserDataBean.getPrimarySalesOrganization()))) {
					condition = true;
				}
			}
		}
		return condition;
	}
	/*
	 * UD 
	 */
	private boolean checkDuplicateGroup() {
		boolean condition = false;
		if (null != nonBPUserDataBean.getGroupName()) {
			int arrayLength = nonBPUserDataBean.getGroupName().length;

			for (int i = 0; i < arrayLength; i++) {
				String outerGroupName = nonBPUserDataBean.getGroupName()[i];
				for (int j = 0; j < arrayLength; j++) {
					String innerGroupName = nonBPUserDataBean.getGroupName()[j];
					if (i != j && !isSelectEmpty(outerGroupName) && (outerGroupName.equals(innerGroupName))) {
						condition = true;
					}
				}
			}

		}
		return condition;

	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset() {
		nonBPUserDataBean = null;
		source = null;
	}
}
