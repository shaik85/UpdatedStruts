

<!-- Copyright (c) 2006 by IBM corporation -->


	
	
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>	
	<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US" xml:lang="en-US">
	<head>
		
		
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link rel="schema.DC" href="http://purl.org/DC/elements/1.0/"/>
		<link rel="SHORTCUT ICON" href="http://w3.ibm.com/favicon.ico"/>
		<meta name="DC.Rights" content="© Copyright IBM Corp. 2011"/>

		<meta name="Keywords" content="CBS-OPPT, Create Proposa"/>
		<meta name="DC.Date" scheme="iso8601" content="2012-07-10"/>
		<meta name="Source" content="v17 template generator, template 17.02 delivery:IBM  authoring:IBM"/> <!-- Kindly change the "delivery" and "authoring" as per what is appropriate.  -->
		<meta name="Security" content="Private"/>

		<!--		<meta name="Abstract" content=""/> -->
		<meta name="IBM.Effective" scheme="W3CDTF" content="2013-07-10"/>
		<meta name="DC.Subject" scheme="IBM_SubjectTaxonomy" content=""/>
		<meta name="Owner" content="hmack@us.ibm.com"/>
		
                <meta name="Feedback" content="hmack@us.ibm.com"/>
		<meta name="DC.Language" scheme="rfc1766" content="en-US"/>

		<meta name="IBM.Country" content="US"/>
		<meta name="Robots" content="index,follow"/>
		<meta name="DC.Type" scheme="IBM_ContentClassTaxonomy" content=""/>
		<meta name="Description" content="The IBM Entitled Software Offering Proposal Planning Tool. Home page."/>

		<!-- Please ensure appropriate meta tag values are aligned with the standards -->
		<title><tiles:getAsString name="title" /></title>
		<link href="//1.w3.s81c.com/common/v17/css/w3.css" rel="stylesheet" title="w3" type="text/css" />
		<script src="//1.w3.s81c.com/common/js/dojo/w3.js" type="text/javascript">	
		
		</script>
		
		
</head>


		
		
	
	
	<body id="ibm-com">
		<div id="ibm-top" class="ibm-liquid" >
		
		
		
<!-- start masthead -->
 <tiles:insert attribute="header" />
<!-- stop masthead -->


<!-- pcon div start -->
<div id="ibm-pcon" >



<!-- start content -->


	<div id="ibm-content">
	
	<tiles:insert attribute="body" />
	
	
	
<!-- CONTENT_BODY -->
  
</div> 
<!-- stop content -->  






<!-- start navigation -->
<tiles:insert attribute="menu" />
<!-- stop navigation -->







 
</div> 
<!-- pcon div end -->
<div id="ibm-related-content"></div>

<!-- start footer -->
  
   <tiles:insert attribute="footer" /> 
<!-- stop footer --> 


<!-- Metrics start -->

<div id="ibm-metrics">
<script src="//w3.ibm.com/w3webmetrics/js/ntpagetag.js" type="text/javascript">//</script>
</div>

<!-- Metrics end -->

</div>
<script type="text/javascript" language="Javascript1.2">
var HelpURL = "<%= com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader.getOPPTHTMLPath() + "help/" %>";
// Normal parameters for a popup window
var WindowParameters = "toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=1"
var HelpSize = "width=600,height=600"
var win = ""
function getFieldHelp(id) {
 var newURL = HelpURL + id
 if (win != "") {
  win.close()
 }
 win = window.open(newURL, 'Help', WindowParameters + "," + HelpSize)
}
 
// This method is used to handle form help.
function getFormHelp() {

 var currentForm = document.helpform;
 
 var id = currentForm.pagehelp.value
 getFieldHelp(id)
 
}
</script>
<noscript>To use this function please enable java script in your browser</noscript>
<!-- print stylesheet MUST follow imported stylesheets --> 
<form name="helpform" action="helpformaction" method="post">
<input type="hidden" name="pagehelp" value="<tiles:getAsString name="help" />" />
</form>
</body>
</html>