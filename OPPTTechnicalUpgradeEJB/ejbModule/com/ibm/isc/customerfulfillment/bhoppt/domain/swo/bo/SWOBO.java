/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo;

import java.util.HashMap;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.LicenseConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/** 
 * This class checks the business condition against swobdo attributes* 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A 
 */
public class SWOBO extends SWOBDO {

	private ErrorReport errorReport = null;

	/**
	 * Validate and populate values for Status Checking
	 * Following will be populated 
	 * 1) Marked as locked
	 * 2) Calcuated price used for contract creation must be stored as old calculated price for all licenses 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param String
	 * @throws DomainException
	 */

	public boolean validateAndPopulateForStatusCheck(String noExternalContrAsso) throws DomainException {

		// Parm based - noExternalContrAssociated - NO  
		// If No,  
		//  	then 'set the lock ind' and OldCalcPrice  
		// if yes, check if external contract no associated
		// 		if true, then 'set the lock ind' and OldCalcPrice

		boolean updated = false;

		if (UtilityConstants.NO.equalsIgnoreCase(noExternalContrAsso)) {
			setLockedInd(UtilityConstants.YES);
			setOldCalcPrice(getCalcPrice());
			updated = true;
		} else {
			if (null == getSwoExtContrNo()) {
				setLockedInd(UtilityConstants.YES);
				setOldCalcPrice(getCalcPrice());
				updated = true;
			}
		}
		return updated;
	}

	/** 
	 * Checks whether the license is already excluded from Special pricing
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isLicenseExcluded() {
		boolean result = false;
		if (LicenseConstants.LICENSE_EXCLUDED.equals(getExclusionId())) {
			result = true;
		}
		return result;
	}

	/** 
	 * Checks whether the license is SVC
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isSVCLicense() {
		boolean result = false;
		if (LicenseConstants.SVC_LICENSE_FLAG.equals(getItemCategory())) {
			result = true;
		}
		return result;
	}

	/** 
	 * Checks whether alternate price is entered at SWO level
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isAlternatePriceAtSWOLevel() {
		boolean result = false;
		if (LicenseConstants.ALT_PRICE_SWOLEVEL.equals(getAlternatePriceUpdateInd())) {
			result = true;
		}
		return result;
	}

	/** 
	 * Checks whether the licenses is locked
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isLicenseLocked() {
		boolean result = false;
		if (LicenseConstants.LICENSE_LOCKED.equals(getLockedInd())) {
			result = true;
		}
		return result;
	}

	/** 
	 * Checks whether the licenses is S&S
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
	 * @return boolean
	 * @author Saravanan Viswanathan
	 */
	public boolean isSAndS() {
		boolean result = false;
		if (LicenseConstants.SS_LICENSE_FLAG.equals(getSAndSInd())) {
			result = true;
		}
		return result;
	}
	/** 
	 * Checks whether the license is amended
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isAmendedLicense() {
		boolean result = false;
		if (getAmendStartDate() != null || getAmendEndDate() != null) {
			result = true;
		}
		return result;
	}

	/** 
	 * Checks whether the license is already bumped
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isLicenseAlreadyBumped() {
		boolean result = false;
		String bumpInd = getBumpInd();
		if (bumpInd != null && bumpInd.startsWith(LicenseConstants.LICENSE_BUMPED)) {
			result = true;
		}
		return result;
	}

	/** 
	 * Validates whether SWO amendment can be performed
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param type
	 * @param compareValues
	 * @return boolean
	 * @throws DomainException 
	 */
	public boolean validateForAmendSWO(int type, HashMap compareValues) throws DomainException {
		boolean result = false;

		errorReport = new ErrorReport();
		boolean firstResult = isLicenseLocked();
		if (!firstResult) {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0615, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		boolean secondResult = isLicenseAlreadyBumped();
		if (secondResult) {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0616, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		boolean thirdResult = isSVCLicense();
		if (thirdResult) {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0617, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		boolean fourthResult = isAmendedLicense();
		if (fourthResult) {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0638, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		boolean fifthResult = true;
		if (UtilityConstants.BUSINESSRULE_OTHER_TYPE == type) {
			fifthResult = validateDatesForAmend(compareValues);
		}
		result = firstResult & !secondResult & !thirdResult & !fourthResult & fifthResult;
		if (!result) {
			throw ExceptionGenerator.generateDomainException(errorReport);
		}
		return result;
	}

	/*
	 * Validates the amendment dates of the SWO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param compareValues
	 * @return boolean
	 */
	private boolean validateDatesForAmend(HashMap compareValues) {
		boolean result = false;
		Date amendStartDate = null;
		Date amendEndDate = null;
		Date cpsDate = null;
		Date cpeDate = null;
		OPPTCalender calendar = new OPPTCalender();

		if (compareValues != null && compareValues.size() > 0) {
			amendStartDate = (Date) compareValues.get(UtilityConstants.LICENSE_AMEND_START);
			amendEndDate = (Date) compareValues.get(UtilityConstants.LICENSE_AMEND_END);
			cpsDate = (Date) compareValues.get(UtilityConstants.CONTRACT_PERIOD_START);
			cpeDate = (Date) compareValues.get(UtilityConstants.CONTRACT_PERIOD_END);

			if (calendar.isDateEqual(amendStartDate, cpsDate) || calendar.isDateGreater(amendStartDate, cpsDate)) {
				if (calendar.isDateLesser(amendStartDate, cpeDate)) {
					if (calendar.isDateLesser(amendStartDate, amendEndDate)) {
						if (calendar.isDateGreater(amendEndDate, cpsDate)) {
							if (calendar.isDateEqual(amendEndDate, cpeDate) || calendar.isDateLesser(amendEndDate, cpeDate)) {
								result = true;
							} else {
								ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0623, OPPTMessageCatalog.TYPE_DOMAIN);
							}
						} else {
							ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0622, OPPTMessageCatalog.TYPE_DOMAIN);
						}
					} else {
						ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0621, OPPTMessageCatalog.TYPE_DOMAIN);
					}
				} else {
					ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0619, OPPTMessageCatalog.TYPE_DOMAIN);
				}
			} else {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0618, OPPTMessageCatalog.TYPE_DOMAIN);
			}

		} else {
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0620, OPPTMessageCatalog.TYPE_DOMAIN);
		}
		return result;
	}

	/** 
	 * Validates whether the SWO change at EE level is allowed
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param type
	 * @return boolean
	 * @throws DomainException 
	 */
	public boolean validateChangeSWOWithEE(int type) throws DomainException {
		boolean result = false;
		if (UtilityConstants.BUSINESSRULE_OTHER_TYPE == type) {
			errorReport = new ErrorReport();
			boolean firstResult = isAlternatePriceAtSWOLevel();
			if (firstResult) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0607, OPPTMessageCatalog.TYPE_DOMAIN);
			}
			boolean secondResult = isLicenseLocked();
			if (secondResult) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0615, OPPTMessageCatalog.TYPE_DOMAIN);
			}
			boolean thirdResult = isSVCLicense();
			if (thirdResult) {
				ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0617, OPPTMessageCatalog.TYPE_DOMAIN);
			}
			result = firstResult & secondResult & thirdResult;
		} else {
			if (!isAlternatePriceAtSWOLevel()) {
				if (!isLicenseLocked()) {
					if (!isSVCLicense()) {
						result = true;
					}
				}
			}
		}
		return result;
	}

	/**
	 *  
	 * This method validates the swo values for copy bump action 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param type
	 * @param values
	 * @throws DomainException
	 * @author Ravishankar
	 */
	public void validateSWOForCopyBump(int type, HashMap values) throws DomainException {

		boolean result = false;

		Date bumpStartDate = (Date) values.get(UtilityConstants.PLAN_START_DATE);
		Date bumpEndDate = (Date) values.get(UtilityConstants.PLAN_END_DATE);
		Date planStartDate = getPlanStartDate();
		Date planEndDate = getPlanEndDate();
		OPPTCalender calender = new OPPTCalender();

		if ((calender.isDateEqual(bumpStartDate, planStartDate) || calender.isDateGreater(bumpStartDate, planStartDate)) && (calender.isDateLesser(bumpStartDate, planEndDate)) && (calender.isDateLesser(bumpStartDate, bumpEndDate)) && (calender.isDateEqual(bumpEndDate, planEndDate) || calender.isDateLesser(bumpEndDate, planEndDate))) {
			result = true;
		} else {
			errorReport = new ErrorReport();
			ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.DE0111, OPPTMessageCatalog.TYPE_DOMAIN);
			DomainException d = new DomainException();
			d.setErrorReport(errorReport);
			throw d;
		}
	}

	/** 
	 * Validates whether SWO is valid for S&S planning process
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 * @throws DomainException
	 * @author Saravanan Viswanathan 
	 */
	public boolean validateForSAndS() throws DomainException {
		boolean result = false;

		result = isSAndS();
		return result;
	}
}