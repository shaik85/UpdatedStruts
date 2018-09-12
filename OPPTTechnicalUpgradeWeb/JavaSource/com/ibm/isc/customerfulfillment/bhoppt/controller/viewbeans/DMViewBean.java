/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOCustomDTO;

/**
 * Hold complete information about the dm including the swos associated with it.  
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
public class DMViewBean extends OPPTViewBean 
{
	private String iDMDescription = null;
	private String iDMNumber = null;
	private String iId = null;
	private Date iPlanEndDate = null;
	private Date iPlanStartDate = null;
	private TreeMap iSwos = null;

	/**
	 * Licenses must be displayed in seperate color
	 */
	private boolean iCopiedDM = false;
	/**
	 * Licenses must be displayed in seperate color
	 */
	private boolean iOnlyQuotes = false;
	
	/**
     * DMViewBean
     * 
     * @author thirumalai
     */
    public DMViewBean(){
	}
	/**
     * DMViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public DMViewBean(DMCustomDTO customDTO){
		setData(customDTO);
	}

	/**
     * Adds a new SWOViewBean to the collection of already existing swos in the dm.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 17, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param key
     * @param swo 
     */
	public void addSWO(String key, SWOViewBean swo) {
		if(swo != null) {
			if(iSwos == null){
				iSwos = new TreeMap();
			}
			// iSwos.put(swo.getId(), swo);
			iSwos.put(key, swo);
		}
	}

	/**
	 * Returns description about the DM. 
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
	public String getDMDescription() {
		return iDMDescription;
	}

	/**
	 * Returns dm number 
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
	public String getDMNumber() {
		return iDMNumber;
	}

	/**
	 * Returns dm identifier. 
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
		return iPlanEndDate;
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
		return iPlanStartDate;
	}

	/**
	 * Returns the collection of CompareTPSWOViewBean's associated with the DM. 
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
	public TreeMap getSwos() {
		return iSwos;
	}
	
	/**
	 * Returns true of the dm is copied 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isCopiedDM() {
		return iCopiedDM;
	}

	/**
	 * Returns true if the DM has only quotes  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isOnlyQuotes() {
		return iOnlyQuotes;
	}

	/**
	 * Sets the copiedDM flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCopiedDM boolean
	 */
	public void setCopiedDM(boolean newCopiedDM) {
		iCopiedDM = newCopiedDM;
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(DMCustomDTO customDTO){
		if(null != customDTO){
			setId(customDTO.getId());
			setDMDescription(customDTO.getDescription());
			setDMNumber(customDTO.getNumber());
			setPlanEndDate(customDTO.getPlanEndDate());
			setPlanStartDate(customDTO.getPlanStartDate());
			setOnlyQuotes(customDTO.isOnlyQuotes());
			setCopiedDM(customDTO.isCopiedDM());
			
			TreeMap dmSwos = customDTO.getSwos();
			if(null != dmSwos){
				Iterator iterator = dmSwos.keySet().iterator();
				while(iterator.hasNext()){
					String swoId = iterator.next().toString();
					addSWO(swoId, new SWOViewBean((SWOCustomDTO)dmSwos.get(swoId)));
				}
			}
		}
	}
	
	/**
	 * Sets complete data about the dm in a single call.  
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
	 * @param id String
	 * @param dmDescription String
	 * @param dmNumber String
	 * @param planStartDate Date
	 * @param planEndDate Date
	 * @param swos Vector
	 */
	public void setData(String id, String dmDescription, String dmNumber, Date planStartDate, Date planEndDate, TreeMap swos){
		setId(id);
		setDMDescription(dmDescription);
		setDMNumber(dmNumber);
		setPlanEndDate(planEndDate);
		setPlanStartDate(planStartDate);
		setSwos(swos);
	}

	/**
	 * Sets the description about the dm. 
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
	 * @param newDMDescription String 
	 */
	public void setDMDescription(String newDMDescription) {
		iDMDescription = newDMDescription;
	}

	/**
	 * sets the dm number
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
	 * @param newDMNumber String 
	 */
	public void setDMNumber(String newDMNumber) {
		iDMNumber = newDMNumber;
	}

	/**
	 * Sets all flag value in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param onlyQuotes boolean
	 * @param copiedDM boolean
	 */
	public void setFlags(boolean onlyQuotes, boolean copiedDM){
		setOnlyQuotes(onlyQuotes);
		setCopiedDM(copiedDM);
	}

	/**
	 * Sets the dm id. 
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
	 * Sets only quotes flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newOnlyQuotes boolean 
	 */
	public void setOnlyQuotes(boolean newOnlyQuotes) {
		iOnlyQuotes = newOnlyQuotes;
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
		iPlanEndDate = newPlanEndDate;
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
		iPlanStartDate = newPlanStartDate;
	}

	/**
	 * Sets the collection as collection of SWOViewBean's associated with the DM. 
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
	 * @param newSwos TreeMap 
	 */
	public void setSwos(TreeMap newSwos) {
		iSwos = newSwos;
	}
}
