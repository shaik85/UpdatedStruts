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
/* This class is creted by Srinivas for OPPTBH-DAD003*/
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RetrieveComplexTypesOutputConnectorDTO implements ConnectorDTOInterface
{
	private String iReturnCode;
	private List iComplexTypesConnectorDTO;
	/** 
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public RetrieveComplexTypesOutputConnectorDTO() 
	{
		
	}

		/**
	 * @return Returns the iComplexTypesConnectorDTO.
	 */
	public List getIComplexTypesConnectorDTO() {
		return iComplexTypesConnectorDTO;
	}
	/**
	 * @param complexTypesConnectorDTO The iComplexTypesConnectorDTO to set.
	 */
	public void setIComplexTypesConnectorDTO(List complexTypesConnectorDTO) {
		iComplexTypesConnectorDTO = complexTypesConnectorDTO;
	}
	/**
	 * @return Returns the iReturnCode.
	 */
	public String getIReturnCode() {
		return iReturnCode;
	}
	/**
	 * @param returnCode The iReturnCode to set.
	 */
	public void setIReturnCode(String returnCode) {
		iReturnCode = returnCode;
	}
}
