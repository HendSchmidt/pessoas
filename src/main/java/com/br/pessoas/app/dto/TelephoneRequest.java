package com.br.pessoas.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelephoneRequest {
	private Long id;
	private Long personId;
	private String countryCode;
	private String stateCode;
	private String phoneNumber;
}
