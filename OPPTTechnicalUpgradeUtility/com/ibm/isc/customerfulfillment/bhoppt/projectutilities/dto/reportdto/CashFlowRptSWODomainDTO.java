/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;

import java.util.HashMap;
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

public class CashFlowRptSWODomainDTO 
{
   private String swoNo = null;
   private String serialNo = null;
   private HashMap monthlyPriceTable = null;
   private List  sWOEEDomainDTOList = null;
   
   /**
    * constructor
    *    @roseuid 3FB4745801B0
    */
   public CashFlowRptSWODomainDTO() 
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
public HashMap getMonthlyPriceTable() {
	return monthlyPriceTable;
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
public String getSerialNo() {
	return serialNo;
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
public List getSWOEEDomainDTOList() {
	return sWOEEDomainDTOList;
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
public String getSwoNo() {
	return swoNo;
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
 * @param map 
 */
public void setMonthlyPriceTable(HashMap map) {
	monthlyPriceTable = map;
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
public void setSerialNo(String string) {
	serialNo = string;
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
public void setSWOEEDomainDTOList(List list) {
	sWOEEDomainDTOList = list;
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
public void setSwoNo(String string) {
	swoNo = string;
}

}
