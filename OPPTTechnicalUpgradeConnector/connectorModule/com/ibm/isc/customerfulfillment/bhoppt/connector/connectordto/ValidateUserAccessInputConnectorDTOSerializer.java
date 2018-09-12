/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;




import java.util.Iterator;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;
/** 
 * Input ConnectorDTO Serializer
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

public class ValidateUserAccessInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public ValidateUserAccessInputConnectorDTOSerializer()
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
	 * @return String
	 * @throws Exception
	 */
	public String createNewMsg(ConnectorDTOInterface connectorDTO) throws Exception
	{
		ValidateUserAccessInputConnectorDTO dto = (ValidateUserAccessInputConnectorDTO)connectorDTO;
		
		StringBuffer buffer = new StringBuffer();
		ConnectorUtility.buildMessage(dto.getFunctionModuleName(), buffer);
		ConnectorUtility.buildMessage(dto.getSessionID(), buffer);
		ConnectorUtility.buildMessage(dto.getCreatedBy(), buffer);
		ConnectorUtility.buildMessage(dto.getUserID(), buffer);
		
		ConnectorUtility.buildMessage(dto.getOrgConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(dto.getProposalType(), buffer);
		ConnectorUtility.buildMessage(dto.getBTPNo(), buffer);
		ConnectorUtility.buildMessage(dto.getPayerNo(), buffer);
		ConnectorUtility.buildMessage(dto.getShipToPartyNo(), buffer);
		
		List sapSoldToPartyList = dto.getSapSoldToParty();
				
		if (sapSoldToPartyList != null && sapSoldToPartyList.size() > 0) {
			Iterator iter = sapSoldToPartyList.iterator();
			
			while (iter.hasNext())
				{
					ConnectorUtility.buildMessage((String) iter.next(), buffer);
				}
		}
			
		
		return buffer.toString();
	}
}
