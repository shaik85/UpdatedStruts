/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A 
 */
public class SignInViewBean extends OPPTViewBean{
	String iUserId;

	
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getUserId() {
		return iUserId;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setUserId(String string) {
		iUserId = string;
	}
	
	/**
     * getRegisterURL
     * 
     * @return
     * @author thirumalai
     */
    public String getRegisterURL(){
		return OPPTPropertiesReader.getSignInRegister();
	}
	/**
     * getForgotIDURL
     * 
     * @return
     * @author thirumalai
     */
    public String getForgotIDURL(){
		return OPPTPropertiesReader.getSignInForgotID();
	}
	/**
     * getForgotPasswordURL
     * 
     * @return
     * @author thirumalai
     */
    public String getForgotPasswordURL(){
		return OPPTPropertiesReader.getSignInForgotPassword();
	}
	/**
     * getChangePasswordURL
     * 
     * @return
     * @author thirumalai
     */
    public String getChangePasswordURL(){
		return OPPTPropertiesReader.getSignInChangePassword();
	}
	/**
     * getWIHelpAndFAQURL
     * 
     * @return
     * @author thirumalai
     */
    public String getWIHelpAndFAQURL(){
		return OPPTPropertiesReader.getSignInWIHelpAndFAQ();
	}
}