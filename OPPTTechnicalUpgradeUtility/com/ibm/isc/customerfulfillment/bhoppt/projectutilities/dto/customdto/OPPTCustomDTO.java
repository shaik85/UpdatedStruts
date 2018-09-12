/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.io.Serializable;
import java.util.*;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerBean;

/**
 * This is parent class for all the CustomDTOs. Custom dto's will stored in session in some 
 * transactions. As all objects that need to be stored in session must be serializable it 
 * implemtes Serializable interface.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class OPPTCustomDTO implements Serializable 
{
    /** Automatically generated javadoc for: serialVersionUID */
    private static final long serialVersionUID = 2105526150206601992L;
	private Map buttonFlags = null;
	private ErrorReport messageReport = null;

	private String userId = null;
	private String emailAddress = null;
	private String groupName = null;
	private String selectedGroupName = null;
	private TreeMap userGroups = null;
	private String firstName = null;
	private String lastName = null;
	private String primarySalesOrg = null;
	private int role = 0;

//	 Changes for Base agreement starts
	
	private String userType = null;
	private int baUserRole = 0;

//	 Changes for Base agreement ends
	
	private String sessionId = null;
	private String transactionName = null;
	
	private boolean confirmationRequired = false;
	
	/**
	 * Adds a new button flag that need not be shown to the user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param buttonId String
	 */
	public void addButtonFlag(String buttonId){
		if(null != buttonId){
			if(null == buttonFlags){
				buttonFlags = new TreeMap();
			}
			buttonFlags.put(buttonId, buttonId);
		}
	}
	
	/**
	 * Adds the messageId to the collection of alteady existing message ids.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param messageId String value which is to be added to the already existing collection of ids.
	 * @param layer int
	 */
	public void addMessageEntry(String messageId, int layer) {
		if(null != messageId) {
			if(null == messageReport){
				messageReport = new ErrorReport();
			}
			messageReport.addErrorEntry(new ErrorKey(messageId, layer), null);
		}
	}
	
	/**
	 * Returns button flags collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public Map getButtonFlags() {
		return buttonFlags;
	}
	
	/**
	 * Returns the email address of the current user logged in
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Returns the group name of the user currently logged in user.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
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
	 * Returns collection of message ids 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ErrorReport
	 */
	public ErrorReport getMessageReport() {
		return messageReport;
	}

	/**
	 * Returns sales org value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPrimarySalesOrg() {
		return primarySalesOrg;
	}

	/**
	 * Returns the role of the user who is currently logged in
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getRole() {
		ProposalDataManagerBean data = new ProposalDataManagerBean();
		data.role=role;
		OPPTCalender cal = new OPPTCalender();
		cal.role=role;
		return role;
	}
	/**
	 * Returns session id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * Returns transaction name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getTransactionName() {
		return transactionName;
	}

	/**
	 * Returns the userId of the currently logged in user
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets button flags collection value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newButtonFlags Map 
	 */
	public void setButtonFlags(Map newButtonFlags) {
		buttonFlags = newButtonFlags;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param asessionId String
	 * @param agroupName String
	 * @param auserId String
	 * @param arole int
	 * @param aemailAddress String
	 * @param aprimarySalesOrg String
	 */
	public void setData(String asessionId, String agroupName, String auserId, int arole, String aemailAddress, String aprimarySalesOrg){
		setSessionId(asessionId);
		setGroupName(agroupName);
		setUserId(auserId);
		setRole(arole);
		setEmailAddress(aemailAddress);
		setPrimarySalesOrg(aprimarySalesOrg);
	}

	/**
	 * Sets the string value passed as the email address of the currently logged in user.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEmailAddress String value which is set as the email address of the currently logged in user.
	 */
	public void setEmailAddress(String newEmailAddress) {
		emailAddress = newEmailAddress;
	}

	/**
	 * Sets the string value passed as the group name of the currently logged in user.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroupName String value which is set as te group name of the currently logged in user
	 */
	public void setGroupName(String newGroupName) {
		groupName = newGroupName;
	}

	/**
	 * Sets message ids collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessageReport ArrayList 
	 */
	public void setMessageReport(ErrorReport newMessageReport) {
		messageReport = newMessageReport;
	}

	/**
	 * Sets sales org value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPrimarySalesOrg String 
	 */
	public void setPrimarySalesOrg(String newPrimarySalesOrg) {
		primarySalesOrg = newPrimarySalesOrg;
	}

	/**
	 * Sets the string value as the role of the currently logged in user.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newRole int value which is used as role of the currently logged in user
	 */
	public void setRole(int newRole) {
		role = newRole;
	}

	/**
	 * Sets session id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSessionId String 
	 */
	public void setSessionId(String newSessionId) {
		sessionId = newSessionId;
	}

	/**
	 * Sets transaction name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTransactionName String 
	 */
	public void setTransactionName(String newTransactionName) {
		transactionName = newTransactionName;
	}

	/**
	 * Sets the string value as the user id of the user currently logged in.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUserId String value which is used as userId of the currently logged in user.
	 */
	public void setUserId(String newUserId) {
		userId = newUserId;
	}
	
	/**
     * Sets complete user info in a single method call
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 24, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param agroupName String
     * @param auserId String
     * @param arole int
     * @param aemailAddress String
     * @param aprimarySalesOrg
     * @param auserGroups 
     */
	public void setUserInfo(String agroupName, String auserId, int arole, String aemailAddress, String aprimarySalesOrg,TreeMap auserGroups){
		setGroupName(agroupName);
		setUserId(auserId);
		setRole(arole);
		setEmailAddress(aemailAddress);
		setPrimarySalesOrg(aprimarySalesOrg);
		setUserGroups(auserGroups);
	}
	
	/**
	 * Returns confirmation required initiator 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isConfirmationRequired() {
		return confirmationRequired;
	}

	/**
	 * Sets confirmation required  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newConfirmationRequired boolean 
	 */
	public void setConfirmationRequired(boolean newConfirmationRequired) {
		confirmationRequired = newConfirmationRequired;
	}
	/**
	 * Returns users first name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns user last name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets users first name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFirstName String 
	 */
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	/**
	 * Sets users last name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLastName String 
	 */
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}

	/**
	 * Returns user name  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getUserName(){
		StringBuffer userInfo = new StringBuffer();
		if(null != getFirstName()){
			userInfo.append(getFirstName()+" ");  /* NOI18N */
		}
		if(null != getLastName()){
			userInfo.append(getLastName());
		}
		if(0 == userInfo.length()){
			userInfo.append(getUserId());
		}
		return userInfo.toString();
		
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
	 * date May 27, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
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
	 * date May 27, 2005 
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
	 * date Jun 15, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedGroupName() {
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
	 * date Jun 15, 2005 
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

//	 Changes for Base agreement starts	
	/**
	 * @return Returns the baUserRole.
	 */
	public int getBaUserRole() {
		return baUserRole;
	}
	/**
	 * @param lBaUserRole The baUserRole to set.
	 */
	public void setBaUserRole(int lBaUserRole) {
		baUserRole = lBaUserRole;
	}
/**
 * @return Returns the userType.
 */
public String getUserType() {
	return userType;
}
/**
 * @param lUserType The userType to set.
 */
public void setUserType(String lUserType) {
	userType = lUserType;
}

//Changes for Base agreement ends
}