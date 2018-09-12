/*
 * Created on May 17, 2010
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
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BasicProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import org.apache.commons.collections.MultiHashMap;


/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ComplexContractIdentifiers {
	MultiHashMap mhm = new MultiHashMap(3);
	private String cpsID = null;
	private String ocpsID = null;
	private String contractType = null;
	private String blbIndicator = null;
	private String execptionCode = null;
	private String message = null;
	private String returnCode = null;
	private String sapReturnCode = null;
	private boolean cpsSalesOrg= false;

	private static ComplexContractIdentifiers complexContractIdentifiers = null;

	private ComplexContractIdentifiers(){

	}

	public static ComplexContractIdentifiers getComplexContractIdentifiers(){
		if(complexContractIdentifiers==null){
			complexContractIdentifiers = new ComplexContractIdentifiers();
		}
		return complexContractIdentifiers;
	}
	//Added by Manoj
	public boolean IsCPSSalesorg(BasicProposalCustomDTO basicProposalCustomDTO){
		//if( (cpsSalesOrg!=true) && ("".equalsIgnoreCase(basicProposalCustomDTO.getCpsID())|| basicProposalCustomDTO.getCpsID()== null)){
			if("".equalsIgnoreCase(basicProposalCustomDTO.getCpsID())|| basicProposalCustomDTO.getCpsID()== null){
			System.out.println("ComplexContractIdentifiers.IsCPSSalesorg()if");
			cpsSalesOrg=true;
		}
		else{
			cpsSalesOrg=false;
		}
			return cpsSalesOrg;
	}
/*	public boolean IsCPSSalesorg(BasicProposalCustomDTO basicProposalCustomDTO){
		if( (cpsSalesOrg!=true) && ("".equalsIgnoreCase(basicProposalCustomDTO.getCpsID())|| basicProposalCustomDTO.getCpsID()== null) && ("7240".equals(basicProposalCustomDTO.getSalesOrganization())|| "0365".equals(basicProposalCustomDTO.getSalesOrganization()))){

			cpsSalesOrg=true;
		}
		else{
			cpsSalesOrg=false;
		}
			return cpsSalesOrg;
	}*/


	public boolean IsChangedComplexContractIdentifiers(BasicProposalCustomDTO basicProposalCustomDTO){
		// First check if all values are null, then return false
		if(IsAllValueNull(basicProposalCustomDTO)){
			return false;
		}
			
		// Check if all values are equal to older value
		
		if(("".equalsIgnoreCase(basicProposalCustomDTO.getCpsID())|| basicProposalCustomDTO.getCpsID()== null)
		//if((cpsID == basicProposalCustomDTO.getCpsID() ||
			//(cpsID != null && cpsID.equals(basicProposalCustomDTO.getCpsID()))) 
			//&&(masterContractID == basicProposalCustomDTO.getMasterContractID() ||
		   	//(masterContractID != null && masterContractID.equals(basicProposalCustomDTO.getMasterContractID()))) &&
		  // (complexContractAmendment == basicProposalCustomDTO.getComplexContractAmendment() ||
		   	//(complexContractAmendment != null && complexContractAmendment.equals(basicProposalCustomDTO.getComplexContractAmendment()))) &&
		   //(masterContractAmendment == basicProposalCustomDTO.getMasterContractAmendment() ||
		   	//(masterContractAmendment != null && masterContractAmendment.equals(basicProposalCustomDTO.getMasterContractAmendment()))) &&
		   //(blbIndicator == basicProposalCustomDTO.getBlbIndicator() ||
		   //	(blbIndicator != null && blbIndicator.equals(basicProposalCustomDTO.getBlbIndicator())))
			){
			return false;
		} else {
			return true;
		}		
	}
	
	public boolean IsAllValueNull(BasicProposalCustomDTO basicProposalCustomDTO){
		if(basicProposalCustomDTO.getCpsID().equals(""))
				{
			//	&&
		   //basicProposalCustomDTO.getMasterContractID().equals("")  &&
		   //basicProposalCustomDTO.getComplexContractAmendment().equals("") &&
	       //basicProposalCustomDTO.getMasterContractAmendment().equals("") &&
		   //(null == basicProposalCustomDTO.getBlbIndicator() ||
		   	//	basicProposalCustomDTO.getBlbIndicator().equals("Select one"))    ){ // Select one to check for drop down list
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public void SetComplexContractIdentifiers(BasicProposalCustomDTO basicProposalCustomDTO){
		setCpsID(basicProposalCustomDTO.getCpsID());
		}
	
	public void ResetComplexContractIdentifiers(){
		setCpsID(null);
		}
	/**
	 * @return Returns the blbIndicator.
	 */
	public String getBlbIndicator() {
		return blbIndicator;
	}
	/**
	 * @param blbIndicator The blbIndicator to set.
	 */
	public void setBlbIndicator(String blbIndicator) {
		this.blbIndicator = blbIndicator;
	}
	/**
	 * @return Returns the complexContractAmendment.
	 */
	/*public String getComplexContractAmendment() {
		return complexContractAmendment;
	}
	*//**
	 * @param complexContractAmendment The complexContractAmendment to set.
	 *//*
	public void setComplexContractAmendment(String complexContractAmendment) {
		this.complexContractAmendment = complexContractAmendment;
	}*/
	/**
	 * @return Returns the complexContractID.
	 */
	public String getCpsID() {
		return cpsID;
	}
	/**
	 * @param complexContractID The complexContractID to set.
	 */
	public void setCpsID(String cpsID) {
		this.cpsID = cpsID;
	}
	/**
	 * @return Returns the complexContractType.
	 */
	public String getOcpsID() {
		return ocpsID;
	}
	/**
	 * @param complexContractType The complexContractType to set.
	 */
	public void setOcpsID(String ocpsID) {
		this.ocpsID = ocpsID;
	}
	/**
	 * @return Returns the masterContractAmendment.
	 */
	/*public String getMasterContractAmendment() {
		return masterContractAmendment;
	}
	*//**
	 * @param masterContractAmendment The masterContractAmendment to set.
	 *//*
	public void setMasterContractAmendment(String masterContractAmendment) {
		this.masterContractAmendment = masterContractAmendment;
	}*/
	/**
	 * @return Returns the masterContractID.
	 */
	/*public String getMasterContractID() {
		return masterContractID;
	}
	*//**
	 * @param masterContractID The masterContractID to set.
	 *//*
	public void setMasterContractID(String masterContractID) {
		this.masterContractID = masterContractID;
	}*/
	/**
	 * @return Returns the masterContractType.
	 */
	public String getContractType() {
		return contractType;
	}
	/**
	 * @param masterContractType The masterContractType to set.
	 */
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	/**
	 * @return Returns the execptionCode.
	 */
	public String getExecptionCode() {
		return execptionCode;
	}
	/**
	 * @param execptionCode The execptionCode to set.
	 */
	public void setExecptionCode(String execptionCode) {
		this.execptionCode = execptionCode;
	}
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message The message to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return Returns the returnCode.
	 */
	public String getReturnCode() {
		return returnCode;
	}
	/**
	 * @param returnCode The returnCode to set.
	 */
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	/**
	 * @return Returns the sapReturnCode.
	 */
	public String getSapReturnCode() {
		return sapReturnCode;
	}
	/**
	 * @param sapReturnCode The sapReturnCode to set.
	 */
	public void setSapReturnCode(String sapReturnCode) {
		this.sapReturnCode = sapReturnCode;
	}
}
