/*
 * Created on May 13, 2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/*
* IBM Confidential
*
* ©  Copyright IBM Corp. 2004, 2005  All Rights Reserved.

* The source code for this program is not published or otherwise divested of
* its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
*/
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMapping;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FetchSelectedInventoryActionForm extends OPPTActionForm{
	
	private String [] DesignatedMachineID;
	private String [] MaterialID;
	private String [] SerialNumber;
	Map list1=new HashMap();
	Map list2=new HashMap();
	Map list3=new HashMap();
	int CNT=0;
	
	ArrayList DesignatedMachineIDList=null;
	ArrayList MaterialIDList=null;
	ArrayList SerialNumberList=null;
	public void reset(ActionMapping mapping, HttpServletRequest request) 
	{
		this.DesignatedMachineID=null;
		this.MaterialID=null;
		this.SerialNumber=null;
		DesignatedMachineID=request.getParameterValues("DesignatedMachineID");
		MaterialID=request.getParameterValues("MaterialID");
		SerialNumber=request.getParameterValues("SerialNumber");
		//String n= request.getParameter("cnt");
		
		   	int i=0;
			int noOfCustomers=0;
			int k=0,l=0;
			int z=0;
			int j=1;
			int p=0;
			//int cnt=DesignatedMachineID.length+MaterialID.length+SerialNumber.length;
			int cnt=DesignatedMachineID.length;
			
			HttpSession session=request.getSession(true);
			Integer s= (Integer)session.getAttribute("CNT");
					
			int count=s.intValue();
			int lpVal=s.intValue()*5;
			
			while(z<count)
			{
				DesignatedMachineIDList=new ArrayList();
				MaterialIDList=new ArrayList();
				SerialNumberList=new ArrayList();
				
				//k=0;
				//l=0;
				//p=0;
				
				
			for (k=0;k<5;k++)
			{
				
				if(DesignatedMachineID[i]==null || MaterialID[i]==null || SerialNumber[i]==null)
				    {
					DesignatedMachineID[i]=" ";
					MaterialID[i]=" ";
					SerialNumber[i]=" ";
				    }				
				DesignatedMachineIDList.add(k,DesignatedMachineID[i]);
				MaterialIDList.add(k,MaterialID[i]);
				SerialNumberList.add(k,SerialNumber[i]);
	    	    i++;   	    		    
			}
			list1.put(new Integer(z),DesignatedMachineIDList);
			list2.put(new Integer(z),MaterialIDList);
			list3.put(new Integer(z),SerialNumberList);
			//j=0;
			z++;
			}	
			
			setList1(list1);
			setList2(list2);
			setList3(list3);
		list1.remove(MaterialIDList);
		list1.remove(DesignatedMachineIDList);
		list1.remove(SerialNumberList);
		list2.remove(MaterialIDList);
		list2.remove(DesignatedMachineIDList);
		list2.remove(SerialNumberList);
		list3.remove(MaterialIDList);
		list3.remove(DesignatedMachineIDList);
		list3.remove(SerialNumberList);
	}
   

	public FetchSelectedInventoryActionForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return Returns the desginatedMachine.
	
	}
}
	/**
	 * @return Returns the designatedMachineID.
	 */
	public String[] getDesignatedMachineID() {
		return DesignatedMachineID;
	}
	/**
	 * @param designatedMachineID The designatedMachineID to set.
	 */
	public void setDesignatedMachineID(String[] designatedMachineID) {
		DesignatedMachineID = designatedMachineID;
	}
	/**
	 * @return Returns the materialID.
	 */
	public String[] getMaterialID() {
		return MaterialID;
	}
	/**
	 * @param materialID The materialID to set.
	 */
	public void setMaterialID(String[] materialID) {
		MaterialID = materialID;
	}
	/**
	 * @return Returns the designatedMachineIDList.
	 */
	public ArrayList getDesignatedMachineIDList() {
		return DesignatedMachineIDList;
	}
	/**
	 * @param designatedMachineIDList The designatedMachineIDList to set.
	 */
	public void setDesignatedMachineIDList(ArrayList designatedMachineIDList) {
		DesignatedMachineIDList = designatedMachineIDList;
	}
	/**
	 * @return Returns the list1.
	 */
	public Map getList1() {
		return list1;
	}
	/**
	 * @param list1 The list1 to set.
	 */
	public void setList1(Map list1) {
		this.list1 = list1;
	}
	/**
	 * @return Returns the list2.
	 */
	public Map getList2() {
		return list2;
	}
	/**
	 * @param list2 The list2 to set.
	 */
	public void setList2(Map list2) {
		this.list2 = list2;
	}
	/**
	 * @return Returns the materialIDList.
	 */
	public ArrayList getMaterialIDList() {
		return MaterialIDList;
	}
	/**
	 * @param materialIDList The materialIDList to set.
	 */
	public void setMaterialIDList(ArrayList materialIDList) {
		MaterialIDList = materialIDList;
	}
	/**
	 * @return Returns the list3.
	 */
	public Map getList3() {
		return list3;
	}
	/**
	 * @param list3 The list3 to set.
	 */
	public void setList3(Map list3) {
		this.list3 = list3;
	}
	/**
	 * @return Returns the serialNumber.
	 */
	public String[] getSerialNumber() {
		return SerialNumber;
	}
	/**
	 * @param serialNumber The serialNumber to set.
	 */
	public void setSerialNumber(String[] serialNumber) {
		SerialNumber = serialNumber;
	}
	/**
	 * @return Returns the serialNumberList.
	 */
	public ArrayList getSerialNumberList() {
		return SerialNumberList;
	}
	/**
	 * @param serialNumberList The serialNumberList to set.
	 */
	public void setSerialNumberList(ArrayList serialNumberList) {
		SerialNumberList = serialNumberList;
	}
}
