/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;


import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds data for the contract maintenance date range view. In general there will not be any data here. 
 * When ever an error occurs in user selection, those errors will be part of ErrorReport, which is part 
 * of the OPPTViewBean from which this class extends. In this for showing the user his previous selections, 
 * we have two parameters fromDate and toDate
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ContractMaintenanceDateRangeViewBean extends OPPTViewBean {
	private ArrayList yearRange = null;
	
	/** 
	 * For getting year range
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getYearRange() {
		return yearRange;
	}

	/** 
	 * For setting year range
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list ArrayList
	 */
	public void setYearRange(ArrayList list) {
		yearRange = list;
	}

}
