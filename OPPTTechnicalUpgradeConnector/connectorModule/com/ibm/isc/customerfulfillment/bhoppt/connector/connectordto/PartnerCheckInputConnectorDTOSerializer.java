/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.PartnerTypeConstants;

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


public class PartnerCheckInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public PartnerCheckInputConnectorDTOSerializer()
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
		PartnerCheckInputConnectorDTO dto = (PartnerCheckInputConnectorDTO) connectorDTO;

		StringBuffer buffer = new StringBuffer();
		ConnectorUtility.buildMessage(dto.getGenericConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(dto.getOrgConnectorDTO(), buffer);

		ConnectorUtility.buildMessage(dto.getPartnerType(), buffer);
		ConnectorUtility.buildMessage(dto.getPartnerLegacyNumber(), buffer);
		/*DADO02&DADO09 Blueharmony sateesh Anne if(!PartnerTypeConstants.PARTNER_9D.equals(dto.getPartnerType())) {
			// Bug Fix. 9D will not have address seq number
			ConnectorUtility.buildMessage(dto.getPartnerAddressSequenceNumber(), buffer);
		}*/
		
		ConnectorUtility.buildMessage(dto.getFinancingContractFlag(), buffer);
		//DADO02&DADO09 BlueHarmony sateesh Anne  ConnectorUtility.buildMessage(dto.getCountryCode(), buffer); /* Changed for EF0607044559S by Sara on June 16,2004 */

		return buffer.toString();
	}
}
