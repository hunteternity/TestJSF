package com.jamari.controller;
	
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

import com.jamari.model.Car;
import com.jamari.service.CarService;

@ManagedBean(name="dtBasicView")
@ViewScoped
public class BasicView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Car> cars;
     
    @ManagedProperty("#{carService}")
    private CarService service;
 
    @PostConstruct
    public void init() {
        cars = service.createCars(50);
    }
     
    public List<Car> getCars() {
        return cars;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
    
    public void postProcessorXSL(Object document){
    	HSSFWorkbook wb = (HSSFWorkbook)document;
		HSSFSheet sheet = wb.getSheetAt(0);
		
		CellStyle cs1 = wb.createCellStyle();
		CellStyle cs2 = wb.createCellStyle();
		Font fontGold = wb.createFont();
		Font fontRed = wb.createFont();
		fontGold.setColor(HSSFColor.GOLD.index);
		fontRed.setColor(HSSFColor.RED.index);
		cs1.setFont(fontGold);
		cs2.setFont(fontRed);
		
//		for(Row row : sheet){
//			for(Cell cell : row){
//				cell.setCellStyle(cs2);
//				cell.setCellValue(cell.getStringCellValue());
//			}
//		}
		
		//iterating r number of rows
		for (int r=0;r < sheet.getLastRowNum(); r++ )
		{
			HSSFRow row = sheet.getRow(r+1);
			
			for(int i=0;i<row.getLastCellNum();i++){
				HSSFCell cell = row.getCell(i);
				cell.setCellStyle(i%2==0?cs1:cs2);
				cell.setCellValue(cell.getStringCellValue());
			}
		}
		
    }
    
    public void outputXLS() throws IOException{
		String excelFileName = "C:/Users/1511008/Desktop/Test.xls";//name of excel file

		String sheetName = "Sheet1";//name of sheet
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName) ;
		
		CellStyle cs1 = wb.createCellStyle();
		CellStyle cs2 = wb.createCellStyle();
		Font fontGold = wb.createFont();
		Font fontRed = wb.createFont();
		fontGold.setColor(HSSFColor.GOLD.index);
		fontRed.setColor(HSSFColor.RED.index);
		cs1.setFont(fontGold);
		cs2.setFont(fontRed);
		
		//iterating r number of rows
		for (int r=0;r < cars.size(); r++ )
		{
			HSSFRow row = sheet.createRow(r);
			
			for(int i=0;i<4;i++){
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(i%2==0?cs1:cs2);
				cell.setCellValue(cars.get(r).getValue(i));
			}
		}
		
		File file = new File(excelFileName);
		if(file.exists()){
			file.delete();
		}
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
//		wb.close();
		String[] cmd = { "C:/Program Files/Microsoft Office 15/root/office15/EXCEL.EXE", excelFileName };
		Runtime.getRuntime().exec(cmd);
	}
}
