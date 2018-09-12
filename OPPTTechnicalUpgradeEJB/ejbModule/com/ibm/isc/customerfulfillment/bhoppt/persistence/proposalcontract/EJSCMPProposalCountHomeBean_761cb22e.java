package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProposalCountHomeBean_761cb22e
 */
public class EJSCMPProposalCountHomeBean_761cb22e extends EJSHome {
	static final long serialVersionUID = 61;
	/**
	 * EJSCMPProposalCountHomeBean_761cb22e
	 */
	public EJSCMPProposalCountHomeBean_761cb22e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountLocal create_Local(java.lang.String salesOrg, java.lang.String proposalContent, java.lang.String customerName) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountLocal result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountBean bean = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(salesOrg, proposalContent, customerName);
			Object ejsKey = keyFromBean(bean);
			result = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountLocal) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(salesOrg, proposalContent, customerName);
			super.afterPostCreate(beanO, ejsKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if(preCreateFlag && !createFailed)
				super.afterPostCreateCompletion(beanO);
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return result;
	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountLocal findByPrimaryKey_Local(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountLocal)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e tmpEJB = (com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ConcreteProposalCount_761cb22e) generalEJB;
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey();
		keyClass.salesOrg = tmpEJB.getSalesOrg();
		keyClass.proposalContent = tmpEJB.getProposalContent();
		keyClass.customerName = tmpEJB.getCustomerName();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey keyFromFields(java.lang.String f0, java.lang.String f1, java.lang.String f2) {
		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey keyClass = new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey();
		keyClass.salesOrg = f0;
		keyClass.proposalContent = f1;
		keyClass.customerName = f2;
		return keyClass;
	}
}
