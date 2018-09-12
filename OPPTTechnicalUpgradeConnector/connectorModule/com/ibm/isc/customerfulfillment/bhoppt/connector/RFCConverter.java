/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector;

import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.InputConnectorDTOSerializerInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.OutputConnectorDTODeserializerInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * Generic Remore Function Call handler.  Based on the RFC Name, it invokes
 * the createMsg method using the corresponding class.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class RFCConverter {
	private static final String CLASS_NAME = "RFCConverter"; /* NOI18N */

	private String iRfcName;

	/** 
	 * Constructor
	 *  
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param aRfcName
	 * @throws Exception
	 */
	public RFCConverter(String aRfcName) throws Exception {
		iRfcName = aRfcName;
	}

	/**
	 * Create the message out of ConnectorDTO  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aInputConnectorDTO
	 * @return message string
	 */
	public String createMsgString(ConnectorDTOInterface aInputConnectorDTO) {
		String returnString = null;

		try {
			InputConnectorDTOSerializerInterface inputSerializer =
				(InputConnectorDTOSerializerInterface) ConnectorUtility.getObject(
					ConnectorUtility.getObjectName(aInputConnectorDTO.getClass().getName())
						+ ConnectorConstants.SERIALZIER);

			returnString = inputSerializer.createNewMsg(aInputConnectorDTO);
		} catch (Exception ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "createMsgString", null, ex);
		}

		return returnString;
	}

	/**
	 * Creates the ConnectorDTO out of given string.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param msgString
	 * @return ConnectorDTO
	 */
	public ConnectorDTOInterface parseMsgString(String msgString) {
		ConnectorDTOInterface connectorDTO = null;

		try {
			OutputConnectorDTODeserializerInterface outputDeserializer =
				(OutputConnectorDTODeserializerInterface) ConnectorUtility.getObjectByRFCName(iRfcName, false);

			connectorDTO =
				outputDeserializer.parseMsgString(
					new StringParser(msgString, ConnectorConstants.CONNECTOR_STRING_DELIMITOR),
					null);
		} catch (Exception ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "parseMsgString", null, ex);  /* NOI18N */
		}

		return connectorDTO;
	}

	/**
	 * To set the RFC Name  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aRFCName
	 */
	public void setRFCName(String aRFCName) {
		iRfcName = aRFCName;
	}
}
