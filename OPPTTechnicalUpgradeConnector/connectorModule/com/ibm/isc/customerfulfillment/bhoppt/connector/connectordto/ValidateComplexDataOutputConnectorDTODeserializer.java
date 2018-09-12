/*
 * Created on May 11, 2010
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

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser;
/**
 * @author Bhanu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ValidateComplexDataOutputConnectorDTODeserializer implements OutputConnectorDTODeserializerInterface
{
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
		ValidateComplexDataOutputConnectorDTO validateComplexDataOutputConnectorDTO = new ValidateComplexDataOutputConnectorDTO();
		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
			validateComplexDataOutputConnectorDTO.setReturnCode(returnCode);

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(returnCode))
			{
				if (tokenizer.hasMoreTokens())
				{
				
					// Length of SAP ReturnCode
					//tokenizer.nextToken();
					
					// SAP ReturnCode
					String temp = tokenizer.nextToken();
					validateComplexDataOutputConnectorDTO.setSapReturnCode(temp);
					
					// Length of the data
					//tokenizer.nextToken();
					
					// Exception code
					//temp = tokenizer.nextToken();
					//validateComplexDataOutputConnectorDTO.setExeptionCode(temp);
					
					// Error Message
					//temp = tokenizer.nextToken();
					//validateComplexDataOutputConnectorDTO.setErrorMessage(temp);
					
					//OCPS id
					temp = tokenizer.nextToken();
					validateComplexDataOutputConnectorDTO.setOcpsID(temp);
					
					// Contract Type
					temp = tokenizer.nextToken();
					validateComplexDataOutputConnectorDTO.setContractType(temp);
					
					//BLB Indicator
					temp = tokenizer.nextToken();
					validateComplexDataOutputConnectorDTO.setBlbIndicator(temp);
				}
				
			}
		}

		return validateComplexDataOutputConnectorDTO;
	}
}
