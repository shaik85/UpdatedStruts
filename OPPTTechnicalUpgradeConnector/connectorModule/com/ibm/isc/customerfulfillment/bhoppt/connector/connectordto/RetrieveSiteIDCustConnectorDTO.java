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
public class RetrieveSiteIDCustConnectorDTO implements ConnectorDTOInterface{
	private String customerNo;
	private String customerName;
	private String SapCustomerNo;
	private String siteID;
	

	/**
	 * @return Returns the customerName.
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName The customerName to set.
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return Returns the customerNo.
	 */
	public String getCustomerNo() {
		return customerNo;
	}
	/**
	 * @param customerNo The customerNo to set.
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	/**
	 * @return Returns the sapCustomerNo.
	 */
	public String getSapCustomerNo() {
		return SapCustomerNo;
	}
	/**
	 * @param sapCustomerNo The sapCustomerNo to set.
	 */
	public void setSapCustomerNo(String sapCustomerNo) {
		SapCustomerNo = sapCustomerNo;
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
}
