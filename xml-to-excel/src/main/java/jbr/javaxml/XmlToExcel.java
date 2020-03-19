package jbr.javaxml;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

/**
 * Converting XML file into excel file.
 *
 */
public class XmlToExcel {

  private static Workbook workbook;
  private static int rowNum;
  private final static int CATEGORY = 0;
  private final static int ID = 1;
  private final static int NAME = 2;
  private final static int MANUFACTURER = 3;
  private final static int MODEL = 4;
  private final static int PRICE = 5;

  public static void main(String[] args) throws Exception {
    createExcelFileAndHeader();
    Sheet sheet = workbook.getSheetAt(0);

    getExcelReport(sheet);

    FileOutputStream fileOutputStream = new FileOutputStream("output/report.xlsx");
    workbook.write(fileOutputStream);
    workbook.close();
    fileOutputStream.close();
  }

  static void getExcelReport(Sheet sheet) throws Exception {
    SAXBuilder saxBuilder = new SAXBuilder();
    XPathExpression<Element> xPathExpr = XPathFactory.instance().compile("products", Filters.element());

    try {
      Document document = saxBuilder.build(new File("input/products.xml"));
      Element element = xPathExpr.evaluateFirst(document);

      List<Element> children = element.getChildren();
      for (Element e : children) {
        Row row = sheet.createRow(rowNum++);

        if (e.getAttribute("category") != null) {
          Cell cell = row.createCell(CATEGORY);
          cell.setCellValue(e.getAttributeValue("category"));
        }

        if (e.getChild("id") != null) {
          Cell cell = row.createCell(ID);
          cell.setCellValue(e.getChildText("id"));
        }

        if (e.getChild("name") != null) {
          Cell cell = row.createCell(NAME);
          cell.setCellValue(e.getChildText("name"));
        }

        if (e.getChild("manufacturer") != null) {
          Cell cell = row.createCell(MANUFACTURER);
          cell.setCellValue(e.getChildText("manufacturer"));
        }

        if (e.getChild("model") != null) {
          Cell cell = row.createCell(MODEL);
          cell.setCellValue(e.getChildText("model"));
        }

        if (e.getChild("price") != null) {
          Cell cell = row.createCell(PRICE);
          cell.setCellValue(e.getChildText("price"));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void createExcelFileAndHeader() {
    workbook = new XSSFWorkbook();

    CellStyle style = workbook.createCellStyle();
    Font boldFont = workbook.createFont();
    boldFont.setBold(true);
    style.setFont(boldFont);

    Sheet sheet = workbook.createSheet();
    rowNum = 0;
    Row row = sheet.createRow(rowNum++);

    Cell cell = row.createCell(CATEGORY);
    cell.setCellValue("Category");
    cell.setCellStyle(style);

    cell = row.createCell(ID);
    cell.setCellValue("Product ID");
    cell.setCellStyle(style);

    cell = row.createCell(NAME);
    cell.setCellValue("Product Name");
    cell.setCellStyle(style);

    cell = row.createCell(MANUFACTURER);
    cell.setCellValue("Manufacturer");
    cell.setCellStyle(style);

    cell = row.createCell(MODEL);
    cell.setCellValue("Model Number");
    cell.setCellStyle(style);

    cell = row.createCell(PRICE);
    cell.setCellValue("Price");
    cell.setCellStyle(style);
  }
}
