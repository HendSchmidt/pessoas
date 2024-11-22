package com.br.pessoas.infra.dataProvider.repository.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel extends AbstractPersistable<Long> {
	private Long personId;
	private String email;
	private String description;
}
