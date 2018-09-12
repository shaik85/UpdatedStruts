/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.session;

import javax.servlet.http.HttpSession;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * OPPTSession is a wrapper class around the HttpSession object. OPPTSession
 * object provides methods for accessing the HttpSession.
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date Nov 12, 2003
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
public class OPPTSession {
    private static final String EXCEPTION = "EXCEPTION"; /* NOI18N */
    
    private static final String CLASS_NAME = "OPPTSession"; /* NOI18N */
    
    private HttpSession httpSession = null;
    
    private ActionDataStore actionDataStore = null;
    
    private SessionDAO sessionDAO = new SessionDAO();
    
    /**
     * Constructor Creates a new wrapper OPPTSession object for the HttpSession
     * object
     * 
     * <br/>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br/>
     * 
     * @param newHttpSession
     *            HttpSession value
     */
    public OPPTSession(HttpSession newHttpSession) {
        httpSession = newHttpSession;
        try {
            actionDataStore = (ActionDataStore) getSessionData(SessionConstants.SESSION_ACTION_DATA_STORE_KEY);
        } catch (Exception e) {
            actionDataStore = new ActionDataStore();
        }
        if (actionDataStore == null) {
            actionDataStore = new ActionDataStore();
        }
    }
    
    /**
     * Returns complete user details that is stored as part of HttpSession
     * object
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 24, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return UserInfoDataBean
     */
    public UserInfoDataBean getUserInfo() {
        return (UserInfoDataBean) httpSession
        .getAttribute(SessionConstants.SESSION_USERINFO_KEY);
    }
    
    /**
     * Returns the lastActionID value which is stored as part of the HttpSession
     * object.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return String
     */
    public String getLastActionID() {
        String lastActionId = null;
        
        try {
            lastActionId = (String) getObjectFromSession(SessionConstants.SESSION_LAST_ACTION_KEY);
        } catch (Exception e) {
            lastActionId = null;
        }
        
        return lastActionId;
    }
    
    /**
     * Returns the lastViewBean which is stored as part of the HttpSession
     * object.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return OPPTViewBean
     */
    public OPPTViewBean getLastViewBean() {
        OPPTViewBean lastViewBean = null;
        
        try {
            lastViewBean = (OPPTViewBean) getObjectFromSession(SessionConstants.SESSION_LAST_VIEW_KEY);
        } catch (Exception e) {
            lastViewBean = null;
        }
        
        return lastViewBean;
    }
    
    /**
     * Returns the lastActionForm which is stored as part of the HttpSession
     * object.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return OPPTActionForm
     */
    public OPPTActionForm getLastActionForm() {
        OPPTActionForm lastActionForm = null;
        
        try {
            lastActionForm = (OPPTActionForm) getObjectFromSession(SessionConstants.SESSION_LAST_FORM_KEY);
        } catch (Exception e) {
            lastActionForm = null;
        }
        
        return lastActionForm;
    }
    
    /**
     * Returns true if the usage of back button is allowed for the current
     * action.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return boolean
     */
    public boolean isBackButtonAllowed() {
        boolean backButtonAllowed = false;
        
        try {
            backButtonAllowed = ((Boolean) getObjectFromSession(SessionConstants.SESSION_BACK_BUTTON_ALLOWED_KEY))
            .booleanValue();
        } catch (Exception e) {
            backButtonAllowed = true;
        }
        
        return backButtonAllowed;
    }
    
    /**
     * Sets the String value passed as the userId in the HttpSession object.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param userInfo
     *            UserInfoDataBean
     */
    public void setUserInfo(UserInfoDataBean userInfo) {
        httpSession.setAttribute(SessionConstants.SESSION_USERINFO_KEY,
                userInfo);
    }
    
    /**
     * Sets the String value passed as the lastActionId in the HttpSession
     * object.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param lastActionID
     *            String value which is stored as lastActionId in HttpSession
     *            object.
     */
    public void setLastActionID(String lastActionID) {
        storeSessionData(SessionConstants.SESSION_LAST_ACTION_KEY, lastActionID);
    }
    
    /**
     * Sets the OPPTViewBean as the lastViewBean in HttpSession object.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param lastViewBean
     *            OPPTViewBean which is stored as lastViewBean in HttpSession
     *            object.
     */
    public void setLastViewBean(OPPTViewBean lastViewBean) {
        storeSessionData(SessionConstants.SESSION_LAST_VIEW_KEY, lastViewBean);
    }
    
    /**
     * Sets the OPPTActionForm as the lastActionForm in HttpSession object. <br>
     * <b>Known Bugs </b> <br>
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003 revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param form
     */
    public void setLastActionForm(OPPTActionForm form) {
        storeSessionData(SessionConstants.SESSION_LAST_FORM_KEY, form);
    }
    
    /**
     * Sets whether back button is allowed for the current action.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param backButtonAllowed
     *            boolean value which represents whether back button is allowed
     *            for the current action.
     */
    public void setBackButtonAllowed(boolean backButtonAllowed) {
        storeSessionData(SessionConstants.SESSION_BACK_BUTTON_ALLOWED_KEY,
                new Boolean(backButtonAllowed));
    }
    
    /**
     * This method is mainly used to check whether the same action is performed
     * twice. It takes the current actionId and current actionForm as arguments
     * and checks them with last actionId and lastActionAction From that are
     * stored in session. If both the actionIds are same then it checks whether
     * the contents of the actionForms are also same. If same it returns true
     * else returns false. <br>
     * <b>Known Bugs </b> <br>
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003 revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param actionid
     *            String value to be used as current action identifier.
     * @param actionForm
     *            OPPTActionForm value to be used as current action form.
     * @return boolean
     */
    public boolean checkDoubleSubmit(String actionid, OPPTActionForm actionForm) {
        String lastActionID = getLastActionID();
        if ((lastActionID != null) && (lastActionID.equalsIgnoreCase(actionid))) {
            OPPTActionForm lastActionForm = getLastActionForm();
            if ((lastActionForm != null) && actionForm.equals(lastActionForm)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Given an actionId, it checks whether the usage of button is allowed for
     * that action. Returns true if back button is allowed. Else returns false.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param actionId
     *            String value which is the action identifier
     * @return boolean
     */
    public boolean checkBackButton(String actionId) {
        boolean backButtonAllowed = false;
        int position = actionDataStore.searchActionID(actionId);
        if (position == -1) {
            backButtonAllowed = true;
        } else {
            if (isBackButtonAllowed()) {
                removeInvalidDataStoreEntries(actionId);
                backButtonAllowed = true;
            } else {
                backButtonAllowed = false;
            }
        }
        return backButtonAllowed;
    }
    
    /**
     * checkBackButton
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param actionId
     * @param backButtonAllowed
     * @return
     * @author thirumalai
     */
    public boolean checkBackButton(String actionId, boolean backButtonAllowed) {
        int position = actionDataStore.searchActionID(actionId);
        
        if (position == -1) {
            backButtonAllowed = true;
        }
        
        return backButtonAllowed;
    }
    
    /**
     * getDataStoreEntry
     * 
     * @param actionId
     * @return
     * @author thirumalai
     */
    public Object getDataStoreEntry(String actionId) {
        Object dataStoreEntry = null;
        try {
            DataStoreEntry entry = actionDataStore
            .getDataStoreEntry(actionDataStore.searchActionID(actionId));
            if (null != entry) {
                dataStoreEntry = entry.getStoredData();
            }
        } catch (Exception e) {
            dataStoreEntry = null;
        }
        return dataStoreEntry;
    }
    
    /**
     * Create a new DataStoreEntry object for the values passed as argument and
     * adds that object into dataStore.
     * 
     * @param actionId
     *            String value which is used as key value in the
     *            actionDataStore.
     * @param item
     *            Object which is actual object stored in actionDataStore with
     *            actionId as key.
     */
    public void addDataStoreEntry(String actionId, Object item) {
        DataStoreEntry entry = new DataStoreEntry();
        entry.setActionID(actionId);
        entry.setStoredData(item);
        actionDataStore.push(entry);
        storeSessionData(SessionConstants.SESSION_ACTION_DATA_STORE_KEY,
                actionDataStore);
    }
    
    /**
     * This method is used to put the actionDataStore object back into the
     * HttpSession object. When ever we work with OPPTSession object it is must
     * to call thie method at the end.
     * 
     * <br/>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br/>
     * 
     * @see java.lang.Object#finalize()
     * 
     *  
     */
    public void finalize() {
        storeSessionData(SessionConstants.SESSION_ACTION_DATA_STORE_KEY,
                actionDataStore);
    }
    
    /**
     * Clears all the entries that are present in action data store. This method
     * is called when a new process starting.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     *  
     */
    public void clearActionDataStore() {
        actionDataStore.removeAllDataStoreEntries();
    }
    
    /**
     * clearActionDataStore
     * 
     * @param actionIDs
     * @author thirumalai
     */
    public void clearActionDataStore(String actionIDs[]) {
        actionDataStore.removeAllDataStoreEntries(actionIDs);
    }
    
    /**
     * Removes all the action data store entries that occured after give
     * actionId.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param actionId
     *            String value
     */
    public void removeInvalidDataStoreEntries(String actionId) {
        actionDataStore.removeInvalidDataStoreEntries(actionId);
    }
    
    /**
     * setCurrentViewBean
     * 
     * @param currentViewBean
     * @author thirumalai
     */
    public void setCurrentViewBean(OPPTViewBean currentViewBean) {
    	
        storeSessionData(SessionConstants.SESSION_CURRENT_VIEW_KEY,
                currentViewBean);
    }
    
    /**
     * getCurrentViewBean
     * 
     * @return
     * @author thirumalai
     */
    public OPPTViewBean getCurrentViewBean() {
        OPPTViewBean currentView = null;
        
        try {
            currentView = (OPPTViewBean) getSessionData(SessionConstants.SESSION_CURRENT_VIEW_KEY);
        } catch (Exception e) {
            currentView = null;
        }
        
        return currentView;
    }
    
    /**
     * setCurrentMessageViewBean
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @param currentViewBean
     * @author thirumalai
     */
    public void setCurrentMessageViewBean(OPPTViewBean currentViewBean) {
        storeSessionData(SessionConstants.SESSION_CURRENT_MESSAGE_VIEW_KEY,
                currentViewBean);
    }
    
    /**
     * getCurrentMessageViewBean
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Nov 12, 2003
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     * 
     * @return
     * @author thirumalai
     */
    public OPPTViewBean getCurrentMessageViewBean() {
        OPPTViewBean currentView = null;
        try {
            currentView = (OPPTViewBean) getSessionData(SessionConstants.SESSION_CURRENT_MESSAGE_VIEW_KEY);
        } catch (Exception e) {
            currentView = null;
        }
        
        return currentView;
    }
    
    /**
     * setCurrentForward
     * 
     * @param currentForward
     * @author thirumalai
     */
    public void setCurrentForward(String currentForward) {
    	     storeSessionData(SessionConstants.SESSION_CURRENT_FORWARD,currentForward);
    }
    
    /**
     * getCurrentForward
     * 
     * @return
     * @author thirumalai
     */
    public String getCurrentForward() {
        String currentForward = null;
        
        try {
            currentForward = (String) getSessionData(SessionConstants.SESSION_CURRENT_FORWARD);
        } catch (Exception e) {
            currentForward = null;
        }
        
        return currentForward;
    }
    
    /**
     * storeObjectToSession
     * 
     * @param key
     * @param object
     * @author thirumalai
     */
    public void storeObjectToSession(String key, Object object) {
    	//System.out.println("OPPTSession.storeObjectToSession()");
        storeSessionData(key, object);
    }
    
    /**
     * storeReportViewBean
     * 
     * @param object
     * @author thirumalai
     */
    public void storeReportViewBean(Object object) {
        // httpSession.setAttribute(SessionConstants.REPORT_VIEW_BEAN, object);
        storeSessionData(SessionConstants.REPORT_VIEW_BEAN, object);
    }
    
    /**
     * getReportViewBean
     * 
     * @return
     * @author thirumalai
     */
    public Object getReportViewBean() {
        // return
        // (Object)httpSession.getAttribute(SessionConstants.REPORT_VIEW_BEAN);
        return getSessionData(SessionConstants.REPORT_VIEW_BEAN);
    }
    
    /**
     * removeReportViewBean
     * 
     * @author thirumalai
     */
    public void removeReportViewBean() {
        removeObjectFromSession(SessionConstants.REPORT_VIEW_BEAN);
    }
    
    /**
     * getObjectFromSession
     * 
     * @param key
     * @return
     * @author thirumalai
     */
    public Object getObjectFromSession(String key) {
        return getSessionData(key);
    }
    
    /**
     * removeObjectFromSession
     * 
     * @param key
     * @author thirumalai
     */
    public void removeObjectFromSession(String key) {
        try {
            sessionDAO.deleteSessionData(getSessionId(), key);
        } catch (Exception e) {
            // Database exception while removing data.
            // Ignore this exception
            // As it is going to be deleted in the next call and/or timeout
        }
    }
    
    /**
     * getSessionId
     * 
     * @return
     * @author thirumalai
     */
    public String getSessionId() {
        return httpSession.getId();
    }
    
    /**
     * invalidate
     * 
     * @author thirumalai
     */
    public void invalidate() {
        //httpSession.invalidate();
        try {
            sessionDAO.deleteSessionData(getSessionId());
            sessionDAO.deleteTempData(getSessionId());
        } catch (Exception e) {
            OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME,
                    "invalidate", null, e); //$NON-NLS-1$
            // Database exception while deleting session content.
            // Ignore this exception
            // As it is going to be deleted in the next call and/or timeout
        }
    }
    
    /**
     * clean
     * 
     * @author thirumalai
     */
    public void clean() {
        try {
            sessionDAO.deleteSessionData();
            sessionDAO.deleteTempData();
        } catch (Exception e) {
            OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME,
                    "invalidate", null, e); //$NON-NLS-1$
        }
    }
    
    /**
     * setFirstActionForwardName
     * 
     * @param forwardName
     * @throws java.lang.Exception
     * @author thirumalai
     */
    public void setFirstActionForwardName(String forwardName) throws Exception {
        storeSessionData(SessionConstants.SESSION_FIRST_ACTION_FORWARD_NAME,
                forwardName);
    }
    
    /**
     * getFirstActionForwardName
     * 
     * @throws java.lang.Exception
     * @return
     * @author thirumalai
     */
    public String getFirstActionForwardName() throws Exception {
        String currentForward = null;
        
        try {
            currentForward = (String) getSessionData(SessionConstants.SESSION_FIRST_ACTION_FORWARD_NAME);
        } catch (Exception e) {
            currentForward = null;
        }
        
        return currentForward;
    }
    
    /**
     * getUserId
     * 
     * @return
     * @author thirumalai
     */
    public String getUserId() {
        String userId = null;
        
        UserInfoDataBean userInfo = getUserInfo();
        if (null != userInfo) {
            userId = userInfo.getUserId();
        }
        if (null == userId) {
            userId = ""; /* NOI18N */
        }
        
        return userId;
    }
    
    /**
     * Returns current user id.
     * 
     * <br>
     * <b>Known Bugs </b> <br>
     * 
     * <br>
     * 
     * <PRE>
     * 
     * date Feb 29, 2004
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br>
     *  
     */
    private void storeSessionData(String key, Object value) {
        String sessionId = getSessionId();
        String userId = getUserId();
       // System.out.println("OPPTSession.storeSessionData()");
        
        try {
            sessionDAO.setSessionData(sessionId, userId, key, value);
        } catch (Exception e) {
            OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME,
                    "storeSessionData", null, e); /* NOI18N */
            // Ignore this exception
            // As it is going to be stored in the next call and/or in memory
        }
    }
    
    private Object getSessionData(String key) {
        Object data = null;
        String sessionId = getSessionId();
        String userId = getUserId();
        
        try {
            data = sessionDAO.getSessionData(sessionId, key);
        } catch (Exception e) {
            OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME,
                    "getSessionData", null, e); /* NOI18N */
            data = null;
        }
        return data;
    }
    
    /**
     * getDataStoreEntryBefore
     * 
     * @param actionID
     * @return
     * @author thirumalai
     */
    public DataStoreEntry getDataStoreEntryBefore(String actionID) {
        return actionDataStore.getDataStoreEntryBefore(actionID);
    }
}