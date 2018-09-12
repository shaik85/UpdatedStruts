<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	
	<xsl:template match="sysplexreport">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="{@pageWidth}" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<fo:table table-layout="fixed" border-width="0.0pt" width="{@secondPagewidth}">
							<fo:table-column number-columns-repeated="{@count}" />
							<fo:table-body>
							        <fo:table-row>
									<fo:table-cell number-columns-spanned="4" height="1.02cm" display-align="after">
										<fo:block font-size="10pt" font-family="any" text-align="left" color="red">IBM Confidential</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-weight="bold" font-size="27pt" font-family="any" text-align="center" color="black">Coupled environment sysplex report</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="18pt" font-family="any" text-align="left" color="black">
											Report printed :
											<xsl:value-of select="@reportprinteddate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="18pt" font-family="any" text-align="left" color="black">
											Prices as of :
											<xsl:value-of select="@priceasof" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="20pt" font-family="any" text-align="center" color="black">
											Contract period :
											<xsl:value-of select="@contractstartdate" />
											-
											<xsl:value-of select="@contractenddate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="20pt" font-family="any" text-align="center" color="black">
											Proposal name :
											<xsl:value-of select="@proposalname" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="20pt" font-family="any" text-align="center" color="black">
											Contract number :
											<xsl:value-of select="@contractnumber" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="20pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Sr No.</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="{@firstMargin}" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="20pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>

									<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Designated machine</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="{@secondMargin}" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Designated machine desc.</fo:block>
									</fo:table-cell>
									
								</fo:table-row>
								<xsl:choose>
									<xsl:when test="@hasdata='populated'">
										<xsl:apply-templates select="dmdetail"/>
									
										<fo:table-row>
											<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="after">
												<fo:block font-size="20pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
											</fo:table-cell>
										</fo:table-row>
										<fo:table-row>
											<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
												<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">SWO Number</fo:block>
											</fo:table-cell>
											<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
												<fo:block font-size="20pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
											</fo:table-cell>
		
											<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
												<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">EE Number</fo:block>
											</fo:table-cell>
											<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
												<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
											</fo:table-cell>
											<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
												<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">EE Description</fo:block>
											</fo:table-cell>
											<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
												<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="right" color="black">Price</fo:block>
											</fo:table-cell>
											<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
												<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
											</fo:table-cell>
											<xsl:for-each select="./countPrice">
												<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
													<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">
														<xsl:value-of select="@displayCount"/>
													</fo:block>
												</fo:table-cell>
											</xsl:for-each>
										
										</fo:table-row>
										<fo:table-row>
											<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="after">
												<fo:block font-size="20pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
											</fo:table-cell>
										</fo:table-row>
									
										<xsl:apply-templates select="swodetail"/>
										<fo:table-row>
											<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="after">
												<fo:block font-size="20pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
											</fo:table-cell>
										</fo:table-row>
										<fo:table-row>
											<fo:table-cell number-columns-spanned="7" background-color="white" height="0.8cm" display-align="after">
												<fo:block font-weight="bold" font-size="18pt" font-family="any" text-align="right" color="black">
													Total software charge for configuration  :
												</fo:block>
											</fo:table-cell>
											<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
												<fo:block font-weight="bold" font-size="18pt" font-family="any" text-align="right" color="black">
													<xsl:value-of select="@totalcharge" />
												</fo:block>
											</fo:table-cell>
										</fo:table-row>
									</xsl:when>
									
								<xsl:otherwise>
									<fo:table-row>
										<fo:table-cell number-columns-spanned="{@count}" background-color="white" height="0.8cm" display-align="before">
											<fo:block font-weight="bold" font-size="19pt" font-family="any" text-align="left" color="black">MLC product</fo:block>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell number-columns-spanned="25" background-color="white" height="0.8cm" display-align="before">
											<fo:block font-size="20pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell number-columns-spanned="25" background-color="white" height="1.02cm" display-align="after">
											<fo:block font-size="19pt" font-family="any" text-align="left" color="black">No DM found in coupled environment</fo:block>
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

	<xsl:template match="dmdetail">
		<xsl:apply-templates select="dm"/>
	</xsl:template>
	
	
	<xsl:template match="swodetail">
		<xsl:apply-templates select="swo"/>
	</xsl:template>
	
	<xsl:template match="dm">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="20pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@serialno"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="{../../@firstMargin}" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="20pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>

			<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="20pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@dmnumber"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="{../../@secondMargin}" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="20pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@dmdescription"/>
				</fo:block>
			</fo:table-cell>
			
		</fo:table-row>
	</xsl:template>
	
	<xsl:template match="swo">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="18pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@swono"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="18pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>

			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="18pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@eenumber"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="18pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="18pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@eedesc"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="18pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="@price"/>
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="18pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
			<xsl:for-each select="./markDM">
				<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
					<fo:block font-size="22pt" font-family="any" text-align="left" color="black">
						<xsl:value-of select="@dmSelected"/>
					</fo:block>
				</fo:table-cell>
			</xsl:for-each>
		</fo:table-row>
	</xsl:template>

</xsl:stylesheet>