package jbr.xmlparser.xslt;

import org.junit.Before;
import org.junit.Test;

public class XsltParserDomSourceTest {

  private XsltParserDomSource xsltParserDomSource;

  @Before
  public void setUp() throws Exception {
    xsltParserDomSource = new XsltParserDomSource();
  }

  @Test
  public void testWriteToFile() throws Exception {
    String xmlFile = "testdata/input/library.xml";
    String xslFile = "testdata/input/library.xsl";
    String outputFile = "testdata/output/library-dom-output.xml";

    xsltParserDomSource.writeToFile(xmlFile, xslFile, outputFile);
  }

  @Test
  public void printBookNamePrice() throws Exception {
    String xmlFile = "testdata/input/library.xml";
    String xslFile = "testdata/input/library-bookname-price.xsl";

    xsltParserDomSource.printResult(xmlFile, xslFile);
  }

}
