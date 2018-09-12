/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

/** 
 * Constants of PriceConnectorDTO.  Whenever a constant
 * a field is added/removed from PriceConnectorDTO, then
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
public interface PriceConnectorDTOConstants
{
	/** constant*/ int SALES_DOCUMENT_NUMBER	= 1;
	/** constant*/ int EE_ITEM_POSITION_NO	= 2;
	/** constant*/ int BILLING_START_DATE		= 3;
	/** constant*/ int BILLING_END_DATE		= 4;
	/** constant*/ int ESW_PRICE				= 5;
	/** constant*/ int CURRENCY				= 6;
	/** constant*/ int BILLING_STATUS	    	= 7;
	
	/** constant*/ int TOTAL_ELEMENTS			= 7;
}
