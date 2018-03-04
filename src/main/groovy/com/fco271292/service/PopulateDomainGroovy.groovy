package com.fco271292.service

import com.fco271292.domain.Person

class PopulateDomainGroovy {
	
	Person populatePerson() {
		Person person = new Person()
	}
	
	Person populatePerson(Integer id, String name) {
		Person person = new Person(id: id, name: name)
	}
}
