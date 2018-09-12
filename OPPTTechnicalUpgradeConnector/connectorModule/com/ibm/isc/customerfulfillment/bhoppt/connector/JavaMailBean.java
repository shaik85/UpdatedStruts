/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector;

import java.io.File;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/** 
 * JavaMail Bean for sending mails
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
public class JavaMailBean implements java.io.Serializable {
	private String propertyFileName = null;
	private String toAddress = null;
	private String replyToAddress = null;
	private String CC = null;
	private String BCC = null;
	private String fromAddress = null;
	private String smtpServer = null;
	private String messageSubject = null;
	private String messageText = null;
	private String messageType = null;
	private Vector attachmentVector = null;
	private boolean printMessages = false;


	/**
	 * MailCommand constructor
	 *   This default constructor just creates an empty object.
	 *   all information will have to be added to the object.
	 */
	public JavaMailBean() {
	}
	
	/**
     * MailCommand constructor
     *   This constructor receives a property file name
     *   and loads the information in the property file
     *
     * @param thePropertyFileName 
     */
	public JavaMailBean(String thePropertyFileName) {
		super();
		setPropertyFileName(thePropertyFileName);
		initProperties();
	}
	
	/**
	 * Mail Command constructor
	 *   This constructor takes a subject and a text,
	 *   and assumes that a property file should be used,
	 *   and that the property file name is "JavaMailBean"
	 * 
	 * Creation date: (8/14/2001 11:00:52 AM)
	 * @param newMessageSubject java.lang.String
	 * @param newMessageText java.lang.String
	 */
	public JavaMailBean(String newMessageSubject, String newMessageText) {
		super();
		propertyFileName = "JavaMailBean";
		printMessages = true;
		initProperties();
		setMessageSubject(newMessageSubject);
		setMessageText(newMessageText);
	}
	
	/**
	 * Mail Command constructor
	 *   This constructor creates the object and fills in
	 *   the TO:, FROM:, Subject:, Message Text, and mail Host 
	 * Creation date: (8/14/2001 11:00:52 AM)
	 * @param newToAddress java.lang.String
	 * @param newFromAddress java.lang.String
	 * @param newMessageSubject java.lang.String
	 * @param newMessageText java.lang.String
	 * @param newSmtpServer java.lang.String
	 */
	public JavaMailBean(String newToAddress, String newFromAddress, String newMessageSubject, 
				String newMessageText, String newSmtpServer) {
		setToAddress(newToAddress);
		setFromAddress(newFromAddress);
		setMessageSubject(newMessageSubject);
		setMessageText(newMessageText);
		setSmtpServer(newSmtpServer);
	}
	
	/**
	* This method reads the to address, the from address, the message type,
	* and the smtp mail server from a properties file
	* Creation date: (8/14/2001 11:00:52 AM)
	*/
	private void initProperties() {
		PropertyResourceBundle mailProperties = null;
		try {
			mailProperties = (PropertyResourceBundle) PropertyResourceBundle.getBundle(getPropertyFileName());
			//initialize mail properties from file
			setToAddress(mailProperties.getString("ToAddress"));
			setFromAddress(mailProperties.getString("FromAddress"));
			setSmtpServer(mailProperties.getString("SmtpServer"));
			try {
				setMessageType(mailProperties.getString("MessageType"));
			} catch (Exception e) {
				// do nothing
			}
		} catch (Exception e) {
			// System.out.println("Exception in JavaMailBean.initProperties()" + e);
		}
	}


	/**
	 * The send() method is exactly like the execute() method, except that it doesn't throw an exception
	 */
	public void send() {
		try {
			execute();
		} catch (Exception e) {
		
		}
	}
	
	
	/**
     * The execute() veifies that you have supplied the proper fields (with setters) then sends the mail.
     * The required fields are to, from, host, subject, and message
     *
     * @throws java.lang.Exception 
     */
	public void execute() throws Exception {
		// System.out.println("Entering execute()");
		// System.out.println("Verifying you have enough information to send the mail");
		if (getToAddress() == null) {
			throw new Exception("You must specify the recipient (To:)");
		}
		if (getFromAddress() == null) {
			throw new Exception("You must specify the originator (From: or ReplyTo:)");
		}
		if (getSmtpServer() == null) {
			throw new Exception("You must specify the SMTP Server");
		}
		if (getMessageText() == null) {
			throw new Exception("You must specify the message text");
		}

		boolean debug = false;
		// System.out.println("Create some properties and get the default Session");
		Properties props = System.getProperties();
		props.put("mail.smtp.host", getSmtpServer());


		// System.out.println("Creating a session object");
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(debug);
		
		try {
				// System.out.println("Creating a message");
		 	MimeMessage msg = new MimeMessage(session);
						
			// To:  (This can take a comma delimited list of addresses)
			//msg.setRecipients(Message.RecipientType.TO, address);
			StringTokenizer toList = new StringTokenizer(getToAddress(), ",");
			while (toList.hasMoreElements()) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toList.nextToken()));
			}
			
			// add CC
			if (getCC() == null) {
				// do nothing
			} else {
				toList = new StringTokenizer(getCC(), ",");
				while (toList.hasMoreElements()) {
					msg.addRecipient(Message.RecipientType.CC, new InternetAddress(toList.nextToken()));
				}
			}
			
			// add BCC
			if (getBCC() == null) {
				// do nothing
			} else {
				toList = new StringTokenizer(getBCC(), ",");
				while (toList.hasMoreElements()) {
					msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(toList.nextToken()));
				}
			}
				
				// Reply to:  (this is an optional field) (this can take a comma delimited list)
			if (getReplyToAddress() == null) {
				// do nothing
			} else {
				//InternetAddress[] address2 = {new InternetAddress(getReplyToAddress())}; // Reply To:
				//msg.setReplyTo(address2);
				msg.setReplyTo(InternetAddress.parse(getReplyToAddress()));
			}

				// From:
			msg.setFrom(new InternetAddress(getFromAddress()));			// From:
			
			
			if (printMessages) {
				// System.out.println("FROM: "+getFromAddress());
				// System.out.println("TO: "+getToAddress());
			}

			
		    if (getMessageSubject() == null) {
		    	// do nothing
		    } else {
		    	msg.setSubject(getMessageSubject());   							// Subject:
		    }


		    // System.out.println("Create and fill the first message part");
		    MimeBodyPart mbp1 = new MimeBodyPart();
		    if (getMessageType() == null) {
		    	mbp1.setText(getMessageText());								//  messge
		    } else {
		    	mbp1.setContent(getMessageText(), getMessageType());		// message and message type
		    }
		    if (printMessages) {
		    	// System.out.println("MESSAGE: "+getMessageText());
		    }

		    // System.out.println("Create the Multipart and add its parts to it");
		    Multipart mp = new MimeMultipart();
		    mp.addBodyPart(mbp1);  // add the message
		    
		    // System.out.println("Taking care of attachments");
		    if (attachmentVector != null) {
				String fileName = null;
				MimeBodyPart mbp2 = null;
				FileDataSource fds = null;
				File fileObject = null;
				for (Enumeration e = getAttachmentVector().elements() ; e.hasMoreElements() ;) {
					fileName = (String)e.nextElement();
					// System.out.println("verify it is a valid file (it is an attachment)");
					try {
						fileObject = new File(fileName);
						if ( ! fileObject.exists()) {
							throw new Exception("The attachment: "+fileName+", does not exist.");
						}
						if ( ! fileObject.isFile()) {
							throw new Exception("The attachment: "+fileName+", is not a regular file.");
						}
						if ( ! fileObject.canRead()) {
							throw new Exception("The attachment: "+fileName+", cannot be read (possibly because of security)");
						}
					} catch (Throwable t) {
						throw new Exception("Problem referring to the attachment: "+fileName+" (The file probably doesn't exist)");
					}
					
					// create the second message part
					mbp2 = new MimeBodyPart();
					
					// System.out.println("Attach the file to the message");
					fds = new FileDataSource(fileName);
					mbp2.setDataHandler(new DataHandler(fds));
					mbp2.setFileName(fds.getName());
					mp.addBodyPart(mbp2);
				}
		    }


		//	 // system.out.println("Add the Multipart to the message");
		    msg.setContent(mp);


		//     // system.out.println("Set the Date: header");
		    msg.setSentDate(new Date());


		    // System.out.println("Send the message");
		    Transport.send(msg);
		    if (printMessages) {
		  //  	 // system.out.println("Message sent successfully...");
		    }


		    // System.out.println("Exiting execute()");
	    
		} catch (MessagingException mex) {
			// System.out.println("Unexpected exception sending mail:"+mex.getMessage());
		    throw new Exception(mex.getMessage());
		    //Exception ex = null;
		    //if ((ex = mex.getNextException()) != null) {
			//throw new new Exception(ex.getMessage());
		    //}
		}
	}
	
	/**
	 * getCC
	 * @return String
	 */
	public String getCC() { return CC; }
	
	/**
	 * setCC
	 * @param newCC
	 */
	public void setCC(String newCC) { CC = newCC; }
	/**
	 * getBCC
	 * @return String
	 */
	public String getBCC() { return BCC; }
	
	/**
	 * setBCC
	 * @param newBCC
	 */
	public void setBCC(String newBCC) { BCC = newBCC; }
	
	/**
	 * getFromAddress
	 * @return String
	 */
	public String getFromAddress() { return fromAddress; }
	
	/**
	 * setFromAddress
	 * @param newFromAddress
	 */
	public void setFromAddress(String newFromAddress) { fromAddress = newFromAddress; }
	
	/**
	 * getMessageType
	 * @return String
	 */
	public String getMessageType() { return messageType; }
	
	/**
	 * setMessageType
	 * @param newMessageType
	 */
	public void setMessageType(String newMessageType) { messageType = newMessageType; }
	
	/**
	 * getReplyToAddress
	 * @return String
	 */
	public String getReplyToAddress() { return replyToAddress; }
	/**
	 * setReplyToAddress
	 * @param newReplyToAddress
	 */
	public void setReplyToAddress(String newReplyToAddress) { replyToAddress = newReplyToAddress; }
	
	/**
	 * getSmtpServer
	 * @return String
	 */
	public String getSmtpServer() { return smtpServer; }
	/**
	 * setSmtpServer
	 * @param newSmtpServer
	 */
	public void setSmtpServer(String newSmtpServer) { smtpServer = newSmtpServer; }
	
	/**
	 * getMessageText
	 * @return String
	 */
	public String getMessageText() { return messageText; }
	/**
	 * setMessageText
	 * @param newMessageText
	 */
	public void setMessageText(String newMessageText) { messageText = newMessageText; }
	
	/**
	 * getMessageSubject
	 * @return String
	 */
	public String getMessageSubject() { return messageSubject; }
	/**
	 * setMessageSubject
	 * @param newMessageSubject
	 */
	public void setMessageSubject(String newMessageSubject) { messageSubject = newMessageSubject; }
	
	/**
	 * getToAddress
	 * @return String
	 */
	public String getToAddress() { return toAddress; }
	
	/**
	 * setToAddress
	 * @param newToAddress
	 */
	public void setToAddress(String newToAddress) { toAddress = newToAddress; }
	
	/**
	 * getPropertyFileName
	 * @return String
	 */
	public String getPropertyFileName() { return propertyFileName; }
	/**
	 * setPropertyFileName
	 * @param newPropertyFileName
	 */
	public void setPropertyFileName(String newPropertyFileName) { propertyFileName = newPropertyFileName; initProperties(); }
	
	/**
	 * isPrintMessages
	 * @return boolean
	 */
	public boolean isPrintMessages() { return printMessages; }
	/**
	 * setPrintMessages
	 * @param printTheMessages
	 */
	public void setPrintMessages(boolean printTheMessages) { printMessages = printTheMessages; }


	/**
	 * getAttachmentVector
	 * @return Vector
	 */
	public Vector getAttachmentVector() {
		if (attachmentVector == null) {
			attachmentVector = new Vector();
		}
		return attachmentVector;
	}
	/**
     * setAttachmentVector
     *
     * @param Vector
     * @param attachmentVector 
     */
	public void setAttachmentVector(Vector attachmentVector) { this.attachmentVector = attachmentVector; }
	
	/**
	 * addAttachment
	 * @param theAttachment java.lang.String
	 * 
	 */
	public void addAttachment(String theAttachment) {
		if (theAttachment != null) {
			getAttachmentVector().add(theAttachment);
		}
	}

	/**
	 * toString
	 *   Creates a String message  
	 * @return String
	 */
	public String toString() {
		String retString = "To:"+getToAddress();
		
		retString=retString+", From:"+getFromAddress();
				
		if (getReplyToAddress() == null) {
			retString=retString+", NO (optional) ReplyTo addresses";
		} else {
			retString=retString+", ReplyTo:"+getReplyToAddress();
		}

		if (getCC() == null) {
			retString=retString+", NO (optional) CC";
		} else {
			retString=retString+", CC:"+getCC();
		}
		
		if (getBCC() == null) {
			retString=retString+", NO (optional) BCC";
		} else {
			retString=retString+", BCC:"+getBCC();
		}
		
		retString = retString+", SMTPServer:"+getSmtpServer();
		
		if (getMessageSubject() == null) {
			retString=retString+", No (optional) Subject";
		} else {
			retString=retString+", Subject:"+getMessageSubject();
		}
		
		if (attachmentVector == null) {
			retString = retString+", NO (optional) Attachments";
		} else {
			retString = retString+", There are "+getAttachmentVector().size()+" attachments:";
			boolean firstTime = false;
			for (Enumeration e = getAttachmentVector().elements() ; e.hasMoreElements() ;) {
				if (firstTime) {
					retString = retString+" ";
				} else {
					retString = retString+", ";
				}
				retString = retString+(String)e.nextElement();
			}
		}
		if (getPropertyFileName() == null) {
			retString = retString+", NO (optional) property file";
		} else {
			retString = retString+", Property File: "+getPropertyFileName()+".properties";
		}
		retString = retString+", Message Type:"+getMessageType()+", Message:"+getMessageText();
		return retString;
	}


}



