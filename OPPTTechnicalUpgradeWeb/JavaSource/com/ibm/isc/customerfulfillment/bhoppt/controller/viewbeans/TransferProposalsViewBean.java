/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.TransferProposalsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.TransferProposalsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * Holds complete data required for transfer proposals view  
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
public class TransferProposalsViewBean extends OPPTViewBean{
	private TreeMap iSalesAreas = null;
	private ArrayList iTargetUsers = null;
	private ArrayList iCreateApproveUsers;
	private ArrayList iProposalApproveUsers;
	private String iSelectedSalesArea = null;
	private int iSourceUserRole = 0;
	private String iMessage= null;
	
	/**
     * TransferProposalsViewBean
     * 
     * @author thirumalai
     */
    public TransferProposalsViewBean(){
	}
	
	/**
     * TransferProposalsViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public TransferProposalsViewBean(TransferProposalsCustomDTO customDto){
		if(null != customDto){
			
			ErrorReport messageReport = customDto.getMessageReport();
			if(null != messageReport){
				setMessage(getMessage(messageReport));
			}
			setSalesAreas(customDto.getSalesAreas());
			setSelectedSalesArea(customDto.getSelectedSalesArea());
			setTargetUsers(getListFromMap(customDto.getTargetUsers()));
			setCreateApproveUsers(getListFromMap(customDto.getCreateApproveUsers()));
			setProposalApproveUsers(getListFromMap(customDto.getProposalApproveUsers()));
			setSourceUserRole(customDto.getSourceUser().getRole());
	
			setButtonFlags(customDto.getButtonFlags());
		}
		
	}
	/**
	 * Returns collection of sales areas available as sales area id and description pairs. 
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
	 * @return HashMap
	 */
	public TreeMap getSalesAreas() {
		return iSalesAreas;
	}

	/**
	 * Returns selected sales area 
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
	 * @return String
	 */
	public String getSelectedSalesArea() {
		return iSelectedSalesArea;
	}

	/**
	 * Returns collection of target users 
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
	 * @return ArrayList
	 */
	public ArrayList getTargetUsers() {
		return iTargetUsers;
	}

	/**
	 * Sets sales area collection 
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
	 * @param newSalesAreas HashMap 
	 */
	public void setSalesAreas(TreeMap newSalesAreas) {
		TreeMap localSalesArea = null;
		if(null != newSalesAreas){
			localSalesArea = new TreeMap();
			Set keySet = newSalesAreas.keySet();
			Iterator itr = keySet.iterator();
			String key;

			while(itr.hasNext()){
				key = (String)itr.next();
				String desc = (String)newSalesAreas.get(key);
				if(null == desc){
					desc = "";  //$NON-NLS-1$
				}
				localSalesArea.put(desc.trim(), key);
			}
		}
		iSalesAreas = localSalesArea;
	}

	/**
	 * Sets selected sales area 
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
	 * @param newSelectedSalesArea String 
	 */
	public void setSelectedSalesArea(String newSelectedSalesArea) {
		iSelectedSalesArea = newSelectedSalesArea;
	}

	/**
	 * Sets collection of target users  
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
	 * @param newTargetUsers ArrayList 
	 */
	public void setTargetUsers(ArrayList newTargetUsers) {
		iTargetUsers = newTargetUsers;
	}

	/**
	 * Adds a new sales area to the collection of sales areas  
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
	 * @param id String value which is the sales area id
	 * @param description String value which is the sales area description
	 */
	public void addSalesArea(String id, String description){
		if(null != id && null != description){
			if(null == iSalesAreas){
				iSalesAreas = new TreeMap();
			}
			iSalesAreas.put(id, description);
		}
	}
	
	/**
	 * Adds a new target user to the collection of target users  
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
	 * @param targetUser String value which is the target user
	 */
	public void addTargetUser(String targetUser){
		if(null != targetUser){
			if(null == iTargetUsers){
				iTargetUsers = new ArrayList();
			}
			iTargetUsers.add(targetUser);
		}
		
	}
	
	/**
     * Sets complete data in a single method call
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param salesAreas HashMap
     * @param targetUsers ArrayList
     * @param selectedSalesArea String
     * @param sourceUser String
     * @param role 
     */
	public void setData(TreeMap salesAreas, ArrayList targetUsers, String selectedSalesArea, 
						String sourceUser, int role){
		setSalesAreas(salesAreas);
		setTargetUsers(targetUsers);
		setSelectedSalesArea(selectedSalesArea);
		setSourceUserRole(role);
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
	
	private ArrayList getListFromMap(TreeMap userMap){
		UserCustomDTO userCustomDto;
				
		UserInfoViewBean viewBean = null;
		ArrayList userList = new ArrayList();

		if(null != userMap){
			Iterator itr = userMap.keySet().iterator();
			while(itr.hasNext()){
				viewBean = new UserInfoViewBean();
				String key = (String)itr.next();
				userCustomDto = (UserCustomDTO)userMap.get(key);
				viewBean.setData(userCustomDto.getUserId(),userCustomDto.getRole(),
					userCustomDto.getApprovedBy(),userCustomDto.getGroup(),userCustomDto.getBaUserRole(),
					userCustomDto.getUserType());
						
				userList.add(viewBean);
			}
		}
		
		return userList;
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
	 * date Mar 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public int getSourceUserRole() {
		return iSourceUserRole;
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
	 * date Mar 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param i 
	 */
	public void setSourceUserRole(int i) {
		iSourceUserRole = i;
	}
	
	/**
	 * Returns the action form associated with the current view. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BPUserActionForm
	 */
	public TransferProposalsActionForm getTransferProposalActionForm() {
		TransferProposalsActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof TransferProposalsActionForm){
			actionForm = (TransferProposalsActionForm)getActionForm();
		}
		else{
			actionForm = new TransferProposalsActionForm();
		}
		return actionForm;
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
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public ArrayList getCreateApproveUsers() {
		return iCreateApproveUsers;
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
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public ArrayList getProposalApproveUsers() {
		return iProposalApproveUsers;
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
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setCreateApproveUsers(ArrayList list) {
		iCreateApproveUsers = list;
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
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setProposalApproveUsers(ArrayList list) {
		iProposalApproveUsers = list;
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
	 * date Mar 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getMessage() {
		return iMessage;
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
	 * date Mar 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setMessage(String string) {
		iMessage = string;
	}

}
