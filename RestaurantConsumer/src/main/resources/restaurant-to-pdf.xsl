<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simple"
                                       page-height="29.7cm"
                                       page-width="21cm"
                                       margin="2cm">
                    <fo:region-body margin-bottom="1cm"/>
                    <fo:region-after extent="1cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <!-- Title page -->
            <fo:page-sequence master-reference="simple">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="30pt"
                              font-family="Helvetica, Arial, sans-serif"
                              font-weight="bold"
                              text-align="center"
                              color="#333333"
                              margin-bottom="2cm">
                        Restaurant
                    </fo:block>
                    <!-- Logo -->
                    <fo:block text-align="center" margin-top="1cm" margin-bottom="1cm">
                        <fo:external-graphic src="url('src/main/resources/static/img/logo.png')"
                                             content-height="auto"
                                             content-width="35%"/>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>

            <!-- Restaurants -->
            <xsl:apply-templates select="restaurant"/>
        </fo:root>
    </xsl:template>

    <xsl:template match="restaurant">
        <fo:page-sequence master-reference="simple">
            <fo:flow flow-name="xsl-region-body">
                <fo:block font-size="20pt"
                          font-family="Helvetica, Arial, sans-serif"
                          font-weight="bold"
                          color="#0055A4">
                    <xsl:value-of select="name"/>
                </fo:block>
                <fo:block font-size="14pt"
                          font-family="Helvetica, Arial, sans-serif"
                          margin-top="0.5cm"
                          margin-bottom="0.5cm"
                          color="#666666">
                    Location: <xsl:value-of select="location"/>
                </fo:block>
                <fo:block font-size="14pt"
                          font-family="Helvetica, Arial, sans-serif"
                          margin-top="0.5cm"
                          color="#666666">
                    Rating: <xsl:value-of select="rating"/>
                </fo:block>
                <fo:block border-top="1pt solid #CCCCCC"
                          margin-top="1cm"/>
                <xsl:apply-templates select="menu"/>
            </fo:flow>
        </fo:page-sequence>
    </xsl:template>

    <xsl:template match="menu">
        <fo:block font-size="16pt"
                  font-family="Helvetica, Arial, sans-serif"
                  font-weight="bold"
                  color="#007ACC">
            Menu:
        </fo:block>
        <xsl:for-each select="dish">
            <fo:block font-size="12pt"
                      font-family="Helvetica, Arial, sans-serif"
                      color="#666666">
                <xsl:number format="1"/>. <xsl:value-of select="name"/> - $<xsl:value-of select="price"/>
            </fo:block>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
