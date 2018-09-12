/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.BasicProposalDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.DateDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.PricingInformationDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.SecondaryProposalDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.VarianceDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.FieldConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalForApprovalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalTypeConstants;

/**
 * Holds complete data required for proposal header details view.
 *
 * <br/><b>Known Bugs</b><br/>
 *
 * <br/><PRE>
 * date Nov 20, 2003
 *
 * revision date author reason
 *
 * </PRE><br/>
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalHeaderDetailsViewBean extends OPPTViewBean{
	private String iContractNumber = null;
	private String iContractType = null;
	private String iProposalStatus = null;

	private TreeMap iBillingBlockOptions = null;
	private TreeMap iBillingDateRuleOptions = null;
	private TreeMap iBillingFrequencyOptions = null;
	private TreeMap iGrowthLimitOptions = null;
	private TreeMap iPaymentTermsOptions = null;
	private TreeMap iPlannedGrowthOptions = null;
	//Added by srinivas-OPPT BH-DAD001
	private LinkedHashMap iProposalTypeOptions = null;
	private TreeMap iDeviatingDateRuleOptions = null;
	private TreeMap iProposalContentOptions = null;

	private BasicProposalDataBean iBasicProposalData = null;
	private PricingInformationDataBean iPricingInformationData = null;
	private VarianceDataBean iVarianceData = null;
	private SecondaryProposalDataBean iSecondaryProposalData = null;
	private PartnerInformationViewBean partnerInformation = null;

	private Date iAmendmentEffectiveDate = null;
	private Date iContractClosureDate = null;

	private boolean iDisplayAmendmentEffectiveDate = true;
	private boolean iDisplayContractClosureDate = false;
	private boolean iDisplayAdditionalGrowthLimit = true;

	private String proposalApprover = null;
	private String proposalContentDetail=null;
	private ArrayList iEndYears = null;
	private ArrayList iStartYears = null;

	private boolean createProposal=false;
	private boolean iContract = false;
	private boolean iProposalForApproval = false;

	private List iNonEditableFields = null;

	// Fields added for variance change proposal
	private boolean iInvoiceSuppression = false;
	private double iExceedingAmount = 0;
	// BH Wave-1 - DAD003 - Complex Contract Identifiers - Begin - Manoj
	private TreeMap blbIndicatorOptions = null;
	// BH Wave-1 - DAD003 - Complex Contract Identifiers - End - Manoj

	/**
	 * Retuns basic proposal information
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
	 * @return BasicProposalDataBean
	 */
	public BasicProposalDataBean getBasicProposalData() {
		if(null == iBasicProposalData){
			iBasicProposalData = new BasicProposalDataBean();
		}
		return iBasicProposalData;
	}

	/**
	 * Returns the collection of billing block options
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
	 * @return TreeMap
	 */
	public TreeMap getBillingBlockOptions() {
		return iBillingBlockOptions;
	}

	/**
	 * Returns billing date rule options
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
	 * @return TreeMap
	 */
	public TreeMap getBillingDateRuleOptions() {
		return iBillingDateRuleOptions;
	}

	/**
	 * Returns billing frequency options
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
	 * @return TreeMap
	 */
	public TreeMap getBillingFrequencyOptions() {
		return iBillingFrequencyOptions;
	}

	/**
     * getContractEndDate
     * 
     * @return
     * @author thirumalai
     */
    public Date getContractEndDate(){
		Date endDate = null;
		if(null != getBasicProposalData()){
			endDate = getBasicProposalData().getContractEndDate();
		}
		return endDate;
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
		return iContractNumber;
	}

	/**
     * getContractPeriodBeginning
     * 
     * @return
     * @author thirumalai
     */
    public Date getContractPeriodBeginning(){
		Date periodBeginning = null;
		if(null != getBasicProposalData()){
			periodBeginning = getBasicProposalData().getContractPeriodBeginning();
		}
		return periodBeginning;
	}

	/**
     * getContractPeriodEnding
     * 
     * @return
     * @author thirumalai
     */
    public Date getContractPeriodEnding(){
		Date periodEnding = null;
		if(null != getBasicProposalData()){
			periodEnding = getBasicProposalData().getContractPeriodEnding();
		}
		return periodEnding;
	}

	/**
     * getContractStartDate
     * 
     * 
     * @return
     * @author thirumalai
     */
    public Date getContractStartDate(){
		Date startDate = null;
		if(null != getBasicProposalData()){
			startDate = getBasicProposalData().getContractStartDate();
		}
		return startDate;
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
		return iContractType;
	}

	/**
     * getContractTypeString
     * 
     * @return
     * @author thirumalai
     */
    public String getContractTypeString() {
		String value = "";  //$NON-NLS-1$

		String desc = OPPTStaticDataHolder.getContractTypeDesc(getContractType());
		if(null != getContractType()){
			value = getContractType();
		}
		if(0 < value.length()){
			if(null != desc){
				value += " - "+desc;  //$NON-NLS-1$
			}
		}
		else{
			if(null != desc){
				value = desc;
			}
		}


		return value;
	}

	/**
     * getCurrencyCodeString
     * 
     * @return
     * @author thirumalai
     */
    public String getCurrencyCodeString(){
		String value = "";  //$NON-NLS-1$

		if(null != getBasicProposalData()){
			value = getBasicProposalData().getCurrencyCode();
		}

		return value;
	}

	/**
	 * Returns deviating date rule options
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
	 * @return TreeMap
	 */
	public TreeMap getDeviatingDateRuleOptions() {
		return iDeviatingDateRuleOptions;
	}

	/**
     * getDistributionChannelString
     * 
     * @return
     * @author thirumalai
     */
    public String getDistributionChannelString(){
		String value = "";  //$NON-NLS-1$

		if(null != getBasicProposalData()){
			//String id = getBasicProposalData().getDistributionChannel();
			String id = getBasicProposalData().getDistributionChannel()+"|"+
						getBasicProposalData().getSalesGroup()+"|"+
						getBasicProposalData().getChannelRole()+"|"+
						getBasicProposalData().getSubmitterRole();
			String desc = OPPTStaticDataHolder.getDistributionChannelDesc(id.trim());
			if(null != id){
				value = id;
			}
			if(0 < value.length()){
				if(null != desc){
					//value += " - "+desc;  //$NON-NLS-1$ commented by Ramesh
					value = desc;
				}
			}
			else{
				if(null != desc){
					value = desc;
				}
			}
		}
		return value;
	}

	/**
     * getDivisionString
     * 
     * @return
     * @author thirumalai
     */

    public String getDivisionString(){
		String value = "";

		if(null != getBasicProposalData()){
			String id = getBasicProposalData().getDivision();
			String desc = OPPTStaticDataHolder.getDivisionCodeDesc(id);
			if(null != id){
				value = id;
			}
			if(0 < value.length()){
				if(null != desc){
					value += " - "+desc;
				}
			}
			else{
				if(null != desc){
					value = desc;
				}
			}
		}
		return value;
	}

	/**
	 * Returns the collection of end years
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 29, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return ArrayList
	 */
	public ArrayList getEndYears() {
		return iEndYears;
	}

	/**
     * getExternalContractNumberString
     * 
     * @return
     * @author thirumalai
     */
    public String getExternalContractNumberString(){
		String externalContractNumberString = null;

		if(null != getBasicProposalData()){
			externalContractNumberString = getBasicProposalData().getExternalContractNumber();
		}

		return externalContractNumberString;
	}

	/**
	 * Returns growth limit options
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
	 * @return TreeMap
	 */
	public TreeMap getGrowthLimitOptions() {
		return iGrowthLimitOptions;
	}

	/**
	 * Returns payment terms options
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
	 * @return TreeMap
	 */
	public TreeMap getPaymentTermsOptions() {
		return iPaymentTermsOptions;
	}

	/**
	 * Returns plannedgrowth options collection
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
	 * @return TreeMap
	 */
	public TreeMap getPlannedGrowthOptions() {
		return iPlannedGrowthOptions;
	}

	/**
	 * Returns pricing information data
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
	 * @return PricingInformationDataBean
	 */
	public PricingInformationDataBean getPricingInformationData() {
		if(null == iPricingInformationData){
			iPricingInformationData = new PricingInformationDataBean();
		}
		return iPricingInformationData;
	}

	/**
     * getProposalNameString
     * 
     * @return
     * @author thirumalai
     */
    public String getProposalNameString(){
		String proposalNameString = null;

		if(null != getBasicProposalData()){
			proposalNameString = getBasicProposalData().getProposalName();
		}

		return proposalNameString;
	}

	/**
     * getProposalNameTypeString
     * 
     * @return
     * @author thirumalai
     */
    public String getProposalNameTypeString(){
		String proposalNameString = null;
		if(null != getBasicProposalData()){
			String proposalTypeDesc =null ;
			String proposalType = getBasicProposalData().getProposalType();
			String proposalContent = getBasicProposalData().getProposalContent();
			
			if(proposalType.equalsIgnoreCase(ProposalTypeConstants.ESSO)){
				if(proposalContent.equalsIgnoreCase("M")){
					proposalTypeDesc ="MLC";
					proposalNameString = getBasicProposalData().getProposalName()+" ("+proposalTypeDesc+")"; 				
				}
				else{			
					proposalTypeDesc ="SandS";
					proposalNameString = getBasicProposalData().getProposalName()+" ("+proposalTypeDesc+")";
				    }
			}
			else{
			proposalNameString = getBasicProposalData().getProposalName()+" ("+OPPTStaticDataHolder.getProposalTypeDesc(proposalType)+")";  //$NON-NLS-1$  //$NON-NLS-2$
			}
		}
		return proposalNameString;
	}
	/**
     * getProposalTypeOptions
     * 
     * @return
     * @author thirumalai
     */
	//Added by srinivas-OPPT BH-DAD001
  public LinkedHashMap getProposalTypeOptions(){
  
		return iProposalTypeOptions;
	}

	/**
     * getProposalTypeString
     * 
     * @return
     * @author thirumalai
     */
    public String getProposalTypeString(){
		String proposalTypeString = null;

		if(null != getBasicProposalData()){
			proposalTypeString = getBasicProposalData().getProposalType();
		}

		return proposalTypeString;
	}

	/**
     * getReportNameString
     * 
     * @return
     * @author thirumalai
     */
    public String getReportNameString(){
		String reportNameString = null;

		if(null != getBasicProposalData()){
			reportNameString = getBasicProposalData().getReportName();
		}

		return reportNameString;
	}

	/**
     * getSalesOrgString
     * 
     * @return
     * @author thirumalai
     */
    public String getSalesOrgString(){
		String salesOrgString = "";  //$NON-NLS-1$

		if(null != getBasicProposalData()){
			String id = getBasicProposalData().getSalesOrganization();
			String value = OPPTStaticDataHolder.getSalesOrgDesc(id);
			if(null != id){
				salesOrgString = id;
			}
			if(0 < salesOrgString.length()){
				if(null != value){
					salesOrgString += " - "+value;  //$NON-NLS-1$
				}
			}
			else{
				if(null != value){
					salesOrgString = value;
				}
			}
		}

		return salesOrgString;
	}

	/**
	 * Returns secondary proposal data
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
	 * @return SecondaryProposalDataBean
	 */
	public SecondaryProposalDataBean getSecondaryProposalData() {
		if(null == iSecondaryProposalData){
			iSecondaryProposalData = new SecondaryProposalDataBean();
		}
		return iSecondaryProposalData;
	}

	/**
	 * Returns the start years collection
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 29, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return ArrayList
	 */
	public ArrayList getStartYears() {
		return iStartYears;
	}

	/**
	 * Returns variance data
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
	 * @return VarianceDataBean
	 */
	public VarianceDataBean getVarianceData() {
		if(null == iVarianceData){
			iVarianceData = new VarianceDataBean();
		}
		return iVarianceData;
	}

	/**
	 * Sets basic proposal data
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
	 * @param newBasicProposalData BasicProposalDataBean
	 */
	public void setBasicProposalData(BasicProposalDataBean newBasicProposalData) {
		iBasicProposalData = newBasicProposalData;
	}

	/**
	 * Sets billing block options collection
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
	 * @param newBillingBlockOpions TreeMap
	 */
	public void setBillingBlockOptions(TreeMap newBillingBlockOpions) {
		iBillingBlockOptions = newBillingBlockOpions;
	}

	/**
	 * Sets billing date rule options
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
	 * @param newBillingDateRuleOptions TreeMap
	 */
	public void setBillingDateRuleOptions(TreeMap newBillingDateRuleOptions) {
		iBillingDateRuleOptions = newBillingDateRuleOptions;
	}

	/**
	 * Sets billing frequency options
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
	 * @param newBbillingFrequencyOptions TreeMap
	 */
	public void setBillingFrequencyOptions(TreeMap newBbillingFrequencyOptions) {
		iBillingFrequencyOptions = newBbillingFrequencyOptions;
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
		iContractNumber = newContractNumber;
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
		iContractType = newContractType;
	}

	/**
	 * Sets deviating date rule options collection
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
	 * @param newDeviatingDateRuleOptions TreeMap
	 */
	public void setDeviatingDateRuleOptions(TreeMap newDeviatingDateRuleOptions) {
		iDeviatingDateRuleOptions = newDeviatingDateRuleOptions;
	}

	/**
	 * Sets growth limit options collection
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
	 * @param newGrowthLimitOptions TreeMap
	 */
	public void setGrowthLimitOptions(TreeMap newGrowthLimitOptions) {
		iGrowthLimitOptions = newGrowthLimitOptions;
	}

	/**
	 * Sets end years collection
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 29, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param newEndYears ArrayList
	 */
	public void setEndYears(ArrayList newEndYears) {
		iEndYears = newEndYears;
	}

	/**
	 * Sets start years collection
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Dec 29, 2003
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param newStartYears ArrayList
	 */
	public void setStartYears(ArrayList newStartYears) {
		iStartYears = newStartYears;
	}

	/**
	 * Sets payment terms options collection
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
	 * @param newPaymentTermsOptions TreeMap
	 */
	public void setPaymentTermsOptions(TreeMap newPaymentTermsOptions) {
		iPaymentTermsOptions = newPaymentTermsOptions;
	}

	/**
	 * Sets planned growth options collection
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
	 * @param newPlannedGrowthOptions TreeMap
	 */
	public void setPlannedGrowthOptions(TreeMap newPlannedGrowthOptions) {
		iPlannedGrowthOptions = newPlannedGrowthOptions;
	}

	/**
	 * Sets pricing information data
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
	 * @param newPricingInformationData PricingInformationDataBean
	 */
	public void setPricingInformationData(PricingInformationDataBean newPricingInformationData) {
		iPricingInformationData = newPricingInformationData;
	}
	/**
     * @param newProposalTypeOptions
     * @author thirumalai
     */
	//Added by srinivas-OPPT BH-DAD001
   public void setProposalTypeOptions(LinkedHashMap newProposalTypeOptions){
	
		iProposalTypeOptions = newProposalTypeOptions;
	}

	/**
	 * Sets secondary proposal data
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
	 * @param newSecondaryProposalData SecondaryProposalDataBean
	 */
	public void setSecondaryProposalData(SecondaryProposalDataBean newSecondaryProposalData) {
		iSecondaryProposalData = newSecondaryProposalData;
	}

	/**
	 * Sets variance data
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
	 * @param newVarianceData VarianceDataBean
	 */
	public void setVarianceData(VarianceDataBean newVarianceData) {
		iVarianceData = newVarianceData;
	}

	/**
	 * Adds new billing block option to existing collection of options.
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
	 * @param id String
	 * @param description String
	 */

	public void addBillingBlockOption(String id, String description){
		if(null != id && null != description){
			if(null == iBillingBlockOptions){
				iBillingBlockOptions = new TreeMap();
			}
			iBillingBlockOptions.put(id, description);
		}
	}

	/**
	 * Adds new billing date rule option to existing collection of options.
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
	 * @param id String
	 * @param description String
	 */
	public void addBillingDateRuleOption(String id, String description){
		if(null != id && null != description){
			if(null == iBillingDateRuleOptions){
				iBillingDateRuleOptions = new TreeMap();
			}
			iBillingDateRuleOptions.put(id, description);
		}
	}

	/**
	 * Adds new billing frequency option to existing collection of options.
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
	 * @param id String
	 * @param description String
	 */
	public void addBillingFrequencyOption(String id, String description){
		if(null != id && null != description){
			if(null == iBillingFrequencyOptions){
				iBillingFrequencyOptions = new TreeMap();
			}
			iBillingFrequencyOptions.put(id, description);
		}
	}

	/**
	 * Adds new deviating date rule option to existing collection of options.
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
	 * @param id String
	 * @param description String
	 */
	public void addDeviatingDateRuleOption(String id, String description){
		if(null != id && null != description){
			if(null == iDeviatingDateRuleOptions){
				iDeviatingDateRuleOptions = new TreeMap();
			}
			iDeviatingDateRuleOptions.put(id, description);
		}
	}

	/**
	 * Adds new growth limit option to existing collection of options.
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
	 * @param id String
	 * @param description String
	 */
	public void addGrowthLimitOption(String id, String description){
		if(null != id && null != description){
			if(null == iGrowthLimitOptions){
				iGrowthLimitOptions = new TreeMap();
			}
			iGrowthLimitOptions.put(id, description);
		}
	}

	/**
	 * Adds new payment terms option to existing collection of options.
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
	 * @param id String
	 * @param description String
	 */
	public void addPaymentTermsOption(String id, String description){
		if(null != id && null != description){
			if(null == iPaymentTermsOptions){
				iPaymentTermsOptions = new TreeMap();
			}
			iPaymentTermsOptions.put(id, description);
		}
	}

	/**
	 * Adds new planned growth option to existing collection of options.
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
	 * @param id String
	 * @param description String
	 */
	public void addPlannedGrowthOption(String id, String description){
		if(null != id && null != description){
			if(null == iPlannedGrowthOptions){
				iPlannedGrowthOptions = new TreeMap();
			}
			iPlannedGrowthOptions.put(id, description);
		}
	}

	/**
	 * Sets complete data in a single method call.
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
	 * @param contractNumber String
	 * @param contractType String
	 * @param plannedGrowthOptions TreeMap
	 * @param growthLimitOptions TreeMap
	 * @param billingFrequencyOptions TreeMap
	 * @param billingBlockOptions TreeMap
	 * @param deviatingDateRuleOptions TreeMap
	 * @param billingDateRuleOptions TreeMap
	 * @param paymentTermsOptions TreeMap
	 * @param basicProposalData BasicProposalDataBean
	 * @param pricingInformationData PricingInformationDataBean
	 * @param secondaryProposalData SecondaryProposalDataBean
	 * @param varianceData VarianceDataBean
	 */
	public void setData(String contractNumber, String contractType, TreeMap plannedGrowthOptions,
						TreeMap growthLimitOptions, TreeMap billingFrequencyOptions, TreeMap billingBlockOptions,
						TreeMap deviatingDateRuleOptions, TreeMap billingDateRuleOptions, TreeMap paymentTermsOptions,
						BasicProposalDataBean basicProposalData, PricingInformationDataBean pricingInformationData,
						SecondaryProposalDataBean secondaryProposalData, VarianceDataBean varianceData){
		setContractNumber(contractNumber);
		setContractType(contractType);
		setPlannedGrowthOptions(plannedGrowthOptions);
		setGrowthLimitOptions(growthLimitOptions);
		setBillingFrequencyOptions(billingFrequencyOptions);
		setBillingBlockOptions(billingBlockOptions);
		setDeviatingDateRuleOptions(deviatingDateRuleOptions);
		setBillingDateRuleOptions(billingDateRuleOptions);
		setPaymentTermsOptions(paymentTermsOptions);
		setBasicProposalData(basicProposalData);
		setPricingInformationData(pricingInformationData);
		setSecondaryProposalData(secondaryProposalData);
		setVarianceData(varianceData);
	}

	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(ProposalHeaderCustomDTO customDTO)
	{
		if(null != customDTO){
			if(customDTO.getProposal() instanceof ContractCustomDTO){
				setContract(true);
			}
			else if(customDTO.getProposal() instanceof ProposalForApprovalCustomDTO){
				setProposalForApproval(true);
			}

			setProposalStatus(customDTO.getProposal().getStatus());
			setButtonFlags(customDTO.getButtonFlags());
			setNonEditableFields(customDTO.getNonEditableFields());
			setContractNumber(customDTO.getContractNumber());
			setContractType(customDTO.getContractType());
			setAmendmentEffectiveDate(customDTO.getAmendmentEffectiveDate());
			setContractClosureDate(customDTO.getContractClosureDate());
			setDisplayContractClosureDate(customDTO.isDisplayContractClosureDate());
			setDisplayAmendmentEffectiveDate(customDTO.isDisplayAmendmentEffectiveDate());
			setDisplayAdditionalGrowthLimit(customDTO.isDisplayAdditionalGrowthLimit());
			setProposalApprover(customDTO.getProposalApprover());

			setProposalContentDetail(OPPTStaticDataHolder.getProposalContentDesc(customDTO.getBasicProposalCustomDTO().getProposalContent()));

			ProposalFormDataCustomDTO proposalFormData = customDTO.getProposalFormDataCustomDTO();
			if(null != proposalFormData)
			{
				setProposalContentOptions(proposalFormData.getProposalContentOptions());
				setProposalTypeOptions(proposalFormData.getProposalTypeOptions());
				setBillingFrequencyOptions(proposalFormData.getBillingFrequencyOptions());
				// BH Wave1 - DAD003 Begin-Manoj
				setBlbIndicatorOptions(proposalFormData.getBlbIndicatorOptions());
				// BH Wave1 - DAD003 End-Manoj
				TreeMap collection =  proposalFormData.getBillingBlockOptions();
				if(null != collection){
					Iterator iterator = collection.keySet().iterator();
					if(null != iterator){
						while(iterator.hasNext()){
							String key = (String)iterator.next();
							addBillingBlockOption(key, key +" - "+ (String)collection.get(key));  //$NON-NLS-1$
						}
					}
				}

				collection =  proposalFormData.getDeviatingDateRuleOptions();
				if(null != collection){
					Iterator iterator = collection.keySet().iterator();
					if(null != iterator){
						while(iterator.hasNext()){
							String key = (String)iterator.next();
							addDeviatingDateRuleOption(key, key +" - "+ (String)collection.get(key));  //$NON-NLS-1$
						}
					}
				}

				collection =  proposalFormData.getBillingDateRuleOptions();
				if(null != collection){
					Iterator iterator = collection.keySet().iterator();
					if(null != iterator){
						while(iterator.hasNext()){
							String key = (String)iterator.next();
							addBillingDateRuleOption(key, key +" - "+ (String)collection.get(key));  //$NON-NLS-1$
						}
					}
				}

				collection =  proposalFormData.getPaymentTermsOptions();
				if(null != collection){
					Iterator iterator = collection.keySet().iterator();
					if(null != iterator){
						while(iterator.hasNext()){
							String key = (String)iterator.next();
							addPaymentTermsOption(key, key +" - "+ (String)collection.get(key));  //$NON-NLS-1$
						}
					}
				}

				setAmendmentEffectiveDate(customDTO.getAmendmentEffectiveDate());
				setProposalApprover(customDTO.getProposalApprover());
				setEndYears(proposalFormData.getEndYears());
				setStartYears(proposalFormData.getStartYears());

				TreeMap plannedGrowth = new TreeMap();
				plannedGrowth.put("Nil", "Nil");  //$NON-NLS-1$  //$NON-NLS-2$
				plannedGrowth.put(3+"", 3+"");  //$NON-NLS-1$  //$NON-NLS-2$
				plannedGrowth.put(6+"", 6+"");  //$NON-NLS-1$  //$NON-NLS-2$
				plannedGrowth.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
				setPlannedGrowthOptions(plannedGrowth);

				TreeMap growthLimit = new TreeMap();
				growthLimit.put("Nil", "Nil");  //$NON-NLS-1$  //$NON-NLS-2$
				growthLimit.put(7+"", 7+"");  //$NON-NLS-1$  //$NON-NLS-2$
				growthLimit.put(15+"", 15+"");  //$NON-NLS-1$  //$NON-NLS-2$
				growthLimit.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
				setGrowthLimitOptions(growthLimit);
			}

			setBasicProposalData(new BasicProposalDataBean(customDTO.getBasicProposalCustomDTO()));
			setPricingInformationData(new PricingInformationDataBean(customDTO.getPricingInformationCustomDTO()));
			setVarianceData(new VarianceDataBean(customDTO.getVarianceInformationCustomDTO()));
			setSecondaryProposalData(new SecondaryProposalDataBean(customDTO.getSecondaryProposalCustomDTO()));
			setPartnerInformation(new PartnerInformationViewBean(customDTO.getPartnerInformationCustomDTO()));

			ProposalHeaderActionForm actionForm = new ProposalHeaderActionForm();
			actionForm.setBasicProposalData(new BasicProposalDataBean(customDTO.getBasicProposalCustomDTO()));
			actionForm.setPricingInformation(new PricingInformationDataBean(customDTO.getPricingInformationCustomDTO()));
			actionForm.setVarianceData(new VarianceDataBean(customDTO.getVarianceInformationCustomDTO()));
			actionForm.setSecondaryProposalData(new SecondaryProposalDataBean(customDTO.getSecondaryProposalCustomDTO()));
			actionForm.setPurchaseOrderDate(new DateDataBean(actionForm.getSecondaryProposalData().getPurchaseOrderDate()));
			actionForm.setFixedValueDate(new DateDataBean(actionForm.getSecondaryProposalData().getFixedValDate()));
			actionForm.getBasicProposalData().setSalesOrganization(customDTO.getBasicProposalCustomDTO().getSalesOrganizationValue());

			actionForm.setCapAmount(getDoubleValue(actionForm.getVarianceData().getCapAmount()));
			actionForm.setCapMinus(String.valueOf(actionForm.getVarianceData().getCapMinus()));
			actionForm.setCapPlus(String.valueOf(actionForm.getVarianceData().getCapPlus()));
			actionForm.setContractStartDate(new DateDataBean(actionForm.getBasicProposalData().getContractStartDate()));
			actionForm.setContractEndDate(new DateDataBean(actionForm.getBasicProposalData().getContractEndDate()));
			actionForm.setContractPeriodStartDate(new DateDataBean(actionForm.getBasicProposalData().getContractPeriodBeginning()));
			actionForm.setContractPeriodEndDate(new DateDataBean(actionForm.getBasicProposalData().getContractPeriodEnding()));
			actionForm.setVarianceDate(new DateDataBean(actionForm.getPricingInformation().getVarianceDate()));
			actionForm.getBasicProposalData().setProposalName(null);
			actionForm.setProposalStatus(getProposalStatus());

			setActionForm(actionForm);
		}
	}

	/**
     * ProposalHeaderDetailsViewBean
     * 
     * @author thirumalai
     */
    public ProposalHeaderDetailsViewBean(){
	}

	/**
     * ProposalHeaderDetailsViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ProposalHeaderDetailsViewBean(ProposalHeaderCustomDTO customDTO){
		setData(customDTO);
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
	public PartnerInformationViewBean getPartnerInformation() {
		return partnerInformation;
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
	 * @param bean
	 */
	public void setPartnerInformation(PartnerInformationViewBean bean) {
		partnerInformation = bean;
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
	 * date Jan 26, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public boolean isCreateProposal() {
		return createProposal;
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
	 * date Jan 26, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param b
	 */
	public void setCreateProposal(boolean b) {
		createProposal = b;
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
	 * date Feb 18, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public TreeMap getProposalContentOptions() {
		return iProposalContentOptions;
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
	 * date Feb 18, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param map
	 */
	public void setProposalContentOptions(TreeMap map) {
		iProposalContentOptions = map;
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
	 * date Feb 19, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return
	 */
	public String getProposalContentDetail() {
		return proposalContentDetail;
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
	 * date Feb 19, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param string
	 */
	public void setProposalContentDetail(String string) {
		proposalContentDetail = string;
	}

	/**
	 * Returns the true if the current view is for a contract
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Feb 27, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return boolean
	 */
	public boolean isContract() {
		return iContract;
	}

	/**
	 * Sets whether the current view is for a contract or for a proposal
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Feb 27, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param newContract boolean
	 */
	public void setContract(boolean newContract) {
		iContract = newContract;
	}

	/**
	 * Returns true if the current view is for proposal for approval
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Feb 27, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return boolean
	 */
	public boolean isProposalForApproval() {
		return iProposalForApproval;
	}

	/**
	 * Sets the current view is for a proposal or proposal waiting for approval
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Feb 27, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param newProposalForApproval boolean
	 */
	public void setProposalForApproval(boolean newProposalForApproval) {
		iProposalForApproval = newProposalForApproval;
	}

	/**
	 * Returns the planned growth option value based on the planned growth option selected
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Mar 5, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return String
	 */
	public String getPlannedGrowthOptionValue(){
		String optionValue = null;
		String value = getPricingInformationData().getPlannedGrowthOption();

		if(value.equals("Nil") || value.equals("3") || value.equals("6")){  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			optionValue = "";  //$NON-NLS-1$
		}
		else{
			optionValue = getPricingInformationData().getPlannedGrowthValue();
		}
		return optionValue;
	}

	/**
	 * Returns the growth limit option value based on the growth limit option selected
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Mar 5, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return String
	 */
	public String getGrowthLimitOptionValue(){
		String optionValue = null;
		String value = getPricingInformationData().getGrowthLimitOption();

		if(value.equals("Nil") || value.equals("7") || value.equals("15")){  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$
			optionValue = "";  //$NON-NLS-1$
		}
		else{
			optionValue = getPricingInformationData().getGrowthLimitValue();
		}
		return optionValue;
	}

	/**
	 * Returns the proposal type value.
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Mar 5, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return String
	 */
	public String getProposalType(){
		return OPPTStaticDataHolder.getProposalTypeDesc(getBasicProposalData().getProposalType());
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
		return iAmendmentEffectiveDate;
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
		return iContractClosureDate;
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
		return iDisplayAmendmentEffectiveDate;
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
		return iDisplayContractClosureDate;
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
		iAmendmentEffectiveDate = newAmendmentEffetiveDate;
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
		iContractClosureDate = newContractClosureDate;
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
		iDisplayAmendmentEffectiveDate = newDisplayAmendmentEffectiveDate;
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
		iDisplayContractClosureDate = newDisplayContractClosureDate;
	}

	/**
     * getContractStartDateDay
     * 
     * @return
     * @author thirumalai
     */
    public String getContractStartDateDay(){
		String day = "dd";  //$NON-NLS-1$
		if(null != getContractStartDate()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractStartDate());
			if(9 >= calender.getDay()){
				day = "0"+calender.getDay();  //$NON-NLS-1$
			}
			else{
				day = calender.getDay()+"";  //$NON-NLS-1$
			}
		}
		return day;
	}

	/**
     * getContractStartDateMonth
     * 
     * @return
     * @author thirumalai
     */
    public String getContractStartDateMonth(){
		String month = "mm";  //$NON-NLS-1$
		if(null != getContractStartDate()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractStartDate());
			if(9 >= calender.getMonth()){
				month = "0"+calender.getMonth();  //$NON-NLS-1$
			}
			else{
				month = calender.getMonth()+"";  //$NON-NLS-1$
			}
		}
		return month;
	}

	/**
     * getContractStartDateYear
     * 
     * @return
     * @author thirumalai
     */
    public String getContractStartDateYear(){
		String year = "yyyy";  //$NON-NLS-1$
		if(null != getContractStartDate()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractStartDate());
			year = calender.getYear()+"";  //$NON-NLS-1$
		}
		return year;
	}

	/**
     * getContractEndDateDay
     * 
     * @return
     * @author thirumalai
     */
    public String getContractEndDateDay(){
		String day = "dd";  //$NON-NLS-1$
		if(null != getContractEndDate()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractEndDate());
			if(9 >= calender.getDay()){
				day = "0"+calender.getDay();  //$NON-NLS-1$
			}
			else{
				day = calender.getDay()+"";  //$NON-NLS-1$
			}
		}
		return day;
	}

	/**
     * getContractEndDateMonth
     * 
     * @return
     * @author thirumalai
     */
    public String getContractEndDateMonth(){
		String month = "mm";  //$NON-NLS-1$
		if(null != getContractEndDate()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractEndDate());
			if(9 >= calender.getMonth()){
				month = "0"+calender.getMonth();  //$NON-NLS-1$
			}
			else{
				month = calender.getMonth()+"";  //$NON-NLS-1$
			}
		}
		return month;
	}

	/**
     * getContractEndDateYear
     * 
     * @return
     * @author thirumalai
     */
    public String getContractEndDateYear(){
		String year = "yyyy";  //$NON-NLS-1$
		if(null != getContractEndDate()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractEndDate());
			year = calender.getYear()+"";  //$NON-NLS-1$
		}
		return year;
	}

	/**
     * getContractPeriodStartDateDay
     * 
     * @return
     * @author thirumalai
     */
    public String getContractPeriodStartDateDay(){
		String day = "dd";  //$NON-NLS-1$
		if(null != getContractPeriodBeginning()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractPeriodBeginning());
			if(9 >= calender.getDay()){
				day = "0"+calender.getDay();  //$NON-NLS-1$
			}
			else{
				day = calender.getDay()+"";  //$NON-NLS-1$
			}
		}
		return day;
	}

	/**
     * getContractPeriodStartDateMonth
     * 
     * @return
     * @author thirumalai
     */
    public String getContractPeriodStartDateMonth(){
		String month = "mm";  //$NON-NLS-1$
		if(null != getContractPeriodBeginning()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractPeriodBeginning());
			if(9 >= calender.getMonth()){
				month = "0"+calender.getMonth();  //$NON-NLS-1$
			}
			else{
				month = calender.getMonth()+"";  //$NON-NLS-1$
			}
		}
		return month;
	}

	/**
     * getContractPeriodStartDateYear
     * 
     * @return
     * @author thirumalai
     */
    public String getContractPeriodStartDateYear(){
		String year = "yyyy";  //$NON-NLS-1$
		if(null != getContractPeriodBeginning()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractPeriodBeginning());
			year = calender.getYear()+"";  //$NON-NLS-1$
		}
		return year;
	}

	/**
     * getContractPeriodEndDateDay
     * 
     * @return
     * @author thirumalai
     */
    public String getContractPeriodEndDateDay(){
		String day = "dd";  //$NON-NLS-1$
		if(null != getContractPeriodEnding()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractPeriodEnding());
			if(9 >= calender.getDay()){
				day = "0"+calender.getDay();  //$NON-NLS-1$
			}
			else{
				day = calender.getDay()+"";  //$NON-NLS-1$
			}
		}
		return day;
	}

	/**
     * getContractPeriodEndDateMonth
     * 
     * @return
     * @author thirumalai
     */
    public String getContractPeriodEndDateMonth(){
		String month = "mm";  //$NON-NLS-1$
		if(null != getContractPeriodEnding()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractPeriodEnding());
			if(9 >= calender.getMonth()){
				month = "0"+calender.getMonth();  //$NON-NLS-1$
			}
			else{
				month = calender.getMonth()+"";  //$NON-NLS-1$
			}
		}
		return month;
	}

	/**
     * getContractPeriodEndDateYear
     * 
     * @return
     * @author thirumalai
     */
    public String getContractPeriodEndDateYear(){
		String year = "yyyy";  //$NON-NLS-1$
		if(null != getContractPeriodEnding()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getContractPeriodEnding());
			year = calender.getYear()+"";  //$NON-NLS-1$
		}
		return year;
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
		return iNonEditableFields;
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
		iNonEditableFields = newNonEditableFields;
	}

	/**
	 * Returns the action form associated with the current view.
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Feb 24, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return ProposalHeaderActionForm
	 */
	public ProposalHeaderActionForm getChangeProposalActionForm() {
		ProposalHeaderActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof ProposalHeaderActionForm){
			actionForm = (ProposalHeaderActionForm)getActionForm();
		}
		else{
			actionForm = new ProposalHeaderActionForm();
			actionForm.getPricingInformation().setAdvance(true);
		}
		return actionForm;
	}

	/**
	 * Returns proposals current status value
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Mar 30, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @return String
	 */
	public String getProposalStatus() {
		return iProposalStatus;
	}

	/**
	 * Sets proposal status value
	 *
	 * <br><b>Known Bugs</b><br>
	 *
	 * <br><PRE>
	 * date Mar 30, 2004
	 *
	 * revision date author reason
	 *
	 * </PRE><br>
	 *
	 * @param newProposalStatus String
	 */
	public void setProposalStatus(String newProposalStatus) {
		iProposalStatus = newProposalStatus;
	}

	/**
     * getPlannedGrowthValue
     * 
     * @return
     * @author thirumalai
     */
    public String getPlannedGrowthValue(){
		String plannedGrowthValue = getPricingInformationData().getPlannedGrowthOption();

		if(null != plannedGrowthValue){
			if("Other".equalsIgnoreCase(plannedGrowthValue)){  //$NON-NLS-1$
				plannedGrowthValue = getPricingInformationData().getPlannedGrowthValue();
			}
			if("Nil".equalsIgnoreCase(plannedGrowthValue)){  //$NON-NLS-1$
				plannedGrowthValue = "0.00";  //$NON-NLS-1$
			}
		}

		return plannedGrowthValue;
	}

	/**
     * getGrowthLimitValue
     * 
     * @return
     * @author thirumalai
     */
    public String getGrowthLimitValue(){
		String growthLimitValue = getPricingInformationData().getGrowthLimitOption();

		if(null != growthLimitValue){
			if("Other".equalsIgnoreCase(growthLimitValue)){  //$NON-NLS-1$
				growthLimitValue = getPricingInformationData().getGrowthLimitValue();
			}
			if("Nil".equalsIgnoreCase(growthLimitValue)){  //$NON-NLS-1$
				growthLimitValue = "0.00";  //$NON-NLS-1$
			}
		}

		return growthLimitValue;
	}

	/**
	 * Returns exceeding amount value
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
	 * @return double
	 */
	public double getExceedingAmount() {
		return iExceedingAmount;
	}

	/**
	 * Returns invoice suppression flag value
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
	public boolean isInvoiceSuppression() {
		return iInvoiceSuppression;
	}

	/**
	 * Sets exceeding amount value
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
	 * @param newExceedingAmount double
	 */
	public void setExceedingAmount(double newExceedingAmount) {
		iExceedingAmount = newExceedingAmount;
	}

	/**
	 * Returns invoice suppression value
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
	 * @param newInvoiceSuppression boolean
	 */
	public void setInvoiceSuppression(boolean newInvoiceSuppression) {
		iInvoiceSuppression = newInvoiceSuppression;
	}

	/**
     * getPageTitle
     * 
     * @return
     * @author thirumalai
     */
    public String getPageTitle(){
		String pageTitle = null;

		if(isContract()){
			pageTitle = "Contract maintenance";  //$NON-NLS-1$
		}
		else if(isProposalForApproval()){
			pageTitle = "Proposals for approval";  //$NON-NLS-1$
		}
		else{
			pageTitle = "Proposal maintenance";  //$NON-NLS-1$
		}
		return pageTitle;
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
		return iDisplayAdditionalGrowthLimit;
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
		iDisplayAdditionalGrowthLimit = newDisplayAdditionalGrowthLimit;
	}

	/**
     * isPlannedGrowthEditable
     * 
     * @return
     * @author thirumalai
     */
    public boolean isPlannedGrowthEditable(){
		boolean editable = true;
		if(null != iNonEditableFields){
			if(iNonEditableFields.contains(FieldConstants.PRICING_INFORMATION_PLANNED_GROWTH_OPTION)){
				editable = false;
			}
		}
		return editable;
	}

	/**
     * isGrowthLimitEditable
     * 
     * @return
     * @author thirumalai
     */
    public boolean isGrowthLimitEditable(){
		boolean editable = true;
		if(null != iNonEditableFields){
			if(iNonEditableFields.contains(FieldConstants.PRICING_INFORMATION_GROWTH_LIMIT_OPTION)){
				editable = false;
			}
		}
		return editable;
	}

	private String getDoubleValue(double doubleValue) {
		BigDecimal initialDouble = new BigDecimal((new Double(doubleValue)).toString());
		BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return scaledDouble.toString();
	}
	// BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Manoj
	/**
	 * @return Returns the blbIndicatorOptions.
	 */
	public TreeMap getBlbIndicatorOptions() {
		return blbIndicatorOptions;
	}	/**
	 * @param blbIndicatorOptions The blbIndicatorOptions to set.
	 */
	public void setBlbIndicatorOptions(TreeMap blbIndicatorOptions) {
		this.blbIndicatorOptions = blbIndicatorOptions;
	}
	// BH Wave1 - DAD003 - Complex Contract Identifiers - End - Manoj
}
