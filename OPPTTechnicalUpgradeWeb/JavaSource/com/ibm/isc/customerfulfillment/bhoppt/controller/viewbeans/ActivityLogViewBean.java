/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Collections;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.ActivityLogComparator;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.ActivityLogDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ActivityLogCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ActivityLogDataCustomDTO;


/**
 * Holds complete information about change history of a user
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date 29th March 2011
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 *  Created by Nomita as a part of Activity Log changes
 * Date 11th Jan 2011
 */
public class ActivityLogViewBean extends OPPTViewBean{
	private ArrayList iActivityLog = null;
	
	
	/**
	 * Returns change history collection
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 *
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getActivityLog() {
		ActivityLogComparator comparator = null;
		if(null != iActivityLog){
			comparator = new ActivityLogComparator();
			Collections.sort(iActivityLog, comparator);
		}
		return iActivityLog;
	}

	/**
	 * Sets change history collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newActivityLog ArrayList 
	 */
	public void setActivityLog(ArrayList newActivityLog) {
		iActivityLog = newActivityLog;
	}

	/**
	 * Adds a new change history entry to already existing collection of change history entries.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ActivityLog ActivityLogDataBean
	 */
	public void addActivityLog(ActivityLogDataBean ActivityLog){
		if(null != ActivityLog){
			if(null == iActivityLog){
				iActivityLog = new ArrayList();
			}
			iActivityLog.add(ActivityLog);
		}
	}
	
	/**
     * Sets complete data in a single method call.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param customDTO 
     */
	public void setData(ActivityLogCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			ArrayList ActivityLog = customDTO.getActivityLog();
			if(null != ActivityLog){
				for(int i=0, size=ActivityLog.size(); i<size; i++){
					ActivityLogDataCustomDTO data = (ActivityLogDataCustomDTO)ActivityLog.get(i);
					if(null != data){
						addActivityLog(new ActivityLogDataBean(data));
					}
				}
			}
		}
	}

	/**
     * ActivityLogViewBean
     * 
     * @author Nomita
     */
    public ActivityLogViewBean(){
	}
	/**
     * ActivityLogViewBean
     * 
     * @param customDTO
     * @author Nomita
     */
    public ActivityLogViewBean(ActivityLogCustomDTO customDTO){
		setData(customDTO);
	}
	/**
     * ActivityLogViewBean
     * 
     * @param customDTO
     * @param contract
     * @author Nomita
     */
   

	
	

}
