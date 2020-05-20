package com.fco271292.service

import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.fco271292.domain.CodigoPostal

class PopulateDomainGroovy {
	
	OperacionesExcel operacionesExcel = new OperacionesExcel();
	
	List<CodigoPostal> convertirExcelObjetoCodigoPostal(String rutaArchivoExcel) {
		
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;
		CodigoPostal codigoPostal
		List<CodigoPostal> listaCodigoPostal = []
		
		try {
			workbook = operacionesExcel.leerExcel(rutaArchivoExcel);
			sheet = operacionesExcel.leerHoja(workbook, 0);
			
			Integer totalFilas = sheet.getPhysicalNumberOfRows()
			(totalFilas).times{numeroFila->
				row = operacionesExcel.leerFila(sheet, numeroFila);
				codigoPostal = new CodigoPostal()
				Integer numeroCeldas = row.getPhysicalNumberOfCells()
				for(Integer indiceCelda = 0; indiceCelda <= numeroCeldas; indiceCelda++) {
					switch(indiceCelda) {
						case 0:
							codigoPostal.codigoPostal = row.getCell(indiceCelda)
						break;
						case 1:
							codigoPostal.descripcionAsentamiento = row.getCell(indiceCelda)
						break;
						case 2:
							codigoPostal.tipoAsentamiento = row.getCell(indiceCelda)
						break;
						case 3:
							codigoPostal.nombreMunicipio = row.getCell(indiceCelda)
						break;
						case 4:
							codigoPostal.nombreEstado = row.getCell(indiceCelda)
						break;
						case 5:
							codigoPostal.nombreCiudad = row.getCell(indiceCelda)
						break;
					}
				}
				listaCodigoPostal << codigoPostal
			}
		}catch(Exception e) {
			println("Error al abrir el archivo ${e.message}");
		}
		listaCodigoPostal
	}
	
}
