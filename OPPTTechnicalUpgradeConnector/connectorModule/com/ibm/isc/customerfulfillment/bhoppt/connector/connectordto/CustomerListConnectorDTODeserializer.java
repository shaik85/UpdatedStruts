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
public class CustomerListConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, CustomerListConnectorDTOConstants
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
	public CustomerListConnectorDTODeserializer()
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
		if (tokenizer.hasMoreTokens())
		{
			int length = Integer.parseInt(tokenizer.nextToken());

			if (length > 0)
			{
				int totalCounter = 1, elementCounter = 1;
				String temp;

				CustomerListConnectorDTO customerConnectorDTO = new CustomerListConnectorDTO();

				List list = new ArrayList();
				((RetrieveCustListOutputConnectorDTO) connectorDTO).setCustomerListConnectorDTOList(list);

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
						case CUSTOMER_LIST_NO :
							customerConnectorDTO = new CustomerListConnectorDTO();
							customerConnectorDTO.setCustomerListNo(temp);
							list.add(customerConnectorDTO);
							break;

						case CUSTOMER_LIST_NAME : // same as default
						default :
							customerConnectorDTO.setCustomerListName(temp);
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
