/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CCMSDataCustomDTO extends OPPTCustomDTO {
    
    private String uRL = null;
    
    private String cCMSUserID = null;
    
    private String passWord = null;
    
    

    /**
     *gets the  passWord
     *
     * @return Returns the passWord.
     */
    public String getPassWord() {
        return passWord;
    }
    /**
     * sets the passWord
     * @param passWord The passWord to set.
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    /**
     *gets the  uRL
     *
     * @return Returns the uRL.
     */
    public String getURL() {
        return uRL;
    }
    /**
     * sets the uRL
     * @param url The uRL to set.
     */
    public void setURL(String url) {
        uRL = url;
    }
   
    /**
     *gets the  cCMSUserID
     *
     * @return Returns the cCMSUserID.
     */
    public String getCCMSUserID() {
        return cCMSUserID;
    }
    /**
     * sets the cCMSUserID
     * @param userID The cCMSUserID to set.
     */
    public void setCCMSUserID(String userID) {
        cCMSUserID = userID;
    }
}
