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

public class ValidateBPAccessInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public ValidateBPAccessInputConnectorDTOSerializer()
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
	public String createNewMsg(ConnectorDTOInterface connectorDTO)  throws Exception
	{
		ValidateBPAccessInputConnectorDTO validateBPAccessInputConnectorDTO = (ValidateBPAccessInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		
		ConnectorUtility.buildMessage(validateBPAccessInputConnectorDTO.getGenericConnectorDTO(),buffer);
		ConnectorUtility.buildMessage(validateBPAccessInputConnectorDTO.getSalesOrg(),buffer);
		ConnectorUtility.buildMessage(validateBPAccessInputConnectorDTO.getAccessOption(),buffer);
		
		if(validateBPAccessInputConnectorDTO.getAccessOption().equals("CL"))		
		{
			String[] custList = validateBPAccessInputConnectorDTO.getCustListNo();
			for(int i=0; i<custList.length; i++)
			{		
				ConnectorUtility.buildMessage(custList[i], buffer);
			}						
		}
		else
		{	
			List bpLegacyList = validateBPAccessInputConnectorDTO.getCustListAndSeqConnectorDTO();
			CustListAndSeqConnectorDTO custListAndSeqConnectorDTO = new CustListAndSeqConnectorDTO();
			if (bpLegacyList != null && bpLegacyList.size() > 0)
			{
				Iterator iter = bpLegacyList.iterator();
				while (iter.hasNext())
				{
					custListAndSeqConnectorDTO = (CustListAndSeqConnectorDTO)iter.next();
					InputConnectorDTOSerializerInterface inputConnectorSerializer = ConnectorUtility.getInputConnectorSerializer(CustListAndSeqConnectorDTO.class.getName());
					buffer.append(inputConnectorSerializer.createNewMsg(custListAndSeqConnectorDTO));
				}
			}							
		}
		return buffer.toString();
	}
}
