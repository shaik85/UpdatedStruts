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

import java.util.ArrayList;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
/**
 * @author Bhanu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ValidateComplexDataOutputConnectorDTO implements ConnectorDTOInterface{
	
	
	private String returnCode;
	private String sapReturnCode;
	private String exeptionCode;
	private String errorMessage;
	private String ocpsID;
	private String contractType;
	private String blbIndicator;
	
	
	
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
	 * @return Returns the errorMessage.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage The errorMessage to set.
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return Returns the exeptionCode.
	 */
	public String getExeptionCode() {
		return exeptionCode;
	}
	/**
	 * @param exeptionCode The exeptionCode to set.
	 */
	public void setExeptionCode(String exeptionCode) {
		this.exeptionCode = exeptionCode;
	}
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
	public String getBlbIndicator() {
		return blbIndicator;
	}
	/**
	 * @param masterContractType The masterContractType to set.
	 */
	public void setBlbIndicator(String blbIndicator) {
		this.blbIndicator= blbIndicator;
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
	
}
