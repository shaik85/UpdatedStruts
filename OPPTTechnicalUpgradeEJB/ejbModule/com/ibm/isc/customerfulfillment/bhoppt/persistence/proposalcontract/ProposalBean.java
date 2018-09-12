/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Bean implementation class for Enterprise Bean: Proposal
 */
public abstract class ProposalBean implements javax.ejb.EntityBean {
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey ejbCreate(
		int proposalId,String proposalName)
		throws javax.ejb.CreateException {
		setProposalId(proposalId);
		setProposalName(proposalName);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int proposalId,String proposalName)
		throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
			
	}
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public abstract int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public abstract void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: proposalType
	 */
	public abstract java.lang.String getProposalType();
	/**
	 * Set accessor for persistent attribute: proposalType
	 */
	public abstract void setProposalType(java.lang.String newProposalType);
	/**
	 * Get accessor for persistent attribute: billingFreqCode
	 */
	public abstract java.lang.String getBillingFreqCode();
	/**
	 * Set accessor for persistent attribute: billingFreqCode
	 */
	public abstract void setBillingFreqCode(
		java.lang.String newBillingFreqCode);
	/**
	 * Get accessor for persistent attribute: createdBy
	 */
	public abstract java.lang.String getCreatedBy();
	/**
	 * Set accessor for persistent attribute: createdBy
	 */
	public abstract void setCreatedBy(java.lang.String newCreatedBy);
	/**
	 * Get accessor for persistent attribute: approvedBy
	 */
	public abstract java.lang.String getApprovedBy();
	/**
	 * Set accessor for persistent attribute: approvedBy
	 */
	public abstract void setApprovedBy(java.lang.String newApprovedBy);
	/**
	 * Get accessor for persistent attribute: statusCode
	 */
	public abstract java.lang.String getStatusCode();
	/**
	 * Set accessor for persistent attribute: statusCode
	 */
	public abstract void setStatusCode(java.lang.String newStatusCode);
	/**
	 * Get accessor for persistent attribute: salesOrg
	 */
	public abstract java.lang.String getSalesOrg();
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public abstract void setSalesOrg(java.lang.String newSalesOrg);
	/**
	 * Get accessor for persistent attribute: distrChannel
	 */
	public abstract java.lang.String getDistrChannel();
	/**
	 * Set accessor for persistent attribute: distrChannel
	 */
	public abstract void setDistrChannel(java.lang.String newDistrChannel);
	/**
	 * Get accessor for persistent attribute: divisionCode
	 */
	public abstract java.lang.String getDivisionCode();
	/**
	 * Set accessor for persistent attribute: divisionCode
	 */
	public abstract void setDivisionCode(java.lang.String newDivisionCode);
	/**
	 * Get accessor for persistent attribute: contractStartDate
	 */
	public abstract java.sql.Date getContractStartDate();
	/**
	 * Set accessor for persistent attribute: contractStartDate
	 */
	public abstract void setContractStartDate(
		java.sql.Date newContractStartDate);
	/**
	 * Get accessor for persistent attribute: contractEndDate
	 */
	public abstract java.sql.Date getContractEndDate();
	/**
	 * Set accessor for persistent attribute: contractEndDate
	 */
	public abstract void setContractEndDate(java.sql.Date newContractEndDate);
	/**
	 * Get accessor for persistent attribute: contractStartPeriod
	 */
	public abstract java.sql.Date getContractStartPeriod();
	/**
	 * Set accessor for persistent attribute: contractStartPeriod
	 */
	public abstract void setContractStartPeriod(
		java.sql.Date newContractStartPeriod);
	/**
	 * Get accessor for persistent attribute: contractEndPeriod
	 */
	public abstract java.sql.Date getContractEndPeriod();
	/**
	 * Set accessor for persistent attribute: contractEndPeriod
	 */
	public abstract void setContractEndPeriod(
		java.sql.Date newContractEndPeriod);
	/**
	 * Get accessor for persistent attribute: tvmRate
	 */
	public abstract double getTvmRate();
	/**
	 * Set accessor for persistent attribute: tvmRate
	 */
	public abstract void setTvmRate(double newTvmRate);
	/**
	 * Get accessor for persistent attribute: growthFactor
	 */
	public abstract double getGrowthFactor();
	/**
	 * Set accessor for persistent attribute: growthFactor
	 */
	public abstract void setGrowthFactor(double newGrowthFactor);
	/**
	 * Get accessor for persistent attribute: specialRate
	 */
	public abstract double getSpecialRate();
	/**
	 * Set accessor for persistent attribute: specialRate
	 */
	public abstract void setSpecialRate(double newSpecialRate);
	/**
	 * Get accessor for persistent attribute: anniversaryAmt
	 */
	public abstract double getAnniversaryAmt();
	/**
	 * Set accessor for persistent attribute: anniversaryAmt
	 */
	public abstract void setAnniversaryAmt(double newAnniversaryAmt);
	/**
	 * Get accessor for persistent attribute: invoiceAmt
	 */
	public abstract double getInvoiceAmt();
	/**
	 * Set accessor for persistent attribute: invoiceAmt
	 */
	public abstract void setInvoiceAmt(double newInvoiceAmt);
	/**
	 * Get accessor for persistent attribute: amentIndicatior
	 */
	public abstract java.lang.String getAmentIndicatior();
	/**
	 * Set accessor for persistent attribute: amentIndicatior
	 */
	public abstract void setAmentIndicatior(
		java.lang.String newAmentIndicatior);
	/**
	 * Get accessor for persistent attribute: amendEffectiveDate
	 */
	public abstract java.sql.Date getAmendEffectiveDate();
	/**
	 * Set accessor for persistent attribute: amendEffectiveDate
	 */
	public abstract void setAmendEffectiveDate(
		java.sql.Date newAmendEffectiveDate);
	/**
	 * Get accessor for persistent attribute: datePriced
	 */
	public abstract java.sql.Date getDatePriced();
	/**
	 * Set accessor for persistent attribute: datePriced
	 */
	public abstract void setDatePriced(java.sql.Date newDatePriced);
	/**
	 * Get accessor for persistent attribute: comments
	 */
	public abstract java.lang.String getComments();
	/**
	 * Set accessor for persistent attribute: comments
	 */
	public abstract void setComments(java.lang.String newComments);
	/**
	 * Get accessor for persistent attribute: createdDate
	 */
	public abstract java.sql.Date getCreatedDate();
	/**
	 * Set accessor for persistent attribute: createdDate
	 */
	public abstract void setCreatedDate(java.sql.Date newCreatedDate);
	/**
	 * Get accessor for persistent attribute: approvedDate
	 */
	public abstract java.sql.Date getApprovedDate();
	/**
	 * Set accessor for persistent attribute: approvedDate
	 */
	public abstract void setApprovedDate(java.sql.Date newApprovedDate);
	/**
	 * Get accessor for persistent attribute: deletedInd
	 */
	public abstract java.lang.String getDeletedInd();
	/**
	 * Set accessor for persistent attribute: deletedInd
	 */
	public abstract void setDeletedInd(java.lang.String newDeletedInd);
	/**
	 * Get accessor for persistent attribute: regCustomerNo
	 */
	public abstract java.lang.String getRegCustomerNo();
	/**
	 * Set accessor for persistent attribute: regCustomerNo
	 */
	public abstract void setRegCustomerNo(java.lang.String newRegCustomerNo);
	/**
	 * Get accessor for persistent attribute: regCustomerName
	 */
	public abstract java.lang.String getRegCustomerName();
	/**
	 * Set accessor for persistent attribute: regCustomerName
	 */
	public abstract void setRegCustomerName(
		java.lang.String newRegCustomerName);
	/**
	 * Get accessor for persistent attribute: regBilltoPartyNo
	 */
	public abstract java.lang.String getRegBilltoPartyNo();
	/**
	 * Set accessor for persistent attribute: regBilltoPartyNo
	 */
	public abstract void setRegBilltoPartyNo(
		java.lang.String newRegBilltoPartyNo);
	/**
	 * Get accessor for persistent attribute: regBillToPartyName
	 */
	public abstract java.lang.String getRegBillToPartyName();
	/**
	 * Set accessor for persistent attribute: regBillToPartyName
	 */
	public abstract void setRegBillToPartyName(
		java.lang.String newRegBillToPartyName);
	/**
	 * Get accessor for persistent attribute: regPayerNo
	 */
	public abstract java.lang.String getRegPayerNo();
	/**
	 * Set accessor for persistent attribute: regPayerNo
	 */
	public abstract void setRegPayerNo(java.lang.String newRegPayerNo);
	/**
	 * Get accessor for persistent attribute: regPayerName
	 */
	public abstract java.lang.String getRegPayerName();
	/**
	 * Set accessor for persistent attribute: regPayerName
	 */
	public abstract void setRegPayerName(java.lang.String newRegPayerName);
	/**
	 * Get accessor for persistent attribute: regShipToPartyNo
	 */
	public abstract java.lang.String getRegShipToPartyNo();
	/**
	 * Set accessor for persistent attribute: regShipToPartyNo
	 */
	public abstract void setRegShipToPartyNo(
		java.lang.String newRegShipToPartyNo);
	/**
	 * Get accessor for persistent attribute: regShipToPartyName
	 */
	public abstract java.lang.String getRegShipToPartyName();
	/**
	 * Set accessor for persistent attribute: regShipToPartyName
	 */
	public abstract void setRegShipToPartyName(
		java.lang.String newRegShipToPartyName);
	/**
	 * Get accessor for persistent attribute: currency
	 */
	public abstract java.lang.String getCurrency();
	/**
	 * Set accessor for persistent attribute: currency
	 */
	public abstract void setCurrency(java.lang.String newCurrency);
	/**
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public abstract java.sql.Date getLastUpdatedDate();
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public abstract void setLastUpdatedDate(java.sql.Date newLastUpdatedDate);
	/**
	 * Get accessor for persistent attribute: refetchInd
	 */
	public abstract java.lang.String getRefetchInd();
	/**
	 * Set accessor for persistent attribute: refetchInd
	 */
	public abstract void setRefetchInd(java.lang.String newRefetchInd);
	/**
	 * Get accessor for persistent attribute: fetchDate
	 */
	public abstract java.sql.Date getFetchDate();
	/**
	 * Set accessor for persistent attribute: fetchDate
	 */
	public abstract void setFetchDate(java.sql.Date newFetchDate);
	/**
	 * Get accessor for persistent attribute: deltaFetchInd
	 */
	public abstract java.lang.String getDeltaFetchInd();
	/**
	 * Set accessor for persistent attribute: deltaFetchInd
	 */
	public abstract void setDeltaFetchInd(java.lang.String newDeltaFetchInd);
	/**
	 * Get accessor for persistent attribute: contrType
	 */
	public abstract java.lang.String getContrType();
	/**
	 * Set accessor for persistent attribute: contrType
	 */
	public abstract void setContrType(java.lang.String newContrType);
	/**
	 * Get accessor for persistent attribute: reportName
	 */
	public abstract java.lang.String getReportName();
	/**
	 * Set accessor for persistent attribute: reportName
	 */
	public abstract void setReportName(java.lang.String newReportName);
	/**
	 * Get accessor for persistent attribute: capAmt
	 */
	public abstract double getCapAmt();
	/**
	 * Set accessor for persistent attribute: capAmt
	 */
	public abstract void setCapAmt(double newCapAmt);
	/**
	 * Get accessor for persistent attribute: capPlus
	 */
	public abstract double getCapPlus();
	/**
	 * Set accessor for persistent attribute: capPlus
	 */
	public abstract void setCapPlus(double newCapPlus);
	/**
	 * Get accessor for persistent attribute: capMinus
	 */
	public abstract double getCapMinus();
	/**
	 * Set accessor for persistent attribute: capMinus
	 */
	public abstract void setCapMinus(double newCapMinus);
	/**
	 * Get accessor for persistent attribute: preTvm
	 */
	public abstract double getPreTvm();
	/**
	 * Set accessor for persistent attribute: preTvm
	 */
	public abstract void setPreTvm(double newPreTvm);
	/**
	 * Get accessor for persistent attribute: contrExtnDate
	 */
	public abstract java.sql.Date getContrExtnDate();
	/**
	 * Set accessor for persistent attribute: contrExtnDate
	 */
	public abstract void setContrExtnDate(java.sql.Date newContrExtnDate);
	/**
	 * Get accessor for persistent attribute: contrRetrDate
	 */
	public abstract java.sql.Date getContrRetrDate();
	/**
	 * Set accessor for persistent attribute: contrRetrDate
	 */
	public abstract void setContrRetrDate(java.sql.Date newContrRetrDate);
	/**
	 * Get accessor for persistent attribute: contrReplDate
	 */
	public abstract java.sql.Date getContrReplDate();
	/**
	 * Set accessor for persistent attribute: contrReplDate
	 */
	public abstract void setContrReplDate(java.sql.Date newContrReplDate);
	/**
	 * Get accessor for persistent attribute: contrClsDate
	 */
	public abstract java.sql.Date getContrClsDate();
	/**
	 * Set accessor for persistent attribute: contrClsDate
	 */
	public abstract void setContrClsDate(java.sql.Date newContrClsDate);
	/**
	 * Get accessor for persistent attribute: contrNo
	 */
	public abstract java.lang.String getContrNo();
	/**
	 * Set accessor for persistent attribute: contrNo
	 */
	public abstract void setContrNo(java.lang.String newContrNo);
	/**
	 * Get accessor for persistent attribute: regCustomerListNo
	 */
	public abstract java.lang.String getRegCustomerListNo();
	/**
	 * Set accessor for persistent attribute: regCustomerListNo
	 */
	public abstract void setRegCustomerListNo(
		java.lang.String newRegCustomerListNo);
	/**
	 * Get accessor for persistent attribute: regBillToPartyListNo
	 */
	public abstract java.lang.String getRegBillToPartyListNo();
	/**
	 * Set accessor for persistent attribute: regBillToPartyListNo
	 */
	public abstract void setRegBillToPartyListNo(
		java.lang.String newRegBillToPartyListNo);
	/**
	 * Get accessor for persistent attribute: regPayerListNo
	 */
	public abstract java.lang.String getRegPayerListNo();
	/**
	 * Set accessor for persistent attribute: regPayerListNo
	 */
	public abstract void setRegPayerListNo(java.lang.String newRegPayerListNo);
	/**
	 * Get accessor for persistent attribute: regShipToPartyListNo
	 */
	public abstract java.lang.String getRegShipToPartyListNo();
	/**
	 * Set accessor for persistent attribute: regShipToPartyListNo
	 */
	public abstract void setRegShipToPartyListNo(
		java.lang.String newRegShipToPartyListNo);
	/**
	 * Get accessor for persistent attribute: annivInvoiceAmount
	 */
	public abstract double getAnnivInvoiceAmount();
	/**
	 * Set accessor for persistent attribute: annivInvoiceAmount
	 */
	public abstract void setAnnivInvoiceAmount(double newAnnivInvoiceAmount);
	/**
	 * Get accessor for persistent attribute: semiAnnivInvoiceAmount
	 */
	public abstract double getSemiAnnivInvoiceAmount();
	/**
	 * Set accessor for persistent attribute: semiAnnivInvoiceAmount
	 */
	public abstract void setSemiAnnivInvoiceAmount(double newSemiAnnivInvoiceAmount);
	/**
	 * Get accessor for persistent attribute: quarterlyInvoiceAmount
	 */
	public abstract double getQuarterlyInvoiceAmount();
	/**
	 * Set accessor for persistent attribute: quarterlyInvoiceAmount
	 */
	public abstract void setQuarterlyInvoiceAmount(double newQuarterlyInvoiceAmount);
	/**
	 * Get accessor for persistent attribute: monthlyInvoiceAmount
	 */
	public abstract double getMonthlyInvoiceAmount();
	/**
	 * Set accessor for persistent attribute: monthlyInvoiceAmount
	 */
	public abstract void setMonthlyInvoiceAmount(double newMonthlyInvoiceAmount);
	/**
	 * Get accessor for persistent attribute: oldContractNo
	 */
	public abstract java.lang.String getOldContractNo();
	/**
	 * Set accessor for persistent attribute: oldContractNo
	 */
	public abstract void setOldContractNo(java.lang.String newOldContractNo);
	/**
	 * Get accessor for persistent attribute: preTVMInvoiceAmt
	 */
	public abstract double getPreTVMInvoiceAmt();
	/**
	 * Set accessor for persistent attribute: preTVMInvoiceAmt
	 */
	public abstract void setPreTVMInvoiceAmt(double newPreTVMInvoiceAmt);
	/**
	 * Get accessor for persistent attribute: proposalSharing
	 */
	public abstract java.lang.String getProposalSharing();
	/**
	 * Set accessor for persistent attribute: proposalSharing
	 */
	public abstract void setProposalSharing(
		java.lang.String newProposalSharing);
	/**
	 * Get accessor for persistent attribute: extContractNo
	 */
	public abstract java.lang.String getExtContractNo();
	/**
	 * Set accessor for persistent attribute: extContractNo
	 */
	public abstract void setExtContractNo(java.lang.String newExtContractNo);
	/**
	 * Get accessor for persistent attribute: contractCreateFlag
	 */
	public abstract java.lang.String getContractCreateFlag();
	/**
	 * Set accessor for persistent attribute: contractCreateFlag
	 */
	public abstract void setContractCreateFlag(
		java.lang.String newContractCreateFlag);
	/**
	 * Get accessor for persistent attribute: pakId
	 */
	public abstract java.lang.String getPakId();
	/**
	 * Set accessor for persistent attribute: pakId
	 */
	public abstract void setPakId(java.lang.String newPakId);
	/**
	 * Get accessor for persistent attribute: advancedBilling
	 */
	public abstract java.lang.String getAdvancedBilling();
	/**
	 * Set accessor for persistent attribute: advancedBilling
	 */
	public abstract void setAdvancedBilling(
		java.lang.String newAdvancedBilling);
	/**
	 * Get accessor for persistent attribute: billingType
	 */
	public abstract java.lang.String getBillingType();
	/**
	 * Set accessor for persistent attribute: billingType
	 */
	public abstract void setBillingType(java.lang.String newBillingType);
	/**
	 * Get accessor for persistent attribute: paymentTerm
	 */
	public abstract java.lang.String getPaymentTerm();
	/**
	 * Set accessor for persistent attribute: paymentTerm
	 */
	public abstract void setPaymentTerm(java.lang.String newPaymentTerm);
	/**
	 * Get accessor for persistent attribute: addValueDays
	 */
	public abstract int getAddValueDays();
	/**
	 * Set accessor for persistent attribute: addValueDays
	 */
	public abstract void setAddValueDays(int newAddValueDays);
	/**
	 * Get accessor for persistent attribute: fixedValueDate
	 */
	public abstract java.sql.Date getFixedValueDate();
	/**
	 * Set accessor for persistent attribute: fixedValueDate
	 */
	public abstract void setFixedValueDate(java.sql.Date newFixedValueDate);
	/**
	 * Get accessor for persistent attribute: tpContractNo
	 */
	public abstract java.lang.String getTpContractNo();
	/**
	 * Set accessor for persistent attribute: tpContractNo
	 */
	public abstract void setTpContractNo(java.lang.String newTpContractNo);
	/**
	 * Get accessor for persistent attribute: ineligibleInd
	 */
	public abstract java.lang.String getIneligibleInd();
	/**
	 * Set accessor for persistent attribute: ineligibleInd
	 */
	public abstract void setIneligibleInd(java.lang.String newIneligibleInd);
	/**
	 * Get accessor for persistent attribute: invoiceInd
	 */
	public abstract java.lang.String getInvoiceInd();
	/**
	 * Set accessor for persistent attribute: invoiceInd
	 */
	public abstract void setInvoiceInd(java.lang.String newInvoiceInd);
	/**
	 * Get accessor for persistent attribute: deviationDateRule
	 */
	public abstract java.lang.String getDeviationDateRule();
	/**
	 * Set accessor for persistent attribute: deviationDateRule
	 */
	public abstract void setDeviationDateRule(
		java.lang.String newDeviationDateRule);
	/**
	 * Get accessor for persistent attribute: billingBlock
	 */
	public abstract java.lang.String getBillingBlock();
	/**
	 * Set accessor for persistent attribute: billingBlock
	 */
	public abstract void setBillingBlock(java.lang.String newBillingBlock);
	/**
	 * Get accessor for persistent attribute: sAndSIncluded
	 */
	public abstract java.lang.String getSAndSIncluded();
	/**
	 * Set accessor for persistent attribute: sAndSIncluded
	 */
	public abstract void setSAndSIncluded(java.lang.String newSAndSIncluded);
	/**
	 * Get accessor for persistent attribute: lockedBy
	 */
	public abstract java.lang.String getLockedBy();
	/**
	 * Set accessor for persistent attribute: lockedBy
	 */
	public abstract void setLockedBy(java.lang.String newLockedBy);
	/**
	 * Get accessor for persistent attribute: poNo
	 */
	public abstract java.lang.String getPoNo();
	/**
	 * Set accessor for persistent attribute: poNo
	 */
	public abstract void setPoNo(java.lang.String newPoNo);
	/**
	 * Get accessor for persistent attribute: freeText
	 */
	public abstract java.lang.String getFreeText();
	/**
	 * Set accessor for persistent attribute: freeText
	 */
	public abstract void setFreeText(java.lang.String newFreeText);
	/**
	 * Get accessor for persistent attribute: regCustomerASNO
	 */
	public abstract java.lang.String getRegCustomerASNO();
	/**
	 * Set accessor for persistent attribute: regCustomerASNO
	 */
	public abstract void setRegCustomerASNO(
		java.lang.String newRegCustomerASNO);
	/**
	 * Get accessor for persistent attribute: regBillToPartyASNo
	 */
	public abstract java.lang.String getRegBillToPartyASNo();
	/**
	 * Set accessor for persistent attribute: regBillToPartyASNo
	 */
	public abstract void setRegBillToPartyASNo(
		java.lang.String newRegBillToPartyASNo);
	/**
	 * Get accessor for persistent attribute: regPayerASNo
	 */
	public abstract java.lang.String getRegPayerASNo();
	/**
	 * Set accessor for persistent attribute: regPayerASNo
	 */
	public abstract void setRegPayerASNo(java.lang.String newRegPayerASNo);
	/**
	 * Get accessor for persistent attribute: regShipTOPartyASNo
	 */
	public abstract java.lang.String getRegShipTOPartyASNo();
	/**
	 * Set accessor for persistent attribute: regShipTOPartyASNo
	 */
	public abstract void setRegShipTOPartyASNo(
		java.lang.String newRegShipTOPartyASNo);
	/**
	 * Get accessor for persistent attribute: gsaInd
	 */
	public abstract java.lang.String getGsaInd();
	/**
	 * Set accessor for persistent attribute: gsaInd
	 */
	public abstract void setGsaInd(java.lang.String newGsaInd);
	/**
	 * Get accessor for persistent attribute: varInd
	 */
	public abstract java.lang.String getVarInd();
	/**
	 * Set accessor for persistent attribute: varInd
	 */
	public abstract void setVarInd(java.lang.String newVarInd);
	/**
	 * Get accessor for persistent attribute: suppressInvoice
	 */
	public abstract java.lang.String getSuppressInvoice();
	/**
	 * Set accessor for persistent attribute: suppressInvoice
	 */
	public abstract void setSuppressInvoice(
		java.lang.String newSuppressInvoice);
	/**
	 * Get accessor for persistent attribute: varDate
	 */
	public abstract java.sql.Date getVarDate();
	/**
	 * Set accessor for persistent attribute: varDate
	 */
	public abstract void setVarDate(java.sql.Date newVarDate);
	/**
	 * Get accessor for persistent attribute: orgVarContractNo
	 */
	public abstract java.lang.String getOrgVarContractNo();
	/**
	 * Set accessor for persistent attribute: orgVarContractNo
	 */
	public abstract void setOrgVarContractNo(
		java.lang.String newOrgVarContractNo);
	/**
	 * Get accessor for persistent attribute: capVariance
	 */
	public abstract double getCapVariance();
	/**
	 * Set accessor for persistent attribute: capVariance
	 */
	public abstract void setCapVariance(double newCapVariance);
	/**
	 * Get accessor for persistent attribute: cumVariance
	 */
	public abstract double getCumVariance();
	/**
	 * Set accessor for persistent attribute: cumVariance
	 */
	public abstract void setCumVariance(double newCumVariance);
	/**
	 * Get accessor for persistent attribute: reg9DPartnerNo
	 */
	public abstract java.lang.String getReg9DPartnerNo();
	/**
	 * Set accessor for persistent attribute: reg9DPartnerNo
	 */
	public abstract void setReg9DPartnerNo(java.lang.String newReg9DPartnerNo);
	/**
	 * Get accessor for persistent attribute: reg9DPartmerName
	 */
	public abstract java.lang.String getReg9DPartmerName();
	/**
	 * Set accessor for persistent attribute: reg9DPartmerName
	 */
	public abstract void setReg9DPartmerName(
		java.lang.String newReg9DPartmerName);
	/**
	 * Get accessor for persistent attribute: lockedOn
	 */
	public abstract java.sql.Date getLockedOn();
	/**
	 * Set accessor for persistent attribute: lockedOn
	 */
	public abstract void setLockedOn(java.sql.Date newLockedOn);
	/**
	 * Get accessor for persistent attribute: proposalName
	 */
	public abstract java.lang.String getProposalName();
	/**
	 * Set accessor for persistent attribute: proposalName
	 */
	public abstract void setProposalName(java.lang.String newProposalName);
	/**
	 * Get accessor for persistent attribute: contrAmendNo
	 */
	public abstract double getContrAmendNo();
	/**
	 * Set accessor for persistent attribute: contrAmendNo
	 */
	public abstract void setContrAmendNo(double newContrAmendNo);
	/**
	 * Get accessor for persistent attribute: contractPeriodVarNo
	 */
	public abstract int getContractPeriodVarNo();
	/**
	 * Set accessor for persistent attribute: contractPeriodVarNo
	 */
	public abstract void setContractPeriodVarNo(int newContractPeriodVarNo);
	/**
	 * Get accessor for persistent attribute: eswFetchTime
	 */
	public abstract java.sql.Time getEswFetchTime();
	/**
	 * Set accessor for persistent attribute: eswFetchTime
	 */
	public abstract void setEswFetchTime(java.sql.Time newEswFetchTime);
	/**
	 * Get accessor for persistent attribute: eswFetchDate
	 */
	public abstract java.sql.Date getEswFetchDate();
	/**
	 * Set accessor for persistent attribute: eswFetchDate
	 */
	public abstract void setEswFetchDate(java.sql.Date newEswFetchDate);
	/**
	 * Get accessor for persistent attribute: contrRenewNo
	 */
	public abstract int getContrRenewNo();
	/**
	 * Set accessor for persistent attribute: contrRenewNo
	 */
	public abstract void setContrRenewNo(int newContrRenewNo);
	/**
	 * Get accessor for persistent attribute: contractReplNo
	 */
	public abstract int getContractReplNo();
	/**
	 * Set accessor for persistent attribute: contractReplNo
	 */
	public abstract void setContractReplNo(int newContractReplNo);
	/**
	 * Get accessor for persistent attribute: poDate
	 */
	public abstract java.sql.Date getPoDate();
	/**
	 * Set accessor for persistent attribute: poDate
	 */
	public abstract void setPoDate(java.sql.Date newPoDate);
	/**
	 * Get accessor for persistent attribute: contractVarNo
	 */
	public abstract int getContractVarNo();
	/**
	 * Set accessor for persistent attribute: contractVarNo
	 */
	public abstract void setContractVarNo(int newContractVarNo);
	/**
	 * Get accessor for persistent attribute: igfNumber
	 */
	public abstract java.lang.String getIgfNumber();
	/**
	 * Set accessor for persistent attribute: igfNumber
	 */
	public abstract void setIgfNumber(java.lang.String newIgfNumber);
	/**
	 * Get accessor for persistent attribute: sandsanniversaryamt
	 */
	public abstract double getSandsanniversaryamt();
	/**
	 * Set accessor for persistent attribute: sandsanniversaryamt
	 */
	public abstract void setSandsanniversaryamt(double newSandsanniversaryamt);
	/**
	 * Get accessor for persistent attribute: sandsdiscountamount
	 */
	public abstract double getSandsdiscountamount();
	/**
	 * Set accessor for persistent attribute: sandsdiscountamount
	 */
	public abstract void setSandsdiscountamount(double newSandsdiscountamount);
	/**
	 * Get accessor for persistent attribute: proposalContent
	 */
	public abstract java.lang.String getProposalContent();
	/**
	 * Set accessor for persistent attribute: proposalContent
	 */
	public abstract void setProposalContent(java.lang.String newProposalContent);
	/**
	 * Get accessor for persistent attribute: submittedBy
	 */
	public abstract java.lang.String getSubmittedBy();
	/**
	 * Set accessor for persistent attribute: submittedBy
	 */
	public abstract void setSubmittedBy(java.lang.String newSubmittedBy);
	/**
	 * Get accessor for persistent attribute: groupName
	 */
	public abstract java.lang.String getGroupName();
	/**
	 * Set accessor for persistent attribute: groupName
	 */
	public abstract void setGroupName(java.lang.String newGroupName);
	
	
	/**
	 * Get accessor for persistent attribute: sandsExtendPeriod
	 */
	public abstract java.lang.String getSandsExtendPeriod();
	/**
	 * Set accessor for persistent attribute: sandsExtendPeriod
	 */
	public abstract void setSandsExtendPeriod(
		java.lang.String newSandsExtendPeriod);
	
	public abstract double getSandsDiscountAmount1();
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount1
	 */
	public abstract void setSandsDiscountAmount1(double newSandsDiscountAmount1);
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount2
	 */
	public abstract double getSandsDiscountAmount2();
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount2
	 */
	public abstract void setSandsDiscountAmount2(double newSandsDiscountAmount2);
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount3
	 */
	public abstract double getSandsDiscountAmount3();
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount3
	 */
	public abstract void setSandsDiscountAmount3(double newSandsDiscountAmount3);
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount4
	 */
	public abstract double getSandsDiscountAmount4();
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount4
	 */
	public abstract void setSandsDiscountAmount4(double newSandsDiscountAmount4);
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount5
	 */
	public abstract double getSandsDiscountAmount5();
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount5
	 */
	public abstract void setSandsDiscountAmount5(double newSandsDiscountAmount5);
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt2
	 */
	public abstract double getSandsAnniversaryAmt2();
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt2
	 */
	public abstract void setSandsAnniversaryAmt2(double newSandsAnniversaryAmt2);
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt3
	 */
	public abstract double getSandsAnniversaryAmt3();
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt3
	 */
	public abstract void setSandsAnniversaryAmt3(double newSandsAnniversaryAmt3);
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt4
	 */
	public abstract double getSandsAnniversaryAmt4();
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt4
	 */
	public abstract void setSandsAnniversaryAmt4(double newSandsAnniversaryAmt4);
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt5
	 */
	public abstract double getSandsAnniversaryAmt5();
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt5
	 */
	public abstract void setSandsAnniversaryAmt5(double newSandsAnniversaryAmt5);
	// Blue Harmony Wave 1 DAD003 - Begin - Bhanu
	/**
	 * Get accessor for persistent attribute: prebillIndicator
	 */
	public abstract String getPrebillIndicator();
	/**
	 * Set accessor for persistent attribute: prebillIndicator
	 */
	public abstract void setPrebillIndicator(String prebillIndicator);
	/**
	 * Get accessor for persistent attribute: masterContractType
	 */
	public abstract String getContractType();
	/**
	 * Set accessor for persistent attribute: masterContractType
	 */
	public abstract void setContractType(String contractType);
	/**
	 * Get accessor for persistent attribute: masterContractId
	 */
	//public abstract String getMasterContractId();
	/**
	 * Set accessor for persistent attribute: masterContractId
	 */
	//public abstract void setMasterContractId(String masterContractId);
	/**
	 * Get accessor for persistent attribute: masterContractAmendment
	 */
	//public abstract String getMasterContractAmendment();
	/**
	 * Set accessor for persistent attribute: masterContractAmendment
	 */
	//public abstract void setMasterContractAmendment(String masterContractAmendment);
	/**
	 * Get accessor for persistent attribute: complexContractType
	 */
	public abstract String getOcpsID();
	/**
	 * Set accessor for persistent attribute: complexContractType
	 */
	public abstract void setOcpsID(String ocpsID);
	/**
	 * Get accessor for persistent attribute: complexContractId
	 */
	public abstract String getCpsId();
	/**
	 * Set accessor for persistent attribute: complexContractId
	 */
	public abstract void setCpsId(String cpsId);
	/**
	 * Get accessor for persistent attribute: complexContractAmendment
	 */
	//public abstract String getComplexContractAmendment();
	/**
	 * Set accessor for persistent attribute: complexContractAmendment
	 */
	//public abstract void setComplexContractAmendment(String complexContractAmendment);
	/**
	 * Get accessor for persistent attribute: blbIndicator
	 */
	public abstract String getBlbIndicator();
	/**
	 * Set accessor for persistent attribute: blbIndicator
	 */
	public abstract void setBlbIndicator(String blbIndicator);
	/**
	 * Get accessor for persistent attribute: cciInd
	 */
	public abstract java.lang.String getCciInd();
	/**
	 * Set accessor for persistent attribute: cciInd
	 */
	public abstract void setCciInd(java.lang.String cciInd);
	/**
	 * Get accessor for persistent attribute: autoPopulateInd
	 */
	public abstract java.lang.String getAutoPopulateInd();
	/**
	 * Set accessor for persistent attribute: autoPopulateInd
	 */
	public abstract void setAutoPopulateInd(java.lang.String newAutoPopulateInd);
	/**
	 * Get accessor for persistent attribute: salesGroup
	 */
	public abstract java.lang.String getSalesGroup();
	/**
	 * Set accessor for persistent attribute: salesGroup
	 */
	public abstract void setSalesGroup(java.lang.String newSalesGroup);
	/**
	 * Get accessor for persistent attribute: channelRole
	 */
	public abstract java.lang.String getChannelRole();
	/**
	 * Set accessor for persistent attribute: channelRole
	 */
	public abstract void setChannelRole(java.lang.String newChannelRole);
	/**
	 * Get accessor for persistent attribute: submitterRole
	 */
	public abstract java.lang.String getSubmitterRole();
	/**
	 * Set accessor for persistent attribute: submitterRole
	 */
	public abstract void setSubmitterRole(java.lang.String newSubmitterRole);
	/**
	 * Get accessor for persistent attribute: paymentMethod
	 */
	public abstract java.lang.String getPaymentMethod();
	/**
	 * Set accessor for persistent attribute: paymentMethod
	 */
	public abstract void setPaymentMethod(java.lang.String newPaymentMethod);
	/**
	 * Get accessor for persistent attribute: discount
	 */
	public abstract double getDiscount();
	/**
	 * Set accessor for persistent attribute: discount
	 */
	public abstract void setDiscount(double newDiscount);
}
