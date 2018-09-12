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

import java.util.List;

/**
 * @author Bhanu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ComplexContractIdentifiersBDO {
	private List iOcpsIDList;
	private List iContractTypeList;
	private List iBLBIndicatorList;
	/**
	 * @return Returns the iBLBIndicatorList.
	 */
	public List getIBLBIndicatorList() {
		return iBLBIndicatorList;
	}
	/**
	 * @param indicatorList The iBLBIndicatorList to set.
	 */
	public void setIBLBIndicatorList(List indicatorList) {
		iBLBIndicatorList = indicatorList;
	}
	/**
	 * @return Returns the iMasterContractTypeList.
	 */
	public List getIContractTypeList() {
		return iContractTypeList;
	}
	/**
	 * @param masterContractTypeList The iMasterContractTypeList to set.
	 */
	public void setIContractTypeList(List contractTypeList) {
		iContractTypeList = contractTypeList;
	}
	/**
	 * @return Returns the iComplexContractTypeList.
	 */
	public List getIOcpsIDList() {
		return iOcpsIDList;
	}
	/**
	 * @param complexContractTypeList The iComplexContractTypeList to set.
	 */
	public void setIOcpsIDList(List ocpsIDList) {
		iOcpsIDList = ocpsIDList;
	}
}
