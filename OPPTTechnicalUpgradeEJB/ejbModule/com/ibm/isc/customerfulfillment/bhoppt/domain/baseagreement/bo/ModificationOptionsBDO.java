/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ModificationOptionsBDO {
    
    private String modificationTypeCode = null;
    private String modificationOption= null;
    private String modificationOptionDesc= null;

    /**
     * return the modificationOption 
     *
     * @return Returns the modificationOption.
     */
    public String getModificationOption() {
        return modificationOption;
    }
    /**
     * sets the modificationOption
     *
     * @param modificationOption The modificationOption to set.
     */
    public void setModificationOption(String lmodificationOption) {
        modificationOption = lmodificationOption;
    }
    /**
     * return the modificationOptionDesc 
     *
     * @return Returns the modificationOptionDesc.
     */
    public String getModificationOptionDesc() {
        return modificationOptionDesc;
    }
    /**
     * sets the modificationOptionDesc
     *
     * @param modificationOptionDesc The modificationOptionDesc to set.
     */
    public void setModificationOptionDesc(String lmodificationOptionDesc) {
        modificationOptionDesc = lmodificationOptionDesc;
    }
    /**
     * return the modificationTypeCode 
     *
     * @return Returns the modificationTypeCode.
     */
    public String getModificationTypeCode() {
        return modificationTypeCode;
    }
    /**
     * sets the modificationTypeCode
     *
     * @param modificationTypeCode The modificationTypeCode to set.
     */
    public void setModificationTypeCode(String lmodificationTypeCode) {
        modificationTypeCode = lmodificationTypeCode;
    }
}
