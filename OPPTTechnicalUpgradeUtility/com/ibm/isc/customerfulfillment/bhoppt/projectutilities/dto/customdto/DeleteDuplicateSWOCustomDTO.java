/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.ArrayList;
import java.util.List;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Oct 28, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1x
 */
public class DeleteDuplicateSWOCustomDTO extends OPPTCustomDTO {
	
	private List swos = null;

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
	 * date Nov 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getSwos() {
		return swos;
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
	 * date Nov 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setSwos(List list) {
		swos = list;
	}
	
	/**
	 *  preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	
	public void addSwos(List list) {
		if(swos == null) {
			swos = new ArrayList();			
		}
		swos.addAll(list);
	}
	
	/** 
	 *  preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoCustomDTO
	 */
	public void checkForSWO(SWOCustomDTO swoCustomDTO) {
		try {
		if(null != swos) {
			for(int i=0;i<swos.size();i++) {
				SWOCustomDTO markedSWO = (SWOCustomDTO)swos.get(i);
				if(markedSWO.getId().equals(swoCustomDTO.getId()) && 
				   markedSWO.getProposalId() == swoCustomDTO.getProposalId() &&
				   markedSWO.getDMId().equals(swoCustomDTO.getDMId()) &&
				   markedSWO.getCustomerId().equals(swoCustomDTO.getCustomerId())) {				   	  
				   	swoCustomDTO.setMarkedForDeletion(true);	
				   	break;		
				   }
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
