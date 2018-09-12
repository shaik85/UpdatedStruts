/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.NonBPUserActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.NonBPUserDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO;

/**
 * Holds complete data required for creating or registering or editing non bp user view.  
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
public class NonBPUserViewBean extends UserViewBean {
	private TreeMap iSalesAreaAccessType = null;
	private NonBPUserDataBean iNonBPUserData = null;
	
	
	/**
     * NonBPUserViewBean
     * 
     * @author thirumalai
     */
    public NonBPUserViewBean(){
	}
	
	/**
     * NonBPUserViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public NonBPUserViewBean(CreateUserCustomDTO customDto){
		super(customDto);
	}
	
	/**
     * NonBPUserViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public NonBPUserViewBean(NonBPUserCustomDTO customDto){
		super(customDto);
		setSalesAreaAccessType(customDto.getSalesAreaAccessType());
		setNonBpUser(customDto.getSalesAreaAccessType(),customDto.getSelectedGroups(),customDto.getGroupsThatCannotBeDeleted());
	}
	
	private void setNonBpUser(TreeMap accessType,TreeSet selectedGroups, TreeSet groupsThatCannotBeDeleted){
		NonBPUserDataBean nonBpDataBean = new NonBPUserDataBean();
		
		ArrayList groupsThatCannotBeDeletedList = new ArrayList();
		
		int size = accessType.keySet().size();
		String [] accessTypeArray = new String[size];
		String [] salesAreaArray = new String[size];
		Iterator itr = accessType.keySet().iterator();
		int counter = 0;
		while(itr.hasNext()){
			String key = (String)itr.next();
			salesAreaArray[counter] = key;
			accessTypeArray[counter] = (String)accessType.get(key);
			counter++;
		}
		if(selectedGroups != null) {
			String []groupsArray = new String[selectedGroups.size()];
		    groupsArray  = (String [])selectedGroups.toArray(groupsArray);	
			nonBpDataBean.setGroupName(groupsArray);			
		}
		if(groupsThatCannotBeDeleted != null){
			groupsThatCannotBeDeletedList.addAll(groupsThatCannotBeDeleted);
			nonBpDataBean.setGroupsThatCannotBeDeleted(groupsThatCannotBeDeletedList);
		} 
		nonBpDataBean.setAccessType(accessTypeArray);
		nonBpDataBean.setSalesArea(salesAreaArray);
		
		setNonBPUserData(nonBpDataBean);
	}
	
	/**
	 * Returns the collection of access type options 
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
	 * @return Hashtable
	 */
	public TreeMap getSalesAreaAccessType() {
		return iSalesAreaAccessType;
	}

	/**
	 * Sets non business partner user data 
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
	 * @return NonBPUserDataBean
	 */
	public NonBPUserDataBean getNonBPUserData() {
		if(null == iNonBPUserData){
			iNonBPUserData = new NonBPUserDataBean();
		}
		return iNonBPUserData;
	}

	/**
	 * Sets the access type collection 
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
	 * @param newAccessTypeOptions Hashtable 
	 */
	public void setSalesAreaAccessType(TreeMap newAccessTypeOptions) {
		iSalesAreaAccessType = newAccessTypeOptions;
	}

	/**
     * Sets non business partners data
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param nonBPUserData 
     */
	public void setNonBPUserData(NonBPUserDataBean nonBPUserData) {
		iNonBPUserData = nonBPUserData;
	}

	/**
	 * Adds a new access type option entry into the already existing collection.  
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
	 * @param accessTypeId String
	 * @param accessType String
	 */
	public void addAccessTypeOption (String accessTypeId, String accessType){
		if(null != accessTypeId && null != accessType){
			if(null == iSalesAreaAccessType){
				iSalesAreaAccessType = new TreeMap();
			}
			iSalesAreaAccessType.put(accessTypeId, accessType);
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
	 * @param accessTypeOptions Hashtable
	 * @param nonBPUserData NonBPUserDataBean
	 */
	public void setData(TreeMap accessTypeOptions, NonBPUserDataBean nonBPUserData){
		setSalesAreaAccessType(accessTypeOptions);
		setNonBPUserData(nonBPUserData);
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
	public NonBPUserActionForm getNonBPUserActionForm() {
		NonBPUserActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof NonBPUserActionForm){
			actionForm = (NonBPUserActionForm)getActionForm();
		}
		else{
			actionForm = new NonBPUserActionForm();
		}
		return actionForm;
	}
	
	/**
	 *  
	 * Retrieves data from String array, packs in TreeMap and returns
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public TreeMap getsalesAreaAccess(){
		TreeMap salesAreaAccess = null;
		String[] accessType=null;
		String[] salesArea= null; 

		accessType = getNonBPUserActionForm().getNonBPUserDataBean().getAccessType();
		salesArea = getNonBPUserActionForm().getNonBPUserDataBean().getSalesArea();

		if(null != accessType && null != salesArea){
			int size = accessType.length;
			salesAreaAccess = new TreeMap();
			for(int i=0; i < size; i++){
				if(null != accessType[i]&& !"".equals(accessType[i]) &&  //$NON-NLS-1$
					null != salesArea[i] && !"".equals(salesArea[i])) {  //$NON-NLS-1$
				salesAreaAccess.put(salesArea[i], accessType[i]);
				}
			}
		}
		return salesAreaAccess;
	}
	
}
