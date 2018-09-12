/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;
import java.util.TreeMap;

/**
 * Custom dto that holds quote information  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class QuotesListCustomDTO extends OPPTCustomDTO {
	private Date toDate = null;
	private Date fromDate = null;
	private ProposalCustomDTO proposalDTO = null;
	private TreeMap quotes = null;

	/**
	 * Returns starting date from which quotes has to be retrieved 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * Returns proposal details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
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
	 * Returns quotes collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getQuotes() {
		return quotes;
	}

	/**
	 * Returns ending date to which the quotes should be retrieved 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * Sets from date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFromDate Date 
	 */
	public void setFromDate(Date newFromDate) {
		fromDate = newFromDate;
	}

	/**
	 * Sets proposal details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalDTO ProposalCustomDTO 
	 */
	public void setProposalDTO(ProposalCustomDTO newProposalDTO) {
		proposalDTO = newProposalDTO;
	}

	/**
	 * Sets quotes collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newQuotes TreeMap 
	 */
	public void setQuotes(TreeMap newQuotes) {
		quotes = newQuotes;
	}

	/**
	 * Sets to date value to which quotes need to be retrieved 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newToDate Date 
	 */
	public void setToDate(Date newToDate) {
		toDate = newToDate;
	}
	
	/**
	 * Adds new quote to the collection of quotes available  
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
	 * @param quote QuoteCustomDTO
	 */
	public void addQuote(QuoteCustomDTO quote){
		if(null != quote){
			if(null == quotes){
				quotes = new TreeMap();
			}
			quotes.put(quote.getId(), quote);
		}
	}
}
