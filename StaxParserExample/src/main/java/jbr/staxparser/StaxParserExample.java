package jbr.staxparser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.sun.xml.internal.stream.events.AttributeImpl;

import jbr.staxparser.model.Book;

/**
 * StAX Parser Example.
 */
public class StaxParserExample {
  public List<Book> parseXmlData(String xmlFile) {
    List<Book> books = new ArrayList<Book>();
    Book book = null;
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

    try {
      XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFile));

      while (xmlEventReader.hasNext()) {
        XMLEvent xmlEvent = xmlEventReader.nextEvent();

        if (xmlEvent.isStartElement()) {
          StartElement startElement = xmlEvent.asStartElement();
          String currentElement = startElement.getName().getLocalPart();

          // Read start element as from <book>
          if (currentElement.equals("book")) {
            book = new Book();

            // Read <book> attributes
            Iterator<AttributeImpl> itr = startElement.getAttributes();
            while (itr.hasNext()) {
              AttributeImpl value = (AttributeImpl) itr.next();
              QName name = value.getName();

              if (name.getLocalPart().equals("id")) {
                book.setId(value.getValue());
              } else if (name.getLocalPart().equals("category")) {
                book.setCategory(value.getValue());
              }
            }

            // Read other child elements of <book>
          } else if (currentElement.equals("name")) {
            xmlEvent = xmlEventReader.nextEvent();
            book.setName(xmlEvent.asCharacters().getData());
          } else if (currentElement.equals("author")) {
            xmlEvent = xmlEventReader.nextEvent();
            book.setAuthor(xmlEvent.asCharacters().getData());
          } else if (currentElement.equals("isbn")) {
            xmlEvent = xmlEventReader.nextEvent();
            book.setIsbn(xmlEvent.asCharacters().getData());
          } else if (currentElement.equals("price")) {
            xmlEvent = xmlEventReader.nextEvent();
            book.setPrice(xmlEvent.asCharacters().getData());
          } else if (currentElement.equals("publisher")) {
            xmlEvent = xmlEventReader.nextEvent();
            book.setPublisher(xmlEvent.asCharacters().getData());
          }
        }

        // Read end element of <book>
        if (xmlEvent.isEndElement()) {
          EndElement endElement = xmlEvent.asEndElement();
          if (endElement.getName().getLocalPart().equals("book")) {
            books.add(book);
          }
        }
      }
    } catch (FileNotFoundException | XMLStreamException e) {
      e.printStackTrace();
    }

    return books;
  }
}
