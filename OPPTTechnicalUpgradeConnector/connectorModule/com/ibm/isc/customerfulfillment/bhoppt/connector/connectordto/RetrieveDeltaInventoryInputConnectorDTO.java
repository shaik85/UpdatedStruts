/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * DTO for retrieve delta inventory
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 2, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class RetrieveDeltaInventoryInputConnectorDTO implements ConnectorDTOInterface
{
	private String contractNumber;
	private String proposalContent;
	private List customerNumberList;

	private RetrieveInvenConnectorDTO retrieveInvenConnectorDTO;
	private OrgConnectorDTO orgConnectorDTO;
	private GenericConnectorDTO genericConnectorDTO;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public RetrieveDeltaInventoryInputConnectorDTO()
	{

	}

	/** 
	 * To get the contract number
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Contract Number 
	 */
	public String getContractNumber()
	{
		return contractNumber;
	}

	/** 
	 * To get the customer number list
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Customer Number List
	 */
	public List getCustomerNumberList()
	{
		return customerNumberList;
	}

	/** 
	 * To get the Generic Connector Data Transfer Object
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Generic Connector DTO 
	 */
	public GenericConnectorDTO getGenericConnectorDTO()
	{
		return genericConnectorDTO;
	}

	/** 
	 * To get the Org Connector Data Transfer Object 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Org ConnectorDTO
	 */
	public OrgConnectorDTO getOrgConnectorDTO()
	{
		return orgConnectorDTO;
	}

	/** 
	 * To get the Retrieve Inventory Connector Data Transfer Object
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RetrieveInvenConnetorDTO 
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
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  lcontractNumber
	 */
	public void setContractNumber(String lcontractNumber)
	{
		contractNumber = lcontractNumber;
	}

	/** 
	 * To set the customer number list
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lcustomerNumberList 
	 */
	public void setCustomerNumberList(List lcustomerNumberList)
	{
		customerNumberList = lcustomerNumberList;
	}

	/** 
	 * To set the generic connector dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
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
	 * To set the org connector dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
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
	 * To set the retrieve inventory connector dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
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
