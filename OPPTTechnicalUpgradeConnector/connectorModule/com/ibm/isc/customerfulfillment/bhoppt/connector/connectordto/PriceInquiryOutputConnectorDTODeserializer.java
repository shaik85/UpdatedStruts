/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;



import java.util.ArrayList;
import java.util.List;

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
public class PriceInquiryOutputConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, PriceInquiryConnectorDTOConstants
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
	public PriceInquiryOutputConnectorDTODeserializer()
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
		PriceInquiryOutputConnectorDTO dto = new PriceInquiryOutputConnectorDTO();
		connectorDTO = dto;

		List list = new ArrayList();
		dto.setPriceInquiryConnectorDTOList(list);

		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
			dto.setReturnCode(returnCode);

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(returnCode))
			{
				if (tokenizer.hasMoreTokens())
				{
					// Length
					int length = Integer.parseInt(tokenizer.nextToken());

					if (length > 0)
					{
						int totalCounter = 1, elementCounter = 1;
						String temp;
						PriceInquiryConnectorDTO priceInquiryConnectorDTO = null;

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
								case SALES_DOC_NO :
									priceInquiryConnectorDTO = new PriceInquiryConnectorDTO();
									list.add(priceInquiryConnectorDTO);
									priceInquiryConnectorDTO.setSalesDocNo(temp);
									break;

								case EE_ITEM_NO :
									priceInquiryConnectorDTO.setEeItemNo(temp);
									break;

								case BILL_PLAN_START_DATE :
									priceInquiryConnectorDTO.setBillPlanStartDte(ConnectorUtility.getDate(temp));
									break;

								case BILL_PLAN_END_DATE :
									priceInquiryConnectorDTO.setBillPlanEndDte(ConnectorUtility.getDate(temp));
									break;

								case PRICE :
									if (temp != null && temp.length() > 0)
									{
										priceInquiryConnectorDTO.setPrice(Double.parseDouble(temp));
									}
									break;

								case CURRENCY :
								default :
									priceInquiryConnectorDTO.setCurrency(temp);
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
			}
		}
		return connectorDTO;
	}
}
