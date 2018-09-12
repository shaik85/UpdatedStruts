/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CreateUserActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 31, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class UserViewBean extends OPPTViewBean{
	
	/**
	 *  constant
     */
    public static final int CREATE_USER = 0;
	/**
	 * constant
     */
    public static final int REGISTER_USER = 1;
	/**
	 * constant
     */
    public static final int EDIT_USER = 2;
	/**
	 * Type refers to the type of the view. Whethe it is Register/Create/Edit.
	 */
	private int iType = CREATE_USER;
	
	private TreeMap  iRoles = null;
	private TreeMap  iSalesAreas = null;
	private TreeMap  iManagers = null;
	private TreeMap  iGroups = null;
	private String   iUserId = null;
	private String   iSelectedRole = null;
	private String   iPrimarySalesArea = null;
	private String   iSelectedManager = null;
	private String[] iSelectedGroups = null;
	private String   iGeoSecOfficer = null;
	private String   iAuthorization = null;
	private TreeMap  userTypes = null;
	private TreeMap  baRoles = null;
    private String   selectedUserType = null;
    private String   selectedBARole = null;
	/**
     * UserViewBean
     * 
     * @author thirumalai
     */
    public UserViewBean(){
	}
	
	/**
     * UserViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public UserViewBean(CreateUserCustomDTO customDto){
		setRoles(customDto.getRoles());
		setAuthorization(customDto.getPrimarySalesAreaAuthorization());
		setSalesAreas(customDto.getSalesAreas());
		setManagers(customDto.getManagers());
		setGroups(customDto.getGroups());
		setUserId(customDto.getUserId());
		setSelectedRole(customDto.getSelectedRole());
		setPrimarySalesArea(customDto.getPrimarySalesArea());	
		setSelectedManager(customDto.getSelectedManager());	
		setSelectedGroups(toStringArray(customDto.getSelectedGroups()));	
		setGeoSecOfficer(customDto.getGeoSecOfficer());
		setUserTypes(customDto.getUserTypes());
		setSelectedUserType(customDto.getSelectedUserType());
		setBaRoles(customDto.getBaRoles());
		setSelectedBARole(customDto.getSelectedBaRole());
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getAuthorization() {
		return iAuthorization;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getGeoSecOfficer() {
		return iGeoSecOfficer;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getGroups() {
		return iGroups;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getManagers() {
		return iManagers;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getPrimarySalesArea() {
		return iPrimarySalesArea;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getRoles() {
		return iRoles;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getSalesAreas() {
		return iSalesAreas;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String[] getSelectedGroups() {
		return iSelectedGroups;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSelectedManager() {
		return iSelectedManager;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSelectedRole() {
		return iSelectedRole;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public int getType() {
		return iType;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getUserId() {
		return iUserId;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setAuthorization(String string) {
		iAuthorization = string;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setGeoSecOfficer(String string) {
		iGeoSecOfficer = string;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setGroups(TreeMap map) {
		iGroups = map;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setManagers(TreeMap map) {
		iManagers = map;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setPrimarySalesArea(String string) {
		iPrimarySalesArea = string;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setRoles(TreeMap map) {
		iRoles = map;
	}

	/**
	 * @return Returns the baRoles.
	 */
	public TreeMap getBaRoles() {
		return baRoles;
	}
	/**
	 * @param lBaRoles The baRoles to set.
	 */
	public void setBaRoles(TreeMap lBaRoles) {
		baRoles = lBaRoles;
	}
	/**
	 * @return Returns the selectedBARole.
	 */
	public String getSelectedBARole() {
		return selectedBARole;
	}
	/**
	 * @param lSelectedBARole The selectedBARole to set.
	 */
	public void setSelectedBARole(String lSelectedBARole) {
		selectedBARole = lSelectedBARole;
	}
	/**
	 * @return Returns the selectedUserType.
	 */
	public String getSelectedUserType() {
		return selectedUserType;
	}
	/**
	 * @param lSelectedUserType The selectedUserType to set.
	 */
	public void setSelectedUserType(String lSelectedUserType) {
		selectedUserType = lSelectedUserType;
	}
	/**
	 * @return Returns the userTypes.
	 */
	public TreeMap getUserTypes() {
		return userTypes;
	}
	/**
	 * @param lUserTypes The userTypes to set.
	 */
	public void setUserTypes(TreeMap lUserTypes) {
		userTypes = lUserTypes;
	}
	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 31, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newSalesAreas 
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSelectedGroups(String string[]) {
		iSelectedGroups = string;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSelectedManager(String string) {
		iSelectedManager = string;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSelectedRole(String string) {
		iSelectedRole = string;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param i 
	 */
	public void setType(int i) {
		iType = i;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setUserId(String string) {
		iUserId = string;
	}
	
	/**
     * Sets complete data in a single call.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 14, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param authorization
     * @param geoSecOfficer
     * @param groups
     * @param managers
     * @param primarySalesArea
     * @param roles
     * @param salesAreas
     * @param selectedGroups
     * @param selectedManager
     * @param selectedRole
     * @param userId 
     */
	public void setData(TreeMap roles, TreeMap salesAreas, TreeMap managers, TreeMap groups, String  userId,
		String selectedRole, String primarySalesArea, String  selectedManager, String  selectedGroups [],
		String  geoSecOfficer, String authorization,TreeMap userTypes,String selectedUserType,
		TreeMap baRoles, String selectedBaRole){
			
		setRoles(roles);
		setSalesAreas(salesAreas);
		setManagers(managers);
		setGroups(groups);
		setUserId(userId);
		setSelectedRole(selectedRole);
		setPrimarySalesArea(primarySalesArea);
		setSelectedManager(selectedManager);
		setSelectedGroups(selectedGroups);
		setGeoSecOfficer(geoSecOfficer);
		setAuthorization(authorization);
		setUserTypes(userTypes);
		setSelectedUserType(selectedUserType);
		setBaRoles(baRoles);
		setSelectedBARole(selectedBaRole);
		
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
	 * @return CreateProposalActionForm
	 */
	public CreateUserActionForm getCreateUserActionForm() {
		CreateUserActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof CreateUserActionForm){
			actionForm = (CreateUserActionForm)getActionForm();
		}
		else{
			actionForm = new CreateUserActionForm();
		}
		return actionForm;
	}
	
	private String [] toStringArray(TreeSet set) {
		String [] stringArray = null;
		if(set != null && set.size() > 0) {
			stringArray = new String[set.size()];
			stringArray = (String []) set.toArray(stringArray);		
		}		
		return stringArray;
	}

}
