package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

/**
 * Local interface for Enterprise Bean: ActivityLog
 */
public interface ActivityLogLocal extends javax.ejb.EJBLocalObject {

	/**
	 * Get accessor for persistent attribute: message
	 */
	public java.lang.String getMessage();

	/**
	 * Set accessor for persistent attribute: message
	 */
	public void setMessage(java.lang.String newMessage);

	/**
	 * Get accessor for persistent attribute: activityDate
	 */
	public java.sql.Date getActivityDate();

	/**
	 * Set accessor for persistent attribute: activityDate
	 */
	public void setActivityDate(java.sql.Date newActivityDate);

	/**
	 * Get accessor for persistent attribute: activityTime
	 */
	public java.sql.Time getActivityTime();

	/**
	 * Set accessor for persistent attribute: activityTime
	 */
	public void setActivityTime(java.sql.Time newActivityTime);

	/**
	 * Get accessor for persistent attribute: userId
	 */
	public java.lang.String getUserId();

	/**
	 * Set accessor for persistent attribute: userId
	 */
	public void setUserId(java.lang.String newUserId);
}
