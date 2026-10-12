E-commerce Backend API

A backend project built using Java and Spring Boot to develop REST APIs for an e-commerce application. The project follows a layered architecture and uses MySQL to store product information.

🚀 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- Jakarta Bean Validation

✨ Features

- Add new products through a REST API.
- Store product information in a MySQL database.
- Validate product fields using Jakarta Bean Validation.
- Use Spring Data JPA for database operations.
- Test API endpoints using Postman.

📦 Product Information

Each product contains the following fields:

- "id" — Unique product identifier
- "name" — Product name
- "price" — Product price
- "quantity" — Available quantity
- "description" — Product description

🏗️ Project Architecture

The project follows a layered architecture:

Client (Postman)
       |
       v
Controller
       |
       v
Service
       |
       v
Repository
       |
       v
MySQL Database

🔗 API Endpoints

Add Product

Endpoint: "POST /products"

Request Body:

{
  "name": "Laptop",
  "price": 55000.00,
  "quantity": 5,
  "description": "Laptop for daily use"
}

Success Response:

Product Added Successfully.

The API saves product information to the MySQL database.

⚙️ Setup and Installation

1. Clone this repository:
   
   git clone https://github.com/Himanshunshd/ecommerce.git

2. Open the project in your preferred IDE.

3. Create a MySQL database:
   
   CREATE DATABASE ecommerce;

4. Configure your database connection in "src/main/resources/application.properties".

5. Run the application using Maven:
   
   ./mvnw spring-boot:run
   
   On Windows, use:
   
   .\mvnw.cmd spring-boot:run

6. Test the API using Postman.

🔐 Database Configuration

Configure the following properties in "application.properties" using your own database credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

Important: Never commit your actual database password or other secrets to GitHub.

📌 Future Improvements

- Retrieve all products
- Retrieve a product by ID
- Update product details
- Delete products
- Improve API error handling
- Add pagination and sorting
- Implement product categories and search

👨‍💻 Developer

Himanshu Nishad

GitHub: "Himanshunshd" (https://github.com/Himanshunshd)

This project is being developed as part of my learning journey in Java Backend Development and Spring Boot.
