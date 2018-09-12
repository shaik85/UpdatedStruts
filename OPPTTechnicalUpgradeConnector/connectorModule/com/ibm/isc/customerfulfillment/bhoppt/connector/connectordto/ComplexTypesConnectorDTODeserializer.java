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
import java.util.List;
import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ComplexTypesConnectorDTODeserializer
                      implements OutputConnectorDTODeserializerInterface,ComplexTypesConnectorDTOConstants

{
	
	public  ComplexTypesConnectorDTODeserializer()
	{
		
	}
	
	
	public ConnectorDTOInterface parseMsgString(StringParser tokenizer, ConnectorDTOInterface connectorDTO)
	throws Exception
{
	List list = null;
	RetrieveComplexTypesOutputConnectorDTO outputConnectorDTO =
		(RetrieveComplexTypesOutputConnectorDTO) connectorDTO;

	list = outputConnectorDTO.getIComplexTypesConnectorDTO();

	if (list == null)
	{
		list = new ArrayList();
		outputConnectorDTO.setIComplexTypesConnectorDTO(list);
	}
	if (tokenizer.hasMoreTokens())
	{
		int length = Integer.parseInt(tokenizer.nextToken());
		if (length > 0)
		{
			int totalCounter = 1, elementCounter = 1;
			String temp;
			ComplexTypesConnectorDTO complexTypesConnectorDTO = new ComplexTypesConnectorDTO();

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
					case BLBIndicator_Type :
						complexTypesConnectorDTO = new ComplexTypesConnectorDTO();
						list.add(complexTypesConnectorDTO);
						complexTypesConnectorDTO.setBlbIndicatorType(temp);
						break;

					case BLBIndicator_Desc :
					default :
						complexTypesConnectorDTO.setBlbIndicatorDesc(temp);
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
