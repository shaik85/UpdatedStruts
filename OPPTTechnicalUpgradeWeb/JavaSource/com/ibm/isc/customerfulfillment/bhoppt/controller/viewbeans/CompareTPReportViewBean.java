/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CompareTPReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.CompareTPRptDomainDTO;

/**
 * Holds the complete information about the compate tp report.  
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
public class CompareTPReportViewBean extends OPPTViewBean 
{
	private String oldContractNumber = null;
	private String newContractNumber = null;
	private Vector swoViewBeans = null;
	
	/**
     * CompareTPReportViewBean
     * 
     * @author thirumalai
     */
    public CompareTPReportViewBean(){
	}
	
	/**
     * CompareTPReportViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public CompareTPReportViewBean(CompareTPReportCustomDTO customDto){
		populateData(customDto);
	}

	/**
	 * Returns the new contract number 
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
	public String getNewContractNumber() {
		return newContractNumber;
	}

	/**
	 * Returns the old contract number 
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
	public String getOldContractNumber() {
		return oldContractNumber;
	}

	/** 
	 * Returns the collection of CompareTPSWOViewBean's associated with the contract.
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
	 * @return Vector 
	 */
	public Vector getSwoViewBeans() {
		return swoViewBeans;
	}

	/**
	 * Sets the new contract number 
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
	 * @param newContractNumber String 
	 */
	public void setNewContractNumber(String newContractNumber) {
		newContractNumber = newContractNumber;
	}

	/**
	 * Sets the old contract number
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
	 * @param oldContractNumber String 
	 */
	public void setOldContractNumber(String oldContractNumber) {
		oldContractNumber = oldContractNumber;
	}

	/**
	 * Sets the collection as the collection of CompareTPSWOViewBean's associated with the contract. 
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
	 * @param newSwoViewBeans Vector 
	 */
	public void setSwoViewBeans(Vector newSwoViewBeans) {
		swoViewBeans = newSwoViewBeans;
	}

	/**
	 * Adds a new CompareTPViewBean to the collection of already existing CompareTPViewBean's collection.  
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
	 * @param swoViewBean CompateTPSWOViewBean
	 */
	public void addSWOViewBean(CompareTPSWOViewBean swoViewBean) {
		if(swoViewBean != null) {
			if(swoViewBeans == null){
				swoViewBeans = new Vector();
			}
			swoViewBeans.addElement(swoViewBean);
		}
	}

	/**
	 * Sets the complete data in a single method call.  
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
	 * @param newContractNumber
	 * @param oldContractNumber
	 * @param swoViewBeans
	 */	
	public void setData(String newContractNumber, String oldContractNumber, Vector swoViewBeans) {
		setNewContractNumber(newContractNumber);
		setOldContractNumber(oldContractNumber);
		setSwoViewBeans(swoViewBeans);
	}
	
	/**
     * populateData
     * 
     * @param customDto
     * @author thirumalai
     */	
	private void populateData(CompareTPReportCustomDTO customDto){
		setNewContractNumber(customDto.getContractCustomDTO().getOldContractNumber());
		setOldContractNumber(customDto.getCompareTPRptDomainDTO().getContractNo());
		setSwoViewBeans(getViewBeanList(customDto));
	}

	
	/**
     * getViewBeanList
     * 
     * @param customDto
     * @author thirumalai
     */
	private Vector getViewBeanList(CompareTPReportCustomDTO customDto){
		Vector beanList = new Vector();
		SWOViewBean viewBean=null;
		SWODomainDTO swoDto=null;
		CompareTPRptDomainDTO domainDto = customDto.getCompareTPRptDomainDTO();
		List swoList = domainDto.getSWODomainDTOList();
		
		int count = 0;
		if(null != swoList){
			Iterator itr = swoList.iterator();
			while(itr.hasNext()){
				swoDto = (SWODomainDTO)swoList.get(count);
				viewBean = new SWOViewBean();
	//			viewBean.setId(swoDto.getId());
				viewBean.setSwoNumber(swoDto.getSwoNo());
				viewBean.setSerialNumber(swoDto.getSerialNo());
				viewBean.setDescription(swoDto.getSwoDesc());
				viewBean.setEswPrice(swoDto.getEswPrice());
				viewBean.setAlternatePrice(swoDto.getAlternatePrice());
				viewBean.setCalculatedPrice(swoDto.getCalcPrice());
				viewBean.setPlanStartDate(swoDto.getPlanStartDate());
				viewBean.setPlanEndDate(swoDto.getPlanEndDate());
				
				beanList.add(viewBean);
				count++;
			}
		}
		
		
		
		
		return beanList;
	}
}
