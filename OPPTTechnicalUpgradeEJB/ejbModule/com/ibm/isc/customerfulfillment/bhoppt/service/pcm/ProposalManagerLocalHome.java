/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import javax.ejb.EJBLocalHome;

/** 
 * Local Home for Proposal Manager
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 18, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham K Mani
 * @version 5.1A 
 */
public interface ProposalManagerLocalHome extends EJBLocalHome
{
	public com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerLocal create()
			throws javax.ejb.CreateException;
}