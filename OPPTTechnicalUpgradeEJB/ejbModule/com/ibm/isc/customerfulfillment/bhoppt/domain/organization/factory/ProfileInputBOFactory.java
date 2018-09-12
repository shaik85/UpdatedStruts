/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory;

import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import javax.ejb.FinderException;
import javax.ejb.EJBException;
import javax.naming.NamingException;



import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BARoleBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ProfileInputBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.RoleBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.SalesOrgBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.UserTypeBDO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BARoleLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.UserTypeLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.RoleLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.RoleLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocalHome;


import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;

/** 
 * ProfileInputBOFactory class.  
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
public class ProfileInputBOFactory 
{
	/**
	 * For storing RoleLocalHome object
	 */
	private RoleLocalHome roleHome; 
	/**
	 * For storing RoleLocal object
	 */
	private RoleLocal roleLocal;
	/**
	 * For storing SalesOrgLocalHome object
	 */
	private SalesOrgLocalHome salesOrgHome; 
	/**
	 * For storing SalesOrgLocal object
	 */
	private SalesOrgLocal salesOrgLocal;
	
	/**
	 * For storing UserTypeLocalHome object
     */
	private UserTypeLocalHome userTypeHome; 

	/**
	 * For storing UserTypeLocal object
	 */
	private UserTypeLocal userTypeLocal;

	/**
	 * For storing BARoleLocalHome object
	 */
	private BARoleLocalHome baRoleHome;

	/**
	 * For storing BARoleLocal object
	 */
	private BARoleLocal baRoleLocal;
	
	/**
	 * For storing Role Collection object
	 */
	private Collection roleCollection;
	/**
	 * For storing SalesOrg Collection object
	 */
	private Collection salesOrgCollection;

	/**
	 * For storing UserType Collection object
	 */	
	private Collection userTypeCollection;

	/**
	 * For storing BaRole Collection object
	 */	
	private Collection baRoleCollection;
		
	/**
	 * For storing Role List object
	 */
	private List roleList;
	/**
	 * For storing SalesOrg List object
	 */
	private List salesOrgList;
	
	/**
	 * For storing UserType List object
	 */	
	private List userTypeList;

	/**
	 * For storing BaRole List object
	 */	
	private List baRoleList;
	/**
	 * For storing Role Iterator object
	 */
	private Iterator roleIterator;
	/**
	 * For storing SalesOrg Iterator object
	 */
	private Iterator salesOrgIterator;
	
	/**
	 * For storing UserType Iterator object
	 */	
	private Iterator userTypeIterator;
	
	/**
	 * For storing BaRole Iterator object
	 */	
	private Iterator baRoleIterator;
	/**
	 * For storing ProfileInputBO object
	 */
	private ProfileInputBO profileInput;
	/**
	 * For storing SalesOrgBDO object
	 */
	private SalesOrgBDO salesOrgBDO;
	/**
	 * For storing RoleBDO object
	 */
	private RoleBDO roleBDO;
	
	/**
	 * For storing UserTypeBDO object
	 */	
	private UserTypeBDO userTypeBDO;
	/**
	 * For storing BARoleBDO object
	 */
	private BARoleBDO baRoleBDO;
	/** 
	 * ProfileInputBOFactory constructor 
	 * This class creates a object of ProfileInputBO
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
	public ProfileInputBOFactory()
	{
		profileInput = new ProfileInputBO();
	}
	/** 
	 * getProfileInputBO() method gets all the SalesOrgs and all the Roles 
	 * The method returns a ProfileInputBO object.
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
	 * @return  ProfileInputBO
	 * @param   
	 * @throws  DomainException
	 */
	public ProfileInputBO getProfileInputBO() throws DomainException
	{		
		
		roleHome = (RoleLocalHome)HomeProvider.getLocal(HomeProvider.ROLE_LOCAL_HOME);
		salesOrgHome = (SalesOrgLocalHome)HomeProvider.getLocal(HomeProvider.SALES_ORG_LOCAL_HOME);
		userTypeHome = (UserTypeLocalHome)HomeProvider.getLocal(HomeProvider.USER_TYPE_LOCAL_HOME);
		baRoleHome = (BARoleLocalHome)HomeProvider.getLocal(HomeProvider.BA_ROLE_LOCAL_HOME);
		
		try
		{	
			roleCollection = roleHome.findAllRoles();
			salesOrgCollection = salesOrgHome.findAllSalesOrg();
			userTypeCollection = userTypeHome.findAllUserTypes();
			baRoleCollection = baRoleHome.findAllBARoles();
			
		}
		catch(FinderException ex)
		{
				throw new DomainException();
		}
		
		roleIterator = roleCollection.iterator();
		roleList = new ArrayList();
		while(roleIterator.hasNext())
		{
			roleLocal = (RoleLocal)roleIterator.next();
			roleBDO = new RoleBDO();
//			 This condition is added for the change DAD O11 Remove approval step,Blue Harmony -by Ramesh Gandi
			if(roleLocal.getActive()!= null && ""!=roleLocal.getActive() && "Y".equalsIgnoreCase(roleLocal.getActive())) //Added ramesh Gandi
			{
			roleBDO.setRoleDescription(roleLocal.getRoleDesc());
			roleBDO.setRole(roleLocal.getRole());
			roleList.add(roleBDO);
			}
		}
			
		profileInput.setRoleList(roleList);
		
		salesOrgIterator = salesOrgCollection.iterator();
		salesOrgList = new ArrayList();
		while(salesOrgIterator.hasNext())
		{
			salesOrgLocal = (SalesOrgLocal)salesOrgIterator.next();
			salesOrgBDO = new SalesOrgBDO();
			salesOrgBDO.setSalesOrg(OPPTHelper.trimString(salesOrgLocal.getSalesOrg()));
			salesOrgBDO.setDefaultCurrncy(salesOrgLocal.getDefaultCurrency());			
			salesOrgBDO.setSalesOrgDesc(OPPTHelper.trimString(salesOrgLocal.getSalesOrgDesc()));
			salesOrgList.add(salesOrgBDO);
		}
		profileInput.setSalesOrgList(salesOrgList);	
		
		userTypeIterator = userTypeCollection.iterator();
		userTypeList = new ArrayList();
		while(userTypeIterator.hasNext())
		{
			userTypeLocal = (UserTypeLocal)userTypeIterator.next();
			userTypeBDO = new UserTypeBDO();
			userTypeBDO.setUserType(userTypeLocal.getUserType());
			userTypeBDO.setUserTypeDescription(userTypeLocal.getUserTypeDescription());
			userTypeList.add(userTypeBDO);
		}
		profileInput.setUserTypeList(userTypeList);
		
		baRoleIterator = baRoleCollection.iterator();
		baRoleList = new ArrayList();
		while(baRoleIterator.hasNext())
		{
			baRoleLocal = (BARoleLocal)baRoleIterator.next();
			baRoleBDO = new BARoleBDO();
			baRoleBDO.setRole(baRoleLocal.getBaseAgreementRole());
			baRoleBDO.setRoleDescription(baRoleLocal.getBaseAgreementRoleDescription());
			baRoleList.add(baRoleBDO);
		}
		profileInput.setBaRoleList(baRoleList); 		
		return profileInput;
	}
	/** 
	 * getSalesOrg() method gets all the SalesOrgs 
	 * The method returns a ProfileInputBO object 
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
	 * @return  SalesOrgBDO
 	 * @param   
	 * @throws  DomainException
	 */	
	 public ProfileInputBO getSalesOrg() throws DomainException
	 {
		salesOrgHome = (SalesOrgLocalHome)HomeProvider.getLocal(HomeProvider.SALES_ORG_LOCAL_HOME);		
		try
		{
			salesOrgCollection = salesOrgHome.findAllSalesOrg();
		}
		catch(FinderException ex)
		{
				throw new DomainException();
		}

		salesOrgIterator = salesOrgCollection.iterator();
		salesOrgList = new ArrayList();

		while(salesOrgIterator.hasNext())
		{
			salesOrgLocal = (SalesOrgLocal)salesOrgIterator.next();
			salesOrgBDO = new SalesOrgBDO();
			salesOrgBDO.setSalesOrg(OPPTHelper.trimString(salesOrgLocal.getSalesOrg()));
			salesOrgBDO.setDefaultCurrncy(salesOrgLocal.getDefaultCurrency());			
			salesOrgBDO.setSalesOrgDesc(OPPTHelper.trimString(salesOrgLocal.getSalesOrgDesc()));
			salesOrgList.add(salesOrgBDO);
		}
		profileInput.setSalesOrgList(salesOrgList);		
		return profileInput;
	 }
}
