/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;

import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BPUserActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO;

/**
 * Class extends from UserViewBean to provide extra information for the business partner.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 14, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class BPUserViewBean extends UserViewBean {
	private String accessRequiredOptions = null;
	private ArrayList customerNumbers = null;
	private HashMap legacyNos = null; 
	
	
	/**
     * BPUserViewBean
     * 
     * @author thirumalai
     */
    public BPUserViewBean(){
	}
	
	/**
     * BPUserViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public BPUserViewBean(CreateUserCustomDTO customDto){
		super(customDto);
	}
	
	/**
     * BPUserViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public BPUserViewBean(BPUserCustomDTO customDto){
		super(customDto);
		setAccessRequiredOptions(customDto.getAccessType());
		setCustomerNumbers(customDto.getCustomerNumbers());
		setLegacyNos(customDto.getLegacyNos());
	}


	/**
	 * Returns the collection of access required options.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Vector
	 */
	public String getAccessRequiredOptions() {
		return accessRequiredOptions;
	}

	

	/**
	 * Sets the collection as access required options. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAccessRequiredOptions Vector 
	 */
	public void setAccessRequiredOptions(String newAccessRequiredOptions) {
		accessRequiredOptions = newAccessRequiredOptions;
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
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public ArrayList getCustomerNumbers() {
		return customerNumbers;
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
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public HashMap getLegacyNos() {
		return legacyNos;
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
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setCustomerNumbers(ArrayList list) {
		customerNumbers = list;
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
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setLegacyNos(HashMap map) {
		legacyNos = map;
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
	public BPUserActionForm getBPUserActionForm() {
		BPUserActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof BPUserActionForm){
			actionForm = (BPUserActionForm)getActionForm();
		}
		else{
			actionForm = new BPUserActionForm();
		}
		return actionForm;
	}
	
	/**
     * getListNumberArrayList
     * 
     * @return
     * @author thirumalai
     */
    public ArrayList getListNumberArrayList() {
		String[] listNumber = getBPUserActionForm().getListNumbers();
		ArrayList tempArray = new ArrayList();
		String value=null;
		if(null != listNumber){
			int length = listNumber.length;
			for(int i = 0; i < length; i++){
				value = listNumber[i];
				tempArray.add(value);
			}
		}
		return tempArray;
	}
	
	/**
	 * Retrieves data from String array, packs in HashMap and returns
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
	public HashMap getUserLegacy(){
		HashMap userLegacy = null;
		String []legacyNumber=null;
		String []sequenceNumber=null;

		legacyNumber = getBPUserActionForm().getLegacyNumber();
		sequenceNumber = getBPUserActionForm().getSequenceNumber();

		if(null != legacyNumber && null != sequenceNumber){
			int size = legacyNumber.length;
			userLegacy = new HashMap();
			for(int i=0; i < size; i++){
				if(null != legacyNumber[i]&& !"".equals(legacyNumber[i]) &&  //$NON-NLS-1$
					null != sequenceNumber[i] && !"".equals(sequenceNumber[i]))  //$NON-NLS-1$
				userLegacy.put(legacyNumber[i], sequenceNumber[i]);
			}
		}
		return userLegacy;
	}

}
