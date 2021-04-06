package org.dhohle.selenium

import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.util.NumberToTextConverter
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import java.io.FileInputStream
import java.util._


object DataDriven {
  def extractData(testSheetName: String, testCaseName: String, fieldName: String): ArrayList[String] = {
    val file = new FileInputStream(System.getProperty("user.dir") + "/Data/LoginData.xlsx")
    //taking location of the excel sheet
    val workbook = new XSSFWorkbook(file)
    //storing excel sheet in a XSSFWorkbook file
    val excelData = new ArrayList[String]
    val sheets = workbook.getNumberOfSheets
    //extracting number of sheets in the workbook
    for (i <- 0 until sheets) {
      if (workbook.getSheetName(i).equalsIgnoreCase(testSheetName)) {
        //Check for the expected name of sheet inside the workbook
        val sheet = workbook.getSheetAt(i)
        val rows = sheet.iterator
        val firstRow = rows.next
        val ce = firstRow.cellIterator
        var k = 0
        var column = 0
        while ( {
          ce.hasNext
        }) {
          val value = ce.next
          if (value.getStringCellValue.equalsIgnoreCase(fieldName)) column = k
          //Check for the expected name of column inside the workbook
          k += 1
        }
        while ( {
          rows.hasNext
        }) {
          val r = rows.next
          if (r.getCell(column).getStringCellValue.equalsIgnoreCase(testCaseName)) {
            //Check for the expected name of row inside the workbook
            val cv = r.cellIterator
            while ( {
              cv.hasNext
            }) {
              val c = cv.next
              if (c.getCellType eq CellType.STRING) excelData.add(c.getStringCellValue)
              //handling of the input if it is of string type
              else excelData.add(NumberToTextConverter.toText(c.getNumericCellValue))
              //handling of the input if it is of integer type
            }
          }
        }
      }
    }
    excelData
  }
}