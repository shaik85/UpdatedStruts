/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


/** 
 * Constants of RetrieveCustConnectorDTO.  Whenever a constant
 * a field is added/removed from RetrieveCustConnectorDTO, then
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
public interface RetrieveCustConnectorDTOConstants
{
	/** constant */ int CUSTOMER_LIST_NO 			= 1;
	/** constant */ int CUSTOMER_NUMBER			= 2;
	/** constant */ int CUSTOMER_NAME				= 3;
	/** constant */ int LEGACY_CUSTOMER_NUMBER		= 4;
	/** constant */ int ADDRESS_SEQUENCE_NUMBER	= 5;
	/** constant */ int COUNTRY_CODE				= 6; //EF0607044559
	
	/** constant */ int TOTAL_ELEMENTS				= 6; //EF0607044559
}
