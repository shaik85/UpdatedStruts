package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization;

/**
 * Key class for Entity Bean: ActivityLog
 */
public class ActivityLogKey implements java.io.Serializable {

	/**
	 * Implementation field for persistent attribute: activityTime
	 */
	public java.sql.Time activityTime;

	/**
	 * Implementation field for persistent attribute: activityDate
	 */
	public java.sql.Date activityDate;

	/**
	 * Implementation field for persistent attribute: userId
	 */
	public java.lang.String userId;

	static final long serialVersionUID = 3206093459760846163L;

	/**
	 * Creates a key for Entity Bean: ActivityLog
	 */
	public ActivityLogKey(
			java.lang.String userId,
			java.sql.Date activityDate,
			java.sql.Time activityTime
		
		) {
		this.activityTime = activityTime;
		this.activityDate = activityDate;
		this.userId = userId;
	}

	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey) otherKey;
			return ((this.userId.equals(o.userId))&& (this.activityDate
					.equals(o.activityDate))
				&& (this.activityTime.equals(o.activityTime)) );
		}
		return false;
	}

	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (userId.hashCode() + activityTime.hashCode() + activityDate
			.hashCode());
	}

	/**
	 * Creates an empty key for Entity Bean: ActivityLog
	 */
	public ActivityLogKey() {
	}

	/**
	 * Creates a key for Entity Bean: ActivityLog
	 */
	
}
