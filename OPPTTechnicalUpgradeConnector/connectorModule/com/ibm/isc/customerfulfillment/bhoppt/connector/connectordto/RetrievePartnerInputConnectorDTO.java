/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 *  RetrievePartnerInputConnectorDTO
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class RetrievePartnerInputConnectorDTO implements ConnectorDTOInterface
{
	private String legacyNo;
	/**
	 * @return Returns the customerNumber.
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}
	/**
	 * @param customerNumber The customerNumber to set.
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	private String customerNumber = null;
	private String addressSequenceNo;
	private String countryCode; //EF0607044559
	private OrgConnectorDTO orgConnectorDTO;
	private GenericConnectorDTO genericConnectorDTO;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public RetrievePartnerInputConnectorDTO()
	{
	}
	
	/** 
	 * To get the address sequence number 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return address sequence number
	 */
	public String getAddressSequenceNo()
	{
		return addressSequenceNo;
	}

	/** 
	 * To get the generic connector dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return generic connector dto
	 */
	public GenericConnectorDTO getGenericConnectorDTO()
	{
		return genericConnectorDTO;
	}

	/** 
	 * To get the legacy number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return legacy number
	 */
	public String getLegacyNo()
	{
		return legacyNo;
	}
	
	/** 
	 * To get the country code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date June 16, 2004 
	 * 
	 * revision date author reason 
	 * Added for EF0607044559 by Sara
	 * </PRE><br> 
	 * 
	 * @return country code
	 */
	public String getCountryCode()
	{
		return countryCode;
	}

	/** 
	 * To get the org connector dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return org connector dto 
	 */
	public OrgConnectorDTO getOrgConnectorDTO()
	{
		return orgConnectorDTO;
	}

	/** 
	 * To set the address sequence number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param laddressSequenceNo 
	 */
	public void setAddressSequenceNo(String laddressSequenceNo)
	{
		addressSequenceNo = laddressSequenceNo;
	}

	/** 
	 * To set the generic connector dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param connectorDTO 
	 */
	public void setGenericConnectorDTO(GenericConnectorDTO connectorDTO)
	{
		genericConnectorDTO = connectorDTO;
	}

	/** 
	 * To set the legacy number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param llegacyNo 
	 */
	public void setLegacyNo(String llegacyNo)
	{
		legacyNo = llegacyNo;
	}
	
	/** 
	 * To set the country code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date June 16, 2004 
	 * Added for EF0607044559 by Sara 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lcountryCode 
	 */
	public void setCountryCode(String lcountryCode)
	{
		countryCode = lcountryCode;
	}

	/** 
	 * To set the org connector dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param connectorDTO 
	 */
	public void setOrgConnectorDTO(OrgConnectorDTO connectorDTO)
	{
		orgConnectorDTO = connectorDTO;
	}
}
