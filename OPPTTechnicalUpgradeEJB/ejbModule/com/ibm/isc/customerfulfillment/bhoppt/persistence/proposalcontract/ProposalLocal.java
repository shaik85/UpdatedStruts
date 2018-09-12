/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;
/**
 * Local interface for Enterprise Bean: Proposal
 */
public interface ProposalLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: proposalType
	 */
	public java.lang.String getProposalType();
	/**
	 * Set accessor for persistent attribute: proposalType
	 */
	public void setProposalType(java.lang.String newProposalType);
	/**
	 * Get accessor for persistent attribute: billingFreqCode
	 */
	public java.lang.String getBillingFreqCode();
	/**
	 * Set accessor for persistent attribute: billingFreqCode
	 */
	public void setBillingFreqCode(java.lang.String newBillingFreqCode);
	/**
	 * Get accessor for persistent attribute: createdBy
	 */
	public java.lang.String getCreatedBy();
	/**
	 * Set accessor for persistent attribute: createdBy
	 */
	public void setCreatedBy(java.lang.String newCreatedBy);
	/**
	 * Get accessor for persistent attribute: approvedBy
	 */
	public java.lang.String getApprovedBy();
	/**
	 * Set accessor for persistent attribute: approvedBy
	 */
	public void setApprovedBy(java.lang.String newApprovedBy);
	/**
	 * Get accessor for persistent attribute: statusCode
	 */
	public java.lang.String getStatusCode();
	/**
	 * Set accessor for persistent attribute: statusCode
	 */
	public void setStatusCode(java.lang.String newStatusCode);
	/**
	 * Get accessor for persistent attribute: salesOrg
	 */
	public java.lang.String getSalesOrg();
	/**
	 * Set accessor for persistent attribute: salesOrg
	 */
	public void setSalesOrg(java.lang.String newSalesOrg);
	/**
	 * Get accessor for persistent attribute: distrChannel
	 */
	public java.lang.String getDistrChannel();
	/**
	 * Set accessor for persistent attribute: distrChannel
	 */
	public void setDistrChannel(java.lang.String newDistrChannel);
	/**
	 * Get accessor for persistent attribute: divisionCode
	 */
	public java.lang.String getDivisionCode();
	/**
	 * Set accessor for persistent attribute: divisionCode
	 */
	public void setDivisionCode(java.lang.String newDivisionCode);
	/**
	 * Get accessor for persistent attribute: contractStartDate
	 */
	public java.sql.Date getContractStartDate();
	/**
	 * Set accessor for persistent attribute: contractStartDate
	 */
	public void setContractStartDate(java.sql.Date newContractStartDate);
	/**
	 * Get accessor for persistent attribute: contractEndDate
	 */
	public java.sql.Date getContractEndDate();
	/**
	 * Set accessor for persistent attribute: contractEndDate
	 */
	public void setContractEndDate(java.sql.Date newContractEndDate);
	/**
	 * Get accessor for persistent attribute: contractStartPeriod
	 */
	public java.sql.Date getContractStartPeriod();
	/**
	 * Set accessor for persistent attribute: contractStartPeriod
	 */
	public void setContractStartPeriod(java.sql.Date newContractStartPeriod);
	/**
	 * Get accessor for persistent attribute: contractEndPeriod
	 */
	public java.sql.Date getContractEndPeriod();
	/**
	 * Set accessor for persistent attribute: contractEndPeriod
	 */
	public void setContractEndPeriod(java.sql.Date newContractEndPeriod);
	/**
	 * Get accessor for persistent attribute: tvmRate
	 */
	public double getTvmRate();
	/**
	 * Set accessor for persistent attribute: tvmRate
	 */
	public void setTvmRate(double newTvmRate);
	/**
	 * Get accessor for persistent attribute: growthFactor
	 */
	public double getGrowthFactor();
	/**
	 * Set accessor for persistent attribute: growthFactor
	 */
	public void setGrowthFactor(double newGrowthFactor);
	/**
	 * Get accessor for persistent attribute: specialRate
	 */
	public double getSpecialRate();
	/**
	 * Set accessor for persistent attribute: specialRate
	 */
	public void setSpecialRate(double newSpecialRate);
	/**
	 * Get accessor for persistent attribute: anniversaryAmt
	 */
	public double getAnniversaryAmt();
	/**
	 * Set accessor for persistent attribute: anniversaryAmt
	 */
	public void setAnniversaryAmt(double newAnniversaryAmt);
	/**
	 * Get accessor for persistent attribute: invoiceAmt
	 */
	public double getInvoiceAmt();
	/**
	 * Set accessor for persistent attribute: invoiceAmt
	 */
	public void setInvoiceAmt(double newInvoiceAmt);
	/**
	 * Get accessor for persistent attribute: amentIndicatior
	 */
	public java.lang.String getAmentIndicatior();
	/**
	 * Set accessor for persistent attribute: amentIndicatior
	 */
	public void setAmentIndicatior(java.lang.String newAmentIndicatior);
	/**
	 * Get accessor for persistent attribute: amendEffectiveDate
	 */
	public java.sql.Date getAmendEffectiveDate();
	/**
	 * Set accessor for persistent attribute: amendEffectiveDate
	 */
	public void setAmendEffectiveDate(java.sql.Date newAmendEffectiveDate);
	/**
	 * Get accessor for persistent attribute: datePriced
	 */
	public java.sql.Date getDatePriced();
	/**
	 * Set accessor for persistent attribute: datePriced
	 */
	public void setDatePriced(java.sql.Date newDatePriced);
	/**
	 * Get accessor for persistent attribute: comments
	 */
	public java.lang.String getComments();
	/**
	 * Set accessor for persistent attribute: comments
	 */
	public void setComments(java.lang.String newComments);
	/**
	 * Get accessor for persistent attribute: createdDate
	 */
	public java.sql.Date getCreatedDate();
	/**
	 * Set accessor for persistent attribute: createdDate
	 */
	public void setCreatedDate(java.sql.Date newCreatedDate);
	/**
	 * Get accessor for persistent attribute: approvedDate
	 */
	public java.sql.Date getApprovedDate();
	/**
	 * Set accessor for persistent attribute: approvedDate
	 */
	public void setApprovedDate(java.sql.Date newApprovedDate);
	/**
	 * Get accessor for persistent attribute: deletedInd
	 */
	public java.lang.String getDeletedInd();
	/**
	 * Set accessor for persistent attribute: deletedInd
	 */
	public void setDeletedInd(java.lang.String newDeletedInd);
	/**
	 * Get accessor for persistent attribute: regCustomerNo
	 */
	public java.lang.String getRegCustomerNo();
	/**
	 * Set accessor for persistent attribute: regCustomerNo
	 */
	public void setRegCustomerNo(java.lang.String newRegCustomerNo);
	/**
	 * Get accessor for persistent attribute: regCustomerName
	 */
	public java.lang.String getRegCustomerName();
	/**
	 * Set accessor for persistent attribute: regCustomerName
	 */
	public void setRegCustomerName(java.lang.String newRegCustomerName);
	/**
	 * Get accessor for persistent attribute: regBilltoPartyNo
	 */
	public java.lang.String getRegBilltoPartyNo();
	/**
	 * Set accessor for persistent attribute: regBilltoPartyNo
	 */
	public void setRegBilltoPartyNo(java.lang.String newRegBilltoPartyNo);
	/**
	 * Get accessor for persistent attribute: regBillToPartyName
	 */
	public java.lang.String getRegBillToPartyName();
	/**
	 * Set accessor for persistent attribute: regBillToPartyName
	 */
	public void setRegBillToPartyName(java.lang.String newRegBillToPartyName);
	/**
	 * Get accessor for persistent attribute: regPayerNo
	 */
	public java.lang.String getRegPayerNo();
	/**
	 * Set accessor for persistent attribute: regPayerNo
	 */
	public void setRegPayerNo(java.lang.String newRegPayerNo);
	/**
	 * Get accessor for persistent attribute: regPayerName
	 */
	public java.lang.String getRegPayerName();
	/**
	 * Set accessor for persistent attribute: regPayerName
	 */
	public void setRegPayerName(java.lang.String newRegPayerName);
	/**
	 * Get accessor for persistent attribute: regShipToPartyNo
	 */
	public java.lang.String getRegShipToPartyNo();
	/**
	 * Set accessor for persistent attribute: regShipToPartyNo
	 */
	public void setRegShipToPartyNo(java.lang.String newRegShipToPartyNo);
	/**
	 * Get accessor for persistent attribute: regShipToPartyName
	 */
	public java.lang.String getRegShipToPartyName();
	/**
	 * Set accessor for persistent attribute: regShipToPartyName
	 */
	public void setRegShipToPartyName(java.lang.String newRegShipToPartyName);
	/**
	 * Get accessor for persistent attribute: currency
	 */
	public java.lang.String getCurrency();
	/**
	 * Set accessor for persistent attribute: currency
	 */
	public void setCurrency(java.lang.String newCurrency);
	/**
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public java.sql.Date getLastUpdatedDate();
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public void setLastUpdatedDate(java.sql.Date newLastUpdatedDate);
	/**
	 * Get accessor for persistent attribute: refetchInd
	 */
	public java.lang.String getRefetchInd();
	/**
	 * Set accessor for persistent attribute: refetchInd
	 */
	public void setRefetchInd(java.lang.String newRefetchInd);
	/**
	 * Get accessor for persistent attribute: fetchDate
	 */
	public java.sql.Date getFetchDate();
	/**
	 * Set accessor for persistent attribute: fetchDate
	 */
	public void setFetchDate(java.sql.Date newFetchDate);
	/**
	 * Get accessor for persistent attribute: deltaFetchInd
	 */
	public java.lang.String getDeltaFetchInd();
	/**
	 * Set accessor for persistent attribute: deltaFetchInd
	 */
	public void setDeltaFetchInd(java.lang.String newDeltaFetchInd);
	/**
	 * Get accessor for persistent attribute: contrType
	 */
	public java.lang.String getContrType();
	/**
	 * Set accessor for persistent attribute: contrType
	 */
	public void setContrType(java.lang.String newContrType);
	/**
	 * Get accessor for persistent attribute: reportName
	 */
	public java.lang.String getReportName();
	/**
	 * Set accessor for persistent attribute: reportName
	 */
	public void setReportName(java.lang.String newReportName);
	/**
	 * Get accessor for persistent attribute: capAmt
	 */
	public double getCapAmt();
	/**
	 * Set accessor for persistent attribute: capAmt
	 */
	public void setCapAmt(double newCapAmt);
	/**
	 * Get accessor for persistent attribute: capPlus
	 */
	public double getCapPlus();
	/**
	 * Set accessor for persistent attribute: capPlus
	 */
	public void setCapPlus(double newCapPlus);
	/**
	 * Get accessor for persistent attribute: capMinus
	 */
	public double getCapMinus();
	/**
	 * Set accessor for persistent attribute: capMinus
	 */
	public void setCapMinus(double newCapMinus);
	/**
	 * Get accessor for persistent attribute: preTvm
	 */
	public double getPreTvm();
	/**
	 * Set accessor for persistent attribute: preTvm
	 */
	public void setPreTvm(double newPreTvm);
	/**
	 * Get accessor for persistent attribute: contrExtnDate
	 */
	public java.sql.Date getContrExtnDate();
	/**
	 * Set accessor for persistent attribute: contrExtnDate
	 */
	public void setContrExtnDate(java.sql.Date newContrExtnDate);
	/**
	 * Get accessor for persistent attribute: contrRetrDate
	 */
	public java.sql.Date getContrRetrDate();
	/**
	 * Set accessor for persistent attribute: contrRetrDate
	 */
	public void setContrRetrDate(java.sql.Date newContrRetrDate);
	/**
	 * Get accessor for persistent attribute: contrReplDate
	 */
	public java.sql.Date getContrReplDate();
	/**
	 * Set accessor for persistent attribute: contrReplDate
	 */
	public void setContrReplDate(java.sql.Date newContrReplDate);
	/**
	 * Get accessor for persistent attribute: contrClsDate
	 */
	public java.sql.Date getContrClsDate();
	/**
	 * Set accessor for persistent attribute: contrClsDate
	 */
	public void setContrClsDate(java.sql.Date newContrClsDate);
	/**
	 * Get accessor for persistent attribute: contrNo
	 */
	public java.lang.String getContrNo();
	/**
	 * Set accessor for persistent attribute: contrNo
	 */
	public void setContrNo(java.lang.String newContrNo);
	/**
	 * Get accessor for persistent attribute: regCustomerListNo
	 */
	public java.lang.String getRegCustomerListNo();
	/**
	 * Set accessor for persistent attribute: regCustomerListNo
	 */
	public void setRegCustomerListNo(java.lang.String newRegCustomerListNo);
	/**
	 * Get accessor for persistent attribute: regBillToPartyListNo
	 */
	public java.lang.String getRegBillToPartyListNo();
	/**
	 * Set accessor for persistent attribute: regBillToPartyListNo
	 */
	public void setRegBillToPartyListNo(
		java.lang.String newRegBillToPartyListNo);
	/**
	 * Get accessor for persistent attribute: regPayerListNo
	 */
	public java.lang.String getRegPayerListNo();
	/**
	 * Set accessor for persistent attribute: regPayerListNo
	 */
	public void setRegPayerListNo(java.lang.String newRegPayerListNo);
	/**
	 * Get accessor for persistent attribute: regShipToPartyListNo
	 */
	public java.lang.String getRegShipToPartyListNo();
	/**
	 * Set accessor for persistent attribute: regShipToPartyListNo
	 */
	public void setRegShipToPartyListNo(
		java.lang.String newRegShipToPartyListNo);
	/**
	 * Get accessor for persistent attribute: annivInvoiceAmount
	 */
	public double getAnnivInvoiceAmount();
	/**
	 * Set accessor for persistent attribute: annivInvoiceAmount
	 */
	public void setAnnivInvoiceAmount(double newAnnivInvoiceAmount);
	/**
	 * Get accessor for persistent attribute: semiAnnivInvoiceAmount
	 */
	public double getSemiAnnivInvoiceAmount();
	/**
	 * Set accessor for persistent attribute: semiAnnivInvoiceAmount
	 */
	public void setSemiAnnivInvoiceAmount(double newSemiAnnivInvoiceAmount);
	/**
	 * Get accessor for persistent attribute: quarterlyInvoiceAmount
	 */
	public double getQuarterlyInvoiceAmount();
	/**
	 * Set accessor for persistent attribute: quarterlyInvoiceAmount
	 */
	public void setQuarterlyInvoiceAmount(double newQuarterlyInvoiceAmount);
	/**
	 * Get accessor for persistent attribute: monthlyInvoiceAmount
	 */
	public double getMonthlyInvoiceAmount();
	/**
	 * Set accessor for persistent attribute: monthlyInvoiceAmount
	 */
	public void setMonthlyInvoiceAmount(double newMonthlyInvoiceAmount);
	/**
	 * Get accessor for persistent attribute: oldContractNo
	 */
	public java.lang.String getOldContractNo();
	/**
	 * Set accessor for persistent attribute: oldContractNo
	 */
	public void setOldContractNo(java.lang.String newOldContractNo);
	/**
	 * Get accessor for persistent attribute: preTVMInvoiceAmt
	 */
	public double getPreTVMInvoiceAmt();
	/**
	 * Set accessor for persistent attribute: preTVMInvoiceAmt
	 */
	public void setPreTVMInvoiceAmt(double newPreTVMInvoiceAmt);
	/**
	 * Get accessor for persistent attribute: proposalSharing
	 */
	public java.lang.String getProposalSharing();
	/**
	 * Set accessor for persistent attribute: proposalSharing
	 */
	public void setProposalSharing(java.lang.String newProposalSharing);
	/**
	 * Get accessor for persistent attribute: extContractNo
	 */
	public java.lang.String getExtContractNo();
	/**
	 * Set accessor for persistent attribute: extContractNo
	 */
	public void setExtContractNo(java.lang.String newExtContractNo);
	/**
	 * Get accessor for persistent attribute: contractCreateFlag
	 */
	public java.lang.String getContractCreateFlag();
	/**
	 * Set accessor for persistent attribute: contractCreateFlag
	 */
	public void setContractCreateFlag(java.lang.String newContractCreateFlag);
	/**
	 * Get accessor for persistent attribute: pakId
	 */
	public java.lang.String getPakId();
	/**
	 * Set accessor for persistent attribute: pakId
	 */
	public void setPakId(java.lang.String newPakId);
	/**
	 * Get accessor for persistent attribute: advancedBilling
	 */
	public java.lang.String getAdvancedBilling();
	/**
	 * Set accessor for persistent attribute: advancedBilling
	 */
	public void setAdvancedBilling(java.lang.String newAdvancedBilling);
	/**
	 * Get accessor for persistent attribute: billingType
	 */
	public java.lang.String getBillingType();
	/**
	 * Set accessor for persistent attribute: billingType
	 */
	public void setBillingType(java.lang.String newBillingType);
	/**
	 * Get accessor for persistent attribute: paymentTerm
	 */
	public java.lang.String getPaymentTerm();
	/**
	 * Set accessor for persistent attribute: paymentTerm
	 */
	public void setPaymentTerm(java.lang.String newPaymentTerm);
	/**
	 * Get accessor for persistent attribute: addValueDays
	 */
	public int getAddValueDays();
	/**
	 * Set accessor for persistent attribute: addValueDays
	 */
	public void setAddValueDays(int newAddValueDays);
	/**
	 * Get accessor for persistent attribute: fixedValueDate
	 */
	public java.sql.Date getFixedValueDate();
	/**
	 * Set accessor for persistent attribute: fixedValueDate
	 */
	public void setFixedValueDate(java.sql.Date newFixedValueDate);
	/**
	 * Get accessor for persistent attribute: tpContractNo
	 */
	public java.lang.String getTpContractNo();
	/**
	 * Set accessor for persistent attribute: tpContractNo
	 */
	public void setTpContractNo(java.lang.String newTpContractNo);
	/**
	 * Get accessor for persistent attribute: ineligibleInd
	 */
	public java.lang.String getIneligibleInd();
	/**
	 * Set accessor for persistent attribute: ineligibleInd
	 */
	public void setIneligibleInd(java.lang.String newIneligibleInd);
	/**
	 * Get accessor for persistent attribute: invoiceInd
	 */
	public java.lang.String getInvoiceInd();
	/**
	 * Set accessor for persistent attribute: invoiceInd
	 */
	public void setInvoiceInd(java.lang.String newInvoiceInd);
	/**
	 * Get accessor for persistent attribute: deviationDateRule
	 */
	public java.lang.String getDeviationDateRule();
	/**
	 * Set accessor for persistent attribute: deviationDateRule
	 */
	public void setDeviationDateRule(java.lang.String newDeviationDateRule);
	/**
	 * Get accessor for persistent attribute: billingBlock
	 */
	public java.lang.String getBillingBlock();
	/**
	 * Set accessor for persistent attribute: billingBlock
	 */
	public void setBillingBlock(java.lang.String newBillingBlock);
	/**
	 * Get accessor for persistent attribute: sAndSIncluded
	 */
	public java.lang.String getSAndSIncluded();
	/**
	 * Set accessor for persistent attribute: sAndSIncluded
	 */
	public void setSAndSIncluded(java.lang.String newSAndSIncluded);
	/**
	 * Get accessor for persistent attribute: lockedBy
	 */
	public java.lang.String getLockedBy();
	/**
	 * Set accessor for persistent attribute: lockedBy
	 */
	public void setLockedBy(java.lang.String newLockedBy);
	/**
	 * Get accessor for persistent attribute: poNo
	 */
	public java.lang.String getPoNo();
	/**
	 * Set accessor for persistent attribute: poNo
	 */
	public void setPoNo(java.lang.String newPoNo);
	/**
	 * Get accessor for persistent attribute: freeText
	 */
	public java.lang.String getFreeText();
	/**
	 * Set accessor for persistent attribute: freeText
	 */
	public void setFreeText(java.lang.String newFreeText);
	/**
	 * Get accessor for persistent attribute: regCustomerASNO
	 */
	public java.lang.String getRegCustomerASNO();
	/**
	 * Set accessor for persistent attribute: regCustomerASNO
	 */
	public void setRegCustomerASNO(java.lang.String newRegCustomerASNO);
	/**
	 * Get accessor for persistent attribute: regBillToPartyASNo
	 */
	public java.lang.String getRegBillToPartyASNo();
	/**
	 * Set accessor for persistent attribute: regBillToPartyASNo
	 */
	public void setRegBillToPartyASNo(java.lang.String newRegBillToPartyASNo);
	/**
	 * Get accessor for persistent attribute: regPayerASNo
	 */
	public java.lang.String getRegPayerASNo();
	/**
	 * Set accessor for persistent attribute: regPayerASNo
	 */
	public void setRegPayerASNo(java.lang.String newRegPayerASNo);
	/**
	 * Get accessor for persistent attribute: regShipTOPartyASNo
	 */
	public java.lang.String getRegShipTOPartyASNo();
	/**
	 * Set accessor for persistent attribute: regShipTOPartyASNo
	 */
	public void setRegShipTOPartyASNo(java.lang.String newRegShipTOPartyASNo);
	/**
	 * Get accessor for persistent attribute: gsaInd
	 */
	public java.lang.String getGsaInd();
	/**
	 * Set accessor for persistent attribute: gsaInd
	 */
	public void setGsaInd(java.lang.String newGsaInd);
	/**
	 * Get accessor for persistent attribute: varInd
	 */
	public java.lang.String getVarInd();
	/**
	 * Set accessor for persistent attribute: varInd
	 */
	public void setVarInd(java.lang.String newVarInd);
	/**
	 * Get accessor for persistent attribute: suppressInvoice
	 */
	public java.lang.String getSuppressInvoice();
	/**
	 * Set accessor for persistent attribute: suppressInvoice
	 */
	public void setSuppressInvoice(java.lang.String newSuppressInvoice);
	/**
	 * Get accessor for persistent attribute: varDate
	 */
	public java.sql.Date getVarDate();
	/**
	 * Set accessor for persistent attribute: varDate
	 */
	public void setVarDate(java.sql.Date newVarDate);
	/**
	 * Get accessor for persistent attribute: orgVarContractNo
	 */
	public java.lang.String getOrgVarContractNo();
	/**
	 * Set accessor for persistent attribute: orgVarContractNo
	 */
	public void setOrgVarContractNo(java.lang.String newOrgVarContractNo);
	/**
	 * Get accessor for persistent attribute: capVariance
	 */
	public double getCapVariance();
	/**
	 * Set accessor for persistent attribute: capVariance
	 */
	public void setCapVariance(double newCapVariance);
	/**
	 * Get accessor for persistent attribute: cumVariance
	 */
	public double getCumVariance();
	/**
	 * Set accessor for persistent attribute: cumVariance
	 */
	public void setCumVariance(double newCumVariance);
	/**
	 * Get accessor for persistent attribute: reg9DPartnerNo
	 */
	public java.lang.String getReg9DPartnerNo();
	/**
	 * Set accessor for persistent attribute: reg9DPartnerNo
	 */
	public void setReg9DPartnerNo(java.lang.String newReg9DPartnerNo);
	/**
	 * Get accessor for persistent attribute: reg9DPartmerName
	 */
	public java.lang.String getReg9DPartmerName();
	/**
	 * Set accessor for persistent attribute: reg9DPartmerName
	 */
	public void setReg9DPartmerName(java.lang.String newReg9DPartmerName);
	/**
	 * Get accessor for persistent attribute: lockedOn
	 */
	public java.sql.Date getLockedOn();
	/**
	 * Set accessor for persistent attribute: lockedOn
	 */
	public void setLockedOn(java.sql.Date newLockedOn);
	/**
	 * Get accessor for persistent attribute: proposalName
	 */
	public java.lang.String getProposalName();
	/**
	 * Set accessor for persistent attribute: proposalName
	 */
	public void setProposalName(java.lang.String newProposalName);
	/**
	 * Get accessor for persistent attribute: contrAmendNo
	 */
	public double getContrAmendNo();
	/**
	 * Set accessor for persistent attribute: contrAmendNo
	 */
	public void setContrAmendNo(double newContrAmendNo);
	/**
	 * Get accessor for persistent attribute: contractPeriodVarNo
	 */
	public int getContractPeriodVarNo();
	/**
	 * Set accessor for persistent attribute: contractPeriodVarNo
	 */
	public void setContractPeriodVarNo(int newContractPeriodVarNo);
	/**
	 * Get accessor for persistent attribute: eswFetchTime
	 */
	public java.sql.Time getEswFetchTime();
	/**
	 * Set accessor for persistent attribute: eswFetchTime
	 */
	public void setEswFetchTime(java.sql.Time newEswFetchTime);
	/**
	 * Get accessor for persistent attribute: eswFetchDate
	 */
	public java.sql.Date getEswFetchDate();
	/**
	 * Set accessor for persistent attribute: eswFetchDate
	 */
	public void setEswFetchDate(java.sql.Date newEswFetchDate);
	/**
	 * Get accessor for persistent attribute: contrRenewNo
	 */
	public int getContrRenewNo();
	/**
	 * Set accessor for persistent attribute: contrRenewNo
	 */
	public void setContrRenewNo(int newContrRenewNo);
	/**
	 * Get accessor for persistent attribute: contractReplNo
	 */
	public int getContractReplNo();
	/**
	 * Set accessor for persistent attribute: contractReplNo
	 */
	public void setContractReplNo(int newContractReplNo);
	/**
	 * Get accessor for persistent attribute: poDate
	 */
	public java.sql.Date getPoDate();
	/**
	 * Set accessor for persistent attribute: poDate
	 */
	public void setPoDate(java.sql.Date newPoDate);
	/**
	 * Get accessor for persistent attribute: contractVarNo
	 */
	public int getContractVarNo();
	/**
	 * Set accessor for persistent attribute: contractVarNo
	 */
	public void setContractVarNo(int newContractVarNo);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: igfNumber
	 */
	public java.lang.String getIgfNumber();
	/**
	 * Set accessor for persistent attribute: igfNumber
	 */
	public void setIgfNumber(java.lang.String newIgfNumber);
	/**
	 * Get accessor for persistent attribute: sandsanniversaryamt
	 */
	public double getSandsanniversaryamt();
	/**
	 * Set accessor for persistent attribute: sandsanniversaryamt
	 */
	public void setSandsanniversaryamt(double newSandsanniversaryamt);
	/**
	 * Get accessor for persistent attribute: sandsdiscountamount
	 */
	public double getSandsdiscountamount();
	/**
	 * Set accessor for persistent attribute: sandsdiscountamount
	 */
	public void setSandsdiscountamount(double newSandsdiscountamount);
	/**
	 * Get accessor for persistent attribute: proposalContent
	 */
	public java.lang.String getProposalContent();
	/**
	 * Set accessor for persistent attribute: proposalContent
	 */
	public void setProposalContent(java.lang.String newProposalContent);
	/**
	 * Get accessor for persistent attribute: submittedBy
	 */
	public java.lang.String getSubmittedBy();
	/**
	 * Set accessor for persistent attribute: submittedBy
	 */
	public void setSubmittedBy(java.lang.String newSubmittedBy);
	/**
	 * Get accessor for persistent attribute: groupName
	 */
	public java.lang.String getGroupName();
	/**
	 * Set accessor for persistent attribute: groupName
	 */
	public void setGroupName(java.lang.String newGroupName);
	
	public double getSandsDiscountAmount1();
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount1
	 */
	public void setSandsDiscountAmount1(double newSandsDiscountAmount1);
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount2
	 */
	public double getSandsDiscountAmount2();
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount2
	 */
	public void setSandsDiscountAmount2(double newSandsDiscountAmount2);
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount3
	 */
	public double getSandsDiscountAmount3();
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount3
	 */
	public void setSandsDiscountAmount3(double newSandsDiscountAmount3);
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount4
	 */
	public double getSandsDiscountAmount4();
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount4
	 */
	public void setSandsDiscountAmount4(double newSandsDiscountAmount4);
	/**
	 * Get accessor for persistent attribute: sandsDiscountAmount5
	 */
	public double getSandsDiscountAmount5();
	/**
	 * Set accessor for persistent attribute: sandsDiscountAmount5
	 */
	public void setSandsDiscountAmount5(double newSandsDiscountAmount5);
	
	/**
	 * Get accessor for persistent attribute: sandsExtendPeriod
	 */
	public java.lang.String getSandsExtendPeriod();
	/**
	 * Set accessor for persistent attribute: sandsExtendPeriod
	 */
	public  void setSandsExtendPeriod(
		java.lang.String newSandsExtendPeriod);
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt2
	 */
	public  double getSandsAnniversaryAmt2();
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt2
	 */
	public  void setSandsAnniversaryAmt2(double newSandsAnniversaryAmt2);
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt3
	 */
	public  double getSandsAnniversaryAmt3();
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt3
	 */
	public  void setSandsAnniversaryAmt3(double newSandsAnniversaryAmt3);
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt4
	 */
	public  double getSandsAnniversaryAmt4();
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt4
	 */
	public  void setSandsAnniversaryAmt4(double newSandsAnniversaryAmt4);
	/**
	 * Get accessor for persistent attribute: sandsAnniversaryAmt5
	 */
	public  double getSandsAnniversaryAmt5();
	/**
	 * Set accessor for persistent attribute: sandsAnniversaryAmt5
	 */
	public  void setSandsAnniversaryAmt5(double newSandsAnniversaryAmt5);
	// Blue Harmony Wave 1 DAD003 - Begin - Bhanu
	/**
	 * Get accessor for persistent attribute: prebillIndicator
	 */
	public String getPrebillIndicator();
	/**
	 * Set accessor for persistent attribute: prebillIndicator
	 */
	public void setPrebillIndicator(String prebillIndicator);
	/**
	 * Get accessor for persistent attribute: masterContractType
	 */
	public String getContractType();
	/**
	 * Set accessor for persistent attribute: masterContractType
	 */
	public void setContractType(String contractType);
	/**
	 * Get accessor for persistent attribute: masterContractId
	 */
	//public String getMasterContractId();
	/**
	 * Set accessor for persistent attribute: masterContractId
	 */
	//public void setMasterContractId(String masterContractId);
	/**
	 * Get accessor for persistent attribute: masterContractAmendment
	 */
	//public String getMasterContractAmendment();
	/**
	 * Set accessor for persistent attribute: masterContractAmendment
	 */
	//public void setMasterContractAmendment(String masterContractAmendment);
	/**
	 * Get accessor for persistent attribute: complexContractType
	 */
	public String getOcpsID();
	/**
	 * Set accessor for persistent attribute: complexContractType
	 */
	public void setOcpsID(String ocpsID);
	/**
	 * Get accessor for persistent attribute: complexContractId
	 */
	public String getCpsId();
	/**
	 * Set accessor for persistent attribute: complexContractId
	 */
	public void setCpsId(String cpsId);
	/**
	 * Get accessor for persistent attribute: complexContractAmendment
	 */
	//public String getComplexContractAmendment();
	/**
	 * Set accessor for persistent attribute: complexContractAmendment
	 */
	//public void setComplexContractAmendment(String complexContractAmendment);
	/**
	 * Get accessor for persistent attribute: blbIndicator
	 */
	public String getBlbIndicator();
	/**
	 * Set accessor for persistent attribute: blbIndicator
	 */
	public void setBlbIndicator(String blbIndicator);
	/**
	 * Get accessor for persistent attribute: cciInd
	 */
	public java.lang.String getCciInd();
	/**
	 * Set accessor for persistent attribute: cciInd
	 */
	public void setCciInd(java.lang.String cciInd);
	// Blue Harmony Wave 1 DAD003 - End - Bhanu
	 /* Get accessor for persistent attribute: autoPopulateInd
	 */
	public java.lang.String getAutoPopulateInd();
	/**
	 * Set accessor for persistent attribute: autoPopulateInd
	 */
	public void setAutoPopulateInd(java.lang.String newAutoPopulateInd);
	/**
	 * Get accessor for persistent attribute: salesGroup
	 */
	public java.lang.String getSalesGroup();
	/**
	 * Set accessor for persistent attribute: salesGroup
	 */
	public void setSalesGroup(java.lang.String newSalesGroup);
	/**
	 * Get accessor for persistent attribute: channelRole
	 */
	public java.lang.String getChannelRole();
	/**
	 * Set accessor for persistent attribute: channelRole
	 */
	public void setChannelRole(java.lang.String newChannelRole);
	/**
	 * Get accessor for persistent attribute: submitterRole
	 */
	public java.lang.String getSubmitterRole();
	/**
	 * Set accessor for persistent attribute: submitterRole
	 */
	public void setSubmitterRole(java.lang.String newSubmitterRole);
	/**
	 * Get accessor for persistent attribute: paymentMethod
	 */
	public java.lang.String getPaymentMethod();
	/**
	 * Set accessor for persistent attribute: paymentMethod
	 */
	public void setPaymentMethod(java.lang.String newPaymentMethod);
	/**
	 * Get accessor for persistent attribute: discount
	 */
	public double getDiscount();
	/**
	 * Set accessor for persistent attribute: discount
	 */
	public void setDiscount(double newDiscount);
}
