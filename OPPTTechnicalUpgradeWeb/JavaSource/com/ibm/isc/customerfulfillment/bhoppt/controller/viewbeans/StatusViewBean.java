/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * Status view bean used for showing the check status information 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 9, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class StatusViewBean extends OPPTViewBean {
	private String proposalId = null;
	private String statusCode = null;
	private String message = null;
	
	/**
	 * Returns message involved with the status code 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns proposal identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getProposalId() {
		return proposalId;
	}

	/**
	 * Returns status code value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets message value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessage String 
	 */
	public void setMessage(String newMessage) {
		message = newMessage;
	}

	/**
	 * Sets proposal identifier value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalId String 
	 */
	public void setProposalId(String newProposalId) {
		proposalId = newProposalId;
	}

	/**
	 * Sets status code value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStatusCode String 
	 */
	public void setStatusCode(String newStatusCode) {
		statusCode = newStatusCode;
	}

	/**
     * setData
     * 
     * @param errorReport
     * @param proposalId
     * @author thirumalai
     */
    public void setData(ErrorReport errorReport, String proposalId){
		setProposalId(proposalId);
		if(null != errorReport){
			OPPTMessageCatalog.getInstance().populateErrorReport(errorReport);
			Iterator errorReportIterator = errorReport.keySet().iterator();
			if(errorReportIterator.hasNext()){
				ErrorKey errorKey = (ErrorKey)errorReportIterator.next();
				if(null != errorKey){
					ErrorEntry errorEntry = (ErrorEntry)errorReport.get(errorKey);
					if(null != errorEntry){
						setMessage(errorEntry.getErrorMessage());
						setStatusCode(errorKey.getErrorId());
					}
				}
			}
		}
	}
	
	/**
     * StatusViewBean
     * 
     * @author thirumalai
     */
    public StatusViewBean(){
	}
    
	/**
     * StatusViewBean
     * 
     * @param errorReport
     * @param proposalId
     * @author thirumalai
     */
    public StatusViewBean(ErrorReport errorReport, String proposalId){
		setData(errorReport, proposalId);
	}
}