/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.ud;

import com.ibm.isc.customerfulfillment.bhoppt.connector.UserProfileConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.UserProfilesConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException;

/**
 * Enter one sentence as a brief description for your class. You can enter more
 * text here (e.g. describe the purpose of the class here).
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date Mar 18, 2005
 * 
 * revision date author reason
 * 
 * </PRE>
 * 
 * <br/>
 * 
 * @author Vinod Kumar Burugupalli
 * @version CBS 1.0
 */
public class UDConnector {
	private static final String CLASS_NAME = "UDConnector"; /* NOI18N */

	/** 
	 * getProfile
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param connectorDTO
	 * @return UserProfileConnectorDTO
	 * @throws ConnectorException
	 */
	public UserProfileConnectorDTO getProfile(
			UserProfileConnectorDTO connectorDTO) throws ConnectorException {
		UDServiceProxy profileManager = new UDServiceProxy();

		try {
			//	profileManager =
			// UDServiceProxyConnectionPool.getInstance().checkOut();
			if (connectorDTO.isLogon()) {
				profileManager.authenticate(connectorDTO.getUserID(),
						connectorDTO.getPassword());
				connectorDTO.setAuthenticated(true);
			}

			connectorDTO = profileManager.getProfile(connectorDTO);
		} finally {
			if (null != profileManager) {
				//		profileManager.close();
			}
		}

		return connectorDTO;
	}

	/** 
	 * getProfiles
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param connectorDTO
	 * @return UserProfilesConnectorDTO
	 * @throws ConnectorException
	 */
	public UserProfilesConnectorDTO getProfiles(
			UserProfilesConnectorDTO connectorDTO) throws ConnectorException {
		UDServiceProxy profileManager = new UDServiceProxy();

		try {
			//		profileManager =
			// UDServiceProxyConnectionPool.getInstance().checkOut();
			connectorDTO = profileManager.getProfiles(connectorDTO);
		} finally {
			if (null != profileManager) {
				//		profileManager.close();
			}
		}

		return connectorDTO;
	}
}