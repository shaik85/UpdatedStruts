/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.multipleaction;

import org.apache.struts.action.*;
import org.apache.commons.lang.*;

import javax.servlet.http.HttpServletRequest;

import java.io.Serializable;
import java.util.*;

/**
 * <p>Provides encapsulated ImageButtonBean-oriented support services for Struts Actions, Struts ActionForms 
 * and Struts-oriented JSPs.</p>
 */
public class MultipleButtonManager implements Map, Serializable
{
	/**
	 * A constant that can be used to consistently refer to the property name of the ActionForm's imageButtonBeanManager.
	 */
	public static String PROPERTY_NAME = "multipleButtonManager";  //$NON-NLS-1$

	/** 
	 * Holds the collection of ImageButtonBeans that are currently defined 
	 */
	private Map imageButtonBeans = null;

	/** 
	 * Holds value of property caseSensitive. 
	 */
	private boolean caseSensitive = true;

	/** 
	 * Holds value of property autoCreateImageButtonBeanMode. 
	 */
	private boolean autoCreateImageButtonBeanMode = true;

	/** 
	 * Adds <i>imageButtonBean</i> to the collection of imageButtonBeans that are currently being managed.
	 * @param imageButtonBean ImageButtonBean to be added
	 */	
	public void add(ImageButtonBean imageButtonBean)
	{
		if (imageButtonBean != null) {
			getImageButtonBeans().put(getCaseSensitiveCompliantName(imageButtonBean.getName()), imageButtonBean);
		}
	}

	/** 
	 * Creates an ImageButtonBean having the name <i>buttonName</i>, then adds the ImageButtonBean
	 * to the collection of imageButtonBeans that are currently being managed.
	 * @param buttonName String containing the name of the ImageButtonBean to be added
	 */	
	public void add(String buttonName)
	{
		add(ImageButtonBeanFactory.createFactory().createImageButtonBean(getCaseSensitiveCompliantName(buttonName)));
	}

	/** 
	 * Resets the MultipleButtonManager.
	 * <p>If the MultipleButtonManager instance variable is created only once within the ActionForm,
	 * this method should be executed from within the ActionForm's <code>reset()</code> method.<br/>
	 * Otherwise (where the MultipleButtonManager instance variable is re-instianted within the
	 * ActionForm's <code>reset()</code> method), it is not necessary to execute this method.</p>
	 * 
	 * @param mapping Struts ActionMapping
	 * @param request HttpServletRequest
	 */	
	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		clear();
	}

	/** 
	 * <p>Returns the Struts ActionForward that is mapped to the currently selected ImageButton.</p>
	 * <p>If no such ActionForward can be found readily, there is a search for a default ActionForward.
	 * If found, it is returned.</p>
	 * <p>Null is returned if there is no ActionForward that maps to the currently selected ImageButton,
	 * or if there is no currently selected ImageButton. </p>
	 * 
	 * @param mapping Struts ActionMapping
	 * @param form the current ActionForm
	 * @param request HttpServletRequest
	 * @return ActionForward
	 */	
	public ActionForward getActionForward(ActionMapping mapping, ActionForm form, HttpServletRequest request)
	{
		ImageButtonBean imageButtonBean = getSelected();
		if (imageButtonBean != null) {
			return getActionForward(mapping, form, request, imageButtonBean.getName());
		
		} else {
			return null;
		}
	}

	/** 
	 * Returns the Struts ActionForward that is mapped to <i>buttonName</I>.
	 * <p>Null is returned if there is no ActionForward that is mapped to <i>buttonName</I>.
	 * 
	 * @param mapping Struts ActionMapping
	 * @param form the current ActionForm
	 * @param request HttpServletRequest
	 * @param buttonName String containing the name of the ImageButton whose mapped 
	 * ActionForward equivalent is to be returned
	 * @return ActionForward
	 */	
	public ActionForward getActionForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, String buttonName)
	{
		if (mapping == null || StringUtils.isEmpty(buttonName)) {
			return null;
		}

		// return the ActionForward for the imageButtonBean that was selected
		ImageButtonBean imageButtonBean = (ImageButtonBean)getImageButtonBean(buttonName);
		if(imageButtonBean != null) {
			return mapping.findForward(imageButtonBean.getName());
		
		} else {
			return null;
		}
	}

	/** 
	 * Returns a boolean indicating whether there is a Struts ActionForward that is mapped to <i>buttonName</I>.
	 * 
	 * @param mapping Struts ActionMapping
	 * @param form the current ActionForm
	 * @param request HttpServletRequest
	 * @param buttonName String containing the name of the ImageButton whose mapped ActionForward 
	 * equivalent is to be returned
	 * @return boolean
	 */	
	public boolean hasActionForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, String buttonName)
	{
		return getActionForward(mapping, form, request, buttonName) != null;
	}

	/**
	 * Returns the ImageButtonBean that is currently in the <i>selected</i> state.<br/>
	 * Null is returned if no ImageButtonBean is currently in the <i>selected</i> state.
	 * 
	 * @return boolean
	 */
	public ImageButtonBean getSelected()
	{
		// get the ImageButtonBeans
		Iterator iterator = getImageButtonBeans().values().iterator();
		if (iterator == null) {
			return null;
		}

		// Iterate through image button beans and check if any one is selected and return the same.
		while(iterator.hasNext())
		{
			ImageButtonBean imageButtonBean = (ImageButtonBean)iterator.next();
			if (imageButtonBean.isSelected()) {
				return imageButtonBean;
			}
		}
		return null;
	}

	/**
	 * Returns a boolean indicating whether any of the ImageButtonBeans currently being managed
	 * is in the <i>selected</i> state.
	 * @return boolean
	 */
	public boolean isSelected()
	{
		return getSelected() != null;
	}

	/**
	 * Returns a boolean indicating whether the ImageButtonBean having the name <i>buttonName</i>
	 * is currently in the <i>selected</i> state.
	 * 
	 * @param buttonName String containing the name of the desired ImageButtonBean
	 * @return boolean
	 */
	public boolean isSelected(String buttonName)
	{
		// get the selected BaseImageButtonBean
		ImageButtonBean imageButtonBean = getSelected();
		
		// compare the selected ImageButtonBean to the buttonName
		if (imageButtonBean != null) {
			return StringUtils.equals(getCaseSensitiveCompliantName(buttonName), getCaseSensitiveCompliantName(imageButtonBean.getName()));
		
		} else {
			return false;
		}
	}

	/** 
	 * Getter for property caseSensitive.
	 * @return Value of property caseSensitive.
	 */
	public boolean isCaseSensitive()
	{
		return caseSensitive;
	}
	
	/** 
	 * Setter for property caseSensitive.
	 * @param caseSensitive New value of property caseSensitive.
	 */
	public void setCaseSensitive(boolean caseSensitive)
	{
		this.caseSensitive = caseSensitive;
	}
	
	/**
	 * Returns a String containing a version of <i>buttonName</i> that is compliant with the current 
	 * state of the <b>caseSensitive</b> property.
	 * 
	 * @param buttonName String containing the ImageBeanButton name
	 * @return String
	 */
	protected String getCaseSensitiveCompliantName(String buttonName)
	{
		if (StringUtils.isEmpty(buttonName)) {
			return buttonName;
		}

		return (isCaseSensitive() ?	buttonName : buttonName.toLowerCase());
	}

	/**
	 * Returns a Map containing ImageButtonBeans, with the keys set to the names of the respective ImageButtonBeans.
	 * 
	 * @return Map of ImageButtonBeans
	 */
	protected Map getImageButtonBeans()
	{
		if (imageButtonBeans == null) {
			imageButtonBeans = new HashMap();
		}

		return imageButtonBeans;
	}
	
	/** 
	 * Removes all mappings from this map (optional operation).
	 */
	public void clear()
	{
		imageButtonBeans = null;
	}
	
	/** 
	 * Returns <tt>true</tt> if this map contains a mapping for the specified key.  
	 * More formally, returns <tt>true</tt> if and only if this map contains at a 
	 * mapping for a key <tt>k</tt> such that <tt>(key==null ? k==null : key.equals(k))</tt>.  
	 * (There can be at most one such mapping.)
	 *
	 * @param key key whose presence in this map is to be tested.
	 * @return <tt>true</tt> if this map contains a mapping for the specified
	 *         key.
	 */
	public boolean containsKey(Object key)
	{
		return getImageButtonBeans().containsKey(getCaseSensitiveCompliantName((String)key));
	}
	
	/** 
	 * Returns <tt>true</tt> if this map maps one or more keys to the specified value.  
	 * More formally, returns <tt>true</tt> if and only if this map contains at least one 
	 * mapping to a value <tt>v</tt> such that <tt>(value==null ? v==null : value.equals(v))</tt>.  
	 * This operation will probably require time linear in the map size for most implementations 
	 * of the <tt>Map</tt> interface.
	 *
	 * @param value value whose presence in this map is to be tested.
	 * @return <tt>true</tt> if this map maps one or more keys to the specified value.
	 */
	public boolean containsValue(Object value)
	{
		return getImageButtonBeans().containsValue(getCaseSensitiveCompliantName((String)value));
	}
	
	/** 
	 * Returns a set view of the mappings contained in this map.  Each element
	 * in the returned set is a {@link Map.Entry}.  The set is backed by the
	 * map, so changes to the map are reflected in the set, and vice-versa.
	 * If the map is modified while an iteration over the set is in progress,
	 * the results of the iteration are undefined.  The set supports element
	 * removal, which removes the corresponding mapping from the map, via the
	 * <tt>Iterator.remove</tt>, <tt>Set.remove</tt>, <tt>removeAll</tt>,
	 * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not support
	 * the <tt>add</tt> or <tt>addAll</tt> operations.
	 *
	 * @return a set view of the mappings contained in this map.
	 */
	public Set entrySet()
	{
		return getImageButtonBeans().entrySet();
	}
	
	/** 
	 * Returns the value to which this map maps the specified key.  Returns
	 * <tt>null</tt> if the map contains no mapping for this key.  A return
	 * value of <tt>null</tt> does not <i>necessarily</i> indicate that the
	 * map contains no mapping for the key; it's also possible that the map
	 * explicitly maps the key to <tt>null</tt>.  The <tt>containsKey</tt>
	 * operation may be used to distinguish these two cases.
	 *
	 * <p>More formally, if this map contains a mapping from a key
	 * <tt>k</tt> to a value <tt>v</tt> such that <tt>(key==null ? k==null :
	 * key.equals(k))</tt>, then this method returns <tt>v</tt>; otherwise
	 * it returns <tt>null</tt>.  (There can be at most one such mapping.)
	 *
	 * @param key key whose associated value is to be returned.
	 * @return the value to which this map maps the specified key, or 
	 * 	       <tt>null</tt> if the map contains no mapping for this key.
	 */
	public Object get(Object key)
	{
		Object imageButtonBean = getImageButtonBeans().get(getCaseSensitiveCompliantName((String)key));

		if (imageButtonBean != null) {
			return imageButtonBean;
		}

		// check autoCreateImageButtonBeanMode
		if (!this.isAutoCreateImageButtonBeanMode()) {
			return imageButtonBean;
		}

			// confirm key is a String
		if (!(key instanceof String)) {
			return imageButtonBean;
		}

		// dynamically create the ImageButtonBean
		this.add((String)key);

		return getImageButtonBeans().get(key);
	}
	
	/** 
	 * Returns <tt>true</tt> if this map contains no key-value mappings.
	 *
	 * @return <tt>true</tt> if this map contains no key-value mappings.
	 */
	public boolean isEmpty()
	{
		return getImageButtonBeans().isEmpty();
	}
	
	/** 
	 * Returns a set view of the keys contained in this map.  The set is
	 * backed by the map, so changes to the map are reflected in the set, and
	 * vice-versa.  If the map is modified while an iteration over the set is
	 * in progress, the results of the iteration are undefined.  The set
	 * supports element removal, which removes the corresponding mapping from
	 * the map, via the <tt>Iterator.remove</tt>, <tt>Set.remove</tt>,
	 * <tt>removeAll</tt> <tt>retainAll</tt>, and <tt>clear</tt> operations.
	 * It does not support the add or <tt>addAll</tt> operations.
	 *
	 * @return a set view of the keys contained in this map.
	 */
	public Set keySet()
	{
		return getImageButtonBeans().keySet();
	}
	
	/** 
	 * Associates the specified value with the specified key in this map
	 * (optional operation).  If the map previously contained a mapping for
	 * this key, the old value is replaced by the specified value.  (A map
	 * <tt>m</tt> is said to contain a mapping for a key <tt>k</tt> if and only
	 * if {@link #containsKey(Object) m.containsKey(k)} would return
	 * <tt>true</tt>.))
	 *
	 * @param key key with which the specified value is to be associated.
	 * @param value value to be associated with the specified key.
	 * @return previous value associated with specified key, or <tt>null</tt>
	 * 	       if there was no mapping for key.  A <tt>null</tt> return can
	 * 	       also indicate that the map previously associated <tt>null</tt>
	 * 	       with the specified key, if the implementation supports
	 * 	       <tt>null</tt> values.
	 */
	public Object put(Object key, Object value)
	{
		return getImageButtonBeans().put(getCaseSensitiveCompliantName((String)key ), value);
	}
	
	/** 
	 * Copies all of the mappings from the specified map to this map
	 * (optional operation).  The effect of this call is equivalent to that
	 * of calling {@link #put(Object,Object) put(k, v)} on this map once
	 * for each mapping from key <tt>k</tt> to value <tt>v</tt> in the
	 * specified map.  The behavior of this operation is unspecified if the
	 * specified map is modified while the operation is in progress.
	 *
	 * @param mappings Mappings to be stored in this map.
	 */
	public void putAll(Map mappings)
	{
		getImageButtonBeans().putAll(mappings);
	}
	
	/** 
	 * Removes the mapping for this key from this map if it is present
	 * (optional operation).   More formally, if this map contains a mapping
	 * from key <tt>k</tt> to value <tt>v</tt> such that
	 * <code>(key==null ?  k==null : key.equals(k))</code>, that mapping
	 * is removed.  (The map can contain at most one such mapping.)
	 *
	 * <p>Returns the value to which the map previously associated the key, or
	 * <tt>null</tt> if the map contained no mapping for this key.  (A
	 * <tt>null</tt> return can also indicate that the map previously
	 * associated <tt>null</tt> with the specified key if the implementation
	 * supports <tt>null</tt> values.)  The map will not contain a mapping for
	 * the specified  key once the call returns.
	 *
	 * @param key key whose mapping is to be removed from the map.
	 * @return previous value associated with specified key, or <tt>null</tt>
	 * 	       if there was no mapping for key.
	 */
	public Object remove(Object key)
	{
		return getImageButtonBeans().remove(getCaseSensitiveCompliantName((String)key));
	}
	
	/** 
	 * Returns the number of key-value mappings in this map.  If the map contains more than 
	 * <tt>Integer.MAX_VALUE</tt> elements, returns <tt>Integer.MAX_VALUE</tt>.
	 *
	 * @return the number of key-value mappings in this map.
	 */
	public int size()
	{
		return getImageButtonBeans().size();
	}
	
	/** 
	 * Returns a collection view of the values contained in this map.  The
	 * collection is backed by the map, so changes to the map are reflected in
	 * the collection, and vice-versa.  If the map is modified while an
	 * iteration over the collection is in progress, the results of the
	 * iteration are undefined.  The collection supports element removal,
	 * which removes the corresponding mapping from the map, via the
	 * <tt>Iterator.remove</tt>, <tt>Collection.remove</tt>,
	 * <tt>removeAll</tt>, <tt>retainAll</tt> and <tt>clear</tt> operations.
	 * It does not support the add or <tt>addAll</tt> operations.
	 *
	 * @return a collection view of the values contained in this map.
	 */
	public Collection values()
	{
		return getImageButtonBeans().values();
	}

	/**
	 * Returns an ImageButtonBean whose name matches <i>buttonName</i>.
	 * @param buttonName String containing the name of the desired ImageButtonBean
	 * @return ImageButtonBean
	 */
	protected ImageButtonBean getImageButtonBean(String buttonName )
	{
		ImageButtonBean imageButtonBean = (ImageButtonBean)get(getCaseSensitiveCompliantName(buttonName));
		return imageButtonBean;
	}

	/** 
	 * Getter for property autoCreateImageButtonBeanMode.
	 * 
	 * @return Value of property autoCreateImageButtonBeanMode.
	 */
	public boolean isAutoCreateImageButtonBeanMode()
	{
		return autoCreateImageButtonBeanMode;
	}
	
	/** 
	 * Setter for property autoCreateImageButtonBeanMode.
	 * 
	 * @param autoCreateImageButtonBeanMode New value of property autoCreateImageButtonBeanMode.
	 */
	public void setAutoCreateImageButtonBeanMode(boolean autoCreateImageButtonBeanMode)
	{
		this.autoCreateImageButtonBeanMode = autoCreateImageButtonBeanMode;
	}
}
