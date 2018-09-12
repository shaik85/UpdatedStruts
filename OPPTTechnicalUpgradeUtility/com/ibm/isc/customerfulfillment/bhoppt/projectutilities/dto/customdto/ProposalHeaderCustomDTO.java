/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.*;

/**
 * Custom dto that holds proposal header information  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 28, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalHeaderCustomDTO extends OPPTCustomDTO 
{
	private ProposalCustomDTO proposal = null;

	private String contractNumber = null;
	private String contractType = null;
	
	private BasicProposalCustomDTO basicProposalCustomDTO = null;
	private PricingInformationCustomDTO pricingInformationCustomDTO = null;
	private SecondaryProposalCustomDTO secondaryProposalCustomDTO = null;
	private VarianceInformationCustomDTO varianceInformationCustomDTO = null;
	
	private ProposalFormDataCustomDTO proposalFormDataCustomDTO = null;
	private PartnerInformationCustomDTO partnerInformationCustomDTO = null;
	private TreeMap customerLists = null;
	
	private boolean proposalDetails = false;
	private boolean fetchInventory = false;
	
	private List alternatePartnerList = null;

	private Date amendmentEffectiveDate = null;
	private Date contractClosureDate = null;

	private boolean displayAmendmentEffectiveDate = false;
	private boolean displayContractClosureDate = false;
	private boolean displayAdditionalGrowthLimit = true;

	private String proposalApprover = null;

	private ArrayList endYears = null;
	private ArrayList startYears = null;
	
	private List nonEditableFields = null;
	
	private boolean changeVarianceProposal = false;
	//DADO02 Sateesh Anne Blueharmony
	private List selectedCustomers = null;

	/**
	 * Returns proposal headers basic proposal information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BasicProposalCustomDTO
	 */
	public BasicProposalCustomDTO getBasicProposalCustomDTO() {
		return basicProposalCustomDTO;
	}

	/**
	 * Returns proposal headers secondary proposal information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SecondaryProposalCustomDTO 
	 */
	public SecondaryProposalCustomDTO getSecondaryProposalCustomDTO() {
		return secondaryProposalCustomDTO;
	}

	/**
	 * Returns proposal headers pricing information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PricingInformationCustomDTO 
	 */
	public PricingInformationCustomDTO getPricingInformationCustomDTO() {
		return pricingInformationCustomDTO;
	}

	/**
	 * Returns proposal headers variance information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return VarianceInformationCustomDTO 
	 */
	public VarianceInformationCustomDTO getVarianceInformationCustomDTO() {
		return varianceInformationCustomDTO;
	}

	/**
	 * Sets basic proposal information for proposal header 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBasicProposalCustomDTO BasicProposalCustomDTO 
	 */
	public void setBasicProposalCustomDTO(BasicProposalCustomDTO newBasicProposalCustomDTO) {
		basicProposalCustomDTO = newBasicProposalCustomDTO;
	}

	/**
	 * Sets secondary proposal information for proposal header 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSecondaryProposalCustomDTO SecondaryProposalCustomDTO 
	 */
	public void setSecondaryProposalCustomDTO(SecondaryProposalCustomDTO newSecondaryProposalCustomDTO) {
		secondaryProposalCustomDTO = newSecondaryProposalCustomDTO;
	}

	/** 
	 * Sets pricing information for proposal header
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPricingInformationCustomDTO PricingInformationCustomDTO 
	 */
	public void setPricingInformationCustomDTO(PricingInformationCustomDTO newPricingInformationCustomDTO) {
		pricingInformationCustomDTO = newPricingInformationCustomDTO;
	}

	/**
	 * Sets variance information for proposal header 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVarianceInformationCustomDTO VarianceInformationCustomDTO 
	 */
	public void setVarianceInformationCustomDTO(VarianceInformationCustomDTO newVarianceInformationCustomDTO) {
		varianceInformationCustomDTO = newVarianceInformationCustomDTO;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ibasicProposalCustomDTO BasicProposalCustomDTO
	 * @param ipricingInformationCustomDTO PricingInformationCustomDTO
	 * @param isecondaryProposalCustomDTO SecondaryProposalCustomDTO
	 * @param ivarianceInformationCustomDTO VarianceInformationCustomDTO
	 * @param ipartnerInformationCustomDTO PartnerInformationCustomDTO
	 */
	public void setData(BasicProposalCustomDTO ibasicProposalCustomDTO, 
						PricingInformationCustomDTO ipricingInformationCustomDTO, 
						SecondaryProposalCustomDTO isecondaryProposalCustomDTO, 
						VarianceInformationCustomDTO ivarianceInformationCustomDTO, 
						PartnerInformationCustomDTO ipartnerInformationCustomDTO){
		setBasicProposalCustomDTO(ibasicProposalCustomDTO);
		setPricingInformationCustomDTO(ipricingInformationCustomDTO);
		setSecondaryProposalCustomDTO(isecondaryProposalCustomDTO);
		setVarianceInformationCustomDTO(ivarianceInformationCustomDTO);
		setPartnerInformationCustomDTO(ipartnerInformationCustomDTO);
	}
	/**
	 * Returns partner information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PartnerInformationCustomDTO
	 */
	public PartnerInformationCustomDTO getPartnerInformationCustomDTO() {
		return partnerInformationCustomDTO;
	}

	/**
	 * Sets partner information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPartnerInformationCustomDTO PartnerInformationCustomDTO 
	 */
	public void setPartnerInformationCustomDTO(PartnerInformationCustomDTO newPartnerInformationCustomDTO) {
		partnerInformationCustomDTO = newPartnerInformationCustomDTO;
	}

	/**
	 * Returns collection of customers whose inventory need to be pulled into proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomerLists() {
		return customerLists;
	}

	/**
	 * Sets customer collection whose inventory need to be pulles into proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerLists TreeMap 
	 */
	public void setCustomerLists(TreeMap newCustomerLists) {
		customerLists = newCustomerLists;
	}
	
	/**
	 * Returns proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
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
	 * Sets proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposal ProposalCustomDTO 
	 */
	public void setProposal(ProposalCustomDTO newProposal) {
		proposal = newProposal;
	}
	
	/**
	 * Returns proposal form data details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalFormDataCustomDTO
	 */
	public ProposalFormDataCustomDTO getProposalFormDataCustomDTO() {
		return proposalFormDataCustomDTO;
	}

	/**
	 * Sets proposal form details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO ProposalFormDataCustomDTO
	 */
	public void setProposalFormDataCustomDTO(ProposalFormDataCustomDTO customDTO) {
		proposalFormDataCustomDTO = customDTO;
	}

	/**
	 *  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getContractNumber() {
		return contractNumber;
	}


	/**
	 * Returns contract type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getContractType() {
		return contractType;
	}


	/**
	 * Sets contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractNumber String 
	 */
	public void setContractNumber(String newContractNumber) {
		contractNumber = newContractNumber;
	}


	/**
	 * Sets contract type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractType String 
	 */
	public void setContractType(String newContractType) {
		contractType = newContractType;
	}
	
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isProposalDetails() {
		return proposalDetails;
	}

	/**
	 *  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setProposalDetails(boolean b) {
		proposalDetails = b;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getProposalApprover() {
		return proposalApprover;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setProposalApprover(String string) {
		proposalApprover = string;
	}

	/**
	 * get Alternate Partner List
	 * @return ESWCustomerCustomDTO
	 */
	public List getAlternatePartnerList() {
		return alternatePartnerList;
	}

	/**
	 * set Alternate Partner List
	 * @param newAlternatePartner ESWCustomerCustomDTO
	 */
	public void setAlternatePartneListr(List newAlternatePartner) {
		alternatePartnerList = newAlternatePartner;
	}
	

	/**
     * add Alternate Partner List
     *
     * @param customer 
     */
	
	public void addAlternatePartner(ESWCustomerCustomDTO customer){
		if(null != customer){
			if(null == alternatePartnerList){
				alternatePartnerList = new ArrayList();
			}
			alternatePartnerList.add(customer);
		}
	}
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isFetchInventory() {
		return fetchInventory;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setFetchInventory(boolean b) {
		fetchInventory = b;
	}

	/**
	 * Returns amendmen effective date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getAmendmentEffectiveDate() {
		return amendmentEffectiveDate;
	}

	/**
	 * Returns contract closure date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getContractClosureDate() {
		return contractClosureDate;
	}

	/**
	 * Returns display amendment effetive date flag value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDisplayAmendmentEffectiveDate() {
		return displayAmendmentEffectiveDate;
	}

	/**
	 * Returns display contract closure date flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDisplayContractClosureDate() {
		return displayContractClosureDate;
	}

	/**
	 * Sets amendment effectve date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAmendmentEffetiveDate Date 
	 */
	public void setAmendmentEffectiveDate(Date newAmendmentEffetiveDate) {
		amendmentEffectiveDate = newAmendmentEffetiveDate;
	}

	/**
	 * Sets contract closure date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractClosureDate Date 
	 */
	public void setContractClosureDate(Date newContractClosureDate) {
		contractClosureDate = newContractClosureDate;
	}

	/**
	 * Sets display amendment effective date flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDisplayAmendmentEffectiveDate boolean
	 */
	public void setDisplayAmendmentEffectiveDate(boolean newDisplayAmendmentEffectiveDate) {
		displayAmendmentEffectiveDate = newDisplayAmendmentEffectiveDate;
	}

	/**
	 * Sets display contract closure date flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDisplayContractClosureDate boolean
	 */
	public void setDisplayContractClosureDate(boolean newDisplayContractClosureDate) {
		displayContractClosureDate = newDisplayContractClosureDate;
	}
	
	/**
	 * Returs non editable field collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getNonEditableFields() {
		return nonEditableFields;
	}

	/**
	 * Sets non editable field collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNonEditableFields List
	 */
	public void setNonEditableFields(List newNonEditableFields) {
		nonEditableFields = newNonEditableFields;
	}
	
	
	/**
     * add non editable field collection
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 20, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param newNonEdiableField 
     */
	
	public void addNonEditableFields(String newNonEdiableField){
		if(null != newNonEdiableField){
			if(null == nonEditableFields){
				nonEditableFields = new ArrayList();
			}
			nonEditableFields.add(newNonEdiableField);
		}
	}
	
	/**
	 * Returns true if the custom dto is for change proposal sequence.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isChangeProposal(){
		boolean changeProposal = false;
		if(null != proposal){
			changeProposal = true;
		}
		return changeProposal;
	}
	
	/**
     * Sets non editable field collection
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 20, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return String
     */
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();

		buffer.append("\n\n[ProposalHeaderCustomDTO] - [toString] - Start...");  /* NOI18N */
		buffer.append("\n\nProposal information: "+proposal);  /* NOI18N */
		buffer.append("\n\nBasic proposal data: "+basicProposalCustomDTO);  /* NOI18N */
		buffer.append("\n\nPricing information: "+pricingInformationCustomDTO);  /* NOI18N */
		buffer.append("\n\nSecondary proposal data: "+secondaryProposalCustomDTO);  /* NOI18N */
		buffer.append("\n\nVariance information: "+varianceInformationCustomDTO);  /* NOI18N */
		buffer.append("\n\nPartner information: "+partnerInformationCustomDTO);  /* NOI18N */
	
		if(null != customerLists){
			buffer.append("\nCustomer lists: Null...");  /* NOI18N */
			Iterator iterator = customerLists.values().iterator();
			while(iterator.hasNext()){
				buffer.append((CustomerListCustomDTO)iterator.next());
			}
		}
		else{
			buffer.append("\nCustomer lists: Null...");  /* NOI18N */
		}
		buffer.append("\n\n[ProposalHeaderCustomDTO] - [toString] - End...");  /* NOI18N */

		return buffer.toString();
	}
	
	/**
	 * Returns true if the proposal header being requested is for changing an 
	 * variance proposal. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isChangeVarianceProposal() {
		return changeVarianceProposal;
	}

	/**
	 * Sets change variance proposal header flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newChangeVarianceProposal boolean
	 */
	public void setChangeVarianceProposal(boolean newChangeVarianceProposal) {
		changeVarianceProposal = newChangeVarianceProposal;
	}
	
	/**
	 * Returns flag value for displaying additional growth limit field. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDisplayAdditionalGrowthLimit() {
		return displayAdditionalGrowthLimit;
	}

	/**
	 * Sets flag value for displaying additional growth limit field. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDisplayAdditionalGrowthLimit boolean
	 */
	public void setDisplayAdditionalGrowthLimit(boolean newDisplayAdditionalGrowthLimit) {
		displayAdditionalGrowthLimit = newDisplayAdditionalGrowthLimit;
	}
    /**
     * alternate parent list
     *
     * @param ialternatePartnerList 
     */
    public void setAlternatePartnerList(List ialternatePartnerList) {
        alternatePartnerList = ialternatePartnerList;
    }
    /**
     * get end years
     * @return Returns the endYears.
     */
    public ArrayList getEndYears() {
        return endYears;
    }
    /**
     * set end years
     * @param lendYears The endYears to set.
     */
    public void setEndYears(ArrayList lendYears) {
        endYears = lendYears;
    }
    /**
     * get start years
     * @return Returns the startYears.
     */
    public ArrayList getStartYears() {
        return startYears;
    }
    /**
     * set start years
     * @param lstartYears The startYears to set.
     */
    public void setStartYears(ArrayList lstartYears) {
        startYears = lstartYears;
    }
	/**
	 * @return Returns the selectedCustomers.
	 */
	public List getSelectedCustomers() {
		return selectedCustomers;
	}
	/**
	 * @param selectedCustomers The selectedCustomers to set.
	 */
	public void setSelectedCustomers(List selectedCustomers) {
		this.selectedCustomers = selectedCustomers;
	}
}