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
 *  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Sep 23, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1x
 */
public class RetrieveSalesOrgAuthOutputConnectorDTODeserializer implements OutputConnectorDTODeserializerInterface {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Sep 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param tokenizer
	 * @param connectorDTO
	 * @return
	 * @throws Exception 
	 * 
	 */
	public ConnectorDTOInterface parseMsgString(StringParser tokenizer, ConnectorDTOInterface connectorDTO) throws Exception {
		
		RetrieveSalesOrgAuthOutputConnectorDTO outputConnectorDTO = new RetrieveSalesOrgAuthOutputConnectorDTO();
		connectorDTO = outputConnectorDTO;
		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
			outputConnectorDTO.setReturnCode(returnCode);

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(returnCode))
			{
				OutputConnectorDTODeserializerInterface outputConnectorDeserializer =
					ConnectorUtility.getOutputConnectorDeserializer(SalesOrgAccessDTO.class.getName());				
				outputConnectorDeserializer.parseMsgString(tokenizer, outputConnectorDTO);
			}
		}
		
		return outputConnectorDTO;
	}

}
