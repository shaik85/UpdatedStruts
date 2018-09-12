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

public class EEConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, EEConnectorDTOConstants
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
	public EEConnectorDTODeserializer()
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
			
			list = outputConnectorDTO.getEEConnectorDTOList();
			
			if (list == null)
			{
				list = new ArrayList();
				outputConnectorDTO.setEEConnectorDTOList(list);
			}
		}
		else if (connectorDTO instanceof RetrieveDeltaInventoryOutputConnectorDTO)
		{
			RetrieveDeltaInventoryOutputConnectorDTO outputConnectorDTO =
				(RetrieveDeltaInventoryOutputConnectorDTO) connectorDTO;
			
			list = outputConnectorDTO.getEEConnectorDTOList();
			
			if (list == null)
			{
				list = new ArrayList();
				outputConnectorDTO.setEEConnectorDTOList(list);
			}
		}
		else if (connectorDTO instanceof CheckVarianceOutputConnectorDTO)
		{
			CheckVarianceOutputConnectorDTO dto = (CheckVarianceOutputConnectorDTO)connectorDTO;
			
			list = dto.getEEConnectorDTOList();
			if (list == null)
			{
				list = new ArrayList();
				dto.setEEConnectorDTOList(list);
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
				EEConnectorDTO eeConnectorDTO = new EEConnectorDTO();

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
							eeConnectorDTO = new EEConnectorDTO();
							list.add(eeConnectorDTO);
							eeConnectorDTO.setSalesDocumentNumber(temp);
							break;

						case EE_ITEM_POSITION_NUMBER :
							eeConnectorDTO.setEEItemPositionNumber(temp);
							break;

						case SWO_ITEM_POSITION_NUMBER :
							eeConnectorDTO.setSWOItemPositionNumber(temp);
							break;

						case VALUE_METRIC :
							eeConnectorDTO.setValueMetric(temp);
							break;

						case USE_LEVEL :
							eeConnectorDTO.setUseLevel(temp);
							break;

						case LICENSE_TYPE :
							eeConnectorDTO.setLicenseType(temp);
							break;

						case EE_MATERIAL_NUMBER :
							eeConnectorDTO.setEEMaterialNumber(temp);
							break;

						case DESCRIPTION_OF_EE_MATERIAL :
							eeConnectorDTO.setDescriptionOfEEMaterial(temp);
							break;

						case CHARGE_OPTION :
							eeConnectorDTO.setChargeOption(temp);
							break;

						case FIRST_MONTH_LIST_PRICE :
							eeConnectorDTO.setFirstMonthListPrice(Double.parseDouble(temp));
							break;

						case PLET_NO :
						default :
							eeConnectorDTO.setPLETNo(temp);
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
