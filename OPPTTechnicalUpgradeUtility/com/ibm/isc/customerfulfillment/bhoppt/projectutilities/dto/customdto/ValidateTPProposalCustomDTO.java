/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.ArrayList;
import java.util.List;

/**
 * To validate the TP  
 * 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 19, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class ValidateTPProposalCustomDTO extends OPPTCustomDTO
{
	private ProposalCustomDTO proposalDTO = null;
	private List swos = null;

	/** 
	 * Returns current proposal information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalCustomDTO
	 */
	public ProposalCustomDTO getProposalDTO()
	{
		return proposalDTO;
	}


	/**
     * Sets current proposal information
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 19, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param customDTO 
     */
	public void setProposalDTO(ProposalCustomDTO customDTO)
	{
		proposalDTO = customDTO;
	}
	
	/**
	 * Retuns compare tp swos collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getSwos() {
		return swos;
	}

	/**
	 * Sets compare to swos collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwos List 
	 */
	public void setSwos(List newSwos) {
		swos = newSwos;
	}
	
	/**
	 * add swos collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO
	 */
	
	public void addSwo(SWOTPCustomDTO customDTO){
		if(null != customDTO){
			if(null == swos){
				swos = new ArrayList();
			}
			swos.add(customDTO);
		}
	}
}
