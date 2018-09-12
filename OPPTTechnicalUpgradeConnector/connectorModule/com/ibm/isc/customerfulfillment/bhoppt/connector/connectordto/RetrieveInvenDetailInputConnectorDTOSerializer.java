/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorUtility;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
/** 
 * Input ConnectorDTO Serializer
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class RetrieveInvenDetailInputConnectorDTOSerializer implements InputConnectorDTOSerializerInterface
{
	private static final String DEFAULT_DATE_VALUE = "00000000"; /* NOI18N */
	private static final String DEFAULT_TIME_VALUE = "000000"; /* NOI18N */
	private RetrieveInvenDetailInputConnectorDTO dto=null;
	private int sCnt1=0,sCnt2=0,sCnt3=0;
	
	/** 
	 * Constructor
	 *  
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public RetrieveInvenDetailInputConnectorDTOSerializer()
	{
	}

	/**
	 * This method is used to parse the given object and build object
	 * a String out of it.
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param connectorDTO
	 * @return String
	 * @throws Exception
	 */
	public String createNewMsg(ConnectorDTOInterface connectorDTO) throws Exception
	{
		RetrieveInvenDetailInputConnectorDTO dto = (RetrieveInvenDetailInputConnectorDTO) connectorDTO;

		StringBuffer buffer = new StringBuffer();
		ConnectorUtility.buildMessage(dto.getGenericConnectorDTO(), buffer);
		ConnectorUtility.buildMessage(dto.getOrgConnectorDTO(), buffer);

		ConnectorUtility.buildMessage(dto.getProposalType(), buffer);
		ConnectorUtility.buildMessage(dto.getFlag(), buffer);
		ConnectorUtility.buildMessage(dto.getCurrency(), buffer);

		ConnectorUtility.buildMessage(getDateStringFor(dto.getContractStartPeriod()), buffer);
		ConnectorUtility.buildMessage(getDateStringFor(dto.getContractEndPeriod()), buffer);
		ConnectorUtility.buildMessage(getDateStringFor(dto.getLastFetchDate()), buffer);		
		ConnectorUtility.buildMessage(getDateStringFor(dto.getLastFetchTime(), false), buffer);
		ConnectorUtility.buildMessage(dto.getContractType(), buffer);
		ConnectorUtility.buildMessage(dto.getContractNumber(), buffer);
		// S and S starts
		ConnectorUtility.buildMessage(dto.getProposalContent(), buffer);
		
		// S and S ends
		//List custList = dto.getCustomerNumber();
		List custList =dto.getSelCustomerList(); 
		int c=0;
		if(dto.isSelectedInventory())
		{
		if (custList != null)
		{
			Iterator iter = custList.iterator();
		
			
			while (iter.hasNext())
			{
				CustomerListCustomDTO customerListCustomDTO=(CustomerListCustomDTO)iter.next();
			
				
				ConnectorUtility.buildMessage(customerListCustomDTO.getCustomerNumber(), buffer);
				//String sdm=getDesignatedMachineIDString(c);
				if(dto.getDesignatedMaterialID()!=null)
				{
					Map m1=dto.getDesignatedMaterialID();
				    ArrayList a1=(ArrayList)m1.get(new Integer(c));
			   	    Iterator ia1 =a1.iterator();
			   	    String si=new String();
				    
			   	    while(ia1.hasNext())
				    {
			  	    	 si=(String)ia1.next();
				    	 ConnectorUtility.buildMessage(si, buffer);
				  	}
				
			    }
				if(dto.getMaterialID()!=null)
				{
					Map m1=dto.getMaterialID();
				    ArrayList a1=(ArrayList)m1.get(new Integer(c));
			   	    Iterator ia1 =a1.iterator();
			   	    String si=new String();
				    
			   	    while(ia1.hasNext())
				    {
			  	    	 si=(String)ia1.next();
				    	 ConnectorUtility.buildMessage(si, buffer);
				  	}
				
			    }
				if(dto.getSerialNumber()!=null)
				{
					Map m1=dto.getSerialNumber();
				    ArrayList a1=(ArrayList)m1.get(new Integer(c));
			   	    Iterator ia1 =a1.iterator();
			   	    String si=new String();
				    
			   	    while(ia1.hasNext())
				    {
			  	    	 si=(String)ia1.next();
				    	 ConnectorUtility.buildMessage(si, buffer);
				  	}
				
			    }
			    
			    
				c++;
				
			}
		}
		if (custList.size() == 0)
		{
			ConnectorUtility.buildMessage("", buffer);
		}
		}else{
		
		if (custList != null)
		{
			Iterator iter = custList.iterator();
			
			while (iter.hasNext())
			{
				CustomerListCustomDTO customerListCustomDTO=(CustomerListCustomDTO)iter.next();
				ConnectorUtility.buildMessage(customerListCustomDTO.getCustomerNumber(), buffer);
				for(int i=0;i<15;i++){
				ConnectorUtility.buildMessage(" ", buffer);
				}
			}
			
			if (custList.size() == 0)
			{
				ConnectorUtility.buildMessage("", buffer);
			}
		}
		}
		
		return buffer.toString();
	}
	
	/**
	 * To get the date string for the given date with a oppt date format  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aDate
	 * @param isDate
	 * @return Formatted date string
	 */
	private String getDateStringFor(Date aDate, boolean isDate)
	{
		String format = ConnectorConstants.DATE_FORMAT;
		
		if (isDate == false)
			format = ConnectorConstants.TIME_FORMAT;
		
		String date =
			ConnectorUtility.getDateByFormat(aDate, format);
		
		if (date == null || date.trim().length() == 0)
		{
			if (isDate)
				date = DEFAULT_DATE_VALUE;
			else
				date = DEFAULT_TIME_VALUE;
		}
		
		return date;
	}
	
	/**
	 * To get the date string for the given date with a oppt date format  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aDate
	 * @return Formatted date string
	 */
	private String getDateStringFor(Date aDate)
	{
		return getDateStringFor(aDate, true);
	}
}
