package jbr.xmlparser.xslt;

import org.junit.Before;
import org.junit.Test;

public class XsltParserStreamSourceTest {
  private XsltParserStreamSource xsltParserStreamSource;

  @Before
  public void setUp() throws Exception {
    xsltParserStreamSource = new XsltParserStreamSource();
  }

  @Test
  public void testWriteToFile() throws Exception {
    String xmlFile = "testdata/input/library.xml";
    String xslFile = "testdata/input/library.xsl";
    String outputFile = "testdata/output/library-stream-output.xml";

    xsltParserStreamSource.writeToFile(xmlFile, xslFile, outputFile);
  }

  @Test
  public void printBookNamePrice() throws Exception {
    String xmlFile = "testdata/input/library.xml";
    String xslFile = "testdata/input/library-bookname-price.xsl";

    xsltParserStreamSource.printResult(xmlFile, xslFile);
  }

}
