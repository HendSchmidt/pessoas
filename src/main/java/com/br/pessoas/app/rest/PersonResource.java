package com.br.pessoas.app.rest;

import com.br.pessoas.app.dto.PersonRequest;
import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonResource {

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest request) {
        return ResponseEntity.ok(service.createPerson(request));
    }

    @GetMapping
    public ResponseEntity<String> getAllPerson(){
        return ResponseEntity.ok("service.getAllPerson()");
    }
}
