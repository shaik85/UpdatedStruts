package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: GeoSecOff
 */
public interface GeoSecOffBeanInjector_4c848b5a extends com.ibm.ws.ejbpersistence.beanextensions.EJBPartialInjector {
	/**
	 * ejbFindBySalesOrg
	 */
	public void ejbFindBySalesOrg(java.lang.String salesOrg, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindByGeoSec
	 */
	public void ejbFindByGeoSec(java.lang.String salesOrg, javax.resource.cci.IndexedRecord record);
}
