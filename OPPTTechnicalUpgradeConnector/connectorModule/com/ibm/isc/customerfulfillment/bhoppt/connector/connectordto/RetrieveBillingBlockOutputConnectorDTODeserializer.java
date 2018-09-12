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
public class RetrieveBillingBlockOutputConnectorDTODeserializer implements OutputConnectorDTODeserializerInterface
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
	public RetrieveBillingBlockOutputConnectorDTODeserializer()
	{
	}

	/**
     * This method is used to parse the given string and build objects
     * out of it.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @return ConnectorDTOInterface
     * @param connectorDTO
     * @param tokenizer
     * @throws java.lang.Exception 
     */
	public ConnectorDTOInterface parseMsgString(StringParser tokenizer, ConnectorDTOInterface connectorDTO)
		throws Exception
	{
		RetrieveBillingBlockOutputConnectorDTO outputConnectorDTO = new RetrieveBillingBlockOutputConnectorDTO();
		connectorDTO = outputConnectorDTO;

		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
			outputConnectorDTO.setIReturnCode(returnCode);

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(returnCode))
			{
				OutputConnectorDTODeserializerInterface outputConnectorDeserializer =
					ConnectorUtility.getOutputConnectorDeserializer(BillingBlockConnectorDTO.class.getName());
				connectorDTO = outputConnectorDeserializer.parseMsgString(tokenizer, outputConnectorDTO);
			}
		}
		return connectorDTO;
	}
}
