/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.*;
import java.util.Date;

/**
 * SWO Details Custom DTO 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class SWODetailsCustomDTO extends SWOCustomDTO 
{
	private ProposalCustomDTO proposal = null;

	private ESWCustomerCustomDTO soldToParty = null;
	private ESWCustomerCustomDTO billToParty = null;
	private ESWCustomerCustomDTO payer = null;
	private Date customerPlanStartDate = null;
	private Date customerPlanEndDate = null;

	private String dMNumber = null;
	private String dMDescription = null;	
	private Date dMPlanStartDate = null;
	private Date dMPlanEndDate = null;
	private boolean sAndS = false;
	
	private TreeMap eEs = null;
	
	private boolean sWOEditable = true;

	/**
	 * Returns bill to party details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getBillToParty() {
		return billToParty;
	}

	/**
	 * Returns customers plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getCustomerPlanEndDate() {
		return customerPlanEndDate;
	}

	/**
	 * Returns customers plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getCustomerPlanStartDate() {
		return customerPlanStartDate;
	}

	/**
	 * Returns dm description 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDMDescription() {
		return dMDescription;
	}

	/**
	 * Returns dm number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDMNumber() {
		return dMNumber;
	}

	/**
	 * Returns dm plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDMPlanEndDate() {
		return dMPlanEndDate;
	}

	/**
	 * Returns dm plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDMPlanStartDate() {
		return dMPlanStartDate;
	}

	/**
	 * Returns ee collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getEEs() {
		return eEs;
	}

	/**
	 * Returns payer details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getPayer() {
		return payer;
	}

	/**
	 * Returns proposal details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalCustomDTO
	 */
	public ProposalCustomDTO getProposal() {
		return proposal;
	}

	/**
	 * Returns sold to party details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getSoldToParty() {
		return soldToParty;
	}

	/**
	 * Sets bill to party details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToParty ESWCustomerCustomDTO 
	 */
	public void setBillToParty(ESWCustomerCustomDTO newBillToParty) {
		billToParty = newBillToParty;
	}

	/**
	 * Sets customer plan end date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerPlanEndDate Date 
	 */
	public void setCustomerPlanEndDate(Date newCustomerPlanEndDate) {
		customerPlanEndDate = newCustomerPlanEndDate;
	}

	/**
	 * Sets customer plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerPlanStartDate Date 
	 */
	public void setCustomerPlanStartDate(Date newCustomerPlanStartDate) {
		customerPlanStartDate = newCustomerPlanStartDate;
	}

	/**
	 * Sets dm description value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMDescription String 
	 */
	public void setDMDescription(String newDMDescription) {
		dMDescription = newDMDescription;
	}

	/**
	 * Sets new dm number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMNumber String 
	 */
	public void setDmNumber(String newDMNumber) {
		dMNumber = newDMNumber;
	}

	/**
	 * Sets dm plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMPlanEndDate Date 
	 */
	public void setDmPlanEndDate(Date newDMPlanEndDate) {
		dMPlanEndDate = newDMPlanEndDate;
	}

	/**
	 * Sets dm plan start date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMPlanStartDate Date 
	 */
	public void setDmPlanStartDate(Date newDMPlanStartDate) {
		dMPlanStartDate = newDMPlanStartDate;
	}

	/**
	 * Sets ee collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEEs TreeMap 
	 */
	public void setEes(TreeMap newEEs) {
		eEs = newEEs;
	}

	/**
	 * Sets payer details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayer ESWCustomerCustomDTO
	 */
	public void setPayer(ESWCustomerCustomDTO newPayer) {
		payer = newPayer;
	}

	/**
	 * Sets proposal data 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposal ProposalCustomDTO
	 */
	public void setProposal(ProposalCustomDTO newProposal) {
		proposal = newProposal;
	}

	/**
	 * Sets sold to party details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToParty ESWCustomerCustomDTO
	 */
	public void setSoldToParty(ESWCustomerCustomDTO newSoldToParty) {
		soldToParty = newSoldToParty;
	}

	/**
	 * Adds ee to the collection of ees available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ee EECustomDTO
	 */
	public void addEE(EECustomDTO ee){
		if(null != ee){
			if(null == eEs){
				eEs = new TreeMap();
			}
			eEs.put(ee.getId(), ee);
		}
	}
	
	
	/**
     * to String
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 7, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return String
     */
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();

		buffer.append("\n[SWODetailsCustomDTO] - Start...");   /* NOI18N */
		buffer.append(super.toString());
		buffer.append("\n[Sold to party] - "+soldToParty);   /* NOI18N */
		buffer.append("\n[Bill to party] - "+billToParty);   /* NOI18N */
		buffer.append("\n[Payer] - "+payer);   /* NOI18N */
		buffer.append("\n[Customer plan start date] - "+customerPlanStartDate);   /* NOI18N */
		buffer.append("\n[Customer plan end date] - "+customerPlanEndDate);   /* NOI18N */
		buffer.append("\n[DM number: "+dMNumber+"]");   /* NOI18N */
		buffer.append("\n[DM description: "+dMDescription+"]");   /* NOI18N */
		buffer.append("\n[DM plan start date: "+dMPlanStartDate+"]");   /* NOI18N */				
		buffer.append("\n[DM plan end date: "+dMPlanEndDate+"]");   /* NOI18N */

		buffer.append("\n[EEs] - "+eEs);   /* NOI18N */	
		buffer.append("\n[SWODetailsCustomDTO] - End...\n");   /* NOI18N */
		
		return buffer.toString();
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
	 * date Mar 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSAndS() {
		return sAndS;
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
	 * date Mar 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSAndS(boolean b) {
		sAndS = b;
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
	 * date Nov 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSWOEditable() {
		return sWOEditable;
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
	 * date Nov 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSWOEditable(boolean b) {
		sWOEditable = b;
	}

    /**
     * set the value
     * @param number The dMNumber to set.
     */
    public void setDMNumber(String number) {
        dMNumber = number;
    }
    /**
     * set the value
     * @param planEndDate The dMPlanEndDate to set.
     */
    public void setDMPlanEndDate(Date planEndDate) {
        dMPlanEndDate = planEndDate;
    }
    /**
     * set the value
     * @param planStartDate The dMPlanStartDate to set.
     */
    public void setDMPlanStartDate(Date planStartDate) {
        dMPlanStartDate = planStartDate;
    }
    /**
     * set the value
     * @param es The eEs to set.
     */
    public void setEEs(TreeMap es) {
        eEs = es;
    }
}
