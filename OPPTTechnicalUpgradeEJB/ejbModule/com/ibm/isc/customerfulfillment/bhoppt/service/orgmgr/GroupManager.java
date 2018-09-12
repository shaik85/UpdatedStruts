/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateGroupCustomDTO;
/**
 * Remote interface for Enterprise Bean: GroupManager
 */
public interface GroupManager extends javax.ejb.EJBObject {
	/**
	 * listGroupsInSalesOrg
	 */
	public GroupsCustomDTO listGroupsInSalesOrg(GroupsCustomDTO groupsCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * getUsersOfGroup
	 */
	public void getUsersOfGroup()
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * removeGroup
	 */
	public GroupCustomDTO removeGroup(GroupCustomDTO groupCustomDTO)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * createGroup
	 */
	public CreateGroupCustomDTO createGroup(CreateGroupCustomDTO createGroupCustomDTO)
		throws ServiceException, java.rmi.RemoteException;
}
