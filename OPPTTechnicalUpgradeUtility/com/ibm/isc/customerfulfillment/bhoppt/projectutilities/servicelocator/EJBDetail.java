/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 23, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A 
 */
public class EJBDetail {
	/**
	 * For storing EJB reference name 
	 */
	private String ejbReference = "";  /* NOI18N */
	
	/**
	 * For storing EJB JNDI 
	 */
	private String ejbJndi = "";  /* NOI18N */
	/**
	 * For storing fully qualified Home Class Name
	 */
	private String ejbHome = "";  //$NON-NLS-1$
	
	/**
	 *  
	 * For setting EJB Reference
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
	 * @param iejbReference String
	 */
	public void setEJBReference(String iejbReference){
		ejbReference = iejbReference;
	}
	
	/**
	 *  
	 * For retrieving EJB Reference 
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
	 * @return String
	 */
	public String getEJBReference(){
		return ejbReference;
	}
	
	/**
	 *  
	 * For setting EJB JNDI
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
	 * @param iejbJndi String
	 */
	public void setEjbJndi(String iejbJndi){
		ejbJndi = iejbJndi;
	}
	
	/**
	 *  
	 * For retrieving EJB JNDI
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
	 * @return String
	 */
	public String getEjbJndi(){
		return ejbJndi;
	}
	
	/**
     * For setting EJB Home
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 25, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param iejbHome 
     */
	public void setEJBHome(String iejbHome){
		ejbHome = iejbHome;
	}
		
	/**
	 *  
	 * For retrieving EJB Home
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
	 * @return String
	 */
	public String getEJBHome(){
		return ejbHome;
	}

}
