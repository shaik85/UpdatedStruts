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
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class UpdateModificationInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface {
	
	public UpdateModificationInputConnectorDTOSerializer() {
		
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
		UpdateModificationInputConnectorDTO updateModificationInputConnectorDTO = (UpdateModificationInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		ConnectorUtility.buildMessage(updateModificationInputConnectorDTO.getFunctionModuleName(),buffer);
		ConnectorUtility.buildMessage(updateModificationInputConnectorDTO.getSessionID(),buffer);
		ConnectorUtility.buildMessage(updateModificationInputConnectorDTO.getAgreementId(),buffer);
		ConnectorUtility.buildMessage(updateModificationInputConnectorDTO.getModificationType(),buffer);
		ConnectorUtility.buildMessage(updateModificationInputConnectorDTO.getModificationOption(),buffer);
		ConnectorUtility.buildMessage(updateModificationInputConnectorDTO.getModificationDescription(),buffer);
		ConnectorUtility.buildMessage(updateModificationInputConnectorDTO.getModificationActive(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(updateModificationInputConnectorDTO.getRolStartDate(),ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(updateModificationInputConnectorDTO.getRolEndDate(),ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(updateModificationInputConnectorDTO.getRevenueRecognition(),buffer);
		ConnectorUtility.buildMessage(updateModificationInputConnectorDTO.getCreatedBy(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(updateModificationInputConnectorDTO.getCreatedOn(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(updateModificationInputConnectorDTO.getChangedBy(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(updateModificationInputConnectorDTO.getChangedOn(), ConnectorConstants.DATE_FORMAT),buffer);
		
		return buffer.toString();
	}


}
