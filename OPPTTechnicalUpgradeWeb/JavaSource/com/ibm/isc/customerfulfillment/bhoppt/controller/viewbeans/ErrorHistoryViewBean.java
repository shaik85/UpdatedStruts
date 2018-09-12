/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorHistoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ErrorInfoCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;

/**
 * Holds complete data about error history of a proposal.  
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
public class ErrorHistoryViewBean extends OPPTViewBean {
	private String iProposalName = null;
	private TreeMap iErrorInfos = null;
	private boolean iEditable = true;
	private boolean iContract = false;

	/**
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public ErrorHistoryViewBean(){
	}

	/**
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param customDTO ErrorHistoryCustomDTO
	 */
	public ErrorHistoryViewBean(ErrorHistoryCustomDTO customDTO){
		setData(customDTO);
	}
	/**
     * @param customDTO
     * @param contract
     * @author thirumalai
     */
    public ErrorHistoryViewBean(ErrorHistoryCustomDTO customDTO, boolean contract){
		setData(customDTO);
		setContract(contract);
	}

	/**
	 * Returns the collection of ErrorInfoViewBean's  
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
	 * @return TreeMap 
	 */
	public TreeMap getErrorInfos() {
		return iErrorInfos;
	}

	/**
	 * Returns the proposal name 
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
	public String getProposalName() {
		return iProposalName;
	}

	/**
	 * Sets the ErrorInfoViewBean's collection
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
	 * @param newErrorInfos TreeMap 
	 */
	public void setErrorInfos(TreeMap newErrorInfos) {
		iErrorInfos = newErrorInfos;
	}

	/**
	 * Sets the proposal name 
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
	 * @param newProposalName String 
	 */
	public void setProposalName(String newProposalName) {
		iProposalName = newProposalName;
	}

	/**
	 * Adds a new ErrorInfoViewBean object to the already existing collection of 
	 * ErrorInfoViewBean's. If none are existing it creates a new collection and 
	 * adds.  
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
	 * @param errorInfo ErrorInfoViewBean
	 */
	public void addErrorInfo(ErrorInfoViewBean errorInfo){
		if(errorInfo != null){
			if(iErrorInfos == null){
				iErrorInfos = new TreeMap();
			}
			iErrorInfos.put(errorInfo.getId(), errorInfo);
		}
	}
	
	/**
	 * Sets complete data from a custom dto
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO ErrorHistoryCustomDTO
	 */
	public void setData(ErrorHistoryCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			ProposalCustomDTO proposalDTO = customDTO.getProposalDTO();
			if(null != proposalDTO){
				setProposalName(proposalDTO.getName()+"("+proposalDTO.getType()+")");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			
			TreeMap newErrorInfos = customDTO.getErrorInfos();
			if(null != newErrorInfos){
				Iterator iterator = newErrorInfos.values().iterator();
				while(iterator.hasNext()){
					addErrorInfo(new ErrorInfoViewBean((ErrorInfoCustomDTO)iterator.next()));					
				}
			}
			
			setEditable(customDTO.isEditable());
		}
	}
	/**
	 * Returns true if error history is editable 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isEditable() {
		return iEditable;
	}

	/**
	 * Sets editable flag value. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEditable boolean
	 */
	public void setEditable(boolean newEditable) {
		iEditable = newEditable;
	}

	/**
	 * Returns true if the error history is for an contract 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isContract() {
		return iContract;
	}

	/**
	 * Sets a flag telling whether the error history is for an proposal or a contract. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContract boolean
	 */
	public void setContract(boolean newContract) {
		iContract = newContract;
	}

	/**
	 * Returns true if there are error entries present.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isErrorHistoryAvailable(){
		boolean available = false;
		if(null != iErrorInfos && 0 < iErrorInfos.size()){
			available = true;
		}
		return available;
	}
}