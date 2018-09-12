/*
 * Created on Apr 9, 2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/*
* IBM Confidential
*
* ©  Copyright IBM Corp. 2004, 2005  All Rights Reserved.

* The source code for this program is not published or otherwise divested of
* its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
*/
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.ArrayList;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RetrieveSiteIDListConnectorDTODeserializer  implements OutputConnectorDTODeserializerInterface, RetrieveSiteIDConnectorDTOConstants{
	
	public RetrieveSiteIDListConnectorDTODeserializer(){
		
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
		RetrieveSiteIDListOutputConnectorDTO retrieveSiteIDListOutputConnectorDTO = new RetrieveSiteIDListOutputConnectorDTO();

		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
			retrieveSiteIDListOutputConnectorDTO.setReturnCode(returnCode);
				
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

					RetrieveSiteIDCustConnectorDTO retrieveSiteIDCustConnectorDTO = new RetrieveSiteIDCustConnectorDTO();
                    List list = new ArrayList();
                   
                    int i =0;
					while (tokenizer.hasMoreTokens())
					{    
						temp = tokenizer.nextToken();
						temp = (temp == null) ? "" : temp;
						
						switch (counter % TOTAL_ELEMENTS)
						{   
						    							
						    case CUSTOMER_NUMBER :
								retrieveSiteIDCustConnectorDTO.setCustomerNo(temp);
								i++;
								break;

							case CUSTOMER_NAME :
								retrieveSiteIDCustConnectorDTO.setCustomerName(temp);
								i++;
								break;
							
						}
						if(i==2){
										
						list.add(retrieveSiteIDCustConnectorDTO);
						retrieveSiteIDCustConnectorDTO = new RetrieveSiteIDCustConnectorDTO();				 
						 i=0;
						 counter =1;
						}else{
							counter++;							
						}
						
						
					}
					retrieveSiteIDListOutputConnectorDTO.setRetrieveCustConnectorDTOList(list);
					
				}
			}
		}
		return retrieveSiteIDListOutputConnectorDTO;
	}

	
}
