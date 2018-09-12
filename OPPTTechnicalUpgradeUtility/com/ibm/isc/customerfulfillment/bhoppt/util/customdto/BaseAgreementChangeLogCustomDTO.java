/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.sql.Date;
import java.sql.Time;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementChangeLogCustomDTO extends OPPTCustomDTO {
    
    private int agreementId = 0;
    private int changeId = 0;
    private String userId = null;
    private Date changeOfDate = null;
    private Time changedTime = null;
    private String changedValues = null;
    
    

    /**
     *gets the  changedValues
     *
     * @return Returns the changedValues.
     */
    public String getChangedValues() {
        return changedValues;
    }
    /**
     * sets the changedValues
     * @param changedValues The changedValues to set.
     */
    public void setChangedValues(String lchangedValues) {
        changedValues = lchangedValues;
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
     * sets the changeOfDate
     * @param changeOfDate The lchangeOfDate to set.
     */
    public void setChangeOfDate(Date lchangeOfDate) {
        changeOfDate = lchangeOfDate;
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
     * sets the userId
     * @param userId The luserId to set.
     */
    public void setUserId(String luserId) {
        userId = luserId;
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
}
