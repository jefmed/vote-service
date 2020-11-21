# voting-service
Cada associado possui um voto e as decisões são tomadas em assembleias, por votação. A partir disso, você precisa criar uma solução para gerenciar essas sessões de votação.

## PRÉ-REQUISITOS

* Java 8
* Docker
* Maven

## INSTALAÇÃO
### Baixar imagem docker
```
docker pull postgres
```
### Executar o container
```
docker run -d -p 5432:5432 --name postgresdb -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=votedb postgres
```

## DOCUMENTAÇÃO
### SWAGGER
```
http://localhost:8080/swagger-ui.html
```

## Desenvolvido com:

* [Springboot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-documentation)
* [Lombok](https://projectlombok.org/features/all)
* [Hibernate](https://hibernate.org/orm/)
* [Maven](https://maven.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)
* [Swagger](https://swagger.io/docs/)
* [Openfeign](https://spring.io/projects/spring-cloud-openfeign)