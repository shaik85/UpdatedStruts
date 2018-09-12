/*
 * Created on Mar 18, 2011
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ReverificationReportDomainDTO;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DeletedUsersReportCustomDTO extends OPPTCustomDTO{

	
	
	private String salesOrg = null;
	private Date reportPrintedDate = null;
	private ReverificationReportDomainDTO reportDTO;
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
	 * @return String 
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
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Sep 24, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param newSalesOrg 
     */
	public void setSalesOrg(String newSalesOrg) {
		salesOrg = newSalesOrg;
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
	 * date Sep 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ReverificationReportDomainDTO
	 */
	public ReverificationReportDomainDTO getReportDTO() {
		return reportDTO;
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
	 * date Sep 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param domainDTO 
	 */
	public void setReportDTO(ReverificationReportDomainDTO domainDTO) {
		reportDTO = domainDTO;
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
	 * date Sep 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getReportPrintedDate() {
		return reportPrintedDate;
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
	 * date Sep 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setReportPrintedDate(Date string) {
		reportPrintedDate = string;
	}

}
