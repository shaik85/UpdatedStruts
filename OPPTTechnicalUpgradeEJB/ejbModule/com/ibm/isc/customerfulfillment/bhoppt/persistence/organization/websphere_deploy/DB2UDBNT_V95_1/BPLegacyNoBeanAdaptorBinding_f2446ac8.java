package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BPLegacyNoBeanAdaptorBinding_f2446ac8
 */
public class BPLegacyNoBeanAdaptorBinding_f2446ac8 implements com.ibm.ws.ejbpersistence.beanextensions.EJBAdapterBinding {
	/**
	 * getExtractor
	 */
	public com.ibm.ws.ejbpersistence.dataaccess.EJBExtractor getExtractor() {
		// extractor for com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanExtractor_f2446ac8
		com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor extractor =  new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanExtractor_f2446ac8();
		extractor.setPrimaryKeyColumns(new int[] {1,2,3});
		extractor.setDataColumns(new int[] {1,2,3,4});
		return extractor;
	}
	/**
	 * getInjector
	 */
	public com.ibm.ws.ejbpersistence.beanextensions.EJBInjector getInjector() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanInjectorImpl_f2446ac8();
	}
	/**
	 * getAdapter
	 */
	public com.ibm.websphere.ejbpersistence.EJBToRAAdapter getAdapter() {
		return com.ibm.ws.rsadapter.cci.WSRelationalRAAdapter.createAdapter();
	}
	/**
	 * getMetadata
	 */
	public Object[] getMetadata() {
		
		java.lang.String[] primarykey, subhomes, composedObjs, composedObjImpls;
		com.ibm.ObjectQuery.metadata.OSQLExternalCatalogEntry[] cat;
		com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[] fields;
		cat = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogEntry[5];

		//-------------------------------------Alias-------------------------------------
		cat[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogRDBAlias("BPLegacyNo", "BPLegacyNo1_Alias", "DB2NT", "BH.BPLEGACYNO", "BPLegacyNo_BPLegacyNo1_Table", 9, 5, 1);


		//-----------------------------------Table Type-----------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[4];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("USER_ID", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 105, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0, false);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("LEGACY_NUMBER", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 10, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0, false);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("ADD_SEQUENCE_NUMBER", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 15, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0, false);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("CUTOMER_NAME", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 35, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		primarykey = new String[3];
		primarykey[0] = "USER_ID";
		primarykey[1] = "LEGACY_NUMBER";
		primarykey[2] = "ADD_SEQUENCE_NUMBER";
		cat[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("BPLegacyNo", "BPLegacyNo1_Table", null, fields, primarykey);


		//-----------------------------------Bean Type-----------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[4];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("userId", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("legacyNo", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("addressSeqNo", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("customerName", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		primarykey = new String[3];
		primarykey[0] = "userId";
		primarykey[1] = "legacyNo";
		primarykey[2] = "addressSeqNo";
		cat[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("BPLegacyNo", "BPLegacyNo_BO", "com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoBean", fields, primarykey);


		//--------------------------------------View--------------------------------------
		composedObjs = null;
		composedObjImpls = null;
		subhomes = null;
		cat[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogView("BPLegacyNo", "BPLegacyNo_BPLegacyNo_BO", "BPLegacyNo_BPLegacyNo1_Alias", composedObjs, composedObjImpls, 
		"select t1.USER_ID,t1.LEGACY_NUMBER,t1.ADD_SEQUENCE_NUMBER,t1.CUTOMER_NAME from _this t1", 
		null, subhomes, 
		0, null);



		cat[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalSysApplOptions(13, true);

		return cat;
	}
	/**
	 * createDataAccessSpecs
	 */
	public java.util.Collection createDataAccessSpecs() throws javax.resource.ResourceException {
		com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec daSpec;
		com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl iSpec;
		java.util.Collection result = new java.util.ArrayList(16);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("Create");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Create");
		daSpec.setInputRecordName("Create");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.CREATE_BEAN);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("Remove");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Remove");
		daSpec.setInputRecordName("Remove");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.REMOVE_BEAN);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("Store");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("StoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("FindByPrimaryKey");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("FindByPrimaryKey444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("FindByPrimaryKeyForUpdateWithRR");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setLockType(com.ibm.websphere.ejbpersistence.EJBToRAAdapter.LOCKTYPE_SELECT_FOR_UPDATE_WITH_RR);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("FindByPrimaryKeyForUpdateWithRS");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setLockType(com.ibm.websphere.ejbpersistence.EJBToRAAdapter.LOCKTYPE_SELECT_FOR_UPDATE_WITH_RS);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("FindByUser");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByUser");
		daSpec.setInputRecordName("FindByUser");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("FindByUser444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByUser");
		daSpec.setInputRecordName("FindByUser");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("FindByUserForUpdateWithRR");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByUser");
		daSpec.setInputRecordName("FindByUser");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setLockType(com.ibm.websphere.ejbpersistence.EJBToRAAdapter.LOCKTYPE_SELECT_FOR_UPDATE_WITH_RR);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("FindByUserForUpdateWithRS");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByUser");
		daSpec.setInputRecordName("FindByUser");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setLockType(com.ibm.websphere.ejbpersistence.EJBToRAAdapter.LOCKTYPE_SELECT_FOR_UPDATE_WITH_RS);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("ReadReadChecking");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("ReadReadChecking");
		daSpec.setInputRecordName("ReadReadChecking");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.READ_READ);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("ReadReadCheckingForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("ReadReadChecking");
		daSpec.setInputRecordName("ReadReadChecking");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.READ_READ);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("PartialStore");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.OTHER);
		daSpec.setProperty("IS_PARTIAL_UPDATE", Boolean.TRUE);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanFunctionSet_f2446ac8");
		iSpec.setFunctionName("PartialStoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.OTHER);
		daSpec.setProperty("IS_PARTIAL_UPDATE", Boolean.TRUE);
		daSpec.setQueryScope(new String[]{"BPLegacyNo"});
		result.add(daSpec);

		return result;

	}
	/**
	 * getProperties
	 */
	public java.util.HashMap getProperties() {
		properties.put("USING_DB_AUTO_OCC_COLLISION_DETECTION", Boolean.FALSE);
		properties.put("NEED_REFRESH_AFTER_PERSISTENCE", Boolean.FALSE);
		properties.put("MULTIPLE_FOR_UPDATE_METHODS", Boolean.TRUE);
		return properties;
	}
	/**
	 * BPLegacyNoBeanAdaptorBinding_f2446ac8
	 */
	public BPLegacyNoBeanAdaptorBinding_f2446ac8() {
		properties = new java.util.HashMap();
		properties.put("VERSION", "7.0.0.0");
	}
	private java.util.HashMap properties;
}
