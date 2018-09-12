/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.GroupUserDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.OPPTDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserContractsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 *  
 * Hold the information about contract maintenance view
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 12, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class ContractMaintenanceViewBean extends OPPTViewBean {
	private String userName = null;
	private String groupName = null;
	private String selectedGroupName = null;
	private TreeMap groupUsers = null;
	private TreeMap userGroups = null;
	private TreeMap contracts = null;
	private String message=null;
	private boolean groupUser = false;
	
	/**
     * ContractMaintenanceViewBean
     * 
     * @author thirumalai
     */
    public ContractMaintenanceViewBean(){
	}
	
	/**
     * ContractMaintenanceViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ContractMaintenanceViewBean(UserContractsCustomDTO customDTO){
		setData(customDTO);
	}
	/**
	 * Retuns the collection of contracts for the selected user  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Vector
	 */
	public TreeMap getContracts() {
		return contracts;
	}

	/**
	 * Returns the group name of the selected user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Returns the collection of users in the selected users group. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Vector
	 */
	public TreeMap getGroupUsers() {
		return groupUsers;
	}

	/**
	 * Returns the selected user name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the contracts collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContracts Vector 
	 */
	public void setContracts(TreeMap newContracts) {
		contracts = newContracts;
	}

	/**
	 * Sets the selected users group name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroupName String 
	 */
	public void setGroupName(String newGroupName) {
		groupName = newGroupName;
	}

	/**
	 * Sets the group users for the selected users group 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroupUsers Vectir 
	 */
	public void setGroupUsers(TreeMap newGroupUsers) {
		groupUsers = newGroupUsers;
	}

	/**
	 * Sets the selected users 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUserName String 
	 */
	public void setUserName(String newUserName) {
		userName = newUserName;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getMessage() {
		return message;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setMessage(String string) {
		message = string;
	}

	/**
	 * Sets the complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userName String
	 * @param groupName String
	 * @param groupUsers Vector
	 * @param contracts Vector
	 */
	public void setData(String userName, String groupName, TreeMap groupUsers, TreeMap contracts){
		setUserName(userName);
		setGroupName(groupName);
		setGroupUsers(groupUsers);
		setContracts(contracts);
	}
	
	/**
     * @param contract
     * @author thirumalai
     */
    public void addContract(ContractViewBean contract){
		if(null != contract){
			if(null == contracts){
				contracts = new TreeMap();
			}
			contracts.put(contract.getContractKey(), contract);
		}
	}

	private void setData(UserContractsCustomDTO customDTO){
		if(null != customDTO){
			GroupUserCustomDTO groupUser = customDTO.getGroupUserInfo();
			if(null != groupUser){
				setUserName(groupUser.getSelectedUser());
				setGroupName(groupUser.getGroupName());
				setSelectedGroupName(groupUser.getSelectedGroupName());
				setGroupUsers(groupUser.getGroupUsers());
				setUserGroups(customDTO.getUserGroups());
				setGroupUser(true);
			}
			else{
				setUserName(customDTO.getUserName());
				setGroupUser(false);
			}
			
			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport){
				TreeMap contracts = customDTO.getContractCustomDTO();
				if(null != contracts){
					Iterator itr = contracts.values().iterator();
					while(itr.hasNext()){
						addContract(new ContractViewBean((ContractCustomDTO)itr.next()));
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
		return groupUser;
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
		groupUser = newGroupUser;
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
	 * date Jun 13, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSelectedGroupName() {
		if(null == selectedGroupName) {
			selectedGroupName = getGroupName();
		}
		return selectedGroupName;
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
	 * date Jun 13, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSelectedGroupName(String string) {
		selectedGroupName = string;
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
	 * date Jun 13, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getUserGroups() {
		return userGroups;
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
	 * date Jun 13, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setUserGroups(TreeMap map) {
		userGroups = map;
	}

}
