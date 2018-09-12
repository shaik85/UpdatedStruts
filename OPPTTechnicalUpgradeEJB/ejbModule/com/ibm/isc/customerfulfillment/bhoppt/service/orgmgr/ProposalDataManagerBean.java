/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import javax.ejb.CreateException;

import com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocal;
import com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.BillingBlockConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.BillingTypeConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ComplexTypesConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CurrencyConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.DivisionConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.DstrChannelConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.GenericConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PaymentTermConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RefreshCurrencyInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RefreshCurrencyOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveBillingBlockInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveBillingBlockOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveComplexTypesInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveComplexTypesOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveDateRulesInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveDateRulesOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePaymentTermsInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePaymentTermsOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveSalesAreaInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveSalesAreaOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.SalesAreaConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.SalesOrgConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CurrencyDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ValidCombinationDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ActivityLogBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BLBIndicatorBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BasicPropDataBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BillingBlockBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BillingDataBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BillingFrequencyBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BillingTypeBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ComplexContractIdentifiersBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ComplexTypesBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.CurrencyBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.DistrChannelBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.DivisionBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.PaymentTermBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ProposalTypeBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.SalesOrgBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.UserProfileBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ValidCombinationBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.ActivityLogBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.BasicPropDataBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.BillingDataBOFactroy;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.ComplexContractIdentifiersBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.ProposalDataDAOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.ProposalTypeBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.ValidCombinationBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.SystemUpdateFactory;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SalesOrganizationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerBean;

/**
 *  
 * Bean implementation class for Enterprise Bean: ProposalDataManager 
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 6, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A
 */
public class ProposalDataManagerBean implements javax.ejb.SessionBean
{
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "ProposalDataManagerBean";
	public static int role = 0;
	private ActivityLogBOFactory iActivityLogBOFactory = new ActivityLogBOFactory();

	private javax.ejb.SessionContext mySessionCtx;
	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext()
	{
		return mySessionCtx;
	}
	
	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx)
	{
		mySessionCtx = ctx;
	}
	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException
	{

	}

	/**
	 * ejbActivate
	 */
	public void ejbActivate()
	{

	}

	/**
	 * ejbPassivate
	 */
	public void ejbPassivate()
	{

	}

	/**
	 * ejbRemove
	 */
	public void ejbRemove()
	{

	}
	/**
	 *  getProposalFormData
	 * This method goes to the factory and gets the data needed for proposal creation
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalFormDataCustomDTO
	 * @param createProposal
	 * @throws ServiceException
	 * @author balajiv
	 * 
	 */
	public ProposalFormDataCustomDTO getProposalFormData(boolean createProposal) throws ServiceException
	{
		String methodName = "getProposalFormData";

		BasicPropDataBOFactory basicPropDataBOFactory = new BasicPropDataBOFactory();
		ProposalFormDataCustomDTO proposalFormDataCustomDTO = new ProposalFormDataCustomDTO();
		BasicPropDataBO basicPropDataBO = null;
		BillingDataBO billingDataBO = null;
		List proposalTypeList = null;

		BillingDataBOFactroy billingDataBOFactroy = new BillingDataBOFactroy();

		try
		{
			billingDataBO = billingDataBOFactroy.getBillingDataBO();
		}
		catch (DomainException de)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());
		}

		ProposalTypeBOFactory proposalTypeBOFactory = new ProposalTypeBOFactory();

		try
		{
			proposalTypeList = proposalTypeBOFactory.findAllProposalTypeBO();
		}
		catch (DomainException de)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());
		}

		if (createProposal)
		{
			try
			{
				basicPropDataBO = basicPropDataBOFactory.getBasicPropDataBO();
			}
			catch (DomainException de)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, de);
				throw ExceptionGenerator.generateServiceException(de.getErrorReport());
			}

			List salesOrgList = basicPropDataBO.getSalesOrgList();
			TreeMap salesOrgMap = new TreeMap();
			for (int i = 0; i < salesOrgList.size(); i++)
			{
				SalesOrgBDO salesOrgBDO = (SalesOrgBDO) salesOrgList.get(i);
				SalesOrganizationCustomDTO salesOrganizationCustomDTO = new SalesOrganizationCustomDTO();
				salesOrganizationCustomDTO.setId(salesOrgBDO.getSalesOrg().trim());
				salesOrganizationCustomDTO.setDescription(salesOrgBDO.getSalesOrgDesc());
				salesOrganizationCustomDTO.setDefaultCurrency(salesOrgBDO.getDefaultCurrncy());
				salesOrgMap.put(salesOrganizationCustomDTO.getId(), salesOrganizationCustomDTO);
			}

			List divisionList = basicPropDataBO.getDivisionList();
			TreeMap divisionMap = new TreeMap();
			for (int i = 0; i < divisionList.size(); i++)
			{
				DivisionBDO divisionBDO = (DivisionBDO) divisionList.get(i);
				divisionMap.put(divisionBDO.getDivisionCode().trim(), divisionBDO.getDivisionDesc());
			}

			List dstrChannelList = basicPropDataBO.getDistributionChannelList();
			TreeMap dstrChannelMap = new TreeMap();
			for (int i = 0; i < dstrChannelList.size(); i++)
			{ 
				String distrChannelId =null;
				DistrChannelBDO distrChannelBDO = (DistrChannelBDO) dstrChannelList.get(i);

				distrChannelId= distrChannelBDO.getDistrChannel().trim()+"|"+distrChannelBDO.getSalesGroup().trim()+"|"+distrChannelBDO.getChannelRole().trim()+"|"+distrChannelBDO.getSubmitterRole().trim();
				dstrChannelMap.put(distrChannelId.trim(),distrChannelBDO.getDistrDescription());
				/*dstrChannelMap.put(
					distrChannelBDO.getDistrChannel().trim(),
					distrChannelBDO.getDistrDescription());*/
			}

			List currencyList = basicPropDataBO.getCurrencyList();
			TreeMap currencyMap = new TreeMap();
			for (int i = 0; i < currencyList.size(); i++)
			{
				CurrencyBDO currencyBDO = (CurrencyBDO) currencyList.get(i);
				currencyMap.put(currencyBDO.getCurrencyCode().trim(), currencyBDO.getCurrencyName());
			}
			proposalFormDataCustomDTO.setDistributionChannelOptions(dstrChannelMap);
			proposalFormDataCustomDTO.setDivisionOptions(divisionMap);
			proposalFormDataCustomDTO.setSalesOrganizationOptions(salesOrgMap);
			proposalFormDataCustomDTO.setCurrencyCodeOptions(currencyMap);

		}

		List paymentTermList = billingDataBO.getPaymentTermList();
		TreeMap paymentTermMap = new TreeMap();

		for (int i = 0; i < paymentTermList.size(); i++)
		{
			PaymentTermBDO paymentTermBDO = (PaymentTermBDO) paymentTermList.get(i);
			paymentTermMap.put(paymentTermBDO.getPaymentTerm().trim(), paymentTermBDO.getPaymentDesc());
		}

		List billingTypeList = billingDataBO.getBillingTypeList();
		TreeMap billingTypeMap = new TreeMap();

		for (int i = 0; i < billingTypeList.size(); i++)
		{
			BillingTypeBDO billingTypeBDO = (BillingTypeBDO) billingTypeList.get(i);
			billingTypeMap.put(billingTypeBDO.getBillingType().trim(), billingTypeBDO.getBillingTypeDesc());
		}

		List billingBlockList = billingDataBO.getBillingBlockList();
		TreeMap billingBlockMap = new TreeMap();

		for (int i = 0; i < billingBlockList.size(); i++)
		{
			BillingBlockBDO billingBlockBDO = (BillingBlockBDO) billingBlockList.get(i);
			billingBlockMap.put(billingBlockBDO.getBillingBlock().trim(), billingBlockBDO.getBillingBlockDesc());
		}
		// BH Wave1 - DAD003 - CCI - Bhanu - Begin
		
		
		// BH Wave1 - DAD003 - CCI - Bhanu -  End		

		List billingFreqList = billingDataBO.getBillingFreqList();
		TreeMap billingFreqMap = new TreeMap();

		for (int i = 0; i < billingFreqList.size(); i++)
		{
			BillingFrequencyBDO billingFrequencyBDO = (BillingFrequencyBDO) billingFreqList.get(i);
			billingFreqMap.put(
				billingFrequencyBDO.getBillingFreqCode().trim(),
				billingFrequencyBDO.getBillingFreqDesc());
		}
         //Added by Srinivas-DAD-001
		LinkedHashMap proposalTypeMap = new LinkedHashMap();
		for (int i = 0; i < proposalTypeList.size(); i++)
		{
			ProposalTypeBO proposalTypeBO = (ProposalTypeBO) proposalTypeList.get(i);

			proposalTypeMap.put( proposalTypeBO.getOfferingDesc(),proposalTypeBO.getOfferingType().trim());
		}

	// nomita- DM requirement start
		OPPTCustomDTO customDTO = new OPPTCustomDTO();
		if(role==RoleConstants.DATA_MIGRATOR)
		{
			//System.out.println("ProposalDataManagerBean.getProposalFormData()inside if");
			GregorianCalendar currentCal = new GregorianCalendar();
			currentCal.setTime(new Date());
			int currentYear = currentCal.get(Calendar.YEAR);

			ArrayList contractStartYearList = new ArrayList();
			contractStartYearList.add(String.valueOf(currentYear - 5));
			for (int i = 0; i < 10; i++)
			{
				contractStartYearList.add(String.valueOf(currentYear - 4 + i));
			}

			ArrayList contractEndYearList = new ArrayList();
			contractEndYearList.add(String.valueOf(currentYear - 5));
			for (int i = 0; i < 15; i++)
			{
				contractEndYearList.add(String.valueOf(currentYear - 4 + i));
				
				}
			
			proposalFormDataCustomDTO.setEndYears(contractEndYearList);
			proposalFormDataCustomDTO.setStartYears(contractStartYearList);
		}
		else
		{
			//System.out.println("ProposalDataManagerBean.getProposalFormData()entered else");
			GregorianCalendar currentCal = new GregorianCalendar();
			currentCal.setTime(new Date());
			int currentYear = currentCal.get(Calendar.YEAR);

			ArrayList contractStartYearList = new ArrayList();
			contractStartYearList.add(String.valueOf(currentYear - 1));
			for (int i = 0; i < 6; i++)
			{
				contractStartYearList.add(String.valueOf(currentYear + i));
			}

			ArrayList contractEndYearList = new ArrayList();
			contractEndYearList.add(String.valueOf(currentYear - 1));
			for (int i = 0; i < 11; i++)
			{
				contractEndYearList.add(String.valueOf(currentYear + i));
			}
			proposalFormDataCustomDTO.setEndYears(contractEndYearList);
			proposalFormDataCustomDTO.setStartYears(contractStartYearList);
		}
		// Nomita- DM changes end
		proposalFormDataCustomDTO.setBillingBlockOptions(billingBlockMap);
		proposalFormDataCustomDTO.setBillingDateRuleOptions(billingTypeMap);
		proposalFormDataCustomDTO.setBillingFrequencyOptions(billingFreqMap);
		proposalFormDataCustomDTO.setPaymentTermsOptions(paymentTermMap);
		proposalFormDataCustomDTO.setProposalTypeOptions(proposalTypeMap);
		proposalFormDataCustomDTO.setProposalContentOptions(getSAndSOptions());
		// BH Wave1 - DAD003 - CCI - Bhanu - Begin
		//proposalFormDataCustomDTO.setComplexContractTypeOptions(complexContractTypeMap);
		//proposalFormDataCustomDTO.setMasterContractTypeOptions(masterContractTypeMap);
		//proposalFormDataCustomDTO.setBlbIndicatorOptions(blbIndicatorTypeMap);
		// BH Wave1 - DAD003 - CCI - Bhanu - End
		return proposalFormDataCustomDTO;
	}

	/**
	 *  checkValidCombination
	 * This method goes to the factory and gets the data needed for proposal creation
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 * @param validCombinationDomainDTO
	 * @throws ServiceException
	 * @author balajiv
	 * 
	 */
	public boolean checkValidCombination(ValidCombinationDomainDTO validCombinationDomainDTO)
		throws ServiceException
	{
		ValidCombinationBOFactory validCombinationBOFactory = new ValidCombinationBOFactory();
		if (validCombinationBOFactory
			.isValidCombination(
				validCombinationDomainDTO.getSalesOrg(),
				validCombinationDomainDTO.getDivisionCode(),
				validCombinationDomainDTO.getDistributionChannel())
			== false)
		{
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0017);
		}
		return true;
	}

	/**
	 * updateSalesOrg
	 * This method is used to   
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
	 * 
	 * @return OPPTCustomDTO
	 * @param opptCustomDTO
	 * @throws ServiceException
	 */
	public OPPTCustomDTO updateSalesOrg(OPPTCustomDTO opptCustomDTO) throws ServiceException
	{
		String methodName = "updateSalesOrg";

		JMSConnectorLocalHome jmsConnectorLocalHome = getJMSConnectorLocalHome();
		JMSConnectorLocal jmsConnectorLocal = null;
		try
		{
			jmsConnectorLocal = jmsConnectorLocalHome.create();
		}
		catch (CreateException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		RetrieveSalesAreaInputConnectorDTO retrieveSalesAreaInputConnectorDTO =
			new RetrieveSalesAreaInputConnectorDTO();
		RetrieveSalesAreaOutputConnectorDTO retrieveSalesAreaOutputConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();

		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_REFRESH_SALES_AREA_OPPT);
		genericConnectorDTO.setSessionID(opptCustomDTO.getSessionId());
		genericConnectorDTO.setUserID(opptCustomDTO.getUserId());
		retrieveSalesAreaInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);

		try
		{
			retrieveSalesAreaOutputConnectorDTO =
				(RetrieveSalesAreaOutputConnectorDTO) jmsConnectorLocal.sendReceive(
					retrieveSalesAreaInputConnectorDTO);
		}
		catch (Exception ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(retrieveSalesAreaOutputConnectorDTO.getReturnCode())
			== false)
		{
			ErrorReport errorReport =
				ExceptionGenerator.getErrorReport(
					retrieveSalesAreaOutputConnectorDTO.getReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
			throw ExceptionGenerator.generateServiceException(errorReport);
		}

		//For SalesOrg
		List salesOrgList = retrieveSalesAreaOutputConnectorDTO.getSalesOrgConnectorDTO();
		List salesOrgBDOList = new ArrayList();
		Iterator iter = null;

		if (salesOrgList != null)
		{
			SalesOrgConnectorDTO salesOrgConnectorDTO;
			iter = salesOrgList.iterator();

			while (iter.hasNext())
			{
				salesOrgConnectorDTO = (SalesOrgConnectorDTO) iter.next();
				SalesOrgBDO salesOrgBDO = new SalesOrgBDO();
				salesOrgBDO.setSalesOrg(salesOrgConnectorDTO.getSalesOrg());
				salesOrgBDO.setSalesOrgDesc(salesOrgConnectorDTO.getSalesOrgDesc());
				salesOrgBDO.setDefaultCurrncy(salesOrgConnectorDTO.getDefaultCurrency());
				salesOrgBDOList.add(salesOrgBDO);
			}
		}

		//For SalesArea
		List validCombinationList = retrieveSalesAreaOutputConnectorDTO.getSalesAreaConnectorDTO();
		List validCombinationBDOList = new ArrayList();

		if (validCombinationList != null)
		{
			SalesAreaConnectorDTO salesAreaConnectorDTO;
			iter = validCombinationList.iterator();

			while (iter.hasNext())
			{
				salesAreaConnectorDTO = (SalesAreaConnectorDTO) iter.next();
				ValidCombinationBDO validCombinationBDO = new ValidCombinationBDO();
				validCombinationBDO.setSalerOrg(salesAreaConnectorDTO.getSalesOrg());
				validCombinationBDO.setDivisionCode(salesAreaConnectorDTO.getDivisionCode());
				validCombinationBDO.setDistributionChannel(salesAreaConnectorDTO.getDstrChannel());
				validCombinationBDOList.add(validCombinationBDO);
			}
		}

		//For Division
		List divisionList = retrieveSalesAreaOutputConnectorDTO.getDivisionConnectorDTO();
		List divisionBDOList = new ArrayList();

		if (divisionList != null)
		{
			DivisionConnectorDTO divisionConnectorDTO;
			iter = divisionList.iterator();

			while (iter.hasNext())
			{
				divisionConnectorDTO = (DivisionConnectorDTO) iter.next();
				DivisionBDO divisionBDO = new DivisionBDO();
				divisionBDO.setDivisionCode(divisionConnectorDTO.getDivisionCode());
				divisionBDO.setDivisionDesc(divisionConnectorDTO.getDivisionCodeDesc());
				divisionBDOList.add(divisionBDO);
			}
		}

		//For Dstr Channel
		List distrChannelList = retrieveSalesAreaOutputConnectorDTO.getDstrChannelConnectorDTO();
		List distrChannelBDOList = new ArrayList();

		if (distrChannelList != null)
		{
			DstrChannelConnectorDTO dstrChannelConnectorDTO;
			iter = distrChannelList.iterator();

			while (iter.hasNext())
			{
				dstrChannelConnectorDTO = (DstrChannelConnectorDTO) iter.next();
				DistrChannelBDO distrChannelBDO = new DistrChannelBDO();
				distrChannelBDO.setDistrChannel(dstrChannelConnectorDTO.getDstrChannel());
				distrChannelBDO.setDistrDescription(dstrChannelConnectorDTO.getDstrChannelDesc());
				distrChannelBDOList.add(distrChannelBDO);
			}
		}

		try
		{
			SystemUpdateFactory systemUpdateFactory = new SystemUpdateFactory();

			systemUpdateFactory.updateSalesOrg(
				salesOrgBDOList,
				validCombinationBDOList,
				divisionBDOList,
				distrChannelBDOList);
		}
		catch (DomainException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		}
		
		/* Start change  CR0801074150 - CBS OPPT activity logging */
		OPPTLogger.infoActivityLogger("Geo Security officer " +opptCustomDTO.getUserId() + " populated the sales area master data from BH to OPPT!",CLASS_NAME, methodName);
		/* End change  CR0801074150 - CBS OPPT activity logging */
		String message="populated the sales area master data from BH to OPPT !";
		createActivityLog(opptCustomDTO.getUserId(),message);
		return opptCustomDTO;
	}

	/**
	 * updateCurrency
	 * This method is used to   
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
	 * 
	 * @return OPPTCustomDTO
	 * @param opptCustomDTO
	 * @throws ServiceException
	 */
	public OPPTCustomDTO updateCurrency(OPPTCustomDTO opptCustomDTO) throws ServiceException
	{
		String methodName = "updateCurrency";

		JMSConnectorLocalHome jmsConnectorLocalHome = getJMSConnectorLocalHome();

		JMSConnectorLocal jmsConnectorLocal = null;
		try
		{
			jmsConnectorLocal = jmsConnectorLocalHome.create();
		}
		catch (CreateException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		RefreshCurrencyInputConnectorDTO refreshCurrencyInputConnectorDTO = new RefreshCurrencyInputConnectorDTO();
		RefreshCurrencyOutputConnectorDTO refreshCurrencyOutputConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();

		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_REFRESH_CURRENCY_OPPT);
		genericConnectorDTO.setSessionID(opptCustomDTO.getSessionId());
		genericConnectorDTO.setUserID(opptCustomDTO.getUserId());
		refreshCurrencyInputConnectorDTO.setIGenericConnectorDTO(genericConnectorDTO);

		try
		{
			refreshCurrencyOutputConnectorDTO =
				(RefreshCurrencyOutputConnectorDTO) jmsConnectorLocal.sendReceive(
					refreshCurrencyInputConnectorDTO);
		}
		catch (Exception ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(refreshCurrencyOutputConnectorDTO.getIReturnCode())
			== false)
		{
			ErrorReport errorReport =
				ExceptionGenerator.getErrorReport(
					refreshCurrencyOutputConnectorDTO.getIReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
			throw ExceptionGenerator.generateServiceException(errorReport);
		}

		List list = refreshCurrencyOutputConnectorDTO.getICurrencyConnectorDTO();

		if (list != null)
		{
			CurrencyConnectorDTO currencyConnectorDTO;

			Iterator iter = list.iterator();
			List currencyList = new ArrayList();

			while (iter.hasNext())
			{
				currencyConnectorDTO = (CurrencyConnectorDTO) iter.next();
				CurrencyBDO currencyBDO = new CurrencyBDO();
				currencyBDO.setCurrencyCode(currencyConnectorDTO.getICurrencyCode());
				currencyBDO.setCurrencyName(currencyConnectorDTO.getICurrencyName());
				currencyBDO.setDecimalAllowed(Integer.parseInt(currencyConnectorDTO.getIDecimalAllowed()));
				currencyList.add(currencyBDO);
			}

			try
			{
				SystemUpdateFactory systemUpdateFactory = new SystemUpdateFactory();

				systemUpdateFactory.updateCurrency(currencyList);
			}
			catch (DomainException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
		}
		/* Start change  CR0801074150 - CBS OPPT activity logging */
		OPPTLogger.infoActivityLogger("User id " +opptCustomDTO.getUserId() + " populated the currency master data from BH to OPPT !",CLASS_NAME, methodName);
		/* End change  CR0801074150 - CBS OPPT activity logging */
		String message="populated the currency master data from BH to OPPT !";
		createActivityLog(opptCustomDTO.getUserId(),message);
		return opptCustomDTO;
	}

	/**
	 * updatePayment
	 * This method is used to   
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
	 * 
	 * @return OPPTCustomDTO
	 * @param opptCustomDTO
	 * @throws ServiceException
	 */
	public OPPTCustomDTO updatePayment(OPPTCustomDTO opptCustomDTO) throws ServiceException
	{
		String methodName = "updatePayment";

		JMSConnectorLocalHome jmsConnectorLocalHome = getJMSConnectorLocalHome();

		JMSConnectorLocal jmsConnectorLocal = null;
		try
		{
			jmsConnectorLocal = jmsConnectorLocalHome.create();
		}
		catch (CreateException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		RetrievePaymentTermsInputConnectorDTO retrievePaymentTermsInputConnectorDTO =
			new RetrievePaymentTermsInputConnectorDTO();
		RetrievePaymentTermsOutputConnectorDTO retrievePaymentTermsOutputConnectorDTO = null;

		retrievePaymentTermsInputConnectorDTO.setFunctionModuleName(
			ConnectorConstants.RFC_RETRIEVE_PAYM_TERMS_OPPT);
		retrievePaymentTermsInputConnectorDTO.setSessionID(opptCustomDTO.getSessionId());

		try
		{
			retrievePaymentTermsOutputConnectorDTO =
				(RetrievePaymentTermsOutputConnectorDTO) jmsConnectorLocal.sendReceive(
					retrievePaymentTermsInputConnectorDTO);
		}
		catch (Exception ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(retrievePaymentTermsOutputConnectorDTO.getIReturnCode())
			== false)
		{
			ErrorReport errorReport =
				ExceptionGenerator.getErrorReport(
					retrievePaymentTermsOutputConnectorDTO.getIReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
			throw ExceptionGenerator.generateServiceException(errorReport);
		}

		List paymentTermList = retrievePaymentTermsOutputConnectorDTO.getIPaymentTermConnectorDTO();

		if (paymentTermList != null)
		{
			PaymentTermConnectorDTO paymentTermConnectorDTO;
			List paymentTermBDOList = new ArrayList();

			Iterator iter = paymentTermList.iterator();

			while (iter.hasNext())
			{
				paymentTermConnectorDTO = (PaymentTermConnectorDTO) iter.next();
				PaymentTermBDO paymentTermBDO = new PaymentTermBDO();
				paymentTermBDO.setPaymentTerm(paymentTermConnectorDTO.getIPaymentCode());
				paymentTermBDO.setPaymentDesc(paymentTermConnectorDTO.getIPaymentDesc());
				paymentTermBDOList.add(paymentTermBDO);
			}

			try
			{
				SystemUpdateFactory systemUpdateFactory = new SystemUpdateFactory();

				systemUpdateFactory.updatePaymentTerm(paymentTermBDOList);
			}
			catch (DomainException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
		}
		/* Start change  CR0801074150 - CBS OPPT activity logging */
		OPPTLogger.infoActivityLogger("User id " +opptCustomDTO.getUserId() + " populated the payment master data from BH to OPPT !",CLASS_NAME, methodName);
		/* End change  CR0801074150 - CBS OPPT activity logging */
		String message="populated the payment master data from BH to OPPT !";
		createActivityLog(opptCustomDTO.getUserId(),message);
		return opptCustomDTO;
	}

	/**
	 * updateBilling
	 * This method is used to   updateBilling
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
	 * 
	 * @return OPPTCustomDTO
	 * @param opptCustomDTO
	 * @throws ServiceException
	 */
	public OPPTCustomDTO updateBilling(OPPTCustomDTO opptCustomDTO) throws ServiceException
	{
		String methodName = "updateBilling";

		JMSConnectorLocalHome jmsConnectorLocalHome = getJMSConnectorLocalHome();

		JMSConnectorLocal jmsConnectorLocal = null;
		try
		{
			jmsConnectorLocal = jmsConnectorLocalHome.create();
		}
		catch (CreateException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		RetrieveDateRulesInputConnectorDTO retrieveDateRulesInputConnectorDTO =
			new RetrieveDateRulesInputConnectorDTO();
		RetrieveDateRulesOutputConnectorDTO retrieveDateRulesOutputConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();

		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_DATE_RULES_OPPT);
		genericConnectorDTO.setSessionID(opptCustomDTO.getSessionId());
		genericConnectorDTO.setUserID(opptCustomDTO.getUserId());
		retrieveDateRulesInputConnectorDTO.setIGenericConnectorDTO(genericConnectorDTO);

		try
		{
			retrieveDateRulesOutputConnectorDTO =
				(RetrieveDateRulesOutputConnectorDTO) jmsConnectorLocal.sendReceive(
					retrieveDateRulesInputConnectorDTO);
		}
		catch (Exception ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(retrieveDateRulesOutputConnectorDTO.getIReturnCode())
			== false)
		{
			ErrorReport errorReport =
				ExceptionGenerator.getErrorReport(
					retrieveDateRulesOutputConnectorDTO.getIReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
			throw ExceptionGenerator.generateServiceException(errorReport);
		}

		List billingTypeList = retrieveDateRulesOutputConnectorDTO.getIBillingTypeConnectorDTO();

		if (billingTypeList != null)
		{
			BillingTypeConnectorDTO billingTypeConnectorDTO;
			Iterator iter = billingTypeList.iterator();

			List billingTypeBDOList = new ArrayList();

			while (iter.hasNext())
			{
				billingTypeConnectorDTO = (BillingTypeConnectorDTO) iter.next();
				BillingTypeBDO billingTypeBDO = new BillingTypeBDO();
				billingTypeBDO.setBillingType(billingTypeConnectorDTO.getIBillingCode());
				billingTypeBDO.setBillingTypeDesc(billingTypeConnectorDTO.getIBillingDesc());
				billingTypeBDOList.add(billingTypeBDO);
			}

			try
			{
				SystemUpdateFactory systemUpdateFactory = new SystemUpdateFactory();

				systemUpdateFactory.updateBillingType(billingTypeBDOList);
			}
			catch (DomainException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
		}
		/* Start change  CR0801074150 - CBS OPPT activity logging */
		OPPTLogger.infoActivityLogger("User id " +opptCustomDTO.getUserId() + " populated the billing master data from BH to OPPT !",CLASS_NAME, methodName);
		/* End change  CR0801074150 - CBS OPPT activity logging */
		String message="populated the billing master data from BH to OPPT !";
		createActivityLog(opptCustomDTO.getUserId(),message);
		return opptCustomDTO;
	}

	/**
	 * updateBillingBlock
	 * This method is used to   updateBillingBlock
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
	 * 
	 * @return OPPTCustomDTO
	 * @param opptCustomDTO
	 * @throws ServiceException
	 */
	public OPPTCustomDTO updateBillingBlock(OPPTCustomDTO opptCustomDTO) throws ServiceException
	{
		String methodName = "updateBillingBlock";

		JMSConnectorLocalHome jmsConnectorLocalHome = getJMSConnectorLocalHome();

		JMSConnectorLocal jmsConnectorLocal = null;
		try
		{
			jmsConnectorLocal = jmsConnectorLocalHome.create();
		}
		catch (CreateException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		RetrieveBillingBlockInputConnectorDTO retrieveBillingBlockInputConnectorDTO =
			new RetrieveBillingBlockInputConnectorDTO();
		RetrieveBillingBlockOutputConnectorDTO retrieveBillingBlockOutputConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();

		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_BILL_BLOCK_OPPT);
		genericConnectorDTO.setSessionID(opptCustomDTO.getSessionId());
		genericConnectorDTO.setUserID(opptCustomDTO.getUserId());
		retrieveBillingBlockInputConnectorDTO.setIGenericConnectorDTO(genericConnectorDTO);

		try
		{
			retrieveBillingBlockOutputConnectorDTO =
				(RetrieveBillingBlockOutputConnectorDTO) jmsConnectorLocal.sendReceive(
					retrieveBillingBlockInputConnectorDTO);
		}
		catch (Exception ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(retrieveBillingBlockOutputConnectorDTO.getIReturnCode())
			== false)
		{
			ErrorReport errorReport =
				ExceptionGenerator.getErrorReport(
					retrieveBillingBlockOutputConnectorDTO.getIReturnCode(),
					OPPTMessageCatalog.TYPE_BACKEND);
			throw ExceptionGenerator.generateServiceException(errorReport);
		}

		List billingBlockList = retrieveBillingBlockOutputConnectorDTO.getIBillingBlockConnectorDTO();

		if (billingBlockList != null)
		{
			BillingBlockConnectorDTO billingBlockConnectorDTO;
			Iterator iter = billingBlockList.iterator();

			List billingBlockBDOList = new ArrayList();

			while (iter.hasNext())
			{
				billingBlockConnectorDTO = (BillingBlockConnectorDTO) iter.next();
				BillingBlockBDO billingBlockBDO = new BillingBlockBDO();
				billingBlockBDO.setBillingBlock(billingBlockConnectorDTO.getIBillingBlock());
				billingBlockBDO.setBillingBlockDesc(billingBlockConnectorDTO.getIBillingBlockDesc());
				billingBlockBDOList.add(billingBlockBDO);
			}

			try
			{
				SystemUpdateFactory systemUpdateFactory = new SystemUpdateFactory();

				systemUpdateFactory.updateBillingBlock(billingBlockBDOList);
			}
			catch (DomainException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
		}
		/* Start change  CR0801074150 - CBS OPPT activity logging */
		OPPTLogger.infoActivityLogger("User id " +opptCustomDTO.getUserId() + " populated the billing block master data from BH to OPPT !",CLASS_NAME, methodName);
		/* End change  CR0801074150 - CBS OPPT activity logging */
		String message="populated the billing block master data from BH to OPPT !";
		createActivityLog(opptCustomDTO.getUserId(),message);
		return opptCustomDTO;
	}
	
//	Added by Srinivas-------OPPTBH-DAD003
	
	/**
	 * updateComplexTypes
	 * This method is used to   updateComplexTypes
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
	 * 
	 * @return OPPTCustomDTO
	 * @param opptCustomDTO
	 * @throws ServiceException
	 */
	public OPPTCustomDTO updateComplexTypes(OPPTCustomDTO opptCustomDTO) throws ServiceException
	{
		String methodName = "updateComplexTypes";
		
		JMSConnectorLocalHome jmsConnectorLocalHome = getJMSConnectorLocalHome();

		JMSConnectorLocal jmsConnectorLocal = null;
		try
		{
			jmsConnectorLocal = jmsConnectorLocalHome.create();
		}
		catch (CreateException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		
		RetrieveComplexTypesInputConnectorDTO  retrieveComplexTypesInputConnectorDTO
               = new RetrieveComplexTypesInputConnectorDTO();
		RetrieveComplexTypesOutputConnectorDTO retrieveComplexTypesOutputConnectorDTO = null;
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_COMPLEX_TYPES_OPPT);
		genericConnectorDTO.setSessionID(opptCustomDTO.getSessionId());
		genericConnectorDTO.setUserID(opptCustomDTO.getUserId());
		retrieveComplexTypesInputConnectorDTO.setIGenericConnectorDTO(genericConnectorDTO);
			
		try
		{
			retrieveComplexTypesOutputConnectorDTO =
				(RetrieveComplexTypesOutputConnectorDTO) jmsConnectorLocal.sendReceive(
						retrieveComplexTypesInputConnectorDTO);
		}
		catch (Exception ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(retrieveComplexTypesOutputConnectorDTO.getIReturnCode())
				== false)
			{
				ErrorReport errorReport =
					ExceptionGenerator.getErrorReport(
							retrieveComplexTypesOutputConnectorDTO.getIReturnCode(),
						OPPTMessageCatalog.TYPE_BACKEND);
				throw ExceptionGenerator.generateServiceException(errorReport);
			}
		List complexTypesList = retrieveComplexTypesOutputConnectorDTO.getIComplexTypesConnectorDTO();

		if (complexTypesList != null)
		{
			ComplexTypesConnectorDTO complexTypesConnectorDTO;
			Iterator iter = complexTypesList.iterator();

			List complexTypesBDOList = new ArrayList(); 
			ComplexTypesBDO complexTypesBDO = null;
			while (iter.hasNext())
			{
				
				complexTypesConnectorDTO = (ComplexTypesConnectorDTO) iter.next();
				complexTypesBDO = new ComplexTypesBDO();
				complexTypesBDO.setBLBIndicatorType(complexTypesConnectorDTO.getBlbIndicatorType());
				complexTypesBDO.setBLBIndicatorDesc(complexTypesConnectorDTO.getBlbIndicatorDesc());
			
			 
				complexTypesBDOList.add(complexTypesBDO);
			}
			try
			{
				SystemUpdateFactory systemUpdateFactory = new SystemUpdateFactory();
				systemUpdateFactory.updateComplexTypes(complexTypesBDOList);
			}
			catch (DomainException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
		}
		/* Start change  CR0801074150 - CBS OPPT activity logging */
		OPPTLogger.infoActivityLogger("User id " +opptCustomDTO.getUserId() + " populated the BLB Indictor master data from BH to OPPT !",CLASS_NAME, methodName);
		/* End change  CR0801074150 - CBS OPPT activity logging */
		String message="populated the BLB Indicator master data from BH to OPPT !";
		createActivityLog(opptCustomDTO.getUserId(),message);
		return opptCustomDTO;
	}
		
		
		
	public void populateStaticData() throws ServiceException
	{
		String methodName = "populateStaticData";

		ProposalDataDAOFactory proposalDataDAOFactory = new ProposalDataDAOFactory();

		try
		{
			proposalDataDAOFactory.populateStaticData();
		}
		catch (DomainException de)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());
		}
	}
	
	// creating activity Log added by Nomita
	private void createActivityLog(String userID,
			String message) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "createActivityLog");
		ActivityLogBO activityLogBO = new ActivityLogBO();
		activityLogBO.setUserId(userID);
		activityLogBO.setMessage(message);
		try {
			iActivityLogBOFactory.create(activityLogBO);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}
	// end
	/**
	 * getCurrencyInformation
	 * This method Get the currency information
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
	 * @param String currency
	 * @return CurrencyDomainDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CurrencyDomainDTO getCurrencyInformation(String currency) throws ServiceException
	{
		String methodName = "getCurrencyInformation";

		CurrencyDomainDTO currencyDomainDTO = null;
		BasicPropDataBOFactory basicPropDataFactory = new BasicPropDataBOFactory();

		try
		{
			currencyDomainDTO = new CurrencyDomainDTO(basicPropDataFactory.getCurrencyBDO(currency));
		}
		catch (DomainException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		}

		return currencyDomainDTO;

	}

	private TreeMap getSAndSOptions()
	{
//		Added by Srinivas-------OPPTBH-DAD001
		TreeMap map = new TreeMap();
//		map.put("M","MLC contract only" );
//		map.put("S","S&S contract only" );
		
//		Added by Srinivas-------OPPTBH-DAD013
		//map.put("A", "MLC and S&S contract");

		return map;
	}

	private JMSConnectorLocalHome getJMSConnectorLocalHome()
	{
		return (JMSConnectorLocalHome) HomeProvider.getLocal(HomeProvider.JMS_CONNECTOR_LOCAL_HOME);
	}
}