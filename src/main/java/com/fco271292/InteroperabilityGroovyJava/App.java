package com.fco271292.InteroperabilityGroovyJava;

import java.io.File;

import com.fco271292.service.Operaciones;

public class App {
	
    public static void main( String[] args ){
    	
    	Operaciones operaciones = new Operaciones();
        String rutaArchivoExcel = "C:\\Users\\Gigabyte\\Downloads\\SEPOMEX.xlsx";
        
        ClassLoader classLoader = App.class.getClassLoader();
        try {
        	System.out.println( "Inicio..." );
        	File excel = new File(classLoader.getResource("SEPOMEX.xlsx").getFile());
            operaciones.mostrarMenu(excel.getAbsolutePath());
            System.out.println( "Termino..." );
        }catch(Exception e) {
        	System.out.println("Error al cargar Excel "+e.getMessage());
        }
    	
    }
}
