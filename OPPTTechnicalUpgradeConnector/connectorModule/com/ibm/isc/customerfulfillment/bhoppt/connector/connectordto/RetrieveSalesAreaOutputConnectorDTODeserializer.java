/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;



import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;
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

public class RetrieveSalesAreaOutputConnectorDTODeserializer implements OutputConnectorDTODeserializerInterface
{
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
	public RetrieveSalesAreaOutputConnectorDTODeserializer()
	{
	}

	/**
	 * This method is used to parse the given string and build objects
	 * out of it.
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param tokenizer
	 * @param connectorDTO
	 * @return ConnectorDTOInterface
	 * @throws Exception
	 */
	public ConnectorDTOInterface parseMsgString(StringParser tokenizer, ConnectorDTOInterface connectorDTO)
		throws Exception
	{
		RetrieveSalesAreaOutputConnectorDTO outputConnectorDTO = new RetrieveSalesAreaOutputConnectorDTO();
		connectorDTO = outputConnectorDTO;
		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
			outputConnectorDTO.setReturnCode(returnCode);

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(returnCode))
			{
				if (tokenizer.hasMoreTokens())
				{
					OutputConnectorDTODeserializerInterface outputConnectorDeserializer =
						ConnectorUtility.getOutputConnectorDeserializer(SalesAreaConnectorDTO.class.getName());
					outputConnectorDeserializer.parseMsgString(tokenizer, outputConnectorDTO);

					outputConnectorDeserializer =
						ConnectorUtility.getOutputConnectorDeserializer(SalesOrgConnectorDTO.class.getName());
					outputConnectorDeserializer.parseMsgString(tokenizer, outputConnectorDTO);

					outputConnectorDeserializer =
						ConnectorUtility.getOutputConnectorDeserializer(DstrChannelConnectorDTO.class.getName());
					outputConnectorDeserializer.parseMsgString(tokenizer, outputConnectorDTO);

					outputConnectorDeserializer =
						ConnectorUtility.getOutputConnectorDeserializer(DivisionConnectorDTO.class.getName());
					outputConnectorDeserializer.parseMsgString(tokenizer, outputConnectorDTO);
				}
			}
		}
		return outputConnectorDTO;
	}
}
