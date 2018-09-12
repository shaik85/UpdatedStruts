/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * Action form to be used for swo details screen.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date May 27, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class SWODetailsActionForm extends OPPTActionForm {
	private String[] alternatePrices = null;
	private String[] discount = null;
	private String[] eeIds = null;

	/**
	 * Returns the collection of alternate prices 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double[]
	 */
	public String[] getAlternatePrices() {
		return alternatePrices;
	}

	/** 
	 * Returns the collection of ee ids
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String[]
	 */
	public String[] getEeIds() {
		return eeIds;
	}

	/**
	 * Sets alternate prices collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAlternatePrices double[] 
	 */
	public void setAlternatePrices(String[] newAlternatePrices) {
		alternatePrices = newAlternatePrices;
	}

	/**
	 * Sets ee ids collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEEIds String[]
	 */
	public void setEeIds(String[] newEEIds) {
		eeIds = newEEIds;
	}

	public void reset(){
		alternatePrices = null;
		eeIds = null;
	}
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String[] getDiscount() {
		return discount;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ds 
	 */
	public void setDiscount(String[] ds) {
		discount = ds;
	}
	
	public ErrorReport validate() {
		System.out.println("SWODetailsActionForm.validate1()");
		ErrorReport errorReport = new ErrorReport();
		String discountCheck=null;
		String alternatePriceCheck = null;
		
		if(null != getDiscount()){
			System.out.println("SWODetailsActionForm.validate1+()");
			int length = getDiscount().length;
			for(int i=0; i< length; i++){
				discountCheck = validateValue(getDiscount()[i], true);
				if(null != discountCheck){
					errorReport.put(new ErrorKey(discountCheck, OPPTMessageCatalog.TYPE_PRESENTATION),null);
					break;
				}
			}
		}
		
		if(null != getAlternatePrices()){
			System.out.println("SWODetailsActionForm.validate2()");
			int length = getAlternatePrices().length;
			for(int i=0; i< length; i++){
				alternatePriceCheck = validateValue(getAlternatePrices()[i], false);
				if(null != alternatePriceCheck){
					errorReport.put(new ErrorKey(alternatePriceCheck, OPPTMessageCatalog.TYPE_PRESENTATION),null);
					break;
				}
			}
		}
		
		return errorReport;
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 31, 2004 
	 * 
	 * revision date author reason
 	 * 31/05/2004    Vinod 	Added as part of MN19387428 - CMVCDEFECT 351 for checking empty value
 	 * 						for the alternate price entered.
  	 * 
	 * </PRE><br> 
	 * 
	 * @param discountValue
	 * @param checkPercent
	 * @return
	 */
	private String validateValue(String discountValue, boolean checkPercent){
		System.out.println("SWODetailsActionForm.validateValue()");
		String result = null;
		
		if(null != discountValue && 0 < discountValue.trim().length()){
			System.out.println("SWODetailsActionForm.validateValue()1");
			try{
				double discount = Double.parseDouble(discountValue);
			
				if(0 > discount){
					if(checkPercent){
						result = ErrorCodeConstants.PAF107;
					}
					else{
						result = ErrorCodeConstants.PAF106;
					}
				}
				else{
					if(checkPercent && 100 <= discount){
						result = ErrorCodeConstants.PAF80;
					}

					if(checkPercent && -1 != discountValue.indexOf(".")){
						int afterDecimal = discountValue.length() - discountValue.indexOf(".");
						if(3 < afterDecimal){
							result = ErrorCodeConstants.PAF81;
						}
					}
				}
			}
			catch(NumberFormatException ex){
				if(true ==  checkPercent){
					result = ErrorCodeConstants.PAF79;
				}
				else{
					result = ErrorCodeConstants.PAF104;
				}
			
			}
		}
		
		return result; 
	}
}