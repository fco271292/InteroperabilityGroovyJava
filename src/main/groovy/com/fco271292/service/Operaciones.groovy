package com.fco271292.service

import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.fco271292.domain.CodigoPostal

class Operaciones {
	
	def mostrarMenu(String rutaArchivo) {
		
		PopulateDomainGroovy populateDomain = new PopulateDomainGroovy()
		Scanner entrada = new Scanner(System.in)
		String opcion = ""
		while(opcion != "0") {
			
			String menu = "Selecciona una opcion \n 1. Listar \n 2. Agregar \n 0. Salir"
			println menu
			opcion = entrada.nextLine()
			switch(opcion){
				case "0":
				break;
				case "1":
				     def listaCodigoPostal = populateDomain.convertirExcelObjetoCodigoPostal(rutaArchivo)
					 listaCodigoPostal.each{codigoPostal->
						 def fila = """${codigoPostal.codigoPostal} | ${codigoPostal.descripcionAsentamiento} | ${codigoPostal.nombreMunicipio} | ${codigoPostal.nombreEstado}"""
						 println fila
					 }
				break;
				case "2":
					String codigoPostal = ""
					String descripcionAsentamiento = ""
					String nombreMunicipio = ""
					String nombreEstado = ""
					print "Ingresa codigo postal: "
					codigoPostal = entrada.nextLine()
					print "Ingresa descripcion del asentamiento: "
					descripcionAsentamiento = entrada.nextLine()
					print "Ingresa nombre del municipio: "
					nombreMunicipio = entrada.nextLine()
					print "Ingresa nombre del estado: "
					nombreEstado = entrada.nextLine()
					CodigoPostal codigoPostalObjeto = new CodigoPostal (codigoPostal:codigoPostal, descripcionAsentamiento: descripcionAsentamiento, nombreMunicipio:nombreMunicipio, nombreEstado:nombreEstado)
					OperacionesExcel operacionesExcel = new OperacionesExcel()
					FabricaExcel fabricaExcel = new FabricaExcel()
					XSSFWorkbook workbook
					XSSFSheet sheet
					XSSFRow row
					workbook = operacionesExcel.leerExcel(rutaArchivo)
					sheet = operacionesExcel.leerHoja(workbook, 0)
					Integer totalFilas = sheet.getPhysicalNumberOfRows()
					row = sheet.createRow(totalFilas)
					row.createCell(0).setCellValue(codigoPostalObjeto.codigoPostal)
					row.createCell(1).setCellValue(codigoPostalObjeto.descripcionAsentamiento)
					row.createCell(3).setCellValue(codigoPostalObjeto.nombreMunicipio)
					row.createCell(4).setCellValue(codigoPostalObjeto.nombreEstado)
					fabricaExcel.guardaLibro(workbook, rutaArchivo)
				break;
			}
		}		
	}
	
}
