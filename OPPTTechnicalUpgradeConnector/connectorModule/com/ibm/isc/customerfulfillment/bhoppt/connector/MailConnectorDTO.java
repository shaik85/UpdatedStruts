/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector;

import java.util.List;

/**
 * Mail connector dto
 *  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 2, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class MailConnectorDTO
{
	private String bccAddress;
	private List bccAddressIDList;

	private String ccAddress;
	private List ccAddressIDList;

	private String fromAddress;
	private String msgText;
	private String subject;

	private String toAddress;
	private String toAddressID;

	private String toFirstName;
	private String toLastName;

	private String sendReplyTo;
	
	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public MailConnectorDTO()
	{
	}


	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getBccAddress()
	{
		return bccAddress;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public List getCcAddressIDList()
	{
		return ccAddressIDList;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getCcAddress()
	{
		return ccAddress;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getFromAddress()
	{
		return fromAddress;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getMsgText()
	{
		return msgText;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSubject()
	{
		return subject;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getToAddressID()
	{
		return toAddressID;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getToAddress()
	{
		return toAddress;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getToFirstName()
	{
		return toFirstName;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getToLastName()
	{
		return toLastName;
	}

	

	/**
     * setBccAddress
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 2, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param list
     * @param address 
     */
	public void setBccAddress(String address)
	{
		bccAddress = address;
	}

	/** 
	 * 
	 * setCcAddressIDList
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setCcAddressIDList(List list)
	{
		ccAddressIDList = list;
	}

	/**
     * setCcAddress
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 2, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param list
     * @param address 
     */
	public void setCcAddress(String address)
	{
		ccAddress = address;
	}

	/** 
	 * 
	 * setFromAddress
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setFromAddress(String string)
	{
		fromAddress = string;
	}

	/** 
	 * 
	 * setMsgText
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setMsgText(String string)
	{
		msgText = string;
	}

	/** 
	 * 
	 * setSubject
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSubject(String string)
	{
		subject = string;
	}

	/**
     * setToAddressID
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 2, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param list
     * @param address 
     */
	public void setToAddressID(String address)
	{
		toAddressID = address;
	}

	/**
     * setToAddress
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 2, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param list
     * @param address 
     */
	public void setToAddress(String address)
	{
		toAddress = address;
	}

	/** 
	 * setToFirstName
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setToFirstName(String string)
	{
		toFirstName = string;
	}

	/** 
	 * 
	 * setToLastName
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setToLastName(String string)
	{
		toLastName = string;
	}

	/** 
	 * getSendReplyTo
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSendReplyTo()
	{
		return sendReplyTo;
	}

	/** 
	 * 
	 * setSendReplyTo
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSendReplyTo(String string)
	{
		sendReplyTo = string;
	}

	/** 
	 * 
	 * setSendReplyTo
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
    public List getBccAddressIDList() {
        return bccAddressIDList;
    }
	/** 
	 * 
	 * setBccAddressIDList
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lbccAddressIDList 
	 */
    public void setBccAddressIDList(List lbccAddressIDList) {
        bccAddressIDList = lbccAddressIDList;
    }
}
