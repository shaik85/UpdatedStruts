/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.IneligibleEECustomDTO;

/**
 * Holds information about an ee in the ineligible licenses view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class IneligibleEEViewBean extends OPPTViewBean{
	private String iEEDetails = null;
	private String iEEMaterialNumber = null;
	private String iSalesOrderNumber = null;
	private String iItemNumber = null;
	private String iId = null;

	/**
	 * Returns ee details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getEEDetails() {
		return iEEDetails;
	}

	/**
	 * Returns ee material number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getEEMaterialNumber() {
		return iEEMaterialNumber;
	}

	/**
	 * Returns unique identifier of the ee 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getId() {
		return iId;
	}

	/**
	 * Returns the item number of the ee. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getItemNumber() {
		return iItemNumber;
	}

	/**
	 * Returns the sales order number of the ee 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSalesOrderNumber() {
		return iSalesOrderNumber;
	}

	/**
	 * Sets the ee details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEEDetails String 
	 */
	public void setEEDetails(String newEEDetails) {
		iEEDetails = newEEDetails;
	}

	/**
	 * Sets ee material number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEEMaterialNumber String 
	 */
	public void setEEMaterialNumber(String newEEMaterialNumber) {
		iEEMaterialNumber = newEEMaterialNumber;
	}

	/**
	 * Sets the ee identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId String 
	 */
	public void setId(String newId) {
		iId = newId;
	}

	/**
	 * Sets the item number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newItemNumber String 
	 */
	public void setItemNumber(String newItemNumber) {
		iItemNumber = newItemNumber;
	}

	/**
	 * Sets the sales order number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesOrderNumber String 
	 */
	public void setSalesOrderNumber(String newSalesOrderNumber) {
		iSalesOrderNumber = newSalesOrderNumber;
	}

	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id
	 * @param eeDetails
	 * @param eeMaterialNumber
	 * @param salesOrderNumber
	 * @param itemNumber
	 */
	public void setData(String id, String eeDetails, String eeMaterialNumber, 
						String salesOrderNumber, String itemNumber){
		setId(id);
		setEEDetails(eeDetails);
		setEEMaterialNumber(eeMaterialNumber);
		setSalesOrderNumber(salesOrderNumber);
		setItemNumber(itemNumber);
	}
	
	/**
     * setData
     * 
     * @param ineligibleEE
     * @author thirumalai
     */
    public void setData(IneligibleEECustomDTO ineligibleEE){
		if(null != ineligibleEE){
			setData(ineligibleEE.getId(), ineligibleEE.getEEDetails(), ineligibleEE.getEEMaterialNumber(), ineligibleEE.getSalesOrderNumber(), ineligibleEE.getItemNumber());
		}
	}
	
	/**
     * IneligibleEEViewBean
     * 
     * @author thirumalai
     */
    public IneligibleEEViewBean(){
	}
	/**
     * IneligibleEEViewBean
     * 
     * @param ineligibleEE
     * @author thirumalai
     */
    public IneligibleEEViewBean(IneligibleEECustomDTO ineligibleEE){
		setData(ineligibleEE);
	}
}
