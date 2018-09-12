/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;




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
public class PriceInquiryInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public PriceInquiryInputConnectorDTOSerializer()
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
		PriceInquiryInputConnectorDTO dto = (PriceInquiryInputConnectorDTO) connectorDTO;
		StringBuffer buffer = new StringBuffer();

		ConnectorUtility.buildMessage(dto.getGenericConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(dto.getOrgConnectorDTO(), buffer);

		ConnectorUtility.buildMessage(dto.getCustomerNumber(), buffer);
		ConnectorUtility.buildMessage(
			ConnectorUtility.getDateByFormat(dto.getBumpDate(), ConnectorConstants.DATE_FORMAT),
			buffer);
			
		ConnectorUtility.buildMessage(Integer.toString(getLength(dto)), buffer);
		ConnectorUtility.buildMessage(dto.getSalesDocNo(), buffer);
		ConnectorUtility.buildMessage(dto.getSwoItemNo(), buffer);
		ConnectorUtility.buildMessage(dto.getEeItemNo(), buffer);
		ConnectorUtility.buildMessage(dto.getValueMetric(), buffer);
		ConnectorUtility.buildMessage(dto.getUseLevel(), buffer);
		ConnectorUtility.buildMessage(dto.getLicenseType(), buffer);
		ConnectorUtility.buildMessage(dto.getChargeOption(), buffer);
		
		return buffer.toString();
	}
	/**
	 *  getLength 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param dto
	 * @return int
	 */	
	private int getLength(PriceInquiryInputConnectorDTO dto)
	{
		int length = ConnectorConstants.CONNECTOR_STRING_DELIMITOR.length() * 7 + 1;

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

		if (dto.getUseLevel() != null)
		{
			length += dto.getUseLevel().length();
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
