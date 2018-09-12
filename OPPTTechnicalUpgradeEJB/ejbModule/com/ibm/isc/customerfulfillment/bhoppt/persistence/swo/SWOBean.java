/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Bean implementation class for Enterprise Bean: SWO
 */
public abstract class SWOBean implements javax.ejb.EntityBean {
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
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey ejbCreate(
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String swoNo)
		throws javax.ejb.CreateException {
		setSwoId(swoId);
		setDmId(dmId);
		setCustomerId(customerId);
		setProposalId(proposalId);
		setSwoNo(swoNo);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		int swoId,
		int dmId,
		int customerId,
		int proposalId,String swoNo)
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
	 * Get accessor for persistent attribute: swoId
	 */
	public abstract int getSwoId();
	/**
	 * Set accessor for persistent attribute: swoId
	 */
	public abstract void setSwoId(int newSwoId);
	/**
	 * Get accessor for persistent attribute: dmId
	 */
	public abstract int getDmId();
	/**
	 * Set accessor for persistent attribute: dmId
	 */
	public abstract void setDmId(int newDmId);
	/**
	 * Get accessor for persistent attribute: customerId
	 */
	public abstract int getCustomerId();
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public abstract void setCustomerId(int newCustomerId);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public abstract int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public abstract void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: lockedInd
	 */
	public abstract java.lang.String getLockedInd();
	/**
	 * Set accessor for persistent attribute: lockedInd
	 */
	public abstract void setLockedInd(java.lang.String newLockedInd);
	/**
	 * Get accessor for persistent attribute: deltaFetchId
	 */
	public abstract java.lang.String getDeltaFetchId();
	/**
	 * Set accessor for persistent attribute: deltaFetchId
	 */
	public abstract void setDeltaFetchId(java.lang.String newDeltaFetchId);
	/**
	 * Get accessor for persistent attribute: adjustmentAmount
	 */
	public abstract double getAdjustmentAmount();
	/**
	 * Set accessor for persistent attribute: adjustmentAmount
	 */
	public abstract void setAdjustmentAmount(double newAdjustmentAmount);
	/**
	 * Get accessor for persistent attribute: planDateInd
	 */
	public abstract java.lang.String getPlanDateInd();
	/**
	 * Set accessor for persistent attribute: planDateInd
	 */
	public abstract void setPlanDateInd(java.lang.String newPlanDateInd);
	/**
	 * Get accessor for persistent attribute: swoContrType
	 */
	public abstract java.lang.String getSwoContrType();
	/**
	 * Set accessor for persistent attribute: swoContrType
	 */
	public abstract void setSwoContrType(java.lang.String newSwoContrType);
	/**
	 * Get accessor for persistent attribute: alternatePriceUpdateInd
	 */
	public abstract java.lang.String getAlternatePriceUpdateInd();
	/**
	 * Set accessor for persistent attribute: alternatePriceUpdateInd
	 */
	public abstract void setAlternatePriceUpdateInd(
		java.lang.String newAlternatePriceUpdateInd);
	/**
	 * Get accessor for persistent attribute: swoContrStatus
	 */
	public abstract java.lang.String getSwoContrStatus();
	/**
	 * Set accessor for persistent attribute: swoContrStatus
	 */
	public abstract void setSwoContrStatus(java.lang.String newSwoContrStatus);
	/**
	 * Get accessor for persistent attribute: swoExtContrNo
	 */
	public abstract java.lang.String getSwoExtContrNo();
	/**
	 * Set accessor for persistent attribute: swoExtContrNo
	 */
	public abstract void setSwoExtContrNo(java.lang.String newSwoExtContrNo);
	/**
	 * Get accessor for persistent attribute: amendEndDate
	 */
	public abstract java.sql.Date getAmendEndDate();
	/**
	 * Set accessor for persistent attribute: amendEndDate
	 */
	public abstract void setAmendEndDate(java.sql.Date newAmendEndDate);
	/**
	 * Get accessor for persistent attribute: refetchId
	 */
	public abstract java.lang.String getRefetchId();
	/**
	 * Set accessor for persistent attribute: refetchId
	 */
	public abstract void setRefetchId(java.lang.String newRefetchId);
	/**
	 * Get accessor for persistent attribute: swoAddedDate
	 */
	public abstract java.sql.Date getSwoAddedDate();
	/**
	 * Set accessor for persistent attribute: swoAddedDate
	 */
	public abstract void setSwoAddedDate(java.sql.Date newSwoAddedDate);
	/**
	 * Get accessor for persistent attribute: bumpInd
	 */
	public abstract java.lang.String getBumpInd();
	/**
	 * Set accessor for persistent attribute: bumpInd
	 */
	public abstract void setBumpInd(java.lang.String newBumpInd);
	/**
	 * Get accessor for persistent attribute: amendStartDate
	 */
	public abstract java.sql.Date getAmendStartDate();
	/**
	 * Set accessor for persistent attribute: amendStartDate
	 */
	public abstract void setAmendStartDate(java.sql.Date newAmendStartDate);
	/**
	 * Get accessor for persistent attribute: amendInd
	 */
	public abstract java.lang.String getAmendInd();
	/**
	 * Set accessor for persistent attribute: amendInd
	 */
	public abstract void setAmendInd(java.lang.String newAmendInd);
	/**
	 * Get accessor for persistent attribute: exclusionId
	 */
	public abstract java.lang.String getExclusionId();
	/**
	 * Set accessor for persistent attribute: exclusionId
	 */
	public abstract void setExclusionId(java.lang.String newExclusionId);
	/**
	 * Get accessor for persistent attribute: swoNo
	 */
	public abstract java.lang.String getSwoNo();
	/**
	 * Set accessor for persistent attribute: swoNo
	 */
	public abstract void setSwoNo(java.lang.String newSwoNo);
	/**
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public abstract java.sql.Date getLastUpdatedDate();
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public abstract void setLastUpdatedDate(java.sql.Date newLastUpdatedDate);
	/**
	 * Get accessor for persistent attribute: oldCalcPrice
	 */
	public abstract double getOldCalcPrice();
	/**
	 * Set accessor for persistent attribute: oldCalcPrice
	 */
	public abstract void setOldCalcPrice(double newOldCalcPrice);
	/**
	 * Get accessor for persistent attribute: eswPrice
	 */
	public abstract double getEswPrice();
	/**
	 * Set accessor for persistent attribute: eswPrice
	 */
	public abstract void setEswPrice(double newEswPrice);
	/**
	 * Get accessor for persistent attribute: plannedInd
	 */
	public abstract java.lang.String getPlannedInd();
	/**
	 * Set accessor for persistent attribute: plannedInd
	 */
	public abstract void setPlannedInd(java.lang.String newPlannedInd);
	/**
	 * Get accessor for persistent attribute: alternatePriceInd
	 */
	public abstract java.lang.String getAlternatePriceInd();
	/**
	 * Set accessor for persistent attribute: alternatePriceInd
	 */
	public abstract void setAlternatePriceInd(
		java.lang.String newAlternatePriceInd);
	/**
	 * Get accessor for persistent attribute: referenceSerialNo
	 */
	public abstract java.lang.String getReferenceSerialNo();
	/**
	 * Set accessor for persistent attribute: referenceSerialNo
	 */
	public abstract void setReferenceSerialNo(
		java.lang.String newReferenceSerialNo);
	/**
	 * Get accessor for persistent attribute: referenceSerialNoDM
	 */
	public abstract java.lang.String getReferenceSerialNoDM();
	/**
	 * Set accessor for persistent attribute: referenceSerialNoDM
	 */
	public abstract void setReferenceSerialNoDM(
		java.lang.String newReferenceSerialNoDM);
	/**
	 * Get accessor for persistent attribute: alternatePrice
	 */
	public abstract double getAlternatePrice();
	/**
	 * Set accessor for persistent attribute: alternatePrice
	 */
	public abstract void setAlternatePrice(double newAlternatePrice);
	/**
	 * Get accessor for persistent attribute: calcPrice
	 */
	public abstract double getCalcPrice();
	/**
	 * Set accessor for persistent attribute: calcPrice
	 */
	public abstract void setCalcPrice(double newCalcPrice);
	/**
	 * Get accessor for persistent attribute: swoDesc
	 */
	public abstract java.lang.String getSwoDesc();
	/**
	 * Set accessor for persistent attribute: swoDesc
	 */
	public abstract void setSwoDesc(java.lang.String newSwoDesc);
	/**
	 * Get accessor for persistent attribute: salesDocNo
	 */
	public abstract java.lang.String getSalesDocNo();
	/**
	 * Set accessor for persistent attribute: salesDocNo
	 */
	public abstract void setSalesDocNo(java.lang.String newSalesDocNo);
	/**
	 * Get accessor for persistent attribute: swoItemNo
	 */
	public abstract java.lang.String getSwoItemNo();
	/**
	 * Set accessor for persistent attribute: swoItemNo
	 */
	public abstract void setSwoItemNo(java.lang.String newSwoItemNo);
	/**
	 * Get accessor for persistent attribute: equipmentNo
	 */
	public abstract java.lang.String getEquipmentNo();
	/**
	 * Set accessor for persistent attribute: equipmentNo
	 */
	public abstract void setEquipmentNo(java.lang.String newEquipmentNo);
	/**
	 * Get accessor for persistent attribute: sequenceNo
	 */
	public abstract int getSequenceNo();
	/**
	 * Set accessor for persistent attribute: sequenceNo
	 */
	public abstract void setSequenceNo(int newSequenceNo);
	/**
	 * Get accessor for persistent attribute: itemCategory
	 */
	public abstract java.lang.String getItemCategory();
	/**
	 * Set accessor for persistent attribute: itemCategory
	 */
	public abstract void setItemCategory(java.lang.String newItemCategory);
	/**
	 * Get accessor for persistent attribute: planStartDate
	 */
	public abstract java.sql.Date getPlanStartDate();
	/**
	 * Set accessor for persistent attribute: planStartDate
	 */
	public abstract void setPlanStartDate(java.sql.Date newPlanStartDate);
	/**
	 * Get accessor for persistent attribute: customerPONo
	 */
	public abstract java.lang.String getCustomerPONo();
	/**
	 * Set accessor for persistent attribute: customerPONo
	 */
	public abstract void setCustomerPONo(java.lang.String newCustomerPONo);
	/**
	 * Get accessor for persistent attribute: planEndDate
	 */
	public abstract java.sql.Date getPlanEndDate();
	/**
	 * Set accessor for persistent attribute: planEndDate
	 */
	public abstract void setPlanEndDate(java.sql.Date newPlanEndDate);
	/**
	 * Get accessor for persistent attribute: serialNo
	 */
	public abstract java.lang.String getSerialNo();
	/**
	 * Set accessor for persistent attribute: serialNo
	 */
	public abstract void setSerialNo(java.lang.String newSerialNo);
	/**
	 * Get accessor for persistent attribute: requestDeliveryDate
	 */
	public abstract java.sql.Date getRequestDeliveryDate();
	/**
	 * Set accessor for persistent attribute: requestDeliveryDate
	 */
	public abstract void setRequestDeliveryDate(
		java.sql.Date newRequestDeliveryDate);
	/**
	 * Get accessor for persistent attribute: sandsIndicator
	 */
	public abstract java.lang.String getSandsIndicator();
	/**
	 * Set accessor for persistent attribute: sandsIndicator
	 */
	public abstract void setSandsIndicator(java.lang.String newSandsIndicator);
	/**
	 * Get accessor for persistent attribute: duplicateDeletedInd
	 */
	public abstract java.lang.String getDuplicateDeletedInd();
	/**
	 * Set accessor for persistent attribute: duplicateDeletedInd
	 */
	public abstract void setDuplicateDeletedInd(java.lang.String newDuplicateDeletedInd);
}
