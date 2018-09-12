/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * Organization Connector DTO 
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class OrgConnectorDTO implements ConnectorDTOInterface
{
	private String salesOrg;
	private String distributionChannel;
	private String salesGroup;
	private String channelRole;
	private String submitterRole;
	private String division;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */

	public OrgConnectorDTO()
	{

	}

	/** 
	 * To get the Distribution Channel
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
	 * @return String Distribution Channel 
	 */
	public String getDistributionChannel()
	{
		return distributionChannel;
	}

	/**
	 * @return the salesGroup
	 */
	public String getSalesGroup() {
		return salesGroup;
	}

	/**
	 * @return the channelRole
	 */
	public String getChannelRole() {
		return channelRole;
	}

	/**
	 * @return the submitterRole
	 */
	public String getSubmitterRole() {
		return submitterRole;
	}

	/**
	 * @param salesGroup the salesGroup to set
	 */
	public void setSalesGroup(String lSalesGroup) {
		this.salesGroup = lSalesGroup;
	}

	/**
	 * @param channelRole the channelRole to set
	 */
	public void setChannelRole(String lChannelRole) {
		this.channelRole = lChannelRole;
	}

	/**
	 * @param submitterRole the submitterRole to set
	 */
	public void setSubmitterRole(String lSubmitterRole) {
		this.submitterRole = lSubmitterRole;
	}

	/** 
	 * To get the Division
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
	 * @return String Division 
	 */
	public String getDivision()
	{
		return division;
	}

	/** 
	 * To get the Sales Organization
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
	 * @return String Sales Organization 
	 */
	public String getSalesOrg()
	{
		return salesOrg;
	}

	/** 
	 * To set the Distribution Channel
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
	 * @param ldistributionChannel 
	 */
	public void setDistributionChannel(String ldistributionChannel)
	{
		distributionChannel = ldistributionChannel;
	}

	/** 
	 * To set the division
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
	 * @param ldivision 
	 */
	public void setDivision(String ldivision)
	{
		division = ldivision;
	}

	/** 
	 * To set the sales organisation
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
	 * @param lsalesOrg 
	 */
	public void setSalesOrg(String lsalesOrg)
	{
		salesOrg =lsalesOrg;
	}
}
