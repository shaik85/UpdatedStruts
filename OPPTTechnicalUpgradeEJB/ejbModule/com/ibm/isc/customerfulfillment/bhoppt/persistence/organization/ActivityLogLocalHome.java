package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

/**
 * Local Home interface for Enterprise Bean: ActivityLog
 */
public interface ActivityLogLocalHome extends javax.ejb.EJBLocalHome {

	/**
	 * Creates an instance from a key for Entity Bean: ActivityLog
	 */
	
	/**
	 * Finds an instance using a key for Entity Bean: ActivityLog
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocal findByPrimaryKey(
		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey primaryKey)
		throws javax.ejb.FinderException;
	public java.util.Collection findAllActivities()
	throws javax.ejb.FinderException;
	/**
	 * Creates an instance from a key for Entity Bean: ActivityLog
	 */
	/**
	 * Creates an instance from a key for Entity Bean: ActivityLog
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogLocal create(
		java.lang.String userId,
		java.sql.Date activityDate,
		java.sql.Time activityTime
		) throws javax.ejb.CreateException;
}
