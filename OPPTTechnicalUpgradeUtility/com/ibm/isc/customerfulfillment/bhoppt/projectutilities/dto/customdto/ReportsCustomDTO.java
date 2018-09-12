/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;
import java.util.TreeMap;

/**
 *  
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

public class ReportsCustomDTO extends OPPTCustomDTO
{
   private TreeMap proposalCustomDTO = null;
   
   /**
    * constructor
    *  
    * <br><b>Known Bugs</b><br> 
    * 
    * <br><PRE> 
    * date Jan 7, 2004 
    * 
    * revision date author reason 
    * 
    * </PRE><br> 
    */
   
   public ReportsCustomDTO() 
   {
    
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
 * date Jan 7, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return TreeMap
 */
public TreeMap getProposalCustomDTO() {
	return proposalCustomDTO;
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
 * date Jan 7, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param list 
 */
public void setProposalCustomDTO(TreeMap list) {
	proposalCustomDTO = list;
}

}
