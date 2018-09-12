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
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeletedUsersReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ReverificationReportDomainDTO;


import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.DeletedUsersReportUserDomainDTO;

/**
 * Holds complete data about User Reverification report  
 * 
 * <br/><b>Known Bugs</b><br/> 
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
public class DeletedUsersReportViewBean extends ReportViewBean {

	/**
	 * convertToDOM
	 * 
	 * @param reportCustomDTO
	 */
	private void convertToDOM(DeletedUsersReportCustomDTO reportCustomDTO) {
		Document document = null;

		document = createDocument();
		ReverificationReportDomainDTO rptDomainDTO = reportCustomDTO.getReportDTO();
		
		Date  date = new Date();
		// Insert Root Order
		Element root = (Element) document.createElement("deletionreport");
		document.appendChild(root);
		root.setAttribute("primarysalesorg", checkForNull(rptDomainDTO.getSalesOrg()));
		root.setAttribute("primarysalesorgdesc", checkForNull(OPPTStaticDataHolder.getSalesOrgDesc(rptDomainDTO.getSalesOrg())));
		root.setAttribute("reportprinteddate", date.toString());

		TreeMap userMap = (TreeMap)rptDomainDTO.getUsers();
		
		Set userTypeKeySet = userMap.keySet();
		Iterator userTypeKeyIterator = userTypeKeySet.iterator();
		while (userTypeKeyIterator.hasNext()) {
		ArrayList userlist = (ArrayList)userMap.get(userTypeKeyIterator.next());
		for (int i=0; i< userlist.size();i++) {
			DeletedUsersReportUserDomainDTO userDTO = (DeletedUsersReportUserDomainDTO)userlist.get(i);
			
			Element userNode = (Element) document.createElement("deleteduser");
			root.appendChild(userNode);
			userNode.setAttribute("firstname",userDTO.getFirstName());
			userNode.setAttribute("lastname",userDTO.getLastName());
			userNode.setAttribute("userid",userDTO.getUserID());	
			String userType= "";
			if(userDTO.getUserType().equals(UtilityConstants.SOFTWARE_USER))
			{
				userType = "Software user";
			}
			else {
				userType = "Base agreement user";
			}	
			userNode.setAttribute("usertype" , userType )	;
			userNode.setAttribute("role",OPPTStaticDataHolder.getRoleDesc(userDTO.getRole()));
			userNode.setAttribute("group",userDTO.getGroupName());
			userNode.setAttribute("deleteddate",userDTO.getDeletedDate().toString());
			userNode.setAttribute("primarysalesorg",userDTO.getPrimarySalesOrg());
			userNode.setAttribute("primarysalesorgdesc",OPPTStaticDataHolder.getSalesOrgDesc(userDTO.getPrimarySalesOrg()));
			userNode.setAttribute("accesstype",getAccessTypeDesc(userDTO.getPrimaryAccessType()));
			userNode.setAttribute("deletedadmin",userDTO.getDeletedAdminEmail());  
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
    public DeletedUsersReportViewBean() {
	}

	/**
     * ReverificationReportViewBean
     * 
     * @param reportCustomDTO
     * @param view
     * @author thirumalai
     */
    public DeletedUsersReportViewBean(DeletedUsersReportCustomDTO reportCustomDTO, String view) {
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
    public DeletedUsersReportViewBean(DeletedUsersReportCustomDTO reportCustomDTO, String view,boolean viewReport) {
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

	

	/**
     * This API takes the user map and seperates the users as per manager and adds them in a separate map
     * which has manager as key and user map as value
     * Sasi R Challa
     *
     * @param userLists
     * @return TreeMap
     */

	/**
     * convertToHTML
     * 
     * @param customDTO
     * @author thirumalai
     */
    protected void convertToHTML(DeletedUsersReportCustomDTO customDTO){
			StringBuffer buffer = new StringBuffer();
			Date  date = new Date();
			buffer.append("<html lang=\"en-us\">\n");
			buffer.append("<head>\n"); 
			buffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\n");
			
			buffer.append("<meta name=\"Version\" content=\"1.0\" />\n");
			buffer.append("<meta name=\"DC.Rights\" content=\"Copyright (c) 2003 by IBM Corporation\" />\n");
			buffer.append("<title>Deleted Users Report</title>\n");
			buffer.append("</head>\n");
			buffer.append("<body>\n");

			buffer.append("<center>\n");
		
			buffer.append("<table border=\"0\" lotus_anchor=\"A4..S14\" width=\"1120\">\n");
			buffer.append("<lotus_global align=\"center\" valign=\"bottom\" lotus_format=\"General\" height=\"19\" width=\"124\" grid=\"OFF\" gridcolor=\"#cccccc\"></lotus_global>\n");
			buffer.append("<tr>\n");
			buffer.append("<td lotus_celltype=\"blank\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" colspan=\"25\" width=\"124\" height=\"19\">&#160;</td>\n");
			buffer.append("</tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"10\"><font LOTUS_SIZE=\"8\" COLOR=\"red\">IBM Confidential</font></td></tr>\n");
			buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"24\"><b>Deleted Users Report</b></td></tr>\n");

			ReverificationReportDomainDTO reportDTO = customDTO.getReportDTO();
			if(null != reportDTO){
				
				buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><b>Sales org : "+checkForNull(OPPTStaticDataHolder.getSalesOrgDesc(reportDTO.getSalesOrg()))+" - "+checkForNull(reportDTO.getSalesOrg())+" </b></td></tr>\n");
				buffer.append("<tr><td lotus_celltype=\"label\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"left\" valign=\"bottom\" height=\"24\"><b>Report printed : "+date.toString()+" </b></td></tr>\n");
				
				buffer.append("<tr><td lotus_celltype=\"blank\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td></tr>\n");
				
				buffer.append("<tr>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><b>User Name</b></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><b>User Id</b></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><b>Type</b></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><b>Role</b></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><b>Group</b></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><b>Sales Area</b></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><b>Access Type</b></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><b>Deleted By</b></td>\n");
				buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap><b>Deleted at GMT</b></td>\n");
				buffer.append("</tr>\n");
				
				buffer.append("<tr><td lotus_celltype=\"blank\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td></tr>\n");
				
				TreeMap userMap = (TreeMap)reportDTO.getUsers();
				boolean noReport = true;
				Set userTypeKeySet = userMap.keySet();
				Iterator userTypeKeyIterator = userTypeKeySet.iterator();
				while (userTypeKeyIterator.hasNext()) {
				ArrayList userlist = (ArrayList)userMap.get(userTypeKeyIterator.next());
				//System.out.println("Size" + userlist.size());
				System.out.println("Size" + userlist);
				if(userlist != null && userlist.size()>0    ){
					noReport = false;
					System.out.println("Inside user size");
				for (int i=0; i< userlist.size();i++) {
					DeletedUsersReportUserDomainDTO userDTO = (DeletedUsersReportUserDomainDTO)userlist.get(i);
					System.out.println("User ID "+userDTO.getUserID());
					String userType= "";
					if(userDTO.getUserType().equals(UtilityConstants.SOFTWARE_USER))
					{
						userType = "Software user";
					}
					else {
						userType = "Base agreement user";
					}
					buffer.append("<tr>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+checkForNull(userDTO.getLastName())+"  " +checkForNull(userDTO.getFirstName())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+userDTO.getUserID()+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+checkForNull(userType)+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+checkForNull(OPPTStaticDataHolder.getRoleDesc(userDTO.getRole()))+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+checkForNull((userDTO.getGroupName()))+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+checkForNull(OPPTStaticDataHolder.getSalesOrgDesc(userDTO.getPrimarySalesOrg()))+" - "+checkForNull(userDTO.getPrimarySalesOrg())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+checkForNull(getAccessTypeDesc(userDTO.getPrimaryAccessType()))+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+checkForNull(userDTO.getDeletedAdminEmail())+"</td>\n");
								buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"4\" height=\"19\" nowrap>"+(userDTO.getDeletedDate())+"</td>\n");
								buffer.append("</tr>");
							}
				          }
				           
				          }
				if(noReport){
		           	System.out.println("Inside else condition");
		           	buffer.append("<tr>\n");
		           	buffer.append("<td lotus_celltype=\"label\" bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" colspan=\"9\" height=\"19\" nowrap><b>No Users deleted for the selected Sales org</b></td>\n");
					buffer.append("</tr>");
			           }
						//buffer.append("<tr><td lotus_celltype=\"blank\" colspan=\"25\" bgcolor=\"#ffffff\" align=\"center\" valign=\"bottom\" height=\"19\">&#160;</td></tr>\n");
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