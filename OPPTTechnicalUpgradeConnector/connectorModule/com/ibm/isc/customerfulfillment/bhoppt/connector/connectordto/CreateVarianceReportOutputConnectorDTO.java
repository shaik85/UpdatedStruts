/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/** 
 * Create Variance Report Output Connector DTO
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 16, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Venkat
 * @version 5.1A 
 */
public class CreateVarianceReportOutputConnectorDTO implements ConnectorDTOInterface {

	private String returnCode;
	/**
	 *  
	 * Constructor
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Venkat
	 * @version 5.1A
	 */
	public CreateVarianceReportOutputConnectorDTO(){
	}
	/**
	 * To get the Return Code
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Return Code
	 */
	public String getReturnCode()
	{
		return returnCode;
	}
	/**
	 * To Set the Return Code 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lreturnCode
	 */
	public void setReturnCode(String lreturnCode){
		returnCode = lreturnCode;
	}

}
