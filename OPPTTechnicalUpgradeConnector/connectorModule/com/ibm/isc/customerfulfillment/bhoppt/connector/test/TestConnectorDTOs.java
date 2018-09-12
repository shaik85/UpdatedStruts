/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.RFCConverter;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.BillingBlockConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.BillingTypeConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ChangeContractInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ChangeContractOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ChargeOptionConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CheckVarianceConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CheckVarianceInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CheckVarianceOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CompareAuthorInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CompareAuthorOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateContractInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateContractOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateVarianceReportInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateVarianceReportOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CurrencyConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CustListAndSeqConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CustomerListConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.DivisionConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.DstrChannelConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.EEConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.GenericConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.LicenseConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.MessageConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.OrgConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PartnerCheckInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PartnerCheckOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PaymentTermConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PriceConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PriceInquiryConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.PriceInquiryOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RefreshCurrencyInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RefreshCurrencyOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RefreshVarianceInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveBillingBlockInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveBillingBlockOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveConfigConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveCustConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveCustInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveCustListInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveCustListOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveCustOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveDateRulesInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveDateRulesOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveDeltaInventoryInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveDeltaInventoryOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveIneligDeltaInvenInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveIneligInvenDetailInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveIneligInvenDetailOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenConfigInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenConfigOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenDetailInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveInvenDetailOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePartnerConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePartnerInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePartnerOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePaymentTermsInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrievePaymentTermsOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveSalesAreaInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveSalesAreaOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveUserAuthConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveUserAuthInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveUserAuthOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.SWOConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.SalesAreaConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.SalesOrgConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.StatusCheckInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.StatusCheckOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.UseLevelConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.UseridMaintInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.UseridMaintOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateBPAccessInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateBPAccessOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateComplexDataInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateComplexDataOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateConfigConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateHeaderDataInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateHeaderDataOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateInvenConfigConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateInvenConfigInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateInvenConfigOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateUserAccessInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValidateUserAccessOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.ValueMetricConnectorDTO;

/** 
 * To test the connectors
 * 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class TestConnectorDTOs
{
	public TestConnectorDTOs()
	{
	}

	// For Z_FV_RETRIEVE_CUSTOMER_OPPT 		- RFC1
	public void testOneObject2String() throws Exception
	{
		RetrieveCustInputConnectorDTO dto = new RetrieveCustInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_RETRIEVE_CUSTOMER_OPPT");
		genericDTO.setSessionID("saraibm2003091937652");
		genericDTO.setUserID("saraibm");

		OrgConnectorDTO orgDTO = new OrgConnectorDTO();
		orgDTO.setSalesOrg("0147");
		orgDTO.setDistributionChannel("A");
		orgDTO.setDivision("00");

		List list = new ArrayList();
		list.add("0030005000");
		list.add("0030005001");

		dto.setCustomerListNumber(list);
		dto.setGenericConnectorDTO(genericDTO);
		dto.setOrgConnectorDTO(orgDTO);

		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_CUSTOMER_OPPT");

	//	System.out.println("OBJECT 2 STRING \n*****************\n");
	//	System.out.println(converter.createMsgString(dto));

		testOneString2Object();
	}

	public void testOneString2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_CUSTOMER_OPPT");
		String msg =
			"0|000266|0030005000|0030001158|SUPER RITE FOODS INC|8650437|001|0030005000|0030001416|SUPERVALU INC|8647414|001|0030005001|0030000547|STATE OF WASHINGTON|9530209|001|0030005001|0030000971|STATE OF WASHINGTON|9532307|001|0030005001|0030001453|STATE OF WASHINGTON|9532166|001|";

		printRetrieveCustOutputConnectorDTO(converter.parseMsgString(msg));
	}

	public void printRetrieveCustOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		RetrieveCustOutputConnectorDTO connectorDTO = (RetrieveCustOutputConnectorDTO) conn;

		List list = connectorDTO.getRetrieveCustConnectorDTOList();

		 System.out.println(
			"\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: " + connectorDTO.getReturnCode() + "\n");
		Iterator iter = list.iterator();

		while (iter.hasNext())
		{
			RetrieveCustConnectorDTO custDTO = (RetrieveCustConnectorDTO) iter.next();

			System.out.println("cust list no# " + custDTO.getCustomerListNo());
			System.out.println("cust number # " + custDTO.getCustomerNo());
			System.out.println("cust name   # " + custDTO.getCustomerName());
			System.out.println("leg cust no # " + custDTO.getLegacyCustomerNo());
			System.out.println("addr. seqno # " + custDTO.getAddressSeqNo() + "\n\n");
		}
	}

	// For Z_WV_INELIG_DETAIL_OPPT 		-RFC7
	public void testTwoObject2String() throws Exception
	{
		RetrieveIneligInvenDetailInputConnectorDTO dto = new RetrieveIneligInvenDetailInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_INELIG_DETAIL_OPPT");
		genericDTO.setSessionID("saraibm2003091937652");
		genericDTO.setUserID("saraibm");

		OrgConnectorDTO orgDTO = new OrgConnectorDTO();
		orgDTO.setSalesOrg("0147");
		orgDTO.setDistributionChannel("A");
		orgDTO.setDivision("00");

		RetrieveInvenConnectorDTO ricDTO = new RetrieveInvenConnectorDTO();
		ricDTO.setProposalType("EA");
		ricDTO.setDocumentCategory("C");
		ricDTO.setCurrency("USD");
		ricDTO.setContractStartDate(Date.valueOf("2003-01-01"));
		ricDTO.setContractEndDate(Date.valueOf("2003-12-31"));

		dto.setLastFetchDate(null);
		dto.setLastFetchTime(null);
		dto.setContractType("O");
		// missing contract number... that is empty
		
		List list = new ArrayList();
		list.add("0030001416");
		
		dto.setCustomerNumber(list);

		dto.setGenericConnectorDTO(genericDTO);
		dto.setOrgConnectorDTO(orgDTO);
		dto.setRetrieveInvenConnectorDTO(ricDTO);

		RFCConverter converter = new RFCConverter("Z_WV_INELIG_DETAIL_OPPT");
		System.out.println(converter.createMsgString(dto));

		testTwoString2Object();
	}

	private void testTwoString2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_INELIG_DETAIL_OPPT");

		String msg =
			"0|20030919|140452|2100|2008304356|000010|C|20010920|0030001416||0123456789||5645001|OS/390|W000010|||000000000010165000|0001035P01|||A|20010920|0001035P01|2008304900|000010|C|20011101|0030001416|30009898|21211414||5655018|CICS/ESA VERSION 4|W0002S2|||000000000010165796|RQ|||A|20011101|RQ|2008304503|000010|C|20010601|0030001416||8823456||5648054|CICS TS for VSE/ESA|W00001T|||000000000010165240|RQ|||A|20010601|RQ|2008304604|000010|C|20010601|0030001416|VAtest|88VT3333||5647A01|OS/390 Version 2|W0000T5|||000000000010165339|RQ|||A|20010601|RQ|2008304629|000010|C|20010601|0030001416|VARtest|88VT3333||5647A01|OS/390 Version 2|W0000TF|||000000000010165369|RQ|||A|20010601|RQ|2008304605|000010|C|20010601|0030001416|VARtest|88VT4444||5648054|CICS TS for VSE/ESA|W00001X|||000000000010165340|0001034P01|||A|20010601|0001034P01|2008304588|000030|C|20010801|0030001416||OPPTWSTEST|390|5645005|System Auto. for OS/390|W00003T|||000000000010165321|0001034P01|||A|20010801|0001034P01|2008304589|000010|C|20010801|0030001416||OPPTWSTEST1|390|5648A25|COBOL for OS/390 & VM V2R2|W000082|||000000000010165322|TP_TEST|||A|20010801|TP_TEST|2008304589|000030|C|20010801|0030001416||OPPTWSTEST1|390|5648054|CICS TS for VSE/ESA|W00001W|||000000000010165323|TP_TEST|||A|20010801|TP_TEST|2008305487|000001|C|20011010|0030001416||WERTY76543|EEEEEEEEEEEEEEEEEEEEEE|5647A01|OS/390 Version 2|W0000R6|||000000000010164338|TP_TEST|||A|20011010|TP_TEST|2008005723|000010|C|19860825|0030001416||UNKNOWN|374500873|5735XXB|Emulation Program Version 1|88251|63911||000000000010123413||||C|19860825|Z9|2008016201|000010|C|19860825|0030001416||37450200873|3745-41A|5735XXB|Emulation Program Version 1|882519|639119||000000000010152572||||C|19860825|Z9|2008012799|000010|C|20000703|0030001416||96720201050|9672-R86|5645DB2|DB2 UDB for OS/390|B72749|||000000000010148750||||C|20000703|Z9|2008300587|000010|C|19971027|0030001416||96720240500|9672-RC4|5647A01|OS/390 Version 2|B003T9|||000000000010154746||||C|19971027|Z9|2008012797|000010|C|20000703|0030001416||96720240834|9672-R86|5645DB2|DB2 UDB for OS/390|B72739|||000000000010148748||||C|20000703|Z9|2298|2008304356|000020|000010|System 370/390 Graduated Charg|Processor Group 20|Basic|S0012RF|OS/390 Base|Monthly Charge|259500||2008304900|000020|000010|PSLC below 3 MSUs|Up to 2 MSU|Basic|S00151N|CICS/ESA V4|Monthly Charge|247000||2008304503|000020|000010|MOSP|Processor Group 18|Basic|S00LRRW|CICS/VSE Version 1|Monthly Charge|30900||2008304604|000020|000010|PSLC below 3 MSUs|Up to 2 MSU|Basic|S001G8D|OS/390 V2 Base|Monthly Charge|249000||2008304629|000020|000010|PSLC below 3 MSUs|Up to 2 MSU|Basic|S001G8D|OS/390 V2 Base|Monthly Charge|249000||2008304605|000020|000010|MOSP|Processor Group 18|Basic|S00LRRW|CICS/VSE Version 1|Monthly Charge|30900||2008304588|000040|000030|PSLC-AD|40|Basic|S000V5N|System Automation for OS/390|Monthly Charge|294000||2008304589|000020|000010|ELC (Extended License Charge)|80|Basic|S001FGH|COBOL for OS/390 & VM V2|Monthly Charge|237600||2008304589|000040|000030|ELC (Extended License Charge)|90|Basic|S00LRRW|CICS/VSE Version 1|Monthly Charge|723500||2008305487|000002|000001|WLC No Charge Migration||Basic|S001G8D|OS/390 V2 Base|No Charge|000||2008005723|000020|000010|Non variable charge||DSLO|S0011TJ|Emulation Program Version 1|Monthly Charge|000||2008016201|000020|000010|Non variable charge||DSLO|S0011TJ|Emulation Program Version 1|Monthly Charge|000||2008012799|000020|000010|PSLC-AD||System Usage Registration|S00087N|DB2 UDB for OS/390|No Charge|000||2008012799|000030|000010|PSLC-AD||System Usage Registration|S00087R|DB2 Buffer Pool Tool Buy|No Charge|000||2008300587|000020|000010|PSLC-AD||System Usage Registration|S001G8D|OS/390 V2 Base|No Charge|000||2008300587|000030|000010|PSLC-AD||System Usage Registration|S001G8F|OS/390 V2 DFSORT|No Charge|000||2008300587|000040|000010|PSLC-AD||System Usage Registration|S001G8G|OS/390 V2 RMF|No Charge|000||2008300587|000050|000010|PSLC-AD||System Usage Registration|S001G8M|OS/390 V2 DFSMS DSS+HSM|No Charge|000||2008300587|000060|000010|PSLC-AD|20|Basic|S001G8T|OS/390 V2 JES3|Monthly Charge|000||2008300587|000070|000010|PSLC-AD|20|Basic|S001G93|OS/390 V2 Security Server|Monthly Charge|000||2008012797|000020|000010|PSLC-AD||System Usage Registration|S00087N|DB2 UDB for OS/390|No Charge|000||2008012797|000030|000010|PSLC-AD||System Usage Registration|S00087R|DB2 Buffer Pool Tool Buy|No Charge|000||422|2008304356|000020|20030101|20031231|259500|USD|2008304900|000020|20030101|20031231|247000|USD|2008304503|000020|20030101|20031231|30900|USD|2008304604|000020|20030101|20031231|249000|USD|2008304629|000020|20030101|20031231|249000|USD|2008304605|000020|20030101|20031231|30900|USD|2008304588|000040|20030101|20031231|294000|USD|2008304589|000020|20030101|20031231|237600|USD|2008304589|000040|20030101|20031231|723500|USD|";

		printRetrieveInvenDetailOutputConnectorDTO(converter.parseMsgString(msg));
	}

	public void printRetrieveInvenDetailOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		Iterator iter = null, iter2 = null, iter3 = null;
		if (conn instanceof RetrieveInvenDetailOutputConnectorDTO)
		{
			RetrieveInvenDetailOutputConnectorDTO dto = (RetrieveInvenDetailOutputConnectorDTO) conn;
			System.out.println(
				"\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: " + dto.getReturnCode() + "\n");
			iter = dto.getSWOConnectorDTOList().iterator();
			iter2 = dto.getEEConnectorDTOList().iterator();
			iter3 = dto.getPriceConnectorDTOList().iterator();
		}
		else if (conn instanceof RetrieveIneligInvenDetailOutputConnectorDTO)
		{
			RetrieveIneligInvenDetailOutputConnectorDTO dto = (RetrieveIneligInvenDetailOutputConnectorDTO) conn;
			System.out.println(
				"\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: " + dto.getReturnCode() + "\n");

			iter = dto.getSWOConnectorDTOList().iterator();
			iter2 = dto.getEEConnectorDTOList().iterator();
			iter3 = dto.getPriceConnectorDTOList().iterator();
		}
		else if (conn instanceof RetrieveDeltaInventoryOutputConnectorDTO)
		{
			RetrieveDeltaInventoryOutputConnectorDTO dto = (RetrieveDeltaInventoryOutputConnectorDTO) conn;
			System.out.println(
				"\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: " + dto.getReturnCode() + "\n");

			iter = dto.getSWOConnectorDTOList().iterator();
			iter2 = dto.getEEConnectorDTOList().iterator();
			iter3 = dto.getPriceConnectorDTOList().iterator();
		}

		while (iter.hasNext())
		{
			SWOConnectorDTO dto = (SWOConnectorDTO) iter.next();

			System.out.println("\n\nSales Document Number     : " + dto.getSalesDocumentNumber());
			System.out.println("SWO Item position no      : " + dto.getSWOItemPositionNumber());
			System.out.println("Sales document category   : " + dto.getSalesDocumentCategory());
			System.out.println("Request delivery date     : " + dto.getRequestDeliveryDate());
			System.out.println("Customer number           : " + dto.getCustomerNumber());
			System.out.println("Customer purch order no   : " + dto.getCustomerPurchaseOrderNumber());
			System.out.println("Designated machine        : " + dto.getDesignatedMachine());
			System.out.println("Desig machine desc        : " + dto.getDesigMachineDesc());
			System.out.println("SWO material number       : " + dto.getSWOMaterialNumber());
			System.out.println("Description of swo        : " + dto.getSWODesc());
			System.out.println("SWO serial number         : " + dto.getSWOSerialNumber());
			System.out.println("Reference serial number   : " + dto.getReferenceSerialNumber());
			System.out.println("Reference designd machine : " + dto.getReferenceDesignatedMachine());
			System.out.println("Equipment number          : " + dto.getEquipmentNumber());
			System.out.println("SWO External contract no  : " + dto.getSWOExternalContractNumber());
			System.out.println("SWO Contract type         : " + dto.getSWOContractType());
			System.out.println("SWO Contract status       : " + dto.getSWOContractStatus());
			System.out.println("Status flag               : " + dto.getIneligibleFlag());
			System.out.println("License effective date    : " + dto.getLicenseEffectiveDate());
			System.out.println("Ineligibility comment     : " + dto.getIneligibilityComment());
		}

		System.out.println("\n\n EE \n*******************\n");
		while (iter2.hasNext())
		{
			EEConnectorDTO dto = (EEConnectorDTO) iter2.next();

			System.out.println("\n\nSales document number      : " + dto.getSalesDocumentNumber());
			System.out.println("EE Item position number    : " + dto.getEEItemPositionNumber());
			System.out.println("SWO Item position number   : " + dto.getSWOItemPositionNumber());
			System.out.println("Value metric               : " + dto.getValueMetric());
			System.out.println("Use level                  : " + dto.getUseLevel());
			System.out.println("License type               : " + dto.getLicenseType());
			System.out.println("EE material number         : " + dto.getEEMaterialNumber());
			System.out.println("Description of EE material : " + dto.getDescriptionOfEEMaterial());
			System.out.println("Charge option              : " + dto.getChargeOption());
			System.out.println("First month list price     : " + dto.getFirstMonthListPrice());
			System.out.println("PLET no.                   : " + dto.getPLETNo());
		}

		System.out.println("\n\n PRICE \n*******************\n");
		while (iter3.hasNext())
		{
			PriceConnectorDTO dto = (PriceConnectorDTO) iter3.next();

			System.out.println("\n\nSales document number      : " + dto.getSalesDocumentNumber());
			System.out.println("EE Item position no        : " + dto.getEEItemPositionNo());
			System.out.println("Billing start date         : " + dto.getBillingStartDate());
			System.out.println("Billing end date           : " + dto.getBillingEndDate());
			System.out.println("ESW price                  : " + dto.getESWPrice());
			System.out.println("Currency                   : " + dto.getCurrency());
		}
	}

	public void validateHeaderO2String() throws Exception
	{
		ValidateHeaderDataInputConnectorDTO dto = new ValidateHeaderDataInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_VALIDATE_HEADER_DATA_OPPT");
		genericDTO.setSessionID("saraibm2003091937652");
		genericDTO.setUserID("saraibm");

		OrgConnectorDTO orgDTO = new OrgConnectorDTO();
		orgDTO.setSalesOrg("0147");
		orgDTO.setDistributionChannel("A");
		orgDTO.setSalesGroup("01");
		orgDTO.setChannelRole("01");
		orgDTO.setSubmitterRole("01");
		orgDTO.setDivision("00");

		dto.setProposalType("EA");

		dto.setGenericConnectorDTO(genericDTO);
		dto.setOrgConnectorDTO(orgDTO);

		RFCConverter converter = new RFCConverter("Z_WV_VALIDATE_HEADER_DATA_OPPT");

		System.out.println("\n\nRFC: Z_WV_VALIDATE_HEADER_DATA_OPPT\n\nOBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));

		validateHeaderS2Object();
	}

	public void validateHeaderS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_VALIDATE_HEADER_DATA_OPPT");
		ConnectorDTOInterface dto = converter.parseMsgString("0|");

		printValidateHeaderDataOutputConnectorDTO(dto);
	}

	public void printValidateHeaderDataOutputConnectorDTO(ConnectorDTOInterface dto)
	{
		ValidateHeaderDataOutputConnectorDTO validateDTO = (ValidateHeaderDataOutputConnectorDTO) dto;
		System.out.println(
			"\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: " + validateDTO.getReturnCode() + "\n");
	}

	public void retrieveCustomerListO2String() throws Exception
	{
		RetrieveCustListInputConnectorDTO dto = new RetrieveCustListInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_RETRIEVE_CUSTLIST_OPPT");
		genericDTO.setSessionID("saraibm2003091937652");
		genericDTO.setUserID("saraibm");

		OrgConnectorDTO orgDTO = new OrgConnectorDTO();
		orgDTO.setSalesOrg("0147");
		orgDTO.setDistributionChannel("A");
		orgDTO.setDivision("00");

		dto.setCity("");
		dto.setCustomerListName("");
		dto.setCustomerListNumber("");
		dto.setZipCode("");
		dto.setGenericConnectorDTO(genericDTO);
		dto.setOrgConnectorDTO(orgDTO);

		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_CUSTLIST_OPPT");

		System.out.println("\n\nRFC: Z_FV_RETRIEVE_CUSTLIST_OPPT\n\nOBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));

		retrieveCustomerListS2Object();
	}

	public void retrieveCustomerListS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_CUSTLIST_OPPT");
		ConnectorDTOInterface dto =
			converter.parseMsgString(
				"0|01174|0030005000|SUPERVALU|0030005001|State of Washington|0030005002|State of Texas|0030005003|State of Oklahoma|0030005004|State of Louisiana|0030005005|State of Idaho|0030005006|Dillon COS, Inc.|0030005007|City of Los Angeles|0030005008|State of Arizona|0030005009|State of Arkansas|0030005010|State of Texas|0030005011|The Boeing Co.|0030005012|University of California|0030005013|IBM Corporation|0030005014|IBM Corp.|0030005015|Mainstar Software Corp.|0030005016|Allen Systems|0030005017|SupportNet|0030009998|Test ZWVCES10|0030099995|SGOCustomer list|0030099996|EGO Test Case List|0030099997|CN-005 Customer list|0030099998|CN-003 Test Customer List|0030099999|OPPT Customer List - E2E Test|0300999978|US Government Dept. of Defense CL|0300999979|COMPUTER SCIENCES CORP CL|0300999980|Carrie Mui Test List #1|0300999981|Carrie Mui Test List #2|0300999982|Carrie Mui Test List #3|0300999983|Carrie Mui Test Customer #4|0300999984|CustomerList for 30005812|0300999985|Customer List for 30001228|0300999986|Customer List for 30001081|0300999987|Customer List for 30001085|2000000301|OPPT US CUSTOMERLIST|2000000302|OPPT US CUSTOMER LIST|271167USLS|Customer list for 271167US|");

		printRetrieveCustListOutputConnectorDTO(dto);
	}

	public void printRetrieveCustListOutputConnectorDTO(ConnectorDTOInterface dto)
	{
		RetrieveCustListOutputConnectorDTO custListDTO = (RetrieveCustListOutputConnectorDTO) dto;
		System.out.println(
			"\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: " + custListDTO.getReturnCode() + "\n");

		List list = custListDTO.getCustomerListConnectorDTOList();

		CustomerListConnectorDTO connectorDTO;

		Iterator iter = list.iterator();

		while (iter.hasNext())
		{
			connectorDTO = (CustomerListConnectorDTO) iter.next();
			System.out.println("\n\nCustomer List Number: " + connectorDTO.getCustomerListNo());
			System.out.println("Customer List Name  : " + connectorDTO.getCustomerListName());
		}
	}

	public void partnerCheckO2String() throws Exception
	{
		PartnerCheckInputConnectorDTO dto = new PartnerCheckInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_PARTNER_CHECK_OPPT");
		genericDTO.setSessionID("saraibm2003091937652");
		genericDTO.setUserID("saraibm");

		OrgConnectorDTO orgDTO = new OrgConnectorDTO();
		orgDTO.setSalesOrg("0147");
		orgDTO.setDistributionChannel("A");
		orgDTO.setDivision("00");

		dto.setGenericConnectorDTO(genericDTO);
		dto.setOrgConnectorDTO(orgDTO);

		dto.setPartnerType("SP");
		dto.setPartnerLegacyNumber("8647414");
		dto.setPartnerAddressSequenceNumber("002");
		dto.setFinancingContractFlag("");

		RFCConverter converter = new RFCConverter("Z_FV_PARTNER_CHECK_OPPT");

		System.out.println("\n\nRFC: Z_FV_PARTNER_CHECK_OPPT\n\nOBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));

		partnerCheckS2Object();
	}

	public void partnerCheckS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_PARTNER_CHECK_OPPT");
		ConnectorDTOInterface dto = converter.parseMsgString("0|00042|SP|0030001416|SUPERVALU INC|8647414|001||");

		printPartnerCheckOutputConnectorDTO(dto);
	}

	public void printPartnerCheckOutputConnectorDTO(ConnectorDTOInterface dto)
	{
		PartnerCheckOutputConnectorDTO partnerDTO = (PartnerCheckOutputConnectorDTO) dto;
		System.out.println(
			"\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: " + partnerDTO.getReturnCode() + "\n");

		System.out.println("\n\nFlag            : " + partnerDTO.getFlag());
		System.out.println("Customer No     : " + partnerDTO.getCustomerNo());
		System.out.println("Partner No      : " + partnerDTO.getPartnerName());
		System.out.println("Legacy No       : " + partnerDTO.getLegacyNo());
		System.out.println("Address Seq. No : " + partnerDTO.getAddressSeqNo());
		System.out.println("Class Type      : " + partnerDTO.getClassType() + "\n");
	}

	public void retrievePartnerO2String() throws Exception
	{
		RetrievePartnerInputConnectorDTO dto = new RetrievePartnerInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_RETRIEVE_PARTNER_OPPT");
		genericDTO.setSessionID("saraibm2003091937652");
		genericDTO.setUserID("saraibm");

		OrgConnectorDTO orgDTO = new OrgConnectorDTO();
		orgDTO.setSalesOrg("0147");
		orgDTO.setDistributionChannel("A");
		orgDTO.setDivision("00");

		dto.setGenericConnectorDTO(genericDTO);
		dto.setOrgConnectorDTO(orgDTO);

		dto.setAddressSequenceNo("8647414");
		dto.setLegacyNo("001");

		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_PARTNER_OPPT");

		System.out.println("\n\nRFC: Z_FV_RETRIEVE_PARTNER_OPPT\n\nOBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));

		retrievePartnerS2Object();
	}

	public void retrievePartnerS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_PARTNER_OPPT");
		ConnectorDTOInterface dto =
			converter.parseMsgString(
				"0|000041|SP|0030001416|SUPERVALU INC|8647414|001|000201|BP|0030001419|SUPERVALU INC|8647414|002|BP|0030003393|SUPERVALU INC|8647414|100|BP|0030003394|SUPERVALU INC|8647414|105|BP|0030003395|SUPERVALU INC|8647414|110|BP|0030003396|SUPERVALU INC|8647414|183|000201|PY|0030001419|SUPERVALU INC|8647414|002|PY|0030003393|SUPERVALU INC|8647414|100|PY|0030003394|SUPERVALU INC|8647414|105|PY|0030003395|SUPERVALU INC|8647414|110|PY|0030003396|SUPERVALU INC|8647414|183|000041|SH|0030001416|SUPERVALU INC|8647414|001|000041|ZI|0030001416|SUPERVALU INC|8647414|001|");

		printRetrievePartnerOutputConnectorDTO(dto);
	}

	public void printRetrievePartnerOutputConnectorDTO(ConnectorDTOInterface dto)
	{
		RetrievePartnerOutputConnectorDTO partnerDTO = (RetrievePartnerOutputConnectorDTO) dto;
		System.out.println(
			"\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: " + partnerDTO.getReturnCode() + "\n");

		Iterator iter = partnerDTO.getRetrievePartnerConnectorDTOList().iterator();

		RetrievePartnerConnectorDTO retrieveDTO;
		while (iter.hasNext())
		{
			retrieveDTO = (RetrievePartnerConnectorDTO) iter.next();

			System.out.println("\n\nFlag             : " + retrieveDTO.getFlag());
			System.out.println("Customer Number  : " + retrieveDTO.getCustomerNumber());
			System.out.println("Customer Name    : " + retrieveDTO.getCustomerName());
			System.out.println("Legacy Number    : " + retrieveDTO.getLegacyNumber());
			System.out.println("Sequence Number  : " + retrieveDTO.getSequenceNumber());
		}
	}

	public void retrieveDetailO2String() throws Exception
	{
		RetrieveInvenDetailInputConnectorDTO dto = new RetrieveInvenDetailInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_RETRIEVE_DETAIL_OPPT");
		genericDTO.setSessionID("saraibm2003091937652");
		genericDTO.setUserID("saraibm");

		OrgConnectorDTO orgDTO = new OrgConnectorDTO();
		orgDTO.setSalesOrg("0365");
		orgDTO.setDistributionChannel("A");
		orgDTO.setDivision("00");

		dto.setGenericConnectorDTO(genericDTO);
		dto.setOrgConnectorDTO(orgDTO);

		dto.setProposalType("EA");
		dto.setFlag("C");
		dto.setCurrency("EUR");
		dto.setContractStartPeriod(Date.valueOf("2003-09-01"));
		dto.setContractEndPeriod(Date.valueOf("2004-08-31"));
		dto.setLastFetchDate(Date.valueOf("0000-00-00"));
		dto.setLastFetchTime(Time.valueOf("00:00:00"));
		dto.setContractType("O");
		dto.setContractNumber("");
		
		List list = new ArrayList();
		list.add("0010156613");
		
		dto.setCustomerNumber(list);

		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_DETAIL_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));

		retrieveDetailS2Object();
	}

	public void retrieveDetailS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_DETAIL_OPPT");
		String msg =
			"0|20030919|140240|377|2008308507|000010|C|20030210|0010156613||98989898989||5645DB2|DB2 UDB for OS/390|W0000P0|||000000000010171924||||2008303987|000010|C|20011201|0010156613||SSSSSSSSSSSSSS||5655040|MERVA IMS  MVS/ESA V3|W00000F|||000000000010164329|HPrasad-ES|||2008307879|000001|C|20020701|0010156613||TESTTESTTEST||5655DB2|IBM DB2 for OS/390 Version 5|W00007C|||000000000010164454|HPrasad-ES|||625|2008308507|000020|000010||||S00087N|DB2 UDB for OS/390|Monthly Charge|000||2008303987|000020|000010|Usage Tiers|Up to 3 Copies|Basic|S0001RC|MERVA AIX USE & BRANCH|Monthly Charge|71376||2008307879|000002|000001|GOLC|Processor Group H30|Basic|S00MVJ2|QMF Win V6 F/C of DB2 V5|Monthly Charge|9200||2008307879|000003|000001|GOLC|Processor Group H70|Basic|S00MVJ4|QMF Win V6 w Host QMF prereq|Monthly Charge|53360||2008307879|000004|000001|GOLC|Processor Group H50|Basic|S001FJ7|IBM DB2 for OS/390 Version 5|Monthly Charge|510781||2008307879|000005|000001|NALC|3|Basic|S001FJ8|DB2 V5 Performance Monitor|Monthly Charge|1104000||233|2008303987|000020|20030901|20040831|71376|EUR|2008307879|000002|20030901|20040831|9200|EUR|2008307879|000003|20030901|20040831|53360|EUR|2008307879|000004|20030901|20040831|510781|EUR|2008307879|000005|20030901|20040831|1104000|EUR|";

		printRetrieveIneligInvenDetailOutputConnectorDTO(converter.parseMsgString(msg));
	}

	public void printRetrieveIneligInvenDetailOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		printRetrieveInvenDetailOutputConnectorDTO(conn);
	}

	public void retrieveInvetoryDeltaO2String() throws Exception
	{
		RetrieveIneligDeltaInvenInputConnectorDTO dto = new RetrieveIneligDeltaInvenInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_INELIG_DELTA_OPPT");
		genericDTO.setSessionID("saraibm2003091937652");
		genericDTO.setUserID("saraibm");

		OrgConnectorDTO orgDTO = new OrgConnectorDTO();
		orgDTO.setSalesOrg("0147");
		orgDTO.setDistributionChannel("A");
		orgDTO.setDivision("00");

		RetrieveInvenConnectorDTO ricDTO = new RetrieveInvenConnectorDTO();
		ricDTO.setProposalType("EA");
		ricDTO.setDocumentCategory("C");
		ricDTO.setCurrency("USD");
		ricDTO.setContractStartDate(Date.valueOf("2003-01-01"));
		ricDTO.setContractEndDate(Date.valueOf("2003-12-31"));

		dto.setContractNumber("O");

		List list = new ArrayList();
		list.add("0030001416");

		dto.setCustomerNumber(list);

		dto.setGenericConnectorDTO(genericDTO);
		dto.setOrgConnectorDTO(orgDTO);
		dto.setRetrieveInvenConnectorDTO(ricDTO);

		RFCConverter converter = new RFCConverter("Z_WV_INELIG_DELTA_OPPT");
		System.out.println(converter.createMsgString(dto));

		retrieveInvetoryDeltaS2Object();
	}

	private void retrieveInvetoryDeltaS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_INELIG_DELTA_OPPT");

		String msg =
			"0|20030919|140452|2100|2008304356|000010|C|20010920|0030001416||0123456789||5645001|OS/390|W000010|||000000000010165000|0001035P01|||A|20010920|0001035P01|2008304900|000010|C|20011101|0030001416|30009898|21211414||5655018|CICS/ESA VERSION 4|W0002S2|||000000000010165796|RQ|||A|20011101|RQ|2008304503|000010|C|20010601|0030001416||8823456||5648054|CICS TS for VSE/ESA|W00001T|||000000000010165240|RQ|||A|20010601|RQ|2008304604|000010|C|20010601|0030001416|VAtest|88VT3333||5647A01|OS/390 Version 2|W0000T5|||000000000010165339|RQ|||A|20010601|RQ|2008304629|000010|C|20010601|0030001416|VARtest|88VT3333||5647A01|OS/390 Version 2|W0000TF|||000000000010165369|RQ|||A|20010601|RQ|2008304605|000010|C|20010601|0030001416|VARtest|88VT4444||5648054|CICS TS for VSE/ESA|W00001X|||000000000010165340|0001034P01|||A|20010601|0001034P01|2008304588|000030|C|20010801|0030001416||OPPTWSTEST|390|5645005|System Auto. for OS/390|W00003T|||000000000010165321|0001034P01|||A|20010801|0001034P01|2008304589|000010|C|20010801|0030001416||OPPTWSTEST1|390|5648A25|COBOL for OS/390 & VM V2R2|W000082|||000000000010165322|TP_TEST|||A|20010801|TP_TEST|2008304589|000030|C|20010801|0030001416||OPPTWSTEST1|390|5648054|CICS TS for VSE/ESA|W00001W|||000000000010165323|TP_TEST|||A|20010801|TP_TEST|2008305487|000001|C|20011010|0030001416||WERTY76543|EEEEEEEEEEEEEEEEEEEEEE|5647A01|OS/390 Version 2|W0000R6|||000000000010164338|TP_TEST|||A|20011010|TP_TEST|2008005723|000010|C|19860825|0030001416||UNKNOWN|374500873|5735XXB|Emulation Program Version 1|88251|63911||000000000010123413||||C|19860825|Z9|2008016201|000010|C|19860825|0030001416||37450200873|3745-41A|5735XXB|Emulation Program Version 1|882519|639119||000000000010152572||||C|19860825|Z9|2008012799|000010|C|20000703|0030001416||96720201050|9672-R86|5645DB2|DB2 UDB for OS/390|B72749|||000000000010148750||||C|20000703|Z9|2008300587|000010|C|19971027|0030001416||96720240500|9672-RC4|5647A01|OS/390 Version 2|B003T9|||000000000010154746||||C|19971027|Z9|2008012797|000010|C|20000703|0030001416||96720240834|9672-R86|5645DB2|DB2 UDB for OS/390|B72739|||000000000010148748||||C|20000703|Z9|2298|2008304356|000020|000010|System 370/390 Graduated Charg|Processor Group 20|Basic|S0012RF|OS/390 Base|Monthly Charge|259500||2008304900|000020|000010|PSLC below 3 MSUs|Up to 2 MSU|Basic|S00151N|CICS/ESA V4|Monthly Charge|247000||2008304503|000020|000010|MOSP|Processor Group 18|Basic|S00LRRW|CICS/VSE Version 1|Monthly Charge|30900||2008304604|000020|000010|PSLC below 3 MSUs|Up to 2 MSU|Basic|S001G8D|OS/390 V2 Base|Monthly Charge|249000||2008304629|000020|000010|PSLC below 3 MSUs|Up to 2 MSU|Basic|S001G8D|OS/390 V2 Base|Monthly Charge|249000||2008304605|000020|000010|MOSP|Processor Group 18|Basic|S00LRRW|CICS/VSE Version 1|Monthly Charge|30900||2008304588|000040|000030|PSLC-AD|40|Basic|S000V5N|System Automation for OS/390|Monthly Charge|294000||2008304589|000020|000010|ELC (Extended License Charge)|80|Basic|S001FGH|COBOL for OS/390 & VM V2|Monthly Charge|237600||2008304589|000040|000030|ELC (Extended License Charge)|90|Basic|S00LRRW|CICS/VSE Version 1|Monthly Charge|723500||2008305487|000002|000001|WLC No Charge Migration||Basic|S001G8D|OS/390 V2 Base|No Charge|000||2008005723|000020|000010|Non variable charge||DSLO|S0011TJ|Emulation Program Version 1|Monthly Charge|000||2008016201|000020|000010|Non variable charge||DSLO|S0011TJ|Emulation Program Version 1|Monthly Charge|000||2008012799|000020|000010|PSLC-AD||System Usage Registration|S00087N|DB2 UDB for OS/390|No Charge|000||2008012799|000030|000010|PSLC-AD||System Usage Registration|S00087R|DB2 Buffer Pool Tool Buy|No Charge|000||2008300587|000020|000010|PSLC-AD||System Usage Registration|S001G8D|OS/390 V2 Base|No Charge|000||2008300587|000030|000010|PSLC-AD||System Usage Registration|S001G8F|OS/390 V2 DFSORT|No Charge|000||2008300587|000040|000010|PSLC-AD||System Usage Registration|S001G8G|OS/390 V2 RMF|No Charge|000||2008300587|000050|000010|PSLC-AD||System Usage Registration|S001G8M|OS/390 V2 DFSMS DSS+HSM|No Charge|000||2008300587|000060|000010|PSLC-AD|20|Basic|S001G8T|OS/390 V2 JES3|Monthly Charge|000||2008300587|000070|000010|PSLC-AD|20|Basic|S001G93|OS/390 V2 Security Server|Monthly Charge|000||2008012797|000020|000010|PSLC-AD||System Usage Registration|S00087N|DB2 UDB for OS/390|No Charge|000||2008012797|000030|000010|PSLC-AD||System Usage Registration|S00087R|DB2 Buffer Pool Tool Buy|No Charge|000||422|2008304356|000020|20030101|20031231|259500|USD|2008304900|000020|20030101|20031231|247000|USD|2008304503|000020|20030101|20031231|30900|USD|2008304604|000020|20030101|20031231|249000|USD|2008304629|000020|20030101|20031231|249000|USD|2008304605|000020|20030101|20031231|30900|USD|2008304588|000040|20030101|20031231|294000|USD|2008304589|000020|20030101|20031231|237600|USD|2008304589|000040|20030101|20031231|723500|USD|";

		printRetrieveInvenDetailOutputConnectorDTO(converter.parseMsgString(msg));
	}

	public void retrieveDeltaO2String() throws Exception
	{
		RetrieveDeltaInventoryInputConnectorDTO dto = new RetrieveDeltaInventoryInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_RETRIEVE_DELTA_OPPT");
		genericDTO.setSessionID("saraibm2003091937652");
		genericDTO.setUserID("saraibm");

		OrgConnectorDTO orgDTO = new OrgConnectorDTO();
		orgDTO.setSalesOrg("0365");
		orgDTO.setDistributionChannel("A");
		orgDTO.setDivision("00");

		RetrieveInvenConnectorDTO ricDTO = new RetrieveInvenConnectorDTO();
		ricDTO.setProposalType("EA");
		ricDTO.setDocumentCategory("C");
		ricDTO.setCurrency("USD");
		ricDTO.setContractStartDate(Date.valueOf("2003-01-01"));
		ricDTO.setContractEndDate(Date.valueOf("2003-12-31"));

		dto.setGenericConnectorDTO(genericDTO);
		dto.setOrgConnectorDTO(orgDTO);
		dto.setRetrieveInvenConnectorDTO(ricDTO);

		dto.setContractNumber("");
		List list = new ArrayList();
		list.add("0030001416");

		dto.setCustomerNumberList(list);

		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_DELTA_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));

		retrieveDeltaS2Object();
	}

	public void retrieveDeltaS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_DETAIL_OPPT");
		String msg =
			"0|20030919|140240|377|2008308507|000010|C|20030210|0010156613||98989898989||5645DB2|DB2 UDB for OS/390|W0000P0|||000000000010171924||||2008303987|000010|C|20011201|0010156613||SSSSSSSSSSSSSS||5655040|MERVA IMS  MVS/ESA V3|W00000F|||000000000010164329|HPrasad-ES|||2008307879|000001|C|20020701|0010156613||TESTTESTTEST||5655DB2|IBM DB2 for OS/390 Version 5|W00007C|||000000000010164454|HPrasad-ES|||625|2008308507|000020|000010||||S00087N|DB2 UDB for OS/390|Monthly Charge|000||2008303987|000020|000010|Usage Tiers|Up to 3 Copies|Basic|S0001RC|MERVA AIX USE & BRANCH|Monthly Charge|71376||2008307879|000002|000001|GOLC|Processor Group H30|Basic|S00MVJ2|QMF Win V6 F/C of DB2 V5|Monthly Charge|9200||2008307879|000003|000001|GOLC|Processor Group H70|Basic|S00MVJ4|QMF Win V6 w Host QMF prereq|Monthly Charge|53360||2008307879|000004|000001|GOLC|Processor Group H50|Basic|S001FJ7|IBM DB2 for OS/390 Version 5|Monthly Charge|510781||2008307879|000005|000001|NALC|3|Basic|S001FJ8|DB2 V5 Performance Monitor|Monthly Charge|1104000||233|2008303987|000020|20030901|20040831|71376|EUR|2008307879|000002|20030901|20040831|9200|EUR|2008307879|000003|20030901|20040831|53360|EUR|2008307879|000004|20030901|20040831|510781|EUR|2008307879|000005|20030901|20040831|1104000|EUR|";

		printRetrieveDeltaInventoryOutputConnectorDTO(converter.parseMsgString(msg));
	}

	public void printRetrieveDeltaInventoryOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		printRetrieveInvenDetailOutputConnectorDTO(conn);
	}
	//useridMaint RFC
	public void useridMaintInputO2String() throws Exception
	{
		UseridMaintInputConnectorDTO dto = new UseridMaintInputConnectorDTO();
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_USERID_MAINT_OPPT");
		genericDTO.setSessionID("kedaribm2003091937652");
		genericDTO.setUserID("ibmoppt");
		dto.setGenericConnectorDTO(genericDTO);
		//dto.setFlag("D"); //For Delete

		// For Create
		dto.setFlag("M");
		String salesOrg[] = {"0147","0048","0072"};
		String accessType[] ={"*","*","*"};
		dto.setSalesOrg(salesOrg);
		dto.setAccessType(accessType);		
		
		RFCConverter converter = new RFCConverter("Z_FV_USERID_MAINT_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		useridMaintInputS2Object();
	}

	public void useridMaintInputS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_USERID_MAINT_OPPT");
		String msg = "0|";
		printUseridMaintInputOutputConnectorDTO(converter.parseMsgString(msg));
	}
	public void printUseridMaintInputOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		UseridMaintOutputConnectorDTO useridMaintOutputConnectorDTO =	(UseridMaintOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ useridMaintOutputConnectorDTO.getReturnCode()+ "\n");
	}
	// retrieveUserAuth RFC
	public void retrieveUserAuthO2String() throws Exception
	{
		RetrieveUserAuthInputConnectorDTO dto = new RetrieveUserAuthInputConnectorDTO();
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_RETRIEVE_USERAUTH_OPPT");
		genericDTO.setSessionID("kedaribm2003091937652");
		genericDTO.setUserID("ibmoppt");
		dto.setGenericConnectorDTO(genericDTO);

		RFCConverter converter = new RFCConverter("Z_WV_RETRIEVE_USERAUTH_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		retrieveUserAuthS2Object();
	}

	public void retrieveUserAuthS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_RETRIEVE_USERAUTH_OPPT");
		String msg = "0|00029|0365|*|0048|*|8660|*|0147|*|";
		printRetrieveUserAuthOutputConnectorDTO(converter.parseMsgString(msg));
	}

	public void printRetrieveUserAuthOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		RetrieveUserAuthOutputConnectorDTO retrieveUserAuthOutputConnectorDTO =
			(RetrieveUserAuthOutputConnectorDTO) conn;

		System.out.println(
			"\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "
				+ retrieveUserAuthOutputConnectorDTO.getReturnCode()
				+ "\n");

		Iterator iter = retrieveUserAuthOutputConnectorDTO.getRetrieveUserAuthConnectorDTO().iterator();

		RetrieveUserAuthConnectorDTO retrieveDTO;
		while (iter.hasNext())
		{
			retrieveDTO = (RetrieveUserAuthConnectorDTO) iter.next();
			System.out.println("Sales Area       : " + retrieveDTO.getSalesArea());
			System.out.println("Access Type      : " + retrieveDTO.getAccessType());
		}
	}
	//validateBPAccessOPP RFC
	public void validateBPAccessOPPTO2String() throws Exception
	{
		ValidateBPAccessInputConnectorDTO dto = new ValidateBPAccessInputConnectorDTO();
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_VALIDATE_BP_ACCESS_OPPT");
		genericDTO.setSessionID("kedaribm2003091937652");
		genericDTO.setUserID("ibmoppt");
		dto.setGenericConnectorDTO(genericDTO);
		dto.setSalesOrg("0365");
		dto.setAccessOption("SP");

		CustListAndSeqConnectorDTO custListAndSeqConnectorDTO = new CustListAndSeqConnectorDTO();
		custListAndSeqConnectorDTO.setLegacyCustNumber("733033");
		custListAndSeqConnectorDTO.setAddSeqNumber("AE");
		
		List custObjList = new ArrayList();
		custObjList.add(custListAndSeqConnectorDTO);
		dto.setCustListAndSeqConnectorDTO(custObjList);
		
		RFCConverter converter = new RFCConverter("Z_WV_VALIDATE_BP_ACCESS_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		validateBPAccessOPPTS2Object();
	}

	public void validateBPAccessOPPTS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_VALIDATE_BP_ACCESS_OPPT");
		String msg = "500|13|4215258|AE|";
		printValidateBPAccessOutputConnectorDTO(converter.parseMsgString(msg));
	}

	public void printValidateBPAccessOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		ValidateBPAccessOutputConnectorDTO validateBPAccessOutputConnectorDTO =
			(ValidateBPAccessOutputConnectorDTO) conn;
		System.out.println(	"\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: " + validateBPAccessOutputConnectorDTO.getReturnCode() + "\n");
		
//		String [] inValidCustList = validateBPAccessOutputConnectorDTO.getInvalidCustListNo();
//		for(int i=0; i< inValidCustList.length; i++)
//		{
//			System.out.println("Customer List Number        : " + inValidCustList[i]);
//		}				
		List inLegacyAndSeqList = validateBPAccessOutputConnectorDTO.getCustListAndSeqConnectorDTO();
		Iterator iter = inLegacyAndSeqList.iterator();

		CustListAndSeqConnectorDTO custListAndSeqConnectorDTO;
		while (iter.hasNext())
		{
			custListAndSeqConnectorDTO = (CustListAndSeqConnectorDTO) iter.next();
			System.out.println("Legacy Number           : " + custListAndSeqConnectorDTO.getLegacyCustNumber());
			System.out.println("Address Seq Number      : " + custListAndSeqConnectorDTO.getAddSeqNumber());
		}

	}

	public void validateUserAccessOPPTO2String() throws Exception
	{
		ValidateUserAccessInputConnectorDTO dto = new ValidateUserAccessInputConnectorDTO();
		dto.setFunctionModuleName("Z_WV_VALIDATE_USER_ACCESS_OPPT");
		dto.setSessionID("saraibm2003091939576");
		dto.setCreatedBy("saraibm");
		dto.setUserID("OPPTAPPROVER");

		OrgConnectorDTO orgDTO = new OrgConnectorDTO();
		orgDTO.setSalesOrg("0365");
		orgDTO.setDistributionChannel("A");
		orgDTO.setDivision("00");

		dto.setOrgConnectorDTO(orgDTO);

		dto.setProposalType("EA");
		dto.setBTPNo("0010156613");
		dto.setPayerNo("0010156613");
		dto.setShipToPartyNo("0010156613");
		List list = new ArrayList();
		list.add("0010156613");
		
		dto.setSapSoldToParty(list);

		RFCConverter converter = new RFCConverter("Z_WV_VALIDATE_USER_ACCESS_OPPT");
		System.out.println(
			"Actual #Z_WV_VALIDATE_USER_ACCESS_OPPT|saraibm2003091939576|saraibm|OPPTAPPROVER|0365|A|00|EA|0010156613|0010156613|0010156613|0010156613|#");
		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		validateUserAccessOPPTS2Object();
	}

	public void validateUserAccessOPPTS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_VALIDATE_USER_ACCESS_OPPT");
		String msg = "0|";
		printValidateUserAccessOutputConnectorDTO(converter.parseMsgString(msg));
	}

	public void printValidateUserAccessOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		ValidateUserAccessOutputConnectorDTO dto = (ValidateUserAccessOutputConnectorDTO) conn;
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: " + dto.getReturnCode() + "\n");
	}

	//Create Variance  RFC
	public void createVarianceReportO2String() throws Exception
	{
		CreateVarianceReportInputConnectorDTO dto = new CreateVarianceReportInputConnectorDTO();
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_CREATE_VAR_OPPT");
		genericDTO.setSessionID("kedaribm2003091937652");
		genericDTO.setUserID("kedaribmCSO");
		dto.setGenericConnectorDTO(genericDTO);
		dto.setSalesOrg("0147");
		dto.setExternalContractNumber("0001235P01");
		dto.setProposalType("ES");
		dto.setContractPeriodStartDate(Date.valueOf("2003-01-01"));
		dto.setContractPeriodEndDate(Date.valueOf("2003-12-31"));
		dto.setCapAmount("30000");
		dto.setLegacyCustomerNo("8650437");
		dto.setAddressSequenceNo("001");
		dto.setVarianceDate(Date.valueOf("2003-12-08"));
		dto.setIndicatorVarType("C");
		dto.setIndicatorQuoteIncluded("");
		
		RFCConverter converter = new RFCConverter("Z_WV_CREATE_VAR_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		createVarianceReportS2Object();
	}

	public void createVarianceReportS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_CREATE_VAR_OPPT");
		String msg = "0|";
		printCreateVarianceReportInputOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printCreateVarianceReportInputOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		CreateVarianceReportOutputConnectorDTO createVarianceReportOutputConnectorDTO =	(CreateVarianceReportOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ createVarianceReportOutputConnectorDTO.getReturnCode()+ "\n");
	}
	
	//Check Variance  RFC
	public void checkVarianceO2String() throws Exception
	{
		CheckVarianceInputConnectorDTO dto = new CheckVarianceInputConnectorDTO();
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_CHECK_VARIANCE_OPPT");
		genericDTO.setSessionID("kedaribm2003091937652");
		genericDTO.setUserID("kedaribmCSO");
		dto.setGenericConnectorDTO(genericDTO);
		dto.setSalesOrg("0147");
		dto.setExternalContractNumber("0001235P01");
		dto.setVarianceDate(Date.valueOf("2003-12-08"));
		dto.setIndicatorVarType("C");		
		
		RFCConverter converter = new RFCConverter("Z_WV_CHECK_VARIANCE_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		checkVarianceS2Object();
	}

	public void checkVarianceS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_CHECK_VARIANCE_OPPT");
		String msg = "0|26|ESSO-Ge-Re|581684|581684|0|272|2008303987|000010|C|00000000|0010156613||SSSSSSSSSSSSSS||5655040|MERVA IMS  MVS/ESAV3|W00000F|||000000000010164329|ESSO-Ge-Re|||2008310109|000010|C|00000000|0010156613||KEDAR-ESSO|KEDAR-ESSO|5655DB2|IBM DB2 for OS/390 Version5|W000097|||000000000010176258|ESSO-Ge-Re|||190|2008303987|000020|000010|Usage Tiers|Up to 3 Copies||S0001RC|MERVA AIX USE & BRANCH||000||2008310109|000020|000010|PSLC below 3 MSUs|Up to 2 MSU||S001FJ7|IBM DB2 for OS/390 Version 5||000||1|";
		printCheckVarianceInputOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printCheckVarianceInputOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		CheckVarianceOutputConnectorDTO checkVarianceOutputConnectorDTO =	(CheckVarianceOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ checkVarianceOutputConnectorDTO.getReturnCode()+ "\n");
		CheckVarianceConnectorDTO checkVarianceConnectorDTO = checkVarianceOutputConnectorDTO.getCheckVarianceConnectorDTO();
		
		System.out.println("\n\nExternal Contract Number : " + checkVarianceConnectorDTO.getExternalContractNumber());
		System.out.println("Total amount of inventory    : " + checkVarianceConnectorDTO.getTotalInventoryAmount());
		System.out.println("Cap variance	             : " + checkVarianceConnectorDTO.getCapVariance());
		
		Iterator iter = null, iter2 = null, iter3 = null;
				
		iter  = checkVarianceOutputConnectorDTO.getSWOConnectorDTOList().iterator();
		iter2 = checkVarianceOutputConnectorDTO.getEEConnectorDTOList().iterator();
		iter3 = checkVarianceOutputConnectorDTO.getPriceConnectorDTOList().iterator();
		while (iter.hasNext())
		{
			SWOConnectorDTO dto = (SWOConnectorDTO) iter.next();
			
			System.out.println("\n\nSales Document Number : " + dto.getSalesDocumentNumber());
			System.out.println("SWO Item position no      : " + dto.getSWOItemPositionNumber());
			System.out.println("Sales document category   : " + dto.getSalesDocumentCategory());
			System.out.println("Request delivery date     : " + dto.getRequestDeliveryDate());
			System.out.println("Customer number           : " + dto.getCustomerNumber());
			System.out.println("Customer purch order no   : " + dto.getCustomerPurchaseOrderNumber());
			System.out.println("Designated machine        : " + dto.getDesignatedMachine());
			System.out.println("Desig machine desc        : " + dto.getDesigMachineDesc());
			System.out.println("SWO material number       : " + dto.getSWOMaterialNumber());
			System.out.println("Description of swo        : " + dto.getSWODesc());
			System.out.println("SWO serial number         : " + dto.getSWOSerialNumber());
			System.out.println("Reference serial number   : " + dto.getReferenceSerialNumber());
			System.out.println("Reference designd machine : " + dto.getReferenceDesignatedMachine());
			System.out.println("Equipment number          : " + dto.getEquipmentNumber());
			System.out.println("SWO External contract no  : " + dto.getSWOExternalContractNumber());
			System.out.println("SWO Contract type         : " + dto.getSWOContractType());
			System.out.println("SWO Contract status       : " + dto.getSWOContractStatus());
		}

		System.out.println("\n\n EE \n*******************\n");
		while (iter2.hasNext())
		{
			EEConnectorDTO dto = (EEConnectorDTO) iter2.next();

			System.out.println("\n\nSales document number  : " + dto.getSalesDocumentNumber());
			System.out.println("EE Item position number    : " + dto.getEEItemPositionNumber());
			System.out.println("SWO Item position number   : " + dto.getSWOItemPositionNumber());
			System.out.println("Value metric               : " + dto.getValueMetric());
			System.out.println("Use level                  : " + dto.getUseLevel());
			System.out.println("License type               : " + dto.getLicenseType());
			System.out.println("EE material number         : " + dto.getEEMaterialNumber());
			System.out.println("Description of EE material : " + dto.getDescriptionOfEEMaterial());
			System.out.println("Charge option              : " + dto.getChargeOption());
			System.out.println("First month list price     : " + dto.getFirstMonthListPrice());
			System.out.println("PLET no.                   : " + dto.getPLETNo());
		}

		System.out.println("\n\n PRICE \n*******************\n");
		while (iter3.hasNext())
		{
			PriceConnectorDTO dto = (PriceConnectorDTO) iter3.next();

			System.out.println("\n\nSales document number  : " + dto.getSalesDocumentNumber());
			System.out.println("EE Item position no        : " + dto.getEEItemPositionNo());
			System.out.println("Billing start date         : " + dto.getBillingStartDate());
			System.out.println("Billing end date           : " + dto.getBillingEndDate());
			System.out.println("ESW price                  : " + dto.getESWPrice());
			System.out.println("Currency                   : " + dto.getCurrency());
			//System.out.println("Indicator                  : " + dto.getIndicator());
		}
	}
	//Create Contract RFC	
	public void createContractO2String() throws Exception
	{
		CreateContractInputConnectorDTO dto = new CreateContractInputConnectorDTO();
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_CREATE_CONTRACT_OPPT");
		genericDTO.setSessionID("kedaribm2003091937652");
		genericDTO.setUserID("kedaribmCSO");
		dto.setIApproverUserId("shashi");
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		orgConnectorDTO.setSalesOrg("0147");
		orgConnectorDTO.setDivision("00");
		orgConnectorDTO.setDistributionChannel("A");
		dto.setIGenericConnectorDTO(genericDTO);
		dto.setIOrgConnectorDTO(orgConnectorDTO);
		
		dto.setIContractNumber("0001235P01");
		dto.setIExternalContractNumber("0001235P01");
		dto.setIVarianceCount("");
		dto.setIFinancingContractNumber("");
		dto.setIProposalType("AM");
		dto.setIContractStartDate(Date.valueOf("2003-01-01"));
		dto.setIContractEndDate(Date.valueOf("2006-12-31"));
		dto.setIContractStartPeriod(Date.valueOf("2003-01-01"));
		dto.setIContractEndPeriod(Date.valueOf("2003-01-01"));
		dto.setIBillingFrequencyNumber("");
		dto.setISpecialRate(0);
		dto.setIAnniversaryAmount("");
		dto.setIGrowthFactor(0);
		dto.setICapAmount("");
		dto.setICapPlus(0);
		dto.setICapMinus(0);
		dto.setIPreTVMInvoiceAmount("");
		dto.setICurrency("");
		dto.setIFlag("");
		dto.setIPakId("");
		dto.setIPaymentTerm("");
		dto.setIFixedValDate(Date.valueOf("2003-01-01"));
		dto.setIAddValueDays("");
		dto.setIBillingType("");
		dto.setIAdvanceBilling("");
		dto.setIInvoiceIndicator("");
		dto.setIDeviatingRule("");
		dto.setIBillingBlock("");
		dto.setIPoNumber("");
		dto.setIPoDate(Date.valueOf("2003-01-01"));
		dto.setIGsaIndicator("");
		dto.setIBillingSupressIndicator("");
		dto.setIFreeTextlength("");
		dto.setIFreeText("Test Proposal");
		dto.setIPartnerFunctionLength("");
		// add for partner and EE's
		
		
		RFCConverter converter = new RFCConverter("Z_FV_CREATE_CONTRACT_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		createContractS2Object();
	}

	public void createContractS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_CREATE_CONTRACT_OPPT");
		String msg = "0|";
		printCreateContractInputOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printCreateContractInputOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		CreateContractOutputConnectorDTO createContractOutputConnectorDTO =	(CreateContractOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ createContractOutputConnectorDTO.getReturnCode()+ "\n");
	}
	//Change Contract RFC
	public void changeContractO2String() throws Exception
	{
		ChangeContractInputConnectorDTO dto = new ChangeContractInputConnectorDTO();
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_CHANGE_CONTRACT_OPPT");
		genericDTO.setSessionID("kedaribm2003091937652");
		genericDTO.setUserID("kedaribmCSO");
		dto.setIGenericConnectorDTO(genericDTO);
		dto.setIContractNumber("");
		dto.setIContractStatus("PA");
		dto.setIContractClosureDate(Date.valueOf("2003-01-01"));
		dto.setIAmendmentReplacementCounter("");
		dto.setIVarianceCounter("");	
		
		RFCConverter converter = new RFCConverter("Z_FV_CHANGE_CONTRACT_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		changeContractS2Object();
	}

	public void changeContractS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_CHANGE_CONTRACT_OPPT");
		String msg = "0|";
		printChangeContractInputOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printChangeContractInputOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		ChangeContractOutputConnectorDTO changeContractOutputConnectorDTO =	(ChangeContractOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ changeContractOutputConnectorDTO.getIReturnCode()+ "\n");
	}

	public void createVarianceO2String() throws Exception
	{
		CreateVarianceReportInputConnectorDTO dto = new CreateVarianceReportInputConnectorDTO();
		
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_CREATE_VAR_OPPT");
		genericDTO.setSessionID("saraibm2003091941860");
		genericDTO.setUserID("saraibm");
		dto.setGenericConnectorDTO(genericDTO);
		
		dto.setSalesOrg("0365");
		dto.setExternalContractNumber("RQ2499Simu");
		dto.setProposalType("ES");
		dto.setContractPeriodStartDate(Date.valueOf("2003-01-01"));
		dto.setContractPeriodEndDate(Date.valueOf("2003-12-31"));
		dto.setCapAmount("");
		dto.setLegacyCustomerNo("733033");
		dto.setAddressSequenceNo("AE");
		dto.setVarianceDate(Date.valueOf("2003-09-19"));
		dto.setIndicatorVarType("C");
		dto.setIndicatorQuoteIncluded("");
		
		RFCConverter converter = new RFCConverter("Z_WV_CREATE_VAR_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		createVarianceS2Object();
	}

	public void createVarianceS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_CREATE_VAR_OPPT");
		String msg = "0|";
		printCreateVarianceReportOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printCreateVarianceReportOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		CreateVarianceReportOutputConnectorDTO createVarianceReportOutputConnectorDTO =	(CreateVarianceReportOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ createVarianceReportOutputConnectorDTO.getReturnCode()+ "\n");
	}
	
	//RFC Compare Author
	
	public void compareAuthorO2String() throws Exception
	{
		CompareAuthorInputConnectorDTO dto = new CompareAuthorInputConnectorDTO();		

		dto.setFunctionModuleName("Z_WV_COMPARE_AUTHOR_OPPT");
		dto.setSessionID("saraibm2003091941860");
		dto.setAdminFlag("");
		dto.setUserID1("kedaribm");
		dto.setUserID2("saranew");
		
		RFCConverter converter = new RFCConverter("Z_WV_COMPARE_AUTHOR_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		compareAuthorS2Object();
	}

	public void compareAuthorS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_COMPARE_AUTHOR_OPPT");
		String msg = "0|";
		printCompareAuthorOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printCompareAuthorOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		CompareAuthorOutputConnectorDTO compareAuthorOutputConnectorDTO =	(CompareAuthorOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ compareAuthorOutputConnectorDTO.getReturnCode()+ "\n");
	}
	
	//RFC RETRIEVE_PAYM_TERMS_OPPT
	
	public void retrievePaymentTermsO2String() throws Exception
	{
		RetrievePaymentTermsInputConnectorDTO dto = new RetrievePaymentTermsInputConnectorDTO();		

		dto.setFunctionModuleName("Z_WV_RETRIEVE_PAYM_TERMS_OPPT");
		dto.setSessionID("saraibm2003091941860");
				
		RFCConverter converter = new RFCConverter("Z_WV_RETRIEVE_PAYM_TERMS_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		retrievePaymentTermsS2Object();
	}

	public void retrievePaymentTermsS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_RETRIEVE_PAYM_TERMS_OPPT");
		String msg = "0|02267|A001|Zero days for Due date/LPF date calculation|A002|0/30 Days for Due date/LPF date calculation|A003|Last day of current/next mth for Due date/LPF date|A004|Due Date:30 days from Invoice date.LPF date:60 day|A005|30 days from Invoice date|A010|10 days from Invoice date|A015|Due date:40 days from invoice date,no LPF for Govt|A016|Due date:50 days from invoice date,no LPF for Govt|A017|DueDate=invoice date. LPF date=inv date+45d,if app|A018|Due date:60d fr Inv Date. No LPF for Gov|A019|Due date:90d fr Inv date. no LPF for gov|A020|Due Date:120d fr Inv date.No LPF for gov|A021|Due Date:150d fr Inv date.No LPF for gov|A022|Due Date:180d fr Inv date.No LPF for gov|A023|Due Date:210d fr Inv date.No LPF for gov|A024|Payment at 20th of the next month fr invoice date|A025|CER Payment within 21 Days 1.5% Discount|A026|CER Payment 80 Days with 1.5% Interest|A027|120 days w/30% down + 3.5% Interest on|A028|Due open receipt of invoice with direct debit|A029|Net Due 45 Days from Invoice Date No LPF|A031|LPF date: 60 days from Invoice date if LPF applies|A032|60 Days from Invoice Date,w/Late Payment Fees|A033|90 Days from Invoice Date, w/Late Payment Fees|A034|120 Days from Invoice Date, w/Late Payment Fees|A035|150 Days from Invoice Date, w/Late Payment Fees|A036|180 Days from Invoice Date,w/Late Payment Fees|A037|210 Days from Invoice Date,w/Late Payment Fees|A038|60 Days from SW Recept date, no LPF for Government|A039|90 Days from Ship Date, no LPF for government|A040|Due date depends on inv creation date Austria gov|AS10|10 days from Invoice date|AS11|Due date:invoice date month end +60 days|AS12|Due date=end of current month + 1 month|AS13|Due date: Invoice date + 15 days|AS14|Direct Debiting;Invoice date + 30 days|P001|Cash before order (CBO)|P003|Cash before delivery (CBD)|P004|Cash on delivery (COD)|P015|Payable in accordance with Payment Amendment|P037|Czech Republic&Slovenia,Payment 80 days|P038|CER 2% prepmt disc already deducted from Inv-amnt|P039|CER 3% prepmt disc fr. end app/#days=999|P041|CER 2% prepmt disc will be deducted at paymnt time|P042|CER 3% prepmt disc bk. end.app/#days=998|WCFI|Working Capital Finance Agreement|Z01S|Securitization Term|ZSDD|Direct Debiting;Invoice date + 13 days|ZZI1|Intercompany Payment Terms 1|";
		printRetrievePaymentOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printRetrievePaymentOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		RetrievePaymentTermsOutputConnectorDTO retrievePaymentTermsOutputConnectorDTO = (RetrievePaymentTermsOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ retrievePaymentTermsOutputConnectorDTO.getIReturnCode()+ "\n");
		
		Iterator iter = retrievePaymentTermsOutputConnectorDTO.getIPaymentTermConnectorDTO().iterator();

		PaymentTermConnectorDTO paymentTermConnectorDTO;
		while (iter.hasNext())
		{
			paymentTermConnectorDTO = (PaymentTermConnectorDTO) iter.next();
			System.out.println("\n\nPayment Code         : " + paymentTermConnectorDTO.getIPaymentCode());
			System.out.println("Payment Desc			 : " + paymentTermConnectorDTO.getIPaymentDesc());
		}
	}
	
	//RFC Z_WV_RETRIEVE_DATE_RULES_OPPT
	
	public void retrieveDateRulesO2String() throws Exception
	{
		RetrieveDateRulesInputConnectorDTO dto = new RetrieveDateRulesInputConnectorDTO();	
		
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_RETRIEVE_DATE_RULES_OPPT");
		genericDTO.setSessionID("saraibm2003091941860");
		genericDTO.setUserID("saraibm");
		dto.setIGenericConnectorDTO(genericDTO);
				
		RFCConverter converter = new RFCConverter("Z_WV_RETRIEVE_DATE_RULES_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		retrieveDateRulesS2Object();
	}

	public void retrieveDateRulesS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_RETRIEVE_DATE_RULES_OPPT");
		String msg = "0|01644|11|Last of month for billing date + 1 month|50|Monthly on First of Month|51|Monthly on Last of Month|53|Monthly|9M|IBM ESW Monthly (SWG)|9Q|IBM ESW Quarterly (SWG - off quarter)|9S|IBM ESW Semi-Annual (SWG)|AD|Annual advance|MD|Monthly advance|MR|Monthly arrears|QD|Quarterly advance|YA|ESW Annual Advance|YB|IBM ESW Annual in Arrears|YC|IBM ESW Annual in Arrears (US Fiscal Year)|YE|IBM ESW Quarterly Advance - EAS|YF|IBM ESW Annual (fiscal year) in Arrears|YG|Quarterly in Arrears, US|YI|IBM ESW Quarterly Arrears Statement|YJ|IBM ESW Monthly Arr. 05.Dec|YK|IBM OPPT Annual in Arrears|YL|IBM OPPT Quarterly Arrears|YM|IBM ESW Monthly|YN|IBM ESW Monthly Arrear|YO|ESW Horizon 1 Year|YP|IBM ESW Quarterly Arrears|YQ|IBM ESW Quarterly Advance|YR|IBM ESW Semi Annual in Arrears|YS|IBM ESW Semi-Annual in Arrears Settlement|YT|ESW 12 months advance|YV|IBM OPPT Semi Annual in Arrears|YW|IBM OPPT Monthly Arrears|ZA|Annual advance no cal.|ZE|ESW Month Arr.27Dec|ZH|IBM ESW Annual Advance, Anniversary on 01 February|ZI|IBM ESW Annual Advance, Anniversary on 01 March|ZJ|IBM ESW Annual Advance, Anniversary on 01 April|ZK|IBM ESW Annual Advance, Anniversary on 01 May|ZL|IBM ESW Annual Advance, Anniversary on 01 June|ZM|IBM ESW Annual Advance, Anniversary on 01 July|ZN|IBM ESW Annual Advance, Anniversary on 01 August|ZO|IBM ESW Annual Advance, Anniversary on 01 September|ZP|IBM ESW Annual Advance, Anniversary on 01 October|ZQ|IBM ESW Annual Advance, Anniversary on 01 November|ZR|First of month after 4 months|ZS|IBM Catia Semi-Annual|ZT|IBM ESW Annual Advance, Anniversary on 01 December|ZU|IBM ESW Annual Advance, Anniversary on 01 December|";
		printRetrieveDateRulesOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printRetrieveDateRulesOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		RetrieveDateRulesOutputConnectorDTO retrieveDateRulesOutputConnectorDTO = (RetrieveDateRulesOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ retrieveDateRulesOutputConnectorDTO.getIReturnCode()+ "\n");
		
		Iterator iter = retrieveDateRulesOutputConnectorDTO.getIBillingTypeConnectorDTO().iterator();

		BillingTypeConnectorDTO billingTypeConnectorDTO;
		while (iter.hasNext())
		{
			billingTypeConnectorDTO = (BillingTypeConnectorDTO) iter.next();
			System.out.println("\n\nBilling Code         : " + billingTypeConnectorDTO.getIBillingCode());
			System.out.println("Billing Desc			 : " + billingTypeConnectorDTO.getIBillingDesc());
		}
	}
	
	//RFC Z_FV_REFRESH_CURRENCY_OPPT
	
	public void refreshCurrencyO2String() throws Exception
	{
		RefreshCurrencyInputConnectorDTO dto = new RefreshCurrencyInputConnectorDTO();	
		
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_REFRESH_CURRENCY_OPPT");
		genericDTO.setSessionID("saraibm2003091941860");
		genericDTO.setUserID("saraibm");
		dto.setIGenericConnectorDTO(genericDTO);
				
		RFCConverter converter = new RFCConverter("Z_FV_REFRESH_CURRENCY_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		refreshCurrencyS2Object();
	}

	public void refreshCurrencyS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_REFRESH_CURRENCY_OPPT");
		String msg = "0|003828|AED|United Arab Emirates Dirham|2|AFA|Afghani|2|ALL|Albanian Lek|2|AMD|Armenian Dram|2|ANG|Netherlands Antillian Guilder|2|AOA|Angola Kwanza|2|ARS|Argentine Peso|2|AUD|Australian Dollar|2|AUDN|Australian dollar extra decimals|2|AWG|Aruban Guilder|2|AZM|Azerbaijanian Manat|2|BAM|Bosnia/Herzegovina Convertible Marks|2|BBD|Barbados Dollar|2|BDT|Bangladesh Taka|2|BGL|Bulgarian Lev|2|BGN|Bulgarian Lev (New)|2|BHD|Bahraini Dinar|3|BIF|Burundi Franc|0|BMD|Bermudian Dollar|2|BND|Brunei Dollar|2|BOB|Bolivian Bolivianos|2|BRL|Brazilian Real (new)|2|BSD|Bahamian Dollar|2|BTN|Bhutan Ngultrum|2|BWP|Botswana Pula|2|BYR|Belarussian Ruble|0|BZD|Belize Dollar|2|CAD|Canadian Dollar|2|CDF|Franc Congolais|2|CFP|French Franc (Pacific Islands)|2|CHF|Swiss Franc|2|CLP|Chilean Peso|0|CNY|Chinese Yuan Renminbi|2|COP|Columbian Peso|2|CRC|Costa Rica Colon|2|CUP|Cuban Peso|2|CVE|Cape Verde Escudo|2|CYP|Cyprus Pound|2|CZK|Czech Koruna|2|DJF|Djibouti Franc|0|DKK|Danish Krone|2|DOP|Dominican Peso|2|DZD|Algerian Dinar|2|ECS|Ecuador Sucre|2|EEK|Estonian Kroon|2|EGP|Egyptian Pound|2|ERN|Eritrea Nakfa|2|ETB|Ethiopian Birr|2|EUR|Currency of EMU member states|2|FJD|Fiji Dollar|2|FKP|Falkland Island Pound|2|GBP|British Pound|2|GEL|Georgian Lari|2|GHC|Ghanian Cedi|2|GIP|Gibraltar Pound|2|GMD|Gambian Dalasi|2|GNF|Guinea Franc|0|GTQ|Guatemalan Quetzal|2|GWP|Guinea-Bissau Peso|2|GYD|Guyanese Dollar|2|HKD|Hong Kong Dollar|2|HNL|Honduran Lempira|2|HRK|Croatian Kuna|2|HTG|Haitian Gourde|2|HUF|Hungarian Forint|2|IDR|Indonesian Rupiah|2|ILS|Israeli Sheqel|2|INR|Indian Rupee|2|IQD|Iraqi Dinar|3|IRR|Iranian Rial|2|ISK|Iceland Krona|2|JMD|Jamaican Dollar|2|JOD|Jordanian Dinar|3|JPY|Japanese Yen|0|KES|Kenyan Shilling|2|KGS|Kyrgzystan Som|2|KHR|Cambodian Riel|2|KMF|Comoros Franc|0|KPW|North Korean Won|2|KRW|South Korean Won|0|KWD|Kuwaiti Dinar|3|KYD|Cayman Dollar|2|KZT|Kazakhstan Tenge|2|LAK|Laotian Kip|2|LBP|Lebanese Pound|2|LKR|Sri Lankan Rupee|2|LRD|Liberian Dollar|2|LSL|Lesotho Loti|2|LTL|Lithuanian Litas|2|LVL|Latvian Lat|2|LYD|Libyan Dinar|3|MAD|Moroccan Dirham|2|MDL|Moldovan Leu|2|MGF|Malagasy Franc|0|MKD|Macedonian Denar|2|MMK|Myanmar Kyat|2|MNT|Mongolian Tugrik|2|MOP|Macao Pataca|2|MRO|Mauritanian Ouguiya|2|MTL|Maltese Lira|2|MUR|Mauritian Rupee|2|MVR|Maldive Rufiyaa|2|MWK|Malawi Kwacha|2|MXN|Mexican Peso (new)|2|MYR|Malaysian Ringgit|2|MZM|Mozambique Metical|2|NAD|Nambian Dollar|2|NGN|Nigerian Naira|2|NIO|Cordoba Oro|2|NOK|Norwegian Krone|2|NPR|Nepalese Rupee|2|NZD|New Zealand Dollars|2|OMR|Omani Rial|3|PAB|Panamanian Balboa|2|PEN|Peru New Sol|2|PGK|Papua New Guinea Kina|2|PHP|Philippino Peso|2|PKR|Pakistani Rupee|2|PLN|Polish Zloty|2|PYG|Paraguayan Guarani|0|QAR|Qatari Rial|2|RMB|Chinese Renminbi Yuan|2|ROL|Romanian Leu|2|RUB|Russian Ruble|2|RUR|Russian Ruble (old)|2|RWF|Rwanda Franc|0|SAR|Saudi Riyal|2|SBD|Solomon Islands Dollar|2|SCR|Seychelles Rupee|2|SEK|Swedish Krona|2|SGD|Singapore Dollar|2|SHP|St.Helena Pound|2|SIT|Slovenian Tolar|2|SKK|Slovak Koruna|2|SLL|Sierra Leone Leone|2|SOS|Somalian Shilling|2|SRG|Suriname Guilder|2|STD|Sao Tome / Principe Dobra|2|SVC|El Salvador Colon|2|SYP|Syrian Pound|2|SZL|Swaziland Lilangeni|2|THB|Thailand Baht|2|TJS|Tajikistan Somoni|2|TMM|Turkmenistani Manat|2|TND|Tunisian Dinar|3|TOP|Tongan Pa'anga|2|TRL|Turkish Lira|0|TTD|Trinidad and Tobago Dollar|2|TWD|New Taiwan Dollar|2|TZS|Tanzanian Shilling|2|UAH|Ukrainian Hryvnia|2|UGX|Ugandan Shilling|2|USD|American Dollar|2|USDN|HR: US dollars with 5 decimal places|5|UYU|Uruguay New Peso|2|UZS|Uzbekistan Sum|2|VEB|Venezuelan Bolivar|2|VND|Vietnamese Dong|2|VUV|Vanuatu Vatu|0|WST|Samoan Tala|2|XAF|C.f.A Franc BEAC|0|XCD|East Carribean Dollar|2|XOF|Benin C.f.A. Franc|0|XPF|Pacific Island Franc|0|YER|Yemeni Ryal|2|YUM|Serbian and Montenegran Dinar|2|ZAR|South African Rand|2|ZMK|Zambian Kwacha|2|ZWD|Zimbabwean Dollar|2|";
		printRefreshCurrencyOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printRefreshCurrencyOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		RefreshCurrencyOutputConnectorDTO refreshCurrencyOutputConnectorDTO = (RefreshCurrencyOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ refreshCurrencyOutputConnectorDTO.getIReturnCode()+ "\n");
		
		Iterator iter = refreshCurrencyOutputConnectorDTO.getICurrencyConnectorDTO().iterator();

		CurrencyConnectorDTO currencyConnectorDTO;
		while (iter.hasNext())
		{
			currencyConnectorDTO = (CurrencyConnectorDTO) iter.next();
			System.out.println("\n\nCurrency Code         : " + currencyConnectorDTO.getICurrencyCode());
			System.out.println("Currency Name			 : " + currencyConnectorDTO.getICurrencyName());
			System.out.println("Decimal Allowed			 : " + currencyConnectorDTO.getIDecimalAllowed());
		}
	}	
	
	//RFC Z_WV_RETRIEVE_BILL_BLOCK_OPPT
	
	public void retrieveBillBlockO2String() throws Exception
	{
		RetrieveBillingBlockInputConnectorDTO dto = new RetrieveBillingBlockInputConnectorDTO();	
		
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_RETRIEVE_BILL_BLOCK_OPPT");
		genericDTO.setSessionID("saraibm2003091941860");
		genericDTO.setUserID("saraibm");
		dto.setIGenericConnectorDTO(genericDTO);
				
		RFCConverter converter = new RFCConverter("Z_WV_RETRIEVE_BILL_BLOCK_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		retrieveBillBlockS2Object();
	}

	public void retrieveBillBlockS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_RETRIEVE_BILL_BLOCK_OPPT");
		String msg = "0|00903|01|Calculation Missing|02|Compl Confirm Missin|03|Price Incomplete|04|Pending Paymnt Terms|07|Pending Addtl Info|08|Pending Credit Appr.|10|Invoiced in NINA|12|Billing Plan Block|13|Wait-Signed Contrac|14|Contract Expired|15|Contract Cancelled|70|Hold Service Pac|71|Bill Order Complete|72|Pre-Announce product|75|Rec.Charge n/a bottm|76|Rec.Charge n/a IPP|77|ILM Contract Pend.|79|Try & Buy/Trial Loan|80|S/W Pending HW Inst.|81|Pre-Invoice Credit|82|Return/Pend.Receipt|83|EMEA Invoice Consol|85|Mgmt/Fin.Appr. req'd|86|Exceeds Approved Amt|87|Waiting for COM Appr|88|TDO/DPL List|89|Rebate Credit Block|90|Pending SW Destruct|91|Pending Eagle SB Prc|92|Name/Address incompl|93|Pend. Payer Decision|94|Non Direct Shipment|95|FR/BEL/LUX Gov'tCust|96|Field Discretion|97|Contract pending|98|Promo/Offering Cond.|99|Other Block Reasons|ZB|Previously Billed|ZC|Contract Cancelled|ZD|S&S waiting cont/reg|";
		printRetrieveBillBlockOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printRetrieveBillBlockOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		RetrieveBillingBlockOutputConnectorDTO retrieveBillingBlockOutputConnectorDTO = (RetrieveBillingBlockOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ retrieveBillingBlockOutputConnectorDTO.getIReturnCode()+ "\n");
		
		Iterator iter = retrieveBillingBlockOutputConnectorDTO.getIBillingBlockConnectorDTO().iterator();

		BillingBlockConnectorDTO billingBlockConnectorDTO;
		while (iter.hasNext())
		{
			billingBlockConnectorDTO = (BillingBlockConnectorDTO) iter.next();
			System.out.println("\n\nBilling Block         : " + billingBlockConnectorDTO.getIBillingBlock());
			System.out.println("Billing Desc	 		  : " + billingBlockConnectorDTO.getIBillingBlockDesc());			
		}
	}	
	
	//RFC Z_FV_REFRESH_SALES_AREA_OPPT
	
	public void refreshSalesAreaO2String() throws Exception
	{
		RetrieveSalesAreaInputConnectorDTO dto = new RetrieveSalesAreaInputConnectorDTO();	
		
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_REFRESH_SALES_AREA_OPPT");
		genericDTO.setSessionID("saraibm2003091941860");
		genericDTO.setUserID("saraibm");
		dto.setGenericConnectorDTO(genericDTO);
				
		RFCConverter converter = new RFCConverter("Z_FV_REFRESH_SALES_AREA_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		refreshSalesAreaS2Object();
	}

	public void refreshSalesAreaS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_REFRESH_SALES_AREA_OPPT");
		String msg = "0|";
		printRefreshSalesAreaOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printRefreshSalesAreaOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		RetrieveSalesAreaOutputConnectorDTO retrieveSalesAreaOutputConnectorDTO = (RetrieveSalesAreaOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ retrieveSalesAreaOutputConnectorDTO.getReturnCode()+ "\n");
		
		Iterator iter = retrieveSalesAreaOutputConnectorDTO.getSalesAreaConnectorDTO().iterator();
		SalesAreaConnectorDTO salesAreaConnectorDTO;
		while (iter.hasNext())
		{
			salesAreaConnectorDTO = (SalesAreaConnectorDTO) iter.next();
			System.out.println("\n\nSales Org         : " + salesAreaConnectorDTO.getSalesOrg());
			System.out.println("Dstr Channel 		  : " + salesAreaConnectorDTO.getDstrChannel());
			System.out.println("Division Code 		  : " + salesAreaConnectorDTO.getDivisionCode());			
		}

		Iterator iter1 = retrieveSalesAreaOutputConnectorDTO.getSalesOrgConnectorDTO().iterator();
		SalesOrgConnectorDTO salesOrgConnectorDTO;
		while (iter.hasNext())
		{
			salesOrgConnectorDTO = (SalesOrgConnectorDTO) iter.next();
			System.out.println("\n\nSales Org         : " + salesOrgConnectorDTO.getSalesOrg());
			System.out.println("Sales org desc 		  : " + salesOrgConnectorDTO.getSalesOrgDesc());
			System.out.println("Default currency		  : " + salesOrgConnectorDTO.getDefaultCurrency());			
		}
		Iterator iter2 = retrieveSalesAreaOutputConnectorDTO.getDstrChannelConnectorDTO().iterator();
		DstrChannelConnectorDTO dstrChannelConnectorDTO;
		while (iter.hasNext())
		{
			dstrChannelConnectorDTO = (DstrChannelConnectorDTO) iter.next();
			System.out.println("\n\nDstr Channel        : " + dstrChannelConnectorDTO.getDstrChannel());
			System.out.println("Dstr channel desc 		  : " + dstrChannelConnectorDTO.getDstrChannelDesc());						
		}
		Iterator iter3 = retrieveSalesAreaOutputConnectorDTO.getDivisionConnectorDTO().iterator();
		DivisionConnectorDTO divisionConnectorDTO;
		while (iter.hasNext())
		{
			divisionConnectorDTO = (DivisionConnectorDTO) iter.next();
			System.out.println("\n\nDivision code        : " + divisionConnectorDTO.getDivisionCode());
			System.out.println("Division code desc 		  : " + divisionConnectorDTO.getDivisionCodeDesc());						
		}

	}	
	
	//RFC Z_WV_REFRESH_VARIANCE_OPPT
	
	public void refreshVarianceO2String() throws Exception
	{
		RefreshVarianceInputConnectorDTO dto = new RefreshVarianceInputConnectorDTO();	
		
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_WV_REFRESH_VARIANCE_OPPT");
		genericDTO.setSessionID("saraibm2003091941860");
		genericDTO.setUserID("saraibm");
		dto.setGenericConnectorDTO(genericDTO);
		dto.setExternalContractNumber("0000P01");
		dto.setSalesOrg("0147");
		dto.setIndicatorVarType("S");
		dto.setVarianceDate(Date.valueOf("2003-01-01"));	
		
		RFCConverter converter = new RFCConverter("Z_WV_REFRESH_VARIANCE_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		refreshVarianceS2Object();
	}

	public void refreshVarianceS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_WV_REFRESH_VARIANCE_OPPT");
		String msg = "";
		printRefreshVarianceOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printRefreshVarianceOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		RetrieveBillingBlockOutputConnectorDTO retrieveBillingBlockOutputConnectorDTO = (RetrieveBillingBlockOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ retrieveBillingBlockOutputConnectorDTO.getIReturnCode()+ "\n");	
	}	

	public void statusCheckO2String() throws Exception
	{
		StatusCheckInputConnectorDTO dto = new StatusCheckInputConnectorDTO();	
		
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_STATUS_CHECK_OPPT");
		genericDTO.setSessionID("saraibm2003091939576");
		genericDTO.setUserID("saraibm");
		dto.setGenericConnectorDTO(genericDTO);
		
		dto.setExternalContractNumber("SaraTechDa");
		dto.setFlag("RUN");
		
		RFCConverter converter = new RFCConverter("Z_FV_STATUS_CHECK_OPPT");

		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		statusCheckS2Object();
	}

	public void statusCheckS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_STATUS_CHECK_OPPT");
		String msg = "0|3|0|0000013|0||000000|||";
		printStatusCheckOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printStatusCheckOutputConnectorDTO(ConnectorDTOInterface conn)
	{
		StatusCheckOutputConnectorDTO statusCheckOutputConnectorDTO = (StatusCheckOutputConnectorDTO) conn;	
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ statusCheckOutputConnectorDTO.getReturnCode()+ "\n");
		System.out.println("SAP Return Code: " + statusCheckOutputConnectorDTO.getReturnCodeSAP());
		
		List list = statusCheckOutputConnectorDTO.getMessageConnectorDTOList();
		
		if (list != null)
		{
			Iterator iter = list.iterator();
			
			while (iter.hasNext())
			{
				System.out.println("\r\n");
				printMessageConnectorDTO((ConnectorDTOInterface)iter.next());
			}
		}
	}	

	public void printMessageConnectorDTO(ConnectorDTOInterface conn)
	{
		MessageConnectorDTO dto = (MessageConnectorDTO)conn;
		
		System.out.println("Exception code: " + dto.getExceptionCode());
		System.out.println("Internal contract no: " + dto.getInternalContractNo());
		System.out.println("Item position no: " + dto.getItemPositionNo());
		System.out.println("Message: " + dto.getMessage());
		System.out.println("Sales doc no: " + dto.getSalesDocNo());
	}

	public void dmConfigS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_RETRIEVE_CONFIG_OPPT");
		
		RetrieveInvenConfigInputConnectorDTO dto = new RetrieveInvenConfigInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_RETRIEVE_CONFIG_OPPT");
		genericDTO.setSessionID("kedaribmCSO2003120614377");
		genericDTO.setUserID("kedaribmCSO");
		dto.setGenericConnectorDTO(genericDTO);
		
		dto.setFlag('A');
		
		RetrieveConfigConnectorDTO configDTO = new RetrieveConfigConnectorDTO();
		configDTO.setSalesDocNo("26");
		configDTO.setSwoItemNo("2008310043");
		configDTO.setEeItemNo("000010");
		configDTO.setValueMetric("000020");

		List list = new ArrayList();
		list.add(configDTO);
		
		dto.setRetrieveConfigConnectorDTOList(list);
		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		
				
		String msg = "0|00490|2008310043|000010|000020|0D6000|NALC||2008310043|000010|000020|0F2000|Application StarterPak||2008310043|000010|000020|756000|ULC Measured Usag.above 0.5MSU||2008310043|000010|000020|7FA000|PSLC-AD||2008310043|000010|000020|A05000|ZELC||2008310043|000010|000020|AA9000|Var. Workload License Charge||2008310043|000010|000020|DE1000|GOLC|X|2008310043|000010|000020|E78000|PC Server S/390||2008310043|000010|000020|F56000|ULC up to 0.5 MSU||2008310043|000010|000020|FDC000|PSLC below 3 MSUs||00047|2008310043|000010|000020|DE1000|BASIC|Basic|X|00060|2008310043|000010|000020|DE1000|BASIC|MLC|Monthly Charge|X|00209|2008310043|000010|000020|DE1000|BASIC|MLC|L|H30|Processor Group H30||2008310043|000010|000020|DE1000|BASIC|MLC|L|H50|Processor Group H50||2008310043|000010|000020|DE1000|BASIC|MLC|L|H70|Processor Group H70|X|";
		printRetrieveInvenConfigOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void printRetrieveInvenConfigOutputConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		RetrieveInvenConfigOutputConnectorDTO dto = (RetrieveInvenConfigOutputConnectorDTO)connectorDTO;
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ dto.getReturnCode()+ "\n");	
		
		List list = dto.getValueMetricList();
		
		for (int i = 0; i < list.size(); i++)
		{
			printValueMetricConnectorDTO((ConnectorDTOInterface) list.get(i));
		}
		
		list = dto.getLicenseList();
		for (int i = 0; i < list.size(); i++)
		{
			printLicenseConnectorDTO((ConnectorDTOInterface) list.get(i));
		}
		
		list = dto.getChargeOptionList();
		for (int i = 0; i < list.size(); i++)
		{
			printChargeOptionConnectorDTO((ConnectorDTOInterface) list.get(i));
		}

		list = dto.getUseLevelList();
		for (int i = 0; i < list.size(); i++)
		{
			printUseLevelConnectorDTO((ConnectorDTOInterface) list.get(i));
		}
	}

	public void printValueMetricConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		System.out.println("*********** ValueMetricConnectorDTO *****************\r\n");
		
		ValueMetricConnectorDTO dto = (ValueMetricConnectorDTO)connectorDTO;
		System.out.println("Sales Doc No: " + dto.getSalesDocNo());
		System.out.println("SWO Item No : " + dto.getSwoItemNo());
		System.out.println("EE Item No  : " + dto.getEeItemNo());
		System.out.println("Value Metric: " + dto.getValueMetric());
		System.out.println("Description : " + dto.getDescription());
		System.out.println("Default: " + dto.getDefault());
		
		System.out.println("\r\n");
	}

	public void printLicenseConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		System.out.println("*********** LicenseConnectorDTO *****************\r\n");
		
		LicenseConnectorDTO dto = (LicenseConnectorDTO)connectorDTO;
		System.out.println("Sales Doc No: " + dto.getSalesDocNo());
		System.out.println("SWO Item No : " + dto.getSwoItemNo());
		System.out.println("EE Item No  : " + dto.getEeItemNo());
		System.out.println("Value Metric: " + dto.getValueMetric());
		System.out.println("License Type: " + dto.getLicenseType());
		System.out.println("Description : " + dto.getDescription());
		System.out.println("Default: " + dto.getDefault());
		
		System.out.println("\r\n");
	}

	public void printChargeOptionConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		System.out.println("*********** ChargeOptionConnectorDTO *****************\r\n");
		
		ChargeOptionConnectorDTO dto = (ChargeOptionConnectorDTO)connectorDTO;
		System.out.println("Sales Doc No: " + dto.getSalesDocNo());
		System.out.println("SWO Item No : " + dto.getSwoItemNo());
		System.out.println("EE Item No  : " + dto.getEeItemNo());
		System.out.println("Value Metric: " + dto.getValueMetric());
		System.out.println("License Type: " + dto.getLicenseType());
		System.out.println("Charge Option:" + dto.getChargeOption());
		System.out.println("Description : " + dto.getDescription());
		System.out.println("Default: " + dto.getDefault());
		
		System.out.println("\r\n");
	}
	
	
	public void printUseLevelConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		System.out.println("*********** UseLevelConnectorDTO *****************\r\n");
		
		UseLevelConnectorDTO dto = (UseLevelConnectorDTO)connectorDTO;
		System.out.println("Sales Doc No: " + dto.getSalesDocNo());
		System.out.println("SWO Item No : " + dto.getSwoItemNo());
		System.out.println("EE Item No  : " + dto.getEeItemNo());
		System.out.println("Value Metric: " + dto.getValueMetric());
		System.out.println("License Type: " + dto.getLicenseType());
		System.out.println("Charge Option:" + dto.getChargeOption());
		System.out.println("Metric Type : " + dto.getValueMetricType());
		System.out.println("use Level   : " + dto.getUseLevel());
		System.out.println("Description : " + dto.getDescription());
		System.out.println("Default: " + dto.getDefault());
		
		System.out.println("\r\n");
	}
	
	public void printPriceInquiryOutputConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		PriceInquiryOutputConnectorDTO dto = (PriceInquiryOutputConnectorDTO)connectorDTO;
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ dto.getReturnCode()+ "\n");	
		
		List list = dto.getPriceInquiryConnectorDTOList();
		Iterator iter = list.iterator();
		
		while (iter.hasNext())
		{
			printPriceInquiryConnectorDTO((ConnectorDTOInterface)iter.next());
		}
	}
	
	public void printPriceInquiryConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		PriceInquiryConnectorDTO dto = (PriceInquiryConnectorDTO)connectorDTO;
		
		System.out.println("\r\n");
		System.out.println("Currency   : " + dto.getCurrency()); 
		System.out.println("EE Item No : " + dto.getEeItemNo());
		System.out.println("Price      : " + dto.getPrice());
		System.out.println("Sales DocNo: " + dto.getSalesDocNo());
		System.out.println("Bill Plan End Date  : " + dto.getBillPlanEndDte());
		System.out.println("Bill Plan Start Date : " + dto.getBillPlanStartDte());
	}

	public void validateConfigS2Object() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_FV_VALIDATE_CONFIG_OPPT");
		
		ValidateInvenConfigInputConnectorDTO dto = new ValidateInvenConfigInputConnectorDTO();

		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_FV_VALIDATE_CONFIG_OPPT");
		genericDTO.setSessionID("kedaribmCSO2003120614377");
		genericDTO.setUserID("kedaribmCSO");
		dto.setGenericConnectorDTO(genericDTO);
		
		ValidateConfigConnectorDTO v = new ValidateConfigConnectorDTO();
		v.setEeSalesDocNo("2008310043");
		v.setSwoItemNo("000010");
		v.setEeItemNo("000020");
		v.setValueMetric("DE1000");
		v.setLicenseType("BASIC");
		v.setChargeOption("MLC");
		v.setValueMetricType("L");
		v.setUseLevel("H70");
		
		List list = new ArrayList();
		list.add(v);
		
		dto.setValidateConfigConnectorDTOList(list);
		System.out.println("OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		
				
		String msg = "0|00027|2008310043|000010|000020||";
		
		printValidateInvenConfigOutputConnectorDTO(converter.parseMsgString(msg));
	}
	
	public void validateComplexData() throws Exception
	{
		RFCConverter converter = new RFCConverter("Z_YOTCCM_COMP_CONTR_IDNT_VALD");
		ValidateComplexDataInputConnectorDTO dto = new ValidateComplexDataInputConnectorDTO();
		
		GenericConnectorDTO genericDTO = new GenericConnectorDTO();
		genericDTO.setFunctionModuleName("Z_YOTCCM_COMP_CONTR_IDNT_VALD");
		genericDTO.setSessionID("bhanuibmCSO2010051114377");
		genericDTO.setUserID("bhanuibmCSO");
		dto.setIGenericConnectorDTO(genericDTO);
		
		OrgConnectorDTO orgConnectorDTO = new OrgConnectorDTO();
		orgConnectorDTO.setSalesOrg("0147");
		orgConnectorDTO.setDivision("00");
		orgConnectorDTO.setDistributionChannel("A");
		dto.setIOrgConnectorDTO(orgConnectorDTO);
		
		dto.setICpsID("cpsid");
		//dto.setIComplexContractAmendment("complexContractAmendment");
		//dto.setIMasterContractID("mastercid");
		//dto.setIMasterContractAmendment("masterComtractAmendment");
		//dto.setIBLBIndicator("blbIndicator");
		dto.setIContractStartDate(Date.valueOf("2009-01-01"));
		dto.setIContractEndDate(Date.valueOf("2009-12-12"));			
		
		System.out.println("Z_YOTCCM_COMP_CONTR_IDNT_VALD -- OBJECT 2 STRING \n*****************\n");
		System.out.println(converter.createMsgString(dto));
		System.out.println("*************************ashok************************");
		//String msg = "0|00027|2008310043|000010|000020||";
		String msg = "0|4|01|0000011|0|Success|cctype|mctype|";
		
		ValidateComplexDataOutputConnectorDTO outputDto = (ValidateComplexDataOutputConnectorDTO)converter.parseMsgString(msg);
		System.out.println("Test TK "+ outputDto);
		System.out.println("\nZ_YOTCCM_COMP_CONTR_IDNT_VALD\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ outputDto.getReturnCode()+ "\n");
		System.out.println("SAP Return Code: "+ outputDto.getSapReturnCode()+"\n");
		System.out.println("Exception Code: "+ outputDto.getExeptionCode()+"\n");
		System.out.println("Error Message: "+ outputDto.getErrorMessage()+"\n");
		System.out.println("OCPS ID: "+ outputDto.getOcpsID()+"\n");
		System.out.println("Contract Type: "+ outputDto.getContractType()+"\n");	
		
	}
	
	public void printValidateInvenConfigOutputConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		ValidateInvenConfigOutputConnectorDTO dto = (ValidateInvenConfigOutputConnectorDTO)connectorDTO;
		System.out.println("\n\n\nSTRING 2 OBJECT \n****************\nReturn Code: "+ dto.getReturnCode()+ "\n");
		
		List list = dto.getValidateInvenConfigConnectorDTOList();
		Iterator iter = list.iterator();
		
		while (iter.hasNext())
		{
			printValidateInvenConfigConnectorDTO((ValidateInvenConfigConnectorDTO)iter.next());
		}
	}
	
	public void printValidateInvenConfigConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		ValidateInvenConfigConnectorDTO dto = (ValidateInvenConfigConnectorDTO)connectorDTO;
		System.out.println("\r\n");
		System.out.println("SapSalesDocNo: " + dto.getSapSalesDocNo());
		System.out.println("SapEEItemNo: " + dto.getSapEEItemNo());
		System.out.println("SapSWOItemNo: " + dto.getSapSWOItemNo());
		System.out.println("SapValidIndicator: " + dto.getSapValidIndicator() + "\r\n");
	}
	
	public static void main(String[] args) throws Exception
	{
		TestConnectorDTOs test = new TestConnectorDTOs();
//		test.testOneObject2String();
//		test.testTwoObject2String();
//		test.validateHeaderO2String();
//		test.retrieveCustomerListO2String();
//		test.partnerCheckO2String();
//		test.retrievePartnerO2String();
//
//		test.retrieveDetailO2String();
//		test.retrieveInvetoryDeltaO2String();
//		test.retrieveDeltaO2String();
//		test.useridMaintInputO2String();
//		test.retrieveUserAuthO2String();
//		test.validateBPAccessOPPTO2String();
//		test.validateUserAccessOPPTO2String();
//		test.createVarianceReportO2String();
//		test.checkVarianceO2String();
//		test.createContractO2String();
//		test.changeContractO2String();
//		test.compareAuthorO2String();
//		test.retrievePaymentTermsO2String();
//		test.retrieveDateRulesO2String();
//		test.refreshCurrencyO2String();
//		test.retrieveBillBlockO2String();
//		test.refreshSalesAreaO2String();
//		test.refreshVarianceO2String();
//		test.statusCheckO2String();
//		test.dmConfigS2Object();
		test.validateConfigS2Object();
		test.validateComplexData();
	}
}
