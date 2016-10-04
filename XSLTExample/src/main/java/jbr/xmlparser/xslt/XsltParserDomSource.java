package jbr.xmlparser.xslt;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XsltParserDomSource {

  private TransformerFactory transformerFactory = TransformerFactory.newInstance();

  public void writeToFile(String xmlFile, String xslFile, String outputFile) throws Exception {
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    Document inputDoc = documentBuilder.parse(xmlFile);

    NodeList books = inputDoc.getElementsByTagName("book");

    Source xslSource = new StreamSource(new File(xslFile));
    Transformer transformer = transformerFactory.newTransformer(xslSource);

    for (int i = 0; i < books.getLength(); i++) {
      Node book = books.item(i);
      if (book.getNodeType() == Node.ELEMENT_NODE) {
        Writer writer = new StringWriter();
        Result result = new DOMResult();
        Source domSource = new DOMSource(book);
        transformer.transform(domSource, result);
      }
    }

  }

  public void printResult(String xmlFile, String xslFile) throws Exception {
    Source xslSource = new StreamSource(new File(xslFile));
    Source xmlSource = new StreamSource(new File(xmlFile));

    Transformer transformer = transformerFactory.newTransformer(xslSource);

    Writer writer = new StringWriter();
    Result result = new StreamResult(writer);
    transformer.transform(xmlSource, result);
    String outputStr = writer.toString();
    System.out.println(outputStr);
  }
}
