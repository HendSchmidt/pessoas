package com.br.pessoas.app.rest;

import com.br.pessoas.app.dto.*;
import com.br.pessoas.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonResource {

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponse>> findAllPerson(){
        return ResponseEntity.ok(service.findAllPerson());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PersonResponse> findByCpf(@PathVariable String cpf){
        return ResponseEntity.ok(service.findByCpf(cpf));
    }

    @PostMapping("/{personId}/address")
    public ResponseEntity<AddressResponse> createPersonAddress(@PathVariable Long personId, @RequestBody AddressRequest request) {
        return ResponseEntity.ok(service.createAddress(personId, request));
    }

    @PostMapping("/{personId}/telephone")
    public ResponseEntity<TelephoneResponse> createPersonTelephone(@PathVariable Long personId, @RequestBody TelephoneRequest request) {
        return ResponseEntity.ok(service.createTelephone(personId, request));
    }

    @PostMapping("/{personId}/email")
    public ResponseEntity<EmailResponse> createPersonEmail(@PathVariable Long personId, @RequestBody EmailRequest request) {
        return ResponseEntity.ok(service.createEmail(personId, request));
    }
}
