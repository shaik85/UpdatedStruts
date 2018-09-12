/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator;

import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A 
 */
public interface EJBHomeFactory {
	/**
     * get remote object
     *
     * @param ejbIdentifier
     * @return EJBHome
     */
    EJBHome getRemoteHome(String ejbIdentifier);
	/**
	 * ejb locate home
     * @param ejbIdentifier
     * @return
     */
    EJBLocalHome getLocalHome(String ejbIdentifier);
}
