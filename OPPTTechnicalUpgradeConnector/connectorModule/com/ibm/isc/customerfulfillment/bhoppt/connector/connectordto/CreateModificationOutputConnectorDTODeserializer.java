/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser;

/**
 * @author balajiv
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CreateModificationOutputConnectorDTODeserializer implements OutputConnectorDTODeserializerInterface {
	
	public CreateModificationOutputConnectorDTODeserializer() {
		
	}
	
	public ConnectorDTOInterface parseMsgString(StringParser tokenizer, ConnectorDTOInterface connectorDTO)
	throws Exception
	{
		CreateModificationOutputConnectorDTO createModificationOutputConnectorDTO = new CreateModificationOutputConnectorDTO();
		connectorDTO = createModificationOutputConnectorDTO;
	
		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
		
			createModificationOutputConnectorDTO.setReturnCode(returnCode);
		}
	
	return connectorDTO;
}
}
