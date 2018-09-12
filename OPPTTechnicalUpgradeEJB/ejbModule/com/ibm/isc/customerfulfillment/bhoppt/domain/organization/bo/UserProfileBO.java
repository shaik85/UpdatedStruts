/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo;

import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
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
public class UserProfileBO extends UserProfileBDO
{
	private ErrorReport errorReport = new ErrorReport();
	private ErrorEntry errorEntry = null;

	public void validateForCreate(TreeMap salesAreaAccessType) throws ServiceException
	{
		//Business Validations : Sales org of user profile
		if (getPrimarySalesOrg() == null)
		{
			ErrorKey key = new ErrorKey(ErrorCodeConstants.SE0208, OPPTMessageCatalog.TYPE_SERVICE);
			errorReport.addErrorEntry(key, null);
		}

		if (getRole() != 5)
		{
			//Business Validations : Primary sales org of user profile – Rule 1
			if (salesAreaAccessType.size() == 1)
			{
				setPrimarySalesOrg(salesAreaAccessType.keySet().iterator().next().toString());
			}

			//Business Validations : Primary sales org of user profile – Rule 2
			if (salesAreaAccessType.size() > 1)
			{
				setPrimarySalesOrg(getPrimarySalesOrg());
			}
		}

		if (errorReport.size() > 0)
		{
			ServiceException se = new ServiceException();
			se.setErrorReport(errorReport);
			throw se;
		}
	}

	public void validateForEdit(TreeMap salesAreaAccessType) throws ServiceException
	{
		//Business Validations : Sales org of user profile
		if (getPrimarySalesOrg() == null)
		{
			ErrorKey key = new ErrorKey(ErrorCodeConstants.SE0208, OPPTMessageCatalog.TYPE_SERVICE);
			errorReport.addErrorEntry(key, null);
		}

		//Business Validations : Primary sales org of user profile – Rule 1
		if (getRole() != 5)
		{
			if (salesAreaAccessType.size() == 1)
			{
				setPrimarySalesOrg(salesAreaAccessType.keySet().iterator().next().toString());
			}

			//Business Validations : Primary sales org of user profile – Rule 2
			if (salesAreaAccessType.size() > 1)
			{
				setPrimarySalesOrg(salesAreaAccessType.keySet().iterator().next().toString());
			}
		}

		if (errorReport.size() > 0)
		{
			ServiceException se = new ServiceException();
			se.setErrorReport(errorReport);
			throw se;
		}

	}

	public boolean validateForTransferProposal(int role, String sourceUser)
	{
		if (getUserId().equals(sourceUser))
		{
			return false;
		}
		
		int userRole = getRole();
		
		if (role == RoleConstants.CSO || role == RoleConstants.MARKETING_REP)
		{
			if (userRole == RoleConstants.CREATE_APPROVE || userRole == role)
			{
				return true;
			}
		}

		if (role == RoleConstants.CREATE_APPROVE)
		{
			if (userRole == RoleConstants.CSO
				|| userRole == RoleConstants.MARKETING_REP
				|| userRole == RoleConstants.CREATE_APPROVE
				|| userRole == RoleConstants.PROPOSAL_APPROVER)
				return true;
		}

		if (role == RoleConstants.BUSINESS_PARTNER)
		{
			if (userRole == RoleConstants.CSO)
			{
				return true;
			}
		}

		if (role == RoleConstants.PROPOSAL_APPROVER)
		{
			if (userRole == RoleConstants.CREATE_APPROVE || getRole() == role)
			{
				return true;
			}
		}

		return false;
	}
}