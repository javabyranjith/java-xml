<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="2.0" xmlns:xs="http://www.w3.org/2001/XMLSchema"
	exclude-result-prefixes="xs functx" xmlns:functx="http://www.functx.com">

	<xsl:import href="functx-1.0-doc-2007-01.xsl" />

	<xsl:variable name="count" select="1" />
	<xsl:template match="/">
		<xsl:for-each select="employees/employee">
			<xsl:variable name="count" select="$count + position()" />
			NAME:
			<xsl:value-of select="name" />
			<xsl:value-of select="functx:substring-before-if-contains('ran$jith','$')" />
			AGE:
			<xsl:value-of select="$count" />
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>