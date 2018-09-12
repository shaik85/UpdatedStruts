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
public class UpdateBaseAgreementInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface {
	
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
	public UpdateBaseAgreementInputConnectorDTOSerializer() {
		
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
		UpdateBaseAgreementInputConnectorDTO updateBaseAgreementInputConnectorDTO = (UpdateBaseAgreementInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getFunctionModuleName(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getSessionID(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getSalesOrganization(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getCustomerNo(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getEnterpriseNo(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getAgreementId(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getAgreementNo(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getAgreementStatus(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getCustomerName(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getEnterpriseName(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getFormNo(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getFormShortDescription(),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getCoverageType(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(updateBaseAgreementInputConnectorDTO.getAcceptDate(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(updateBaseAgreementInputConnectorDTO.getExpirationDate(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(updateBaseAgreementInputConnectorDTO.getChangedBy(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(updateBaseAgreementInputConnectorDTO.getChangedOn(), ConnectorConstants.DATE_FORMAT),buffer);
		
		return buffer.toString();
	}

}
