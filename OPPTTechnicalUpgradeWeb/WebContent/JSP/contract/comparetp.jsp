
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt" %>

<%@ page import="java.util.*"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CompareTPReportViewBean"%>
<%@ page import ="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport" %>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>

<%
	Vector beanList = null;
	String newContractNo="";
	String oldContractNo="";
	ArrayList buttonFlags = null;
	
	ErrorReport errorReport = null;
	
	OPPTSession opptSession = new OPPTSession(session);
	CompareTPReportViewBean viewBean = (CompareTPReportViewBean)opptSession.getCurrentViewBean();
	
	if(null != viewBean){
		newContractNo = viewBean.getNewContractNumber();
		oldContractNo = viewBean.getOldContractNumber();
		beanList = viewBean.getSwoViewBeans();
		
		buttonFlags = viewBean.getButtonFlags();
		errorReport = viewBean.getErrorReport();
		errorReport.getErrorFieldNames();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="description" content="<tiles:getAsString name="description" />"/>
<meta name="keywords" content="BH-OPPT, Create Proposal"/>
<meta name="owner" content="OPPT@us.ibm.com"/>
<meta name="robots" content="noindex,nofollow"/>
<meta name="security" content="private"/>
<meta name="source" content="w3 v17 template generator"/>
<meta name="ibm.country" content="US"/>
<meta name="dc.date" scheme="iso8601" content="2003-08-28"/>
<meta name="dc.language" scheme="rfc1766" content="en-US"/>
<meta name="dc.rights" content="Copyright (c) 2005 by IBM Corporation"/>
<meta name="ibm.industry" scheme="IBM_IndustryTaxonomy" content="B"/>
<meta name="ibm.effective" scheme="W3CDTF" content="2004-09-15"/>
<meta name="feedback" content="OPPT@us.ibm.com"/>
<title>BH-OPPT | Contract maintenance | Comparative statement of the old contract &amp; new proposal</title>
</head>
<body>


<center>

<table border="0" lotus_anchor="A4..S14" width="100%">
	<lotus_global align="CENTER" valign="BOTTOM" lotus_format="General"
		height="19" grid="OFF" gridcolor="#cccccc"></lotus_global>
	<!-- Begin of changes by Saravanan V for CR112802661 on 12/10/2002 -->
	<tr>
		<td lotus_celltype="blank" align="center" valign="bottom" width="81"
			height="19"> &nbsp;</td>
	</tr>
	<tr>
		<td><a name="main"></a>
		<table border="0" lotus_anchor="A4..S14" width="840">
			<tr align="right" valign="bottom">
				<th lotus_celltype="LABEL" colspan="7" align="center">
				<strong>
				Comparative statement of the old contract & new proposal</strong>  </th>
			</tr>
			<tr  align="left" valign="bottom">
				<td lotus_celltype="BLANK" colspan="7">&nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<th lotus_celltype="LABEL" colspan="7" height="19"> <strong>Report
				printed on:</strong> 09-09-2003</th>
			</tr>
			<tr  align="left" valign="bottom">
				<td lotus_celltype="BLANK" colspan="7">&nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="BLANK" colspan="7">&nbsp;</td>
			</tr>
			<tr bgcolor="#ffffff" align="left" valign="bottom">
				<td lotus_celltype="BLANK" colspan="4">&nbsp;</td>
				<td lotus_celltype="LABEL"> (In new contract number)</td>
				<td lotus_celltype="LABEL"> (In old contract number)</td>
				<td lotus_celltype="BLANK" colspan="1">&nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<th lotus_celltype="LABEL" width="14%" height="19"><strong>SWO number</strong></th>
				<th lotus_celltype="LABEL" width="14%"><strong>Serial number</strong></th>
				<th lotus_celltype="LABEL" width="14%"><strong>EE no</strong></th>
				<th lotus_celltype="LABEL" width="14%"><strong>EE desc</strong></th>
				<th lotus_celltype="LABEL" width="14%"><strong>0001035P02</strong></th>
				<th lotus_celltype="LABEL" width="14%"><strong>0001035P01</strong></th>
				<th lotus_celltype="LABEL" width="14%"><strong>Change in ESW price</strong></th>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL" height="19"> 5645001</td>
				<td lotus_celltype="LABEL"> W00000T</td>
				<td lotus_celltype="LABEL"> S0012RF</td>
				<td lotus_celltype="LABEL"> OS/390 Base</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL" height="19"> &nbsp;</td>
				<td lotus_celltype="LABEL"> W000010</td>
				<td lotus_celltype="LABEL"> S0012RF</td>
				<td lotus_celltype="LABEL"> OS/390 Base</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL" height="19"> &nbsp;</td>
				<td lotus_celltype="LABEL"> W000013</td>
				<td lotus_celltype="LABEL"> S0012RF</td>
				<td lotus_celltype="LABEL"> OS/390 Base</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> W000014</td>
				<td lotus_celltype="LABEL"> S0012RF</td>
				<td lotus_celltype="LABEL"> OS/390 Base</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> W000016</td>
				<td lotus_celltype="LABEL"> S0012RF</td>
				<td lotus_celltype="LABEL"> OS/390 Base</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> 5645005</td>
				<td lotus_celltype="LABEL"> W00002Z</td>
				<td lotus_celltype="LABEL"> S000V5N</td>
				<td lotus_celltype="LABEL"> System Automation for OS/390</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> W00003R</td>
				<td lotus_celltype="LABEL"> S000V5N</td>
				<td lotus_celltype="LABEL"> System Automation for OS/390</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> &nbsp;</td>

				<td lotus_celltype="LABEL"> W00003S</td>
				<td lotus_celltype="LABEL"> S000V5N</td>
				<td lotus_celltype="LABEL"> System Automation for OS/390</td>

				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> 5645DB2</td>
				<td lotus_celltype="LABEL"> W0000F9</td>
				<td lotus_celltype="LABEL"> S00087N</td>
				<td lotus_celltype="LABEL"> DB2 UDB for OS/390</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL">&nbsp;</td>
				<td lotus_celltype="LABEL">&nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL">&nbsp;</td>

				<td lotus_celltype="LABEL"> W0000FD</td>
				<td lotus_celltype="LABEL"> S00087G</td>
				<td lotus_celltype="LABEL"> QMF HPO Buy</td>

				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> &nbsp;</td>

				<td lotus_celltype="LABEL"> W0000FJ</td>
				<td lotus_celltype="LABEL"> S00087G</td>
				<td lotus_celltype="LABEL"> QMF HPO Buy</td>
				<td lotus_celltype="LABEL" align="center">X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> 5647A01</td>
				<td lotus_celltype="LABEL"> W0000R5</td>
				<td lotus_celltype="LABEL"> S001G8D</td>
				<td lotus_celltype="LABEL"> OS/390 V2 Base</td>

				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> 5695013</td>

				<td lotus_celltype="LABEL">A1JLR</td>
				<td lotus_celltype="LABEL"> S0002RW</td>
				<td lotus_celltype="LABEL"> IBM Compiler for REXX/370</td>

				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> 5695014</td>

				<td lotus_celltype="LABEL"> A1FM2</td>
				<td lotus_celltype="LABEL"> S000DJX</td>
				<td lotus_celltype="LABEL">IBM Library for REXX/370</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL">&nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> 5695137</td>
				<td lotus_celltype="LABEL"> A19CS</td>
				<td lotus_celltype="LABEL"> S000PX4</td>
				<td lotus_celltype="LABEL"> MQSeries MVS/ESA</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL">&nbsp;</td>
				<td lotus_celltype="LABEL"> A2PV9</td>
				<td lotus_celltype="LABEL"> S000PX3</td>
				<td lotus_celltype="LABEL"> Client Attachment Feature</td>
				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> &nbsp;</td>

				<td lotus_celltype="LABEL"> A2PV9</td>
				<td lotus_celltype="LABEL"> S000PX4</td>
				<td lotus_celltype="LABEL"> MQSeries MVS/ESA</td>

				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>

			<tr align="left" valign="bottom">
				<td lotus_celltype="LABEL"> 5697B82</td>

				<td lotus_celltype="LABEL"> K94459</td>
				<td lotus_celltype="LABEL"> S001FFC</td>
				<td lotus_celltype="LABEL"> Tivoli NetView Enterprise</td>

				<td lotus_celltype="LABEL" align="center"> X</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
				<td lotus_celltype="LABEL"> &nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</center>
</body>
</html>
