package com.fco271292.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	
	Integer id;
	
	String trademark;
	
	String model;
	
	Person person;
	
}