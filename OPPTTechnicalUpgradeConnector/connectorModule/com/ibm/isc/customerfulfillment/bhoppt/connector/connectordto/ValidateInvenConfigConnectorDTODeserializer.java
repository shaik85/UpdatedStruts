/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.ArrayList;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser;

/**
 * Validate inventory configuration connector deserializer 
 * 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 23, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class ValidateInvenConfigConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, ValidateInvenConfigConnectorDTOConstants
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
	public ValidateInvenConfigConnectorDTODeserializer()
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
		ValidateInvenConfigOutputConnectorDTO dto = (ValidateInvenConfigOutputConnectorDTO) connectorDTO;
		List list = dto.getValidateInvenConfigConnectorDTOList();

		if (list == null)
		{
			list = new ArrayList();
			dto.setValidateInvenConfigConnectorDTOList(list);
		}

		if (tokenizer.hasMoreTokens())
		{
			// Length
			int length = Integer.parseInt(tokenizer.nextToken());

			if (length > 0)
			{
				int totalCounter = 1, elementCounter = 1;
				String temp;
				ValidateInvenConfigConnectorDTO validateInvenConfigConnectorDTO = null;

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
						case SAP_SALES_DOC_NO :
							validateInvenConfigConnectorDTO = new ValidateInvenConfigConnectorDTO();
							list.add(validateInvenConfigConnectorDTO);
							validateInvenConfigConnectorDTO.setSapSalesDocNo(temp);
							break;

						case SAP_SWO_ITEM_NO :
							validateInvenConfigConnectorDTO.setSapSWOItemNo(temp);
							break;

						case SAP_EE_ITEM_NO :
							validateInvenConfigConnectorDTO.setSapEEItemNo(temp);
							break;

						case SAP_VALID_INDICATOR :
						default :
							validateInvenConfigConnectorDTO.setSapValidIndicator(temp);
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
