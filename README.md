# Spring boot templates

This repository is my box of ready to use spring boot templates

# Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

# Prerequisites

What things you need to install the software and how to install them

# Workspace

- java 1.8
- maven

# Build and Run

After cloning repository, choose one example and go to its directory, for example:

```
cd 001-no-database
```

After that, just run :

```
mvn clean package spring-boot:run
```

Skip Tests with :

```
mvn clean package -DskipTests=true
```

If no errors, api is ready to use or test.

# Enpoints

## 00-hello-world

```
curl http://localhost:8080/

curl http://localhost:8080/customers
```

Tested in ![heroku](https://raw.githubusercontent.com/jrichardsz/static_resources/master/heroku.png)

## 001-no-database

```
curl http://localhost:8080/

curl http://localhost:8080/customers
```

Tested in ![heroku](https://raw.githubusercontent.com/jrichardsz/static_resources/master/heroku.png)

## 002-hql-database

```
curl http://localhost:8080/

curl http://localhost:8080/customer

curl -X POST -H "Content-Type: application/json" --data '{"id":"100","firstName":"John","lastName":"Wick"}'   http://localhost:8080/customer

curl -X POST -H "Content-Type: application/json" --data '{"id":"101","firstName":"John","lastName":"Rambo"}'   http://localhost:8080/customer

```

Tested in ![heroku](https://raw.githubusercontent.com/jrichardsz/static_resources/master/heroku.png)

## 003-hql-database-with-integration-test

# Versioning

1.0.0

# License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

# Authors

* **Richard Leon Ingaruca** - *Initial work* - [JRichardsz](https://github.com/jrichardsz)
