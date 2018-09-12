/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.*;
import java.util.ArrayList;

/**
 * Custom dto that holds data for creating and editing business partner user.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 1, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class BPUserCustomDTO extends CreateUserCustomDTO {
	private String accessType = null;
	private ArrayList customerNumbers = null;
	private HashMap legacyNos = null;
	
	/**
	 * Returns the access type of the user
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getAccessType() {
		return accessType;
	}

	/**
	 * Returns the collection of customer number as per access type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getCustomerNumbers() {
		return customerNumbers;
	}

	/**
	 * Sets access type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAccessType String 
	 */
	public void setAccessType(String newAccessType) {
		accessType = newAccessType;
	}

	/**
	 * Sets collection of customer numbers as per access type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerNumbers ArrayList 
	 */
	public void setCustomerNumbers(ArrayList newCustomerNumbers) {
		customerNumbers = newCustomerNumbers;
	}

	/**
	 * Adds customer number to the collection of customer numbers  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerNumber String
	 */
	public void addCustomerNumber(String customerNumber){
		if(null != customerNumber){
			if(null == customerNumbers){
			    customerNumbers = new ArrayList();
			}
			customerNumbers.add(customerNumber);
		}
	}
	
	/**
	 * Sets complete data in a single method call
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param roles HashMap
	 * @param salesAreas HashMap
	 * @param managers HashMap
	 * @param groups HashMap
	 * @param userId String
	 * @param selectedRole String
	 * @param primarySalesArea String
	 * @param selectedManager String
	 * @param lselectedGroup String
	 * @param laccessType String
	 * @param lcustomerNumbers ArrayList
	 */
	public void setData(TreeMap roles, TreeMap salesAreas, TreeMap managers, 
						TreeMap groups, String userId, String selectedRole, 
						String primarySalesArea, String selectedManager, String lselectedGroup,		
						String laccessType, ArrayList lcustomerNumbers){
		// This is not used at all so we pass null. There is no Business need for BP user at this point of time
		super.setData(roles, salesAreas, managers, groups, userId, selectedRole, primarySalesArea, selectedManager, null,null,null,null,null);
		setAccessType(laccessType);
		setCustomerNumbers(lcustomerNumbers);
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
	 * date Jan 17, 2004 
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
	 * date Jan 17, 2004 
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

}
