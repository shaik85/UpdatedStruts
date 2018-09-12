/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;


/**
 * To retrieve the Inventory details  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */

public class RetrieveIneligInvenDetailInputConnectorDTO implements ConnectorDTOInterface
{
	private Date lastFetchDate;
	private Time lastFetchTime;
	private String contractType;
	private String contractNumber;
	private List customerNumberList;
	private String proposalContent;
	
	private RetrieveInvenConnectorDTO retrieveInvenConnectorDTO;
	private OrgConnectorDTO orgConnectorDTO;
	private GenericConnectorDTO genericConnectorDTO;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public RetrieveIneligInvenDetailInputConnectorDTO()
	{

	}
	/** 
	 * To get the contract number
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
	 * @return Contract number
	 */
	public String getContractNumber()
	{
		return contractNumber;
	}

	/** 
	 * To get the Contract Type
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
	 * @return Contract Type 
	 */
	public String getContractType()
	{
		return contractType;
	}

	/** 
	 * To get the Customer Number
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
	 * @return 
	 */
	public List getCustomerNumber()
	{
		return customerNumberList;
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
	 * To get the Last Fetch Date 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Last Fetch Date
	 */
	public Date getLastFetchDate()
	{
		return lastFetchDate;
	}

	/** 
	 * To get the Last Fetch Time
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
	 * @return Last Fetch Time
	 */
	public Time getLastFetchTime()
	{
		return lastFetchTime;
	}

	/** 
	 * To get the OrgConnectorDTO
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
	 * @return OrgConnectorDTO
	 */
	public OrgConnectorDTO getOrgConnectorDTO()
	{
		return orgConnectorDTO;
	}

	/** 
	 * To get the RetrieveInvenConnectorDTO
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
	 * @return RetrieveInvenConnectorDTO 
	 */
	public RetrieveInvenConnectorDTO getRetrieveInvenConnectorDTO()
	{
		return retrieveInvenConnectorDTO;
	}

	/** 
	 * To set the contract number
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
	 * @param lcontractNumber
	 */
	public void setContractNumber(String lcontractNumber)
	{
		contractNumber = lcontractNumber;
	}

	/** 
	 * To set the contract type
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
	 * @param lcontractType 
	 */
	public void setContractType(String lcontractType)
	{
		contractType = lcontractType;
	}

	/** 
	 * To set the customer number
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
	 * @param customerNumber 
	 */
	public void setCustomerNumber(List customerNumber)
	{
		customerNumberList = customerNumber;
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
	 * To set the last fetch date
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
	 * @param date
	 */
	public void setLastFetchDate(Date date)
	{
		lastFetchDate = date;
	}

	/** 
	 * To set the last fetch time
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
	 * @param time 
	 */
	public void setLastFetchTime(Time time)
	{
		lastFetchTime = time;
	}

	/** 
	 * To set the OrgConnectorDTO
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
	public void setOrgConnectorDTO(OrgConnectorDTO connectorDTO)
	{
		orgConnectorDTO = connectorDTO;
	}

	/** 
	 * To set the RetrieveInvenConnectorDTO
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
	public void setRetrieveInvenConnectorDTO(RetrieveInvenConnectorDTO connectorDTO)
	{
		retrieveInvenConnectorDTO = connectorDTO;
	}
	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getProposalContent() {
		return proposalContent;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setProposalContent(String string) {
		proposalContent = string;
	}

}
