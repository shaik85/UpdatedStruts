/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;


import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceInformationCustomDTO;

/**
 * Holds variance information of a proposal  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 25, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class VarianceDataBean extends OPPTDataBean{
	private double capAmount;
	private double capPlus;
	private double capMinus;
	
	/**
	 * Returns cap amount of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	public double getCapAmount() {
		return capAmount;
	}

	/**
	 * Returns cap minus value for the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	public double getCapMinus() {
		return capMinus;
	}

	/**
	 * Returns cap plus value of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	public double getCapPlus() {
		return capPlus;
	}

	/**
	 * Sets cap amount value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCapAmount double 
	 */
	public void setCapAmount(double newCapAmount) {
		capAmount = newCapAmount;
	}

	/**
	 * Sets cap minus value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCapMinus double 
	 */
	public void setCapMinus(double newCapMinus) {
		capMinus = newCapMinus;
	}

	/**
	 * Sets cap plus value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCapPlus double 
	 */
	public void setCapPlus(double newCapPlus) {
		capPlus = newCapPlus;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param capAmount double
	 * @param capPlus double
	 * @param capMinus double
	 */
	public void setData(double capAmount, double capPlus, double capMinus){
		setCapAmount(capAmount);
		setCapPlus(capPlus);
		setCapMinus(capMinus);
	}

	/**
     * VarianceDataBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(VarianceInformationCustomDTO customDTO){
		if(null != customDTO){
			setCapAmount(customDTO.getCapAmount());
			setCapPlus(customDTO.getCapPlus());
			setCapMinus(customDTO.getCapMinus());
		}
	}
	
	/**
     * VarianceDataBean
     * 
     * @author thirumalai
     */
    public VarianceDataBean(){
	}
	
	public VarianceDataBean(VarianceInformationCustomDTO customDTO){
		setData(customDTO);
	}

	/**
     * toString
     * 
     * @see java.lang.Object#toString()
     * @author thirumalai
     */
    public String toString(){
		StringBuffer strValue = new StringBuffer();
		
		strValue.append("[VarianceDataBean] - [toString] - Start...");  //$NON-NLS-1$
		strValue.append("\nCap amount: "+getCapAmount());  //$NON-NLS-1$
		strValue.append("\nCap plus: "+getCapPlus());  //$NON-NLS-1$
		strValue.append("\nCap minus: "+getCapMinus());  //$NON-NLS-1$
		strValue.append("[VarianceDataBean] - [toString] - End...");  //$NON-NLS-1$

		return strValue.toString();
	}

	/**
     * equals
     * 
     * @param dataBean
     * @return
     * @author thirumalai
     */
    public boolean equals(VarianceDataBean dataBean)
	{
		boolean equal = true;
		
		if(null != dataBean){
			if(capAmount != dataBean.getCapAmount()){
				equal = false;
			}
			else if(capPlus != dataBean.getCapPlus()){
				equal = false;
			}
			else if(capMinus != dataBean.getCapMinus()){
				equal = false;
			}
		}
		
		return equal;
	}
}
