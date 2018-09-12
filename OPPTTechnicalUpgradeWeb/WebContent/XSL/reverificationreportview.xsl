<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:template match="userReverificationReport">
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
										<fo:block font-weight="bold" font-size="20pt" font-family="any" text-align="center" color="black">User Reverification Report</fo:block>
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
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">User last name</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">User first name</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">OPPT Id</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Role</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Group</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Last log-in date</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Primary sales area</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Secondary sales area</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Access type</fo:block>
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

								<xsl:apply-templates select="usertype" />
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>



<!-- ========================= -->
	<!-- child element: usertype    -->
	<!-- ========================= -->
	<xsl:template match="usertype">
	<fo:table-row>
	<fo:table-cell number-columns-spanned="2" background-color="white" height="1.5cm" display-align="before">
		<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">User Type</fo:block>
	</fo:table-cell>

	<fo:table-cell number-columns-spanned="4" background-color="white" height="1.5cm" display-align="before">
	<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
		<xsl:value-of select="@userType" />
	</fo:block>
	</fo:table-cell>

	<fo:table-cell number-columns-spanned="2" background-color="white" height="1.5cm" display-align="before">
		<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
	</fo:table-cell>

	<fo:table-cell number-columns-spanned="4" background-color="white" height="1.5cm" display-align="before">
    	<fo:block font-size="16pt" font-family="any" text-align="left" color="black"></fo:block>
	</fo:table-cell>

	</fo:table-row>
	<fo:table-row>
		<fo:table-cell number-columns-spanned="21" background-color="white" height="0.8cm" display-align="after">
			<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
		</fo:table-cell>
	</fo:table-row>	
	<xsl:apply-templates select="manager" />
	</xsl:template>

	<!-- ========================= -->
	<!-- child element: manager    -->
	<!-- ========================= -->
	<xsl:template match="manager">
	<fo:table-row>
		<fo:table-cell number-columns-spanned="21" background-color="white" height="0.8cm" display-align="after">
			<fo:block font-size="16pt" font-family="any" text-align="center" color="black">&#160;</fo:block>
		</fo:table-cell>
	</fo:table-row>	
	<fo:table-row>

	<fo:table-cell number-columns-spanned="2" background-color="white" height="1.5cm" display-align="before">
		<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Manager Name</fo:block>
	</fo:table-cell>

	<fo:table-cell number-columns-spanned="4" background-color="white" height="1.5cm" display-align="before">
	<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
		<xsl:value-of select="@managername" />
	</fo:block>
	</fo:table-cell>


	<fo:table-cell number-columns-spanned="2" background-color="white" height="1.5cm" display-align="before">
		<fo:block font-size="16pt" font-weight="bold" font-family="any" text-align="left" color="black">Email Id</fo:block>
	</fo:table-cell>

	<fo:table-cell number-columns-spanned="4" background-color="white" height="1.5cm" display-align="before">
	<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
		<xsl:value-of select="@email" />
	</fo:block>
	</fo:table-cell>
	</fo:table-row>
	<xsl:apply-templates select="user" />
	</xsl:template>




	<!-- ========================= -->
	<!-- child element: user     -->
	<!-- ========================= -->
	<xsl:template match="user">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@lastname" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@firstname" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@userid" />
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
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@lastlogindate" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@primarysalesareadesc" /> - <xsl:value-of select="@primarysalesarea" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@accesstype" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<xsl:apply-templates select="salesarea" />
	</xsl:template>
	<xsl:template match="salesarea">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;
				</fo:block>
			</fo:table-cell>
			<!-- EF0621051852 - Changes starts from here : Thirumalaikumar -->
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
				<xsl:value-of select="@group" />
				</fo:block>
			</fo:table-cell>
			<!-- Changes end here -->			
			<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;
				</fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="after">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;
				</fo:block>
			</fo:table-cell>
			<!-- EF0621051852 - Changes starts from here : Thirumalaikumar -->
			<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@secondarysalesareadesc" />
				</fo:block>
			</fo:table-cell>
			<!-- Changes end here -->			
			<fo:table-cell number-columns-spanned="3" background-color="white" height="0.8cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">
					<xsl:value-of select="@accesstype" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>		
</xsl:stylesheet>

