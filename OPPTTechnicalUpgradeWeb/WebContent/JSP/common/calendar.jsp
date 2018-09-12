<!--(C) Copyright IBM Corp. 2004, 2005  All Rights Reserved  -->
<%--
 /*****************************************************************************
  * Copyright (c) 2006 by IBM corporation 
  * Author: Gillian L. Burnett
  *
  * This JSP builds a small calendar intended to be opened in a pop-up window. 
  * One month is displayed, with links to move forward and back between months.
  * Certain dates may be disabled, depending upon optional input parameters 
  * passed to the JSP. When an active date is clicked, a form element on the 
  * opening page is populated with the selected date.
  *
  * The JSP has five input parameters that control the month and year that
  * are displayed, and which dates are displayed as links and which are 
  * disabled. 
  *
  * Starting Month/Year
  *   The month and year to display can be explicitly set by
  *   passing the input parameters VIEW_MONTH and VIEW_YEAR, which will 
  *   override any other default calculations. These parameters are used when
  *   moving between months via the previous and next links on the calendar. If
  *   you would like the calendar to start at a particular month & year, you 
  *   should pass these parameters to the JSP.
  *
  *   If VIEW_MONTH and/or VIEW_YEAR are not supplied, the JSP checks to see if
  *   a full date range or start date only date range exists. If one exists, 
  *   and the start date of the range is after today's date, then the calendar 
  *   will start at the month & year of the range's start date. 
  *
  *   In all other cases, the calendar defaults to the current month and year.
  *   
  * Linked/Disabled Dates
  *   Which dates are displayed as links and which are disabled is controlled 
  *   by the combination of three input parameters: VALID_DATE_START, 
  *   VALIDATE_DATE_END, and ALLOW_PAST_DATES. 
  *
  *   If valid values for both the start date and end date of a range are 
  *   provided, a full date range will be used and only the dates which fall 
  *   within the range will be displayed as links. If valid dates are passed 
  *   for both values, but the end date is before the start date, the entire 
  *   range will be disregarded. If both dates are passed, but only one of the
  *   dates is valid, the invalid date will be disregarded and a start date 
  *   only or end date only range will be used. Pass only a start date or only
  *   an end date to explicitly use a start date only or end date only range.
  *   
  *   In addition to the date ranges, the ALLOW_PAST_DATES input parameter 
  *   allows you to toggle whether dates prior to today's date are disabled or 
  *   not. This parameter can be toggled on/off regardless of the type of date
  *   range used, or whether a range is used at all. However, if a date range 
  *   is supplied, it will always take precedence over ALLOW_PAST_DATES. So, 
  *   if a date falls outside of the supplied date range, it will always be 
  *   disabled, regardless of the ALLOW_PAST_DATES setting. But if a date falls
  *   within the date range and is prior to today, then the ALLOW_PAST_DATES 
  *   setting will determine whether that date is disabled or not.
  *   
  * Input Parameters
  *   SOURCE_OBJ - Required. The name of the text field on the opening page 
  *     that will be populated with the date selected. This value must be fully
  *     qualified (i.e., document.FormName.FieldName)
  *   
  *   VIEW_MONTH - Optional. If supplied, this value is used as the month to
  *     display.
  *
  *   VIEW_YEAR - Optional. If supplied, this value is used as the year to
  *     display.
  *
  *   VALID_DATE_START - Optional. If a valid value is supplied, this date will
  *     be used as the start date of the valid date range. This date may be
  *     supplied with or without an end date.
  *
  *   VALIDATE_DATE_END - Optional.If a valid value is supplied, this date will
  *     be used as the end date of the valid date range. This date may be
  *     supplied with or without a start date.
  *
  *   ALLOW_PAST_DATES - Optional. If "true" is supplied (case-insensitive),
  *     any date prior to today will be displayed as a link, as long as the 
  *     date falls within any supplied range. If the parameter is not supplied,
  *     or has any value other than "true", dates prior to the today's date 
  *     will be disabled.
  *
  ****************************************************************************/
--%>
<%-- Java API Packages --%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>

<%
 /**
  * For a typical web application, these constants should be created
  * in a Java class, rather than directly in the JSP.
  * 
  * They are included here for simplicity of this asset.
  **/

  final String SOURCE_OBJ = "sourceObj";
  final String VIEW_MONTH = "viewMonth";
  final String VIEW_YEAR = "viewYear";
  final String VALID_DATE_START = "validStart";
  final String VALID_DATE_END = "validEnd";
  final String ALLOW_PAST_DATES = "allowPast";
%>

<%
  //Get input parameters from the request
  String sourceObject = request.getParameter(SOURCE_OBJ);
  if(sourceObject == null || sourceObject.trim().length() <= 0) {
    throw new Exception("Missing input parameter: " + SOURCE_OBJ);
  }
  String reqMonthView = request.getParameter(VIEW_MONTH);
  String reqYearView = request.getParameter(VIEW_YEAR);
  String reqValidStart = request.getParameter(VALID_DATE_START);
  String reqValidEnd = request.getParameter(VALID_DATE_END);
  String reqAllowPastDates = request.getParameter(ALLOW_PAST_DATES);

  //Create date formatters
  SimpleDateFormat sdfFullNumeric = new SimpleDateFormat("MM/dd/yyyy");
  SimpleDateFormat sdfMonthName = new SimpleDateFormat("MMM");
  
  //Instantiate the Calendar object that we will use for building the calendar
  Calendar cView = Calendar.getInstance();

  //Get the date parts of the current date from the Calendar object
  int monthCurrent = cView.get(Calendar.MONTH);
  int dayCurrent = cView.get(Calendar.DATE);
  int yearCurrent = cView.get(Calendar.YEAR);

  //Clear the calendar so all time fields are set to zero.
  //Reset the calendar's date using the current date parts
  cView.clear();
  cView.set(yearCurrent, monthCurrent, dayCurrent);

  //Create a date object using the Calendar to store the current date
  Date dCurrent = cView.getTime();

  //Try parsing the start date passed in on the request.
  Date dValidStart = null;
  try {
    dValidStart = sdfFullNumeric.parse(reqValidStart);
  }
  catch(NullPointerException e) {
    //Ignore any null pointer exceptions that may occur
    //dValidStart is still null, so a start date won't be used
  }
  catch(java.text.ParseException e) {
    //Ignore any parsing exceptions that may occur
    //dValidStart is still null, so a start date won't be used
  }
  
  Date dValidEnd = null;
  try {
    dValidEnd = sdfFullNumeric.parse(reqValidEnd);
  }
  catch(NullPointerException e) {
    //Ignore any null pointer exceptions that may occur
    //dValidStart is still null, so a start date won't be used
  }
  catch(java.text.ParseException e) {
    //Ignore any parsing exceptions that may occur
    //dValidEnd is still null, so an end date won't be used
  }

  boolean validRangeExists = false;
  boolean validStartExists = false;
  boolean validEndExists = false;
  boolean allowPastDates = false;
  
  if(dValidStart != null && dValidEnd != null &&  dValidEnd.compareTo(dValidStart) >= 0) {
    //A valid range exists if both start and end dates have a value and 
    //the end date is the same as or after the start date.
    validRangeExists = true;
  }
  else if(dValidStart != null && dValidEnd == null) {
    //If a valid start date exists and a valid end date does not, we will use
    //a start date only
    validStartExists = true;
  }
  else if(dValidEnd != null && dValidStart == null) {
    //If a valid end date exists and a valid start date does not, we will use
    //an end date only
    validEndExists = true;
  }
  
  if(reqAllowPastDates != null && reqAllowPastDates.equalsIgnoreCase("true")) {
    //Set allowPastDates boolean based on whether it was sent in the request
    allowPastDates = true;
  }


  Calendar cTemp = Calendar.getInstance();  
  int monthView, yearView;

  //Set the month to display
  if(reqMonthView != null && reqMonthView.trim().length() > 0)
  {
    //If monthView was passed in the request, use that value
    monthView = Integer.parseInt(reqMonthView);
  }
  else if((validRangeExists || validStartExists) && dValidStart.after(dCurrent))
  {
    //If a full range or start-date only range exists and the start date is 
    //after the current date, use the month of the start date
    cTemp.setTime(dValidStart);
    monthView = cTemp.get(Calendar.MONTH);
  }
  else
  {
    //Otherwise, use the month of the current date
    cTemp.setTime(dCurrent);
    monthView = cTemp.get(Calendar.MONTH);
  }
  
  //Set the year to display
  if(reqYearView != null && reqYearView.trim().length() > 0)
  {
    //If yearView was passed in the request, use that value
    yearView = Integer.parseInt(reqYearView);
  }
  else if((validRangeExists || validStartExists) && dValidStart.after(dCurrent))
  {
    ////If a full range or start-date only range exists and the start date is 
    //after the current date, use the year of the start date
    cTemp.setTime(dValidStart);
    yearView = cTemp.get(Calendar.YEAR);
  }
  else
  {
    //Otherwise, use the year of the current date
    cTemp.setTime(dCurrent);
    yearView = cTemp.get(Calendar.YEAR);
  }

  //Clear the calendar so all time fields are set to zero.
  //Set the calendar's time to the first day of the month and year we are going to view.
  //Set a Date object to the calendar's time.
  cView.clear();
  cView.set(yearView, monthView, 1);
  Date dView = cView.getTime();

  //Format the month name and put into a variable
  String monthName = sdfMonthName.format(dView);
  
  //Determine the correct values for the previous and next month and year
  int monthPrev = monthView == Calendar.JANUARY ? Calendar.DECEMBER : monthView - 1;
  int monthNext = monthView == Calendar.DECEMBER ? Calendar.JANUARY : monthView + 1;
  int yearPrev = monthView == Calendar.JANUARY ? yearView - 1 : yearView;
  int yearNext = monthView == Calendar.DECEMBER ? yearView + 1 : yearView;
  
  int dyearPrev = yearView - 1 ;
  int dyearNext = yearView + 1;

  //Build the URLs for the previous and next links
  String prevLink = "calendar.jsp?" + 
                    VIEW_MONTH + "=" + monthPrev + "&" + 
                    VIEW_YEAR + "=" + yearPrev + "&" + 
                    SOURCE_OBJ + "=" + URLEncoder.encode(sourceObject);
  String nextLink = "calendar.jsp?" + 
                    VIEW_MONTH + "=" + monthNext + "&" + 
                    VIEW_YEAR + "=" + yearNext + "&" + 
                    SOURCE_OBJ + "=" + URLEncoder.encode(sourceObject);
                    
  String prevYearLink = "calendar.jsp?" + 
                    VIEW_MONTH + "=" + monthView + "&" + 
                    VIEW_YEAR + "=" + dyearPrev + "&" + 
                    SOURCE_OBJ + "=" + URLEncoder.encode(sourceObject);           
  
  String nextYearLink = "calendar.jsp?" + 
                    VIEW_MONTH + "=" + monthView + "&" + 
                    VIEW_YEAR + "=" + dyearNext + "&" + 
                    SOURCE_OBJ + "=" + URLEncoder.encode(sourceObject);                       
                           
  
  if(validRangeExists) {
    prevLink += "&amp;" + VALID_DATE_START + "=" +  URLEncoder.encode(sdfFullNumeric.format(dValidStart)) +
                "&amp;" + VALID_DATE_END + "=" + URLEncoder.encode(sdfFullNumeric.format(dValidEnd));
    nextLink += "&amp;" + VALID_DATE_START + "=" +  URLEncoder.encode(sdfFullNumeric.format(dValidStart)) +
                "&amp;" + VALID_DATE_END + "=" + URLEncoder.encode(sdfFullNumeric.format(dValidEnd));
  }
  else if(validStartExists) {
    prevLink += "&amp;" + VALID_DATE_START + "=" +  URLEncoder.encode(sdfFullNumeric.format(dValidStart));
    nextLink += "&amp;" + VALID_DATE_START + "=" +  URLEncoder.encode(sdfFullNumeric.format(dValidStart));
  }
  else if(validEndExists) {
    prevLink += "&amp;" + VALID_DATE_END + "=" + URLEncoder.encode(sdfFullNumeric.format(dValidEnd));
    nextLink += "&amp;" + VALID_DATE_END + "=" + URLEncoder.encode(sdfFullNumeric.format(dValidEnd));
  }
  
  if(allowPastDates) {
    prevLink += "&" + ALLOW_PAST_DATES + "=true";
    nextLink += "&" + ALLOW_PAST_DATES + "=true";
    prevYearLink += "&" + ALLOW_PAST_DATES + "=true";
    nextYearLink += "&" + ALLOW_PAST_DATES + "=true";

  }  
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="description" content="BH-OPPT Calendar" />
<meta name="keywords" content="BH-OPPT, Index page" />
<meta name="owner" content="OPPT@us.ibm.com" />
<meta name="robots" content="noindex,nofollow" />
<meta name="security" content="private" />
<meta name="source" content="w3 v8 template generator" />
<meta name="ibm.country" content="US" />
<meta name="dc.date" scheme="iso8601" content="2003-08-28" />
<meta name="dc.language" scheme="rfc1766" content="en-US" />
<meta name="dc.rights" content="Copyright (c) 2005 by IBM Corporation" />
<meta name="ibm.industry" scheme="IBM_IndustryTaxonomy" content="B" />
<meta name="ibm.effective" scheme="W3CDTF" content="2004-09-15" />
<meta name="feedback" content="OPPT@us.ibm.com" />
<!-- Licensed Materials - Property of IBM, 5724-B88, (C) Copyright IBM Corp. 2003, 2004 - All Rights reserved. -->
<title>BH-OPPT | Calendar</title>
<script type="text/javascript" language = "Javascript1.2" src="//w3.ibm.com/ui/v8/scripts/scripts.js"></script>
<link href="http://1.w3.s81c.com/common/v17/css/w3.css" rel="stylesheet" title="w3" type="text/css" />
<script src="http://1.w3.s81c.com/common/js/dojo/w3.js" type="text/javascript">//</script>
<script language="JavaScript" type="text/javascript">
  <!--
  
  function callPrevYear(option)
  {
	document.form1.action="<%=prevYearLink%>";
	document.form1.method="post";
	document.form1.submit();
  }  
  function callPrevMonth(option)
  {
	document.form1.action="<%=prevLink %>";
	document.form1.method="post";
	document.form1.submit();
  }  
  
  function callNextMonth(option)
  {
    document.form1.action="<%=nextLink %>";
	document.form1.method="post";
	document.form1.submit();
  }  
  
  function callNextYear(option)
  {
    document.form1.action="<%=nextYearLink %>";
	document.form1.method="post";
	document.form1.submit();
  }  
  
  function selectDate(strDate)
  {
    objSource = eval("self.opener.<%= sourceObject %>");
    objSource.value = strDate;
    window.close();
  }
  //-->
  </script>
</head>

<body bgcolor="#ffffff" alink="#cceeff" marginheight="0" marginwidth="0" topmargin="0" leftmargin="0">
<form name="form1" method="post" action="">
<table border="0" cellspacing="0" cellpadding="10" align="center" width="100%"><tr><td>
  <table border="1" cellspacing="0" cellpadding="0"><tr><td>
              <table border="1" cellspacing="0" cellpadding="0" bordercolor="#4477BB">
                <tr>
      <td class="calHeader" colspan="7">
        <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <tr><td>&nbsp;</td></tr>
        <tr>
          <td width="20%" height="20">
                          <input type="button" name="prevMonth" value="Prev year " onclick="callPrevYear()" />
                        </td>  
                        <td width="20%" height="20">
                          <input type="button" name="prevYear" value="Prev month" onclick="callPrevMonth()" />
                        </td>
          <td width="20%"><strong><%= sdfMonthName.format(dView) %> <%= yearView %></strong></td>
          <td width="20%">
                          <input type="button" name="nextMonth" value="Next month" onclick="callNextMonth()" />
                        </td>  
          <td width="20%">
                          <input type="button" name="nextYear" value="Next year" onclick="callNextYear()" />
                        </td> 
        </tr>
        </table>
      </td>
    </tr>
    <tr>
                  <td style=background-color:#cccccc; class="bar-blue-med" height="20" width="45">Sun</td>
                  <td style=background-color:#cccccc; class="bar-blue-med" height="20" width="56">Mon</td>
                  <td style=background-color:#cccccc; class="bar-blue-med" height="20" width="45">Tue</td>
                  <td style=background-color:#cccccc; class="bar-blue-med" height="20" width="58">Wed</td>
                  <td style=background-color:#cccccc; class="bar-blue-med" height="20" width="41">Thr</td>
                  <td style=background-color:#cccccc; class="bar-blue-med" height="20" width="36">Fri</td>
                  <td style=background-color:#cccccc; class="bar-blue-med" height="20" width="40">Sat</td>
    </tr>                                                          
    <%
    //Move through the calendar backwards until the most recent 
    //Sunday is reached
    while(cView.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
    {
      cView.add(Calendar.DATE, -1);
    }
    
    //Move through the calendar forwards, building the calendar HTML,
    //until the first day of the next month is reached
    boolean beginWeek = false;
    boolean endWeek = false;
    boolean showBlank = false;
    boolean showLink = false;
    while(cView.get(Calendar.MONTH) != monthNext)
    {
      //Set the date object to the Calendar's date
      dView = cView.getTime();
      
      //Set a boolean to start a new week if the date is a Sunday
      beginWeek = cView.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? true : false;
      
      //Set a boolean to end the week if the date is a Saturday
      endWeek = cView.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ? true : false;
      
      //Set a boolean to show a blank cell if the date's month is not the month being displayed
      showBlank = cView.get(Calendar.MONTH) != monthView ? true : false;

      //Set a boolean to determine whether the date should be displayed as a link
      //or deactivated
      if(!allowPastDates && dView.compareTo(dCurrent) < 0) {
        //If past dates are not allowed and the date to display is
        //prior to today, do not show the date as a link
        showLink = false;
      }
      else {
        //Otherwise, do some more date range checking
        
        if(validRangeExists) {
          //If a full date range exists, show the date as a link if
          //it is after or the same as the start date, and if it is
          //before or the same as the end date
          if(dView.compareTo(dValidStart) >= 0 && dView.compareTo(dValidEnd) <= 0) {
            showLink = true;
          }
          else {
            showLink = false;
          }
        }
        else if(validStartExists) {
            //If a start date only range exists, show the date as a link if
            //it is after or the same as the start date
          if(dView.compareTo(dValidStart) >= 0) {
            showLink = true;
          }
          else {
            showLink = false;
          }
        }
        else if(validEndExists) {
          //If an end date only range exists, show the date as a link if
          //it is before or the same as the end date
          if(dView.compareTo(dValidEnd) <= 0) {
            showLink = true;
          }
          else {
            showLink = false;
          }
          
        }
        else {
          //Otherwise there is no range at all
          showLink = true;
        }
      }

      if(beginWeek)
      {
    %>
    <tr>
    <% 
      }
      
      if(showBlank)
      {
    %>
                  <td height="20" width="45">&nbsp;</td>
    <% 
      }
      else if(showLink)
      {
    %>
                  <td height="20" width="56" align="center"><a href="javascript:selectDate('<%= sdfFullNumeric.format(dView) %>')"><%= cView.get(Calendar.DATE) %></a></td>
    <% 
      }
      else
      {
    %>
                  <td height="25" width="45"><%= cView.get(Calendar.DATE) %></td>
    <% 
      }  
      
      if(endWeek)
      {
    %>
    </tr>
    <% 
      }
      
      cView.add(Calendar.DATE, 1);

    } /* END WHILE LOOP THROUGH CURRENT MONTH */
    
    //Build remaining empty table cells needed to complete the calendar
    while(cView.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
    {
      endWeek = cView.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ? true : false;
    %>  
                  <td width="45">&nbsp;</td>
    <%
      if(endWeek)
      {
    %>
   
    <% 
      }
    
      cView.add(Calendar.DATE, 1);
    }
    %>
    </table>
  </td></tr></table>
</td></tr></table>
</form>
</body>
</html>