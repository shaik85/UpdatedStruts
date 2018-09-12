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
 * Connector Deserializer
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

public class ChangeContractOutputConnectorDTODeserializer implements OutputConnectorDTODeserializerInterface
{
	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public ChangeContractOutputConnectorDTODeserializer()
	{

	}

	/**
	 * To parse the message and create the corresponding object 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.OutputConnectorDTODeserializerInterface#parseMsgString(java.util.StringTokenizer, com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface) 
	 * @param tokenizer
	 * @param connectorDTO
	 * @return ConnectorDTOInterface
	 * @throws Exception
	 */
	public ConnectorDTOInterface parseMsgString(StringParser tokenizer, ConnectorDTOInterface connectorDTO)
		throws Exception
	{
		ChangeContractOutputConnectorDTO changeContractOutputConnectorDTO = new ChangeContractOutputConnectorDTO();
		connectorDTO = changeContractOutputConnectorDTO;
		
		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
			
			changeContractOutputConnectorDTO.setIReturnCode(returnCode);
		}
		
		return connectorDTO;
	}
}
