package jbr.saxparser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import jbr.saxparser.model.Book;
import jbr.saxparser.model.Books;

public class LibraryHandler extends DefaultHandler {
  private Book _book;
  private List<Book> _booksList;
  private Books _books;
  boolean _id;
  boolean _category;
  boolean _name;
  boolean _author;
  boolean _isbn;
  boolean _price;
  boolean _publisher;

  public Books getBooks() {
    _books = new Books();
    _books.setBooks(_booksList);
    return _books;
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

    if (qName.equalsIgnoreCase("books") && _booksList == null) _booksList = new ArrayList<Book>();

    if (qName.equalsIgnoreCase("book")) {
      _book = new Book();
      _book.setId(attributes.getValue("id"));
      _book.setCategory(attributes.getValue("category"));
    }

    if (qName.equalsIgnoreCase("name")) _name = true;
    if (qName.equalsIgnoreCase("author")) _author = true;
    if (qName.equalsIgnoreCase("isbn")) _isbn = true;
    if (qName.equalsIgnoreCase("price")) _price = true;
    if (qName.equalsIgnoreCase("publisher")) _publisher = true;

    super.startElement(uri, localName, qName, attributes);
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {

    if (_name) {
      _book.setName(new String(ch, start, length));
      _name = false;
    }

    if (_author) {
      _book.setAuthor(new String(ch, start, length));
      _author = false;
    }

    if (_isbn) {
      _book.setIsbn(new String(ch, start, length));
      _isbn = false;
    }

    if (_price) {
      _book.setPrice(new String(ch, start, length));
      _price = false;
    }

    if (_publisher) {
      _book.setPublisher(new String(ch, start, length));
      _publisher = false;
    }

    super.characters(ch, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equalsIgnoreCase("book")) {
      _booksList.add(_book);
    }
  }

}
