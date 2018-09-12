/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

import java.util.Enumeration;
import java.util.ResourceBundle;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * To read the application properties 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 5, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class OPPTPropertiesReader {
	private static final String PROPERTIES_FILE = "OPPT";  /* NOI18N */
	private static final String SMTP_SERVER = "mail.smtp.server";   /* NOI18N */
	private static final String OPPT_URL = "oppt.url";   /* NOI18N */

	private static final String CONNECTION_POOL_MIN = "connectionpool.min.size";   /* NOI18N */
	private static final String CONNECTION_POOL_MAX = "connectionpool.max.size";   /* NOI18N */
	private static final String CONNECTION_POOL_TIMEOUT = "connectionpool.timeout";   /* NOI18N */

	private static final String SERVICE_LOCATOR_FILE = "service.locator.file";   /* NOI18N */
	private static final String CONNECTOR_CONFIG_FILE = "connector.config.file";   /* NOI18N */
	private static final String MESSAGE_CATALOG_FILE = "message.catalog.file";   /* NOI18N */
	private static final String ROLE_AUTHORIZATION_FILE = "role.authorization.file";   /* NOI18N */
	private static final String OPPT_IMAGE_PATH = "oppt.images.path";   /* NOI18N */
	private static final String OPPT_HTML_PATH = "oppt.html.path";
	private static final String OPPT_LOG_CONFIGURATION = "oppt.log.configuration.file";   /* NOI18N */
	private static final String OPPT_LOG_MESSAGE_FILE = "oppt.log.message.file";   /* NOI18N */

	private static final String OPPT_APPLICATION_ID = "oppt.application.id";   /* NOI18N */
	private static final String OPPT_ENCRYPTION_ALGORITHM = "oppt.encryption.algorithm";   /* NOI18N */

	private static final String CLASS_NAME = "OPPTPropertiesReader";   /* NOI18N */

	private static final String SIGNIN_REGISTER = "signin.register";   /* NOI18N */
	private static final String SIGNIN_FORGOTID = "signin.forgotid";   /* NOI18N */
	private static final String SIGNIN_FORGOTPASSWORD = "signin.forgotpassword";   /* NOI18N */
	private static final String SIGNIN_CHANGEPASSWORD = "signin.changepassword";   /* NOI18N */
	private static final String SIGNIN_WIHELPANDFAQ = "signin.wihelpandfaq";   /* NOI18N */

	private static final String OPPT_USE_DAO_TO_COPY = "oppt.usedaotocopy";   /* NOI18N */
	private static final String OPPT_USE_DAO_TO_COPY_REPLACE = "oppt.usedaotocopyreplace";   /* NOI18N */
	private static final String OPPT_USE_DAO_TO_COPY_VARIANCE = "oppt.usedaotocopyvariance";   /* NOI18N */
	private static final String OPPT_USE_DOWNLOAD = "oppt.usedownload";   /* NOI18N */
	private static final String OPPT_MAX_SWO_FOR_VIEW = "oppt.maxswoforview";   /* NOI18N */
	
	private static final String JMS_QUEUE_CONNECTION_FACTORY = "jms.queueconnectionfactory";   /* NOI18N */
	private static final String JMS_SENDER_QUEUE = "jms.senderqueue";   /* NOI18N */
	private static final String JMS_RECEIVER_QUEUE = "jms.receiverqueue";   /* NOI18N */
	private static final String UD_CONNECTOR_KSH = "oppt.ud.kshlocation";   /* NOI18N */
	private static final String UD_CONNECTOR_URL = "oppt.ud.bluepagesurl";   /* NOI18N */
	private static final String UD_CONNECTOR_PASSWORD = "oppt.ud.keystorepass"; /* NOI18N */
	private static final String MBE_CBS_CODE_READY = "mbe.cbs.codeready"; /* NOI18N */
	private static final String CCMS_SERVER_TRUSTFILE = "ccms.server.trustfile"; /* NOI18N */
	private static final String CCMS_SERVER_KEYFILE = "ccms.server.keyfile"; /* NOI18N */
	
	private static final ResourceBundle bundle;

	static {
		bundle = ResourceBundle.getBundle(PROPERTIES_FILE);

		Enumeration enu = bundle.getKeys();

		while (enu.hasMoreElements()){
		    
			OPPTLogger.debug((String) enu.nextElement(), CLASS_NAME, "Initializer");  //$NON-NLS-1$
		}
	}
		
	/**
	 * To get sign in register
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
		 * @return String
	 */
	
	public static String getSignInRegister() {
		return getAString(SIGNIN_REGISTER);
	}

	/**
	 * To get sign in forgot id 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public static String getSignInForgotID() {
		return getAString(SIGNIN_FORGOTID);
	}

	/**
	 * To get sign in forgot password 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *
	 * @return String
	 */
	
	public static String getSignInForgotPassword() {
		return getAString(SIGNIN_FORGOTPASSWORD);
	}

	/**
	 * To change the sign in password 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public static String getSignInChangePassword() {
		return getAString(SIGNIN_CHANGEPASSWORD);
	}
	
	/**
	 * To get ud connector KSHFile 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public static String getUDConnectorKSHFile() {
			return getAString(UD_CONNECTOR_KSH);
		}
	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public static String getUDUrl() {
				return getAString(UD_CONNECTOR_URL);
			}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public static String getUDConnectorPass() {
				return getAString(UD_CONNECTOR_PASSWORD);
			}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */

	public static String getSignInWIHelpAndFAQ() {
		return getAString(SIGNIN_WIHELPANDFAQ);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getSMTPServer() {
		return getAString(SMTP_SERVER);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getServiceLocatorConfigurationFile() {
		return getAString(SERVICE_LOCATOR_FILE);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getConnectorConfigurationFile() {
		return getAString(CONNECTOR_CONFIG_FILE);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getMessageCatalogFile() {
		return getAString(MESSAGE_CATALOG_FILE);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getRoleAuthorizationFile() {
		return getAString(ROLE_AUTHORIZATION_FILE);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return integer
	 */
	public static int getConnectionPoolMinSize() {
		return getANumber(CONNECTION_POOL_MIN);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return integer
	 */
	public static int getConnectionPoolMaxSize() {
		return getANumber(CONNECTION_POOL_MAX);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return integer
	 */
	public static int getConnectionPoolTimeout() {
		return getANumber(CONNECTION_POOL_TIMEOUT);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getOpptUrl() {
		return getAString(OPPT_URL);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getOPPTImagePath() {
		return getAString(OPPT_IMAGE_PATH);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getLoggerConfigurationFile() {
		return getAString(OPPT_LOG_CONFIGURATION);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getLoggerMessageFile() {
		return getAString(OPPT_LOG_MESSAGE_FILE);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getMBECBSCodeReady() {
		return getAString(MBE_CBS_CODE_READY);
	}
	
	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getApplicationID() {
		return getAString(OPPT_APPLICATION_ID);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getEncryptionAlgorithm() {
		return getAString(OPPT_ENCRYPTION_ALGORITHM);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getQueueConnectionFactory() {
		return getAString(JMS_QUEUE_CONNECTION_FACTORY);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getSenderQueue() {
		return getAString(JMS_SENDER_QUEUE);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getReceiverQueue() {
		return getAString(JMS_RECEIVER_QUEUE);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public static boolean useDAO() {
		boolean result = false;
		try {
			String str = bundle.getString(OPPT_USE_DAO_TO_COPY);
			if (str != null && "true".equals(str)) {  /* NOI18N */
				result = true;
			}
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "OPPTPropertiesReader", "UseDAO", null, e);  /* NOI18N */  /* NOI18N */  //$NON-NLS-3$
		}
		return result;
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public static boolean useDAOForCopyReplace() {
		boolean result = false;
		try {
			String str = bundle.getString(OPPT_USE_DAO_TO_COPY_REPLACE);
			if (str != null && "true".equals(str)) {  /* NOI18N */
				result = true;
			}
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "OPPTPropertiesReader", "useDAOForCopyReplace", null, e);  /* NOI18N */  /* NOI18N */  /* NOI18N */
		}
		return result;
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public static boolean useDAOForVariance() {
		boolean result = false;
		try {
			String str = bundle.getString(OPPT_USE_DAO_TO_COPY_VARIANCE);
			if (str != null && "true".equals(str)) {  /* NOI18N */
				result = true;
			}
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "OPPTPropertiesReader", "useDAOForVariance", null, e);  /* NOI18N */  /* NOI18N */  /* NOI18N */
		}
		return result;
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public static boolean useDownload() {
		boolean result = false;
		try {
			String str = bundle.getString(OPPT_USE_DOWNLOAD);
			if (str != null && "true".equals(str)) {  /* NOI18N */
				result = true;
			}
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "OPPTPropertiesReader", "useDownload", null, e);  /* NOI18N */  /* NOI18N */  /* NOI18N */
		}
		return result;
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return integer
	 */
	public static int getMaxSWOForViewProposal() {
		int result = 800;
		try {
			String str = bundle.getString(OPPT_MAX_SWO_FOR_VIEW);
			str = OPPTHelper.trimStringToNull(str);
			if (str != null) {
				result = Integer.parseInt(str);
			}
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "OPPTPropertiesReader", "maxForViewProposal", null, e);  /* NOI18N */  /* NOI18N */  /* NOI18N */
		}
		return result;
	}
	
	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getOPPTHTMLPath() {
		return getAString(OPPT_HTML_PATH);
	}
	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getCCCMSServerTrustFile() {
		return getAString(CCMS_SERVER_TRUSTFILE);
	}
	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public static String getCCCMSServerKeyFile() {
		return getAString(CCMS_SERVER_KEYFILE);
	}

	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return integer
	 */
	private static int getANumber(String key) {
		int size = -1;

		try {
			size = Integer.parseInt(bundle.getString(key));
		} catch (NumberFormatException ex) {
			OPPTLogger.log("INVALID_NUMBER", OPPTLogger.WARNING, CLASS_NAME, "getANumber", key);  /* NOI18N */  /* NOI18N */
		}

		return size;
	}

	/**
     * To trim the string
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 28, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return String
     * @param key 
     */
	public static String getAString(String key) {
		String str = bundle.getString(key);

		return OPPTHelper.trimString(str);
	}
}