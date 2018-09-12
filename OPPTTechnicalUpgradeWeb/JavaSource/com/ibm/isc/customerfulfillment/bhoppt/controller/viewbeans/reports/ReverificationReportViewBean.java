/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ReverificationReportDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ReverificationReportUserDomainDTO;

/**
 * Holds complete data about User Reverification report  
 * 
 * <br/><strong>Known Bugs</strong><br/> 
 * 
 * <br/><PRE> 
 * date Sep 30, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Saravanan Viswanathan
 * @version 5.1X
 */
public class ReverificationReportViewBean extends ReportViewBean {

	/**
	 * convertToDOM
	 * 
	 * @param reportCustomDTO
	 */
	private void convertToDOM(ReverificationReportCustomDTO reportCustomDTO) {
		Document document = null;

		document = createDocument();
		ReverificationReportDomainDTO rptDomainDTO = reportCustomDTO.getReportDTO();
		
		// Insert Root Order
		Element root = (Element) document.createElement("userReverificationReport");
		document.appendChild(root);
		
		root.setAttribute("primarysalesorg", checkForNull(rptDomainDTO.getSalesOrg()));
		root.setAttribute("primarysalesorgdesc", checkForNull(OPPTStaticDataHolder.getSalesOrgDesc(rptDomainDTO.getSalesOrg())));
		root.setAttribute("reportprinteddate", formatDate(reportCustomDTO.getReportPrintedDate()));

		TreeMap userLists = (TreeMap)rptDomainDTO.getUsers();
		TreeMap usersMapByUserType =  createUsersMapByManager(userLists);
		Set userTypeKeySet = usersMapByUserType.keySet();
		Iterator userTypeKeyIterator = userTypeKeySet.iterator();
		String userType= "";
		while(userTypeKeyIterator.hasNext())
		{
			String userTypeKey = (String)userTypeKeyIterator.next();
			if(userTypeKey.equals(UtilityConstants.SOFTWARE_USER))
			{
				userType = "Software user";
			}
			else {
				userType = "Base agreement user";
			}
			
			TreeMap usersMapByManager = (TreeMap)usersMapByUserType.get(userTypeKey);
			Set managerKeySet = usersMapByManager.keySet();
			Iterator managerKeyIterator = managerKeySet.iterator();
			Element userTypeNode = (Element)document.createElement("usertype");
			root.appendChild(userTypeNode);
			userTypeNode.setAttribute("userType",userType );
			while(managerKeyIterator.hasNext())
			{
				String managerKey = (String)managerKeyIterator.next();
				TreeMap usersForManager = (TreeMap)usersMapByManager.get(managerKey);
				TreeMap userListSorted = sortSalesOrg(usersForManager);
				StringTokenizer managerTokenizer = new StringTokenizer(managerKey, "-");
				String managerName = managerTokenizer.nextToken();
				String managerEmail = managerTokenizer.nextToken();
				Element managerNode = (Element)document.createElement("manager");
				userTypeNode.appendChild(managerNode);
				managerNode.setAttribute("managername",managerName );
				managerNode.setAttribute("email", managerEmail);
				int userCount = 0;
				if (null != userListSorted) {
					Set keySet = userListSorted.keySet();
					Iterator iterateKey = keySet.iterator();
					while (iterateKey.hasNext()) {
						ReverificationReportUserDomainDTO userDTO = (ReverificationReportUserDomainDTO)userListSorted.get(iterateKey.next());
						//	EF0621051852 - User Reverifcation Report, shows only the primary group.
						//	Changes starts from here : Thirumalaikumar
						List userGroups = userDTO.getGroupNames();
						int salesOrgSize = 0;
						int userGroupSize = 0;
						int noOfRows = 0;
						String groupName = "";

						if (userGroups != null && userGroups.size() != 0)
						{
							groupName = (String) userGroups.get(0);
							userGroupSize = userGroups.size();
						}
						
						Element userNode = (Element) document.createElement("user");
						managerNode.appendChild(userNode);
						//userNode.setAttribute("managername",userDTO.getManagerName());
						//userNode.setAttribute("manager email id", userDTO.getManagerEmail());
						userNode.setAttribute("firstname",userDTO.getFirstName());
						userNode.setAttribute("lastname",userDTO.getLastName());
						userNode.setAttribute("userid",userDTO.getUserID());
						if(userDTO.getUserType().equals(UtilityConstants.SOFTWARE_USER))
						{
							userNode.setAttribute("role",OPPTStaticDataHolder.getRoleDesc(userDTO.getRole()));
							
						}
						else {
							userNode.setAttribute("role",OPPTStaticDataHolder.getBARoleDesc(userDTO.getBa_role()));
						}
						userNode.setAttribute("group",groupName);
						userNode.setAttribute("lastlogindate",formatDate(userDTO.getLastLogInDate()));
						userNode.setAttribute("primarysalesarea",userDTO.getPrimarySalesOrg());
						userNode.setAttribute("primarysalesareadesc",OPPTStaticDataHolder.getSalesOrgDesc(userDTO.getPrimarySalesOrg()));
						userNode.setAttribute("accesstype",getAccessTypeDesc(userDTO.getPrimaryAccessType()));
						TreeMap salesOrgLists = (TreeMap)userDTO.getSalesOrgs();
				
					if (null != salesOrgLists)
					{
						salesOrgSize=salesOrgLists.size();
						
					}
					else
					{
						salesOrgSize = 0;
					}
					
					userGroupSize = userGroups.size()-1;
	
					if( salesOrgSize >= userGroupSize)
					{
						noOfRows = salesOrgSize;
					}
					else
					{
						noOfRows = userGroupSize;
					}
	
	                if(null != salesOrgLists && null != userGroups)
	                {
						Set salesOrgSet = salesOrgLists.keySet();
						Iterator salesOrgIterateKey = salesOrgSet.iterator();
						for (int i = 0; i < noOfRows; i++) {
							Element salesAreaNode = (Element) document.createElement("salesarea");
							userNode.appendChild(salesAreaNode);
								if( i < salesOrgSize)
								{
									String salesArea = salesOrgIterateKey.next().toString();
									String accessType = salesOrgLists.get(salesArea).toString();
									String salesAreaDesc = OPPTStaticDataHolder.getSalesOrgDesc(salesArea);
									salesAreaNode.setAttribute("secondarysalesareadesc",salesAreaDesc+" - "+salesArea);
									salesAreaNode.setAttribute("accesstype",getAccessTypeDesc(accessType));
								}
								else
								{
									salesAreaNode.setAttribute("secondarysalesareadesc","");
									salesAreaNode.setAttribute("accesstype","");
								}
							
								if(i < userGroupSize)
								{
								  salesAreaNode.setAttribute("group",(String) userGroups.get(i+1));
								}
								else
								{
								  salesAreaNode.setAttribute("group","");
								}
							}
	                }  else if (null != salesOrgLists && null == userGroups)
	                {
						Set salesOrgSet = salesOrgLists.keySet();
						Iterator salesOrgIterateKey = salesOrgSet.iterator();
						for (int i = 0; i < noOfRows; i++) {
							Element salesAreaNode = (Element) document.createElement("salesarea");
							userNode.appendChild(salesAreaNode);
								if( i < salesOrgSize)
								{
									String salesArea = salesOrgIterateKey.next().toString();
									String accessType = salesOrgLists.get(salesArea).toString();
									String salesAreaDesc = OPPTStaticDataHolder.getSalesOrgDesc(salesArea);
									salesAreaNode.setAttribute("secondarysalesareadesc",salesAreaDesc+" - "+salesArea);
									salesAreaNode.setAttribute("accesstype",getAccessTypeDesc(accessType));
									salesAreaNode.setAttribute("group","");
								}
							}
	                }
	                else if (null == salesOrgLists && null != userGroups)
	                {
						for (int i = 0; i < noOfRows; i++) {
							      Element salesAreaNode = (Element) document.createElement("salesarea");
							      userNode.appendChild(salesAreaNode);
								  salesAreaNode.setAttribute("secondarysalesareadesc","");
								  salesAreaNode.setAttribute("accesstype","");
								  salesAreaNode.setAttribute("group",(String) userGroups.get(i+1));
							}
	                }
				}
				}
			}
		}
		super.setDocument(document);
	}
//	Changes end here

	/**
     * ReverificationReportViewBean
     * 
     * @author thirumalai
     */
    public ReverificationReportViewBean() {
	}

	/**
     * ReverificationReportViewBean
     * 
     * @param reportCustomDTO
     * @param view
     * @author thirumalai
     */
    public ReverificationReportViewBean(ReverificationReportCustomDTO reportCustomDTO, String view) {
		convertToDOM(reportCustomDTO);
		super.setView(view);
	}
	
	/**
     * ReverificationReportViewBean
     * 
     * @param reportCustomDTO
     * @param view
     * @param viewReport
     * @author thirumalai
     */
    public ReverificationReportViewBean(ReverificationReportCustomDTO reportCustomDTO, String view,boolean viewReport) {
		if(viewReport){
			convertToDOM(reportCustomDTO);
		}
		else{
			convertToHTML(reportCustomDTO);
		}
		setView(view);
	}
	/**
     * getAccessTypeDesc
     * 
     * @param accessType
     * @return
     * @author thirumalai
     */
    private String getAccessTypeDesc(String accessType) {
		String accessTypeDesc = new String();
		if(accessType!=null) {
			if(accessType.equals("S"))
				accessTypeDesc = "Sensitive";
			else if(accessType.equals("*"))
				accessTypeDesc = "All";
			else
				accessTypeDesc = "Non Sensitive";
		}
		else {
			accessTypeDesc = "Non Sensitive";
		}
		return accessTypeDesc;
	}

	/* Code for sorting based on Primary sales org */	
	/**
     * sortSalesOrg
     * 
     * @param userLists
     * @return
     * @author thirumalai
     */
    private TreeMap sortSalesOrg(TreeMap userLists) {
		TreeMap userListSorted = null;
		if (null != userLists) {
			userListSorted = new TreeMap();
			Set keySet = userLists.keySet();
			Iterator iterateKey = keySet.iterator();
			while (iterateKey.hasNext()) {
				ReverificationReportUserDomainDTO userDTO = (ReverificationReportUserDomainDTO)userLists.get(iterateKey.next());
				String salesOrg = OPPTStaticDataHolder.getSalesOrgDesc(userDTO.getPrimarySalesOrg());
				String userID = userDTO.getUserID();
				String keyValue = salesOrg.concat("-").concat(userID);
				userListSorted.put(keyValue,userDTO);
			}
		}
		return userListSorted;
	}
	

	/**
     * This API takes the user map and seperates the users as per manager and adds them in a separate map
     * which has manager as key and user map as value
     * Sasi R Challa
     *
     * @param userLists
     * @return TreeMap
     */
	private TreeMap createUsersMapByManager(TreeMap userLists) {
		TreeMap usersMapBySWManager = null;
	    TreeMap usersMapByBAManager = null;
	    TreeMap usersMapByUserType = null;
		if (null != userLists) {
			usersMapBySWManager = new TreeMap();
			usersMapByBAManager = new TreeMap();
			usersMapByUserType = new TreeMap();
			Set keySet = userLists.keySet();
			Iterator iterateKey = keySet.iterator();
			while (iterateKey.hasNext()) {
			    String userKey = (String)iterateKey.next();
				ReverificationReportUserDomainDTO userDTO = (ReverificationReportUserDomainDTO)userLists.get(userKey);
				String userType = userDTO.getUserType();
				String managerKey = userDTO.getManagerName()+"-"+userDTO.getManagerEmail();
                if(UtilityConstants.SOFTWARE_USER.equals(userType)) {
    				TreeMap usersForManager = null;
    				if( null == usersMapBySWManager.get(managerKey)) {
    				    usersForManager = new TreeMap();
    				} else {
    				    usersForManager = (TreeMap)usersMapBySWManager.get(managerKey);				    
    				}
    				usersForManager.put(userKey,userDTO);
    				usersMapBySWManager.put(managerKey,usersForManager);
    				usersMapByUserType.put(UtilityConstants.SOFTWARE_USER,usersMapBySWManager);
                }else {
    				TreeMap usersForManager = null;
    				if( null == usersMapByBAManager.get(managerKey)) {
    				    usersForManager = new TreeMap();
    				} else {
    				    usersForManager = (TreeMap)usersMapByBAManager.get(managerKey);				    
    				}
    				usersForManager.put(userKey,userDTO);
    				usersMapByBAManager.put(managerKey,usersForManager);
    				usersMapByUserType.put(UtilityConstants.BASE_CONTRACT_USER,usersMapByBAManager);
                }
			}
		}
		
		return usersMapByUserType;    
	}
	/**
     * convertToHTML
     * 
     * @param customDTO
     * @author thirumalai
     */
    protected void convertToHTML(ReverificationReportCustomDTO customDTO){
			StringBuffer buffer = new StringBuffer();
		
			buffer.append("<html lang=\"en-us\">\n");
			buffer.append("<head>\n");
			buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\n");
			
			buffer.append("<meta name=\"Version\" content=\"1.0\" />\n");
			buffer.append("<meta name=\"DC.Rights\" content=\"Copyright (c) 2003 by IBM Corporation\" />\n");
			buffer.append("<title>User Reverification Report</title>\n");
			buffer.append("</head>\n");
			buffer.append("<body>\n");

			buffer.append("<center>\n");
		
			buffer.append("<table border=\"0\" lotus_anchor=\"A4..S14\" width=\"1120\">\n");
			buffer.append("<lotus_global align=\"center\" valign=\"bottom\" lotus_format=\"General\" height=\"19\" width=\"124\" grid=\"OFF\" gridcolor=\"#cccccc\"></lotus_global>\n");
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"25\" width=\"124\" height=\"19\">&#160;</td>\n");
			buffer.append("</tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"10\"><p style=\"color:red;\">IBM Confidential</p></td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\"><strong>User Reverification Report</strong></td></tr>\n");

			ReverificationReportDomainDTO reportDTO = customDTO.getReportDTO();
			if(null != reportDTO){
				
				buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><strong>Sales org : "+checkForNull(OPPTStaticDataHolder.getSalesOrgDesc(reportDTO.getSalesOrg()))+" - "+checkForNull(reportDTO.getSalesOrg())+" </strong></td></tr>\n");
				buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><strong>Report printed : "+formatDate(customDTO.getReportPrintedDate())+" </strong></td></tr>\n");
				
				buffer.append("<tr><td lotus_celltype=\"blank\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td></tr>\n");
				
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap><strong>User last name</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap><strong>User first name</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap><strong>OPPT Id</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap><strong>Role</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap><strong>Group</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap><strong>Last log-in date</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><strong>Primary sales area</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><strong>Secondary sales area</strong></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"5\" height=\"19\" nowrap><strong>Access type</strong></td>\n");
				buffer.append("</tr>\n");
				
				buffer.append("<tr><td lotus_celltype=\"blank\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td></tr>\n");
				
				TreeMap userLists = (TreeMap)reportDTO.getUsers();
				
				TreeMap usersMapByUserType =  createUsersMapByManager(userLists);
				Set userTypeKeySet = usersMapByUserType.keySet();
				Iterator userTypeKeyIterator = userTypeKeySet.iterator();
				while(userTypeKeyIterator.hasNext())
				{
					String userTypeKey = (String)userTypeKeyIterator.next();
					String userType= "";
					if(userTypeKey.equals(UtilityConstants.SOFTWARE_USER))
					{
						userType = "Software user";
					}
					else {
						userType = "Base agreement user";
					}
					buffer.append("<tr>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><strong>User Type:</strong></td>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><strong>"+userType+"</strong></td>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
					buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
					buffer.append("</tr>\n");	
					buffer.append("<tr><td lotus_celltype=\"blank\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td></tr>\n");
					TreeMap usersMapByManager = (TreeMap)usersMapByUserType.get(userTypeKey);
					Set managerKeySet = usersMapByManager.keySet();
					Iterator managerIteratorKey = managerKeySet.iterator();
					while(managerIteratorKey.hasNext())
					{
						String managerKey = (String)managerIteratorKey.next();
						TreeMap usersForManager = (TreeMap)usersMapByManager.get(managerKey);
						TreeMap userListSorted = sortSalesOrg(usersForManager);
						int userCount = 0;	
						StringTokenizer managerTokenizer = new StringTokenizer(managerKey, "-");
						String managerName = managerTokenizer.nextToken();
						String managerEmail = managerTokenizer.nextToken();
						buffer.append("<tr>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><strong>ManagerName:</strong></td>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><strong>"+managerName+"</strong></td>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap><strong> ManagerEmail:</strong></td>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap><strong>"+managerEmail+"</strong></td>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
						buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap></td>\n");
						buffer.append("</tr>\n");	
					
						if (null != userListSorted) {
							Set keySet = userListSorted.keySet();
							Iterator iterateKey = keySet.iterator();
							while (iterateKey.hasNext()) {
								ReverificationReportUserDomainDTO userDTO = (ReverificationReportUserDomainDTO)userListSorted.get(iterateKey.next());
								String[] SalesOrg = appendSalesOrg(userDTO.getSalesOrgs());
                                String userRole="";
								if(userDTO.getUserType().equals(UtilityConstants.SOFTWARE_USER))
								{
									userRole = OPPTStaticDataHolder.getRoleDesc(userDTO.getRole());
								}
								else {
									userRole = OPPTStaticDataHolder.getBARoleDesc(userDTO.getBa_role());
								}								
								buffer.append("<tr>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap>"+checkForNull(userDTO.getLastName())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap>"+checkForNull(userDTO.getFirstName())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap>"+checkForNull(userDTO.getUserID())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap>"+checkForNull(userRole)+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap>"+checkForNull(appendUserGroupNames(userDTO.getGroupNames()))+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"2\" height=\"19\" nowrap>"+formatDate(userDTO.getLastLogInDate())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+checkForNull(OPPTStaticDataHolder.getSalesOrgDesc(userDTO.getPrimarySalesOrg()))+" - "+checkForNull(userDTO.getPrimarySalesOrg())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+SalesOrg[0]+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"5\" height=\"19\" nowrap>"+checkForNull(getAccessTypeDesc(userDTO.getPrimaryAccessType()))+SalesOrg[1]+"</td>\n");
								buffer.append("</tr>");
							}
						}
						buffer.append("<tr><td lotus_celltype=\"blank\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td></tr>\n");
					}
				}
			}	
			buffer.append("</table>\n");
			buffer.append("</center>\n");
			buffer.append("</body>\n");
			buffer.append("</html>\n");
			setDownloadContent(buffer.toString());
	}
	
	//	EF0621051852 - User Reverifcation Report, shows only the primary group.
	//	Changes starts from here : Thirumalaikumar
	/**
     * appendUserGroupNames
     * 
     * @param userGroupLists
     * @return
     * @author thirumalai
     */
    private String appendUserGroupNames(List userGroupLists)
	{
		    StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < userGroupLists.size(); i++) {
				buffer.append((String)userGroupLists.get(i));
				if(i != userGroupLists.size()-1)
				{
					buffer.append("<br />");
				}
	        }
            return buffer.toString();
	}
	
	/**
     * appendSalesOrg
     * 
     * @param salesOrg
     * @return
     * @author thirumalai
     */
    private String[] appendSalesOrg(Map salesOrg)
	{
		String[] salesOrgArray = new String[2];
		TreeMap salesOrgLists = (TreeMap)salesOrg;
		StringBuffer secondarySalesArea = new StringBuffer("&#160;");
		StringBuffer accessTypes = new StringBuffer();
		if (null != salesOrgLists) {
			Set salesOrgSet = salesOrgLists.keySet();
			Iterator salesOrgIterateKey = salesOrgSet.iterator();
			while (salesOrgIterateKey.hasNext()) {
				String salesArea = salesOrgIterateKey.next().toString();
				String accessType = salesOrgLists.get(salesArea).toString();
				String salesAreaDesc = OPPTStaticDataHolder.getSalesOrgDesc(salesArea);
				secondarySalesArea.append("<br />")
				                  .append(checkForNull(salesAreaDesc)+" - "+checkForNull(salesArea)); 
				accessTypes.append("<br />")
				           .append(checkForNull(getAccessTypeDesc(accessType)));	
			}
			salesOrgArray[0] = secondarySalesArea.toString();
			salesOrgArray[1] = accessTypes.toString();   
		}
		return salesOrgArray;
	}	
    //	Changes end here
	
}