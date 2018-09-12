/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.multipleaction;

import java.io.Serializable;


/**
 * <p>Provides the MultipleButtonManager with a representation of a JSP-based Image Button, created 
 * using the Struts HTML Image Custom Tag (<code>&lt;html:image &gt;</code>).</p>
 * 
 * <p>The ImageButtonBean is created and managed entirely by the MultipleButtonManager through its 
 * <code>add( String name ) : void</code> method.</p>
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class ImageButtonBean implements Serializable
{
    private String x = null;
    private String y = null;

	/** 
	 * Holds value of property name. 
	 */
	private String name;

	/**
	 * Creates a BaseImageButtonBean, initializing the <b>name</b> property to <i>name</i>.
	 * @param name String value to be used to initialize the <i>name</i> property.
	 */
	public ImageButtonBean(String name)
	{
		this();
		setName(name);
	}
	/**
     * ImageButtonBean
     * 
     * @author thirumalai
     */
    public ImageButtonBean()
	{
		super();
	}

	/**
	 * Returns a String containing the value of the <b>x</b> property.
	 * @return String
	 */
    public String getX() 
	{
        return x;
    }

	/**   
	 * Sets the <b>x</b> property to the value found in <i>x</i>.
	 * @param x String value to be used to initialize the <b>x</b> property.
	 */
    public void setX(String x) 
	{
        this.x = x;
    }

	/**
	 * Returns a String containing the value of the <b>y</b> property.
	 * @return String
	 */
    public String getY() 
	{
         return y;
    }

	/**   
	 * Sets the <b>y</b> property to the value found in <i>y</i>.
	 * @param y String value to be used to initialize the <b>y</b> property.
	 */
    public void setY(String y) 
	{
        this.y = y;
    }

	/**
	 * Returns a boolean indicating whether this ImageButtonBean is in the <i>selected</i> state.
	 * @return boolean
	 */
    public boolean isSelected() 
	{
          return ((x!=null) || (y!=null));
    }

	/** 
	 * Getter for property name.
	 * @return Value of property name.
	 */
	public String getName()
	{
		return name;
	}
	
	/** 
	 * Setter for property name.
	 * @param name New value of property name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Causes this to reset itself
	 */
	public void reset()
	{
		setX(null);
		setY(null);
	}
}
