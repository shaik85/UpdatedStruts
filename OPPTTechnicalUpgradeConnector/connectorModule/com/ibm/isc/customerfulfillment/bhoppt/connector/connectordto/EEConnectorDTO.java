/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * EEConnector DTO
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class EEConnectorDTO implements ConnectorDTOInterface
{
	private String salesDocumentNumber;
	private String eEItemPositionNumber;
	private String sWOItemPositionNumber;
	private String valueMetric;
	private String useLevel;
	private String licenseType;
	private String eEMaterialNumber;
	private String descriptionOfEEMaterial;
	private String chargeOption;
	private double firstMonthListPrice;
	private String pLETNo;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public EEConnectorDTO()
	{
	}

	/** 
	 * To get the Charge Option
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
	public String getChargeOption()
	{
		return chargeOption;
	}

	/** 
	 * To get the Description of EE material 
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
	public String getDescriptionOfEEMaterial()
	{
		return descriptionOfEEMaterial;
	}

	/** 
	 * To get the EE Item position number
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
	public String getEEItemPositionNumber()
	{
		return eEItemPositionNumber;
	}

	/** 
	 * To get the EE Material number 
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
	public String getEEMaterialNumber()
	{
		return eEMaterialNumber;
	}

	/** 
	 * To get the first month list price
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
	public double getFirstMonthListPrice()
	{
		return firstMonthListPrice;
	}

	/** 
	 * To get the license type 
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
	public String getLicenseType()
	{
		return licenseType;
	}

	/** 
	 * To get the PLET number
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
	public String getPLETNo()
	{
		return pLETNo;
	}

	/** 
	 * To get the sales document number
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
	public String getSalesDocumentNumber()
	{
		return salesDocumentNumber;
	}

	/** 
	 * To get the SWO Item position number
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
	public String getSWOItemPositionNumber()
	{
		return sWOItemPositionNumber;
	}

	/** 
	 * To get the Use level
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
	 * @return String
	 */
	public String getUseLevel()
	{
		return useLevel;
	}

	/** 
	 * To get the value metric
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
	public String getValueMetric()
	{
		return valueMetric;
	}

	/** 
	 * To set the charge option
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
	 * @param lchargeOption
	 */
	public void setChargeOption(String lchargeOption)
	{
		chargeOption = lchargeOption;
	}

	/** 
	 * To set the description of EE material
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
	 * @param desc
	 */
	public void setDescriptionOfEEMaterial(String desc)
	{
		descriptionOfEEMaterial = desc;
	}

	/** 
	 * To set the EE Item position number
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
	 * @param positionNo
	 */
	public void setEEItemPositionNumber(String positionNo)
	{
		eEItemPositionNumber = positionNo;
	}

	/** 
	 * To set the EE Matieral Number
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
	 * @param materialNumber 
	 */
	public void setEEMaterialNumber(String materialNumber)
	{
		eEMaterialNumber = materialNumber;
	}

	/** 
	 * To set the first month list price
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
	 * @param listPrice 
	 */
	public void setFirstMonthListPrice(double listPrice)
	{
		firstMonthListPrice = listPrice;
	}

	/** 
	 * To set the License Type
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
	 * @param licType
	 */
	public void setLicenseType(String licType)
	{
		licenseType = licType;
	}

	/** 
	 * To set the PLET number
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
	 * @param number
	 */
	public void setPLETNo(String number)
	{
		pLETNo = number;
	}

	/** 
	 * To set the sales document number
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
	 * @param string
	 */
	public void setSalesDocumentNumber(String string)
	{
		salesDocumentNumber = string;
	}

	/** 
	 * To set the SWO Item Position Number
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
	 * @param positionNo
	 */
	public void setSWOItemPositionNumber(String positionNo)
	{
		sWOItemPositionNumber = positionNo;
	}

	/** 
	 * To set the use level 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param luseLevel
	 */
	public void setUseLevel(String luseLevel)
	{
		useLevel = luseLevel;
	}

	/** 
	 * To set the value metric
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
	 * @param lvalueMetric 
	 */
	public void setValueMetric(String lvalueMetric)
	{
		valueMetric = lvalueMetric;
	}
}
