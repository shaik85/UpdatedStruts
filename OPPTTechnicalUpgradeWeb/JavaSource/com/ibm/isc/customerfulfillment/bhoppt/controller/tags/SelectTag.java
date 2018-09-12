/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UsersCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ReverificationReportUserDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.BasicProposalDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.UserProfileBO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BasicProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO;

/**
 * Displayes the drop down menu
 * 
 * <br /><b>Known Bugs</b><br /> 
 * 
 * <br /><PRE> 
 * date Nov 12, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br /> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class SelectTag extends OPPTTag 
{
	private static final String CLASS_NAME="SelectTag";  //$NON-NLS-1$
	private String name = null;
	private String style = "iform";  //$NON-NLS-1$
	private String id = null;
	private String onchange = null;
	private String onclick = null;
	private String onkeyup = null;
	private TreeMap options = null;
	private LinkedHashMap proposalTypeOptions = null;//OPPT BH-DAD001-SRINIVAS
	private String selectedOption = null;
	private boolean reverse = false;
	private List nonEditableFields = null;
	private String value = null;
	private boolean editable = true;
	private boolean displayValue = true;
	private String title = null; 
	private boolean disabled = false;
	private String dependent = null;//OPPT BH-DAD001 - Bhanu

	BasicProposalDataBean dataBean= new BasicProposalDataBean();
	BasicProposalCustomDTO propcustomDTO = new BasicProposalCustomDTO();
	ProposalFormDataCustomDTO formcustomDTO = new ProposalFormDataCustomDTO();
	UserProfileBO userProfileBO = new UserProfileBO();
	
	
	/**
	 * Overridden method - Displays drop down menu 
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
	public int doStartTag() throws JspException {
		String methodName="doStartTag";  //$NON-NLS-1$
		StringBuffer buffer = new StringBuffer();
		UsersCustomDTO customDTO= new UsersCustomDTO();
		//ReverificationReportUserDomainDTO customDTO = new ReverificationReportUserDomainDTO ();
		if(null != getName()){
			if(isFieldEditable()){
				if(null == getId()){
					setId(getName());
				}
				/*
				if(null == getSelectedOption()){
					if("basicProposalData.distributionChannel".equalsIgnoreCase(getName()))
						setSelectedOption("IBM Sales");
					else
					setSelectedOption(Constants.DEFAULT_SELECT);
					
				}
				*/
				buffer.append("<select");  //$NON-NLS-1$
				buffer.append(" name=\""+getName()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append(" class=\""+getStyle()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append(" id=\""+getId()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
			/*	if(null != getOnchange()){
					buffer.append(" onchange=\""+getOnchange()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				}*/
				if(null != getOnclick()){
					buffer.append(" onclick=\""+getOnclick()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				}
				if(null != getOnkeyup()){
					buffer.append(" onkeyup=\""+getOnkeyup()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				}				// Added by Balaji - Starts  
				if(null != getTitle()){
					buffer.append(" title=\""+getTitle()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				}
				if(disabled)
				{
				buffer.append(" disabled=\"disabled\"");			
				}
			
//				 Added by Balaji - Ends
				buffer.append(">");  //$NON-NLS-1$

				if(isSelected(getSelectedOption(), Constants.DEFAULT_SELECT)){
					buffer.append("<option value=\""+Constants.DEFAULT_SELECT+"\" selected=\"selected\">"+Constants.DEFAULT_SELECT+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
				}
				else{
					buffer.append("<option value=\""+Constants.DEFAULT_SELECT+"\">"+Constants.DEFAULT_SELECT+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
				}
				
				if(null != getOptions()){
					Iterator keys = getOptions().keySet().iterator();
					while(keys.hasNext()){
						String key = (String)keys.next();
						if(null != key){
							String value = (String)getOptions().get(key);
							if(null == value){
								value = key;
							}
							
							if(isReverse()){
								String temp = key;
								key = value;
								value = temp;
							}
						
							if(isSelected(getSelectedOption(), key)){

								buffer.append("<option value=\""+key+"\" selected=\"selected\">"+getValue(value, "")+"</option>");  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-2$
							}
							else{
								if("basicProposalData.distributionChannel".equalsIgnoreCase(getName())&& ("IBM Sales".equalsIgnoreCase(getValue(value, ""))))
								{
									buffer.append("<option value=\""+key+ "\" selected=\"selected\">"+getValue(value, "")+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
								}
								//added for division -Nomita
							
								else if("basicProposalData.division".equalsIgnoreCase(getName())&& ("00 - IBM Generic Div".equalsIgnoreCase(getValue(value, ""))))
								{
									buffer.append("<option value=\""+key+ "\" selected=\"selected\">"+getValue(value, "")+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
								}
									else if("basicProposalData.salesOrganization".equalsIgnoreCase(getName())&& (("IBM GERMANY - "+"7240").equalsIgnoreCase(getValue(value, ""))))
								{
										//userProfileDomainDTO.setPrimarySalesOrg(userProfileBO.getPrimarySalesOrg());
										//System.out
										//		.println("SelectTag.doStartTag()"+userProfileBO.getPrimarySalesOrg());
										buffer.append("<option value=\""+key+ "\" selected=\"selected\">"+getValue(value, "")+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
							}
							else if("basicProposalData.currencyCode".equalsIgnoreCase(getName())&& (("EUR - "+"Euro").equalsIgnoreCase(getValue(value, ""))))
							{
								buffer.append("<option value=\""+key+ "\" selected=\"selected\">"+getValue(value, "")+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
							}	
								//end
									else
								buffer.append("<option value=\""+key+"\">"+getValue(value, "")+"</option>");  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-2$
							}
						}
					}
				}
             //	OPPT BH-DAD001-SRINIVAS
				if(null != getProposalTypeOptions()){
					Iterator keys = getProposalTypeOptions().keySet().iterator();
					while(keys.hasNext()){
						String key = (String)keys.next();
						if(null != key){
							String value = (String)getProposalTypeOptions().get(key);
							if(null == value){
								value = key;
							}
							
							if(isReverse()){
								String temp = key;
								key = value;
								value = temp;
							}
							if(isSelected(getSelectedOption(), key)){		
								if(null==getDependent()){
									buffer.append("<option value=\""+key+"\" selected=\"selected\">"+getValue(value, "")+"</option>");  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-2$
								} else if(isValidDependent(key,getValue(value, ""))) {
									buffer.append("<option value=\""+key+"\" selected=\"selected\">"+getValue(value, "")+"</option>");
								} else {
									buffer.append("<option value=\""+key+"\">"+getValue(value, "")+"</option>");
								}
							}
							else{
								buffer.append("<option value=\""+key+"\">"+getValue(value, "")+"</option>");  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-2$
							}
						}
					}
				}
				buffer.append("</select>");  //$NON-NLS-1$
			}
			else{
				if(null != getSelectedOption()){
					buffer.append("<input type=\"hidden\" name=\""+getName()+"\" value=\""+getSelectedOption()+"\" />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
				}
				if(null != value){
					buffer.append(getValue(value, ""));  //$NON-NLS-1$
				}
				else{
					if(isDisplayValue()){
						if(null != getSelectedOption() && null != getOptions()){
							buffer.append(getValue((String)getOptions().get(getSelectedOption()), ""));  //$NON-NLS-1$
						}
						else if(null != getSelectedOption()){
							buffer.append(getValue(getSelectedOption(), ""));  //$NON-NLS-1$
						}
						else{
							buffer.append("");  //$NON-NLS-1$
						}
					}
					else{
						buffer.append(getValue(getSelectedOption(), ""));  //$NON-NLS-1$
					}
				}
			}
		}
		
		JspWriter out = pageContext.getOut();
		try{
			out.print(buffer.toString());
			out.flush();
		} 
		catch (IOException ioe){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ioe);  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}
	
	/**
	 * Returns the identifier for the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the name of the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/** 
	 * Returns the collection of options available for the drop down menu
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getOptions() {
		return options;
	}

	/**
	 * Returns the style of the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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
	 * Sets the drop down menu identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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
	 * Sets the name of the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newName String 
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Sets collection of options available for the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newOptions TreeMap 
	 */
	public void setOptions(TreeMap newOptions) {
		options = newOptions;
	}

	/**
	 * Sets the style of the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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
	 * Returns selected option value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedOption() {
		return selectedOption;
	}

	/**
	 * Sets selected option value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedOption String 
	 */
	public void setSelectedOption(String newSelectedOption) {
		selectedOption = newSelectedOption;
	}

	
	private boolean isSelected(String selectedOption, String option){
		boolean selected = false;
		
		if(null != selectedOption && null != option ){
			if(selectedOption.equalsIgnoreCase(option)){
				selected = true;
			}
		}
		
		return selected;
	}
	
	private boolean isValidDependent(String key,String value){
		boolean selected = false;
		if((key.equalsIgnoreCase("ES") && getDependent().trim().equalsIgnoreCase(Constants.SNS_DESC)) 
	      ||(key.equalsIgnoreCase("ES") && getDependent().trim().equalsIgnoreCase(Constants.MLC_DESC)) && value.trim().equalsIgnoreCase("MLC") ){
			selected = true;
		}
		
		// If the proposal type is not ES, then always return true.
		if(!key.equalsIgnoreCase("ES")){
			selected = true;
		}
		
		return selected;
	}
	
	/**
	 * Returns true if value should be used as key and key to be used as value. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isReverse() {
		return reverse;
	}

	/**
	 * Sets the reverse flag value. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newReverse boolean
	 */
	public void setReverse(boolean newReverse) {
		reverse = newReverse;
	}

	/** 
	 * Returns the target value that need to be excuted on change of any value in the drop down. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getOnchange() {
		return onchange;
	}

	/** 
	 * Sets the target value that need to be excuted on change of any value in the drop down. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newOnchange String 
	 */
	public void setOnchange(String newOnchange) {
		onchange = newOnchange;
	}
	
	/**
	 * Returns collection of non editable field names 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getNonEditableFields() {
		return nonEditableFields;
	}

	/**
	 * Sets collection of non editable field names 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNonEditableFields List
	 */
	public void setNonEditableFields(List newNonEditableFields) {
		nonEditableFields = newNonEditableFields;
	}

	private boolean isFieldEditable(){
		boolean fieldEditable = false;
		if(null != getNonEditableFields())
		{
			if(null != getName())
			{
				if(!getNonEditableFields().contains(getName())){
					fieldEditable = true;
				}
			}
		}
		else{
			if(isEditable()){
				fieldEditable = true;
			}
			else{
				fieldEditable = false;
			}
		}
		return fieldEditable;
		
	}
	
	

	/**
	 * Returns string value which need to be used, when the drop down menu is not editable. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets string as value which need to be used, when the drop down is not editable 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newValue String 
	 */
	public void setValue(String newValue) {
		value = newValue;
	}
	
	/**
	 * Returns true, if the value the value associated with the selected content 
	 * need to be displayed when the select is non editable 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDisplayValue() {
		return displayValue;
	}

	/**
	 * Returns true if the select box is editable. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Sets the flag value for displaying the select content when the select is non editable 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDisplayValue boolean
	 */
	public void setDisplayValue(boolean newDisplayValue) {
		displayValue = newDisplayValue;
	}

	/**
	 * Sets select box editable flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEditable boolean
	 */
	public void setEditable(boolean newEditable) {
		editable = newEditable;
	}
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
//	OPPT BH-DAD001-SRINIVAS
	/**
	 * @return Returns the proposalTypeOptions.
	 */
	public LinkedHashMap getProposalTypeOptions() {
		return proposalTypeOptions;
	}
//	OPPT BH-DAD001-SRINIVAS
	/**
	 * @param proposalTypeOptions The proposalTypeOptions to set.
	 */
	public void setProposalTypeOptions(LinkedHashMap proposalTypeOptions) {
		this.proposalTypeOptions = proposalTypeOptions;
	}
	
	
	/**
	 * @return Returns the disabled.
	 */
	public boolean isDisabled() {
		return disabled;
	}
	/**
	 * @param disabled The disabled to set.
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	// BH - Wave1 - DAD001 - Bhanu - Begin
	/**
	 * @return Returns the dependent.
	 */
	public String getDependent() {
		return dependent;
	}
	/**
	 * @param dependent The dependent to set.
	 */
	public void setDependent(String dependent) {
		this.dependent = dependent;
	}
	// BH - Wave1 - DAD001 - Bhanu - End
	/**
	 * @return Returns the onclick.
	 */
	public String getOnclick() {
		return onclick;
	}
	/**
	 * @param onclick The onclick to set.
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
	/**
	 * @return Returns the onkeyup.
	 */
	public String getOnkeyup() {
		return onkeyup;
	}
	/**
	 * @param onkeyup The onkeyup to set.
	 */
	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}
}