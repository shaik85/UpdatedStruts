/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dm.factory;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dm.bo.DMBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;


/** 
 * This factory class returns the DM Business object based on the input values 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar J
 * @version 5.1A 
 */


public class DMBOFactory
{
    /**DM_TABLE 
     */
	public static final int DM_TABLE = 1;
	/**HISTORY_DM_TABLE 
     */
	public static final int HISTORY_DM_TABLE=2;
	/**VARIANCE_DM_TABLE 
     */
	public static final int VARIANCE_DM_TABLE =3;
	/**VARIANCE_DM_LOCAL_HOME 
     */	
	private static final String VARIANCE_DM_LOCAL_HOME = "VarianceDMLocalHome";
	/**CLASS_NAME 
     */
	private static final String CLASS_NAME="DMBOFactory";

	/**
	 *  
	 * This method finds DMBO for the particular DMNumber 
	 * DMNo should be unique for the particular Customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmNo
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public List findDMBOForDMNo(String dmNo, int proposalId,int customerId, int table) throws DomainException
	{
		DMLocalHome dmLocalHome = null;
		DMLocal dmLocal = null;
		VarianceDMLocalHome varianceDMLocalHome = null;
		VarianceDMLocal varianceDMLocal = null;
			
		Collection dmLocalList = null;

		List dmBOList = null;
		if (table != 0 && table==DM_TABLE)
		{
			dmLocalHome = getDMLocalHome();
			try
			{
				dmLocalList = dmLocalHome.findByDMNo(dmNo, proposalId,customerId);
			}
			catch (FinderException e)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findDMBOForDMNo",null,e);
			}
			Iterator iterate = dmLocalList.iterator();
			dmBOList = new ArrayList();
			while (iterate.hasNext())
			{
				dmLocal = (DMLocal) iterate.next();
				dmBOList.add(getDMBOForLocal(dmLocal));
			}
		}else	if (VARIANCE_DM_TABLE==table)
		{
			varianceDMLocalHome = getVarianceDMLocalHome();
			try
			{
				dmLocalList = varianceDMLocalHome.findByDMNo(dmNo, proposalId,customerId);
			}
			catch (FinderException e)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findDMBOForDMNo",null,e);
			}
			Iterator iterate = dmLocalList.iterator();
			dmBOList = new ArrayList();
			while (iterate.hasNext())
			{
				varianceDMLocal = (VarianceDMLocal) iterate.next();
				dmBOList.add(getDMBOForLocal(varianceDMLocal));
			}
		}
		return dmBOList;
	}

	/**
	 *  
	 * This factory method returns DM BO object based on the Primary Key object 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @param customerId
	 * @param dmId
	 * @param table
	 * @return DMBO
	 * @throws DomainException
	 * @author Ravishankar
	 */	
	public DMBO getDMBO(int proposalId,int customerId,int dmId,int table)throws DomainException{ 
		DMLocalHome dmLocalHome = null;
		DMLocal dmLocal = null;
		VarianceDMLocalHome varianceDMLocalHome = null;
		VarianceDMLocal varianceDMLocal = null;
		VarianceDMKey varianceDMKey = null;
		HistoryDMLocal historyDMLocal=null;
		HistoryDMLocalHome historyDMLocalHome=null;
		HistoryDMKey historyDMKey=null;
		DMKey dmKey=null;
		DMBO dmBO=null;
			if (table != 0 && table==DM_TABLE){
					dmLocalHome = getDMLocalHome();
					dmKey=new DMKey(dmId,customerId,proposalId);
				try{
					dmLocal=dmLocalHome.findByPrimaryKey(dmKey);
					dmBO=getDMBOForLocal(dmLocal);
				}catch(FinderException f){
					OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getDMBO",null,f);
					throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
				}
			}else if(VARIANCE_DM_TABLE == table){
				varianceDMLocalHome = getVarianceDMLocalHome();
				varianceDMKey=new VarianceDMKey(dmId,customerId,proposalId);
				try{
					varianceDMLocal = varianceDMLocalHome.findByPrimaryKey(varianceDMKey);
					dmBO=getDMBOForLocal(varianceDMLocal);
				}catch(FinderException f){
					OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getDMBO",null,f);
					throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
				}
			}else if(HISTORY_DM_TABLE == table){
				historyDMLocalHome = getHistoryDMLocalHome();
				historyDMKey=new HistoryDMKey(dmId,customerId,proposalId);
				try{
					historyDMLocal = historyDMLocalHome.findByPrimaryKey(historyDMKey);
					dmBO=getDMBOForLocal(historyDMLocal);
				}catch(FinderException f){
					//OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getDMBO",null,f);
					throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
				}
					
			}
	 return dmBO;
	}

	/** 
	 * This method populates DMBO from DMLocal
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmLocal
	 * @return 
	 */
	private DMBO getDMBOForLocal(DMLocal dmLocal)
	{
		DMBO dmBO = new DMBO();
		dmBO.setDmId(dmLocal.getDmId());
		dmBO.setCustomerId(dmLocal.getCustomerId());
		dmBO.setProposalId(dmLocal.getProposalId());
		dmBO.setDmAddedDate(dmLocal.getDmAddedDate());
		dmBO.setDmCopyIncrNo(dmLocal.getDmCopyIncrNo());
		dmBO.setDmDesc(dmLocal.getDmDesc());
		dmBO.setDmNo(dmLocal.getDmNo());
		dmBO.setExclusionID(dmLocal.getExclusionID());
		dmBO.setLastUpdatedDate(dmLocal.getLastUpdatedDate());
		dmBO.setPlanEndDate(dmLocal.getPlanEndDate());
		dmBO.setPlannedInd(dmLocal.getPlannedInd());
		dmBO.setPlanStartDate(dmLocal.getPlanStartDate());

		return dmBO;
	}
	
	/** 
	 * This method populates DMBO from DMLocal
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmLocal
	 * @return 
	 */
	private DMBO getDMBOForLocal(HistoryDMLocal dmLocal)
	{
		DMBO dmBO = new DMBO();
		dmBO.setDmId(dmLocal.getDmId());
		dmBO.setCustomerId(dmLocal.getCustomerId());
		dmBO.setProposalId(dmLocal.getProposalId());
		dmBO.setDmAddedDate(dmLocal.getDmAddedDate());
		dmBO.setDmDesc(dmLocal.getDmDesc());
		dmBO.setDmNo(dmLocal.getDmNo());
		dmBO.setLastUpdatedDate(dmLocal.getLastUpdatedDate());
		dmBO.setPlanEndDate(dmLocal.getPlanEndDate());
		dmBO.setPlannedInd(dmLocal.getPlannedInd());
		dmBO.setPlanStartDate(dmLocal.getPlanStartDate());

		return dmBO;
	}

		/** This method sets the DMBO using varianceDMLocal
		 * 
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Dec 17, 2003 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param dmLocal
		 * @return 
		 */
		
		private DMBO getDMBOForLocal(VarianceDMLocal varianceDMLocal)
		{
			DMBO dmBO = new DMBO();
			dmBO.setDmNo(varianceDMLocal.getDmNo());
			dmBO.setDmDesc(varianceDMLocal.getDmDesc());
			dmBO.setDmId(varianceDMLocal.getDmId());
			dmBO.setCustomerId(varianceDMLocal.getCustomerId());
			dmBO.setProposalId(varianceDMLocal.getProposalId());
			return dmBO;
			
		}
	
	
	/**
	 *  
	 * This method Lists the DMBO for the Customer 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @param customerId
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	

	public List findDMBOForCustomer(int proposalId, int customerId, int table) throws DomainException
	{
		DMLocalHome dmLocalHome = null;
		DMLocal dmLocal = null;
		
		VarianceDMLocalHome varianceDMLocalHome = null;
		VarianceDMLocal varianceDMLocal = null;
		
		Collection dmLocalList = null;
		List dmBOList = null;
		if (table != 0 && table==DM_TABLE)
		{
			dmLocalHome = getDMLocalHome();
			try
			{
				dmLocalList = dmLocalHome.findByCustomer(customerId, proposalId);
			}
			catch (FinderException e)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findDMBOForCustomer",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterate = dmLocalList.iterator();
			dmBOList = new ArrayList();

			while (iterate.hasNext())
			{
				dmLocal = (DMLocal) iterate.next();

				dmBOList.add(getDMBOForLocal(dmLocal));
			}
		}
		if(table == VARIANCE_DM_TABLE) {
			varianceDMLocalHome = getVarianceDMLocalHome();
			try
			{
				dmLocalList = varianceDMLocalHome.findByCustomer(proposalId,customerId);
			}
			catch (FinderException e)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findDMBOForCustomer",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterate = dmLocalList.iterator();
			dmBOList = new ArrayList();

			while (iterate.hasNext())
			{
				varianceDMLocal = (VarianceDMLocal) iterate.next();

				dmBOList.add(getDMBOForLocal(varianceDMLocal));
			}
			
		}
		return dmBOList;
	}

	/**
	 * This method creates the DM entity with record 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmBO
	 * @param table
	 * @throws DomainException
	 */
	public void createDMBO(DMBO dmBO, int table) throws DomainException
	{
		DMLocalHome dmLocalHome = null;
		DMLocal dmLocal = null;
		VarianceDMLocalHome varianceDMLocalHome = null;
		VarianceDMLocal varianceDMLocal = null;
		HistoryDMLocal historyDMLocal=null;
		HistoryDMLocalHome historyDMLocalHome=null;
		
		int maxDMId = 0;
		if (table != 0 && table==DM_TABLE)
		{
			dmLocalHome = getDMLocalHome();
			try
			{
				dmLocal =
					dmLocalHome.create(dmBO.getDmId(), dmBO.getCustomerId(), dmBO.getProposalId(), dmBO.getDmNo());
			}
			catch (CreateException c)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"createDMBO",null,c);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(dmLocal, dmBO);
		}
		
		else if (0!= table  && VARIANCE_DM_TABLE==table)
				{
					varianceDMLocalHome = getVarianceDMLocalHome();
					try
					{
						varianceDMLocal =
						varianceDMLocalHome.create(dmBO.getDmId(), dmBO.getCustomerId(), dmBO.getProposalId(),dmBO.getDmNo());
					}
					catch (CreateException c)
					{
						OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"createDMBO",null,c);
						throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
					}

					populateLocalWithBO(varianceDMLocal, dmBO);
				}
		else if (table != 0 && table==HISTORY_DM_TABLE)
		{
			historyDMLocalHome = getHistoryDMLocalHome();
			try
			{
				historyDMLocal =historyDMLocalHome.create(dmBO.getDmId(), dmBO.getCustomerId(), dmBO.getProposalId(),dmBO.getDmNo(),dmBO.getLastUpdatedDate());
			}
			catch (CreateException c)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"createDMBO",null,c);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(historyDMLocal, dmBO);
		}
		
		
				
	}

	/** 
	 * This method sets values for Local object from BO 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmLocal
	 * @param dmBO 
	 */
	private void populateLocalWithBO(DMLocal dmLocal, DMBO dmBO)
	{
		dmLocal.setDmAddedDate(dmBO.getDmAddedDate());
		dmLocal.setDmCopyIncrNo(dmBO.getDmCopyIncrNo());
		dmLocal.setDmDesc(OPPTHelper.trimStringToNull(dmBO.getDmDesc()));
		dmLocal.setExclusionID(OPPTHelper.trimStringToNull(dmBO.getExclusionID()));
		dmLocal.setLastUpdatedDate(dmBO.getLastUpdatedDate());
		dmLocal.setPlanEndDate(dmBO.getPlanEndDate());
		dmLocal.setPlannedInd(OPPTHelper.trimStringToNull(dmBO.getPlannedInd()));
		dmLocal.setPlanStartDate(dmBO.getPlanStartDate());
	}
	
	/** 
	 * This method is used to Populate Variance Local DM with DMBO
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param varianceDMLocal
	 * @param dmBO
	 * @author Venkat 
	 */
	private void populateLocalWithBO(VarianceDMLocal varianceDMLocal, DMBO dmBO)
	{
		
		varianceDMLocal.setDmNo(OPPTHelper.trimStringToNull(dmBO.getDmNo()));
		varianceDMLocal.setDmDesc(OPPTHelper.trimStringToNull(dmBO.getDmDesc()));
		varianceDMLocal.setDmId(dmBO.getDmId());
		varianceDMLocal.setCustomerId(dmBO.getCustomerId());
		varianceDMLocal.setProposalId(dmBO.getProposalId());
			
	}
	
	/**
	 *  
	 * This method is used to Populate History Local DM with DMBO 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param HistoryDMLocal
	 * @param dmBO
	 */
	private void populateLocalWithBO(HistoryDMLocal historyDMLocal , DMBO dmBO)
	{
			
			historyDMLocal.setDmDesc(OPPTHelper.trimStringToNull(dmBO.getDmDesc()));
			historyDMLocal.setDmAddedDate(dmBO.getDmAddedDate());
			historyDMLocal.setExclusionId(OPPTHelper.trimStringToNull(dmBO.getExclusionID()));
			historyDMLocal.setPlanEndDate(dmBO.getPlanEndDate());
			historyDMLocal.setPlannedInd(OPPTHelper.trimStringToNull(dmBO.getPlannedInd()));
			historyDMLocal.setPlanStartDate(dmBO.getPlanStartDate());
		
	}


	/**
	 *  
	 * This method updates dm data
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmBO
	 * @param table
	 * @throws DomainException
	 */
	public void updateDMBO(DMBO dmBO, int table) throws DomainException
	{
		DMLocalHome dmLocalHome = null;
		DMLocal dmLocal = null;
		DMKey dmKey = null;
		if (table != 0 && table==DM_TABLE)
		{
			dmLocalHome = getDMLocalHome();
			dmKey = new DMKey(dmBO.getDmId(), dmBO.getCustomerId(), dmBO.getProposalId());
			try
			{
				dmLocal = dmLocalHome.findByPrimaryKey(dmKey);
			}
			catch (FinderException e)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"updateDMBO",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(dmLocal, dmBO);
		}
	}

	/**
	 *  
	 * This method returns the max DM BO from table  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 6, 2003 
	 * 
	 *	Dec 22 Venkat Variance DM info 
	 * 
	 * </PRE><br> 
	 * 
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public DMBO findMaxDMBO(int table) throws DomainException
	{
		DMLocalHome dmLocalHome = null;
		DMLocal dmLocal = null;
		VarianceDMLocalHome varianceDMLocalHome = null;
		VarianceDMLocal varianceDMLocal = null;
		Collection dmLocalCollection = null;
		
		DMBO dmBO = null;
		if (table != 0 && table==DM_TABLE)
		{
			dmLocalHome = getDMLocalHome();
			try
			{
				dmLocalCollection = dmLocalHome.findMaxDMId();
				Iterator iterateDMLocal = dmLocalCollection.iterator();
				while (iterateDMLocal.hasNext())
				{
					dmLocal = (DMLocal) iterateDMLocal.next();
				}
			 	
			}
			catch (FinderException e)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findMaxDMBO",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if(dmLocal!=null){
				dmBO = getDMBOForLocal(dmLocal);
			}else{
				dmBO=new DMBO();
				dmBO.setDmId(0);	
			}
			
		}
		
		
		else if (0 != table && VARIANCE_DM_TABLE==table)
				{
					varianceDMLocalHome = getVarianceDMLocalHome();
					try
					{
						dmLocalCollection = varianceDMLocalHome.findMaxVarianceDMId();
						Iterator iterateDMLocal = dmLocalCollection.iterator();
						while (iterateDMLocal.hasNext())
						{
							varianceDMLocal = (VarianceDMLocal) iterateDMLocal.next();
						}
					}
					catch (FinderException e)
					{
						OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findMaxDMBO",null,e);
						throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
					}
					if(varianceDMLocal!=null){
						dmBO = getDMBOForLocal(varianceDMLocal);	
					}else{
						dmBO=new DMBO();
						dmBO.setDmId(0);
					}
					
				}
		
		return dmBO;
	}
	
	/**
	 *  
	 * This method deletes the DM details record  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	
	public void deleteDMBO(DMBO dmBO,int table)throws DomainException{
		DMLocalHome dmLocalHome = null;
		DMLocal dmLocal = null;
		DMKey dmKey=null;
		
		if (table != 0 && table==DM_TABLE){
	
			 dmLocalHome = getDMLocalHome();
			 dmKey=new DMKey(dmBO.getDmId(),dmBO.getCustomerId(),dmBO.getProposalId());
			
				try{ 
					 dmLocalHome.remove(dmKey);
				   
				   }catch(RemoveException re){
					
					OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"deleteDMBO",null,re);
					throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);				   	 
				   
				   }
						
			}
	}
	

	/**
	 *  
	 * This method returns DMLocalHome 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	private DMLocalHome getDMLocalHome()
	{
		return (DMLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome("DMLocalHome");
	}
	
	/**
	 *  
	 * This method returns HistoryDMLocalHome 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	private HistoryDMLocalHome getHistoryDMLocalHome()
	{
		return (HistoryDMLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome("HistoryDMLocalHome");
	}

	
	/**
	 *  
	 * This method is used to get the Variance DM Local Home
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return VarianceDMLocalHome
	 * @author Venkat
	 */
	private VarianceDMLocalHome getVarianceDMLocalHome()
		{
			return (VarianceDMLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(VARIANCE_DM_LOCAL_HOME);
		}

	/** 
	 * Deletes the DMs stored in the temporary variance table
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @throws DomainException 
	 */
	public void deleteVarianceDM(int proposalID) throws DomainException{
		VarianceDMLocalHome dmLocalHome = null;
		VarianceDMLocal dmLocal = null;
		Collection machines = null;
		
		try{
			dmLocalHome = getVarianceDMLocalHome();
			machines = dmLocalHome.findByProposal(proposalID);
			if(machines != null && machines.size() > 0){
				Iterator iterate = machines.iterator();
				while(iterate.hasNext()){
					dmLocal = (VarianceDMLocal)iterate.next();
					dmLocal.getEJBLocalHome().remove(dmLocal.getPrimaryKey());
				}
			}else{
				return;
			}
		}catch(FinderException e){
			//The variance inventory details might not be present
			return;
		}catch(Exception e){
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION,OPPTLogger.ERROR,"DMBOFactory","deleteVarianceDM",null,e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}
}