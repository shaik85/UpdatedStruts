/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;

import java.util.List;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */


public class CompareTPRptSWODomainDTO 
{
   private String sWONumber = null;
   private List eEDomainDTOList = null;
  
   /**
    * 
    * constructor
    *
    */
   public CompareTPRptSWODomainDTO() 
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
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return 
 */
public String getSWONumber() {
	return sWONumber;
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
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param string 
 */
public void setSWONumber(String string) {
	sWONumber = string;
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
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return 
 */
public List getEEDomainDTOList() {
	return eEDomainDTOList;
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
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param list 
 */
public void setEEDomainDTOList(List list) {
	eEDomainDTOList = list;
}

}
