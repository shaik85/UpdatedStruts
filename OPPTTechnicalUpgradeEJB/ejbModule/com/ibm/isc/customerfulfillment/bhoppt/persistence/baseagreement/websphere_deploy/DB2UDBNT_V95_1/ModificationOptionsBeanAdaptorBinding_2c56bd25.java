package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ModificationOptionsBeanAdaptorBinding_2c56bd25
 */
public class ModificationOptionsBeanAdaptorBinding_2c56bd25 implements com.ibm.ws.ejbpersistence.beanextensions.EJBAdapterBinding {
	/**
	 * getExtractor
	 */
	public com.ibm.ws.ejbpersistence.dataaccess.EJBExtractor getExtractor() {
		// extractor for com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanExtractor_2c56bd25
		com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor extractor =  new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanExtractor_2c56bd25();
		extractor.setPrimaryKeyColumns(new int[] {1,2});
		extractor.setDataColumns(new int[] {1,2,3});
		return extractor;
	}
	/**
	 * getInjector
	 */
	public com.ibm.ws.ejbpersistence.beanextensions.EJBInjector getInjector() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanInjectorImpl_2c56bd25();
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
		cat[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogRDBAlias("ModificationOptions", "ModificationOptions1_Alias", "DB2NT", "BH.MODIFICATIONOPTIONS", "ModificationOptions_ModificationOptions1_Table", 9, 5, 1);


		//-----------------------------------Table Type-----------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[3];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("MODIFICATION_TYPE_CODE", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 5, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0, false);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("MODIFICATION_OPTION", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 2, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0, false);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("MODIFICATION_OPTION_DESC", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 40, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		primarykey = new String[2];
		primarykey[0] = "MODIFICATION_TYPE_CODE";
		primarykey[1] = "MODIFICATION_OPTION";
		cat[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("ModificationOptions", "ModificationOptions1_Table", null, fields, primarykey);


		//-----------------------------------Bean Type-----------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[3];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("modificationTypeCode", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("modificationOption", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("modificationOptionDescription", new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, new String(), com.ibm.ObjectQuery.engine.OSQLConstants.NOT_APPLICABLE, true, com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0, false);
		primarykey = new String[2];
		primarykey[0] = "modificationTypeCode";
		primarykey[1] = "modificationOption";
		cat[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("ModificationOptions", "ModificationOptions_BO", "com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsBean", fields, primarykey);


		//--------------------------------------View--------------------------------------
		composedObjs = null;
		composedObjImpls = null;
		subhomes = null;
		cat[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogView("ModificationOptions", "ModificationOptions_ModificationOptions_BO", "ModificationOptions_ModificationOptions1_Alias", composedObjs, composedObjImpls, 
		"select t1.MODIFICATION_TYPE_CODE,t1.MODIFICATION_OPTION,t1.MODIFICATION_OPTION_DESC from _this t1", 
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
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("Create");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Create");
		daSpec.setInputRecordName("Create");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.CREATE_BEAN);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("Remove");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Remove");
		daSpec.setInputRecordName("Remove");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.REMOVE_BEAN);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("Store");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("StoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("FindByTypeCode");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByTypeCode");
		daSpec.setInputRecordName("FindByTypeCode");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("FindByTypeCode444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByTypeCode");
		daSpec.setInputRecordName("FindByTypeCode");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("FindByTypeCodeForUpdateWithRR");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByTypeCode");
		daSpec.setInputRecordName("FindByTypeCode");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setLockType(com.ibm.websphere.ejbpersistence.EJBToRAAdapter.LOCKTYPE_SELECT_FOR_UPDATE_WITH_RR);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("FindByTypeCodeForUpdateWithRS");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByTypeCode");
		daSpec.setInputRecordName("FindByTypeCode");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setLockType(com.ibm.websphere.ejbpersistence.EJBToRAAdapter.LOCKTYPE_SELECT_FOR_UPDATE_WITH_RS);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("FindByPrimaryKey");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("FindByPrimaryKey444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("FindByPrimaryKeyForUpdateWithRR");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setLockType(com.ibm.websphere.ejbpersistence.EJBToRAAdapter.LOCKTYPE_SELECT_FOR_UPDATE_WITH_RR);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("FindByPrimaryKeyForUpdateWithRS");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setLockType(com.ibm.websphere.ejbpersistence.EJBToRAAdapter.LOCKTYPE_SELECT_FOR_UPDATE_WITH_RS);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("ReadReadChecking");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("ReadReadChecking");
		daSpec.setInputRecordName("ReadReadChecking");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.READ_READ);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("ReadReadCheckingForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("ReadReadChecking");
		daSpec.setInputRecordName("ReadReadChecking");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.READ_READ);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("PartialStore");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.OTHER);
		daSpec.setProperty("IS_PARTIAL_UPDATE", Boolean.TRUE);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanFunctionSet_2c56bd25");
		iSpec.setFunctionName("PartialStoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.OTHER);
		daSpec.setProperty("IS_PARTIAL_UPDATE", Boolean.TRUE);
		daSpec.setQueryScope(new String[]{"ModificationOptions"});
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
	 * ModificationOptionsBeanAdaptorBinding_2c56bd25
	 */
	public ModificationOptionsBeanAdaptorBinding_2c56bd25() {
		properties = new java.util.HashMap();
		properties.put("VERSION", "7.0.0.0");
	}
	private java.util.HashMap properties;
}
