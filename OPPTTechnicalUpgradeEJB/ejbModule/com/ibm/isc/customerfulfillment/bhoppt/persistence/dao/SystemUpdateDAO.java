/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * This DAO is responsible for system updates in User Administration  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 28, 2003 
 * 
 * Revision #1
 * 
 *    All delete calls are removed as those tables have a relationship with other tables.
 *    Changed by Muruga.
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class SystemUpdateDAO extends OPPTDAO
{
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "SystemUpdateDAO";

	private static final String SALES_ORG_SELECT = "select sales_org from BH.sales_org where sales_org = ?";
	private static final String SALES_AREA_SELECT =
		"select sales_org from BH.salesarea where sales_org = ? and dstr_channel = ? and division_code = ? ";
	private static final String DSTR_CHANNEL_SELECT =
		"select dstr_channel from BH.dstr_channel where dstr_channel = ?";
	private static final String DIVISION_SELECT = "select division_code from BH.division where division_code = ?";
	private static final String CURRENCY_SELECT = "select currency_code from BH.currency where currency_code = ?";
	private static final String PAYMENT_TERM_SELECT =
		"select payment_term from BH.paymentterm where payment_term = ?";
	private static final String BILLING_TYPE_SELECT = "select billing_type from BH.billingtype where billing_type = ?";
	private static final String BILLING_BLOCK_SELECT =
		"select billing_block from BH.billingblock where billing_block = ?";
	

	private static final String SALES_ORG_UPDATE =
		"update BH.sales_org set sales_org_desc = ?, default_currency = ? where sales_org = ?";
	private static final String SALES_AREA_UPDATE =
		"update BH.salesarea set sales_org = ?, dstr_channel = ?, division_code = ? where sales_org = ? and dstr_channel = ? and division_code = ? ";
	private static final String DSTR_CHANNEL_UPDATE =
		"update BH.dstr_channel set dstr_channel_desc = ? where dstr_channel = ?";
	private static final String DIVISION_UPDATE =
		"update BH.division set division_desc = ? where division_code = ?";
	private static final String CURRENCY_UPDATE =
		"update BH.currency set currency_name = ?, decimal_allowed = ? where currency_code = ?";
	private static final String PAYMENT_TERM_UPDATE =
		"update BH.paymentterm set payment_term_desc = ? where payment_term = ?";
	
	
	private static final String BILLING_TYPE_UPDATE =
		"update BH.billingtype set billing_desc = ? where billing_type = ?";
	private static final String BILLING_BLOCK_UPDATE =
		"update BH.billingblock set billing_block_desc = ? where billing_block = ?";
	

	
	
//	Added by Srinivas-------OPPTBH-DAD003
	
	private static final String BLB_INDICATOR_SELECT = "select blb_type from BH.blbindicator where blb_type = ?";
//	Added by Srinivas-------OPPTBH-DAD003	
	private static final String BLB_INDICATOR_UPDATE = "update BH.blbindicator set blb_desc = ? where blb_type = ?";
//	Added by Srinivas-------OPPTBH-DAD003	
	private static final String BLB_INDICATOR_INSERT = "insert into BH.blbindicator values(?,?)";
	
	private static final String SALES_ORG_INSERT = "insert into BH.sales_org values (?,?,?)";
	private static final String SALES_AREA_INSERT = "insert into BH.salesarea values (?,?,?)";
	private static final String DSTR_CHANNEL_INSERT = "insert into BH.dstr_channel values (?,?)";
	private static final String DIVISION_INSERT = "insert into BH.division values (?,?)";

	private static final String CURRENCY_INSERT = "insert into BH.currency values (?,?,?)";
	private static final String PAYMENT_TERM_INSERT = "insert into BH.paymentterm values (?,?)";
	private static final String BILLING_TYPE_INSERT = "insert into BH.billingtype values (?,?)";
	private static final String BILLING_BLOCK_INSERT = "insert into BH.billingblock values (?,?)";

	/** 
	 * SystemUpdateDAO Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public SystemUpdateDAO()
	{
	}

	/**
	 * This method is used to update SalesOrg  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * @param salesOrg
	 * @param salesOrgDesc
	 * @param defaultCurrency 
	 * @return void
	 * @throws DomainException 
	 */

	public static void updateSalesOrg(String salesOrg, String salesOrgDesc, String defaultCurrency)
		throws DomainException
	{
		String methodName = "updateSalesOrg";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = getConnection();

			preparedStatement = connection.prepareStatement(SALES_ORG_SELECT);
			preparedStatement.setString(1, salesOrg);

			if (checkForExistence(preparedStatement))
			{
				preparedStatement = connection.prepareStatement(SALES_ORG_UPDATE);

				preparedStatement.setString(1, salesOrgDesc);
				preparedStatement.setString(2, defaultCurrency);
				preparedStatement.setString(3, salesOrg);
			}
			else
			{
				preparedStatement = connection.prepareStatement(SALES_ORG_INSERT);

				preparedStatement.setString(1, salesOrg);
				preparedStatement.setString(2, salesOrgDesc);
				preparedStatement.setString(3, defaultCurrency);
			}

			preparedStatement.executeUpdate();
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		finally
		{
			closeConnection(connection, null, preparedStatement);
		}
	}

	private static boolean checkForExistence(PreparedStatement preparedStatement) throws DomainException
	{
		String methodName = "checkForExistence";

		ResultSet rs = null;
		boolean isExisting = false;

		try
		{
			rs = preparedStatement.executeQuery(); 			
			isExisting = rs.next();

			return isExisting;
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
				}

				if (preparedStatement != null)
				{
					preparedStatement.close();
				}
			}
			catch (SQLException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
		}
	}

	/**
	 * This method is used to  update Sales Area 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * @param salesOrg
	 * @param dstrChannel
	 * @param divisionCode
	 * @return void
	 * @throws DomainException
	 */
	public static void updateSalesArea(String salesOrg, String dstrChannel, String divisionCode)
		throws DomainException
	{
		String methodName = "updateSalesArea";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = getConnection();

			preparedStatement = connection.prepareStatement(SALES_AREA_SELECT);
			preparedStatement.setString(1, salesOrg);
			preparedStatement.setString(2, dstrChannel);
			preparedStatement.setString(3, divisionCode);

			if (checkForExistence(preparedStatement))
			{
				preparedStatement = connection.prepareStatement(SALES_AREA_UPDATE);

				preparedStatement.setString(4, salesOrg);
				preparedStatement.setString(5, dstrChannel);
				preparedStatement.setString(6, divisionCode);
			}
			else
			{
				preparedStatement = connection.prepareStatement(SALES_AREA_INSERT);
			}

			preparedStatement.setString(1, salesOrg);
			preparedStatement.setString(2, dstrChannel);
			preparedStatement.setString(3, divisionCode);

			preparedStatement.executeUpdate();
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		finally
		{
			closeConnection(connection, null, preparedStatement);
		}
	}

	/**
	 * This method is used to  update Distribution Channel 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	 
	 * @param dstrChannel
	 * @param dstrChannelDesc
	 * @return void
	 * @throws DomainException
	 */

	public static void updateDstrChannel(String dstrChannel, String dstrChannelDesc) throws DomainException
	{
		String methodName = "updateDstrChannel";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = getConnection();

			preparedStatement = connection.prepareStatement(DSTR_CHANNEL_SELECT);
			preparedStatement.setString(1, dstrChannel);

			if (checkForExistence(preparedStatement))
			{
				preparedStatement = connection.prepareStatement(DSTR_CHANNEL_UPDATE);

				preparedStatement.setString(1, dstrChannelDesc);
				preparedStatement.setString(2, dstrChannel);
			}
			else
			{
				preparedStatement = connection.prepareStatement(DSTR_CHANNEL_INSERT);
				preparedStatement.setString(1, dstrChannel);
				preparedStatement.setString(2, dstrChannelDesc);
			}

			preparedStatement.executeUpdate();
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		finally
		{
			closeConnection(connection, null, preparedStatement);
		}
	}

	/**
	 * This method is used to  update Division 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *
	 * @param divisionCodeDesc
	 * @param divisionCode
	 * @return void
	 * @throws DomainException
	 */

	public static void updateDivision(String divisionCode, String divisionCodeDesc) throws DomainException
	{
		String methodName = "updateDivision";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = getConnection();

			preparedStatement = connection.prepareStatement(DIVISION_SELECT);
			preparedStatement.setString(1, divisionCode);

			if (checkForExistence(preparedStatement))
			{
				preparedStatement = connection.prepareStatement(DIVISION_UPDATE);
				preparedStatement.setString(1, divisionCodeDesc);
				preparedStatement.setString(2, divisionCode);
			}
			else
			{
				preparedStatement = connection.prepareStatement(DIVISION_INSERT);
				preparedStatement.setString(1, divisionCode);
				preparedStatement.setString(2, divisionCodeDesc);
			}
			preparedStatement.executeUpdate();
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		finally
		{
			closeConnection(connection, null, preparedStatement);
		}
	}

	/**
	 * This method is used to  update currency  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * 
	 * @param currencyCode
	 * @param currencyCodeDesc
	 * @param decimalAllowed
	 * @return void
	 * @throws DomainException 
	 */
	public static void updateCurrency(String currencyCode, String currencyCodeDesc, int decimalAllowed)
		throws DomainException
	{
		String methodName = "updateCurrency";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = getConnection();

			preparedStatement = connection.prepareStatement(CURRENCY_SELECT);
			preparedStatement.setString(1, currencyCode);

			if (checkForExistence(preparedStatement))
			{
				preparedStatement = connection.prepareStatement(CURRENCY_UPDATE);
				preparedStatement.setString(1, currencyCodeDesc);
				preparedStatement.setDouble(2, decimalAllowed);
				preparedStatement.setString(3, currencyCode);
			}
			else
			{
				preparedStatement = connection.prepareStatement(CURRENCY_INSERT);
				preparedStatement.setString(1, currencyCode);
				preparedStatement.setString(2, currencyCodeDesc);
				preparedStatement.setDouble(3, decimalAllowed);
			}

			preparedStatement.executeUpdate();
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		finally
		{
			closeConnection(connection, null, preparedStatement);
		}
	}

	/**
	 * This method is used to update Payment Term  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * @param paymentTerm
	 * @param paymentTermDesc	 
	 * @return void
	 * @throws DomainException
	 */
	public static void updatePaymentTerm(String paymentTerm, String paymentTermDesc) throws DomainException
	{
		String methodName = "updatePaymentTerm";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = getConnection();

			preparedStatement = connection.prepareStatement(PAYMENT_TERM_SELECT);
			preparedStatement.setString(1, paymentTerm);

			if (checkForExistence(preparedStatement))
			{
				preparedStatement = connection.prepareStatement(PAYMENT_TERM_UPDATE);
				preparedStatement.setString(1, paymentTermDesc);
				preparedStatement.setString(2, paymentTerm);
			}
			else
			{
				preparedStatement = connection.prepareStatement(PAYMENT_TERM_INSERT);
				preparedStatement.setString(1, paymentTerm);
				preparedStatement.setString(2, paymentTermDesc);
			}

			preparedStatement.executeUpdate();
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		finally
		{
			closeConnection(connection, null, preparedStatement);
		}
	}

	/**
	 * This method is used to  update Billing Type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * @param billingType
	 * @param billingTypeDesc	 
	 * @return void
	 * @throws DomainException
	 */
	public static void updateBillingType(String billingType, String billingTypeDesc) throws DomainException
	{
		String methodName = "updateBillingType";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = getConnection();

			preparedStatement = connection.prepareStatement(BILLING_TYPE_SELECT);
			preparedStatement.setString(1, billingType);

			if (checkForExistence(preparedStatement))
			{
				preparedStatement = connection.prepareStatement(BILLING_TYPE_UPDATE);
				preparedStatement.setString(1, billingTypeDesc);
				preparedStatement.setString(2, billingType);
			}
			else
			{
				preparedStatement = connection.prepareStatement(BILLING_TYPE_INSERT);
				preparedStatement.setString(1, billingType);
				preparedStatement.setString(2, billingTypeDesc);
			}

			preparedStatement.executeUpdate();
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		finally
		{
			closeConnection(connection, null, preparedStatement);
		}
	}

	/**
	 * This method is used to update Billing Block
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * @param billingBlock
	 * @param billingBlockDesc	 
	 * @return void
	 * @throws DomainException
	 */
	public static void updateBillingBlock(String billingBlock, String billingBlockDesc) throws DomainException
	{
		String methodName = "updateBillingBlock";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = getConnection();

			preparedStatement = connection.prepareStatement(BILLING_BLOCK_SELECT);
			preparedStatement.setString(1, billingBlock);

			if (checkForExistence(preparedStatement))
			{
				preparedStatement = connection.prepareStatement(BILLING_BLOCK_UPDATE);
				preparedStatement.setString(1, billingBlockDesc);
				preparedStatement.setString(2, billingBlock);
			}
			else
			{
				preparedStatement = connection.prepareStatement(BILLING_BLOCK_INSERT);
				preparedStatement.setString(1, billingBlock);
				preparedStatement.setString(2, billingBlockDesc);
			}
			preparedStatement.executeUpdate();
		}
		catch (SQLException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		
		finally
		{
			closeConnection(connection, null, preparedStatement);
		}
	}
	
//	Added by Srinivas-------OPPTBH-DAD003	
		public static void updateComplexTypes(String blbIndicatorType, String blbIndicatorDesc) throws DomainException
		{
			String methodName = "updateComplexTypes";

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try
			{
				connection = getConnection();
					
			preparedStatement = connection.prepareStatement(BLB_INDICATOR_SELECT);
			preparedStatement.setString(1, blbIndicatorType);
			
			if (checkForExistence(preparedStatement)) 
			{
					preparedStatement = connection.prepareStatement(BLB_INDICATOR_UPDATE);
					preparedStatement.setString(1,blbIndicatorDesc);
					preparedStatement.setString(2,blbIndicatorType );
				
				}
				else
				{  
					preparedStatement = connection.prepareStatement(BLB_INDICATOR_INSERT);
					preparedStatement.setString(1,blbIndicatorType);
					preparedStatement.setString(2,blbIndicatorDesc);
				}
				preparedStatement.executeUpdate();
//				preparedStatement = connection.prepareStatement(BLB_INDICATOR_UPDATE);
//				preparedStatement.setString(1,blbIndicatorType);
//				preparedStatement.setString(1,blbIndicatorDesc);
			}
			catch (SQLException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			
			finally
			{
				closeConnection(connection, null, preparedStatement);
			}
	}
	
}