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

public class InventoryListRptCustomerDomainDTO extends OPPTDomainDTO
{
   private String soldToPartyID = null;	
   private double totalCalculatedPrice;
   private String legNo = null;
   private String aSNO = null;
   private List dMDomainDTOList = null;
   private double totalListPrice;
   private List ssdmDomainTO = null;
   private String custType = null;   
   
   /**
    * constructor
    *    @roseuid 3FB4745A02CB
    */
   public InventoryListRptCustomerDomainDTO() 
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
public String getASNO() {
	return aSNO;
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
public List getDMDomainDTOList() {
	return dMDomainDTOList;
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
public String getLegNo() {
	return legNo;
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
public double getTotalCalculatedPrice() {
	return totalCalculatedPrice;
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
public double getTotalListPrice() {
	return totalListPrice;
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
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
public List getSSDmDomainTO() {
	return ssdmDomainTO;
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
 * date Mar 24, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return 
 */
public String getCustType() {
	return custType;
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
public void setASNO(String string) {
	aSNO = string;
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
public void setDMDomainDTOList(List list) {
	dMDomainDTOList = list;
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
public void setLegNo(String string) {
	legNo = string;
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
 * @param d 
 */
public void setTotalCalculatedPrice(double d) {
	totalCalculatedPrice = d;
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
 * @param d 
 */
public void setTotalListPrice(double d) {
	totalListPrice = d;
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
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
public void setSSDmDomainTO(List list) {
	ssdmDomainTO = list;
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
 * @param dmDomainList 
 */
public void addDMDomainDTOList(List dmDomainList)
{
	if(null != dmDomainList)
	{
		if(null == dMDomainDTOList)
		{
			dMDomainDTOList = new ArrayList();
		}
		dMDomainDTOList.add(dmDomainList);
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
 * <br><b>Known Bugs</b><br>
 * <br><PRE>
 * date Mar 24, 2004
 * revision date author reason
 * </PRE><br>
 *
 * @param dmDomainList 
 */
	public void addSSDMDomainDTOList(List dmDomainList) {
		if (null != dmDomainList) {
			if (null == ssdmDomainTO) {
				ssdmDomainTO = new ArrayList();
			}
			ssdmDomainTO.add(dmDomainList);
		}
	}
	
	/**
	 * set the data
	 * <br><b>Known Bugs</b><br>
	 * <br><PRE>
	 * date Mar 24, 2004
	 * revision date author reason
	 * </PRE><br>
	 *
	 * @param s 
	 */
	public void setCustType(String s) {
		custType = s;
	}
	
	/**
	 * reset the default values
	 * <br><b>Known Bugs</b><br>
	 * <br><PRE>
	 * date Mar 24, 2004
	 * revision date author reason
	 * </PRE><br>
	 *
	 */
	
	public void reset(){
		soldToPartyID = null;	
		legNo = null;
		aSNO = null;
		custType = null;   

		if(null != dMDomainDTOList){
			for(int i=0; i<dMDomainDTOList.size(); i++){
				InventoryListRptDMDomainDTO dto = (InventoryListRptDMDomainDTO)dMDomainDTOList.get(i);
				dto.reset();
			}
			dMDomainDTOList.clear();
			dMDomainDTOList = null;
		}
		if(null != ssdmDomainTO){
			for(int i=0; i<ssdmDomainTO.size(); i++){
				InventoryListRptDMDomainDTO dto = (InventoryListRptDMDomainDTO)ssdmDomainTO.get(i);
				dto.reset();
			}
			ssdmDomainTO.clear();
			ssdmDomainTO= null;
		}
	}

	/**
	 * finalize
	 * <br><PRE>
	 * date Mar 24, 2004
	 * revision date author reason
	 * </PRE><br>
	 *
	 */
/*	public void finalize(){
		soldToPartyID = null;	
		legNo = null;
		aSNO = null;
		custType = null;   

		if(null != dMDomainDTOList){
			for(int i=0; i<dMDomainDTOList.size(); i++){
				InventoryListRptDMDomainDTO dto = (InventoryListRptDMDomainDTO)dMDomainDTOList.get(i);
				// dto.reset();
				dto = null;
			}
			dMDomainDTOList.clear();
			dMDomainDTOList = null;
		}
		if(null != ssdmDomainTO){
			for(int i=0; i<ssdmDomainTO.size(); i++){
				InventoryListRptDMDomainDTO dto = (InventoryListRptDMDomainDTO)ssdmDomainTO.get(i);
				// dto.reset();
				dto = null;
			}
			ssdmDomainTO.clear();
			ssdmDomainTO= null;
		}
	}*/
}