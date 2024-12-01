package com.br.pessoas.app.rest;

import com.br.pessoas.app.dto.*;
import com.br.pessoas.app.service.PersonService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/person")
@OpenAPIDefinition(info = @Info(title = "Pessoas API", description = "Api para gerenciamento de pessoas."))
public class PersonResource {

	@Autowired
	private PersonService service;

	@Operation(summary = "Dado um objeto request cria uma pessoa.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Indica sucesso na criação da pessoa.",
					content = @Content(schema = @Schema(implementation = PersonResponse.class))),
			@ApiResponse(responseCode = "400", description = "Indica que os dados enviados não estão de acordo com o esperado.",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Indica que ocorreu um erro interno na API.")})
	@PostMapping
	public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest request) {
		return ResponseEntity.ok(service.create(request));
	}

	@Operation(summary = "Dado um objeto request atualiza uma pessoa.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Indica sucesso na atualização da pessoa.",
					content = @Content(schema = @Schema(implementation = PersonResponse.class))),
			@ApiResponse(responseCode = "400", description = "Indica que os dados enviados não estão de acordo com o esperado.",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Indica que ocorreu um erro interno na API.")})
	@PutMapping("/{cpf}")
	public ResponseEntity<PersonResponse> updatePerson(@PathVariable String cpf, @RequestBody PersonRequest request) {
		return ResponseEntity.ok(service.updatePerson(cpf, request));
	}

	@Operation(summary = "Dado um cpf deleta a pessoa correspondente e todos seus complementos.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Indica sucesso na exclusão da pessoa e seus complementos.",
					content = @Content(schema = @Schema(implementation = PersonResponse.class))),
			@ApiResponse(responseCode = "400", description = "Indica que os dados enviados não estão de acordo com o esperado.",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Indica que ocorreu um erro interno na API.")})
	@DeleteMapping("/{cpf}")
	public ResponseEntity<String> deletePerson(@PathVariable String cpf) {
		return ResponseEntity.ok(service.deletePerson(cpf));
	}

	@Operation(summary = "Retorna uma lista de todas pessoas existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Indica sucesso na listagem da pessoa.",
					content = @Content(schema = @Schema(implementation = PersonResponse.class))),
			@ApiResponse(responseCode = "400", description = "Indica que os dados enviados não estão de acordo com o esperado.",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Indica que ocorreu um erro interno na API.")})
	@GetMapping
	public ResponseEntity<List<PersonResponse>> findAllPerson() {
		return ResponseEntity.ok(service.findAllPerson());
	}

	@Operation(summary = "Dado um cpf retorna a pessoa correspondente.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Indica sucesso na criação da pessoa.",
					content = @Content(schema = @Schema(implementation = PersonResponse.class))),
			@ApiResponse(responseCode = "400", description = "Indica que os dados enviados não estão de acordo com o esperado.",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Indica que ocorreu um erro interno na API.")})
	@GetMapping("/{cpf}")
	public ResponseEntity<PersonResponse> findByCpf(@PathVariable String cpf) {
		return ResponseEntity.ok(service.findByCpf(cpf));
	}

	@Operation(summary = "Dado o identificador da pessoa e um objeto de request cria um endereço para pessoa correspondente.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Indica sucesso na criação do endereço.",
					content = @Content(schema = @Schema(implementation = AddressResponse.class))),
			@ApiResponse(responseCode = "400", description = "Indica que os dados enviados não estão de acordo com o esperado.",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Indica que ocorreu um erro interno na API.")})
	@PostMapping("/{personId}/address")
	public ResponseEntity<AddressResponse> createPersonAddress(@PathVariable Long personId, @RequestBody AddressRequest request) {
		return ResponseEntity.ok(service.createAddress(personId, request));
	}

	@Operation(summary = "Dado o identificador da pessoa e um objeto de request cria um telefone para pessoa correspondente.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Indica sucesso na criação do telefone.",
					content = @Content(schema = @Schema(implementation = TelephoneResponse.class))),
			@ApiResponse(responseCode = "400", description = "Indica que os dados enviados não estão de acordo com o esperado.",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Indica que ocorreu um erro interno na API.")})
	@PostMapping("/{personId}/telephone")
	public ResponseEntity<TelephoneResponse> createPersonTelephone(@PathVariable Long personId, @RequestBody TelephoneRequest request) {
		return ResponseEntity.ok(service.createTelephone(personId, request));
	}

	@Operation(summary = "Dado o identificador da pessoa e um objeto de request cria um email para pessoa correspondente.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Indica sucesso na criação do email.",
					content = @Content(schema = @Schema(implementation = EmailResponse.class))),
			@ApiResponse(responseCode = "400", description = "Indica que os dados enviados não estão de acordo com o esperado.",
					content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Indica que ocorreu um erro interno na API.")})
	@PostMapping("/{personId}/email")
	public ResponseEntity<EmailResponse> createPersonEmail(@PathVariable Long personId, @RequestBody EmailRequest request) {
		return ResponseEntity.ok(service.createEmail(personId, request));
	}
}
