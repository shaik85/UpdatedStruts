/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dto;


import java.util.HashMap;
import java.util.Map;


/** 
 * This Domain dtos carries the data across the service layer
 * During Copy Inventory Process 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham K Mani
 * @version 5.1A 
 */


public class CopyInventoryDomainDTO extends OPPTDomainDTO
{
	private Map iValueMap = new HashMap();

	private int newProposalID;
	private int oldProposalID;

	private int newCustomerID;
	private int oldCustomerID;

	private int newDMID;
	private int oldDMID;

	private int newSWOID;
	private int oldSWOID;

	private int newEEID;
	private int oldEEID;

	private int choice;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public CopyInventoryDomainDTO()
	{
	}

	/** 
	 * To get the new customer ID
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return newCustomerID
	 */
	public int getNewCustomerID()
	{
		return newCustomerID;
	}

	/** 
	 * To get the new DM ID
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return newDMID
	 */
	public int getNewDMID()
	{
		return newDMID;
	}

	/** 
	 * To get the new proposal id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return newProposalID
	 */
	public int getNewProposalID()
	{
		return newProposalID;
	}

	/** 
	 * To get the new SWOID
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return newSWOID
	 */
	public int getNewSWOID()
	{
		return newSWOID;
	}

	/** 
	 * To get the old customer ID
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return oldCustomerID
	 */
	public int getOldCustomerID()
	{
		return oldCustomerID;
	}

	/** 
	 * To get the old DM ID
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return oldDMID
	 */
	public int getOldDMID()
	{
		return oldDMID;
	}

	/** 
	 * To get the old proposal ID
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return oldProposalID
	 */
	public int getOldProposalID()
	{
		return oldProposalID;
	}

	/** 
	 * To get the old swo id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return oldSWOID
	 */
	public int getOldSWOID()
	{
		return oldSWOID;
	}

	/** 
	 * To set the new customer id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerID 
	 */
	public void setNewCustomerID(int iNewCustomerID)
	{
		newCustomerID = iNewCustomerID;
	}

	/** 
	 * To set the new dm id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMID 
	 */
	public void setNewDMID(int iNewDMID)
	{
		newDMID = iNewDMID;
	}

	/** 
	 * To set the new proposal id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalID 
	 */
	public void setNewProposalID(int iNewProposalID)
	{
		newProposalID = iNewProposalID;
	}

	/** 
	 * To set the new SWO ID
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSWOID 
	 */
	public void setNewSWOID(int iNewSWOID)
	{
		newSWOID = iNewSWOID;
	}

	/** 
	 * To set the old customer ID
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldCustomerID 
	 */
	public void setOldCustomerID(int iOldCustomerID)
	{
		oldCustomerID = iOldCustomerID;
	}

	/** 
	 * To set the old dm id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldDMID 
	 */
	public void setOldDMID(int iOldDMID)
	{
		oldDMID = iOldDMID;
	}

	/** 
	 * To set the old proposal id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldProposalID 
	 */
	public void setOldProposalID(int iOldProposalID)
	{
		oldProposalID = iOldProposalID;
	}

	/** 
	 * To set the old swo id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldSWOID 
	 */
	public void setOldSWOID(int iOldSWOID)
	{
		oldSWOID = iOldSWOID;
	}

	/**
	 * To add the values to the map based on the keys  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param key
	 * @param value
	 */
	public void addValue(Object key, Object value)
	{
		iValueMap.put(key, value);
	}

	/**
	 * To get the value for the given key  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param key
	 * @return Object
	 */
	public Object getValue(Object key)
	{
		return iValueMap.get(key);
	}
	/** 
	 * To get the choice 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return choice 
	 */
	public int getChoice()
	{
		return choice;
	}

	/** 
	 * To set the choice
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param choice 
	 */
	public void setChoice(int iChoice)
	{
		choice = iChoice;
	}

	/** 
	 * To set the new ee id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return newEEID
	 */
	public int getNewEEID()
	{
		return newEEID;
	}

	/** 
	 * To get the old ee-id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return oldEEID 
	 */
	public int getOldEEID()
	{
		return oldEEID;
	}

	/** 
	 * To set the new ee-id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEEID 
	 */
	public void setNewEEID(int i)
	{
		newEEID = i;
	}

	/** 
	 * To set the old ee-id
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldEEID 
	 */
	public void setOldEEID(int i)
	{
		oldEEID = i;
	}
}
