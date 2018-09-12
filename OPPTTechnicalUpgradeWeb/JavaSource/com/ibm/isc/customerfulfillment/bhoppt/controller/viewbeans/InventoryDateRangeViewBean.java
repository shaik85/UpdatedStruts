/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryDateRangeCustomDTO;

/**
 * Holds the data required for selecting the date range for fetching planned inventory.  
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
public class InventoryDateRangeViewBean extends OPPTViewBean{
	private Date iDefaultStartDate = null;
	private Date iDefaultEndDate = null;
	private ArrayList iStartYears = null;
	private ArrayList iEndYears = null;

	/**
	 * Returns contract end year collection 
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
	 * @return ArrayList
	 */
	public ArrayList getEndYears() {
		return iEndYears;
	}

	/**
	 * Returns contract start year collection 
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
	 * @return ArrayList
	 */
	public ArrayList getStartYears() {
		return iStartYears;
	}

	/**
	 * Returns default end date 
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
	 * @return Date
	 */
	public Date getDefaultEndDate() {
		return iDefaultEndDate;
	}

	/**
	 * Returns default start date 
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
	 * @return Date
	 */
	public Date getDefaultStartDate() {
		return iDefaultStartDate;
	}

	/**
	 * Sets default end date 
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
	 * @param newDefaultStartDate Date 
	 */
	public void setDefaultEndDate(Date newDefaultStartDate) {
		iDefaultEndDate = newDefaultStartDate;
	}

	/**
	 * Sets default start date 
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
	 * @param newDefaultStartDate Date 
	 */
	public void setDefaultStartDate(Date newDefaultStartDate) {
		iDefaultStartDate = newDefaultStartDate;
	}

	/**
	 * Sets contract end year collection 
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
	 * @param newEndYears ArrayList 
	 */
	public void setEndYears(ArrayList newEndYears) {
		iEndYears = newEndYears;
	}

	/**
	 * Sets contract start year collection 
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
	 * @param newStartYears ArrayList 
	 */
	public void setStartYears(ArrayList newStartYears) {
		iStartYears = newStartYears;
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
	 * @param defaultStartDate
	 * @param defaultEndDate
	 */
	public void setData(Date defaultStartDate, Date defaultEndDate){
		setDefaultStartDate(defaultStartDate);
		setDefaultEndDate(defaultEndDate);
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(InventoryDateRangeCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			setDefaultStartDate(customDTO.getDefaultStartDate());
			setDefaultEndDate(customDTO.getDefaultEndDate());
			setStartYears(customDTO.getStartYears());
			setEndYears(customDTO.getEndYears());
		}
	}
	
	/**
     * InventoryDateRangeViewBean
     * 
     * @author thirumalai
     */
    public InventoryDateRangeViewBean(){
	}
	/**
     * InventoryDateRangeViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public InventoryDateRangeViewBean(InventoryDateRangeCustomDTO customDTO){
		setData(customDTO);
	}
}
