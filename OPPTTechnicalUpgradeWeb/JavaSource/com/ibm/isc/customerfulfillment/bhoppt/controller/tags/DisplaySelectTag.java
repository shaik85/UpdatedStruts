/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.HttpJspPage;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.taglib.html.Constants;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;

/** 
 * Given date object to this tag, this tag is used to display the date in readable format.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 12, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class DisplaySelectTag extends TagSupport 
{
	private String id = null;
	private String style = "iform";  //$NON-NLS-1$
	private HashMap options = null;
	private String property = null;
	 
	/**
	 * Overridden method - All the processing that is required to display the drop down menu should 
	 * be done at the start of the tag. So override the doStartTag to have logic for displaying the 
	 * drop down menu. 
	 * 
	 * <br/><PRE> 
	 * date Nov 13, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag() 
	 * @return
	 * @throws JspException 
	 *
	 */
	public int doStartTag() throws JspException 
	{
		JspWriter out = pageContext.getOut();
		try{
			out.println("<select name=\""+id+"\" id=\""+id+"\" class=\""+style+"\">");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-4$
			String selectedOption = getPropertyValue(property);
			if(null == selectedOption){
				out.println("<option value=\"\" selected=\"selected\">Select one</option>");  //$NON-NLS-1$
			}
			else {
				out.println("<option value=\"\">Select one</option>");  //$NON-NLS-1$
			}
			if(null != options){
				Iterator keys = options.keySet().iterator();
				while(keys.hasNext()){
					String key = (String)keys.next();
					if(null != selectedOption && selectedOption.equals(key)){
						out.println("<option value=\""+key+"\" selected=\"selected\">"+options.get(key)+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
					}
					else{
						out.println("<option value=\""+key+"\">"+options.get(key)+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
					}
				}
			}
			out.println("</select>");  //$NON-NLS-1$
		}
		catch(IOException ioe){
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns select identifier 
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
	 * @return 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns bean property value
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
	 * @return String
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * Returns style value 
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
	 * @return String
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * Returns options collection 
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
	 * @return HashMap
	 */
	public HashMap getOptions() {
		return options;
	}

	/**
	 * Sets select identifier 
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
	 * @param newId String 
	 */
	public void setId(String newId) {
		id = newId;
	}

	/**
	 * Sets bean property value 
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
	 * @param newProperty String 
	 */
	public void setProperty(String newProperty) {
		property = newProperty;
	}

	/**
	 * Sets style value 
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
	 * @param newStyle String 
	 */
	public void setStyle(String newStyle) {
		style = newStyle;
	}

	/**
	 * Sets options collection 
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
	 * @param newOptions HashMap 
	 */
	public void setOptions(HashMap newOptions) {
		options = newOptions;
	}
	
	/**
	 * Helper method that get the property value from the underlying bean  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param property String
	 * @return String
	 */
	private String getPropertyValue(String property)
	{
		String selectedOption = null;		

		if(null != property){
			Object bean = pageContext.getAttribute(Constants.BEAN_KEY);
			try{
				selectedOption = BeanUtils.getProperty(bean, property);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

		return selectedOption;
	}
}