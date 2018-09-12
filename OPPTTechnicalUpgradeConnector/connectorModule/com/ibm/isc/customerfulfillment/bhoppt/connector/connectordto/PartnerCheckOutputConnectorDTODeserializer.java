/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
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
public class PartnerCheckOutputConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, PartnerCheckConnectorDTOConstants
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
	public PartnerCheckOutputConnectorDTODeserializer()
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
		PartnerCheckOutputConnectorDTO dto = new PartnerCheckOutputConnectorDTO();
		connectorDTO = dto;

		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
			dto.setReturnCode(returnCode);

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(returnCode))
			{
				if (tokenizer.hasMoreTokens())
				{
					int length = Integer.parseInt(tokenizer.nextToken());

					if (length > 0)
					{
						int totalCounter = 1, elementCounter = 1;
						String temp;

						while (tokenizer.hasMoreTokens())
						{
							temp = tokenizer.nextToken();

							if (temp != null)
							{
								totalCounter += temp.length() + 1;
							}
							else
							{
								totalCounter++;
							}

							switch (elementCounter % TOTAL_ELEMENTS)
							{
								case FLAG :
									dto.setFlag(temp);
									break;

								case CUSTOMER_NUMBER :
									dto.setCustomerNo(temp);
									break;

								case PARTNER_NAME :
									dto.setPartnerName(temp);
									break;

	/*DADO02&DADO09 BlueHarmony Sateesh Anne case LEGACY_NUMBER :
									dto.setLegacyNo(temp);
									break;

								case ADDRESS_SEQUENCE_NUMBER :
									dto.setAddressSeqNo(temp);
									break;*/

								case CLASS_TYPE : // same as default
								default :
									dto.setClassType(temp);
									elementCounter = 0;
							}

							elementCounter++;

							if (totalCounter >= length)
							{
								break;
							}
						}
					} // end of if length > 0
				} // end of hasMoreTokens if
			}
		}

		return connectorDTO;
	}
}
