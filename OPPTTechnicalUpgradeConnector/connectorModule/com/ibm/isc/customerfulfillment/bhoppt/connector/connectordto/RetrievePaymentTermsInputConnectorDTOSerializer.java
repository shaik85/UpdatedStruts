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


public class RetrievePaymentTermsInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public RetrievePaymentTermsInputConnectorDTOSerializer()
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
	 */
	public String createNewMsg(ConnectorDTOInterface connectorDTO)
	{
		RetrievePaymentTermsInputConnectorDTO retrievePaymentTermsInputConnectorDTO = (RetrievePaymentTermsInputConnectorDTO)connectorDTO;
		
		StringBuffer buffer = new StringBuffer();

		ConnectorUtility.buildMessage(retrievePaymentTermsInputConnectorDTO.getFunctionModuleName(), buffer);
		ConnectorUtility.buildMessage(retrievePaymentTermsInputConnectorDTO.getSessionID(), buffer);		
		
		return buffer.toString();
	}
}
