# E-Commerce Backend API

A backend project built using Java 21 and Spring Boot to develop REST APIs for an e-commerce application. The project follows a layered architecture and uses MySQL to store and manage product and category information.

## 🚀 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- Jakarta Bean Validation

## ✨ Features

- Add, retrieve, update, and delete products.
- Search products by name and by name and price.
- Update product prices using a DTO.
- Manage product categories.
- Validate request data using Jakarta Bean Validation.
- Perform database operations using Spring Data JPA.
- Handle API errors using exception handling.

## 📦 Product Information

Each product contains the following fields:

- `id` — Unique product identifier
- `name` — Product name
- `price` — Product price
- `quantity` — Available quantity
- `description` — Product description

## 🏗️ Project Architecture

The application follows a layered architecture:

```text
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
```

## 🔗 API Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/products` | Add a new product |
| GET | `/products` | Retrieve all products |
| GET | `/products/{id}` | Retrieve a product by ID |
| DELETE | `/products/{id}` | Delete a product by ID |
| GET | `/products/search/name?name=Laptop` | Search products by name |
| GET | `/products/search?name=Laptop&price=55000` | Search by name and price |
| PATCH | `/products/{id}` | Update product price |
| GET | `/categories` | Retrieve categories, if implemented |

Include any additional category endpoints using their actual controller mappings.

## ⚙️ Setup and Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Himanshunshd/ecommerce.git
   ```

2. Open the project in your preferred IDE.

3. Create the MySQL database matching your datasource URL. For example, if your URL uses `e_commerce`:

   ```sql
   CREATE DATABASE e_commerce;
   ```

4. Configure the database connection in `src/main/resources/application.properties` using your own credentials.

5. Run the application on Windows:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

6. Test the API endpoints using Postman.

## 🔐 Database Configuration

Use your own local database credentials. Never commit actual passwords, API keys, or other secrets to GitHub.

## 📌 Future Improvements

- Add pagination and sorting.
- Improve API documentation.
- Add automated tests.

These improvements can be updated as the project evolves.

## 👨‍💻 Developer

**Himanshu Nishad**

GitHub: https://github.com/Himanshunshd

This project is part of my learning journey in Java Backend Development and Spring Boot.
