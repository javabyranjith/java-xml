package jbr.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jbr.jaxb.model.Book;
import jbr.jaxb.model.Library;

public class JaxbUnmarshalling {

  public static void main(String[] args) {

    try {
      File inputFile = new File("testdata/input/library.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);

      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      Library library = (Library) unmarshaller.unmarshal(inputFile);

      List<Book> books = library.getBook();
      Book book = books.get(1);
      System.out.println(book.getName());
      System.out.println(book.getCategory());
    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }
}
