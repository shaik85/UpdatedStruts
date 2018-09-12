
<!-- Copyright (c) 2006 by IBM corporation -->

<%@ page import="com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction" %>
<div id="ibm-leadspace-head" class="ibm-alternate">
		<div id="ibm-leadspace-body" class="ibm-alternate">

				<h1><br>
				BH-OPPT</h1>

<p ><em><br>Progress</em></p>		
		</div>
	</div>

<div id="ibm-content-body">


<table cellpadding="0" cellspacing="0" border="0" width="600" summary="BH-OPPT">
	<tr valign="top">
		<td width="600">
			<table width="600" role="presentation"">
				
			</table>
		</td>
		<td width="7">&nbsp;</td>
		<td width="150">&nbsp;</td>
	</tr>
</table>
	<%
		OPPTLongAction task = (OPPTLongAction)session.getAttribute("task");
		int count = 0;
		if(task.isRunning())
		{
			try {
				count = ((Integer)session.getAttribute("count")).intValue();
			}
			catch(NullPointerException ne) {
				count = 0;
			}
			// count++;
			// session.setAttribute("count", new Integer(count));
	%>
<table border="1" align="center" cellspacing="0" summary="tempcount">
	<tr>
		<td>
			<table width="60%" align="center" cellspacing="2" summary="layout">
				<tr>
		            <% 
		            	int tempCount = count%30;
		            	for (int i = 1; i <= tempCount; i++) { %>
		            	<td width="3%" style="background-color:#cccccc;" class="dark">&nbsp;</td>
		            <% } %>
		            <% for (int i = (tempCount+1); i <=30; i++ ) { %>
		            	<td width="3%">&nbsp;</td>
		            <% } %>
		        </tr>
			</table>
		</td>
	</tr>
</table>
			  
	<%
		}
	%>

<!-- start content head -->
		<div id="ibm-content-head">


		</div> 
    	<!-- stop content head -->


	<div id="ibm-content-main">
		
	</div>

</div>
			