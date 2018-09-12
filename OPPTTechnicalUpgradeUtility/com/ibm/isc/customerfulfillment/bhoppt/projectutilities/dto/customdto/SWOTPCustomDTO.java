/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * SWO Custom DTO 
 * 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 19, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class SWOTPCustomDTO extends OPPTCustomDTO
{
	private String number=null;
	private String serialNumber=null;
	private String externalContractNumber=null;
	private String contractType=null;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public SWOTPCustomDTO()
	{
	}
	/** 
	 * return the value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getContractType()
	{
		return contractType;
	}

	/** 
	 * 
	 * return the value
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getExternalContractNumber()
	{
		return externalContractNumber;
	}

	/** 
	 * return the value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getNumber()
	{
		return number;
	}

	/** 
	 * 
	 * return the value
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSerialNumber()
	{
		return serialNumber;
	}

	/** 
	 * setthe value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setContractType(String string)
	{
		contractType = string;
	}

	/** 
	 * setthe value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setExternalContractNumber(String string)
	{
		externalContractNumber = string;
	}

	/** 
	 * 
	 * setthe value
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setNumber(String string)
	{
		number = string;
	}

	/** 
	 * set the value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSerialNumber(String string)
	{
		serialNumber = string;
	}

}
