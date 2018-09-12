/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


/** 
 * Constants of SWOConnectorDTO.  Whenever a constant
 * a field is added/removed from SWOConnectorDTO, then
 * this constant interface has to change.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 27, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public interface SWOConnectorDTOConstants
{
	/**constant*/ int SALES_DOCUMENT_NUMBER			= 1;
	/**constant*/ int SWO_ITEM_POSITION_NUMBER		= 2;
	/**constant*/ int SALES_DOCUMENT_CATEGORY		= 3;
	/**constant*/ int REQUEST_DELIVERY_DATE			= 4;
	/**constant*/ int CUSTOMER_NUMBER				= 5;
	/**constant*/ int CUSTOMER_PURCHASE_ORDER_NUMBER	= 6;
	/**constant*/ int DESIGNATED_MACHINE				= 7;
	/**constant*/ int DESIG_MACHINE_DESCRIPTION		= 8;
	/**constant*/ int SWO_MATERIAL_NUMBER			= 9;
	/**constant*/ int SWO_DESCRIPTION				= 10;
	/**constant*/ int SWO_SERIAL_NUMBER				= 11;
	/**constant*/ int REFERENCE_SERIAL_NUMBER		= 12;
	/**constant*/ int REFEREENCE_DESIGNATED_MACHINE	= 13;
	/**constant*/ int EQUIPMENT_NUMBER				= 14;
	/**constant*/ int SWO_EXTERNAL_CONTRACT_NUMBER	= 15;
	/**constant*/ int SWO_CONTRACT_TYPE				= 16;
	/**constant*/ int SWO_CONTRACT_STATUS			= 17;
	/**constant*/ int S_AND_S_IND					= 18;
	/**constant*/ int INELIGIBLE_FLAG				= 19;
	/**constant*/ int LICENSE_EFFECTIVE_DATE			= 20;
	/**constant*/ int INELIGIBILITY_COMMENT			= 21;
	
	/**constant*/ int TOTAL_ELEMENTS					= 21;
	/**constant*/ int TOTAL_INELIGIBLE_ELEMENTS		= 3;
}
