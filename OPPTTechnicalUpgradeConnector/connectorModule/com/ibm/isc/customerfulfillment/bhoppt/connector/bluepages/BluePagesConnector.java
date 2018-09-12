/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.bluepages;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import com.ibm.bluepages.BPResults;
import com.ibm.bluepages.BluePages;
import com.ibm.isc.customerfulfillment.bhoppt.connector.UserProfileConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.UserProfilesConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

public class BluePagesConnector {
    
    private static final String INTERNET = "INTERNET";  /* NOI18N */
    private static final String NAME = "NAME";  /* NOI18N */
    private static final String MGRNUM = "MGRNUM";  /* NOI18N */
    private static final String EMPNUM = "EMPNUM";  /* NOI18N */
    private static final String MNUM = "MNUM";  /* NOI18N */
	
    /** 
     * This is to get userprofiles from blue pages
     * <br/><b>Known Bugs</b><br/> 
     * 
     * <br/><PRE> 
     * date Sep 24, 2004 
     * 
     * revision date author reason 
     * 
     * </PRE><br/> 
     * @author Balaji Venkatesan
     * @version 5.1x
     * @param connectorDTO
     * @return UserProfileConnectorDTO
     * @throws ConnectorException
     */	    
    public UserProfileConnectorDTO getProfile(UserProfileConnectorDTO connectorDTO) throws ConnectorException {
        
        try {
			BPResults bpResults = null;
			bpResults = BluePages.getPersonsByInternet(connectorDTO.getUserID());
			if(null != bpResults) {
				int rows = bpResults.rows();
			    if(0 == rows) {
			    	throw ExceptionGenerator.generateConnectorException(ErrorCodeConstants.C0003);
			    }
				loadData(connectorDTO, bpResults,false,null);
			}
		} catch (Exception e) {
		    OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"BluePagesConnector","getProfile",null,e); 
		    throw ExceptionGenerator.generateConnectorException(ErrorCodeConstants.C0003);
		}
        
		return connectorDTO;
	}
    
    /**
     * This method apart from getting user details will also get the details of the Manager from BluePages
     * @param userProfilesDTO
     * @return UserProfilesConnectorDTO
     * @throws ConnectorException
     * 
     */
	public UserProfilesConnectorDTO getProfiles(UserProfilesConnectorDTO userProfilesDTO) throws ConnectorException {
	    
	    Map userProfilesMap = userProfilesDTO.getUserProfiles();
		Iterator iter = userProfilesMap.keySet().iterator();
		try {
		    while (iter.hasNext()) {
		        UserProfileConnectorDTO profileDTO = new UserProfileConnectorDTO();
		        String userId = (String) iter.next();
		        profileDTO.setUserID(userId);
		        BPResults bpResults = null;
		        bpResults = BluePages.getPersonsByInternet(userId);
		        if(null != bpResults) {
		        	int rows = bpResults.rows();
		        	if(0 == rows){
		        		continue;
		        	}
		            loadData(profileDTO, bpResults,false,null);
		            profileDTO.setAuthenticated(true);
		            String managerId = getManagerId(bpResults);
		            if( null != managerId) {
		            	bpResults = BluePages.getPersonByCnum(managerId);
		                String managerNumber = getManagerNumber(bpResults);
		                loadData(profileDTO, bpResults,true,managerNumber);
		            }
		        }
		        userProfilesMap.put(userId,profileDTO);
		    }
		} catch (Exception e) {
		   // Do not handle as if user did not have a profile in blue pages then we do not worry
		}
		return userProfilesDTO;
	}
	/**
     * load Data
     * @param connectorDTO
     * @param bpResults
     * @param manager
     */	
	private void loadData(UserProfileConnectorDTO connectorDTO,BPResults bpResults,boolean manager,String managerNumber) {

		int rows = bpResults.rows();
		
		for (int k = 0; k < rows; k++) {
			Hashtable hastTab = bpResults.getRow(k);
			String name  = (String)  hastTab.get(NAME);	
			String email = (String) hastTab.get(INTERNET);
			String empNumber = OPPTHelper.trimString((String)hastTab.get(EMPNUM));
			if(manager) {
				if(managerNumber != null && empNumber != null) {
					if(!managerNumber.equals(empNumber)) {
						continue;
					}
				}
			}
			
			
			String firstName = "";
			String lastName = "";
			if( null != name) {
			    StringTokenizer strTkn = new StringTokenizer(name,",");
			    if (strTkn.hasMoreTokens()) {
			    	firstName = OPPTHelper.trimString(strTkn.nextToken());
				}
			    if (strTkn.hasMoreTokens()) {
			    	lastName = OPPTHelper.trimString(strTkn.nextToken());
			    }
			}
					
			if(manager) {
				connectorDTO.setManagerEmailAddress(email);
				connectorDTO.setManagerFirstName(firstName);
				connectorDTO.setManagerLastName(lastName);
				break;
			}else {
				connectorDTO.setEmailAddress(email);
				connectorDTO.setFirstName(firstName);
				connectorDTO.setLastName(lastName);	
			}
		}
	}
	/**
     *   getManagerId
     * @param bpResults
     * @param manager
     * @return String
     * 
     */		
	private String getManagerId(BPResults bpResults) {
	    int rows = bpResults.rows();
	    String managerId = null;
		for (int k = 0; k < rows; k++) {
			Hashtable hastTab = bpResults.getRow(k);
			managerId = (String) hastTab.get(MNUM);
		}
		return OPPTHelper.trimString(managerId);
	}
	
	private String getManagerNumber(BPResults bpResults) {
		
	    int rows = bpResults.rows();
	    String managerNumber = null;
		for (int k = 0; k < rows; k++) {
			Hashtable hastTab = bpResults.getRow(k);
			managerNumber = (String) hastTab.get(EMPNUM);
		}
		return OPPTHelper.trimString(managerNumber);
	}

}
