/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/** 
 * RFC DTO for change the old contract status and creating a new contract
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 12, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Arun Nagarajan
 * @version 5.1A 
 */
public class ChangeCreateContractInputConnectorDTO implements ConnectorDTOInterface{

	private ChangeContractInputConnectorDTO changeContractDTO;
	private CreateContractInputConnectorDTO createContractDTO;

	/** 
	 * Constructor 
	 *  
	 * <br/><PRE> 
	 * date Mar 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public ChangeCreateContractInputConnectorDTO() {
	}

	/** 
	 * Returns the Change Contract DTO 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ChangeContractInputConnectorDTO
	 */
	public ChangeContractInputConnectorDTO getChangeContractDTO() {
		return changeContractDTO;
	}

	/** 
	 * Returns create contract DTO 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CreateContractInputConnectorDTO
	 */
	public CreateContractInputConnectorDTO getCreateContractDTO() {
		return createContractDTO;
	}

	/** 
	 * Sets the Change Contract DTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param connectorDTO 
	 */
	public void setChangeContractDTO(ChangeContractInputConnectorDTO connectorDTO) {
		changeContractDTO = connectorDTO;
	}

	/** 
	 * Sets Create Contract DTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param connectorDTO 
	 */
	public void setCreateContractDTO(CreateContractInputConnectorDTO connectorDTO) {
		createContractDTO = connectorDTO;
	}

}
