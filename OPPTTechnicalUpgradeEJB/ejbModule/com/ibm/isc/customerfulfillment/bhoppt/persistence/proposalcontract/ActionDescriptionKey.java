package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

/**
 * Key class for Entity Bean: ActionDescription
 */
public class ActionDescriptionKey implements java.io.Serializable {

	static final long serialVersionUID = 3206093459760846163L;

	/**
	 * Implementation field for persistent attribute: operationPerformed
	 */
	public java.lang.String operationPerformed;

	/**
	 * Creates an empty key for Entity Bean: ActionDescription
	 */
	public ActionDescriptionKey() {
	}

	/**
	 * Creates a key for Entity Bean: ActionDescription
	 */
	public ActionDescriptionKey(java.lang.String operationPerformed) {
		this.operationPerformed = operationPerformed;
	}

	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ActionDescriptionKey) {
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ActionDescriptionKey o = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ActionDescriptionKey) otherKey;
			return ((this.operationPerformed.equals(o.operationPerformed)));
		}
		return false;
	}

	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return (operationPerformed.hashCode());
	}
}
