# Project Cinema

Project cinema is a simple exercise intedent to increase my skills in java web developmnet. The main idea is to create a functional web application to manage cinema workflow. With support of Spring Boot framework app responsible for makign basic CRUD operations.
### The main features to implement:
* Adding/removing/editing user 
* Adding/removing/editing cinema repertoire
* Adding/removing/editing new movies
* Adding/removing/editing screenings
* Purchasing tickets for a movie 
* Cinama Hall seat managament
* User session
* Role based access control based on role hierarchy

# Technologies

* Spring Boot Web
* Spring Security
* Thymeleaf
* Spring Data JPA
* Hibernate
* PostgreSQL
* Spring JDBC
* Lombok
* Boostrap

# ERD of PostgreSQL database

![ERD](/src/main/resources/readme/erd2.png)

# Views of some implemented features
 ### List of currenlty registered users
 ![users](/src/main/resources/readme/listOfUsers.png)


 ### Cinema repertoire
 ![repertoire](/src/main/resources/readme/repertoire.png)
 
 ### List of users purchased tickets
 ![tickets](/src/main/resources/readme/MyTickets.png)
 
 
 ### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- Git

### Clone the Repository

Clone the repository to your local machine using the following command:
```
git clone https://github.com/Altz133/cinema.git
```
### Build the Project

Navigate to the project directory and build the application using Maven:
```
cd repository-name
mvn clean install
```

### Run the Application

To run the application, use the following command:
```
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

### Access the Application

Open your web browser and access the application at `http://localhost:8080`.

