/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory;

import javax.ejb.FinderException;

import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

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
public class ValidCombinationBOFactory {
	
	
	public boolean isValidCombination(String salesOrg,
									  String divisionCode,
									  String dstrChannel) {
									  	
		boolean validCombination = true;
		SalesAreaLocalHome salesAreaLocalHome = (SalesAreaLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome("SalesAreaLocalHome");
		SalesAreaLocal salesAreaLocal = null;
		
		//SalesAreaKey key = new SalesAreaKey(salesOrg, dstrChannel, divisionCode);
		SalesAreaKey key = new SalesAreaKey(salesOrg, divisionCode, dstrChannel);
		
		try {
			salesAreaLocal = salesAreaLocalHome.findByPrimaryKey(key);
		} catch (FinderException e) {
			validCombination = false;
		}
		
		if(salesAreaLocal == null) {
			validCombination = false;
		}
		
		return validCombination;
	}
	
	
	
	

}
