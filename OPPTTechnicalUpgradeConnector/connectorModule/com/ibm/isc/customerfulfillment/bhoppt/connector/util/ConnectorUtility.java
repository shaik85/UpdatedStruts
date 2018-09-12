/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.InputConnectorDTOSerializerInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.OutputConnectorDTODeserializerInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.test.TestConnectorDTOs;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTParser;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * This class serves the repeated functionality of the ConnectorDTO's.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class ConnectorUtility
{
	private static final String CLASS_NAME = "ConnectorUtility"; /* NOI18N */
	
	private static Map cClassMapCollection = new HashMap();
	private static Properties cProperties = null;

	private static final String OPPT_MAPPER_FILE = "OPPTConnectorMapper.xml"; /* NOI18N */
	private static final String RFC_OUTPUT_FILE = "RFCOutputs.properties"; /* NOI18N */

	
	static {
		populateMap();
	}

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	private ConnectorUtility()
	{
	}

	/**
	 * Returns the instance of a class for the given ID. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id
	 * @return Object
	 * @throws Exception
	 */
	public static Object getObject(String id) throws Exception
	{
		String className = (String) cClassMapCollection.get(id);

		if (className == null)
		{
			StringBuffer buffer = new StringBuffer();
			buffer.append("DTO ID ["); //$NON-NLS-1$
			buffer.append(id);
			buffer.append("] is not found in the XML Configuration.  Check your XML configuration for the given DTO ID"); //$NON-NLS-1$

			throw new Exception(buffer.toString());
		}

		return getObjectForName(className);
	}

	/**
	 * To get the object for the given RFC 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br>
	 * 
	 * @param rfcName
	 * @param isInputConnector
	 * @return Object
	 * @exception Exception
	 */
	public static Object getObjectByRFCName(String rfcName, boolean isInputConnector) throws Exception
	{
		String key = (String) cClassMapCollection.get(getKeyFor(rfcName, isInputConnector));

		return getObject(getKeyFor(key, isInputConnector));
	}

	private static String getKeyFor(String key, boolean isInputConnector)
	{
		StringBuffer buffer = new StringBuffer(key);

		return (isInputConnector)
			? buffer.append(ConnectorConstants.SERIALZIER).toString()
			: buffer.append(ConnectorConstants.DESERIALZIER).toString();
	}

	/**
	 * To load the class for the given string class name.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param className
	 * @return instance of the class
	 * @throws Exception
	 */
	public static Object getObjectForName(String className) throws Exception
	{
		return Class.forName(className).newInstance();
	}

	/**
	 * To get the time object for the given time string  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param timeString
	 * @return Time
	 */
	public static Time getTime(String timeString)
	{
		Time time = null;

		if (timeString != null && timeString.trim().length() > 5)
		{
			timeString =
				timeString.substring(0, 2)
					+ ConnectorConstants.TIME_DELIMITER
					+ timeString.substring(2, 4)
					+ ConnectorConstants.TIME_DELIMITER
					+ timeString.substring(4);
			time = Time.valueOf(timeString);
		}

		return time;
	}

	/**
	 *  
	 * To get the date from the given SAP format date string
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dateString
	 * @return Date
	 */
	public static Date getDate(String dateString)
	{
		Date date = null;

		if (dateString != null && dateString.trim().length() > 7 && 
		    (!dateString.trim().equals(ConnectorConstants.DEFAULT_DATE)))
		{
			dateString =
				dateString.substring(0, 4)
					+ ConnectorConstants.DATE_DELIMITER
					+ dateString.substring(4, 6)
					+ ConnectorConstants.DATE_DELIMITER
					+ dateString.substring(6);
			date = Date.valueOf(dateString);
		}

		return date;
	}

	/**
	 * Populate the local map in order to serve the value for every request.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 */
	private static void populateMap()
	{
		try
		{
			String filename = OPPTPropertiesReader.getConnectorConfigurationFile();

			Node rootNode = OPPTParser.getBaseNode(new File(filename));

			NodeList list = rootNode.getChildNodes();
			String name;

			for (int i = 0; i < list.getLength(); i++)
			{
				Node node = list.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					name = node.getNodeName();
					if (name.equalsIgnoreCase(ConnectorConstants.DATA_TRANSFER_OBJECT))
					{
						buildCollection(node, false);
					}
					else if (name.equalsIgnoreCase(ConnectorConstants.REMOTE_FUNCTION_CALL))
					{
						buildCollection(node, true);
					}
				}
			}
		}
		catch (Exception err)
		{
			// log and create a empty collection
			cClassMapCollection.clear();

			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "popuplateMap", null, err);
		}
	}

	/**
	 * To build the collection based whether the node type is RFC or ConnectorDTO  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param node
	 * @param isRFC
	 */
	private static void buildCollection(Node node, boolean isRFC)
	{
		Node childNode;
		String name;

		if (node.hasChildNodes())
		{
			NodeList list = node.getChildNodes();

			int size = list.getLength();

			String nodeID = null;

			if (isRFC)
			{
				nodeID = node.getAttributes().getNamedItem(ConnectorConstants.NAME).getNodeValue();
			}
			else
			{
				nodeID = node.getAttributes().getNamedItem(ConnectorConstants.ID).getNodeValue();
			}

			for (int count = 0; count < size; count++)
			{
				childNode = list.item(count);

				if (childNode.getNodeType() == Node.ELEMENT_NODE)
				{
					name = childNode.getNodeName();

					if (isRFC)
					{
						String referenceID =
							childNode.getAttributes().getNamedItem(ConnectorConstants.ID).getNodeValue();

						StringBuffer buffer = new StringBuffer();
						buffer.append(nodeID);

						if (name.equalsIgnoreCase(ConnectorConstants.INPUT_DTO))
						{
							buffer.append(ConnectorConstants.SERIALZIER);
						}
						else if (name.equalsIgnoreCase(ConnectorConstants.OUTPUT_DTO))
						{
							buffer.append(ConnectorConstants.DESERIALZIER);
						}

						cClassMapCollection.put(buffer.toString(), referenceID);
					}
					else
					{
						if (childNode.getChildNodes().getLength() > 0)
						{
							StringBuffer buffer = new StringBuffer();
							buffer.append(nodeID);
							buffer.append(childNode.getNodeName());
							cClassMapCollection.put(
								buffer.toString(),
								childNode.getChildNodes().item(0).getNodeValue());
						}
					}
				}
			}
		}
	}

	/** 
	 * To get the object name.  The package name will be ignored and 
	 * will get the exact name of the object
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param name
	 * @return exact name of the object without package
	 */
	public static String getObjectName(String name)
	{
		int index = name.lastIndexOf(ConnectorConstants.PACKAGE_SEPARATOR);
		if (index > -1)
		{
			name = name.substring(index + 1);
		}

		return name;
	}

	/**
	 * To get the corresponding object for the given name  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param name
	 * @return object for the given name
	 * @throws Exception
	 */
	public static OutputConnectorDTODeserializerInterface getOutputConnectorDeserializer(String name)
		throws Exception
	{
		return (OutputConnectorDTODeserializerInterface) getObject(
			getObjectName(name) + ConnectorConstants.DESERIALZIER);
	}

	/**
	 * To get the corresponding object for the given name  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param name
	 * @return object for the given name
	 * @throws Exception
	 */
	public static InputConnectorDTOSerializerInterface getInputConnectorSerializer(String name) throws Exception
	{
		return (InputConnectorDTOSerializerInterface) getObject(
			getObjectName(name) + ConnectorConstants.SERIALZIER);
	}

	/**
	 * Return a string for the given date on the given format.
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 27, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @param format
	 * @return String date with the given format
	 */
	public static String getDateByFormat(java.util.Date date, String format)
	{
		SimpleDateFormat formatter;

		if (date == null || format == null)
		{
			return null;
		}

		formatter = new SimpleDateFormat(format);

		return formatter.format(date);
	}

	/**
	 * Builds the message for the given DTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dto
	 * @param buffer
	 * @throws java.lang.Exception
	 */
	public static void buildMessage(ConnectorDTOInterface dto, StringBuffer buffer) throws Exception
	{
		InputConnectorDTOSerializerInterface inputConnectorSerializer =
			getInputConnectorSerializer(dto.getClass().getName());
		buffer.append(inputConnectorSerializer.createNewMsg(dto));
	}

	/**
	 * Populates the buffer with the given value 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param buffer
	 * @param value
	 */
	public static void buildMessage(String value, StringBuffer buffer)
	{
		buffer.append((value == null ? "" : value.trim())); //$NON-NLS-1$
		buffer.append(ConnectorConstants.CONNECTOR_STRING_DELIMITOR);
	}

	/**
	 * To get the ESW String for non-decimal allowed double 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param num
	 * @return String
	 */
	public static String getESWStringFor(double num)
	{
		return Integer.toString((int)num);
	}
	
	/**
	 * Test bed implementation
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br>
	 * 
	 * @param aRFCName
	 * @return String 
	 */
	public static String getOutputForRFC(String aRFCName)
	{
		if (cProperties == null)
		{
			loadProperties();
		}

		return cProperties.getProperty(aRFCName);
	}
	/**
	 * loadProperties()
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * revision date author reason 
	 * </PRE><br>
	 */

	private static void loadProperties()
	{
		cProperties = new Properties();
		InputStream stream = TestConnectorDTOs.class.getResourceAsStream(RFC_OUTPUT_FILE);

		try
		{
			if (stream != null)
			{
				cProperties.load(stream);
			}
		}
		catch (IOException e)
		{
			OPPTLogger.debug("Unable to load properties", "ConnectorUtility", "loadProperties"); //$NON-NLS-1$
		}
		finally
		{
			if (stream != null)
			{
				try
				{
					stream.close();
				}
				catch (IOException e)
				{
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "loadProperties", null, e);
				}
			}
		}
	}
}
