/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.multipleaction;

import org.apache.commons.beanutils.*;
import org.apache.struts.action.*;

/**
 * <p>Creates new objects that implement the MultipleButtonManager interface.</p> 
 */
public class MultipleButtonManagerFactory
{

	/**
	 * Contains the default MultipleButtonManager class name
	 */
	public static String MULTIPLE_BUTTON_MANAGER_CLASS_NAME = "com.ibm.isc.customerfulfillment.bhoppt.controller.multipleaction.MultipleButtonManager";  //$NON-NLS-1$

	/**
	 * Contains the static instance of the MultipleButtonManagerFactory.
	 */
	private static MultipleButtonManagerFactory imageButtonBeanManagerFactory = new MultipleButtonManagerFactory();

	/**
	 * (Private) Constructor.
	 */
	private MultipleButtonManagerFactory()
	{
		super();
	}

	/**
	 * Returns an instance of the MultipleButtonManagerFactory.
	 * 
	 * @return MultipleButtonManagerFactory
	 */
	public static MultipleButtonManagerFactory createFactory()
	{
		return imageButtonBeanManagerFactory;
	}

	/**
	 * Returns a new instance of an object that implements the MultipleButtonManager interface.
	 * 
	 * @return MultipleButtonManager
	 */
	public MultipleButtonManager createImageButtonBeanManager()
	{
		try {
			return MultipleButtonManagerFactory.createFactory().newImageButtonBeanManager();
		}
		catch(Exception ex){}
		return null;
	}

	/**
     * Returns a new instance of an object that implements the MultipleButtonManager interface.
     *
     * @return MultipleButtonManager
     * @throws java.lang.Exception 
     */
	protected MultipleButtonManager newImageButtonBeanManager() throws Exception
	{
		Class imageButtonBeanManagerClass = null;
		MultipleButtonManager imageButtonBeanManager = null;
		try
		{
			imageButtonBeanManagerClass = Class.forName(MULTIPLE_BUTTON_MANAGER_CLASS_NAME);
			imageButtonBeanManager = (MultipleButtonManager)imageButtonBeanManagerClass.newInstance();
			return imageButtonBeanManager;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	/** 
	 * Returns an MultipleButtonManager from the ActionForm <i>form</i>.
	 * 
	 * @param form ActionForm from which the MultipleButtonManager is to be returned
	 * @return MultipleButtonManager
	 */
	public MultipleButtonManager getImageButtonBeanManager(ActionForm form )
	{
		if ( form == null ) {
			return null;
		}
		
		MultipleButtonManager imageButtonBeanManager = null;
		
		try
		{
			// try the Property approach
			imageButtonBeanManager = (MultipleButtonManager)PropertyUtils.getProperty(form, MultipleButtonManager.PROPERTY_NAME );
		}
		catch( Exception ex )
		{
		}
		
		return imageButtonBeanManager;
	}
}
