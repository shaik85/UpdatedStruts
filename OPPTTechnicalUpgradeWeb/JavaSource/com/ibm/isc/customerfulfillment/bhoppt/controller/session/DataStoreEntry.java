/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.session;

import java.io.Serializable;

/**
 * This class is used to create a new entry to be added into the
 * ActionDataStore. This holds the actionID and a object associated with the
 * actionID. ActionDataStore uses this actionID to get the object associated and
 * work with the DataStoreEntry.
 * 
 * @author vinodkumarb
 */
public class DataStoreEntry implements Serializable {
    /**
     * This is the action identifier which is used by ActionDataStore to work
     * with the object associated with.
     */
    private String actionID = null;
    
    /**
     * This is the object that is associated with the actionID.
     */
    private Object storedData = null;
    
    /**
     * Returns actionID
     * 
     * @return String
     */
    public String getActionID() {
        return actionID;
    }
    
    /**
     * Retuen the object associated with the actionID
     * 
     * @return Object
     */
    public Object getStoredData() {
        return storedData;
    }
    
    /**
     * Sets the newActionID passed as actionID
     * 
     * @param newActionID
     *            String value which is used as actionID by the ActionDataStore
     */
    public void setActionID(String newActionID) {
        actionID = newActionID;
    }
    
    /**
     * Sets the newStoredData to the storedData.
     * 
     * @param newStoredData
     *            Object value which is stored along with the actionID to be
     *            used by the ActionDataStore.
     */
    public void setStoredData(Object newStoredData) {
        storedData = newStoredData;
    }
}
