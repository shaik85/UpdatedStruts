/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds the basic information about modification of an agreement
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date jun 13, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Gavaskar Bhojan
 * 
 */
public class DisplayModificationViewBean extends OPPTViewBean{

    private TreeMap modificationTypes = null;

    private TreeMap selectedModifications = null;

    private String modificationStatus=null;
   
	
    
    

  
    /**
     *this is the getter method for modificationStatus 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:12:29 PM
     *
     * @return String.
     */
    public String getModificationStatus() {
        return modificationStatus;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:12:29 PM
     * @param lModificationStatus modificationStatus.
     */
    public void setModificationStatus(String lModificationStatus) {
        modificationStatus = lModificationStatus;
    }
    /**
     * Returns the modificationTypes.
     * 
     * @return TreeMap
     */
   
	
	
	public TreeMap getModificationTypes() {
        return modificationTypes;
    }

    /**
     * sets all the modification Types
     * 
     * @param lmodificationTypes TreeMap
     *            
     */
    public void setModificationTypes(TreeMap lmodificationTypes) {
        modificationTypes = lmodificationTypes;
    }

    /**
     * Returns the selectedModifications.
     * 
     * @return TreeMap
     */
    public TreeMap getSelectedModifications() {
        return selectedModifications;
    }

    /**
     * sets the modifications which are selected
     * 
     * @param lselectedModifications TreeMap
     *            
     */
    public void setSelectedModifications(TreeMap lselectedModifications) {
        selectedModifications = lselectedModifications;
    }
   

}


