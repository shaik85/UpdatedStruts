/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CopySWOActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.CustomerInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopySWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOCustomDTO;

/**
 * Hold complete information required for copy swo view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 18, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CopySWOViewBean extends OPPTViewBean {
	private String sourceSoldToParty = null;
	private String sourceDMNumber = null;
	private String sourceDMDescription = null;

	private String swoNumber = null;
	private String serialNumber = null;
	private String description = null;
	
	private String selectedTargetSoldToParty = null;
	private TreeMap targetSoldToParty = null;
	private TreeMap targetDMNumber = null;
	private TreeMap targetDMDescription = null;

	private Date planStartDate = null;
	private Date planEndDate = null;
	private List startYears = null;
	private List endYears = null;


	/**
	 * Returns contract end year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getEndYears() {
		return endYears;
	}

	/**
	 * Returns contract start year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getStartYears() {
		return startYears;
	}
	/**
	 * Sets contract end year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEndYears List 
	 */
	public void setEndYears(List newEndYears) {
		endYears = newEndYears;
	}

	/**
	 * Sets contract start year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStartYears List 
	 */
	public void setStartYears(List newStartYears) {
		startYears = newStartYears;
	}

	/**
	 * Returns source dm's description. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSourceDMDescription() {
		return sourceDMDescription;
	}

	/**
	 * Returns source dm number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSourceDMNumber() {
		return sourceDMNumber;
	}

	/**
	 * Returns source sold to party 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSourceSoldToParty() {
		return sourceSoldToParty;
	}

	/**
	 * Returns collection of target sold to party number's 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getTargetSoldToParty() {
		return targetSoldToParty;
	}

	/**
	 * Sets source dm's description 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSourceDMDescription String 
	 */
	public void setSourceDMDescription(String newSourceDMDescription) {
		sourceDMDescription = newSourceDMDescription;
	}

	/**
	 * Sets source dm number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSourceDMNumber String 
	 */
	public void setSourceDMNumber(String newSourceDMNumber) {
		sourceDMNumber = newSourceDMNumber;
	}

	/**
	 * Sets the source sold to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSourceSoldToParty String 
	 */
	public void setSourceSoldToParty(String newSourceSoldToParty) {
		sourceSoldToParty = newSourceSoldToParty;
	}

	/**
	 * Sets the collection as target sold to party collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTargetSoldToParty TreeMap 
	 */
	public void setTargetSoldToParty(TreeMap newTargetSoldToParty) {
		targetSoldToParty = newTargetSoldToParty;
	}
	
	/**
	 * Returns selected target sold to party  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedTargetSoldToParty() {
		return selectedTargetSoldToParty;
	}

	/**
	 * Sets the selected target sold to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedTargetSoldToParty String 
	 */
	public void setSelectedTargetSoldToParty(String newSelectedTargetSoldToParty) {
		selectedTargetSoldToParty = newSelectedTargetSoldToParty;
	}
	
	/**
	 * Returns description 
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
		return description;
	}


	/**
	 * Returns plan end date 
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
		return planEndDate;
	}



	/**
	 * Returns plan start date 
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
	 * @return 
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}



	/**
	 * Returns the serial number 
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
	public String getSerialNumber() {
		return serialNumber;
	}


	/**
	 * Returns the swo number 
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
	public String getSwoNumber() {
		return swoNumber;
	}



	/**
	 * Sets the description of the license 
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
		description = newDescription;
	}



	/**
	 * Sets the plan end date for the dm. 
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
		planEndDate = newPlanEndDate;
	}



	/**
	 * Sets the plan start date for the dm. 
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
		planStartDate = newPlanStartDate;
	}



	/**
	 * Sets the serial number 
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
	 * @param newSerialNumber String 
	 */
	public void setSerialNumber(String newSerialNumber) {
		serialNumber = newSerialNumber;
	}


	/**
	 * Sets the swo number 
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
	 * @param newSwoNumber String 
	 */
	public void setSwoNumber(String newSwoNumber) {
		swoNumber = newSwoNumber;
	}

	
	/**
     * Adds a new customer to already existin (if none exists creates a new) collection of customers.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param description
     * @param id 
     */
	public void addTargetSoldToPaty(String id, String description){
		if(null != id){
			if(null == targetSoldToParty){
				targetSoldToParty = new TreeMap();
			}
			targetSoldToParty.put(id, description);
		}
	}

	/**
     * addTargetDMNumber
     * 
     * @param id
     * @param description
     * @author thirumalai
     */
    public void addTargetDMNumber(String id, String description){
		if(null != id){
			if(null == targetDMNumber){
				targetDMNumber = new TreeMap();
			}
			targetDMNumber.put(id, description);
		}
	}

	/**
     * addTargetDMDescription
     * 
     * @param id
     * @param description
     * @author thirumalai
     */
    public void addTargetDMDescription(String id, String description){
		if(null != id){
			if(null == targetDMDescription){
				targetDMDescription = new TreeMap();
			}
			targetDMDescription.put(id, description);
		}
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(CopySWOCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			CustomerInfoDataBean sourceCustomer = new CustomerInfoDataBean(customDTO.getSourceCustomer());
			setSourceSoldToParty(sourceCustomer.getLegacyCustomerNumberWithAS());
			setSourceDMNumber(customDTO.getSourceDMNumber());
			setSourceDMDescription(customDTO.getSourceDMDescription());
			
			SWOCustomDTO sourceSWO = customDTO.getSourceSWO();
			if(null != sourceSWO){
				setSwoNumber(sourceSWO.getNumber());
				setSerialNumber(sourceSWO.getSerialNumber());
				setDescription(sourceSWO.getDescription());
				setPlanStartDate(sourceSWO.getPlanStartDate());
				setPlanEndDate(sourceSWO.getPlanEndDate());		
			}
			
			setSelectedTargetSoldToParty(customDTO.getSelectedTargetCustomer());
			setTargetDMNumber(null);
			setTargetDMDescription(null);
	
			Map customers = customDTO.getTargetCustomers();
			if(null != customers){
				Iterator iterator = customers.values().iterator();
				while(iterator.hasNext()){
					ProposalCustomerCustomDTO targetCustomer = (ProposalCustomerCustomDTO)iterator.next();
					String key = String.valueOf(targetCustomer.getCustomerId());
					addTargetSoldToPaty(key, targetCustomer.getLegacyCustomerNumberWithAS());

					if(null != getSelectedTargetSoldToParty() && getSelectedTargetSoldToParty().equalsIgnoreCase(key)){
						Map dms = targetCustomer.getDMs();
						if(null != dms){
							Iterator dmIterator = dms.values().iterator();
							while(dmIterator.hasNext()){
								DMCustomDTO dm = (DMCustomDTO)dmIterator.next();
								String dmKey = dm.getId();
								addTargetDMNumber(dmKey, dm.getNumber());
								addTargetDMDescription(dmKey, dm.getDescription());
								
							}
						}
					}
				}
			}

			setStartYears(customDTO.getStartYears());
			setEndYears(customDTO.getEndYears());
		}
	}
	
	/**
     * CopySWOViewBean
     * 
     * @author thirumalai
     */
    public CopySWOViewBean(){
	}
    
	/**
     * CopySWOViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public CopySWOViewBean(CopySWOCustomDTO customDTO){
		setData(customDTO);
	}
	
	/**
	 * Returns target dm description collection 
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
	 * @return TreeMap
	 */
	public TreeMap getTargetDMDescription() {
		return targetDMDescription;
	}

	/**
	 * Returns target dm number collection 
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
	 * @return TreeMap
	 */
	public TreeMap getTargetDMNumber() {
		return targetDMNumber;
	}

	/**
	 * Sets target dm description collection 
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
	 * @param newTargetDMDescription TreeMap
	 */
	public void setTargetDMDescription(TreeMap newTargetDMDescription) {
		targetDMDescription = newTargetDMDescription;
	}

	/**
	 * Sets target dm number collection 
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
	 * @param newTargetDMNumber TreeMap
	 */
	public void setTargetDMNumber(TreeMap newTargetDMNumber) {
		targetDMNumber = newTargetDMNumber;
	}

		
	/**
     * getCopySWOActionForm
     * 
     * @return
     * @author thirumalai
     */
    public CopySWOActionForm getCopySWOActionForm(){
		CopySWOActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof CopySWOActionForm){
			actionForm = (CopySWOActionForm)getActionForm();
		}
		else{
			actionForm = new CopySWOActionForm();
		}
		return actionForm;
	}
}