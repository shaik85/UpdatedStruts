/*
 * Created on May 11, 2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/*
* IBM Confidential
*
* ©  Copyright IBM Corp. 2004, 2005  All Rights Reserved.

* The source code for this program is not published or otherwise divested of
* its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
*/
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
/**
 * @author Bhanu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ValidateComplexDataInputConnectorDTO implements ConnectorDTOInterface{
	private OrgConnectorDTO iOrgConnectorDTO;
	private GenericConnectorDTO iGenericConnectorDTO;
	private String iCpsID;
	//private String iComplexContractAmendment;
	//private String iMasterContractID;
	//private String iMasterContractAmendment;
	//private String iBLBIndicator;
	private Date   iContractStartDate;
	private Date   iContractEndDate;
	

	/**
	 * @return Returns the iBLBIndicator.
	 */
//	public String getIBLBIndicator() {
//		return iBLBIndicator;
//	}
//	/**
//	 * @param indicator The iBLBIndicator to set.
//	 */
//	public void setIBLBIndicator(String indicator) {
//		iBLBIndicator = indicator;
//	}
	/**
	 * @return Returns the iComplexContractAmendment.
	 */
	/*public String getIComplexContractAmendment() {
		return iComplexContractAmendment;
	}
	*//**
	 * @param complexContractAmendment The iComplexContractAmendment to set.
	 *//*
	public void setIComplexContractAmendment(String complexContractAmendment) {
		iComplexContractAmendment = complexContractAmendment;
	}*/
	/**
	 * @return Returns the iComplexContractID.
	 */
	public String getICpsID() {
		return iCpsID;
	}
	/**
	 * @param complexContractID The iComplexContractID to set.
	 */
	public void setICpsID(String cpsID) {
		iCpsID = cpsID;
	}
	/**
	 * @return Returns the iContractEndDate.
	 */
	public Date getIContractEndDate() {
		return iContractEndDate;
	}
	/**
	 * @param contractEndDate The iContractEndDate to set.
	 */
	public void setIContractEndDate(Date contractEndDate) {
		iContractEndDate = contractEndDate;
	}
	/**
	 * @return Returns the iContractStartDate.
	 */
	public Date getIContractStartDate() {
		return iContractStartDate;
	}
	/**
	 * @param contractStartDate The iContractStartDate to set.
	 */
	public void setIContractStartDate(Date contractStartDate) {
		iContractStartDate = contractStartDate;
	}
	/**
	 * @return Returns the iGenericConnectorDTO.
	 */
	public GenericConnectorDTO getIGenericConnectorDTO() {
		return iGenericConnectorDTO;
	}
	/**
	 * @param genericConnectorDTO The iGenericConnectorDTO to set.
	 */
	public void setIGenericConnectorDTO(GenericConnectorDTO genericConnectorDTO) {
		iGenericConnectorDTO = genericConnectorDTO;
	}
	/**
	 * @return Returns the iMasterContractAmendment.
	 */
	/*public String getIMasterContractAmendment() {
		return iMasterContractAmendment;
	}
	*//**
	 * @param masterContractAmendment The iMasterContractAmendment to set.
	 *//*
	public void setIMasterContractAmendment(String masterContractAmendment) {
		iMasterContractAmendment = masterContractAmendment;
	}
	*//**
	 * @return Returns the iMasterContractID.
	 *//*
	public String getIMasterContractID() {
		return iMasterContractID;
	}
	*//**
	 * @param masterContractID The iMasterContractID to set.
	 *//*
	public void setIMasterContractID(String masterContractID) {
		iMasterContractID = masterContractID;
	}*/
	/**
	 * @return Returns the iOrgConnectorDTO.
	 */
	public OrgConnectorDTO getIOrgConnectorDTO() {
		return iOrgConnectorDTO;
	}
	/**
	 * @param orgConnectorDTO The iOrgConnectorDTO to set.
	 */
	public void setIOrgConnectorDTO(OrgConnectorDTO orgConnectorDTO) {
		iOrgConnectorDTO = orgConnectorDTO;
	}
}
