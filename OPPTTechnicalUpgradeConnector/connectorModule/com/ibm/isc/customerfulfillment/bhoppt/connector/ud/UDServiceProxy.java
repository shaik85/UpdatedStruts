/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.ud;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import com.ibm.isc.customerfulfillment.bhoppt.connector.UserProfileConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.UserProfilesConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;

/**
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 18, 2005 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version CBS 1.0
 */
public class UDServiceProxy {
	private static Properties properties = null;

	private static final String CLASS_NAME = "UDConnector"; /* NOI18N */
	private static String SEARCH_SCOPE = "ou=persons,o=ibm.com"; /* NOI18N */
	// private static String JAVA_KEYSTORE = "c:/repository/Unified_Directory/uesw_cdt0729.jks";
	private static String JAVA_KEYSTORE = OPPTPropertiesReader.getUDConnectorKSHFile(); 
	private static String BLUE_PAGES_URL = OPPTPropertiesReader.getUDUrl();
	private static String JAVA_KEYSTORE_PW = OPPTPropertiesReader.getUDConnectorPass();

	private static final String REMOVE = "REMOVE";

	private DirContext dirContext = null;

	private List propertyChangeListenerList = new ArrayList();
	/**
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br/> 
	 */
	public UDServiceProxy() {
		if (null == properties) {
			initialize();
		}
	}
	/** 
	 * initialize
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * revision date author reason 
	 * </PRE><br>
	 */
	private static void initialize() {
		//System.setProperty("javax.net.ssl.keyStore", JAVA_KEYSTORE);
		//System.setProperty("javax.net.ssl.keyStorePassword", JAVA_KEYSTORE_PW);

		properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		properties.put("java.naming.ldap.derefAliases", "never");
		properties.put("java.naming.ldap.referral.bind", "true");
		properties.put("java.naming.ldap.version", "3");
		properties.put(Context.REFERRAL, "follow");
		properties.put(Context.SECURITY_PROTOCOL, "ssl");
		// properties.put(Context.PROVIDER_URL, "ldap://sslbluepages.mkm.can.ibm.com:636");
		properties.put(Context.PROVIDER_URL, BLUE_PAGES_URL);

	}

	//	public void addPropertyChangeListener(PropertyChangeListener listener){
	//		propertyChangeListenerList.add(listener);
	//	}
	//
	//	public void close()
	//	{
	//		Iterator iter = propertyChangeListenerList.iterator();
	//
	//		while (iter.hasNext())
	//		{
	//			PropertyChangeListener listener = (PropertyChangeListener) iter.next();
	//			listener.propertyChange(new PropertyChangeEvent(this, REMOVE, null, this));
	//		}
	//	}
	/** 
	 * authenticate
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * revision date author reason 
	 * </PRE><br>
	 * @param userID
	 * @param password
	 * @throws ConnectorException
	 */
	public void authenticate(String userID, String password) throws ConnectorException {
		
		boolean authenticated = true;

		try {
			String principal = "uid=" + getUID(userID) + ",ou=persons,o=ibm.com";
			
			Properties local = new Properties();
			local.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			local.put("java.naming.ldap.derefAliases", "never");
			local.put("java.naming.ldap.referral.bind", "true");
			local.put("java.naming.ldap.version", "3");
			local.put(Context.REFERRAL, "follow");
			local.put(Context.SECURITY_PROTOCOL, "ssl");
			local.put(Context.PROVIDER_URL, BLUE_PAGES_URL);
			local.put(Context.SECURITY_AUTHENTICATION, "simple");
			local.put(Context.SECURITY_PRINCIPAL, principal);
			local.put(Context.SECURITY_CREDENTIALS, password.trim());
			new InitialDirContext(local);

		} catch (Exception e) {
			
			e.printStackTrace();
			throw ExceptionGenerator.generateConnectorException(ErrorCodeConstants.C0001);
		}
		
	}
	/** 
	 * getProfile
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * revision date author reason 
	 * </PRE><br>
	 * @param userDTO
	 * @return UserProfilesConnectorDTO
	 * @throws ConnectorException
	 */
	public UserProfileConnectorDTO getProfile(UserProfileConnectorDTO userDTO) throws ConnectorException {
		
		Attributes matchAttrs = new BasicAttributes(true);
		matchAttrs.put(new BasicAttribute("authenid", userDTO.getUserID()));

		try {
			NamingEnumeration results = getDirContext().search(SEARCH_SCOPE, matchAttrs);
			if (results.hasMoreElements()) {
				SearchResult sr = (SearchResult) results.next();
				Attributes attr = sr.getAttributes();
				userDTO.setFirstName((String) attr.get("givenname").get());
				userDTO.setLastName((String) attr.get("sn").get());
				userDTO.setEmailAddress((String) attr.get("mail").get());
			}
		} catch (Exception e) {
		
			e.printStackTrace();
			throw ExceptionGenerator.generateConnectorException(ErrorCodeConstants.C0003);

		}
		
		return userDTO;
	}
	/** 
	 * getProfiles
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * revision date author reason 
	 * </PRE><br>
	 * @param userProfilesDTO
	 * @return UserProfilesConnectorDTO
	 * @throws ConnectorException
	 */
	public UserProfilesConnectorDTO getProfiles(UserProfilesConnectorDTO userProfilesDTO) throws ConnectorException {
		Map userProfilesMap = userProfilesDTO.getUserProfiles();
		Iterator iter = userProfilesMap.keySet().iterator();

		String[] returnIDs = { "authenid", "givenname", "sn", "mail" };

		StringBuffer filter = new StringBuffer();
		filter.append("(|");
		while (iter.hasNext()) {
			filter.append("(authenid=" + iter.next() + ") ");
		}
		filter.append(")");

		
		SearchControls ctls = new SearchControls();
		ctls.setReturningAttributes(returnIDs);

		try {
			NamingEnumeration results = getDirContext().search(SEARCH_SCOPE, filter.toString(), ctls);
			while (results.hasMoreElements()) {
				SearchResult sr = (SearchResult) results.next();
				Attributes attr = sr.getAttributes();

				UserProfileConnectorDTO profileDTO = new UserProfileConnectorDTO();
				String authenID = (String) attr.get("authenid").get();
				profileDTO.setUserID(authenID);
				profileDTO.setFirstName((String) attr.get("givenname").get());
				profileDTO.setLastName((String) attr.get("sn").get());
				profileDTO.setEmailAddress((String) attr.get("mail").get());

				userProfilesMap.put(authenID, profileDTO);
			}
		} catch (Exception e) {
			throw ExceptionGenerator.generateConnectorException(ErrorCodeConstants.C0003);
		}

		return userProfilesDTO;
	}
	/** 
	 * getDirContext
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * revision date author reason 
	 * </PRE><br>
	 * @param userID
	 * @return String
	 * @throws Exception
	 */
	private String getUID(String userID) throws Exception {
		String uID = null;
		try {
			Attributes matchAttrs = new BasicAttributes(true);
			matchAttrs.put(new BasicAttribute("authenid", userID));

			NamingEnumeration results = getDirContext().search(SEARCH_SCOPE, matchAttrs);
			
			if (results.hasMoreElements()) {
				SearchResult sr = (SearchResult) results.next();
				Attributes attr = sr.getAttributes();
				
				uID = (String) attr.get("uid").get();
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			throw ExceptionGenerator.generateConnectorException(ErrorCodeConstants.C0003);

		}

		return uID;
	}
	/** 
	 * getDirContext
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * revision date author reason 
	 * </PRE><br>
	 * @return DirContext
	 * @throws ConnectorException
	 */
	private DirContext getDirContext() throws ConnectorException {
		TimeTaken timeTaken = new TimeTaken("UDServiceProxy","getDirContext");
		try {
			dirContext = new InitialDirContext(UDServiceProxy.properties);
		} catch (Exception e) {
			throw ExceptionGenerator.generateConnectorException(ErrorCodeConstants.C0004);
		}
		timeTaken.end();
		return dirContext;
	}
}
