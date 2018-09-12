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
 * Created by Nomita as a part of Activity Log changes
 * Date 11th Jan 2011
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A 
 */
public class ActivityLogComparator implements Comparator {

	/** 
	 *
	 * 
	 * <br/><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object) 
	 * @return 
	 * 
	 */
	public int compare(Object firstObject, Object secondObject) {
		int returnValue = 0;
		ActivityLogDataBean dataBeanFirst = null;
		ActivityLogDataBean dataBeanSecond = null;
		
		if(firstObject instanceof ActivityLogDataBean && secondObject instanceof ActivityLogDataBean){
			dataBeanFirst = (ActivityLogDataBean)firstObject;
			dataBeanSecond = (ActivityLogDataBean)secondObject;
			if(dataBeanFirst.getActivityDate().after(dataBeanSecond.getActivityDate())){
				returnValue = 1;
			}
			else if(dataBeanFirst.getActivityDate().before(dataBeanSecond.getActivityDate())){
				returnValue = -1;
			}
		}
		return returnValue;
	}

}
