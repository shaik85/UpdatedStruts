
/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
/**
 * Remote interface for Enterprise Bean: ProposalDataManager
 */
public interface ProposalDataManager extends javax.ejb.EJBObject {
	/**
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
	 * @return 
	 * @throws 
	 */
	public OPPTCustomDTO updateSalesOrg(OPPTCustomDTO opptCustomDTO)
		throws ServiceException, java.rmi.RemoteException;
	/**
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
	 * @return 
	 * @throws 
	 */
	public OPPTCustomDTO updateCurrency(OPPTCustomDTO opptCustomDTO)
		throws ServiceException, java.rmi.RemoteException;
	/**
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
	 * @return 
	 * @throws 
	 */
	public OPPTCustomDTO updatePayment(OPPTCustomDTO opptCustomDTO)
		throws ServiceException, java.rmi.RemoteException;
	/**
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
	 * @return 
	 * @throws 
	 */
	public OPPTCustomDTO updateBilling(OPPTCustomDTO opptCustomDTO)
		throws ServiceException, java.rmi.RemoteException;
	/**
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
	 * @return 
	 * @throws 
	 */
	public OPPTCustomDTO updateBillingBlock(OPPTCustomDTO opptCustomDTO)
		throws ServiceException, java.rmi.RemoteException;
	
	
//	Added by Srinivas-------OPPTBH-DAD003
	/**
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
	 * @return 
	 * @throws 
	 */
	public OPPTCustomDTO updateComplexTypes(OPPTCustomDTO opptCustomDTO)
	throws ServiceException, java.rmi.RemoteException;
		
	public void populateStaticData() throws ServiceException, java.rmi.RemoteException;
}
