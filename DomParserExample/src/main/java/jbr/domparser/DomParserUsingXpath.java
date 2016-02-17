package jbr.domparser;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParserUsingXpath {
  private Document _document;
  private XPath _xPath;

  /**
   * Initializes objects
   */
  public void init(String xmlFile) {
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder;

    try {
      documentBuilder = documentBuilderFactory.newDocumentBuilder();
      _document = documentBuilder.parse(new File(xmlFile));
      _xPath = XPathFactory.newInstance().newXPath();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Get a value by xapth expression
   * 
   * @param xpath
   * @return
   */
  public String getXpathValue(String xpath) {
    String xpathValue = "";

    if (StringUtils.isNotEmpty(xpath)) {
      try {
        xpathValue = _xPath.compile(xpath).evaluate(_document);
      } catch (XPathExpressionException e) {
        System.out.println(e.getMessage());
      }
    }

    return xpathValue;
  }

  /**
   * Get all the values matches by xapth expression
   * 
   * @param xpath
   * @return
   */
  public List<String> getXpathValues(String xpath) {
    List<String> xpathValues = new ArrayList<String>();

    try {
      NodeList nodeList = (NodeList) _xPath.compile(xpath).evaluate(_document, XPathConstants.NODESET);

      if (null != nodeList && nodeList.getLength() > 0) {
        for (int i = 0; i < nodeList.getLength(); i++) {
          xpathValues.add(nodeList.item(i).getTextContent());
        }
      }
    } catch (XPathExpressionException e) {
      System.out.println(e.getMessage());
    }

    return xpathValues;
  }

  public List<String> getXpathDistinctValues(String xpath) {
    List<String> xpathValues = new ArrayList<String>();

    try {
      NodeList nodeList = (NodeList) _xPath.compile(xpath).evaluate(_document, XPathConstants.NODESET);

      for (int i = 0; null != nodeList && nodeList.getLength() > 0 && i < nodeList.getLength(); i++) {
        String xpathVal = nodeList.item(i).getTextContent();
        if (!xpathValues.contains(xpathVal)) xpathValues.add(xpathVal);
      }

    } catch (XPathExpressionException e) {
      System.out.println(e.getMessage());
    }

    return xpathValues;
  }

  /**
   * Get value for a xpath using single attribute and its value.
   * 
   * @param xpath
   * @param attrName
   * @param attrVal
   * @return
   */
  public String getXPathValueForAnAttr(String xpath, String attrName, String attrVal) {
    String xpathValue = "";

    if (StringUtils.isNotEmpty(xpath) && StringUtils.isNotEmpty(attrName) && StringUtils.isNotEmpty(attrVal)) {
      try {
        NodeList nodeList = (NodeList) _xPath.compile(xpath).evaluate(_document, XPathConstants.NODESET);

        for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
          Node node = nodeList.item(i);
          Node attr = node.getAttributes().getNamedItem(attrName);

          if (null != attr && attr.getNodeName().equalsIgnoreCase(attrName)
              && attr.getNodeValue().equalsIgnoreCase(attrVal)) {
            xpathValue = node.getTextContent();
          }
        }
      } catch (XPathExpressionException e) {
        System.out.println(e.getMessage());
      }
    }

    return xpathValue;
  }

  /**
   * Get all the values for a xpath using single attribute and its value.
   * 
   * @param xpath
   * @param attrName
   * @param attrVal
   * @return
   */
  public List<String> getXPathValuesForAnAttr(String xpath, String attrName, String attrVal) {
    List<String> xpathValues = new ArrayList<String>();

    if (StringUtils.isNotEmpty(xpath) && StringUtils.isNotEmpty(attrName) && StringUtils.isNotEmpty(attrVal)) {
      try {
        NodeList nodeList = (NodeList) _xPath.compile(xpath).evaluate(_document, XPathConstants.NODESET);

        for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
          Node node = nodeList.item(i);
          Node attr = node.getAttributes().getNamedItem(attrName);

          if (null != attr && attr.getNodeName().equalsIgnoreCase(attrName)
              && attr.getNodeValue().equalsIgnoreCase(attrVal)) {
            xpathValues.add(node.getTextContent());
          }
        }
      } catch (XPathExpressionException e) {
        System.out.println(e.getMessage());
      }
    }

    return xpathValues;
  }

  /**
   * Get value for a xpath using two attributes and its value.
   * 
   * @param xpath
   * @param attr1Name
   * @param attr1Value
   * @param attr2Name
   * @param attr2Value
   * @return
   */
  public String getXPathValueForTwoAttr(String xpath, String attr1Name, String attr1Value, String attr2Name,
      String attr2Value) {
    String xpathValue = "";

    if (StringUtils.isNotEmpty(xpath) && StringUtils.isNotEmpty(attr1Name) && StringUtils.isNotEmpty(attr1Value)
        && StringUtils.isNotEmpty(attr2Name) && StringUtils.isNotEmpty(attr2Value)) {

      try {
        NodeList nodeList = (NodeList) _xPath.compile(xpath).evaluate(_document, XPathConstants.NODESET);

        for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
          Node node = nodeList.item(i);
          Node attr1 = node.getAttributes().getNamedItem(attr1Name);
          Node attr2 = node.getAttributes().getNamedItem(attr2Name);

          if (null != attr1 && attr1.getNodeName().equalsIgnoreCase(attr1Name)
              && attr1.getNodeValue().equalsIgnoreCase(attr1Value) && null != attr2
              && attr2.getNodeName().equalsIgnoreCase(attr2Name) && attr2.getNodeValue().equalsIgnoreCase(attr2Value)) {
            xpathValue = node.getTextContent();
          }
        }
      } catch (XPathExpressionException e) {
        System.out.println(e.getMessage());
      }
    }

    return xpathValue;
  }

  /**
   * Get all the values for a xpath using two attributes and its value.
   * 
   * @param xpath
   * @param attr1Name
   * @param attr1Value
   * @param attr2Name
   * @param attr2Value
   * @return
   */
  public List<String> getXPathValuesForTwoAttr(String xpath, String attr1Name, String attr1Value, String attr2Name,
      String attr2Value) {
    List<String> xpathValues = new ArrayList<String>();

    if (StringUtils.isNotEmpty(xpath) && StringUtils.isNotEmpty(attr1Name) && StringUtils.isNotEmpty(attr1Value)
        && StringUtils.isNotEmpty(attr2Name) && StringUtils.isNotEmpty(attr2Value)) {

      try {
        NodeList nodeList = (NodeList) _xPath.compile(xpath).evaluate(_document, XPathConstants.NODESET);

        for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
          Node node = nodeList.item(i);
          Node attr1 = node.getAttributes().getNamedItem(attr1Name);
          Node attr2 = node.getAttributes().getNamedItem(attr2Name);

          if (null != attr1 && attr1.getNodeName().equalsIgnoreCase(attr1Name)
              && attr1.getNodeValue().equalsIgnoreCase(attr1Value) && null != attr2
              && attr2.getNodeName().equalsIgnoreCase(attr2Name) && attr2.getNodeValue().equalsIgnoreCase(attr2Value)) {
            xpathValues.add(node.getTextContent());
          }
        }
      } catch (XPathExpressionException e) {
        System.out.println(e.getMessage());
      }
    }

    return xpathValues;
  }

  public Node getNodeByXpath(String xpath, String attrName, String attrVal) {
    Node nodeObject = null;

    if (StringUtils.isNotEmpty(xpath) && StringUtils.isNotEmpty(attrName) && StringUtils.isNotEmpty(attrVal)) {
      try {
        NodeList nodeList = (NodeList) _xPath.compile(xpath).evaluate(_document, XPathConstants.NODESET);

        for (int i = 0; null != nodeList && i < nodeList.getLength(); i++) {
          Node node = nodeList.item(i);
          Node attr = node.getAttributes().getNamedItem(attrName);

          if (null != attr && attr.getNodeName().equalsIgnoreCase(attrName)
              && attr.getNodeValue().equalsIgnoreCase(attrVal)) {
            nodeObject = node;
          }
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    return nodeObject;
  }

  public String getFullNode(Node node) throws TransformerFactoryConfigurationError, TransformerException {
    StreamResult nodeData = new StreamResult(new StringWriter());

    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    transformer.transform(new DOMSource(node), nodeData);

    return nodeData.getWriter().toString();
  }
}
