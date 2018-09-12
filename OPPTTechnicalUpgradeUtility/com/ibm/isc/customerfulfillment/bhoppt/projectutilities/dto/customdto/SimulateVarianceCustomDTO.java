/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;

/**
 * Custom dto that holds data required for simulate variance  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 15, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class SimulateVarianceCustomDTO extends ContractInfoCustomDTO 
{
	private ContractCustomDTO contractDTO = null;
	private Date varianceDate = null;
	private boolean includeQuotes = false;
	
	/**
	 * Returns contract dto on which the simulate variance is applied 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ContractCustomDTO
	 */
	public ContractCustomDTO getContractDTO() {
		return contractDTO;
	}

	/**
	 * Returns include quotes flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isIncludeQuotes() {
		return includeQuotes;
	}

	/**
	 * Returns variance date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getVarianceDate() {
		return varianceDate;
	}

	/**
	 * Sets contract dto on which the simulate variance is applied 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractDTO ContractCustomDTO 
	 */
	public void setContractDTO(ContractCustomDTO newContractDTO) {
		contractDTO = newContractDTO;
	}

	/**
	 * Sets include quotes flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newIncludeQuotes boolean
	 */
	public void setIncludeQuotes(boolean newIncludeQuotes) {
		includeQuotes = newIncludeQuotes;
	}

	/**
	 * Sets variance date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVarianceDate Date 
	 */
	public void setVarianceDate(Date newVarianceDate) {
		varianceDate = newVarianceDate;
	}
	
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalName String
	 * @param proposalType String
	 * @param contractType String
	 * @param contractNumber String
	 * @param externalContractNumber String
	 * @param contractPeriodStartDate Date
	 * @param contractPeriodEndDate Date
	 * @param ivarianceDate Date
	 * @param iincludeQuiotes boolean
	 * @param icontract ContractCustomDTO
	 */
	public void setData(String proposalName, String proposalType, String contractType,
						String contractNumber, String externalContractNumber, 
						Date contractPeriodStartDate, Date contractPeriodEndDate, Date ivarianceDate, 
						boolean iincludeQuiotes, ContractCustomDTO icontract){
		super.setData(proposalName, proposalType, contractType, contractNumber, externalContractNumber, contractPeriodStartDate, contractPeriodEndDate);
		setVarianceDate(ivarianceDate);
		setIncludeQuotes(iincludeQuiotes);
		setContractDTO(icontract);
	}
}
