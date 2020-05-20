package com.fco271292.InteroperabilityGroovyJava;

import java.io.File;

import com.fco271292.service.Operaciones;

public class App {
	
    public static void main( String[] args ){
    	
    	Operaciones operaciones = new Operaciones();
        String rutaArchivoExcel = "/var/documentos/SEPOMEX.xlsx";
//        ClassLoader classLoader = App.class.getClassLoader();
        try {
        	File excel = new File(rutaArchivoExcel);
            operaciones.mostrarMenu(excel.getAbsolutePath());
        } catch(Exception e) {
        	System.out.println("Error al cargar Excel "+e.getMessage());
        }
    	
    }
}
