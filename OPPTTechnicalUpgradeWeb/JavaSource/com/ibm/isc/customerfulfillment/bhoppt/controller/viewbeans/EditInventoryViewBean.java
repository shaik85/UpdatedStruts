/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.CustomerInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;

/**
 * Hold data for edit swo view.  
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
public class EditInventoryViewBean extends OPPTViewBean 
{
	private TreeMap iCustomers = null;
	private TreeMap iCustomerDMs = null;
	private TreeMap iDMSWOs = null;
	
	private boolean iSandS = false;

	private List iStartYears = null;
	private List iEndYears = null;

	/**
	 * Returns collection of selected customers for edit inventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomers() {
		return iCustomers;
	}

	/**
	 * Returns collection of selected dms for editinventory
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomerDMs() {
		return iCustomerDMs;
	}

	/**
	 * Return collection of end years for edit inventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
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
	 * Returns true if the proposal is an S and S proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isSandS() {
		return iSandS;
	}

	/**
	 * Returns collection of start years for edit inventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
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
	 * Returns collection of swos for edit inventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getDMSWOs() {
		return iDMSWOs;
	}

	/**
	 * Sets collection of customer for edit inventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomers TreeMap
	 */
	public void setCustomers(TreeMap newCustomers) {
		iCustomers = newCustomers;
	}

	/**
	 * Sets collection of dms for edit inventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerDMs TreeMap
	 */
	public void setCustomerDMs(TreeMap newCustomerDMs) {
		iCustomerDMs = newCustomerDMs;
	}

	/**
	 * Sets end years collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
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
	 * Sets proposal type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param isSandS boolean
	 */
	public void setSandS(boolean isSandS) {
		iSandS = isSandS;
	}

	/**
	 * Sets start years collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
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
	 * Sets collection of swos for edit inventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMSWOs TreeMap
	 */
	public void setDMSWOs(TreeMap newDMSWOs) {
		iDMSWOs = newDMSWOs;
	}
	
	/**
     * addCustomer
     * 
     * @param key
     * @param customer
     * @author thirumalai
     */
    public void addCustomer(String key, EditCustomerViewBean customer){
		if(null != customer){
			if(null == iCustomers){
				iCustomers = new TreeMap();
			}
			iCustomers.put(key, customer);
		}
	}

	/**
     * addDM
     * 
     * @param key
     * @param customerCustomDTO
     * @param dm
     * @author thirumalai
     */
    public void addDM(String key, ESWCustomerCustomDTO customerCustomDTO, EditDMViewBean dm){
		if(null != dm){
			if(null == iCustomerDMs){
				iCustomerDMs = new TreeMap();
			}

			StringTokenizer st = new StringTokenizer(key, Constants.STRING_SEPERATOR);
			if(2 == st.countTokens()){
				String customerKey = st.nextToken().trim();
				try{
					EditCustomerDMViewBean customerDMViewBean = (EditCustomerDMViewBean)iCustomerDMs.get(customerKey);
					if(null == customerDMViewBean){
						customerDMViewBean = new EditCustomerDMViewBean();
						if(null != customerCustomDTO){
							CustomerInfoDataBean customerInfo = new CustomerInfoDataBean(customerCustomDTO);
							customerDMViewBean.setSoldToPartyNumber(customerInfo.getLegacyCustomerNumberWithAS());
							customerDMViewBean.setSoldToPartyName(customerInfo.getCustomerName());
						}
					}
					customerDMViewBean.addDM(key, dm);
					
					iCustomerDMs.put(customerKey, customerDMViewBean);
				}
				catch(Exception e){
				}
			}
		}
	}

	/**
     * addSWO
     * 
     * @param key
     * @param customerCustomDTO
     * @param dmCustomDTO
     * @param swo
     * @author thirumalai
     */
    public void addSWO(String key, ESWCustomerCustomDTO customerCustomDTO, DMCustomDTO dmCustomDTO, EditSWOViewBean swo){
		if(null != swo){
			if(null == iDMSWOs){
				iDMSWOs = new TreeMap();
			}

			StringTokenizer st = new StringTokenizer(key, Constants.STRING_SEPERATOR);
			if(3 == st.countTokens()){
				String dmKey = st.nextToken().trim()+Constants.STRING_SEPERATOR+st.nextToken();
				try{
					EditDMSWOViewBean dmSWOViewBean = (EditDMSWOViewBean)iDMSWOs.get(dmKey);
					if(null == dmSWOViewBean){
						dmSWOViewBean = new EditDMSWOViewBean();
						if(null != customerCustomDTO){
							CustomerInfoDataBean customerInfo = new CustomerInfoDataBean(customerCustomDTO);
							dmSWOViewBean.setSoldToPartyNumber(customerInfo.getLegacyCustomerNumberWithAS());
							dmSWOViewBean.setSoldToPartyName(customerInfo.getCustomerName());
						}
						
						if(null != dmCustomDTO){
							dmSWOViewBean.setDMNumber(dmCustomDTO.getNumber());
							dmSWOViewBean.setDMDescription(dmCustomDTO.getDescription());			
						}
					}
					dmSWOViewBean.addSWO(key, swo);
					
					iDMSWOs.put(dmKey, dmSWOViewBean);
				}
				catch(Exception e){
				}
			}
		}
	}
	
	private void setData(EditInventoryCustomDTO customDTO, boolean isSAndS){
		if(null != customDTO){
			setSandS(isSAndS);
			setStartYears(customDTO.getStartYears());
			setEndYears(customDTO.getEndYears());

			TreeMap selectedList = customDTO.getSelectedCustomers();
			if(null != selectedList){
				Iterator iterator = selectedList.keySet().iterator();
				while(iterator.hasNext()){
					String key = iterator.next().toString();
					addCustomer(key, new EditCustomerViewBean((EditCustomerCustomDTO)selectedList.get(key)));
				}
			}

			selectedList = customDTO.getSelectedDMs();
			if(null != selectedList){
				Iterator iterator = selectedList.keySet().iterator();
				while(iterator.hasNext()){
					String key = iterator.next().toString();
					EditDMCustomDTO dmCustomDTO = (EditDMCustomDTO)selectedList.get(key);
					addDM(key, dmCustomDTO.getCustomer(), new EditDMViewBean(dmCustomDTO));
				}
			}
			
			selectedList = customDTO.getSelectedSWOs();
			if(null != selectedList){
				Iterator iterator = selectedList.keySet().iterator();
				while(iterator.hasNext()){
					String key = iterator.next().toString();
					EditSWOCustomDTO swoCustomDTO = (EditSWOCustomDTO)selectedList.get(key);
					addSWO(key, swoCustomDTO.getCustomerDTO(), swoCustomDTO.getDmDTO(), new EditSWOViewBean(swoCustomDTO));
				}
			}
		}
	}
	
	/**
     * EditInventoryViewBean
     * 
     * @author thirumalai
     */
    public EditInventoryViewBean(){
	}
	/**
     * EditInventoryViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public EditInventoryViewBean(EditInventoryCustomDTO customDTO){
		setData(customDTO, false);
	}
	/**
     * EditInventoryViewBean
     * 
     * @param customDTO
     * @param isSAndS
     * @author thirumalai
     */
    public EditInventoryViewBean(EditInventoryCustomDTO customDTO, boolean isSAndS){
		setData(customDTO, isSAndS);
	}
}