/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * Mail connector for sending mails
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 5, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class MailConnector
{
	private static final String CLASS_NAME = "MailConnector"; /* NOI18N */
	private static final String DEFAULT_CONTENT_TYPE = "text/plain"; /* NOI18N */

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public MailConnector()
	{
	}
	/**
	 *  
	 * mailIt 
	 * 
	 * <br/><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param connectorDTO
	 * @throws ConnectorException
	 */
	private void mailIt(MailConnectorDTO connectorDTO) throws ConnectorException
	{
		String methodName = "mailIt";

		try
		{
			InitialContext context = new InitialContext();
			// Fix for Mail Session- GWA FIX BALAJI
			Session session = ServiceLocator.getJavaMailSessionFactory().getJavaMailSession();
			// Fix for Mail Session- GWA FIX BALAJI
			
			MimeMessage msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(connectorDTO.getFromAddress()));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(connectorDTO.getToAddress()));
			
			String address = connectorDTO.getCcAddress();
			if (null != address && 0 < address.trim().length())
			{
				msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(address));
			}
			
			address = connectorDTO.getBccAddress();
			if (null != address && 0 < address.trim().length())
			{
				msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(address));
			}
			
			msg.setSubject(connectorDTO.getSubject());
			msg.setText(connectorDTO.getMsgText());

			address = connectorDTO.getSendReplyTo();
			Address[] replyToAddress = new InternetAddress[1];
			
			if (null != address && 0 < address.trim().length())
			{
				replyToAddress[0] = new InternetAddress(address);
			}
			else
			{
				replyToAddress[0] = new InternetAddress(connectorDTO.getFromAddress());
			}
			
			msg.setReplyTo(replyToAddress);
			
			String inputMessage =
				OPPTHelper.getLogString(
					connectorDTO.getToAddress(),
					connectorDTO.getCcAddress(),
					connectorDTO.getBccAddress());

			OPPTLogger.log("MAIL_TO", OPPTLogger.INFO, CLASS_NAME, methodName, inputMessage);
			OPPTLogger.log("MAIL_SUBJECT", OPPTLogger.INFO, CLASS_NAME, methodName, connectorDTO.getSubject());
			OPPTLogger.log("MAIL_TEXT", OPPTLogger.INFO, CLASS_NAME, methodName, connectorDTO.getMsgText());
			
			Transport.send(msg);
		}
		catch (Exception e)
		{
			OPPTLogger.log("MAIL_EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);

			throw ExceptionGenerator.generateConnectorException(ErrorCodeConstants.SE0802);
		}

	}
	/**
	 *  
	 * sendMail 
	 * 
	 * <br/><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param connectorDTO
	 * @throws ConnectorException
	 * @return MailConnectorDTO
	 */
	public MailConnectorDTO sendMail(MailConnectorDTO connectorDTO) throws ConnectorException
	{
		if (true)
		{
			mailIt(connectorDTO);
			
			return connectorDTO;
		}
		
		String methodName = "sendMail";
		String sendReplyTo = null;
		String messageType = null;
		JavaMailBean mailBean =null;
		String inputMessage = null;
        mailBean = new JavaMailBean();

		mailBean.setFromAddress(connectorDTO.getFromAddress());
		mailBean.setToAddress(connectorDTO.getToAddress());
		mailBean.setCC(connectorDTO.getCcAddress());
		mailBean.setBCC(connectorDTO.getBccAddress());

		mailBean.setMessageSubject(connectorDTO.getSubject());
		mailBean.setMessageText(connectorDTO.getMsgText());

		sendReplyTo = connectorDTO.getSendReplyTo();

		if (null == sendReplyTo || 0 == sendReplyTo.trim().length())
		{
			mailBean.setReplyToAddress(connectorDTO.getToAddress());
		}
		else
		{
			mailBean.setReplyToAddress(sendReplyTo);
		}

	     messageType = mailBean.getMessageType();
		if (null == messageType || 0 == messageType.trim().length())
		{
			mailBean.setMessageType(DEFAULT_CONTENT_TYPE);
		}

		mailBean.setSmtpServer(OPPTPropertiesReader.getSMTPServer());

	    inputMessage =
			OPPTHelper.getLogString(
				connectorDTO.getToAddress(),
				connectorDTO.getCcAddress(),
				connectorDTO.getBccAddress());

		OPPTLogger.log("MAIL_TO", OPPTLogger.INFO, CLASS_NAME, methodName, inputMessage);
		OPPTLogger.log("MAIL_SUBJECT", OPPTLogger.INFO, CLASS_NAME, methodName, connectorDTO.getSubject());
		OPPTLogger.log("MAIL_TEXT", OPPTLogger.INFO, CLASS_NAME, methodName, connectorDTO.getMsgText());

		try
		{
			mailBean.execute();
		}
		catch (Exception e)
		{
			OPPTLogger.log("MAIL_EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);

			throw ExceptionGenerator.generateConnectorException(ErrorCodeConstants.SE0802);
		}

		return connectorDTO;
	}
}