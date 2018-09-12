/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo;

import java.util.HashMap;
import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementStatusConstant;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.SalesOrgConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * This class checks the business condition against BaseAgreementBDO attributes
 * <br/><b>Known Bugs</b><br/>
 * <br/><PRE>
 * date Jun 14, 2006
 * revision date author reason
 * </PRE><br/>
 *
 * @author Sasi R Challa
 * @version CBS 2.1
 */
public class BaseAgreementBO extends BaseAgreementBDO{
	
	protected boolean postCondition = false;
	public HashMap postConditionResult = null;
	protected boolean preCondition = false;
	protected ErrorReport errorReport = new ErrorReport();
	
	public void validateForInactive(HashMap compareValues) throws DomainException
	{	
		validateRole(compareValues);
		if((BaseAgreementStatusConstant.Inactive).equals(getAgreementStatus()))
		{
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1001);
			
		}
	}
	public void validateForActive(HashMap compareValues) throws DomainException
	{	
		validateRole(compareValues);
		if((BaseAgreementStatusConstant.Active).equals(getAgreementStatus()))
		{
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1013);
			
		}
	}
	
	public void validateRole(HashMap compareValues) throws DomainException
	{
		if(!new Integer(RoleConstants.CREATE_UPDATE).equals(compareValues.get(UtilityConstants.BO_ROLE))) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1003);
		}
	}

	public void validateAgreementHeader(HashMap compareValues) throws DomainException 
	{
		validateRole(compareValues);
		if (!(SalesOrgConstants.USA.equals(getSalesOrganization()) || SalesOrgConstants.CANADA.equals(getSalesOrganization())))
		{
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1008);
		}
		/* if(isFieldEmpty(getEnterpriseNumber()) && isFieldEmpty(getCustomerNumber()))
		{ throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1009);		} */
						
		if(!isFieldEmpty(getCustomerNumber()) && isFieldEmpty(getCustomerName()))
		{
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1010);
		}
		/*if(!isFieldEmpty(getEnterpriseNumber()) && isFieldEmpty(getEnterpriseName())){
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1011);	
				} */
		if (isFieldEmpty(getAgreementNumber()))
		{
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1004);
		}
		if (isSelectEmpty(getFormNumber())) 
		{
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1005);
		}
		if (isSelectEmpty(getCoverageType())) 
		{
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1006);
		}
		if (isFieldEmpty(getCustomerRepresentative())) 
		{
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1007);
		}		
	}
	
	protected boolean isSelectEmpty(String selectValue){
		boolean empty = false;
		if(null == selectValue){
			empty = true;
		}
		else if(0 != selectValue.length() && selectValue.equalsIgnoreCase("Select one")){ 
			empty = true;
		}
		return empty;		
	}
	protected boolean isFieldEmpty(String fieldValue){
		boolean empty = false;
		if(null == fieldValue){
			empty = true;
		}
		else if(0 == fieldValue.trim().length()){
			empty = true;
		}
		return empty;		
	}
	
	public boolean validateForAmend() throws DomainException{
		boolean result = true;
		if(BaseAgreementStatusConstant.Inactive.equals(getAgreementStatus())) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1002);
		}
		return result;
	}
	public boolean validateForFormNumber(boolean result) throws DomainException{
		boolean target = result;
		if(target == false) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1012);
		}
		return target;
	}
}
