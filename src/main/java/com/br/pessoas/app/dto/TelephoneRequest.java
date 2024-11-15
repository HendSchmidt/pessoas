package com.br.pessoas.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelephoneRequest {
	private Long id;
	private String countryCode;
	private String stateCode;
	private String phoneNumber;
	private String description;
}
