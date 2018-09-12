/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.connector.UserProfileConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.OPPTDomainDTO;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Sep 24, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1x
 */
public class ReverificationReportDomainDTO extends OPPTDomainDTO {
	private String salesOrg = null;
	private Map users = null;
	 
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
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSalesOrg() {
		return salesOrg;
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
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public Map getUsers() {
		if(null == users){
			users = new TreeMap();
		}
		return users;
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
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSalesOrg(String string) {
		salesOrg = string;
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
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setUsers(Map map) {
		users = map;
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
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUser 
	 */
	public void addUser(ReverificationReportUserDomainDTO newUser){
		if(null != newUser){
			getUsers().put(newUser.getUserID(), newUser);
		}
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
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userID
	 * @param lsalesOrg
	 * @param accessType 
	 */
	
	public void addUser(String userID, String lsalesOrg, String accessType){
		if(null != userID && null != lsalesOrg && null != accessType){
			ReverificationReportUserDomainDTO user = (ReverificationReportUserDomainDTO)getUsers().get(userID);
			
			if(null == user){
				user = new ReverificationReportUserDomainDTO();
				user.setUserID(userID);
				addUser(user);
			}
			
			user.addSalesOrg(lsalesOrg, accessType);
		}
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
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userID
	 * @param firstName
	 * @param lastName
	 * @param  userPresentInBluePages
	 */
	public void updateUserProfile(String userID, String firstName, String lastName, boolean userPresentInBluePages){
		if(null != userID){
			ReverificationReportUserDomainDTO user = (ReverificationReportUserDomainDTO)getUsers().get(userID);
			if(null != user){
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setUserPresentInBluePages(userPresentInBluePages);
			}
		}
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
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userProfileConnectorDTO
	 * @param userPresentInWI
	
	 */
	public void updateUserProfile(UserProfileConnectorDTO userProfileConnectorDTO, boolean userPresentInWI){
		if(null != userProfileConnectorDTO.getUserID()){
			ReverificationReportUserDomainDTO user = (ReverificationReportUserDomainDTO)getUsers().get(userProfileConnectorDTO.getUserID());
			if(null != user){
				user.setFirstName(userProfileConnectorDTO.getFirstName());
				user.setLastName(userProfileConnectorDTO.getLastName());
				user.setManagerEmail(userProfileConnectorDTO.getManagerEmailAddress());
				user.setManagerName(userProfileConnectorDTO.getManagerFirstName()+ " "+ userProfileConnectorDTO.getManagerLastName());  /* NOI18N */
				user.setUserPresentInBluePages(userProfileConnectorDTO.isAuthenticated());
			}
		}
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
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	
	 */
	public void cleanUpUsersFromOPPT(){
		if(null != users){
			Iterator userIterator = users.keySet().iterator();
			ArrayList userList = new ArrayList();
			while(userIterator.hasNext()){
				String userKey = (String)userIterator.next();
				ReverificationReportUserDomainDTO user = (ReverificationReportUserDomainDTO)users.get(userKey);
				if(!user.isUserPresentInOPPT()){
					userList.add(userKey);
				}
			}
			int size = userList.size();
			for(int i=0; i<size; i++){
				users.remove(userList.get(i));
			}
		}
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
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	
	 */
	public void cleanUpUsersNotInBluePages(){
		if(null != users){
			Iterator userIterator = users.keySet().iterator();
			ArrayList userList = new ArrayList();
			while(userIterator.hasNext()){
				String userKey = (String)userIterator.next();
				ReverificationReportUserDomainDTO user = (ReverificationReportUserDomainDTO)users.get(userKey);
				if(!user.isUserPresentInBluePages()){
					userList.add(userKey);
				}
			}
			int size = userList.size();
			for(int i=0; i<size; i++){
				users.remove(userList.get(i));
			}
		}
	}
}