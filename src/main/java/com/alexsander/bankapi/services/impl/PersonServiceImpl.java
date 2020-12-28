package com.alexsander.bankapi.services.impl;


import com.alexsander.bankapi.entities.Person;
import com.alexsander.bankapi.repositories.PersonRepository;
import com.alexsander.bankapi.services.PersonService;
import com.alexsander.bankapi.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public Person createPerson(Person person) throws Exception {
        this.validateCpf(person.getCpf());
        this.validateEmail(person.getEmail());
        return this.personRepository.save(person);
    }

    private void validateCpf(String cpf) throws Exception {
        if (!ValidatorUtils.isValidCpf(cpf)) {
            throw new Exception("Este cpf não é valido.");
        } else {
            Optional<Person> personByCpf = this.personRepository.findByCpf(cpf);
            if (personByCpf.isPresent()) {
                throw new Exception("Já existe este cpf cadastrado.");
            }
        }
    }

    private void validateEmail(String email) throws Exception {
        if (!ValidatorUtils.isValidEmailAddress(email)) {
            throw new Exception("Este email não é valido.");
        } else {
            Optional<Person> personByEmail = this.personRepository.findByEmail(email);
            if (personByEmail.isPresent()) {
                throw new Exception("Já existe este email cadastrado.");
            }
        }
    }


}
