package com.br.pessoas.app.dto;

public record ErrorResponse( Integer statusCode,
		 String message,
		 Object stackTrace) {
}
