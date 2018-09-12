/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;



import java.util.ArrayList;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;
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

public class PriceConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, PriceConnectorDTOConstants
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
	public PriceConnectorDTODeserializer()
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
		List list = null;
		
		if (connectorDTO instanceof RetrieveInvenDetailOutputConnectorDTO)
		{
			RetrieveInvenDetailOutputConnectorDTO outputConnectorDTO =
				(RetrieveInvenDetailOutputConnectorDTO) connectorDTO;
			
			list = outputConnectorDTO.getPriceConnectorDTOList();
			
			if (list == null)
			{
				list = new ArrayList();
				outputConnectorDTO.setPriceConnectorDTOList(list);
			}
		}		
		else if (connectorDTO instanceof RetrieveDeltaInventoryOutputConnectorDTO)
		{
			RetrieveDeltaInventoryOutputConnectorDTO outputConnectorDTO =
				(RetrieveDeltaInventoryOutputConnectorDTO) connectorDTO;
			
			list = outputConnectorDTO.getPriceConnectorDTOList();
			
			if (list == null)
			{
				list = new ArrayList();
				outputConnectorDTO.setPriceConnectorDTOList(list);
			}
		}
		else if (connectorDTO instanceof CheckVarianceOutputConnectorDTO)
		{
			CheckVarianceOutputConnectorDTO dto = (CheckVarianceOutputConnectorDTO)connectorDTO;
			
			list = dto.getPriceConnectorDTOList();
			if (list == null)
			{
				list = new ArrayList();
				dto.setPriceConnectorDTOList(list);
			}
		}
		
		if (tokenizer.hasMoreTokens())
		{
			// Length
			int length = Integer.parseInt(tokenizer.nextToken());

			if (length > 0)
			{
				int totalCounter = 1, elementCounter = 1;
				String temp;
				PriceConnectorDTO priceConnectorDTO = new PriceConnectorDTO();

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
						case SALES_DOCUMENT_NUMBER :
							priceConnectorDTO = new PriceConnectorDTO();
							list.add(priceConnectorDTO);
							priceConnectorDTO.setSalesDocumentNumber(temp);
							break;

						case EE_ITEM_POSITION_NO :
							priceConnectorDTO.setEEItemPositionNo(temp);
							break;

						case BILLING_START_DATE :
							priceConnectorDTO.setBillingStartDate(ConnectorUtility.getDate(temp));
							break;

						case BILLING_END_DATE :
							priceConnectorDTO.setBillingEndDate(ConnectorUtility.getDate(temp));
							break;

						case ESW_PRICE :
							if (temp != null && (temp = temp.trim()).length() > 0)
								priceConnectorDTO.setESWPrice(Double.parseDouble(temp));
							break;

						case CURRENCY :
							priceConnectorDTO.setCurrency(temp);
							break;
							
						case BILLING_STATUS :
						default :
							priceConnectorDTO.setBillingStatus(temp);
							elementCounter = 0;
					}

					elementCounter++;

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
