/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;


/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class EditSWODataBean extends OPPTDataBean{
	private String alternatePrice = "";  //$NON-NLS-1$
	private DateDataBean planStartDate = null;
	private DateDataBean planEndDate = null;
	
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
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getAlternatePrice() {
		return alternatePrice;
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
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public DateDataBean getPlanEndDate() {
		if(null == planEndDate){
			planEndDate = new DateDataBean();
		}
		return planEndDate;
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
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public DateDataBean getPlanStartDate() {
		if(null == planStartDate){
			planStartDate = new DateDataBean();
		}
		return planStartDate;
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
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAlternatePrice String
	 */
	public void setAlternatePrice(String newAlternatePrice) {
		alternatePrice = newAlternatePrice;
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
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bean 
	 */
	public void setPlanEndDate(DateDataBean bean) {
		planEndDate = bean;
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
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bean 
	 */
	public void setPlanStartDate(DateDataBean bean) {
		planStartDate = bean;
	}

//	public ErrorReport validate() {
//		ErrorReport errorReport = new ErrorReport();
//		
//		try{
//			if(!isFieldEmpty(getAlternatePrice())){
//				double doubleValue = Double.parseDouble(getAlternatePrice());
//				if(doubleValue < 0){
//					errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF106, OPPTMessageCatalog.TYPE_PRESENTATION), null);
//				}
//			}
//		}
//		catch(Exception e){
//			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA30, OPPTMessageCatalog.TYPE_PRESENTATION), null);
//		}
//		
//		return errorReport;
//	}
	
	/**
     * reset
     * 
     * @author thirumalai
     */
    public void reset(){
		alternatePrice = "";  //$NON-NLS-1$
		planStartDate = null;
		planEndDate = null;
	}

	/**
     * toString
     *  
     * @see java.lang.Object#toString()
     * @author thirumalai
     */
    public String toString(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("[EditSWODataBean] - [toString] - ");  //$NON-NLS-1$
		buffer.append("[Alternate price: "+alternatePrice+"] - ");  //$NON-NLS-1$  //$NON-NLS-2$
		buffer.append("[Plan start date: "+planStartDate+"] - ");  //$NON-NLS-1$  //$NON-NLS-2$
		buffer.append("[Plan end date: "+planEndDate+"]");  //$NON-NLS-1$  //$NON-NLS-2$
		
		return buffer.toString();
	}
}
