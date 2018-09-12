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

public class EEDetailsConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public EEDetailsConnectorDTOSerializer()
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
		EEDetailsConnectorDTO eeDetailsDTO = (EEDetailsConnectorDTO) connectorDTO;
		StringBuffer buffer = new StringBuffer();
		
		ConnectorUtility.buildMessage(eeDetailsDTO.getISalesDocNo(),buffer);
		ConnectorUtility.buildMessage(eeDetailsDTO.getIEeItemNumber(),buffer);
		ConnectorUtility.buildMessage(eeDetailsDTO.getISequenceItem(),buffer);
		
		ConnectorUtility.buildMessage(eeDetailsDTO.getCpsID(),buffer);
		ConnectorUtility.buildMessage(eeDetailsDTO.getOcpsID(),buffer);
		ConnectorUtility.buildMessage(eeDetailsDTO.getBLBIndicator(),buffer);
		ConnectorUtility.buildMessage(eeDetailsDTO.getPrebillIndicator(),buffer);
		ConnectorUtility.buildMessage(eeDetailsDTO.getIConditionType(),buffer);
		ConnectorUtility.buildMessage(eeDetailsDTO.getIAmount(),buffer);
		ConnectorUtility.buildMessage(eeDetailsDTO.getICurrency(),buffer);
		ConnectorUtility.buildMessage(eeDetailsDTO.getIBillToParty(),buffer);
		ConnectorUtility.buildMessage(eeDetailsDTO.getIPayer(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(eeDetailsDTO.getSSBilledUptoDate(), ConnectorConstants.DATE_FORMAT),buffer);
		/** CR6153 starts **/
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(eeDetailsDTO.getIContractPeriodStartDate(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(eeDetailsDTO.getIContractPeriodEndDate(), ConnectorConstants.DATE_FORMAT),buffer);
		/** CR6153 ends **/
		return buffer.toString();
	}
}
