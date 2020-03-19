package jbr.domparser;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

public class DomParserUsingXpathTest {
  private DomParserUsingXpath _domParserUsingXpath;

  @Before
  public void setUp() throws Exception {
    _domParserUsingXpath = new DomParserUsingXpath();
    _domParserUsingXpath.init("testdata/library.xml");
  }

  @Test
  public void getXpathValueTest() {
    String xpathValue = _domParserUsingXpath.getXpathValue("/library/books/book/name");
    System.out.println(xpathValue);
    Assert.assertNotEquals("", xpathValue);
  }

  @Test
  public void getXpathValuesTest() {
    List<String> xpathValues = _domParserUsingXpath.getXpathValues("/library/books/book/name");

    for (String value : xpathValues)
      System.out.println(value);
    Assert.assertNotNull(xpathValues);
    Assert.assertTrue(xpathValues.size() > 0);
  }

  @Test
  public void getXPathValueForAnAttrTest() {
    String xpathSingleAttr = _domParserUsingXpath.getXPathValueForAnAttr("/library/books/book", "category", "Atomic");
    System.out.println(xpathSingleAttr);
    Assert.assertNotNull(xpathSingleAttr);
    Assert.assertNotEquals("", xpathSingleAttr);
  }

  @Test
  public void getXPathValuesForAnAttrTest() {
    List<String> xpathSingleAttrValues = _domParserUsingXpath.getXPathValuesForAnAttr("/library/books/book", "category",
        "Natural");
    for (String value : xpathSingleAttrValues)
      System.out.println(value);

    Assert.assertNotNull(xpathSingleAttrValues);
    Assert.assertTrue(xpathSingleAttrValues.size() > 0);
  }

  @Test
  public void getXPathValueForTwoAttrTest() {
    String xpathTwoAttr = _domParserUsingXpath.getXPathValueForTwoAttr("/library/books/book", "id", "PHY00001",
        "category", "Atomic");
    System.out.println(xpathTwoAttr);
    Assert.assertNotNull(xpathTwoAttr);
  }

  @Test
  public void getXPathValuesForTwoAttrTest() {
    List<String> xpathTwoAttrValues = _domParserUsingXpath.getXPathValuesForTwoAttr("/library/books/book", "id",
        "PHY00002", "category", "Natural");
    for (String value : xpathTwoAttrValues)
      System.out.println(value);

    Assert.assertNotNull(xpathTwoAttrValues);
    Assert.assertTrue(xpathTwoAttrValues.size() > 0);
  }

  @Test
  public void getFullNodeTest() throws Exception {
    System.out.println("\n===getFullNodeTest===");
    Node node = _domParserUsingXpath.getNodeByXpath("/library/books/book", "category", "Atomic");
    String fullNodeValue = _domParserUsingXpath.getFullNode(node);
    System.out.println(fullNodeValue);
    Assert.assertNotNull(node);
    Assert.assertNotNull(fullNodeValue);
  }

}
