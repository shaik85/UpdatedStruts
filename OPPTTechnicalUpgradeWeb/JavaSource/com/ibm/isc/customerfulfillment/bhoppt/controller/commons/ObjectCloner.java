/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ObjectCloner
 * 
 * @author vinodkumarb
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ObjectCloner {
	
	//	so that nobody can accidentally create an ObjectCloner object
	private ObjectCloner(){}
	
	// returns a deep copy of an object
	/**
     * deepCopy
     * 
     * @param oldObj
     * @throws java.lang.Exception
     * @return
     * @author thirumalai
     */
    public static Object deepCopy(Object oldObj) throws Exception
	{
	   ObjectOutputStream oos = null;
	   ObjectInputStream ois = null;
	   try
	   {
		  ByteArrayOutputStream bos = new ByteArrayOutputStream();
		  oos = new ObjectOutputStream(bos);

		  // serialize and pass the object
		  oos.writeObject(oldObj);
		  oos.flush();
		  
		  ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
		  ois = new ObjectInputStream(bin);
		  
		  // return the new object
		  return ois.readObject();
	   }
	   catch(Exception e)
	   {
		  throw(e);
	   }
	   finally
	   {
		  oos.close();
		  ois.close();
	   }
	}
}