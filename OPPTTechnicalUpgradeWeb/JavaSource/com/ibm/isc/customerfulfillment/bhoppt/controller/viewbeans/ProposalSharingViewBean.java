/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalSharingActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * Holds complete data about the proposal sharing view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalSharingViewBean extends OPPTViewBean {
	private TreeMap iUsers = null;
	private TreeMap iAccessTypes = null;
	private String iMessage = null;
	
	/**
	 * Returns the collection of accesstypes. Key is the user if and value is the type of the access.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getAccessTypes() {
		return iAccessTypes;
	}

	/**
	 * Returns the collection of users available for sharing the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getUsers() {
		return iUsers;
	}

	/**
	 * Sets accessType colelction 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAccessTypes TreeMap
	 */
	public void setAccessTypes(TreeMap newAccessTypes) {
		iAccessTypes = newAccessTypes;
	}

	/**
	 * Sets the collection of users available for sharing the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUsers TreeMap 
	 */
	public void setUsers(TreeMap newUsers) {
		iUsers = newUsers;
	}

	/**
	 * Adds new access type to the already existing collection  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param user String
	 * @param accessType String
	 */
	public void addAccessType(String user, String accessType){
		if(null != user && null != accessType){
			if(null == iAccessTypes){
				iAccessTypes = new TreeMap();
			}
			iAccessTypes.put(user, accessType);
		}
	}
	
	/**
     * Adds the new user to the already existing collection of users available for sharing proposal.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param name
     * @param userId 
     */
	public void addUser(String userId, String name){
		if(null != userId){
			if(null == iUsers){
				iUsers = new TreeMap();
			}
			iUsers.put(userId, name);
		}
	}
	
	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param accessTypes TreeMap
	 * @param users TreeMap
	 */
	public void setData(TreeMap accessTypes, TreeMap users){
		setAccessTypes(accessTypes);
		setUsers(users);
	}

	/**
	 * Sets complete data from an custom dto  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO
	 */	
	public void setData(ShareProposalCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			setAccessTypes(customDTO.getAccessType());
			
			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport){
				setUsers(customDTO.getUsers());
			}
			else{
				setMessage(getMessage(messageReport));
			}
		}
	}
	
	/**
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public ProposalSharingViewBean(){
	}
	
	/**
	 * Constructor
	 * Creates a new ProposalSharingViewBean from ShareProposalCustomDTO 
	 * 
	 * <br/><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param customDTO ShareProposalCustomDTO
	 */
	public ProposalSharingViewBean(ShareProposalCustomDTO customDTO){
		setData(customDTO);
	}

	/**
	 * Returns message value if no users present 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMessage() {
		return iMessage;
	}

	/**
	 * Sets message value if no users present 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessage String 
	 */
	public void setMessage(String newMessage) {
		iMessage = newMessage;
	}

	private String getMessage(ErrorReport errorReport){
		String message = null;
		
		if(null != errorReport){
			OPPTMessageCatalog.getInstance().populateErrorReport(errorReport);
			Iterator errorReportIterator = errorReport.values().iterator();
			if(errorReportIterator.hasNext()){
				ErrorEntry errorEntry = (ErrorEntry)errorReportIterator.next();
				if(null != errorEntry){
					message = errorEntry.getErrorMessage();
				}
			}
		}
		
		return message;
	}
	
//	/** 
//	 * Overridden method - Enter your description here. 
//	 * 
//	 * <br/><PRE> 
//	 * date Mar 16, 2004 
//	 * 
//	 * revision date author reason 
//	 * 
//	 * </PRE><br/> 
//	 * 
//	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#setActionForm(com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm) 
//	 * @param newActionForm 
//	 * 
//	 */
//	public void setActionForm(OPPTActionForm newActionForm) {
//		super.setActionForm(newActionForm);
//		
//		ProposalSharingActionForm actionForm = null;
//		if(null != getActionForm() && getActionForm() instanceof ProposalSharingActionForm){
//			actionForm = (ProposalSharingActionForm)getActionForm();
//		}
//		else{
//			actionForm = new ProposalSharingActionForm();
//		}
//		
//		setAccessTypes(actionForm.getRequestParams());
//	}

	/**
     * getProposalSharingActionForm
     * 
     * @return
     * @author thirumalai
     */
    public ProposalSharingActionForm getProposalSharingActionForm(){
		ProposalSharingActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof ProposalSharingActionForm){
			actionForm = (ProposalSharingActionForm)getActionForm();
		}
		return actionForm;
	}
}
