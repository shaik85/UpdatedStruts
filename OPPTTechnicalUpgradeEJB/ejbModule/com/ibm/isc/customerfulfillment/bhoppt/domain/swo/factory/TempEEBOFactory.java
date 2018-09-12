/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.TempEEBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEELocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/** 
 * This class creates and finds the instances of TempEEBO class 
 * 
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
public class TempEEBOFactory {
	
	private static final String CLASS_NAME="TempEEBOFactory";
	
	/**
	 *  
	 * This method creates the tempeebo and
	 * inserts one record in tempee table 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @param customerId
	 * @param dmId
	 * @throws DomainException
	 */
	public void createTempEEBO(TempEEBO tempEEBO)throws DomainException{
		TempEELocal tempEELocal=null;
		try{
			tempEELocal=HomeProvider.getTempEELocal(tempEEBO.getProposalId(),tempEEBO.getCustomerId(),tempEEBO.getDmId());
			populateLocalWithBO(tempEELocal,tempEEBO);			
				
		}catch(CreateException c){
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"createTempEEBO",null,c);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);			
		}
		
	}
	
	/**
	 *  
	 * This method gets the TempEEBO 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public TempEEBO getTempEEBO(int proposalId,int customerId,int dmId)throws DomainException{
		TempEEBO tempEEBO=null;
		TempEELocal tempEELocal=null;
		TempEELocalHome tempEELocalHome=null;
		TempEEKey tempEEKey=null;
			try{
				tempEEKey=new TempEEKey(proposalId,customerId,dmId);
				tempEELocalHome=(TempEELocalHome)HomeProvider.getLocal(HomeProvider.TEMP_EE_LOCAL_HOME);
				tempEELocal=tempEELocalHome.findByPrimaryKey(tempEEKey);
				tempEEBO=new TempEEBO();
				populateBOWithLocal(tempEEBO,tempEELocal);				
					
			}catch(FinderException e){
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getTempEEBO",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);	
			}
	return tempEEBO;
	}
	
	/**
	 *  
	 * This method updates the TempEEBO 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tempEEBO
	 * @throws DomainException
	 */
	public void updateTempEEBO(TempEEBO tempEEBO)throws DomainException{
		TempEELocal tempEELocal=null;
		TempEELocalHome tempEELocalHome=null;
		TempEEKey tempEEKey=null;
			try{
				tempEEKey=new TempEEKey(tempEEBO.getProposalId(),tempEEBO.getCustomerId(),tempEEBO.getDmId());
				tempEELocalHome=(TempEELocalHome)HomeProvider.getLocal(HomeProvider.TEMP_EE_LOCAL_HOME);
				tempEELocal=tempEELocalHome.findByPrimaryKey(tempEEKey);
				populateLocalWithBO(tempEELocal,tempEEBO);				
			
			 }catch(FinderException e){
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"updateTempEEBO",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);			
			}
	
	}
	
	/**
	 *  
	 * This method removes the temp ee bean 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tempEEBO
	 * @throws DomainException
	 */
	public void deleteTempEEBO(TempEEBO tempEEBO)throws DomainException{
		TempEELocal tempEELocal=null;
		TempEELocalHome tempEELocalHome=null;
		TempEEKey tempEEKey=null;
			try{

				tempEEKey=new TempEEKey(tempEEBO.getProposalId(),tempEEBO.getCustomerId(),tempEEBO.getDmId());
				tempEELocalHome=(TempEELocalHome)HomeProvider.getLocal(HomeProvider.TEMP_EE_LOCAL_HOME);
				tempEELocalHome.remove(tempEEKey);

			}catch(RemoveException e){
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"deleteTempEEBO",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);			
			}	
	}
	
	/**
	 *  
	 * This method populate local with BOs 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tempEELocal
	 * @param tempEEBO
	 */
	private void populateLocalWithBO(TempEELocal tempEELocal,TempEEBO tempEEBO){ 
	
		tempEELocal.setSessionId(OPPTHelper.trimStringToNull(tempEEBO.getSessionId()));
		tempEELocal.setSwoId(tempEEBO.getSwoId());
		tempEELocal.setEeId(tempEEBO.getEeId());
		tempEELocal.setChargeOptionDesc(OPPTHelper.trimStringToNull(tempEEBO.getChargeOptionDesc()));
		tempEELocal.setCho(OPPTHelper.trimStringToNull(tempEEBO.getCho()));
		tempEELocal.setDefaultFlag(OPPTHelper.trimStringToNull(tempEEBO.getDefaultFlag()));
		tempEELocal.setEeItemNo(OPPTHelper.trimStringToNull(tempEEBO.getEeItemNo()));
		tempEELocal.setEeNo(OPPTHelper.trimStringToNull(tempEEBO.getEeNo()));
		tempEELocal.setLcs(OPPTHelper.trimStringToNull(tempEEBO.getLcs()));
		tempEELocal.setLicenseType(OPPTHelper.trimStringToNull(tempEEBO.getLicenseType()));
		tempEELocal.setSalesDocNo(OPPTHelper.trimStringToNull(tempEEBO.getSalesDocNo()));
		tempEELocal.setSwoItemNo(OPPTHelper.trimStringToNull(tempEEBO.getSwoItemNo()));
		tempEELocal.setUl(OPPTHelper.trimStringToNull(tempEEBO.getUl()));
		tempEELocal.setUseLevel(OPPTHelper.trimStringToNull(tempEEBO.getUseLevel()));
		tempEELocal.setValidInd(OPPTHelper.trimStringToNull(tempEEBO.getValidInd()));
		tempEELocal.setValueMetric(OPPTHelper.trimStringToNull(tempEEBO.getValueMetric()));
		tempEELocal.setValueMetricType(OPPTHelper.trimStringToNull(tempEEBO.getValueMetricType()));
		tempEELocal.setVm(OPPTHelper.trimStringToNull(tempEEBO.getVm()));
	
	}
	
	/**
	 *  
	 * This method populates the BO with Local 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tempEELocal
	 * @param tempEEBO
	 */
	private void populateBOWithLocal(TempEEBO tempEEBO,TempEELocal tempEELocal){
		
		tempEEBO.setSessionId(OPPTHelper.trimStringToNull(tempEELocal.getSessionId()));
		tempEEBO.setProposalId(tempEELocal.getProposalId());
		tempEEBO.setCustomerId(tempEELocal.getCustomerId());
		tempEEBO.setDmId(tempEELocal.getDmId());
		tempEEBO.setSwoId(tempEELocal.getSwoId());
		tempEEBO.setEeId(tempEELocal.getEeId());
		tempEEBO.setChargeOptionDesc(OPPTHelper.trimStringToNull(tempEELocal.getChargeOptionDesc()));
		tempEEBO.setCho(OPPTHelper.trimStringToNull(tempEELocal.getCho()));
		tempEEBO.setDefaultFlag(OPPTHelper.trimStringToNull(tempEELocal.getDefaultFlag()));
		tempEEBO.setEeItemNo(OPPTHelper.trimStringToNull(tempEELocal.getEeItemNo()));
		tempEEBO.setEeNo(OPPTHelper.trimStringToNull(tempEELocal.getEeNo()));
		tempEEBO.setLcs(OPPTHelper.trimStringToNull(tempEELocal.getLcs()));
		tempEEBO.setLicenseType(OPPTHelper.trimStringToNull(tempEELocal.getLicenseType()));
		tempEEBO.setSalesDocNo(OPPTHelper.trimStringToNull(tempEELocal.getSalesDocNo()));
		tempEEBO.setSwoItemNo(OPPTHelper.trimStringToNull(tempEELocal.getSwoItemNo()));
		tempEEBO.setUl(OPPTHelper.trimStringToNull(tempEELocal.getUl()));
		tempEEBO.setUseLevel(OPPTHelper.trimStringToNull(tempEELocal.getUseLevel()));
		tempEEBO.setValidInd(OPPTHelper.trimStringToNull(tempEELocal.getValidInd()));
		tempEEBO.setValueMetric(OPPTHelper.trimStringToNull(tempEELocal.getValueMetric()));
		tempEEBO.setValueMetricType(OPPTHelper.trimStringToNull(tempEELocal.getValueMetricType()));
		tempEEBO.setVm(OPPTHelper.trimStringToNull(tempEELocal.getVm()));
		
	}

}
