/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/** 
 * This class provides methods for parsing XML file. All the methods are static
 * so that methods can be accessed without instanciating the class.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A 
 */
public class OPPTParser {
	
	/**
     * Parses a XML file and returns the root/base node. It takes File object
     * of the XML file that is to be parsed.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param xmlFile File
     * @return Node
     * @throws java.io.IOException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException 
     */
	public static Node getBaseNode(File xmlFile) throws ParserConfigurationException, SAXException, IOException
	{
		Document xmlDoc = null;
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		xmlDoc = documentBuilder.parse(xmlFile);
		
		return xmlDoc.getDocumentElement();
	}
	
	/**
     * Parses a XML file and returns the root/base node. It takes InputStream
     * of the XML file that is to be parsed.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param xmlFile InputStream
     * @return Node
     * @throws java.io.IOException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException 
     */
	public static Node getBaseNode(InputStream xmlFile) throws ParserConfigurationException, SAXException, IOException
	{
		Document xmlDoc = null;
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		xmlDoc = documentBuilder.parse(xmlFile);

		return xmlDoc.getDocumentElement();
	}

	/**
	 *  Returns the name of a given node.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param node Node
	 * @return String
	 */
	public static String getName(Node node)
	{
		String nodeName = "";  //$NON-NLS-1$
		
		if(null!=node){
			nodeName = node.getNodeName();
		}		
		return nodeName;
	}
	
	/**
	 *  Returns the value of a given node.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param node Node
	 * @return String
	 */
	public static String getValue(Node node)
	{
		String nodeValue = "";  //$NON-NLS-1$
		Node textNode = null;
		try{
			if(null!=node){
				if(Node.TEXT_NODE != getType(node)){
					textNode = getNodeWithTypeFromNodeList(getChildNodeList(node), Node.TEXT_NODE);
				}
				nodeValue = textNode.getNodeValue();
			}
		}
		catch(DOMException dme){
		}		
		return nodeValue;
	}
	
	
	
	/**
	 *  Returns list of child nodes for a given node
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param node Node
	 * @return NodeList
	 */
	public static NodeList getChildNodeList(Node node)
	{
		NodeList nodeList = null;
		
		if(null!=node){
			nodeList = node.getChildNodes();
		}		
		return nodeList;
	}
	
	/**
		 *  Returns ArrayList of child elements for a given node
		 * 
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Nov 20, 2003 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param node Node
		 * @return ArrayList
		 */
		public static ArrayList getChildElements(Node node)
		{
			ArrayList elementList = null;
		
			if(null!=node){
				elementList = new ArrayList();
				NodeList nodeList = node.getChildNodes();
				int length = nodeList.getLength();
				for(int i = 0;i < length; i++){
					if(getType(nodeList.item(i)) == Node.ELEMENT_NODE){
						elementList.add(nodeList.item(i));
					}
				}
				
			}		
			return elementList;
		}
	
	/**
	 *  Returns a node, from node list, whose node name is given.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param listNode NodeList
	 * @param nodeName String
	 * @return Node
	 */
	public static Node getNodeFromNodeList(NodeList listNode, String nodeName){
		Node node = null;
		
		if(null != listNode){
			int listLength = listNode.getLength();
			for(int i=0; i < listLength; i++){
				if(nodeName.equals(getName(listNode.item(i)))){
					node = listNode.item(i);
				}
			}
		}
		return node;
	}
	
	/**
	 *  Returns an ArrayList of matching nodes of given name from node list.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param listNode NodeList
	 * @param nodeName String
	 * @return ArrayList
	 */
	public static ArrayList getNodeListFromNodeList(NodeList listNode, String nodeName){
		ArrayList nodeList = null;
	
		if(null != listNode){
			int listLength = listNode.getLength();
			nodeList =  new ArrayList();
			for(int i=0; i < listLength; i++){
				if(nodeName.equals(getName(listNode.item(i)))){
					nodeList.add(listNode.item(i));
				}
			}
		}
		return nodeList;
	}
	
	/**
	 *  
	 * This method returns the attribute value for a given node and attribute. 
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
	 * @param node Node
	 * @param attribute String
	 * @return String
	 */
	public static String getAttributeValue(Node node, String attribute){
		String attributeValue = "";  //$NON-NLS-1$
	
		if(null != node){
			if(getType(node) == Node.ELEMENT_NODE){
				Element nodeElement = (Element)node;
				attributeValue = nodeElement.getAttribute(attribute);
			}
		}
		return attributeValue;
	}
	
	/**
	 *  Returns a node, from node list, whose node name is given.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param listNode NodeList
	 * @param nodeType short
	 * @return Node
	 */
	public static Node getNodeWithTypeFromNodeList(NodeList listNode, short nodeType){
		Node node = null;

		if(null != listNode){
			int listLength = listNode.getLength();
			for(int i=0; i < listLength; i++){
				if(getType(listNode.item(i)) == nodeType){
					node = listNode.item(i);
				}
			}
		}
		return node;
	}
	
	/**
	 *  
	 * Returns an ArrayList of matching nodes(whose node name, attribute name and
	 * attribute vaues are given)from node list.
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
	 * @param listNode NodeList
	 * @param nodeName String
	 * @param attributeName String
	 * @param attributeValue String
	 * @return ArrayList
	 */
	public static ArrayList getNodeWithAttributeFromNodeList(NodeList listNode, String nodeName, 
		String attributeName, String attributeValue){
			
		ArrayList nodeArray = null;
		Element elementNode = null;
	
		if(null != listNode){
			int listLength = listNode.getLength();
			nodeArray =  new ArrayList();
			for(int i=0; i < listLength; i++){
				if(getType((Node)listNode.item(i)) == Node.ELEMENT_NODE){	
					elementNode = (Element)listNode.item(i);
				
					if(nodeName.equals(elementNode.getTagName()) && attributeValue.equals(elementNode.getAttribute(attributeName))){
						nodeArray.add(elementNode);
					}
				}
			}
		}
		return nodeArray;
	}
	
	/**
	 *  Returns the the node type of a given node.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param node Node
	 * @return short
	 */
	private static short getType(Node node)
	{
		short nodeType = 0;
		try{
			if(null!=node){
				nodeType = node.getNodeType();
			}
		}
		catch(DOMException dme){
		}		
		return nodeType;
	}
}
