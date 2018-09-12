/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

/**
 * Enter one sentence as a brief description for your class. You can enter more
 * text here (e.g. describe the purpose of the class here).
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date Dec 23, 2003
 * 
 * revision date author reason
 * 
 * </PRE>
 * 
 * <br/>
 * 
 * @author Balaji Venkatesan
 * @version 5.1A
 */
public interface PriceConstants {

    /** constant */
    String SVC = "V"; /* NOI18N */

    // Indicator Constants
    /** constant */
    String YES = "Y"; /* NOI18N */

    /** constant */
    String NO = "N"; /* NOI18N */

    // Licences
    /** constant */
    String EXCLUDED = "E"; /* NOI18N */

    /** constant */
    String NOT_EXCLUDED = "I"; /* NOI18N */

    /** constant */
    String ALL = "A"; /* NOI18N */

    /** constant */
    String MLC = "M"; /* NOI18N */

    /** constant */
    String S_AND_S = "S"; /* NOI18N */

    // proposal Level
    /** constant */
    String VARIANCE_PROPOSAL = "VAR"; /* NOI18N */

    /** constant */
    String ANNIV_AMT_PROPOSAL = "ANIV"; /* NOI18N */

    /** constant */
    String ANNIV_AMT_EAS_PROPOSAL = "ANIVEAS"; /* NOI18N */

    // We are using BigDecimal for calculation purpose so we need a scale
    // for divide function.
    /** constant */
    int PRECISION = 30; /* NOI18N */

}
