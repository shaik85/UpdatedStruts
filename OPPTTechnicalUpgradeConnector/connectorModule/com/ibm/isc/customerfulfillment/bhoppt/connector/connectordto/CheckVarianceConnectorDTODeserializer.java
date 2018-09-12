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

public class CheckVarianceConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, CheckVarianceConnectorDTOConstants
{

	/**
	 *  
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public CheckVarianceConnectorDTODeserializer()
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
		CheckVarianceOutputConnectorDTO outputConnectorDTO = (CheckVarianceOutputConnectorDTO) connectorDTO;

		if (tokenizer.hasMoreTokens())
		{
			int length = Integer.parseInt(OPPTHelper.trimString(tokenizer.nextToken()));
			if (tokenizer.hasMoreTokens())
			{
				String temp;
				int counter = 1, totalCounter = 1;

				CheckVarianceConnectorDTO checkVarianceConnectorDTO = new CheckVarianceConnectorDTO();
				outputConnectorDTO.setCheckVarianceConnectorDTO(checkVarianceConnectorDTO);

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
										
					temp = (temp == null) ? "" : temp;

					switch (counter % TOTAL_ELEMENTS)
					{
						case EXTERNAL_CONTRACT_NUMBER :
							checkVarianceConnectorDTO.setExternalContractNumber(temp);
							break;

						case TOTAL_INVENTORY_AMOUNT :
							checkVarianceConnectorDTO.setTotalInventoryAmount(temp);
							break;

						case CAP_VARIANCE :
						default :
							checkVarianceConnectorDTO.setCapVariance(temp);
							counter = 0;
					}
					counter++;
					
					if (totalCounter >= length)
					{
						break;
					}					
				}
			}
		}
		
		return connectorDTO;
	}
}
