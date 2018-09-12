/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO;

/**
 * BaseAgreement Report Excel ViewBean
 * @author balajiv
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementReportExcelViewBean extends OPPTViewBean {
	
	private BaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO = null;

	
	
    /**
     *this is the getter method for baseAgreementReportsCustomDTO 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:04:35 PM
     *
     * @return BaseAgreementReportsCustomDTO.
     */
    public BaseAgreementReportsCustomDTO getBaseAgreementReportsCustomDTO() {
        return baseAgreementReportsCustomDTO;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:04:35 PM
     * @param lBaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO.
     */
    public void setBaseAgreementReportsCustomDTO(
            BaseAgreementReportsCustomDTO lBaseAgreementReportsCustomDTO) {
        baseAgreementReportsCustomDTO = lBaseAgreementReportsCustomDTO;
    }
}
