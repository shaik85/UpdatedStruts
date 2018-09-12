/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.authorization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTParser;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * This class is mainly used for cheking whether a user has access on particular action. 
 * Given the role of the user, this class helps in checking whether that user with that 
 * role has access on specified action.
 * 
 * Different roles in oppt are:
 * <ol>
 * 	<li>Marketing Rep
 * 	<li>Proposal Approver
 * 	<li>CSO
 * 	<li>Business Partner
 * 	<li>Manager
 * 	<li>CreateApprove
 * 	<li>BHD
 * </ol>
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 28, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class RoleAuthorization {
	
	private static final String CLASS_NAME="RoleAuthorization";  //$NON-NLS-1$
	private static RoleAuthorization cRoleAuthorization = null;
	
	private HashMap iActionRoles = null;
	/**
	 * Constructor
	 * RoleAuthorization type is an singleton class. Only one instance of this class shoulf be 
	 * present in memory. We should not allow users to create a new instance. So the constructor 
	 * is made private. When ever you want to make use of RoleAuthorization type, call getInstance 
	 * static method get a reference to RoleAuthorization type and use it. 
	 * 
	 * <br/><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	private RoleAuthorization(){
		iActionRoles = new HashMap();
		populateActionRoles();
	}
	
	/**
	 * RoleAuthorizaton type is and single ton class. Only one instance of this type should be
	 * existing in memory. So, when ever you want to get an instance of RoleAuthorization call 
	 * getInstance method, get  reference to RoleAuthorization and perform the method calls. 
	 * 
	 * This first checks the RoleAuthorization instance is null. If null it creates a new reference 
	 * and returns. If not null it returns already existing  reference.   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public static RoleAuthorization getInstance(){
		if(null == cRoleAuthorization){
			cRoleAuthorization = new RoleAuthorization(); 
		}
		return cRoleAuthorization;
	}
	
	/**
	 * Parses the xml RoleAuthorization xml document and creates action role mapping out 
	 * of the data  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 */
	private void populateActionRoles(){
		String methodName="populateActionRoles";  //$NON-NLS-1$
		
		try{
			InputStream xmlInputStream = new FileInputStream(new File(OPPTPropertiesReader.getRoleAuthorizationFile()));
			Node configFileNode =OPPTParser.getBaseNode(xmlInputStream);
			ArrayList actionRoles = OPPTParser.getChildElements(configFileNode);
			for(int i=0; i<actionRoles.size(); i++){
				Node actionRole = (Node)actionRoles.get(i);
				String id = OPPTParser.getAttributeValue(actionRole, "id");  //$NON-NLS-1$
				ArrayList roleList = new ArrayList();
				populateRoles(actionRole, roleList);
				iActionRoles.put(id, roleList);			
			}
		}
		catch(ParserConfigurationException pce){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, pce);  //$NON-NLS-1$
		}
		catch(SAXException se){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, se);  //$NON-NLS-1$
		}
		catch(IOException ioe){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ioe);  //$NON-NLS-1$
		}
		printActionRoles();
	}

	/**
	 * Given and ActionRole node, it gets the role's with in that node and populates the 
	 * ArrayList passed to this method.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param actionRole Node
	 * @param roleList ArrayList
	 */
	private void populateRoles(Node actionRole, ArrayList roleList){
		ArrayList roleNodes = OPPTParser.getChildElements(actionRole);

		if(null != roleNodes){
			int roleCount = roleNodes.size();
			for(int i=0; i < roleCount; i++){
				String roleValue = OPPTParser.getValue((Node)roleNodes.get(i));
				if(null != roleValue){
					try{
						roleList.add(new Integer(Integer.parseInt(roleValue)));	
					}
					catch(Exception e){}
				}
				
			}
		}
	}

	/**
	 * Prints the Action Role mapping collection.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 */	
	public void printActionRoles(){
		Iterator keys = iActionRoles.keySet().iterator();
		while(keys.hasNext()){
			String actionId = (String)keys.next();
			ArrayList roleList = (ArrayList)iActionRoles.get(actionId);
		}
	}
	
	/**
	 * Given the action identifier and role, this method checks whether the specified role 
	 * has access on given action. If the role has access on the action it returns true 
	 * else it returns false.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param actionId String
	 * @param role String
	 * @return boolean
	 */	
	public boolean isRoleHasAccess(String actionId, int role){
		boolean hasAccess = false;
		if(null != actionId){
			ArrayList roleList = (ArrayList)iActionRoles.get(actionId);
			if(null != roleList){
				for(int i=0, size=roleList.size(); i<size; i++){
					int newRole = ((Integer)roleList.get(i)).intValue();
					if(role == newRole){
						hasAccess = true;
						break;
					}
				}
			}
			else{
				hasAccess = true;
			}
		}
		return hasAccess;
	}
}
