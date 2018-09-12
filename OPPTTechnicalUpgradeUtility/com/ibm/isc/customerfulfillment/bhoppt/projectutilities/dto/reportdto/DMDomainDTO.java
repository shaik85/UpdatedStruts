/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;

import java.util.ArrayList;

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
public class DMDomainDTO 
{
   private ArrayList swoDTO=null;
   /** public*/
   public CustomerDomainDTO theCustomerDomainDTO=null;
   /** public*/
   public SWODomainDTO theSWODomainDTO=null;
   
   /**
    * constructor   @roseuid 3FB4745A025D
    */
   public DMDomainDTO() 
   {
    
   }
/**
 * return the swoDTO 
 *
 * @return Returns the swoDTO.
 */
public ArrayList getSwoDTO() {
    return swoDTO;
}
/**
 * sets the swoDTO
 *
 * @param lSwoDTO The swoDTO to set.
 */
public void setSwoDTO(ArrayList lSwoDTO) {
    swoDTO = lSwoDTO;
}
/**
 * return the theCustomerDomainDTO 
 *
 * @return Returns the theCustomerDomainDTO.
 */
public CustomerDomainDTO getTheCustomerDomainDTO() {
    return theCustomerDomainDTO;
}
/**
 * sets the theCustomerDomainDTO
 *
 * @param lTheCustomerDomainDTO The theCustomerDomainDTO to set.
 */
public void setTheCustomerDomainDTO(CustomerDomainDTO lTheCustomerDomainDTO) {
    theCustomerDomainDTO = lTheCustomerDomainDTO;
}
/**
 * return the theSWODomainDTO 
 *
 * @return Returns the theSWODomainDTO.
 */
public SWODomainDTO getTheSWODomainDTO() {
    return theSWODomainDTO;
}
/**
 * sets the theSWODomainDTO
 *
 * @param lTheSWODomainDTO The theSWODomainDTO to set.
 */
public void setTheSWODomainDTO(SWODomainDTO lTheSWODomainDTO) {
    theSWODomainDTO = lTheSWODomainDTO;
}
}
