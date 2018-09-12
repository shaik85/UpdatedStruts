/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;
import java.util.Date;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO;

/**
 * Hold complete information about a customer, which includes all the dms associated with the customer. 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CustomerViewBean extends OPPTViewBean {
	private String iId = null;
	private String iSoldToParty = null;
	private String iDescription = null;
	private String iSapCustomerNumber = null;
	private Date iPlanStartDate = null;
	private Date iPlanEndDate = null;
	private TreeMap iDMs = null;
	
	/**
	 * Returns the description of the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String 
	 */
	public String getDescription() {
		return iDescription;
	}

	/**
	 * Return the DMViewBean's associated with the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getDMs() {
		return iDMs;
	}

	/**
	 * Returns the plan end date for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanEndDate() {
		return iPlanEndDate;
	}

	/**
	 * Returns plan start date of the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanStartDate() {
		return iPlanStartDate;
	}

	/**
	 * Returns the sold to party id of the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSoldToParty() {
		return iSoldToParty;
	}

	/**
	 * Sets the description of the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDescription String 
	 */
	public void setDescription(String newDescription) {
		iDescription = newDescription;
	}

	/**
	 * Sets the collection as DM's associated with the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMs TreeMap 
	 */
	public void setDMs(TreeMap newDMs) {
		iDMs = newDMs;
	}

	/**
	 * Sets the plan end date for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanEndDate Date 
	 */
	public void setPlanEndDate(Date newPlanEndDate) {
		iPlanEndDate = newPlanEndDate;
	}

	/**
	 * Sets the plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanStartDate Date 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		iPlanStartDate = newPlanStartDate;
	}

	/**
	 * Sets the sold to party 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToParty String 
	 */
	public void setSoldToParty(String newSoldToParty) {
		iSoldToParty = newSoldToParty;
	}

	/**
     *  Sets complete date in a single method call.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 17, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param soldToParty String
     * @param description String
     * @param planStartDate Date
     * @param planEndDate Date
     * @param dms TreeMap
     * @param id 
     */
	public void setData(String id, String soldToParty, String description, Date planStartDate, Date planEndDate, TreeMap dms){
		setId(id);
		setSoldToParty(soldToParty);
		setDescription(description);
		setPlanStartDate(planStartDate);
		setPlanEndDate(planEndDate);
		setDMs(dms);
	}
	/**
	 * Returns customer id. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Sets the id of the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
     * Adds new dm to the collection of dms available for the customer
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 11, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param dm DMViewBean
     * @param key 
     */
	public void addDM(String key, DMViewBean dm){
		if(null != dm){
			if(null == iDMs){
				iDMs = new TreeMap();
			}
			// iDMs.put(dm.getId(), dm);
			iDMs.put(key, dm);
		}
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(ProposalCustomerCustomDTO customDTO){
		if(null != customDTO){
			setId(customDTO.getCustomerId()+"");  //$NON-NLS-1$
			//DADO02&DADO09 BlueHarmony Sateesh 
			//setSoldToParty(customDTO.getLegacyCustomerNumber()+" "+customDTO.getAddressSequenceNumber());  //$NON-NLS-1$
			  //$NON-NLS-1$
			setSoldToParty(customDTO.getSoldToPartyNo());//DADO02
			setDescription(customDTO.getCustomerName());
			setSapCustomerNumber(customDTO.getSAPCustomerNumber());
			setPlanStartDate(customDTO.getPlanStartDate());
			setPlanEndDate(customDTO.getPlanEndDate());
			
			TreeMap customerDMs = customDTO.getDMs();
			if(null != customerDMs){
				Iterator iterator = customerDMs.keySet().iterator();
				while(iterator.hasNext()){
					String dmId = iterator.next().toString();
					addDM(dmId, new DMViewBean((DMCustomDTO)customerDMs.get(dmId)));
				}
			}
		}
	}
	
	/**
     * CustomerViewBean
     * 
     * @author thirumalai
     */
    public CustomerViewBean(){
	}
	/**
     * CustomerViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public CustomerViewBean(ProposalCustomerCustomDTO customDTO){
		setData(customDTO);
	}
	
	/**
	 * Returns sap customer number  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSapCustomerNumber() {
		return iSapCustomerNumber;
	}

	/**
	 * Sets sap customer number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSapCustomerNumber String 
	 */
	public void setSapCustomerNumber(String newSapCustomerNumber) {
		iSapCustomerNumber = newSapCustomerNumber;
	}
}
