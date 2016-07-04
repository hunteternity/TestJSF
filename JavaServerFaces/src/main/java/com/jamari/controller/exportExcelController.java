package com.jamari.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;



import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.jamari.model.Car;

@ManagedBean(name="exportExcel")
public class exportExcelController {
	
	 private List<Car> cars = new ArrayList<Car>();
     
	     
	    @PostConstruct
	    public void init() {
	    	
	        cars.add(new Car("c1","2001","BMW","Black"));
	        cars.add(new Car("c2","1999","Jaguar","White"));
	        cars.add(new Car("c3","1987","Honda","Blue"));
	        
	    }
	 
	    public List<Car> getCars() {
	        return cars;
	    }
	    
	    
	    public void export(List<Car> cars) {
	    	System.out.println("start export~~~~~~~ ");
	    	
	    	FacesContext facesContext = FacesContext.getCurrentInstance();
	    	ExternalContext ec = facesContext.getExternalContext();
	    	String fileName = "carData.xls";
	    	
	    	ec.responseReset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
	        ec.setResponseContentType("application/vnd.ms-excel"); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ExternalContext#getMimeType() for auto-detection based on filename.
	        /*ec.setResponseContentLength(contentLength); */ // Set it with the file size. This header is optional. It will work if it's omitted, but the download progress will be unknown.    
	        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.

	        OutputStream output;
			try {
				output = ec.getResponseOutputStream();
			
	        // Now you can write the InputStream of the file to the above OutputStream the usual way.
	        HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");
            
            HSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.LIME.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            HSSFRow rowhead = sheet.createRow((short)0);
            
            HSSFCell cell = rowhead.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue("Id");
            
            cell = rowhead.createCell(1);
            cell.setCellStyle(style);
            cell.setCellValue("Year");
            
            cell = rowhead.createCell(2);
            cell.setCellStyle(style);
            cell.setCellValue("Brand");
            
            cell = rowhead.createCell(3);
            cell.setCellStyle(style);
            cell.setCellValue("Color");
          
            
            for(int i =1; i <= cars.size(); i++){
            	HSSFRow row = sheet.createRow((short)i);
                row.createCell(0).setCellValue(cars.get(i-1).getmId());
                row.createCell(1).setCellValue(cars.get(i-1).getmYear());
                row.createCell(2).setCellValue(cars.get(i-1).getmBrand());
                row.createCell(3).setCellValue(cars.get(i-1).getmColor());
            }
            
            
            workbook.write(output);
            output.close();
            
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        facesContext.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
	    }
	    	
	    	
	    }
	 
	   






