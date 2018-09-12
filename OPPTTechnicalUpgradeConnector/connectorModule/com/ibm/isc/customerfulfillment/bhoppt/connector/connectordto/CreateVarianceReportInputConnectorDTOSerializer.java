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
public class CreateVarianceReportInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public CreateVarianceReportInputConnectorDTOSerializer()
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
	public String createNewMsg(ConnectorDTOInterface connectorDTO)throws Exception
	{
		CreateVarianceReportInputConnectorDTO createVarianceReportInputConnectorDTO = (CreateVarianceReportInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		ConnectorUtility.buildMessage(createVarianceReportInputConnectorDTO.getGenericConnectorDTO(),buffer);
		ConnectorUtility.buildMessage(createVarianceReportInputConnectorDTO.getSalesOrg(),buffer);
		ConnectorUtility.buildMessage(createVarianceReportInputConnectorDTO.getExternalContractNumber(),buffer);
		ConnectorUtility.buildMessage(createVarianceReportInputConnectorDTO.getProposalType(),buffer);
		
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createVarianceReportInputConnectorDTO.getContractPeriodStartDate(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createVarianceReportInputConnectorDTO.getContractPeriodEndDate(), ConnectorConstants.DATE_FORMAT),buffer);
		
		ConnectorUtility.buildMessage(createVarianceReportInputConnectorDTO.getCapAmount(),buffer);
		ConnectorUtility.buildMessage(createVarianceReportInputConnectorDTO.getLegacyCustomerNo(),buffer);
		//ConnectorUtility.buildMessage(createVarianceReportInputConnectorDTO.getAddressSequenceNo(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createVarianceReportInputConnectorDTO.getVarianceDate(), ConnectorConstants.DATE_FORMAT),buffer);
		
		ConnectorUtility.buildMessage(createVarianceReportInputConnectorDTO.getIndicatorVarType(),buffer);
		ConnectorUtility.buildMessage(createVarianceReportInputConnectorDTO.getIndicatorQuoteIncluded(),buffer);
		
		return buffer.toString();
	}
}
