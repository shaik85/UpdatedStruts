/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;



/** 
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 11, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class SAndSPlanningCustomDTO extends OPPTCustomDTO {
	
	private ProposalCustomDTO proposal = null;
	private SAndSEECustomDTO selectedEE [];
	private double sAndSDiscount;

	/** 
	 * get the data	
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public ProposalCustomDTO getProposal() {
		return proposal;
	}

	/** 
	 *get the data 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getSAndSDiscount() {
		return sAndSDiscount;
	}

	/** 
	 * get the data	 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public SAndSEECustomDTO[] getSelectedEE() {
		return selectedEE;
	}

	/** 
	 * set the data
	* <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO 
	 */
	public void setProposal(ProposalCustomDTO customDTO) {
		proposal = customDTO;
	}

	/** 
	* set the data
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setSAndSDiscount(double d) {
		sAndSDiscount = d;
	}

	/** 
	 * set the data	
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 11, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTOs 
	 */
	public void setSelectedEE(SAndSEECustomDTO[] customDTOs) {
		selectedEE = customDTOs;
	}

}

