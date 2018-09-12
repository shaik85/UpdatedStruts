/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UsersCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
/**
 * Holds complete data required for user maintenance view  
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
public class UserMaintenanceViewBean extends OPPTViewBean{
	private TreeMap iUserInfos = null;
	private TreeMap iSalesAreas = null;
	private String iSelectedSalesArea = null;
	private String iMessage = null;
	
	/**
     * UserMaintenanceViewBean
     * 
     * @author thirumalai
     */
    public UserMaintenanceViewBean(){
	}
	
	/**
     * UserMaintenanceViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public UserMaintenanceViewBean(UsersCustomDTO customDto){
		setSalesAreas(customDto.getSalesAreas());
		setSelectedSalesArea(customDto.getSelectedSalesArea());
		setUserList(customDto.getUsers());
		ErrorReport messageReport = customDto.getMessageReport();
		if(null != messageReport)
		{
			setMessage(getMessage(messageReport));
		}
	}

	/**
	 * Returns available sales areas collection 
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
	 * Returns collection of user infos 
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
	public TreeMap getUserInfos() {
		return iUserInfos;
	}

	/**
	 * Sets sales areas collection 
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
	 * @param newSalesAreas TreeMap 
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
				localSalesArea.put(desc.trim() + "-" + key, key);  //$NON-NLS-1$
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
	 * Sets user infos collection 
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
	 * @param newUserInfos TreeMap 
	 */
	public void setUserInfos(TreeMap newUserInfos) {
		iUserInfos = newUserInfos;
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
	 * date Feb 20, 2004 
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

	/**
	 * Adds an user info to collection of already existing user info's  
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
	 * @param userInfo UserInfoViewBean
	 */
	public void addUserInfo(UserInfoViewBean userInfo){
		if(null != userInfo){
			if(null == iUserInfos){
				iUserInfos = new TreeMap();
			}
			iUserInfos.put(userInfo.getUserId(), userInfo);
		}
		
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
	 * Sets complete data in a single method call  
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
	 * @param userInfos
	 * @param salesAreas
	 * @param selectedSalesArea
	 */
	public void setData(TreeMap userInfos, TreeMap salesAreas, String selectedSalesArea){
		setUserInfos(userInfos);
		setSalesAreas(salesAreas);
		setSelectedSalesArea(selectedSalesArea);
	}
	
	private void setUserList(TreeMap userMap){	
		if(null != userMap){	
			Iterator userItr = userMap.keySet().iterator();
			UserCustomDTO customDto;
			UserInfoViewBean userBean;
			
			while(userItr.hasNext()){
				userBean = new UserInfoViewBean();
				String key = (String)userItr.next();
				customDto = (UserCustomDTO)userMap.get(key);
				userBean.setUserId(checkNull(customDto.getUserId()));
				userBean.setUserType(customDto.getUserType());
				userBean.setUserTypDesc(OPPTStaticDataHolder.getUserTypeDesc(customDto.getUserType()));
				userBean.setBaRole(customDto.getBaUserRole());
				userBean.setApprovedBy(checkNull(customDto.getApprovedBy()));
				userBean.setRole(customDto.getRole());
				if(Constants.SOFTWARE_USER.equals(customDto.getUserType()))
				{	
					userBean.setRoleDescription(OPPTStaticDataHolder.getRoleDesc(String.valueOf(customDto.getRole())));
				} else {
					userBean.setRoleDescription(OPPTStaticDataHolder.getBARoleDesc(String.valueOf(customDto.getBaUserRole())));
				}
					
				userBean.setGroup(checkNull(customDto.getGroup()));
				addUserInfo(userBean);
			}
		}
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
	
	private String checkNull(String value){
		if(null == value){
			return "";  //$NON-NLS-1$
		}
		else{
			return value;
		}
	}
}
