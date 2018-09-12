/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


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
public class OrgConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public OrgConnectorDTOSerializer()
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
		OrgConnectorDTO orgConnectorDTO = (OrgConnectorDTO) connectorDTO;

		StringBuffer buffer = new StringBuffer();

		ConnectorUtility.buildMessage(orgConnectorDTO.getSalesOrg(), buffer);
		ConnectorUtility.buildMessage(orgConnectorDTO.getDistributionChannel(), buffer);
		
		if(orgConnectorDTO.getSalesGroup()!=null && !"".equals(orgConnectorDTO.getDistributionChannel())){
			ConnectorUtility.buildMessage(orgConnectorDTO.getSalesGroup(), buffer);
		}
		if(orgConnectorDTO.getChannelRole()!=null && !"".equals(orgConnectorDTO.getChannelRole())){
			ConnectorUtility.buildMessage(orgConnectorDTO.getChannelRole(), buffer);
		}
		if(orgConnectorDTO.getSubmitterRole()!=null && !"".equals(orgConnectorDTO.getSubmitterRole())){
			ConnectorUtility.buildMessage(orgConnectorDTO.getSubmitterRole(), buffer);
		}
		ConnectorUtility.buildMessage(orgConnectorDTO.getDivision(), buffer);

		return buffer.toString();
	}
}
