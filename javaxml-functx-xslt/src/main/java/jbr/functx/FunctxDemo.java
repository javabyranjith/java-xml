package jbr.functx;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class FunctxDemo {

  public static void main(String[] args) throws Exception {
    String sourcePath = "testdata/functx/functx.xml";
    String xsltPath = "testdata/functx/functx.xsl";
    String resultDir = "testdata/functx/functx-output.html";

    TransformerFactory factory = TransformerFactory.newInstance();
    Transformer transformer = factory.newTransformer(new StreamSource(new File(xsltPath)));
    transformer.transform(new StreamSource(new File(sourcePath)), new StreamResult(new File(resultDir)));

    System.out.println("Output generated successfully at: " + resultDir);
  }
}
