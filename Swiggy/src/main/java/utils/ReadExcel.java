package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) {
		String projectPath=System.getProperty("user.dir");
        String excelFilePath=projectPath+"/src/test/resources/swiggy_negative_accounts.xlsx";
        
        try {
        	for(int i=0;i<loadExcel(excelFilePath, "phone", true).length;i++) {
        		System.out.println(loadExcel(excelFilePath, "phone", true)[i][0]);
        		System.out.println(loadExcel(excelFilePath, "phone", true)[i][1]);
        	}
        	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
    
public static Object[][] loadExcel(String excelFilePath, String sheetName, boolean firstRowIsHeader) throws IOException{
    	
    	
    	InputStream fis = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//workbook.getSheetAt(sheetNum);
		int totalRows = sheet.getLastRowNum();
		
    	Object[][] data;
    	int rowIndex;
    	
		// if first row is header , start from rowIndex=1
		if(firstRowIsHeader) {
			rowIndex=1;
			data= new Object[totalRows][2];
		}else {
			// if first row is header , start from rowIndex=0
			rowIndex=0;
			data= new Object[totalRows+1][2];
		}
		
		 for(;rowIndex <= totalRows;rowIndex++) {
             //iterating to all rows
             XSSFRow row = sheet.getRow(rowIndex);
             int totalCells=row.getLastCellNum();
             for ( int cellIndex=0;cellIndex < totalCells; cellIndex++) {
                 XSSFCell cell = row.getCell(cellIndex);
                 int objectRowindex=rowIndex;
                 if(firstRowIsHeader) {
                     objectRowindex=rowIndex-1;
                 }
                 
                 //print
                 switch(cell.getCellType()) {
                 case STRING:
                     data[objectRowindex][cellIndex]=cell.getStringCellValue();
                     break;
                 case NUMERIC:
                     data[objectRowindex][cellIndex]=cell.getNumericCellValue();
                     break;
				default:
					break;
                 }
             }
		
		 }
		 return data;
    }

    }
