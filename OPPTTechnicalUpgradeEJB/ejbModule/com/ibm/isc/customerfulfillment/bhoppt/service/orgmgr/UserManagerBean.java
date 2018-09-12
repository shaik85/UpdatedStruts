/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;


import java.sql.Timestamp;
import java.util.*;

import javax.ejb.CreateException;

import com.ibm.isc.customerfulfillment.bhoppt.connector.*;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.MailMessageConstants;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserGroupProfileDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserProfileDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.*;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.*;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ActivityLogBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.ActivityLogBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.*;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.UserDAO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.websphere.models.config.process.Service;
import com.ibm.ws.webservices.engine.types.Time;

/**
 *  
 * Bean implementation class for Enterprise Bean: UserManager 
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 6, 2004 
 * 
 * revision date author reason 
 * Revised by balaji to add group information to the database
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A
 */
public class UserManagerBean implements javax.ejb.SessionBean {
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "UserManagerBean";
	private ActivityLogBOFactory iActivityLogBOFactory = new ActivityLogBOFactory();

	private javax.ejb.SessionContext mySessionCtx;

	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}

	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}

	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}

	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}

	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}

	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}

	/**
	 *  This method goes to the factory and creates a BP User
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bpUserCustom
	 * @return BPUserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public BPUserCustomDTO createBPUser(BPUserCustomDTO bpUserCustom) throws ServiceException {
		String methodName = "createBPUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		try {
			String userId = bpUserCustom.getUserId();

			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();

			try {
				if (userProfileBOFactory.isUserIdExists(userId)) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0200);
				}
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);

				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			String selectedManager = bpUserCustom.getSelectedManager();
			if (selectedManager == null) {
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0201);
			}

			UserProfileBO userProfileBO = new UserProfileBO();

			userProfileBO.setUserId(bpUserCustom.getUserId());
			userProfileBO.setRole(bpUserCustom.getRole());
			userProfileBO.setBPAccessIndicator(bpUserCustom.getAccessType());
			userProfileBO.setPrimarySalesOrg(bpUserCustom.getPrimarySalesArea());
			userProfileBO.setAthorization(UtilityConstants.BPUSER_CREATE_DEFAULT_ACCESS_TYPE);
			userProfileBO.setApproverId(bpUserCustom.getSelectedManager());

			String accessType = OPPTHelper.trimString(bpUserCustom.getAccessType());
			if (UtilityConstants.BPCUSTOMERLIST_ACCESS_TYPE_OPPT.equals(accessType)) {
				List customerNosList = new ArrayList();
				Iterator iter = bpUserCustom.getCustomerNumbers().iterator();

				while (iter.hasNext()) {
					BPCustomerListBDO bPCustomerListBDO = new BPCustomerListBDO();
					bPCustomerListBDO.setCustListNo((String) iter.next());
					bPCustomerListBDO.setUserId(bpUserCustom.getUserId());
					customerNosList.add(bPCustomerListBDO);
				}

				userProfileBO.setBPCustomerList(customerNosList);
			} else {
				HashMap legacyNosMap = bpUserCustom.getLegacyNos();

				Iterator LegacyNosIter = legacyNosMap.keySet().iterator();
				List legacyNosList = new ArrayList();
				while (LegacyNosIter.hasNext()) {
					BPLegacyBDO bpLegacyBDO = new BPLegacyBDO();
					bpLegacyBDO.setLegacyNumber((String) LegacyNosIter.next());
					bpLegacyBDO.setAddressSeqNumber((String) legacyNosMap.get(bpLegacyBDO.getLegacyNumber()));
					bpLegacyBDO.setUserId(bpUserCustom.getUserId());
					legacyNosList.add(bpLegacyBDO);
				}
				userProfileBO.setBPLegactNoList(legacyNosList);
			}
			userProfileBO.validateForCreate(bpUserCustom.getSalesAreas());

			// We should check for IR 
			try {
				UserProfileConnectorDTO wiDTO = new UserProfileConnectorDTO();
				wiDTO.setUserID(userProfileBO.getUserId());

				UserProfileConnector wi = new UserProfileConnector();
				wiDTO = wi.getProfile(wiDTO);
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}

			try {
				userProfileBOFactory.createUserProfileBO(userProfileBO);
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			//Call the method to create the id in ESW
			ValidateBPAccessInputConnectorDTO validateBPAccessInputConnectorDTO = new ValidateBPAccessInputConnectorDTO();

			GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
			genericConnectorDTO.setSessionID(bpUserCustom.getSessionId());
			genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_VALIDATE_BP_ACCESS_OPPT);
			genericConnectorDTO.setUserID(userProfileBO.getUserId());
			validateBPAccessInputConnectorDTO.setSalesOrg(userProfileBO.getPrimarySalesOrg());

			if (UtilityConstants.BPCUSTOMERLIST_ACCESS_TYPE_OPPT.equals(accessType)) {
				String[] custList = new String[userProfileBO.getBPCustomerList().size()];
				List bpCustomerList = userProfileBO.getBPCustomerList();
				int size = bpCustomerList.size();

				for (int i = 0; i < size; i++) {
					custList[i] = bpCustomerList.get(i).toString();
				}
				validateBPAccessInputConnectorDTO.setCustListNo(custList);
				validateBPAccessInputConnectorDTO.setAccessOption(UtilityConstants.BPCUSTOMERLIST_ACCESS_TYPE_ESW);
			} else {
				validateBPAccessInputConnectorDTO.setAccessOption(UtilityConstants.BPLEGACYNO_ACCESS_TYPE_ESW);
				List custList = new ArrayList();

				HashMap bPLegacyMap = bpUserCustom.getLegacyNos();
				Iterator LegacyNosIter = bPLegacyMap.keySet().iterator();

				while (LegacyNosIter.hasNext()) {
					CustListAndSeqConnectorDTO custListConnectorDTO = new CustListAndSeqConnectorDTO();
					custListConnectorDTO.setLegacyCustNumber((String) LegacyNosIter.next());
					custListConnectorDTO.setAddSeqNumber((String) bPLegacyMap.get(custListConnectorDTO.getLegacyCustNumber()));
					custList.add(custListConnectorDTO);
				}
				validateBPAccessInputConnectorDTO.setCustListAndSeqConnectorDTO(custList);
			}
			validateBPAccessInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);

			JMSConnectorLocalHome jmsConnectorLocalHome = (JMSConnectorLocalHome) HomeProvider.getLocal(HomeProvider.JMS_CONNECTOR_LOCAL_HOME);

			JMSConnectorLocal jmsConnectorLocal = null;
			try {
				jmsConnectorLocal = jmsConnectorLocalHome.create();
			} catch (CreateException ex) {
				OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			ValidateBPAccessOutputConnectorDTO validateBPAccessOutputConnectorDTO = null;
			try {
				validateBPAccessOutputConnectorDTO = (ValidateBPAccessOutputConnectorDTO) jmsConnectorLocal.sendReceive(validateBPAccessInputConnectorDTO);

				validateBPAccessOutputConnectorDTO.setReturnCode(OPPTHelper.trimString(validateBPAccessOutputConnectorDTO.getReturnCode()));
			} catch (Exception ex) {
				OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(validateBPAccessOutputConnectorDTO.getReturnCode()) == false) {
				OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				throwBackendTypeServiceException(validateBPAccessOutputConnectorDTO.getReturnCode());
			}

			UseridMaintInputConnectorDTO useridMaintInputConnectorDTO = new UseridMaintInputConnectorDTO();

			genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_USERID_MAINT_OPPT);
			genericConnectorDTO.setSessionID(bpUserCustom.getSessionId());
			genericConnectorDTO.setUserID(userId);

			String[] salesOrgs = { bpUserCustom.getPrimarySalesArea()};
			String[] accesstype = { UtilityConstants.BPUSER_CREATE_DEFAULT_ACCESS_TYPE };

			useridMaintInputConnectorDTO.setAccessType(accesstype);
			useridMaintInputConnectorDTO.setSalesOrg(salesOrgs);
			useridMaintInputConnectorDTO.setFlag(UtilityConstants.USER_CREATE);
			useridMaintInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);

			UseridMaintOutputConnectorDTO useridMaintOutputConnectorDTO = null;

			try {
				useridMaintOutputConnectorDTO = (UseridMaintOutputConnectorDTO) jmsConnectorLocal.sendReceive(useridMaintInputConnectorDTO);

				useridMaintOutputConnectorDTO.setReturnCode(OPPTHelper.trimString(useridMaintOutputConnectorDTO.getReturnCode()));
			} catch (Exception ex) {
				OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			if (useridMaintOutputConnectorDTO == null || (ConnectorConstants.RFC_SUCCESS_CODE.equals(useridMaintOutputConnectorDTO.getReturnCode()) == false)) {
				OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				throwBackendTypeServiceException(useridMaintOutputConnectorDTO.getReturnCode());
			}

			//populate the mailingInfoDTO and send mail
			MailConnector communicationConnector = new MailConnector();
			MailConnectorDTO mailConnectorDTO = new MailConnectorDTO();
			//get info for User id 
			UserProfileConnectorDTO webIdentityConnectorDTO = new UserProfileConnectorDTO();
			UserProfileConnector webIdentityConnector = new UserProfileConnector();
			webIdentityConnectorDTO.setUserID(bpUserCustom.getUserId());

			try {
				webIdentityConnectorDTO = webIdentityConnector.getProfile(webIdentityConnectorDTO);
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}

			//get info for Admin id 
			UserProfileConnectorDTO webIdentityConnectorDTOAdmin = new UserProfileConnectorDTO();
			UserProfileConnector webIdentityConnectorAdmin = new UserProfileConnector();
			webIdentityConnectorDTOAdmin.setUserID(bpUserCustom.getUserId());

			try {
				webIdentityConnectorDTOAdmin = webIdentityConnectorAdmin.getProfile(webIdentityConnectorDTOAdmin);
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}

			//get info for Manager id 
			UserProfileConnectorDTO webIdentityConnectorDTOManager = new UserProfileConnectorDTO();
			UserProfileConnector webIdentityConnectorManager = new UserProfileConnector();
			webIdentityConnectorDTOManager.setUserID(bpUserCustom.getSelectedManager());

			try {
				webIdentityConnectorDTOManager = webIdentityConnectorAdmin.getProfile(webIdentityConnectorDTOManager);
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}

			PreparedString preparedString = new PreparedString(MailMessageConstants.USER_CREATION_MAIL_SUBJECT);
			preparedString.setString(1, OPPTHelper.trimString(bpUserCustom.getUserId()));
			mailConnectorDTO.setSubject(preparedString.toString());

			preparedString.clear(MailMessageConstants.USER_CREATION_USER_MAIL_TEXT);

			String firstName = webIdentityConnectorDTO.getFirstName();
			firstName = (firstName == null) ? "" : firstName;

			String lastName = webIdentityConnectorDTO.getLastName();
			lastName = (lastName == null) ? "" : lastName;

			preparedString.setString(1, new StringBuffer(firstName).append(" ").append(lastName).toString());

			preparedString.setString(2, OPPTHelper.trimString(bpUserCustom.getUserId()));
			preparedString.setString(3, Integer.toString(bpUserCustom.getRole()));
			preparedString.setString(4, "");
			preparedString.setString(5, bpUserCustom.getPrimarySalesArea());
			preparedString.setString(6, bpUserCustom.getPrimarySalesAreaAuthorization());
			preparedString.setString(7, OPPTPropertiesReader.getOpptUrl());
			mailConnectorDTO.setMsgText(preparedString.toString());

			mailConnectorDTO.setFromAddress(bpUserCustom.getEmailAddress());
			mailConnectorDTO.setToAddress(webIdentityConnectorDTO.getEmailAddress());
			mailConnectorDTO.setCcAddress(webIdentityConnectorDTOManager.getEmailAddress());

			try {
				mailConnectorDTO = communicationConnector.sendMail(mailConnectorDTO);
			} catch (ConnectorException e) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			}

			return bpUserCustom;
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *   This method goes to the factory and creates a Non BP User
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param nonBPUserCustom
	 * @return NonBPUserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	
	 */
	public NonBPUserCustomDTO createNonBPUser(NonBPUserCustomDTO nonBPUserCustom) throws ServiceException {
		String methodName = "createNonBPUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		/* Start change  CR0801074150 - CBS OPPT activity logging */
		StringBuffer newUserLog = new StringBuffer();
		/* End change  CR0801074150 - CBS OPPT activity logging */
		try {
			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();
			UserGroupBOFactory userGroupBOFactory = new UserGroupBOFactory();

			String userId = nonBPUserCustom.getUserId();
			String groupAccess = null;

			try {
				if (userProfileBOFactory.isUserIdExists(userId)) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0200);
				}
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
			
			String selectedManager = nonBPUserCustom.getSelectedManager();
			if (selectedManager.equals(UtilityConstants.NULL)) {
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0201);
			} else {

				UserProfileBO userProfileBO = new UserProfileBO();
				if(nonBPUserCustom.getUserType().equals(UtilityConstants.SOFTWARE_USER)) 
				{
					// Changes for OPPT UD - Balaji starts 
					TreeSet userGroup = nonBPUserCustom.getSelectedGroups();
					String groupName = null;
					if (userGroup != null && userGroup.size() > 0) {
						if (userGroup.first() != null) {
							groupName = (String) userGroup.first();
						}
					}
					//	String groupName = OPPTHelper.trimString(nonBPUserCustom.getSelectedGroup());
					
					userProfileBO.setUserId(nonBPUserCustom.getUserId());
					userProfileBO.setUserType(nonBPUserCustom.getUserType());
					userProfileBO.setRole(Integer.parseInt(nonBPUserCustom.getSelectedRole()));
					userProfileBO.setBaRole(0);
					userProfileBO.setGroupName(groupName);
					userProfileBO.setApproverId(nonBPUserCustom.getSelectedManager());
					userProfileBO.setPrimarySalesOrg(nonBPUserCustom.getPrimarySalesArea());
					userProfileBO.setAthorization(nonBPUserCustom.getPrimarySalesAreaAuthorization());
					if (null != nonBPUserCustom.getPrimarySalesAreaAuthorization() && "N".equals(nonBPUserCustom.getPrimarySalesAreaAuthorization().trim())) {
						userProfileBO.setAthorization(null);
					}
					userProfileBO.validateForCreate(nonBPUserCustom.getSalesAreaAccessType());
					
					/* MN28310042/MN32138047 - Access to multiple groups belonging to multiple GEOs 
					 * 
					 * if (Integer.parseInt(nonBPUserCustom.getSelectedRole()) == RoleConstants.CREATE_APPROVE || Integer.parseInt(nonBPUserCustom.getSelectedRole()) == RoleConstants.BHD) {
						validateForCreateApproveAndBHD(nonBPUserCustom.getSelectedRole(), nonBPUserCustom.getPrimarySalesArea(), nonBPUserCustom.getSalesAreaAccessType());
					} */
					try {
						userProfileBOFactory.createUserProfileBO(userProfileBO);
						if (userGroup != null && userGroup.size() > 0) {
							//	UD Changes starts
							Iterator iter = userGroup.iterator();
							StringBuffer groupAccessBuffer = new StringBuffer();
							while (iter.hasNext()) {
								UserGroupBO userGroupBO = new UserGroupBO();
								String localGroupName = OPPTHelper.trimString(iter.next().toString());
								userGroupBO.setGroupName(localGroupName);
								userGroupBO.setUserId(userProfileBO.getUserId());
								userGroupBOFactory.createUserGroupBO(userGroupBO);
								groupAccessBuffer.append(" ");
								groupAccessBuffer.append(localGroupName);
							}
							groupAccess = groupAccessBuffer.toString();
						}
						// UD changes ends

					} catch (DomainException ex) {
						OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
					}
				 }
				 else
				 {
					userProfileBO.setUserId(nonBPUserCustom.getUserId());
					userProfileBO.setUserType(nonBPUserCustom.getUserType());
					userProfileBO.setRole(0);
					userProfileBO.setBaRole(Integer.parseInt(nonBPUserCustom.getSelectedBaRole()));
					userProfileBO.setPrimarySalesOrg(nonBPUserCustom.getPrimarySalesArea());
					userProfileBO.setAthorization(nonBPUserCustom.getPrimarySalesAreaAuthorization());
					userProfileBO.setApproverId(nonBPUserCustom.getSelectedManager());
					
					/* EF0731086618 -  Illegal process of User ID creation via OPPT application.
					 * This function currently allows invalid user id to insert into the database.
					 * So that we commented this line, User id insert should be happened after the 
					 * Blue page validation. */ 
					
					try {
						userProfileBOFactory.createUserProfileBO(userProfileBO);
					} catch (DomainException ex) {
						OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
					} 
				 }
				// We should check for IR 
				UserProfileConnectorDTO wiDTO = new UserProfileConnectorDTO();
				UserProfileConnector wi = new UserProfileConnector();
				wiDTO.setUserID(userProfileBO.getUserId());

				try {
					wiDTO = wi.getProfile(wiDTO);
				} catch (ConnectorException ce) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
					getSessionContext().setRollbackOnly();
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
				} catch (Exception ex) {
					OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
					getSessionContext().setRollbackOnly();
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
				}

				//Call the method to create the id in ESW
				JMSConnectorLocalHome jmsConnectorLocalHome = (JMSConnectorLocalHome) HomeProvider.getLocal(HomeProvider.JMS_CONNECTOR_LOCAL_HOME);

				JMSConnectorLocal jmsConnectorLocal;
				try {
					jmsConnectorLocal = jmsConnectorLocalHome.create();
				} catch (CreateException ex) {
					OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
					getSessionContext().setRollbackOnly();

					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
				}

				UseridMaintInputConnectorDTO useridMaintInputConnectorDTO = new UseridMaintInputConnectorDTO();
				GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();

				genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_USERID_MAINT_OPPT);
				genericConnectorDTO.setSessionID(nonBPUserCustom.getSessionId());
				genericConnectorDTO.setUserID(userId);
				useridMaintInputConnectorDTO.setFlag(UtilityConstants.USER_CREATE);

				//set the salesOrg and access type 
				TreeMap salesOrgAccessType = nonBPUserCustom.getSalesAreaAccessType();
				String[] salesOrgArray = new String[salesOrgAccessType.size()];
				String[] accesstypeArray = new String[salesOrgAccessType.size()];

				int i = 0;

				Iterator salesOrgIterator = salesOrgAccessType.keySet().iterator();
				while (salesOrgIterator.hasNext()) {
					salesOrgArray[i] = (String) salesOrgIterator.next();
					accesstypeArray[i] = (String) salesOrgAccessType.get(salesOrgArray[i]);
					if (null != accesstypeArray[i] && "N".equals(accesstypeArray[i].trim())) {
						accesstypeArray[i] = null;
					}
					i++;
				}

				useridMaintInputConnectorDTO.setSalesOrg(salesOrgArray);
				useridMaintInputConnectorDTO.setAccessType(accesstypeArray);
				useridMaintInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);

				UseridMaintOutputConnectorDTO useridMaintOutputConnectorDTO = null;
				try {
					useridMaintOutputConnectorDTO = (UseridMaintOutputConnectorDTO) jmsConnectorLocal.sendReceive(useridMaintInputConnectorDTO);
					useridMaintOutputConnectorDTO.setReturnCode(OPPTHelper.trimString(useridMaintOutputConnectorDTO.getReturnCode()));
				//	useridMaintOutputConnectorDTO = new UseridMaintOutputConnectorDTO();
				//	useridMaintOutputConnectorDTO.setReturnCode(OPPTHelper.trimString("0"));

				} catch (Exception ex) {
					OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
					getSessionContext().setRollbackOnly();

					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
				}

				if (ConnectorConstants.RFC_SUCCESS_CODE.equals(useridMaintOutputConnectorDTO.getReturnCode()) == false) {
					OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
					getSessionContext().setRollbackOnly();

					throwBackendTypeServiceException(useridMaintOutputConnectorDTO.getReturnCode());
				}

				//populate the mailingInfoDTO and send mail
				MailConnector communicationConnector = new MailConnector();
				MailConnectorDTO mailConnectorDTO = new MailConnectorDTO();
				//get info for User id 
				UserProfileConnectorDTO webIdentityConnectorDTO = new UserProfileConnectorDTO();
				UserProfileConnector webIdentityConnector = new UserProfileConnector();
				webIdentityConnectorDTO.setUserID(nonBPUserCustom.getUserId());

				try {
					webIdentityConnectorDTO = webIdentityConnector.getProfile(webIdentityConnectorDTO);
					
				} catch (ConnectorException ce) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
				}
				//get info for Admin id 
				UserProfileConnectorDTO webIdentityConnectorDTOAdmin = new UserProfileConnectorDTO();
				UserProfileConnector webIdentityConnectorAdmin = new UserProfileConnector();
				webIdentityConnectorDTOAdmin.setUserID(nonBPUserCustom.getUserId());

				try {
					webIdentityConnectorDTOAdmin = webIdentityConnectorAdmin.getProfile(webIdentityConnectorDTOAdmin);
					
				} catch (ConnectorException ce) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
				}

				//get info for Manager id 
				UserProfileConnectorDTO webIdentityConnectorDTOManager = new UserProfileConnectorDTO();
				UserProfileConnector webIdentityConnectorManager = new UserProfileConnector();
				webIdentityConnectorDTOManager.setUserID(nonBPUserCustom.getSelectedManager());

				try {
					webIdentityConnectorDTOManager = webIdentityConnectorAdmin.getProfile(webIdentityConnectorDTOManager);
					
					
				} catch (ConnectorException ce) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
				}

				PreparedString preparedString = new PreparedString(MailMessageConstants.USER_CREATION_MAIL_SUBJECT);
				preparedString.setString(1, OPPTHelper.trimString(nonBPUserCustom.getUserId()));
				mailConnectorDTO.setSubject(preparedString.toString());

				preparedString.clear(MailMessageConstants.USER_CREATION_USER_MAIL_TEXT);

				String firstName = webIdentityConnectorDTO.getFirstName();
				firstName = (firstName == null) ? "" : firstName;

				String lastName = webIdentityConnectorDTO.getLastName();
				lastName = (lastName == null) ? "" : lastName;

				preparedString.setString(1, new StringBuffer(firstName).append(" ").append(lastName).toString());

				preparedString.setString(2, OPPTHelper.trimString(nonBPUserCustom.getUserId()));
				/**
				 * Defect 358
				 * MN19539229
				 * Balaji
				 */
				if(nonBPUserCustom.getUserType().equals(UtilityConstants.SOFTWARE_USER)){
					preparedString.setString(3, OPPTStaticDataHolder.getRoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedRole())));
				} else {
					preparedString.setString(3, OPPTStaticDataHolder.getBARoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedBaRole())));
				}
					
				preparedString.setString(4, groupAccess == null ? "" : groupAccess);

				/*
				 * Changes Made for MN 19769207
				 * Balaji
				 * Defect 8 
				  */
				StringBuffer salesOrgDetails = new StringBuffer();
				Iterator salesOrgIteratorForMail = salesOrgAccessType.keySet().iterator();
				while (salesOrgIteratorForMail.hasNext()) {
					String salesOrg = (String) salesOrgIteratorForMail.next();
					String accessTypeFromUI = (String) salesOrgAccessType.get(salesOrg);
					String accessType = "N";
                    // nonBPUserCustom.getPrimarySalesAreaAuthorization()
					if ("*".equals(OPPTHelper.trimString(accessTypeFromUI))) {
						accessType = "All";
					} else if ("S".equals(OPPTHelper.trimString(accessTypeFromUI))) {
						accessType = "Sensitive";
					} else if ("N".equals(OPPTHelper.trimString(accessTypeFromUI))) {
						accessType = "Non Sensitive";
					}

					salesOrgDetails.append(" Sales Area : ");
					salesOrgDetails.append(salesOrg).append("-").append(OPPTStaticDataHolder.getSalesOrgDesc(salesOrg));
					salesOrgDetails.append(" Access Type : ");
					salesOrgDetails.append(accessType);

				}
				preparedString.setString(5, salesOrgDetails.toString());
				preparedString.setString(6, OPPTPropertiesReader.getOpptUrl());
				preparedString.setString(7, OPPTStaticDataHolder.getUserTypeDesc(OPPTHelper.trimString(nonBPUserCustom.getUserType())));
				/*
				 * Changes Made for MN 19769207
				 * Balaji
				 * Defect 8 
				  */

				mailConnectorDTO.setMsgText(preparedString.toString());

				mailConnectorDTO.setFromAddress(nonBPUserCustom.getEmailAddress());
				mailConnectorDTO.setToAddress(webIdentityConnectorDTO.getEmailAddress());
				mailConnectorDTO.setCcAddress(webIdentityConnectorDTOManager.getEmailAddress());

				try {
					mailConnectorDTO = communicationConnector.sendMail(mailConnectorDTO);
				} catch (ConnectorException e) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				}
				
				/* Start change  CR0801074150 - CBS OPPT activity logging */
				newUserLog.append("User id:").append(nonBPUserCustom.getUserId()).append(" ");
				newUserLog.append("User Type:");
				if(nonBPUserCustom.getUserType().equals(UtilityConstants.SOFTWARE_USER)){
					newUserLog.append("Software User").append(" ").append("Role:");
					newUserLog.append(OPPTStaticDataHolder.getRoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedRole())));
				} else {
					newUserLog.append("Baseagreement User").append(" ").append("Role:");
					newUserLog.append(OPPTStaticDataHolder.getBARoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedBaRole())));
				}
				newUserLog.append(" ").append("Group Access:").append(groupAccess == null ? "" : groupAccess).append(" ").append("Sales Org details:").append(salesOrgDetails);
				/* End change  CR0801074150 - CBS OPPT activity logging */
			}
			/* Start change  CR0801074150 - CBS OPPT activity logging */
			OPPTLogger.infoActivityLogger("Geo Security officer " + nonBPUserCustom.getSelectedManager() + " successfully created OPPT profile for user id " + nonBPUserCustom.getUserId()+ "!",CLASS_NAME, methodName);
			OPPTLogger.infoActivityLogger("The details for the new user are " + newUserLog.toString(),CLASS_NAME, methodName);
			 	/* End change  CR0801074150 - CBS OPPT activity logging */
			
			String message= "Geo Security officer "+nonBPUserCustom.getGeoSecOff() + " successfully created OPPT profile for user id " + nonBPUserCustom.getUserId()+ "!";
			createActivityLog(nonBPUserCustom.getGeoSecOff(),message);
			 //String message="The details for the new user are " + newUserLog.toString();
			//createActivityLog(nonBPUserCustom.getGeoSecOff(),message);
			
			
			
			return nonBPUserCustom;
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *   This method goes to the factory and gets roles and salesOrg 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param createUserCustom
	 * @return CreateUserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public CreateUserCustomDTO createNewUser(CreateUserCustomDTO createUserCustom) throws ServiceException {
		String methodName = "createNewUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			ProfileInputBOFactory profileInputBOFactory = new ProfileInputBOFactory();

			ProfileInputBO profileInputBO = new ProfileInputBO();
			UserProfileBO userProfileBO = new UserProfileBO();

			try {
				profileInputBO = profileInputBOFactory.getProfileInputBO();
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			//For Getting Roles
			List roleList = profileInputBO.getRoleList();
			TreeMap roleMap = new TreeMap();
			RoleBDO role;

			String admin = Integer.toString(RoleConstants.ADMINISTRATOR);
			for (int i = 0; i < roleList.size(); i++) {
				role = (RoleBDO) roleList.get(i);

				if (admin.equals(role.getRole()) == false) {
					roleMap.put(OPPTHelper.trimString(role.getRole()), OPPTHelper.trimString(role.getRoleDescription()));
				}
			}

			//For Getting SalesOrg
			List salesOrgList = profileInputBO.getSalesOrgList();
			SalesOrgBDO salesOrg = null;

			TreeMap salesOrgMap = new TreeMap();

			for (int i = 0; i < salesOrgList.size(); i++) {
				salesOrg = (SalesOrgBDO) salesOrgList.get(i);
				salesOrgMap.put(OPPTHelper.trimString(salesOrg.getSalesOrg()), OPPTHelper.trimString(salesOrg.getSalesOrgDesc()));
			}
			
			//For Getting UserTypes
			List UserTypeList = profileInputBO.getUserTypeList();
			UserTypeBDO userType = null;

			TreeMap UserTypeMap = new TreeMap();

			for (int i = 0; i < UserTypeList.size(); i++) {
				userType = (UserTypeBDO) UserTypeList.get(i);
				UserTypeMap.put(OPPTHelper.trimString(userType.getUserType()), OPPTHelper.trimString(userType.getUserTypeDescription()));
			}			

			//For Getting BARoles
			List baRoleList = profileInputBO.getBaRoleList();
			BARoleBDO baRole = null;

			TreeMap baRoleMap = new TreeMap();

			for (int i = 0; i < baRoleList.size(); i++) {
				baRole = (BARoleBDO) baRoleList.get(i);
				baRoleMap.put(OPPTHelper.trimString(baRole.getRole()), OPPTHelper.trimString(baRole.getRoleDescription()));
			}			
			createUserCustom.setRoles(roleMap);
			createUserCustom.setSalesAreas(salesOrgMap);
			createUserCustom.setUserTypes(UserTypeMap);
			createUserCustom.setBaRoles(baRoleMap);

			return createUserCustom;
		} catch (ServiceException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  This method goes to the factory and gets the data for a BP user required for Edit 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bpUserCustom
	 * @return BPUserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public BPUserCustomDTO editBPUser(BPUserCustomDTO bpUserCustom) throws ServiceException {
		String methodName = "editBPUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();
			ProfileInputBOFactory profileInputBOFactory = new ProfileInputBOFactory();

			ProfileInputBO profileInputBO = null;
			UserProfileBO userProfileBO = null;

			try {
				userProfileBO = userProfileBOFactory.getUserProfileBO(bpUserCustom.getUserId());
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			bpUserCustom.setSelectedRole(Integer.toString(userProfileBO.getRole()));
			bpUserCustom.setSelectedManager(OPPTHelper.trimString(userProfileBO.getApproverId()));
			bpUserCustom.setPrimarySalesArea(OPPTHelper.trimString(userProfileBO.getPrimarySalesOrg()));
			bpUserCustom.setAccessType(OPPTHelper.trimString(userProfileBO.getBPAccessIndicator()));

			if (UtilityConstants.BPLEGACYNO_ACCESS_TYPE_OPPT.equals(userProfileBO.getBPAccessIndicator())) {
				HashMap legacyNosMap = new HashMap();
				BPLegacyBDO bpLegacyBDO;

				Iterator iter = userProfileBO.getBPLegactNoList().iterator();

				while (iter.hasNext()) {
					bpLegacyBDO = (BPLegacyBDO) iter.next();
					legacyNosMap.put(bpLegacyBDO.getLegacyNumber(), bpLegacyBDO.getAddressSeqNumber());
				}
				bpUserCustom.setLegacyNos(legacyNosMap);
			} else {
				ArrayList customerNosList = new ArrayList();

				Iterator iter = userProfileBO.getBPCustomerList().iterator();
				BPCustomerListBDO bPCustomerListBDO;

				while (iter.hasNext()) {
					bPCustomerListBDO = (BPCustomerListBDO) iter.next();
					customerNosList.add(bPCustomerListBDO.getCustListNo());
				}
				bpUserCustom.setCustomerNumbers(customerNosList);
			}

			// Existing information related to the User id
			String primarySalesOrg = OPPTHelper.trimString(bpUserCustom.getPrimarySalesArea());

			try {
				profileInputBO = profileInputBOFactory.getProfileInputBO();
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			List roleList = profileInputBO.getRoleList();
			TreeMap roleMap = new TreeMap();

			RoleBDO role;
			String partnerRole = Integer.toString(RoleConstants.BUSINESS_PARTNER);

			for (int i = 0; i < roleList.size(); i++) {
				role = (RoleBDO) roleList.get(i);
				if (partnerRole.equals(role.getRole())) {
					roleMap.put(OPPTHelper.trimString(role.getRole()), OPPTHelper.trimString(role.getRoleDescription()));
				}
			}

			SalesOrgBDO salesOrg;

			TreeMap salesOrgMap = new TreeMap();
			List salesOrgList = profileInputBO.getSalesOrgList();
			for (int i = 0; i < salesOrgList.size(); i++) {
				salesOrg = (SalesOrgBDO) salesOrgList.get(i);
				salesOrgMap.put(OPPTHelper.trimString(salesOrg.getSalesOrg()), OPPTHelper.trimString(salesOrg.getSalesOrgDesc()));
			}

			bpUserCustom.setRoles(roleMap);
			bpUserCustom.setSalesAreas(salesOrgMap);
			bpUserCustom.setManagers(getManagerAndAdministrators(primarySalesOrg));

			return bpUserCustom;
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  This method goes to the factory and gets the data for a Non BP user required for Edit
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param createUserCustom
	 * @return CreateUserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public NonBPUserCustomDTO editNonBPUser(NonBPUserCustomDTO nonBPUserCustom) throws ServiceException {
		String methodName = "editNonBPUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		/* Start change  CR0801074150 - CBS OPPT activity logging */
		StringBuffer newUserLog = new StringBuffer();
		StringBuffer salesOrgDetails = new StringBuffer();
		StringBuffer groupAccessBuffer = new StringBuffer();
		/* End change  CR0801074150 - CBS OPPT activity logging */

		try {
			ProfileInputBO profileInputBO = null;
			UserProfileBO userProfileBO = null;

			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();

			try {
				userProfileBO = userProfileBOFactory.getUserProfileBO(nonBPUserCustom.getUserId());
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			JMSConnectorLocalHome jmsConnectorLocalHome = (JMSConnectorLocalHome) HomeProvider.getLocal(HomeProvider.JMS_CONNECTOR_LOCAL_HOME);
			JMSConnectorLocal jmsConnectorLocal = null;
			try {
				jmsConnectorLocal = jmsConnectorLocalHome.create();
			} catch (CreateException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			RetrieveUserAuthInputConnectorDTO retrieveAuthInputConnectorDTO = new RetrieveUserAuthInputConnectorDTO();
			RetrieveUserAuthOutputConnectorDTO retrieveUserAuthOutputConnectorDTO = null;

			RetrieveUserAuthConnectorDTO retrieveUserAuthConnectorDTO = new RetrieveUserAuthConnectorDTO();
			GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();

			genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_USERAUTH_OPPT);
			genericConnectorDTO.setSessionID(nonBPUserCustom.getSessionId());
			genericConnectorDTO.setUserID(nonBPUserCustom.getUserId());
			retrieveAuthInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
			try {
				retrieveUserAuthOutputConnectorDTO = (RetrieveUserAuthOutputConnectorDTO) jmsConnectorLocal.sendReceive(retrieveAuthInputConnectorDTO);

				retrieveUserAuthOutputConnectorDTO.setReturnCode(OPPTHelper.trimString(retrieveUserAuthOutputConnectorDTO.getReturnCode()));
			} catch (Exception ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(retrieveUserAuthOutputConnectorDTO.getReturnCode()) == false) {
				throwBackendTypeServiceException(retrieveUserAuthOutputConnectorDTO.getReturnCode());
			}

			List retrieveUserAuthConnectorDTOList = retrieveUserAuthOutputConnectorDTO.getRetrieveUserAuthConnectorDTO();

			String primarySalesOrg = OPPTHelper.trimString(userProfileBO.getPrimarySalesOrg());
			primarySalesOrg = (primarySalesOrg == null) ? "" : primarySalesOrg;

			String salesArea;

			//set the output of RFC into the nonBPUserCustom	
			TreeMap salesOrgAccessTypeMap = new TreeMap();
			for (int i = 0; i < retrieveUserAuthConnectorDTOList.size(); i++) {
				retrieveUserAuthConnectorDTO = (RetrieveUserAuthConnectorDTO) retrieveUserAuthConnectorDTOList.get(i);

				salesArea = OPPTHelper.trimString(retrieveUserAuthConnectorDTO.getSalesArea());
				if (primarySalesOrg.equals(salesArea) == false) {
					String accessType = OPPTHelper.trimString(retrieveUserAuthConnectorDTO.getAccessType());
					if (null == OPPTHelper.trimStringToNull(accessType)) {
						accessType = "N";
					}
					salesOrgAccessTypeMap.put(salesArea, OPPTHelper.trimString(accessType));
				}
				/* Start change  CR0801074150 - CBS OPPT activity logging */
				String logAccessType = retrieveUserAuthConnectorDTO.getAccessType();
				if (null == OPPTHelper.trimStringToNull(logAccessType)) {
					logAccessType = "N";
				}
				if ("*".equals(OPPTHelper.trimString(logAccessType))) {
					logAccessType = "All";
				} else if ("S".equals(OPPTHelper.trimString(logAccessType))) {
					logAccessType = "Sensitive";
				} else if ("N".equals(OPPTHelper.trimString(logAccessType))) {
					logAccessType = "Non Sensitive";
				}
				salesOrgDetails.append(" Sales Area:");
				salesOrgDetails.append(salesArea).append("-" ).append(OPPTStaticDataHolder.getSalesOrgDesc(salesArea));
				salesOrgDetails.append(" Access Type:");
				salesOrgDetails.append(logAccessType);
				/* End change  CR0801074150 - CBS OPPT activity logging */

			}

			nonBPUserCustom.setSalesAreaAccessType(salesOrgAccessTypeMap);
			//To populate the drop boxes in edit
			ProfileInputBOFactory profileInputBOFactory = new ProfileInputBOFactory();
			GroupBOFactory groupBOFactory = new GroupBOFactory();
			GeoSecOffBOFactory geoSecOffBOFactory = new GeoSecOffBOFactory();
			nonBPUserCustom.setSelectedRole(Integer.toString(userProfileBO.getRole()));
			nonBPUserCustom.setSelectedBaRole(Integer.toString(userProfileBO.getBaRole()));
			
			if(userProfileBO.getUserType().equals(UtilityConstants.SOFTWARE_USER)) 
			{
				// Start of UD changes - Balaji 
				UserGroupBOFactory userGroupBOFactory = new UserGroupBOFactory();
				List userGroupList = userGroupBOFactory.findUserGroupBO(OPPTHelper.trimString(nonBPUserCustom.getUserId()));
	
				TreeSet userGroupSet = new TreeSet();
				for (int i = 0; i < userGroupList.size(); i++) {
					UserGroupBO userGroupBO = (UserGroupBO) userGroupList.get(i);
					userGroupSet.add(userGroupBO.getGroupName());
					/* Start change  CR0801074150 - CBS OPPT activity logging */
					groupAccessBuffer.append(userGroupBO.getGroupName());
					if (!(userGroupList.size()== i+1)){
						groupAccessBuffer.append(","); }
					/* end change  CR0801074150 - CBS OPPT activity logging */
				}
				nonBPUserCustom.setSelectedGroups(userGroupSet);
				
				TreeSet groupsThatCannotBeDeleted = listGroupsforWhichUsersHaveProposals(OPPTHelper.trimString(nonBPUserCustom.getUserId()), userProfileBO.getRole(), userGroupList);
				nonBPUserCustom.setGroupsThatCannotBeDeleted(groupsThatCannotBeDeleted);
	
				// End of UD changes  - Balaji
			}			
			
			nonBPUserCustom.setSelectedManager(OPPTHelper.trimString(userProfileBO.getApproverId()));
			nonBPUserCustom.setPrimarySalesArea(primarySalesOrg);
			nonBPUserCustom.setPrimarySalesAreaAuthorization(OPPTHelper.trimString(userProfileBO.getAthorization()));
			if (null == OPPTHelper.trimStringToNull(nonBPUserCustom.getPrimarySalesAreaAuthorization())) {
				nonBPUserCustom.setPrimarySalesAreaAuthorization("N");
			}

			//Existing information related to the User id			
			primarySalesOrg = OPPTHelper.trimString(nonBPUserCustom.getPrimarySalesArea());

			//For getting Roles,SalesOrgs,UserType & BaRole
			try {
				profileInputBO = profileInputBOFactory.getProfileInputBO();
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
//			For Getting Roles
			List roleList = profileInputBO.getRoleList();

			RoleBDO role = null;
			TreeMap roleMap = new TreeMap();

			String partner = Integer.toString(RoleConstants.BUSINESS_PARTNER);
			String admin = Integer.toString(RoleConstants.ADMINISTRATOR);

			for (int i = 0; i < roleList.size(); i++) {
				role = (RoleBDO) roleList.get(i);
				if ((partner.equals(role.getRole()) == false) && (admin.equals(role.getRole()) == false)) {
					roleMap.put(OPPTHelper.trimString(role.getRole()), OPPTHelper.trimString(role.getRoleDescription()));
				}
			}

//			For Getting salesOrgs
			List salesOrgList = profileInputBO.getSalesOrgList();
			SalesOrgBDO salesOrg = null;

			TreeMap salesOrgMap = new TreeMap();

			for (int i = 0; i < salesOrgList.size(); i++) {
				salesOrg = (SalesOrgBDO) salesOrgList.get(i);
				salesOrgMap.put(OPPTHelper.trimString(salesOrg.getSalesOrg()), OPPTHelper.trimString(salesOrg.getSalesOrgDesc()));
			}
			
//			For Getting UserTypes
			List UserTypeList = profileInputBO.getUserTypeList();
			UserTypeBDO userType = null;

			TreeMap UserTypeMap = new TreeMap();

			for (int i = 0; i < UserTypeList.size(); i++) {
				userType = (UserTypeBDO) UserTypeList.get(i);
				UserTypeMap.put(OPPTHelper.trimString(userType.getUserType()), OPPTHelper.trimString(userType.getUserTypeDescription()));
			}			

			//For Getting BARoles
			List baRoleList = profileInputBO.getBaRoleList();
			BARoleBDO baRole = null;

			TreeMap baRoleMap = new TreeMap();

			for (int i = 0; i < baRoleList.size(); i++) {
				baRole = (BARoleBDO) baRoleList.get(i);
				baRoleMap.put(OPPTHelper.trimString(baRole.getRole()), OPPTHelper.trimString(baRole.getRoleDescription()));
			}	
			
			if(userProfileBO.getUserType().equals(UtilityConstants.SOFTWARE_USER)) 
			{
				// For getting Groups
				/*
				List groupList = null;
				try {
					groupList = groupBOFactory.findGroupBOForSalesOrg(primarySalesOrg);
				} catch (DomainException ex) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
				}
	
				GroupBO groupBO;
				TreeMap groupMap = new TreeMap();
	
				for (int i = 0; i < groupList.size(); i++) {
					groupBO = (GroupBO) groupList.get(i);
					groupMap.put(OPPTHelper.trimString(groupBO.getGroupName()), OPPTHelper.trimString(groupBO.getGroupName()));
				}
				nonBPUserCustom.setGroups(groupMap); */
				
				ArrayList groupList = new ArrayList();
				try {
					
					List geoSecOffList = geoSecOffBOFactory.findAllGEOSecForSalesOrg(primarySalesOrg);
					for (int i = 0; i < geoSecOffList.size(); i++) {
						GeoSecOffBO geoSecOffBO = (GeoSecOffBO) geoSecOffList.get(i);
						List localGroupList = groupBOFactory.findGroupBOForSalesOrg(OPPTHelper.trimString(geoSecOffBO.getSalesOrg()));
						groupList.addAll(localGroupList);
					}
				} catch (DomainException ex) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
								throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
				}
				// UD Changes ends here
				GroupBO groupBO;
				TreeMap groupMap = new TreeMap();
	
				for (int i = 0; i < groupList.size(); i++) {
					groupBO = (GroupBO) groupList.get(i);
					groupMap.put(OPPTHelper.trimString(groupBO.getGroupName()), OPPTHelper.trimString(groupBO.getGroupName()));
				}
				nonBPUserCustom.setGroups(groupMap);
			 }			

			// Get the GeoSecOfficer for the Primary Sales Org
			GeoSecOffBO geoSecOffBO = null;
			try {
				geoSecOffBO = geoSecOffBOFactory.findGEOSecOffBOForSalesOrg(primarySalesOrg);
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			String selectedGeoSecOfficer = OPPTHelper.trimString(geoSecOffBO.getGeoSecOffSO());
			// Set the drop box values for roles, groups, managers,userTypes,BaRoles
			nonBPUserCustom.setRoles(roleMap);
			nonBPUserCustom.setSalesAreas(salesOrgMap);
			nonBPUserCustom.setUserTypes(UserTypeMap);
			nonBPUserCustom.setBaRoles(baRoleMap);
			nonBPUserCustom.setManagers(getManagerAndAdministrators(primarySalesOrg));
			nonBPUserCustom.setGeoSecOfficer(selectedGeoSecOfficer);
			
			/* Start change  CR0801074150 - CBS OPPT activity logging */
			newUserLog.append("User Id:").append(nonBPUserCustom.getUserId()).append(" ");
			newUserLog.append("User Type:");
			if(nonBPUserCustom.getUserType().equals(UtilityConstants.SOFTWARE_USER)){
				newUserLog.append("Software User").append(" ").append("Role:");
				newUserLog.append(OPPTStaticDataHolder.getRoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedRole())));
			} else {
				newUserLog.append("Baseagreement User").append(" ").append("Role:");
				newUserLog.append(OPPTStaticDataHolder.getBARoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedBaRole())));
			}
			newUserLog.append(" ").append("Group Access:").append(groupAccessBuffer.toString()).append(" ").append("Sales Org details:").append(salesOrgDetails);
		    OPPTLogger.infoActivityLogger("The details for the user before editing are " + newUserLog.toString(),CLASS_NAME, methodName);
		/* End change  CR0801074150 - CBS OPPT activity logging */
			return nonBPUserCustom;
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  This method goes to the factory and gets the Users for Sales Org 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param usersCustom
	 * @return UsersCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public UsersCustomDTO listUsersInSalesOrg(UsersCustomDTO usersCustom) throws ServiceException {
		String methodName = "listUsersInSalesOrg";
		ErrorReport errorReport = null;
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			String primarySalesOrg = OPPTHelper.trimString(usersCustom.getSelectedSalesArea());

			TreeMap salesOrgTreeMap = usersCustom.getSalesAreas();

			if (salesOrgTreeMap == null || primarySalesOrg == null) {
				ProfileInputBO profileInputBO = null;
				ProfileInputBOFactory profileInputBOFactory = new ProfileInputBOFactory();

				salesOrgTreeMap = new TreeMap();
				try {
					profileInputBO = profileInputBOFactory.getSalesOrg();
				} catch (DomainException ex) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
				}

				SalesOrgBDO salesOrg;
				List salesOrgList = profileInputBO.getSalesOrgList();
				for (int i = 0; i < salesOrgList.size(); i++) {
					salesOrg = (SalesOrgBDO) salesOrgList.get(i);
					salesOrgTreeMap.put(OPPTHelper.trimString(salesOrg.getSalesOrg()), OPPTHelper.trimString(salesOrg.getSalesOrgDesc()));
				}
				usersCustom.setSalesAreas(salesOrgTreeMap);
			}

			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();
			List userProfileList = null;

			try {
				userProfileList = userProfileBOFactory.findUserProfileBOForSalesOrg(primarySalesOrg);
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			if (userProfileList == null || userProfileList.size() == 0) {
				//throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0202);
				errorReport = new ErrorReport();
				errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.SE0202, OPPTMessageCatalog.TYPE_SERVICE), null);
				usersCustom.setMessageReport(errorReport);
				return usersCustom;
			}

			//populate the data in UsersCustomDTO	
			Iterator iter = userProfileList.iterator();
			UserProfileBO userProfileBO = null;

			while (iter.hasNext()) {
				userProfileBO = (UserProfileBO) iter.next();
				if (userProfileBO.getRole() != RoleConstants.ADMINISTRATOR) {
					UserCustomDTO userCustomDTO = new UserCustomDTO();
					userCustomDTO.setUserId(OPPTHelper.trimString(userProfileBO.getUserId()));
					userCustomDTO.setUserType(OPPTHelper.trimString(userProfileBO.getUserType()));
					userCustomDTO.setBaUserRole(userProfileBO.getBaRole());
					userCustomDTO.setRole(userProfileBO.getRole());
					userCustomDTO.setSalesOrg(userProfileBO.getPrimarySalesOrg());
					userCustomDTO.setGroup(userProfileBO.getGroupName());
					userCustomDTO.setApprovedBy(OPPTHelper.trimString(userProfileBO.getApproverId()));
					usersCustom.addUser(userCustomDTO);
				}
			}

			return usersCustom;
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  This method goes to the factory and registers a BP User 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bpUserCustom
	 * @return BPUserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public BPUserCustomDTO registerBPUser(BPUserCustomDTO bpUserCustom) throws ServiceException {
		String methodName = "registerBPUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();
			String userId = bpUserCustom.getUserId();

			try {
				if (userProfileBOFactory.isUserIdExists(userId)) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0200);
				}
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			String selectedManager = bpUserCustom.getSelectedManager();
			if (UtilityConstants.NULL.equals(selectedManager)) {
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0201);
			}

			UserProfileBO userProfileBO = new UserProfileBO();
			userProfileBO.setUserId(bpUserCustom.getUserId());
			userProfileBO.setRole(bpUserCustom.getRole());
			userProfileBO.setBPAccessIndicator(bpUserCustom.getAccessType());
			userProfileBO.setPrimarySalesOrg(bpUserCustom.getPrimarySalesArea());
			userProfileBO.setAthorization(UtilityConstants.BPUSER_CREATE_DEFAULT_ACCESS_TYPE);
			userProfileBO.setApproverId(bpUserCustom.getSelectedManager());

			if (UtilityConstants.BPCUSTOMERLIST_ACCESS_TYPE_OPPT.equals(bpUserCustom.getAccessType())) {
				List customerNosList = new ArrayList();
				Iterator iter = bpUserCustom.getCustomerNumbers().iterator();
				BPCustomerListBDO bPCustomerListBDO;

				while (iter.hasNext()) {
					bPCustomerListBDO = new BPCustomerListBDO();
					bPCustomerListBDO.setCustListNo((String) iter.next());
					bPCustomerListBDO.setUserId(bpUserCustom.getUserId());
					customerNosList.add(bPCustomerListBDO);
				}
				userProfileBO.setBPCustomerList(customerNosList);
			} else {
				HashMap legacyNosMap = bpUserCustom.getLegacyNos();

				Iterator LegacyNosIter = legacyNosMap.keySet().iterator();
				List legacyNosList = new ArrayList();
				while (LegacyNosIter.hasNext()) {
					BPLegacyBDO bpLegacyBDO = new BPLegacyBDO();
					bpLegacyBDO.setLegacyNumber((String) LegacyNosIter.next());
					bpLegacyBDO.setAddressSeqNumber((String) legacyNosMap.get(bpLegacyBDO.getLegacyNumber()));
					bpLegacyBDO.setUserId(bpUserCustom.getUserId());
					legacyNosList.add(bpLegacyBDO);
				}
				userProfileBO.setBPLegactNoList(legacyNosList);
			}

			userProfileBO.validateForCreate(bpUserCustom.getSalesAreas());

			//Populate the ValidateBPAccessInputConnectorDTO and fire the RFC
			ValidateBPAccessInputConnectorDTO validateBPAccessInputConnectorDTO = new ValidateBPAccessInputConnectorDTO();
			ValidateBPAccessOutputConnectorDTO validateBPAccessOutputConnectorDTO = null;

			GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
			genericConnectorDTO.setSessionID(bpUserCustom.getSessionId());
			genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_VALIDATE_BP_ACCESS_OPPT);
			genericConnectorDTO.setUserID(userProfileBO.getUserId());
			validateBPAccessInputConnectorDTO.setSalesOrg(userProfileBO.getPrimarySalesOrg());

			if (UtilityConstants.BPCUSTOMERLIST_ACCESS_TYPE_OPPT.equals(bpUserCustom.getAccessType())) {
				String[] custList = new String[userProfileBO.getBPCustomerList().size()];
				for (int i = 0; i < userProfileBO.getBPCustomerList().size(); i++) {
					custList[i] = userProfileBO.getBPCustomerList().get(i).toString();
				}
				validateBPAccessInputConnectorDTO.setCustListNo(custList);
				validateBPAccessInputConnectorDTO.setAccessOption(UtilityConstants.BPCUSTOMERLIST_ACCESS_TYPE_ESW);
			} else {
				validateBPAccessInputConnectorDTO.setAccessOption(UtilityConstants.BPLEGACYNO_ACCESS_TYPE_ESW);
				CustListAndSeqConnectorDTO custListAndSeqConnectorDTO;
				HashMap bPLegacyMap = bpUserCustom.getLegacyNos();
				List custList = new ArrayList();
				Iterator LegacyNosIter = bPLegacyMap.keySet().iterator();
				while (LegacyNosIter.hasNext()) {
					custListAndSeqConnectorDTO = new CustListAndSeqConnectorDTO();
					custListAndSeqConnectorDTO.setLegacyCustNumber((String) LegacyNosIter.next());
					custListAndSeqConnectorDTO.setAddSeqNumber((String) bPLegacyMap.get(custListAndSeqConnectorDTO.getLegacyCustNumber()));
					custList.add(custListAndSeqConnectorDTO);
				}
				validateBPAccessInputConnectorDTO.setCustListAndSeqConnectorDTO(custList);
			}
			validateBPAccessInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);

			JMSConnectorLocalHome jmsConnectorLocalHome = (JMSConnectorLocalHome) HomeProvider.getLocal(HomeProvider.JMS_CONNECTOR_LOCAL_HOME);
			JMSConnectorLocal jmsConnectorLocal = null;
			try {
				jmsConnectorLocal = jmsConnectorLocalHome.create();
			} catch (CreateException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			try {
				validateBPAccessOutputConnectorDTO = (ValidateBPAccessOutputConnectorDTO) jmsConnectorLocal.sendReceive(validateBPAccessInputConnectorDTO);

				validateBPAccessOutputConnectorDTO.setReturnCode(OPPTHelper.trimString(validateBPAccessOutputConnectorDTO.getReturnCode()));
			} catch (Exception ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(validateBPAccessOutputConnectorDTO.getReturnCode())) {
				throwBackendTypeServiceException(validateBPAccessOutputConnectorDTO.getReturnCode());
			}

			//Now Populate the mailingInfoDTO and send mail	
			MailConnector communicationConnector = new MailConnector();
			MailConnectorDTO mailConnectorDTO = new MailConnectorDTO();

			//get info for User id 
			UserProfileConnectorDTO wiDTO = new UserProfileConnectorDTO();
			UserProfileConnector wi = new UserProfileConnector();
			wiDTO.setUserID(bpUserCustom.getUserId());

			try {
				wiDTO = wi.getProfile(wiDTO);
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}
			//get info for Manager id 
			UserProfileConnectorDTO wiDTOManager = new UserProfileConnectorDTO();
			UserProfileConnector wiManager = new UserProfileConnector();
			wiDTOManager.setUserID(bpUserCustom.getSelectedManager());

			try {
				wiDTOManager = wiManager.getProfile(wiDTOManager);
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}
			List adminList = null;
			try {
				adminList = userProfileBOFactory.findUserProfileBOForSalesOrg(bpUserCustom.getPrimarySalesArea());
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			Iterator iter = adminList.iterator();

			//get info for Admin id's 
			UserProfileConnectorDTO wiDTOAdmin;
			UserProfileConnector wiAdmin = new UserProfileConnector();

			StringBuffer emailIds = new StringBuffer();
			while (iter.hasNext()) {
				userProfileBO = (UserProfileBO) iter.next();
				if (userProfileBO.getRole() == RoleConstants.ADMINISTRATOR) {
					wiDTOAdmin = new UserProfileConnectorDTO();
					wiDTOAdmin.setUserID(userProfileBO.getUserId());
					try {
						wiDTOAdmin = wiAdmin.getProfile(wiDTOAdmin);
					} catch (ConnectorException ce) {
						OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
					}

					if (emailIds.length() > 0) {
						emailIds = emailIds.append(", ");
					}

					emailIds = emailIds.append(wiDTOAdmin.getEmailAddress());
				}
			}
			PreparedString preparedString = new PreparedString(MailMessageConstants.REGISTRATION_USER_MAIL_SUBJECT);
			preparedString.setString(1, OPPTHelper.trimString(bpUserCustom.getUserId()));
			mailConnectorDTO.setSubject(preparedString.toString());

			preparedString.clear(MailMessageConstants.REGISTRATION_USER_MAIL_TEXT);

			String firstName = wiDTO.getFirstName();
			firstName = (firstName == null) ? "" : firstName;

			String lastName = wiDTO.getLastName();
			lastName = (lastName == null) ? "" : lastName;

			preparedString.setString(1, new StringBuffer(firstName).append(" ").append(lastName).toString());

			preparedString.setString(2, OPPTHelper.trimString(bpUserCustom.getUserId()));
			preparedString.setString(3, new Integer(bpUserCustom.getRole()).toString());
			preparedString.setString(4, "");
			preparedString.setString(5, bpUserCustom.getPrimarySalesArea());
			preparedString.setString(6, bpUserCustom.getPrimarySalesAreaAuthorization());
			preparedString.setString(7, OPPTPropertiesReader.getOpptUrl());

			mailConnectorDTO.setMsgText(preparedString.toString());

			mailConnectorDTO.setFromAddress(wiDTO.getEmailAddress());
			mailConnectorDTO.setToAddress(wiDTOManager.getEmailAddress());
			mailConnectorDTO.setCcAddress(emailIds.toString());

			try {
				mailConnectorDTO = communicationConnector.sendMail(mailConnectorDTO);
			} catch (ConnectorException e) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			}

			ErrorReport errorReport = new ErrorReport();
			errorReport = ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0214, OPPTMessageCatalog.TYPE_SERVICE);

			bpUserCustom.setMessageReport(errorReport);

			return bpUserCustom;
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  This method goes to the factory and registers a Non BP User 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param createUserCustom
	 * @return CreateUserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public NonBPUserCustomDTO registerNonBPUser(NonBPUserCustomDTO nonBPUserCustom) throws ServiceException {
		String methodName = "registerNonBPUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();
			UserProfileBO userProfileBO = new UserProfileBO();
			String groupAccess = null;

			String userId = nonBPUserCustom.getUserId();
			try {
				if (userProfileBOFactory.isUserIdExists(userId)) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0200);
				}
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			String selectedManager = nonBPUserCustom.getSelectedManager();
			if (UtilityConstants.NULL.equals(selectedManager)) {
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0201);
			}

			if(nonBPUserCustom.getUserType().equals(UtilityConstants.SOFTWARE_USER)) 
			{
				//	Changes for OPPT UD - Balaji starts 
				TreeSet userGroup = nonBPUserCustom.getSelectedGroups();
				String groupName = null;
				if (userGroup != null && userGroup.size() > 0) {
					if (userGroup.first() != null) {
						groupName = (String) userGroup.first();
					}
					Iterator iter = userGroup.iterator();
					StringBuffer groupAccessBuffer = new StringBuffer();
					while (iter.hasNext()) {
						groupAccessBuffer.append(" ");
						groupAccessBuffer.append(OPPTHelper.trimString(iter.next().toString()));
						groupAccessBuffer.append(", ");
					}
					groupAccess = groupAccessBuffer.toString();
				}
				//	Changes for OPPT UD - Balaji ends 
			    //	String groupName = OPPTHelper.trimString(nonBPUserCustom.getSelectedGroup());
				userProfileBO.setUserId(nonBPUserCustom.getUserId());
				userProfileBO.setUserType(nonBPUserCustom.getUserType());
				userProfileBO.setRole(nonBPUserCustom.getRole());
				userProfileBO.setGroupName(groupName);
				userProfileBO.setApproverId(nonBPUserCustom.getSelectedManager());
				userProfileBO.setPrimarySalesOrg(nonBPUserCustom.getPrimarySalesArea());
				userProfileBO.setAthorization(nonBPUserCustom.getPrimarySalesAreaAuthorization());
				if (	null != nonBPUserCustom.getPrimarySalesAreaAuthorization() && "N".equals(nonBPUserCustom.getPrimarySalesAreaAuthorization().trim())) {
					userProfileBO.setAthorization(null);
				}
				userProfileBO.validateForCreate(nonBPUserCustom.getSalesAreaAccessType());
				//CreateApprove role validation	 and BHD Validation			
				/*  MN28310042/MN32138047 - Access to multiple groups belonging to multiple GEOs  */
				/*if (Integer.toString(RoleConstants.CREATE_APPROVE).equals(nonBPUserCustom.getSelectedRole()) || Integer.toString(RoleConstants.BHD).equals(nonBPUserCustom.getSelectedRole())) {
					validateForCreateApproveAndBHD(nonBPUserCustom.getSelectedRole(), nonBPUserCustom.getPrimarySalesArea(), nonBPUserCustom.getSalesAreaAccessType());
				}*/
			}
			else {
				userProfileBO.setUserId(nonBPUserCustom.getUserId());
				userProfileBO.setUserType(nonBPUserCustom.getUserType());
				userProfileBO.setBaRole(nonBPUserCustom.getBaUserRole());
				userProfileBO.setPrimarySalesOrg(nonBPUserCustom.getPrimarySalesArea());
				userProfileBO.setAthorization(nonBPUserCustom.getPrimarySalesAreaAuthorization());
				userProfileBO.setApproverId(nonBPUserCustom.getSelectedManager());
			}
			//Populate the mailingInfoConnectorDTO and send mail
			MailConnector communicationConnector = new MailConnector();
			MailConnectorDTO mailConnectorDTO = new MailConnectorDTO();

			PreparedString preparedString = new PreparedString(MailMessageConstants.REGISTRATION_USER_MAIL_SUBJECT);
			preparedString.setString(1, OPPTHelper.trimString(nonBPUserCustom.getUserId()));
			mailConnectorDTO.setSubject(preparedString.toString());
			preparedString.clear(MailMessageConstants.REGISTRATION_USER_MAIL_TEXT);

			//get info for User id 
			UserProfileConnectorDTO wiDTO = new UserProfileConnectorDTO();
			UserProfileConnector wi = new UserProfileConnector();
			wiDTO.setUserID(nonBPUserCustom.getUserId());

			try {
				wiDTO = wi.getProfile(wiDTO);
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}
			//get info for Manager id 
			UserProfileConnectorDTO webIdentityConnectorDTO = new UserProfileConnectorDTO();
			UserProfileConnector webIdentityConnector = new UserProfileConnector();
			webIdentityConnectorDTO.setUserID(nonBPUserCustom.getSelectedManager());

			try {
				webIdentityConnectorDTO = webIdentityConnector.getProfile(webIdentityConnectorDTO);
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}
			List adminList = new ArrayList();

			/*
			 * Changes Made for MN 19769207
			 * Balaji 
			 * Defect 8
			 * Mail should be sent for all geo sec off for the sales org 
			 */
			try {
				GeoSecOffBOFactory geoSecOffBOFactory = new GeoSecOffBOFactory();
				GeoSecOffBO geoSecOfBO = geoSecOffBOFactory.findGEOSecOffBOForSalesOrg(nonBPUserCustom.getPrimarySalesArea());
				adminList = userProfileBOFactory.findUserProfileBOForSalesOrg(geoSecOfBO.getGeoSecOffSO());
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
			/*
			 * Changes Made for MN 19769207
			 * Balaji 
			 * Defect 8
			 */

			Iterator adminListIter = adminList.iterator();

			//get info for Admin id's 
			UserProfileConnectorDTO wiDTOAdmin;
			UserProfileConnector wiAdmin = new UserProfileConnector();

			StringBuffer emailIds = new StringBuffer();
			while (adminListIter.hasNext()) {
				userProfileBO = (UserProfileBO) adminListIter.next();
				if (userProfileBO.getRole() == RoleConstants.ADMINISTRATOR) {
					wiDTOAdmin = new UserProfileConnectorDTO();
					wiDTOAdmin.setUserID(userProfileBO.getUserId());
					try {
						wiDTOAdmin = wiAdmin.getProfile(wiDTOAdmin);
					} catch (ConnectorException ce) {
						OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
					}

					if (emailIds.length() > 0) {
						emailIds = emailIds.append(", ");
					}

					emailIds = emailIds.append(wiDTOAdmin.getEmailAddress());
				}
			}

			String firstName = wiDTO.getFirstName();
			firstName = (firstName == null) ? "" : firstName;

			String lastName = wiDTO.getLastName();
			lastName = (lastName == null) ? "" : lastName;

			preparedString.setString(1, new StringBuffer(firstName).append(" ").append(lastName).toString());
			preparedString.setString(2, OPPTHelper.trimString(nonBPUserCustom.getUserId()));
			if(nonBPUserCustom.getUserType().equals(UtilityConstants.SOFTWARE_USER)){
				preparedString.setString(3, OPPTStaticDataHolder.getRoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedRole())));
			} else {
				preparedString.setString(3, OPPTStaticDataHolder.getBARoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedBaRole())));
			}
			preparedString.setString(4, (groupAccess == null) ? "" : groupAccess);
			/*
			 * Changes Made for MN 19769207
			 * Balaji 
			 * Defect 8 
			 */
			StringBuffer salesOrgDetails = new StringBuffer();
			TreeMap salesOrgAccessType = nonBPUserCustom.getSalesAreaAccessType();
			Iterator salesOrgIterator = salesOrgAccessType.keySet().iterator();
			while (salesOrgIterator.hasNext()) {
				String salesOrg = (String) salesOrgIterator.next();
				String accessTypeFromUI = (String) salesOrgAccessType.get(salesOrg);
				String accessType = "N";

				if ("*".equals(OPPTHelper.trimString(accessTypeFromUI))) {
					accessType = "All";
				} else if ("S".equals(OPPTHelper.trimString(accessTypeFromUI))) {
					accessType = "Sensitive";
				} else if ("N".equals(OPPTHelper.trimString(accessTypeFromUI))) {
					accessType = "Non Sensitive";
				}

				salesOrgDetails.append(" Sales Area:");
				salesOrgDetails.append(salesOrg);
				salesOrgDetails.append("-");
				salesOrgDetails.append(OPPTStaticDataHolder.getSalesOrgDesc(salesOrg));
				salesOrgDetails.append(" Access Type:");
				salesOrgDetails.append(accessType);

			}
			preparedString.setString(5, salesOrgDetails.toString());
			preparedString.setString(6, OPPTPropertiesReader.getOpptUrl());
			preparedString.setString(7, OPPTStaticDataHolder.getUserTypeDesc(OPPTHelper.trimString(nonBPUserCustom.getUserType())));
			OPPTLogger.debug("preparedString.toString()  = " + preparedString.toString(), CLASS_NAME, methodName);
			/*
			 * Changes Made for MN 19769207
			 * Balaji- Ends 
			 */

			mailConnectorDTO.setMsgText(preparedString.toString());
			mailConnectorDTO.setFromAddress(wiDTO.getEmailAddress());
			mailConnectorDTO.setToAddress(webIdentityConnectorDTO.getEmailAddress());
			mailConnectorDTO.setCcAddress(emailIds.toString());
			try {
				mailConnectorDTO = communicationConnector.sendMail(mailConnectorDTO);
			} catch (ConnectorException e) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			}

			ErrorReport errorReport = new ErrorReport();
			errorReport = ExceptionGenerator.addErrorEntry(errorReport, ErrorCodeConstants.SE0214, OPPTMessageCatalog.TYPE_SERVICE);

			nonBPUserCustom.setMessageReport(errorReport);

			return nonBPUserCustom;
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  This method goes to the factory and removes the User
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  userCustom
	 * @return UserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public UserCustomDTO removeUser(UserCustomDTO userCustom) throws ServiceException {
		String methodName = "removeUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		
		try {
			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();
			UserGroupBOFactory userGroupBOFactory = new UserGroupBOFactory();

			String userId = OPPTHelper.trimString(userCustom.getUserId());
			UserProfileBO userProfileBO = userProfileBOFactory.getUserProfileBO(userId);


			if(userProfileBO.getUserType().equals(UtilityConstants.SOFTWARE_USER)) 
			{			
				ProposalManagerLocalHome proposalManagerHome = (ProposalManagerLocalHome) HomeProvider.getLocal(HomeProvider.PROPOSAL_MANAGER_HOME_LOCAL);
				ProposalManagerLocal proposalManager;

				try {
					proposalManager = proposalManagerHome.create();
				} catch (CreateException ex) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
				}

				// Check before removing the ID - series of finder methods to be fired
				int role = userCustom.getRole();
	
				userCustom.setRole(userProfileBO.getRole());
				userCustom = proposalManager.checkForRemovingUser(userCustom);
				userCustom.setRole(role);
	
				if (userCustom.getId() != null) {
					throw ExceptionGenerator.generateServiceException(userCustom.getId());
				} else {
					//Get Profile
					userProfileBOFactory.deleteUserProfileBO(userId); //Delete 
					userGroupBOFactory.deleteUserGroups(userId);
				}
			} else {
				userProfileBOFactory.deleteUserProfileBO(userId); //Delete 
			}	
			JMSConnectorLocalHome jmsConnectorLocalHome = (JMSConnectorLocalHome) HomeProvider.getLocal(HomeProvider.JMS_CONNECTOR_LOCAL_HOME);
			JMSConnectorLocal jmsConnectorLocal;
			try {
				jmsConnectorLocal = jmsConnectorLocalHome.create();
			} catch (CreateException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			UseridMaintInputConnectorDTO useridMaintInputConnectorDTO = new UseridMaintInputConnectorDTO();
			UseridMaintOutputConnectorDTO useridMaintOutputConnectorDTO = new UseridMaintOutputConnectorDTO();
			GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
			genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_USERID_MAINT_OPPT);
			genericConnectorDTO.setSessionID(userCustom.getSessionId());
			genericConnectorDTO.setUserID(userId);
			useridMaintInputConnectorDTO.setFlag(UtilityConstants.USER_DELETE);
			useridMaintInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
			try {
				useridMaintOutputConnectorDTO = (UseridMaintOutputConnectorDTO) jmsConnectorLocal.sendReceive(useridMaintInputConnectorDTO);
				useridMaintOutputConnectorDTO.setReturnCode(OPPTHelper.trimString(useridMaintOutputConnectorDTO.getReturnCode()));
			} catch (Exception ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			if (ConnectorConstants.RFC_SUCCESS_CODE.equals(useridMaintOutputConnectorDTO.getReturnCode()) == false) {
				OPPTLogger.debug("Rollback is called #" + useridMaintOutputConnectorDTO.getReturnCode() + "#", CLASS_NAME, methodName);
				getSessionContext().setRollbackOnly();

				throwBackendTypeServiceException(useridMaintOutputConnectorDTO.getReturnCode());
			}
			/* Start change  CR0801074150 - CBS OPPT activity logging */
			OPPTLogger.infoActivityLogger("Geo Security officer " +userCustom.getGeoSecOff() + " successfully removed the OPPT access for user id " + userCustom.getUserId()+ "!",CLASS_NAME, methodName);
			String message="Geo Security officer " +userCustom.getGeoSecOff() + " successfully removed the OPPT access for user id " + userCustom.getUserId()+ "!";
			createActivityLog(userCustom.getGeoSecOff(),message);
			/* End change  CR0801074150 - CBS OPPT activity logging */
			
			MailConnector communicationConnector = new MailConnector();
			MailConnectorDTO mailConnectorDTO = new MailConnectorDTO();
			//get info for User id 
			UserProfileConnectorDTO webIdentityConnectorDTO = new UserProfileConnectorDTO();
			UserProfileConnector webIdentityConnector = new UserProfileConnector();
			webIdentityConnectorDTO.setUserID(userCustom.getUserId());

			try {
				webIdentityConnectorDTO = webIdentityConnector.getProfile(webIdentityConnectorDTO);
				
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}

			//get info for Admin id 
			UserProfileConnectorDTO webIdentityConnectorDTOAdmin = new UserProfileConnectorDTO();
			UserProfileConnector webIdentityConnectorAdmin = new UserProfileConnector();
			webIdentityConnectorDTOAdmin.setUserID(userCustom.getUserId());

			try {
				webIdentityConnectorDTOAdmin = webIdentityConnectorAdmin.getProfile(webIdentityConnectorDTOAdmin);
				
				
				
				
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}

			//get info for Manager id 
			UserProfileConnectorDTO webIdentityConnectorDTOManager = new UserProfileConnectorDTO();
			UserProfileConnector webIdentityConnectorManager = new UserProfileConnector();
			webIdentityConnectorDTOManager.setUserID(userCustom.getGeoSecOff());
			

			try {
				webIdentityConnectorDTOManager = webIdentityConnectorAdmin.getProfile(webIdentityConnectorDTOManager);
				
				
			
			} catch (ConnectorException ce) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}

			PreparedString preparedString = new PreparedString(MailMessageConstants.USER_DELETION_MAIL_SUBJECT);
			preparedString.setString(1, OPPTHelper.trimString(userCustom.getUserId()));
			mailConnectorDTO.setSubject(preparedString.toString());
			

			preparedString.clear(MailMessageConstants.USER_DELETION_USER_MAIL_TEXT);

			String firstName = webIdentityConnectorDTO.getFirstName();
			firstName = (firstName == null) ? "" : firstName;

			String lastName = webIdentityConnectorDTO.getLastName();
			lastName = (lastName == null) ? "" : lastName;
			preparedString.setString(1, new StringBuffer(lastName).append(" ").append(firstName).toString());
			preparedString.setString(11, new StringBuffer(lastName).append(" ").append(firstName).toString());

			preparedString.setString(2, OPPTHelper.trimString(userCustom.getUserId()));
			preparedString.setString(3, OPPTStaticDataHolder.getUserTypeDesc(OPPTHelper.trimString(userCustom.getUserType())));
			
			int role = userProfileBO.getRole();
			
			
			if(userCustom.getUserType().equals(UtilityConstants.SOFTWARE_USER)){
				preparedString.setString(4, OPPTStaticDataHolder.getRoleDesc(Integer.toString(role)));
			} else {
				preparedString.setString(4, OPPTStaticDataHolder.getBARoleDesc(Integer.toString(role)));
			}
			preparedString.setString(5, userProfileBO.getGroupName());
			
			StringBuffer salesOrgDetails = new StringBuffer();
			
			
			String salesOrg = userCustom.getPrimarySalesOrg();
			String accessTypeFromUI = userProfileBO.getAthorization();
			System.out.println("Accesstype from UI" +accessTypeFromUI);
			
				String accessType = "N";
                // nonBPUserCustom.getPrimarySalesAreaAuthorization()
				if ("*".equals(OPPTHelper.trimString(accessTypeFromUI))) {
					accessType = "All";
				} else if ("S".equals(OPPTHelper.trimString(accessTypeFromUI))) {
					accessType = "Sensitive";
				} else if ("N".equals(OPPTHelper.trimString(accessTypeFromUI))) {
					accessType = "Non Sensitive";
				}

				
				salesOrgDetails.append(salesOrg).append("-").append(OPPTStaticDataHolder.getSalesOrgDesc(salesOrg));
				preparedString.setString(7, salesOrgDetails.toString());
				preparedString.setString(8,accessType);
				
				String deletedByFirstName = webIdentityConnectorDTOManager.getFirstName();
				deletedByFirstName = (deletedByFirstName == null) ? "" : deletedByFirstName;

				String deletedByLastName = webIdentityConnectorDTOManager.getLastName();
				deletedByLastName = (deletedByLastName == null) ? "" : deletedByLastName;
				
				preparedString.setString(9, new StringBuffer(deletedByLastName).append(" ").append(deletedByFirstName).append("   ").append(userCustom.getGeoSecOff()).toString());
				
				
				
				
			//	preparedString.setString(9,userCustom.getGeoSecOff());	
				
				Timestamp cuttentdate = new Timestamp(new Date().getTime());
				preparedString.setString(10,cuttentdate.toString() );
			
			preparedString.setString(6, OPPTPropertiesReader.getOpptUrl());
		//	preparedString.setString(7, OPPTPropertiesReader.getOpptUrl());
			mailConnectorDTO.setMsgText(preparedString.toString());
			System.out.println("Mail Message "+mailConnectorDTO.getMsgText());
			UserDAO.insertDeletedUserProfile(userProfileBO,userCustom.getGeoSecOff(),firstName ,lastName);
            mailConnectorDTO.setFromAddress(userCustom.getEmailAddress());
			mailConnectorDTO.setToAddress(webIdentityConnectorDTO.getEmailAddress());
			mailConnectorDTO.setCcAddress(webIdentityConnectorDTOManager.getEmailAddress());

			try {
				mailConnectorDTO = communicationConnector.sendMail(mailConnectorDTO);
			} catch (ConnectorException e) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			}

			
			
			return userCustom;
		} catch (DomainException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}


	/**
	 *  This method goes to the factory and saves the edited information of BP User 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bpUserCustom
	 * @return BPUserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public BPUserCustomDTO saveEditBPUser(BPUserCustomDTO bpUserCustom) throws ServiceException {
		String methodName = "saveEditBPUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();

			String selectedManager = bpUserCustom.getSelectedManager();
			int selectedRole = bpUserCustom.getRole();

			UserProfileBO userProfileBO = null;

			try {
				userProfileBO = userProfileBOFactory.getUserProfileBO(bpUserCustom.getUserId());
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			if (UtilityConstants.NULL.equals(selectedManager)) {
				//Check for whether manager is selected or not
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0201);
			}

			//set the already existing values in UserProfileBO used for validations
			userProfileBO.setUserId(userProfileBO.getUserId());
			userProfileBO.setRole(userProfileBO.getRole());
			userProfileBO.setPrimarySalesOrg(userProfileBO.getPrimarySalesOrg());
			userProfileBO.setBPAccessIndicator(userProfileBO.getBPAccessIndicator());
			if (selectedRole == RoleConstants.PROPOSAL_APPROVER
				|| selectedRole == RoleConstants.MARKETING_REP
				|| selectedRole == RoleConstants.MANAGER
				|| selectedRole == RoleConstants.CREATE_APPROVE
				|| selectedRole == RoleConstants.BHD
				|| selectedRole == RoleConstants.OPPT_READ
				|| userProfileBO.getRole() == RoleConstants.CSO) {
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0206);
			}

			userProfileBO.validateForEdit(bpUserCustom.getSalesAreas());

			//set the already edited values in UserProfileBO		
			userProfileBO.setUserId(bpUserCustom.getUserId());
			userProfileBO.setRole(bpUserCustom.getRole());
			userProfileBO.setBPAccessIndicator(bpUserCustom.getAccessType());
			userProfileBO.setPrimarySalesOrg(bpUserCustom.getPrimarySalesArea());
			userProfileBO.setApproverId(bpUserCustom.getSelectedManager());
			if (UtilityConstants.BPLEGACYNO_ACCESS_TYPE_OPPT.equals(bpUserCustom.getAccessType())) {
				HashMap bPLegacyMap = bpUserCustom.getLegacyNos();
				List custList = new ArrayList();

				Iterator LegacyNosIter = bPLegacyMap.keySet().iterator();
				while (LegacyNosIter.hasNext()) {
					BPLegacyBDO bpLegacyBDO = new BPLegacyBDO();
					bpLegacyBDO.setLegacyNumber((String) LegacyNosIter.next());
					bpLegacyBDO.setAddressSeqNumber((String) bPLegacyMap.get(bpLegacyBDO.getLegacyNumber()));
					bpLegacyBDO.setUserId(bpUserCustom.getUserId());
					custList.add(bpLegacyBDO);
				}
				userProfileBO.setBPLegactNoList(custList);
			} else {
				List customerNosList = new ArrayList();
				Iterator iter = bpUserCustom.getCustomerNumbers().iterator();

				while (iter.hasNext()) {
					BPCustomerListBDO bPCustomerListBDO = new BPCustomerListBDO();
					bPCustomerListBDO.setCustListNo((String) iter.next());
					bPCustomerListBDO.setUserId(bpUserCustom.getUserId());
					customerNosList.add(bPCustomerListBDO);
				}
				userProfileBO.setBPCustomerList(customerNosList);
			}

			try {
				userProfileBOFactory.updateUserProfileBO(userProfileBO);
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			JMSConnectorLocalHome jmsConnectorLocalHome = (JMSConnectorLocalHome) HomeProvider.getLocal(HomeProvider.JMS_CONNECTOR_LOCAL_HOME);
			JMSConnectorLocal jmsConnectorLocal = null;
			try {
				jmsConnectorLocal = jmsConnectorLocalHome.create();
			} catch (CreateException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			boolean setFlag = true;
			//if((!userProfileBO.getBPCustomerList().equals(bpUserCustom.getCustomerNumbers())) || (!userProfileBO.getBPCustomerList().equals(bpUserCustom.getCustomerNumbers())))//check whether any customer numbers are added or deleted

			if (true) //check whether any customer numbers are added or deleted
				{
				//Call the method to create the id in ESW
				ValidateBPAccessInputConnectorDTO validateBPAccessInputConnectorDTO = new ValidateBPAccessInputConnectorDTO();
				ValidateBPAccessOutputConnectorDTO validateBPAccessOutputConnectorDTO = null;

				GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
				genericConnectorDTO.setSessionID(bpUserCustom.getSessionId());
				genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_VALIDATE_BP_ACCESS_OPPT);
				genericConnectorDTO.setUserID(userProfileBO.getUserId());
				validateBPAccessInputConnectorDTO.setSalesOrg(userProfileBO.getPrimarySalesOrg());

				if (UtilityConstants.BPCUSTOMERLIST_ACCESS_TYPE_OPPT.equals(bpUserCustom.getAccessType())) {
					String[] custList = new String[userProfileBO.getBPCustomerList().size()];
					for (int i = 0; i < userProfileBO.getBPCustomerList().size(); i++) {
						custList[i] = userProfileBO.getBPCustomerList().get(i).toString();
					}
					validateBPAccessInputConnectorDTO.setCustListNo(custList);
					validateBPAccessInputConnectorDTO.setAccessOption(UtilityConstants.BPCUSTOMERLIST_ACCESS_TYPE_ESW);
				} else {
					validateBPAccessInputConnectorDTO.setAccessOption(UtilityConstants.BPLEGACYNO_ACCESS_TYPE_ESW);

					HashMap bPLegacyMap = bpUserCustom.getLegacyNos();
					List custList = new ArrayList();
					Iterator LegacyNosIter = bPLegacyMap.keySet().iterator();
					while (LegacyNosIter.hasNext()) {
						CustListAndSeqConnectorDTO custListAndSeqConnectorDTO = new CustListAndSeqConnectorDTO();
						custListAndSeqConnectorDTO.setLegacyCustNumber((String) LegacyNosIter.next());
						custListAndSeqConnectorDTO.setAddSeqNumber((String) bPLegacyMap.get(custListAndSeqConnectorDTO.getLegacyCustNumber()));
						custList.add(custListAndSeqConnectorDTO);
					}
					validateBPAccessInputConnectorDTO.setCustListAndSeqConnectorDTO(custList);
				}
				validateBPAccessInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
				try {
					validateBPAccessOutputConnectorDTO = (ValidateBPAccessOutputConnectorDTO) jmsConnectorLocal.sendReceive(validateBPAccessInputConnectorDTO);

					validateBPAccessOutputConnectorDTO.setReturnCode(OPPTHelper.trimString(validateBPAccessOutputConnectorDTO.getReturnCode()));
				} catch (Exception ex) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
				}

				if (ConnectorConstants.RFC_SUCCESS_CODE.equals(validateBPAccessOutputConnectorDTO.getReturnCode()) == false) {
					setFlag = false;

					throwBackendTypeServiceException(validateBPAccessOutputConnectorDTO.getReturnCode());
				}
			} else {
				if (setFlag) {
					GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
					UseridMaintInputConnectorDTO useridMaintInputConnectorDTO = new UseridMaintInputConnectorDTO();
					UseridMaintOutputConnectorDTO useridMaintOutputConnectorDTO = new UseridMaintOutputConnectorDTO();
					genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_USERID_MAINT_OPPT);
					genericConnectorDTO.setSessionID(bpUserCustom.getSessionId());
					genericConnectorDTO.setUserID(bpUserCustom.getUserId());

					useridMaintInputConnectorDTO.setFlag(UtilityConstants.USER_CREATE);
					String[] salesOrgs = new String[1];
					String[] accesstype = new String[1];
					salesOrgs[0] = bpUserCustom.getPrimarySalesArea();
					accesstype[0] = UtilityConstants.BPUSER_CREATE_DEFAULT_ACCESS_TYPE;

					useridMaintInputConnectorDTO.setAccessType(accesstype);
					useridMaintInputConnectorDTO.setSalesOrg(salesOrgs);
					useridMaintInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
					try {
						useridMaintOutputConnectorDTO = (UseridMaintOutputConnectorDTO) jmsConnectorLocal.sendReceive(useridMaintInputConnectorDTO);

						useridMaintOutputConnectorDTO.setReturnCode(OPPTHelper.trimString(useridMaintOutputConnectorDTO.getReturnCode()));
					} catch (Exception ex) {
						OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
					}

					if (ConnectorConstants.RFC_SUCCESS_CODE.equals(useridMaintOutputConnectorDTO.getReturnCode()) == false) {
						throwBackendTypeServiceException(useridMaintOutputConnectorDTO.getReturnCode());
					}
				}
			}
			return bpUserCustom;
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  This method goes to the factory and saves the edited information of Non BP User 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param nonBPUserCustom
	 * @return NonBPUserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public NonBPUserCustomDTO saveEditNonBPUser(NonBPUserCustomDTO nonBPUserCustom) throws ServiceException {
		String methodName = "saveEditNonBPUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		/* Start change  CR0801074150 - CBS OPPT activity logging */
		StringBuffer newUserLog = new StringBuffer();
		/* End change  CR0801074150 - CBS OPPT activity logging */
		try {
			boolean userHasAccessToMultipleGroups = false;
			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();
			UserGroupBOFactory userGroupBOFactory = new UserGroupBOFactory();
			TreeMap salesOrgAccessType = new TreeMap();
			String groupAccess = null;

			String primarySalesOrg = nonBPUserCustom.getPrimarySalesArea();
			String selectedManager = nonBPUserCustom.getSelectedManager();
			String userType = nonBPUserCustom.getUserType();
			
			//	String selectedGroup = OPPTHelper.trimString(nonBPUserCustom.getSelectedGroup());
			//	Changes for OPPT UD - Balaji starts 

			UserProfileBO userProfileBO = null;
			if(userType.equals(UtilityConstants.SOFTWARE_USER)) 
			{			
				int selectedRole = Integer.parseInt(nonBPUserCustom.getSelectedRole());
				TreeSet userGroup = nonBPUserCustom.getSelectedGroups();
					//String groupName = null;
					String selectedGroup = null;
					if (userGroup != null && userGroup.size() > 0) {
						if (userGroup.first() != null) {
							selectedGroup = (String) userGroup.first();
						}
					   if (userGroup.size() > 1) {
							userHasAccessToMultipleGroups = true;
						}
						//	String groupName = OPPTHelper.trimString(nonBPUserCustom.getSelectedGroup());
					}
					List userGroupBOList = new ArrayList();
		
					try {
						userProfileBO = userProfileBOFactory.getUserProfileBO(nonBPUserCustom.getUserId());
						userGroupBOList = userGroupBOFactory.findUserGroupBO(nonBPUserCustom.getUserId());
		
					} catch (DomainException ex) {
						OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
					}

					if (UtilityConstants.NULL.equals(selectedManager)) {
						//Check for whether manager is selected or not			
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0201);
					}

					//validation for Edit
					userProfileBO.validateForEdit(nonBPUserCustom.getSalesAreaAccessType());

					//CreateApprove role validation	 and BHD Validation	
					/*  MN28310042/MN32138047 - Access to multiple groups belonging to multiple GEOs */
					/*if (selectedRole == RoleConstants.CREATE_APPROVE || selectedRole == RoleConstants.BHD) {
						validateForCreateApproveAndBHD(nonBPUserCustom.getSelectedRole(), nonBPUserCustom.getPrimarySalesArea(), nonBPUserCustom.getSalesAreaAccessType());
					}*/

					//Role Check
					validateForRoleChange(nonBPUserCustom.getSelectedRole(), new Integer(userProfileBO.getRole()).toString(), nonBPUserCustom.getUserId());
					// CBS Check Starts
					JMSConnectorLocalHome jmsConnectorLocalHome = (JMSConnectorLocalHome) HomeProvider.getLocal(HomeProvider.JMS_CONNECTOR_LOCAL_HOME);
					JMSConnectorLocal jmsConnectorLocal = null;
					try {
						jmsConnectorLocal = jmsConnectorLocalHome.create();
					} catch (CreateException ex) {
						OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
						getSessionContext().setRollbackOnly();

						OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
					}

					UseridMaintInputConnectorDTO useridMaintInputConnectorDTO = new UseridMaintInputConnectorDTO();
					UseridMaintOutputConnectorDTO useridMaintOutputConnectorDTO = null;

					GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();

					genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_USERID_MAINT_OPPT);
					genericConnectorDTO.setSessionID(nonBPUserCustom.getSessionId());
					genericConnectorDTO.setUserID(nonBPUserCustom.getUserId());
					useridMaintInputConnectorDTO.setFlag(UtilityConstants.USER_CREATE);
					//set the salesOrg and access type 
					salesOrgAccessType = nonBPUserCustom.getSalesAreaAccessType();
					String[] salesOrgArray = new String[salesOrgAccessType.size()];
					String[] accesstypeArray = new String[salesOrgAccessType.size()];
					int i = 0;
					Iterator salesOrgIterator = salesOrgAccessType.keySet().iterator();
					while (salesOrgIterator.hasNext()) {
						salesOrgArray[i] = (String) salesOrgIterator.next();
						accesstypeArray[i] = (String) salesOrgAccessType.get(salesOrgArray[i]);
						if (null != accesstypeArray[i] && "N".equals(accesstypeArray[i].trim())) {
							accesstypeArray[i] = null;
						}
						i++;
					}

					useridMaintInputConnectorDTO.setSalesOrg(salesOrgArray);
					useridMaintInputConnectorDTO.setAccessType(accesstypeArray);
					useridMaintInputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);

					try {
						useridMaintOutputConnectorDTO = (UseridMaintOutputConnectorDTO) jmsConnectorLocal.sendReceive(useridMaintInputConnectorDTO);

						useridMaintOutputConnectorDTO.setReturnCode(OPPTHelper.trimString(useridMaintOutputConnectorDTO.getReturnCode()));
					} catch (Exception ex) {
						OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
					}

					if (ConnectorConstants.RFC_SUCCESS_CODE.equals(useridMaintOutputConnectorDTO.getReturnCode()) == false) {
						OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
						getSessionContext().setRollbackOnly();

						throwBackendTypeServiceException(useridMaintOutputConnectorDTO.getReturnCode());
					}
					
					// CBS Check ends
				
					selectedGroup = (selectedGroup == null) ? "" : selectedGroup;
					//boolean groupChange = false;
					ProposalManagerLocalHome proposalManagerHome = (ProposalManagerLocalHome) HomeProvider.getLocal(HomeProvider.PROPOSAL_MANAGER_HOME_LOCAL);
					ProposalManagerLocal proposalManager = null;
					try {
						proposalManager = proposalManagerHome.create();
					} catch (CreateException ex) {
						OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
					}
					/* Groups - Begin changes */
					//if(null != userGroupBOList && 0 == userGroupBOList.size() &&
							//userGroup != null && userGroup.size() > 0) {
					/* Groups - End changes */
					/*
					 * Here the user is added to a new group so we have to update
					 * all the proposals of that User to the group name which has
					 * just been added
					 */
					
					proposalManager.updateProposalWithGroupName(OPPTHelper.trimString(nonBPUserCustom.getUserId()),
									selectedGroup);
					userGroupBOFactory.deleteUserGroups(nonBPUserCustom.getUserId());
					/* Groups - Begin changes */
					//}
					/* Groups - End changes */
					
					selectedGroup = (selectedGroup == null || selectedGroup.trim().length() == 0) ? null : selectedGroup;
	
					userProfileBO.setUserType(userType);
					userProfileBO.setRole(selectedRole);
					userProfileBO.setGroupName(selectedGroup);
					userProfileBO.setApproverId(nonBPUserCustom.getSelectedManager());
					userProfileBO.setPrimarySalesOrg(primarySalesOrg);
					userProfileBO.setAthorization(nonBPUserCustom.getPrimarySalesAreaAuthorization());
				if (null != nonBPUserCustom.getPrimarySalesAreaAuthorization() && "N".equals(nonBPUserCustom.getPrimarySalesAreaAuthorization().trim())) {
					userProfileBO.setAthorization(null);
				}
	
				try {
					userProfileBOFactory.updateUserProfileBO(userProfileBO);
					//	UD Changes starts
					if (userGroup != null && userGroup.size() > 0) {
						userGroupBOFactory.deleteUserGroups(userProfileBO.getUserId());
						Iterator iter = userGroup.iterator();
						StringBuffer groupAccessBuffer = new StringBuffer();
						while (iter.hasNext()) {
							UserGroupBO userGroupBO = new UserGroupBO();
							String localGroupName = OPPTHelper.trimString(iter.next().toString());
							userGroupBO.setGroupName(localGroupName);
							userGroupBO.setUserId(userProfileBO.getUserId());
							userGroupBOFactory.createUserGroupBO(userGroupBO);
							groupAccessBuffer.append(" ");
							groupAccessBuffer.append(localGroupName);
						}
						groupAccess = groupAccessBuffer.toString();
					}
					// UD Changes ends
	
				} catch (DomainException ex) {
					OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
					getSessionContext().setRollbackOnly();
	
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
				}
			}
			else {
				try {
					userProfileBO = userProfileBOFactory.getUserProfileBO(nonBPUserCustom.getUserId());
					userProfileBO.setUserType(userType);
					userProfileBO.setBaRole(Integer.parseInt(nonBPUserCustom.getSelectedBaRole()));
					userProfileBO.setApproverId(nonBPUserCustom.getSelectedManager());
					userProfileBO.setPrimarySalesOrg(primarySalesOrg);
					userProfileBO.setAthorization(nonBPUserCustom.getPrimarySalesAreaAuthorization());
					userProfileBOFactory.updateUserProfileBO(userProfileBO);
				} catch (DomainException ex) {
					OPPTLogger.debug("Rollback is called: ", CLASS_NAME, methodName);
					getSessionContext().setRollbackOnly();
	
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
				}
			}
			//check whether any changes are made to salesOrg and accesstype

				/*
				 * Changes Made for MN 19769207
				 * Balaji
				 * Defect 8 
				 */

				//populate the mailingInfoDTO and send mail
				MailConnector communicationConnector = new MailConnector();
				MailConnectorDTO mailConnectorDTO = new MailConnectorDTO();
				//get info for User id 
				UserProfileConnectorDTO webIdentityConnectorDTO = new UserProfileConnectorDTO();
				UserProfileConnector webIdentityConnector = new UserProfileConnector();
				webIdentityConnectorDTO.setUserID(nonBPUserCustom.getUserId());

				try {
					webIdentityConnectorDTO = webIdentityConnector.getProfile(webIdentityConnectorDTO);
				} catch (ConnectorException ce) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
				}
				//get info for Admin id 
				UserProfileConnectorDTO webIdentityConnectorDTOAdmin = new UserProfileConnectorDTO();
				UserProfileConnector webIdentityConnectorAdmin = new UserProfileConnector();
				webIdentityConnectorDTOAdmin.setUserID(nonBPUserCustom.getUserId());

				try {
					webIdentityConnectorDTOAdmin = webIdentityConnectorAdmin.getProfile(webIdentityConnectorDTOAdmin);
				} catch (ConnectorException ce) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
				}

				//get info for Manager id 
				UserProfileConnectorDTO webIdentityConnectorDTOManager = new UserProfileConnectorDTO();
				UserProfileConnector webIdentityConnectorManager = new UserProfileConnector();
				webIdentityConnectorDTOManager.setUserID(nonBPUserCustom.getSelectedManager());

				try {
					webIdentityConnectorDTOManager = webIdentityConnectorAdmin.getProfile(webIdentityConnectorDTOManager);
				} catch (ConnectorException ce) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
				}

				PreparedString preparedString = new PreparedString(MailMessageConstants.USER_CHANGE_MAIL_SUBJECT);
				preparedString.setString(1, OPPTHelper.trimString(nonBPUserCustom.getUserId()));
				mailConnectorDTO.setSubject(preparedString.toString());

				preparedString.clear(MailMessageConstants.USER_CHANGE_USER_MAIL_TEXT);

				String firstName = webIdentityConnectorDTO.getFirstName();
				firstName = (firstName == null) ? "" : firstName;

				String lastName = webIdentityConnectorDTO.getLastName();
				lastName = (lastName == null) ? "" : lastName;

				preparedString.setString(1, new StringBuffer(firstName).append(" ").append(lastName).toString());

				preparedString.setString(2, OPPTHelper.trimString(nonBPUserCustom.getUserId()));
				/**
				 * Defect 358
				 * MN19539229
				 * Balaji
				 */
				preparedString.setString(3, OPPTStaticDataHolder.getRoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedRole())));
				preparedString.setString(4, groupAccess == null ? "" : groupAccess);

				/*
				 * Changes Made for MN 19769207
				 * Balaji
				 * Defect 8 
				  */
				StringBuffer salesOrgDetails = new StringBuffer();
				Iterator salesOrgIteratorForMail = salesOrgAccessType.keySet().iterator();
				while (salesOrgIteratorForMail.hasNext()) {
					String salesOrg = (String) salesOrgIteratorForMail.next();
					String accessTypeFromUI = (String) salesOrgAccessType.get(salesOrg);
					String accessType = "N";
					//nonBPUserCustom.getPrimarySalesAreaAuthorization()
					if ("*".equals(OPPTHelper.trimString(accessTypeFromUI))) {
						accessType = "All";
					} else if ("S".equals(OPPTHelper.trimString(accessTypeFromUI))) {
						accessType = "Sensitive";
					} else if ("N".equals(OPPTHelper.trimString(accessTypeFromUI))) {
						accessType = "Non Sensitive";
					}

					salesOrgDetails.append(" Sales Area:");
					salesOrgDetails.append(salesOrg).append("-" ).append(OPPTStaticDataHolder.getSalesOrgDesc(salesOrg));
					salesOrgDetails.append(" Access Type:");
					salesOrgDetails.append(accessType);

				}
				preparedString.setString(5, salesOrgDetails.toString());
				preparedString.setString(6, OPPTPropertiesReader.getOpptUrl());
				preparedString.setString(7, OPPTStaticDataHolder.getUserTypeDesc(OPPTHelper.trimString(nonBPUserCustom.getUserType())));
				mailConnectorDTO.setMsgText(preparedString.toString());

				mailConnectorDTO.setFromAddress(nonBPUserCustom.getEmailAddress());
				mailConnectorDTO.setToAddress(webIdentityConnectorDTO.getEmailAddress());
				OPPTLogger.debug(" webIdentityConnectorDTO.getEmailAddress() = " + webIdentityConnectorDTO.getEmailAddress(), CLASS_NAME, "changeUser");
				mailConnectorDTO.setCcAddress(webIdentityConnectorDTOManager.getEmailAddress());

				/* Start change  CR0801074150 - CBS OPPT activity logging */
				
				newUserLog.append("User id:").append(nonBPUserCustom.getUserId()).append(" ");
				newUserLog.append("User Type:");
				if(nonBPUserCustom.getUserType().equals(UtilityConstants.SOFTWARE_USER)){
					newUserLog.append("Software User").append(" ").append("Role:");
					newUserLog.append(OPPTStaticDataHolder.getRoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedRole())));
				} else {
					newUserLog.append("Baseagreement User").append(" ").append("Role:");
					newUserLog.append(OPPTStaticDataHolder.getBARoleDesc(OPPTHelper.trimString(nonBPUserCustom.getSelectedBaRole())));
				}
				newUserLog.append(" ").append("Group Access:").append(groupAccess == null ? "" : groupAccess).append(" ").append("Sales Org details:").append(salesOrgDetails);
				
				/* End change  CR0801074150 - CBS OPPT activity logging */
				
				try {
					mailConnectorDTO = communicationConnector.sendMail(mailConnectorDTO);
				} catch (ConnectorException e) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				}
				/*
				 * Changes Made for MN 19769207
				 * Balaji
				 * Defect 8 
				  */
			/* Start change  CR0801074150 - CBS OPPT activity logging */
			OPPTLogger.infoActivityLogger("Geo Security officer " +nonBPUserCustom.getGeoSecOff() + " successfully edited the profile for user id " + nonBPUserCustom.getUserId()+ "!",CLASS_NAME, methodName);
			OPPTLogger.infoActivityLogger("The details for the user after editing are " + newUserLog.toString(),CLASS_NAME, methodName);
			String message="Geo Security officer " +nonBPUserCustom.getGeoSecOff() + " successfully edited the profile for user id "+ nonBPUserCustom.getUserId();
			createActivityLog(nonBPUserCustom.getGeoSecOff(),message);
			/* End change  CR0801074150 - CBS OPPT activity logging */
			return nonBPUserCustom;
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  This method goes to the factory and gets users for a Group 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  groupName
	 * @return UserGroupProfileDomainDTO
	 * @throws ServiceException
	 * @author 
	 */
	public UserGroupProfileDomainDTO findUserForGroup(String groupName) throws ServiceException {
		String methodName = "findUserForGroup";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();
			UserGroupProfileDomainDTO userGroupProfileDomainDTO = new UserGroupProfileDomainDTO();
			UserGroupBOFactory userGroupBOFactory = new UserGroupBOFactory();
			List userProfileList = new ArrayList();

			try {
				userProfileList = userProfileBOFactory.findUserProfileBOForGroup(groupName);
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			try {
				List userGroupBOList = userGroupBOFactory.findUserforGroup(groupName);
				for (int i = 0; i < userGroupBOList.size(); i++) {
					UserGroupBO userGroupBO = (UserGroupBO) userGroupBOList.get(i);
					UserProfileBO userProfileBO = userProfileBOFactory.getUserProfileBO(userGroupBO.getUserId());
					userProfileList.add(userProfileBO);
				}
			} catch (DomainException de) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, de);
				throw ExceptionGenerator.generateServiceException(de.getErrorReport());
			}

			userGroupProfileDomainDTO.setUserGroupProfileDomainDTOList(userProfileList);

			return userGroupProfileDomainDTO;
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  This method goes to the factory and gets Managers,GeoSecOfficer,Groups for the selected sales org
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  createUserCustom
	 * @return CreateUserCustomDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public CreateUserCustomDTO processCreateNewUser(CreateUserCustomDTO createUserCustom) throws ServiceException {
		String methodName = "processCreateNewUser";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try {
			GroupBOFactory groupBOFactory = new GroupBOFactory();
			GeoSecOffBOFactory geoSecOffBOFactory = new GeoSecOffBOFactory();
			UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();

			String primarySalesOrg = createUserCustom.getPrimarySalesArea();
			String userType = createUserCustom.getUserType();
			List groupList = new ArrayList();
            
			if(userType.equals(UtilityConstants.SOFTWARE_USER))
			{	
				//UD Changes starts here
				 try {
				     if(createUserCustom.getSelectedRole() != null) {
				      if(Integer.parseInt(createUserCustom.getSelectedRole()) == RoleConstants.BHD || Integer.parseInt(createUserCustom.getSelectedRole()) == RoleConstants.OPPT_READ) {
				       groupList.addAll(groupBOFactory.findAllGroups());
				      } else {
				       List geoSecOffList = geoSecOffBOFactory.findAllGEOSecForSalesOrg(primarySalesOrg);
				       for (int i = 0; i < geoSecOffList.size(); i++) {
				        GeoSecOffBO geoSecOffBO = (GeoSecOffBO) geoSecOffList.get(i);
				        List localGroupList = groupBOFactory.findGroupBOForSalesOrg(OPPTHelper.trimString(geoSecOffBO.getSalesOrg()));
				        groupList.addAll(localGroupList);
				       }
				      }
				     }
				    } catch (DomainException ex) {
				     OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				     throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
				    }
				// UD Changes ends here
				GroupBO groupBO;
				TreeMap groupMap = new TreeMap();
	
				for (int i = 0; i < groupList.size(); i++) {
					groupBO = (GroupBO) groupList.get(i);
					groupMap.put(OPPTHelper.trimString(groupBO.getGroupName()), OPPTHelper.trimString(groupBO.getGroupName()));
				}
				createUserCustom.setGroups(groupMap);
			}    
			GeoSecOffBO geoSecOffBO = null;

			try {
				geoSecOffBO = geoSecOffBOFactory.findGEOSecOffBOForSalesOrg(primarySalesOrg);
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			String selectedGeoSecOfficer = OPPTHelper.trimString(geoSecOffBO.getGeoSecOffSO());
			createUserCustom.setGeoSecOfficer(selectedGeoSecOfficer);

			createUserCustom.setManagers(getManagerAndAdministrators(primarySalesOrg));
			return createUserCustom;
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userId
	 * @return UserProfileDomainDTO
	 * @throws ServiceException
	 * @author balajiv 
	 */

	public UserProfileDomainDTO getUserProfile(String userId) throws ServiceException {
		String methodName = "getUserProfile";

		UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();
		UserProfileBO userProfileBO = null;

		try {
			userProfileBO = userProfileBOFactory.getUserProfileBO(userId);
		} catch (DomainException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		}

		UserProfileDomainDTO userProfileDomainDTO = new UserProfileDomainDTO(userProfileBO);
		userProfileDomainDTO.setApproverId(userProfileBO.getApproverId());
		userProfileDomainDTO.setAthorization(userProfileBO.getAthorization());
		userProfileDomainDTO.setBPAccessIndicator(userProfileBO.getBPAccessIndicator());

		if (userProfileBO.getBPAccessIndicator() != null && UtilityConstants.BPCUSTOMERLIST_ACCESS_TYPE_OPPT.equals(userProfileBO.getBPAccessIndicator())) {
			userProfileDomainDTO.setBPCustomerList(userProfileBO.getBPCustomerList());
		} else if (userProfileBO.getBPAccessIndicator() != null && UtilityConstants.BPLEGACYNO_ACCESS_TYPE_OPPT.equals(userProfileBO.getBPAccessIndicator())) {
			userProfileDomainDTO.setBPLegactNoList(userProfileBO.getBPLegactNoList());
		}

		userProfileDomainDTO.setGroupName(userProfileBO.getGroupName());
		userProfileDomainDTO.setRole(userProfileBO.getRole());
		userProfileDomainDTO.setPrimarySalesOrg(userProfileBO.getPrimarySalesOrg());

		return userProfileDomainDTO;
	}

	/**
	 *  Method to validate of business rules for CreateApprove Role and BHD Role
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param String role
	 * @param String salesOrg
	 * @param HashMap salesOrgAccess
	 * @return void
	 *	  
	 */
	private void validateForCreateApproveAndBHD(String role, String salesOrg, TreeMap salesOrgAccess) throws ServiceException {
		String methodName = "validateForCreateApproveAndBHD";
		//CreateApprove role validation
		if (Integer.toString(RoleConstants.CREATE_APPROVE).equals(role)) {
			// CR 4928
			//if (SalesOrgConstants.CANADA.equals(salesOrg) == true) {
			//	throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0204);
			//}
		}

		//SalesOrg for BHD role validation
		if (Integer.toString(RoleConstants.BHD).equals(role)|| Integer.toString(RoleConstants.OPPT_READ).equals(role) ) {
			GeoSecOffBOFactory geoSecOffBOFactory = new GeoSecOffBOFactory();
			String primarySalesOrg = salesOrg;
			GeoSecOffBO geoSecOffBO = null;

			try {
				geoSecOffBO = geoSecOffBOFactory.findGEOSecOffBOForSalesOrg(primarySalesOrg);
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			String selectedGeoSecOfficer = geoSecOffBO.getGeoSecOffSO();
			TreeMap salesOrgMap = salesOrgAccess;

			Iterator salesOrgIterator = salesOrgMap.keySet().iterator();
			while (salesOrgIterator.hasNext()) {
				primarySalesOrg = salesOrgIterator.next().toString();
				try {
					geoSecOffBO = geoSecOffBOFactory.findGEOSecOffBOForSalesOrg(primarySalesOrg);
				} catch (DomainException ex) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
				}
				if (selectedGeoSecOfficer.equals(geoSecOffBO.getGeoSecOffSO()) == false) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0207);
				}
			}
		}
	}

	/**
	 *  Method to validate of business rules for CreateApprove Role and BHD Role
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param String role
	 * @param String salesOrg
	 * @param HashMap salesOrgAccess
	 * @return void
	 *	  
	 */
	private void validateForRoleChange(String sRole, String eRole, String user) throws ServiceException {
		int selectRole = (sRole == null || sRole.trim().length() == 0) ? -1 : Integer.parseInt(sRole);
		int exisistingRole = (eRole == null || eRole.trim().length() == 0) ? -1 : Integer.parseInt(eRole);

		//CSO - Mark Rep Role
		if (exisistingRole == RoleConstants.CSO || exisistingRole == RoleConstants.MARKETING_REP) {
			if (selectRole != RoleConstants.CSO || selectRole != RoleConstants.MARKETING_REP) {
				if (selectRole == RoleConstants.PROPOSAL_APPROVER || selectRole == RoleConstants.MANAGER) {
					checkForProposalsForApproverAndManager(user);
				}

				if (selectRole == RoleConstants.BHD || selectRole == RoleConstants.BUSINESS_PARTNER || selectRole == RoleConstants.OPPT_READ) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0206);
				}

				// Commented as part of MN22686120 by Vinod K Burugupalli
				//				if (selectRole == RoleConstants.CREATE_APPROVE) {
				//				//  Create approve check for US removed
				//				//	checkForProposalsForCreateApprove(user, eRole);
				//				}
				// Commented as part of MN22686120 by Vinod K Burugupalli
			}
		}
		//BHD
		if (exisistingRole == RoleConstants.BHD || exisistingRole == RoleConstants.OPPT_READ) {
			if (selectRole != exisistingRole) {
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0206);
			}
		}
		//Proposal Approver
		if (exisistingRole == RoleConstants.PROPOSAL_APPROVER) {
			if (selectRole == RoleConstants.BHD || selectRole == RoleConstants.BUSINESS_PARTNER || selectRole==RoleConstants.OPPT_READ) {
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0206);
			}

			if (selectRole == RoleConstants.MANAGER || selectRole == RoleConstants.MARKETING_REP || selectRole == RoleConstants.CSO) {
				checkForProposalsForCSOAndMarkAndManager(user, eRole);
			}
			if (selectRole == RoleConstants.CREATE_APPROVE) {
				checkForProposalsForCreateApprove(user, eRole);
			}
		}
		//CreateApprove
		if (exisistingRole == RoleConstants.CREATE_APPROVE) {
			if (selectRole == RoleConstants.BHD || selectRole == RoleConstants.BUSINESS_PARTNER || selectRole == RoleConstants.OPPT_READ) {
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0206);
			}

			if (selectRole == RoleConstants.MANAGER || selectRole == RoleConstants.MARKETING_REP || selectRole == RoleConstants.CSO || selectRole == RoleConstants.PROPOSAL_APPROVER) {
				checkForProposalsForCSOAndMarkAndManager(user, eRole);
			}
		}
		//Manager
		if (exisistingRole == RoleConstants.MANAGER) {
			if (selectRole == RoleConstants.BHD || selectRole == RoleConstants.BUSINESS_PARTNER || selectRole == RoleConstants.OPPT_READ) {
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0206);
			}
		}
	}

	/**
	 *  Method to validate of business rules for CreateApprove Role and BHD Role
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param String userId
	 * @return void
	 * @throws ServiceException	  
	 */
	private void checkForProposalsForApproverAndManager(String userId) throws ServiceException {
		String methodName = "checkForProposalsForApproverAndManager";

		ProposalManagerLocalHome proposalManagerHome = (ProposalManagerLocalHome) HomeProvider.getLocal(HomeProvider.PROPOSAL_MANAGER_HOME_LOCAL);
		ProposalManagerLocal proposalManager;
		List proposalManagerList;

		try {
			proposalManager = proposalManagerHome.create();
		} catch (CreateException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		proposalManagerList = proposalManager.checkForProposalsForApproverAndManager(userId);

		if (proposalManagerList.size() > 0) {
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0209);
		}
	}
	/**
	 *  Method to validate of business rules for CreateApprove Role and BHD Role
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param String userId
	 * @param String exisitRole	 
	 * @return void
	 * @throws ServiceException	  
	 */
	private void checkForProposalsForCreateApprove(String userId, String exisitRole) throws ServiceException {
		String methodName = "checkForProposalsForCreateApprove";

		ProposalManagerLocalHome proposalManagerHome = (ProposalManagerLocalHome) HomeProvider.getLocal(HomeProvider.PROPOSAL_MANAGER_HOME_LOCAL);

		ProposalManagerLocal proposalManager;
		List proposalManagerList;

		try {
			proposalManager = proposalManagerHome.create();
		} catch (CreateException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		proposalManagerList = proposalManager.checkForProposalsForCreateApprove(userId, exisitRole);

		if (proposalManagerList != null && proposalManagerList.size() > 0) {
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0210);
		}
	}

	/**
	 *  Method to validate of business rules for CreateApprove Role and BHD Role
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param String userId
	 * @param String exisitRole	 
	 * @return void
	 * @throws ServiceException	  
	 */
	private void checkForProposalsForCSOAndMarkAndManager(String userId, String exisitRole) throws ServiceException {
		String methodName = "checkForProposalsForCSOAndMarkAndManager";

		ProposalManagerLocalHome proposalManagerHome = (ProposalManagerLocalHome) HomeProvider.getLocal(HomeProvider.PROPOSAL_MANAGER_HOME_LOCAL);
		ProposalManagerLocal proposalManager;
		List proposalManagerList;

		try {
			proposalManager = proposalManagerHome.create();
		} catch (CreateException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		proposalManagerList = proposalManager.checkForProposalsForCSOAndMarkAndManager(userId, exisitRole);

		if (proposalManagerList != null && proposalManagerList.size() > 0) {
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0209);
		}
	}

	/**
	 * signIn	 *  
	 * For authenticating the user
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDto
	 * @return SigninCustomDTO
	 * @throws ServiceException
	 */
	public SigninCustomDTO signIn(SigninCustomDTO customDto) throws ServiceException {
		String methodName = "signIn";

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();

		try {
			UserProfileBO userProfileBO = null;

			boolean isAuthenticated = true;

			try {
				UserProfileConnectorDTO userProfileConnectorDTO  = new UserProfileConnectorDTO();
				userProfileConnectorDTO.setUserID(customDto.getUserId());
				userProfileConnectorDTO.setLogon(true);
				userProfileConnectorDTO.setPassword(customDto.getPassword());

				CommunicationConnector communicationConnector = new CommunicationConnector();

				OPPTLogger.debug("Connecting with WI.", CLASS_NAME, methodName);
				userProfileConnectorDTO = communicationConnector.authenticate(userProfileConnectorDTO);
				OPPTLogger.debug("WI authentication completed!", CLASS_NAME, methodName);

				//sisAuthenticated = webIdentityConnectorDTO.isAuthenticated();

				customDto.setWIAuthenticated(isAuthenticated);

				if (isAuthenticated) {
					OPPTLogger.debug("Getting the user profile", CLASS_NAME, methodName);
					userProfileBO = userProfileBOFactory.getUserProfileBO(customDto.getUserId());
					OPPTLogger.debug("Profile fetched!", CLASS_NAME, methodName);
					
					/* Start change  CR0801074150 - CBS OPPT activity logging */
					OPPTLogger.infoActivityLogger("User id " +customDto.getUserId() + " successfully logged in !",CLASS_NAME, methodName);
					String message=" successfully logged in !";
					createActivityLog(customDto.getUserId(),message);
					/* End change  CR0801074150 - CBS OPPT activity logging */
				}

				customDto.setFirstName(userProfileConnectorDTO.getFirstName());
				customDto.setLastName(userProfileConnectorDTO.getLastName());
				customDto.setEmailAddress(userProfileConnectorDTO.getEmailAddress());

			} catch (DomainException e) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			} catch (ConnectorException e) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}

			if (null != userProfileBO) {
				customDto.setRole(userProfileBO.getRole());
				customDto.setPrimarySalesOrg(userProfileBO.getPrimarySalesOrg());
				customDto.setGroupName(userProfileBO.getGroupName());
//				Changes for Base agreement starts
				
				customDto.setUserType(userProfileBO.getUserType());
				customDto.setBaUserRole(userProfileBO.getBaRole());
//				Changes for Base agreement ends				
				// UD fix starts
				UserGroupBOFactory userGroupBOFactory = new UserGroupBOFactory();
				List userGroupBOList = userGroupBOFactory.findUserGroupBO(OPPTHelper.trimString(customDto.getUserId()));
				if (userGroupBOList.size() > 0) {
					TreeMap map = new TreeMap();
					for (int k = 0; k < userGroupBOList.size(); k++) {
						UserGroupBO userGroupBO = (UserGroupBO) userGroupBOList.get(k);
						map.put(userGroupBO.getGroupName(), userGroupBO.getGroupName());
					}
					customDto.setUserGroups(map);
				}

				// UD fix ends

				customDto.setOPPTUser(true);
				/*
				 * CR 4520 fix starts
				 */
				java.util.Date today = new java.util.Date();
				userProfileBO.setLastLoginDate((new java.sql.Date(today.getTime())));
				userProfileBO.setFirstName(customDto.getFirstName());
				userProfileBO.setLastName(customDto.getLastName());
				try {
					userProfileBOFactory.updateUserProfileBO(userProfileBO);

				} catch (DomainException e) {
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
					throw ExceptionGenerator.generateServiceException(e.getErrorReport());
				}

				/*
				 * CR 4520 fix ends
				 */

			} else {
				customDto.setOPPTUser(false);
			}

			return customDto;
		} catch (ServiceException ex) {
			throw ex;
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  
	 * Returns an ArrayList of Eligible Approvers for Registering a Proposal/Contract
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
	 * @param 
	 * @returns ArrayList
	 * @throws Service Exception
	 * @author Prakash Mall
	 */
	public List getEligibleApprover() throws ServiceException {
		String methodName = "getEligibleApprover";

		List userProfileList = new ArrayList();
		List userProfileDomainDTOList = new ArrayList();
		UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();

		try {
			userProfileList = userProfileBOFactory.findEligibleApprovers();
			Iterator iter = userProfileList.iterator();
			while (iter.hasNext()) {
				UserProfileDomainDTO userProfileDomainDTO = new UserProfileDomainDTO((UserProfileBO) iter.next());
				userProfileDomainDTOList.add(userProfileDomainDTO);
			}
		} catch (DomainException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		}

		return userProfileDomainDTOList;

	}

	/**
	 *  This method will get the users from same group
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userId
	 * @param groupName
	 * @param role
	 * @return UserGroupProfileDomainDTO
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public UserGroupProfileDomainDTO getUsersFromSameGrp(String userId, String groupName, int role) throws ServiceException {
		String methodName = "getUsersFromSameGrp";

		UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();
		UserGroupBOFactory userGroupBOFactory = new UserGroupBOFactory();

		UserGroupProfileDomainDTO userGroupProfileDomainDTO = new UserGroupProfileDomainDTO();
		List userProfileList;
		List groupCollection = null;

		try {
			userProfileList = userProfileBOFactory.findUserProfileBOForGroup(groupName);
			//Changed by Thirumalai kumar Starts here for UD
			groupCollection = userGroupBOFactory.findUserGroupBO(userId);
			Iterator userGroupIterator = groupCollection.iterator();
			while (userGroupIterator.hasNext()) {
				String userGroupName = ((UserGroupBO) userGroupIterator.next()).getGroupName();
				userProfileList.addAll(userProfileBOFactory.findUserProfileBOForGroup(userGroupName));
			}
			//Changed by Thirumalai kumar Ends

		} catch (DomainException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		}

		UserProfileBO userProfileBO = new UserProfileBO();
		switch (role) {
			case RoleConstants.MARKETING_REP :
				for (int i = 0; i < userProfileList.size(); i++) {
					userProfileBO = (UserProfileBO) userProfileList.get(i);
					if (userProfileBO.getRole() != RoleConstants.CSO && userProfileBO.getRole() != RoleConstants.CREATE_APPROVE && userProfileBO.getRole() != RoleConstants.MARKETING_REP) {
						userProfileList.remove(userProfileBO);
					}
				}
				break;

			case RoleConstants.PROPOSAL_APPROVER :
				for (int i = 0; i < userProfileList.size(); i++) {
					userProfileBO = (UserProfileBO) userProfileList.get(i);
					if (userProfileBO.getRole() != RoleConstants.PROPOSAL_APPROVER) {
						userProfileList.remove(userProfileBO);
					}
				}
				break;

			case RoleConstants.CSO :
				for (int i = 0; i < userProfileList.size(); i++) {
					userProfileBO = (UserProfileBO) userProfileList.get(i);
					if (userProfileBO.getRole() != RoleConstants.CSO && userProfileBO.getRole() != RoleConstants.CREATE_APPROVE && userProfileBO.getRole() != RoleConstants.MARKETING_REP) {
						userProfileList.remove(userProfileBO);
					}
				}
				break;

			case RoleConstants.CREATE_APPROVE :
				for (int i = 0; i < userProfileList.size(); i++) {
					userProfileBO = (UserProfileBO) userProfileList.get(i);
					if (userProfileBO.getRole() != RoleConstants.CSO && userProfileBO.getRole() != RoleConstants.CREATE_APPROVE && userProfileBO.getRole() != RoleConstants.MARKETING_REP) {
						userProfileList.remove(userProfileBO);
					}
				}
				break;

			case RoleConstants.BHD :
				for (int i = 0; i < userProfileList.size(); i++) {
					userProfileBO = (UserProfileBO) userProfileList.get(i);
					if (userProfileBO.getRole() != RoleConstants.BHD) {
						userProfileList.remove(userProfileBO);
					}
				}
				break;
				
			case RoleConstants.OPPT_READ :
				for (int i = 0; i < userProfileList.size(); i++) {
					userProfileBO = (UserProfileBO) userProfileList.get(i);
					if (userProfileBO.getRole() != RoleConstants.OPPT_READ) {
						userProfileList.remove(userProfileBO);
					}
				}
				break;	
		}

		userGroupProfileDomainDTO.setUserGroupProfileDomainDTOList(userProfileList);
		return userGroupProfileDomainDTO;
	}

	/**
	 * This method checks if the proposal is shared to loggedUser 
	 * OR Shared to someone in loggedUser group
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
	 * @param Hashmap
	 * @return boolean
	 * @throws ServiceException
	 * @author Prakash
	 */

	public boolean validateForSharing(HashMap compareValues) throws ServiceException {
		boolean result = false;
		String loggedUser = (String) compareValues.get(UtilityConstants.BO_USERID);
		String groupName = (String) compareValues.get(UtilityConstants.BO_GROUPNAME);
		String userHavingFullAccessOnProposal = (String) compareValues.get(UtilityConstants.BO_SHARING_ID);

		if (loggedUser.equalsIgnoreCase(userHavingFullAccessOnProposal)) {
			result = true;
		} else {
			// chk if the userHavingFullAccessOnProposal is in same grp as the logged user
			result = isUserFromSameGroup(loggedUser, userHavingFullAccessOnProposal);
		}
		return result;
	}
	
	/**
 	* isUserFromSameGroup
 	* isUserFromSameGroup
 	* 
	* @param user1
 	* @param user2
 	* @return boolean
 	* @throws ServiceException
 	*/
	public boolean isUserFromSameGroup(String user1, String user2) throws ServiceException {
		String grpName1 = null;
		String grpName2 = null;

		if (null != user1 && null != user2) {
			grpName1 = getUserProfile(user1).getGroupName();
			grpName2 = getUserProfile(user2).getGroupName();
		}

		if (null != grpName1 && null != grpName2) {
			return (grpName1.equalsIgnoreCase(grpName2));
		} else {
			return false;
		}
	}
	/**
	 * throwBackendTypeServiceException
	 * throwBackendTypeServiceException
	 * 
	 * @param errorCode
	 * @throws ServiceException
	 */
	private void throwBackendTypeServiceException(String errorCode) throws ServiceException {
		throw ExceptionGenerator.generateServiceException(ExceptionGenerator.getErrorReport(errorCode, OPPTMessageCatalog.TYPE_BACKEND));
	}
	/**
	 * 
	 * getManagerAndAdministrators
	 * getManagerAndAdministrators
	 * @param primarySalesOrg
	 * @return TreeMap
	 * @throws DomainException
	 */
	private TreeMap getManagerAndAdministrators(String primarySalesOrg) throws DomainException {
		String methodName = "getManagerAndAdministrators";

		GeoSecOffBOFactory geoSecOffBOFactory = new GeoSecOffBOFactory();
		GeoSecOffBO geoSecOffBO = geoSecOffBOFactory.findGEOSecOffBOForSalesOrg(primarySalesOrg);

		String geoSalesOrg = "";

		if (geoSecOffBO != null) {
			geoSalesOrg = geoSecOffBO.getGeoSecOffSO();
		}

		UserProfileBOFactory userProfileBOFactory = new UserProfileBOFactory();

		TreeMap managerMap = new TreeMap();

		String[] roles = { Integer.toString(RoleConstants.MANAGER), Integer.toString(RoleConstants.ADMINISTRATOR)};
		String[] sales = { primarySalesOrg, geoSalesOrg };

		for (int count = 0; count < roles.length; count++) {
			List list = null;
			try {
				list = userProfileBOFactory.findAllForSalesOrgAndRole(sales[count], roles[count]);
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ex;
			}

			UserProfileBO userProfileBO;
			String userID;

			for (int i = 0; i < list.size(); i++) {
				userProfileBO = (UserProfileBO) list.get(i);
				userID = OPPTHelper.trimString(userProfileBO.getUserId());
				managerMap.put(userID, userID);
			}
		}

		return managerMap;
	}

	/**
	 * listAllSalesOrgs
	 * listAllSalesOrgs
	 * @param customDTO
	 * @return ReverificationCustomDTO
	 * @throws ServiceException
	 */
	public ReverificationCustomDTO listAllSalesOrgs(ReverificationCustomDTO customDTO) throws ServiceException {
		String methodName = "listAllSalesOrgs";

		if (null != customDTO) {
			ProfileInputBO profileInputBO = null;
			ProfileInputBOFactory profileInputBOFactory = new ProfileInputBOFactory();

			TreeMap salesOrgs = new TreeMap();
			try {
				profileInputBO = profileInputBOFactory.getSalesOrg();
			} catch (DomainException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			SalesOrgBDO salesOrg = null;
			List salesOrgList = profileInputBO.getSalesOrgList();
			for (int i = 0, size = salesOrgList.size(); i < size; i++) {
				salesOrg = (SalesOrgBDO) salesOrgList.get(i);
				salesOrgs.put(OPPTHelper.trimString(salesOrg.getSalesOrg()), OPPTHelper.trimString(salesOrg.getSalesOrgDesc()));
			}

			customDTO.setSalesOrgs(salesOrgs);
		}

		return customDTO;
	}
	
	/**
 	* This method is used to show the groups which have proposals associated with a group
 	* @param userId
 	* @param role
 	* @param userGroupList
 	* @return
 	* @throws ServiceException
 	*/
	private TreeSet listGroupsforWhichUsersHaveProposals(String userId, int role, List userGroupList) throws ServiceException {

		ProposalManagerLocalHome proposalManagerHome = (ProposalManagerLocalHome) HomeProvider.getLocal(HomeProvider.PROPOSAL_MANAGER_HOME_LOCAL);
		ProposalManagerLocal proposalManager;
		TreeSet set = new TreeSet();

		try {
			proposalManager = proposalManagerHome.create();
		} catch (CreateException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "listGroupsforWhichUsersHaveProposals", null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		if (null != userGroupList) {
			for (int i = 0; i < userGroupList.size(); i++) {
				UserGroupBO userGroupBO = (UserGroupBO) userGroupList.get(i);
				String groupName = OPPTHelper.trimString(userGroupBO.getGroupName());
				ProposalDomainDTO [] proposalDomainDTO = proposalManager.findProposalsCreatedFromGroup(userId, groupName, role);
				if(null != proposalDomainDTO && proposalDomainDTO.length > 0) {
					
					set.add(groupName);
				}
				
			}

		}
		return set;
	}
	
	/**
	 * This method is used during transfer of proposals 
	 * @param user
	 * @param targetUser
	 * @return
	 * @throws ServiceException
	 */
	public boolean isTargetUserEligibleForTransfer(String user, String targetUser) throws ServiceException {
		boolean eligible = true;
		UserGroupBOFactory userGroupBOFactory = new UserGroupBOFactory();
		List userGroupBOList = new ArrayList();
		List targetUserGroupBOList = new ArrayList();
		userGroupBOList = userGroupBOFactory.findUserGroupBO(user);
		targetUserGroupBOList = userGroupBOFactory.findUserGroupBO(targetUser);
		if (userGroupBOList.size() > 0) {
			for (int i = 0; i < userGroupBOList.size(); i++) {
				UserGroupBO userGroupBO = (UserGroupBO) userGroupBOList.get(i);
				String userGroupName = userGroupBO.getGroupName();
				boolean matchingGroup = false;
				for (int k = 0; k < targetUserGroupBOList.size(); k++) {
					UserGroupBO targetUserGroupBO = (UserGroupBO) targetUserGroupBOList.get(k);
					String targetUserGroupName = targetUserGroupBO.getGroupName();
					if (userGroupName.equals(targetUserGroupName)) {
						matchingGroup = true;
					}
				}
				if (!matchingGroup) {
					eligible = false;
					break;
				}
			}
		} else if (userGroupBOList.size() == 0) {
			if (targetUserGroupBOList.size() != 0) {
				eligible = false;
			}
		}
		return eligible;
	}
	
	
	// retrieving activityLog added by Nomita
	
	public ActivityLogCustomDTO getActivityLog(
				ActivityLogCustomDTO activityLogCustomDTO)
				throws ServiceException {
			ErrorReport errorReport = new ErrorReport();
			List activityLogBOList = null;
			
					
			

			ActivityLogBOFactory activityLogBOFactory = new ActivityLogBOFactory();
						
			UserCustomDTO userCustomDTO = activityLogCustomDTO.getUserDTO();
			
			
			try {
				activityLogBOList = activityLogBOFactory
						.findActivityLogForUser(userCustomDTO);
			} catch (DomainException ex) {
				activityLogCustomDTO.setMessageReport(ex.getErrorReport());
			}
			

			Iterator activityLogIterator = activityLogBOList.iterator();
			
			while (activityLogIterator.hasNext()) {
				ActivityLogDataCustomDTO activityLogDataCustomDTO = new ActivityLogDataCustomDTO();
				ActivityLogBO activityLogBO = (ActivityLogBO) activityLogIterator
						.next();
				activityLogDataCustomDTO.setMessage(activityLogBO.getMessage());
				//System.out.println("UserManagerBean.getActivityLog(mesg)"+activityLogBO.getMessage());
				activityLogDataCustomDTO.setUserId(activityLogBO
						.getUserId());
				//System.out.println("UserManagerBean.getActivityLog(id)"+activityLogBO.getUserId());
				activityLogDataCustomDTO.setActivityDate(activityLogBO
						.getActivityDate());
				//System.out.println("UserManagerBean.getActivityLog(date)"+activityLogBO.getActivityDate());
				activityLogDataCustomDTO.setActivityTime(activityLogBO
						.getActivityTime());
				
				//System.out.println("UserManagerBean.getActivityLog(time)"+activityLogBO.getActivityTime());			
				activityLogCustomDTO
						.addActivityLog(activityLogDataCustomDTO);
				
					
					
				}
			
			return activityLogCustomDTO;
		}
// creating activity Log
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
	
// Nomita end
}