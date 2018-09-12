<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:template match="variancereport">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="47.41cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<fo:table table-layout="fixed" border-width="0.0pt" width="47.41cm">
						<fo:table-column number-columns-repeated="18" />
							<fo:table-body>
							        <fo:table-row>
									<fo:table-cell number-columns-spanned="4" height="1.02cm" display-align="after">
										<fo:block font-size="10pt" font-family="any" text-align="left" color="red">IBM Confidential</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="center" color="black">
											Variance <xsl:value-of select="cntrperiodvarno" /> Report
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											Variance date : <xsl:value-of select="variancedate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											External contract no :
											<xsl:value-of select="extcontrno" />
										</fo:block>		
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											Contract period start date :
											<xsl:value-of select="contractstartdate" />
										</fo:block>		
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											Contract period end date :
											<xsl:value-of select="contractenddate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											Currency :
											<xsl:value-of select="currency" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
	
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											Sold-to customer no:
											<xsl:value-of select="customerno" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											Inventory at period start of contract:
											<xsl:value-of select="invoiceamount" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											Cumulative actual inventory as of variance date:
											<xsl:value-of select="cumulativeamount" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											CAP amount:
											<xsl:value-of select="capamount" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											CAP variance:
											<xsl:value-of select="capvariance" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
																				
								<fo:table-row>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Customer no.</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Desig mach.</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">SWO no.</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Serial no.</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">EE no.</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Description of EE</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">Entitled Price</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">Effective date</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Ind</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<xsl:apply-templates select="customer"/>

							<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
										  Ind = Indicator
										</fo:block>
									</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
							<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
								<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
									I = Initial
								</fo:block>
							</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
							<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
								<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
									A = Addition
								</fo:block>
							</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
							<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
								<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
									R = Removal
								</fo:block>
							</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
							<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
								<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
									B = Bump
								</fo:block>
							</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
							<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
								<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
									P = Price change
								</fo:block>
							</fo:table-cell>
							</fo:table-row>
							<fo:table-row>
							<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
								<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
									S = SVC
								</fo:block>
							</fo:table-cell>
							</fo:table-row>	
							<fo:table-row>
							<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
								<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
									D = Deselected
								</fo:block>
							</fo:table-cell>
							</fo:table-row>	
							</fo:table-body>
						</fo:table>

					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<!-- ========================= -->
	<!-- child element: customer     -->
	<!-- ========================= -->
<xsl:template match="customer">
		<xsl:apply-templates select="dm" />
</xsl:template>
	<xsl:template match="dm">
		<xsl:variable name="customerno">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="parent::node()/customerno" />
				</xsl:when>
				<xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:apply-templates select="swo">
			<xsl:with-param name="customerno" select="$customerno" />
		</xsl:apply-templates>
		<xsl:if test="count(./swo) != 0">
			<fo:table-row>
				<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:if>
	</xsl:template>

	<xsl:template match="swo">
		<xsl:param name="customerno" />
		<xsl:variable name="dmno">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="parent::node()/dmno" />
				</xsl:when>
				<xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:apply-templates select="ee">
			<xsl:with-param name="customerno" select="$customerno" />
			<xsl:with-param name="dmno" select="$dmno" />
		</xsl:apply-templates>
		<xsl:if test="count(./ee) != 0">
			<fo:table-row>
				<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:if>
	</xsl:template>
	
	<xsl:template match="ee">
		<xsl:param name="customerno" />
		<xsl:param name="dmno" />
		<xsl:variable name="swono">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="parent::node()/swono" />
				</xsl:when>
				<xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="serialno">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="parent::node()/serialno" />
				</xsl:when>
				<xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:apply-templates select="price">
			<xsl:with-param name="customerno" select="$customerno" />
			<xsl:with-param name="dmno" select="$dmno" />
			<xsl:with-param name="swono" select="$swono" />
			<xsl:with-param name="serialno" select="$serialno" />
		</xsl:apply-templates>
		<xsl:if test="count(./price) != 0">
			<fo:table-row>
				<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:if>
	</xsl:template>
	
	<xsl:template match="price">
	
		<xsl:param name="customerno" />
		<xsl:param name="dmno" />
		<xsl:param name="swono" />
		<xsl:param name="serialno" />
		<fo:table-row>
			<!-- Legacy Customer No display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after" starts-row="false">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="$customerno" />
				</fo:block>
			</fo:table-cell>
			<!-- Design. Machine display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="$dmno" />
				</fo:block>
			</fo:table-cell>
			
			<!-- SWO  Display-->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="$swono" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="$serialno" />
				</fo:block>
			</fo:table-cell>
			<!-- Entitlement entity display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="parent::node()/eeno" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="parent::node()/eedesc" />
				</fo:block>
			</fo:table-cell>
			<!-- Price display -->
	  			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="price" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
				<xsl:value-of select="effectivedate" />
				</fo:block>
			</fo:table-cell>
			
			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="indicator" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>	
	</xsl:template>
</xsl:stylesheet>