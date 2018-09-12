/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;
import java.util.HashMap;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;
/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementReportsCustomDTO extends OPPTCustomDTO {
	
	private List BaseAgreementReportCustomDTOs = null;
	
	private HashMap BaseAgreementReportModificationMap = null;

	private List BaseAgreementReportDetailCustomDTOs = null;
	/**
	 * @return Returns the baseAgreementReportModificationMap.
	 */
	public HashMap getBaseAgreementReportModificationMap() {
		return BaseAgreementReportModificationMap;
	}
	/**
	 * @param baseAgreementReportModificationMap The baseAgreementReportModificationMap to set.
	 */
	public void setBaseAgreementReportModificationMap(
			HashMap baseAgreementReportModificationMap) {
		BaseAgreementReportModificationMap = baseAgreementReportModificationMap;
	}
	/**
	 * @return Returns the baseAgreementReportCustomDTOs.
	 */
	public List getBaseAgreementReportCustomDTOs() {
		return BaseAgreementReportCustomDTOs;
	}
	/**
	 * @param baseAgreementReportCustomDTOs The baseAgreementReportCustomDTOs to set.
	 */
	public void setBaseAgreementReportCustomDTOs(
			List baseAgreementReportCustomDTOs) {
		BaseAgreementReportCustomDTOs = baseAgreementReportCustomDTOs;
	}
	/**
	 * @return Returns the baseAgreementReportDetailCustomDTOs.
	 */
	public List getBaseAgreementReportDetailCustomDTOs() {
		return BaseAgreementReportDetailCustomDTOs;
	}
	/**
	 * @param baseAgreementReportDetailCustomDTOs The baseAgreementReportDetailCustomDTOs to set.
	 */
	public void setBaseAgreementReportDetailCustomDTOs(
			List baseAgreementReportDetailCustomDTOs) {
		BaseAgreementReportDetailCustomDTOs = baseAgreementReportDetailCustomDTOs;
	}
}
