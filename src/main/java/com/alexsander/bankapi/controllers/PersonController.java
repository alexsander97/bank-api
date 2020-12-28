package com.alexsander.bankapi.controllers;

import com.alexsander.bankapi.dtos.PersonDTO;
import com.alexsander.bankapi.entities.Person;
import com.alexsander.bankapi.response.ResponseApi;
import com.alexsander.bankapi.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @PostMapping
    public ResponseEntity<ResponseApi<PersonDTO>> createPerson(@RequestBody PersonDTO personRequest) {
        logger.info("Preparando para cadastrar uma pessoa.");
        ResponseApi<PersonDTO> response = new ResponseApi<>();
        List<String> errors = new ArrayList<>();

        try {
            Person entity = this.personService.createPerson(PersonDTO.convertToEntity(personRequest));
            response.setData(PersonDTO.convertToDto(entity));
            logger.info("Pessoa cadastrada com sucesso.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            errors.add(e.getMessage());
            response.setErrors(errors);
            return ResponseEntity.badRequest().body(response);
        }
    }

}

