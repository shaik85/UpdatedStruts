/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Copy Replacement Custom DTO  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 16, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class CopyReplacementCustomDTO extends OPPTCustomDTO
{
	private String newProposalName = null;
	private ReplaceContractCustomDTO replaceContractDTO = null;

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
	public CopyReplacementCustomDTO()
	{
	}

	/** 
	 * To get the new proposal name
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
	 * @return string
	 */
	public String getNewProposalName()
	{
		return newProposalName;
	}

	/** 
	 * To get the replace contract custom dto
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
	 * @return ReplaceContractCustomDTO
	 */
	public ReplaceContractCustomDTO getReplaceContractDTO()
	{
		return replaceContractDTO;
	}

	/** 
	 * To set the new proposal name
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
	 * @param lnewProposalName 
	 */
	public void setNewProposalName(String lnewProposalName)
	{
		newProposalName = lnewProposalName;
	}

	/** 
	 * To set the replace contract dto
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
	public void setReplaceContractDTO(ReplaceContractCustomDTO customDTO)
	{
		replaceContractDTO = customDTO;
	}

}
