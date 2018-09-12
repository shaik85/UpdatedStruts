<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:template match="contractplanningreport">
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
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="center" color="black">Contract planning report</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											Report printed :
											<xsl:value-of select="reportprinteddate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											Prices as of :
											<xsl:value-of select="pricedasof" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											Contract period :
											<xsl:value-of select="contractstartdate" />
											-
											<xsl:value-of select="contractenddate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											TVM rate :
											<xsl:value-of select="tvmrate" />
											% Planned growth :
											<xsl:value-of select="plannedgrowthrate" />
											%
										</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
											<xsl:value-of select="proposalname" />
											(
											<xsl:value-of select="contractnumber" />
											)
										</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black" space-after.optimum="15pt">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>


								<fo:table-row>
									<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">Billing</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">Price</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell background-color="white" width="2.86cm" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" width="2.86cm" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">SWO number</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black" wrap-option="no-wrap">Serial number&#160;&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Indicator</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Plan start date</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Plan end date</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" width="2.86cm" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">ESW</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">Alternate</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">Calculated</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" width="2.86cm" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" width="2.86cm" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Value metric description</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Use level</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">EE</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="6" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<xsl:apply-templates />




								<fo:table-row>
									<fo:table-cell number-columns-spanned="15" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Total price for contract attachment :</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">
											<xsl:value-of select="totalcalculatedprice" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="17" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">Invoice frequency &amp; amount (Related to MLC products only)</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="13" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Annual</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
											<xsl:value-of select="annualinvoiceamount" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
											&#160;										
											<xsl:if test="billingfrequency = 'A'">
												Selected
											</xsl:if>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="13" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Semi-annual</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
											<xsl:value-of select="semiannualinvoiceamount" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
											&#160;										
											<xsl:if test="billingfrequency = 'S'">
												Selected
											</xsl:if>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="13" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Quarterly</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
											<xsl:value-of select="quarterlyinvoiceamount" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
											&#160;										
											<xsl:if test="billingfrequency = 'Q'">
												Selected
											</xsl:if>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="13" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Monthly</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
											<xsl:value-of select="monthlyinvoiceamount" />
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
											&#160;										
											<xsl:if test="billingfrequency = 'M'">
												Selected
											</xsl:if>
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
					&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Payer :
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
					&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
					<xsl:value-of select="payer/@name" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>

		<xsl:apply-templates />

		<fo:table-row>
			<fo:table-cell number-columns-spanned="15" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					Total price for sold to party (
					<xsl:value-of select="soldtoparty/@id" />
					):
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">
					<xsl:value-of select="totalcalculatedprice" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

	<xsl:template match="dm">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					Designated machine:
					<xsl:value-of select="@number" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<xsl:apply-templates />
		<fo:table-row>
			<fo:table-cell number-columns-spanned="15" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					Total price for designated machine (
					<xsl:value-of select="@number" />
					) :
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">
					<xsl:value-of select="totalcalculatedprice" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

	<xsl:template match="swo">
		<fo:table-row>
			<fo:table-cell background-color="white" width="2.86cm" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" width="2.86cm" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="number" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black" wrap-option="no-wrap">
					<xsl:value-of select="serialnumber" />
					&#160;&#160;
				</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					&#160;&#160;
					<xsl:value-of select="indicator" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="plannedstartdate" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-weight="any" font-family="any" text-align="left" color="black">
					<xsl:value-of select="plannedenddate" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="1" background-color="white" width="2.86cm" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="eswprice" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="alternateprice" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="calculatedprice" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>

		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="ee">

		<fo:table-row>
			<fo:table-cell background-color="white" width="2.86cm" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" width="2.86cm" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="valuemetricdesc" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="uselevel" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
					<xsl:value-of select="number" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="eswprice" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="alternateprice" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="calculatedprice" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>

	</xsl:template>

</xsl:stylesheet>