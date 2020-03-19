package jbr.domparser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SimpleDomParser {

  public static void main(String[] args) {
    File xmlFile = new File("testdata/library.xml");
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder;

    try {
      documentBuilder = documentBuilderFactory.newDocumentBuilder();
      Document document = documentBuilder.parse(xmlFile);

      NodeList books = document.getElementsByTagName("book");

      for (int i = 0; i < books.getLength(); i++) {
        Node book = books.item(i);
        if (book.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element) book;
          System.out.println(element.getAttribute("id"));
          System.out.println(element.getElementsByTagName("name").item(0).getTextContent());
        }
      }
    } catch (ParserConfigurationException | SAXException | IOException e) {
      e.printStackTrace();
    }
  }

}
