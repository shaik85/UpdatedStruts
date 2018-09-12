/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import java.util.Iterator;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
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

public class RetrieveIneligInvenDetailInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public RetrieveIneligInvenDetailInputConnectorDTOSerializer()
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
		RetrieveIneligInvenDetailInputConnectorDTO retrieveDTO =
			(RetrieveIneligInvenDetailInputConnectorDTO) connectorDTO;

		StringBuffer buffer = new StringBuffer();

		ConnectorUtility.buildMessage(retrieveDTO.getGenericConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(retrieveDTO.getOrgConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(retrieveDTO.getRetrieveInvenConnectorDTO(), buffer);

		ConnectorUtility.buildMessage(
			ConnectorUtility.getDateByFormat(retrieveDTO.getLastFetchDate(), ConnectorConstants.DATE_FORMAT),
			buffer);
		
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(retrieveDTO.getLastFetchTime(), ConnectorConstants.TIME_FORMAT), buffer);
		ConnectorUtility.buildMessage(retrieveDTO.getContractType(), buffer);
		ConnectorUtility.buildMessage(retrieveDTO.getContractNumber(), buffer);
		//		S and S starts
		ConnectorUtility.buildMessage(retrieveDTO.getProposalContent(), buffer);
		// S and S ends
		
		List custList = retrieveDTO.getCustomerNumber();
		
		if (custList != null)
		{
			Iterator iter = custList.iterator();
			
			while (iter.hasNext())
			{
				ConnectorUtility.buildMessage((String)iter.next(), buffer);
			}
			
			if (custList.size() == 0)
			{
				ConnectorUtility.buildMessage("", buffer);
			}
		}

		return buffer.toString();
	}
}
