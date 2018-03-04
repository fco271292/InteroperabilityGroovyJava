package com.fco271292.InteroperabilityGroovyJava;

import com.fco271292.domain.Car;
import com.fco271292.domain.Person;
import com.fco271292.service.PopulateDomainGroovy;
import com.fco271292.service.PopulateDomainJava;

public class App {
	
    public static void main( String[] args ){
    	
    	Person p = new Person();
    	Car c = new Car();
    	PopulateDomainGroovy populateDomain = new PopulateDomainGroovy();
    	PopulateDomainJava populateDomainJava = new PopulateDomainJava();
        
    	System.out.println( "Se genera clase persona con groovy" );
        p = populateDomain.populatePerson(1, "FCO RYS");
        System.out.println("Persona. " + p.getId() + " " + p.getName());
        
        System.out.println( "Se genera clase carro con java" );
        c = populateDomainJava.populateCar(10, "Carro","Modelo",p);
        System.out.println("Carro. " + " "+ c.getId() + " " + c.getTrademark() + " " + c.getModel() + " " + c.getPerson());
        
    }
}
