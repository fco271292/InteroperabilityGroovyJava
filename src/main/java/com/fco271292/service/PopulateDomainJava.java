package com.fco271292.service;

import com.fco271292.domain.Car;

public class PopulateDomainJava {
	
	public Car populateCar() {
		Car car = new Car();
		return car;
	}
	
	public Car populateCar(Integer id, String trademark) {
		Car car = new Car(id,trademark,null);
		return car;
	}
	
}
