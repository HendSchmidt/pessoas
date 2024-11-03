package com.br.pessoas.app.rest;

import com.br.pessoas.app.dto.PersonRequest;
import com.br.pessoas.app.dto.PersonResponse;
import com.br.pessoas.app.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonResourceTest {

	@Mock
	private PersonService service;

	@InjectMocks
	private PersonResource resource;


	private PersonRequest request;
	private PersonResponse personResponse;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		request = new PersonRequest();
		request.setId(1L);
		request.setNome("John");
		request.setSobrenome("Doe");
		request.setCpf("123.456.789-00");
		request.setIdade(30);


		personResponse = new PersonResponse();
		personResponse.setId(1L);
		personResponse.setNome("John");
		personResponse.setSobrenome("Doe");
		personResponse.setCpf("123.456.789-00");
		personResponse.setIdade(30);

	}

	@Test
	public void shouldReturnPersonResponseWhenCreatingPersonWithValidInput() {
		Mockito.when(service.createPerson(request)).thenReturn(personResponse);
    	ResponseEntity<PersonResponse> response = resource.createPerson(request);

   	 	assertEquals(HttpStatus.OK, response.getStatusCode());
    	assertEquals(personResponse, response.getBody());
		Mockito.verify(service, Mockito.times(1)).createPerson(request);
	}
}
