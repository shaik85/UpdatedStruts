/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReportsCustomDTO;

/**
 * Holds complete data required for report view.   
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
public class ReportsViewBean extends OPPTViewBean{
	private TreeMap iProposals = null;
	
	/**
     * ReportsViewBean
     * 
     * @author thirumalai
     */
    public ReportsViewBean(){
	}
	
	/**
     * ReportsViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public ReportsViewBean(ReportsCustomDTO customDto){
		populateBean(customDto.getProposalCustomDTO());
	}

	/**
	 * Returns the collection of proposals available for generating reports 
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
	public TreeMap getProposals() {
		return iProposals;
	}

	/**
	 * Sets the collection of proposals available for report generation 
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
	 * @param newProposals ArrayList 
	 */
	public void setProposals(TreeMap newProposals) {
		iProposals = newProposals;
	}

	/**
     * Adds a new proposal to the already existing collection
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param key
     * @param value 
     */
	public void addProposal(Object key, Object value){
		
		if(null == iProposals){
			iProposals = new TreeMap();
		}
		iProposals.put(key,value);
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
	 * @param proposals
	 */
	public void setData(TreeMap proposals){
		setProposals(proposals);
	}
	
	private void populateBean(TreeMap customMap){
		Set keySet = customMap.keySet();
		Iterator itr = keySet.iterator();
		
		while(itr.hasNext()){
			Object key = itr.next();
			ProposalCustomDTO customDto = (ProposalCustomDTO)customMap.get(key);
			String proposalName = customDto.getName();
			if(null != key && null != proposalName && !"".equals(proposalName)){  //$NON-NLS-1$
				addProposal(proposalName, key);
			}
		}
	}
}

