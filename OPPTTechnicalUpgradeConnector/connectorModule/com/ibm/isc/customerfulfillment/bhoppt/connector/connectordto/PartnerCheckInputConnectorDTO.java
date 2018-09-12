/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 *  PartnerCheckInputConnectorDTO
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
public class PartnerCheckInputConnectorDTO implements ConnectorDTOInterface
{
	private String partnerType;
	private String partnerLegacyNumber;
	private String partnerAddressSequenceNumber;
	private String financingContractFlag;
	private OrgConnectorDTO orgConnectorDTO;
	private GenericConnectorDTO genericConnectorDTO;
	private String countryCode; //EF0607044559

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
	public PartnerCheckInputConnectorDTO()
	{
	}

	/** 
	 * To get the financing contract flag
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
	 * @return financing contract flag 
	 */
	public String getFinancingContractFlag()
	{
		return financingContractFlag;
	}

	/** 
	 * To get the partner address sequence number
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
	 * @return address sequence number
	 */
	public String getPartnerAddressSequenceNumber()
	{
		return partnerAddressSequenceNumber;
	}

	/** 
	 * To get the partner legacy number
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
	 * @return partner legacy number
	 */
	public String getPartnerLegacyNumber()
	{
		return partnerLegacyNumber;
	}
	
	/** 
	 * To get the country code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date June 16, 2004 
	 * Added for EF0607044559 by Sara
	 *  
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return country code
	 */
	public String getCountryCode()
	{
		return countryCode;
	}	

	/** 
	 * To get the partner type
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
	 * @return partner type
	 */
	public String getPartnerType()
	{
		return partnerType;
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
     * To set the financing contract flag
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 4, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param financingContractFlag
     * @param lfinancingContractFlag 
     */
	public void setFinancingContractFlag(String lfinancingContractFlag)
	{
		financingContractFlag = lfinancingContractFlag;
	}

	/**
     * To set the partner address sequence number
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 4, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param partnerAddressSequenceNumber
     * @param lpartnerAddressSequenceNumber 
     */
	public void setPartnerAddressSequenceNumber(String lpartnerAddressSequenceNumber)
	{
		partnerAddressSequenceNumber = lpartnerAddressSequenceNumber;
	}

	/**
     * To set the partner legacy number
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 4, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param partnerLegacyNumber
     * @param lpartnerLegacyNumber 
     */
	public void setPartnerLegacyNumber(String lpartnerLegacyNumber)
	{
		partnerLegacyNumber = lpartnerLegacyNumber;
	}
	
	/**
     * To set the country code
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date June 16, 2004
     * Added for EF0607044559 by Sara
     * revision date author reason
     * </PRE><br>
     *
     * @param countryCode
     * @param lcountryCode 
     */
	public void setCountryCode(String lcountryCode)
	{
		countryCode = lcountryCode;
	}	

	/**
     * To set the partner type
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 4, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param partnerType
     * @param lpartnerType 
     */
	public void setPartnerType(String lpartnerType)
	{
		partnerType = lpartnerType;
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
