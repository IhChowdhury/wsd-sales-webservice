<h1 align="center">Sales Service</h1>


## Description
A Sales webservice for sales api.

## Requirements

For building and running the application:
- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.wsdtest.salesservice.SalesServiceApplication` class from your IDE.

or,
```shell
mvn spring-boot:run
```
## To build application
```shell
mvn 
```

## To create Docker image
- First create an executable jar
- Then run the following command to target directory

```shell
docker build -t wsd-sales-webservice:latest .
```

To run docker image
```shell
docker run -p 8080:8080 -t  wsd-sales-webservice
```

## Supported URL
- [Api documentation](http://localhost:8080/api-doc)
- [H2 Console](http://localhost:8080/h2-console/)
