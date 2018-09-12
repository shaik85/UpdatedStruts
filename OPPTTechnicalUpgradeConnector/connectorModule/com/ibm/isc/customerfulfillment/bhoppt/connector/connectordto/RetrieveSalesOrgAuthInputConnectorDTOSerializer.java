/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;


/** 
 * This class is Serializer class which is used to convert the data to RFC format
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Sep 23, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1x
 */

public class RetrieveSalesOrgAuthInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface {

	/**
	 *  
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Sep 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param connectorDTO
	 * @return
	 * @throws Exception 
	 *
	 */
	public String createNewMsg(ConnectorDTOInterface connectorDTO) throws Exception {
		
		RetrieveSalesOrgAuthInputConnectorDTO dto = (RetrieveSalesOrgAuthInputConnectorDTO) connectorDTO;
		StringBuffer buffer = new StringBuffer();

		ConnectorUtility.buildMessage(dto.getGenericConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(dto.getSalesOrg(), buffer);
		
		return buffer.toString();
	}
}
