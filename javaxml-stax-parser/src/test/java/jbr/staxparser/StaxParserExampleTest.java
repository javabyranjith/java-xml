package jbr.staxparser;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jbr.staxparser.model.Book;

public class StaxParserExampleTest {
  private StaxParserExample _staxParserExample;
  private List<Book> _books;

  @Before
  public void setUp() throws Exception {
    _staxParserExample = new StaxParserExample();
    _books = _staxParserExample.parseXmlData("testdata/library.xml");
  }

  @Test
  public void testBook1() {
    Book book1 = _books.get(0);
    Assert.assertEquals("PHY00001", book1.getId());
    Assert.assertEquals("Atomic", book1.getCategory());
    Assert.assertEquals("Concepts of Physics", book1.getName());
    Assert.assertEquals("H.C.Verma", book1.getAuthor());
  }

}
