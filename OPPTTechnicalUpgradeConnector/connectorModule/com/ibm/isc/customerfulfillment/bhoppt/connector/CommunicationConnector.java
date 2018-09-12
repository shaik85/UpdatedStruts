/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector;

import java.util.Iterator;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException;

/** 
 * Communication connector used to communicate with external
 * Systems
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason
 * Balaji Replaced WebIdentityConnector with UsetProfileConnector 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class CommunicationConnector
{
	private static final String ADDRESS_SEPARATOR = ", "; /* NOI18N */

	private static final int TO_ADDRESS = 1;
	private static final int CC_ADDRESS = 2;
	private static final int BCC_ADDRESS = 3;
	/**
     * authenticate
     * <br/><PRE>
     * date Jan 2, 2004
     * revision date author reason
     * </PRE><br/>
     *
     * @see com.ibm.isc.customerfulfillment.bhoppt.connector.webidentity.ConnectionPool#checkOut()
     * @param connectorDTO
     * @return UserProfileConnectorDTO
     * @throws com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException 
     */
	public UserProfileConnectorDTO authenticate(UserProfileConnectorDTO connectorDTO) throws ConnectorException
	{
		UserProfileConnector wi = new UserProfileConnector();
		connectorDTO = wi.getProfile(connectorDTO);

		return connectorDTO;
	}
	/** 
	 * sendMail
	 * 
	 * <br/><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.connector.webidentity.ConnectionPool#checkOut() 
	 * @param mailConnectorDTO
	 * @return MailConnectorDTO
	 * @throws ConnectorException
     */
	public MailConnectorDTO sendMail(MailConnectorDTO mailConnectorDTO) throws ConnectorException
	{
		//mailConnectorDTO.setCcAddress("");
		//mailConnectorDTO.setBccAddress("");

		populateMailAddressFor(mailConnectorDTO.getToAddressID(), mailConnectorDTO, TO_ADDRESS);
		populateMailAddressFor(mailConnectorDTO.getCcAddressIDList(), mailConnectorDTO, CC_ADDRESS);
		populateMailAddressFor(mailConnectorDTO.getBccAddressIDList(), mailConnectorDTO, BCC_ADDRESS);

		MailConnector mailConnector = new MailConnector();
		mailConnectorDTO = mailConnector.sendMail(mailConnectorDTO);

		return mailConnectorDTO;
	}

	/** 
	 * 
	 * populateMailAddress
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list
	 * @param mailConnectorDTO 
	 * @param choice
	 */
	private void populateMailAddressFor(List list, MailConnectorDTO mailConnectorDTO, int choice)
		throws ConnectorException
	{
		if (list != null)
		{
			Iterator iter = list.iterator();

			while (iter.hasNext())
			{
				populateMailAddressFor((String) iter.next(), mailConnectorDTO, choice);
			}
		}
	}

	/** 
	 * populateMailAddressFor
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string
	 * @param mailConnectorDTO 
	 * @param choice
	 */
	private void populateMailAddressFor(String userID, MailConnectorDTO mailConnectorDTO, int choice)
		throws ConnectorException
	{
		UserProfileConnectorDTO dto = new UserProfileConnectorDTO();
		dto.setUserID(userID);

		dto = authenticate(dto);

		switch (choice)
		{
			case TO_ADDRESS :
				mailConnectorDTO.setToAddress(dto.getEmailAddress());
				break;

			case CC_ADDRESS :
				mailConnectorDTO.setCcAddress(
					getAppendAddress(mailConnectorDTO.getCcAddress(), dto.getEmailAddress()));
				break;

			case BCC_ADDRESS :
			default :
				mailConnectorDTO.setBccAddress(
					getAppendAddress(mailConnectorDTO.getBccAddress(), dto.getEmailAddress()));
		}
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param address
	 * @return 
	 */
	private String getAppendAddress(String address, String newAddress)
	{

		if (address == null)
		{
			address = "";
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append(address);

		if (newAddress != null)
		{
			if (address.trim().length() > 0)
			{
				buffer.append(ADDRESS_SEPARATOR);
			}
			buffer.append(newAddress);
		}

		return buffer.toString();
	}
	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param args
	 * @throws ConnectorException
	 */
	public static void main(String[] args) throws ConnectorException
	{
		CommunicationConnector c = new CommunicationConnector();
		UserProfileConnectorDTO connectorDTO = new UserProfileConnectorDTO();
		connectorDTO.setUserID("muruga");

		
	}
}
