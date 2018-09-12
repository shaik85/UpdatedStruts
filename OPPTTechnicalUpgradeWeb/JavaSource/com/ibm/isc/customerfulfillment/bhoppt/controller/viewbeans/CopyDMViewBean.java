/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;
import java.util.Date;
import java.util.Vector;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CopyDMActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.CustomerInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;

/**
 * Hold complete information required for copy dm view.  
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
public class CopyDMViewBean extends OPPTViewBean {
	private String soldToPartyNumber = null;
	private String dmDescription = null;
	private String dmNumber = null;
	private Date planEndDate = null;
	private Date planStartDate = null;

	private TreeMap targetSoldToParty = null;

	private List iStartYears = null;
	private List iEndYears = null;


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
		return iEndYears;
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
		return iStartYears;
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
		iEndYears = newEndYears;
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
		iStartYears = newStartYears;
	}

	/**
	 * Returns source dm description 
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
	 * @return String
	 */
	public String getDMDescription() {
		return dmDescription;
	}

	/**
	 * Sets source dm number 
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
	 * @return String
	 */
	public String getDMNumber() {
		return dmNumber;
	}

	/**
	 * Sets source dms default plan end date 
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
	 * @return Date 
	 */
	public Date getPlanEndDate() {
		return planEndDate;
	}

	/** 
	 * Sets source dms default plan start date 
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
	 * @return Date
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}

	/**
	 * Sets source dm parent sold to party number 
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
	 * @return String
	 */
	public String getSoldToPartyNumber() {
		return soldToPartyNumber;
	}

	/**
	 * Sets target sold to party collection 
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
	public TreeMap getTargetSoldToParty() {
		return targetSoldToParty;
	}

	/**
	 * Sets source dms description 
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
	 * @param newDMDescription String
	 */
	public void setDMDescription(String newDMDescription) {
		dmDescription = newDMDescription;
	}

	/**
	 * Sets source dms number 
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
	 * @param newDMNumber String 
	 */
	public void setDMNumber(String newDMNumber) {
		dmNumber = newDMNumber;
	}

	/**
	 * Sets source dms default plan end date 
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
	 * @param newPlanEndDate Date 
	 */
	public void setPlanEndDate(Date newPlanEndDate) {
		planEndDate = newPlanEndDate;
	}

	/**
	 * Sets source dms default plan start date 
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
	 * @param newPlanStartDate Date 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		planStartDate = newPlanStartDate;
	}

	/**
	 * Sets source dms parent sold to party number 
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
	 * @param newSoldToPartyNumber String 
	 */
	public void setSoldToPartyNumber(String newSoldToPartyNumber) {
		soldToPartyNumber = newSoldToPartyNumber;
	}

	/**
	 * Sets target sold to partys collection 
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
	 * @param newTargetSoldToParty TreeMap
	 */
	public void setTargetSoldToParty(TreeMap newTargetSoldToParty) {
		targetSoldToParty = newTargetSoldToParty;
	}
	
	/**
     * addTargetSoldToParty
     * 
     * @param key
     * @param targetSoldToPartyNumber
     * @author thirumalai
     */
    public void addTargetSoldToParty(String key, String targetSoldToPartyNumber){
		if(null != key || null != targetSoldToPartyNumber){
			if(null == targetSoldToParty){
				targetSoldToParty = new TreeMap();
			}
			targetSoldToParty.put(key, targetSoldToPartyNumber);
		}
	}

	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(CopyDMCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			CustomerInfoDataBean sourceSoldToParty = new CustomerInfoDataBean(customDTO.getSourceCustomer());
			setSoldToPartyNumber(sourceSoldToParty.getLegacyCustomerNumberWithAS());
			
			DMCustomDTO sourceDM = customDTO.getSourceDM();
			if(null != sourceDM){
				setDMDescription(sourceDM.getDescription());
				setDMNumber(sourceDM.getNumber());
				setPlanStartDate(sourceDM.getPlanStartDate());
				setPlanEndDate(sourceDM.getPlanEndDate());
			}

			Map targetSoldToPartys = customDTO.getTargetCustomers();
			if(null != targetSoldToPartys){
				Iterator iterator = targetSoldToPartys.keySet().iterator();
				while(iterator.hasNext()){
					String key = (String)iterator.next();
					CustomerInfoDataBean targetSoldToParty = new CustomerInfoDataBean((ESWCustomerCustomDTO)targetSoldToPartys.get(key));
					addTargetSoldToParty(key, targetSoldToParty.getLegacyCustomerNumberWithAS());
				}
			}

			setStartYears(customDTO.getStartYears());
			setEndYears(customDTO.getEndYears());
		}
	}
	
	/**
     * CopyDMViewBean
     * 
     * @author thirumalai
     */
    public CopyDMViewBean(){
	}

	/**
     * CopyDMViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public CopyDMViewBean(CopyDMCustomDTO customDTO){
		setData(customDTO);
	}

	/**
     * getCopyDMActionForm
     * 
     * @return
     * @author thirumalai
     */
    public CopyDMActionForm getCopyDMActionForm(){
		CopyDMActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof CopyDMActionForm){
			actionForm = (CopyDMActionForm)getActionForm();
		}
		else{
			actionForm = new CopyDMActionForm();
		}
		return actionForm;
	}
}
