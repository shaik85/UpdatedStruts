/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo;
/**
 * Local interface for Enterprise Bean: SWO
 */
public interface SWOLocal extends javax.ejb.EJBLocalObject {
	/**
	 * Get accessor for persistent attribute: lockedInd
	 */
	public java.lang.String getLockedInd();
	/**
	 * Set accessor for persistent attribute: lockedInd
	 */
	public void setLockedInd(java.lang.String newLockedInd);
	/**
	 * Get accessor for persistent attribute: deltaFetchId
	 */
	public java.lang.String getDeltaFetchId();
	/**
	 * Set accessor for persistent attribute: deltaFetchId
	 */
	public void setDeltaFetchId(java.lang.String newDeltaFetchId);
	/**
	 * Get accessor for persistent attribute: adjustmentAmount
	 */
	public double getAdjustmentAmount();
	/**
	 * Set accessor for persistent attribute: adjustmentAmount
	 */
	public void setAdjustmentAmount(double newAdjustmentAmount);
	/**
	 * Get accessor for persistent attribute: planDateInd
	 */
	public java.lang.String getPlanDateInd();
	/**
	 * Set accessor for persistent attribute: planDateInd
	 */
	public void setPlanDateInd(java.lang.String newPlanDateInd);
	/**
	 * Get accessor for persistent attribute: swoContrType
	 */
	public java.lang.String getSwoContrType();
	/**
	 * Set accessor for persistent attribute: swoContrType
	 */
	public void setSwoContrType(java.lang.String newSwoContrType);
	/**
	 * Get accessor for persistent attribute: alternatePriceUpdateInd
	 */
	public java.lang.String getAlternatePriceUpdateInd();
	/**
	 * Set accessor for persistent attribute: alternatePriceUpdateInd
	 */
	public void setAlternatePriceUpdateInd(
		java.lang.String newAlternatePriceUpdateInd);
	/**
	 * Get accessor for persistent attribute: swoContrStatus
	 */
	public java.lang.String getSwoContrStatus();
	/**
	 * Set accessor for persistent attribute: swoContrStatus
	 */
	public void setSwoContrStatus(java.lang.String newSwoContrStatus);
	/**
	 * Get accessor for persistent attribute: swoExtContrNo
	 */
	public java.lang.String getSwoExtContrNo();
	/**
	 * Set accessor for persistent attribute: swoExtContrNo
	 */
	public void setSwoExtContrNo(java.lang.String newSwoExtContrNo);
	/**
	 * Get accessor for persistent attribute: amendEndDate
	 */
	public java.sql.Date getAmendEndDate();
	/**
	 * Set accessor for persistent attribute: amendEndDate
	 */
	public void setAmendEndDate(java.sql.Date newAmendEndDate);
	/**
	 * Get accessor for persistent attribute: refetchId
	 */
	public java.lang.String getRefetchId();
	/**
	 * Set accessor for persistent attribute: refetchId
	 */
	public void setRefetchId(java.lang.String newRefetchId);
	/**
	 * Get accessor for persistent attribute: swoAddedDate
	 */
	public java.sql.Date getSwoAddedDate();
	/**
	 * Set accessor for persistent attribute: swoAddedDate
	 */
	public void setSwoAddedDate(java.sql.Date newSwoAddedDate);
	/**
	 * Get accessor for persistent attribute: bumpInd
	 */
	public java.lang.String getBumpInd();
	/**
	 * Set accessor for persistent attribute: bumpInd
	 */
	public void setBumpInd(java.lang.String newBumpInd);
	/**
	 * Get accessor for persistent attribute: amendStartDate
	 */
	public java.sql.Date getAmendStartDate();
	/**
	 * Set accessor for persistent attribute: amendStartDate
	 */
	public void setAmendStartDate(java.sql.Date newAmendStartDate);
	/**
	 * Get accessor for persistent attribute: amendInd
	 */
	public java.lang.String getAmendInd();
	/**
	 * Set accessor for persistent attribute: amendInd
	 */
	public void setAmendInd(java.lang.String newAmendInd);
	/**
	 * Get accessor for persistent attribute: exclusionId
	 */
	public java.lang.String getExclusionId();
	/**
	 * Set accessor for persistent attribute: exclusionId
	 */
	public void setExclusionId(java.lang.String newExclusionId);
	/**
	 * Get accessor for persistent attribute: swoNo
	 */
	public java.lang.String getSwoNo();
	/**
	 * Set accessor for persistent attribute: swoNo
	 */
	public void setSwoNo(java.lang.String newSwoNo);
	/**
	 * Get accessor for persistent attribute: lastUpdatedDate
	 */
	public java.sql.Date getLastUpdatedDate();
	/**
	 * Set accessor for persistent attribute: lastUpdatedDate
	 */
	public void setLastUpdatedDate(java.sql.Date newLastUpdatedDate);
	/**
	 * Get accessor for persistent attribute: oldCalcPrice
	 */
	public double getOldCalcPrice();
	/**
	 * Set accessor for persistent attribute: oldCalcPrice
	 */
	public void setOldCalcPrice(double newOldCalcPrice);
	/**
	 * Get accessor for persistent attribute: eswPrice
	 */
	public double getEswPrice();
	/**
	 * Set accessor for persistent attribute: eswPrice
	 */
	public void setEswPrice(double newEswPrice);
	/**
	 * Get accessor for persistent attribute: plannedInd
	 */
	public java.lang.String getPlannedInd();
	/**
	 * Set accessor for persistent attribute: plannedInd
	 */
	public void setPlannedInd(java.lang.String newPlannedInd);
	/**
	 * Get accessor for persistent attribute: alternatePriceInd
	 */
	public java.lang.String getAlternatePriceInd();
	/**
	 * Set accessor for persistent attribute: alternatePriceInd
	 */
	public void setAlternatePriceInd(java.lang.String newAlternatePriceInd);
	/**
	 * Get accessor for persistent attribute: referenceSerialNo
	 */
	public java.lang.String getReferenceSerialNo();
	/**
	 * Set accessor for persistent attribute: referenceSerialNo
	 */
	public void setReferenceSerialNo(java.lang.String newReferenceSerialNo);
	/**
	 * Get accessor for persistent attribute: referenceSerialNoDM
	 */
	public java.lang.String getReferenceSerialNoDM();
	/**
	 * Set accessor for persistent attribute: referenceSerialNoDM
	 */
	public void setReferenceSerialNoDM(java.lang.String newReferenceSerialNoDM);
	/**
	 * Get accessor for persistent attribute: alternatePrice
	 */
	public double getAlternatePrice();
	/**
	 * Set accessor for persistent attribute: alternatePrice
	 */
	public void setAlternatePrice(double newAlternatePrice);
	/**
	 * Get accessor for persistent attribute: calcPrice
	 */
	public double getCalcPrice();
	/**
	 * Set accessor for persistent attribute: calcPrice
	 */
	public void setCalcPrice(double newCalcPrice);
	/**
	 * Get accessor for persistent attribute: swoDesc
	 */
	public java.lang.String getSwoDesc();
	/**
	 * Set accessor for persistent attribute: swoDesc
	 */
	public void setSwoDesc(java.lang.String newSwoDesc);
	/**
	 * Get accessor for persistent attribute: salesDocNo
	 */
	public java.lang.String getSalesDocNo();
	/**
	 * Set accessor for persistent attribute: salesDocNo
	 */
	public void setSalesDocNo(java.lang.String newSalesDocNo);
	/**
	 * Get accessor for persistent attribute: swoItemNo
	 */
	public java.lang.String getSwoItemNo();
	/**
	 * Set accessor for persistent attribute: swoItemNo
	 */
	public void setSwoItemNo(java.lang.String newSwoItemNo);
	/**
	 * Get accessor for persistent attribute: equipmentNo
	 */
	public java.lang.String getEquipmentNo();
	/**
	 * Set accessor for persistent attribute: equipmentNo
	 */
	public void setEquipmentNo(java.lang.String newEquipmentNo);
	/**
	 * Get accessor for persistent attribute: sequenceNo
	 */
	public int getSequenceNo();
	/**
	 * Set accessor for persistent attribute: sequenceNo
	 */
	public void setSequenceNo(int newSequenceNo);
	/**
	 * Get accessor for persistent attribute: itemCategory
	 */
	public java.lang.String getItemCategory();
	/**
	 * Set accessor for persistent attribute: itemCategory
	 */
	public void setItemCategory(java.lang.String newItemCategory);
	/**
	 * Get accessor for persistent attribute: planStartDate
	 */
	public java.sql.Date getPlanStartDate();
	/**
	 * Set accessor for persistent attribute: planStartDate
	 */
	public void setPlanStartDate(java.sql.Date newPlanStartDate);
	/**
	 * Get accessor for persistent attribute: customerPONo
	 */
	public java.lang.String getCustomerPONo();
	/**
	 * Set accessor for persistent attribute: customerPONo
	 */
	public void setCustomerPONo(java.lang.String newCustomerPONo);
	/**
	 * Get accessor for persistent attribute: planEndDate
	 */
	public java.sql.Date getPlanEndDate();
	/**
	 * Set accessor for persistent attribute: planEndDate
	 */
	public void setPlanEndDate(java.sql.Date newPlanEndDate);
	/**
	 * Get accessor for persistent attribute: serialNo
	 */
	public java.lang.String getSerialNo();
	/**
	 * Set accessor for persistent attribute: serialNo
	 */
	public void setSerialNo(java.lang.String newSerialNo);
	/**
	 * Get accessor for persistent attribute: requestDeliveryDate
	 */
	public java.sql.Date getRequestDeliveryDate();
	/**
	 * Set accessor for persistent attribute: requestDeliveryDate
	 */
	public void setRequestDeliveryDate(java.sql.Date newRequestDeliveryDate);
	/**
	 * Get accessor for persistent attribute: swoId
	 */
	public int getSwoId();
	/**
	 * Set accessor for persistent attribute: swoId
	 */
	public void setSwoId(int newSwoId);
	/**
	 * Get accessor for persistent attribute: dmId
	 */
	public int getDmId();
	/**
	 * Set accessor for persistent attribute: dmId
	 */
	public void setDmId(int newDmId);
	/**
	 * Get accessor for persistent attribute: customerId
	 */
	public int getCustomerId();
	/**
	 * Set accessor for persistent attribute: customerId
	 */
	public void setCustomerId(int newCustomerId);
	/**
	 * Get accessor for persistent attribute: proposalId
	 */
	public int getProposalId();
	/**
	 * Set accessor for persistent attribute: proposalId
	 */
	public void setProposalId(int newProposalId);
	/**
	 * Get accessor for persistent attribute: sandsIndicator
	 */
	public java.lang.String getSandsIndicator();
	/**
	 * Set accessor for persistent attribute: sandsIndicator
	 */
	public void setSandsIndicator(java.lang.String newSandsIndicator);
	/**
	 * Get accessor for persistent attribute: duplicateDeletedInd
	 */
	public java.lang.String getDuplicateDeletedInd();
	/**
	 * Set accessor for persistent attribute: duplicateDeletedInd
	 */
	public void setDuplicateDeletedInd(java.lang.String newDuplicateDeletedInd);
}
