/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

import java.util.Date;

/** 
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
public class CreateVarianceReportInputConnectorDTO implements ConnectorDTOInterface {
	private String salesOrg;
	private String externalContractNumber;
	private String proposalType;
	private Date contractPeriodStartDate;
	private Date contractPeriodEndDate;
	private String capAmount;
	private String legacyCustomerNo;
	private String addressSequenceNo;
	private Date varianceDate;
	private String indicatorVarType;
	private String indicatorQuoteIncluded;
	private GenericConnectorDTO genericConnectorDTO;
	
	/**
	 * 
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public CreateVarianceReportInputConnectorDTO(){

	}
	
	/**
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
	 * @return
	 */
	public String getSalesOrg(){
	 return salesOrg;	
	}
	/**
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
	 * @return
	 */
	
	public String getExternalContractNumber(){
		 return externalContractNumber;	
	}
	
	/**
	 *  
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
	 * @return
	 */
	public String getProposalType(){
		 return proposalType;	
	}
	
	/**
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
	 * @return
	 */
	public Date getContractPeriodStartDate(){
		 return contractPeriodStartDate;	
	}
	/**
	 * 
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
	 * @return
	 */
	public Date getContractPeriodEndDate(){
		 return contractPeriodEndDate;	
	}
		
	/**
	 *  
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
	 * @return
	 */		
	public String getCapAmount(){
		 return capAmount;	
	}
	
	/**
	 *  
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
	 * @return
	 */
	public String getLegacyCustomerNo(){
		 return legacyCustomerNo;	
	}
	
	/**
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
	 * @return
	 */
	public String getAddressSequenceNo(){
		 return addressSequenceNo;	
	}
	/**
	 *  
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
	 * @return
	 */
	public Date getVarianceDate(){
		 return varianceDate;	
	}
	
	/**
	   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public String getIndicatorVarType(){
		return indicatorVarType;	
	}
	
	/**
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
	 * @return
	 */
	public String getIndicatorQuoteIncluded(){
		return indicatorQuoteIncluded;	
	}

	/**
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
	 * @return
	 */
	public GenericConnectorDTO getGenericConnectorDTO(){
		return genericConnectorDTO;	
	}
	
	/**
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
	 * @param lsalesOrg
	 */
	public void setSalesOrg(String lsalesOrg){
		salesOrg = lsalesOrg;
	}
	
	/**
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
	 * @param lexternalContractNumber
	 */
	public void setExternalContractNumber(String lexternalContractNumber){
		externalContractNumber = lexternalContractNumber;
	}
	
	/**
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
	 * @param lproposalType
	 */
	public void setProposalType(String lproposalType){
		proposalType = lproposalType;
	}
	
	/**
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
	 * @param lcontractPeriodStartDate
	 */
	public void setContractPeriodStartDate(Date lcontractPeriodStartDate){
		contractPeriodStartDate = lcontractPeriodStartDate;
	}
	/**
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
	 * @param lcontractPeriodEndDate
	 */
	public void setContractPeriodEndDate(Date lcontractPeriodEndDate){
		contractPeriodEndDate = lcontractPeriodEndDate;
	}
	
	/**
	 *  
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
	 * @param lcapAmount
	 */
	public void setCapAmount(String lcapAmount){
		capAmount = lcapAmount;
	}
	
	/**
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
	 * @param llegacyCustomerNo
	 */
	public void setLegacyCustomerNo(String llegacyCustomerNo){
		legacyCustomerNo = llegacyCustomerNo;
	}
	
	/**
	 *  
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
	 * @param laddressSequenceNo
	 */
	public void setAddressSequenceNo(String laddressSequenceNo){
		addressSequenceNo = laddressSequenceNo;
	}
	
	/**
	 *  
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
	 * @param lvarianceDate
	 */
	public void setVarianceDate(Date lvarianceDate){
		varianceDate = lvarianceDate;
	}
	
	/**
	 *  
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
	 * @param lindicatorVarType
	 */
	public void setIndicatorVarType(String lindicatorVarType){
		indicatorVarType = lindicatorVarType;
	}
	
	/**
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
	 * @param lindicatorQuoteIncluded
	 */
	public void setIndicatorQuoteIncluded(String lindicatorQuoteIncluded){
	    indicatorQuoteIncluded = lindicatorQuoteIncluded;
	}
	
	/**
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
	 * @param connectorDTO
	 */
	public void setGenericConnectorDTO(GenericConnectorDTO connectorDTO){
			genericConnectorDTO = connectorDTO;
	}
	

}
