/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import java.util.StringTokenizer;

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateBaseAgreementInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateModificationInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.UpdateBaseAgreementInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.UpdateModificationInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementModificationDetailsBO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;

/**
 * @author balajiv
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementConnectorDTOBuilder {
	
	public static CreateBaseAgreementInputConnectorDTO buildCreateBaseAgreementInputConnectorDTO(BaseAgreementBO baseAgreementBO) {
		CreateBaseAgreementInputConnectorDTO createBaseAgreementInputConnectorDTO = new CreateBaseAgreementInputConnectorDTO();
		
		createBaseAgreementInputConnectorDTO.setSalesOrganization(baseAgreementBO.getSalesOrganization());
		createBaseAgreementInputConnectorDTO.setCustomerNo(baseAgreementBO.getCustomerNumber());
		createBaseAgreementInputConnectorDTO.setEnterpriseNo(baseAgreementBO.getEnterpriseNumber());
		createBaseAgreementInputConnectorDTO.setAgreementId(""+baseAgreementBO.getAgreementId());
		createBaseAgreementInputConnectorDTO.setAgreementNo(baseAgreementBO.getAgreementNumber());
		createBaseAgreementInputConnectorDTO.setAgreementStatus(baseAgreementBO.getAgreementStatus());
		createBaseAgreementInputConnectorDTO.setCustomerName(baseAgreementBO.getCustomerName());
		createBaseAgreementInputConnectorDTO.setEnterpriseName(baseAgreementBO.getEnterpriseName());
		createBaseAgreementInputConnectorDTO.setFormNo(baseAgreementBO.getFormNumber());
		createBaseAgreementInputConnectorDTO.setFormShortDescription(getFormShortDesc(baseAgreementBO.getFormNumber()));
		createBaseAgreementInputConnectorDTO.setCoverageType(baseAgreementBO.getCoverageType());
		createBaseAgreementInputConnectorDTO.setAcceptDate(baseAgreementBO.getAcceptedDate());
		createBaseAgreementInputConnectorDTO.setExpirationDate(baseAgreementBO.getExpirationDate());
		createBaseAgreementInputConnectorDTO.setCreatedBy(baseAgreementBO.getCreatedBy());
		createBaseAgreementInputConnectorDTO.setCreatedOn(baseAgreementBO.getCreatedDate());
		createBaseAgreementInputConnectorDTO.setChangedBy(baseAgreementBO.getChangedBy());
		createBaseAgreementInputConnectorDTO.setChangedOn(baseAgreementBO.getChangedDate());
		
		return createBaseAgreementInputConnectorDTO;
	}
	
	
	public static UpdateBaseAgreementInputConnectorDTO buildUpdateBaseAgreementInputConnectorDTO(BaseAgreementBO baseAgreementBO) {
		UpdateBaseAgreementInputConnectorDTO updateBaseAgreementInputConnectorDTO = new UpdateBaseAgreementInputConnectorDTO();
		
		updateBaseAgreementInputConnectorDTO.setSalesOrganization(baseAgreementBO.getSalesOrganization());
		updateBaseAgreementInputConnectorDTO.setCustomerNo(baseAgreementBO.getCustomerNumber());
		updateBaseAgreementInputConnectorDTO.setEnterpriseNo(baseAgreementBO.getEnterpriseNumber());
		updateBaseAgreementInputConnectorDTO.setAgreementId(""+baseAgreementBO.getAgreementId());
		updateBaseAgreementInputConnectorDTO.setAgreementNo(baseAgreementBO.getAgreementNumber());
		updateBaseAgreementInputConnectorDTO.setAgreementStatus(baseAgreementBO.getAgreementStatus());
		updateBaseAgreementInputConnectorDTO.setCustomerName(baseAgreementBO.getCustomerName());
		updateBaseAgreementInputConnectorDTO.setEnterpriseName(baseAgreementBO.getEnterpriseName());
		updateBaseAgreementInputConnectorDTO.setFormNo(baseAgreementBO.getFormNumber());
		updateBaseAgreementInputConnectorDTO.setFormShortDescription(getFormShortDesc(baseAgreementBO.getFormNumber()));
		updateBaseAgreementInputConnectorDTO.setCoverageType(baseAgreementBO.getCoverageType());
		updateBaseAgreementInputConnectorDTO.setAcceptDate(baseAgreementBO.getAcceptedDate());
		updateBaseAgreementInputConnectorDTO.setExpirationDate(baseAgreementBO.getExpirationDate());
		updateBaseAgreementInputConnectorDTO.setChangedBy(baseAgreementBO.getChangedBy());
		updateBaseAgreementInputConnectorDTO.setChangedOn(baseAgreementBO.getChangedDate());
		
		return updateBaseAgreementInputConnectorDTO;
	}
	
	
	public static CreateModificationInputConnectorDTO buildCreateModificationInputConnectorDTO(BaseAgreementBO baseAgreementBO, BaseAgreementModificationDetailsBO modDetailsBO) {
		CreateModificationInputConnectorDTO createModificationInputConnectorDTO = new CreateModificationInputConnectorDTO();
		
		createModificationInputConnectorDTO.setAgreementId(""+baseAgreementBO.getAgreementId());
		createModificationInputConnectorDTO.setModificationType(modDetailsBO.getModificationTypeCode());
		
		if(BaseAgreementModificationConstants.ROL.equals(modDetailsBO.getModificationTypeCode())) {
//			 ROL SPECIFIC
			createModificationInputConnectorDTO.setModificationOption(modDetailsBO.getModificationOption());	
			createModificationInputConnectorDTO.setModificationDescription(OPPTStaticDataHolder.getRolOptions(modDetailsBO.getModificationOption()));
			createModificationInputConnectorDTO.setRolStartDate(modDetailsBO.getRolStartDate());
			createModificationInputConnectorDTO.setRolEndDate(modDetailsBO.getRolEndDate());
		}
		// For Modification Status we set Agreement Status 
		createModificationInputConnectorDTO.setModificationActive(modDetailsBO.getModStatus());
		createModificationInputConnectorDTO.setRevenueRecognition(modDetailsBO.getRevenueRecognition());
		createModificationInputConnectorDTO.setCreatedBy(baseAgreementBO.getCreatedBy());
		createModificationInputConnectorDTO.setCreatedOn(baseAgreementBO.getCreatedDate());
		createModificationInputConnectorDTO.setChangedBy(baseAgreementBO.getChangedBy());
		createModificationInputConnectorDTO.setChangedOn(baseAgreementBO.getChangedDate());
		
		return createModificationInputConnectorDTO;
	}
	
	public static UpdateModificationInputConnectorDTO buildUpdateModificationInputConnectorDTO(BaseAgreementBO baseAgreementBO, BaseAgreementModificationDetailsBO modDetailsBO) {
		UpdateModificationInputConnectorDTO updateModificationInputConnectorDTO = new UpdateModificationInputConnectorDTO();
		
		updateModificationInputConnectorDTO.setAgreementId(""+baseAgreementBO.getAgreementId());
		updateModificationInputConnectorDTO.setModificationType(modDetailsBO.getModificationTypeCode());
		
		if(BaseAgreementModificationConstants.ROL.equals(modDetailsBO.getModificationTypeCode())) {
//			 ROL SPECIFIC
			updateModificationInputConnectorDTO.setModificationOption(modDetailsBO.getModificationOption());	
			updateModificationInputConnectorDTO.setModificationDescription(OPPTStaticDataHolder.getRolOptions(modDetailsBO.getModificationOption()));
			updateModificationInputConnectorDTO.setRolStartDate(modDetailsBO.getRolStartDate());
			updateModificationInputConnectorDTO.setRolEndDate(modDetailsBO.getRolEndDate());
		}
		// For Modification Status we set Agreement Status 
		updateModificationInputConnectorDTO.setModificationActive(modDetailsBO.getModStatus());
		updateModificationInputConnectorDTO.setRevenueRecognition(modDetailsBO.getRevenueRecognition());
		updateModificationInputConnectorDTO.setCreatedBy(baseAgreementBO.getCreatedBy());
		updateModificationInputConnectorDTO.setCreatedOn(baseAgreementBO.getCreatedDate());
		updateModificationInputConnectorDTO.setChangedBy(baseAgreementBO.getChangedBy());
		updateModificationInputConnectorDTO.setChangedOn(baseAgreementBO.getChangedDate());
		
		return updateModificationInputConnectorDTO;
	}
	
	private static String getFormShortDesc(String formNumber) {
		String formShortDesc = null;
		String formLongDesc = null;
		String salesOrg = null ;
		String totalFormDetail = OPPTStaticDataHolder.getFormDescription(formNumber);
		if(totalFormDetail != null) {
			StringTokenizer strTok = new StringTokenizer(totalFormDetail,"|");
			formLongDesc = strTok.nextToken();
			formShortDesc = strTok.nextToken();
			salesOrg = strTok.nextToken();			
			/* while(strTok.hasMoreElements()) {
				formShortDesc = (String) strTok.nextElement();
			} */
		}
		
		return formShortDesc;
	}

}
