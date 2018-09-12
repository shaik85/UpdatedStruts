/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.mail.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTParser;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
//import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.UtilityLogConstants;
/**
 * This class provides methods for locating different service components
 * like EJB, Mail Service and JMS. It parses the XML file and keeps the information,
 * required for locating a service, in local variables. After locating a service it keeps
 * the object in HashMap to implement caching.     
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class ServiceLocator
	implements DataSourceFactory, EJBHomeFactory, JavaMailSessionFactory, JMSObjectFactory {

	/**
	 * Static reference of the class.
	 */
	private static ServiceLocator cServiceLocator = new ServiceLocator();

	/**
	 *  
	 * Constructor 
	 * Private constructor to make the class a singleton class. It creates tow instances of HashMap.
	 * HashMap "iCacheTable" is used for storing the instances of different services  and
	 * HashMap "iEJBConfigDetail" is for storing the configuration of EJBs.It also intializes the 
	 * XMLPath field and calls configureLocator() which does the initial configuration(Calls OPPTParser 
	 * to parse the XML fillen and store store the values in local variables.
	 * 
	 * <br/><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	private ServiceLocator() {
		iCacheTable = new HashMap();
		iEJBConfigDetail = new HashMap();
		try {
			iXmlInputStream =
				new FileInputStream(new File(OPPTPropertiesReader.getServiceLocatorConfigurationFile()));
		} catch (FileNotFoundException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ServiceLocator", "Constructor", null, e);  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
		}
		configureLocator();
	}

	/**
	 *  Reference for InitialContext;
	 */
	private InitialContext iInitialContext = null;
	/**
	 *  Static reference for HashMap(For storing instances of different Services)
	 */
	private HashMap iCacheTable;

	/**
	 * Static variable to store the configuration file in InputStream.
	 */
	private InputStream iXmlInputStream;

	/**
	 * HashMap to store EJB configuration detail.
	 */
	private HashMap iEJBConfigDetail;

	/**
	 * Static variable to store the JNDI detail for JMS.
	 */
	private String iJmsJndiPath = null;

	/**
	 * Static variable to store the JNDI detail for Mail Session. 
	 */
	private String iMailSessionJndiPath = null;

	/**
	 * Static variable to store the JNDI detail for Data Source. 
	 */
	private String iDataSourceJndiPath = null;

	/**
	 *  
	 * This method returns the static instance of ServiceLocator.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	private static ServiceLocator getInstance() {
		return cServiceLocator;
	}

	/**
	 *  
	 * This method returns DataSourceFactory.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public static DataSourceFactory getDataSourceFactory() {
		return getInstance();
	}

	/**
	 *  
	 * This method returns EJBHomeFactory. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public static EJBHomeFactory getEJBHomeFactory() {
		return getInstance();
	}

	/**
	 *  
	 * This method returns JavaMailSessionFactory.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public static JavaMailSessionFactory getJavaMailSessionFactory() {

		return getInstance();
	}

	/**
	 *  
	 * This method returns JMSObjectFactory.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public static JMSObjectFactory getJMSObjectFactory() {
		return getInstance();
	}

	/**
	 *  
	 * Overridden method 
	 * This method receives an EJB identifier and checks whether corresponding remote home is present
	 * in cache(Hashtable). It returns the object from Hashtable if it is present there 
	 * otherwise it looks up to locate a new instance, populates the Hashtable and returns
	 * the same instance. 
	 * 
	 * <br/><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param ejbIdentifier String
	 * @return EJBHome
	 *
	 */
	public EJBHome getRemoteHome(String ejbIdentifier) {
		EJBHome beanHome = null;
		if (iCacheTable.containsKey(ejbIdentifier)) {
			beanHome = (EJBHome) iCacheTable.get(ejbIdentifier);
		} else {
			try {
				EJBDetail ejbDetail = (EJBDetail) iEJBConfigDetail.get(ejbIdentifier);
				String ejbLocator = ejbDetail.getEjbJndi();
				Object homeObject = iInitialContext.lookup(ejbLocator);
				beanHome =
					(EJBHome) PortableRemoteObject.narrow(homeObject, Class.forName(ejbDetail.getEJBHome()));

				iCacheTable.put(ejbIdentifier, beanHome);
			} catch (NamingException nme) {
				//				OPPTLogger.error().log(UtilityLogConstants.ServLoc101e,
				//						"com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator",
				//						"getRemoteHome",nme.toString());
			} catch (ClassNotFoundException cne) {
				//				OPPTLogger.error().log(UtilityLogConstants.ServLoc102e,
				//						"com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator",
				//						"getRemoteHome",cne.toString());
			}
		}
		return beanHome;
	}

	/**
	 *  
	 * Overridden method 
	 * This method receives an EJB identifier and checks whether corresponding local home is present
	 * in cache(Hashtable). It returns the object from Hashtable if it is present there 
	 * otherwise it looks up to locate a new instance, populates the Hashtable and returns
	 * the same instance.  
	 * 
	 * <br/><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param ejbIdentifier String
	 * @return EJBLocalHome
	 *
	 */
	public EJBLocalHome getLocalHome(String ejbIdentifier) {
		EJBLocalHome beanHome = null;
		if (iCacheTable.containsKey(ejbIdentifier)) {
			beanHome = (EJBLocalHome) iCacheTable.get(ejbIdentifier);
		} else {
			try {
				EJBDetail ejbDetail = (EJBDetail) iEJBConfigDetail.get(ejbIdentifier);
				String ejbLocator = ServiceLocatorConstants.EJB_LOCATOR_PATH + ejbDetail.getEJBReference();
				//System.out.println("ServiceLocator.getLocalHome()"+ServiceLocatorConstants.EJB_LOCATOR_PATH);
				Object homeObject = iInitialContext.lookup(ejbLocator);

				beanHome = (EJBLocalHome) homeObject;
				iCacheTable.put(ejbIdentifier, beanHome);
			} catch (NamingException nme) {
				//				OPPTLogger.error().log(UtilityLogConstants.ServLoc101e,
				//					"com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator",
				//					"getLocalHome",nme.toString());
			}
		}
		return beanHome;

	}

	/**
	 *  
	 * Overridden method 
	 * This method returns default DataSource object for the JNDI given in xml file.
	 * 
	 * 
	 * <br/><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.DataSourceFactory#getDataSource() 
	 * @return DataSource
	 *
	 */
	public DataSource getDataSource() {
		return getDataSource(iDataSourceJndiPath);
	}

	/**
	 * 
	 * This method checks if DataSource object for the given JNDI  is 
	 * present in cache (Hashtable). It returns the object from Hashtable if it is present
	 * in Hashtable otherwise it looks up to locate a new instance, populates the Hashtable
	 * and returns the same instance. This method returns DataSource object for the JNDI given by user
	 * 
	 * <br/><PRE> 
	 * date Nov 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param dataSourceJndi
	 * @return 
	 *
	 */
	public DataSource getDataSource(String dataSourceJndi) {
		DataSource dataSource = null;
		if (iCacheTable.containsKey(dataSourceJndi)) {
			dataSource = (DataSource) iCacheTable.get(dataSourceJndi);
		} else {
			try {
				dataSource = (DataSource) iInitialContext.lookup(iDataSourceJndiPath);
				iCacheTable.put(dataSourceJndi, dataSource);
			} catch (NamingException nme) {
				//				OPPTLogger.error().log(UtilityLogConstants.ServLoc101e,
				//					"com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator",
				//					"getDataSource",nme.toString());
			}
		}
		return dataSource;
	}

	/**
	 *  
	 * Overridden method 
	 * This method returns default Mail Session object for the JNDI given in xml file.
	 * 
	 * <br/><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @return Session
	 *
	 */
	public Session getJavaMailSession() {
		return getJavaMailSession(iMailSessionJndiPath);
	}

	/**
     * Overridden method
     * This method checks if Mail Session object for the given JNDI
     * in cache (Hashtable). It returns the object from Hashtable if it is present in
     * Hashtable otherwise it looks up to locate a new instance, populates the Hashtable
     * and returns the same instance.
     * <br/><PRE>
     * date Nov 24, 2003
     * revision date author reason
     * </PRE><br/>
     *
     * @return Session
     * @param mailSessionJndi 
     */
	public Session getJavaMailSession(String mailSessionJndi) {
		Session mailSession = null;
		if (iCacheTable.containsKey(mailSessionJndi)) {
			mailSession = (Session) iCacheTable.get(mailSessionJndi);
		} else {
			try {
				mailSession = (Session) iInitialContext.lookup(mailSessionJndi);
				iCacheTable.put(mailSessionJndi, mailSession);
			} catch (NamingException nme) {
				//				OPPTLogger.error().log(UtilityLogConstants.ServLoc101e,
				//					"com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator",
				//					"getJavaMailSession",nme.toString());
			}
		}
		return mailSession;
	}

	/**
	 *  
	 * Overridden method
	 * This method returns default QueueConnectionFactory object i.e. for the JNDI given in
	 * xml file.
	 * 
	 * <br/><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.JMSObjectFactory#getQueueConnectionFactory() 
	 * @return QueueConnectionFactory
	 *
	 */
	public QueueConnectionFactory getQueueConnectionFactory() {
		return getQueueConnectionFactory(iJmsJndiPath);
	}

	/**
	 *  
	 * Overridden method
	 * This method checks if QueueConnectionFactory object for the given JNDI 
	 * is present in cache (Hashtable). It returns the object from Hashtable if it is
	 * present in Hashtable otherwise it looks up to locate a new instance, populates 
	 * the Hashtable and returns the same instance.  
	 * 
	 * <br/><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.JMSObjectFactory#getQueueConnectionFactory() 
	 * @return QueueConnectionFactory
	 *
	 */
	public QueueConnectionFactory getQueueConnectionFactory(String jmsConnectionJndi) {
		QueueConnectionFactory connectionFactory = null;
		if (iCacheTable.containsKey(jmsConnectionJndi)) {
			connectionFactory = (QueueConnectionFactory) iCacheTable.get(jmsConnectionJndi);
		} else {
			try {
				connectionFactory = (QueueConnectionFactory) iInitialContext.lookup(jmsConnectionJndi);
				iCacheTable.put(jmsConnectionJndi, connectionFactory);
			} catch (NamingException nme) {
				//				OPPTLogger.error().log(UtilityLogConstants.ServLoc101e,
				//					"com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator",
				//					"getQueueConnectionFactory",nme.toString());
			}
		}
		return connectionFactory;
	}

	/**
	 *  
	 * Overridden method 
	 * This method checks if Queue object for the given JNDI is present in cache (Hashtable).
	 * It returns the object from Hashtable if it is present in Hashtable otherwise it looks
	 * up to locate a new instance, populates the Hashtable and returns the same instance.
	 * 
	 * <br/><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param jmsQueueJndi String
	 * @return Queue
	 *
	 */
	public Queue getQueue(String jmsQueueJndi) {
		Queue queue = null;
		if (iCacheTable.containsKey(jmsQueueJndi)) {
			queue = (Queue) iCacheTable.get(jmsQueueJndi);
		} else {
			try {
				queue = (Queue) iInitialContext.lookup(jmsQueueJndi);
				iCacheTable.put(jmsQueueJndi, queue);
			} catch (NamingException nme) {
				//				OPPTLogger.error().log(UtilityLogConstants.ServLoc101e,
				//					"com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator",
				//					"getQueue",nme.toString());
			}
		}
		return queue;
	}

	/**
	 *  
	 * This method is responsible for calling OPPTParser for parsing the configuration file
	 *  and storing them in local variables.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 */
	private void configureLocator() {
		Node returnNode = null;
		NodeList childNodes = null;
		Hashtable contextProperties = new Hashtable();
		try {
			Node configFileNode = OPPTParser.getBaseNode(iXmlInputStream);
			childNodes = OPPTParser.getChildNodeList(configFileNode);

			returnNode = OPPTParser.getNodeFromNodeList(childNodes, ServiceLocatorConstants.DATA_SOURCE_NODE_NAME);
			configureDataSource(returnNode);

			returnNode = OPPTParser.getNodeFromNodeList(childNodes, ServiceLocatorConstants.JMS_NODE_NAME);
			configureJMS(returnNode);

			returnNode =
				OPPTParser.getNodeFromNodeList(childNodes, ServiceLocatorConstants.MAIL_SESSION_NODE_NAME);
			configureMailSession(returnNode);

			returnNode = OPPTParser.getNodeFromNodeList(childNodes, ServiceLocatorConstants.EJB_NODE_NAME);
			configureEJBDetails(
				OPPTParser.getNodeListFromNodeList(
					OPPTParser.getChildNodeList(returnNode),
					ServiceLocatorConstants.BEAN_NODE_NAME));

			iInitialContext = new InitialContext();
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ServiceLocator", "configureLocator", null, e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
		}

	}

	/**
	 *  
	 * Extracts the JNDI information for DataSource from XML file and sets it to 
	 * local variable "cDataSourceJndiPath".
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dataSourceNode Node
	 */
	private void configureDataSource(Node dataSourceNode) {
		NodeList nodeList = OPPTParser.getChildNodeList(dataSourceNode);
		Node jndiNode =
			OPPTParser.getNodeFromNodeList(nodeList, ServiceLocatorConstants.DATA_SOURCE_JNDI_NODE_NAME);

		iDataSourceJndiPath = OPPTParser.getValue(jndiNode);
	}

	/**
	 *  
	 * Extracts the JNDI information for JMS from XML file and sets it to 
	 * local variable "cJmsJndiPath".
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param jmsNode Node
	 */
	private void configureJMS(Node jmsNode) {
		NodeList nodeList = OPPTParser.getChildNodeList(jmsNode);
		Node jndiNode = OPPTParser.getNodeFromNodeList(nodeList, ServiceLocatorConstants.JMS_JNDI_NODE_NAME);

		iJmsJndiPath = OPPTParser.getValue(jndiNode);
	}

	/**
	 *  
	 * Extracts the JNDI information for Mail Session from XML file and sets it to 
	 * local variable "cMailSessionJndiPath".
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param mailSessionNode Node
	 */
	private void configureMailSession(Node mailSessionNode) {
		NodeList nodeList = OPPTParser.getChildNodeList(mailSessionNode);
		Node jndiNode =
			OPPTParser.getNodeFromNodeList(nodeList, ServiceLocatorConstants.MAIL_SESSION_JNDI_NODE_NAME);

		iMailSessionJndiPath = OPPTParser.getValue(jndiNode);
	}

	/**
	 * 
	 * Extracts the Bean detail from xml file packs it in EJBDetail object and stores it in
	 * HashMap "iEJBConfigDetail";
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param beanList ArrayList
	 */
	private void configureEJBDetails(ArrayList beanList) {
		Node beanNode = null;
		Node referenceNode = null;
		Node jndiNode = null;
		Node homeNode = null;
		String beanIdentifier = "";  //$NON-NLS-1$

		EJBDetail beanDetail = null;
		int arrayListLength = beanList.size();

		for (int i = 0; i < arrayListLength; i++) {
			beanDetail = new EJBDetail();
			beanNode = (Node) beanList.get(i);
			beanIdentifier =
				OPPTParser.getAttributeValue(beanNode, ServiceLocatorConstants.IDENTIFIER_ATTRIBUTE_NAME);
			referenceNode =
				OPPTParser.getNodeFromNodeList(
					OPPTParser.getChildNodeList(beanNode),
					ServiceLocatorConstants.EJB_REFERENCE_NODE_NAME);
			jndiNode =
				OPPTParser.getNodeFromNodeList(
					OPPTParser.getChildNodeList(beanNode),
					ServiceLocatorConstants.EJB_JNDI_NODE_NAME);
			homeNode =
				OPPTParser.getNodeFromNodeList(
					OPPTParser.getChildNodeList(beanNode),
					ServiceLocatorConstants.EJB_HOME_NODE_NAME);

			if (null != referenceNode) {
				beanDetail.setEJBReference(OPPTParser.getValue(referenceNode));
			}
			if (null != jndiNode) {
				beanDetail.setEjbJndi(OPPTParser.getValue(jndiNode));
			}
			if (null != homeNode) {
				beanDetail.setEJBHome(OPPTParser.getValue(homeNode));
			}

			iEJBConfigDetail.put(beanIdentifier, beanDetail);
		}
	}
	
	/**
	 * 
	 * Extracts the Bean detail from xml file packs it in EJBDetail object and stores it in
	 * HashMap "iEJBConfigDetail";
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param beanList ArrayList
	 */
	public QueueConnectionFactory resetQueueConnectionFactory () {
		QueueConnectionFactory connectionFactory = null;
		
		try {
			connectionFactory = (QueueConnectionFactory) iInitialContext.lookup(iJmsJndiPath);
			iCacheTable.put(iJmsJndiPath, connectionFactory);
		} catch (NamingException nme) {
				//				OPPTLogger.error().log(UtilityLogConstants.ServLoc101e,
				//					"com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator",
				//					"getQueueConnectionFactory",nme.toString());
			}
		
		return connectionFactory;
	}

}