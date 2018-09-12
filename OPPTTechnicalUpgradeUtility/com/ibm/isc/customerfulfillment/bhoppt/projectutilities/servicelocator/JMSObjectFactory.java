/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator;

import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;

/** 
 * This interface contains methods that returns Queue and Queue Connecton factroy.
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
public interface JMSObjectFactory {
	/**
	 *  
	 * This method returns default QueueConnectionFactory object by taking JNDI from xml file
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
	 * @return
	 */
	public QueueConnectionFactory getQueueConnectionFactory();
	
	/**
	 *  
	 * This method returns QueueConnectionFactory object for the JNDI given by user
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
	 * @param jmsConnectionJndi
	 * @return
	 */
	public QueueConnectionFactory getQueueConnectionFactory(String jmsConnectionJndi);
	
	/**
     * This method returns Queue object for the JNDI given by user
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 3, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @return
     * @param jmsQueueJndi 
     */
	public Queue getQueue(String jmsQueueJndi);/**
	 *  
	 * This method returns Queue object for the JNDI given by user
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public QueueConnectionFactory resetQueueConnectionFactory();


}
