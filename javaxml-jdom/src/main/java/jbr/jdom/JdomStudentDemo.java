package jbr.jdom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

public class JdomStudentDemo {
  public static void main(String[] args) {
    SAXBuilder saxBuilder = new SAXBuilder();

    try {
      Document document = saxBuilder.build(new File("testdata/input/student.xml"));
      XPathFactory xpf = XPathFactory.instance();
      XPathExpression<Object> xpath = xpf.compile("class/student[@rollno='493']");

      List<Object> studentList = xpath.evaluate(document);
      System.out.println("----------------------------");

      for (int temp = 0; temp < studentList.size(); temp++) {
        Element student = (Element) studentList.get(temp);

        System.out.println("\nCurrent Element :" + student.getName());
        Element val = student.getChild("address").getChild("state");
        System.out.println("val: " + val.getText());
        // System.out.println(val != null ?
        // student.getChild("address").getChild("state").getText() : null);
        /*
         * Attribute attribute = student.getAttribute("rollno");
         * System.out.println("Student roll no : " + attribute.getValue());
         * System.out.println("First Name : " +
         * student.getChild("firstname").getText());
         * System.out.println("Last Name : " +
         * student.getChild("lastname").getText());
         * System.out.println("Nick Name : " +
         * student.getChild("nickname").getText());
         * System.out.println("Marks : " + student.getChild("marks").getText());
         */
      }
    } catch (JDOMException | IOException e) {
      e.printStackTrace();
    }
  }
}
