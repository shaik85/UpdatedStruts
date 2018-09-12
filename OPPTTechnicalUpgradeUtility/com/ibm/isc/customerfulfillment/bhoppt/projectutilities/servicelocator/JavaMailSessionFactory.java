/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator;

import javax.mail.Session;
/** 
 * This interface has method for returning Mail Session object.
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
public interface JavaMailSessionFactory {
	/**
	 *  
	 * This method returns default Mail Seeion object by taking JNDI from xml file
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Session
	 */
	public Session getJavaMailSession();
	
	/**
	 *  
	 *This method returns Mail Session object for the JNDI given by user
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param mailSessionJndi
	 * @return Session
	 */
	public Session getJavaMailSession(String mailSessionJndi);

}
