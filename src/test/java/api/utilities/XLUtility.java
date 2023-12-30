package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// fi fo, Workbook, sheet, Row, Cell



public class XLUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle Style;
	String path = null;
	
	
	public XLUtility(String path)
	{
	   this.path = path;
	}
	
	
	public int getRowCount(String sheetname) throws IOException
	{
		 
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		int rowcount= sheet.getLastRowNum();
	    workbook.close();
	    fi.close();
	    return rowcount;
		
	}
	
	public int getCellCount(String sheetname,int rownum) throws IOException
	{
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
        row = sheet.getRow(rownum);
        int cellcount= row.getLastCellNum();
        workbook.close();
	    fi.close();
		
		return cellcount;
	}
	
	public String getCellData(String sheetname,int rownum,int colnum) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			
		data = formatter.formatCellValue(cell);	
		}
		
	    catch(Exception e)
		{
	    	data ="";
		}
		workbook.close();
	    fi.close();
		return data;

		
	}
	
	
	
	
	
}