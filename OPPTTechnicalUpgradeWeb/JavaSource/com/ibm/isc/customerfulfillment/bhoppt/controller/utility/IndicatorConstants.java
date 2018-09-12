/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.utility;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 4, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public interface IndicatorConstants {
    /** constant */
    String FOR_CONTRACT = OPPTPropertiesReader.getOPPTImagePath()+"indicators/for_contract.gif"; /* NOI18N */

    /** constant */
    String REFETCH_LICENSE = OPPTPropertiesReader.getOPPTImagePath()+"indicators/refetch_license.gif"; /* NOI18N */

    /** constant */
    String DELTA_FETCH_LICENSE = OPPTPropertiesReader.getOPPTImagePath()+"indicators/delta_fetch_license.gif"; /* NOI18N */

    /** constant */
    String AMENDED_LICENSE = OPPTPropertiesReader.getOPPTImagePath()+"indicators/amended_license.gif"; /* NOI18N */
}
