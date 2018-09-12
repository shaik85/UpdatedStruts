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
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/* This class is creted by Srinivas for OPPTBH-DAD003*/
public class RetrieveComplexTypesInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
{
   
	
	
	public  RetrieveComplexTypesInputConnectorDTOSerializer ()
	{
		
	}
	
	public String createNewMsg(ConnectorDTOInterface connectorDTO) throws Exception
	{
		RetrieveComplexTypesInputConnectorDTO retrieveComplexTypesInputConnectorDTO = (RetrieveComplexTypesInputConnectorDTO)connectorDTO;		
		StringBuffer buffer = new StringBuffer();
		
		ConnectorUtility.buildMessage(retrieveComplexTypesInputConnectorDTO.getIGenericConnectorDTO(),buffer);
		
		return buffer.toString();
	}
}
