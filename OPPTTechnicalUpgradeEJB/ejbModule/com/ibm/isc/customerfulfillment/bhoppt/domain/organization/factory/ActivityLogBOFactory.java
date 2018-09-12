
 /* IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 * Created by Nomita as a part of Activity Log changes
 * Date 11th Jan 2011
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory;

import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ActivityLogBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/** 
 * This class is to Create, Update, Remove and Find ActivityLog entities.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * Created by Nomita as a part of Activity Log changes
 * Date 11th Jan 2011
 * 
 * revision date author reason 
 * 
 *
 */

public class ActivityLogBOFactory {
	private static final String CLASS_NAME = "ActivityLogBOFactory";

	
	/**
	 * @param activityLogBO
	 * @throws DomainException
	 */
	public void create(ActivityLogBO activityLogBO) throws DomainException {
		String methodName = "create";
		ActivityLogLocalHome activityLogLocalHome = getActivityLogLocalHome();
		ActivityLogLocal activityLogLocal = null;
		Date date =new java.sql.Date(System.currentTimeMillis());
		Time time =new Time(System.currentTimeMillis());
		

		try {
		
			//activityLogLocal = activityLogLocalHome.create("nchennam@in.ibm.com",new java.sql.Date(System.currentTimeMillis()),new Time(System.currentTimeMillis()));
			activityLogLocal = activityLogLocalHome.create(activityLogBO.getUserId(),date,time);
			activityLogLocal.setMessage(activityLogBO.getMessage());
			//activityLogLocal.setMessage(newMessage)(";
        		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

        	//	activityLogLocal.setMessage(activityLogBO.getMessage());
	}

	/** 
	 * find if User has touched the proposal in the past.  
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 *  
	 * 
	 * revision date author reason 
	 * 
	 
	 * 
	 */

	public List findActivityLogForUser(UserCustomDTO userCustomDTO) throws DomainException {
		boolean userAccessTheLog = true;
		ActivityLogLocalHome activityLogLocalHome = getActivityLogLocalHome();
		List activityLogList = new ArrayList();
		Collection activityLogCol = null;
    
		  System.out.println("Localhome "+getActivityLogLocalHome());
		try {
			activityLogCol = activityLogLocalHome.findAllActivities();
			}			
		catch (FinderException ex) {
			// left it blank for purpose. If null, it means that for this proposal, the user has not accessed it.
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0417); 
		}
		
		Iterator iter = activityLogCol.iterator();
		ActivityLogLocal activityLogLocal = null;

		while (iter.hasNext()) {
			ActivityLogBO activityLogBO = new ActivityLogBO();
			activityLogLocal = (ActivityLogLocal) iter.next();
			activityLogBO.setUserId(activityLogLocal.getUserId());
			activityLogBO.setMessage(activityLogLocal.getMessage());
			activityLogBO.setActivityDate(activityLogLocal.getActivityDate());
			activityLogBO.setActivityTime(activityLogLocal.getActivityTime());
			
			
			activityLogList.add(activityLogBO);
		}

		return activityLogList;

	}
	


	private ActivityLogLocalHome getActivityLogLocalHome() {
		return (ActivityLogLocalHome) HomeProvider.getLocal(HomeProvider.ACTIVITY_LOG_LOCAL_HOME);
	}

	
}
		