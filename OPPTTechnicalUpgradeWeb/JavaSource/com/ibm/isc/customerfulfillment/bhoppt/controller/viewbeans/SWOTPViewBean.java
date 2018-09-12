/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOTPCustomDTO;

/**
 * Holds complete data about swo tp view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class SWOTPViewBean extends OPPTViewBean{
	private String iNumber = null;
	private String iSerialNumber = null;
	private String iContractNumber = null;
	private String iContractType = null;
	
	/**
	 * Returns contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getContractNumber() {
		return iContractNumber;
	}

	/**
	 * Returns contract type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getContractType() {
		return iContractType;
	}

	/**
	 * Returns tp number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getNumber() {
		return iNumber;
	}

	/**
	 * Returns serial number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSerialNumber() {
		return iSerialNumber;
	}

	/**
	 * Sets contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractNumber String 
	 */
	public void setContractNumber(String newContractNumber) {
		iContractNumber = newContractNumber;
	}

	/**
	 * Sets contract type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractType String 
	 */
	public void setContractType(String newContractType) {
		iContractType = newContractType;
	}

	/**
	 * Sets number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNumber String 
	 */
	public void setNumber(String newNumber) {
		iNumber = newNumber;
	}

	/**
	 * Sets serial number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSerialNumber String 
	 */
	public void setSerialNumber(String newSerialNumber) {
		iSerialNumber = newSerialNumber;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param number String
	 * @param serialNumber String
	 * @param contractNumber String
	 * @param contractType String
	 */
	public void setData(String number, String serialNumber, String contractNumber, String contractType){
		setNumber(number);
		setSerialNumber(serialNumber);
		setContractNumber(contractNumber);
		setContractType(contractType);
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(SWOTPCustomDTO customDTO){
		if(null != customDTO){
			setNumber(customDTO.getNumber());
			setSerialNumber(customDTO.getSerialNumber());
			setContractNumber(customDTO.getExternalContractNumber());
			setContractType(customDTO.getContractType());
		}
	}
	
	/**
     * SWOTPViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public SWOTPViewBean(SWOTPCustomDTO customDTO){
		setData(customDTO);
	}

	/**
     * SWOTPViewBean
     * 
     * @author thirumalai
     */
    public SWOTPViewBean(){
	}
}
