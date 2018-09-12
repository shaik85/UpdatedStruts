<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes" />
	<xsl:template match="printproposal">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" page-height="47.41cm" page-width="25.0cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
					<fo:region-body />
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4" master-name="A4-Portrait">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<fo:table table-layout="fixed" border-width="0.0pt" width="21.0cm">

							<fo:table-column number-columns-repeated="4" />

							<fo:table-body>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" height="1.02cm" display-align="after">
										<fo:block font-size="10pt" font-family="any" text-align="left" color="red">IBM Confidential</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Sales area</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Sales organization</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@salesOrganization" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Distribution channel</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@distributionChannel" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Division</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@division" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Currency code</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@currencyCode" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Complex Contract Identifiers</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">CPS id</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@complexContractID" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Original CPS id</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@complexContractType" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract type</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@masterContractType" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">BLB indicator</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@blbIndicator" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								    <fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Basic proposal data</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Proposal name</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@proposalName" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Proposal type</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@proposalType" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Report name</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@reportName" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">External contract number</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@externalContractNumber" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract number</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@contractNumber" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract type</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@contractType" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell background-color="#CCCCCC" height="1.02cm" width="5.25cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Contract dates</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="#CCCCCC" height="1.02cm" width="5.25cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">yyyy-mm-dd</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="#CCCCCC" height="1.02cm" width="5.25cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="#CCCCCC" height="1.02cm" width="5.25cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">yyyy-mm-dd</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract start date</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@contractStartDate" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract end date</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@contractEndDate" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract period beginning</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@contractPeriodBeginning" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract period ending</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@contractPeriodEnding" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Amendment effective date</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@amendmentEffectiveDate" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Pricing information</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Planned growth</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@plannedGrowthValue" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Billing frequency</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@billingFrequency" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Growth limit</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@growthLimitValue" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Advance</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@advance" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Additional growth limit</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@additionalGrowthLimit" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">PAKID</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@pakid" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<!-- CR6153 changes starts -->
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Extended period</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@extendPeriod" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<!-- CR6153 changes ends -->
								
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">MLC Anniversary contract amount</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@anniversaryContractAmount" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">S&amp;S Anniversary contract amount</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@ssAnniversaryContractAmount" /></fo:block>
									</fo:table-cell>
								</fo:table-row>

								<!-- CR6153 changes starts -->

								
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">S&amp;S Anniversary contract amount2</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@ssAnniversaryContractAmount2" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">S&amp;S Anniversary contract amount3</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@ssAnniversaryContractAmount3" /></fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">S&amp;S Anniversary contract amount4</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@anniversaryContractAmount4" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">S&amp;S Anniversary contract amount5</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@ssAnniversaryContractAmount5" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<!-- CR6153 changes ends -->

								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">TVM rate</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@tvmRate" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Detailed invoice</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@detailedInvoice" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Billing block</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@billingBlock" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">GSA</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@gsa" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Billing date rule</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@billingDateRule" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"> Deviating date rule</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@deviatingDateRule" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Free text for invoice print</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@freeTextForInvoicePrint" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Purchase order data</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"> P.O. number</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@purchaseOrderNumber" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">P.O. date</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@purchaseOrderDate" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Payment terms</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Add value days</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@addValueDays" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Fixed val date</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@fixedValDate" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Payment terms</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@paymentTerms" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Variance</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">CAP amount</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@capAmount" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">CAP minus</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@capMinus" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">CAP plus</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@capPlus" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Financing data</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">CAL #</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@igfOfferNumber" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Special billing indicator</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@prebillindicator" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Comments</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@comments" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Proposal approver detail</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Name</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@proposalApprover" /></fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Partner function details</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="1" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Number</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="#CCCCCC" height="1.02cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Name</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="1"  background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Sold to party</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@soldToPartyNumber" /></fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@soldToPartyName" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="1"  background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Bill to party</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@billToPartyNumber" /></fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@billToPartyName" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="1"  background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Payer</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@payerNumber" /></fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@payerName" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="1"  background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Ship to party</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@shipToPartyNumber" /></fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@shipToPartyName" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="1"  background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black">9E Partner</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="1" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@nineDPartnerNumber" /></fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" background-color="white" height="0.8cm" display-align="before">
										<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@nineDPartnerName" /></fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
										<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
									</fo:table-cell>
								</fo:table-row>

								<xsl:apply-templates />

							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template match="MLCProducts">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Invoice amount&#160;:&#160;<xsl:value-of select="@invoiceAmount" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
		
		<xsl:choose>
			<xsl:when test="@isSAndS='true'">
				<fo:table-row>
					<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
						<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">MLC products</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</xsl:when>
		</xsl:choose>
		
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="SANDSProducts">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Total S&amp;S discounted amount&#160;:&#160;<xsl:value-of select="@ssDiscountAmt" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="4" background-color="#CCCCCC" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">S&amp;S products</fo:block>
			</fo:table-cell>
		</fo:table-row>
		
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="customer">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="2" background-color="#CCCCCC" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Sold-to-party&#160;:&#160;<xsl:value-of select="soldtoparty/@number" /></fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="#CCCCCC" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">SAP sold-to-party&#160;:&#160;<xsl:value-of select="soldtoparty/@sapNumber" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Bill-to-party</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="billtoparty/@number" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Plan start date</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@planstartdate" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Payer</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="payer/@number" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Plan end date</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="@planenddate" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>

		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="dm">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="2" background-color="#CCCCCC" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Designated machine&#160;:&#160;<xsl:value-of select="@number" /></fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="#CCCCCC" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Description&#160;:&#160;<xsl:value-of select="@description" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Plan start date</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="planstartdate" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Plan end date</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="planenddate" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>

		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="swo">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="2" background-color="#cccccc" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">SWO/SWOSno&#160;:&#160;<xsl:value-of select="@number" /></fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="#cccccc" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Description&#160;:&#160;<xsl:value-of select="@description" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Reference S/N</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="referenceSN" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">ESW price</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="eswprice" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Reference D/N</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="referenceDN" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Alternate price</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="alternateprice" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Plan start date</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="planstartdate" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Calculated price</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="calculatedprice" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Plan end date</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="planenddate" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract status</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="contractStatus" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract number</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="contractNumber" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract type</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="contractType" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="sandsswo">
		<fo:table-row>
			<fo:table-cell number-columns-spanned="2" background-color="#cccccc" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">SWO/SWOSno&#160;:&#160;<xsl:value-of select="@number" /></fo:block>
			</fo:table-cell>
			<fo:table-cell number-columns-spanned="2" background-color="#cccccc" height="1.02cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">Description&#160;:&#160;<xsl:value-of select="@description" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Reference S/N</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="referenceSN" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">ESW SAndS price</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="eswprice" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Reference D/N</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="referenceDN" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Alternate SAndS price</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="alternateprice" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Plan start date</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="planstartdate" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Calculated SAndS price</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="calculatedprice" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Plan end date</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="planenddate" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract status</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="contractStatus" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract number</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="contractNumber" /></fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black">Contract type</fo:block>
			</fo:table-cell>
			<fo:table-cell background-color="white" height="0.8cm" width="5.25cm" display-align="before">
				<fo:block font-size="16pt" font-family="any" text-align="left" color="black"><xsl:value-of select="contractType" /></fo:block>
			</fo:table-cell>
		</fo:table-row>
		<fo:table-row>
			<fo:table-cell number-columns-spanned="4" background-color="white" height="0.5cm" display-align="after">
				<fo:block font-size="20pt" font-weight="bold" font-family="any" text-align="left" color="black">&#160;</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
</xsl:stylesheet>