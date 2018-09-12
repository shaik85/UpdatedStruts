/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory;

import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import javax.ejb.FinderException;
import javax.naming.NamingException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.GeoSecOffBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.GeoSecOffLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/** 
 * GeoSecOffBOFactory class. 
 * This class will create & consume Business Objects
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class GeoSecOffBOFactory
{
	/** 
	 * GeoSecOffBOFactory constructor
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  
	 */
	public GeoSecOffBOFactory()
	{
	}
	/** 
	 * This method gets the GeoSec Officer for the salesOrg provided	  
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  GeoSecOffBO
	 * @param   salesOrg
	 * @throws  DomainException
	 */
	public GeoSecOffBO findGEOSecOffBOForSalesOrg(String salesOrg) throws DomainException
	{
		GeoSecOffLocalHome geoSecOffHome =
			(GeoSecOffLocalHome) HomeProvider.getLocal(HomeProvider.GEO_SEC_OFF_LOCAL_HOME);
		GeoSecOffBO geoSecOffBO = null;
		try
		{
			GeoSecOffLocal geoSecOffLocal = geoSecOffHome.findBySalesOrg(salesOrg);
			geoSecOffBO = getGeoSecOffBO(geoSecOffLocal);
		}
		catch (FinderException ex)
		{
			ErrorReport report =
				ExceptionGenerator.getErrorReport(ErrorCodeConstants.SE0333, OPPTMessageCatalog.TYPE_SERVICE);
			throw ExceptionGenerator.generateDomainException(report);
		}

		return geoSecOffBO;
	}

	/** 
	 * This method gets the All GeoSec Officer. 	 
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  GeoSecOffBO
	 * @param   
	 * @throws  DomainException
	 */
	public GeoSecOffBO findAllGEOSecOffBO() throws DomainException
	{
		GeoSecOffLocalHome geoSecOffHome =
			(GeoSecOffLocalHome) HomeProvider.getLocal(HomeProvider.GEO_SEC_OFF_LOCAL_HOME);
		GeoSecOffBO geoSecOffBO = null;
		try
		{
			Collection geoSecOfficerCollection = geoSecOffHome.findAllGeoSecOfficer();
			Iterator geoSecOfficerIterator = geoSecOfficerCollection.iterator();

			List geoSecOfficerList = new ArrayList();
			geoSecOffBO = new GeoSecOffBO();

			while (geoSecOfficerIterator.hasNext())
			{
				geoSecOfficerList.add(getGeoSecOffBO((GeoSecOffLocal) geoSecOfficerIterator.next()));
			}
			geoSecOffBO.setGeoSecOfficerList(geoSecOfficerList);
		}
		catch (FinderException ex)
		{
			ErrorReport report =
				ExceptionGenerator.getErrorReport(ErrorCodeConstants.SE0333, OPPTMessageCatalog.TYPE_SERVICE);
			throw ExceptionGenerator.generateDomainException(report);
		}
		return geoSecOffBO;
	}

	/**
	 * To get all the GEO Sec for the given Sales Org 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesOrg
	 * @return List of GeoSecOffBO
	 * @throws DomainException
	 */
	public List findAllGEOSecForSalesOrg(String salesOrg) throws DomainException
	{
		GeoSecOffLocalHome geoSecOffHome =
			(GeoSecOffLocalHome) HomeProvider.getLocal(HomeProvider.GEO_SEC_OFF_LOCAL_HOME);
		List list = new ArrayList();
		try
		{
			GeoSecOffLocal geoSecOffLocal = geoSecOffHome.findBySalesOrg(salesOrg);
			Collection geoSecCollection = geoSecOffHome.findByGeoSec(geoSecOffLocal.getGeoSecOffSo());
			Iterator iterator = geoSecCollection.iterator();
			while (iterator.hasNext())
			{
				list.add(getGeoSecOffBO((GeoSecOffLocal) iterator.next()));
			}
		}
		catch (FinderException ex)
		{
			ErrorReport report =
				ExceptionGenerator.getErrorReport(ErrorCodeConstants.SE0333, OPPTMessageCatalog.TYPE_SERVICE);
			throw ExceptionGenerator.generateDomainException(report);
		}
		return list;
	}

	/**
	 * To build the BO out of Local 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param local
	 * @return GeoSecOffBO
	 */
	private GeoSecOffBO getGeoSecOffBO(GeoSecOffLocal local)
	{
		GeoSecOffBO bo = new GeoSecOffBO();

		bo.setGeoSecOffSO(OPPTHelper.trimString(local.getGeoSecOffSo()));
		bo.setSalesOrg(OPPTHelper.trimString(local.getSalesOrg()));

		return bo;
	}
}
