package com.fco271292.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OperacionesExcel {
	
	public XSSFWorkbook leerExcel(String rutaArchivo) throws FileNotFoundException,IOException {
		FileInputStream fileInputStream = new FileInputStream(rutaArchivo);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		return workbook;
	}
	
	public XSSFSheet leerHoja(XSSFWorkbook workbook,Integer numberSheet) {
		XSSFSheet sheet = workbook.getSheetAt(numberSheet);
		return sheet;
	}
	
	public XSSFRow leerFila(XSSFSheet sheet,Integer rowNumber) {
		XSSFRow row = sheet.getRow(rowNumber);
		return row;
	}
	
	public XSSFCell leerCelda(XSSFRow row,Integer cellNumber) {
		XSSFCell cell = row.getCell(cellNumber);
		return cell;
	}
	
}
