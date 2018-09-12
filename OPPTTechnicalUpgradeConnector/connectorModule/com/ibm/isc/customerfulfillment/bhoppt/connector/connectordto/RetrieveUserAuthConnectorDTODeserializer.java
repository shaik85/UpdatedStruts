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
public class RetrieveUserAuthConnectorDTODeserializer implements OutputConnectorDTODeserializerInterface,RetrieveUserAuthConnectorDTOConstants
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
	public RetrieveUserAuthConnectorDTODeserializer()
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
	public ConnectorDTOInterface parseMsgString(StringParser tokenizer, ConnectorDTOInterface connectorDTO) throws Exception
	{		
		List list = null;
		RetrieveUserAuthOutputConnectorDTO outputConnectorDTO = (RetrieveUserAuthOutputConnectorDTO)connectorDTO;
		
		list = outputConnectorDTO.getRetrieveUserAuthConnectorDTO();		
		if (list == null)
		{
			list = new ArrayList();
			outputConnectorDTO.setRetrieveUserAuthConnectorDTO(list);
		}
		if (tokenizer.hasMoreTokens())
		{
			int length = Integer.parseInt(tokenizer.nextToken());
			if (length > 0)
			{
				int totalCounter = 1, elementCounter = 1;
				String temp;
				RetrieveUserAuthConnectorDTO retrieveUserAuthConnectorDTO = new RetrieveUserAuthConnectorDTO();

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
						case SALES_AREA :
							 retrieveUserAuthConnectorDTO = new RetrieveUserAuthConnectorDTO();
							 list.add(retrieveUserAuthConnectorDTO);
							 retrieveUserAuthConnectorDTO.setSalesArea(temp);
							 break;

						case ACCESS_TYPE : 
						default :
							 retrieveUserAuthConnectorDTO.setAccessType(temp);
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
