/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

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

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;

/**
 * CheckVarianceInputConnectorDTOSerializer
 * @author Muragan
 */
public class CheckVarianceInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public CheckVarianceInputConnectorDTOSerializer()
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
	 * @return String created message
	 * @throws Exception
	 */
	public String createNewMsg(ConnectorDTOInterface connectorDTO)throws Exception
	{
		CheckVarianceInputConnectorDTO checkVarianceInputConnectorDTO = (CheckVarianceInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		
		ConnectorUtility.buildMessage(checkVarianceInputConnectorDTO.getGenericConnectorDTO(),buffer);
		
		ConnectorUtility.buildMessage(checkVarianceInputConnectorDTO.getSalesOrg(),buffer);
		ConnectorUtility.buildMessage(checkVarianceInputConnectorDTO.getExternalContractNumber(),buffer);		
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(checkVarianceInputConnectorDTO.getVarianceDate(), ConnectorConstants.DATE_FORMAT),buffer);		
		ConnectorUtility.buildMessage(checkVarianceInputConnectorDTO.getIndicatorVarType(),buffer);
		
		return buffer.toString();
	}
}
