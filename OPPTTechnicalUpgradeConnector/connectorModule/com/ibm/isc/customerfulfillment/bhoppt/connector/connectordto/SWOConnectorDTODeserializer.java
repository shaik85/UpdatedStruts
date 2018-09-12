/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

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

import java.util.ArrayList;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser;

public class SWOConnectorDTODeserializer
	implements OutputConnectorDTODeserializerInterface, SWOConnectorDTOConstants
{
	private boolean ineligible = false;
	private boolean isSAndSAllowed = true;

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
	public SWOConnectorDTODeserializer()
	{
	}

	/**
	 * To set the flag if the call is for ineligible inventory
	 * details  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aIneligible
	 */
	public void setIneligble(boolean aIneligible)
	{
		ineligible = aIneligible;
	}
	/**
	 * setSAndSAllowed
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param flag
	 */
	public void setSAndSAllowed(boolean flag)
	{
		isSAndSAllowed = flag;
	}
	
	/**
	 * This method is used to parse the given string and build objects
	 * out of it.
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 */
	public ConnectorDTOInterface parseMsgString(StringParser tokenizer, ConnectorDTOInterface connectorDTO)
		throws Exception
	{
		List list = null;
		
		if (connectorDTO instanceof RetrieveInvenDetailOutputConnectorDTO)
		{
			RetrieveInvenDetailOutputConnectorDTO outputConnectorDTO =
				(RetrieveInvenDetailOutputConnectorDTO) connectorDTO;
			
			list = outputConnectorDTO.getSWOConnectorDTOList();
			
			if (list == null)
			{
				list = new ArrayList();
				outputConnectorDTO.setSWOConnectorDTOList(list);
			}
		}
		else if (connectorDTO instanceof RetrieveDeltaInventoryOutputConnectorDTO)
		{
			RetrieveDeltaInventoryOutputConnectorDTO outputConnectorDTO =
				(RetrieveDeltaInventoryOutputConnectorDTO) connectorDTO;
			
			list = outputConnectorDTO.getSWOConnectorDTOList();
			
			if (list == null)
			{
				list = new ArrayList();
				outputConnectorDTO.setSWOConnectorDTOList(list);
			}
		}
		else if (connectorDTO instanceof CheckVarianceOutputConnectorDTO)
		{
			CheckVarianceOutputConnectorDTO dto = (CheckVarianceOutputConnectorDTO)connectorDTO;
			
			list = dto.getSWOConnectorDTOList();
			if (list == null)
			{
				list = new ArrayList();
				dto.setSWOConnectorDTOList(list);
			}
		}
		
		if (tokenizer.hasMoreTokens())
		{
			// Length
			int length = Integer.parseInt(tokenizer.nextToken());

			if (length > 0)
			{
				int totalCounter = 1, elementCounter = 1;
				String temp;
				SWOConnectorDTO swoConnectorDTO = new SWOConnectorDTO();

				int totalElements = TOTAL_ELEMENTS;

				if (ineligible == false)
				{
					totalElements = TOTAL_ELEMENTS - TOTAL_INELIGIBLE_ELEMENTS + 1;
					
					if (isSAndSAllowed == false)
					{
						totalElements--;			
					}
				}
				

				while (tokenizer.hasMoreTokens())
				{
					temp = tokenizer.nextToken();

					if (temp != null)
					{
						totalCounter += temp.length() + 1;
					}
					else
					{
						totalCounter++;
					}

					switch (elementCounter % totalElements)
					{
						case SALES_DOCUMENT_NUMBER :
							swoConnectorDTO = new SWOConnectorDTO();
							list.add(swoConnectorDTO);
							swoConnectorDTO.setSalesDocumentNumber(temp);
							break;

						case SWO_ITEM_POSITION_NUMBER :
							swoConnectorDTO.setSWOItemPositionNumber(temp);
							break;

						case SALES_DOCUMENT_CATEGORY :
							swoConnectorDTO.setSalesDocumentCategory(temp);
							break;

						case REQUEST_DELIVERY_DATE :
							swoConnectorDTO.setRequestDeliveryDate(ConnectorUtility.getDate(temp));
							break;

						case CUSTOMER_NUMBER :
							swoConnectorDTO.setCustomerNumber(temp);
							break;

						case CUSTOMER_PURCHASE_ORDER_NUMBER :
							swoConnectorDTO.setCustomerPurchaseOrderNumber(temp);
							break;

						case DESIGNATED_MACHINE :
							swoConnectorDTO.setDesignatedMachine(temp);
							break;

						case DESIG_MACHINE_DESCRIPTION :
							swoConnectorDTO.setDesigMachineDesc(temp);
							break;

						case SWO_MATERIAL_NUMBER :
							swoConnectorDTO.setSWOMaterialNumber(temp);
							break;

						case SWO_DESCRIPTION :
							swoConnectorDTO.setSWODesc(temp);
							break;

						case SWO_SERIAL_NUMBER :
							swoConnectorDTO.setSWOSerialNumber(temp);
							break;

						case REFERENCE_SERIAL_NUMBER :
							swoConnectorDTO.setReferenceSerialNumber(temp);
							break;

						case REFEREENCE_DESIGNATED_MACHINE :
							swoConnectorDTO.setReferenceDesignatedMachine(temp);
							break;

						case EQUIPMENT_NUMBER :
							swoConnectorDTO.setEquipmentNumber(temp);
							break;

						case SWO_EXTERNAL_CONTRACT_NUMBER :
							swoConnectorDTO.setSWOExternalContractNumber(temp);
							break;

						case SWO_CONTRACT_TYPE :
							swoConnectorDTO.setSWOContractType(temp);
							break;

						case SWO_CONTRACT_STATUS :
							swoConnectorDTO.setSWOContractStatus(temp);
							
							if ((ineligible == false) && (isSAndSAllowed == false))
							{
								elementCounter = 0;
							}
							break;
							
						case S_AND_S_IND :
							swoConnectorDTO.setSAndSIndicator(temp);

							if (ineligible == false)
								elementCounter = 0;

							break;

						case INELIGIBLE_FLAG :
							swoConnectorDTO.setIneligibleFlag(temp);
							break;

						case LICENSE_EFFECTIVE_DATE :
							swoConnectorDTO.setLicenseEffectiveDate(ConnectorUtility.getDate(temp));
							break;

						case INELIGIBILITY_COMMENT : // same as default
						default :
							swoConnectorDTO.setIneligibilityComment(temp);
							elementCounter = 0;
					}

					elementCounter++;

					if (totalCounter >= length)
					{
						break;
					}
				}
			}
		}

		return connectorDTO;
	}
}
