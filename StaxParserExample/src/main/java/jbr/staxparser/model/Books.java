package jbr.staxparser.model;

import java.util.List;

public class Books {

  private String _dept;
  private List<Book> _books;

  public String getDept() {
    return _dept;
  }

  public void setDept(String dept) {
    this._dept = dept;
  }

  public List<Book> getBooks() {
    return _books;
  }

  public void setBooks(List<Book> books) {
    this._books = books;
  }

}
