package com.clarence.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.model.WorkbookRecordList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utilz
{
	private static String pathness = System.getProperty("user.dir").replace("\\", "//");
	private static final String FILE_NAME = pathness + "/readme.xlsx";
	
	public static void main(String args[])
	{
		try 
		{
//			System.out.println(System.getProperty("user.dir"));
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            while(iterator.hasNext())
            {
            	Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                
                while (cellIterator.hasNext()) 
                {
                	Cell currentCell = cellIterator.next();
                	if (currentCell.getCellTypeEnum() == CellType.STRING)
                	{
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } 
                	else if (currentCell.getCellTypeEnum() == CellType.NUMERIC)
                	{
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }
				}
                System.out.println();
            }
            
            workbook.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	
			
		
	}
}
