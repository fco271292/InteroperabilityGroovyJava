package com.fco271292.service

import org.apache.poi.hssf.util.HSSFColor
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined
import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.ss.usermodel.Font
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class FabricaExcel {
	
	def guardaLibro(XSSFWorkbook workbook,String rutaArchivo) {
		
		FileOutputStream excel = new FileOutputStream(rutaArchivo)
		try{
			workbook.write(excel)
		}catch(Exception e){
			println "Error al generar archivo de Excel ${e.message}"
		}
	}
	
	XSSFSheet generaHojaExcel(XSSFWorkbook workbook,String nombreHoja){
	
		XSSFSheet hoja = workbook.createSheet(nombreHoja)
	}
	
	XSSFRow generaFila(XSSFSheet sheet,Integer numeroFila){
		XSSFRow renglon = sheet.createRow(numeroFila)
	}
	
	XSSFCell generaCelda(XSSFRow renglon,Integer numeroCelda,def contenido) {
		XSSFCell celda = renglon.createCell(numeroCelda)
		celda.setCellValue(contenido)
		celda
	}
	
	XSSFCellStyle agregarEstilo(XSSFWorkbook workbook) {
		XSSFCellStyle estilo = workbook.createCellStyle()
		estilo.setFillBackgroundColor(IndexedColors.BLACK.getIndex())
		estilo.setFillPattern(FillPatternType.SOLID_FOREGROUND)
		Font fuente = workbook.createFont()
		fuente.setColor(HSSFColorPredefined.WHITE.index)
		estilo.setFont(fuente)
		estilo
	}
	
}
