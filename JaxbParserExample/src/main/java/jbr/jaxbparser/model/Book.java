package jbr.jaxbparser.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Book {
  private String _id;
  private String _category;
  private String _name;
  private String _author;
  private String _isbn;
  private String _price;
  private String _publisher;

  public String getId() {
    return _id;
  }

  @XmlAttribute
  public void setId(String id) {
    this._id = id;
  }

  public String getCategory() {
    return _category;
  }

  @XmlAttribute
  public void setCategory(String category) {
    this._category = category;
  }

  public String getName() {
    return _name;
  }

  @XmlElement
  public void setName(String name) {
    this._name = name;
  }

  public String getAuthor() {
    return _author;
  }

  @XmlElement
  public void setAuthor(String author) {
    this._author = author;
  }

  public String getIsbn() {
    return _isbn;
  }

  @XmlElement
  public void setIsbn(String isbn) {
    this._isbn = isbn;
  }

  public String getPrice() {
    return _price;
  }

  @XmlElement
  public void setPrice(String price) {
    this._price = price;
  }

  public String getPublisher() {
    return _publisher;
  }

  @XmlElement
  public void setPublisher(String publisher) {
    this._publisher = publisher;
  }
}
