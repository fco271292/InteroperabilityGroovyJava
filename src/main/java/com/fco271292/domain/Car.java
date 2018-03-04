package com.fco271292.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Car {
	
	Integer id;
	
	String trademark;
	
	String model;
	
}