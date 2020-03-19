package jbr.jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Library {

  List<Book> book;

  public List<Book> getBook() {
    return book;
  }

  @XmlElement
  public void setBook(List<Book> book) {
    this.book = book;
  }

}
