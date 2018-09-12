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
public class EEDomainDTO 
{
   private ArrayList priceDTO=null;
   /** public field */
   public SWODomainDTO theSWODomainDTO=null;
   /** public field */
   public PriceDomainDTO thePriceDomainDTO=null;
   
   /**
    * constructor
    *    @roseuid 3FB4745A028F
    */
   public EEDomainDTO() 
   {
    
   }
/**
 * return the priceDTO 
 *
 * @return Returns the priceDTO.
 */
public ArrayList getPriceDTO() {
    return priceDTO;
}
/**
 * sets the priceDTO
 *
 * @param lPriceDTO The priceDTO to set.
 */
public void setPriceDTO(ArrayList lPriceDTO) {
    priceDTO = lPriceDTO;
}
/**
 * return the thePriceDomainDTO 
 *
 * @return Returns the thePriceDomainDTO.
 */
public PriceDomainDTO getThePriceDomainDTO() {
    return thePriceDomainDTO;
}
/**
 * sets the thePriceDomainDTO
 *
 * @param lThePriceDomainDTO The thePriceDomainDTO to set.
 */
public void setThePriceDomainDTO(PriceDomainDTO lThePriceDomainDTO) {
    thePriceDomainDTO = lThePriceDomainDTO;
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
