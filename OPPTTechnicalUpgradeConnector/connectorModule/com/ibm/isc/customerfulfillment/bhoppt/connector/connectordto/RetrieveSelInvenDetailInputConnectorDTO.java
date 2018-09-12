/*
 * Created on May 25, 2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/*
* IBM Confidential
*
* ©  Copyright IBM Corp. 2004, 2005  All Rights Reserved.

* The source code for this program is not published or otherwise divested of
* its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
*/
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RetrieveSelInvenDetailInputConnectorDTO implements ConnectorDTOInterface{
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
    private Map designatedMachineID; 
	private Map  materialID;
	private OrgConnectorDTO orgConnectorDTO;
	private GenericConnectorDTO genericConnectorDTO;
	
	public RetrieveSelInvenDetailInputConnectorDTO(){ }
	
	/**
	 * @return Returns the contractEndPeriod.
	 */
	public Date getContractEndPeriod() {
		return contractEndPeriod;
	}
	/**
	 * @param contractEndPeriod The contractEndPeriod to set.
	 */
	public void setContractEndPeriod(Date contractEndPeriod) {
		this.contractEndPeriod = contractEndPeriod;
	}
	/**
	 * @return Returns the contractNumber.
	 */
	public String getContractNumber() {
		return contractNumber;
	}
	/**
	 * @param contractNumber The contractNumber to set.
	 */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	/**
	 * @return Returns the contractStartPeriod.
	 */
	public Date getContractStartPeriod() {
		return contractStartPeriod;
	}
	/**
	 * @param contractStartPeriod The contractStartPeriod to set.
	 */
	public void setContractStartPeriod(Date contractStartPeriod) {
		this.contractStartPeriod = contractStartPeriod;
	}
	/**
	 * @return Returns the contractType.
	 */
	public String getContractType() {
		return contractType;
	}
	/**
	 * @param contractType The contractType to set.
	 */
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	/**
	 * @return Returns the currency.
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency The currency to set.
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * @return Returns the designatedMachineID.
	 */
	public Map getDesignatedMachineID() {
		return designatedMachineID;
	}
	/**
	 * @param designatedMachineID The designatedMachineID to set.
	 */
	public void setDesignatedMachineID(Map designatedMachineID) {
		this.designatedMachineID = designatedMachineID;
	}
	/**
	 * @return Returns the flag.
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag The flag to set.
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return Returns the genericConnectorDTO.
	 */
	public GenericConnectorDTO getGenericConnectorDTO() {
		return genericConnectorDTO;
	}
	/**
	 * @param genericConnectorDTO The genericConnectorDTO to set.
	 */
	public void setGenericConnectorDTO(GenericConnectorDTO genericConnectorDTO) {
		this.genericConnectorDTO = genericConnectorDTO;
	}
	/**
	 * @return Returns the lastFetchDate.
	 */
	public Date getLastFetchDate() {
		return lastFetchDate;
	}
	/**
	 * @param lastFetchDate The lastFetchDate to set.
	 */
	public void setLastFetchDate(Date lastFetchDate) {
		this.lastFetchDate = lastFetchDate;
	}
	/**
	 * @return Returns the lastFetchTime.
	 */
	public Time getLastFetchTime() {
		return lastFetchTime;
	}
	/**
	 * @param lastFetchTime The lastFetchTime to set.
	 */
	public void setLastFetchTime(Time lastFetchTime) {
		this.lastFetchTime = lastFetchTime;
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
	 * @return Returns the orgConnectorDTO.
	 */
	public OrgConnectorDTO getOrgConnectorDTO() {
		return orgConnectorDTO;
	}
	/**
	 * @param orgConnectorDTO The orgConnectorDTO to set.
	 */
	public void setOrgConnectorDTO(OrgConnectorDTO orgConnectorDTO) {
		this.orgConnectorDTO = orgConnectorDTO;
	}
	/**
	 * @return Returns the proposalContent.
	 */
	public String getProposalContent() {
		return proposalContent;
	}
	/**
	 * @param proposalContent The proposalContent to set.
	 */
	public void setProposalContent(String proposalContent) {
		this.proposalContent = proposalContent;
	}
	/**
	 * @return Returns the proposalType.
	 */
	public String getProposalType() {
		return proposalType;
	}
	/**
	 * @param proposalType The proposalType to set.
	 */
	public void setProposalType(String proposalType) {
		this.proposalType = proposalType;
	}
	/**
	 * @return Returns the customerNumberList.
	 */
	public List getCustomerNumber() {
		return customerNumberList;
	}
	/**
	 * @param customerNumberList The customerNumberList to set.
	 */
	public void setCustomerNumber(List customerNumberList) {
		this.customerNumberList = customerNumberList;
	}
}
