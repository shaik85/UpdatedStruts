/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo;

import java.sql.Date;
import java.sql.Time;

/**
 * BaseAgreementChangeLogBDO class represents attribute defined in BaseAgreement ChangeLog Entity
 * This data can be validated using BaseAgreementBO Business Object class
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jun 14, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravi Yandapalli
 * @version CBS 2.1
 */
public class BaseAgreementChangeLogBDO {

	
	private int changeId = 0;
	private int agreementId = 0;
	private String changedBy = null;
	private Date changedDate = null;
	private Time changedTime = null;
	private String changedDetails = null;
	
	
	
	
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
     * @param agreementId The agreementId to set.
     */
    public void setAgreementId(int lagreementId) {
        agreementId = lagreementId;
    }
    /**
     *gets the  changedBy
     *
     * @return Returns the changedBy.
     */
    public String getChangedBy() {
        return changedBy;
    }
    /**
     * sets the changedBy
     * @param changedBy The changedBy to set.
     */
    public void setChangedBy(String lchangedBy) {
        changedBy = lchangedBy;
    }
    /**
     *gets the  changedDate
     *
     * @return Returns the changedDate.
     */
    public Date getChangedDate() {
        return changedDate;
    }
    /**
     * sets the changedDate
     * @param changedDate The changedDate to set.
     */
    public void setChangedDate(Date lchangedDate) {
        changedDate = lchangedDate;
    }
    /**
     *gets the  changedDetails
     *
     * @return Returns the changedDetails.
     */
    public String getChangedDetails() {
        return changedDetails;
    }
    /**
     * sets the changedDetails
     * @param changedDetails The changedDetails to set.
     */
    public void setChangedDetails(String lchangedDetails) {
        changedDetails = lchangedDetails;
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
     * @param changedTime The changedTime to set.
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
     * @param changeId The changeId to set.
     */
    public void setChangeId(int lchangeId) {
        changeId = lchangeId;
    }
}
