package com.br.pessoas.domain.entity;

public class EmailEntity {
	private Long id;
	private Long personId;
	private String email;
	private String description;

	public EmailEntity() {
	}

	public EmailEntity(Long id, Long personId, String email, String description) {
        this.id = id;
        this.personId = personId;
        this.email = email;
		this.description = description;
    }

	public EmailEntity(Long id, String email,  String description) {
		this.id = id;
		this.email = email;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
