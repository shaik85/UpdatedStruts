/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.GroupUserDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalForApprovalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalsForApprovalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * Holds complete data about the proposals for approval maintenance view  
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
public class ProposalsForApprovalViewBean extends OPPTViewBean 
{
	private GroupUserDataBean iGroupUserData = null;
	private TreeMap iProposalsForApproval = null;
	private String iMessage = null;
	private boolean iGroupUser = false;
	
	/**
	 * Returns group user data. That is the selected sales org, group name and sales org's
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
	 * @return GroupUserDataBean
	 */
	public GroupUserDataBean getGroupUserData() {
		return iGroupUserData;
	}

	/**
	 * Returns collection of available proposals for the selected group user. 
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
	public TreeMap getProposalsForApproval() {
		return iProposalsForApproval;
	}

	/**
	 * Sets group users data 
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
	 * @param newGroupUserData GroupUserDataBean 
	 */
	public void setGroupUserData(GroupUserDataBean newGroupUserData) {
		iGroupUserData = newGroupUserData;
		if(null != iGroupUserData){
			setGroupUser(true);
		}
		else{
			setGroupUser(false);
		}
	}

	/**
	 * Sets the collection of proposals for the selected group user 
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
	 * @param newProposalsForApproval TreeMap 
	 */
	public void setProposalsForApproval(TreeMap newProposalsForApproval) {
		iProposalsForApproval = newProposalsForApproval;
	}
	
	/**
	 * Adds the proposal to the already existing collection of proposals  
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
	 * @param proposalForApproval ProposalForApprovalViewBean
	 */
	public void addProposalForApproval(ProposalForApprovalViewBean proposalForApproval){
		if(null != proposalForApproval){
			if(null == iProposalsForApproval){
				iProposalsForApproval = new TreeMap();
			}
			iProposalsForApproval.put(proposalForApproval.getId(), proposalForApproval);
		}
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(ProposalsForApprovalCustomDTO customDTO){
		if(null != customDTO){
			GroupUserCustomDTO groupUser = customDTO.getGroupUserInfo();
			if(null != groupUser){
				setGroupUserData(new GroupUserDataBean(groupUser));
			}
			else{
				setUserName(customDTO.getUserName());
			}
			
			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport)
			{
				TreeMap userProposals = customDTO.getProposalsForApproval();
				if(null != userProposals){
					Iterator proposalIterator = userProposals.values().iterator();
					if(null != proposalIterator){
						while(proposalIterator.hasNext()){
							addProposalForApproval(new ProposalForApprovalViewBean((ProposalForApprovalCustomDTO)proposalIterator.next()));
						}
					}
				}
			}
			else{
				setMessage(getMessage(messageReport));
			}
			
			setButtonFlags(customDTO.getButtonFlags());
		}
	}

	/**
     * @param customDTO
     * ProposalsForApprovalViewBean
     * 
     * @author thirumalai
     */
    public ProposalsForApprovalViewBean(ProposalsForApprovalCustomDTO customDTO){
		setData(customDTO);
	}

	/**
     * ProposalsForApprovalViewBean
     * 
     * @param message
     * @param buttonFlags
     * @author thirumalai
     */
    public ProposalsForApprovalViewBean(String message, Map buttonFlags){
		setMessage(message);
		setButtonFlags(buttonFlags);
	}
	
	/**
	 * Returns message value if no proposals present 
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
	 * Sets message value if no proposals present 
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

	/**
	 * Returns if the user is an group user or not 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean 
	 */
	public boolean isGroupUser() {
		return iGroupUser;
	}

	/**
	 * Sets group user flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroupUser boolean
	 */
	public void setGroupUser(boolean newGroupUser) {
		iGroupUser = newGroupUser;
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

	/**
     * isRequiredError
     * 
     * @return
     * @author thirumalai
     */
    public boolean isRequiredError(){
		boolean requiredError = false;
		
		if(null != getErrorReport()){
			HashSet errorFields = getErrorReport().getErrorFieldNames();
			if(null != errorFields && errorFields.contains("required")){  //$NON-NLS-1$
				requiredError= true;
			}
		}
		
		return requiredError;
	}
}
