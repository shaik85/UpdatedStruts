<html>
<head>
<link rel="stylesheet" href="styles/styles.css" />
<script  src="scripts/jquery-3.3.1.js" ></script>
<script type="text/javascript">
$("document").ready(function(){
	
	$("#chatContent").append("<p><div class=\"wapic\"> </div><div class=\"waspeak\" ><div id=\""+createNextID()+"\">Connecting to Watson...."+ "<div style=\"text-align:right\">at " + GetFormattedDate()+"</div></div></div></p>");	 
	$.getJSON({ url: "sendQuery.wa",
		  data: {userText: "Refresh"},
		  success: sentSuccessfully
		  
		});
		$('#userText').keypress(function(e) {
        	if (e.keyCode == 13) {
        		$("#sendQuery").click();
        	}
		});
		$("#sendQuery").click(function(){
		if($("#userText").val().length > 0)
			{
			
				$("#chatContent").append("<p><div class=\"userpic\"> </div><div class=\"authspeak\">"+$("#userText").val()+ "<div style=\"text-align:right\">at " + GetFormattedDate()+"</div></div></p>");
				$("#chatContent").append("<p><div class=\"wapic\"> </div><div class=\"waspeak\" ><div id=\""+createNextID()+"\">Please wait ...</div></div></p>");
				$.getJSON({ url: "sendQuery.wa",
					  data: {userText: $("#userText").val()},
					  success: sentSuccessfully
					  
					});
				$("#userText").val("");
				$("#userText").focus();
				$('#chatContent').scrollTop($('#chatContent').height()+5);
			}
	});
	function GetFormattedDate() {

	    var todayTime = new Date();

	    var month = todayTime .getMonth() + 1;

	    var day = todayTime .getDate();

	    var year = todayTime .getFullYear();
	    
	    var hour =todayTime.getHours();
	    var mins =todayTime.getMinutes();
	    var secs =todayTime.getSeconds();

	    return year + "-" + month + "-" + day+" " + hour + ":" +mins+":"+secs;

	}
	/*$("#chatbut").click(function(){

		if($("#chatbut").text()=="Open Chat"){
			$('#chatmaindiv').animate({height:'600px'}, 500);
			 $("#chatbut").text("Close Chat");
			 $(".inputarea").show();
			 $("#chatContent").show();
			 $("#mainWinTitle").removeClass('mainWinTitle2');
			 $("#mainWinTitle").addClass('mainWinTitle');
		}
		else
			{
			$(".inputarea").hide();
			$("#chatContent").hide();
			$('#chatmaindiv').animate({height:'50px'}, 500);
			 $("#chatbut").text("Open Chat");
			 $("#mainWinTitle").removeClass('mainWinTitle');
			 $("#mainWinTitle").addClass('mainWinTitle2');

			}
	});*/
 
	function sentSuccessfully(data,status,xhr){
			var respDiv;
	        var result;
	        var time;
	        switch (status){
	        case 'success':
	        	result=data.responseText;
	        	time=data.now;
	        	break;
	        case 'nocontent':
	        	result='No content received from server';
	        	time=GetFormattedDate();
	        	break;
	        case 'error':
	        	result='There seems to be some unexpected error that happened';
	        	time=GetFormattedDate();
	        	break;
	        case 'timeout':
	        	result='The request timed out, waiting for the response';
	        	time=GetFormattedDate();
	        	break;
	        case 'abort':
	        	result='The process is aborted';
	        	time=GetFormattedDate();
	        	break;
	        case 'parseerror':
	        	result='There is a parse error while getting the data';
	        	time=GetFormattedDate();
	        	break;
	        }
			respDiv="wa"+$("#wid").val();
	        $("#"+respDiv).html(data.responseText + "  <div style=\"text-align:right\">at " + time +"</div>");
	        $('#chatContent').scrollTop($('#chatContent').height()+5);
	        
	}
	function createNextID(){
		var idval;
		idval=$("#wid").val();
		idval=++idval;
		$("#wid").val(idval);
		return "wa"+idval;
	}
});
</script>
</head>
<body>

 
<div class="mainwindow" id="chatmaindiv">

 <div class="chatcontent" id="chatContent">
 <input type="hidden" id="wid" value="1" />
 </div>
 <div class="inputarea">
 <hr color="blue" width="600" size="1">
 <input class="userinput" id="userText" name="usertext" />&nbsp;&nbsp;<button id="sendQuery" class="submitbut">Send</button>
 
 </div>
 
</div>


</body>
</html>
