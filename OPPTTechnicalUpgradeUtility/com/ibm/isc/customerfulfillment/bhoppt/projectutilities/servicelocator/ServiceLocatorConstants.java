/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator;

/** 
 * Constants file for storing values that are used for service locator.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 27, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A 
 */
public class ServiceLocatorConstants {
	
	/**
	 * Constant for storing Ejb locator 
	 */
	public static final String EJB_LOCATOR_PATH = "java:comp/env/";  /* NOI18N */
	
	/**
	 * Constant for storing configuration XML file name
	 */
	public static final String XML_FILE_NAME = "OPPTJndiDetail.xml";  /* NOI18N */
	
	/**
	 * Constant for storing node name for InitialContextFactory
	 */
	public static final String CONTEXT_NODE_NAME = "jndi-context";  /* NOI18N */
	
	/**
	 * Constant for storing node name for Provider Url
	 */
	public static final String PROVIDER_URL_NODE_NAME = "jndi-url";  /* NOI18N */
	
	/**
	 * Constant for storing node name for Data Source
	 */
	public static final String DATA_SOURCE_NODE_NAME= "data-source";  /* NOI18N */
	
	/**
	 * Constant for storing node name for QueueConnectionFactory
	 */
	public static final String JMS_NODE_NAME = "jms";  /* NOI18N */
	
	/**
	 * Constant for storing node name for MailSession
	 */
	public static final String MAIL_SESSION_NODE_NAME = "mail-session";  /* NOI18N */
	
	/**
	 * Constant for storing node name for Enterprise Beans
	 */
	public static final String EJB_NODE_NAME = "enterprise-beans";  /* NOI18N */
	
	/**
	 * Constant for storing node name for different beans
	 */
	public static final String BEAN_NODE_NAME = "bean";  /* NOI18N */
	
	/**
	 * Constant for storing node name for Enterprise Beans
	 */
	public static final String DATA_SOURCE_JNDI_NODE_NAME= "jndi-name";  /* NOI18N */
	
	/**
	 * Constant for storing node name for Enterprise Beans
	 */
	public static final String MAIL_SESSION_JNDI_NODE_NAME = "jndi-name";  /* NOI18N */
	
	/**
	 * Constant for storing node name for Enterprise Beans
	 */
	public static final String QUEUE_CONNECTION_KEY = "connectionFactory";  /* NOI18N */

	/**
	 * Constant for storing node name for Enterprise Beans
	 */
	public static final String JMS_JNDI_NODE_NAME= "jndi-name";  /* NOI18N */
	
	/**
	 * Constant for storing node name for Enterprise Beans
	 */
	public static final String IDENTIFIER_ATTRIBUTE_NAME= "identifier";  /* NOI18N */
	
	/**
	 * Constant for storing node name for Enterprise Beans
	 */
	public static final String EJB_REFERENCE_NODE_NAME= "ejb-reference";  /* NOI18N */
	
	/**
	 * Constant for storing node name for Enterprise Beans
	 */
	public static final String EJB_JNDI_NODE_NAME= "ejb-jndi";  /* NOI18N */
		
	/**
	 * Constant for storing node name for Enterprise Beans
	 */
	public static final String EJB_HOME_NODE_NAME= "home";  /* NOI18N */
}
