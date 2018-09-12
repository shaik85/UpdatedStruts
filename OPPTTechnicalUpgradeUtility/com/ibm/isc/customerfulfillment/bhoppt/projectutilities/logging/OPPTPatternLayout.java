/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.helpers.PatternParser;

/** 
 * This class inherits from PatternLayout and uses OPPTPatternParser for implementing
 * GWA standards.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 1, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A 
 */
public class OPPTPatternLayout extends PatternLayout{
	
    /**
	 * constructor
	 * <br/><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 *
	 */
    
    public OPPTPatternLayout(){
		super();
	}
	
	/**
	 * constructor
	 * <br/><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param pattern String
	 *
	 */
	
	public OPPTPatternLayout(String pattern){
		super(pattern);
	}
		
	/**
	 *  
	 * Overridden method 
	 * This method accepts the pattern and calls OPPTPatternParser to parse the patter
	 * and format the output in GWA standards.
	 * 
	 * <br/><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see org.apache.log4j.PatternLayout#createPatternParser(java.lang.String) 
	 * @param pattern String
	 * @return  PatternParser
	 *
	 */
	 protected PatternParser createPatternParser(String pattern) {
	   return new OPPTPatternParser(pattern);
	 }
}
