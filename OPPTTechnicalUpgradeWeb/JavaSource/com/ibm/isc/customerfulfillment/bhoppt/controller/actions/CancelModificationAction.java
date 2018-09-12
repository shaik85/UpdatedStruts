/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BaseAgreementActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementFormViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;

/**
 * Cancel Modification Action
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class CancelModificationAction extends OPPTAction {
	/**
	 * Overridden method - Enter your description here.
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date Oct 28, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 *  
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
			throws Exception {

		session.setBackButtonAllowed(true);
		OPPTViewBean viewBean = session.getCurrentViewBean();
		setForwardName(session.getCurrentForward());
		return viewBean;

	}

	/**
	 * Overridden method - Enter your description here.
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date Oct 28, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getActionName()
	 * @return
	 *  
	 */
	protected String getActionName() {
		// TODO Auto-generated method stub
		return "CancelModificationAction"; //$NON-NLS-1$
	}

	/**
	 * Overridden method - Enter your description here.
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date Oct 28, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @param session
	 * @return
	 *  
	 */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		TreeMap formDetailsMap = new TreeMap();
		TreeMap coverageTypeMap = new TreeMap();
		TreeMap salesOrgMap = new TreeMap();
		if (null != OPPTStaticDataHolder.formNumberMap
				&& null != OPPTStaticDataHolder.salesOrgMapForBaseAgreement
				&& null != OPPTStaticDataHolder.coverageTypeMap) {

			coverageTypeMap = new TreeMap();
			formDetailsMap = new TreeMap();
			salesOrgMap = new TreeMap();
			formDetailsMap.putAll(OPPTStaticDataHolder.formNumberMap);
			salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
			coverageTypeMap.putAll(OPPTStaticDataHolder.coverageTypeMap);
		}
		if (null != viewBean
				&& null != currentForward
				&& (currentForward.equals(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION) || currentForward.equals(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND)))
		{			// actualForward = forwardCreate;
			if (viewBean instanceof DisplayModificationViewBean) {
				valid = true;
				BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO = (BaseAgreementDetailsCustomDTO) session
						.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
				if (baseAgreementDetailsCustomDTO != null
						&& baseAgreementDetailsCustomDTO.getAgreementId() > 0) {

					if (null != baseAgreementDetailsCustomDTO) {

						BaseAgreementDetailViewBean baseAgreementDetailViewBean = new BaseAgreementDetailViewBean(baseAgreementDetailsCustomDTO);
						baseAgreementDetailViewBean.setCoverageTypeMap(coverageTypeMap);
						baseAgreementDetailViewBean.setFormDetailsMap(formDetailsMap);
						baseAgreementDetailViewBean.setSalesOrgMap(salesOrgMap);
						session.setCurrentViewBean(baseAgreementDetailViewBean);
						session.setCurrentForward(ForwardNameConstants.PAGE_AMEND_BASEAGREEMENT);
					} else {

						session.setCurrentViewBean(new BaseAgreementDetailViewBean());
						session.setCurrentForward(ForwardNameConstants.PAGE_AMEND_BASEAGREEMENT);
					}

				} else if (baseAgreementDetailsCustomDTO != null && baseAgreementDetailsCustomDTO.getAgreementId() == 0) {
					if (null != baseAgreementDetailsCustomDTO) {
						BaseAgreementActionForm baseAgreementActionForm = (BaseAgreementActionForm) session.getObjectFromSession(SessionConstants.SESSION_BASEAGREEMENT_ACTIONFORM);
						BaseAgreementFormViewBean  baseAgreementFormViewBean = new BaseAgreementFormViewBean(baseAgreementActionForm);
						baseAgreementFormViewBean.setCoverageTypeDetails(coverageTypeMap);
						baseAgreementFormViewBean.setFormDetails(formDetailsMap);
						baseAgreementFormViewBean.setSalesOrg(salesOrgMap);
						session.setCurrentViewBean(baseAgreementFormViewBean);
						session.setCurrentForward(ForwardNameConstants.PAGE_CREATE_BASEAGREEMENT);
					} else {
						session.setCurrentViewBean(new BaseAgreementFormViewBean());
						session.setCurrentForward(ForwardNameConstants.PAGE_CREATE_BASEAGREEMENT);
					}
				}

			}
		}
		return valid;
	}

}
