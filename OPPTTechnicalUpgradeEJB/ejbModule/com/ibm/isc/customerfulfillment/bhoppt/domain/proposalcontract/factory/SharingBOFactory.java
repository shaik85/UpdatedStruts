/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.SharingBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.SharingLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
/** 
 * This class is to Create, Update, Remove and Find Sharing entities. 
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


public class SharingBOFactory {
	private Collection sharingCollection = null;

	private static final String SHARING_LOCAL_HOME = "SharingLocalHome";
	/**
	 * This Factory method is used to get the proposals/contracts which are shared by particular userId
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  String userId
	 * @throws DomainException
	 * @return List
	 */

	public List findSharingBOForUsers(String userId) throws DomainException {
		SharingBO sharingBO = null;
		List sharingList = null;
		SharingLocal sharingLocal = null;
		SharingLocalHome sharingLocalHome = getSharingLocalHome();
		try {
			sharingCollection = sharingLocalHome.findByUser(userId);
		} catch (FinderException ex) {
			// If the proposal is not shared to userId, then the findByUser(userId) will throw a finder exception.
			// its valid scenerio as per business rule and no Exception need to be thrown. 
		}

		if (sharingCollection != null) {
			Iterator sharingIterator = sharingCollection.iterator();
			sharingList = new ArrayList();
			while (sharingIterator.hasNext()) {
				sharingLocal = (SharingLocal) sharingIterator.next();
				sharingBO = new SharingBO();
				sharingBO.setAccessType(OPPTHelper.trimString(sharingLocal.getAccessType()));
				sharingBO.setProposalId(sharingLocal.getProposalId());
				// Fix for BHD transfer proposals 
				// Defect 8 
				sharingBO.setAccessTo(OPPTHelper.trimString(sharingLocal.getAccessTo()));
				sharingList.add(sharingBO);
			}
		}
		return sharingList;
	}

	/**
	 * This factory method retuns the local home for Sharing bean
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  
	 * @throws 
	 * @return 
	 * @author prakash
	 */

	private SharingLocalHome getSharingLocalHome() {
		return (SharingLocalHome) HomeProvider.getLocal(HomeProvider.SHARING_LOCAL_HOME);
	}

	/** 
	 * Returns the SharingBO for the proposal and user
	 * If the user has access to the proposal return SharingBO, else null. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param user
	 * @return SharingBO
	 * @throws DomainException 
	 */
	public SharingBO getSharingBO(int proposalID, String user) throws DomainException {
		SharingBO sharingBO = null;
		SharingLocal sharingLocal = null;
		SharingLocalHome sharingLocalHome = getSharingLocalHome();

		if (user == null) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0601);
		}

		try {
			sharingLocal = (SharingLocal) sharingLocalHome.findByPrimaryKey(new SharingKey(proposalID, user));
		} catch (FinderException e) {
			return null;
		} catch (Exception e) {
			OPPTLogger.log(
				ErrorCodeConstants.APP_GENERAL_EXCEPTION,
				OPPTLogger.ERROR,
				"SharingBOFactory",
				"getSharingBO",
				null,
				e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		sharingBO = new SharingBO();
		sharingBO.setAccessType(sharingLocal.getAccessType());
		sharingBO.setAccessTo(user);
		sharingBO.setProposalId(proposalID);

		return sharingBO;
	}

	/**
	 * @param proposalID
	 * @return
	 */
	public List findSharingBOByProposalId(int proposalID) {

		ArrayList sharingBOList = new ArrayList();
		SharingLocal sharingLocal = null;

		SharingLocalHome sharingLocalHome = getSharingLocalHome();
		try {
			Collection col = sharingLocalHome.findByProposalId(proposalID);
			Iterator iter = col.iterator();
			while (iter.hasNext()) {
				sharingLocal = (SharingLocal) iter.next();
				SharingBO sharingBO = new SharingBO();
				populateDataFromEntity(sharingBO, sharingLocal);
				sharingBOList.add(sharingBO);
			}
		} catch (FinderException ex) {
			return null;
		}
		return sharingBOList;
	}

	private void populateDataFromEntity(SharingBO sharingBO, SharingLocal sharingLocal) {
		sharingBO.setProposalId(sharingBO.getProposalId());
		sharingBO.setAccessType(sharingLocal.getAccessType());
		sharingBO.setAccessTo(sharingLocal.getAccessTo());
	}

	/**
	 * @param ProposalId
	 * @param userName
	 * @throws DomainException
	 */
	public void deleteSharingBO(int ProposalId, String userName) throws DomainException {
		SharingLocal sharingLocal = null;

		SharingLocalHome sharingLocalHome = getSharingLocalHome();
		try {
			sharingLocal = (SharingLocal) sharingLocalHome.findByPrimaryKey(new SharingKey(ProposalId, userName));
			sharingLocal.remove();
		} catch (FinderException ex) {
			throw ExceptionGenerator.generateDomainException("DE0824");
		} catch (RemoveException ex) {
			throw ExceptionGenerator.generateDomainException("DE0801");
		}
	}

	/**
	 * @param sharingBO
	 * @throws DomainException
	 */
	public void updateSharingBO(SharingBO sharingBO) throws DomainException {
		try {
			SharingLocalHome localHome = getSharingLocalHome();
			SharingKey key = new SharingKey(sharingBO.getProposalId(), sharingBO.getAccessTo());

			SharingLocal local = localHome.findByPrimaryKey(key);
			local.setAccessType(sharingBO.getAccessType());
		} catch (FinderException e) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}
	
	/**
	 * @param sharingBO
	 * @param accessTo
	 * @throws DomainException
	 */
	public void updateSharingBO(SharingBO sharingBO, String accessTo) throws DomainException {
		try {
			SharingLocalHome localHome = getSharingLocalHome();
			SharingKey key = new SharingKey(sharingBO.getProposalId(), sharingBO.getAccessTo());

			SharingLocal local = localHome.findByPrimaryKey(key);
			local.setAccessType(sharingBO.getAccessType());
			local.setAccessTo(accessTo);
			
		} catch (FinderException e) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}

	/**
	 * @param sharingBO
	 * @throws DomainException
	 */
	public void createSharingBO(SharingBO sharingBO) throws DomainException {
		try {
			SharingLocalHome localHome = getSharingLocalHome();

			SharingLocal local = localHome.create(sharingBO.getProposalId(), sharingBO.getAccessTo());
			local.setAccessType(sharingBO.getAccessType());
		} catch (CreateException e) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}

	/**
	 * @param proposalId
	 * @return
	 */
	public SharingBO getSharingBOWithFullAccessOnPropsoal(int proposalId) {

		SharingBO sharingBO = new SharingBO();

		try {
			SharingLocalHome localHome = getSharingLocalHome();

			SharingLocal local = localHome.findByProposalAndAccess(proposalId);
			populateDataFromEntity(sharingBO, local);
		} catch (FinderException ex) {
			sharingBO = null;
		}
		return sharingBO;
	}
}
