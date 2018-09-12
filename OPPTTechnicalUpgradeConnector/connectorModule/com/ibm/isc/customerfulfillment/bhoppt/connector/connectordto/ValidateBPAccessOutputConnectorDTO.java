/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class ValidateBPAccessOutputConnectorDTO implements ConnectorDTOInterface 
{
	private String returnCode;
	private String [] invalidCustListNo;
	private List custListAndSeqConnectorDTO;
	private String customername;
	/** 
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public ValidateBPAccessOutputConnectorDTO() 
	{
		
	}
	/** 
	 * To get the Return code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Return code
	 */
	public String getReturnCode()
	{
		return returnCode;
	}
	/** 
	 * To set the return code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aReturnCode
	 */
	public void setReturnCode(String aReturnCode)
	{
		returnCode = aReturnCode;
	}
	/** 
	 * To get the InvalidCustListNo
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public String[] getInvalidCustListNo()
	{
		return invalidCustListNo;
	}
	/** 
	 * To set the InvalidCustListNo
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param list
	 */
	public void setInvalidCustListNo(String[] list)
	{
		invalidCustListNo = list;
	}
	/** 
	 * To get the InvalidCustListNo
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getCustListAndSeqConnectorDTO()
	{
		return custListAndSeqConnectorDTO;
	}
	/** 
	 * To set the InvalidCustListNo
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list
	 */
	public void setCustListAndSeqConnectorDTO(List list)
	{
		custListAndSeqConnectorDTO = list;
	}
	/** 
	 * To get the Customer Name
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Return code
	 */
	public String getCustomerName()
	{
		return customername;
	}
	/** 
	 * To set the Customer Name
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newString 
	 */
	public void setCustomerName(String newString)
	{
		customername = newString;
	}
}
