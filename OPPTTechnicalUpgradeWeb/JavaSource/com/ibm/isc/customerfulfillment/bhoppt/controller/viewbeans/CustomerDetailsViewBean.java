/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ESWCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO;

/**
 * Holds the information for the customer details view 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CustomerDetailsViewBean extends OPPTViewBean {
	private String soldToPartyNumber = null;
	private String soldToPartyName = null;
	private String billToPartyNumber = null;
	private String billToPartyName = null;
	private String payerNumber = null;
	private String payerName = null;
	private String shipToPartyNumber = null;
	private String shipToPartyName = null;
	private Date planStartDate = null;
	private Date planEndDate = null;
	
	/**
	 * Returns bill to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillToPartyName() {
		return billToPartyName;
	}

	/**
	 * Returns bill to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillToPartyNumber() {
		return billToPartyNumber;
	}

	/**
	 * Returns payer name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPayerName() {
		return payerName;
	}

	/**
	 * Returns payer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPayerNumber() {
		return payerNumber;
	}

	/**
	 * Returns plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanEndDate() {
		return planEndDate;
	}

	/**
	 * Returns plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}

	/**
	 * Returns ship to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getShipToPartyName() {
		return shipToPartyName;
	}

	/**
	 * Returns ship to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getShipToPartyNumber() {
		return shipToPartyNumber;
	}

	/**
	 * Returns sold to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSoldToPartyName() {
		return soldToPartyName;
	}

	/**
	 * Returns sold to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSoldToPartyNumber() {
		return soldToPartyNumber;
	}

	/**
     * Sets bill to party name
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 19, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newBillToPartyName 
     */
	public void setBillToPartyName(String newBillToPartyName) {
		billToPartyName = newBillToPartyName;
	}

	/**
	 * Sets bill to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToPartyNumber String 
	 */
	public void setBillToPartyNumber(String newBillToPartyNumber) {
		billToPartyNumber = newBillToPartyNumber;
	}

	/**
	 * Sets payer name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayerName String 
	 */
	public void setPayerName(String newPayerName) {
		payerName = newPayerName;
	}

	/**
	 * Sets payer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayerNumber String 
	 */
	public void setPayerNumber(String newPayerNumber) {
		payerNumber = newPayerNumber;
	}

	/**
	 * Sets plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanEndDate Date 
	 */
	public void setPlanEndDate(Date newPlanEndDate) {
		planEndDate = newPlanEndDate;
	}

	/**
	 * Sets plan start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlanStartDate Date 
	 */
	public void setPlanStartDate(Date newPlanStartDate) {
		planStartDate = newPlanStartDate;
	}

	/**
	 * Sets ship to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShipToPartyName String 
	 */
	public void setShipToPartyName(String newShipToPartyName) {
		shipToPartyName = newShipToPartyName;
	}

	/**
	 * Sets ship to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShipToPartyNumber String 
	 */
	public void setShipToPartyNumber(String newShipToPartyNumber) {
		shipToPartyNumber = newShipToPartyNumber;
	}

	/**
	 * Sets sold to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToPartyName String 
	 */
	public void setSoldToPartyName(String newSoldToPartyName) {
		soldToPartyName = newSoldToPartyName;
	}

	/**
	 * Sets sold to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToPartyNumber String 
	 */
	public void setSoldToPartyNumber(String newSoldToPartyNumber) {
		soldToPartyNumber = newSoldToPartyNumber;
	}

	/**
	 * Sets the complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param soldToPartyNumber String
	 * @param soldToPartyName String
	 * @param billToPartyNumber String
	 * @param billToPartyName String
	 * @param payerNumber String
	 * @param payerName String
	 * @param shipToPartyNumber String
	 * @param shipToPartyName String
	 * @param planStartDate String
	 * @param planEndDate String
	 */
	public void setData(String soldToPartyNumber, String soldToPartyName, String billToPartyNumber, String billToPartyName, 
						String payerNumber, String payerName, String shipToPartyNumber, String shipToPartyName,
						Date planStartDate, Date planEndDate){
		setSoldToPartyNumber(soldToPartyNumber);
		setSoldToPartyName(soldToPartyName);
		setBillToPartyNumber(billToPartyNumber);
		setBillToPartyName(billToPartyName);
		setPayerNumber(payerNumber);
		setPayerName(payerName);
		setShipToPartyNumber(shipToPartyNumber);
		setShipToPartyName(shipToPartyName);
		setPlanStartDate(planStartDate);
		setPlanEndDate(planEndDate);
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(ProposalCustomerCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			//DADO02 setSoldToPartyNumber(customDTO.getLegacyCustomerNumberWithAS());
			setSoldToPartyNumber(customDTO.getSAPCustomerNumber());
			setSoldToPartyName(customDTO.getCustomerName());
			setPlanStartDate(customDTO.getPlanStartDate());
			setPlanEndDate(customDTO.getPlanEndDate());
			
			ESWCustomerCustomDTO customer[] = customDTO.getESWCustomerCustomDTOs();
			if(null != customer){
				for(int i=0, size=customer.length; i<size; i++){
					ESWCustomerCustomDTO eswCustomer = customer[i];
					if(null != eswCustomer){
						switch(eswCustomer.getPartnerType()){
							case UtilityConstants.PARTNER_BILL_TO_PARTY: 
										setBillToPartyName(eswCustomer.getCustomerName());
										//DADO02 setBillToPartyNumber(eswCustomer.getLegacyCustomerNumberWithAS());
							            setBillToPartyNumber(eswCustomer.getSAPCustomerNumber());
										break;
							case UtilityConstants.PARTNER_PAYER:
										setPayerName(eswCustomer.getCustomerName());
										//DADO02 setPayerNumber(eswCustomer.getLegacyCustomerNumberWithAS());
										setPayerNumber(eswCustomer.getSAPCustomerNumber());
                                        break;
							case UtilityConstants.PARTNER_SHIP_TO_PARTY:
										setShipToPartyName(eswCustomer.getCustomerName());
										//DADO02 setShipToPartyNumber(eswCustomer.getLegacyCustomerNumberWithAS());
							            setShipToPartyNumber(eswCustomer.getSAPCustomerNumber());
                                      	break;
						    default :
                                break;
                        }
					}
				}
			}
		}
	}
	/**
     * CustomerDetailsViewBean
     * 
     * @author thirumalai
     */
    public CustomerDetailsViewBean(){
	}
	/**
     * CustomerDetailsViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public CustomerDetailsViewBean(ProposalCustomerCustomDTO customDTO){
		setData(customDTO);
	}
}
