package com.br.pessoas.domain.entity;

public class EmailEntity {
	private Long id;
	private Long personId;
	private String email;

	public EmailEntity() {
	}

	public EmailEntity(Long id, Long personId, String email) {
        this.id = id;
        this.personId = personId;
        this.email = email;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "Email{" +
				"email='" + email + '\'' +
				", id=" + id +
				", personId=" + personId +
				'}';
	}
}
