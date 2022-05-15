# spring-mongodb-demo

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [MongoDB](https://www.mongodb.com/)

## Running the application locally

1. Create `testdb` database in mongodb
2. Build the project using `mvn clean install`
3. Run using `mvn spring-boot:run`
4. Access the api(i.e. `http://localhost:8080/api/v1/students/`) 