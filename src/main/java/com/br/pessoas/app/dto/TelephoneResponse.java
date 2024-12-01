package com.br.pessoas.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(content = JsonInclude.Include.NON_NULL, value = JsonInclude.Include.NON_EMPTY)
public class TelephoneResponse {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("personId")
	private Long personId;
	@JsonProperty("countryCode")
	private String countryCode;
	@JsonProperty("stateCode")
	private String stateCode;
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	@JsonProperty("description")
	private String description;
}
