/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.AccessHistoryComparator;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.ProposalHistoryDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHistoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHistoryDataCustomDTO;

/**
 * Holds complete information about history of a proposal  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 *  Revised by Nomita as a part of Activity Log changes
 * Date 11th Jan 2011
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalHistoryViewBean extends OPPTViewBean{
	private ArrayList iProposalHistory = null;
	private String iProposalName = null;
	private boolean iContract = false;
	private boolean iProposalForApproval = false;
	
	/**
	 * Returns proposal history collection 
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
	public ArrayList getProposalHistory() {
		AccessHistoryComparator comparator = null;
		if(null != iProposalHistory){
			comparator = new AccessHistoryComparator();
			Collections.sort(iProposalHistory, comparator);
		}
		return iProposalHistory;
	}

	/**
	 * Sets proposal history collection 
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
	 * @param newProposalHistory ArrayList 
	 */
	public void setProposalHistory(ArrayList newProposalHistory) {
		iProposalHistory = newProposalHistory;
	}

	public String getProposalName() {
		return iProposalName;
	}

	

	/**
	 * Sets the proposal name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * Revised by Nomita as a part of Activity Log changes
 * Date 11th Jan 2011 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalName String 
	 */
	public void setProposalName(String newProposalName) {
		iProposalName = newProposalName;
	}
	
	/**
	 * Adds a new proposal history entry to already existing collection of proposal history entries.  
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
	 * @param proposalHistory ProposalHistoryDataBean
	 */
	public void addProposalHistory(ProposalHistoryDataBean proposalHistory){
		if(null != proposalHistory){
			if(null == iProposalHistory){
				iProposalHistory = new ArrayList();
			}
			iProposalHistory.add(proposalHistory);
		}
	}
	
	/**
     * Sets complete data in a single method call.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param customDTO 
     */
	public void setData(ProposalHistoryCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
		//start- Nomits
			ProposalCustomDTO proposalDTO = customDTO.getProposalDTO();
			if(null != proposalDTO){
				setProposalName(proposalDTO.getName()+"("+proposalDTO.getType()+")");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			//end
			ArrayList accessHistory = customDTO.getAccessHistory();
			if(null != accessHistory){
				for(int i=0, size=accessHistory.size(); i<size; i++){
					ProposalHistoryDataCustomDTO data = (ProposalHistoryDataCustomDTO)accessHistory.get(i);
					if(null != data){
						addProposalHistory(new ProposalHistoryDataBean(data));
					}
				}
			}
		}
	}

	/**
     * ProposalHistoryViewBean
     * 
     * @author thirumalai
     */
    public ProposalHistoryViewBean(){
	}
	/**
     * ProposalHistoryViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ProposalHistoryViewBean(ProposalHistoryCustomDTO customDTO){
		setData(customDTO);
	}
	/**
     * ProposalHistoryViewBean
     * 
     * @param customDTO
     * @param contract
     * @author thirumalai
     */
    public ProposalHistoryViewBean(ProposalHistoryCustomDTO customDTO, boolean contract){
		setData(customDTO);
		setContract(contract);
	}
	/**
     * ProposalHistoryViewBean
     * 
     * @param customDTO
     * @param contract
     * @param proposalForApproval
     * @author thirumalai
     */
    public ProposalHistoryViewBean(ProposalHistoryCustomDTO customDTO, boolean contract, boolean proposalForApproval){
		setData(customDTO);
		setContract(contract);
		setProposalForApproval(proposalForApproval);
	}

	/**
	 * Returns true if the access history is for an contract 
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
	 * Sets a flag telling whether the access history is for an proposal or a contract. 
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
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
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
	 * @return 
	 */
	public boolean isProposalForApproval() {
		return iProposalForApproval;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
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
	 * @param b 
	 */
	public void setProposalForApproval(boolean b) {
		iProposalForApproval = b;
	}

}
