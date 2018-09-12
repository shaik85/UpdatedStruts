/*
 * Created on May 21, 2010
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
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FetchSelectedInventoryDTO extends OPPTCustomDTO{
	
	Map DesignatedMachineID=new HashMap();
	Map MaterialID=new HashMap();
	Map SerialNumber=new HashMap();

	/**
	 * @return Returns the designatedMachineID.
	 */
	public Map getDesignatedMachineID() {
		return DesignatedMachineID;
	}
	/**
	 * @param designatedMachineID The designatedMachineID to set.
	 */
	public void setDesignatedMachineID(Map designatedMachineID) {
		DesignatedMachineID = designatedMachineID;
	}
	/**
	 * @return Returns the materialID.
	 */
	public Map getMaterialID() {
		return MaterialID;
	}
	/**
	 * @param materialID The materialID to set.
	 */
	public void setMaterialID(Map materialID) {
		MaterialID = materialID;
	}
	/**
	 * @return Returns the serialNumber.
	 */
	public Map getSerialNumber() {
		return SerialNumber;
	}
	/**
	 * @param serialNumber The serialNumber to set.
	 */
	public void setSerialNumber(Map serialNumber) {
		SerialNumber = serialNumber;
	}
}
