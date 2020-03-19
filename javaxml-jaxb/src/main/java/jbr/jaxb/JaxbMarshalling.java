package jbr.jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import jbr.jaxb.model.Book;
import jbr.jaxb.model.Library;

public class JaxbMarshalling {
  public static void main(String[] args) {

    Book book = new Book();
    book.setAuthor("Ranjith");
    book.setName("Java");
    book.setCategory("Programming");
    book.setId("100");
    book.setIsbn("342342");
    book.setPrice("1000");
    book.setPublisher("JBR");

    List<Book> books = new ArrayList<Book>();
    books.add(book);

    Library library = new Library();
    library.setBook(books);

    try {
      File outputFile = new File("testdata/output/books.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
      Marshaller marshaller = jaxbContext.createMarshaller();

      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(library, outputFile);

    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }
}
