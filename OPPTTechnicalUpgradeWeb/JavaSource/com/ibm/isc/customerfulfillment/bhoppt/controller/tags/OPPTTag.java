/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.jsp.tagext.TagSupport;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br /><b>Known Bugs</b><br /> 
 * 
 * <br /><PRE> 
 * date Feb 5, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br /> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class OPPTTag extends TagSupport {
	/**
     * @param baseString
     * @param defaultValue
     * @return
     * @author thirumalai
     */
    protected String getValue(String baseString, String defaultValue) {
		if(null == baseString || 0 >= baseString.length()){
			if(null == defaultValue){
				baseString = "";  //$NON-NLS-1$
			}
			else{
				baseString = defaultValue;
			}
		}
		else{
			int index = baseString.indexOf("&");  //$NON-NLS-1$
			if(0 < index){
				StringBuffer buffer = new StringBuffer();
				buffer.append(baseString.substring(0, index+1));
				buffer.append("amp;");  //$NON-NLS-1$
				buffer.append(baseString.substring(index+1, baseString.length()));
				baseString = buffer.toString();
			}
		}
		return baseString;
	}

	/**
     * @param value1
     * @param value2
     * @param defaultValue
     * @return
     * @author thirumalai
     */
    protected String getValue(String value1, String value2, String defaultValue){
		String value = defaultValue;
		value1 = getValue(value1, "");  //$NON-NLS-1$
		value2 = getValue(value2, "");  //$NON-NLS-1$
		if(0 < value1.length()){
			if(0 < value2.length()){
				value = value1 +" / "+ value2;  //$NON-NLS-1$
			}
			else{
				value = value1;
			}
		}
		else{
			if(0 < value2.length()){
				value = value2;
			}
			else{
				value = defaultValue;
			}
		}
		return value;
	}
	
	/**
     * getDoubleValue
     * 
     * @param doubleValue
     * @param defaultValue
     * @return
     * @author thirumalai
     */
    protected String getDoubleValue(double doubleValue, String defaultValue) {
//		defaultValue = "0.00";
		String value = "";  //$NON-NLS-1$
//		if(0 != doubleValue){
			BigDecimal initialDouble = new BigDecimal((new Double(doubleValue)).toString());
		//	BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_DOWN);
		/*
		* This is a fix for display issue of rounding
		* Balaji 
		*/
		BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		value = scaledDouble.toString();
//		}
//		else{
//			if(null != defaultValue){
//				value = defaultValue;
//			}
//		}
		return value;
	}
	
	/**
     * getDateValue
     * 
     * @param date
     * @param defaultValue
     * @return
     * @author thirumalai
     */
    protected String getDateValue(Date date, String defaultValue){
		String dateValue = "";  //$NON-NLS-1$
		
		if(null == defaultValue){
			defaultValue = "";  //$NON-NLS-1$
		}
		if(null != date){
			OPPTCalender calender = new OPPTCalender();
			dateValue = calender.getDateString(date,true);
		}
		else{
			dateValue = defaultValue;
		}
		
		return dateValue;
	}
	
	/**
     * getValue
     * 
     * @param stringValue
     * @param length
     * @return
     * @author thirumalai
     */
    protected String getValue(String stringValue, int length){
		StringBuffer buffer = new StringBuffer();
		
		if(null != stringValue){
			char chars[] = stringValue.trim().toCharArray();
			for(int i=0, size=chars.length; i<size; i++){
				buffer.append(chars[i]);
				if(0 == (i+1)%length){
					if(size != (i+1)){
						buffer.append("<br />");  //$NON-NLS-1$
					}
				}
			}
		}
		
		return buffer.toString();
	}
}