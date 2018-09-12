/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;
import java.util.TreeMap;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.QuoteCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.QuotesListCustomDTO;

/**
 * Holds complete data about quotes list view  
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
public class QuotesListViewBean extends OPPTViewBean {
	private TreeMap iQuotes = null;
	
	/**
	 * Returns the collection of quotes availble for the selected period 
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
	 * @return TreeMap
	 */
	public TreeMap getQuotes() {
		return iQuotes;
	}

	/**
	 * Sets the collection of quotes for the selected period 
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
	 * @param newQuotes TreeMap 
	 */
	public void setQuotes(TreeMap newQuotes) {
		iQuotes = newQuotes;
	}

	/**
     * Adds a new quote into already existing collection of quotes
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param quote QuoteViewBean
     * @param id 
     */
	public void addQuote(String id, QuoteViewBean quote){
		if(null != quote){
			if(null == iQuotes){
				iQuotes = new TreeMap();
			}
			iQuotes.put(id, quote);
		}
	}
	
	/**
	 * Sets complete data in a single method call.  
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
	 * @param quotes TreeMap
	 */
	public void setData(TreeMap quotes){
		setQuotes(quotes);
	}

	/**
	 * Sets complete data from a custom dto  
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
	 * @param customDTO QuoteListCustomDTO
	 */	
	public void setData(QuotesListCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			TreeMap quotes = customDTO.getQuotes();
			if(null != quotes){
				Iterator quoteIterator = quotes.keySet().iterator();
				while(quoteIterator.hasNext()){
					String id = (String)quoteIterator.next();
					addQuote(id, new QuoteViewBean((QuoteCustomDTO)quotes.get(id)));
				}
			}
		}
	}
	
	/**
     * QuotesListViewBean
     * 
     * @author thirumalai
     */
    public QuotesListViewBean(){
	}

	/**
     * QuotesListViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public QuotesListViewBean(QuotesListCustomDTO customDTO){
		setData(customDTO);
	}
	
	/**
     * quotesAvailable
     * 
     * @return
     * @author thirumalai
     */
    public boolean quotesAvailable(){
		boolean available = true;
		
		if(null == iQuotes || 0 == iQuotes.size()){
			available = false;
		}
		
		return available;
	}
	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#selectAll() 
	 *  
	 * 
	 */
	public void selectAll() {
		if(null != iQuotes){
			Iterator quoteIterator = iQuotes.values().iterator();
			while(quoteIterator.hasNext()){
				((QuoteViewBean)quoteIterator.next()).setSelected(true);
			}
		}
	}

	/**
     * clearAll
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#clearAll()
     * @author thirumalai
     */
    public void clearAll() {
		if(null != iQuotes){
			Iterator quoteIterator = iQuotes.values().iterator();
			while(quoteIterator.hasNext()){
				((QuoteViewBean)quoteIterator.next()).setSelected(false);
			}
		}
	}
}