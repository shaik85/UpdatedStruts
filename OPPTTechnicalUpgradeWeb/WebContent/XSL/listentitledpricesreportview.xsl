<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />

	<xsl:template match="listentitledpricesreport">
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
							<fo:table-column number-columns-repeated="29" />
							<fo:table-body>
							        <fo:table-row>
									<fo:table-cell number-columns-spanned="4" height="1.02cm" display-align="after">
										<fo:block font-size="10pt" font-family="any" text-align="left" color="red">IBM Confidential</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="28" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-weight="bold" font-size="20pt" font-family="any" text-align="center" color="black">List / Entitled Prices report</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">
											Report printed :&#160;
											<xsl:value-of select="reportprinteddate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">
											Prices as of :&#160;
											<xsl:value-of select="pricedasof" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="28" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											Contract period :&#160;
											<xsl:value-of select="contractstartdate" />
											-
											<xsl:value-of select="contractenddate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											External contract number :&#160;
											<xsl:value-of select="externalcontractnumber" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											Currency :&#160;
											<xsl:value-of select="currency" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="22" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">Prices</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Sap Customer Nr</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Design. machine&#160;&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">SW offering</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">SWO description</fo:block>
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
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Serial Nr.</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">Description</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">List</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Entitled</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Alternate</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Delta List / Entitled</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<xsl:apply-templates select="customer" />

								<fo:table-row>
									<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Total price for contract attachment :&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">
											<xsl:value-of select="totallistprice" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">
											<xsl:value-of select="totalentitledprice" />
										</fo:block>
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
					<xsl:if test="custtype='M'">MLC products</xsl:if>				
					<xsl:if test="custtype='S'">S&amp;S products</xsl:if>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<xsl:apply-templates select="dm" />
		<fo:table-row>
			<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>

		<fo:table-row>
			<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Total price for customer no.:&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="totallistprice" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="totalentitledprice" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

	<xsl:template match="dm">
		<xsl:variable name="customerNo">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="parent::node()/legacycustomernumber" />
				</xsl:when>
				<xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:apply-templates select="swo">
			<xsl:with-param name="customerNo" select="$customerNo" />
		</xsl:apply-templates>
		<xsl:if test="count(./swo) != 0">
			<fo:table-row>
				<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
				</fo:table-cell>
			</fo:table-row>

			<fo:table-row>
				<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Total price for designated machine :&#160;</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">
						<xsl:value-of select="totallistprice" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">
						<xsl:value-of select="totalentitledprice" />
					</fo:block>
				</fo:table-cell>
				<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:if>
	</xsl:template>

	<xsl:template match="swo">
		<xsl:param name="customerNo" />
		<xsl:variable name="dmNo">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="parent::node()/dmnumber" />
				</xsl:when>
				<xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="customerNoUnique">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="$customerNo" />
				</xsl:when>
				<xsl:otherwise>&#160;</xsl:otherwise>
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
		<fo:table-row>
			<!-- Legacy Customer No display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after" starts-row="false">
				<xsl:choose>
			  		<xsl:when test="position() = 1"><fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="$customerNo" /></fo:block></xsl:when>
				</xsl:choose>
			</fo:table-cell>
			<!-- Design. Machine display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<xsl:choose>
			  		<xsl:when test="position() = 1"><fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="$dmNo" /></fo:block></xsl:when>
			  		<xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</fo:table-cell>
			<!-- SW Offering Display-->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<xsl:choose>
			  		<xsl:when test="position() = 1"><fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="parent::node()/swonumber" /></fo:block></xsl:when>
			  		<xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</fo:table-cell>
			<!-- Description Display-->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<xsl:choose>
			  		<xsl:when test="position() = 1"><fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="parent::node()/swodescription" /></fo:block></xsl:when>
			  		<xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</fo:table-cell>
			<!-- Quantity/PG display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="quantity" />
				</fo:block>
			</fo:table-cell>
			<!-- Value metric display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="valuemetric" />
				</fo:block>
			</fo:table-cell>
			<!-- Entitlement entity display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="eenumber" />
				</fo:block>
			</fo:table-cell>
			<!-- Serial Number display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<xsl:choose>
			  		<xsl:when test="position() = 1"><fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="parent::node()/serialnumber" /></fo:block></xsl:when>
			  		<xsl:otherwise><xsl:text disable-output-escaping="yes"></xsl:text></xsl:otherwise>
				</xsl:choose>
			</fo:table-cell>
			<!-- Description display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="eedescription" />
				</fo:block>
			</fo:table-cell>
			<!-- List price -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="listprice" />
				</fo:block>
			</fo:table-cell>
			<!-- Price display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="entitledprice" />
				</fo:block>
			</fo:table-cell>
			<!-- Alternate price display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="alternateprice" />
				</fo:block>
			</fo:table-cell>
			<!-- Delta List display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="deltalist" />
				</fo:block>
			</fo:table-cell>

		</fo:table-row>

	</xsl:template>
</xsl:stylesheet>