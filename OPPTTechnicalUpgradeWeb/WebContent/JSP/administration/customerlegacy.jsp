
<!-- Copyright (c) 2006 by IBM corporation -->

<table summary="legacy customer numbers" align="center" border="0" width="600" cellspacing="0" cellpadding="0">
	<tr>
		<td align="left">
				Enter legacy customer numbers, click on save button to submit your request
		</td>
	</tr>
</table>
&nbsp;<br />
<table summary="legacy customer" class="ibm-data-table" align="center" width="600" border="0" cellspacing="0" cellpadding="0">	
	<tr>
		<th height="18" align="left">Legacy no.</th>
		<th height="18" align="left">Sequence no.</th>
		<th height="18" align="left">Legacy no.</th>
		<th height="18" align="left">Sequence no.</th>

	</tr>
	<%
		int count = 1;
		for(int i=0; i < 50; i++)
		{
	%>
			<tr>
				<td align="left"><label for="<%="legacynumber" + count%>">&nbsp;</label>
					<input type="text" name="legacyNumber" id="<%="legacynumber" + count%>" value="" maxlength="10" size="8"/>
				</td>
				<td align="left"><label for="<%="sequencenumber" + count%>">&nbsp;</label>
					<input type="text" name="sequenceNumber" id="<%="sequencenumber" + count%>" value="" maxlength="15" size="13"/>
				</td>
	<%
				count++;
	%>
				<td align="left"><label for="<%="legacynumber" + count%>">&nbsp;</label>
					<input type="text" name="legacyNumber" id="<%="legacynumber" + count%>" value="" maxlength="10" size="8"/>
				</td>
				<td align="left"><label for="<%="sequencenumber" + count%>">&nbsp;</label>
					<input type="text" name="sequenceNumber" id="<%="sequencenumber" + count%>" value="" maxlength="15" size="13"/>
				</td>
			</tr>
	<%
			count++;
		}
	%>
</table>