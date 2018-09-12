/*
 * Created on Apr 19, 2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/*
* IBM Confidential
*
* ©  Copyright IBM Corp. 2004, 2005  All Rights Reserved.

* The source code for this program is not published or otherwise divested of
* its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
*/
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RetrieveSiteIDListInputConnectorDTO implements ConnectorDTOInterface{
	private String zipCode;
	private String city;
	private String siteID = null;
	private String siteName = null;
	private OrgConnectorDTO orgConnectorDTO;
	private GenericConnectorDTO genericConnectorDTO;

	/**
	 * @return Returns the city.
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return Returns the genericConnectorDTO.
	 */
	public GenericConnectorDTO getGenericConnectorDTO() {
		return genericConnectorDTO;
	}
	/**
	 * @param genericConnectorDTO The genericConnectorDTO to set.
	 */
	public void setGenericConnectorDTO(GenericConnectorDTO genericConnectorDTO) {
		this.genericConnectorDTO = genericConnectorDTO;
	}
	/**
	 * @return Returns the orgConnectorDTO.
	 */
	public OrgConnectorDTO getOrgConnectorDTO() {
		return orgConnectorDTO;
	}
	/**
	 * @param orgConnectorDTO The orgConnectorDTO to set.
	 */
	public void setOrgConnectorDTO(OrgConnectorDTO orgConnectorDTO) {
		this.orgConnectorDTO = orgConnectorDTO;
	}
	/**
	 * @return Returns the siteID.
	 */
	public String getSiteID() {
		return siteID;
	}
	/**
	 * @param siteID The siteID to set.
	 */
	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}
	/**
	 * @return Returns the siteName.
	 */
	public String getSiteName() {
		return siteName;
	}
	/**
	 * @param siteName The siteName to set.
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/**
	 * @return Returns the zipCode.
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode The zipCode to set.
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
