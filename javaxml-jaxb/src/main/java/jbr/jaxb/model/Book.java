package jbr.jaxb.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Book {
  private String id;
  private String category;
  private String name;
  private String author;
  private String isbn;
  private String price;
  private String publisher;

  public String getId() {
    return id;
  }

  @XmlAttribute
  public void setId(String id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  @XmlAttribute
  public void setCategory(String category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  @XmlElement
  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  @XmlElement
  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  @XmlElement
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getPrice() {
    return price;
  }

  @XmlElement
  public void setPrice(String price) {
    this.price = price;
  }

  public String getPublisher() {
    return publisher;
  }

  @XmlElement
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
}
