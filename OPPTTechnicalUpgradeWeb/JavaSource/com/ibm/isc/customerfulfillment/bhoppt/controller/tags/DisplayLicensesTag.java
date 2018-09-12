/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SWOViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;

/**
 * Custom tag that is used for displaying the license
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
public class DisplayLicensesTag extends OPPTTag {
	private TreeMap licenses = null;
	private String dmId = null;
	private String customerId = null;
	private boolean copiedDM = false;
	private boolean onlyQuotes = false;
	private boolean sands = false;

	private boolean proposalEditable = true;

	private String styleEdit = "edit";  //$NON-NLS-1$
	private String styleQuote = "quote";  //$NON-NLS-1$
	private String styleSVCLicense = "svcLicense";  //$NON-NLS-1$
	// CR 2031
	private String duplicateDeleted = "duplicateDeleted";  //$NON-NLS-1$
	private boolean selectAllLicenses = false;
	private boolean clearAllLicenses = false;
	/**
	 * Overridden method -  
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
		JspWriter out = pageContext.getOut();
		try {
			if (onlyQuotes) {
				out.print("<tr class=\"quoteSWODescription\">");  //$NON-NLS-1$
			} else {
				out.print("<tr style=\"background-color:#eeeeee;\" class=\"bar-gray-med-light\">");  //$NON-NLS-1$
			}
			if (isProposalEditable()) {
				out.println("<th width=\"20\" align=\"left\">&nbsp;</th>");  //$NON-NLS-1$
				out.println("<th width=\"87\" align=\"left\">SWO no/ SWO Sl no</th>");  //$NON-NLS-1$
			} else {
				out.println("<th width=\"2\" align=\"left\">&nbsp;</th>"); 
				out.println("<th width=\"110\" align=\"left\">SWO no/ SWO Sl no</th>");  //$NON-NLS-1$
			}
			out.println("<th width=\"87\" align=\"left\">SWO desc</th>");  //$NON-NLS-1$
			if (isSands()) {
				out.println("<th width=\"58\" align=\"left\">ESW S&amp;S price</th>");  //$NON-NLS-1$
			} else {
				out.println("<th width=\"58\" align=\"left\">ESW price</th>");  //$NON-NLS-1$
			}
			if (isSands()) {
				out.println("<th width=\"58\" align=\"left\">Alt S&amp;S price</th>");  //$NON-NLS-1$
			} else {
				out.println("<th width=\"58\" align=\"left\">Alt price</th>");  //$NON-NLS-1$
			}
			if (isSands()) {
				out.println("<th width=\"58\" align=\"left\">Calc S&amp;S price</th>");  //$NON-NLS-1$
			} else {
				out.println("<th width=\"58\" align=\"left\">Calc price</th>");  //$NON-NLS-1$
			}
			out.println("<th width=\"94\" align=\"left\">Pln st dt</th>");  //$NON-NLS-1$
			out.println("<th width=\"94\" align=\"left\">Pln end dt</th>");  //$NON-NLS-1$
			out.println("<th width=\"37\" align=\"left\">Ind</th>");  //$NON-NLS-1$
			out.println("</tr>");  //$NON-NLS-1$

			if (null != getLicenses() && 0 < getLicenses().size()) {
				Iterator iterator = licenses.keySet().iterator();
				while (iterator.hasNext()) {
					String swoIndex = iterator.next().toString();
					SWOViewBean license = (SWOViewBean) licenses.get(swoIndex);
					String swoId = getSwoId(swoIndex);
					OPPTCalender calender = new OPPTCalender();
					String style = "license";  //$NON-NLS-1$

					if (license.isEditedLicense() || license.isBumped() || isCopiedDM()) {
						if (license.isBumped()) {
							if (!license.isFirstBump()) {
								style = styleEdit;
							}
						} else {
							style = styleEdit;
						}

					} else if (license.isQuote()) {
						style = styleQuote;
					} else if (license.isSvcLicense()) {
						style = styleSVCLicense;
					} else if (license.isDuplicateDeleted()) {
						style = duplicateDeleted;
					}

					out.println("<tr class=\"" + style + "\">");  //$NON-NLS-2$  //$NON-NLS-1$
					if (isProposalEditable()) {
						if (license.isMarkedForDeletion()) {
							out.println("<td width=\"20\" valign=\"bottom\" align=\"center\"> * <br/>");  //$NON-NLS-1$
						} else {
							if (isSands()) {
								out.println("<td width=\"20\" valign=\"bottom\" align=\"center\"><input type=\"checkbox\" name=\"selectedSandSIds\" title=\"title34\" id=\"check" + swoId + "\" value=\"" + swoId + "\"");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
								if (isSelectAllLicenses()) {
									out.println("checked=\"true\"");  //$NON-NLS-1$
								}
								out.println("/>");  //$NON-NLS-1$
							} else {
								out.println("<td width=\"20\" valign=\"bottom\" align=\"center\"><input type=\"checkbox\" name=\"selectedIds\" title=\"title34\" id=\"check" + swoId + "\" value=\"" + swoId + "\"");  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
								if (isSelectAllLicenses()) {
									out.println("checked=\"true\"");  //$NON-NLS-1$
								}
								out.println("/>");  //$NON-NLS-1$
							}
						}

						out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						if (isSands()) {
							out.println("<td width=\"87\" valign=\"bottom\" align=\"left\"><label for=\"check" + swoId + "\"><a href=\"SWODetails.wss?type=sands&customerId=" + customerId + "&dmId=" + dmId + "&swoId=" + swoIndex + "\">" + getValue(license.getSwoNumber(), license.getSerialNumber(), "") + "</a></label>");  //$NON-NLS-6$  //$NON-NLS-3$  //$NON-NLS-5$  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-7$  //$NON-NLS-4$
						} else {
							out.println("<td width=\"87\" valign=\"bottom\" align=\"left\"><label for=\"check" + swoId + "\"><a href=\"SWODetails.wss?customerId=" + customerId + "&dmId=" + dmId + "&swoId=" + swoIndex + "\">" + getValue(license.getSwoNumber(), license.getSerialNumber(), "") + "</a></label>");  //$NON-NLS-5$  //$NON-NLS-2$  //$NON-NLS-6$  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-7$  //$NON-NLS-1$
						}

						out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					} else {
						if (isSands()) {
							out.println("<td width=\"2\" align=\"left\">&nbsp;</td>"); 
							out.println("<td width=\"110\" valign=\"bottom\" align=\"left\"><a href=\"SWODetails.wss?type=sands&customerId=" + customerId + "&dmId=" + dmId + "&swoId=" + swoIndex + "\">" + getValue(license.getSwoNumber(), license.getSerialNumber(), "") + "</a>");  //$NON-NLS-4$  //$NON-NLS-6$  //$NON-NLS-5$  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$
							out.println("</td>");  //$NON-NLS-1$
						} else {
							out.println("<td width=\"2\" align=\"left\">&nbsp;</td>"); 
							out.println("<td width=\"110\" valign=\"bottom\" align=\"left\"><a href=\"SWODetails.wss?customerId=" + customerId + "&dmId=" + dmId + "&swoId=" + swoIndex + "\">" + getValue(license.getSwoNumber(), license.getSerialNumber(), "") + "</a>");  //$NON-NLS-4$  //$NON-NLS-5$  //$NON-NLS-3$  //$NON-NLS-6$  //$NON-NLS-2$  //$NON-NLS-1$
							out.println("</td>");  //$NON-NLS-1$
						}
					}

					out.println("<td width=\"87\" valign=\"bottom\" align=\"left\">" + getValue(license.getDescription(), ""));  //$NON-NLS-1$  //$NON-NLS-2$
					out.println(" <br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					if (license.isShowESWPrice()) {
						out.println("<td width=\"58\" valign=\"bottom\" align=\"right\">" + getDoubleValue(license.getEswPrice(), "0.00"));  //$NON-NLS-2$  //$NON-NLS-1$
					} else {
						out.println("<td width=\"58\" valign=\"bottom\" align=\"right\">" + getValue("-", "-"));  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					}
					out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					if (license.isShowAlternatePrice()) {
						out.println("<td width=\"58\" valign=\"bottom\" align=\"right\">" + getDoubleValue(license.getAlternatePrice(), "0.00"));  //$NON-NLS-2$  //$NON-NLS-1$
					} else {
						out.println("<td width=\"58\" valign=\"bottom\" align=\"right\">" + getValue("-", "-"));  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					}
					out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					if (license.isShowCalculatedPrice()) {
						out.println("<td width=\"58\" valign=\"bottom\" align=\"right\">" + getDoubleValue(license.getCalculatedPrice(), "0.00"));  //$NON-NLS-1$  //$NON-NLS-2$
					} else {
						out.println("<td width=\"58\" valign=\"bottom\" align=\"right\">" + getValue("-", "-"));  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
					}
					out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td width=\"94\" valign=\"bottom\" align=\"left\">" + getDateValue(license.getPlanStartDate(), ""));  //$NON-NLS-1$  //$NON-NLS-2$
					out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td width=\"94\" valign=\"bottom\" align=\"left\">" + getDateValue(license.getPlanEndDate(), ""));  //$NON-NLS-1$  //$NON-NLS-2$
					out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$

					StringBuffer indicator = new StringBuffer();
					if (license.isLocked()) {
						indicator.append(getImage("locked.gif", "Locked"));  //$NON-NLS-2$  //$NON-NLS-1$
					}
					if (license.isBumped()) {
						indicator.append(getImage("bumped.gif", "Bumped"));  //$NON-NLS-2$  //$NON-NLS-1$
					}
					if (license.isExcluded()) {
						indicator.append(getImage("excluded.gif", "Excluded"));  //$NON-NLS-2$  //$NON-NLS-1$
					}
					if (license.isForConract()) {
						indicator.append(getImage("for_contract.gif", "For contract"));  //$NON-NLS-2$  //$NON-NLS-1$
					}
					if (license.isRefetchLicense()) {
						indicator.append(getImage("refetched.gif", "Refetch license"));  //$NON-NLS-1$  //$NON-NLS-2$
					}
					if (license.isDeltaFetchLicense()) {
						indicator.append(getImage("delta_fetched.gif", "Delte fetch license"));  //$NON-NLS-2$  //$NON-NLS-1$
					}
					if (license.isAmendedLicense()) {
						indicator.append(getImage("amended.gif", "Amended license"));  //$NON-NLS-2$  //$NON-NLS-1$
					}
					if (license.isAlreadyBilled()) {
						indicator.append(getImage("alreadybilled.gif", "Already billed license"));  //$NON-NLS-2$  //$NON-NLS-1$
					}

					out.println("<td width=\"37\" valign=\"bottom\" align=\"left\">" + indicator.toString());  //$NON-NLS-1$
					out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("</tr>");  //$NON-NLS-1$
					/* CR0531074816 - CBS OPPT accessibility issues
					out.println("<tr>");  //$NON-NLS-1$
					out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$					
					out.println("</tr>");  //$NON-NLS-1$ */
					
				}
			} else {
				out.println("<tr>");  //$NON-NLS-1$
				if (isProposalEditable()) {
					out.println("<td valign=\"bottom\" colspan=\"9\" align=\"left\">&nbsp;&nbsp;" + Constants.NO_SWOS_FOR_DM + "<br />");  //$NON-NLS-2$  //$NON-NLS-1$
				} else {
					out.println("<td valign=\"bottom\" colspan=\"8\" align=\"left\">&nbsp;&nbsp;" + Constants.NO_SWOS_FOR_DM + "<br />");  //$NON-NLS-2$  //$NON-NLS-1$
				}
				out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
				out.println("</tr>");  //$NON-NLS-1$
			}
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns if the licenses are part of a copied dm 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isCopiedDM() {
		return copiedDM;
	}

	/**
	 * Returns swo's parent customers identiier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Returns license's parents dm identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDmId() {
		return dmId;
	}

	/**
	 * Returns license information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getLicenses() {
		return licenses;
	}

	/**
	 * Returns true if the license is part of a dm whose licenses are all quotes. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isOnlyQuotes() {
		return onlyQuotes;
	}

	/**
	 * Sets copiedDM flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCopiedDM boolean 
	 */
	public void setCopiedDM(boolean newCopiedDM) {
		copiedDM = newCopiedDM;
	}

	/**
	 * Sets license's parent customer identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerId String 
	 */
	public void setCustomerId(String newCustomerId) {
		customerId = newCustomerId;
	}

	/**
	 * Sets license's parent dm's identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDmId String 
	 */
	public void setDmId(String newDmId) {
		dmId = newDmId;
	}

	/**
	 * Sets license that need to be displayed 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicenses TreeMap 
	 */
	public void setLicenses(TreeMap newLicenses) {
		licenses = newLicenses;
	}

	/**
	 * Sets only quotes flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newOnlyQuotes boolean 
	 */
	public void setOnlyQuotes(boolean newOnlyQuotes) {
		onlyQuotes = newOnlyQuotes;
	}

	/**
	 * Returns edited liceses style
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getStyleEdit() {
		return styleEdit;
	}

	/**
	 * Returns quote's style 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getStyleQuote() {
		return styleQuote;
	}

	/**
	 * Returns style of an svc license 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getStyleSVCLicense() {
		return styleSVCLicense;
	}

	/**
	 * Sets edited licenses style 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStyleEdit String 
	 */
	public void setStyleEdit(String newStyleEdit) {
		styleEdit = newStyleEdit;
	}

	/**
	 * Sets quote's style 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStyleQuote String 
	 */
	public void setStyleQuote(String newStyleQuote) {
		styleQuote = newStyleQuote;
	}

	/**
	 * Sets svc licenses style 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStyleSVCLicense String 
	 */
	public void setStyleSVCLicense(String newStyleSVCLicense) {
		styleSVCLicense = newStyleSVCLicense;
	}

	private String getSwoId(String swoId) {
		String id = "";  //$NON-NLS-1$
		if (null != getCustomerId()) {
			id = getCustomerId();
		}
		if (null != getDmId()) {
			if (0 < id.length()) {
				id = id + Constants.STRING_SEPERATOR + getDmId();
			} else {
				id = getDmId();
			}
		}
		if (null != swoId) {
			if (0 < id.length()) {
				id = id + Constants.STRING_SEPERATOR + swoId;
			} else {
				id = swoId;
			}
		}
		return id;
	}

	/**
	 * Returns true if proposal is editable 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isProposalEditable() {
		return proposalEditable;
	}

	/**
	 * Sets proposal editable flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalEditable boolean
	 */
	public void setProposalEditable(boolean newProposalEditable) {
		proposalEditable = newProposalEditable;
	}

	private String getImage(String buttonName, String name) {
		StringBuffer image = new StringBuffer();

		if (null != buttonName) {
			String path = OPPTPropertiesReader.getOPPTImagePath() + "icons/" + buttonName;  //$NON-NLS-1$

			image.append("<img");  //$NON-NLS-1$
			image.append(" src=\"" + path + "\"");  //$NON-NLS-1$  //$NON-NLS-2$
			image.append(" height=\"14\"");  //$NON-NLS-1$
			image.append(" width=\"14\"");  //$NON-NLS-1$
			image.append(" name=\"" + name + "\"");  //$NON-NLS-1$  //$NON-NLS-2$
			image.append(" alt=\"" + name + "\"");  //$NON-NLS-1$  //$NON-NLS-2$
			image.append(" />");  //$NON-NLS-1$
		}

		return image.toString();
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSands() {
		return sands;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSands(boolean b) {
		sands = b;
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
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSelectAllLicenses() {
		return selectAllLicenses;
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
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSelectAllLicenses(boolean b) {
		selectAllLicenses = b;
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
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isClearAllLicenses() {
		return clearAllLicenses;
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
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setClearAllLicenses(boolean b) {
		clearAllLicenses = b;
	}

}
