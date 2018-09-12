/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;
import java.util.List;
import java.util.Vector;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMEECustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMSWOCustomDTO;

/**
 * Holds the information about the swo and its corresponding EE's.   
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
public class ConfigureDMSWOViewBean extends OPPTViewBean {
	private String swoId = null;
	private String swoNumber = null;
	private String swoSerialNumber = null;
	private String swoDescription = null;
	
	private List eeViewBeans = null;
	
	/**
	 * Returns the collection of ee view beans associated with the swo in ConfigureDM. 
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
	 * @return List
	 */
	public List getEEViewBeans() {
		return eeViewBeans;
	}

	/**
	 * Returns the swo description. 
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
	public String getSwoDescription() {
		return swoDescription;
	}

	/**
	 * Returns swo number 
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
	 * Sets the collection as collection of ConfigureDMEEViewBean's associated with the swo. 
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
	 */
	public void setEeViewBeans(List newEEViewBeans) {
		eeViewBeans = newEEViewBeans;
	}

	/**
	 * Sets the swo description. 
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
	 * @param newSwoDescription String 
	 */
	public void setSwoDescription(String newSwoDescription) {
		swoDescription = newSwoDescription;
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
	 * Adds a new ConfigureDMEEViewBean to the collection of already existing ConfigureDMEEViewBean's.  
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
	 * @param eeViewBean ConfigureDMEEViewBean
	 */
	public void addEEViewBean(ConfigureDMEEViewBean eeViewBean) {
		if(eeViewBean != null) {
			if(eeViewBeans == null) {
				eeViewBeans = new ArrayList();
			}
			eeViewBeans.add(eeViewBean);
		}
	}
	
	/**
	 * Returns swo identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoId() {
		return swoId;
	}

	/**
	 * Sets swo identifier value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoId String 
	 */
	public void setSwoId(String newSwoId) {
		swoId = newSwoId;
	}

	/**
	 * Returns swo serial number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoSerialNumber() {
		return swoSerialNumber;
	}

	/**
	 * Sets swo serial number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoSerialNumber String 
	 */
	public void setSwoSerialNumber(String newSwoSerialNumber) {
		swoSerialNumber = newSwoSerialNumber;
	}

	public void setData(ConfigureDMSWOCustomDTO customDTO){
		if(null != customDTO){
			setSwoId(customDTO.getId());
			setSwoNumber(customDTO.getSwoNumber());
			setSwoSerialNumber(customDTO.getSwoSerialNumber());
			setSwoDescription(customDTO.getSwoDescription());

			List eeCollection = customDTO.getEes();
			if(null != eeCollection){
				for(int i=0, size=eeCollection.size(); i<size; i++){
					addEEViewBean(new ConfigureDMEEViewBean((ConfigureDMEECustomDTO)eeCollection.get(i)));			
				}
			}
		}
	}
	
	public ConfigureDMSWOViewBean(){
	}
	public ConfigureDMSWOViewBean(ConfigureDMSWOCustomDTO customDTO){
		setData(customDTO);
	}
}
