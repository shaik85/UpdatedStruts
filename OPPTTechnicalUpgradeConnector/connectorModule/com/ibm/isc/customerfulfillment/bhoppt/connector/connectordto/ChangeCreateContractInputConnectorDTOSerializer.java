/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;

/** 
 * Input connector DTO serializer 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 12, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Arun Nagarajan
 * @version 5.1A 
 */
public class ChangeCreateContractInputConnectorDTOSerializer
	implements InputConnectorDTOSerializerInterface {

	private static final String BE_SPECIFIC_DUMMY_CHAR = "X"; /* NOI18N */
	/** 
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Mar 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public ChangeCreateContractInputConnectorDTOSerializer() {
	}

	/**
	 * This method is used to parse the given object and build object
	 * a String out of it.
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param connectorDTO
	 * @return String newmessage
	 * @throws Exception
	 */
	public String createNewMsg(ConnectorDTOInterface connectorDTO) throws Exception{
		ChangeCreateContractInputConnectorDTO connectorInputDTO = (ChangeCreateContractInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		
		ConnectorUtility.buildMessage(connectorInputDTO.getChangeContractDTO(),buffer);
		StringBuffer crazyBuffer = new StringBuffer();
		for(int i=buffer.length();i<1023;i++){
			buffer.append(BE_SPECIFIC_DUMMY_CHAR);
		}
		ConnectorUtility.buildMessage(crazyBuffer.toString(),buffer);
		ConnectorUtility.buildMessage(connectorInputDTO.getCreateContractDTO(),buffer);
		return buffer.toString();
	}
}