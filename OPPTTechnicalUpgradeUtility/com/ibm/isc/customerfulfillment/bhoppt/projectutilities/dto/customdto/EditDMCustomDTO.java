/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;
import java.util.List;

/**
 * Custom dto that holds information required for edited a dm  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 21, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class EditDMCustomDTO extends OPPTCustomDTO 
{
	private ProposalCustomDTO proposal;

	private DMCustomDTO selectedDM = null;
	private ESWCustomerCustomDTO customer = null;

	private Date editPlanStartDate = null;
	private Date editPlanEndDate = null;

	private List startYears = null;
	private List endYears = null;
	/**
	 * Returns customer to which the selected dm belongs to 
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
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getCustomer() {
		return customer;
	}

	/**
	 * Returns edited plan end date value 
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
	 * @return Date
	 */
	public Date getEditPlanEndDate() {
		return editPlanEndDate;
	}

	/**
	 * Returns edited plan start date value 
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
	 * @return Date
	 */
	public Date getEditPlanStartDate() {
		return editPlanStartDate;
	}

	/**
	 * Returns proposal to which the dm belongs to 
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
	 * @return ProposalCustomDTO
	 */
	public ProposalCustomDTO getProposal() {
		return proposal;
	}

	/**
	 * Returns selected dm information 
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
	 * @return DMCustomDTO
	 */
	public DMCustomDTO getSelectedDM() {
		return selectedDM;
	}

	/**
	 * Sets the customer information to which the dm belongs to 
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
	 * @param newCustomer 
	 */
	public void setCustomer(ESWCustomerCustomDTO newCustomer) {
		customer = newCustomer;
	}

	/**
	 * Sets edited plan end date value 
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
	 * @param newEditPlanEndDate  
	 */
	public void setEditPlanEndDate(Date newEditPlanEndDate) {
		editPlanEndDate = newEditPlanEndDate;
	}

	/**
	 * Sets edited plan start date value 
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
	 * @param newEditPlanStartDate
	 */
	public void setEditPlanStartDate(Date newEditPlanStartDate) {
		editPlanStartDate = newEditPlanStartDate;
	}

	/**
	 * Sets proposal to which the dm belongs to 
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
	 * @param newProposal 
	 */
	public void setProposal(ProposalCustomDTO newProposal) {
		proposal = newProposal;
	}

	/**
	 * sets selected dm information 
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
	 * @param customDTO
	 */
	public void setSelectedDM(DMCustomDTO customDTO) {
		selectedDM = customDTO;
	}

	/**
	 * Returns contract end year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getEndYears() {
		return endYears;
	}


	/**
	 * Returns contract start year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getStartYears() {
		return startYears;
	}


	/**
	 * Sets contract end year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEndYears 
	 */
	public void setEndYears(List newEndYears) {
		endYears = newEndYears;
	}


	/**
	 * Sets contract start year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStartYears 
	 */
	public void setStartYears(List newStartYears) {
		startYears = newStartYears;
	}
}
