/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;


/**
 *  RetrieveSalesOrgAuthOutputConnectorDTO
 * <br/><b>Known Bugs</b><br/>
 * <br/><PRE>
 * date Dec 4, 2003
 * revision date author reason
 * </PRE><br/>
 *
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class RetrieveSalesOrgAuthOutputConnectorDTO
	implements ConnectorDTOInterface {
		
		private String returnCode ;
		private List salesOrgAccessList;

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
		 * date Dec 27, 2003 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @return 
		 */
		public String getReturnCode() {
			return returnCode;
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
		 * date Dec 27, 2003 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @return 
		 */
		public List getSalesOrgAccessList() {
			return salesOrgAccessList;
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
		 * date Dec 27, 2003 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param string
		 */
		public void setReturnCode(String string) {
			returnCode = string;
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
		 * date Dec 27, 2003 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param list
		 */
		public void setSalesOrgAccessList(List list) {
			salesOrgAccessList = list;
		}

}
