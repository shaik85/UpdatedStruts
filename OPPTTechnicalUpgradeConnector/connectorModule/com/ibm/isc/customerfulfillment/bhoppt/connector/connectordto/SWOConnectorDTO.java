/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * SWO ConnectorDTO contains SWO and DM details  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class SWOConnectorDTO implements ConnectorDTOInterface {
	private String salesDocumentNumber;
	private String sWOItemPositionNumber;
	private String salesDocumentCategory;
	private Date requestDeliveryDate;
	private String customerNumber;
	private String customerPurchaseOrderNumber;
	private String designatedMachine;
	private String desigMachineDesc;
	private String sWOMaterialNumber;
	private String sWODesc;
	private String sWOSerialNumber;
	private String referenceSerialNumber;
	private String referenceDesignatedMachine;
	private String equipmentNumber;
	private String sWOExternalContractNumber;
	private String sWOContractType;
	private String sWOContractStatus;
	private String sAndSIndicator;
	private String ineligibleFlag;
	private Date licenseEffectiveDate;
	private String ineligibilityComment;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public SWOConnectorDTO() {
	}
	/** 
	 * To get the customer number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Customer Number
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/** 
	 * To get the customer purchace order number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Customer purchace order number
	 */
	public String getCustomerPurchaseOrderNumber() {
		return customerPurchaseOrderNumber;
	}

	/** 
	 * To get the Designated Machine Description
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Designated Machine Description
	 */
	public String getDesigMachineDesc() {
		return desigMachineDesc;
	}

	/** 
	 * To get the Designated Machine 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Designated Machine
	 */
	public String getDesignatedMachine() {
		return designatedMachine;
	}

	/** 
	 * To get the Equipment Number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Equipment Number
	 */
	public String getEquipmentNumber() {
		return equipmentNumber;
	}

	/** 
	 * To get the Reference Designated Machine 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Reference Designated Machine
	 */
	public String getReferenceDesignatedMachine() {
		return referenceDesignatedMachine;
	}

	/** 
	 * To get the Reference Serial Number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Reference Serial Number
	 */
	public String getReferenceSerialNumber() {
		return referenceSerialNumber;
	}

	/** 
	 * To get the Request Delivery Date
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Request Delivery Date
	 */
	public Date getRequestDeliveryDate() {
		return requestDeliveryDate;
	}

	/** 
	 * To get the Sales Document Category
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Sales Document Category 
	 */
	public String getSalesDocumentCategory() {
		return salesDocumentCategory;
	}

	/** 
	 * To get the Sales document number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Sales document number 
	 */
	public String getSalesDocumentNumber() {
		return salesDocumentNumber;
	}

	/** 
	 * To get the SWO Contract Status
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SWO Contract Status 
	 */
	public String getSWOContractStatus() {
		return sWOContractStatus;
	}

	/** 
	 * To get the SWO Contract Type
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SWO Contract Type
	 */
	public String getSWOContractType() {
		return sWOContractType;
	}

	/** 
	 * To get the SWO Description
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SWO Description 
	 */
	public String getSWODesc() {
		return sWODesc;
	}

	/** 
	 * To get the SWO External Contract Number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SWO External Contract Number
	 */
	public String getSWOExternalContractNumber() {
		return sWOExternalContractNumber;
	}

	/** 
	 * To get the SWO Item Position Number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SWO Item Position Number
	 */
	public String getSWOItemPositionNumber() {
		return sWOItemPositionNumber;
	}

	/** 
	 * To get the SWO Material Number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SWO Material Number
	 */
	public String getSWOMaterialNumber() {
		return sWOMaterialNumber;
	}

	/** 
	 * To get the SWO Serial Number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SWO Serial Number
	 */
	public String getSWOSerialNumber() {
		return sWOSerialNumber;
	}

	/** 
	 * To set the customer number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lcustomerNumber
	 */
	public void setCustomerNumber(String lcustomerNumber) {
		customerNumber = lcustomerNumber;
	}

	/** 
	 * To set the customer purchase order number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param purchaseOrderNumber
	 */
	public void setCustomerPurchaseOrderNumber(String purchaseOrderNumber) {
		customerPurchaseOrderNumber = purchaseOrderNumber;
	}

	/** 
	 * To set the designated machine description
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmDescription
	 */
	public void setDesigMachineDesc(String dmDescription) {
		desigMachineDesc = dmDescription;
	}

	/** 
	 * To set the designated machine 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dm
	 */
	public void setDesignatedMachine(String dm) {
		designatedMachine = dm;
	}

	/** 
	 * To set the equipment number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param equipmentNo
	 */
	public void setEquipmentNumber(String equipmentNo) {
		equipmentNumber = equipmentNo;
	}

	/** 
	 * To set the reference designated machine 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param referenceDM
	 */
	public void setReferenceDesignatedMachine(String referenceDM) {
		referenceDesignatedMachine = referenceDM;
	}

	/** 
	 * To set the reference serial number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param serialNo
	 */
	public void setReferenceSerialNumber(String serialNo) {
		referenceSerialNumber = serialNo;
	}

	/** 
	 * To set the request delivery date 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lrequestDeliveryDate
	 */
	public void setRequestDeliveryDate(Date lrequestDeliveryDate) {
		requestDeliveryDate = lrequestDeliveryDate;
	}

	/** 
	 * To set the sales document category
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lsalesDocumentCategory
	 */
	public void setSalesDocumentCategory(String lsalesDocumentCategory) {
		salesDocumentCategory = lsalesDocumentCategory;
	}

	/** 
	 * To set the sales document number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesDocNo
	 */
	public void setSalesDocumentNumber(String salesDocNo) {
		salesDocumentNumber = salesDocNo;
	}

	/** 
	 * To set the SWO Contract Status 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contractStatus
	 */
	public void setSWOContractStatus(String contractStatus) {
		sWOContractStatus = contractStatus;
	}

	/** 
	 * To set the SWO Contract Type
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contractType
	 */
	public void setSWOContractType(String contractType) {
		sWOContractType = contractType;
	}

	/** 
	 * To set the SWO Description
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param desc
	 */
	public void setSWODesc(String desc) {
		sWODesc = desc;
	}

	/** 
	 * To set the SWO External Contract Number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param  externalContractNo
	 */
	public void setSWOExternalContractNumber(String externalContractNo) {
		sWOExternalContractNumber = externalContractNo;
	}

	/** 
	 * To set the SWO Item Position Number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param itemPositionNo
	 */
	public void setSWOItemPositionNumber(String itemPositionNo) {
		sWOItemPositionNumber = itemPositionNo;
	}

	/** 
	 * To set the SWO Material Number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param materialNo
	 */
	public void setSWOMaterialNumber(String materialNo) {
		sWOMaterialNumber = materialNo;
	}

	/** 
	 * To set the SWO Serial Number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param serialNo
	 */
	public void setSWOSerialNumber(String serialNo) {
		sWOSerialNumber = serialNo;
	}

	/** 
	 * To get the Ineligibility Comment
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Ineligibility Comment 
	 */
	public String getIneligibilityComment() {
		return ineligibilityComment;
	}

	/** 
	 * To get the Ineligible Flag 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Ineligible Flag
	 */
	public String getIneligibleFlag() {
		return ineligibleFlag;
	}

	/** 
	 * To get the License Effective Date 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return License Effective Date
	 */
	public Date getLicenseEffectiveDate() {
		return licenseEffectiveDate;
	}

	/** 
	 * To set the Ineligibility Comment 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param comment 
	 */
	public void setIneligibilityComment(String comment) {
		ineligibilityComment = comment;
	}

	/** 
	 * To set the ineligible flag
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param flag 
	 */
	public void setIneligibleFlag(String flag) {
		ineligibleFlag = flag;
	}

	/** 
	 * To set the license effective date
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date 
	 */
	public void setLicenseEffectiveDate(Date date) {
		licenseEffectiveDate = date;
	}
	/** 
	
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSAndSIndicator() {
		return sAndSIndicator;
	}

	/** 
	 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSAndSIndicator(String string) {
		sAndSIndicator = string;
	}
	/** 
	 *  getKey  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return  String
	 */
	public String getKey() {
		StringBuffer buffer = new StringBuffer();
		if (null != getEquipmentNumber()) {
			buffer.append(getEquipmentNumber());
			buffer.append("__");
		}
		if (null != getSalesDocumentNumber()) {
			buffer.append(getSalesDocumentNumber());
		}

		return buffer.toString();
	}

}
