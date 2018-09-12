<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:template match="deletionreport">
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
							<fo:table-column number-columns-repeated="20" />
							<fo:table-body>
							        <fo:table-row>
									<fo:table-cell number-columns-spanned="4" height="1.02cm" display-align="after">
										<fo:block font-size="10pt" font-family="any" text-align="left" color="red">IBM Confidential</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="21" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="21" background-color="white" height="1.02cm" display-align="after">
										<fo:block font-weight="bold" font-size="20pt" font-family="any" text-align="center" color="black">Deleted Users Report</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="21" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">
											Sales org :
											<xsl:value-of select="@primarysalesorgdesc" /> - <xsl:value-of select="@primarysalesorg" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="21" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="left" color="black">
											Report printed :
											<xsl:value-of select="@reportprinteddate" />
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="21" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-weight="bold" font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="21" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="21" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">User Name</fo:block>
									</fo:table-cell>									
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">OPPT Id</fo:block>
									</fo:table-cell>
										<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">User Type</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Role</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Group</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Sales Area</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Access type</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Deleted By</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Deleted at GMT</fo:block>
									</fo:table-cell>    						
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="21" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="21" background-color="white" height="0.8cm" display-align="after">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="center" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
                                                                 <xsl:apply-templates select="deleteduser" />

							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
			
	</xsl:template>

	<xsl:template match="deleteduser">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@lastname" /> - <xsl:value-of select="@firstname" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@userid" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@usertype" />
				</fo:block>
			</fo:table-cell>
			
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@role" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@group" />
				</fo:block>
			</fo:table-cell>
		       <fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@primarysalesorgdesc" /> - <xsl:value-of select="@primarysalesorg" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@accesstype" />
				</fo:block>
			</fo:table-cell>
			
			
			<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
				<xsl:value-of select="@deletedadmin" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@deleteddate" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>

	</xsl:template>
		
	
	</xsl:stylesheet>

