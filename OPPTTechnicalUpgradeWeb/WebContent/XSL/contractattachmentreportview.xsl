<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />


	<xsl:template match="contractAttachmentreport">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="60cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<fo:table table-layout="fixed" border-width="0.0pt" width="56cm">
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
										<fo:block font-weight="bold" font-size="20pt" font-family="any" text-align="center" color="black">Contract Attachment Report</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">
											Report printed :
											<xsl:value-of select="@reportprinteddate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											Contract Period :
											<xsl:value-of select="@contractstartdate" />
											-
											<xsl:value-of select="@contractenddate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											TVM rate :
											<xsl:value-of select="@tvmrate" />
											% Planned growth :
											<xsl:value-of select="@plannedgrowthrate" />
											%
										</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											<xsl:value-of select="@proposalname" />
											(
											<xsl:value-of select="@contractnumber" />
											)
										</fo:block>
									</fo:table-cell>
								</fo:table-row>


								<fo:table-row>
									<fo:table-cell number-columns-spanned="26" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="8" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Designated Machine</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="8" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">SWO</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">Billing</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">MLC</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">Contract</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">
											<xsl:if test="@draft='draft'">Comments</xsl:if>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Number</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Description</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Value metric description</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Use Level</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">SWO number</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Serial number</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Description</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">Indicator</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Plan start date</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Plan end date</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">(C1)</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">Billing Period amount(C2)</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">&#160;</fo:block>
									</fo:table-cell>

								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<xsl:apply-templates select="customer" />


								<fo:table-row>
									<fo:table-cell number-columns-spanned="20" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">Total for contract attachment :</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">
											<xsl:value-of select="@totaleswprice" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">
											<xsl:value-of select="@totalcalculatedprice" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								

								<fo:table-row>
									<fo:table-cell number-columns-spanned="24" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">Invoice frequency &amp; amount (Related to MLC products only)</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="16" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>

									<fo:table-cell number-columns-spanned="5" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Annual</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
											<xsl:value-of select="@annualinvoiceamount" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											&#160;
											<xsl:if test="@billingfrequency = 'A'">Selected</xsl:if>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>

								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="16" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>

									<fo:table-cell number-columns-spanned="5" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Semi-annual</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
											<xsl:value-of select="@semiannualinvoiceamount" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											&#160;
											<xsl:if test="@billingfrequency = 'S'">Selected</xsl:if>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>

								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="16" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>

									<fo:table-cell number-columns-spanned="5" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Quarterly</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
											<xsl:value-of select="@quarterlyinvoiceamount" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											&#160;
											<xsl:if test="@billingfrequency = 'Q'">Selected</xsl:if>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>

								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="16" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>

									<fo:table-cell number-columns-spanned="5" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Monthly</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
											<xsl:value-of select="@monthlyinvoiceamount" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											&#160;
											<xsl:if test="@billingfrequency = 'M'">Selected</xsl:if>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>

								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
										C1 : MLC(Monthly License Charge) - For each sold to party, designated machine and SWO, shows what MLC charge would be without a contract agreement
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
										C2 : Contract billing period- The amount the sold to party will pay IBM based on the selected billing frequency- monthly, quarterly, semi-annually,annually. The price includes TVM(Time Value of Money).
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
		<fo:table-row>
			<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
					<xsl:if test="soldtoparty/@custtype='M'">MLC products</xsl:if>				
					<xsl:if test="soldtoparty/@custtype='S'">S&amp;S products</xsl:if>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
					Sold to party :
					<xsl:value-of select="soldtoparty/@id" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
					Bill to party :
					<xsl:value-of select="billtoparty/@id" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
					Payer :
					<xsl:value-of select="payer/@id" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="soldtoparty/@name" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="billtoparty/@name" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="payer/@name" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<xsl:apply-templates select="dm" />
		<fo:table-row>
			<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="20" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="right" color="black">
					Total price for customer (
					<xsl:value-of select="soldtoparty/@id" />
					) :
				</fo:block>
			</fo:table-cell>

			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">
					<xsl:value-of select="@totaleswprice" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">
					<xsl:value-of select="@totalcalculatedprice" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>

	</xsl:template>

	<xsl:template match="dm">
		<xsl:variable name="customerNo">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="../soldtoparty/@id" />
				</xsl:when>
				<xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:apply-templates select="swo">
			<xsl:with-param name="customerNo" select="$customerNo" />
		</xsl:apply-templates>
	</xsl:template>

	<xsl:template match="swo">
		<xsl:param name="customerNo" />
		<xsl:variable name="dmNo">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="../@number" />
				</xsl:when>
				<xsl:otherwise>&#160;</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="dmDesc">
			<xsl:choose>
				<xsl:when test="position() = 1">
					<xsl:value-of select="../@description" />
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
			<xsl:with-param name="dmDesc" select="$dmDesc" />
		</xsl:apply-templates>
	</xsl:template>



	<xsl:template match="ee">
		<xsl:param name="customerNo" />
		<xsl:param name="dmNo" />
		<xsl:param name="dmDesc" />
		<fo:table-row>
			<!-- Design. Machine display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="$dmNo" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="$dmDesc" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="../@valuemetricdesc" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="../@uselevel" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="../@number" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="../@serialnumber" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="../@description" />
				</fo:block>
			</fo:table-cell>
			<!-- Indicator Display-->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
					<xsl:value-of select="../@indicator" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
					<xsl:value-of select="../@plannedstartdate" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
					<xsl:value-of select="../@plannedenddate" />
				</fo:block>

			</fo:table-cell>


			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:choose>
						<xsl:when test="../@comments='A'">
							<xsl:value-of select="../@alternateprice" />
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="../@eswprice" />
						</xsl:otherwise>
					</xsl:choose>
				</fo:block>
			</fo:table-cell>

			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="../@calculatedprice" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">


					<xsl:if test="../../../../@draft='draft'">
						<xsl:value-of select="../@comments" />
					</xsl:if>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
</xsl:stylesheet>
