<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:template match="comparetpreport">
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
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="center" color="black">Comparative statement of the old contract and new proposal</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											Report printed on :
											<xsl:value-of select="printdate" />
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
										</fo:block>		
									</fo:table-cell>
								</fo:table-row>
							
								<fo:table-row>
									<fo:table-cell number-columns-spanned="10" background-color="white" width="2.86cm" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">
									
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" width="2.86cm" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											(In new contract number)
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="4" background-color="white" width="2.86cm" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
											(In old contract number)
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell number-columns-spanned="18" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
																				
							
								<fo:table-row>
									<fo:table-cell number-columns-spanned="2" background-color="white" width="2.86cm" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">SWO number</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" width="2.86cm" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">Serial number</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">EE no</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="right" color="black" wrap-option="no-wrap">EE desc</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" width="2.86cm" height="1.02cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
									 	</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black"><xsl:value-of select="newcontrno"/></fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black"><xsl:value-of select="contrno"/></fo:block>
									</fo:table-cell>
								</fo:table-row>	
								<xsl:apply-templates select="swo"/>
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<!-- ========================= -->
	<!-- child element: SWO     -->
	<!-- ========================= -->
<xsl:template match="swo">
		<xsl:apply-templates select="ee" />
			<xsl:if test="count(./ee) != 0">
			<fo:table-row>
				<fo:table-cell number-columns-spanned="28" background-color="white" height="0.8cm" display-align="after">
					<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
				</fo:table-cell>
			</fo:table-row>
			</xsl:if>
</xsl:template>
	
	<xsl:template match="ee">
		<fo:table-row>
			<!-- SWO Display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after" starts-row="false">
			<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
				<xsl:choose>
					<xsl:when test="position() = 1">
						<xsl:value-of select="parent::node()/swono" />
					</xsl:when>
				<xsl:otherwise>&#160;</xsl:otherwise>
				</xsl:choose>
			</fo:block>
			</fo:table-cell>
			<!-- EE display -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
					<xsl:value-of select="eeserialno" />
				</fo:block>
			</fo:table-cell>
						
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="eeno" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="right" color="black">
					<xsl:value-of select="eedesc" />
				</fo:block>
			</fo:table-cell>
			<!--Contract Display -->
			<fo:table-cell number-columns-spanned="3" background-color="white" width="2.86cm" height="1.02cm" display-align="after">
				<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">
				</fo:block>
			</fo:table-cell>
									
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
					X
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="center" color="black">
					X
				</fo:block>
			</fo:table-cell>
		</fo:table-row>	
	</xsl:template>
</xsl:stylesheet>