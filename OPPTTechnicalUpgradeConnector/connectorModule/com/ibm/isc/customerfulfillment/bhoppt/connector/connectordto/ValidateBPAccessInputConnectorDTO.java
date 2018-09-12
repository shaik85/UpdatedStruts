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
public class ValidateBPAccessInputConnectorDTO 	implements ConnectorDTOInterface 
{
	private String salesOrg = null;
	private String accessOption = null;
	private String [] custListNo;  
	private GenericConnectorDTO genericConnectorDTO;  
	private List custListAndSeqConnectorDTO;
	
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
	public ValidateBPAccessInputConnectorDTO() 
	{
	
	}
	/** 
	 * To get the Generic ConnectorDTO
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
	 * @return GenericConnectorDTO
	 */
	public GenericConnectorDTO getGenericConnectorDTO()
	{
		return genericConnectorDTO;
	}
	/** 
	 * To get the Sales Org 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Sales Org
	 */
	public String getSalesOrg()
	{
		return salesOrg;
	}
	/** 
	 * To get the Access Option 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Access Option 
	 */
	public String getAccessOption()
	{
		return accessOption;
	}
	/** 
	 * To get the Sales Org 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Customer List
	 */
	public String[] getCustListNo()
	{
		return custListNo;
	}
	/** 
	 * To get the Sales Org 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param newSalesOrg
	 */
	public void setSalesOrg(String newSalesOrg)
	{
		salesOrg = newSalesOrg;
	}
	/** 
	 * To get the Sales Org 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAccessOption
	 */
	public void setAccessOption(String newAccessOption)
	{
		accessOption = newAccessOption;
	}
	/** 
	 * To get the Sales Org 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustListNo
	 */
	public void setCustListNo(String[] newCustListNo)
	{
		custListNo = newCustListNo;
	}
	/** 
	 * To set the Generic ConnectorDTO
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
	 * @param connectorDTO 
	 */
	public void setGenericConnectorDTO(GenericConnectorDTO connectorDTO)
	{
		genericConnectorDTO = connectorDTO;
	}
	/** 
	 * To get the CustListAndSeqConnectorDTO
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustListAndSeqConnectorDTO
	 */
	public List getCustListAndSeqConnectorDTO()
	{
		return custListAndSeqConnectorDTO;
	}
	/** 
	 * To set the Generic ConnectorDTO
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
	 * @param connectorDTO 
	 */
	public void setCustListAndSeqConnectorDTO(List connectorDTO)
	{
		custListAndSeqConnectorDTO = connectorDTO;
	}
}
