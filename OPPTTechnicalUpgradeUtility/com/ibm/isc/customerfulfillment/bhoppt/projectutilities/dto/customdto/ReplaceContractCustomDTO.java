/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;

/**
 *  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham K Mani
 * @version 5.1A
 */
public class ReplaceContractCustomDTO extends ContractInfoCustomDTO
{
	private Date contractReplacementDate = null;
	private ContractCustomDTO contractDTO = null;
	
	/* start change CR6153*/
	private String iSandsExtendPeriod = null;
	private String proposalContent = null;
	private Date contractStartDate = null;
	private Date contractEndDate = null;	
	/* end change CR6153*/	

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public ReplaceContractCustomDTO()
	{
	}

	/** 
	 * To get the contract dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return contract dto 
	 */
	public ContractCustomDTO getContractDTO()
	{
		return contractDTO;
	}

	/** 
	 * To get the contract replacement date
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return contract replacement date 
	 */
	public Date getContractReplacementDate()
	{
		return contractReplacementDate;
	}

	/** 
	 * To set the contract dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO 
	 */
	public void setContractDTO(ContractCustomDTO customDTO)
	{
		contractDTO = customDTO;
	}

	/** 
	 * To set the contract replacement date
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date 
	 */
	public void setContractReplacementDate(Date date)
	{
		contractReplacementDate = date;
	}
	
	/* start change CR6153*/
	/**
	 * @return Returns the iSandsExtendPeriod.
	 */
	public String isISandsExtendPeriod() {
		return iSandsExtendPeriod;
	}
	/**
	 * @param sandsExtendPeriod The iSandsExtendPeriod to set.
	 */
	public void setISandsExtendPeriod(String sandsExtendPeriod) {
		iSandsExtendPeriod = sandsExtendPeriod;
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
	 * @return Returns the contractEndDate.
	 */
	public Date getContractEndDate() {
		return contractEndDate;
	}
	/**
	 * @param contractEndDate The contractEndDate to set.
	 */
	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	/**
	 * @return Returns the contractStartDate.
	 */
	public Date getContractStartDate() {
		return contractStartDate;
	}
	/**
	 * @param contractStartDate The contractStartDate to set.
	 */
	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	
	/* end change CR6153*/	
	
}
