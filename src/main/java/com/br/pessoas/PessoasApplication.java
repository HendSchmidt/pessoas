package com.br.pessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.br.pessoas.infra.dataProvider.repository")
@EnableCaching
public class PessoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoasApplication.class, args);
	}

}
