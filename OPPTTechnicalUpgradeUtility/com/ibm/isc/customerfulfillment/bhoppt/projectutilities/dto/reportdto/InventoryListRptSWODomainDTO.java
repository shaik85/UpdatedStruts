/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;

import java.util.List;
import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.OPPTDomainDTO;
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

public class InventoryListRptSWODomainDTO extends OPPTDomainDTO
{
   private String soldToPartyID;	
   private String swoID;
   private String dmID = null ;
   private String sWoNumber = null ;
   private String indicator = null ;
   private String serialNumber = null ;
   private String quantity = null ;
   private List sWOEEDomainDTOList = null ;
   private double calculatedPrice;
   private double alternatePrice;
   private double eswPrice;
   /**
    * constructor
    *    @roseuid 3FB4745B0005
    */
   public InventoryListRptSWODomainDTO() 
   {
    
   }
   
   /**
    * get the data
    *    @roseuid 3F84CE300109
    */
   public void getData() 
   {
    
   }
   
   /**
    * set the data
    *    @roseuid 3F84CE3400E7
    */
   public void setData() 
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
public String getIndicator() {
	return indicator;
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
public String getSerialNumber() {
	return serialNumber;
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
public String getSWoNumber() {
	return sWoNumber;
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
public String getQuantity() {
	return quantity;
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
 * date Mar 15, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return 
 */
public double getCalculatedPrice() {
	return calculatedPrice;
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
 * date Mar 15, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return 
 */
public double getAlternatePrice() {
	return alternatePrice;
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
 * date Mar 18, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return 
 */
public double getEswPrice() {
	return eswPrice;
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
public void setIndicator(String string) {
	indicator = string;
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
public void setSerialNumber(String string) {
	serialNumber = string;
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
public void setSWoNumber(String string) {
	sWoNumber = string;
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
public void setQuantity(String string) {
	quantity = string;
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
 * date Jan 14, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return 
 */
public String getDmID() {
	return dmID;
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
 * date Jan 14, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return 
 */
public String getSoldToPartyID() {
	return soldToPartyID;
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
 * date Jan 14, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return 
 */
public String getSwoID() {
	return swoID;
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
 * date Jan 14, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param string 
 */
public void setDmID(String string) {
	dmID = string;
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
 * date Jan 14, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param string 
 */
public void setSoldToPartyID(String string) {
	soldToPartyID = string;
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
 * date Jan 14, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param string 
 */
public void setSwoID(String string) {
	swoID = string;
}

/**
 * Enter one sentence as a brief description for this method.
 * You can enter more text here. Please think of
 * - visibility decision
 * - changes that are made to objects, which are passed as parameters
 * - concurrency issues
 * - examples how to invoke this methods
 * - preconditions that this method relies on
 * <br><b>Known Bugs</b><br>
 * <br><PRE>
 * date Mar 15, 2004
 * revision date author reason
 * </PRE><br>
 *
 * @param d 
 */
public void setCalculatedPrice(double d) {
	calculatedPrice = d;
}

/**
 * Enter one sentence as a brief description for this method.
 * You can enter more text here. Please think of
 * - visibility decision
 * - changes that are made to objects, which are passed as parameters
 * - concurrency issues
 * - examples how to invoke this methods
 * - preconditions that this method relies on
 * <br><b>Known Bugs</b><br>
 * <br><PRE>
 * date Mar 15, 2004
 * revision date author reason
 * </PRE><br>
 *
 * @param d 
 */
public void setAlternatePrice(double d) {
	alternatePrice = d;
}
/**
 * Enter one sentence as a brief description for this method.
 * You can enter more text here. Please think of
 * - visibility decision
 * - changes that are made to objects, which are passed as parameters
 * - concurrency issues
 * - examples how to invoke this methods
 * - preconditions that this method relies on
 * <br><b>Known Bugs</b><br>
 * <br><PRE>
 * date Mar 18, 2004
 * revision date author reason
 * </PRE><br>
 *
 * @param d 
 */
public void setEswPrice(double d) {
	eswPrice = d;
}

/**
 * Enter one sentence as a brief description for this method.
 * You can enter more text here. Please think of
 * - visibility decision
 * - changes that are made to objects, which are passed as parameters
 * - concurrency issues
 * - examples how to invoke this methods
 * - preconditions that this method relies on
 * <br><b>Known Bugs</b><br>
 * <br><PRE>
 * date Jan 5, 2004
 * revision date author reason
 * </PRE><br>
 *
 * @param swoeeDomainDTOList 
 */
public void addSWOEEDomainDTOList(List swoeeDomainDTOList)
{
	if(null != swoeeDomainDTOList)
	{
		if(null == sWOEEDomainDTOList)
		{
			sWOEEDomainDTOList = new ArrayList();
		}
		sWOEEDomainDTOList.addAll(swoeeDomainDTOList);
	}
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
 * date Jan 5, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 */

public void reset(){
		soldToPartyID = null;	
		swoID = null;
		dmID = null;
		sWoNumber = null;
		indicator = null;
		serialNumber = null;
		quantity = null;
		
		if(null != sWOEEDomainDTOList){
			for(int i=0; i<sWOEEDomainDTOList.size(); i++){
				InventoryListRptSWOEEDomainDTO dto = (InventoryListRptSWOEEDomainDTO)sWOEEDomainDTOList.get(i);
				dto.reset();
			}
			sWOEEDomainDTOList.clear();
			sWOEEDomainDTOList = null;
		}
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
 * date Jan 5, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 
 */
/*public void finalize(){
		soldToPartyID = null;	
		swoID = null;
		dmID = null;
		sWoNumber = null;
		indicator = null;
		serialNumber = null;
		quantity = null;
		
		if(null != sWOEEDomainDTOList){
			for(int i=0; i<sWOEEDomainDTOList.size(); i++){
				InventoryListRptSWOEEDomainDTO dto = (InventoryListRptSWOEEDomainDTO)sWOEEDomainDTOList.get(i);
				dto = null;
//				dto.reset();
			}
			sWOEEDomainDTOList.clear();
			sWOEEDomainDTOList = null;
		}
	}*/
}