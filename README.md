## Description of the solution
- The solution is based on the Spring Boot framework, using the following technologies:
  - Spring Boot
  - Spring Data JPA
  - Spring Web
  - Spring Test

- It follows the principles of Clean Code and SOLID, taking advantage of the :
  - Dependency Injection
  - Use of lombok to avoid boilerplate code
  - Use of the Builder pattern to create objects
  - Use of the Repository pattern to access the database
  - Use of the Service pattern to implement the business logic
  - Use of the Controller pattern to expose the endpoints
  - Use of the DTO pattern to transfer data between layers
  - Use of the Mapper pattern to map the DTOs to the entities and vice versa
    


## Use
- Execute the project with the command: `mvn spring-boot:run`
- Execute the tests with the command: `mvn test`
- There is a Postman Collection available to test the endpoints


## Credits
- Javier Alvarez

## Extras
- Collecion Postman: Directorio extra/Postman
- Analisis Sonar: https://sonarcloud.io/summary/overall?id=jalvarez2000_prueba
- Consola H2: http://localhost:8080/h2-console (usuario:sa, password:)

## License
[MIT] © [Javier Alvarez]
