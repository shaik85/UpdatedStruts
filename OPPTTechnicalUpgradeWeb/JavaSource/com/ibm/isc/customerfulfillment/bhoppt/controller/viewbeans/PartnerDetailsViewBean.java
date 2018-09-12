/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.FetchCustomerListActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.GetPartnersActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PartnerInformationCustomDTO;

/**
 * Holds complete data required for partner details view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class PartnerDetailsViewBean extends OPPTViewBean
{
	private boolean iChangeProposal = false;
	private boolean iRoleBusinessPartner = false;
	private String iComments = null;
	private PartnerInformationViewBean iPartnerInformation = null;
	
	private GetPartnersActionForm iGetPartnersActionForm = null;
	
	/**
	 * Returns true if the current view is for the change proposal process  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isChangeProposal() {
		return iChangeProposal;
	}

	/**
	 * If change proposal process, that is change proposal is true, partner information will not be null. 
	 * Else it returns null. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PartnerInformationViewBean
	 */
	public PartnerInformationViewBean getPartnerInformation() {
		return iPartnerInformation;
	}

	/**
     * Sets change proposal flag
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newChangeProposal 
     */
	public void setChangeProposal(boolean newChangeProposal) {
		iChangeProposal = newChangeProposal;
	}

	/**
	 * Sets partner information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPartnerInformation PartnerInformationViewBean 
	 */
	public void setPartnerInformation(PartnerInformationViewBean newPartnerInformation) {
		iPartnerInformation = newPartnerInformation;
	}

	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param changeProposal
	 * @param partnerInformation
	 */
	public void setData(boolean changeProposal, PartnerInformationViewBean partnerInformation){
		setChangeProposal(changeProposal);
		setPartnerInformation(partnerInformation);
	}
	/**
	 * Returns true if the role of the current user is an business partner 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isRoleBusinessPartner() {
		return iRoleBusinessPartner;
	}

	/**
	 * Sets business partner flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newRoleBusinessPartner boolean 
	 */
	public void setRoleBusinessPartner(boolean newRoleBusinessPartner) {
		iRoleBusinessPartner = newRoleBusinessPartner;
	}
	
	/**
     * PartnerDetailsViewBean
     * 
     * @author thirumalai
     */
    public PartnerDetailsViewBean(){
	}
	/**
     * PartnerDetailsViewBean
     * 
     * @param roleBusinessPartner
     * @param changeProposal
     * @param partnerInformation
     * @author thirumalai
     */
    public PartnerDetailsViewBean(boolean roleBusinessPartner, boolean changeProposal, PartnerInformationCustomDTO partnerInformation){
		setRoleBusinessPartner(roleBusinessPartner);
		setChangeProposal(changeProposal);
		setPartnerInformation(new PartnerInformationViewBean(partnerInformation));
	}
	/**
     * PartnerDetailsViewBean
     * 
     * @param roleBusinessPartner
     * @param changeProposal
     * @param partnerInformation
     * @param comments
     * @author thirumalai
     */
    public PartnerDetailsViewBean(boolean roleBusinessPartner, boolean changeProposal, PartnerInformationCustomDTO partnerInformation, String comments){
		setRoleBusinessPartner(roleBusinessPartner);
		setChangeProposal(changeProposal);
		setPartnerInformation(new PartnerInformationViewBean(partnerInformation));
		setComments(comments);
	}
	
	/**
	 * Returns comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getComments() {
		return iComments;
	}

	/**
     * Sets comments value
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 26, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param string 
     */
	public void setComments(String string) {
		iComments = string;
	}

	/**
	 * Returns the action form associated with the current view. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return FetchCustomerListActionForm
	 */
	public FetchCustomerListActionForm getFetchCustomerListActionForm() {
		FetchCustomerListActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof FetchCustomerListActionForm){
			actionForm = (FetchCustomerListActionForm)getActionForm();
		}
		else{
			actionForm = new FetchCustomerListActionForm();
		}
		return actionForm;
	}

	/**
	 * Sets get partners action form 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public GetPartnersActionForm getGetPartnersActionForm() {
		if(null == iGetPartnersActionForm){
			iGetPartnersActionForm = new GetPartnersActionForm();
		}
		return iGetPartnersActionForm;
	}

	/**
	 * Sets get partners action form. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param getPartnersActionForm GetPartnersActionForm
	 */
	public void setGetPartnersActionForm(GetPartnersActionForm getPartnersActionForm) {
		iGetPartnersActionForm = getPartnersActionForm;
	}
}