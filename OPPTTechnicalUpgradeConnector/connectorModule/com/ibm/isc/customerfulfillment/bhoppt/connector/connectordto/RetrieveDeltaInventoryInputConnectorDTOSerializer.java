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
public class RetrieveDeltaInventoryInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public RetrieveDeltaInventoryInputConnectorDTOSerializer()
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
		RetrieveDeltaInventoryInputConnectorDTO dto = (RetrieveDeltaInventoryInputConnectorDTO) connectorDTO;

		StringBuffer buffer = new StringBuffer();
		ConnectorUtility.buildMessage(dto.getGenericConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(dto.getOrgConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(dto.getRetrieveInvenConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(dto.getContractNumber(), buffer);
		ConnectorUtility.buildMessage(dto.getProposalContent(), buffer);

		List list = dto.getCustomerNumberList();

		if (list != null && list.size() > 0)
		{
			Iterator iter = list.iterator();

			while (iter.hasNext())
			{
				ConnectorUtility.buildMessage((String) iter.next(), buffer);
			}
		}
		else
		{
			ConnectorUtility.buildMessage("", buffer);
		}

		return buffer.toString();
	}
}
