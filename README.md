# Spring Event Listener

This project uses spring event listener to generate events after some business logic.
The idea of this project it's to understand a lit bit more about this awesome feature of Spring.

You can know more [here](https://www.baeldung.com/spring-events).

#  What was used?

- Spring / Spring Boot
- Thymeleaf
- H2 or Postgres
- Spring Mail

# How to run?

    mvn clean package
    
Using Postgres
         
    java -jar -Dspring.profiles.active=postgres event-listener-0.0.0.1.jar
    
Using H2

    java -jar -Dspring.profiles.active=h2 event-listener-0.0.0.1.jar
