/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;


import java.util.TreeMap;

/**
 * Custom dto that holds data for creating a group  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 28, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CreateGroupCustomDTO extends OPPTCustomDTO 
{
   private String groupName = null;
   private TreeMap salesAreas = null;
   private String selectedSalesArea = null;

   /**
	* Returns group name 
	* 
	* <br><b>Known Bugs</b><br> 
	* 
	* <br><PRE> 
	* date Nov 28, 2003 
	* 
	* revision date author reason 
	* 
	* </PRE><br> 
	* 
	* @return String
	*/
   public String getGroupName() {
	   return groupName;
   }

   /**
	* Returns collection of sales area and sales area description map collection 
	* 
	* <br><PRE> 
	* date Nov 28, 2003 
	* 
	* revision date author reason 
	* 
	* </PRE><br> 
	* 
	* @return HashMap
	*/
   public TreeMap getSalesAreas() {
	   return salesAreas;
   }

   /**
	* Returns selected sales area 
	* 
	* <br><b>Known Bugs</b><br> 
	* 
	* <br><PRE> 
	* date Nov 28, 2003 
	* 
	* revision date author reason 
	* 
	* </PRE><br> 
	* 
	* @return String
	*/
   public String getSelectedSalesArea() {
	   return selectedSalesArea;
   }

   /**
	* Sets group name 
	* 
	* <br><b>Known Bugs</b><br> 
	* 
	* <br><PRE> 
	* date Nov 28, 2003 
	* 
	* revision date author reason 
	* 
	* </PRE><br> 
	* 
	* @param newGroupName 
	*/
   public void setGroupName(String newGroupName) {
	   groupName = newGroupName;
   }

   /**
	* Sets sales area collection 
	* 
	* <br><b>Known Bugs</b><br> 
	* 
	* <br><PRE> 
	* date Nov 28, 2003 
	* 
	* revision date author reason 
	* 
	* </PRE><br> 
	* 
	* @param newSalesAreas 
	*/
   public void setSalesAreas(TreeMap newSalesAreas) {
	   salesAreas = newSalesAreas;
   }

   /**
	* Sets selected sales area value 
	* 
	* <br><b>Known Bugs</b><br> 
	* 
	* <br><PRE> 
	* date Nov 28, 2003 
	* 
	* revision date author reason 
	* 
	* </PRE><br> 
	* 
	* @param newSelectedSalesArea 
	*/
   public void setSelectedSalesArea(String newSelectedSalesArea) {
	   selectedSalesArea = newSelectedSalesArea;
   }

   /**
	* Adds new sales area and description map to the collection of already existing maps.  
	* 
	* <br><b>Known Bugs</b><br> 
	* 
	* <br><PRE> 
	* date Nov 28, 2003 
	* 
	* revision date author reason 
	* 
	* </PRE><br> 
	* 
	* @param id String
	* @param description 
	*/
   public void addSalesArea(String id, String description){
	   if(null != id && null != description){
		   if(null == salesAreas){
			   salesAreas = new TreeMap();
		   }
		   salesAreas.put(id, description);
	   }
   }
	
   /**
	* Sets complete data in a single method call  
	* 
	* <br><b>Known Bugs</b><br> 
	* 
	* <br><PRE> 
	* date Nov 28, 2003 
	* 
	* revision date author reason 
	* 
	* </PRE><br> 
	* 
	* @param isalesAreas 
	* @param iselectedSalesArea 
	* @param igroupName 
	* 	*/
   public void setData(TreeMap isalesAreas, String iselectedSalesArea, String igroupName){
	   setSalesAreas(isalesAreas);
	   setSelectedSalesArea(iselectedSalesArea);
	   setGroupName(igroupName);
   }
}
