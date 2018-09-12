/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import java.util.HashMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.EditCustomerDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.EditDMDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.EditSWODataBean;


public class EditInventoryActionForm extends OPPTActionForm {
	private HashMap customers = new HashMap();
	private HashMap dms = new HashMap();
	private HashMap swos = new HashMap();

	/**
	 * @param key
	 * @return
	 */
	public EditCustomerDataBean getCustomer(String key){
		EditCustomerDataBean customer = null;
		try{
			customer = (EditCustomerDataBean)customers.get(key);
		}
		catch(NullPointerException e){}
		if(null == customer){
			customer = new  EditCustomerDataBean();
			customers.put(key, customer);
		}
		return customer;
	}
	
	/**
	 * @return
	 */
	public HashMap getCustomers(){
		return customers;
	}

	/**
	 * @param key
	 * @return
	 */
	public EditDMDataBean getDm(String key){
		EditDMDataBean dm = null;
		try{
			dm = (EditDMDataBean)dms.get(key);
		}
		catch(NullPointerException e){}
		if(null == dm){
			dm = new  EditDMDataBean();
			dms.put(key, dm);
		}
		return dm;
	}

	/**
	 * @return
	 */
	public HashMap getDMs(){
		return dms;
	}

	/**
	 * @param key
	 * @return
	 */
	public EditSWODataBean getSwo(String key){
		EditSWODataBean swo = null;
		try{
			swo = (EditSWODataBean)swos.get(key);
		}
		catch(NullPointerException e){}
		if(null == swo){
			swo = new  EditSWODataBean();
			swos.put(key, swo);
		}
		return swo;
	}

	/**
	 * @return
	 */
	public HashMap getSWOs(){
		return swos;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		customers = new HashMap();
		dms = new HashMap();
		swos = new HashMap();
	}
}