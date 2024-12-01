# Pessoas 

Um microserviço simples, para cadastrar pessoas.

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

### 📋 Pré-requisitos

De que coisas você precisa para instalar o software e como instalá-lo?

```
Ide de sua preferencia.
Congigurar o arquivo properties.
Java acima da versão 21.
Maven 3.9.9 .
Docker.
Redis redis/redis-stack-server.
Redis cli (Opcional)
```

### 🔧 Instalação

- Clonar o projeto.
- Criar e rodar uma imagem do redis/redis-stack-server no docker
- Configurar o arquivo properties.
- Exemplo:
````
  spring.application.name=
  server.port=
  spring.datasource.url=jdbc:h2:mem:master
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=
  spring.datasource.password=
  spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
  spring.jpa.show-sql: 
  spring.jpa.hibernate.ddl-auto=
  management.endpoints.web.exposure.include=
  
  #Swaggr opn api
  springdoc.api-docs.enabled=true
  springdoc.swagger-ui.path=/swagger-ui.html

  #Redis
  spring.cache.host=localhost
  spring.cache.port=6379
  spring.cache.type=redis
````

## ✒️ Autores
* **Hendrix Schmidt** - *Trabalho Inicial* 
