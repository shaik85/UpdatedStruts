/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

public class CustomerSelectionActionForm extends OPPTActionForm {
	private String selectedSTP = null;
	private String[] selectedINV = null;
	private String legacyCustomerNumber = null;
	private String sequenceNumber = null;
	private String countryCode = null;
	private String comments = null;
	private String alternatePartnerINV = null;
	
		
	/**
	 * Returns comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Returns legacy customer number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLegacyCustomerNumber() {
		return legacyCustomerNumber;
	}

	/**
	 * Returns customers ids whose inventory need to be pulled into proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String[]
	 */
	public String[] getSelectedINV() {
		return selectedINV;
	}

	/**
	 * Returns selected sold to party customer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedSTP() {
		return selectedSTP;
	}

	/**
	 * Returns sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * Sets comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newComments String 
	 */
	public void setComments(String newComments) {
		comments = newComments;
	}

	/**
	 * Sets legacy customer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLegacyCustomerNumber String 
	 */
	public void setLegacyCustomerNumber(String newLegacyCustomerNumber) {
		legacyCustomerNumber = newLegacyCustomerNumber;
	}

	/**
	 * Sets customer ids whose inventory need to be pulled into proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedINV String[] 
	 */
	public void setSelectedINV(String[] newSelectedINV) {
		
		selectedINV = newSelectedINV;
	}

	/**
	 * Sets selected sold to party value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedSTP String 
	 */
	public void setSelectedSTP(String newSelectedSTP) {
		selectedSTP = newSelectedSTP;
	}

	/**
	 * Sets address sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSequenceNumber String 
	 */
	public void setSequenceNumber(String newSequenceNumber) {
		sequenceNumber = newSequenceNumber;
	}
	
	/**
	 * Returns alternate partner inv value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getAlternatePartnerINV() {
		return alternatePartnerINV;
	}

	/**
	 * Sets alternate partner inv value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setAlternatePartnerINV(String string) {
		alternatePartnerINV = string;
	}

	public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
		
		if(null != getSelectedSTP()){
			if("alternateCustomer".equalsIgnoreCase(getSelectedSTP())){
				if(null != getLegacyCustomerNumber() && 0 < getLegacyCustomerNumber().length()){
				}
				else{
					errorReport.put(new ErrorKey(ErrorCodeConstants.PAF28, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
				if(null != getSequenceNumber() && 0 < getSequenceNumber().length()){
				}
				else{
					errorReport.put(new ErrorKey(ErrorCodeConstants.PAF29, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
		}
		else{
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF27, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		if(null != getSelectedINV()){
			if(null == getAlternatePartnerINV() && 0 >= getSelectedINV().length){
				// Message saying atleast one inv should be selected
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF30, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else if(null == getAlternatePartnerINV()){
			// Message saying atleast one inv should be selected
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF30, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		if(null != selectedSTP){
			if("alternateCustomer".equals(selectedSTP)){
				if(null == alternatePartnerINV){
					errorReport.put(new ErrorKey(ErrorCodeConstants.PAF86, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else{
				if(null != selectedINV){
					boolean validInv = false;
					for(int i=0, length=selectedINV.length; i<length; i++){
						if(selectedSTP.equalsIgnoreCase(selectedINV[i])){
							validInv = true;
							break;
						}
					}
					if(!validInv){
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF86, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				}
			}
		}
		
		if(null != getAlternatePartnerINV()){
			if(null != getLegacyCustomerNumber() && 0 < getLegacyCustomerNumber().length()){
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF28, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
			if(null != getSequenceNumber() && 0 < getSequenceNumber().length()){
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF29, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		
		return errorReport;
	}

	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset() 
	 *  
	 * 
	 */
	public void reset() {
		selectedSTP = null;
		selectedINV = null;
		legacyCustomerNumber = null;
		sequenceNumber = null;
		countryCode = null;
		comments = null;
		alternatePartnerINV = null;
	}

	/**
	 * Returns country code value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets country code value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCountryCode String 
	 */
	public void setCountryCode(String newCountryCode) {
		countryCode = newCountryCode;
	}
	
	
}