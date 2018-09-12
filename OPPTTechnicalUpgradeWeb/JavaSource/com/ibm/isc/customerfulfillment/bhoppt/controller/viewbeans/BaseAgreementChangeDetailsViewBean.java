/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2006, 2008
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.sql.Date;
import java.sql.Time;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementChangeLogCustomDTO;

/**
 * BaseAgreement Change Details ViewBean
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementChangeDetailsViewBean extends OPPTViewBean {
    
    private int agreementId = 0;
    private int changeId = 0;
    private String userId = null;
    private Date changeOfDate = null;
    private Time changedTime = null;
    private String changedValue = null;
    
    /**
     * 
     * default Constructor of BaseAgreementChangeDetailsViewBean
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:50:38 PM
     *
     */
    
    public BaseAgreementChangeDetailsViewBean(){
        
    }
    /**
     * 
     * Constructor of BaseAgreementChangeDetailsViewBean
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:50:55 PM
     * @param customDTO
     */
    public BaseAgreementChangeDetailsViewBean(BaseAgreementChangeLogCustomDTO customDTO){
        setAgreementId(customDTO.getAgreementId());
        setChangeId(customDTO.getChangeId());
        setUserId(customDTO.getUserId());  
        setChangeOfDate(customDTO.getChangeOfDate());
        setChangedTime(customDTO.getChangedTime());
        setChangedValue(customDTO.getChangedValues());
       }
    
    
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:51:28 PM
     * @param lChangeOfDate changeOfDate.
     */
    public void setChangeOfDate(Date lChangeOfDate) {
        changeOfDate = lChangeOfDate;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:51:28 PM
     * @param lUserId userId.
     */
    public void setUserId(String lUserId) {
        userId = lUserId;
    }
    /**
     *gets the  changeOfDate
     *
     * @return Returns the changeOfDate.
     */
    public Date getChangeOfDate() {
        return changeOfDate;
    }
    
    /**
     *gets the  userId
     *
     * @return Returns the userId.
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     *gets the  agreementId
     *
     * @return Returns the agreementId.
     */
    public int getAgreementId() {
        return agreementId;
    }
    /**
     * sets the agreementId
     * @param lagreementId The agreementId to set.
     */
    public void setAgreementId(int lagreementId) {
        agreementId = lagreementId;
    }
    /**
     *gets the  changedTime
     *
     * @return Returns the changedTime.
     */
    public Time getChangedTime() {
        return changedTime;
    }
    /**
     * sets the changedTime
     * @param lchangedTime The changedTime to set.
     */
    public void setChangedTime(Time lchangedTime) {
        changedTime = lchangedTime;
    }
    /**
     *gets the  changeId
     *
     * @return Returns the changeId.
     */
    public int getChangeId() {
        return changeId;
    }
    /**
     * sets the changeId
     * @param lchangeId The changeId to set.
     */
    public void setChangeId(int lchangeId) {
        changeId = lchangeId;
    }
    
    
    /**
     *gets the  changedValue
     *
     * @return Returns the changedValue.
     */
    public String getChangedValue() {
        return changedValue;
    }
    /**
     * sets the changedValue
     * @param lchangedValue The changedValue to set.
     */
    public void setChangedValue(String lchangedValue) {
        changedValue = lchangedValue;
    }
}
