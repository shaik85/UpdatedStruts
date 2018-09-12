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

public class InventoryListRptDMDomainDTO extends OPPTDomainDTO
{
   private String soldToPartyID = null;	
   private String desgMcID = null;		
   private String desgMcNo = null;
   private double totalCalculatedPrice ;
   private List sWODomainDTOList = null;
   private double totalListPrice;
   private List sSSWODomainDTOList = null;   
   
   /** 
    * constructor
    * <br><b>Known Bugs</b><br> 
    * 
    * <br><PRE> 
    * date Nov 22, 2003 
    * 
    * revision date author reason 
    * 
    * </PRE><br> 
    * 
    
    */
   public InventoryListRptDMDomainDTO() 
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
public String getDesgMcNo() {
	return desgMcNo;
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
public List getSWODomainDTOList() {
	return sWODomainDTOList;
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
public List getSSSWODomainDTOList() {
	return sSSWODomainDTOList;
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
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param string 
 */
public void setDesgMcNo(String string) {
	desgMcNo = string;
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
public void setSWODomainDTOList(List list) {
	sWODomainDTOList = list;
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
public void setSSSWODomainDTOList(List list) {
	sSSWODomainDTOList = list;
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
 * date Mar 19, 2004 
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
public String getDesgMcID() {
	return desgMcID;
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
public void setDesgMcID(String string) {
	desgMcID = string;
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
 * <br><b>Known Bugs</b><br>
 * <br><PRE>
 * date Jan 5, 2004
 * revision date author reason
 * </PRE><br>
 *
 * @param swoDomainDTOList 
 */
public void addSWODomainDTOList(List swoDomainDTOList)
{
	if(null != swoDomainDTOList)
	{
		if(null == sWODomainDTOList)
		{
			sWODomainDTOList = new ArrayList();
		}
		sWODomainDTOList.add(swoDomainDTOList);
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
 * @param ssSWODomainDTOList 
 */
public void addSSSWODomainDTOList(List ssSWODomainDTOList)
{
	if(null != ssSWODomainDTOList)
	{
		if(null == sSSWODomainDTOList)
		{
			sSSWODomainDTOList = new ArrayList();
		}
		sSSWODomainDTOList.add(ssSWODomainDTOList);
	}
}

/**
 *reset the values
 *  * - preconditions that this method relies on
 * <br><b>Known Bugs</b><br>
 * <br><PRE>
 * date Mar 24, 2004
 * revision date author reason
 * </PRE><br>
 *
 */
	public void reset(){
		soldToPartyID = null;	
		desgMcID = null;		
		desgMcNo = null;

		if(null != sWODomainDTOList){
			for(int i=0; i<sWODomainDTOList.size(); i++){
				InventoryListRptSWODomainDTO dto = (InventoryListRptSWODomainDTO)sWODomainDTOList.get(i);
				dto.reset();
			}
			sWODomainDTOList.clear();
			sWODomainDTOList = null;
		}
		if(null != sSSWODomainDTOList){
			for(int i=0; i<sSSWODomainDTOList.size(); i++){
				InventoryListRptSWODomainDTO dto = (InventoryListRptSWODomainDTO)sSSWODomainDTOList.get(i);
				dto.reset();
			}
			sSSWODomainDTOList.clear();
			sSSWODomainDTOList = null;
		}
	}

	/**
	 *finalization
	 ** - preconditions that this method relies on
	 * <br><b>Known Bugs</b><br>
	 * <br><PRE>
	 * date Mar 24, 2004
	 * revision date author reason
	 * </PRE><br>
	 * @throws Throwable
	 *
	  
	 */
/*	public void finalize() throws Throwable{
		super.finalize();
        soldToPartyID = null;	
		desgMcID = null;		
		desgMcNo = null;

		if(null != sWODomainDTOList){
			for(int i=0; i<sWODomainDTOList.size(); i++){
				InventoryListRptSWODomainDTO dto = (InventoryListRptSWODomainDTO)sWODomainDTOList.get(i);
				// dto.reset();
				dto = null;
			}
			sWODomainDTOList.clear();
			sWODomainDTOList = null;
		}
		if(null != sSSWODomainDTOList){
			for(int i=0; i<sSSWODomainDTOList.size(); i++){
				InventoryListRptSWODomainDTO dto = (InventoryListRptSWODomainDTO)sSSWODomainDTOList.get(i);
				// dto.reset();
				dto = null;
			}
			sSSWODomainDTOList.clear();
			sSSWODomainDTOList = null;
		}
	}*/
}
