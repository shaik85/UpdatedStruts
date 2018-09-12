/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;

/**
 * Amend SWO custom dto
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */

public class AmendSWOCustomDTO extends OPPTCustomDTO
{
   private SWOCustomDTO swoDTO = null;
   private ContractCustomDTO contractDTO = null;
   private Date fromDate = null;
   private Date toDate = null;
   
   /**
    * AmendSWOCustomDTO
    *@roseuid 3FB471E402F7
    */
   public AmendSWOCustomDTO() 
   {
    
   }
   
   /**
    * it's set the data
    *@roseuid 3F717F1202DA
    */
   public void setData() 
   {
    
   }
   
   /**
    * it's get the data
    *@roseuid 3F717F1202DA
    */
   
   public void getData() 
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
    * @return 
    */
public ContractCustomDTO getContractDTO() {
	return contractDTO;
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
 * @return 
 */
public Date getFromDate() {
	return fromDate;
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
 * @return 
 */
public SWOCustomDTO getSwoDTO() {
	return swoDTO;
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
 * @return 
 */
public Date getToDate() {
	return toDate;
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
 * @param customDTO 
 */
public void setContractDTO(ContractCustomDTO customDTO) {
	contractDTO = customDTO;
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
 * @param date 
 */
public void setFromDate(Date date) {
	fromDate = date;
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
 * @param customDTO 
 */
public void setSwoDTO(SWOCustomDTO customDTO) {
	swoDTO = customDTO;
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
 * @param date 
 */
public void setToDate(Date date) {
	toDate = date;
}

}
