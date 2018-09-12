/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dm.bo;

import java.sql.Date;
import java.util.HashMap;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/** 
 * This class checks the business condition against dmbdo attributes* 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A 
 */
public class DMBO extends DMBDO {

	private ErrorReport ierrorReport=new ErrorReport();
	
	/**
	 *  
	 * This method validates the Copy Bump for the DM 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param type
	 * @param values
	 * @throws DomainException
	 */
	public void validateDMForCopyBump(int type,HashMap values)throws DomainException{
		boolean result=false;
		Date bumpStartDate=(Date)values.get(UtilityConstants.PLAN_START_DATE);
		Date bumpEndDate=(Date)values.get(UtilityConstants.PLAN_END_DATE);
		Date planStartDate=getPlanStartDate();
		Date planEndDate=getPlanEndDate();
		OPPTCalender calender=new OPPTCalender();
				
		if((calender.isDateEqual(bumpStartDate, planStartDate) || calender.isDateGreater(bumpStartDate, planStartDate)) && (calender.isDateLesser(bumpStartDate, planEndDate)) && (calender.isDateLesser(bumpStartDate, bumpEndDate)) && (calender.isDateEqual(bumpEndDate, planEndDate)|| calender.isDateLesser(bumpEndDate, planEndDate))) {
				result = true;
		}else{
				ExceptionGenerator.addErrorEntry(ierrorReport,ErrorCodeConstants.DE0110,OPPTMessageCatalog.TYPE_DOMAIN);
				DomainException d=new DomainException();
				d.setErrorReport(ierrorReport);
				throw d;
			
			}
	}

}
