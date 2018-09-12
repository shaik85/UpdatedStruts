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

public class ValueMetricConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, ValueMetricConnectorDTOConstants
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
	public ValueMetricConnectorDTODeserializer()
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
		RetrieveInvenConfigOutputConnectorDTO dto = (RetrieveInvenConfigOutputConnectorDTO) connectorDTO;
		List list = dto.getValueMetricList();

		if (list == null)
		{
			list = new ArrayList();
			dto.setValueMetricList(list);
		}

		if (tokenizer.hasMoreTokens())
		{
			// Length
			int length = Integer.parseInt(tokenizer.nextToken());

			if (length > 0)
			{
				int totalCounter = 1, elementCounter = 1;
				String temp;
				ValueMetricConnectorDTO valueMetricConnectorDTO = null;

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
							valueMetricConnectorDTO = new ValueMetricConnectorDTO();
							list.add(valueMetricConnectorDTO);
							valueMetricConnectorDTO.setSalesDocNo(temp);
							break;

						case SWO_ITEM_NO :
							valueMetricConnectorDTO.setSwoItemNo(temp);
							break;

						case EE_ITEM_NO :
							valueMetricConnectorDTO.setEeItemNo(temp);
							break;

						case VALUE_METRIC :
							valueMetricConnectorDTO.setValueMetric(temp);
							break;

						case DESCRIPTION :
							valueMetricConnectorDTO.setDescription(temp);
							break;

						case DEFAULT :
						default :
							valueMetricConnectorDTO.setDefault(temp);
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
