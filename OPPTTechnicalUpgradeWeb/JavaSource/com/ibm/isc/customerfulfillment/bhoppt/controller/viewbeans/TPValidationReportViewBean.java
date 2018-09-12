/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOTPCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ValidateTPProposalCustomDTO;

/**
 * Holds complete data about tp validation report  
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
public class TPValidationReportViewBean extends OPPTViewBean {
	private List iSwoTPs = null;
	
	/**
	 * Returns the collection of SWOTP's  
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
	 * @return ArrayList
	 */
	public List getSwoTPs() {
		return iSwoTPs;
	}

	/**
	 * Sets collection of swo tp's 
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
	 * @param newSwoTPs ArrayList 
	 */
	public void setSwoTPs(List newSwoTPs) {
		iSwoTPs = newSwoTPs;
	}

	/**
	 * Adds a new swo tp the collection of already existing swo tp's  
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
	 * @param swoTP SWOTPViewBean
	 */
	public void addSwo(SWOTPViewBean swoTP){
		if(null != swoTP){
			if(null == iSwoTPs){
				iSwoTPs = new ArrayList();
			}
			iSwoTPs.add(swoTP);
		}
	}
	
	/**
     * Sets complete data in a single method call
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param customDTO 
     */
	public void setData(ValidateTPProposalCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			List swos = customDTO.getSwos();
			if(null != swos){
				for(int i=0, size=swos.size(); i<size; i++){
					addSwo(new SWOTPViewBean((SWOTPCustomDTO)swos.get(i)));
				}
			}
		}
	}
	
	/**
     * TPValidationReportViewBean
     * 
     * @author thirumalai
     */
    public TPValidationReportViewBean(){
	}
	/**
     * TPValidationReportViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public TPValidationReportViewBean(ValidateTPProposalCustomDTO customDTO){
		setData(customDTO);
	}
}
