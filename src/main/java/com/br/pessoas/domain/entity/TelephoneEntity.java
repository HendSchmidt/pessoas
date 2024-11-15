package com.br.pessoas.domain.entity;

public class TelephoneEntity {
	private Long id;
	private Long personId;
	private String countryCode;
	private String stateCode;
	private String phoneNumber;
	private String description;

	public TelephoneEntity() {
	}

	public TelephoneEntity(String stateCode, String phoneNumber, Long personId, Long id, String countryCode, String description) {
		this.stateCode = stateCode;
		this.phoneNumber = phoneNumber;
		this.personId = personId;
		this.id = id;
		this.countryCode = countryCode;
		this.description = description;
	}

	public TelephoneEntity(String stateCode, String phoneNumber, Long id, String countryCode, String description) {
		this.stateCode = stateCode;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.countryCode = countryCode;
		this.description = description;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Telephone{" +
				"countryCode='" + countryCode + '\'' +
				", id=" + id +
				", personId=" + personId +
				", stateCode='" + stateCode + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				'}';
	}
}
