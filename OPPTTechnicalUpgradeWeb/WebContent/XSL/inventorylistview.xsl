<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />

	<xsl:template match="report">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="50cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<fo:table table-layout="fixed" border-width="0.0pt" width="50cm">
							<fo:table-column number-columns-repeated="26" />
							<fo:table-body>
							        <fo:table-row>
									<fo:table-cell number-columns-spanned="4" height="1.02cm" display-align="after">
										<fo:block font-size="10pt" font-family="any" text-align="left" color="red">IBM Confidential</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-weight="bold" font-size="20pt" font-family="any" text-align="center" color="black">Inventory list report</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Report printed : <xsl:value-of select="reportprinteddate" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Prices as of : <xsl:value-of select="pricedasof" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">Contract period : <xsl:value-of select="contractstartdate" />&#160;-&#160;<xsl:value-of select="contractenddate" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">External contract number : <xsl:value-of select="contractnumber" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">Currency : <xsl:value-of select="currency" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Sap customer no.</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Design. machine &#160;&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="center" color="black">SW offering</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="center" color="black">Indicator</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Quantity/PG</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Value metric</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Entitlement entity</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Serial no.</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Description</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Price</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Alternate price</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="center" color="black">PLET no.</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<xsl:apply-templates select="customer" />
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
							
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Total price for contract attachment :</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="totalprice" /></fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

							</fo:table-body>
						</fo:table>

					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="customer">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
					<xsl:if test="soldtoparty/@custtype='M'">MLC products</xsl:if>				
					<xsl:if test="soldtoparty/@custtype='S'">S&amp;S products</xsl:if>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<xsl:apply-templates select="dm" />
		<fo:table-row>
			<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
	
		<fo:table-row>
			<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Total price for customer no.:</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="totalprice" /></fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

	<xsl:template match="dm">
		<xsl:variable name="customerNo">
			<xsl:choose>
			  <xsl:when test="position() = 1"><xsl:value-of select="parent::node()/soldtoparty/@id" /></xsl:when>
			  <xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:apply-templates select="swo" >
			<xsl:with-param name="customerNo" select="$customerNo"/>
		</xsl:apply-templates>
		<xsl:if test="count(./swo) != 0">	
			<fo:table-row>
				<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
				</fo:table-cell>
			</fo:table-row>
			
			<fo:table-row>
				<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Total price for designated machine :</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="totalprice" /></fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:if>		
	</xsl:template>

	<xsl:template match="swo">
		<xsl:param name="customerNo"/>
		<xsl:variable name="dmNo">
			<xsl:choose>
			  <xsl:when test="position() = 1"><xsl:value-of select="parent::node()/@number" /></xsl:when>
			  <xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="customerNoUnique">
			<xsl:choose>
			  <xsl:when test="position() = 1"><xsl:value-of select="$customerNo" /></xsl:when>
			  <xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:apply-templates select="ee" >
			<xsl:with-param name="customerNo" select="$customerNoUnique"/>
			<xsl:with-param name="dmNo" select="$dmNo"/>
		</xsl:apply-templates>
	</xsl:template>
	<xsl:template match="ee">
		<xsl:param name="customerNo"/>
		<xsl:param name="dmNo"/>
		<fo:table-row>
			<!-- Legacy Customer No display -->
			<fo:table-cell  number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after" starts-row="false">
				<xsl:choose>
			  		<xsl:when test="position() = 1"><fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="$customerNo" /></fo:block></xsl:when>
			  		<xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</fo:table-cell>
			<!-- Design. Machine display -->
			<fo:table-cell  number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<xsl:choose>
			  		<xsl:when test="position() = 1"><fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="$dmNo" /></fo:block></xsl:when>
			  		<xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</fo:table-cell>
			<!-- SW Offering Display-->
			<fo:table-cell  number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<xsl:choose>
			  		<xsl:when test="position() = 1"><fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="parent::node()/number" /></fo:block></xsl:when>
			  		<xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</fo:table-cell>
			<!-- Indicator Display-->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<xsl:choose>
			  		<xsl:when test="position() = 1"><fo:block font-size="16pt" font-family="any" text-align="center" color="black"><xsl:value-of select="parent::node()/indicator" /></fo:block></xsl:when>
			  		<xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</fo:table-cell>
			<!-- Quantity/PG display -->
			<fo:table-cell  number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="uselevel" /></fo:block>
			</fo:table-cell>
			<!-- Value metric display -->
			<fo:table-cell  number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="valuemetricdesc" /></fo:block>
			</fo:table-cell>
			<!-- Entitlement entity display -->
			<fo:table-cell  number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="number" /></fo:block>
			</fo:table-cell>
			<!-- Serial Number display -->
			<fo:table-cell  number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<xsl:choose>
			  		<xsl:when test="position() = 1"><fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="parent::node()/serialnumber" /></fo:block></xsl:when>
			  		<xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</fo:table-cell>
			<!-- Description display -->
			<fo:table-cell  number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="desc" /></fo:block>
			</fo:table-cell>
			<!-- Price display -->
			<fo:table-cell  number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="eswprice" /></fo:block>
			</fo:table-cell>
			<!-- Alternate price display -->
			<fo:table-cell  number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="alternateprice" /></fo:block>
			</fo:table-cell>
			<!-- PLET no. display -->
			<fo:table-cell  number-columns-spanned="3" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black"><xsl:value-of select="pletno" /></fo:block>
			</fo:table-cell>

		</fo:table-row>

	</xsl:template>
</xsl:stylesheet>