# Projeto E-Diaristas

Projeto desenvolvido e atualizado durante a imersão Multi Stack da Treina Web utilizando Java e Spring Boot

## Dependências do Projeto

- Spring Boot
- Spring Web MVC
- Thymeleaf
- Spring Data JPA
- Bean Validation

## Dependências de Desenvolvimento

- Spring Boot Devtools
- Lombok

## Requisitos

- Java 17+ (Atualmente utilizo o openjdk 21 2023-09-19)
- Maven

## Como testar o projeto na sua máquina

Clone o repository e acesse a pasta do projeto.

```ssh
git clone git@github.com:jotahtsx/e-diaristas-spring.git
cd e-diaristas-spring
```

Atualize as configurações de acesso ao banco de dados no arquivo [application.properties](src/main/resources/application.properties)

```properties
spring.datasource.url=jdbc:mysql://host:porta/bancodedados?useTimezone=true&serverTimezone=America/Fortaleza
spring.datasource.username=usuario
spring.datasource.password=senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

Execute o projeto através do Maven.

```sh
mvn spring-boot:run
```

Acesse a aplicação em [http://localhost:8080/admin](http://localhost:8080/admin)