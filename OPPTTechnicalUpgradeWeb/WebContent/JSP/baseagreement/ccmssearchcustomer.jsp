<!-- Copyright (c) 2006 by IBM corporation -->

<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/oppt-tags.tld" prefix="oppt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CCMSCustomerSelectionViewBean"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CCMSCustomerSelectionActionForm"%>
<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CCMSApplyToBaseAgreementActionForm"%>
<%  
	HashSet errorValues = null;
	CCMSCustomerSelectionViewBean viewBean = null;
    OPPTSession opptSession = new OPPTSession(session);
  
	if(null != opptSession.getCurrentViewBean() && opptSession.getCurrentViewBean() instanceof CCMSCustomerSelectionViewBean) {
		viewBean = (CCMSCustomerSelectionViewBean) opptSession.getCurrentViewBean();
	}else {
		viewBean = new CCMSCustomerSelectionViewBean();
	}
	if (null == viewBean) {
		return;
	}
	
	CCMSCustomerSelectionActionForm actionForm = new CCMSCustomerSelectionActionForm();
	if(viewBean.getActionForm() != null && viewBean.getActionForm() instanceof CCMSCustomerSelectionActionForm) {
		actionForm = (CCMSCustomerSelectionActionForm) viewBean.getActionForm();
	}
	
	String sapCustomerNumber =null;
	ErrorReport errorReport = viewBean.getErrorReport();
	errorValues = errorReport.getErrorFieldNames();
	HashSet errorLabels = errorReport.getErrorFieldNames();
	
	if(viewBean.getActionForm() != null && viewBean.getActionForm() instanceof CCMSApplyToBaseAgreementActionForm) {
		CCMSApplyToBaseAgreementActionForm applyToBaseAgreementActionForm = (CCMSApplyToBaseAgreementActionForm)viewBean.getActionForm();
		sapCustomerNumber = applyToBaseAgreementActionForm.getSapCustomerNumber();
		actionForm.setCountryCode(viewBean.getCountryCode());
		actionForm.setCmrNumber(viewBean.getCMRNumber());
		actionForm.setEnterpriseNumber(viewBean.getEnterpriseNumber());
	}else{
	 if(errorReport != null && errorReport.size()!= 0){
         viewBean.setCustomerList(new ArrayList());
        }
	}
	%>
	
	<div id="edit-layout" align="right"><a href="javascript:getFormHelp()">
  <img src="//w3.ibm.com/ui/v8/images/icon-link-popup.gif" alt="" width="14" height="14" /> Page help </a>
</div>

<table cellpadding="0" cellspacing="0" border="0" width="600" summary="layout">
	<tr valign="top">
		<td width="600">
		<table width="600" role="presentation">
			<tr>
				<h1>CCMS customer selection</h1>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
			<td>
			<oppt:displayErrorReport errorReport="<%=errorReport%>" />
			</td></tr>
			<tr>
                 <td>
                    <p>This screen helps to listing all the customer information from CCMS</p>
                                    
                 </td>
                 </tr>
                 <tr>
                    <td>
                    <p>user should enter either countrycode and CMR number combination or enterprise number.When user clicks on Create button based on 
                    user input it will show the customer details from CCMS database.</p>                 
                 </td>
                 </tr>
                 <% if(viewBean.getCustomerList()!=null && viewBean.getCustomerList().size()!=0){        %>
                  <tr>
                    <td>
                    <p>Select the SAP customer number from the list by clicking the radio button and click on ApplyToBA ,it will apply the customer detais to Baseagreement registration page.</p>                 
                 </td>
                 </tr>
                 <%} %>
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>

 <table summary="CCMSCustomerDetails" cellpadding="0" cellspacing="0" border="0" width="800">
        <html:form action="/protect/CCMSCustomerDetailsAction.wss">
            <tr valign="top"> 
              <td width="458">
			<table summary="CustomerDetails" width="100%">

				<tr>
				    <td height="25" width="40"><b class="black">*</strong></td> 
				    <td width="150" height="25" ><label for="countryCode"><oppt:label label="Country&nbsp;code:" id="countryCode" errorLables="<%=errorValues%>" /></label></td>
                    <td width="125" height="25" ><oppt:select  selectedOption="<%=actionForm.getCountryCode()%>" name="countryCode" id="countryCode" options="<%=viewBean.getSalesOrgDetails()%>" title="select country code" /></td>
                   
                    <td height="25" width="40"><b class="black">*</strong></td> 
					<td height="25" width="180"><label for="cmrNumber"><oppt:label label="CMR&nbsp;number:" id="cmrNumber" errorLables="<%=errorValues%>"/></label></td>
 					<td height="25" width="180"><oppt:text name="cmrNumber" value="<%=actionForm.getCmrNumber()%>" maxlength="30" styleId="cmrNumber" styleClass="iform" size="20" title="Enter CMR number" /></td>
                </tr>
                <tr>
                   <td height="25" width="40"><b class="black">*</strong></td> 
					<td height="25" width="180"><label for="enterpriseNumber"><oppt:label label="Enterprise&nbsp;number:" id="enterpriseNumber" errorLables="<%=errorValues%>"/></label></td>
					<td height="25" width="108"><oppt:text name="enterpriseNumber" value="<%=actionForm.getEnterpriseNumber()%>" maxlength="30" styleId="enterpriseNumber" styleClass="iform" size="20" title="Enter enterprise number"/></td>
				</tr>
                <tr> <td colspan="6">&nbsp;</td></tr>
                <tr>

	         <td width="600" align="right" colspan="6"><oppt:button id="create" name="multipleButtonManager.create" alt="Create" primary="true" value="Create" /></td>

	         </tr>
                
			</table>
			
		</td></tr>
		 </html:form>
      </table>
     
      <% if(viewBean.getCustomerList()!=null && viewBean.getCustomerList().size()!=0){        %>
	  <html:form action="/protect/CCMSApplytoBaseAgreement.wss">  
	  <input name="deptcount" type="hidden" value="1"/>
	    <table summary="fetchcustomerlist" width="600">   
	         <tr>
	         <td>
	         <oppt:fetchcustomerlist customerList = "<%=viewBean.getCustomerList()%>" sapCustomerNumber = "<%=sapCustomerNumber%>"/>
	         </td>
	         </tr>
          	 <tr>
	            <td width="600" align="right" colspan="6"><oppt:button id="ApplytoBA" name="applytoBA" alt="ApplytoBA" primary="true" value="ApplytoBA" /></td>
	         </tr>
	         </table>
	         </html:form>
	          <% }%>
<script language="JavaScript" type="text/javaScript">
 // Images used for sorting
 var ascendingIcon = "http://w3.ibm.com/ui/v8/images/icon-link-sort-a-dark.gif"
 var descendingIcon = "http://w3.ibm.com/ui/v8/images/icon-link-sort-d-dark.gif"
 var sortableIcon = "http://w3.ibm.com/ui/v8/images/icon-link-sort-u-dark.gif"


 // Global variables to help the sorting
 var previousSortColumn = -1;
 var currentColumn = 1;
 var secondSortColumn = -1;
 var isSortWithControl = false

 var SORT_BY_NUMBERIC = "n"
 var SORT_BY_STRING_CASE_SENSITIVE = "s"
 var SORT_BY_STRING_CASE_INSENSITIVE = "si"
 var SORT_BY_DATE = "d"

 function sortTable(tableName, sortColumn, sortIfEqualColumn, sortType, obj) {

 	var imageName = document.getElementById(obj).src

 	var splitascendingIcon = ascendingIcon.split("/")
 	var subStringascendingIcon = splitascendingIcon[splitascendingIcon.length - 1]

 	var splitdescendingIcon = descendingIcon.split("/")
 	var subStringdescendingIcon = splitdescendingIcon[splitdescendingIcon.length - 1]

 	var splitsortableIcon = sortableIcon.split("/")
 	var subStringsortableIcon = splitsortableIcon[splitsortableIcon.length - 1]

 	splitImageName = imageName.split("/")
 	var subStringImageName = splitImageName[splitImageName.length - 1]


    if(subStringImageName == subStringsortableIcon)
    {
      document.getElementById(obj).src=ascendingIcon;
      document.getElementById(obj).alt="ascending sort";
      
    }

    if(subStringImageName == subStringascendingIcon)
    {
      document.getElementById(obj).src=descendingIcon;
      document.getElementById(obj).alt="descending sort ";
    }

    if(subStringImageName == subStringdescendingIcon)
    {
      document.getElementById(obj).src=sortableIcon;
      document.getElementById(obj).alt="Sort the column";
    }





 	var sapCustomerNumber = document.getElementById("customerNumber")

 	var currentForm = document.forms[document.forms.length - 1];
 		if(currentForm.deptcount != null && currentForm.deptcount.value > 1) {
 			var deptcount = currentForm.deptcount.value;
 				for(var i=1;i<=deptcount;i++) {
 					var tableNameToSort = tableName+"["+i+"]";
 					if(document.getElementById(tableNameToSort) != null) {
 						sortableArray = getTableDataForSortColumns(tableNameToSort, sortColumn, sortIfEqualColumn, sortType)
 						sortedArray = sortTableFor(tableNameToSort, sortColumn, sortType, sortableArray)
 						assignToTable(sortedArray, tableNameToSort)
 					}
 				}
 		}
 	else {
 			sortableArray = getTableDataForSortColumns(tableName, sortColumn, sortIfEqualColumn, sortType)
 			sortedArray = sortTableFor(tableName, sortColumn, sortType, sortableArray)
 			assignToTable(sortedArray, tableName)
 		}

 	// if the sorting done for a control, then there is a possibility that
 	// the value of the control might change.  In order to save that, the
 	// previousSortColumn is assigned to -1
 	if (isSortWithControl) {
 		previousSortColumn = -1
 	}
 	else {
 		previousSortColumn = sortColumn
 	}
 }

 /// Sorts the given array (sortableArray)
 // It again repopulates the array with the sorted order (taking the value from the table)
 function sortTableFor(tableName, sortColumn, sortType, sortableArray) {
 	var sortableTable = document.getElementById(tableName)
 	var rowsCount = sortableTable.rows.length - 1
 	var sortArray = sort(sortableArray, sortType, sortColumn)
 	var newArray = new Array(rowsCount)
 	var columnCount = sortableTable.rows[1].cells.length

 	for (i = 0; i < rowsCount; i++) {
 		newArray[i] = new Array(columnCount)
 		for (j = 0; j < columnCount; j++) {
 			// Reads the row (from the sorted array) and put that in the index starting from 0.
 			newArray[i][j] = sortableTable.rows[sortArray[i][0]].cells[j].innerHTML
 		}
 	}
 	return newArray
 }

 // This method assigns the sorted array value to the given table
 function assignToTable(sortedArray, tableName) {
 	var sortableTable = document.getElementById(tableName)
 	for (i = 0; i < sortedArray.length; i++) {
 		for (j = 0; j < sortedArray[i].length; j++) {
 			sortableTable.rows[i+1].cells[j].innerHTML = sortedArray[i][j]
 		}
 	}
 }

 // This method builds the table data with the column's needs to be sorted out
 // This column builds the array in the following format
 // data[i][0] = row number (starting from 1) REQUIRED
 // data[i][1] = sort column REQUIRED
 // data[i][2] = second sorting column [OPTIONAL], presents only when this sortIfEqualColumn > -1
 function getTableDataForSortColumns(tableName, sortColumn, sortIfEqualColumn, sortType) {
 	var sortableTable = document.getElementById(tableName)
 	// Since the header will not be part of the sorting, the length should be determined as
 	// actual length - 1
 	var rowsCount = sortableTable.rows.length - 1
 	var columnCount = 2

 	sortArray = new Array(rowsCount)

 	// Assign -1 to the second sort column
 	secondSortColumn = -1
 	isSortWithControl = false

 	if (sortIfEqualColumn > -1) {
 		secondSortColumn = 2
 		columnCount = 3
 	}
 	var tableRows = sortableTable.rows

 	for (i = 0; i < rowsCount; i++) {
 		sortArray[i] = new Array(columnCount)
 		sortArray[i][0] = i + 1 // the current row number

 		var sortColumnElement = tableRows[i + 1].cells[sortColumn]
 		var childObject = getByType(sortColumnElement.childNodes, null)

 		// check whether the cell contains object or normal text
 		if (childObject != null) {
 			if (isSortWithControl == false) {
 				isSortWithControl = true
 			}
 			// take the value of the object
 			if(sortColumnElement.childNodes[0].nodeName == "A") {
 				sortArray[i][1] = sortColumnElement.childNodes[0].innerHTML
 			}
 			else {
 				sortArray[i][1] = childObject.value
 			}
 		}
 		else {
 			// it is not a control.  use the innerText for sorting
 			if(sortColumnElement.childNodes[0].nodeName == "A") {
 				sortArray[i][1] = sortColumnElement.childNodes[0].innerHTML
 			}
 			else {
 				sortArray[i][1] = sortColumnElement.innerHTML
 			}
 		}

 		// if second column sorting is requested, then again check for control and normal text
 		if (sortIfEqualColumn > -1) {
 			var secondSortColumnElement = tableRows[i + 1].cells[sortIfEqualColumn]
 			var childObject = getByType(secondSortColumnElement.childNodes, null)

 			if (childObject != null) {
 				// take the value of the object
 				sortArray[i][2] = childObject.value
 			}
 			else {
 				// it is not a control.  use the innerText for sorting
 				sortArray[i][2] = secondSortColumnElement.innerHTML
 			}
 		}
 	}
 	return sortArray
 }

 // To get the element by the given type
 function getByType(childNode, typeName) {
 	var returnChild = null
 	var i = 0 ;
 	for (i = 0; i < childNode.length; i++) {
 		if (typeName != null) {
 			if (childNode[i].type == typeName) {
 				returnChild = childNode[i]
 				break
 			}
 		}
 		else {
 			if (isValidType(childNode[i].type)) {
 				returnChild = childNode[i]
 				break
 			}
 		}
 	}
 	return returnChild
 }

 // Checks for the valid controls that has the value
 function isValidType(objectType) {
 	return (objectType == "text" || objectType == "textarea" || objectType == "select-one" ||  objectType == "radio" || objectType == "checkbox" || objectType == "hidden")}

 // Sorts the given array (sortableArray)
 // It again repopulates the array with the sorted order (taking the value from the table)
 function sortTableFor(tableName, sortColumn, sortType, sortableArray) {
 	var sortableTable = document.getElementById(tableName)
 	var rowsCount = sortableTable.rows.length - 1
 	var sortArray = sort(sortableArray, sortType, sortColumn)
 	var newArray = new Array(rowsCount)
 	var columnCount = sortableTable.rows[1].cells.length

 	for (i = 0; i < rowsCount; i++) {
 		newArray[i] = new Array(columnCount)
 		for (j = 0; j < columnCount; j++) {
 			// Reads the row (from the sorted array) and put that in the index starting from 0.
 			newArray[i][j] = sortableTable.rows[sortArray[i][0]].cells[j].innerHTML
 		}
 	}
 	return newArray
 }

 // this function uses the implicit sorting functionality of the array
 // but overriding the sorting method based on the sorting type
 function sort(sortArray, sortType, sortColumn) {
 	if (previousSortColumn == sortColumn) {
 		sortArray.reverse()
 	}
 	else {
 		switch (sortType) {
 			case SORT_BY_NUMBERIC:
 				sortArray.sort(compareNumeric);
 				break;

 			case SORT_BY_STRING_CASE_SENSITIVE:
 				sortArray.sort(compareString);
 				break;

 			case SORT_BY_STRING_CASE_INSENSITIVE:
 				sortArray.sort(compareStringIgnoreCase);
 				break;

 			case SORT_BY_DATE:
 				sortArray.sort(compareDate);
 				break;

 			default:
 				sortArray.sort();
 		}
 	}

 	return sortArray;
 }
 // To compare two dates
 function compareDate(a, b) {
 	var returnValue = compare(new Date(a[currentColumn]), new Date(b[currentColumn]))
 	return sortOnSecondColumn(returnValue, a, b)
 }

 // To compare two numberic values
 function compareNumeric(a, b) {
 	var numberOne, numberTwo;

 	numberOne = a[currentColumn];
 	numberTwo = b[currentColumn];

 	if (isNaN(numberOne)) {
 		return 1;
 	}

 	if (isNaN(numberTwo)) {
 		return 1;
 	}

 	if (secondSortColumn > -1 && numberOne == numberTwo)
 	{
 		return sortOnSecondColumn(0, a, b)
 	}

 	return numberOne - numberTwo;
 }

 // To compare two strings (case sensitive)
 function compareString(a, b) {
 	var returnValue = compare(a[currentColumn], b[currentColumn]);
 	return sortOnSecondColumn(returnValue, a, b)
 }

 // To compare two strings (case in-sensitive)
 function compareStringIgnoreCase(a, b) {
 	var returnValue = compare(a[currentColumn].toLowerCase(), b[currentColumn].toLowerCase());
 	return sortOnSecondColumn(returnValue, a, b)
 }

 function sortOnSecondColumn(returnValue, a, b) {
 	if (returnValue == 0 && secondSortColumn > -1) {
 		return compare(a[secondSortColumn], b[secondSortColumn])
 	}

 	return returnValue;
 }

 // To compare two objects
 function compare(a, b) {
 	if (a < b) {
 		return -1;
 	}

 	if (a > b) {
 		return 1;
 	}

 	return 0;
 }

 // To trim the given string
 function trim(inputString) {
 	return inputString.replace(/^\s*|\s*$/g, "")
 }

 // To get the row object for the given object
 function getRowObject(currentObject) {
 	return getObjectBy(currentObject, "TR")

 }

 // Global variables
 var container = new Array();
 var onResizeHandler;

 function scrollbarWidth(){
     var w;

     if (! document.body.currentStyle) {
        document.body.currentStyle = document.body.style;
        }

     if (document.body.currentStyle.overflowY == 'visible' || document.body.currentStyle.overflowY == 'scroll'){
         w = document.body.offsetWidth - document.body.clientLeft - document.body.clientWidth;
     }else{
         win = window.open("about:blank", "_blank", "top=0,left=0,width=100,height=100,scrollbars=yes");
         win.document.writeln('scrollbar');
         w = win.document.body.offsetWidth - win.document.body.clientLeft - win.document.body.clientWidth;
         win.close();
     }

     return w;
 }

 function getActualWidth(e){
     if (! e.currentStyle)  {
      e.currentStyle = e.style;
       }
     return  e.clientWidth - parseInt(e.currentStyle.paddingLeft) - parseInt(e.currentStyle.paddingRight);
 }

 function findRowWidth(r){
     for (var i=0; i < r.length; i++){
         r[i].actualWidth = getActualWidth(r[i]);
     }
 }

 function setRowWidth(r){
     for (var i=0; i < r.length; i++){
         r[i].width = r[i].actualWidth;
         r[i].innerHTML = '<span style="width:' + r[i].actualWidth + ';">' + r[i].innerHTML + '</span>';
     }
 }

 function fixTableWidth(tbl){
     for (var i=0; i < tbl.tHead.rows.length; i++)   findRowWidth(tbl.tHead.rows[i].cells);
     findRowWidth(tbl.tBodies[0].rows[0].cells);
     if (tbl.tFoot) {
      for (var i=0; i < tbl.tFoot.rows.length; i++)  
      { findRowWidth(tbl.tFoot.rows[i].cells); }
      }

     //tbl.width = '';

     for (var i=0; i < tbl.tHead.rows.length; i++)   setRowWidth(tbl.tHead.rows[i].cells);
     setRowWidth(tbl.tBodies[0].rows[0].cells);
     if (tbl.tFoot) {
      for (var i=0; i < tbl.tFoot.rows.length; i++) 
      {  setRowWidth(tbl.tFoot.rows[i].cells);}
      }
 }

 function makeScrollableTable(tbl,scrollFooter,height){
     var c, pNode, hdr, ftr, wrapper, rect;

     if (typeof tbl == 'string') {
     tbl = document.getElementById(tbl);
     }

     pNode = tbl.parentNode;
     fixTableWidth(tbl);

     c = container.length;
     container[c] = document.createElement('<SPAN style="height: 100; overflow: auto;">');
     container[c].id = tbl.id + "Container";
     pNode.insertBefore(container[c], tbl);
     container[c].appendChild(tbl);
     container[c].style.width = tbl.clientWidth + 2 * tbl.clientLeft + scrollbarWidth();

     hdr = tbl.cloneNode(false);
     hdr.id += 'Header';
     hdr.appendChild(tbl.tHead.cloneNode(true));
     tbl.tHead.style.display = 'none';

     if (!scrollFooter || !tbl.tFoot){
         ftr = document.createElement('<SPAN style="width:1;height:1;clip: rect(0 1 1 0);background-color:transparent;">');
         ftr.id = tbl.id + 'Footer';
         ftr.style.border = tbl.style.border;
         ftr.style.width = getActualWidth(tbl) + 2 * tbl.clientLeft;
         ftr.style.borderBottom = ftr.style.borderLeft = ftr.style.borderRight = 'none';
     }else{
         ftr = tbl.cloneNode(false);
         ftr.id += 'Footer';
         ftr.appendChild(tbl.tFoot.cloneNode(true));
         ftr.style.borderTop = 'none';
         tbl.tFoot.style.display = 'none';
     }

     wrapper = document.createElement('<table border=0 cellspacing=0 cellpadding=0>');
     wrapper.id = tbl.id + 'Wrapper';
     pNode.insertBefore(wrapper, container[c]);

     wrapper.insertRow(0).insertCell(0).appendChild(hdr);
     wrapper.insertRow(1).insertCell(0).appendChild(container[c]);
     wrapper.insertRow(2).insertCell(0).appendChild(ftr);

     wrapper.align = tbl.align;
     tbl.align = hdr.align = ftr.align = 'left';
     hdr.style.borderBottom = 'none';
     tbl.style.borderTop = tbl.style.borderBottom = 'none';

     // adjust page size
     if (c == 0 && height == 'auto'){
         onResizeAdjustTable();
         onResizeHandler = window.onresize;
         window.onresize = onResizeAdjustTable;
     }else{
         container[c].style.height = height;
     }
 }

 function onResizeAdjustTable(){
     if (onResizeHandler){
      onResizeHandler();
      }
     var rect = container[0].getClientRects()(0);
     var h = document.body.clientHeight - (rect.top + (document.body.scrollHeight - rect.bottom));
     container[0].style.height = (h > 0) ? h : 1;
 }

 // Global variables
 var container = new Array();
 var onResizeHandler;

 function scrollbarWidth(){
     var w;

     if (! document.body.currentStyle) {
       document.body.currentStyle = document.body.style;
       }

     if (document.body.currentStyle.overflowY == 'visible' || document.body.currentStyle.overflowY == 'scroll'){
         w = document.body.offsetWidth - document.body.clientLeft - document.body.clientWidth;
     }else{
         win = window.open("about:blank", "_blank", "top=0,left=0,width=100,height=100,scrollbars=yes");
         win.document.writeln('scrollbar');
         w = win.document.body.offsetWidth - win.document.body.clientLeft - win.document.body.clientWidth;
         win.close();
     }

     return w;
 }

 function getActualWidth(e){
     if (! e.currentStyle){
        e.currentStyle = e.style;
        }

     return  e.clientWidth - parseInt(e.currentStyle.paddingLeft) - parseInt(e.currentStyle.paddingRight);
 }

 function findRowWidth(r){
     for (var i=0; i < r.length; i++){
         r[i].actualWidth = getActualWidth(r[i]);
     }
 }

 function setRowWidth(r){
     for (var i=0; i < r.length; i++){
         r[i].width = r[i].actualWidth;
         r[i].innerHTML = '<span style="width:' + r[i].actualWidth + ';">' + r[i].innerHTML + '</span>';
     }
 }

 function fixTableWidth(tbl){
     for (var i=0; i < tbl.tHead.rows.length; i++)   findRowWidth(tbl.tHead.rows[i].cells);
     findRowWidth(tbl.tBodies[0].rows[0].cells);
     if (tbl.tFoot){
         for (var i=0; i < tbl.tFoot.rows.length; i++)  
           { findRowWidth(tbl.tFoot.rows[i].cells);}
       }

     //tbl.width = '';

     for (var i=0; i < tbl.tHead.rows.length; i++)   setRowWidth(tbl.tHead.rows[i].cells);
     setRowWidth(tbl.tBodies[0].rows[0].cells);
     if (tbl.tFoot) {
      for (var i=0; i < tbl.tFoot.rows.length; i++)  
      { setRowWidth(tbl.tFoot.rows[i].cells);}
      }
 }

 function makeScrollableTable(tbl,scrollFooter,height){
     var c, pNode, hdr, ftr, wrapper, rect;

     if (typeof tbl == 'string'){
      tbl = document.getElementById(tbl);
      }

     pNode = tbl.parentNode;
     fixTableWidth(tbl);

     c = container.length;
     container[c] = document.createElement('<SPAN style="height: 100; overflow: auto;">');
     container[c].id = tbl.id + "Container";
     pNode.insertBefore(container[c], tbl);
     container[c].appendChild(tbl);
     container[c].style.width = tbl.clientWidth + 2 * tbl.clientLeft + scrollbarWidth();

     hdr = tbl.cloneNode(false);
     hdr.id += 'Header';
     hdr.appendChild(tbl.tHead.cloneNode(true));
     tbl.tHead.style.display = 'none';

     if (!scrollFooter || !tbl.tFoot){
         ftr = document.createElement('<SPAN style="width:1;height:1;clip: rect(0 1 1 0);background-color:transparent;">');
         ftr.id = tbl.id + 'Footer';
         ftr.style.border = tbl.style.border;
         ftr.style.width = getActualWidth(tbl) + 2 * tbl.clientLeft;
         ftr.style.borderBottom = ftr.style.borderLeft = ftr.style.borderRight = 'none';
     }else{
         ftr = tbl.cloneNode(false);
         ftr.id += 'Footer';
         ftr.appendChild(tbl.tFoot.cloneNode(true));
         ftr.style.borderTop = 'none';
         tbl.tFoot.style.display = 'none';
     }

     wrapper = document.createElement('<table border=0 cellspacing=0 cellpadding=0>');
     wrapper.id = tbl.id + 'Wrapper';
     pNode.insertBefore(wrapper, container[c]);

     wrapper.insertRow(0).insertCell(0).appendChild(hdr);
     wrapper.insertRow(1).insertCell(0).appendChild(container[c]);
     wrapper.insertRow(2).insertCell(0).appendChild(ftr);

     wrapper.align = tbl.align;
     tbl.align = hdr.align = ftr.align = 'left';
     hdr.style.borderBottom = 'none';
     tbl.style.borderTop = tbl.style.borderBottom = 'none';

     // adjust page size
     if (c == 0 && height == 'auto'){
         onResizeAdjustTable();
         onResizeHandler = window.onresize;
         window.onresize = onResizeAdjustTable;
     }else{
         container[c].style.height = height;
     }
 }

 function onResizeAdjustTable(){
     if (onResizeHandler){
      onResizeHandler();
      }

     var rect = container[0].getClientRects()(0);
     var h = document.body.clientHeight - (rect.top + (document.body.scrollHeight - rect.bottom));
     container[0].style.height = (h > 0) ? h : 1;
 }


 </script>



	         