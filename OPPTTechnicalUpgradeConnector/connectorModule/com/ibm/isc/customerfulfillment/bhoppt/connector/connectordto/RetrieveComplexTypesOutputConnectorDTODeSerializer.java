/*
 * Created on May 12, 2010
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
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/* This class is creted by Srinivas for OPPTBH-DAD003*/
public class RetrieveComplexTypesOutputConnectorDTODeSerializer implements OutputConnectorDTODeserializerInterface
{
	
	public  RetrieveComplexTypesOutputConnectorDTODeSerializer()
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
		RetrieveComplexTypesOutputConnectorDTO outputConnectorDTO = new RetrieveComplexTypesOutputConnectorDTO();
		//connectorDTO = outputConnectorDTO;

		if (tokenizer.hasMoreTokens())
		{
			String returnCode = OPPTHelper.trimString(tokenizer.nextToken());
			outputConnectorDTO.setIReturnCode(returnCode);

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(returnCode))
			{
				OutputConnectorDTODeserializerInterface outputConnectorDeserializer =
					ConnectorUtility.getOutputConnectorDeserializer(ComplexTypesConnectorDTO.class.getName());
				connectorDTO = outputConnectorDeserializer.parseMsgString(tokenizer, outputConnectorDTO);
			}
		}
		return connectorDTO;
	}
}
