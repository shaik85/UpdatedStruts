/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;

import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.ProposalDataManagerHome;

/**
 * OPPTActionServlet is customized ActionServlet for OPPT Application. init() method is
 * overriden for parsing the messages available in an xml file, and create a message 
 * catalog and store it in application memory.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class OPPTActionServlet extends ActionServlet {
	/**
	 * Overridden method - Overriden for parsing the error messages, that are stored in an XML document,
	 * creating message catalog out of those messages and load it into memory. 
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see javax.servlet.GenericServlet#init() 
	 * @throws ServletException 
	 *
	 */
	public void init() throws ServletException {
		OPPTSession opptSession = new OPPTSession(null);
		opptSession.clean();

		OPPTMessageCatalog.getInstance(); 

		super.init();
		
		try{		
			ProposalDataManagerHome pcmHome = (ProposalDataManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("ProposalDataManagerHome");  //$NON-NLS-1$
			ProposalDataManager pcm = pcmHome.create();
			pcm.populateStaticData();
		}
		catch(Exception e){
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"OPPTActionServlet","init",null,e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
		}
	}
}
