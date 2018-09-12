/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

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

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;

/**
 * ChangeContractInputConnectorDTOSerializer
 *
 * @author Murugan
 */
public class ChangeContractInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public ChangeContractInputConnectorDTOSerializer()
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
	public String createNewMsg(ConnectorDTOInterface connectorDTO) throws Exception
	{
		ChangeContractInputConnectorDTO changeContractInputConnectorDTO = (ChangeContractInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		
		ConnectorUtility.buildMessage(changeContractInputConnectorDTO.getIGenericConnectorDTO(),buffer);
		ConnectorUtility.buildMessage(changeContractInputConnectorDTO.getIContractNumber(),buffer);
		ConnectorUtility.buildMessage(changeContractInputConnectorDTO.getIContractStatus(),buffer);
		
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(changeContractInputConnectorDTO.getIContractClosureDate(), ConnectorConstants.DATE_FORMAT),buffer);		
		ConnectorUtility.buildMessage(changeContractInputConnectorDTO.getIAmendmentReplacementCounter(),buffer);
		ConnectorUtility.buildMessage(changeContractInputConnectorDTO.getIVarianceCounter(),buffer);
		
		return buffer.toString();
	}
}
