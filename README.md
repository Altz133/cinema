# Project Cinema

Project cinema is a simple exercise intedened to increase my skills in Java web development. The main idea is to create a functional web application to manage cinema workflow. With support of Spring Boot application is responsible for CRUD operations on database. Project is under active development.

### The main features:

* Adding/removing/editing user 
* Adding/removing/editing cinema repertoire
* Adding/removing/editing new movies
* Adding/removing/editing screenings
* Purchasing tickets for a movie 
* Screening seat management
* User session
* Role based access control based on role hierarchy
* Admin control panel

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

# Some of implemented features

 ### List of currenlty registered users
![users](/src/main/resources/readme/listOfUsers.png)

 ### Cinema repertoire for admin
![repertoire](/src/main/resources/readme/repertoire.png)

  ### Cinema repertoire for guest
![repertoireA](/src/main/resources/readme/repertoireAnonymous.png)
 
 ### List of ticket assigned to logged account
![tickets](/src/main/resources/readme/MyTickets.png)

### Registering a privileged user (admin or manager role only)
![regPri](/src/main/resources/readme/registerPrivileged.png)

### Planing a new screening 
![newScreening](/src/main/resources/readme/NewScreening.png)
 
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
cd cinema
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

