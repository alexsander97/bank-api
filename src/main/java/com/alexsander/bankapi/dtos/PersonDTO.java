package com.alexsander.bankapi.dtos;

import com.alexsander.bankapi.entities.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.Email;
import java.util.Date;

public class PersonDTO {

    @Email
    private String email;

    @CPF
    private String cpf;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;


    public static Person convertToEntity(PersonDTO personDTO) {
        Person entity = new Person();
        entity.setBirthDate(personDTO.getBirthDate());
        entity.setCpf(personDTO.getCpf());
        entity.setEmail(personDTO.getEmail());
        entity.setName(personDTO.getName());
        return entity;
    }

    public static PersonDTO convertToDto(Person entity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setBirthDate(entity.getBirthDate());
        personDTO.setCpf(entity.getCpf());
        personDTO.setEmail(entity.getEmail());
        personDTO.setName(entity.getName());
        return personDTO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}