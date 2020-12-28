package com.alexsander.bankapi.services;

import com.alexsander.bankapi.entities.Person;

public interface PersonService {

    Person createPerson(Person person) throws Exception;
}
