package jbr.saxparser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleSaxParserExample {
  public static void main(String[] args) throws Exception {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();

    DefaultHandler handler = new DefaultHandler() {
      boolean name;
      boolean author;
      boolean isbn;
      boolean price;
      boolean publisher;

      @Override
      public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("name")) name = true;
        if (qName.equalsIgnoreCase("author")) author = true;
        if (qName.equalsIgnoreCase("isbn")) isbn = true;
        if (qName.equalsIgnoreCase("price")) price = true;
        if (qName.equalsIgnoreCase("publisher")) publisher = true;

        super.startElement(uri, localName, qName, attributes);
      }

      @Override
      public void characters(char[] ch, int start, int length) throws SAXException {
        if (name) {
          System.out.println("Name: " + new String(ch, start, length));
          name = false;
        }
        if (author) {
          System.out.println("Author: " + new String(ch, start, length));
          author = false;
        }
        if (isbn) {
          System.out.println("ISBN: " + new String(ch, start, length));
          isbn = false;
        }
        if (price) {
          System.out.println("Price: " + new String(ch, start, length));
          price = false;
        }
        if (publisher) {
          System.out.println("Publisher: " + new String(ch, start, length));
          publisher = false;
        }
        
        super.characters(ch, start, length);
      }

      @Override
      public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
      }

    };

    saxParser.parse("testdata/library.xml", handler);
  }
}
