/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;


/** 
 * Input ConnectorDTO Serializer
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class RetrieveSalesOrgAuthInputConnectorDTO
	implements ConnectorDTOInterface {

    
    private GenericConnectorDTO genericConnectorDTO;
		private String salesOrg;

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
		public GenericConnectorDTO getGenericConnectorDTO() {
			return genericConnectorDTO;
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
		 * date Dec 27, 2003 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param  connectorDTO
		 */
		public void setGenericConnectorDTO(GenericConnectorDTO connectorDTO) {
			genericConnectorDTO = connectorDTO;
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
		 * @param  string
		 */
		public void setSalesOrg(String string) {
			salesOrg = string;
		}

}
