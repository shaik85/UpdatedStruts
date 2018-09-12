/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;
/**
 * Home interface for Enterprise Bean: BaseAgreementDataManager
 */
public interface BaseAgreementDataManagerHome extends javax.ejb.EJBHome {
    /**
     * Creates a default instance of Session Bean: BaseAgreementDataManager
     */
    public com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager create()
        throws javax.ejb.CreateException,
        java.rmi.RemoteException;
}
