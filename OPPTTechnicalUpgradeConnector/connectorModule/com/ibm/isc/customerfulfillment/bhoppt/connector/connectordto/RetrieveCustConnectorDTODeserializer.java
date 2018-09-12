/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;




import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
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


public class RetrieveCustConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, RetrieveCustConnectorDTOConstants
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
	public RetrieveCustConnectorDTODeserializer()
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
		RetrieveCustOutputConnectorDTO customerOutputConnectorDTO = new RetrieveCustOutputConnectorDTO();

		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
			
			customerOutputConnectorDTO.setReturnCode(returnCode);

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(returnCode))
			{
				if (tokenizer.hasMoreTokens())
				{
					String length = tokenizer.nextToken();
				}

				if (tokenizer.hasMoreTokens())
				{
					String temp;

					int counter = 1;

					RetrieveCustConnectorDTO customerConnectorDTO = new RetrieveCustConnectorDTO();

					while (tokenizer.hasMoreTokens())
					{
						temp = tokenizer.nextToken();
						temp = (temp == null) ? "" : temp;

						switch (counter % TOTAL_ELEMENTS)
						{
							case CUSTOMER_LIST_NO :
								customerConnectorDTO = new RetrieveCustConnectorDTO();
								customerOutputConnectorDTO.addCustConnectorDTO(customerConnectorDTO);
								customerConnectorDTO.setCustomerListNo(temp);
								break;

							case CUSTOMER_NUMBER :
								customerConnectorDTO.setCustomerNo(temp);
								break;

							case CUSTOMER_NAME :
								customerConnectorDTO.setCustomerName(temp);
								break;

							case LEGACY_CUSTOMER_NUMBER :
								customerConnectorDTO.setLegacyCustomerNo(temp);
								break;
							
							case ADDRESS_SEQUENCE_NUMBER :
								customerConnectorDTO.setAddressSeqNo(temp);
								break;
							/* Changed for EF0607044559S by Sara on June 16,2004 */				
							case COUNTRY_CODE : // Follow whatever applicable for default
							default :
								customerConnectorDTO.setCountryCode(temp);
								counter = 0;
							/* EF0607044559E */
						}
						counter++;
					}
				}
			}
		}
		return customerOutputConnectorDTO;
	}
}
