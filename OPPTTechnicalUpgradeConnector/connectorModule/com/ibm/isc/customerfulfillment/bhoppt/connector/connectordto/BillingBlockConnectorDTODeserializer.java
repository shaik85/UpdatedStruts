/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.List;
import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class BillingBlockConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, BillingBlockConnectorDTOConstants
{

	/** 
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public BillingBlockConnectorDTODeserializer()
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
		RetrieveBillingBlockOutputConnectorDTO outputConnectorDTO =
			(RetrieveBillingBlockOutputConnectorDTO) connectorDTO;

		list = outputConnectorDTO.getIBillingBlockConnectorDTO();

		if (list == null)
		{
			list = new ArrayList();
			outputConnectorDTO.setIBillingBlockConnectorDTO(list);
		}
		if (tokenizer.hasMoreTokens())
		{
			int length = Integer.parseInt(tokenizer.nextToken());
			if (length > 0)
			{
				int totalCounter = 1, elementCounter = 1;
				String temp;
				BillingBlockConnectorDTO billingBlockConnectorDTO = new BillingBlockConnectorDTO();

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
						case BILLING_BLOCK :
							billingBlockConnectorDTO = new BillingBlockConnectorDTO();
							list.add(billingBlockConnectorDTO);
							billingBlockConnectorDTO.setIBillingBlock(temp);
							break;

						case BILLING_BLOCK_DESC :
						default :
							billingBlockConnectorDTO.setIBillingBlockDesc(temp);
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
