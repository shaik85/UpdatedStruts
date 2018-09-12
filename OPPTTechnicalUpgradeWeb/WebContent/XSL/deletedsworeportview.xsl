<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:template match="deletedSwoReport">
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

							<fo:table-column number-columns-repeated="10" />

							<fo:table-body>
							        <fo:table-row>
									<fo:table-cell number-columns-spanned="4" height="1.02cm" display-align="after">
										<fo:block font-size="10pt" font-family="any" text-align="left" color="red">IBM Confidential</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="9" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="center" color="black">Report of deleted SWOs</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="9" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Report printed : <xsl:value-of select="reportPrintedDate" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="9" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Prices as of : <xsl:value-of select="pricesAsOf" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="9" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">Contract period : <xsl:value-of select="contractStartDate" />&#160;-&#160;<xsl:value-of select="contractEndDate" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="9" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">TVM rate : <xsl:value-of select="tvmRate" />&#160;%&#160;Planned growth : <xsl:value-of select="plannedGrowth" />&#160;%</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="9" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black"><xsl:value-of select="proposalName" />&#160;(<xsl:value-of select="contractNumber" />)</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="9" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">Billing</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">Price</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">SWO number</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Serial number</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Plan start date</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Plan end date</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">ESW</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">Alternate</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black">Calculated</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Value metric description</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Use level</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">EE</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<xsl:choose>
									<xsl:when test="@hasData='true'">
										<xsl:apply-templates />
		
										<fo:table-row>
											<fo:table-cell number-columns-spanned="5" background-color="white" height="1.02cm" display-align="before">
												<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
											</fo:table-cell>
											<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
												<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Total price for contract attachment &#160;:</fo:block>
											</fo:table-cell>
											<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
												<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black"><xsl:value-of select="totalPrice" /></fo:block>
											</fo:table-cell>
										</fo:table-row>
										<fo:table-row>
											<fo:table-cell number-columns-spanned="9" background-color="white" height="1.02cm" display-align="after">
												<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
											</fo:table-cell>
										</fo:table-row>
									</xsl:when>
									
									<xsl:otherwise>
										<fo:table-row>
											<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
												<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
											</fo:table-cell>
											<fo:table-cell number-columns-spanned="8" background-color="white" height="1.02cm" display-align="before">
												<fo:block font-size="16pt" font-family="any" text-align="left" color="black">No SWO has been deleted.</fo:block>
											</fo:table-cell>
										</fo:table-row>
									</xsl:otherwise>
								</xsl:choose>
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
					<xsl:if test="soldToParty/@custtype='M'">MLC products</xsl:if>				
					<xsl:if test="soldToParty/@custtype='S'">S&amp;S products</xsl:if>
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Sold to party&#160;:&#160;<xsl:value-of select="soldToParty/@number" /></fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Bill to party&#160;:&#160;<xsl:value-of select="billToParty/@number" /></fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Payer&#160;:&#160;<xsl:value-of select="payer/@number" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="soldToParty/@name" /></fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="billToParty/@name" /></fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="payer/@name" /></fo:block>
			</fo:table-cell>
		</fo:table-row>

		<xsl:apply-templates />

		<fo:table-row>
			<fo:table-cell number-columns-spanned="5" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Total price for sold to party&#160;(<xsl:value-of select="soldToParty/@number" />)&#160;:</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black"><xsl:value-of select="totalPrice" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

	<xsl:template match="dm">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="9" background-color="white" height="1.02cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Designated machine&#160;:&#160;<xsl:value-of select="@number" /></fo:block>
			</fo:table-cell>
		</fo:table-row>

		<xsl:apply-templates />

		<fo:table-row>
			<fo:table-cell number-columns-spanned="5" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">Total price for designated machine&#160;(<xsl:value-of select="@number" />)&#160;:</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black"><xsl:value-of select="totalPrice" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

	<xsl:template match="swo">
		<fo:table-row>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@number" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@serialNumber" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="planStartDate" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="planEndDate" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="eswPrice" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="alternatePrice" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="calculatedPrice" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="ee">
		<fo:table-row>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="valueMetricDescription" /></fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="1.02cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="useLevel" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@number" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="eswPrice" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="alternatePrice" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="1.02cm" width="5.26cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black"><xsl:value-of select="calculatedPrice" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
</xsl:stylesheet>