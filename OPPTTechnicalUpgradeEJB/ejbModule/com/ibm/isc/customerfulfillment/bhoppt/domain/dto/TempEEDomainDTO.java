/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dto;
import java.sql.Date;

import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.TempEEBO;

/** 
 * This domain dto used to transfer the and store the values in 
 * TempEE table 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 22, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar J
 * @version 5.1A 
 */
public class TempEEDomainDTO extends OPPTDomainDTO {

	private String iSessionId;
	private int iProposalId;
	private int iCustomerId;
	private int iDmId;
	private int iSwoId;
	private int iEeId;
	private String iEeNo;
	private String iSalesDocNo;
	private String iSwoItemNo;
	private String iEeItemNo;
	private String iValueMetric;
	private String iLicenseType;
	private String iChargeOptionDesc;
	private String iUseLevel;
	private String iValidInd;
	private String iValueMetricType;
	private String iVm;
	private String iLcs;
	private String iCho;
	private String iUl;
	private String iDefaultFlag;

/**
 *  
 * Empty TempEEDomainDTOConstructor  
 * 
 * <br/><PRE> 
 * date Jan 22, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 *
 */	
public TempEEDomainDTO(){
		
}

/**
 *  
 * Constructor takes TempEEBO as argument 
 * Enter your description here. 
 * 
 * <br/><PRE> 
 * date Jan 22, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 *
 */
public TempEEDomainDTO(TempEEBO tempEEBO){
	
	iSessionId=tempEEBO.getSessionId();
	iProposalId=tempEEBO.getProposalId();
	iCustomerId=tempEEBO.getCustomerId();
	iDmId=tempEEBO.getDmId();
	iSwoId=tempEEBO.getSwoId();
	iEeId=tempEEBO.getEeId();
	iEeNo=tempEEBO.getEeNo();
	iSalesDocNo=tempEEBO.getSalesDocNo();
	iSwoItemNo=tempEEBO.getSwoItemNo();
	iEeItemNo=tempEEBO.getEeItemNo();
	iValueMetric=tempEEBO.getValueMetric();
	iLicenseType=tempEEBO.getLicenseType();
	iChargeOptionDesc=tempEEBO.getChargeOptionDesc();
	iUseLevel=tempEEBO.getUseLevel();
	iValidInd=tempEEBO.getValidInd();
	iValueMetricType=tempEEBO.getValueMetricType();
	iVm=tempEEBO.getVm();
	iLcs=tempEEBO.getLcs();
	iCho=tempEEBO.getCho();
	iUl=tempEEBO.getUl();
	iDefaultFlag=tempEEBO.getDefaultFlag();
}

/** 
 * Get the charge option 
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
 * @return iChargeOptionDesc
 */
public String getChargeOptionDesc() {
	return iChargeOptionDesc;
}

/** 
 * Get the Cho 
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
 * @return iCho
 */
public String getCho() {
	return iCho;
}

/** 
 * Get the customer id 
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
 * @return iCustomerId
 */
public int getCustomerId() {
	return iCustomerId;
}

/** 
 * Get the Default flag 
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
 * @return iDefaultFlag
 */
public String getDefaultFlag() {
	return iDefaultFlag;
}

/** 
 * Get the DM Id 
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
 * @return iDmId
 */
public int getDmId() {
	return iDmId;
}

/** 
 * Get the EE id 
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
 * @return iEeId
 */
public int getEeId() {
	return iEeId;
}

/** 
 * Get the EE Item No 
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
 * @return iEeItemNo
 */
public String getEeItemNo() {
	return iEeItemNo;
}

/** 
 * Get the EE No 
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
 * @return iEeNo
 */
public String getEeNo() {
	return iEeNo;
}

/** 
 * Get the LCS 
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
 * @return iLcs
 */
public String getLcs() {
	return iLcs;
}

/** 
 * Get the License type 
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
 * @return iLicenseType
 */
public String getLicenseType() {
	return iLicenseType;
}

/** 
 * Get the Proposal id 
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
 * @return iProposalId
 */
public int getProposalId() {
	return iProposalId;
}

/** 
 * Get the sales doc no 
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
 * @return iSalesDocNo
 */
public String getSalesDocNo() {
	return iSalesDocNo;
}

/** 
 *Get the Session id 
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
 * @return iSessionId
 */
public String getSessionId() {
	return iSessionId;
}

/** 
 * Get the SWO id 
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
 * @return iSwoId
 */
public int getSwoId() {
	return iSwoId;
}

/** 
 * Get the SWO Item No
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
 * @return iSwoItemNo
 */
public String getSwoItemNo() {
	return iSwoItemNo;
}

/** 
 * Get the Ul 
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
 * @return iUl
 */
public String getUl() {
	return iUl;
}

/** 
 * Get the Use Level 
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
 * @return iUseLevel
 */
public String getUseLevel() {
	return iUseLevel;
}

/** 
 * Get Valid Indicator 
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
 * @return iValidInd
 */
public String getValidInd() {
	return iValidInd;
}

/** 
 * Get the Value metric 
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
 * @return iValueMetric
 */
public String getValueMetric() {
	return iValueMetric;
}

/** 
 * Get the value metric type 
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
 * @return iValueMetricType
 */
public String getValueMetricType() {
	return iValueMetricType;
}

/** 
 * Get the VM 
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
 * @return iVm
 */
public String getVm() {
	return iVm;
}

/** 
 * Set the charge option desc 
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
 * @param chargeOptionDesc 
 */
public void setChargeOptionDesc(String chargeOptionDesc) {
	iChargeOptionDesc = chargeOptionDesc;
}

/** 
 * Set the CHO 
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
 * @param cho 
 */
public void setCho(String cho) {
	iCho = cho;
}

/** 
 * Set the Customer id 
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
 * @param customerId 
 */
public void setCustomerId(int customerId) {
	iCustomerId = customerId;
}

/** 
 * Set the Default flag 
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
 * @param defaultFlag 
 */
public void setDefaultFlag(String defaultFlag) {
	iDefaultFlag = defaultFlag;
}

/** 
 * Set the DM Id 
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
 * @param dmId
 */
public void setDmId(int dmId) {
	iDmId = dmId;
}

/** 
 * Set the EE ID 
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
 * @param eeId 
 */
public void setEeId(int eeId) {
	iEeId = eeId;
}

/** 
 * Set the EE Item No 
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
 * @param eeItemNo 
 */
public void setEeItemNo(String eeItemNo) {
	iEeItemNo = eeItemNo;
}

/** 
 * Set EE No 
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
 * @param eeNo 
 */
public void setEeNo(String eeNo) {
	iEeNo = eeNo;
}

/** 
 * Set the LCS 
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
 * @param lcs 
 */
public void setLcs(String lcs) {
	iLcs = lcs;
}

/** 
 *Set the License type 
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
 * @param licenseType 
 */
public void setLicenseType(String licenseType) {
	iLicenseType = licenseType;
}

/** 
 * Set the Proposal Id 
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
 * @param proposalId 
 */
public void setProposalId(int proposalId) {
	iProposalId = proposalId;
}

/** 
 * Set the Sales Doc No 
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
 * @param salesDocNo 
 */
public void setSalesDocNo(String salesDocNo) {
	iSalesDocNo = salesDocNo;
}

/** 
 * Set the Session Id 
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
 * @param sessionId 
 */
public void setSessionId(String sessionId) {
	iSessionId = sessionId;
}

/** 
 * Set the SWO Id 
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
 * @param swoId 
 */
public void setSwoId(int swoId) {
	iSwoId = swoId;
}

/** 
 * Set the SWO Item No 
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
 * @param swoItemNo 
 */
public void setSwoItemNo(String swoItemNo) {
	iSwoItemNo = swoItemNo;
}

/** 
 * Set the UL 
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
 * @param ul 
 */
public void setUl(String ul) {
	iUl = ul;
}

/** 
 * Set the Use Level 
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
 * @param useLevel 
 */
public void setUseLevel(String useLevel) {
	iUseLevel = useLevel;
}

/** 
 * Set the Valid Indicator 
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
 * @param validInd 
 */
public void setValidInd(String validInd) {
	iValidInd = validInd;
}

/** 
 * Set the Value metric 
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
 * @param valueMetric 
 */
public void setValueMetric(String valueMetric) {
	iValueMetric = valueMetric;
}

/** 
 * Set the Value metric type 
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
 * @param valueMetricType 
 */
public void setValueMetricType(String valueMetricType) {
	iValueMetricType = valueMetricType;
}

/** 
 * Set the VM 
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
 * @param vm 
 */
public void setVm(String vm) {
	iVm =vm;
}



}
