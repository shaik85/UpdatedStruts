<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" version="1.0" indent="yes" />

	<xsl:template match="listentitledpricesreport">
		<style>.heading.content .cellHeading {background-color:#ffffff;vertical-align:top;height:19px} .cellContent {background-color:#ffffff;vertical-align:bottom;height:19px}</style>

		<table border="0">
			<tr>
				<td colspan="30" bgcolor="#ffffff" align="center" valign="bottom" height="19">
					&#160;
				</td>
			</tr>
			<tr>
				<td colspan="30" bgcolor="#ffffff" align="center" valign="bottom" height="19">
					&#160;
				</td>
			</tr>
			<tr>
				<td colspan="30" align="center" valign="top" height="29">
					
						<strong>List / Entitled Prices report</strong>
					
				</td>
			</tr>
			<tr>
				<td colspan="30" align="left" class="cellContent">
					
						<strong>
							Report printed :
							<xsl:value-of select="reportprinteddate" />
						</strong>
					
				</td>
			</tr>
			<tr>
				<td colspan="30" align="left" class="cellContent">
					
						<strong>
							Prices as of :
							<xsl:value-of select="pricedasof" />
						</strong>
					
				</td>
			</tr>
			<tr>
				<td colspan="30" align="center" class="cellContent">
					
						Contract period :
						<xsl:value-of select="contractstartdate" />
						-
						<xsl:value-of select="contractenddate" />
					
				</td>
			</tr>
			<tr>
				<td colspan="30" align="center" class="cellContent">
					
						External contract number :
						<xsl:value-of select="externalcontractnumber" />
					
				</td>
			</tr>
			<tr>
				<td colspan="30" align="center" class="cellContent">
					
						Currency :
						<xsl:value-of select="currency" />
					
				</td>
			</tr>
			<tr>
				<td colspan="30" align="center" class="cellContent">
					&#160;
				</td>
			</tr>

			<tr>
				<td colspan="22" align="left" class="cellContent">
					&#160;
				</td>
				<td colspan="8" align="center" class="cellContent">
					
						<strong>Prices</strong>
					
				</td>
			</tr>
			<tr>
				<td colspan="5" align="left" class="cellHeading" span="no">
					
						<strong>Sap Customer Nr</strong>
					
				</td>
				<td colspan="2" align="left" class="cellHeading">
					
						<strong>Design. machine&#160;&#160;</strong>
					
				</td>
				<td colspan="3" align="left" class="cellHeading">
					
						<strong>SW offering</strong>
					
				</td>
				<td colspan="2" align="left" class="cellHeading">
					
						<strong>SWO description</strong>
					
				</td>
				<td colspan="2" align="left" class="cellHeading">
					
						<strong>Quantity/PG</strong>
					
				</td>
				<td colspan="3" align="left" class="cellHeading">
					
						<strong>Value metric</strong>
					
				</td>
				<td colspan="2" align="left" class="cellHeading">
					
						<strong>Entitlement entity</strong>
					
				</td>
				<td colspan="2" align="left" class="cellHeading">
					
						<strong>Serial Nr.</strong>
					
				</td>
				<td colspan="3" align="left" class="cellHeading">
					
						<strong>Description</strong>
					
				</td>
				<td colspan="2" align="right" class="cellHeading">
					
						<strong>List</strong>
					
				</td>
				<td colspan="2" align="right" class="cellHeading">
					
						<strong>Entitled</strong>
					
				</td>
				<td width="81" align="right" class="cellHeading">
					
						<strong>Alternate</strong>
					
				</td>
				<td colspan="2" align="right" class="cellHeading">
					
						<strong>Delta List / Entitled</strong>
					
				</td>
			</tr>

			<xsl:apply-templates select="customer" />

			<tr>
				<td colspan="30" align="center" class="cellContent">
					
						<strong>&#160;</strong>
					
				</td>
			</tr>

			<tr>
				<td colspan="24" align="right" class="cellContent">
					
						<strong>Total price for contract attachment :</strong>
					
				</td>
				<td colspan="2" align="right" class="cellContent">
					
						<strong><xsl:value-of select="totallistprice" /></strong>
					
				</td>
				<td colspan="2" align="right" class="cellContent">
					
						<strong><xsl:value-of select="totalentitledprice" /></strong>
					
				</td>
			</tr>
		</table>

	</xsl:template>

	<xsl:template match="customer">
		<tr>
			<td lotus_celltype="label" colspan="6" bgcolor="#ffffff" align="left" valign="bottom" height="19">
				
					<strong><xsl:if test="custtype='M'">MLC products</xsl:if></strong>
					<strong><xsl:if test="custtype='S'">S&amp;S products</xsl:if></strong>
				
			</td>
		</tr>
		<xsl:apply-templates select="dm" />
		<tr>
			<td colspan="30" align="center" class="cellContent">
				
					<strong>&#160;</strong>
				
			</td>
		</tr>

		<tr>
			<td colspan="24" align="right" class="cellContent">
				
					<strong>Total price for customer no.:</strong>
				
			</td>
			<td colspan="2" align="right" class="cellContent">
				
					<strong><xsl:value-of select="totallistprice" /></strong>
				
			</td>
			<td colspan="2" align="right" class="cellContent">
				
					<strong><xsl:value-of select="totalentitledprice" /></strong>
				
			</td>
		</tr>
	</xsl:template>

	<xsl:template match="dm">
		<xsl:variable name="customerNo">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="parent::node()/legacycustomernumber" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:text disable-output-escaping="yes">&#160;</xsl:text>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:apply-templates select="swo">
			<xsl:with-param name="customerNo" select="$customerNo" />
		</xsl:apply-templates>
		<xsl:if test="count(./swo) != 0">
			<tr>
				<td colspan="30" align="center" class="cellContent">
					
						<strong>&#160;</strong>
					
				</td>
			</tr>

			<tr>
				<td colspan="24" align="right" class="cellContent">
					
						<strong>Total price for designated machine :</strong>
					
				</td>
				<td colspan="2" align="right" class="cellContent">
					
						<strong><xsl:value-of select="totallistprice" /></strong>
					
				</td>
				<td colspan="2" align="right" class="cellContent">
					
						<strong><xsl:value-of select="totalentitledprice" /></strong>
					
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template match="swo">
		<xsl:param name="customerNo" />
		<xsl:variable name="dmNo">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="parent::node()/dmnumber" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:text disable-output-escaping="yes">&#160;</xsl:text>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="customerNoUnique">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="$customerNo" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:text disable-output-escaping="yes">&#160;</xsl:text>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:apply-templates select="ee">
			<xsl:with-param name="customerNo" select="$customerNoUnique" />
			<xsl:with-param name="dmNo" select="$dmNo" />
		</xsl:apply-templates>
	</xsl:template>
	<xsl:template match="ee">
		<xsl:param name="customerNo" />
		<xsl:param name="dmNo" />
		<tr>
			<td colspan="5" align="left" class="cellContent">
				<xsl:choose>
				  <xsl:when test="position() = 1"><xsl:value-of select="$customerNo" /></xsl:when>
				  <xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</td>
			<td colspan="2" align="left" class="cellContent">
				<xsl:choose>
				  <xsl:when test="position() = 1"><xsl:value-of select="$dmNo" /></xsl:when>
				  <xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</td>
			<td colspan="3" align="left" class="cellContent">
				<xsl:choose>
				  <xsl:when test="position() = 1"><xsl:value-of select="parent::node()/swonumber" /></xsl:when>
				  <xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</td>
			<td colspan="2" align="left" class="cellContent">
				<xsl:choose>
				  <xsl:when test="position() = 1"><xsl:value-of select="parent::node()/swodescription" /></xsl:when>
				  <xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</td>
			<td colspan="2" align="left" class="cellContent">
				
					<xsl:value-of select="quantity" />
				
			</td>
			<td colspan="3" align="left" class="cellContent">
				
					<xsl:value-of select="valuemetric" />
				
			</td>
			<td colspan="2" align="left" class="cellContent">
				
					<xsl:value-of select="eenumber" />
				
			</td>
			<td colspan="2" align="left" class="cellContent">
				<xsl:choose>
				  <xsl:when test="position() = 1"><xsl:value-of select="parent::node()/serialnumber" /></xsl:when>
				  <xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</td>
			<td colspan="3" align="left" class="cellContent">
				
					<xsl:value-of select="eedescription" />
				
			</td>
			<td colspan="2" align="right" class="cellContent">
				
					<xsl:value-of select="listprice" />
				
			</td>
			<td colspan="2" align="right" class="cellContent">
				
					<xsl:value-of select="entitledprice" />
				
			</td>
			<td width="81" align="right" class="cellContent">
				
					<xsl:value-of select="alternateprice" />
				
			</td>
			<td colspan="2" align="right" class="cellContent">
				
					<xsl:value-of select="deltalist" />
				
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>