/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.session;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * ActionDataStore is an Stack object which is used to store the
 * DataStoreEntries. This class provides methods to work on the stack object. In
 * the OPPTSession this ActionDataStore is used to store the custom dtos into
 * session with actionId as key value.
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date Nov 11, 2003
 * 
 * revision date author reason
 * 
 * </PRE>
 * 
 * <br/>
 * 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ActionDataStore extends Stack implements Serializable {
    /**
     * Given the actionID this method searches for the DataStoreEntry whise
     * actionId is same as the actionID passed and returns its index value. If
     * no matching DataSoreEntry found it returns -1.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 11, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param actionID
     *            String value which is used as action identifier
     * @return int position in the stack where the DataStoreEntry is present
     */
    public int searchActionID(String actionID) {
        int searchIndex = -1;
        for (int i = 0; i < size(); i++) {
            if (actionID.equalsIgnoreCase(((DataStoreEntry) get(i))
                    .getActionID())) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }
    
    /**
     * This method removed all the DataStoreEntry's that are stored after the
     * DataStoreEntry whise actionID is equal to the String value passed as
     * argument.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 11, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param actionID
     *            String value which is the base DataStoreEntry index for
     *            removing all the DataStoreEntry's that are stored after.
     */
    public void removeInvalidDataStoreEntries(String actionID) {
        boolean proceed = true;
        
        while (proceed && (size() != 0)) {
            try {
                if (actionID.equalsIgnoreCase(((DataStoreEntry) peek())
                        .getActionID())) {
                    proceed = false;
                }
                pop();
            } catch (EmptyStackException e) {
                proceed = false;
            }
        }
    }
    
    /**
     * This method removes all the DataStoreEntry's that are stored as part of
     * the ActionDataStore.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 11, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     *  
     */
    public void removeAllDataStoreEntries() {
        removeAllElements();
    }
    
    /**
     * removeAllDataStoreEntries
     * 
     * @param actionIDs
     * @author thirumalai
     */
    public void removeAllDataStoreEntries(String actionIDs[]) {
        if (null == actionIDs) {
            removeAllElements();
        } else {
            boolean proceed = true;
            
            while (proceed && (size() != 0)) {
                try {
                    String actionID = ((DataStoreEntry) peek()).getActionID();
                    for (int i = 0, size = actionIDs.length; i < size; i++) {
                        if (actionID.equalsIgnoreCase(actionIDs[i])) {
                            proceed = false;
                            break;
                        }
                    }
                    if (proceed) {
                        pop();
                    }
                } catch (EmptyStackException e) {
                    proceed = false;
                }
            }
        }
    }
    
    /**
     * Adds the DataStoreEntry into the collection (Stack).
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 11, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param entry
     *            DataStoreEntry new entry to be added into the collection of
     *            DataStoreEntry's
     */
    public void addDataStoreEntry(DataStoreEntry entry) {
        push(entry);
    }
    
    /**
     * This method returns the DataStoreEntry present the postion passed.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 11, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param position
     *            int value which is index value to get the DataStoreEntry
     * @return DataStoreEntry
     */
    public DataStoreEntry getDataStoreEntry(int position) {
        return (DataStoreEntry) get(position);
    }
    
    /**
     * Given the action id, this method removed all the data store entry's store
     * after the action id, and data store store entry associated with the
     * action id and returns the data store entry that is just before the given
     * action id.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Mar 23, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param actionID
     * @return DataStoreEntry
     */
    public DataStoreEntry getDataStoreEntryBefore(String actionID) {
        DataStoreEntry dataStoreEntry = null;
        
        try {
            // Remove the data store entry stored with the given action id
            boolean proceed = true;
            while (proceed && (size() != 0)) {
                if (actionID.equalsIgnoreCase(((DataStoreEntry) peek())
                        .getActionID())) {
                    proceed = false;
                }
                pop();
            }
            
            // Get the data store entry associated with the last action item
            dataStoreEntry = (DataStoreEntry) peek();
        } catch (EmptyStackException e) {
            dataStoreEntry = null;
        }
        
        return dataStoreEntry;
    }
}