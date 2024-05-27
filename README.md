# Spring [CQRS](https://martinfowler.com/bliki/CQRS.html) pattern

Two simple APIs to study about CQRS(Command–query separation) pattern with Spring boot


### Used Technologies

* [Java](https://www.java.com/)
* [Docker](https://www.docker.com/)
* [PostgreSQL](https://www.postgresql.org/)
* [Kafka](https://kafka.apache.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)

## Dependencies and versions

* Docker - Version: 26.1.1 or higher
* Java(JDK) - Version: 17 or higher

### Getting started

First you need to run Postgres and Kafka with Docker:

```
docker compose up -d
```

after that run both applications with:

```shell
./mvnw spring-boot:run
```

and you will test on [localhost:8080](http://localhost:8080) and [localhost:8081](http://localhost:8081)


## Rest Endpoints

### Command app (port: 8081)

**Create product**

```POST``` /product
```json
{
  "type": "CreateProduct",
  "product": {
    "name": "keybooard",
    "description": "k500",
    "price": 63.63
  }
}
```

**Update product**

```PUT``` /product/{id}
```json
{
  "type": "UpdateProduct",
  "product": {
    "name": "keybooard",
    "description": "k500",
    "price": 63.63
  }
}
```


### Query app (port: 8080)

**Get all products**

```GET``` /product


**Get by id**

```GET``` /product{id}



