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
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Sep 23, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1x
 */
public class SalesOrgAccessDTODeserializer implements OutputConnectorDTODeserializerInterface, SalesOrgAccessDTOConstants {

	/** 
	 * This method is used to deserialize the sales org part 
	 * 
	 * <br/><PRE> 
	 * date Sep 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.OutputConnectorDTODeserializerInterface#parseMsgString(com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser, com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface) 
	 * @param tokenizer
	 * @param connectorDTO
	 * @return
	 * @throws Exception 
	 * 
	 */
	public ConnectorDTOInterface parseMsgString(StringParser tokenizer, ConnectorDTOInterface connectorDTO) throws Exception {
		
		List list = null;
		RetrieveSalesOrgAuthOutputConnectorDTO outputConnectorDTO = (RetrieveSalesOrgAuthOutputConnectorDTO) connectorDTO;
		
		list = outputConnectorDTO.getSalesOrgAccessList();			
		
		if (list == null)
		{
			list = new ArrayList();
			outputConnectorDTO.setSalesOrgAccessList(list);
		}
		if (tokenizer.hasMoreTokens())
		{
			int length = Integer.parseInt(tokenizer.nextToken());
			if (length > 0)
			{
				int totalCounter = 1, elementCounter = 1;
				String temp;
				SalesOrgAccessDTO salesOrgAccessDTO = new SalesOrgAccessDTO();

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
						case USER_ID :
							salesOrgAccessDTO = new SalesOrgAccessDTO();
							 list.add(salesOrgAccessDTO);
							salesOrgAccessDTO.setUserID(temp);
							 break;
						case SALES_ORG :
							salesOrgAccessDTO.setSalesOrg(temp);
							 break;

						case ACCESS_TYPE :
						default :
							salesOrgAccessDTO.setAccessType(temp);
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
