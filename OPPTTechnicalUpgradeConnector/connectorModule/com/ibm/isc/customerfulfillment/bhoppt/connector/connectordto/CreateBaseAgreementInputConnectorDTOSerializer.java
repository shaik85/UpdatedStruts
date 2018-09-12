/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;

/**
 * @author balajiv
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CreateBaseAgreementInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface {
	
	/** 
	 * Constructor
	 *  
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */	
	public CreateBaseAgreementInputConnectorDTOSerializer() {
		
	}
	
	/**
	 * This method is used to parse the given object and build object
	 * a String out of it.
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param connectorDTO
	 * @return String created new message
	 * @throws Exception
	 */
	public String createNewMsg(ConnectorDTOInterface connectorDTO) throws Exception
	{
		CreateBaseAgreementInputConnectorDTO createBaseAgreementInputConnectorDTO = (CreateBaseAgreementInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getFunctionModuleName(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getSessionID(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getSalesOrganization(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getCustomerNo(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getEnterpriseNo(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getAgreementId(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getAgreementNo(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getAgreementStatus(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getCustomerName(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getEnterpriseName(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getFormNo(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getFormShortDescription(),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getCoverageType(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createBaseAgreementInputConnectorDTO.getAcceptDate(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createBaseAgreementInputConnectorDTO.getExpirationDate(), ConnectorConstants.DATE_FORMAT),buffer);		
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getCreatedBy(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createBaseAgreementInputConnectorDTO.getCreatedOn(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(createBaseAgreementInputConnectorDTO.getChangedBy(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createBaseAgreementInputConnectorDTO.getChangedOn(), ConnectorConstants.DATE_FORMAT),buffer);
		
		return buffer.toString();
	}

}
