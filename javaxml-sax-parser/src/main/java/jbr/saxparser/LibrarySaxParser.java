package jbr.saxparser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import jbr.saxparser.model.Book;
import jbr.saxparser.model.Books;

public class LibrarySaxParser {

  public static void main(String[] args) throws Exception {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
      SAXParser saxParser = saxParserFactory.newSAXParser();
      LibraryHandler handler = new LibraryHandler();
      saxParser.parse("testdata/library.xml", handler);

      Books books = handler.getBooks();

      for (Book book : books.getBooks()) {

        System.out.println("ID: " + book.getId());
        System.out.println("CATEGORY: " + book.getCategory());
        System.out.println("NAME: " + book.getName());
        System.out.println("AUTHOR: " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("PRICE: " + book.getPrice());
        System.out.println("PUBLISHER: " + book.getPublisher());
        System.out.println("\n");
      }

    } catch (ParserConfigurationException | SAXException | IOException e) {
      e.printStackTrace();
    }

  }

}
