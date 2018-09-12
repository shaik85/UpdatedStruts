/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * DTO for retrieve inventory details  
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
public class RetrieveInvenDetailInputConnectorDTO implements ConnectorDTOInterface
{
	private String proposalType;
	private String flag;
	private String currency;

	private Date contractStartPeriod;
	private Date contractEndPeriod;
	private Date lastFetchDate;
	private Time lastFetchTime;
	private String contractType;

	private String contractNumber;
	private List customerNumberList;
	private String proposalContent;
	private Map designatedMaterialID;
	private Map materialID;
	private Map serialNumber;
    private List selCustomerList;
    private boolean selectedInventory=false;
    
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
	public RetrieveInvenDetailInputConnectorDTO()
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
	 * To get the customer number
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
	 * @return Customer Number 
	 */
	public List getCustomerNumber()
	{
		return customerNumberList;
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
	 * To set the customer number
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
	 * @param customerNumber 
	 */
	public void setCustomerNumber(List customerNumber)
	{
		customerNumberList = customerNumber;
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
	 * To get the contract end date
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
	 * @return Contract end date 
	 */
	public Date getContractEndPeriod()
	{
		return contractEndPeriod;
	}

	/** 
	 * To get the contract start date
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
	 * @return Contract Start Date 
	 */
	public Date getContractStartPeriod()
	{
		return contractStartPeriod;
	}

	/** 
	 * To get the contract type
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
	 * @return Contract Type 
	 */
	public String getContractType()
	{
		return contractType;
	}

	/** 
	 * To get the currency
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
	 * @return Currency 
	 */
	public String getCurrency()
	{
		return currency;
	}

	/** 
	 * To get the flag
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
	 * @return flag value 
	 */
	public String getFlag()
	{
		return flag;
	}

	/** 
	 * To get the last fetch date
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
	 * @return Last fetch date 
	 */
	public Date getLastFetchDate()
	{
		return lastFetchDate;
	}

	/** 
	 * To get the last fetch time
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
	 * @return Last fetch time
	 */
	public Time getLastFetchTime()
	{
		return lastFetchTime;
	}

	/** 
	 * To get the proposal type
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
	 * @return Proposal type 
	 */
	public String getProposalType()
	{
		return proposalType;
	}

	/** 
	 * To set the contract end date
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
	 * @param date 
	 */
	public void setContractEndPeriod(Date date)
	{
		contractEndPeriod = date;
	}

	/** 
	 * To set the contract start date
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
	 * @param date 
	 */
	public void setContractStartPeriod(Date date)
	{
		contractStartPeriod = date;
	}

	/** 
	 * To set the contract type
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
	 * @param lcontractType 
	 */
	public void setContractType(String lcontractType)
	{
		contractType = lcontractType;
	}

	/** 
	 * To set the currency
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
	 * @param lcurrency 
	 */
	public void setCurrency(String lcurrency)
	{
		currency = lcurrency;
	}

	/** 
	 * To set the flag value
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
	 * @param lflag 
	 */
	public void setFlag(String lflag)
	{
		flag = lflag;
	}

	/** 
	 * To set the last fetch date
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
	 * date Dec 2, 2003 
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
	 * To set the proposal type
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
	 * @param lproposalType 
	 */
	public void setProposalType(String lproposalType)
	{
		proposalType = lproposalType;
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

	/**
	 * @return Returns the designatedMaterialID.
	 */
	public Map getDesignatedMaterialID() {
		return designatedMaterialID;
	}
	/**
	 * @param designatedMaterialID The designatedMaterialID to set.
	 */
	public void setDesignatedMaterialID(Map designatedMaterialID) {
		this.designatedMaterialID = designatedMaterialID;
	}
	/**
	 * @return Returns the materialID.
	 */
	public Map getMaterialID() {
		return materialID;
	}
	/**
	 * @param materialID The materialID to set.
	 */
	public void setMaterialID(Map materialID) {
		this.materialID = materialID;
	}
	/**
	 * @return Returns the selCustomerList.
	 */
	public List getSelCustomerList() {
		return selCustomerList;
	}
	/**
	 * @param selCustomerList The selCustomerList to set.
	 */
	public void setSelCustomerList(List selCustomerList) {
		this.selCustomerList = selCustomerList;
	}
	/**
	 * @return Returns the serialNumber.
	 */
	public Map getSerialNumber() {
		return serialNumber;
	}
	/**
	 * @param serialNumber The serialNumber to set.
	 */
	public void setSerialNumber(Map serialNumber) {
		this.serialNumber = serialNumber;
	}
	/**
	 * @return Returns the selectedInventory.
	 */
	public boolean isSelectedInventory() {
		return selectedInventory;
	}
	/**
	 * @param selectedInventory The selectedInventory to set.
	 */
	public void setSelectedInventory(boolean selectedInventory) {
		this.selectedInventory = selectedInventory;
	}
}
