/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.GroupBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GroupLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/** 
 * GroupBOFactory class. 
 * This class will create & consume Business Objects
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class GroupBOFactory
{	
	private GroupLocalHome groupHome = null;	
	private GroupLocal groupLocal = null;
	private GroupBO groupBO;
	
	private Collection groupCollection;
	private Iterator groupIterator;	
	private List groupList; 
	/** 
	 * GeoSecOffBOFactory constructor
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  
	 */	
	public GroupBOFactory()
	{
		groupBO = new GroupBO(); 
	}
	/** 
	 * Enter one sentence as a brief description for your class. 
	 * You can enter more text here (e.g. describe the purpose of the class here). 
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  
	 */	
	public void getGroupBO()throws DomainException
	{
			
	}
	/** 
	 * This method finds groups for sales Org provided
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  ArrayList
	 * @param   salesOrg
	 * @throws  DomainException
	 */	
	public ArrayList findGroupBOForSalesOrg(String salesOrg) throws DomainException
	{
		ArrayList groupBOList = new ArrayList();
		groupHome = (GroupLocalHome)HomeProvider.getLocal(HomeProvider.GROUP_LOCAL_HOME);							
		try
		{
			groupCollection = groupHome.findBySalesOrg(salesOrg);
		}
		catch(FinderException ex)
		{
			throw new DomainException();			
		}		
		groupIterator = groupCollection.iterator();
		
		while(groupIterator.hasNext())
		{
			groupLocal=(GroupLocal)groupIterator.next();
			groupBO = new GroupBO();
			groupBO.setGroupName(OPPTHelper.trimString(groupLocal.getGroupName()));
			groupBO.setSalesOrg(OPPTHelper.trimString(groupLocal.getSalesOrg()));			
			groupBOList.add(groupBO);
		}		
		return groupBOList;
	}
	/** 
	 * This method checks whether the GroupName already exists or not	  
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  boolean
	 * @param   groupName,salesOrg
	 * @throws  DomainException
	 */	
	public boolean isGroupNameExistsForSalesOrg(String groupName,String salesOrg)throws DomainException
	{
		boolean groupNameExists = true;		
		groupHome = (GroupLocalHome)HomeProvider.getLocal(HomeProvider.GROUP_LOCAL_HOME);								
		try
		{			
			groupLocal = groupHome.findByGroupName(groupName);
		}
		catch(FinderException ex)
		{
			groupNameExists = false;
		}
		
		if(groupLocal==null)
		{
			groupNameExists = false;			
		}
		return groupNameExists; 	
	}
	/** 
	 * This method will create a Group	  
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  void
	 * @param   groupBO
	 * @throws  DomainException
	 */	
	public void createGroupBO(GroupBO groupBO) throws DomainException
	{
		groupHome = (GroupLocalHome)HomeProvider.getLocal(HomeProvider.GROUP_LOCAL_HOME);
		try
		{		
			groupLocal = groupHome.create(groupBO.getGroupName());
		}
		catch(CreateException ex)
		{
			throw new DomainException();					
		}
		groupLocal.setSalesOrg(groupBO.getSalesOrg());		
	}
	/** 
	 * This method will remove a Group
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  void
	 * @param   groupName
	 * @throws  DomainException
	 */	
	public void removeGroup(String groupName) throws DomainException
	{
		groupHome = (GroupLocalHome)HomeProvider.getLocal(HomeProvider.GROUP_LOCAL_HOME);		
		try
		{
			groupLocal = groupHome.findByPrimaryKey(groupName);
		}		
		catch(FinderException ex)
		{
			
			throw new DomainException();	
		} 
		try
		{			
			groupLocal.remove();			
		}
		catch(RemoveException ex)
		{	
			
			throw new DomainException();						
		}	
	}
	
	 /** This method finds out all the available groups 
	  *  
	  * <br/><b>Known Bugs</b><br/> 
	  * 
	  * <br/><PRE> 
	  * date Oct 28, 2006 
	  * 
	  * revision date author reason 
	  *
	  * </PRE><br> 
	  * 
	  * @return  ArrayList
	  * @throws  DomainException
	  */ 
	 
	public ArrayList findAllGroups() throws DomainException
	 {
	  ArrayList groupBOList = new ArrayList();
	  groupHome = (GroupLocalHome)HomeProvider.getLocal(HomeProvider.GROUP_LOCAL_HOME);       
	  try
	  {
	   groupCollection = groupHome.findAllGroup();
	  }
	  catch(FinderException ex)
	  {
	   throw new DomainException();   
	  }  
	  groupIterator = groupCollection.iterator();
	  
	  while(groupIterator.hasNext())
	  {
	   groupLocal=(GroupLocal)groupIterator.next();
	   groupBO = new GroupBO();
	   groupBO.setGroupName(OPPTHelper.trimString(groupLocal.getGroupName()));
	   groupBO.setSalesOrg(OPPTHelper.trimString(groupLocal.getSalesOrg()));   
	   groupBOList.add(groupBO);
	  }  
	  return groupBOList;
	 }

}
