/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;
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
public class ValidCombinationDomainDTO 
{
   private String salesOrg = null;
   private String divisionCode = null;
   private String distributionChannel = null;
   
   /**
    * constructor
    *    @roseuid 3FB4745C01AB
    */
   public ValidCombinationDomainDTO() 
   {
    
   }
/**
 * return the distributionChannel 
 *
 * @return Returns the distributionChannel.
 */
public String getDistributionChannel() {
    return distributionChannel;
}
/**
 * sets the distributionChannel
 *
 * @param lDistributionChannel The distributionChannel to set.
 */
public void setDistributionChannel(String lDistributionChannel) {
    distributionChannel = lDistributionChannel;
}
/**
 * return the divisionCode 
 *
 * @return Returns the divisionCode.
 */
public String getDivisionCode() {
    return divisionCode;
}
/**
 * sets the divisionCode
 *
 * @param lDivisionCode The divisionCode to set.
 */
public void setDivisionCode(String lDivisionCode) {
    divisionCode = lDivisionCode;
}
/**
 * return the salesOrg 
 *
 * @return Returns the salesOrg.
 */
public String getSalesOrg() {
    return salesOrg;
}
/**
 * sets the salesOrg
 *
 * @param lSalesOrg The salesOrg to set.
 */
public void setSalesOrg(String lSalesOrg) {
    salesOrg = lSalesOrg;
}
}
