/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dto;

import java.util.List;
import java.io.Serializable;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class UserGroupProfileDomainDTO implements Serializable 
{
	private List userGroupProfileDomainDTOList;
	/** 
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public UserGroupProfileDomainDTO() 
	{
			
	}
	public void setUserGroupProfileDomainDTOList(List newList)
	{
		userGroupProfileDomainDTOList = newList;
	}
	public List getUserGroupProfileDomainDTOList()
	{
		return userGroupProfileDomainDTOList;
	}
}
