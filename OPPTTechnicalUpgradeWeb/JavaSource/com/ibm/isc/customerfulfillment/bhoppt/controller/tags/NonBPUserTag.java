/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.HttpJspPage;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.NonBPUserActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.TransferProposalsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.NonBPUserViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UserInfoViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 17, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class NonBPUserTag extends OPPTTag 
{
	private NonBPUserViewBean nonbpview = null;
	private TreeMap accessmap = null;
	private boolean edituser = false;
	 
	/**
	 * Overridden method - All the processing that is required to display the date should 
	 * be done at the start of the tag. So override the doStartTag to have logic for displaying 
	 * the date. 
	 * 
	 * <br /><PRE> 
	 * date Nov 13, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br /> 
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag() 
	 * @return
	 * @throws JspException 
	 *
	 */
	public int doStartTag() throws JspException 
	{
		JspWriter out = null;
		String[] accessTypeArray=null;
		String[] salesAreaArray=null;
		
		try {
			out = pageContext.getOut();
			if(null != nonbpview){
				NonBPUserActionForm actionForm = (NonBPUserActionForm)nonbpview.getActionForm();;
				if(null == actionForm){
					accessTypeArray = nonbpview.getNonBPUserData().getAccessType();
					salesAreaArray = nonbpview.getNonBPUserData().getSalesArea();
				}
				else{
					accessTypeArray = actionForm.getNonBPUserDataBean().getAccessType();
					salesAreaArray = actionForm.getNonBPUserDataBean().getSalesArea();
				}
			}
					
			String access="";  //$NON-NLS-1$
			String selectedSalesArea="";  //$NON-NLS-1$
			String accessLabel="";  //$NON-NLS-1$
			String salesAreaLabel="";  //$NON-NLS-1$
			int loopSize = 0;
			int arraySize = 0;
			if(null != salesAreaArray){
				arraySize = getSize(salesAreaArray,accessTypeArray);
			}
			if(arraySize < 5){ 
				loopSize=4;
			}
			else{
				loopSize = arraySize;
			}	
			
			for(int i=0; i < loopSize; i++)
			{
				if(arraySize > i){
					selectedSalesArea = salesAreaArray[i];
					access = accessTypeArray[i];
					accessLabel = access  + "label";  //$NON-NLS-1$
					salesAreaLabel = selectedSalesArea + "label";  //$NON-NLS-1$
				}
				out.write("<tr>");
				out.write("<td width=\"12\" height=\"30\" align=\"center\"></td>");  //$NON-NLS-1$  //$NON-NLS-2$
				out.write("<td>");  //$NON-NLS-1$
				out.write(displayCombo(accessmap,"nonBPUserDataBean.accessType",accessLabel,access,false));  //$NON-NLS-1$
				out.write("</td>");  //$NON-NLS-1$
				out.write("<td width=\"12\" height=\"30\" align=\"center\"></td>");  //$NON-NLS-1$  //$NON-NLS-2$
				out.write("<td>");  //$NON-NLS-1$
				out.write(displayCombo(nonbpview.getSalesAreas(),"nonBPUserDataBean.salesArea",salesAreaLabel,selectedSalesArea, true));  //$NON-NLS-1$
				out.write("</td>");  //$NON-NLS-1$
				out.write("</tr>");  //$NON-NLS-1$
				selectedSalesArea = "";  //$NON-NLS-1$
				access = "";  //$NON-NLS-1$
			}
			int filler=0;
			 if(isEdituser()){
				if(arraySize >= 4 && ((arraySize-4)%5 != 0)){
					filler = 5 - ((arraySize-4)%5);
					for(int j = 0; j < filler; j++){
						accessLabel = "accessLabel" + j;  //$NON-NLS-1$
						salesAreaLabel = "salesAreaLabel" + j;  //$NON-NLS-1$
						out.write("<tr>");  //$NON-NLS-1$
						out.write("<td width=\"12\" height=\"30\" align=\"center\"></td>");  //$NON-NLS-1$  //$NON-NLS-2$
						out.write("<td>");  //$NON-NLS-1$
						out.write(displayCombo(accessmap,"nonBPUserDataBean.accessType",accessLabel,"",false));  //$NON-NLS-2$  //$NON-NLS-1$
						out.write("</td>");  //$NON-NLS-1$
						out.write("<td width=\"12\" height=\"30\" align=\"center\"></td>");  //$NON-NLS-1$  //$NON-NLS-2$
						out.write("<td>");  //$NON-NLS-1$
						out.write(displayCombo(nonbpview.getSalesAreas(),"nonBPUserDataBean.salesArea",salesAreaLabel,"", true));  //$NON-NLS-2$  //$NON-NLS-1$
						out.write("</td>");  //$NON-NLS-1$
						out.write("</tr>");  //$NON-NLS-1$
					}
				}
				if(arraySize >= 4 && ((arraySize-4)%5 == 0)){
					for(int i=0; i < 5; i++){
						accessLabel = "accessLabel" + (i + filler);  //$NON-NLS-1$
						salesAreaLabel = "salesAreaLabel" + (i + filler);  //$NON-NLS-1$
						out.write("<tr>");  //$NON-NLS-1$
						out.write("<td width=\"12\" height=\"30\" align=\"center\"></td>");  //$NON-NLS-1$  //$NON-NLS-2$
						out.write("<td>");  //$NON-NLS-1$
						out.write(displayCombo(accessmap,"nonBPUserDataBean.accessType",accessLabel,"",false));  //$NON-NLS-2$  //$NON-NLS-1$
						out.write("</td>");  //$NON-NLS-1$
						out.write("<td width=\"12\" height=\"30\" align=\"center\"></td>");  //$NON-NLS-1$  //$NON-NLS-2$
						out.write("<td>");  //$NON-NLS-1$
						out.write(displayCombo(nonbpview.getSalesAreas(),"nonBPUserDataBean.salesArea",salesAreaLabel,"", true));  //$NON-NLS-2$  //$NON-NLS-1$
						out.write("</td>");  //$NON-NLS-1$
						out.write("</tr>");  //$NON-NLS-1$
					}
				}
			}
	
			out.flush();
		} catch( IOException ioe ) {
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}
	
	
	private String displayCombo(TreeMap displayMap,String name ,String label, String selectedValue, boolean reverse){
		StringBuffer buffer = new StringBuffer();
		
		if (name.equals("nonBPUserDataBean.accessType"))
	    buffer.append("<select name=\"nonBPUserDataBean.accessType"  + "\" title=\"Access Type\" class=\"iform\" >");  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
		
		else if(name.equals("nonBPUserDataBean.salesArea"))
			
		buffer.append("<select name=\"nonBPUserDataBean.salesArea"  + "\" title=\"Sales Org\" class=\"iform\" >");  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
		
		else
		buffer.append("<select name=\"" + name + "\" class=\"iform\" id=\"" + label+ "\">");  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
		if(isSelected(selectedValue, Constants.DEFAULT_SELECT)){
			buffer.append("<option value=\""+Constants.DEFAULT_SELECT+"\" selected=\"selected\">"+Constants.DEFAULT_SELECT+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
		}
		else{
			buffer.append("<option value=\""+Constants.DEFAULT_SELECT+"\">"+Constants.DEFAULT_SELECT+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
		}
		if(null != displayMap){
			Iterator keys = displayMap.keySet().iterator();
			while(keys.hasNext()){
				String key = (String)keys.next();
				if(null != key){
					String value = (String)displayMap.get(key);
					if(null == value){
						value = key;
					}
			
					if(reverse){
						String temp = key;
						key = value;
						value = temp;
					}
			
					if(isSelected(selectedValue, key)){			
						buffer.append("<option value=\""+key+"\" selected=\"selected\">"+getValue(value, "")+"</option>");  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-2$
					}
					else{
						buffer.append("<option value=\""+key+"\">"+getValue(value, "")+"</option>");  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-2$
					}
				}
			}
			buffer.append("</select>");  //$NON-NLS-1$
		}
	
		return buffer.toString();
	}

	private boolean isSelected(String selectedOption, String option){
		boolean selected = false;
	
		if(null != selectedOption && null != option){
			if(selectedOption.equalsIgnoreCase(option)){
				selected = true;
			}
		}
	
		return selected;
	}
	
	private int getSize(String[] salesAreaArray, String [] accessTypeArray){
		int firstLength = 0;
		int secondLength = 0;
		int firstSize = salesAreaArray.length - 1;
		int secondSize = accessTypeArray.length - 1;
		
		for(int i=firstSize; i >= 0; i--){
			if(!Constants.DEFAULT_SELECT.equalsIgnoreCase(salesAreaArray[i])){
				firstLength = i+1;
				break;
			}
		}
		
		for(int i=secondSize; i >= 0; i--){
			if(!Constants.DEFAULT_SELECT.equalsIgnoreCase(accessTypeArray[i])){
				secondLength = i+1;
				break;
			}
		}
		return(firstLength > secondLength? firstLength: secondLength);
	}
	
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isEdituser() {
		return edituser;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public NonBPUserViewBean getNonbpview() {
		return nonbpview;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setEdituser(boolean b) {
		edituser = b;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bean 
	 */
	public void setNonbpview(NonBPUserViewBean bean) {
		nonbpview = bean;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getAccessmap() {
		return accessmap;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setAccessmap(TreeMap map) {
		accessmap = map;
	}

}
