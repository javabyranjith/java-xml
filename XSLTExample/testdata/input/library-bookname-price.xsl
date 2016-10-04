<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0">
  <xsl:template match="/">
    <html>
      <head>
        <title>Books List</title>
      </head>
      <body>
        <table border="1">
          <tr>
            <th>Book Name</th>
            <th>Price</th>
          </tr>
          <xsl:for-each select="library/books/book">
            <tr>
              <td>
                <xsl:value-of select="name" />
              </td>
              <td>
                <xsl:value-of select="price" />
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>