/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dto;


import java.util.HashMap;


import java.io.Serializable;
import java.lang.ref.WeakReference;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
/** 
 * This is the base class for the all the domain dtos 
 * which have common values to be transfered across the layer 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 2, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar J
 * @version 5.1A 
 */


public class OPPTDomainDTO implements Serializable {
	
	private String actionName;
	private boolean actionAllowed = true;
	private HashMap iValues;
	
	double discount1;
	
	
	  /*PricePropsalDomaiDTO  dto;
	   * 
	   * set and get 
	   */
	
	
	public double getDiscount1() {
		System.out.println("OPPTDomainDTO.getDiscount1()"+discount1);
		return discount1;
	}

	public void setDiscount1(double discount1) {
		this.discount1 = discount1;
	}

	/** 
	 * Checks whether the action to be followed is allowed 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iActionAllowed
	 */
	public boolean isActionAllowed() {
		return actionAllowed;
	}
	
	/** 
	 * Gets the transaction name
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iActionName
	 */
	public String getActionName() {
		return actionName;
	}
	
	/** 
	 * Gets the values
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iValues
	 */
	public HashMap getValues() {
		return iValues;
	}
	
	/** 
	 * Sets whether the transaction to be followed is allowed
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setActionAllowed(boolean b) {
		actionAllowed = b;
	}
	
	/** 
	 * Sets the transaction name
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setActionName(String newActionName) {
		actionName = newActionName;
	}
	
	/** 
	 * Set the values
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setValues(HashMap map) {
		iValues = map;
	}
	
	public String formatSQL(String sql) {
		sql = OPPTHelper.replace(sql,",'null'",",null");
		sql = OPPTHelper.replace(sql,",''",",null");
		System.out.println("OPPTDomainDTO.formatSQL()"+sql);
		return sql;
	}
}
