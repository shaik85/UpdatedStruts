/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector;

import com.ibm.isc.customerfulfillment.bhoppt.connector.bluepages.BluePagesConnector;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException;

/** 
 * This is a deligate in future if we move to UD then we can switch at this class
 * 
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
 */
public class UserProfileConnector {

	/**
	 * This is a Wrapper for WebIdentity 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param connectorDTO
	 * @return
	 * @throws ConnectorException
	 */

	public UserProfileConnectorDTO getProfile(UserProfileConnectorDTO connectorDTO) throws ConnectorException {
		
		BluePagesConnector connector = new BluePagesConnector();
		connectorDTO = connector.getProfile(connectorDTO);
		

		return connectorDTO;
	}

	/**
     * This method is used by service layer to get details of a users from a particular sales org
     * The connector Exception in thismethod is swallowed so that admin see the details of other users
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Sep 24, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param userProfilesConnectorDTO
     * @return
     * @param connectorDTO
     * @throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException 
     */
	public UserProfilesConnectorDTO populateNames(UserProfilesConnectorDTO connectorDTO) throws ConnectorException {
		
		BluePagesConnector connector = new BluePagesConnector();
		connectorDTO = connector.getProfiles(connectorDTO);
		
		return connectorDTO;
	}
}