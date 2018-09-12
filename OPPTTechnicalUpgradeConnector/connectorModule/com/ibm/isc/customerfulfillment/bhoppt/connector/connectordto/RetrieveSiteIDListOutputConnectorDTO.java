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

import java.util.ArrayList;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RetrieveSiteIDListOutputConnectorDTO implements ConnectorDTOInterface {
	private String returnCode;
	private List retrieveCustConnectorDTOList = new ArrayList();
	
	public RetrieveSiteIDListOutputConnectorDTO(){
		
	}

	/**
	 * @return Returns the retrieveCustConnectorDTOList.
	 */
	public List getRetrieveCustConnectorDTOList() {
		return retrieveCustConnectorDTOList;
	}
	/**
	 * @param retrieveCustConnectorDTOList The retrieveCustConnectorDTOList to set.
	 */
	public void setRetrieveCustConnectorDTOList(
			List list) {
		retrieveCustConnectorDTOList = list;
	}
	/**
	 * @return Returns the returnCode.
	 */
	public String getReturnCode() {
		return returnCode;
	}
	/**
	 * @param returnCode The returnCode to set.
	 */
	public void setReturnCode(String lreturnCode) {
		returnCode = lreturnCode;
	}
	
	public void addCustConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		retrieveCustConnectorDTOList.add(connectorDTO);
	}

}
