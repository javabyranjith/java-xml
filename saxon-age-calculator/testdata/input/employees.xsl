<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:up="http://example.com/saxon-extension">
  <xsl:template match="/">
    <html>
      <body>
        <h2>Employee Details</h2>
        <table border="1">
          <tr bgcolor="#9acd32">
            <th style="text-align:left">Name</th>
            <th style="text-align:left">Address</th>
            <th style="text-align:left">Date of Birth</th>
            <th style="text-align:left">Age</th>
            <th style="text-align:left">Phone</th>
            <th style="text-align:left">Email</th>
          </tr>
          <xsl:for-each select="employees/employee">
            <tr>
              <td>
                <xsl:value-of select="name" />
              </td>
              <td>
                <xsl:value-of select="address" />
              </td>
              <td>
                <xsl:value-of select="dob" />
              </td>
              <td>
                <xsl:value-of select="up:upper(dob)" />
              </td>
              <td>
                <xsl:value-of select="phone" />
              </td>
              <td>
                <xsl:value-of select="email" />
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>