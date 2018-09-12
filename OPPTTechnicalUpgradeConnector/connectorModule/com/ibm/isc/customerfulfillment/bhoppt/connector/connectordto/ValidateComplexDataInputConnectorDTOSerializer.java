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

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ValidateComplexDataInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface {
	
	
	public String createNewMsg(ConnectorDTOInterface connectorDTO) throws Exception
	{
		ValidateComplexDataInputConnectorDTO validateComplexDataInputConnectorDTO = (ValidateComplexDataInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		
		ConnectorUtility.buildMessage(validateComplexDataInputConnectorDTO.getIGenericConnectorDTO(),buffer);
		//ConnectorUtility.buildMessage(validateComplexDataInputConnectorDTO.getIOrgConnectorDTO().getSalesOrg(),buffer);
		ConnectorUtility.buildMessage(validateComplexDataInputConnectorDTO.getICpsID(),buffer);
		//ConnectorUtility.buildMessage(validateComplexDataInputConnectorDTO.getIComplexContractAmendment(),buffer);
		//ConnectorUtility.buildMessage(validateComplexDataInputConnectorDTO.getIMasterContractID(),buffer);
		//ConnectorUtility.buildMessage(validateComplexDataInputConnectorDTO.getIMasterContractAmendment(),buffer);
		//ConnectorUtility.buildMessage(validateComplexDataInputConnectorDTO.getIBLBIndicator(),buffer);		
		//ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(validateComplexDataInputConnectorDTO.getIContractStartDate(), ConnectorConstants.DATE_FORMAT),buffer);
		//ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(validateComplexDataInputConnectorDTO.getIContractEndDate(), ConnectorConstants.DATE_FORMAT),buffer);
		
		return buffer.toString();
		
	}

}
