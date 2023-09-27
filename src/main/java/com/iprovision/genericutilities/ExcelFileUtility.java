package com.iprovision.genericutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to Excel file
 * @author abhishek.birana
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This method will write the data into excel sheet
	 * @param sheetname
	 * @param rowNo
	 * @param celNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoNewExcelSheet(String sheetName, int rowNo, int celNo, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName);
		Row rw = sh.createRow(rowNo);
		Cell cel = rw.createCell(celNo);
		cel.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(ConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	/**
	 * This method will write the data into existing excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param colNo
	 * @param name
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExistingExcelSheet(String sheetName, int rowNo, int colNo, String name, int randomNum) throws EncryptedDocumentException, IOException
	{
//		Random r = new Random();
//		int ran = r.nextInt(1000);
//		//	AbhishekAutomationSet_001
//		//	AbhishekAutomationProfile001
//		//	Split by "_" ------->
		
		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).setCellValue(name.replaceAll("[A-Za-z0-9]", ""));
		
		if(name.contains("Set"))
		{
			String[] nameUpdated = name.split("_");
			nameUpdated[1] = nameUpdated[1].replaceAll("[^A-Za-z]", "");
			String nameNew = nameUpdated[0]+"_"+randomNum;
			wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).setCellValue(nameNew);
		}
		else
		{
			String[] nameUpdated = name.split("Profile");
			nameUpdated[1] = nameUpdated[1].replaceAll("[^A-Za-z]", "");
			String nameNew = nameUpdated[0]+"Profile"+randomNum;
			wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).setCellValue(nameNew);
		}
//		
//		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
//		Workbook wb = WorkbookFactory.create(fis);
//		wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).setCellValue(nameNew);
//		
//		FileOutputStream fos = new FileOutputStream(ConstantsUtility.excelFilePath);
//		wb.write(fos);
//		wb.close();
//		
//		
		
		
		
		FileOutputStream fos = new FileOutputStream(ConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	
	/**
	 * This method will write the data into existing excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param colNo
	 * @param parentId
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeParentIdIntoExistingExcelSheet(String sheetName, int rowNo, int colNo, String parentId) throws EncryptedDocumentException, IOException
	{
		//parentId.replaceAll("[A-Za-z0-9]", "");
		
		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).setCellValue(parentId.replaceAll("[A-Za-z0-9]", ""));
		wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).setCellValue(parentId);
		
		FileOutputStream fos = new FileOutputStream(ConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	
	
	/**
	 * This method will capture all the data inside a sheet for dataprovider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
