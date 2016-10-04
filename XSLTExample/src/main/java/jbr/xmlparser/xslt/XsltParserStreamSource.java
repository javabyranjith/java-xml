package jbr.xmlparser.xslt;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XsltParserStreamSource {

  private TransformerFactory transformerFactory = TransformerFactory.newInstance();

  public void writeToFile(String xmlFile, String xslFile, String outputFile) throws Exception {
    Source xslSource = new StreamSource(new File(xslFile));
    Source xmlSource = new StreamSource(new File(xmlFile));

    Transformer transformer = transformerFactory.newTransformer(xslSource);
    Result result = new StreamResult(new File(outputFile));
    transformer.transform(xmlSource, result);
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
