/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**


 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class UseridMaintInputConnectorDTO implements ConnectorDTOInterface 
{
	private String flag;
	private String accessReq;
	private String [] salesOrg;
	private String [] accessType;
	private GenericConnectorDTO genericConnectorDTO;  
	/** 
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public UseridMaintInputConnectorDTO() 
	{
		
	}
	/** 
	 * To get the Generic ConnectorDTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return GenericConnectorDTO
	 */
	public GenericConnectorDTO getGenericConnectorDTO()
	{
		return genericConnectorDTO;
	}
	/** 
	 * To set the Generic ConnectorDTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param connectorDTO 
	 */
	public void setGenericConnectorDTO(GenericConnectorDTO connectorDTO)
	{
		genericConnectorDTO = connectorDTO;
	}
	/** 
	 * To get the 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getFlag()
	{
		return flag;
	}
	/** 
	 * To get the 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String []
	 */
	public String [] getSalesOrg()
	{
		return salesOrg;
	}
	/** 
	 * To get the 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String [] getAccessType()
	{
		return accessType;
	}
	/** 
	 * To get the 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getAccessReq()
	{
		return accessReq;
	}
	/**
     * To get the
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 21, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newFlag 
     */
	public void setFlag(String newFlag)
	{
		flag = newFlag;
	}
	/** 
	 * To get the 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param newSalesOrg
	 */
	public void setSalesOrg(String [] newSalesOrg)
	{
		salesOrg = newSalesOrg;
	}	
	/** 
	* To get the 
	*  
	* <br><b>Known Bugs</b><br> 
	* 
	* <br><PRE> 
	* date Nov 21, 2003 
	* 
	* revision date author reason 
	* 
	* </PRE><br> 
	* @param newAccessType
	*/
	public void setAccessType(String [] newAccessType)
	{
		accessType = newAccessType;
	}
	/**
     * To get the
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 21, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newAccessReq 
     */
	public void setAccessReq(String newAccessReq)
	{
		accessReq = newAccessReq;
	}
	
}
