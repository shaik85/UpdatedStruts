/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;




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
public class RetrieveInvenConfigInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public RetrieveInvenConfigInputConnectorDTOSerializer()
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
		RetrieveInvenConfigInputConnectorDTO dto = (RetrieveInvenConfigInputConnectorDTO) connectorDTO;

		StringBuffer buffer = new StringBuffer();

		ConnectorUtility.buildMessage(dto.getGenericConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(String.valueOf(dto.getFlag()), buffer);

		int length = 0;
		List list = dto.getRetrieveConfigConnectorDTOList();

		for (int i = 0; i < list.size(); i++)
		{
			length += getLength((RetrieveConfigConnectorDTO) list.get(i));
		}

		ConnectorUtility.buildMessage(Integer.toString(length), buffer);
		for (int i = 0; i < list.size(); i++)
		{
			ConnectorUtility.buildMessage((ConnectorDTOInterface) list.get(i), buffer);
		}

		return buffer.toString();
	}

	private int getLength(RetrieveConfigConnectorDTO dto)
	{
		int length = ConnectorConstants.CONNECTOR_STRING_DELIMITOR.length() * 6 + 1;

		if (dto.getSalesDocNo() != null)
		{
			length += dto.getSalesDocNo().length();
		}

		if (dto.getSwoItemNo() != null)
		{
			length += dto.getSwoItemNo().length();
		}

		if (dto.getEeItemNo() != null)
		{
			length += dto.getEeItemNo().length();
		}

		if (dto.getValueMetric() != null)
		{
			length += dto.getValueMetric().length();
		}

		if (dto.getLicenseType() != null)
		{
			length += dto.getLicenseType().length();
		}

		if (dto.getChargeOption() != null)
		{
			length += dto.getChargeOption().length();
		}

		return length;
	}
}
