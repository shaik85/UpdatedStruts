/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.multipleaction;


/**
 * <p>Creates new objects that implement the ImageButtonBean interface. If available, the Struts 
 * ImageButtonBean class (or subclass, thereof) is used. Otherwise, the class that is bundled with
 * the MultipleButtonManager package is used.</p>
 */
public class ImageButtonBeanFactory {

	/**
     */
    public static final String IMAGE_BUTTON_CLASS_NAME = "com.ibm.isc.customerfulfillment.bhoppt.controller.multipleaction.ImageButtonBean";  //$NON-NLS-1$ 

	/**
	 * (Private) Constructor.
	 */
	private ImageButtonBeanFactory() {
		super();
	}

	/**
	 * Contains the static instance of the ImageButtonBeanFactory.
	 */
	private static ImageButtonBeanFactory imageButtonBeanFactory = new ImageButtonBeanFactory();

	/**
	 * Returns an instance of the ImageButtonBeanFactory.
	 *  
	 * @return ImageButtonBeanFactory
	 */
	public static ImageButtonBeanFactory createFactory() {
		return imageButtonBeanFactory;
	}

	/**
	 * Returns a new instance of an object that implements the ImageButtonBean interface, after 
	 * initializing the ImageButtonBean <b>name</b> property to the value found in <i>buttonName</i>.
	 * 
	 * @param buttonName String containing the name to be assigned to the new ImageButtonBean
	 * @return ImageButtonBean
	 */
	public ImageButtonBean createImageButtonBean(String buttonName) 
	{
		try {
			return ImageButtonBeanFactory.createFactory().newImageButtonBean(buttonName);
		} catch (Throwable ex) {}
		return null;
	}

	/**
     * Returns a new instance of an object that implements the ImageButtonBean interface, after
     * initializing the ImageButtonBean <b>name</b> property to the value found in <i>buttonName</i>.
     *
     * @param buttonName String containing the name to be assigned to the new ImageButtonBean
     * @return ImageButtonBean
     * @throws java.lang.Throwable 
     */
	protected ImageButtonBean newImageButtonBean(String buttonName) throws Throwable 
	{
		ImageButtonBean imageButtonBean = null;
		Class imageButtonBeanClass = null;

		// try to create an instance
		try {
			imageButtonBeanClass = Class.forName(IMAGE_BUTTON_CLASS_NAME);
			imageButtonBean = (ImageButtonBean)imageButtonBeanClass.newInstance();
			if(imageButtonBean != null) {
				imageButtonBean.setName(buttonName);
			}
			return imageButtonBean;
			
		} catch (Throwable th) {
			throw th;
		}
	}
}
