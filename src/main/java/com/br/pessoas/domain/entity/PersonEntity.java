package com.br.pessoas.domain.entity;

public class PersonEntity {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Integer idade;

    public PersonEntity() {
    }

    public PersonEntity(Long id, String nome, String sobrenome, String cpf, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;
        return getCpf().equals(that.getCpf());
    }

    @Override
    public int hashCode() {
        return getCpf().hashCode();
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                '}';
    }
}
