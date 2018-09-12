/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;



import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;

/**
 * @author balajiv
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CreateModificationInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface {
	
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
	public CreateModificationInputConnectorDTOSerializer() {
		
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
		CreateModificationInputConnectorDTO createModificationInputConnectorDTO = (CreateModificationInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		ConnectorUtility.buildMessage(createModificationInputConnectorDTO.getFunctionModuleName(),buffer);
		ConnectorUtility.buildMessage(createModificationInputConnectorDTO.getSessionID(),buffer);
		ConnectorUtility.buildMessage(createModificationInputConnectorDTO.getAgreementId(),buffer);
		ConnectorUtility.buildMessage(createModificationInputConnectorDTO.getModificationType(),buffer);
		ConnectorUtility.buildMessage(createModificationInputConnectorDTO.getModificationOption(),buffer);
		ConnectorUtility.buildMessage(createModificationInputConnectorDTO.getModificationDescription(),buffer);
		ConnectorUtility.buildMessage(createModificationInputConnectorDTO.getModificationActive(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createModificationInputConnectorDTO.getRolStartDate(), ConnectorConstants.DATE_FORMAT),buffer);
		if(BaseAgreementModificationConstants.ROL.equals(createModificationInputConnectorDTO.getModificationType()) &&
		   createModificationInputConnectorDTO.getRolEndDate() == null) {
			ConnectorUtility.buildMessage(ConnectorConstants.DEFAULT_EXPIRATION_DATE,buffer);
		}else {
			ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createModificationInputConnectorDTO.getRolEndDate(), ConnectorConstants.DATE_FORMAT),buffer);
		}
		ConnectorUtility.buildMessage(createModificationInputConnectorDTO.getRevenueRecognition(),buffer);
		ConnectorUtility.buildMessage(createModificationInputConnectorDTO.getCreatedBy(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createModificationInputConnectorDTO.getCreatedOn(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(createModificationInputConnectorDTO.getChangedBy(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createModificationInputConnectorDTO.getChangedOn(), ConnectorConstants.DATE_FORMAT),buffer);
		
		return buffer.toString();
	}
}
