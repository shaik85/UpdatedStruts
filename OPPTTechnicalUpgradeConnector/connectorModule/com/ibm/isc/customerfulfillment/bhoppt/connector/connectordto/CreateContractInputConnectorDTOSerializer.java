/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import java.util.List;
import java.util.Iterator;

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
public class CreateContractInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
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
	public CreateContractInputConnectorDTOSerializer()
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
	 * @return String created new message
	 * @throws Exception
	 */
	public String createNewMsg(ConnectorDTOInterface connectorDTO) throws Exception
	{
		CreateContractInputConnectorDTO createContractInputConnectorDTO = (CreateContractInputConnectorDTO)connectorDTO;
		StringBuffer buffer = new StringBuffer();
		
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIGenericConnectorDTO(),buffer);
//		 Commented for the change DAD O11 Remove approval step,Blue Harmony -by Ramesh Gandi
		//ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIApproverUserId(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIOrgConnectorDTO(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIContractNumber(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIExternalContractNumber(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIVarianceCount(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIFinancingContractNumber(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIProposalType(),buffer);
		
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createContractInputConnectorDTO.getIContractStartDate(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createContractInputConnectorDTO.getIContractEndDate(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createContractInputConnectorDTO.getIContractStartPeriod(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createContractInputConnectorDTO.getIContractEndPeriod(), ConnectorConstants.DATE_FORMAT),buffer);
		
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIBillingFrequencyNumber(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getESWStringFor(createContractInputConnectorDTO.getISpecialRate()),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIAnniversaryAmount(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getESWStringFor(createContractInputConnectorDTO.getIGrowthFactor()),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getICapAmount(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getESWStringFor(createContractInputConnectorDTO.getICapPlus()),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getESWStringFor(createContractInputConnectorDTO.getICapMinus()),buffer);
		
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIPreTVMInvoiceAmount(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getICurrency(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIFlag(),buffer);
	//commented out for wave 1 release-PakId removal CR by Nomita
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIPakId(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIPaymentTerm(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createContractInputConnectorDTO.getIFixedValDate(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIAddValueDays(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIBillingType(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIAdvanceBilling(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIInvoiceIndicator(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIDeviatingRule(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIBillingBlock(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIPoNumber(),buffer);
		ConnectorUtility.buildMessage(ConnectorUtility.getDateByFormat(createContractInputConnectorDTO.getIPoDate(), ConnectorConstants.DATE_FORMAT),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIGsaIndicator(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIBillingSupressIndicator(),buffer);
		/*CR6153 Start changes*/
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getISAndASExtendInd(),buffer);
		/*CR6153 End changes*/
		
// BH Wave1 - DAD003 - Begin - Bhanu
		
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getCpsID(),buffer);
		
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getOcpsID(),buffer);
		//ConnectorUtility.buildMessage(createContractInputConnectorDTO.getComplexContractAmendment(),buffer);
		//ConnectorUtility.buildMessage(createContractInputConnectorDTO.getMasterContractID(),buffer);
		
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getContractType(),buffer);
		//ConnectorUtility.buildMessage(createContractInputConnectorDTO.getMasterContractAmendment(),buffer);
		
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getBLBIndicator(),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getPrebillIndicator(),buffer);
		//ConnectorUtility.buildMessage("prebill",buffer);
		String paymentMethod;
		if("".equalsIgnoreCase(createContractInputConnectorDTO.getIFinancingContractNumber())||null==createContractInputConnectorDTO.getIFinancingContractNumber())
			{
			paymentMethod="7";
	}
			else{
//	System.out
	//.println("CreateContractInputConnectorDTO.getPaymentMethod()igfOfferNumberin E"+igfOfferNumber);

				paymentMethod="E";
			}
			ConnectorUtility.buildMessage(paymentMethod,buffer);
		//System.out
		//		.println("CreateContractInputConnectorDTOSerializer.createNewMsg()getPrebillIndicator()"+createContractInputConnectorDTO.getPrebillIndicator());
		//ConnectorUtility.buildMessage(createContractInputConnectorDTO.getpr
		
		
		// BH Wave1 - DAD003 - End - Bhanu
		ConnectorUtility.buildMessage(getFreeTextLength(createContractInputConnectorDTO.getIFreeText()),buffer);
		ConnectorUtility.buildMessage(createContractInputConnectorDTO.getIFreeText(),buffer);		
		
		List partnerInfoList =  createContractInputConnectorDTO.getIPartnerInfoConnectorDTO();
		int lengthPartnerInfo = 0;
		for (int i = 0; i < partnerInfoList.size(); i++)
		{
			lengthPartnerInfo += getLength((PartnerInfoConnectorDTO) partnerInfoList.get(i));
		}
		lengthPartnerInfo = lengthPartnerInfo +1;
		ConnectorUtility.buildMessage(Integer.toString(lengthPartnerInfo), buffer);
		
		PartnerInfoConnectorDTO partnerInfoConnectorDTO = new PartnerInfoConnectorDTO();
		if (partnerInfoList != null && partnerInfoList.size() > 0)
		{
			Iterator iter = partnerInfoList.iterator();
			while (iter.hasNext())
			{
				partnerInfoConnectorDTO = (PartnerInfoConnectorDTO)iter.next();
				ConnectorUtility.buildMessage(partnerInfoConnectorDTO,buffer);
			}
		}
		
		
		List eeDetailsList =  createContractInputConnectorDTO.getIEEDetailsConnectorDTO();
		
		int lengthEEDetails = 0;
		for (int i = 0; i < eeDetailsList.size(); i++)
		{
			lengthEEDetails += getLength((EEDetailsConnectorDTO) eeDetailsList.get(i));
		}
		lengthEEDetails = lengthEEDetails + 1;
		ConnectorUtility.buildMessage(Integer.toString(lengthEEDetails), buffer);
		
		EEDetailsConnectorDTO eeDetailsConnectorDTO = new EEDetailsConnectorDTO();
		if (eeDetailsList != null && eeDetailsList.size() > 0)
		{
			Iterator iter = eeDetailsList.iterator();
			while (iter.hasNext())
			{
				eeDetailsConnectorDTO = (EEDetailsConnectorDTO)iter.next();
				ConnectorUtility.buildMessage(eeDetailsConnectorDTO,buffer);
				
			}
		}
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
	private int getLength(PartnerInfoConnectorDTO dto)
	{
		int length = ConnectorConstants.CONNECTOR_STRING_DELIMITOR.length() * 2;
		if (dto.getIPartnerFunction() != null)
		{
			length += dto.getIPartnerFunction().length();
		}

		if (dto.getIPartnerNo() != null)
		{
			length += dto.getIPartnerNo().length();
		}		
		
		return length;
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
	private int getLength(EEDetailsConnectorDTO dto)
	{

		/** CR6153 starts **/
		//int length = ConnectorConstants.CONNECTOR_STRING_DELIMITOR.length() * 9;
		int length = ConnectorConstants.CONNECTOR_STRING_DELIMITOR.length() * 15;
		/** CR6153 ends **/

		if (dto.getISalesDocNo() != null)
		{
			length += dto.getISalesDocNo().length();
		}

		if (dto.getIEeItemNumber() != null)
		{
			length += dto.getIEeItemNumber().length();
		}
		if (dto.getISequenceItem() != null)
		{
			length += dto.getISequenceItem().length();
		}	
		if (dto.getCpsID() != null)
		{
			length += dto.getCpsID().length();
		}
		if (dto.getOcpsID() != null)
		{
			length += dto.getOcpsID().length();
		}
		if (dto.getBLBIndicator() != null)
		{
			length += dto.getBLBIndicator().length();
		}
		if (dto.getPrebillIndicator() != null)
		{
			length += dto.getPrebillIndicator().length();
		}
		if (dto.getIConditionType() != null)
		{
			length += dto.getIConditionType().length();
		}		
		if (dto.getIAmount() != null)
		{
			length += dto.getIAmount().length();
		}		
		if (dto.getICurrency() != null)
		{
			length += dto.getICurrency().length();
		}		
		if (dto.getIBillToParty() != null)
		{
			length += dto.getIBillToParty().length();
		}		
		if (dto.getIPayer() != null)
		{
			length += dto.getIPayer().length();
		}		
		if (dto.getSSBilledUptoDate() != null)
		{
			length += dto.getSSBilledUptoDate().toString().length();
		}		
		
		/** CR6153 starts **/
		if (dto.getIContractPeriodStartDate() != null)
		{
			length += dto.getIContractPeriodStartDate().toString().length()-2;
		}		
		if (dto.getIContractPeriodEndDate() != null)
		{
			length += dto.getIContractPeriodEndDate().toString().length()-2;
		}		
		/** CR6153 ends **/
		
		return length;
	}
	/**
	 *  getFreeTextLength
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param freeText
	 * @return String
	 */		
	private String getFreeTextLength(String freeText)
	{
		int length = ConnectorConstants.CONNECTOR_STRING_DELIMITOR.length() * 2;
		
		if (freeText != null)
		{
			length += freeText.trim().length();		
		}
		
		return Integer.toString(length);
	}
}
