/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;

/**
 * Custom dto that holds complete error history of an proposal. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 31, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ErrorHistoryCustomDTO extends OPPTCustomDTO {
	private ProposalCustomDTO proposalDTO = null;
	private TreeMap errorInfos = null;
	private boolean editable = true;

	/**
	 * Returns error infos collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getErrorInfos() {
		return errorInfos;
	}

	/**
	 * Returns the proposal info for which error history is fetched 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalCustomDTO
	 */
	public ProposalCustomDTO getProposalDTO() {
		return proposalDTO;
	}

	/**
	 * Sets error info collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newErrorInfos 
	 */
	public void setErrorInfos(TreeMap newErrorInfos) {
		errorInfos = newErrorInfos;
	}

	/**
	 * Sets proposal info to which error history is to be fetched 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalDTO 
	 */
	public void setProposalDTO(ProposalCustomDTO newProposalDTO) {
		proposalDTO = newProposalDTO;
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
	 * @param errorInfo
	 */
	public void addErrorInfo(ErrorInfoCustomDTO errorInfo){
		if(null != errorInfo){
			if(null == errorInfos){
				errorInfos = new TreeMap();
			}
			errorInfos.put(errorInfo.getId(), errorInfo);
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
		return editable;
	}

	/**
	 * Sets editable flag for the error history. By default it is true.
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
	 * @param newEditable 
	 */
	public void setEditable(boolean newEditable) {
		editable = newEditable;
	}
}
