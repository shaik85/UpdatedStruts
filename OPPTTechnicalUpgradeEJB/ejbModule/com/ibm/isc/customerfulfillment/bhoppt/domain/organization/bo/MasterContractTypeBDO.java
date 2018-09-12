/*
 * Created on Apr 28, 2010
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
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo;

/**
 * @author Bhanu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MasterContractTypeBDO {
	private String contractType;
	private String contractDesc;
	
	
	/**
	 * @return Returns the masterContractDesc.
	 */
	public String getContractDesc() {
		return contractDesc;
	}
	/**
	 * @param masterContractDesc The masterContractDesc to set.
	 */
	public void setContractDesc(String contractDesc) {
		this.contractDesc = contractDesc;
	}
	/**
	 * @return Returns the masterContractType.
	 */
	public String getContractType() {
		return contractType;
	}
	/**
	 * @param masterContractType The masterContractType to set.
	 */
	public void setMasterContractType(String contractType) {
		this.contractType = contractType;
	}
}
