/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

public class ProposalSharingActionForm extends OPPTActionForm {
	private String accessType1 = null;
	private String accessUser1 = null;
	private String accessType2 = null;
	private String accessUser2 = null;
	private String accessType3 = null;
	private String accessUser3 = null;
	
	/**
	 * Returns access type1 value 
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
	 * @return String
	 */
	public String getAccessType1() {
		return accessType1;
	}

	/**
	 * Returns access type 2 value 
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
	 * @return String
	 */
	public String getAccessType2() {
		return accessType2;
	}

	/**
	 * Returns access type 3 value 
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
	 * @return String
	 */
	public String getAccessType3() {
		return accessType3;
	}

	/**
	 * Returns access user 1 value 
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
	 * @return String
	 */
	public String getAccessUser1() {
		return accessUser1;
	}

	/** 
	 * Returns access user 2 value 
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
	 * @return String
	 */
	public String getAccessUser2() {
		return accessUser2;
	}

	/** 
	 * Returns access user 3 value 
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
	 * @return String
	 */
	public String getAccessUser3() {
		return accessUser3;
	}

	/** 
	 * Sets access type 1 value 
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
	 * @param newAccessType1 String 
	 */
	public void setAccessType1(String newAccessType1) {
		accessType1 = newAccessType1;
	}

	/** 
	 * Sets access type 2 value 
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
	 * @param newAccessType2 String 
	 */
	public void setAccessType2(String newAccessType2) {
		accessType2 = newAccessType2;
	}

	/** 
	 * Sets access type 3 value 
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
	 * @param newAccessType3 String 
	 */
	public void setAccessType3(String newAccessType3) {
		accessType3 = newAccessType3;
	}

	/**
	 * Sets access user 1 value 
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
	 * @param newAccessUser1 String 
	 */
	public void setAccessUser1(String newAccessUser1) {
		accessUser1 = newAccessUser1;
	}

	/** 
	 * Sets access user 2 value 
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
	 * @param newAccessUser2 String 
	 */
	public void setAccessUser2(String newAccessUser2) {
		accessUser2 = newAccessUser2;
	}

	/** 
	 * Sets access user 3 value 
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
	 * @param newAccessUser3 String 
	 */
	public void setAccessUser3(String newAccessUser3) {
		accessUser3 = newAccessUser3;
	}
	
	/**
	 * @return
	 */
	public TreeMap getRequestParams()
	{
		TreeMap userAccesses = new TreeMap();
		
		if(!isSelectEmpty(accessUser1) && isValidAccessUser(accessUser1)){
			userAccesses.put(accessUser1, accessType1);
		}
		
		if(!isSelectEmpty(accessUser2) && isValidAccessUser(accessUser2)){
			userAccesses.put(accessUser2, accessType2);
		}
		
		if(!isSelectEmpty(accessUser3) && isValidAccessUser(accessUser3)){
			userAccesses.put(accessUser3, accessType3);
		}
		
		return userAccesses;
	}
	
	/**
	 * @param accessUser
	 * @return
	 */
	private boolean isValidAccessUser(String accessUser){
		boolean validAccessUser = true;
		if(null == accessUser || "None".equalsIgnoreCase(accessUser.trim())){
			validAccessUser = false;
		}
		return validAccessUser;
	}
	
	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		accessType1 = null;
		accessUser1 = null;
		accessType2 = null;
		accessUser2 = null;
		accessType3 = null;
		accessUser3 = null;
	}
}
