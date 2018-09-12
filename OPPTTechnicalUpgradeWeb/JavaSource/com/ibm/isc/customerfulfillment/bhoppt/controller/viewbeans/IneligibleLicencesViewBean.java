/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleLicensesCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleSWOCustomDTO;

/**
 * Holds complete information about ineligible licenses view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class IneligibleLicencesViewBean extends OPPTViewBean {
	/**
	 * constant
     */
    public static final int MLC_BLOCK = 1;
	/**
	 * constant
     */
    public static final int SANDS_BLOCK = 2;
	
	/**
	 * constant
     */
    public static final int EXISTING_CONTRACT_COVERAGE = 1;
	/**
	 * constant
     */
    public static final int LICENSES_FAILING_REMOVAL_DATE_CHECK = 2;
	/**
	 * constant
     */
    public static final int LICENSES_WITH_REJECTION_REASON = 3;
	/**
	 * constant
     */
    public static final int LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK = 4;
	/**
	 * constant
     */
    public static final int LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE = 5;
	/**
	 * constant
     */
    public static final int S_AND_S_EXISTING_CONTRACT_COVERAGE = 6;
	/**
	 * constant
     */
    public static final int S_AND_S_LICENSES_FAILING_REMOVAL_DATE_CHECK = 7;
	/**
	 * constant
     */
    public static final int S_AND_S_LICENSES_WITH_REJECTION_REASON = 8;
	/**
	 * constant
     */
    public static final int S_AND_S_LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK = 9;
	/**
	 * constant
     */
    public static final int S_AND_S_LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE = 10;
	/**
	 * constant
     */
    public static final int LICENSES_FAILING_WITH_SVC= 11;
	/**
	 * constant
     */
    public static final int S_AND_S_LICENSES_FAILING_WITH_SVC = 12;
		
	private TreeMap iExistingContractCoverage = null;
	private TreeMap iLicensesFailingRemovalDateCheck = null;
	private TreeMap iLicensesWithRejectionReason = null;
	private TreeMap iLicensesFailingLicenseEffectiveDateCheck = null;
	private TreeMap iLicensesFailingDueToDeliveryBlockDate = null;
	private TreeMap iLicensesFailingWithSvc = null;
	
	private TreeMap iSAndSExistingContractCoverage = null;
	private TreeMap iSAndSLicensesFailingRemovalDateCheck = null;
	private TreeMap iSAndSLicensesWithRejectionReason = null;
	private TreeMap iSAndSLicensesFailingLicenseEffectiveDateCheck = null;
	private TreeMap iSAndSLicensesFailingDueToDeleveryBlockDate = null;
	private TreeMap iSAndSLicensesFailingWithSvc = null;
	
	private boolean iShowExistingContractCoverage = false;
	private boolean iShowLicensesFailingRemovalDateCheck = false;
	private boolean iShowLicensesWithRejectionReason = false;
	private boolean iShowLicensesFailingLicenseEffectiveDateCheck = false;
	private boolean iShowLicensesFailingDueToDeliveryBlockDate = false;
	private boolean iShowLicensesFailingWithSvc = false;
	
	private boolean iSandSShowExistingContractCoverage = false;
	private boolean iSandSShowLicensesFailingRemovalDateCheck = false;
	private boolean iSandSShowLicensesWithRejectionReason = false;
	private boolean iSandSShowLicensesFailingLicenseEffectiveDateCheck = false;
	private boolean iSandSShowLicensesFailingDueToDeliveryBlockDate = false;
	private boolean iSandSShowLicensesFailingWithSvc = false;

	private boolean iSAndS = false;
	private String iMlcSandSOption = null;

	/**
	 * Returns the collection of licenses under existing contract coverage section. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap 
	 */
	public TreeMap getExistingContractCoverage() {
		return iExistingContractCoverage;
	}

	/**
	 * Returns the collection of licenses under licenses failing due to delivery block date section. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getLicensesFailingDueToDeliveryBlockDate() {
		return iLicensesFailingDueToDeliveryBlockDate;
	}

	/** 
	 * Returns the collection of licenses under licenses failing license effective date check section. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getLicensesFailingLicenseEffectiveDateCheck() {
		return iLicensesFailingLicenseEffectiveDateCheck;
	}

	/**
	 * Returns the collection of licenses under licenses failing removal date check section. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getLicensesFailingRemovalDateCheck() {
		return iLicensesFailingRemovalDateCheck;
	}

	/**
	 * Returns the collection of licenses under licenses with rejection section. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getLicensesWithRejectionReason() {
		return iLicensesWithRejectionReason;
	}

	/**
	 * Shows true if existing contract coverage section is to be shown to the user. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean 
	 */
	public TreeMap getLicensesFailingWithSvc() {
		return iLicensesFailingWithSvc;
	}
	public boolean isShowExistingContractCoverage() {
		return iShowExistingContractCoverage;
	}

	/** 
	 * Shows true if licenses failing due to delivery block date  section is to be shown to the user. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean 
	 */
	public boolean isShowLicensesFailingDueToDeliveryBlockDate() {
		return iShowLicensesFailingDueToDeliveryBlockDate;
	}

	/** 
	 * Shows true if licenses failing license effective date check section is to be shown to the user. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isShowLicensesFailingLicenseEffectiveDateCheck() {
		return iShowLicensesFailingLicenseEffectiveDateCheck;
	}

	/**
	 * Shows true if licenses failing license failing removal date check section is to be shown to the user. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isShowLicensesFailingRemovalDateCheck() {
		return iShowLicensesFailingRemovalDateCheck;
	}

	/** 
	 * Shows true if licenses with rejection reason section is to be shown to the user. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isShowLicensesWithRejectionReason() {
		return iShowLicensesWithRejectionReason;
	}
	public boolean isShowLicensesFailingWithSvc() {
		return iShowLicensesFailingWithSvc;
		
	}

	/**
	 * Sets the existing contract converage licenses collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newExistingContractCoverage TreeMap 
	 */
	
	public void setExistingContractCoverage(TreeMap newExistingContractCoverage) {
		iExistingContractCoverage = newExistingContractCoverage;
	}

	/**
	 * Sets the licenses failing due to delivery block date collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicensesFailingDueToDeliveryBlockDate TreeMap 
	 */
	public void setLicensesFailingDueToDeliveryBlockDate(TreeMap newLicensesFailingDueToDeliveryBlockDate) {
		iLicensesFailingDueToDeliveryBlockDate = newLicensesFailingDueToDeliveryBlockDate;
	}

	/**
     * Sets the licenses failing license effective date check collection
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 19, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newLicensesFailingLicenseEffectiveDateCheck 
     */
	public void setLicensesFailingLicenseEffectiveDateCheck(TreeMap newLicensesFailingLicenseEffectiveDateCheck) {
		iLicensesFailingLicenseEffectiveDateCheck = newLicensesFailingLicenseEffectiveDateCheck;
	}

	/**
	 * Sets licenses failing removal date check collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicensesFailingRemovalDateCheck TreeMap 
	 */
	public void setLicensesFailingRemovalDateCheck(TreeMap newLicensesFailingRemovalDateCheck) {
		iLicensesFailingRemovalDateCheck = newLicensesFailingRemovalDateCheck;
	}

	/**
	 * Sets licenses with rejection reasin collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicensesWithRejectionReason TreeMap 
	 */
	public void setLicensesWithRejectionReason(TreeMap newLicensesWithRejectionReason) {
		iLicensesWithRejectionReason = newLicensesWithRejectionReason;
	}
	public void setLicensesFailingWithSvc(TreeMap newLicensesFailingWithSvc) {
		iLicensesFailingWithSvc = newLicensesFailingWithSvc;
	}

	/**
	 *  sets the showExistingContractCoverage flag
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShowExistingContractCoverage boolean 
	 */
	
	public void setShowExistingContractCoverage(boolean newShowExistingContractCoverage) {
		iShowExistingContractCoverage = newShowExistingContractCoverage;
	}

	/**
	 * sets showLicensesFailingDueToDeliveryBlockDate flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShowLicensesFailingDueToDeliveryBlockDate boolean 
	 */
	public void setShowLicensesFailingDueToDeliveryBlockDate(boolean newShowLicensesFailingDueToDeliveryBlockDate) {
		iShowLicensesFailingDueToDeliveryBlockDate = newShowLicensesFailingDueToDeliveryBlockDate;
	}

	/**
	 * sets showLicensesFailingLicenseEffectiveDateCheck flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShowLicensesFailingLicenseEffectiveDateCheck boolean 
	 */
	public void setShowLicensesFailingLicenseEffectiveDateCheck(boolean newShowLicensesFailingLicenseEffectiveDateCheck) {
		iShowLicensesFailingLicenseEffectiveDateCheck = newShowLicensesFailingLicenseEffectiveDateCheck;
	}

	/**
	 * Sets showLicensesFailingRemovalDateCheck flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShowLicensesFailingRemovalDateCheck boolean 
	 */
	public void setShowLicensesFailingRemovalDateCheck(boolean newShowLicensesFailingRemovalDateCheck) {
		iShowLicensesFailingRemovalDateCheck = newShowLicensesFailingRemovalDateCheck;
	}

	/**
	 * Sets showLicensesWithRejectionReason flag
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShowLicensesWithRejectionReason boolean 
	 */
	public void setShowLicensesWithRejectionReason(boolean newShowLicensesWithRejectionReason) {
		iShowLicensesWithRejectionReason = newShowLicensesWithRejectionReason;
	}
	
	public void setShowLicensesFailingWithSvc(boolean newShowLicensesFailingWithSvc) {
		iShowLicensesFailingWithSvc = newShowLicensesFailingWithSvc;
	}
	
	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param existingContractCoverage TreeMap
	 * @param licensesFailingRemovalDateCheck TreeMap
	 * @param licensesWithRejectionReason TreeMap
	 * @param licensesFailingLicenseEffectiveDateCheck  TreeMap
	 * @param licensesFailingDueToDeliveryBlockDate TreeMap
	 */
	public void setData(TreeMap existingContractCoverage, TreeMap licensesFailingRemovalDateCheck,
						TreeMap licensesWithRejectionReason, TreeMap licensesFailingLicenseEffectiveDateCheck, 
						TreeMap licensesFailingDueToDeliveryBlockDate,TreeMap licensesFailingWithSvc){
		setExistingContractCoverage(existingContractCoverage);
		setLicensesFailingRemovalDateCheck(licensesFailingRemovalDateCheck);
		setLicensesWithRejectionReason(licensesWithRejectionReason);
		setLicensesFailingLicenseEffectiveDateCheck(licensesFailingLicenseEffectiveDateCheck);
		setLicensesFailingDueToDeliveryBlockDate(licensesFailingDueToDeliveryBlockDate);
		setLicensesFailingWithSvc(licensesFailingWithSvc);
	}

	/**
	 * Adds a new license under existing contract coverage section  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ineligibleLicense IneligibleSWOViewBean
	 */	
	public void addExistingContractCoverage(IneligibleSWOViewBean ineligibleLicense){
		if(null != ineligibleLicense){
			if(null == iExistingContractCoverage){
				iExistingContractCoverage = new TreeMap();
			}
			iExistingContractCoverage.put(ineligibleLicense.getId(), ineligibleLicense);
		}
	}

	/**
	 * Adds new license under licenses failing removal date check  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ineligibleLicense IneligibleSWOViewBean
	 */
	public void addLicensesFailingRemovalDateCheck(IneligibleSWOViewBean ineligibleLicense){
		if(null != ineligibleLicense){
			if(null == iLicensesFailingRemovalDateCheck){
				iLicensesFailingRemovalDateCheck = new TreeMap();
			}
			iLicensesFailingRemovalDateCheck.put(ineligibleLicense.getId(), ineligibleLicense);
		}
	}

	/**
	 * Adds new license under licenses with rejection reason section   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ineligibleLicense IneligibleSWOViewBean
	 */
	public void addLicensesWithRejectionReason(IneligibleSWOViewBean ineligibleLicense){
		if(null != ineligibleLicense){
			if(null == iLicensesWithRejectionReason){
				iLicensesWithRejectionReason = new TreeMap();
			}
			iLicensesWithRejectionReason.put(ineligibleLicense.getId(), ineligibleLicense);
		}
	}

	/**
	 * Adds new license under licenses failing license effective date check section  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ineligibleLicense IneligibleSWOCustomDTO
	 */
	public void addLicensesFailingLicenseEffectiveDateCheck(IneligibleSWOViewBean ineligibleLicense){
		if(null != ineligibleLicense){
			if(null == iLicensesFailingLicenseEffectiveDateCheck){
				iLicensesFailingLicenseEffectiveDateCheck = new TreeMap();
			}
			iLicensesFailingLicenseEffectiveDateCheck.put(ineligibleLicense.getId(), ineligibleLicense);
		}
	}

	/**
	 * Adds new license under licenses failing due to delivery block date collection  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ineligibleLicense IneligibleSWOViewBean
	 */
	public void addLicensesFailingDueToDeliveryBlockDate(IneligibleSWOViewBean ineligibleLicense){
		if(null != ineligibleLicense){
			if(null == iLicensesFailingDueToDeliveryBlockDate){
				iLicensesFailingDueToDeliveryBlockDate = new TreeMap();
			}
			iLicensesFailingDueToDeliveryBlockDate.put(ineligibleLicense.getId(), ineligibleLicense);
		}
	}
	public void addLicensesFailingWithSvc(IneligibleSWOViewBean ineligibleLicense){
		if(null != ineligibleLicense){
			if(null == iLicensesFailingWithSvc){
				iLicensesFailingWithSvc = new TreeMap();
			}
			iLicensesFailingWithSvc.put(ineligibleLicense.getId(), ineligibleLicense);
		}
	}
	
		
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(IneligibleLicensesCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			
			setExistingContractCoverage(populateIneligibleLicenses(customDTO.getExistingContractCoverage()));
			setLicensesFailingRemovalDateCheck(populateIneligibleLicenses(customDTO.getLicensesFailingRemovalDateCheck()));
			setLicensesWithRejectionReason(populateIneligibleLicenses(customDTO.getLicensesWithRejectionReason()));
			setLicensesFailingLicenseEffectiveDateCheck(populateIneligibleLicenses(customDTO.getLicensesFailingLicenseEffectiveDateCheck()));
			setLicensesFailingDueToDeliveryBlockDate(populateIneligibleLicenses(customDTO.getLicensesFailingDueToDeleveryBlockDate()));
			setLicensesFailingWithSvc(populateIneligibleLicenses(customDTO.getLicensesFailingWithSvc()));
			setSAndS(customDTO.isSAndS());
			if(isSAndS()){
				setSAndSExistingContractCoverage(populateIneligibleLicenses(customDTO.getSAndSExistingContractCoverage()));
				setSAndSLicensesFailingRemovalDateCheck(populateIneligibleLicenses(customDTO.getSAndSLicensesFailingRemovalDateCheck()));
				setSAndSLicensesWithRejectionReason(populateIneligibleLicenses(customDTO.getSAndSLicensesWithRejectionReason()));
				setSAndSLicensesFailingLicenseEffectiveDateCheck(populateIneligibleLicenses(customDTO.getSAndSLicensesFailingLicenseEffectiveDateCheck()));
				setSAndSLicensesFailingDueToDeleveryBlockDate(populateIneligibleLicenses(customDTO.getSAndSLicensesFailingDueToDeleveryBlockDate()));
				setSAndSLicensesFailingWithSvc(populateIneligibleLicenses(customDTO.getSAndSLicensesFailingWithSvc()));
				setMlcSandSOption(customDTO.getMlcSandSOption());
			}
		}
	}
	
	private TreeMap populateIneligibleLicenses(TreeMap sourceCollection) {
		TreeMap targetCollection = null;
		if(null != sourceCollection){
			targetCollection = new TreeMap();
			Iterator swoIterator = sourceCollection.values().iterator();
			if(null != swoIterator){
				while(swoIterator.hasNext()){
					IneligibleSWOCustomDTO swo = (IneligibleSWOCustomDTO)swoIterator.next();
					if(null != swo){
						IneligibleSWOViewBean swoView = new IneligibleSWOViewBean(swo);
						targetCollection.put(swoView.getId(), swoView);
					}
				}
			}
		}
		return targetCollection;
	}
	
	
	/**
     * IneligibleLicencesViewBean
     * 
     * @author thirumalai
     */
    public IneligibleLicencesViewBean(){
	}
	/**
     * IneligibleLicencesViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public IneligibleLicencesViewBean(IneligibleLicensesCustomDTO customDTO){
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSAndS() {
		return iSAndS;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getSAndSExistingContractCoverage() {
		return iSAndSExistingContractCoverage;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getSAndSLicensesFailingDueToDeleveryBlockDate() {
		return iSAndSLicensesFailingDueToDeleveryBlockDate;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getSAndSLicensesFailingLicenseEffectiveDateCheck() {
		return iSAndSLicensesFailingLicenseEffectiveDateCheck;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getSAndSLicensesFailingRemovalDateCheck() {
		return iSAndSLicensesFailingRemovalDateCheck;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getSAndSLicensesWithRejectionReason() {
		return iSAndSLicensesWithRejectionReason;
	}
	
	public TreeMap getSAndSLicensesFailingWithSvc() {
		return iSAndSLicensesFailingWithSvc;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSAndS(boolean b) {
		iSAndS = b;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setSAndSExistingContractCoverage(TreeMap map) {
		iSAndSExistingContractCoverage = map;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setSAndSLicensesFailingDueToDeleveryBlockDate(TreeMap map) {
		iSAndSLicensesFailingDueToDeleveryBlockDate = map;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setSAndSLicensesFailingLicenseEffectiveDateCheck(TreeMap map) {
		iSAndSLicensesFailingLicenseEffectiveDateCheck = map;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setSAndSLicensesFailingRemovalDateCheck(TreeMap map) {
		iSAndSLicensesFailingRemovalDateCheck = map;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setSAndSLicensesWithRejectionReason(TreeMap map) {
		iSAndSLicensesWithRejectionReason = map;
	}

	public void setSAndSLicensesFailingWithSvc(TreeMap map) {
		iSAndSLicensesFailingWithSvc = map;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSandSShowExistingContractCoverage() {
		return iSandSShowExistingContractCoverage;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSandSShowLicensesFailingDueToDeliveryBlockDate() {
		return iSandSShowLicensesFailingDueToDeliveryBlockDate;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSandSShowLicensesFailingLicenseEffectiveDateCheck() {
		return iSandSShowLicensesFailingLicenseEffectiveDateCheck;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSandSShowLicensesFailingRemovalDateCheck() {
		return iSandSShowLicensesFailingRemovalDateCheck;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSandSShowLicensesWithRejectionReason() {
		return iSandSShowLicensesWithRejectionReason;
	}
	
	public boolean isSandSShowLicensesFailingWithSvc() {
		return iSandSShowLicensesFailingWithSvc;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSandSShowExistingContractCoverage(boolean b) {
		iSandSShowExistingContractCoverage = b;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSandSShowLicensesFailingDueToDeliveryBlockDate(boolean b) {
		iSandSShowLicensesFailingDueToDeliveryBlockDate = b;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSandSShowLicensesFailingLicenseEffectiveDateCheck(boolean b) {
		iSandSShowLicensesFailingLicenseEffectiveDateCheck = b;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSandSShowLicensesFailingRemovalDateCheck(boolean b) {
		iSandSShowLicensesFailingRemovalDateCheck = b;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSandSShowLicensesWithRejectionReason(boolean b) {
		iSandSShowLicensesWithRejectionReason = b;
	}
	
	public void setSandSShowLicensesFailingWithSvc(boolean b) {
		iSandSShowLicensesFailingWithSvc = b;
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
	 * date Mar 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getMlcSandSOption() {
		return iMlcSandSOption;
	}

	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 15, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param mlcOption 
     */
	public void setMlcSandSOption(String mlcOption) {
		iMlcSandSOption = mlcOption;
	}
	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#selectAll() 
	 *  
	 * 
	 */
	public void selectAll() {
		setSelected(iLicensesFailingLicenseEffectiveDateCheck, true);
		setSelected(iLicensesFailingDueToDeliveryBlockDate, true);
		setSelected(iSAndSLicensesFailingLicenseEffectiveDateCheck, true);
		setSelected(iSAndSLicensesFailingDueToDeleveryBlockDate, true);

		iShowLicensesFailingLicenseEffectiveDateCheck = true;
		iShowLicensesFailingDueToDeliveryBlockDate = true;
		iSandSShowLicensesFailingLicenseEffectiveDateCheck = true;
		iSandSShowLicensesFailingDueToDeliveryBlockDate = true;
	}

	/**
     * clearAll
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#clearAll()
     * @author thirumalai
     */
    public void clearAll() {
		setSelected(iLicensesFailingLicenseEffectiveDateCheck, false);
		setSelected(iLicensesFailingDueToDeliveryBlockDate, false);
		setSelected(iSAndSLicensesFailingLicenseEffectiveDateCheck, false);
		setSelected(iSAndSLicensesFailingDueToDeleveryBlockDate, false);
	}
	
	private void setSelected(TreeMap ineligibleCollection, boolean selected){
		if(null != ineligibleCollection){
			Iterator iterator = ineligibleCollection.values().iterator();
			while(iterator.hasNext()){
				IneligibleSWOViewBean swo = (IneligibleSWOViewBean)iterator.next();
				if(null != swo){
					swo.setSelected(selected); 
				}
			}
		}
	}
}