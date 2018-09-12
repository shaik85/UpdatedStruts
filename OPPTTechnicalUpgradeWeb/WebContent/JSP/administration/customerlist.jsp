
<!-- Copyright (c) 2006 by IBM corporation -->

<table  summary="Enter customer list" class="ibm-data-table" align="center" border="0" width="600" cellspacing="0"
						cellpadding="0">
	<tr style="background-color:#cccccc;" align="left">
		<th height="18" colspan="5">Enter Site Id numbers:</th>
	</tr>
	<%
		int count = 1;
		for(int i=0; i < 10; i++)
		{
	%>
			<tr class="hil">
	<%
			for(int j=0; j < 5; j++)
			{
	%>
				<td width="117" height="30"><label for="<%="customerlist" + count%>">&nbsp;&nbsp;</label>
					<input type="text" name="listNumbers" id="<%="customerlist" + count%>" value="" maxlength="10" size="8" class="iform"/>
				</td>
	<%	
				count++;
			}
	%>
			</tr>
	<%
		}
	%>
</table>