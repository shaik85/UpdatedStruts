/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.ud;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * Connection pool for profile manager service proxy connection pool
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 18, 2005 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version CBS 1.0
 */
public class UDServiceProxyConnectionPool implements ConnectionPool, PropertyChangeListener
{
	private static final String CLASS_NAME = "UDServiceProxyConnectionPool"; /* NOI18N */

	private Vector availablePool = new Vector();
	private Vector busyPool = new Vector();
	private long timeout = 20000;

	private static final UDServiceProxyConnectionPool pool = new UDServiceProxyConnectionPool();


	/**
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br/> 
	 */
	private UDServiceProxyConnectionPool(){
		configurePool();
	}
	/** 
	 * 
	 * getInstance
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *  
	 */
	public static UDServiceProxyConnectionPool getInstance(){
		return pool;
	}

	/** 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *  
	 */
	private void configurePool()
	{
		int maxPoolSize = OPPTPropertiesReader.getConnectionPoolMaxSize();
		timeout = OPPTPropertiesReader.getConnectionPoolTimeout();

		if(1 > maxPoolSize)
		{
			int minPoolSize = OPPTPropertiesReader.getConnectionPoolMinSize();
			if(1 > minPoolSize){
				minPoolSize = 1;
				OPPTLogger.log("WI_PROXY_CONNECTION_POOL_MIN_MAX_WARNING", OPPTLogger.INFO, CLASS_NAME, "configurePool", null);
			}
			maxPoolSize = minPoolSize;
		}

		OPPTLogger.debug("UDServiceProxy Connection Pool Loading...", CLASS_NAME, "configurePool");
		
		for(int i=0; i<maxPoolSize; i++)
		{
			UDServiceProxy proxy = new UDServiceProxy();
	//		proxy.addPropertyChangeListener(this);
			availablePool.add(proxy);
			OPPTLogger.debug("UDServiceProxy Connection Pool Loading...["+(i+1)+"]", CLASS_NAME, "configurePool");
		}

		OPPTLogger.debug("UDServiceProxy Connection Pool Loaded.", CLASS_NAME, "configurePool");
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.connector.webidentity.ConnectionPool#checkOut() 
	 * @return UDServiceProxy
	 * @throws ResourceAllocationException 
	 * 
	 */
	public UDServiceProxy checkOut() throws ConnectorException
	{
		UDServiceProxy proxy = getConnection();

		if(null == proxy)
		{
			try
			{
				OPPTLogger.debug("Into wait state", CLASS_NAME, "checkOut");
				synchronized (this){
					wait(timeout);
				}
			}
			catch(InterruptedException err){
				// ignore this exception....
			}

			proxy = getConnection();

			if(null == proxy){
				throw ExceptionGenerator.generateConnectorException(ErrorCodeConstants.C0005);
			}
		}

		return proxy;
	}
	/** 
	 * getConnection
	 * 
	 * <br/><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.connector.webidentity.ConnectionPool#checkOut() 
	 * @return UDServiceProxy
     */
	private UDServiceProxy getConnection()
	{
		UDServiceProxy proxy = null;

		if(0 < availablePool.size())
		{
			proxy = (UDServiceProxy)availablePool.remove(0);
			busyPool.add(proxy);
		}

		return proxy;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent) 
	 * @param evt 
	 * 
	 */
	public void propertyChange(PropertyChangeEvent evt)
	{
		UDServiceProxy proxy = (UDServiceProxy) evt.getNewValue();

		if(busyPool.remove(proxy)){
			availablePool.add(proxy);
			OPPTLogger.debug(new StringBuffer("about to notify ").append(proxy).toString(), CLASS_NAME, "propertyChange");
			synchronized(this){
				notify();
			}
		}
		else {
			OPPTLogger.log("WI_CONNECTION_POOL_UNABLE_TO_REMOVE", OPPTLogger.WARNING, CLASS_NAME, "propertyChange", null);
		}
	}
}