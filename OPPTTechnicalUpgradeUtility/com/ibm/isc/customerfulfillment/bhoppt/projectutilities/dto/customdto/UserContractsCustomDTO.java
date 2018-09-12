/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;
import java.util.TreeMap;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 29, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class UserContractsCustomDTO extends OPPTCustomDTO
{
   private GroupUserCustomDTO groupUserInfo;
   private TreeMap contractCustomDTO;
   private Date startDate;
   private Date endDate;
   
	/** 
	 * Returns List of ContractCustomDTO
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
	 * @return List
	 */
	public TreeMap getContractCustomDTO() {
		return contractCustomDTO;
	}
	
	/** 
	 * Returns End Date
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
	 * @return Date
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/** 
	 * Returns GroupUserCustomDTO
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
	 * @return GroupUserCustomDTO
	 */
	public GroupUserCustomDTO getGroupUserInfo() {
		return groupUserInfo;
	}
	
	/** 
	 * Returns Start Date
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
	 * @return Date
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
     *  For setting ContractCustomDTO
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 29, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param contractCustomDTOList 
     */
	public void setContractCustomDTO(TreeMap contractCustomDTOList) {
		contractCustomDTO = contractCustomDTOList;
	}
	
	/** 
	 * For setting End Date
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
	 * @param date 
	 */
	public void setEndDate(Date date) {
		endDate = date;
	}
	
	/** 
	 * For setting GroupUserCustomDTO
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
	 * @param customDTO 
	 */
	public void setGroupUserInfo(GroupUserCustomDTO customDTO) {
		groupUserInfo = customDTO;
	}
	
	/** 
	 * For setting Start Date
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
	 * @param date 
	 */
	public void setStartDate(Date date) {
		startDate = date;
	}

}
