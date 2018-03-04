package com.fco271292.service;

import com.fco271292.domain.Car;
import com.fco271292.domain.Person;

public class PopulateDomainJava {
	
	public Car populateCar() {
		Car car = new Car();
		return car;
	}
	
	public Car populateCar(Integer id, String trademark, String model,Person person) {
		Car car = new Car(id,trademark,model,person);
		return car;
	}
	
}
