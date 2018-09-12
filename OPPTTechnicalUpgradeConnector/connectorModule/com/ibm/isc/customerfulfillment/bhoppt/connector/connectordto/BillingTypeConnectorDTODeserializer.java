/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

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

import java.util.List;
import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser;

/**
 * BillingTypeConnectorDTODeserializer
 *
 * @author Murugan
 */
public class BillingTypeConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, BillingTypeConnectorDTOConstants
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
	public BillingTypeConnectorDTODeserializer()
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
		List list = null;

		RetrieveDateRulesOutputConnectorDTO outputConnectorDTO =
			(RetrieveDateRulesOutputConnectorDTO) connectorDTO;
		list = outputConnectorDTO.getIBillingTypeConnectorDTO();

		if (list == null)
		{
			list = new ArrayList();
			outputConnectorDTO.setIBillingTypeConnectorDTO(list);
		}
		if (tokenizer.hasMoreTokens())
		{
			int length = Integer.parseInt(tokenizer.nextToken());
			if (length > 0)
			{
				int totalCounter = 1, elementCounter = 1;
				String temp;
				BillingTypeConnectorDTO billingTypeConnectorDTO = new BillingTypeConnectorDTO();

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
						case BILLING_CODE :
							billingTypeConnectorDTO = new BillingTypeConnectorDTO();
							list.add(billingTypeConnectorDTO);
							billingTypeConnectorDTO.setIBillingCode(temp);
							break;

						case BILLING_DESC :
						default :
							billingTypeConnectorDTO.setIBillingDesc(temp);
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
