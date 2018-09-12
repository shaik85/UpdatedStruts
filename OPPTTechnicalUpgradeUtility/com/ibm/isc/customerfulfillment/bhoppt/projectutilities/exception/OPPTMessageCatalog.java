/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception;

import java.io.*;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;


/**
 * 
 * <p>All the error messages and corresponding information is stored in an XML file. At the start 
 * of the application. the XML file is parsed, and an OPPTMessageCatalog is created. An 
 * OPPTMessageCatalog has an ErrorEntry object mapped to a messageId.This file stores all the error
 * messages in five different HashMap based on their error type.</p>
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class OPPTMessageCatalog implements Serializable
{
	/**
	 *  
	 * Constructor 
	 * Private constructor to make the class Singleton.
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	private OPPTMessageCatalog() {
		super();
	}
	
	/**
	 * Static reference of the class.
	 */
	private static OPPTMessageCatalog cMessageCatalog = null;
	
	/**
	 * HashMap for storing error list of type "BackEnd".
	 */
	private HashMap  iBackEndErrorDetail = null; 
	
	/**
	 * HashMap for storing error list of type "Domain".
	 */
	private HashMap  iDomainErrorDetail = null; 
		
	/**
	 * HashMap for storing error list of type "Connector" .
	 */
	private HashMap  iConnectorErrorDetail = null; 
		
	/**
	 * HashMap for storing error list of type "Service" .
	 */
	private HashMap  iServiceErrorDetail = null; 
		
	/**
	 * HashMap for storing error list of type "Presentation" .
	 */
	private HashMap  iPresentationErrorDetail = null; 
	
	/**
	 * Constant to locate HashMap which stores error messages of type "BackEnd" 
	 */
	public static final int TYPE_BACKEND = 1;
	
	/**
	 * Constant to locate HashMap which stores error messages of type "Domain" 
	 */
	public static final int TYPE_DOMAIN = 2;
	
	/**
	 * Constant to locate HashMap which stores error messages of type "Service" 
	 */
	public static final int TYPE_SERVICE = 3;
	
	/**
	 * Constant to locate HashMap which stores error messages of type "Connector" 
	 */
	public static final int TYPE_CONNECTOR = 4;
	
	/**
	 * Constant to locate HashMap which stores error messages of type "Presentation" 
	 */
	public static final int TYPE_PRESENTATION = 5;
	
	
	
	/**
	 *<b> This method checks if there is any OPPTMessageCatalog instances already created. If created 
	 * it returns the same object, if not created it creates a new OPPTMessageCatalog instance and
	 * returns the same. (This follows Singleton pattern)<b>
	 * 
	 * <b> It calls method populateMessageCatelogFromXML() to parse the XML file and populate the data
	 * in local HashMap.<b>
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br>   
	 * 
	 * @return OPPTMessageCatalog
	 */
	public static OPPTMessageCatalog getInstance() {
		if(cMessageCatalog == null) {
			cMessageCatalog = new OPPTMessageCatalog();
			cMessageCatalog.populateMessageCatelogFromXML();
		}
		return cMessageCatalog;
	}
	
	/**
	 * Populates the ErrorEntry's for the errorKeys in the ErrorReport
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorReport ErrorReport object.
	 */
	public void populateErrorReport(ErrorReport errorReport) {
		if(errorReport != null){
			Iterator errorKeys = errorReport.keySet().iterator();
			while(errorKeys.hasNext()){
				ErrorKey errorKey = (ErrorKey)errorKeys.next();
				ErrorEntry errorEntry = (ErrorEntry)errorReport.get(errorKey);
				if(null == errorEntry){
					errorEntry = getErrorEntry(errorKey);
				}
				else{
					errorEntry = getErrorEntry(errorKey, errorEntry);
				}
				
				if(null != errorEntry){
					errorReport.put(errorKey, errorEntry);
				}
				else{
					errorReport.remove(errorKey);
				}
			}
		}
	}
	/**
	 *  
	 * Creates ErrorEntry object for given ErrorKey and returns.
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
	 * @param errorKey
	 * @return ErrorEntry
	 */
	private ErrorEntry getErrorEntry(ErrorKey errorKey){
		ErrorEntry errorEntry = null;
		String errorId = errorKey.getErrorId();
		if(null != errorId){
			int errorType = errorKey.getErrorType();
			HashMap errorEntryDetail = getHashMap(errorType);
			if(null != errorEntryDetail){
				errorEntry = (ErrorEntry)errorEntryDetail.get(errorId);
			}
		}
		return errorEntry;
	}

	private ErrorEntry getErrorEntry(ErrorKey errorKey, ErrorEntry errorEntry){
		if(null != errorKey){
			String errorId = errorKey.getErrorId();
			if(null != errorId ){
				int errorType = errorKey.getErrorType();
	
				HashMap errorEntryDetail = getHashMap(errorType);
				if(null != errorEntryDetail){
					ErrorEntry localErrorEntry = (ErrorEntry)errorEntryDetail.get(errorId);
					if(null != localErrorEntry){
						errorEntry.setMessageInputCount(localErrorEntry.getMessageInputCount());
						errorEntry.setFieldNames(localErrorEntry.getFieldNames());
						String messageInputs[] = errorEntry.getMessageInputs();

						if(null != messageInputs){
							int size = messageInputs.length;
							if(size == errorEntry.getMessageInputCount()){
								PreparedString prepareString = new PreparedString(localErrorEntry.getErrorMessage());
								for(int i=1; i<=size; i++){
									prepareString.setString(i, messageInputs[i-1]);
								}
								errorEntry.setErrorMessage(prepareString.toString());
							}
							else{
								errorEntry.setErrorMessage(localErrorEntry.getErrorMessage());
							}
						}
						else{
							errorEntry.setErrorMessage(localErrorEntry.getErrorMessage());
						}
					}
				}
			}
		}
		return errorEntry;
	}
	
	/**
	 *  
	 * Finds the HashMap for a given constant value and returns.
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
	 * @param errorType
	 * @return HashMap
	 */
	private HashMap getHashMap(int errorType){
		HashMap errorDetailMap = null;
		switch (errorType){
			case 1:
				errorDetailMap = iBackEndErrorDetail;
				break;
			case 2:
				errorDetailMap = iDomainErrorDetail;
				break;
			case 3:
				errorDetailMap = iServiceErrorDetail;
				break;
			case 4:
				errorDetailMap = iConnectorErrorDetail;
				break;
			case 5:
				errorDetailMap = iPresentationErrorDetail;			
		    default :
                break;
        }
		return errorDetailMap;
	}
	
	/**
	 *  
	 * Calls parser to parse the XML file and calls different methods to populate
	 * the data in different HashMap based on ErrorType.
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
	 *
	 */
	private void populateMessageCatelogFromXML(){
		ArrayList nodeArray = null;
		NodeList childNodes = null;
		InputStream xmlInputStream = null;
		
		iBackEndErrorDetail = new HashMap();
		iDomainErrorDetail = new HashMap();
		iConnectorErrorDetail = new HashMap();
		iServiceErrorDetail = new HashMap();
		iPresentationErrorDetail = new HashMap();

		try{
			xmlInputStream = new FileInputStream(new File(OPPTPropertiesReader.getMessageCatalogFile()));
			System.out
					.println("OPPTMessageCatalog.populateMessageCatelogFromXML()"+OPPTPropertiesReader.getMessageCatalogFile());
			
			Node configFileNode = OPPTParser.getBaseNode(xmlInputStream);
			childNodes = OPPTParser.getChildNodeList(configFileNode);
			nodeArray = OPPTParser.getNodeWithAttributeFromNodeList(childNodes, "messageType","type","BackEnd");  /* NOI18N */  /* NOI18N */  /* NOI18N */
			populateCache(nodeArray, iBackEndErrorDetail);
			
			nodeArray = OPPTParser.getNodeWithAttributeFromNodeList(childNodes, "messageType","type","Domain");  /* NOI18N */  /* NOI18N */  /* NOI18N */
			populateCache(nodeArray, iDomainErrorDetail);
					
			nodeArray = OPPTParser.getNodeWithAttributeFromNodeList(childNodes, "messageType","type","Connector");  /* NOI18N */  /* NOI18N */  /* NOI18N */
			populateCache(nodeArray, iConnectorErrorDetail);
					
			nodeArray = OPPTParser.getNodeWithAttributeFromNodeList(childNodes, "messageType","type","Service");  /* NOI18N */  /* NOI18N */  /* NOI18N */
			populateCache(nodeArray, iServiceErrorDetail);
					
			nodeArray = OPPTParser.getNodeWithAttributeFromNodeList(childNodes, "messageType","type","Presentation");  /* NOI18N */  /* NOI18N */  /* NOI18N */
			populateCache(nodeArray, iPresentationErrorDetail);
		}
		catch(ParserConfigurationException nme){
		// We do not handle this exception
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"OPPTMessageCatalog","populateMessageCatelogFromXML",null,nme);  /* NOI18N */  /* NOI18N */  /* NOI18N */
		}
		catch(SAXException nme){
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"OPPTMessageCatalog","populateMessageCatelogFromXML",null,nme);  /* NOI18N */  /* NOI18N */  /* NOI18N */
		}
		catch(IOException nme){
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"OPPTMessageCatalog","populateMessageCatelogFromXML",null,nme);  /* NOI18N */  /* NOI18N */  /* NOI18N */
		}
	}
	
	/**
	 *  
	 * 
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
	 * @param nodeArray
	 * @param cacheMap
	 */
	private void populateCache(ArrayList nodeArray, HashMap cacheMap){
		
		Node messageNode = null;
		String messageId = null;
		String[] fieldValues = null;
		String errorMessage = null;
		int messageInputCount = -1;
		ErrorEntry errorEntry = null;
		
		if(null != nodeArray){
			Node typeNode = (Node)nodeArray.get(0);
			ArrayList messageNodeList = OPPTParser.getChildElements(typeNode);
			
			int listCount = messageNodeList.size();
			
			for(int i=0; i < listCount; i++){
				messageNode = (Node)messageNodeList.get(i);
				messageId = OPPTParser.getAttributeValue(messageNode, "id");  /* NOI18N */
				fieldValues = populateFields(messageNode);
				errorMessage = populateErrorMessage(messageNode);
				messageInputCount = populateMessageInputCount(messageNode);
				errorEntry = new ErrorEntry(errorMessage,fieldValues, messageInputCount);
				cacheMap.put(messageId,errorEntry);
			}
		}
	}
	
	/**
	 *  
	 * Retrieves field values from XML file for given node and packs it in String array 
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
	 * @param messageNode
	 * @return String[]
	 */
	private String[] populateFields(Node messageNode){
		String[] fieldValues = null;
		
		Node inputFiledNode = OPPTParser.getNodeFromNodeList(OPPTParser.getChildNodeList(messageNode),"inputFields");  /* NOI18N */
		ArrayList fieldNodes = OPPTParser.getNodeListFromNodeList(OPPTParser.getChildNodeList(inputFiledNode), "fieldName");  /* NOI18N */

		if(null != fieldNodes){
			fieldValues = new String[fieldNodes.size()];
			for(int i=0; i < fieldValues.length; i++){
				fieldValues[i] = OPPTParser.getValue((Node)fieldNodes.get(i));
			}
		}
		return fieldValues;
	}
	
	/**
	 *  
	 * Returns error message for the given node
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
	 * @param messageNode
	 * @return
	 */
	private String populateErrorMessage(Node messageNode){
		String errorMessage = "";  /* NOI18N */
		Node errorDetalNode = OPPTParser.getNodeFromNodeList(OPPTParser.getChildNodeList(messageNode),"value");  /* NOI18N */
		errorMessage = OPPTParser.getValue(errorDetalNode);
		return errorMessage;
	}

	private int populateMessageInputCount(Node messageNode){
		int messageInputCount = -1;
		Node errorDetalNode = OPPTParser.getNodeFromNodeList(OPPTParser.getChildNodeList(messageNode),"inputValueCount");  /* NOI18N */
		try{
			messageInputCount = Integer.parseInt(OPPTParser.getValue(errorDetalNode));
		}
		catch(Exception e){
			// Exception thrown when the input value count is other than integer value. 
		}
		return messageInputCount;
	}
}
