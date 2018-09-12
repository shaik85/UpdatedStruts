/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * Validate user access input connector dto
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 18, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham K Mani
 * @version 5.1A
 */
public class ValidateUserAccessInputConnectorDTO implements ConnectorDTOInterface
{
	private String createdBy;
	private String proposalType;
	private String bTPNo;
	private String payerNo;
	private String shipToPartyNo;
	private List sapSoldToParty;

	private String functionModuleName;
	private String sessionID;
	private String userID;

	private OrgConnectorDTO orgConnectorDTO;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public ValidateUserAccessInputConnectorDTO()
	{
	}

	/** 
	 * To get the BTP No
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return bTPNo
	 */
	public String getBTPNo()
	{
		return bTPNo;
	}

	/** 
	 * To get the created by
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CreatedBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/** 
	 * To get the org connector dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return OrgConnectorDTO
	 */
	public OrgConnectorDTO getOrgConnectorDTO()
	{
		return orgConnectorDTO;
	}

	/** 
	 * To get the payer number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PayerNo
	 */
	public String getPayerNo()
	{
		return payerNo;
	}

	/** 
	 * To get the proposal type
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalType
	 */
	public String getProposalType()
	{
		return proposalType;
	}

	/** 
	 * To get the sap sold to party
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SapSoldToParty
	 */
	public List getSapSoldToParty()
	{
		return sapSoldToParty;
	}

	/** 
	 * To get the ship to party number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ShipToPartyNo
	 */
	public String getShipToPartyNo()
	{
		return shipToPartyNo;
	}

	/** 
	 * To set the btp number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lbtpNo 
	 */
	public void setBTPNo(String lbtpNo)
	{
		bTPNo = lbtpNo;
	}

	/** 
	 * To set the created by
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lcreatedBy 
	 */
	public void setCreatedBy(String lcreatedBy)
	{
		createdBy = lcreatedBy;
	}

	/** 
	 * To set the org connector dto
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
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

	/** 
	 * To set the payer number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lpayerNo
	 */
	public void setPayerNo(String lpayerNo)
	{
		payerNo = lpayerNo;
	}

	/** 
	 * To set the proposalType
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lproposalType
	 */
	public void setProposalType(String lproposalType)
	{
		proposalType = lproposalType;
	}

	/** 
	 * To set the sap sold to party
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sapSoldToPartyList
	 */
	public void setSapSoldToParty(List sapSoldToPartyList)
	{
		sapSoldToParty = sapSoldToPartyList;
	}

	/** 
	 * To set the ship to party number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lshipToPartyNo
	 */
	public void setShipToPartyNo(String lshipToPartyNo)
	{
		shipToPartyNo = lshipToPartyNo;
	}

	/** 
	 * To get the function module name
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
	 * @return 
	 */
	public String getFunctionModuleName()
	{
		return functionModuleName;
	}

	/** 
	 * To get the session ID
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
	 * @return String sessionID
	 */
	public String getSessionID()
	{
		return sessionID;
	}

	/** 
	 * To get the user ID
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
	 * @return String userID 
	 */
	public String getUserID()
	{
		return userID;
	}

	/** 
	 * To set the function module name 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lfunctionModuleName
	 */
	public void setFunctionModuleName(String lfunctionModuleName)
	{
		functionModuleName = lfunctionModuleName;
	}

	/** 
	 * To set the session ID
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
	 * @param String lSessionID
	 */
	public void setSessionID(String lsessionID)
	{
		sessionID = lsessionID;
	}

	/** 
	 * To set the user ID
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
	 * @param String luserID 
	 */
	public void setUserID(String luserID)
	{
		userID = luserID;
	}
}
