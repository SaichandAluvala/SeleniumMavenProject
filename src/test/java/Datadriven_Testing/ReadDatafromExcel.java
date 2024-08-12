package Datadriven_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDatafromExcel {
	public static void main(String[] args) throws Exception {
        //raw excel data
		File file=new File("C:\\Users\\saaluvala\\OneDrive - Copart, Inc\\Desktop\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(file); 
		
		//workbook excel data 
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(1);
		
	//String cellvalue=	sheet.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(cellvalue);
		
		
		//get complete excel data
		
		int rowcount=sheet.getPhysicalNumberOfRows();
		
		
		XSSFRow row=sheet.getRow(rowcount-1);
		int cellcount=row.getPhysicalNumberOfCells();
		
		System.out.println("Rows :"+rowcount +"||" +"Cells :" +cellcount);
		
		
		//print the excel data
		for (int i=1; i<rowcount; i++) {
			XSSFRow rowvalue=sheet.getRow(i);
			
			for (int j=1; j<cellcount; j++) {
				XSSFCell cellvalue=rowvalue.getCell(j);
				//System.out.print("||"+cellvalue); 
				
				
				System.out.print("||"+cellvalue);
			}
			System.out.println();
		}
		
		workbook.close();
		fis.close();
}
}