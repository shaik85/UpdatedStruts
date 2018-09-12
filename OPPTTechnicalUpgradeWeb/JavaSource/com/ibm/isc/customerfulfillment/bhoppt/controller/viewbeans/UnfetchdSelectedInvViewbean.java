/*
 * Created on Oct 28, 2010
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
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class UnfetchdSelectedInvViewbean extends OPPTViewBean{
	//private List errCustListData = null;
	private InventoryCustomDTO  customDTOdata =null;
	
	/**
     * UnfetchdSelectedInvViewbean
     * 
     * @author Ramesh Gandi
     */
    public UnfetchdSelectedInvViewbean(){
		
	}
	
	/**
     * UnfetchdSelectedInvViewbean
     * 
     * @param customDTO
     * @author Ramesh Gandi
     */
    public UnfetchdSelectedInvViewbean(InventoryCustomDTO customDTO){
		if(null != customDTO){
			//setErrCustListData(customDTO.getErrListData()); 
			setCustomDTOdata(customDTO);
		}
	}
	

	/**
	 * @return Returns the errCustListData.
	 */
/*	public List getErrCustListData() {
		return errCustListData;
	}*/
	/**
	 * @param errCustListData The errCustListData to set.
	 */
/*	public void setErrCustListData(List errCustListData) {
		this.errCustListData = errCustListData;
	}*/
	/**
	 * @return Returns the customDTOdata.
	 */
	public InventoryCustomDTO getCustomDTOdata() {
		return customDTOdata;
	}
	/**
	 * @param customDTOdata The customDTOdata to set.
	 */
	public void setCustomDTOdata(InventoryCustomDTO customDTOdata) {
		this.customDTOdata = customDTOdata;
	}
}
