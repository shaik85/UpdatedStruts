package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * ProposalBeanFunctionSet_8ef9b9cc
 */
public class ProposalBeanFunctionSet_8ef9b9cc extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.PROPOSAL (PROPOSAL_ID, ADD_VALUE_DAYS, ADVANCE_BILLING, AMDT_IND, AMDT_EFFC_DATE, APPROVED_BY, PROPOSAL_TYPE, BILLING_FREQ_CODE, CREATED_BY, STATUS_CODE, SALES_ORG, DSTR_CHANNEL, DIVISION_CODE, PROPOSAL_NAME, CNTR_START_DATE, CNTR_END_DATE, CNTR_START_PERIOD, CNTR_END_PERIOD, TVM_RATE, GROWTH_FACTOR, SPECIAL_RATE, INVOICE_AMOUNT, DATE_PRICED, COMMENTS, CREATED_DATE, APPROVED_DATE, DELETED_IND, REG_SOLD_TO_P_NO, REG_SOLD_TO_P_NAME, REG_BILL_TO_P_NO, REG_BILL_TO_P_NAME, REG_PAYER_NO, REG_PAYER_NAME, REG_SHIP_TO_P_NO, REG_SHIP_TO_P_NAME, CURRENCY, LAST_UPDATE_DATE, RE_FETCH_ID, FETCH_DATE, DELTA_FETCH_ID, CNTR_TYPE, REPORT_NAME, CAP_AMOUNT, CAP_PLUS, CAP_MINUS, PRE_TVM, CNTR_EXTN_DATE, CNTR_RETR_DATE, CNTR_REPL_DATE, CNTR_CLS_DATE, CNTR_NUMBER, CNTR_AMDT_NO, REG_SOLD_TO_P_LNO, REG_BILL_TO_P_LNO, REG_PAYER_LNO, REG_SHIP_TO_P_LNO, INVOICE_AMOUNT_SEM, INVOICE_AMOUNT_ANN, INVOICE_AMOUNT_MON, INVOICE_AMOUNT_QRT, OLD_CNTR_NUMBER, PRE_TVM_INV_AMT, PROPOSAL_SHARING, EXT_CNTR_NUMBER, CNTR_CREATE_FLAG, PAK_ID, BILLING_TYPE, PAYMENT_TERM, FIXED_VAL_DATE, TP_CNTR_NUMBER, INELIGIBLE_IND, INVOICE_IND, AUTOPOPULATE_IND, CCI_IND, PREBILL_INDICATOR, BLB_INDICATOR, CONTRACT_TYPE, OCPS, CPS, S_S_DISCOUNT_AMOUNT5, S_S_DISCOUNT_AMOUNT4, S_S_DISCOUNT_AMOUNT3, S_S_DISCOUNT_AMOUNT2, S_S_DISCOUNT_AMOUNT1, S_S_ANNV_AMOUNT5, S_S_ANNV_AMOUNT4, S_S_ANNV_AMOUNT3, S_S_ANNV_AMOUNT2, S_S_EXTEND_CNTR_IND, GROUP_NAME, SUBMITTED_BY, PROPOSAL_CONTENT, S_S_DISCOUNT_SUM, S_S_ANNV_AMOUNT, REG_9D_PARTNER_NO, REG_9D_PARTNER_NAME, CUM_VALUE, CAP_VARIANCE, ORG_VAR_CNTR_NUMBER, VAR_DATE, VAR_IND, REG_SOLD_TO_P_ASNO, REG_BILL_TO_P_ASNO, REG_PAYER_ASNO, REG_SHIP_TO_P_ASNO, SUPPRESS_INVOICE, ESW_FETCH_DATE, ESW_FETCH_TIME, GSA_IND, FREE_TEXT, LOCKED_BY, LOCKED_ON, PO_NUMBER, PO_DATE, ANNV_AMOUNT, CNTR_NEWRENEW_NO, BILLING_BLOCK, CNTR_PERIOD_VAR_NO, CNTR_VAR_NO, DEVIATING_DATE_RULE, S_S_EXCLUDED, CNTR_REPL_NO, FIN_CNTR_NO, SALES_GROUP, CHANNEL_ROLE, SUBMITTER_ROLE, PAYMENTMETHOD, DISCOUNT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column ADD_VALUE_DAYS
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column ADVANCE_BILLING
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column AMDT_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column AMDT_EFFC_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column APPROVED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column BILLING_FREQ_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column CREATED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.VARCHAR);
			}
			// For column STATUS_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column SALES_ORG
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column DSTR_CHANNEL
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			// For column DIVISION_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column PROPOSAL_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column CNTR_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(14);
				if(tempDate != null)
					pstmt.setDate(15,tempDate);
				else
					pstmt.setNull(15,java.sql.Types.DATE);
			}
			// For column CNTR_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(15);
				if(tempDate != null)
					pstmt.setDate(16,tempDate);
				else
					pstmt.setNull(16,java.sql.Types.DATE);
			}
			// For column CNTR_START_PERIOD
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(16);
				if(tempDate != null)
					pstmt.setDate(17,tempDate);
				else
					pstmt.setNull(17,java.sql.Types.DATE);
			}
			// For column CNTR_END_PERIOD
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(17);
				if(tempDate != null)
					pstmt.setDate(18,tempDate);
				else
					pstmt.setNull(18,java.sql.Types.DATE);
			}
			// For column TVM_RATE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(18);
				if(tempDouble != null)
					pstmt.setDouble(19,tempDouble.doubleValue());
				else
					pstmt.setNull(19,java.sql.Types.DECIMAL);
			}
			// For column GROWTH_FACTOR
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(19);
				if(tempDouble != null)
					pstmt.setDouble(20,tempDouble.doubleValue());
				else
					pstmt.setNull(20,java.sql.Types.DECIMAL);
			}
			// For column SPECIAL_RATE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(20);
				if(tempDouble != null)
					pstmt.setDouble(21,tempDouble.doubleValue());
				else
					pstmt.setNull(21,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(21);
				if(tempDouble != null)
					pstmt.setDouble(22,tempDouble.doubleValue());
				else
					pstmt.setNull(22,java.sql.Types.DECIMAL);
			}
			// For column DATE_PRICED
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(22);
				if(tempDate != null)
					pstmt.setDate(23,tempDate);
				else
					pstmt.setNull(23,java.sql.Types.DATE);
			}
			// For column COMMENTS
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(24,tempString);
				else
					pstmt.setNull(24,java.sql.Types.VARCHAR);
			}
			// For column CREATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(24);
				if(tempDate != null)
					pstmt.setDate(25,tempDate);
				else
					pstmt.setNull(25,java.sql.Types.DATE);
			}
			// For column APPROVED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(25);
				if(tempDate != null)
					pstmt.setDate(26,tempDate);
				else
					pstmt.setNull(26,java.sql.Types.DATE);
			}
			// For column DELETED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.CHAR);
			}
			// For column REG_SOLD_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(27);
				if(tempString != null)
					pstmt.setString(28,tempString);
				else
					pstmt.setNull(28,java.sql.Types.CHAR);
			}
			// For column REG_SOLD_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(28);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(29);
				if(tempString != null)
					pstmt.setString(30,tempString);
				else
					pstmt.setNull(30,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(30);
				if(tempString != null)
					pstmt.setString(31,tempString);
				else
					pstmt.setNull(31,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(31);
				if(tempString != null)
					pstmt.setString(32,tempString);
				else
					pstmt.setNull(32,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(33);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(34);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.CHAR);
			}
			// For column CURRENCY
			{
				String tempString;


				tempString=(String)inputRecord.get(35);
				if(tempString != null)
					pstmt.setString(36,tempString);
				else
					pstmt.setNull(36,java.sql.Types.CHAR);
			}
			// For column LAST_UPDATE_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(36);
				if(tempDate != null)
					pstmt.setDate(37,tempDate);
				else
					pstmt.setNull(37,java.sql.Types.DATE);
			}
			// For column RE_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(37);
				if(tempString != null)
					pstmt.setString(38,tempString);
				else
					pstmt.setNull(38,java.sql.Types.CHAR);
			}
			// For column FETCH_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(38);
				if(tempDate != null)
					pstmt.setDate(39,tempDate);
				else
					pstmt.setNull(39,java.sql.Types.DATE);
			}
			// For column DELTA_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(39);
				if(tempString != null)
					pstmt.setString(40,tempString);
				else
					pstmt.setNull(40,java.sql.Types.CHAR);
			}
			// For column CNTR_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(40);
				if(tempString != null)
					pstmt.setString(41,tempString);
				else
					pstmt.setNull(41,java.sql.Types.CHAR);
			}
			// For column REPORT_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(41);
				if(tempString != null)
					pstmt.setString(42,tempString);
				else
					pstmt.setNull(42,java.sql.Types.CHAR);
			}
			// For column CAP_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(42);
				if(tempDouble != null)
					pstmt.setDouble(43,tempDouble.doubleValue());
				else
					pstmt.setNull(43,java.sql.Types.DECIMAL);
			}
			// For column CAP_PLUS
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(43);
				if(tempDouble != null)
					pstmt.setDouble(44,tempDouble.doubleValue());
				else
					pstmt.setNull(44,java.sql.Types.DECIMAL);
			}
			// For column CAP_MINUS
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(44);
				if(tempDouble != null)
					pstmt.setDouble(45,tempDouble.doubleValue());
				else
					pstmt.setNull(45,java.sql.Types.DECIMAL);
			}
			// For column PRE_TVM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(45);
				if(tempDouble != null)
					pstmt.setDouble(46,tempDouble.doubleValue());
				else
					pstmt.setNull(46,java.sql.Types.DECIMAL);
			}
			// For column CNTR_EXTN_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(46);
				if(tempDate != null)
					pstmt.setDate(47,tempDate);
				else
					pstmt.setNull(47,java.sql.Types.DATE);
			}
			// For column CNTR_RETR_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(47);
				if(tempDate != null)
					pstmt.setDate(48,tempDate);
				else
					pstmt.setNull(48,java.sql.Types.DATE);
			}
			// For column CNTR_REPL_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(48);
				if(tempDate != null)
					pstmt.setDate(49,tempDate);
				else
					pstmt.setNull(49,java.sql.Types.DATE);
			}
			// For column CNTR_CLS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(49);
				if(tempDate != null)
					pstmt.setDate(50,tempDate);
				else
					pstmt.setNull(50,java.sql.Types.DATE);
			}
			// For column CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(50);
				if(tempString != null)
					pstmt.setString(51,tempString);
				else
					pstmt.setNull(51,java.sql.Types.CHAR);
			}
			// For column CNTR_AMDT_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(51);
				if(tempDouble != null)
					pstmt.setDouble(52,tempDouble.doubleValue());
				else
					pstmt.setNull(52,java.sql.Types.DECIMAL);
			}
			// For column REG_SOLD_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(52);
				if(tempString != null)
					pstmt.setString(53,tempString);
				else
					pstmt.setNull(53,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(53);
				if(tempString != null)
					pstmt.setString(54,tempString);
				else
					pstmt.setNull(54,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(54);
				if(tempString != null)
					pstmt.setString(55,tempString);
				else
					pstmt.setNull(55,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(55);
				if(tempString != null)
					pstmt.setString(56,tempString);
				else
					pstmt.setNull(56,java.sql.Types.CHAR);
			}
			// For column INVOICE_AMOUNT_SEM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(56);
				if(tempDouble != null)
					pstmt.setDouble(57,tempDouble.doubleValue());
				else
					pstmt.setNull(57,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_ANN
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(57);
				if(tempDouble != null)
					pstmt.setDouble(58,tempDouble.doubleValue());
				else
					pstmt.setNull(58,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_MON
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(58);
				if(tempDouble != null)
					pstmt.setDouble(59,tempDouble.doubleValue());
				else
					pstmt.setNull(59,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_QRT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(59);
				if(tempDouble != null)
					pstmt.setDouble(60,tempDouble.doubleValue());
				else
					pstmt.setNull(60,java.sql.Types.DECIMAL);
			}
			// For column OLD_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(60);
				if(tempString != null)
					pstmt.setString(61,tempString);
				else
					pstmt.setNull(61,java.sql.Types.CHAR);
			}
			// For column PRE_TVM_INV_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(61);
				if(tempDouble != null)
					pstmt.setDouble(62,tempDouble.doubleValue());
				else
					pstmt.setNull(62,java.sql.Types.DECIMAL);
			}
			// For column PROPOSAL_SHARING
			{
				String tempString;


				tempString=(String)inputRecord.get(62);
				if(tempString != null)
					pstmt.setString(63,tempString);
				else
					pstmt.setNull(63,java.sql.Types.CHAR);
			}
			// For column EXT_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(63);
				if(tempString != null)
					pstmt.setString(64,tempString);
				else
					pstmt.setNull(64,java.sql.Types.CHAR);
			}
			// For column CNTR_CREATE_FLAG
			{
				String tempString;


				tempString=(String)inputRecord.get(64);
				if(tempString != null)
					pstmt.setString(65,tempString);
				else
					pstmt.setNull(65,java.sql.Types.CHAR);
			}
			// For column PAK_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(65);
				if(tempString != null)
					pstmt.setString(66,tempString);
				else
					pstmt.setNull(66,java.sql.Types.CHAR);
			}
			// For column BILLING_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(66);
				if(tempString != null)
					pstmt.setString(67,tempString);
				else
					pstmt.setNull(67,java.sql.Types.CHAR);
			}
			// For column PAYMENT_TERM
			{
				String tempString;


				tempString=(String)inputRecord.get(67);
				if(tempString != null)
					pstmt.setString(68,tempString);
				else
					pstmt.setNull(68,java.sql.Types.CHAR);
			}
			// For column FIXED_VAL_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(68);
				if(tempDate != null)
					pstmt.setDate(69,tempDate);
				else
					pstmt.setNull(69,java.sql.Types.DATE);
			}
			// For column TP_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(69);
				if(tempString != null)
					pstmt.setString(70,tempString);
				else
					pstmt.setNull(70,java.sql.Types.CHAR);
			}
			// For column INELIGIBLE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(70);
				if(tempString != null)
					pstmt.setString(71,tempString);
				else
					pstmt.setNull(71,java.sql.Types.CHAR);
			}
			// For column INVOICE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(71);
				if(tempString != null)
					pstmt.setString(72,tempString);
				else
					pstmt.setNull(72,java.sql.Types.CHAR);
			}
			// For column AUTOPOPULATE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(72);
				if(tempString != null)
					pstmt.setString(73,tempString);
				else
					pstmt.setNull(73,java.sql.Types.CHAR);
			}
			// For column CCI_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(73);
				if(tempString != null)
					pstmt.setString(74,tempString);
				else
					pstmt.setNull(74,java.sql.Types.CHAR);
			}
			// For column PREBILL_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(74);
				if(tempString != null)
					pstmt.setString(75,tempString);
				else
					pstmt.setNull(75,java.sql.Types.CHAR);
			}
			// For column BLB_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(75);
				if(tempString != null)
					pstmt.setString(76,tempString);
				else
					pstmt.setNull(76,java.sql.Types.CHAR);
			}
			// For column CONTRACT_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(76);
				if(tempString != null)
					pstmt.setString(77,tempString);
				else
					pstmt.setNull(77,java.sql.Types.CHAR);
			}
			// For column OCPS
			{
				String tempString;


				tempString=(String)inputRecord.get(77);
				if(tempString != null)
					pstmt.setString(78,tempString);
				else
					pstmt.setNull(78,java.sql.Types.CHAR);
			}
			// For column CPS
			{
				String tempString;


				tempString=(String)inputRecord.get(78);
				if(tempString != null)
					pstmt.setString(79,tempString);
				else
					pstmt.setNull(79,java.sql.Types.CHAR);
			}
			// For column S_S_DISCOUNT_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(79);
				if(tempDouble != null)
					pstmt.setDouble(80,tempDouble.doubleValue());
				else
					pstmt.setNull(80,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(80);
				if(tempDouble != null)
					pstmt.setDouble(81,tempDouble.doubleValue());
				else
					pstmt.setNull(81,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(81);
				if(tempDouble != null)
					pstmt.setDouble(82,tempDouble.doubleValue());
				else
					pstmt.setNull(82,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(82);
				if(tempDouble != null)
					pstmt.setDouble(83,tempDouble.doubleValue());
				else
					pstmt.setNull(83,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT1
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(83);
				if(tempDouble != null)
					pstmt.setDouble(84,tempDouble.doubleValue());
				else
					pstmt.setNull(84,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(84);
				if(tempDouble != null)
					pstmt.setDouble(85,tempDouble.doubleValue());
				else
					pstmt.setNull(85,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(85);
				if(tempDouble != null)
					pstmt.setDouble(86,tempDouble.doubleValue());
				else
					pstmt.setNull(86,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(86);
				if(tempDouble != null)
					pstmt.setDouble(87,tempDouble.doubleValue());
				else
					pstmt.setNull(87,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(87);
				if(tempDouble != null)
					pstmt.setDouble(88,tempDouble.doubleValue());
				else
					pstmt.setNull(88,java.sql.Types.DECIMAL);
			}
			// For column S_S_EXTEND_CNTR_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(88);
				if(tempString != null)
					pstmt.setString(89,tempString);
				else
					pstmt.setNull(89,java.sql.Types.CHAR);
			}
			// For column GROUP_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(89);
				if(tempString != null)
					pstmt.setString(90,tempString);
				else
					pstmt.setNull(90,java.sql.Types.CHAR);
			}
			// For column SUBMITTED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(90);
				if(tempString != null)
					pstmt.setString(91,tempString);
				else
					pstmt.setNull(91,java.sql.Types.VARCHAR);
			}
			// For column PROPOSAL_CONTENT
			{
				String tempString;


				tempString=(String)inputRecord.get(91);
				if(tempString != null)
					pstmt.setString(92,tempString);
				else
					pstmt.setNull(92,java.sql.Types.CHAR);
			}
			// For column S_S_DISCOUNT_SUM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(92);
				if(tempDouble != null)
					pstmt.setDouble(93,tempDouble.doubleValue());
				else
					pstmt.setNull(93,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(93);
				if(tempDouble != null)
					pstmt.setDouble(94,tempDouble.doubleValue());
				else
					pstmt.setNull(94,java.sql.Types.DECIMAL);
			}
			// For column REG_9D_PARTNER_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(94);
				if(tempString != null)
					pstmt.setString(95,tempString);
				else
					pstmt.setNull(95,java.sql.Types.CHAR);
			}
			// For column REG_9D_PARTNER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(95);
				if(tempString != null)
					pstmt.setString(96,tempString);
				else
					pstmt.setNull(96,java.sql.Types.CHAR);
			}
			// For column CUM_VALUE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(96);
				if(tempDouble != null)
					pstmt.setDouble(97,tempDouble.doubleValue());
				else
					pstmt.setNull(97,java.sql.Types.DECIMAL);
			}
			// For column CAP_VARIANCE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(97);
				if(tempDouble != null)
					pstmt.setDouble(98,tempDouble.doubleValue());
				else
					pstmt.setNull(98,java.sql.Types.DECIMAL);
			}
			// For column ORG_VAR_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(98);
				if(tempString != null)
					pstmt.setString(99,tempString);
				else
					pstmt.setNull(99,java.sql.Types.CHAR);
			}
			// For column VAR_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(99);
				if(tempDate != null)
					pstmt.setDate(100,tempDate);
				else
					pstmt.setNull(100,java.sql.Types.DATE);
			}
			// For column VAR_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(100);
				if(tempString != null)
					pstmt.setString(101,tempString);
				else
					pstmt.setNull(101,java.sql.Types.CHAR);
			}
			// For column REG_SOLD_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(101);
				if(tempString != null)
					pstmt.setString(102,tempString);
				else
					pstmt.setNull(102,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(102);
				if(tempString != null)
					pstmt.setString(103,tempString);
				else
					pstmt.setNull(103,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(103);
				if(tempString != null)
					pstmt.setString(104,tempString);
				else
					pstmt.setNull(104,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(104);
				if(tempString != null)
					pstmt.setString(105,tempString);
				else
					pstmt.setNull(105,java.sql.Types.CHAR);
			}
			// For column SUPPRESS_INVOICE
			{
				String tempString;


				tempString=(String)inputRecord.get(105);
				if(tempString != null)
					pstmt.setString(106,tempString);
				else
					pstmt.setNull(106,java.sql.Types.CHAR);
			}
			// For column ESW_FETCH_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(106);
				if(tempDate != null)
					pstmt.setDate(107,tempDate);
				else
					pstmt.setNull(107,java.sql.Types.DATE);
			}
			// For column ESW_FETCH_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(107);
				if(tempTime != null)
					pstmt.setTime(108,tempTime);
				else
					pstmt.setNull(108,java.sql.Types.TIME);
			}
			// For column GSA_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(108);
				if(tempString != null)
					pstmt.setString(109,tempString);
				else
					pstmt.setNull(109,java.sql.Types.CHAR);
			}
			// For column FREE_TEXT
			{
				String tempString;


				tempString=(String)inputRecord.get(109);
				if(tempString != null)
					pstmt.setString(110,tempString);
				else
					pstmt.setNull(110,java.sql.Types.VARCHAR);
			}
			// For column LOCKED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(110);
				if(tempString != null)
					pstmt.setString(111,tempString);
				else
					pstmt.setNull(111,java.sql.Types.VARCHAR);
			}
			// For column LOCKED_ON
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(111);
				if(tempDate != null)
					pstmt.setDate(112,tempDate);
				else
					pstmt.setNull(112,java.sql.Types.DATE);
			}
			// For column PO_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(112);
				if(tempString != null)
					pstmt.setString(113,tempString);
				else
					pstmt.setNull(113,java.sql.Types.CHAR);
			}
			// For column PO_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(113);
				if(tempDate != null)
					pstmt.setDate(114,tempDate);
				else
					pstmt.setNull(114,java.sql.Types.DATE);
			}
			// For column ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(114);
				if(tempDouble != null)
					pstmt.setDouble(115,tempDouble.doubleValue());
				else
					pstmt.setNull(115,java.sql.Types.DECIMAL);
			}
			// For column CNTR_NEWRENEW_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(115);
				if(tempInteger != null)
					pstmt.setInt(116,tempInteger.intValue());
				else
					pstmt.setNull(116,java.sql.Types.DECIMAL);
			}
			// For column BILLING_BLOCK
			{
				String tempString;


				tempString=(String)inputRecord.get(116);
				if(tempString != null)
					pstmt.setString(117,tempString);
				else
					pstmt.setNull(117,java.sql.Types.CHAR);
			}
			// For column CNTR_PERIOD_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(117);
				if(tempInteger != null)
					pstmt.setInt(118,tempInteger.intValue());
				else
					pstmt.setNull(118,java.sql.Types.INTEGER);
			}
			// For column CNTR_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(118);
				if(tempInteger != null)
					pstmt.setInt(119,tempInteger.intValue());
				else
					pstmt.setNull(119,java.sql.Types.INTEGER);
			}
			// For column DEVIATING_DATE_RULE
			{
				String tempString;


				tempString=(String)inputRecord.get(119);
				if(tempString != null)
					pstmt.setString(120,tempString);
				else
					pstmt.setNull(120,java.sql.Types.CHAR);
			}
			// For column S_S_EXCLUDED
			{
				String tempString;


				tempString=(String)inputRecord.get(120);
				if(tempString != null)
					pstmt.setString(121,tempString);
				else
					pstmt.setNull(121,java.sql.Types.CHAR);
			}
			// For column CNTR_REPL_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(121);
				if(tempInteger != null)
					pstmt.setInt(122,tempInteger.intValue());
				else
					pstmt.setNull(122,java.sql.Types.DECIMAL);
			}
			// For column FIN_CNTR_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(122);
				if(tempString != null)
					pstmt.setString(123,tempString);
				else
					pstmt.setNull(123,java.sql.Types.CHAR);
			}
			// For column SALES_GROUP
			{
				String tempString;


				tempString=(String)inputRecord.get(123);
				if(tempString != null)
					pstmt.setString(124,tempString);
				else
					pstmt.setNull(124,java.sql.Types.CHAR);
			}
			// For column CHANNEL_ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(124);
				if(tempString != null)
					pstmt.setString(125,tempString);
				else
					pstmt.setNull(125,java.sql.Types.CHAR);
			}
			// For column SUBMITTER_ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(125);
				if(tempString != null)
					pstmt.setString(126,tempString);
				else
					pstmt.setNull(126,java.sql.Types.CHAR);
			}
			// For column PAYMENTMETHOD
			{
				String tempString;


				tempString=(String)inputRecord.get(126);
				if(tempString != null)
					pstmt.setString(127,tempString);
				else
					pstmt.setNull(127,java.sql.Types.CHAR);
			}
			// For column DISCOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(127);
				if(tempDouble != null)
					pstmt.setDouble(128,tempDouble.doubleValue());
				else
					pstmt.setNull(128,java.sql.Types.DECIMAL);
			}
			if (executeUpdate(connection, pstmt, CreateQuery_0)==0)
				throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String RemoveQuery_0 = "DELETE FROM BH.PROPOSAL  WHERE PROPOSAL_ID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			if (executeUpdate(connection, pstmt, RemoveQuery_0)==0)
				throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String StoreQuery_0 = "UPDATE BH.PROPOSAL  SET ADD_VALUE_DAYS = ?, ADVANCE_BILLING = ?, AMDT_IND = ?, AMDT_EFFC_DATE = ?, APPROVED_BY = ?, PROPOSAL_TYPE = ?, BILLING_FREQ_CODE = ?, CREATED_BY = ?, STATUS_CODE = ?, SALES_ORG = ?, DSTR_CHANNEL = ?, DIVISION_CODE = ?, PROPOSAL_NAME = ?, CNTR_START_DATE = ?, CNTR_END_DATE = ?, CNTR_START_PERIOD = ?, CNTR_END_PERIOD = ?, TVM_RATE = ?, GROWTH_FACTOR = ?, SPECIAL_RATE = ?, INVOICE_AMOUNT = ?, DATE_PRICED = ?, COMMENTS = ?, CREATED_DATE = ?, APPROVED_DATE = ?, DELETED_IND = ?, REG_SOLD_TO_P_NO = ?, REG_SOLD_TO_P_NAME = ?, REG_BILL_TO_P_NO = ?, REG_BILL_TO_P_NAME = ?, REG_PAYER_NO = ?, REG_PAYER_NAME = ?, REG_SHIP_TO_P_NO = ?, REG_SHIP_TO_P_NAME = ?, CURRENCY = ?, LAST_UPDATE_DATE = ?, RE_FETCH_ID = ?, FETCH_DATE = ?, DELTA_FETCH_ID = ?, CNTR_TYPE = ?, REPORT_NAME = ?, CAP_AMOUNT = ?, CAP_PLUS = ?, CAP_MINUS = ?, PRE_TVM = ?, CNTR_EXTN_DATE = ?, CNTR_RETR_DATE = ?, CNTR_REPL_DATE = ?, CNTR_CLS_DATE = ?, CNTR_NUMBER = ?, CNTR_AMDT_NO = ?, REG_SOLD_TO_P_LNO = ?, REG_BILL_TO_P_LNO = ?, REG_PAYER_LNO = ?, REG_SHIP_TO_P_LNO = ?, INVOICE_AMOUNT_SEM = ?, INVOICE_AMOUNT_ANN = ?, INVOICE_AMOUNT_MON = ?, INVOICE_AMOUNT_QRT = ?, OLD_CNTR_NUMBER = ?, PRE_TVM_INV_AMT = ?, PROPOSAL_SHARING = ?, EXT_CNTR_NUMBER = ?, CNTR_CREATE_FLAG = ?, PAK_ID = ?, BILLING_TYPE = ?, PAYMENT_TERM = ?, FIXED_VAL_DATE = ?, TP_CNTR_NUMBER = ?, INELIGIBLE_IND = ?, INVOICE_IND = ?, AUTOPOPULATE_IND = ?, CCI_IND = ?, PREBILL_INDICATOR = ?, BLB_INDICATOR = ?, CONTRACT_TYPE = ?, OCPS = ?, CPS = ?, S_S_DISCOUNT_AMOUNT5 = ?, S_S_DISCOUNT_AMOUNT4 = ?, S_S_DISCOUNT_AMOUNT3 = ?, S_S_DISCOUNT_AMOUNT2 = ?, S_S_DISCOUNT_AMOUNT1 = ?, S_S_ANNV_AMOUNT5 = ?, S_S_ANNV_AMOUNT4 = ?, S_S_ANNV_AMOUNT3 = ?, S_S_ANNV_AMOUNT2 = ?, S_S_EXTEND_CNTR_IND = ?, GROUP_NAME = ?, SUBMITTED_BY = ?, PROPOSAL_CONTENT = ?, S_S_DISCOUNT_SUM = ?, S_S_ANNV_AMOUNT = ?, REG_9D_PARTNER_NO = ?, REG_9D_PARTNER_NAME = ?, CUM_VALUE = ?, CAP_VARIANCE = ?, ORG_VAR_CNTR_NUMBER = ?, VAR_DATE = ?, VAR_IND = ?, REG_SOLD_TO_P_ASNO = ?, REG_BILL_TO_P_ASNO = ?, REG_PAYER_ASNO = ?, REG_SHIP_TO_P_ASNO = ?, SUPPRESS_INVOICE = ?, ESW_FETCH_DATE = ?, ESW_FETCH_TIME = ?, GSA_IND = ?, FREE_TEXT = ?, LOCKED_BY = ?, LOCKED_ON = ?, PO_NUMBER = ?, PO_DATE = ?, ANNV_AMOUNT = ?, CNTR_NEWRENEW_NO = ?, BILLING_BLOCK = ?, CNTR_PERIOD_VAR_NO = ?, CNTR_VAR_NO = ?, DEVIATING_DATE_RULE = ?, S_S_EXCLUDED = ?, CNTR_REPL_NO = ?, FIN_CNTR_NO = ?, SALES_GROUP = ?, CHANNEL_ROLE = ?, SUBMITTER_ROLE = ?, PAYMENTMETHOD = ?, DISCOUNT = ? WHERE PROPOSAL_ID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column ADD_VALUE_DAYS
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column ADVANCE_BILLING
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column AMDT_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column AMDT_EFFC_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column APPROVED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(128,tempInteger.intValue());
				else
					pstmt.setNull(128,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column BILLING_FREQ_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column CREATED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column STATUS_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column SALES_ORG
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column DSTR_CHANNEL
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column DIVISION_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			// For column PROPOSAL_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column CNTR_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(14);
				if(tempDate != null)
					pstmt.setDate(14,tempDate);
				else
					pstmt.setNull(14,java.sql.Types.DATE);
			}
			// For column CNTR_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(15);
				if(tempDate != null)
					pstmt.setDate(15,tempDate);
				else
					pstmt.setNull(15,java.sql.Types.DATE);
			}
			// For column CNTR_START_PERIOD
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(16);
				if(tempDate != null)
					pstmt.setDate(16,tempDate);
				else
					pstmt.setNull(16,java.sql.Types.DATE);
			}
			// For column CNTR_END_PERIOD
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(17);
				if(tempDate != null)
					pstmt.setDate(17,tempDate);
				else
					pstmt.setNull(17,java.sql.Types.DATE);
			}
			// For column TVM_RATE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(18);
				if(tempDouble != null)
					pstmt.setDouble(18,tempDouble.doubleValue());
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column GROWTH_FACTOR
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(19);
				if(tempDouble != null)
					pstmt.setDouble(19,tempDouble.doubleValue());
				else
					pstmt.setNull(19,java.sql.Types.DECIMAL);
			}
			// For column SPECIAL_RATE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(20);
				if(tempDouble != null)
					pstmt.setDouble(20,tempDouble.doubleValue());
				else
					pstmt.setNull(20,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(21);
				if(tempDouble != null)
					pstmt.setDouble(21,tempDouble.doubleValue());
				else
					pstmt.setNull(21,java.sql.Types.DECIMAL);
			}
			// For column DATE_PRICED
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(22);
				if(tempDate != null)
					pstmt.setDate(22,tempDate);
				else
					pstmt.setNull(22,java.sql.Types.DATE);
			}
			// For column COMMENTS
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(23,tempString);
				else
					pstmt.setNull(23,java.sql.Types.VARCHAR);
			}
			// For column CREATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(24);
				if(tempDate != null)
					pstmt.setDate(24,tempDate);
				else
					pstmt.setNull(24,java.sql.Types.DATE);
			}
			// For column APPROVED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(25);
				if(tempDate != null)
					pstmt.setDate(25,tempDate);
				else
					pstmt.setNull(25,java.sql.Types.DATE);
			}
			// For column DELETED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(26,tempString);
				else
					pstmt.setNull(26,java.sql.Types.CHAR);
			}
			// For column REG_SOLD_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(27);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.CHAR);
			}
			// For column REG_SOLD_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(28);
				if(tempString != null)
					pstmt.setString(28,tempString);
				else
					pstmt.setNull(28,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(29);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(30);
				if(tempString != null)
					pstmt.setString(30,tempString);
				else
					pstmt.setNull(30,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(31);
				if(tempString != null)
					pstmt.setString(31,tempString);
				else
					pstmt.setNull(31,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(32,tempString);
				else
					pstmt.setNull(32,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(33);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(34);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.CHAR);
			}
			// For column CURRENCY
			{
				String tempString;


				tempString=(String)inputRecord.get(35);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.CHAR);
			}
			// For column LAST_UPDATE_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(36);
				if(tempDate != null)
					pstmt.setDate(36,tempDate);
				else
					pstmt.setNull(36,java.sql.Types.DATE);
			}
			// For column RE_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(37);
				if(tempString != null)
					pstmt.setString(37,tempString);
				else
					pstmt.setNull(37,java.sql.Types.CHAR);
			}
			// For column FETCH_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(38);
				if(tempDate != null)
					pstmt.setDate(38,tempDate);
				else
					pstmt.setNull(38,java.sql.Types.DATE);
			}
			// For column DELTA_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(39);
				if(tempString != null)
					pstmt.setString(39,tempString);
				else
					pstmt.setNull(39,java.sql.Types.CHAR);
			}
			// For column CNTR_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(40);
				if(tempString != null)
					pstmt.setString(40,tempString);
				else
					pstmt.setNull(40,java.sql.Types.CHAR);
			}
			// For column REPORT_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(41);
				if(tempString != null)
					pstmt.setString(41,tempString);
				else
					pstmt.setNull(41,java.sql.Types.CHAR);
			}
			// For column CAP_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(42);
				if(tempDouble != null)
					pstmt.setDouble(42,tempDouble.doubleValue());
				else
					pstmt.setNull(42,java.sql.Types.DECIMAL);
			}
			// For column CAP_PLUS
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(43);
				if(tempDouble != null)
					pstmt.setDouble(43,tempDouble.doubleValue());
				else
					pstmt.setNull(43,java.sql.Types.DECIMAL);
			}
			// For column CAP_MINUS
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(44);
				if(tempDouble != null)
					pstmt.setDouble(44,tempDouble.doubleValue());
				else
					pstmt.setNull(44,java.sql.Types.DECIMAL);
			}
			// For column PRE_TVM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(45);
				if(tempDouble != null)
					pstmt.setDouble(45,tempDouble.doubleValue());
				else
					pstmt.setNull(45,java.sql.Types.DECIMAL);
			}
			// For column CNTR_EXTN_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(46);
				if(tempDate != null)
					pstmt.setDate(46,tempDate);
				else
					pstmt.setNull(46,java.sql.Types.DATE);
			}
			// For column CNTR_RETR_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(47);
				if(tempDate != null)
					pstmt.setDate(47,tempDate);
				else
					pstmt.setNull(47,java.sql.Types.DATE);
			}
			// For column CNTR_REPL_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(48);
				if(tempDate != null)
					pstmt.setDate(48,tempDate);
				else
					pstmt.setNull(48,java.sql.Types.DATE);
			}
			// For column CNTR_CLS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(49);
				if(tempDate != null)
					pstmt.setDate(49,tempDate);
				else
					pstmt.setNull(49,java.sql.Types.DATE);
			}
			// For column CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(50);
				if(tempString != null)
					pstmt.setString(50,tempString);
				else
					pstmt.setNull(50,java.sql.Types.CHAR);
			}
			// For column CNTR_AMDT_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(51);
				if(tempDouble != null)
					pstmt.setDouble(51,tempDouble.doubleValue());
				else
					pstmt.setNull(51,java.sql.Types.DECIMAL);
			}
			// For column REG_SOLD_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(52);
				if(tempString != null)
					pstmt.setString(52,tempString);
				else
					pstmt.setNull(52,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(53);
				if(tempString != null)
					pstmt.setString(53,tempString);
				else
					pstmt.setNull(53,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(54);
				if(tempString != null)
					pstmt.setString(54,tempString);
				else
					pstmt.setNull(54,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(55);
				if(tempString != null)
					pstmt.setString(55,tempString);
				else
					pstmt.setNull(55,java.sql.Types.CHAR);
			}
			// For column INVOICE_AMOUNT_SEM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(56);
				if(tempDouble != null)
					pstmt.setDouble(56,tempDouble.doubleValue());
				else
					pstmt.setNull(56,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_ANN
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(57);
				if(tempDouble != null)
					pstmt.setDouble(57,tempDouble.doubleValue());
				else
					pstmt.setNull(57,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_MON
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(58);
				if(tempDouble != null)
					pstmt.setDouble(58,tempDouble.doubleValue());
				else
					pstmt.setNull(58,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_QRT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(59);
				if(tempDouble != null)
					pstmt.setDouble(59,tempDouble.doubleValue());
				else
					pstmt.setNull(59,java.sql.Types.DECIMAL);
			}
			// For column OLD_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(60);
				if(tempString != null)
					pstmt.setString(60,tempString);
				else
					pstmt.setNull(60,java.sql.Types.CHAR);
			}
			// For column PRE_TVM_INV_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(61);
				if(tempDouble != null)
					pstmt.setDouble(61,tempDouble.doubleValue());
				else
					pstmt.setNull(61,java.sql.Types.DECIMAL);
			}
			// For column PROPOSAL_SHARING
			{
				String tempString;


				tempString=(String)inputRecord.get(62);
				if(tempString != null)
					pstmt.setString(62,tempString);
				else
					pstmt.setNull(62,java.sql.Types.CHAR);
			}
			// For column EXT_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(63);
				if(tempString != null)
					pstmt.setString(63,tempString);
				else
					pstmt.setNull(63,java.sql.Types.CHAR);
			}
			// For column CNTR_CREATE_FLAG
			{
				String tempString;


				tempString=(String)inputRecord.get(64);
				if(tempString != null)
					pstmt.setString(64,tempString);
				else
					pstmt.setNull(64,java.sql.Types.CHAR);
			}
			// For column PAK_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(65);
				if(tempString != null)
					pstmt.setString(65,tempString);
				else
					pstmt.setNull(65,java.sql.Types.CHAR);
			}
			// For column BILLING_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(66);
				if(tempString != null)
					pstmt.setString(66,tempString);
				else
					pstmt.setNull(66,java.sql.Types.CHAR);
			}
			// For column PAYMENT_TERM
			{
				String tempString;


				tempString=(String)inputRecord.get(67);
				if(tempString != null)
					pstmt.setString(67,tempString);
				else
					pstmt.setNull(67,java.sql.Types.CHAR);
			}
			// For column FIXED_VAL_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(68);
				if(tempDate != null)
					pstmt.setDate(68,tempDate);
				else
					pstmt.setNull(68,java.sql.Types.DATE);
			}
			// For column TP_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(69);
				if(tempString != null)
					pstmt.setString(69,tempString);
				else
					pstmt.setNull(69,java.sql.Types.CHAR);
			}
			// For column INELIGIBLE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(70);
				if(tempString != null)
					pstmt.setString(70,tempString);
				else
					pstmt.setNull(70,java.sql.Types.CHAR);
			}
			// For column INVOICE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(71);
				if(tempString != null)
					pstmt.setString(71,tempString);
				else
					pstmt.setNull(71,java.sql.Types.CHAR);
			}
			// For column AUTOPOPULATE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(72);
				if(tempString != null)
					pstmt.setString(72,tempString);
				else
					pstmt.setNull(72,java.sql.Types.CHAR);
			}
			// For column CCI_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(73);
				if(tempString != null)
					pstmt.setString(73,tempString);
				else
					pstmt.setNull(73,java.sql.Types.CHAR);
			}
			// For column PREBILL_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(74);
				if(tempString != null)
					pstmt.setString(74,tempString);
				else
					pstmt.setNull(74,java.sql.Types.CHAR);
			}
			// For column BLB_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(75);
				if(tempString != null)
					pstmt.setString(75,tempString);
				else
					pstmt.setNull(75,java.sql.Types.CHAR);
			}
			// For column CONTRACT_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(76);
				if(tempString != null)
					pstmt.setString(76,tempString);
				else
					pstmt.setNull(76,java.sql.Types.CHAR);
			}
			// For column OCPS
			{
				String tempString;


				tempString=(String)inputRecord.get(77);
				if(tempString != null)
					pstmt.setString(77,tempString);
				else
					pstmt.setNull(77,java.sql.Types.CHAR);
			}
			// For column CPS
			{
				String tempString;


				tempString=(String)inputRecord.get(78);
				if(tempString != null)
					pstmt.setString(78,tempString);
				else
					pstmt.setNull(78,java.sql.Types.CHAR);
			}
			// For column S_S_DISCOUNT_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(79);
				if(tempDouble != null)
					pstmt.setDouble(79,tempDouble.doubleValue());
				else
					pstmt.setNull(79,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(80);
				if(tempDouble != null)
					pstmt.setDouble(80,tempDouble.doubleValue());
				else
					pstmt.setNull(80,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(81);
				if(tempDouble != null)
					pstmt.setDouble(81,tempDouble.doubleValue());
				else
					pstmt.setNull(81,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(82);
				if(tempDouble != null)
					pstmt.setDouble(82,tempDouble.doubleValue());
				else
					pstmt.setNull(82,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT1
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(83);
				if(tempDouble != null)
					pstmt.setDouble(83,tempDouble.doubleValue());
				else
					pstmt.setNull(83,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(84);
				if(tempDouble != null)
					pstmt.setDouble(84,tempDouble.doubleValue());
				else
					pstmt.setNull(84,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(85);
				if(tempDouble != null)
					pstmt.setDouble(85,tempDouble.doubleValue());
				else
					pstmt.setNull(85,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(86);
				if(tempDouble != null)
					pstmt.setDouble(86,tempDouble.doubleValue());
				else
					pstmt.setNull(86,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(87);
				if(tempDouble != null)
					pstmt.setDouble(87,tempDouble.doubleValue());
				else
					pstmt.setNull(87,java.sql.Types.DECIMAL);
			}
			// For column S_S_EXTEND_CNTR_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(88);
				if(tempString != null)
					pstmt.setString(88,tempString);
				else
					pstmt.setNull(88,java.sql.Types.CHAR);
			}
			// For column GROUP_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(89);
				if(tempString != null)
					pstmt.setString(89,tempString);
				else
					pstmt.setNull(89,java.sql.Types.CHAR);
			}
			// For column SUBMITTED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(90);
				if(tempString != null)
					pstmt.setString(90,tempString);
				else
					pstmt.setNull(90,java.sql.Types.VARCHAR);
			}
			// For column PROPOSAL_CONTENT
			{
				String tempString;


				tempString=(String)inputRecord.get(91);
				if(tempString != null)
					pstmt.setString(91,tempString);
				else
					pstmt.setNull(91,java.sql.Types.CHAR);
			}
			// For column S_S_DISCOUNT_SUM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(92);
				if(tempDouble != null)
					pstmt.setDouble(92,tempDouble.doubleValue());
				else
					pstmt.setNull(92,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(93);
				if(tempDouble != null)
					pstmt.setDouble(93,tempDouble.doubleValue());
				else
					pstmt.setNull(93,java.sql.Types.DECIMAL);
			}
			// For column REG_9D_PARTNER_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(94);
				if(tempString != null)
					pstmt.setString(94,tempString);
				else
					pstmt.setNull(94,java.sql.Types.CHAR);
			}
			// For column REG_9D_PARTNER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(95);
				if(tempString != null)
					pstmt.setString(95,tempString);
				else
					pstmt.setNull(95,java.sql.Types.CHAR);
			}
			// For column CUM_VALUE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(96);
				if(tempDouble != null)
					pstmt.setDouble(96,tempDouble.doubleValue());
				else
					pstmt.setNull(96,java.sql.Types.DECIMAL);
			}
			// For column CAP_VARIANCE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(97);
				if(tempDouble != null)
					pstmt.setDouble(97,tempDouble.doubleValue());
				else
					pstmt.setNull(97,java.sql.Types.DECIMAL);
			}
			// For column ORG_VAR_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(98);
				if(tempString != null)
					pstmt.setString(98,tempString);
				else
					pstmt.setNull(98,java.sql.Types.CHAR);
			}
			// For column VAR_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(99);
				if(tempDate != null)
					pstmt.setDate(99,tempDate);
				else
					pstmt.setNull(99,java.sql.Types.DATE);
			}
			// For column VAR_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(100);
				if(tempString != null)
					pstmt.setString(100,tempString);
				else
					pstmt.setNull(100,java.sql.Types.CHAR);
			}
			// For column REG_SOLD_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(101);
				if(tempString != null)
					pstmt.setString(101,tempString);
				else
					pstmt.setNull(101,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(102);
				if(tempString != null)
					pstmt.setString(102,tempString);
				else
					pstmt.setNull(102,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(103);
				if(tempString != null)
					pstmt.setString(103,tempString);
				else
					pstmt.setNull(103,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(104);
				if(tempString != null)
					pstmt.setString(104,tempString);
				else
					pstmt.setNull(104,java.sql.Types.CHAR);
			}
			// For column SUPPRESS_INVOICE
			{
				String tempString;


				tempString=(String)inputRecord.get(105);
				if(tempString != null)
					pstmt.setString(105,tempString);
				else
					pstmt.setNull(105,java.sql.Types.CHAR);
			}
			// For column ESW_FETCH_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(106);
				if(tempDate != null)
					pstmt.setDate(106,tempDate);
				else
					pstmt.setNull(106,java.sql.Types.DATE);
			}
			// For column ESW_FETCH_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(107);
				if(tempTime != null)
					pstmt.setTime(107,tempTime);
				else
					pstmt.setNull(107,java.sql.Types.TIME);
			}
			// For column GSA_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(108);
				if(tempString != null)
					pstmt.setString(108,tempString);
				else
					pstmt.setNull(108,java.sql.Types.CHAR);
			}
			// For column FREE_TEXT
			{
				String tempString;


				tempString=(String)inputRecord.get(109);
				if(tempString != null)
					pstmt.setString(109,tempString);
				else
					pstmt.setNull(109,java.sql.Types.VARCHAR);
			}
			// For column LOCKED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(110);
				if(tempString != null)
					pstmt.setString(110,tempString);
				else
					pstmt.setNull(110,java.sql.Types.VARCHAR);
			}
			// For column LOCKED_ON
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(111);
				if(tempDate != null)
					pstmt.setDate(111,tempDate);
				else
					pstmt.setNull(111,java.sql.Types.DATE);
			}
			// For column PO_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(112);
				if(tempString != null)
					pstmt.setString(112,tempString);
				else
					pstmt.setNull(112,java.sql.Types.CHAR);
			}
			// For column PO_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(113);
				if(tempDate != null)
					pstmt.setDate(113,tempDate);
				else
					pstmt.setNull(113,java.sql.Types.DATE);
			}
			// For column ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(114);
				if(tempDouble != null)
					pstmt.setDouble(114,tempDouble.doubleValue());
				else
					pstmt.setNull(114,java.sql.Types.DECIMAL);
			}
			// For column CNTR_NEWRENEW_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(115);
				if(tempInteger != null)
					pstmt.setInt(115,tempInteger.intValue());
				else
					pstmt.setNull(115,java.sql.Types.DECIMAL);
			}
			// For column BILLING_BLOCK
			{
				String tempString;


				tempString=(String)inputRecord.get(116);
				if(tempString != null)
					pstmt.setString(116,tempString);
				else
					pstmt.setNull(116,java.sql.Types.CHAR);
			}
			// For column CNTR_PERIOD_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(117);
				if(tempInteger != null)
					pstmt.setInt(117,tempInteger.intValue());
				else
					pstmt.setNull(117,java.sql.Types.INTEGER);
			}
			// For column CNTR_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(118);
				if(tempInteger != null)
					pstmt.setInt(118,tempInteger.intValue());
				else
					pstmt.setNull(118,java.sql.Types.INTEGER);
			}
			// For column DEVIATING_DATE_RULE
			{
				String tempString;


				tempString=(String)inputRecord.get(119);
				if(tempString != null)
					pstmt.setString(119,tempString);
				else
					pstmt.setNull(119,java.sql.Types.CHAR);
			}
			// For column S_S_EXCLUDED
			{
				String tempString;


				tempString=(String)inputRecord.get(120);
				if(tempString != null)
					pstmt.setString(120,tempString);
				else
					pstmt.setNull(120,java.sql.Types.CHAR);
			}
			// For column CNTR_REPL_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(121);
				if(tempInteger != null)
					pstmt.setInt(121,tempInteger.intValue());
				else
					pstmt.setNull(121,java.sql.Types.DECIMAL);
			}
			// For column FIN_CNTR_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(122);
				if(tempString != null)
					pstmt.setString(122,tempString);
				else
					pstmt.setNull(122,java.sql.Types.CHAR);
			}
			// For column SALES_GROUP
			{
				String tempString;


				tempString=(String)inputRecord.get(123);
				if(tempString != null)
					pstmt.setString(123,tempString);
				else
					pstmt.setNull(123,java.sql.Types.CHAR);
			}
			// For column CHANNEL_ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(124);
				if(tempString != null)
					pstmt.setString(124,tempString);
				else
					pstmt.setNull(124,java.sql.Types.CHAR);
			}
			// For column SUBMITTER_ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(125);
				if(tempString != null)
					pstmt.setString(125,tempString);
				else
					pstmt.setNull(125,java.sql.Types.CHAR);
			}
			// For column PAYMENTMETHOD
			{
				String tempString;


				tempString=(String)inputRecord.get(126);
				if(tempString != null)
					pstmt.setString(126,tempString);
				else
					pstmt.setNull(126,java.sql.Types.CHAR);
			}
			// For column DISCOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(127);
				if(tempDouble != null)
					pstmt.setDouble(127,tempDouble.doubleValue());
				else
					pstmt.setNull(127,java.sql.Types.DECIMAL);
			}
			if (executeUpdate(connection, pstmt, StoreQuery_0)==0)
				throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String StoreOCCQuery_0 = "UPDATE BH.PROPOSAL  SET ADD_VALUE_DAYS = ?, ADVANCE_BILLING = ?, AMDT_IND = ?, AMDT_EFFC_DATE = ?, APPROVED_BY = ?, PROPOSAL_TYPE = ?, BILLING_FREQ_CODE = ?, CREATED_BY = ?, STATUS_CODE = ?, SALES_ORG = ?, DSTR_CHANNEL = ?, DIVISION_CODE = ?, PROPOSAL_NAME = ?, CNTR_START_DATE = ?, CNTR_END_DATE = ?, CNTR_START_PERIOD = ?, CNTR_END_PERIOD = ?, TVM_RATE = ?, GROWTH_FACTOR = ?, SPECIAL_RATE = ?, INVOICE_AMOUNT = ?, DATE_PRICED = ?, COMMENTS = ?, CREATED_DATE = ?, APPROVED_DATE = ?, DELETED_IND = ?, REG_SOLD_TO_P_NO = ?, REG_SOLD_TO_P_NAME = ?, REG_BILL_TO_P_NO = ?, REG_BILL_TO_P_NAME = ?, REG_PAYER_NO = ?, REG_PAYER_NAME = ?, REG_SHIP_TO_P_NO = ?, REG_SHIP_TO_P_NAME = ?, CURRENCY = ?, LAST_UPDATE_DATE = ?, RE_FETCH_ID = ?, FETCH_DATE = ?, DELTA_FETCH_ID = ?, CNTR_TYPE = ?, REPORT_NAME = ?, CAP_AMOUNT = ?, CAP_PLUS = ?, CAP_MINUS = ?, PRE_TVM = ?, CNTR_EXTN_DATE = ?, CNTR_RETR_DATE = ?, CNTR_REPL_DATE = ?, CNTR_CLS_DATE = ?, CNTR_NUMBER = ?, CNTR_AMDT_NO = ?, REG_SOLD_TO_P_LNO = ?, REG_BILL_TO_P_LNO = ?, REG_PAYER_LNO = ?, REG_SHIP_TO_P_LNO = ?, INVOICE_AMOUNT_SEM = ?, INVOICE_AMOUNT_ANN = ?, INVOICE_AMOUNT_MON = ?, INVOICE_AMOUNT_QRT = ?, OLD_CNTR_NUMBER = ?, PRE_TVM_INV_AMT = ?, PROPOSAL_SHARING = ?, EXT_CNTR_NUMBER = ?, CNTR_CREATE_FLAG = ?, PAK_ID = ?, BILLING_TYPE = ?, PAYMENT_TERM = ?, FIXED_VAL_DATE = ?, TP_CNTR_NUMBER = ?, INELIGIBLE_IND = ?, INVOICE_IND = ?, AUTOPOPULATE_IND = ?, CCI_IND = ?, PREBILL_INDICATOR = ?, BLB_INDICATOR = ?, CONTRACT_TYPE = ?, OCPS = ?, CPS = ?, S_S_DISCOUNT_AMOUNT5 = ?, S_S_DISCOUNT_AMOUNT4 = ?, S_S_DISCOUNT_AMOUNT3 = ?, S_S_DISCOUNT_AMOUNT2 = ?, S_S_DISCOUNT_AMOUNT1 = ?, S_S_ANNV_AMOUNT5 = ?, S_S_ANNV_AMOUNT4 = ?, S_S_ANNV_AMOUNT3 = ?, S_S_ANNV_AMOUNT2 = ?, S_S_EXTEND_CNTR_IND = ?, GROUP_NAME = ?, SUBMITTED_BY = ?, PROPOSAL_CONTENT = ?, S_S_DISCOUNT_SUM = ?, S_S_ANNV_AMOUNT = ?, REG_9D_PARTNER_NO = ?, REG_9D_PARTNER_NAME = ?, CUM_VALUE = ?, CAP_VARIANCE = ?, ORG_VAR_CNTR_NUMBER = ?, VAR_DATE = ?, VAR_IND = ?, REG_SOLD_TO_P_ASNO = ?, REG_BILL_TO_P_ASNO = ?, REG_PAYER_ASNO = ?, REG_SHIP_TO_P_ASNO = ?, SUPPRESS_INVOICE = ?, ESW_FETCH_DATE = ?, ESW_FETCH_TIME = ?, GSA_IND = ?, FREE_TEXT = ?, LOCKED_BY = ?, LOCKED_ON = ?, PO_NUMBER = ?, PO_DATE = ?, ANNV_AMOUNT = ?, CNTR_NEWRENEW_NO = ?, BILLING_BLOCK = ?, CNTR_PERIOD_VAR_NO = ?, CNTR_VAR_NO = ?, DEVIATING_DATE_RULE = ?, S_S_EXCLUDED = ?, CNTR_REPL_NO = ?, FIN_CNTR_NO = ?, SALES_GROUP = ?, CHANNEL_ROLE = ?, SUBMITTER_ROLE = ?, PAYMENTMETHOD = ?, DISCOUNT = ? WHERE PROPOSAL_ID = ? AND ADD_VALUE_DAYS = ? AND TVM_RATE = ? AND GROWTH_FACTOR = ? AND SPECIAL_RATE = ? AND INVOICE_AMOUNT = ? AND CAP_AMOUNT = ? AND CAP_PLUS = ? AND CAP_MINUS = ? AND PRE_TVM = ? AND CNTR_AMDT_NO = ? AND INVOICE_AMOUNT_SEM = ? AND INVOICE_AMOUNT_ANN = ? AND INVOICE_AMOUNT_MON = ? AND INVOICE_AMOUNT_QRT = ? AND PRE_TVM_INV_AMT = ? AND S_S_DISCOUNT_AMOUNT5 = ? AND S_S_DISCOUNT_AMOUNT4 = ? AND S_S_DISCOUNT_AMOUNT3 = ? AND S_S_DISCOUNT_AMOUNT2 = ? AND S_S_DISCOUNT_AMOUNT1 = ? AND S_S_ANNV_AMOUNT5 = ? AND S_S_ANNV_AMOUNT4 = ? AND S_S_ANNV_AMOUNT3 = ? AND S_S_ANNV_AMOUNT2 = ? AND S_S_DISCOUNT_SUM = ? AND S_S_ANNV_AMOUNT = ? AND CUM_VALUE = ? AND CAP_VARIANCE = ? AND ANNV_AMOUNT = ? AND CNTR_NEWRENEW_NO = ? AND CNTR_PERIOD_VAR_NO = ? AND CNTR_VAR_NO = ? AND CNTR_REPL_NO = ? AND DISCOUNT = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column ADD_VALUE_DAYS
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column ADVANCE_BILLING
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column AMDT_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column AMDT_EFFC_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column APPROVED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(128,tempInteger.intValue());
				else
					pstmt.setNull(128,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column BILLING_FREQ_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column CREATED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column STATUS_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column SALES_ORG
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column DSTR_CHANNEL
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column DIVISION_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			// For column PROPOSAL_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column CNTR_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(14);
				if(tempDate != null)
					pstmt.setDate(14,tempDate);
				else
					pstmt.setNull(14,java.sql.Types.DATE);
			}
			// For column CNTR_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(15);
				if(tempDate != null)
					pstmt.setDate(15,tempDate);
				else
					pstmt.setNull(15,java.sql.Types.DATE);
			}
			// For column CNTR_START_PERIOD
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(16);
				if(tempDate != null)
					pstmt.setDate(16,tempDate);
				else
					pstmt.setNull(16,java.sql.Types.DATE);
			}
			// For column CNTR_END_PERIOD
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(17);
				if(tempDate != null)
					pstmt.setDate(17,tempDate);
				else
					pstmt.setNull(17,java.sql.Types.DATE);
			}
			// For column TVM_RATE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(18);
				if(tempDouble != null)
					pstmt.setDouble(18,tempDouble.doubleValue());
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column GROWTH_FACTOR
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(19);
				if(tempDouble != null)
					pstmt.setDouble(19,tempDouble.doubleValue());
				else
					pstmt.setNull(19,java.sql.Types.DECIMAL);
			}
			// For column SPECIAL_RATE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(20);
				if(tempDouble != null)
					pstmt.setDouble(20,tempDouble.doubleValue());
				else
					pstmt.setNull(20,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(21);
				if(tempDouble != null)
					pstmt.setDouble(21,tempDouble.doubleValue());
				else
					pstmt.setNull(21,java.sql.Types.DECIMAL);
			}
			// For column DATE_PRICED
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(22);
				if(tempDate != null)
					pstmt.setDate(22,tempDate);
				else
					pstmt.setNull(22,java.sql.Types.DATE);
			}
			// For column COMMENTS
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(23,tempString);
				else
					pstmt.setNull(23,java.sql.Types.VARCHAR);
			}
			// For column CREATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(24);
				if(tempDate != null)
					pstmt.setDate(24,tempDate);
				else
					pstmt.setNull(24,java.sql.Types.DATE);
			}
			// For column APPROVED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(25);
				if(tempDate != null)
					pstmt.setDate(25,tempDate);
				else
					pstmt.setNull(25,java.sql.Types.DATE);
			}
			// For column DELETED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(26,tempString);
				else
					pstmt.setNull(26,java.sql.Types.CHAR);
			}
			// For column REG_SOLD_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(27);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.CHAR);
			}
			// For column REG_SOLD_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(28);
				if(tempString != null)
					pstmt.setString(28,tempString);
				else
					pstmt.setNull(28,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(29);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(30);
				if(tempString != null)
					pstmt.setString(30,tempString);
				else
					pstmt.setNull(30,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(31);
				if(tempString != null)
					pstmt.setString(31,tempString);
				else
					pstmt.setNull(31,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(32,tempString);
				else
					pstmt.setNull(32,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(33);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(34);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.CHAR);
			}
			// For column CURRENCY
			{
				String tempString;


				tempString=(String)inputRecord.get(35);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.CHAR);
			}
			// For column LAST_UPDATE_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(36);
				if(tempDate != null)
					pstmt.setDate(36,tempDate);
				else
					pstmt.setNull(36,java.sql.Types.DATE);
			}
			// For column RE_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(37);
				if(tempString != null)
					pstmt.setString(37,tempString);
				else
					pstmt.setNull(37,java.sql.Types.CHAR);
			}
			// For column FETCH_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(38);
				if(tempDate != null)
					pstmt.setDate(38,tempDate);
				else
					pstmt.setNull(38,java.sql.Types.DATE);
			}
			// For column DELTA_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(39);
				if(tempString != null)
					pstmt.setString(39,tempString);
				else
					pstmt.setNull(39,java.sql.Types.CHAR);
			}
			// For column CNTR_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(40);
				if(tempString != null)
					pstmt.setString(40,tempString);
				else
					pstmt.setNull(40,java.sql.Types.CHAR);
			}
			// For column REPORT_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(41);
				if(tempString != null)
					pstmt.setString(41,tempString);
				else
					pstmt.setNull(41,java.sql.Types.CHAR);
			}
			// For column CAP_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(42);
				if(tempDouble != null)
					pstmt.setDouble(42,tempDouble.doubleValue());
				else
					pstmt.setNull(42,java.sql.Types.DECIMAL);
			}
			// For column CAP_PLUS
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(43);
				if(tempDouble != null)
					pstmt.setDouble(43,tempDouble.doubleValue());
				else
					pstmt.setNull(43,java.sql.Types.DECIMAL);
			}
			// For column CAP_MINUS
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(44);
				if(tempDouble != null)
					pstmt.setDouble(44,tempDouble.doubleValue());
				else
					pstmt.setNull(44,java.sql.Types.DECIMAL);
			}
			// For column PRE_TVM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(45);
				if(tempDouble != null)
					pstmt.setDouble(45,tempDouble.doubleValue());
				else
					pstmt.setNull(45,java.sql.Types.DECIMAL);
			}
			// For column CNTR_EXTN_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(46);
				if(tempDate != null)
					pstmt.setDate(46,tempDate);
				else
					pstmt.setNull(46,java.sql.Types.DATE);
			}
			// For column CNTR_RETR_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(47);
				if(tempDate != null)
					pstmt.setDate(47,tempDate);
				else
					pstmt.setNull(47,java.sql.Types.DATE);
			}
			// For column CNTR_REPL_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(48);
				if(tempDate != null)
					pstmt.setDate(48,tempDate);
				else
					pstmt.setNull(48,java.sql.Types.DATE);
			}
			// For column CNTR_CLS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(49);
				if(tempDate != null)
					pstmt.setDate(49,tempDate);
				else
					pstmt.setNull(49,java.sql.Types.DATE);
			}
			// For column CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(50);
				if(tempString != null)
					pstmt.setString(50,tempString);
				else
					pstmt.setNull(50,java.sql.Types.CHAR);
			}
			// For column CNTR_AMDT_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(51);
				if(tempDouble != null)
					pstmt.setDouble(51,tempDouble.doubleValue());
				else
					pstmt.setNull(51,java.sql.Types.DECIMAL);
			}
			// For column REG_SOLD_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(52);
				if(tempString != null)
					pstmt.setString(52,tempString);
				else
					pstmt.setNull(52,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(53);
				if(tempString != null)
					pstmt.setString(53,tempString);
				else
					pstmt.setNull(53,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(54);
				if(tempString != null)
					pstmt.setString(54,tempString);
				else
					pstmt.setNull(54,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(55);
				if(tempString != null)
					pstmt.setString(55,tempString);
				else
					pstmt.setNull(55,java.sql.Types.CHAR);
			}
			// For column INVOICE_AMOUNT_SEM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(56);
				if(tempDouble != null)
					pstmt.setDouble(56,tempDouble.doubleValue());
				else
					pstmt.setNull(56,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_ANN
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(57);
				if(tempDouble != null)
					pstmt.setDouble(57,tempDouble.doubleValue());
				else
					pstmt.setNull(57,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_MON
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(58);
				if(tempDouble != null)
					pstmt.setDouble(58,tempDouble.doubleValue());
				else
					pstmt.setNull(58,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_QRT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(59);
				if(tempDouble != null)
					pstmt.setDouble(59,tempDouble.doubleValue());
				else
					pstmt.setNull(59,java.sql.Types.DECIMAL);
			}
			// For column OLD_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(60);
				if(tempString != null)
					pstmt.setString(60,tempString);
				else
					pstmt.setNull(60,java.sql.Types.CHAR);
			}
			// For column PRE_TVM_INV_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(61);
				if(tempDouble != null)
					pstmt.setDouble(61,tempDouble.doubleValue());
				else
					pstmt.setNull(61,java.sql.Types.DECIMAL);
			}
			// For column PROPOSAL_SHARING
			{
				String tempString;


				tempString=(String)inputRecord.get(62);
				if(tempString != null)
					pstmt.setString(62,tempString);
				else
					pstmt.setNull(62,java.sql.Types.CHAR);
			}
			// For column EXT_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(63);
				if(tempString != null)
					pstmt.setString(63,tempString);
				else
					pstmt.setNull(63,java.sql.Types.CHAR);
			}
			// For column CNTR_CREATE_FLAG
			{
				String tempString;


				tempString=(String)inputRecord.get(64);
				if(tempString != null)
					pstmt.setString(64,tempString);
				else
					pstmt.setNull(64,java.sql.Types.CHAR);
			}
			// For column PAK_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(65);
				if(tempString != null)
					pstmt.setString(65,tempString);
				else
					pstmt.setNull(65,java.sql.Types.CHAR);
			}
			// For column BILLING_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(66);
				if(tempString != null)
					pstmt.setString(66,tempString);
				else
					pstmt.setNull(66,java.sql.Types.CHAR);
			}
			// For column PAYMENT_TERM
			{
				String tempString;


				tempString=(String)inputRecord.get(67);
				if(tempString != null)
					pstmt.setString(67,tempString);
				else
					pstmt.setNull(67,java.sql.Types.CHAR);
			}
			// For column FIXED_VAL_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(68);
				if(tempDate != null)
					pstmt.setDate(68,tempDate);
				else
					pstmt.setNull(68,java.sql.Types.DATE);
			}
			// For column TP_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(69);
				if(tempString != null)
					pstmt.setString(69,tempString);
				else
					pstmt.setNull(69,java.sql.Types.CHAR);
			}
			// For column INELIGIBLE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(70);
				if(tempString != null)
					pstmt.setString(70,tempString);
				else
					pstmt.setNull(70,java.sql.Types.CHAR);
			}
			// For column INVOICE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(71);
				if(tempString != null)
					pstmt.setString(71,tempString);
				else
					pstmt.setNull(71,java.sql.Types.CHAR);
			}
			// For column AUTOPOPULATE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(72);
				if(tempString != null)
					pstmt.setString(72,tempString);
				else
					pstmt.setNull(72,java.sql.Types.CHAR);
			}
			// For column CCI_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(73);
				if(tempString != null)
					pstmt.setString(73,tempString);
				else
					pstmt.setNull(73,java.sql.Types.CHAR);
			}
			// For column PREBILL_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(74);
				if(tempString != null)
					pstmt.setString(74,tempString);
				else
					pstmt.setNull(74,java.sql.Types.CHAR);
			}
			// For column BLB_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(75);
				if(tempString != null)
					pstmt.setString(75,tempString);
				else
					pstmt.setNull(75,java.sql.Types.CHAR);
			}
			// For column CONTRACT_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(76);
				if(tempString != null)
					pstmt.setString(76,tempString);
				else
					pstmt.setNull(76,java.sql.Types.CHAR);
			}
			// For column OCPS
			{
				String tempString;


				tempString=(String)inputRecord.get(77);
				if(tempString != null)
					pstmt.setString(77,tempString);
				else
					pstmt.setNull(77,java.sql.Types.CHAR);
			}
			// For column CPS
			{
				String tempString;


				tempString=(String)inputRecord.get(78);
				if(tempString != null)
					pstmt.setString(78,tempString);
				else
					pstmt.setNull(78,java.sql.Types.CHAR);
			}
			// For column S_S_DISCOUNT_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(79);
				if(tempDouble != null)
					pstmt.setDouble(79,tempDouble.doubleValue());
				else
					pstmt.setNull(79,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(80);
				if(tempDouble != null)
					pstmt.setDouble(80,tempDouble.doubleValue());
				else
					pstmt.setNull(80,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(81);
				if(tempDouble != null)
					pstmt.setDouble(81,tempDouble.doubleValue());
				else
					pstmt.setNull(81,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(82);
				if(tempDouble != null)
					pstmt.setDouble(82,tempDouble.doubleValue());
				else
					pstmt.setNull(82,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT1
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(83);
				if(tempDouble != null)
					pstmt.setDouble(83,tempDouble.doubleValue());
				else
					pstmt.setNull(83,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(84);
				if(tempDouble != null)
					pstmt.setDouble(84,tempDouble.doubleValue());
				else
					pstmt.setNull(84,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(85);
				if(tempDouble != null)
					pstmt.setDouble(85,tempDouble.doubleValue());
				else
					pstmt.setNull(85,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(86);
				if(tempDouble != null)
					pstmt.setDouble(86,tempDouble.doubleValue());
				else
					pstmt.setNull(86,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(87);
				if(tempDouble != null)
					pstmt.setDouble(87,tempDouble.doubleValue());
				else
					pstmt.setNull(87,java.sql.Types.DECIMAL);
			}
			// For column S_S_EXTEND_CNTR_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(88);
				if(tempString != null)
					pstmt.setString(88,tempString);
				else
					pstmt.setNull(88,java.sql.Types.CHAR);
			}
			// For column GROUP_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(89);
				if(tempString != null)
					pstmt.setString(89,tempString);
				else
					pstmt.setNull(89,java.sql.Types.CHAR);
			}
			// For column SUBMITTED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(90);
				if(tempString != null)
					pstmt.setString(90,tempString);
				else
					pstmt.setNull(90,java.sql.Types.VARCHAR);
			}
			// For column PROPOSAL_CONTENT
			{
				String tempString;


				tempString=(String)inputRecord.get(91);
				if(tempString != null)
					pstmt.setString(91,tempString);
				else
					pstmt.setNull(91,java.sql.Types.CHAR);
			}
			// For column S_S_DISCOUNT_SUM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(92);
				if(tempDouble != null)
					pstmt.setDouble(92,tempDouble.doubleValue());
				else
					pstmt.setNull(92,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(93);
				if(tempDouble != null)
					pstmt.setDouble(93,tempDouble.doubleValue());
				else
					pstmt.setNull(93,java.sql.Types.DECIMAL);
			}
			// For column REG_9D_PARTNER_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(94);
				if(tempString != null)
					pstmt.setString(94,tempString);
				else
					pstmt.setNull(94,java.sql.Types.CHAR);
			}
			// For column REG_9D_PARTNER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(95);
				if(tempString != null)
					pstmt.setString(95,tempString);
				else
					pstmt.setNull(95,java.sql.Types.CHAR);
			}
			// For column CUM_VALUE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(96);
				if(tempDouble != null)
					pstmt.setDouble(96,tempDouble.doubleValue());
				else
					pstmt.setNull(96,java.sql.Types.DECIMAL);
			}
			// For column CAP_VARIANCE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(97);
				if(tempDouble != null)
					pstmt.setDouble(97,tempDouble.doubleValue());
				else
					pstmt.setNull(97,java.sql.Types.DECIMAL);
			}
			// For column ORG_VAR_CNTR_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(98);
				if(tempString != null)
					pstmt.setString(98,tempString);
				else
					pstmt.setNull(98,java.sql.Types.CHAR);
			}
			// For column VAR_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(99);
				if(tempDate != null)
					pstmt.setDate(99,tempDate);
				else
					pstmt.setNull(99,java.sql.Types.DATE);
			}
			// For column VAR_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(100);
				if(tempString != null)
					pstmt.setString(100,tempString);
				else
					pstmt.setNull(100,java.sql.Types.CHAR);
			}
			// For column REG_SOLD_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(101);
				if(tempString != null)
					pstmt.setString(101,tempString);
				else
					pstmt.setNull(101,java.sql.Types.CHAR);
			}
			// For column REG_BILL_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(102);
				if(tempString != null)
					pstmt.setString(102,tempString);
				else
					pstmt.setNull(102,java.sql.Types.CHAR);
			}
			// For column REG_PAYER_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(103);
				if(tempString != null)
					pstmt.setString(103,tempString);
				else
					pstmt.setNull(103,java.sql.Types.CHAR);
			}
			// For column REG_SHIP_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(104);
				if(tempString != null)
					pstmt.setString(104,tempString);
				else
					pstmt.setNull(104,java.sql.Types.CHAR);
			}
			// For column SUPPRESS_INVOICE
			{
				String tempString;


				tempString=(String)inputRecord.get(105);
				if(tempString != null)
					pstmt.setString(105,tempString);
				else
					pstmt.setNull(105,java.sql.Types.CHAR);
			}
			// For column ESW_FETCH_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(106);
				if(tempDate != null)
					pstmt.setDate(106,tempDate);
				else
					pstmt.setNull(106,java.sql.Types.DATE);
			}
			// For column ESW_FETCH_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(107);
				if(tempTime != null)
					pstmt.setTime(107,tempTime);
				else
					pstmt.setNull(107,java.sql.Types.TIME);
			}
			// For column GSA_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(108);
				if(tempString != null)
					pstmt.setString(108,tempString);
				else
					pstmt.setNull(108,java.sql.Types.CHAR);
			}
			// For column FREE_TEXT
			{
				String tempString;


				tempString=(String)inputRecord.get(109);
				if(tempString != null)
					pstmt.setString(109,tempString);
				else
					pstmt.setNull(109,java.sql.Types.VARCHAR);
			}
			// For column LOCKED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(110);
				if(tempString != null)
					pstmt.setString(110,tempString);
				else
					pstmt.setNull(110,java.sql.Types.VARCHAR);
			}
			// For column LOCKED_ON
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(111);
				if(tempDate != null)
					pstmt.setDate(111,tempDate);
				else
					pstmt.setNull(111,java.sql.Types.DATE);
			}
			// For column PO_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(112);
				if(tempString != null)
					pstmt.setString(112,tempString);
				else
					pstmt.setNull(112,java.sql.Types.CHAR);
			}
			// For column PO_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(113);
				if(tempDate != null)
					pstmt.setDate(113,tempDate);
				else
					pstmt.setNull(113,java.sql.Types.DATE);
			}
			// For column ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(114);
				if(tempDouble != null)
					pstmt.setDouble(114,tempDouble.doubleValue());
				else
					pstmt.setNull(114,java.sql.Types.DECIMAL);
			}
			// For column CNTR_NEWRENEW_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(115);
				if(tempInteger != null)
					pstmt.setInt(115,tempInteger.intValue());
				else
					pstmt.setNull(115,java.sql.Types.DECIMAL);
			}
			// For column BILLING_BLOCK
			{
				String tempString;


				tempString=(String)inputRecord.get(116);
				if(tempString != null)
					pstmt.setString(116,tempString);
				else
					pstmt.setNull(116,java.sql.Types.CHAR);
			}
			// For column CNTR_PERIOD_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(117);
				if(tempInteger != null)
					pstmt.setInt(117,tempInteger.intValue());
				else
					pstmt.setNull(117,java.sql.Types.INTEGER);
			}
			// For column CNTR_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(118);
				if(tempInteger != null)
					pstmt.setInt(118,tempInteger.intValue());
				else
					pstmt.setNull(118,java.sql.Types.INTEGER);
			}
			// For column DEVIATING_DATE_RULE
			{
				String tempString;


				tempString=(String)inputRecord.get(119);
				if(tempString != null)
					pstmt.setString(119,tempString);
				else
					pstmt.setNull(119,java.sql.Types.CHAR);
			}
			// For column S_S_EXCLUDED
			{
				String tempString;


				tempString=(String)inputRecord.get(120);
				if(tempString != null)
					pstmt.setString(120,tempString);
				else
					pstmt.setNull(120,java.sql.Types.CHAR);
			}
			// For column CNTR_REPL_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(121);
				if(tempInteger != null)
					pstmt.setInt(121,tempInteger.intValue());
				else
					pstmt.setNull(121,java.sql.Types.DECIMAL);
			}
			// For column FIN_CNTR_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(122);
				if(tempString != null)
					pstmt.setString(122,tempString);
				else
					pstmt.setNull(122,java.sql.Types.CHAR);
			}
			// For column SALES_GROUP
			{
				String tempString;


				tempString=(String)inputRecord.get(123);
				if(tempString != null)
					pstmt.setString(123,tempString);
				else
					pstmt.setNull(123,java.sql.Types.CHAR);
			}
			// For column CHANNEL_ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(124);
				if(tempString != null)
					pstmt.setString(124,tempString);
				else
					pstmt.setNull(124,java.sql.Types.CHAR);
			}
			// For column SUBMITTER_ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(125);
				if(tempString != null)
					pstmt.setString(125,tempString);
				else
					pstmt.setNull(125,java.sql.Types.CHAR);
			}
			// For column PAYMENTMETHOD
			{
				String tempString;


				tempString=(String)inputRecord.get(126);
				if(tempString != null)
					pstmt.setString(126,tempString);
				else
					pstmt.setNull(126,java.sql.Types.CHAR);
			}
			// For column DISCOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(127);
				if(tempDouble != null)
					pstmt.setDouble(127,tempDouble.doubleValue());
				else
					pstmt.setNull(127,java.sql.Types.DECIMAL);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column ADD_VALUE_DAYS
			{
				Integer tempInteger;


				tempInteger=(Integer)oldRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(129,tempInteger.intValue());
				else
					pstmt.setNull(129,java.sql.Types.INTEGER);
			}
			// For column TVM_RATE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(18);
				if(tempDouble != null)
					pstmt.setDouble(130,tempDouble.doubleValue());
				else
					pstmt.setNull(130,java.sql.Types.DECIMAL);
			}
			// For column GROWTH_FACTOR
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(19);
				if(tempDouble != null)
					pstmt.setDouble(131,tempDouble.doubleValue());
				else
					pstmt.setNull(131,java.sql.Types.DECIMAL);
			}
			// For column SPECIAL_RATE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(20);
				if(tempDouble != null)
					pstmt.setDouble(132,tempDouble.doubleValue());
				else
					pstmt.setNull(132,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(21);
				if(tempDouble != null)
					pstmt.setDouble(133,tempDouble.doubleValue());
				else
					pstmt.setNull(133,java.sql.Types.DECIMAL);
			}
			// For column CAP_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(42);
				if(tempDouble != null)
					pstmt.setDouble(134,tempDouble.doubleValue());
				else
					pstmt.setNull(134,java.sql.Types.DECIMAL);
			}
			// For column CAP_PLUS
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(43);
				if(tempDouble != null)
					pstmt.setDouble(135,tempDouble.doubleValue());
				else
					pstmt.setNull(135,java.sql.Types.DECIMAL);
			}
			// For column CAP_MINUS
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(44);
				if(tempDouble != null)
					pstmt.setDouble(136,tempDouble.doubleValue());
				else
					pstmt.setNull(136,java.sql.Types.DECIMAL);
			}
			// For column PRE_TVM
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(45);
				if(tempDouble != null)
					pstmt.setDouble(137,tempDouble.doubleValue());
				else
					pstmt.setNull(137,java.sql.Types.DECIMAL);
			}
			// For column CNTR_AMDT_NO
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(51);
				if(tempDouble != null)
					pstmt.setDouble(138,tempDouble.doubleValue());
				else
					pstmt.setNull(138,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_SEM
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(56);
				if(tempDouble != null)
					pstmt.setDouble(139,tempDouble.doubleValue());
				else
					pstmt.setNull(139,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_ANN
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(57);
				if(tempDouble != null)
					pstmt.setDouble(140,tempDouble.doubleValue());
				else
					pstmt.setNull(140,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_MON
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(58);
				if(tempDouble != null)
					pstmt.setDouble(141,tempDouble.doubleValue());
				else
					pstmt.setNull(141,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_QRT
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(59);
				if(tempDouble != null)
					pstmt.setDouble(142,tempDouble.doubleValue());
				else
					pstmt.setNull(142,java.sql.Types.DECIMAL);
			}
			// For column PRE_TVM_INV_AMT
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(61);
				if(tempDouble != null)
					pstmt.setDouble(143,tempDouble.doubleValue());
				else
					pstmt.setNull(143,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(79);
				if(tempDouble != null)
					pstmt.setDouble(144,tempDouble.doubleValue());
				else
					pstmt.setNull(144,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(80);
				if(tempDouble != null)
					pstmt.setDouble(145,tempDouble.doubleValue());
				else
					pstmt.setNull(145,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(81);
				if(tempDouble != null)
					pstmt.setDouble(146,tempDouble.doubleValue());
				else
					pstmt.setNull(146,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(82);
				if(tempDouble != null)
					pstmt.setDouble(147,tempDouble.doubleValue());
				else
					pstmt.setNull(147,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT1
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(83);
				if(tempDouble != null)
					pstmt.setDouble(148,tempDouble.doubleValue());
				else
					pstmt.setNull(148,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(84);
				if(tempDouble != null)
					pstmt.setDouble(149,tempDouble.doubleValue());
				else
					pstmt.setNull(149,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(85);
				if(tempDouble != null)
					pstmt.setDouble(150,tempDouble.doubleValue());
				else
					pstmt.setNull(150,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(86);
				if(tempDouble != null)
					pstmt.setDouble(151,tempDouble.doubleValue());
				else
					pstmt.setNull(151,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(87);
				if(tempDouble != null)
					pstmt.setDouble(152,tempDouble.doubleValue());
				else
					pstmt.setNull(152,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_SUM
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(92);
				if(tempDouble != null)
					pstmt.setDouble(153,tempDouble.doubleValue());
				else
					pstmt.setNull(153,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(93);
				if(tempDouble != null)
					pstmt.setDouble(154,tempDouble.doubleValue());
				else
					pstmt.setNull(154,java.sql.Types.DECIMAL);
			}
			// For column CUM_VALUE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(96);
				if(tempDouble != null)
					pstmt.setDouble(155,tempDouble.doubleValue());
				else
					pstmt.setNull(155,java.sql.Types.DECIMAL);
			}
			// For column CAP_VARIANCE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(97);
				if(tempDouble != null)
					pstmt.setDouble(156,tempDouble.doubleValue());
				else
					pstmt.setNull(156,java.sql.Types.DECIMAL);
			}
			// For column ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(114);
				if(tempDouble != null)
					pstmt.setDouble(157,tempDouble.doubleValue());
				else
					pstmt.setNull(157,java.sql.Types.DECIMAL);
			}
			// For column CNTR_NEWRENEW_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)oldRecord.get(115);
				if(tempInteger != null)
					pstmt.setInt(158,tempInteger.intValue());
				else
					pstmt.setNull(158,java.sql.Types.DECIMAL);
			}
			// For column CNTR_PERIOD_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)oldRecord.get(117);
				if(tempInteger != null)
					pstmt.setInt(159,tempInteger.intValue());
				else
					pstmt.setNull(159,java.sql.Types.INTEGER);
			}
			// For column CNTR_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)oldRecord.get(118);
				if(tempInteger != null)
					pstmt.setInt(160,tempInteger.intValue());
				else
					pstmt.setNull(160,java.sql.Types.INTEGER);
			}
			// For column CNTR_REPL_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)oldRecord.get(121);
				if(tempInteger != null)
					pstmt.setInt(161,tempInteger.intValue());
				else
					pstmt.setNull(161,java.sql.Types.DECIMAL);
			}
			// For column DISCOUNT
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(127);
				if(tempDouble != null)
					pstmt.setDouble(162,tempDouble.doubleValue());
				else
					pstmt.setNull(162,java.sql.Types.DECIMAL);
			}
			if (executeUpdate(connection, pstmt, StoreOCCQuery_0)==0)
				throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String findByContrORExternalContrNumQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ? or  q1.\"EXT_CNTR_NUMBER\" = ?) ";
	/**
	 * FindByContrORExternalContrNum
	 */
	public javax.resource.cci.Record FindByContrORExternalContrNum(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.contrNo = ?1 or o.extContractNo = ?1 */
			pstmt = prepareStatement(connection, findByContrORExternalContrNumQuery_0);

			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByContrORExternalContrNumQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByContrORExternalContrNumForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ? or  q1.\"EXT_CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByContrORExternalContrNum444Update
	 */
	public javax.resource.cci.Record FindByContrORExternalContrNum444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.contrNo = ?1 or o.extContractNo = ?1 */
			pstmt = prepareStatement(connection, findByContrORExternalContrNumForUpdateQuery_0);

			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByContrORExternalContrNumForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByContrORExternalContrNumForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ? or  q1.\"EXT_CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByContrORExternalContrNumForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByContrORExternalContrNumForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.contrNo = ?1 or o.extContractNo = ?1 */
			pstmt = prepareStatement(connection, findByContrORExternalContrNumForUpdateWithRRQuery_0);

			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByContrORExternalContrNumForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByContrORExternalContrNumForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ? or  q1.\"EXT_CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByContrORExternalContrNumForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByContrORExternalContrNumForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.contrNo = ?1 or o.extContractNo = ?1 */
			pstmt = prepareStatement(connection, findByContrORExternalContrNumForUpdateWithRSQuery_0);

			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByContrORExternalContrNumForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserGroupQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"GROUP_NAME\" = ?) ";
	/**
	 * FindByUserGroup
	 */
	public javax.resource.cci.Record FindByUserGroup(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.createdBy = ?1 and o.groupName = ?2 */
			pstmt = prepareStatement(connection, findByUserGroupQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserGroupQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserGroupForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"GROUP_NAME\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserGroup444Update
	 */
	public javax.resource.cci.Record FindByUserGroup444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.createdBy = ?1 and o.groupName = ?2 */
			pstmt = prepareStatement(connection, findByUserGroupForUpdateQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserGroupForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserGroupForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"GROUP_NAME\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserGroupForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByUserGroupForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.createdBy = ?1 and o.groupName = ?2 */
			pstmt = prepareStatement(connection, findByUserGroupForUpdateWithRRQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserGroupForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserGroupForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"GROUP_NAME\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserGroupForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByUserGroupForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.createdBy = ?1 and o.groupName = ?2 */
			pstmt = prepareStatement(connection, findByUserGroupForUpdateWithRSQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserGroupForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserForDateRangeQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"CNTR_START_DATE\" >= ?)  and  ( q1.\"CNTR_END_DATE\" <= ?) ";
	/**
	 * FindByUserForDateRange
	 */
	public javax.resource.cci.Record FindByUserForDateRange(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.createdBy = ?1 and o.contractStartDate >= ?2 and o.contractEndDate <= ?3 */
			pstmt = prepareStatement(connection, findByUserForDateRangeQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (startDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For ?3 (endDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByUserForDateRangeQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserForDateRangeForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"CNTR_START_DATE\" >= ?)  and  ( q1.\"CNTR_END_DATE\" <= ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserForDateRange444Update
	 */
	public javax.resource.cci.Record FindByUserForDateRange444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.createdBy = ?1 and o.contractStartDate >= ?2 and o.contractEndDate <= ?3 */
			pstmt = prepareStatement(connection, findByUserForDateRangeForUpdateQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (startDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For ?3 (endDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByUserForDateRangeForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserForDateRangeForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"CNTR_START_DATE\" >= ?)  and  ( q1.\"CNTR_END_DATE\" <= ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserForDateRangeForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByUserForDateRangeForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.createdBy = ?1 and o.contractStartDate >= ?2 and o.contractEndDate <= ?3 */
			pstmt = prepareStatement(connection, findByUserForDateRangeForUpdateWithRRQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (startDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For ?3 (endDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByUserForDateRangeForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserForDateRangeForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"CNTR_START_DATE\" >= ?)  and  ( q1.\"CNTR_END_DATE\" <= ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserForDateRangeForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByUserForDateRangeForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.createdBy = ?1 and o.contractStartDate >= ?2 and o.contractEndDate <= ?3 */
			pstmt = prepareStatement(connection, findByUserForDateRangeForUpdateWithRSQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (startDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For ?3 (endDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByUserForDateRangeForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByVarContractNoQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"CNTR_PERIOD_VAR_NO\" = ?) ";
	/**
	 * FindByVarContractNo
	 */
	public javax.resource.cci.Record FindByVarContractNo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.orgVarContractNo = ?1 and o.contractPeriodVarNo = ?2 */
			pstmt = prepareStatement(connection, findByVarContractNoQuery_0);

			// For ?1 (orgVarContractNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (contractPeriodVarNo)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByVarContractNoQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByVarContractNoForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"CNTR_PERIOD_VAR_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByVarContractNo444Update
	 */
	public javax.resource.cci.Record FindByVarContractNo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.orgVarContractNo = ?1 and o.contractPeriodVarNo = ?2 */
			pstmt = prepareStatement(connection, findByVarContractNoForUpdateQuery_0);

			// For ?1 (orgVarContractNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (contractPeriodVarNo)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByVarContractNoForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByVarContractNoForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"CNTR_PERIOD_VAR_NO\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByVarContractNoForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByVarContractNoForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.orgVarContractNo = ?1 and o.contractPeriodVarNo = ?2 */
			pstmt = prepareStatement(connection, findByVarContractNoForUpdateWithRRQuery_0);

			// For ?1 (orgVarContractNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (contractPeriodVarNo)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByVarContractNoForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByVarContractNoForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"CNTR_PERIOD_VAR_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByVarContractNoForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByVarContractNoForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.orgVarContractNo = ?1 and o.contractPeriodVarNo = ?2 */
			pstmt = prepareStatement(connection, findByVarContractNoForUpdateWithRSQuery_0);

			// For ?1 (orgVarContractNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (contractPeriodVarNo)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByVarContractNoForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findAllVarianceContractsQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'VC\')  order by  q1.\"PROPOSAL_ID\" asc";
	/**
	 * FindAllVarianceContracts
	 */
	public javax.resource.cci.Record FindAllVarianceContracts(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.orgVarContractNo =?1 and o.statusCode ='VC' order by  o.proposalId */
			pstmt = prepareStatement(connection, findAllVarianceContractsQuery_0);

			// For ?1 (contractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllVarianceContractsQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findAllVarianceContractsForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'VC\')  order by  q1.\"PROPOSAL_ID\" asc FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindAllVarianceContracts444Update
	 */
	public javax.resource.cci.Record FindAllVarianceContracts444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.orgVarContractNo =?1 and o.statusCode ='VC' order by  o.proposalId */
			pstmt = prepareStatement(connection, findAllVarianceContractsForUpdateQuery_0);

			// For ?1 (contractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllVarianceContractsForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findAllVarianceContractsForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'VC\')  order by  q1.\"PROPOSAL_ID\" asc FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindAllVarianceContractsForUpdateWithRR
	 */
	public javax.resource.cci.Record FindAllVarianceContractsForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.orgVarContractNo =?1 and o.statusCode ='VC' order by  o.proposalId */
			pstmt = prepareStatement(connection, findAllVarianceContractsForUpdateWithRRQuery_0);

			// For ?1 (contractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllVarianceContractsForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findAllVarianceContractsForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'VC\')  order by  q1.\"PROPOSAL_ID\" asc FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindAllVarianceContractsForUpdateWithRS
	 */
	public javax.resource.cci.Record FindAllVarianceContractsForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.orgVarContractNo =?1 and o.statusCode ='VC' order by  o.proposalId */
			pstmt = prepareStatement(connection, findAllVarianceContractsForUpdateWithRSQuery_0);

			// For ?1 (contractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllVarianceContractsForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByApproverFromGroupQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\')  and  ( q1.\"GROUP_NAME\" = ?) ";
	/**
	 * FindByApproverFromGroup
	 */
	public javax.resource.cci.Record FindByApproverFromGroup(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') and  o.groupName = ?2 */
			pstmt = prepareStatement(connection, findByApproverFromGroupQuery_0);

			// For ?1 (approverId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByApproverFromGroupQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByApproverFromGroupForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\')  and  ( q1.\"GROUP_NAME\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByApproverFromGroup444Update
	 */
	public javax.resource.cci.Record FindByApproverFromGroup444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') and  o.groupName = ?2 */
			pstmt = prepareStatement(connection, findByApproverFromGroupForUpdateQuery_0);

			// For ?1 (approverId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByApproverFromGroupForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByApproverFromGroupForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\')  and  ( q1.\"GROUP_NAME\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByApproverFromGroupForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByApproverFromGroupForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') and  o.groupName = ?2 */
			pstmt = prepareStatement(connection, findByApproverFromGroupForUpdateWithRRQuery_0);

			// For ?1 (approverId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByApproverFromGroupForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByApproverFromGroupForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\')  and  ( q1.\"GROUP_NAME\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByApproverFromGroupForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByApproverFromGroupForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') and  o.groupName = ?2 */
			pstmt = prepareStatement(connection, findByApproverFromGroupForUpdateWithRSQuery_0);

			// For ?1 (approverId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByApproverFromGroupForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findMaxContractNumberQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( substr ( q1.\"CNTR_NUMBER\", 1, 7) =  ( select  max( substr ( q2.\"CNTR_NUMBER\", 1, 7)) from BH.PROPOSAL q2) ) ";
	/**
	 * FindMaxContractNumber
	 */
	public javax.resource.cci.Record FindMaxContractNumber(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  substring(o.contrNo,1,7) =  (select max ( substring (a.contrNo,1,7) ) from Proposal a ) */
			pstmt = prepareStatement(connection, findMaxContractNumberQuery_0);

			result = executeQuery(connection, pstmt, findMaxContractNumberQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findMaxContractNumberForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( substr ( q1.\"CNTR_NUMBER\", 1, 7) =  ( select  max( substr ( q2.\"CNTR_NUMBER\", 1, 7)) from BH.PROPOSAL q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxContractNumber444Update
	 */
	public javax.resource.cci.Record FindMaxContractNumber444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  substring(o.contrNo,1,7) =  (select max ( substring (a.contrNo,1,7) ) from Proposal a ) */
			pstmt = prepareStatement(connection, findMaxContractNumberForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findMaxContractNumberForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findMaxContractNumberForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( substr ( q1.\"CNTR_NUMBER\", 1, 7) =  ( select  max( substr ( q2.\"CNTR_NUMBER\", 1, 7)) from BH.PROPOSAL q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxContractNumberForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxContractNumberForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  substring(o.contrNo,1,7) =  (select max ( substring (a.contrNo,1,7) ) from Proposal a ) */
			pstmt = prepareStatement(connection, findMaxContractNumberForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findMaxContractNumberForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findMaxContractNumberForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( substr ( q1.\"CNTR_NUMBER\", 1, 7) =  ( select  max( substr ( q2.\"CNTR_NUMBER\", 1, 7)) from BH.PROPOSAL q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxContractNumberForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxContractNumberForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  substring(o.contrNo,1,7) =  (select max ( substring (a.contrNo,1,7) ) from Proposal a ) */
			pstmt = prepareStatement(connection, findMaxContractNumberForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findMaxContractNumberForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByContractNumberQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ?) ";
	/**
	 * FindByContractNumber
	 */
	public javax.resource.cci.Record FindByContractNumber(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.contrNo = ?1 */
			pstmt = prepareStatement(connection, findByContractNumberQuery_0);

			// For ?1 (contractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByContractNumberQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByContractNumberForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByContractNumber444Update
	 */
	public javax.resource.cci.Record FindByContractNumber444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.contrNo = ?1 */
			pstmt = prepareStatement(connection, findByContractNumberForUpdateQuery_0);

			// For ?1 (contractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByContractNumberForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByContractNumberForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByContractNumberForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByContractNumberForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.contrNo = ?1 */
			pstmt = prepareStatement(connection, findByContractNumberForUpdateWithRRQuery_0);

			// For ?1 (contractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByContractNumberForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByContractNumberForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByContractNumberForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByContractNumberForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.contrNo = ?1 */
			pstmt = prepareStatement(connection, findByContractNumberForUpdateWithRSQuery_0);

			// For ?1 (contractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByContractNumberForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\') ";
	/**
	 * FindByWaitingForApproval
	 */
	public javax.resource.cci.Record FindByWaitingForApproval(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') */
			pstmt = prepareStatement(connection, findByWaitingForApprovalQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\')  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByWaitingForApproval444Update
	 */
	public javax.resource.cci.Record FindByWaitingForApproval444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForUpdateQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\')  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByWaitingForApprovalForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByWaitingForApprovalForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForUpdateWithRRQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\')  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByWaitingForApprovalForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByWaitingForApprovalForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForUpdateWithRSQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForProposalApproverQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\') ";
	/**
	 * FindByWaitingForApprovalForProposalApprover
	 */
	public javax.resource.cci.Record FindByWaitingForApprovalForProposalApprover(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForProposalApproverQuery_0);

			// For ?1 (approver)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForProposalApproverQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForProposalApproverForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\')  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByWaitingForApprovalForProposalApprover444Update
	 */
	public javax.resource.cci.Record FindByWaitingForApprovalForProposalApprover444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForProposalApproverForUpdateQuery_0);

			// For ?1 (approver)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForProposalApproverForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForProposalApproverForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\')  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByWaitingForApprovalForProposalApproverForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByWaitingForApprovalForProposalApproverForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForProposalApproverForUpdateWithRRQuery_0);

			// For ?1 (approver)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForProposalApproverForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForProposalApproverForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\')  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByWaitingForApprovalForProposalApproverForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByWaitingForApprovalForProposalApproverForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA') */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForProposalApproverForUpdateWithRSQuery_0);

			// For ?1 (approver)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForProposalApproverForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByLockedByQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"LOCKED_BY\" = ?) ";
	/**
	 * FindByLockedBy
	 */
	public javax.resource.cci.Record FindByLockedBy(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.lockedBy=?1 */
			pstmt = prepareStatement(connection, findByLockedByQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByLockedByQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByLockedByForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"LOCKED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByLockedBy444Update
	 */
	public javax.resource.cci.Record FindByLockedBy444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.lockedBy=?1 */
			pstmt = prepareStatement(connection, findByLockedByForUpdateQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByLockedByForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByLockedByForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"LOCKED_BY\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByLockedByForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByLockedByForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.lockedBy=?1 */
			pstmt = prepareStatement(connection, findByLockedByForUpdateWithRRQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByLockedByForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByLockedByForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"LOCKED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByLockedByForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByLockedByForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.lockedBy=?1 */
			pstmt = prepareStatement(connection, findByLockedByForUpdateWithRSQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByLockedByForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserAndSalesOrgQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"LOCKED_BY\" = ?) ";
	/**
	 * FindByUserAndSalesOrg
	 */
	public javax.resource.cci.Record FindByUserAndSalesOrg(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.lockedBy=?1 */
			pstmt = prepareStatement(connection, findByUserAndSalesOrgQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserAndSalesOrgQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserAndSalesOrgForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"LOCKED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserAndSalesOrg444Update
	 */
	public javax.resource.cci.Record FindByUserAndSalesOrg444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.lockedBy=?1 */
			pstmt = prepareStatement(connection, findByUserAndSalesOrgForUpdateQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserAndSalesOrgForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserAndSalesOrgForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"LOCKED_BY\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserAndSalesOrgForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByUserAndSalesOrgForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.lockedBy=?1 */
			pstmt = prepareStatement(connection, findByUserAndSalesOrgForUpdateWithRRQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserAndSalesOrgForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserAndSalesOrgForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"LOCKED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserAndSalesOrgForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByUserAndSalesOrgForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.lockedBy=?1 */
			pstmt = prepareStatement(connection, findByUserAndSalesOrgForUpdateWithRSQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserAndSalesOrgForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findRelatedVarianceProposalQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'D1\' or  q1.\"STATUS_CODE\" = \'D2\' or  q1.\"STATUS_CODE\" = \'P\' or  q1.\"STATUS_CODE\" = \'VR\' or  q1.\"STATUS_CODE\" = \'PA\') ";
	/**
	 * FindRelatedVarianceProposal
	 */
	public javax.resource.cci.Record FindRelatedVarianceProposal(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o  where o.orgVarContractNo = ?1 and o.statusCode  in('D1','D2','P','VR','PA') */
			pstmt = prepareStatement(connection, findRelatedVarianceProposalQuery_0);

			// For ?1 (orgVarianceContractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findRelatedVarianceProposalQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findRelatedVarianceProposalForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'D1\' or  q1.\"STATUS_CODE\" = \'D2\' or  q1.\"STATUS_CODE\" = \'P\' or  q1.\"STATUS_CODE\" = \'VR\' or  q1.\"STATUS_CODE\" = \'PA\')  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindRelatedVarianceProposal444Update
	 */
	public javax.resource.cci.Record FindRelatedVarianceProposal444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o  where o.orgVarContractNo = ?1 and o.statusCode  in('D1','D2','P','VR','PA') */
			pstmt = prepareStatement(connection, findRelatedVarianceProposalForUpdateQuery_0);

			// For ?1 (orgVarianceContractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findRelatedVarianceProposalForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findRelatedVarianceProposalForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'D1\' or  q1.\"STATUS_CODE\" = \'D2\' or  q1.\"STATUS_CODE\" = \'P\' or  q1.\"STATUS_CODE\" = \'VR\' or  q1.\"STATUS_CODE\" = \'PA\')  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindRelatedVarianceProposalForUpdateWithRR
	 */
	public javax.resource.cci.Record FindRelatedVarianceProposalForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o  where o.orgVarContractNo = ?1 and o.statusCode  in('D1','D2','P','VR','PA') */
			pstmt = prepareStatement(connection, findRelatedVarianceProposalForUpdateWithRRQuery_0);

			// For ?1 (orgVarianceContractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findRelatedVarianceProposalForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findRelatedVarianceProposalForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"ORG_VAR_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'D1\' or  q1.\"STATUS_CODE\" = \'D2\' or  q1.\"STATUS_CODE\" = \'P\' or  q1.\"STATUS_CODE\" = \'VR\' or  q1.\"STATUS_CODE\" = \'PA\')  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindRelatedVarianceProposalForUpdateWithRS
	 */
	public javax.resource.cci.Record FindRelatedVarianceProposalForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o  where o.orgVarContractNo = ?1 and o.statusCode  in('D1','D2','P','VR','PA') */
			pstmt = prepareStatement(connection, findRelatedVarianceProposalForUpdateWithRSQuery_0);

			// For ?1 (orgVarianceContractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findRelatedVarianceProposalForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByApproverQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?) ";
	/**
	 * FindByApprover
	 */
	public javax.resource.cci.Record FindByApprover(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.approvedBy=?1 */
			pstmt = prepareStatement(connection, findByApproverQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByApproverQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByApproverForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByApprover444Update
	 */
	public javax.resource.cci.Record FindByApprover444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.approvedBy=?1 */
			pstmt = prepareStatement(connection, findByApproverForUpdateQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByApproverForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByApproverForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByApproverForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByApproverForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.approvedBy=?1 */
			pstmt = prepareStatement(connection, findByApproverForUpdateWithRRQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByApproverForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByApproverForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"APPROVED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByApproverForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByApproverForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.approvedBy=?1 */
			pstmt = prepareStatement(connection, findByApproverForUpdateWithRSQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByApproverForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForCreateApproveQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( ( q1.\"APPROVED_BY\" = ? and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\') )  or  q1.\"CREATED_BY\" = ?) ";
	/**
	 * FindByWaitingForApprovalForCreateApprove
	 */
	public javax.resource.cci.Record FindByWaitingForApprovalForCreateApprove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where (o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA')) or o.createdBy=?1 */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForCreateApproveQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForCreateApproveQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForCreateApproveForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( ( q1.\"APPROVED_BY\" = ? and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\') )  or  q1.\"CREATED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByWaitingForApprovalForCreateApprove444Update
	 */
	public javax.resource.cci.Record FindByWaitingForApprovalForCreateApprove444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where (o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA')) or o.createdBy=?1 */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForCreateApproveForUpdateQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForCreateApproveForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForCreateApproveForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( ( q1.\"APPROVED_BY\" = ? and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\') )  or  q1.\"CREATED_BY\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByWaitingForApprovalForCreateApproveForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByWaitingForApprovalForCreateApproveForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where (o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA')) or o.createdBy=?1 */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForCreateApproveForUpdateWithRRQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForCreateApproveForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByWaitingForApprovalForCreateApproveForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( ( q1.\"APPROVED_BY\" = ? and  ( q1.\"STATUS_CODE\" = \'PA\' or  q1.\"STATUS_CODE\" = \'EA\' or  q1.\"STATUS_CODE\" = \'AA\' or  q1.\"STATUS_CODE\" = \'VA\') )  or  q1.\"CREATED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByWaitingForApprovalForCreateApproveForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByWaitingForApprovalForCreateApproveForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where (o.approvedBy=?1 and o.statusCode in ('PA','EA','AA','VA')) or o.createdBy=?1 */
			pstmt = prepareStatement(connection, findByWaitingForApprovalForCreateApproveForUpdateWithRSQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByWaitingForApprovalForCreateApproveForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findRelatedProposalForContractQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"OLD_CNTR_NUMBER\" = ?) ";
	/**
	 * FindRelatedProposalForContract
	 */
	public javax.resource.cci.Record FindRelatedProposalForContract(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.oldContractNo = ?1 */
			pstmt = prepareStatement(connection, findRelatedProposalForContractQuery_0);

			// For ?1 (oldContractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findRelatedProposalForContractQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findRelatedProposalForContractForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"OLD_CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindRelatedProposalForContract444Update
	 */
	public javax.resource.cci.Record FindRelatedProposalForContract444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.oldContractNo = ?1 */
			pstmt = prepareStatement(connection, findRelatedProposalForContractForUpdateQuery_0);

			// For ?1 (oldContractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findRelatedProposalForContractForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findRelatedProposalForContractForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"OLD_CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindRelatedProposalForContractForUpdateWithRR
	 */
	public javax.resource.cci.Record FindRelatedProposalForContractForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.oldContractNo = ?1 */
			pstmt = prepareStatement(connection, findRelatedProposalForContractForUpdateWithRRQuery_0);

			// For ?1 (oldContractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findRelatedProposalForContractForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findRelatedProposalForContractForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"OLD_CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindRelatedProposalForContractForUpdateWithRS
	 */
	public javax.resource.cci.Record FindRelatedProposalForContractForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.oldContractNo = ?1 */
			pstmt = prepareStatement(connection, findRelatedProposalForContractForUpdateWithRSQuery_0);

			// For ?1 (oldContractNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findRelatedProposalForContractForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByDateRangeForGroupQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"GROUP_NAME\" = ?)  and  ( q1.\"CNTR_START_DATE\" >= ?)  and  ( q1.\"CNTR_END_DATE\" <= ?) ";
	/**
	 * FindByDateRangeForGroup
	 */
	public javax.resource.cci.Record FindByDateRangeForGroup(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.createdBy = ?1 and o.groupName = ?2 and o.contractStartDate >= ?3 and o.contractEndDate <= ?4 */
			pstmt = prepareStatement(connection, findByDateRangeForGroupQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (startDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For ?4 (endDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByDateRangeForGroupQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByDateRangeForGroupForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"GROUP_NAME\" = ?)  and  ( q1.\"CNTR_START_DATE\" >= ?)  and  ( q1.\"CNTR_END_DATE\" <= ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByDateRangeForGroup444Update
	 */
	public javax.resource.cci.Record FindByDateRangeForGroup444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.createdBy = ?1 and o.groupName = ?2 and o.contractStartDate >= ?3 and o.contractEndDate <= ?4 */
			pstmt = prepareStatement(connection, findByDateRangeForGroupForUpdateQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (startDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For ?4 (endDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByDateRangeForGroupForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByDateRangeForGroupForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"GROUP_NAME\" = ?)  and  ( q1.\"CNTR_START_DATE\" >= ?)  and  ( q1.\"CNTR_END_DATE\" <= ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByDateRangeForGroupForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByDateRangeForGroupForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.createdBy = ?1 and o.groupName = ?2 and o.contractStartDate >= ?3 and o.contractEndDate <= ?4 */
			pstmt = prepareStatement(connection, findByDateRangeForGroupForUpdateWithRRQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (startDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For ?4 (endDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByDateRangeForGroupForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByDateRangeForGroupForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  and  ( q1.\"GROUP_NAME\" = ?)  and  ( q1.\"CNTR_START_DATE\" >= ?)  and  ( q1.\"CNTR_END_DATE\" <= ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByDateRangeForGroupForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByDateRangeForGroupForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.createdBy = ?1 and o.groupName = ?2 and o.contractStartDate >= ?3 and o.contractEndDate <= ?4 */
			pstmt = prepareStatement(connection, findByDateRangeForGroupForUpdateWithRSQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (startDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For ?4 (endDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByDateRangeForGroupForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?) ";
	/**
	 * FindByUser
	 */
	public javax.resource.cci.Record FindByUser(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.createdBy=?1 */
			pstmt = prepareStatement(connection, findByUserQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUser444Update
	 */
	public javax.resource.cci.Record FindByUser444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.createdBy=?1 */
			pstmt = prepareStatement(connection, findByUserForUpdateQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByUserForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.createdBy=?1 */
			pstmt = prepareStatement(connection, findByUserForUpdateWithRRQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByUserForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByUserForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByUserForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o)  from Proposal o where o.createdBy=?1 */
			pstmt = prepareStatement(connection, findByUserForUpdateWithRSQuery_0);

			// For ?1 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByUserForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByNameQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"PROPOSAL_NAME\" = ?) ";
	/**
	 * FindByName
	 */
	public javax.resource.cci.Record FindByName(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.proposalName = ?1 */
			pstmt = prepareStatement(connection, findByNameQuery_0);

			// For ?1 (proposalName)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByNameQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByNameForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"PROPOSAL_NAME\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByName444Update
	 */
	public javax.resource.cci.Record FindByName444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.proposalName = ?1 */
			pstmt = prepareStatement(connection, findByNameForUpdateQuery_0);

			// For ?1 (proposalName)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByNameForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByNameForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"PROPOSAL_NAME\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByNameForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByNameForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.proposalName = ?1 */
			pstmt = prepareStatement(connection, findByNameForUpdateWithRRQuery_0);

			// For ?1 (proposalName)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByNameForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByNameForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"PROPOSAL_NAME\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByNameForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByNameForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.proposalName = ?1 */
			pstmt = prepareStatement(connection, findByNameForUpdateWithRSQuery_0);

			// For ?1 (proposalName)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByNameForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByCntrNumberORExternalCntrNumAndStatusQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ? or  q1.\"EXT_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'C\' or  q1.\"STATUS_CODE\" = \'EX\') ";
	/**
	 * FindByCntrNumberORExternalCntrNumAndStatus
	 */
	public javax.resource.cci.Record FindByCntrNumberORExternalCntrNumAndStatus(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where (o.contrNo = ?1 or o.extContractNo = ?1) and o.statusCode in ('C','EX') */
			pstmt = prepareStatement(connection, findByCntrNumberORExternalCntrNumAndStatusQuery_0);

			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCntrNumberORExternalCntrNumAndStatusQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByCntrNumberORExternalCntrNumAndStatusForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ? or  q1.\"EXT_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'C\' or  q1.\"STATUS_CODE\" = \'EX\')  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCntrNumberORExternalCntrNumAndStatus444Update
	 */
	public javax.resource.cci.Record FindByCntrNumberORExternalCntrNumAndStatus444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where (o.contrNo = ?1 or o.extContractNo = ?1) and o.statusCode in ('C','EX') */
			pstmt = prepareStatement(connection, findByCntrNumberORExternalCntrNumAndStatusForUpdateQuery_0);

			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCntrNumberORExternalCntrNumAndStatusForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByCntrNumberORExternalCntrNumAndStatusForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ? or  q1.\"EXT_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'C\' or  q1.\"STATUS_CODE\" = \'EX\')  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCntrNumberORExternalCntrNumAndStatusForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByCntrNumberORExternalCntrNumAndStatusForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where (o.contrNo = ?1 or o.extContractNo = ?1) and o.statusCode in ('C','EX') */
			pstmt = prepareStatement(connection, findByCntrNumberORExternalCntrNumAndStatusForUpdateWithRRQuery_0);

			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCntrNumberORExternalCntrNumAndStatusForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByCntrNumberORExternalCntrNumAndStatusForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CNTR_NUMBER\" = ? or  q1.\"EXT_CNTR_NUMBER\" = ?)  and  ( q1.\"STATUS_CODE\" = \'C\' or  q1.\"STATUS_CODE\" = \'EX\')  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCntrNumberORExternalCntrNumAndStatusForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByCntrNumberORExternalCntrNumAndStatusForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where (o.contrNo = ?1 or o.extContractNo = ?1) and o.statusCode in ('C','EX') */
			pstmt = prepareStatement(connection, findByCntrNumberORExternalCntrNumAndStatusForUpdateWithRSQuery_0);

			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?1 (cntrNum)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCntrNumberORExternalCntrNumAndStatusForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.ADD_VALUE_DAYS, T1.ADVANCE_BILLING, T1.AMDT_IND, T1.AMDT_EFFC_DATE, T1.APPROVED_BY, T1.PROPOSAL_ID, T1.PROPOSAL_TYPE, T1.BILLING_FREQ_CODE, T1.CREATED_BY, T1.STATUS_CODE, T1.SALES_ORG, T1.DSTR_CHANNEL, T1.DIVISION_CODE, T1.PROPOSAL_NAME, T1.CNTR_START_DATE, T1.CNTR_END_DATE, T1.CNTR_START_PERIOD, T1.CNTR_END_PERIOD, T1.TVM_RATE, T1.GROWTH_FACTOR, T1.SPECIAL_RATE, T1.INVOICE_AMOUNT, T1.DATE_PRICED, T1.COMMENTS, T1.CREATED_DATE, T1.APPROVED_DATE, T1.DELETED_IND, T1.REG_SOLD_TO_P_NO, T1.REG_SOLD_TO_P_NAME, T1.REG_BILL_TO_P_NO, T1.REG_BILL_TO_P_NAME, T1.REG_PAYER_NO, T1.REG_PAYER_NAME, T1.REG_SHIP_TO_P_NO, T1.REG_SHIP_TO_P_NAME, T1.CURRENCY, T1.LAST_UPDATE_DATE, T1.RE_FETCH_ID, T1.FETCH_DATE, T1.DELTA_FETCH_ID, T1.CNTR_TYPE, T1.REPORT_NAME, T1.CAP_AMOUNT, T1.CAP_PLUS, T1.CAP_MINUS, T1.PRE_TVM, T1.CNTR_EXTN_DATE, T1.CNTR_RETR_DATE, T1.CNTR_REPL_DATE, T1.CNTR_CLS_DATE, T1.CNTR_NUMBER, T1.CNTR_AMDT_NO, T1.REG_SOLD_TO_P_LNO, T1.REG_BILL_TO_P_LNO, T1.REG_PAYER_LNO, T1.REG_SHIP_TO_P_LNO, T1.INVOICE_AMOUNT_SEM, T1.INVOICE_AMOUNT_ANN, T1.INVOICE_AMOUNT_MON, T1.INVOICE_AMOUNT_QRT, T1.OLD_CNTR_NUMBER, T1.PRE_TVM_INV_AMT, T1.PROPOSAL_SHARING, T1.EXT_CNTR_NUMBER, T1.CNTR_CREATE_FLAG, T1.PAK_ID, T1.BILLING_TYPE, T1.PAYMENT_TERM, T1.FIXED_VAL_DATE, T1.TP_CNTR_NUMBER, T1.INELIGIBLE_IND, T1.INVOICE_IND, T1.AUTOPOPULATE_IND, T1.CCI_IND, T1.PREBILL_INDICATOR, T1.BLB_INDICATOR, T1.CONTRACT_TYPE, T1.OCPS, T1.CPS, T1.S_S_DISCOUNT_AMOUNT5, T1.S_S_DISCOUNT_AMOUNT4, T1.S_S_DISCOUNT_AMOUNT3, T1.S_S_DISCOUNT_AMOUNT2, T1.S_S_DISCOUNT_AMOUNT1, T1.S_S_ANNV_AMOUNT5, T1.S_S_ANNV_AMOUNT4, T1.S_S_ANNV_AMOUNT3, T1.S_S_ANNV_AMOUNT2, T1.S_S_EXTEND_CNTR_IND, T1.GROUP_NAME, T1.SUBMITTED_BY, T1.PROPOSAL_CONTENT, T1.S_S_DISCOUNT_SUM, T1.S_S_ANNV_AMOUNT, T1.REG_9D_PARTNER_NO, T1.REG_9D_PARTNER_NAME, T1.CUM_VALUE, T1.CAP_VARIANCE, T1.ORG_VAR_CNTR_NUMBER, T1.VAR_DATE, T1.VAR_IND, T1.REG_SOLD_TO_P_ASNO, T1.REG_BILL_TO_P_ASNO, T1.REG_PAYER_ASNO, T1.REG_SHIP_TO_P_ASNO, T1.SUPPRESS_INVOICE, T1.ESW_FETCH_DATE, T1.ESW_FETCH_TIME, T1.GSA_IND, T1.FREE_TEXT, T1.LOCKED_BY, T1.LOCKED_ON, T1.PO_NUMBER, T1.PO_DATE, T1.ANNV_AMOUNT, T1.CNTR_NEWRENEW_NO, T1.BILLING_BLOCK, T1.CNTR_PERIOD_VAR_NO, T1.CNTR_VAR_NO, T1.DEVIATING_DATE_RULE, T1.S_S_EXCLUDED, T1.CNTR_REPL_NO, T1.FIN_CNTR_NO, T1.SALES_GROUP, T1.CHANNEL_ROLE, T1.SUBMITTER_ROLE, T1.PAYMENTMETHOD, T1.DISCOUNT FROM BH.PROPOSAL  T1 WHERE T1.PROPOSAL_ID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, FindByPrimaryKeyQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.ADD_VALUE_DAYS, T1.ADVANCE_BILLING, T1.AMDT_IND, T1.AMDT_EFFC_DATE, T1.APPROVED_BY, T1.PROPOSAL_ID, T1.PROPOSAL_TYPE, T1.BILLING_FREQ_CODE, T1.CREATED_BY, T1.STATUS_CODE, T1.SALES_ORG, T1.DSTR_CHANNEL, T1.DIVISION_CODE, T1.PROPOSAL_NAME, T1.CNTR_START_DATE, T1.CNTR_END_DATE, T1.CNTR_START_PERIOD, T1.CNTR_END_PERIOD, T1.TVM_RATE, T1.GROWTH_FACTOR, T1.SPECIAL_RATE, T1.INVOICE_AMOUNT, T1.DATE_PRICED, T1.COMMENTS, T1.CREATED_DATE, T1.APPROVED_DATE, T1.DELETED_IND, T1.REG_SOLD_TO_P_NO, T1.REG_SOLD_TO_P_NAME, T1.REG_BILL_TO_P_NO, T1.REG_BILL_TO_P_NAME, T1.REG_PAYER_NO, T1.REG_PAYER_NAME, T1.REG_SHIP_TO_P_NO, T1.REG_SHIP_TO_P_NAME, T1.CURRENCY, T1.LAST_UPDATE_DATE, T1.RE_FETCH_ID, T1.FETCH_DATE, T1.DELTA_FETCH_ID, T1.CNTR_TYPE, T1.REPORT_NAME, T1.CAP_AMOUNT, T1.CAP_PLUS, T1.CAP_MINUS, T1.PRE_TVM, T1.CNTR_EXTN_DATE, T1.CNTR_RETR_DATE, T1.CNTR_REPL_DATE, T1.CNTR_CLS_DATE, T1.CNTR_NUMBER, T1.CNTR_AMDT_NO, T1.REG_SOLD_TO_P_LNO, T1.REG_BILL_TO_P_LNO, T1.REG_PAYER_LNO, T1.REG_SHIP_TO_P_LNO, T1.INVOICE_AMOUNT_SEM, T1.INVOICE_AMOUNT_ANN, T1.INVOICE_AMOUNT_MON, T1.INVOICE_AMOUNT_QRT, T1.OLD_CNTR_NUMBER, T1.PRE_TVM_INV_AMT, T1.PROPOSAL_SHARING, T1.EXT_CNTR_NUMBER, T1.CNTR_CREATE_FLAG, T1.PAK_ID, T1.BILLING_TYPE, T1.PAYMENT_TERM, T1.FIXED_VAL_DATE, T1.TP_CNTR_NUMBER, T1.INELIGIBLE_IND, T1.INVOICE_IND, T1.AUTOPOPULATE_IND, T1.CCI_IND, T1.PREBILL_INDICATOR, T1.BLB_INDICATOR, T1.CONTRACT_TYPE, T1.OCPS, T1.CPS, T1.S_S_DISCOUNT_AMOUNT5, T1.S_S_DISCOUNT_AMOUNT4, T1.S_S_DISCOUNT_AMOUNT3, T1.S_S_DISCOUNT_AMOUNT2, T1.S_S_DISCOUNT_AMOUNT1, T1.S_S_ANNV_AMOUNT5, T1.S_S_ANNV_AMOUNT4, T1.S_S_ANNV_AMOUNT3, T1.S_S_ANNV_AMOUNT2, T1.S_S_EXTEND_CNTR_IND, T1.GROUP_NAME, T1.SUBMITTED_BY, T1.PROPOSAL_CONTENT, T1.S_S_DISCOUNT_SUM, T1.S_S_ANNV_AMOUNT, T1.REG_9D_PARTNER_NO, T1.REG_9D_PARTNER_NAME, T1.CUM_VALUE, T1.CAP_VARIANCE, T1.ORG_VAR_CNTR_NUMBER, T1.VAR_DATE, T1.VAR_IND, T1.REG_SOLD_TO_P_ASNO, T1.REG_BILL_TO_P_ASNO, T1.REG_PAYER_ASNO, T1.REG_SHIP_TO_P_ASNO, T1.SUPPRESS_INVOICE, T1.ESW_FETCH_DATE, T1.ESW_FETCH_TIME, T1.GSA_IND, T1.FREE_TEXT, T1.LOCKED_BY, T1.LOCKED_ON, T1.PO_NUMBER, T1.PO_DATE, T1.ANNV_AMOUNT, T1.CNTR_NEWRENEW_NO, T1.BILLING_BLOCK, T1.CNTR_PERIOD_VAR_NO, T1.CNTR_VAR_NO, T1.DEVIATING_DATE_RULE, T1.S_S_EXCLUDED, T1.CNTR_REPL_NO, T1.FIN_CNTR_NO, T1.SALES_GROUP, T1.CHANNEL_ROLE, T1.SUBMITTER_ROLE, T1.PAYMENTMETHOD, T1.DISCOUNT FROM BH.PROPOSAL  T1 WHERE T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, FindByPrimaryKeyForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.ADD_VALUE_DAYS, T1.ADVANCE_BILLING, T1.AMDT_IND, T1.AMDT_EFFC_DATE, T1.APPROVED_BY, T1.PROPOSAL_ID, T1.PROPOSAL_TYPE, T1.BILLING_FREQ_CODE, T1.CREATED_BY, T1.STATUS_CODE, T1.SALES_ORG, T1.DSTR_CHANNEL, T1.DIVISION_CODE, T1.PROPOSAL_NAME, T1.CNTR_START_DATE, T1.CNTR_END_DATE, T1.CNTR_START_PERIOD, T1.CNTR_END_PERIOD, T1.TVM_RATE, T1.GROWTH_FACTOR, T1.SPECIAL_RATE, T1.INVOICE_AMOUNT, T1.DATE_PRICED, T1.COMMENTS, T1.CREATED_DATE, T1.APPROVED_DATE, T1.DELETED_IND, T1.REG_SOLD_TO_P_NO, T1.REG_SOLD_TO_P_NAME, T1.REG_BILL_TO_P_NO, T1.REG_BILL_TO_P_NAME, T1.REG_PAYER_NO, T1.REG_PAYER_NAME, T1.REG_SHIP_TO_P_NO, T1.REG_SHIP_TO_P_NAME, T1.CURRENCY, T1.LAST_UPDATE_DATE, T1.RE_FETCH_ID, T1.FETCH_DATE, T1.DELTA_FETCH_ID, T1.CNTR_TYPE, T1.REPORT_NAME, T1.CAP_AMOUNT, T1.CAP_PLUS, T1.CAP_MINUS, T1.PRE_TVM, T1.CNTR_EXTN_DATE, T1.CNTR_RETR_DATE, T1.CNTR_REPL_DATE, T1.CNTR_CLS_DATE, T1.CNTR_NUMBER, T1.CNTR_AMDT_NO, T1.REG_SOLD_TO_P_LNO, T1.REG_BILL_TO_P_LNO, T1.REG_PAYER_LNO, T1.REG_SHIP_TO_P_LNO, T1.INVOICE_AMOUNT_SEM, T1.INVOICE_AMOUNT_ANN, T1.INVOICE_AMOUNT_MON, T1.INVOICE_AMOUNT_QRT, T1.OLD_CNTR_NUMBER, T1.PRE_TVM_INV_AMT, T1.PROPOSAL_SHARING, T1.EXT_CNTR_NUMBER, T1.CNTR_CREATE_FLAG, T1.PAK_ID, T1.BILLING_TYPE, T1.PAYMENT_TERM, T1.FIXED_VAL_DATE, T1.TP_CNTR_NUMBER, T1.INELIGIBLE_IND, T1.INVOICE_IND, T1.AUTOPOPULATE_IND, T1.CCI_IND, T1.PREBILL_INDICATOR, T1.BLB_INDICATOR, T1.CONTRACT_TYPE, T1.OCPS, T1.CPS, T1.S_S_DISCOUNT_AMOUNT5, T1.S_S_DISCOUNT_AMOUNT4, T1.S_S_DISCOUNT_AMOUNT3, T1.S_S_DISCOUNT_AMOUNT2, T1.S_S_DISCOUNT_AMOUNT1, T1.S_S_ANNV_AMOUNT5, T1.S_S_ANNV_AMOUNT4, T1.S_S_ANNV_AMOUNT3, T1.S_S_ANNV_AMOUNT2, T1.S_S_EXTEND_CNTR_IND, T1.GROUP_NAME, T1.SUBMITTED_BY, T1.PROPOSAL_CONTENT, T1.S_S_DISCOUNT_SUM, T1.S_S_ANNV_AMOUNT, T1.REG_9D_PARTNER_NO, T1.REG_9D_PARTNER_NAME, T1.CUM_VALUE, T1.CAP_VARIANCE, T1.ORG_VAR_CNTR_NUMBER, T1.VAR_DATE, T1.VAR_IND, T1.REG_SOLD_TO_P_ASNO, T1.REG_BILL_TO_P_ASNO, T1.REG_PAYER_ASNO, T1.REG_SHIP_TO_P_ASNO, T1.SUPPRESS_INVOICE, T1.ESW_FETCH_DATE, T1.ESW_FETCH_TIME, T1.GSA_IND, T1.FREE_TEXT, T1.LOCKED_BY, T1.LOCKED_ON, T1.PO_NUMBER, T1.PO_DATE, T1.ANNV_AMOUNT, T1.CNTR_NEWRENEW_NO, T1.BILLING_BLOCK, T1.CNTR_PERIOD_VAR_NO, T1.CNTR_VAR_NO, T1.DEVIATING_DATE_RULE, T1.S_S_EXCLUDED, T1.CNTR_REPL_NO, T1.FIN_CNTR_NO, T1.SALES_GROUP, T1.CHANNEL_ROLE, T1.SUBMITTER_ROLE, T1.PAYMENTMETHOD, T1.DISCOUNT FROM BH.PROPOSAL  T1 WHERE T1.PROPOSAL_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, FindByPrimaryKeyForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.ADD_VALUE_DAYS, T1.ADVANCE_BILLING, T1.AMDT_IND, T1.AMDT_EFFC_DATE, T1.APPROVED_BY, T1.PROPOSAL_ID, T1.PROPOSAL_TYPE, T1.BILLING_FREQ_CODE, T1.CREATED_BY, T1.STATUS_CODE, T1.SALES_ORG, T1.DSTR_CHANNEL, T1.DIVISION_CODE, T1.PROPOSAL_NAME, T1.CNTR_START_DATE, T1.CNTR_END_DATE, T1.CNTR_START_PERIOD, T1.CNTR_END_PERIOD, T1.TVM_RATE, T1.GROWTH_FACTOR, T1.SPECIAL_RATE, T1.INVOICE_AMOUNT, T1.DATE_PRICED, T1.COMMENTS, T1.CREATED_DATE, T1.APPROVED_DATE, T1.DELETED_IND, T1.REG_SOLD_TO_P_NO, T1.REG_SOLD_TO_P_NAME, T1.REG_BILL_TO_P_NO, T1.REG_BILL_TO_P_NAME, T1.REG_PAYER_NO, T1.REG_PAYER_NAME, T1.REG_SHIP_TO_P_NO, T1.REG_SHIP_TO_P_NAME, T1.CURRENCY, T1.LAST_UPDATE_DATE, T1.RE_FETCH_ID, T1.FETCH_DATE, T1.DELTA_FETCH_ID, T1.CNTR_TYPE, T1.REPORT_NAME, T1.CAP_AMOUNT, T1.CAP_PLUS, T1.CAP_MINUS, T1.PRE_TVM, T1.CNTR_EXTN_DATE, T1.CNTR_RETR_DATE, T1.CNTR_REPL_DATE, T1.CNTR_CLS_DATE, T1.CNTR_NUMBER, T1.CNTR_AMDT_NO, T1.REG_SOLD_TO_P_LNO, T1.REG_BILL_TO_P_LNO, T1.REG_PAYER_LNO, T1.REG_SHIP_TO_P_LNO, T1.INVOICE_AMOUNT_SEM, T1.INVOICE_AMOUNT_ANN, T1.INVOICE_AMOUNT_MON, T1.INVOICE_AMOUNT_QRT, T1.OLD_CNTR_NUMBER, T1.PRE_TVM_INV_AMT, T1.PROPOSAL_SHARING, T1.EXT_CNTR_NUMBER, T1.CNTR_CREATE_FLAG, T1.PAK_ID, T1.BILLING_TYPE, T1.PAYMENT_TERM, T1.FIXED_VAL_DATE, T1.TP_CNTR_NUMBER, T1.INELIGIBLE_IND, T1.INVOICE_IND, T1.AUTOPOPULATE_IND, T1.CCI_IND, T1.PREBILL_INDICATOR, T1.BLB_INDICATOR, T1.CONTRACT_TYPE, T1.OCPS, T1.CPS, T1.S_S_DISCOUNT_AMOUNT5, T1.S_S_DISCOUNT_AMOUNT4, T1.S_S_DISCOUNT_AMOUNT3, T1.S_S_DISCOUNT_AMOUNT2, T1.S_S_DISCOUNT_AMOUNT1, T1.S_S_ANNV_AMOUNT5, T1.S_S_ANNV_AMOUNT4, T1.S_S_ANNV_AMOUNT3, T1.S_S_ANNV_AMOUNT2, T1.S_S_EXTEND_CNTR_IND, T1.GROUP_NAME, T1.SUBMITTED_BY, T1.PROPOSAL_CONTENT, T1.S_S_DISCOUNT_SUM, T1.S_S_ANNV_AMOUNT, T1.REG_9D_PARTNER_NO, T1.REG_9D_PARTNER_NAME, T1.CUM_VALUE, T1.CAP_VARIANCE, T1.ORG_VAR_CNTR_NUMBER, T1.VAR_DATE, T1.VAR_IND, T1.REG_SOLD_TO_P_ASNO, T1.REG_BILL_TO_P_ASNO, T1.REG_PAYER_ASNO, T1.REG_SHIP_TO_P_ASNO, T1.SUPPRESS_INVOICE, T1.ESW_FETCH_DATE, T1.ESW_FETCH_TIME, T1.GSA_IND, T1.FREE_TEXT, T1.LOCKED_BY, T1.LOCKED_ON, T1.PO_NUMBER, T1.PO_DATE, T1.ANNV_AMOUNT, T1.CNTR_NEWRENEW_NO, T1.BILLING_BLOCK, T1.CNTR_PERIOD_VAR_NO, T1.CNTR_VAR_NO, T1.DEVIATING_DATE_RULE, T1.S_S_EXCLUDED, T1.CNTR_REPL_NO, T1.FIN_CNTR_NO, T1.SALES_GROUP, T1.CHANNEL_ROLE, T1.SUBMITTER_ROLE, T1.PAYMENTMETHOD, T1.DISCOUNT FROM BH.PROPOSAL  T1 WHERE T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, FindByPrimaryKeyForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findMaxProposalIdQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"PROPOSAL_ID\" =  ( select  max( q2.\"PROPOSAL_ID\") from BH.PROPOSAL q2) ) ";
	/**
	 * FindMaxProposalId
	 */
	public javax.resource.cci.Record FindMaxProposalId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.proposalId = (select max(a.proposalId) from Proposal a) */
			pstmt = prepareStatement(connection, findMaxProposalIdQuery_0);

			result = executeQuery(connection, pstmt, findMaxProposalIdQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findMaxProposalIdForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"PROPOSAL_ID\" =  ( select  max( q2.\"PROPOSAL_ID\") from BH.PROPOSAL q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxProposalId444Update
	 */
	public javax.resource.cci.Record FindMaxProposalId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.proposalId = (select max(a.proposalId) from Proposal a) */
			pstmt = prepareStatement(connection, findMaxProposalIdForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findMaxProposalIdForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findMaxProposalIdForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"PROPOSAL_ID\" =  ( select  max( q2.\"PROPOSAL_ID\") from BH.PROPOSAL q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxProposalIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxProposalIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.proposalId = (select max(a.proposalId) from Proposal a) */
			pstmt = prepareStatement(connection, findMaxProposalIdForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findMaxProposalIdForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findMaxProposalIdForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"PROPOSAL_ID\" =  ( select  max( q2.\"PROPOSAL_ID\") from BH.PROPOSAL q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxProposalIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxProposalIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.proposalId = (select max(a.proposalId) from Proposal a) */
			pstmt = prepareStatement(connection, findMaxProposalIdForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findMaxProposalIdForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findProposalContractWaitingForCSOAndMarkQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?) ";
	/**
	 * FindProposalContractWaitingForCSOAndMark
	 */
	public javax.resource.cci.Record FindProposalContractWaitingForCSOAndMark(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.createdBy=?1 */
			pstmt = prepareStatement(connection, findProposalContractWaitingForCSOAndMarkQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findProposalContractWaitingForCSOAndMarkQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findProposalContractWaitingForCSOAndMarkForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindProposalContractWaitingForCSOAndMark444Update
	 */
	public javax.resource.cci.Record FindProposalContractWaitingForCSOAndMark444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.createdBy=?1 */
			pstmt = prepareStatement(connection, findProposalContractWaitingForCSOAndMarkForUpdateQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findProposalContractWaitingForCSOAndMarkForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findProposalContractWaitingForCSOAndMarkForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindProposalContractWaitingForCSOAndMarkForUpdateWithRR
	 */
	public javax.resource.cci.Record FindProposalContractWaitingForCSOAndMarkForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.createdBy=?1 */
			pstmt = prepareStatement(connection, findProposalContractWaitingForCSOAndMarkForUpdateWithRRQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findProposalContractWaitingForCSOAndMarkForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findProposalContractWaitingForCSOAndMarkForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"CREATED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindProposalContractWaitingForCSOAndMarkForUpdateWithRS
	 */
	public javax.resource.cci.Record FindProposalContractWaitingForCSOAndMarkForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.createdBy=?1 */
			pstmt = prepareStatement(connection, findProposalContractWaitingForCSOAndMarkForUpdateWithRSQuery_0);

			// For ?1 (createdBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findProposalContractWaitingForCSOAndMarkForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBytpContractNoQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"TP_CNTR_NUMBER\" = ?) ";
	/**
	 * FindBytpContractNo
	 */
	public javax.resource.cci.Record FindBytpContractNo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.tpContractNo = ?1 */
			pstmt = prepareStatement(connection, findBytpContractNoQuery_0);

			// For ?1 (tpContractNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBytpContractNoQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBytpContractNoForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"TP_CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBytpContractNo444Update
	 */
	public javax.resource.cci.Record FindBytpContractNo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.tpContractNo = ?1 */
			pstmt = prepareStatement(connection, findBytpContractNoForUpdateQuery_0);

			// For ?1 (tpContractNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBytpContractNoForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBytpContractNoForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"TP_CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBytpContractNoForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBytpContractNoForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.tpContractNo = ?1 */
			pstmt = prepareStatement(connection, findBytpContractNoForUpdateWithRRQuery_0);

			// For ?1 (tpContractNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBytpContractNoForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBytpContractNoForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"TP_CNTR_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBytpContractNoForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBytpContractNoForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where o.tpContractNo = ?1 */
			pstmt = prepareStatement(connection, findBytpContractNoForUpdateWithRSQuery_0);

			// For ?1 (tpContractNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBytpContractNoForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBySubmittedByQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"SUBMITTED_BY\" = ?) ";
	/**
	 * FindBySubmittedBy
	 */
	public javax.resource.cci.Record FindBySubmittedBy(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.submittedBy = ?1 */
			pstmt = prepareStatement(connection, findBySubmittedByQuery_0);

			// For ?1 (submittedBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySubmittedByQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBySubmittedByForUpdateQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"SUBMITTED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySubmittedBy444Update
	 */
	public javax.resource.cci.Record FindBySubmittedBy444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.submittedBy = ?1 */
			pstmt = prepareStatement(connection, findBySubmittedByForUpdateQuery_0);

			// For ?1 (submittedBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySubmittedByForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBySubmittedByForUpdateWithRRQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"SUBMITTED_BY\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySubmittedByForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySubmittedByForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.submittedBy = ?1 */
			pstmt = prepareStatement(connection, findBySubmittedByForUpdateWithRRQuery_0);

			// For ?1 (submittedBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySubmittedByForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBySubmittedByForUpdateWithRSQuery_0 = " select  q1.\"ADD_VALUE_DAYS\",  q1.\"ADVANCE_BILLING\",  q1.\"AMDT_IND\",  q1.\"AMDT_EFFC_DATE\",  q1.\"APPROVED_BY\",  q1.\"PROPOSAL_ID\",  q1.\"PROPOSAL_TYPE\",  q1.\"BILLING_FREQ_CODE\",  q1.\"CREATED_BY\",  q1.\"STATUS_CODE\",  q1.\"SALES_ORG\",  q1.\"DSTR_CHANNEL\",  q1.\"DIVISION_CODE\",  q1.\"PROPOSAL_NAME\",  q1.\"CNTR_START_DATE\",  q1.\"CNTR_END_DATE\",  q1.\"CNTR_START_PERIOD\",  q1.\"CNTR_END_PERIOD\",  q1.\"TVM_RATE\",  q1.\"GROWTH_FACTOR\",  q1.\"SPECIAL_RATE\",  q1.\"INVOICE_AMOUNT\",  q1.\"DATE_PRICED\",  q1.\"COMMENTS\",  q1.\"CREATED_DATE\",  q1.\"APPROVED_DATE\",  q1.\"DELETED_IND\",  q1.\"REG_SOLD_TO_P_NO\",  q1.\"REG_SOLD_TO_P_NAME\",  q1.\"REG_BILL_TO_P_NO\",  q1.\"REG_BILL_TO_P_NAME\",  q1.\"REG_PAYER_NO\",  q1.\"REG_PAYER_NAME\",  q1.\"REG_SHIP_TO_P_NO\",  q1.\"REG_SHIP_TO_P_NAME\",  q1.\"CURRENCY\",  q1.\"LAST_UPDATE_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"FETCH_DATE\",  q1.\"DELTA_FETCH_ID\",  q1.\"CNTR_TYPE\",  q1.\"REPORT_NAME\",  q1.\"CAP_AMOUNT\",  q1.\"CAP_PLUS\",  q1.\"CAP_MINUS\",  q1.\"PRE_TVM\",  q1.\"CNTR_EXTN_DATE\",  q1.\"CNTR_RETR_DATE\",  q1.\"CNTR_REPL_DATE\",  q1.\"CNTR_CLS_DATE\",  q1.\"CNTR_NUMBER\",  q1.\"CNTR_AMDT_NO\",  q1.\"REG_SOLD_TO_P_LNO\",  q1.\"REG_BILL_TO_P_LNO\",  q1.\"REG_PAYER_LNO\",  q1.\"REG_SHIP_TO_P_LNO\",  q1.\"INVOICE_AMOUNT_SEM\",  q1.\"INVOICE_AMOUNT_ANN\",  q1.\"INVOICE_AMOUNT_MON\",  q1.\"INVOICE_AMOUNT_QRT\",  q1.\"OLD_CNTR_NUMBER\",  q1.\"PRE_TVM_INV_AMT\",  q1.\"PROPOSAL_SHARING\",  q1.\"EXT_CNTR_NUMBER\",  q1.\"CNTR_CREATE_FLAG\",  q1.\"PAK_ID\",  q1.\"BILLING_TYPE\",  q1.\"PAYMENT_TERM\",  q1.\"FIXED_VAL_DATE\",  q1.\"TP_CNTR_NUMBER\",  q1.\"INELIGIBLE_IND\",  q1.\"INVOICE_IND\",  q1.\"AUTOPOPULATE_IND\",  q1.\"CCI_IND\",  q1.\"PREBILL_INDICATOR\",  q1.\"BLB_INDICATOR\",  q1.\"CONTRACT_TYPE\",  q1.\"OCPS\",  q1.\"CPS\",  q1.\"S_S_DISCOUNT_AMOUNT5\",  q1.\"S_S_DISCOUNT_AMOUNT4\",  q1.\"S_S_DISCOUNT_AMOUNT3\",  q1.\"S_S_DISCOUNT_AMOUNT2\",  q1.\"S_S_DISCOUNT_AMOUNT1\",  q1.\"S_S_ANNV_AMOUNT5\",  q1.\"S_S_ANNV_AMOUNT4\",  q1.\"S_S_ANNV_AMOUNT3\",  q1.\"S_S_ANNV_AMOUNT2\",  q1.\"S_S_EXTEND_CNTR_IND\",  q1.\"GROUP_NAME\",  q1.\"SUBMITTED_BY\",  q1.\"PROPOSAL_CONTENT\",  q1.\"S_S_DISCOUNT_SUM\",  q1.\"S_S_ANNV_AMOUNT\",  q1.\"REG_9D_PARTNER_NO\",  q1.\"REG_9D_PARTNER_NAME\",  q1.\"CUM_VALUE\",  q1.\"CAP_VARIANCE\",  q1.\"ORG_VAR_CNTR_NUMBER\",  q1.\"VAR_DATE\",  q1.\"VAR_IND\",  q1.\"REG_SOLD_TO_P_ASNO\",  q1.\"REG_BILL_TO_P_ASNO\",  q1.\"REG_PAYER_ASNO\",  q1.\"REG_SHIP_TO_P_ASNO\",  q1.\"SUPPRESS_INVOICE\",  q1.\"ESW_FETCH_DATE\",  q1.\"ESW_FETCH_TIME\",  q1.\"GSA_IND\",  q1.\"FREE_TEXT\",  q1.\"LOCKED_BY\",  q1.\"LOCKED_ON\",  q1.\"PO_NUMBER\",  q1.\"PO_DATE\",  q1.\"ANNV_AMOUNT\",  q1.\"CNTR_NEWRENEW_NO\",  q1.\"BILLING_BLOCK\",  q1.\"CNTR_PERIOD_VAR_NO\",  q1.\"CNTR_VAR_NO\",  q1.\"DEVIATING_DATE_RULE\",  q1.\"S_S_EXCLUDED\",  q1.\"CNTR_REPL_NO\",  q1.\"FIN_CNTR_NO\",  q1.\"SALES_GROUP\",  q1.\"CHANNEL_ROLE\",  q1.\"SUBMITTER_ROLE\",  q1.\"PAYMENTMETHOD\",  q1.\"DISCOUNT\" from BH.PROPOSAL q1 where  ( q1.\"SUBMITTED_BY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySubmittedByForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySubmittedByForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Proposal o where  o.submittedBy = ?1 */
			pstmt = prepareStatement(connection, findBySubmittedByForUpdateWithRSQuery_0);

			// For ?1 (submittedBy)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySubmittedByForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * ProposalBeanFunctionSet_8ef9b9cc
	 */
	public ProposalBeanFunctionSet_8ef9b9cc() {
		functionHash=new java.util.HashMap(108);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByContrORExternalContrNum",new Integer(4));
		functionHash.put("FindByContrORExternalContrNum444Update",new Integer(5));
		functionHash.put("FindByContrORExternalContrNumForUpdateWithRR",new Integer(6));
		functionHash.put("FindByContrORExternalContrNumForUpdateWithRS",new Integer(7));
		functionHash.put("FindByUserGroup",new Integer(8));
		functionHash.put("FindByUserGroup444Update",new Integer(9));
		functionHash.put("FindByUserGroupForUpdateWithRR",new Integer(10));
		functionHash.put("FindByUserGroupForUpdateWithRS",new Integer(11));
		functionHash.put("FindByUserForDateRange",new Integer(12));
		functionHash.put("FindByUserForDateRange444Update",new Integer(13));
		functionHash.put("FindByUserForDateRangeForUpdateWithRR",new Integer(14));
		functionHash.put("FindByUserForDateRangeForUpdateWithRS",new Integer(15));
		functionHash.put("FindByVarContractNo",new Integer(16));
		functionHash.put("FindByVarContractNo444Update",new Integer(17));
		functionHash.put("FindByVarContractNoForUpdateWithRR",new Integer(18));
		functionHash.put("FindByVarContractNoForUpdateWithRS",new Integer(19));
		functionHash.put("FindAllVarianceContracts",new Integer(20));
		functionHash.put("FindAllVarianceContracts444Update",new Integer(21));
		functionHash.put("FindAllVarianceContractsForUpdateWithRR",new Integer(22));
		functionHash.put("FindAllVarianceContractsForUpdateWithRS",new Integer(23));
		functionHash.put("FindByApproverFromGroup",new Integer(24));
		functionHash.put("FindByApproverFromGroup444Update",new Integer(25));
		functionHash.put("FindByApproverFromGroupForUpdateWithRR",new Integer(26));
		functionHash.put("FindByApproverFromGroupForUpdateWithRS",new Integer(27));
		functionHash.put("FindMaxContractNumber",new Integer(28));
		functionHash.put("FindMaxContractNumber444Update",new Integer(29));
		functionHash.put("FindMaxContractNumberForUpdateWithRR",new Integer(30));
		functionHash.put("FindMaxContractNumberForUpdateWithRS",new Integer(31));
		functionHash.put("FindByContractNumber",new Integer(32));
		functionHash.put("FindByContractNumber444Update",new Integer(33));
		functionHash.put("FindByContractNumberForUpdateWithRR",new Integer(34));
		functionHash.put("FindByContractNumberForUpdateWithRS",new Integer(35));
		functionHash.put("FindByWaitingForApproval",new Integer(36));
		functionHash.put("FindByWaitingForApproval444Update",new Integer(37));
		functionHash.put("FindByWaitingForApprovalForUpdateWithRR",new Integer(38));
		functionHash.put("FindByWaitingForApprovalForUpdateWithRS",new Integer(39));
		functionHash.put("FindByWaitingForApprovalForProposalApprover",new Integer(40));
		functionHash.put("FindByWaitingForApprovalForProposalApprover444Update",new Integer(41));
		functionHash.put("FindByWaitingForApprovalForProposalApproverForUpdateWithRR",new Integer(42));
		functionHash.put("FindByWaitingForApprovalForProposalApproverForUpdateWithRS",new Integer(43));
		functionHash.put("FindByLockedBy",new Integer(44));
		functionHash.put("FindByLockedBy444Update",new Integer(45));
		functionHash.put("FindByLockedByForUpdateWithRR",new Integer(46));
		functionHash.put("FindByLockedByForUpdateWithRS",new Integer(47));
		functionHash.put("FindByUserAndSalesOrg",new Integer(48));
		functionHash.put("FindByUserAndSalesOrg444Update",new Integer(49));
		functionHash.put("FindByUserAndSalesOrgForUpdateWithRR",new Integer(50));
		functionHash.put("FindByUserAndSalesOrgForUpdateWithRS",new Integer(51));
		functionHash.put("FindRelatedVarianceProposal",new Integer(52));
		functionHash.put("FindRelatedVarianceProposal444Update",new Integer(53));
		functionHash.put("FindRelatedVarianceProposalForUpdateWithRR",new Integer(54));
		functionHash.put("FindRelatedVarianceProposalForUpdateWithRS",new Integer(55));
		functionHash.put("FindByApprover",new Integer(56));
		functionHash.put("FindByApprover444Update",new Integer(57));
		functionHash.put("FindByApproverForUpdateWithRR",new Integer(58));
		functionHash.put("FindByApproverForUpdateWithRS",new Integer(59));
		functionHash.put("FindByWaitingForApprovalForCreateApprove",new Integer(60));
		functionHash.put("FindByWaitingForApprovalForCreateApprove444Update",new Integer(61));
		functionHash.put("FindByWaitingForApprovalForCreateApproveForUpdateWithRR",new Integer(62));
		functionHash.put("FindByWaitingForApprovalForCreateApproveForUpdateWithRS",new Integer(63));
		functionHash.put("FindRelatedProposalForContract",new Integer(64));
		functionHash.put("FindRelatedProposalForContract444Update",new Integer(65));
		functionHash.put("FindRelatedProposalForContractForUpdateWithRR",new Integer(66));
		functionHash.put("FindRelatedProposalForContractForUpdateWithRS",new Integer(67));
		functionHash.put("FindByDateRangeForGroup",new Integer(68));
		functionHash.put("FindByDateRangeForGroup444Update",new Integer(69));
		functionHash.put("FindByDateRangeForGroupForUpdateWithRR",new Integer(70));
		functionHash.put("FindByDateRangeForGroupForUpdateWithRS",new Integer(71));
		functionHash.put("FindByUser",new Integer(72));
		functionHash.put("FindByUser444Update",new Integer(73));
		functionHash.put("FindByUserForUpdateWithRR",new Integer(74));
		functionHash.put("FindByUserForUpdateWithRS",new Integer(75));
		functionHash.put("FindByName",new Integer(76));
		functionHash.put("FindByName444Update",new Integer(77));
		functionHash.put("FindByNameForUpdateWithRR",new Integer(78));
		functionHash.put("FindByNameForUpdateWithRS",new Integer(79));
		functionHash.put("FindByCntrNumberORExternalCntrNumAndStatus",new Integer(80));
		functionHash.put("FindByCntrNumberORExternalCntrNumAndStatus444Update",new Integer(81));
		functionHash.put("FindByCntrNumberORExternalCntrNumAndStatusForUpdateWithRR",new Integer(82));
		functionHash.put("FindByCntrNumberORExternalCntrNumAndStatusForUpdateWithRS",new Integer(83));
		functionHash.put("FindByPrimaryKey",new Integer(84));
		functionHash.put("FindByPrimaryKey444Update",new Integer(85));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(86));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(87));
		functionHash.put("FindMaxProposalId",new Integer(88));
		functionHash.put("FindMaxProposalId444Update",new Integer(89));
		functionHash.put("FindMaxProposalIdForUpdateWithRR",new Integer(90));
		functionHash.put("FindMaxProposalIdForUpdateWithRS",new Integer(91));
		functionHash.put("FindProposalContractWaitingForCSOAndMark",new Integer(92));
		functionHash.put("FindProposalContractWaitingForCSOAndMark444Update",new Integer(93));
		functionHash.put("FindProposalContractWaitingForCSOAndMarkForUpdateWithRR",new Integer(94));
		functionHash.put("FindProposalContractWaitingForCSOAndMarkForUpdateWithRS",new Integer(95));
		functionHash.put("FindBytpContractNo",new Integer(96));
		functionHash.put("FindBytpContractNo444Update",new Integer(97));
		functionHash.put("FindBytpContractNoForUpdateWithRR",new Integer(98));
		functionHash.put("FindBytpContractNoForUpdateWithRS",new Integer(99));
		functionHash.put("FindBySubmittedBy",new Integer(100));
		functionHash.put("FindBySubmittedBy444Update",new Integer(101));
		functionHash.put("FindBySubmittedByForUpdateWithRR",new Integer(102));
		functionHash.put("FindBySubmittedByForUpdateWithRS",new Integer(103));
		functionHash.put("ReadReadChecking",new Integer(104));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(105));
		functionHash.put("PartialStore",new Integer(106));
		functionHash.put("PartialStoreUsingOCC",new Integer(107));
	}
	/**
	 * execute
	 */
	public Record execute(WSInteractionSpec interactionSpec, IndexedRecord inputRecord, Object connection) throws javax.resource.ResourceException {
		String functionName=interactionSpec.getFunctionName();
		Record outputRecord=null;
		int functionIndex=((Integer)functionHash.get(functionName)).intValue();

		switch (functionIndex) {
		case 0:
			Create(inputRecord,connection,interactionSpec);
			break;
		case 1:
			Remove(inputRecord,connection,interactionSpec);
			break;
		case 2:
			Store(inputRecord,connection,interactionSpec);
			break;
		case 3:
			StoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		case 4:
			outputRecord=FindByContrORExternalContrNum(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindByContrORExternalContrNum444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByContrORExternalContrNumForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByContrORExternalContrNumForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindByUserGroup(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindByUserGroup444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindByUserGroupForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindByUserGroupForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=FindByUserForDateRange(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindByUserForDateRange444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindByUserForDateRangeForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindByUserForDateRangeForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 16:
			outputRecord=FindByVarContractNo(inputRecord,connection,interactionSpec);
			break;
		case 17:
			outputRecord=FindByVarContractNo444Update(inputRecord,connection,interactionSpec);
			break;
		case 18:
			outputRecord=FindByVarContractNoForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 19:
			outputRecord=FindByVarContractNoForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 20:
			outputRecord=FindAllVarianceContracts(inputRecord,connection,interactionSpec);
			break;
		case 21:
			outputRecord=FindAllVarianceContracts444Update(inputRecord,connection,interactionSpec);
			break;
		case 22:
			outputRecord=FindAllVarianceContractsForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 23:
			outputRecord=FindAllVarianceContractsForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 24:
			outputRecord=FindByApproverFromGroup(inputRecord,connection,interactionSpec);
			break;
		case 25:
			outputRecord=FindByApproverFromGroup444Update(inputRecord,connection,interactionSpec);
			break;
		case 26:
			outputRecord=FindByApproverFromGroupForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 27:
			outputRecord=FindByApproverFromGroupForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 28:
			outputRecord=FindMaxContractNumber(inputRecord,connection,interactionSpec);
			break;
		case 29:
			outputRecord=FindMaxContractNumber444Update(inputRecord,connection,interactionSpec);
			break;
		case 30:
			outputRecord=FindMaxContractNumberForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 31:
			outputRecord=FindMaxContractNumberForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 32:
			outputRecord=FindByContractNumber(inputRecord,connection,interactionSpec);
			break;
		case 33:
			outputRecord=FindByContractNumber444Update(inputRecord,connection,interactionSpec);
			break;
		case 34:
			outputRecord=FindByContractNumberForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 35:
			outputRecord=FindByContractNumberForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 36:
			outputRecord=FindByWaitingForApproval(inputRecord,connection,interactionSpec);
			break;
		case 37:
			outputRecord=FindByWaitingForApproval444Update(inputRecord,connection,interactionSpec);
			break;
		case 38:
			outputRecord=FindByWaitingForApprovalForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 39:
			outputRecord=FindByWaitingForApprovalForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 40:
			outputRecord=FindByWaitingForApprovalForProposalApprover(inputRecord,connection,interactionSpec);
			break;
		case 41:
			outputRecord=FindByWaitingForApprovalForProposalApprover444Update(inputRecord,connection,interactionSpec);
			break;
		case 42:
			outputRecord=FindByWaitingForApprovalForProposalApproverForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 43:
			outputRecord=FindByWaitingForApprovalForProposalApproverForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 44:
			outputRecord=FindByLockedBy(inputRecord,connection,interactionSpec);
			break;
		case 45:
			outputRecord=FindByLockedBy444Update(inputRecord,connection,interactionSpec);
			break;
		case 46:
			outputRecord=FindByLockedByForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 47:
			outputRecord=FindByLockedByForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 48:
			outputRecord=FindByUserAndSalesOrg(inputRecord,connection,interactionSpec);
			break;
		case 49:
			outputRecord=FindByUserAndSalesOrg444Update(inputRecord,connection,interactionSpec);
			break;
		case 50:
			outputRecord=FindByUserAndSalesOrgForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 51:
			outputRecord=FindByUserAndSalesOrgForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 52:
			outputRecord=FindRelatedVarianceProposal(inputRecord,connection,interactionSpec);
			break;
		case 53:
			outputRecord=FindRelatedVarianceProposal444Update(inputRecord,connection,interactionSpec);
			break;
		case 54:
			outputRecord=FindRelatedVarianceProposalForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 55:
			outputRecord=FindRelatedVarianceProposalForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 56:
			outputRecord=FindByApprover(inputRecord,connection,interactionSpec);
			break;
		case 57:
			outputRecord=FindByApprover444Update(inputRecord,connection,interactionSpec);
			break;
		case 58:
			outputRecord=FindByApproverForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 59:
			outputRecord=FindByApproverForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 60:
			outputRecord=FindByWaitingForApprovalForCreateApprove(inputRecord,connection,interactionSpec);
			break;
		case 61:
			outputRecord=FindByWaitingForApprovalForCreateApprove444Update(inputRecord,connection,interactionSpec);
			break;
		case 62:
			outputRecord=FindByWaitingForApprovalForCreateApproveForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 63:
			outputRecord=FindByWaitingForApprovalForCreateApproveForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 64:
			outputRecord=FindRelatedProposalForContract(inputRecord,connection,interactionSpec);
			break;
		case 65:
			outputRecord=FindRelatedProposalForContract444Update(inputRecord,connection,interactionSpec);
			break;
		case 66:
			outputRecord=FindRelatedProposalForContractForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 67:
			outputRecord=FindRelatedProposalForContractForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 68:
			outputRecord=FindByDateRangeForGroup(inputRecord,connection,interactionSpec);
			break;
		case 69:
			outputRecord=FindByDateRangeForGroup444Update(inputRecord,connection,interactionSpec);
			break;
		case 70:
			outputRecord=FindByDateRangeForGroupForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 71:
			outputRecord=FindByDateRangeForGroupForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 72:
			outputRecord=FindByUser(inputRecord,connection,interactionSpec);
			break;
		case 73:
			outputRecord=FindByUser444Update(inputRecord,connection,interactionSpec);
			break;
		case 74:
			outputRecord=FindByUserForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 75:
			outputRecord=FindByUserForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 76:
			outputRecord=FindByName(inputRecord,connection,interactionSpec);
			break;
		case 77:
			outputRecord=FindByName444Update(inputRecord,connection,interactionSpec);
			break;
		case 78:
			outputRecord=FindByNameForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 79:
			outputRecord=FindByNameForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 80:
			outputRecord=FindByCntrNumberORExternalCntrNumAndStatus(inputRecord,connection,interactionSpec);
			break;
		case 81:
			outputRecord=FindByCntrNumberORExternalCntrNumAndStatus444Update(inputRecord,connection,interactionSpec);
			break;
		case 82:
			outputRecord=FindByCntrNumberORExternalCntrNumAndStatusForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 83:
			outputRecord=FindByCntrNumberORExternalCntrNumAndStatusForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 84:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 85:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 86:
			outputRecord=FindByPrimaryKeyForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 87:
			outputRecord=FindByPrimaryKeyForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 88:
			outputRecord=FindMaxProposalId(inputRecord,connection,interactionSpec);
			break;
		case 89:
			outputRecord=FindMaxProposalId444Update(inputRecord,connection,interactionSpec);
			break;
		case 90:
			outputRecord=FindMaxProposalIdForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 91:
			outputRecord=FindMaxProposalIdForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 92:
			outputRecord=FindProposalContractWaitingForCSOAndMark(inputRecord,connection,interactionSpec);
			break;
		case 93:
			outputRecord=FindProposalContractWaitingForCSOAndMark444Update(inputRecord,connection,interactionSpec);
			break;
		case 94:
			outputRecord=FindProposalContractWaitingForCSOAndMarkForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 95:
			outputRecord=FindProposalContractWaitingForCSOAndMarkForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 96:
			outputRecord=FindBytpContractNo(inputRecord,connection,interactionSpec);
			break;
		case 97:
			outputRecord=FindBytpContractNo444Update(inputRecord,connection,interactionSpec);
			break;
		case 98:
			outputRecord=FindBytpContractNoForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 99:
			outputRecord=FindBytpContractNoForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 100:
			outputRecord=FindBySubmittedBy(inputRecord,connection,interactionSpec);
			break;
		case 101:
			outputRecord=FindBySubmittedBy444Update(inputRecord,connection,interactionSpec);
			break;
		case 102:
			outputRecord=FindBySubmittedByForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 103:
			outputRecord=FindBySubmittedByForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 104:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 105:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 106:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 107:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.PROPOSAL  T1 WHERE T1.PROPOSAL_ID = ? AND T1.ADD_VALUE_DAYS = ? AND T1.TVM_RATE = ? AND T1.GROWTH_FACTOR = ? AND T1.SPECIAL_RATE = ? AND T1.INVOICE_AMOUNT = ? AND T1.CAP_AMOUNT = ? AND T1.CAP_PLUS = ? AND T1.CAP_MINUS = ? AND T1.PRE_TVM = ? AND T1.CNTR_AMDT_NO = ? AND T1.INVOICE_AMOUNT_SEM = ? AND T1.INVOICE_AMOUNT_ANN = ? AND T1.INVOICE_AMOUNT_MON = ? AND T1.INVOICE_AMOUNT_QRT = ? AND T1.PRE_TVM_INV_AMT = ? AND T1.S_S_DISCOUNT_AMOUNT5 = ? AND T1.S_S_DISCOUNT_AMOUNT4 = ? AND T1.S_S_DISCOUNT_AMOUNT3 = ? AND T1.S_S_DISCOUNT_AMOUNT2 = ? AND T1.S_S_DISCOUNT_AMOUNT1 = ? AND T1.S_S_ANNV_AMOUNT5 = ? AND T1.S_S_ANNV_AMOUNT4 = ? AND T1.S_S_ANNV_AMOUNT3 = ? AND T1.S_S_ANNV_AMOUNT2 = ? AND T1.S_S_DISCOUNT_SUM = ? AND T1.S_S_ANNV_AMOUNT = ? AND T1.CUM_VALUE = ? AND T1.CAP_VARIANCE = ? AND T1.ANNV_AMOUNT = ? AND T1.CNTR_NEWRENEW_NO = ? AND T1.CNTR_PERIOD_VAR_NO = ? AND T1.CNTR_VAR_NO = ? AND T1.CNTR_REPL_NO = ? AND T1.DISCOUNT = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column ADD_VALUE_DAYS
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column TVM_RATE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(2);
				if(tempDouble != null)
					pstmt.setDouble(3,tempDouble.doubleValue());
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
			}
			// For column GROWTH_FACTOR
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(3);
				if(tempDouble != null)
					pstmt.setDouble(4,tempDouble.doubleValue());
				else
					pstmt.setNull(4,java.sql.Types.DECIMAL);
			}
			// For column SPECIAL_RATE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(4);
				if(tempDouble != null)
					pstmt.setDouble(5,tempDouble.doubleValue());
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(5);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column CAP_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(7,tempDouble.doubleValue());
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column CAP_PLUS
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(7);
				if(tempDouble != null)
					pstmt.setDouble(8,tempDouble.doubleValue());
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column CAP_MINUS
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(8);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column PRE_TVM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(9);
				if(tempDouble != null)
					pstmt.setDouble(10,tempDouble.doubleValue());
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
			}
			// For column CNTR_AMDT_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(10);
				if(tempDouble != null)
					pstmt.setDouble(11,tempDouble.doubleValue());
				else
					pstmt.setNull(11,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_SEM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(11);
				if(tempDouble != null)
					pstmt.setDouble(12,tempDouble.doubleValue());
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_ANN
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(12);
				if(tempDouble != null)
					pstmt.setDouble(13,tempDouble.doubleValue());
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_MON
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(13);
				if(tempDouble != null)
					pstmt.setDouble(14,tempDouble.doubleValue());
				else
					pstmt.setNull(14,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_QRT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(14);
				if(tempDouble != null)
					pstmt.setDouble(15,tempDouble.doubleValue());
				else
					pstmt.setNull(15,java.sql.Types.DECIMAL);
			}
			// For column PRE_TVM_INV_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(15);
				if(tempDouble != null)
					pstmt.setDouble(16,tempDouble.doubleValue());
				else
					pstmt.setNull(16,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(16);
				if(tempDouble != null)
					pstmt.setDouble(17,tempDouble.doubleValue());
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(17);
				if(tempDouble != null)
					pstmt.setDouble(18,tempDouble.doubleValue());
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(18);
				if(tempDouble != null)
					pstmt.setDouble(19,tempDouble.doubleValue());
				else
					pstmt.setNull(19,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(19);
				if(tempDouble != null)
					pstmt.setDouble(20,tempDouble.doubleValue());
				else
					pstmt.setNull(20,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT1
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(20);
				if(tempDouble != null)
					pstmt.setDouble(21,tempDouble.doubleValue());
				else
					pstmt.setNull(21,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(21);
				if(tempDouble != null)
					pstmt.setDouble(22,tempDouble.doubleValue());
				else
					pstmt.setNull(22,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(22);
				if(tempDouble != null)
					pstmt.setDouble(23,tempDouble.doubleValue());
				else
					pstmt.setNull(23,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(23);
				if(tempDouble != null)
					pstmt.setDouble(24,tempDouble.doubleValue());
				else
					pstmt.setNull(24,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(24);
				if(tempDouble != null)
					pstmt.setDouble(25,tempDouble.doubleValue());
				else
					pstmt.setNull(25,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_SUM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(25);
				if(tempDouble != null)
					pstmt.setDouble(26,tempDouble.doubleValue());
				else
					pstmt.setNull(26,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(26);
				if(tempDouble != null)
					pstmt.setDouble(27,tempDouble.doubleValue());
				else
					pstmt.setNull(27,java.sql.Types.DECIMAL);
			}
			// For column CUM_VALUE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(27);
				if(tempDouble != null)
					pstmt.setDouble(28,tempDouble.doubleValue());
				else
					pstmt.setNull(28,java.sql.Types.DECIMAL);
			}
			// For column CAP_VARIANCE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(28);
				if(tempDouble != null)
					pstmt.setDouble(29,tempDouble.doubleValue());
				else
					pstmt.setNull(29,java.sql.Types.DECIMAL);
			}
			// For column ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(29);
				if(tempDouble != null)
					pstmt.setDouble(30,tempDouble.doubleValue());
				else
					pstmt.setNull(30,java.sql.Types.DECIMAL);
			}
			// For column CNTR_NEWRENEW_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(30);
				if(tempInteger != null)
					pstmt.setInt(31,tempInteger.intValue());
				else
					pstmt.setNull(31,java.sql.Types.DECIMAL);
			}
			// For column CNTR_PERIOD_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(31);
				if(tempInteger != null)
					pstmt.setInt(32,tempInteger.intValue());
				else
					pstmt.setNull(32,java.sql.Types.INTEGER);
			}
			// For column CNTR_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(32);
				if(tempInteger != null)
					pstmt.setInt(33,tempInteger.intValue());
				else
					pstmt.setNull(33,java.sql.Types.INTEGER);
			}
			// For column CNTR_REPL_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(33);
				if(tempInteger != null)
					pstmt.setInt(34,tempInteger.intValue());
				else
					pstmt.setNull(34,java.sql.Types.DECIMAL);
			}
			// For column DISCOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(34);
				if(tempDouble != null)
					pstmt.setDouble(35,tempDouble.doubleValue());
				else
					pstmt.setNull(35,java.sql.Types.DECIMAL);
			}
			executeQuery(connection, pstmt, ReadReadQuery_0);

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.PROPOSAL  T1 WHERE T1.PROPOSAL_ID = ? AND T1.ADD_VALUE_DAYS = ? AND T1.TVM_RATE = ? AND T1.GROWTH_FACTOR = ? AND T1.SPECIAL_RATE = ? AND T1.INVOICE_AMOUNT = ? AND T1.CAP_AMOUNT = ? AND T1.CAP_PLUS = ? AND T1.CAP_MINUS = ? AND T1.PRE_TVM = ? AND T1.CNTR_AMDT_NO = ? AND T1.INVOICE_AMOUNT_SEM = ? AND T1.INVOICE_AMOUNT_ANN = ? AND T1.INVOICE_AMOUNT_MON = ? AND T1.INVOICE_AMOUNT_QRT = ? AND T1.PRE_TVM_INV_AMT = ? AND T1.S_S_DISCOUNT_AMOUNT5 = ? AND T1.S_S_DISCOUNT_AMOUNT4 = ? AND T1.S_S_DISCOUNT_AMOUNT3 = ? AND T1.S_S_DISCOUNT_AMOUNT2 = ? AND T1.S_S_DISCOUNT_AMOUNT1 = ? AND T1.S_S_ANNV_AMOUNT5 = ? AND T1.S_S_ANNV_AMOUNT4 = ? AND T1.S_S_ANNV_AMOUNT3 = ? AND T1.S_S_ANNV_AMOUNT2 = ? AND T1.S_S_DISCOUNT_SUM = ? AND T1.S_S_ANNV_AMOUNT = ? AND T1.CUM_VALUE = ? AND T1.CAP_VARIANCE = ? AND T1.ANNV_AMOUNT = ? AND T1.CNTR_NEWRENEW_NO = ? AND T1.CNTR_PERIOD_VAR_NO = ? AND T1.CNTR_VAR_NO = ? AND T1.CNTR_REPL_NO = ? AND T1.DISCOUNT = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column ADD_VALUE_DAYS
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column TVM_RATE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(2);
				if(tempDouble != null)
					pstmt.setDouble(3,tempDouble.doubleValue());
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
			}
			// For column GROWTH_FACTOR
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(3);
				if(tempDouble != null)
					pstmt.setDouble(4,tempDouble.doubleValue());
				else
					pstmt.setNull(4,java.sql.Types.DECIMAL);
			}
			// For column SPECIAL_RATE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(4);
				if(tempDouble != null)
					pstmt.setDouble(5,tempDouble.doubleValue());
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(5);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column CAP_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(7,tempDouble.doubleValue());
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column CAP_PLUS
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(7);
				if(tempDouble != null)
					pstmt.setDouble(8,tempDouble.doubleValue());
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column CAP_MINUS
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(8);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column PRE_TVM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(9);
				if(tempDouble != null)
					pstmt.setDouble(10,tempDouble.doubleValue());
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
			}
			// For column CNTR_AMDT_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(10);
				if(tempDouble != null)
					pstmt.setDouble(11,tempDouble.doubleValue());
				else
					pstmt.setNull(11,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_SEM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(11);
				if(tempDouble != null)
					pstmt.setDouble(12,tempDouble.doubleValue());
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_ANN
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(12);
				if(tempDouble != null)
					pstmt.setDouble(13,tempDouble.doubleValue());
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_MON
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(13);
				if(tempDouble != null)
					pstmt.setDouble(14,tempDouble.doubleValue());
				else
					pstmt.setNull(14,java.sql.Types.DECIMAL);
			}
			// For column INVOICE_AMOUNT_QRT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(14);
				if(tempDouble != null)
					pstmt.setDouble(15,tempDouble.doubleValue());
				else
					pstmt.setNull(15,java.sql.Types.DECIMAL);
			}
			// For column PRE_TVM_INV_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(15);
				if(tempDouble != null)
					pstmt.setDouble(16,tempDouble.doubleValue());
				else
					pstmt.setNull(16,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(16);
				if(tempDouble != null)
					pstmt.setDouble(17,tempDouble.doubleValue());
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(17);
				if(tempDouble != null)
					pstmt.setDouble(18,tempDouble.doubleValue());
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(18);
				if(tempDouble != null)
					pstmt.setDouble(19,tempDouble.doubleValue());
				else
					pstmt.setNull(19,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(19);
				if(tempDouble != null)
					pstmt.setDouble(20,tempDouble.doubleValue());
				else
					pstmt.setNull(20,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_AMOUNT1
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(20);
				if(tempDouble != null)
					pstmt.setDouble(21,tempDouble.doubleValue());
				else
					pstmt.setNull(21,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT5
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(21);
				if(tempDouble != null)
					pstmt.setDouble(22,tempDouble.doubleValue());
				else
					pstmt.setNull(22,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT4
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(22);
				if(tempDouble != null)
					pstmt.setDouble(23,tempDouble.doubleValue());
				else
					pstmt.setNull(23,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT3
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(23);
				if(tempDouble != null)
					pstmt.setDouble(24,tempDouble.doubleValue());
				else
					pstmt.setNull(24,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT2
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(24);
				if(tempDouble != null)
					pstmt.setDouble(25,tempDouble.doubleValue());
				else
					pstmt.setNull(25,java.sql.Types.DECIMAL);
			}
			// For column S_S_DISCOUNT_SUM
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(25);
				if(tempDouble != null)
					pstmt.setDouble(26,tempDouble.doubleValue());
				else
					pstmt.setNull(26,java.sql.Types.DECIMAL);
			}
			// For column S_S_ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(26);
				if(tempDouble != null)
					pstmt.setDouble(27,tempDouble.doubleValue());
				else
					pstmt.setNull(27,java.sql.Types.DECIMAL);
			}
			// For column CUM_VALUE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(27);
				if(tempDouble != null)
					pstmt.setDouble(28,tempDouble.doubleValue());
				else
					pstmt.setNull(28,java.sql.Types.DECIMAL);
			}
			// For column CAP_VARIANCE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(28);
				if(tempDouble != null)
					pstmt.setDouble(29,tempDouble.doubleValue());
				else
					pstmt.setNull(29,java.sql.Types.DECIMAL);
			}
			// For column ANNV_AMOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(29);
				if(tempDouble != null)
					pstmt.setDouble(30,tempDouble.doubleValue());
				else
					pstmt.setNull(30,java.sql.Types.DECIMAL);
			}
			// For column CNTR_NEWRENEW_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(30);
				if(tempInteger != null)
					pstmt.setInt(31,tempInteger.intValue());
				else
					pstmt.setNull(31,java.sql.Types.DECIMAL);
			}
			// For column CNTR_PERIOD_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(31);
				if(tempInteger != null)
					pstmt.setInt(32,tempInteger.intValue());
				else
					pstmt.setNull(32,java.sql.Types.INTEGER);
			}
			// For column CNTR_VAR_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(32);
				if(tempInteger != null)
					pstmt.setInt(33,tempInteger.intValue());
				else
					pstmt.setNull(33,java.sql.Types.INTEGER);
			}
			// For column CNTR_REPL_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(33);
				if(tempInteger != null)
					pstmt.setInt(34,tempInteger.intValue());
				else
					pstmt.setNull(34,java.sql.Types.DECIMAL);
			}
			// For column DISCOUNT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(34);
				if(tempDouble != null)
					pstmt.setDouble(35,tempDouble.doubleValue());
				else
					pstmt.setNull(35,java.sql.Types.DECIMAL);
			}
			executeQuery(connection, pstmt, ReadReadForUpdateQuery_0);

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	/**
	 * initializeUpdateTemplates
	 */
	private void initializeUpdateTemplates() throws javax.resource.ResourceException {
		updateTemplateList = ProposalBeanPartialUpdateQueryHelper.getUpdateTemplates();
	}
	private java.util.List updateTemplateList = null;
	/**
	 * PartialStore
	 */
	public void PartialStore(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			boolean[] changedFieldIndexes = interactionSpec.getChangedFieldsIndexes();
			if (updateTemplateList == null)
				initializeUpdateTemplates();
			{
				com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate aTemplate = (com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate) updateTemplateList.get(0);
				String updateQuery = aTemplate.nativeQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[0])
					{
						// For column ADD_VALUE_DAYS
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[1])
					{
						// For column ADVANCE_BILLING
						String tempString;


						tempString=(String)inputRecord.get(1);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column AMDT_IND
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[2])
					{
						// For column AMDT_EFFC_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(3);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column APPROVED_BY
						String tempString;


						tempString=(String)inputRecord.get(4);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[66])
					{
						// For column PROPOSAL_TYPE
						String tempString;


						tempString=(String)inputRecord.get(6);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column BILLING_FREQ_CODE
						String tempString;


						tempString=(String)inputRecord.get(7);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[31])
					{
						// For column CREATED_BY
						String tempString;


						tempString=(String)inputRecord.get(8);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[92])
					{
						// For column STATUS_CODE
						String tempString;


						tempString=(String)inputRecord.get(9);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[89])
					{
						// For column SALES_ORG
						String tempString;


						tempString=(String)inputRecord.get(10);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[39])
					{
						// For column DSTR_CHANNEL
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[40])
					{
						// For column DIVISION_CODE
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[63])
					{
						// For column PROPOSAL_NAME
						String tempString;


						tempString=(String)inputRecord.get(13);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[29])
					{
						// For column CNTR_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(14);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column CNTR_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(15);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[30])
					{
						// For column CNTR_START_PERIOD
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(16);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column CNTR_END_PERIOD
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(17);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[95])
					{
						// For column TVM_RATE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(18);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[47])
					{
						// For column GROWTH_FACTOR
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(19);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[91])
					{
						// For column SPECIAL_RATE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(20);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[50])
					{
						// For column INVOICE_AMOUNT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(21);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[35])
					{
						// For column DATE_PRICED
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(22);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column COMMENTS
						String tempString;


						tempString=(String)inputRecord.get(23);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[32])
					{
						// For column CREATED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(24);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column APPROVED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(25);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[36])
					{
						// For column DELETED_IND
						String tempString;


						tempString=(String)inputRecord.get(26);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[78])
					{
						// For column REG_SOLD_TO_P_NO
						String tempString;


						tempString=(String)inputRecord.get(27);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[77])
					{
						// For column REG_SOLD_TO_P_NAME
						String tempString;


						tempString=(String)inputRecord.get(28);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[74])
					{
						// For column REG_BILL_TO_P_NO
						String tempString;


						tempString=(String)inputRecord.get(29);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[73])
					{
						// For column REG_BILL_TO_P_NAME
						String tempString;


						tempString=(String)inputRecord.get(30);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[82])
					{
						// For column REG_PAYER_NO
						String tempString;


						tempString=(String)inputRecord.get(31);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[81])
					{
						// For column REG_PAYER_NAME
						String tempString;


						tempString=(String)inputRecord.get(32);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[86])
					{
						// For column REG_SHIP_TO_P_NO
						String tempString;


						tempString=(String)inputRecord.get(33);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[85])
					{
						// For column REG_SHIP_TO_P_NAME
						String tempString;


						tempString=(String)inputRecord.get(34);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[34])
					{
						// For column CURRENCY
						String tempString;


						tempString=(String)inputRecord.get(35);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[52])
					{
						// For column LAST_UPDATE_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(36);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[68])
					{
						// For column RE_FETCH_ID
						String tempString;


						tempString=(String)inputRecord.get(37);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[44])
					{
						// For column FETCH_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(38);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[37])
					{
						// For column DELTA_FETCH_ID
						String tempString;


						tempString=(String)inputRecord.get(39);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column CNTR_TYPE
						String tempString;


						tempString=(String)inputRecord.get(40);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[87])
					{
						// For column REPORT_NAME
						String tempString;


						tempString=(String)inputRecord.get(41);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column CAP_AMOUNT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(42);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column CAP_PLUS
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(43);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column CAP_MINUS
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(44);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[62])
					{
						// For column PRE_TVM
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(45);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column CNTR_EXTN_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(46);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column CNTR_RETR_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(47);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column CNTR_REPL_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(48);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column CNTR_CLS_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(49);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column CNTR_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(50);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column CNTR_AMDT_NO
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(51);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[76])
					{
						// For column REG_SOLD_TO_P_LNO
						String tempString;


						tempString=(String)inputRecord.get(52);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[72])
					{
						// For column REG_BILL_TO_P_LNO
						String tempString;


						tempString=(String)inputRecord.get(53);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[80])
					{
						// For column REG_PAYER_LNO
						String tempString;


						tempString=(String)inputRecord.get(54);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[84])
					{
						// For column REG_SHIP_TO_P_LNO
						String tempString;


						tempString=(String)inputRecord.get(55);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[90])
					{
						// For column INVOICE_AMOUNT_SEM
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(56);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column INVOICE_AMOUNT_ANN
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(57);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[54])
					{
						// For column INVOICE_AMOUNT_MON
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(58);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[67])
					{
						// For column INVOICE_AMOUNT_QRT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(59);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[55])
					{
						// For column OLD_CNTR_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(60);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[61])
					{
						// For column PRE_TVM_INV_AMT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(61);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[65])
					{
						// For column PROPOSAL_SHARING
						String tempString;


						tempString=(String)inputRecord.get(62);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[43])
					{
						// For column EXT_CNTR_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(63);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column CNTR_CREATE_FLAG
						String tempString;


						tempString=(String)inputRecord.get(64);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[58])
					{
						// For column PAK_ID
						String tempString;


						tempString=(String)inputRecord.get(65);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column BILLING_TYPE
						String tempString;


						tempString=(String)inputRecord.get(66);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[59])
					{
						// For column PAYMENT_TERM
						String tempString;


						tempString=(String)inputRecord.get(67);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[45])
					{
						// For column FIXED_VAL_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(68);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[94])
					{
						// For column TP_CNTR_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(69);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[49])
					{
						// For column INELIGIBLE_IND
						String tempString;


						tempString=(String)inputRecord.get(70);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[51])
					{
						// For column INVOICE_IND
						String tempString;


						tempString=(String)inputRecord.get(71);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[122])
					{
						// For column AUTOPOPULATE_IND
						String tempString;


						tempString=(String)inputRecord.get(72);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[121])
					{
						// For column CCI_IND
						String tempString;


						tempString=(String)inputRecord.get(73);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[120])
					{
						// For column PREBILL_INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(74);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[119])
					{
						// For column BLB_INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(75);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[118])
					{
						// For column CONTRACT_TYPE
						String tempString;


						tempString=(String)inputRecord.get(76);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[117])
					{
						// For column OCPS
						String tempString;


						tempString=(String)inputRecord.get(77);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[116])
					{
						// For column CPS
						String tempString;


						tempString=(String)inputRecord.get(78);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[115])
					{
						// For column S_S_DISCOUNT_AMOUNT5
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(79);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[114])
					{
						// For column S_S_DISCOUNT_AMOUNT4
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(80);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[113])
					{
						// For column S_S_DISCOUNT_AMOUNT3
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(81);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[112])
					{
						// For column S_S_DISCOUNT_AMOUNT2
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(82);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[111])
					{
						// For column S_S_DISCOUNT_AMOUNT1
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(83);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[110])
					{
						// For column S_S_ANNV_AMOUNT5
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(84);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[109])
					{
						// For column S_S_ANNV_AMOUNT4
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(85);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[108])
					{
						// For column S_S_ANNV_AMOUNT3
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(86);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[107])
					{
						// For column S_S_ANNV_AMOUNT2
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(87);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[106])
					{
						// For column S_S_EXTEND_CNTR_IND
						String tempString;


						tempString=(String)inputRecord.get(88);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[105])
					{
						// For column GROUP_NAME
						String tempString;


						tempString=(String)inputRecord.get(89);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[104])
					{
						// For column SUBMITTED_BY
						String tempString;


						tempString=(String)inputRecord.get(90);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[103])
					{
						// For column PROPOSAL_CONTENT
						String tempString;


						tempString=(String)inputRecord.get(91);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[102])
					{
						// For column S_S_DISCOUNT_SUM
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(92);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[101])
					{
						// For column S_S_ANNV_AMOUNT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(93);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[70])
					{
						// For column REG_9D_PARTNER_NO
						String tempString;


						tempString=(String)inputRecord.get(94);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[69])
					{
						// For column REG_9D_PARTNER_NAME
						String tempString;


						tempString=(String)inputRecord.get(95);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[33])
					{
						// For column CUM_VALUE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(96);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column CAP_VARIANCE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(97);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[57])
					{
						// For column ORG_VAR_CNTR_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(98);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[96])
					{
						// For column VAR_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(99);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[97])
					{
						// For column VAR_IND
						String tempString;


						tempString=(String)inputRecord.get(100);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[75])
					{
						// For column REG_SOLD_TO_P_ASNO
						String tempString;


						tempString=(String)inputRecord.get(101);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[71])
					{
						// For column REG_BILL_TO_P_ASNO
						String tempString;


						tempString=(String)inputRecord.get(102);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[79])
					{
						// For column REG_PAYER_ASNO
						String tempString;


						tempString=(String)inputRecord.get(103);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[83])
					{
						// For column REG_SHIP_TO_P_ASNO
						String tempString;


						tempString=(String)inputRecord.get(104);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[93])
					{
						// For column SUPPRESS_INVOICE
						String tempString;


						tempString=(String)inputRecord.get(105);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[41])
					{
						// For column ESW_FETCH_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(106);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[42])
					{
						// For column ESW_FETCH_TIME
						java.sql.Time tempTime;


						tempTime=(java.sql.Time)inputRecord.get(107);
						if(tempTime != null){
							pstmt.setTime(stmtIndex,tempTime);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIME);
						stmtIndex++;

					}
					if (changedFieldIndexes[48])
					{
						// For column GSA_IND
						String tempString;


						tempString=(String)inputRecord.get(108);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[46])
					{
						// For column FREE_TEXT
						String tempString;


						tempString=(String)inputRecord.get(109);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[53])
					{
						// For column LOCKED_BY
						String tempString;


						tempString=(String)inputRecord.get(110);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[98])
					{
						// For column LOCKED_ON
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(111);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[60])
					{
						// For column PO_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(112);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[56])
					{
						// For column PO_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(113);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column ANNV_AMOUNT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(114);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column CNTR_NEWRENEW_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(115);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column BILLING_BLOCK
						String tempString;


						tempString=(String)inputRecord.get(116);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column CNTR_PERIOD_VAR_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(117);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[28])
					{
						// For column CNTR_VAR_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(118);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[38])
					{
						// For column DEVIATING_DATE_RULE
						String tempString;


						tempString=(String)inputRecord.get(119);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[88])
					{
						// For column S_S_EXCLUDED
						String tempString;


						tempString=(String)inputRecord.get(120);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[99])
					{
						// For column CNTR_REPL_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(121);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[100])
					{
						// For column FIN_CNTR_NO
						String tempString;


						tempString=(String)inputRecord.get(122);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[123])
					{
						// For column SALES_GROUP
						String tempString;


						tempString=(String)inputRecord.get(123);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[124])
					{
						// For column CHANNEL_ROLE
						String tempString;


						tempString=(String)inputRecord.get(124);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[125])
					{
						// For column SUBMITTER_ROLE
						String tempString;


						tempString=(String)inputRecord.get(125);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[126])
					{
						// For column PAYMENTMETHOD
						String tempString;


						tempString=(String)inputRecord.get(126);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[127])
					{
						// For column DISCOUNT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(127);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(5);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					if (executeUpdate(connection, pstmt, updateQuery)==0)
						throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

				}
			}
		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	/**
	 * PartialStoreUsingOCC
	 */
	public void PartialStoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			boolean[] changedFieldIndexes = interactionSpec.getChangedFieldsIndexes();
			if (updateTemplateList == null)
				initializeUpdateTemplates();
			{
				com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate aTemplate = (com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate) updateTemplateList.get(0);
				IndexedRecord oldRecord = interactionSpec.getOldRecord();
				Object[] oldValues = new Object[34];
				oldValues[0] = oldRecord.get(0);
				oldValues[1] = oldRecord.get(18);
				oldValues[2] = oldRecord.get(19);
				oldValues[3] = oldRecord.get(20);
				oldValues[4] = oldRecord.get(21);
				oldValues[5] = oldRecord.get(42);
				oldValues[6] = oldRecord.get(43);
				oldValues[7] = oldRecord.get(44);
				oldValues[8] = oldRecord.get(45);
				oldValues[9] = oldRecord.get(51);
				oldValues[10] = oldRecord.get(56);
				oldValues[11] = oldRecord.get(57);
				oldValues[12] = oldRecord.get(58);
				oldValues[13] = oldRecord.get(59);
				oldValues[14] = oldRecord.get(61);
				oldValues[15] = oldRecord.get(79);
				oldValues[16] = oldRecord.get(80);
				oldValues[17] = oldRecord.get(81);
				oldValues[18] = oldRecord.get(82);
				oldValues[19] = oldRecord.get(83);
				oldValues[20] = oldRecord.get(84);
				oldValues[21] = oldRecord.get(85);
				oldValues[22] = oldRecord.get(86);
				oldValues[23] = oldRecord.get(87);
				oldValues[24] = oldRecord.get(92);
				oldValues[25] = oldRecord.get(93);
				oldValues[26] = oldRecord.get(96);
				oldValues[27] = oldRecord.get(97);
				oldValues[28] = oldRecord.get(114);
				oldValues[29] = oldRecord.get(115);
				oldValues[30] = oldRecord.get(117);
				oldValues[31] = oldRecord.get(118);
				oldValues[32] = oldRecord.get(121);
				oldValues[33] = oldRecord.get(127);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes,oldValues);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[0])
					{
						// For column ADD_VALUE_DAYS
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[1])
					{
						// For column ADVANCE_BILLING
						String tempString;


						tempString=(String)inputRecord.get(1);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column AMDT_IND
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[2])
					{
						// For column AMDT_EFFC_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(3);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column APPROVED_BY
						String tempString;


						tempString=(String)inputRecord.get(4);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[66])
					{
						// For column PROPOSAL_TYPE
						String tempString;


						tempString=(String)inputRecord.get(6);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column BILLING_FREQ_CODE
						String tempString;


						tempString=(String)inputRecord.get(7);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[31])
					{
						// For column CREATED_BY
						String tempString;


						tempString=(String)inputRecord.get(8);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[92])
					{
						// For column STATUS_CODE
						String tempString;


						tempString=(String)inputRecord.get(9);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[89])
					{
						// For column SALES_ORG
						String tempString;


						tempString=(String)inputRecord.get(10);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[39])
					{
						// For column DSTR_CHANNEL
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[40])
					{
						// For column DIVISION_CODE
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[63])
					{
						// For column PROPOSAL_NAME
						String tempString;


						tempString=(String)inputRecord.get(13);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[29])
					{
						// For column CNTR_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(14);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column CNTR_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(15);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[30])
					{
						// For column CNTR_START_PERIOD
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(16);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column CNTR_END_PERIOD
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(17);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[95])
					{
						// For column TVM_RATE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(18);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[47])
					{
						// For column GROWTH_FACTOR
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(19);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[91])
					{
						// For column SPECIAL_RATE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(20);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[50])
					{
						// For column INVOICE_AMOUNT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(21);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[35])
					{
						// For column DATE_PRICED
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(22);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column COMMENTS
						String tempString;


						tempString=(String)inputRecord.get(23);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[32])
					{
						// For column CREATED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(24);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column APPROVED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(25);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[36])
					{
						// For column DELETED_IND
						String tempString;


						tempString=(String)inputRecord.get(26);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[78])
					{
						// For column REG_SOLD_TO_P_NO
						String tempString;


						tempString=(String)inputRecord.get(27);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[77])
					{
						// For column REG_SOLD_TO_P_NAME
						String tempString;


						tempString=(String)inputRecord.get(28);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[74])
					{
						// For column REG_BILL_TO_P_NO
						String tempString;


						tempString=(String)inputRecord.get(29);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[73])
					{
						// For column REG_BILL_TO_P_NAME
						String tempString;


						tempString=(String)inputRecord.get(30);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[82])
					{
						// For column REG_PAYER_NO
						String tempString;


						tempString=(String)inputRecord.get(31);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[81])
					{
						// For column REG_PAYER_NAME
						String tempString;


						tempString=(String)inputRecord.get(32);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[86])
					{
						// For column REG_SHIP_TO_P_NO
						String tempString;


						tempString=(String)inputRecord.get(33);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[85])
					{
						// For column REG_SHIP_TO_P_NAME
						String tempString;


						tempString=(String)inputRecord.get(34);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[34])
					{
						// For column CURRENCY
						String tempString;


						tempString=(String)inputRecord.get(35);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[52])
					{
						// For column LAST_UPDATE_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(36);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[68])
					{
						// For column RE_FETCH_ID
						String tempString;


						tempString=(String)inputRecord.get(37);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[44])
					{
						// For column FETCH_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(38);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[37])
					{
						// For column DELTA_FETCH_ID
						String tempString;


						tempString=(String)inputRecord.get(39);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column CNTR_TYPE
						String tempString;


						tempString=(String)inputRecord.get(40);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[87])
					{
						// For column REPORT_NAME
						String tempString;


						tempString=(String)inputRecord.get(41);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column CAP_AMOUNT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(42);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column CAP_PLUS
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(43);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column CAP_MINUS
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(44);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[62])
					{
						// For column PRE_TVM
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(45);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column CNTR_EXTN_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(46);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column CNTR_RETR_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(47);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column CNTR_REPL_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(48);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column CNTR_CLS_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(49);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column CNTR_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(50);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column CNTR_AMDT_NO
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(51);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[76])
					{
						// For column REG_SOLD_TO_P_LNO
						String tempString;


						tempString=(String)inputRecord.get(52);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[72])
					{
						// For column REG_BILL_TO_P_LNO
						String tempString;


						tempString=(String)inputRecord.get(53);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[80])
					{
						// For column REG_PAYER_LNO
						String tempString;


						tempString=(String)inputRecord.get(54);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[84])
					{
						// For column REG_SHIP_TO_P_LNO
						String tempString;


						tempString=(String)inputRecord.get(55);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[90])
					{
						// For column INVOICE_AMOUNT_SEM
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(56);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column INVOICE_AMOUNT_ANN
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(57);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[54])
					{
						// For column INVOICE_AMOUNT_MON
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(58);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[67])
					{
						// For column INVOICE_AMOUNT_QRT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(59);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[55])
					{
						// For column OLD_CNTR_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(60);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[61])
					{
						// For column PRE_TVM_INV_AMT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(61);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[65])
					{
						// For column PROPOSAL_SHARING
						String tempString;


						tempString=(String)inputRecord.get(62);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[43])
					{
						// For column EXT_CNTR_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(63);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column CNTR_CREATE_FLAG
						String tempString;


						tempString=(String)inputRecord.get(64);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[58])
					{
						// For column PAK_ID
						String tempString;


						tempString=(String)inputRecord.get(65);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column BILLING_TYPE
						String tempString;


						tempString=(String)inputRecord.get(66);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[59])
					{
						// For column PAYMENT_TERM
						String tempString;


						tempString=(String)inputRecord.get(67);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[45])
					{
						// For column FIXED_VAL_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(68);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[94])
					{
						// For column TP_CNTR_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(69);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[49])
					{
						// For column INELIGIBLE_IND
						String tempString;


						tempString=(String)inputRecord.get(70);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[51])
					{
						// For column INVOICE_IND
						String tempString;


						tempString=(String)inputRecord.get(71);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[122])
					{
						// For column AUTOPOPULATE_IND
						String tempString;


						tempString=(String)inputRecord.get(72);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[121])
					{
						// For column CCI_IND
						String tempString;


						tempString=(String)inputRecord.get(73);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[120])
					{
						// For column PREBILL_INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(74);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[119])
					{
						// For column BLB_INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(75);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[118])
					{
						// For column CONTRACT_TYPE
						String tempString;


						tempString=(String)inputRecord.get(76);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[117])
					{
						// For column OCPS
						String tempString;


						tempString=(String)inputRecord.get(77);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[116])
					{
						// For column CPS
						String tempString;


						tempString=(String)inputRecord.get(78);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[115])
					{
						// For column S_S_DISCOUNT_AMOUNT5
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(79);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[114])
					{
						// For column S_S_DISCOUNT_AMOUNT4
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(80);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[113])
					{
						// For column S_S_DISCOUNT_AMOUNT3
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(81);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[112])
					{
						// For column S_S_DISCOUNT_AMOUNT2
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(82);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[111])
					{
						// For column S_S_DISCOUNT_AMOUNT1
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(83);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[110])
					{
						// For column S_S_ANNV_AMOUNT5
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(84);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[109])
					{
						// For column S_S_ANNV_AMOUNT4
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(85);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[108])
					{
						// For column S_S_ANNV_AMOUNT3
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(86);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[107])
					{
						// For column S_S_ANNV_AMOUNT2
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(87);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[106])
					{
						// For column S_S_EXTEND_CNTR_IND
						String tempString;


						tempString=(String)inputRecord.get(88);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[105])
					{
						// For column GROUP_NAME
						String tempString;


						tempString=(String)inputRecord.get(89);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[104])
					{
						// For column SUBMITTED_BY
						String tempString;


						tempString=(String)inputRecord.get(90);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[103])
					{
						// For column PROPOSAL_CONTENT
						String tempString;


						tempString=(String)inputRecord.get(91);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[102])
					{
						// For column S_S_DISCOUNT_SUM
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(92);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[101])
					{
						// For column S_S_ANNV_AMOUNT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(93);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[70])
					{
						// For column REG_9D_PARTNER_NO
						String tempString;


						tempString=(String)inputRecord.get(94);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[69])
					{
						// For column REG_9D_PARTNER_NAME
						String tempString;


						tempString=(String)inputRecord.get(95);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[33])
					{
						// For column CUM_VALUE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(96);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column CAP_VARIANCE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(97);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[57])
					{
						// For column ORG_VAR_CNTR_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(98);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[96])
					{
						// For column VAR_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(99);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[97])
					{
						// For column VAR_IND
						String tempString;


						tempString=(String)inputRecord.get(100);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[75])
					{
						// For column REG_SOLD_TO_P_ASNO
						String tempString;


						tempString=(String)inputRecord.get(101);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[71])
					{
						// For column REG_BILL_TO_P_ASNO
						String tempString;


						tempString=(String)inputRecord.get(102);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[79])
					{
						// For column REG_PAYER_ASNO
						String tempString;


						tempString=(String)inputRecord.get(103);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[83])
					{
						// For column REG_SHIP_TO_P_ASNO
						String tempString;


						tempString=(String)inputRecord.get(104);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[93])
					{
						// For column SUPPRESS_INVOICE
						String tempString;


						tempString=(String)inputRecord.get(105);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[41])
					{
						// For column ESW_FETCH_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(106);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[42])
					{
						// For column ESW_FETCH_TIME
						java.sql.Time tempTime;


						tempTime=(java.sql.Time)inputRecord.get(107);
						if(tempTime != null){
							pstmt.setTime(stmtIndex,tempTime);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIME);
						stmtIndex++;

					}
					if (changedFieldIndexes[48])
					{
						// For column GSA_IND
						String tempString;


						tempString=(String)inputRecord.get(108);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[46])
					{
						// For column FREE_TEXT
						String tempString;


						tempString=(String)inputRecord.get(109);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[53])
					{
						// For column LOCKED_BY
						String tempString;


						tempString=(String)inputRecord.get(110);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[98])
					{
						// For column LOCKED_ON
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(111);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[60])
					{
						// For column PO_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(112);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[56])
					{
						// For column PO_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(113);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column ANNV_AMOUNT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(114);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column CNTR_NEWRENEW_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(115);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column BILLING_BLOCK
						String tempString;


						tempString=(String)inputRecord.get(116);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column CNTR_PERIOD_VAR_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(117);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[28])
					{
						// For column CNTR_VAR_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(118);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[38])
					{
						// For column DEVIATING_DATE_RULE
						String tempString;


						tempString=(String)inputRecord.get(119);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[88])
					{
						// For column S_S_EXCLUDED
						String tempString;


						tempString=(String)inputRecord.get(120);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[99])
					{
						// For column CNTR_REPL_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(121);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[100])
					{
						// For column FIN_CNTR_NO
						String tempString;


						tempString=(String)inputRecord.get(122);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[123])
					{
						// For column SALES_GROUP
						String tempString;


						tempString=(String)inputRecord.get(123);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[124])
					{
						// For column CHANNEL_ROLE
						String tempString;


						tempString=(String)inputRecord.get(124);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[125])
					{
						// For column SUBMITTER_ROLE
						String tempString;


						tempString=(String)inputRecord.get(125);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[126])
					{
						// For column PAYMENTMETHOD
						String tempString;


						tempString=(String)inputRecord.get(126);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[127])
					{
						// For column DISCOUNT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(127);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(5);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					// optimistic predicate columns
					{
						// For column ADD_VALUE_DAYS
						Integer tempInteger;


						tempInteger=(Integer)oldValues[0];
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;
						}

					}
					{
						// For column TVM_RATE
						Double tempDouble;


						tempDouble=(Double)oldValues[1];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column GROWTH_FACTOR
						Double tempDouble;


						tempDouble=(Double)oldValues[2];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column SPECIAL_RATE
						Double tempDouble;


						tempDouble=(Double)oldValues[3];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column INVOICE_AMOUNT
						Double tempDouble;


						tempDouble=(Double)oldValues[4];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column CAP_AMOUNT
						Double tempDouble;


						tempDouble=(Double)oldValues[5];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column CAP_PLUS
						Double tempDouble;


						tempDouble=(Double)oldValues[6];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column CAP_MINUS
						Double tempDouble;


						tempDouble=(Double)oldValues[7];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column PRE_TVM
						Double tempDouble;


						tempDouble=(Double)oldValues[8];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column CNTR_AMDT_NO
						Double tempDouble;


						tempDouble=(Double)oldValues[9];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column INVOICE_AMOUNT_SEM
						Double tempDouble;


						tempDouble=(Double)oldValues[10];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column INVOICE_AMOUNT_ANN
						Double tempDouble;


						tempDouble=(Double)oldValues[11];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column INVOICE_AMOUNT_MON
						Double tempDouble;


						tempDouble=(Double)oldValues[12];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column INVOICE_AMOUNT_QRT
						Double tempDouble;


						tempDouble=(Double)oldValues[13];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column PRE_TVM_INV_AMT
						Double tempDouble;


						tempDouble=(Double)oldValues[14];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_DISCOUNT_AMOUNT5
						Double tempDouble;


						tempDouble=(Double)oldValues[15];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_DISCOUNT_AMOUNT4
						Double tempDouble;


						tempDouble=(Double)oldValues[16];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_DISCOUNT_AMOUNT3
						Double tempDouble;


						tempDouble=(Double)oldValues[17];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_DISCOUNT_AMOUNT2
						Double tempDouble;


						tempDouble=(Double)oldValues[18];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_DISCOUNT_AMOUNT1
						Double tempDouble;


						tempDouble=(Double)oldValues[19];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_ANNV_AMOUNT5
						Double tempDouble;


						tempDouble=(Double)oldValues[20];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_ANNV_AMOUNT4
						Double tempDouble;


						tempDouble=(Double)oldValues[21];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_ANNV_AMOUNT3
						Double tempDouble;


						tempDouble=(Double)oldValues[22];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_ANNV_AMOUNT2
						Double tempDouble;


						tempDouble=(Double)oldValues[23];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_DISCOUNT_SUM
						Double tempDouble;


						tempDouble=(Double)oldValues[24];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_ANNV_AMOUNT
						Double tempDouble;


						tempDouble=(Double)oldValues[25];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column CUM_VALUE
						Double tempDouble;


						tempDouble=(Double)oldValues[26];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column CAP_VARIANCE
						Double tempDouble;


						tempDouble=(Double)oldValues[27];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column ANNV_AMOUNT
						Double tempDouble;


						tempDouble=(Double)oldValues[28];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column CNTR_NEWRENEW_NO
						Integer tempInteger;


						tempInteger=(Integer)oldValues[29];
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;
						}

					}
					{
						// For column CNTR_PERIOD_VAR_NO
						Integer tempInteger;


						tempInteger=(Integer)oldValues[30];
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;
						}

					}
					{
						// For column CNTR_VAR_NO
						Integer tempInteger;


						tempInteger=(Integer)oldValues[31];
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;
						}

					}
					{
						// For column CNTR_REPL_NO
						Integer tempInteger;


						tempInteger=(Integer)oldValues[32];
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;
						}

					}
					{
						// For column DISCOUNT
						Double tempDouble;


						tempDouble=(Double)oldValues[33];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					if (executeUpdate(connection, pstmt, updateQuery)==0)
						throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

				}
			}
		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
}
