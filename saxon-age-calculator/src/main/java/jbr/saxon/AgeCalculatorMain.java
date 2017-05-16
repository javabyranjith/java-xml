package jbr.saxon;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.Configuration;
import net.sf.saxon.TransformerFactoryImpl;
import net.sf.saxon.trans.XPathException;

public class AgeCalculatorMain {

	public static void main(String[] args) throws XPathException {
		// Set saxon as your transformer.
		System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");

		// specify input and output
		transform("testdata/input/employees.xml", "testdata/input/employees.xsl", "testdata/output/output.html");
	}

	public static void transform(String sourcePath, String xsltPath, String resultDir) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();

			if (factory instanceof TransformerFactoryImpl) {
				TransformerFactoryImpl tFactoryImpl = (TransformerFactoryImpl) factory;
				Configuration config = tFactoryImpl.getConfiguration();
				config.registerExtensionFunction(new AgeCalculator());
			}

			Transformer transformer = factory.newTransformer(new StreamSource(new File(xsltPath)));
			transformer.transform(new StreamSource(new File(sourcePath)), new StreamResult(new File(resultDir)));

			System.out.println("Output generated successfully at: " + resultDir);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}