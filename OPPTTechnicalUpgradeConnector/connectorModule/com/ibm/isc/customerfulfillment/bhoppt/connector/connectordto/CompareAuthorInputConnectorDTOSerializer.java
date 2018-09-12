/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;



import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;
/** 
 * Connector Deserializer
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class CompareAuthorInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
{
	/** 
	 * Constructor
	 *  
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */	
	public CompareAuthorInputConnectorDTOSerializer()
	{
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
	 * @return String created new message
	 */
	public String createNewMsg(ConnectorDTOInterface connectorDTO)
	{
		CompareAuthorInputConnectorDTO compareAuthorInputConnectorDTO = (CompareAuthorInputConnectorDTO)connectorDTO;
		
		StringBuffer buffer = new StringBuffer();

		ConnectorUtility.buildMessage(compareAuthorInputConnectorDTO.getFunctionModuleName(), buffer);
		ConnectorUtility.buildMessage(compareAuthorInputConnectorDTO.getSessionID(), buffer);
		ConnectorUtility.buildMessage(compareAuthorInputConnectorDTO.getAdminFlag(), buffer);
		ConnectorUtility.buildMessage(compareAuthorInputConnectorDTO.getUserID1(), buffer);
		ConnectorUtility.buildMessage(compareAuthorInputConnectorDTO.getUserID2(), buffer);
		
		return buffer.toString();
	}
}
