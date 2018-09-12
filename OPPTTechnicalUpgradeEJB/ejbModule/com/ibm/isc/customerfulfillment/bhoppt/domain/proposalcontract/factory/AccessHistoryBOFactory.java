/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.AccessHistoryBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/** 
 * This class is to Create, Update, Remove and Find AccessHistory entities.  
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
public class AccessHistoryBOFactory {
	private static final String CLASS_NAME = "AccessHistoryBOFactory";

	private static int sequenceNo = 0;

	/**
	 * @param accessHistoryBO
	 * @throws DomainException
	 */
	public void create(AccessHistoryBO accessHistoryBO) throws DomainException {
		String methodName = "create";
       		AccessHistoryLocalHome accessHistoryLocalHome = getAccessHistoryLocalHome();
		AccessHistoryLocal accessHistoryLocal = null;

		try {
					accessHistoryLocal = accessHistoryLocalHome.create(accessHistoryBO.getProposalId(), accessHistoryBO.getUserId(), new java.sql.Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()), getNextSequenceNo());
        		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		accessHistoryLocal.setOperationPerformed(accessHistoryBO.getOperationPerformed());
	}

	/** 
	 * find if User has touched the proposal in the past.  
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Prakash Mall
	 * @version 5.1A 
	 * @exception
	 * @return boolean
	 * 
	 */

	public List findAccessHistoryForProposal(int proposalId, String userId) throws DomainException {
		boolean userAccessTheProposal = true;
		AccessHistoryLocalHome accessHistoryLocalHome = getAccessHistoryLocalHome();
		List accessHistoryList = new ArrayList();
		Collection accessHisCol = null;

		try {
			if (null != userId) {
				accessHisCol = accessHistoryLocalHome.findByProposalIDAndUserID(proposalId, userId);
			} else {
				accessHisCol = accessHistoryLocalHome.findByProposalID(proposalId);
			}			
		} catch (FinderException ex) {
			// left it blank for purpose. If null, it means that for this proposal, the user has not accessed it.
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0417); 
		}
		
		Iterator iter = accessHisCol.iterator();
		AccessHistoryLocal accessHistoryLocal = null;

		while (iter.hasNext()) {
			AccessHistoryBO accessHistoryBO = new AccessHistoryBO();
			accessHistoryLocal = (AccessHistoryLocal) iter.next();
			accessHistoryBO.setUserId(accessHistoryLocal.getUserId());
			accessHistoryBO.setAccessDate(accessHistoryLocal.getAccessDate());
			accessHistoryBO.setOperationPerformed(accessHistoryLocal.getOperationPerformed());
		// added by Nomita for Activity Log changes
		// start
			accessHistoryBO.setAccessTime(accessHistoryLocal.getAccessTime());
			accessHistoryBO.setSequenceNo(accessHistoryLocal.getSeqNo());
		
		//end	
			accessHistoryList.add(accessHistoryBO);
		}

		return accessHistoryList;

	}
	


	private AccessHistoryLocalHome getAccessHistoryLocalHome() {
		return (AccessHistoryLocalHome) HomeProvider.getLocal(HomeProvider.ACCESS_HISTORY_LOCAL_HOME);
	}

	private static synchronized int getNextSequenceNo() {
		return sequenceNo++;
	}
}