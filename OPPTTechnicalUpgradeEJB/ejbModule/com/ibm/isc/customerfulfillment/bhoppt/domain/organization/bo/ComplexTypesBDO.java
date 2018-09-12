/*
 * Created on May 11, 2010
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
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/* This class is creted by Srinivas for OPPTBH-DAD003*/

public class ComplexTypesBDO {
	
	private  String BLBIndicatorType ;
	private  String BLBIndicatorDesc;

	
	/**
	 * @return Returns the bLBIndicatorDesc.
	 */
	public String getBLBIndicatorDesc() {
		return BLBIndicatorDesc;
	}
	/**
	 * @param indicatorDesc The bLBIndicatorDesc to set.  
	 */
	public void setBLBIndicatorDesc(String indicatorDesc) {
		BLBIndicatorDesc = indicatorDesc;
	}
	/**
	 * @return Returns the bLBIndicatorType.
	 */
	public String getBLBIndicatorType() {
		return BLBIndicatorType;
	}
	/**
	 * @param indicatorType The bLBIndicatorType to set.
	 */
	public void setBLBIndicatorType(String indicatorType) {
		BLBIndicatorType = indicatorType;
	}
}
