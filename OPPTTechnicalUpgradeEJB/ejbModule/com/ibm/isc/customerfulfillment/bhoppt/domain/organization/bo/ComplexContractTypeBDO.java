/*
 * Created on Apr 27, 2010
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
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ComplexContractTypeBDO {
	private String ocpsID;
	private String ocpsIDDesc;	
	
	
	/**
	 * @return Returns the iComplexContractDesc.
	 */
	public String getOcpsIDDesc() {
		return ocpsIDDesc;
	}
	/**
	 * @param complexContractDesc The iComplexContractDesc to set.
	 */
	public void setOcpsIDDesc(String newOcpsIDDesc) {
		ocpsIDDesc = newOcpsIDDesc;
	}
	/**
	 * @return Returns the iComplexContractType.
	 */
	public String getocpsIDType() {
		return ocpsID;
	}
	/**
	 * @param complexContractType The iComplexContractType to set.
	 */
	public void setComplexContractType(String newOcpsID) {
		ocpsID = newOcpsID;
	}
}
