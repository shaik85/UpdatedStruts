/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import java.util.Comparator;

/** 
 * Implements compare method for sorting Access History.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 16, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A 
 */
public class AccessHistoryComparator implements Comparator {

	/** 
	 * For sorting based on Locked On date of ProposalHistoryDataBean.
	 * 
	 * <br/><PRE> 
	 * date Mar 16, 2004 
	 * 
	 *  Revised by Nomita as a part of Activity Log changes
 * Date 11th Jan 2011
	 * 
	 * </PRE><br/> 
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object) 
	 * @return 
	 * 
	 */
	public int compare(Object firstObject, Object secondObject) {
		int returnValue = 0;
		ProposalHistoryDataBean dataBeanFirst = null;
		ProposalHistoryDataBean dataBeanSecond = null;
		
		if(firstObject instanceof ProposalHistoryDataBean && secondObject instanceof ProposalHistoryDataBean){
			dataBeanFirst = (ProposalHistoryDataBean)firstObject;
			dataBeanSecond = (ProposalHistoryDataBean)secondObject;
			if(dataBeanFirst.getAccessDate().after(dataBeanSecond.getAccessDate())){
				returnValue = 1;
			}
			else if(dataBeanFirst.getAccessDate().before(dataBeanSecond.getAccessDate())){
				returnValue = -1;
			}
		}
		return returnValue;
	}

}
