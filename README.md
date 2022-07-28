# 🚀 REST API Using Spring Boot
## Aim
- How to build REST APIs in Java with Spring Boot?
- How to bootstrap your application using https://start.spring.io and the New Project Wizard in IntelliJ?
- How to build basic CRUD REST API in Spring Boot?

## Requirements
For building and running the application you need:
- [JDK 18](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [Postman](https://www.postman.com/)
- [IntelliJ IDE](https://www.jetbrains.com/idea/)

## Plugins
- Live Templates : https://www.jetbrains.com/help/idea/using-live-templates.html
- Http Client : https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html
- Github Copilot : https://copilot.github.com/

## Running the application locally
- There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `ddev.danvega.streamsschedule` class from your IDE.
- Open a command line (or terminal) and navigate to the folder where you have the project files. We can build and run the application by issuing the following command:

MacOS/Linux : 
```sh
./mvnw spring-boot:run`=
```

Windows : 
```sh
mvnw spring-boot:run
```

## Getting started with Spring
- [Spring Quickstart Guide](https://spring.io/quickstart)

## All operations
### 📤 create data (POST http://localhost:8080/streams)
![image](https://user-images.githubusercontent.com/53792139/181505236-bf3687c6-324d-48c1-9994-6f0f6124242a.png)

### 📥 read data (GET http://localhost:8080/streams)
![image](https://user-images.githubusercontent.com/53792139/181505431-3d5312d3-aa01-4d0d-9117-41cf8e259dfa.png)

### 📥 read data by id (GET http://localhost:8080/streams/id={id})
![image](https://user-images.githubusercontent.com/53792139/181505357-e2751f5a-5b19-4256-a413-ded38906ce0d.png)

### 📤 update data by id (POST http://localhost:8080/streams/id={id})
![image](https://user-images.githubusercontent.com/53792139/181505137-3fe69cc6-673c-4968-b03e-0f66409fec4f.png)

### ❌ delete data by id (DEL http://localhost:8080/streams/id={id})
![image](https://user-images.githubusercontent.com/53792139/181505755-66b4f519-1178-4307-8c35-46d379f546f2.png)

# ✨ Thank You For Reading
