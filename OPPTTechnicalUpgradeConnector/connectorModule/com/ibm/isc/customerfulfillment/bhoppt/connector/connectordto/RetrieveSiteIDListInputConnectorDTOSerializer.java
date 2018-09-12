/*
 * Created on Apr 19, 2010
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
public class RetrieveSiteIDListInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface{
	public RetrieveSiteIDListInputConnectorDTOSerializer(){
		
	}
	
	/**
	 * This method is used to parse the given object and build object
	 * a String out of it.
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param connectorDTO
	 * @return String
	 * @throws Exception
	 */
	public String createNewMsg(ConnectorDTOInterface connectorDTO) throws Exception
	{
		RetrieveSiteIDListInputConnectorDTO dto = (RetrieveSiteIDListInputConnectorDTO)connectorDTO;
		
		StringBuffer buffer = new StringBuffer();
		ConnectorUtility.buildMessage(dto.getGenericConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(dto.getOrgConnectorDTO(), buffer);
		
		ConnectorUtility.buildMessage(dto.getZipCode(), buffer);
		ConnectorUtility.buildMessage(dto.getCity(), buffer);
		ConnectorUtility.buildMessage(dto.getSiteName(), buffer);
		ConnectorUtility.buildMessage(dto.getSiteID(), buffer);
		
		return buffer.toString();
	}
}
