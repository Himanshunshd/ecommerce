# E-Commerce Backend API

A backend project built using Java 21 and Spring Boot to develop REST APIs for an e-commerce application. The project follows a layered architecture and uses MySQL to manage product and category information.

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

- Add and retrieve products.
- Search products by name and by name and price.
- Update product prices using DTOs.
- Delete products.
- Manage product categories.
- Validate request data using Jakarta Bean Validation.
- Handle API errors using exception handling.
- Store and retrieve data using MySQL and Spring Data JPA.

## 📦 Product Information

Each product contains:

- `id` — Unique product identifier
- `name` — Product name
- `price` — Product price
- `quantity` — Available quantity
- `description` — Product description

## 🗂️ Category Management

The application includes category management APIs to organize products into categories.

Category operations are implemented using Spring Boot's layered architecture and Spring Data JPA.

## 🏗️ Project Architecture

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
| POST | `/products` | Add a product |
| GET | `/products` | Retrieve all products |
| GET | `/products/search/name?name=Laptop` | Search products by name |
| GET | `/products/search?name=Laptop&price=55000` | Search by name and price |
| PATCH | `/products/{id}` | Update product price |
| DELETE | `/products/{id}` | Delete a product |
| GET | `/categories` | Retrieve categories |

Ensure the table matches your actual controller mappings. Add other implemented endpoints, including product-by-ID and category update endpoints, if applicable.

## ⚙️ Setup and Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Himanshunshd/ecommerce.git
   ```

2. Open the project in your IDE.

3. Create the MySQL database matching your datasource URL. For example:

   ```sql
   CREATE DATABASE e_commerce;
   ```

4. Configure your database connection in `src/main/resources/application.properties` using your own credentials.

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

## 👨‍💻 Developer

**Himanshu Nishad**

GitHub: https://github.com/Himanshunshd

This project is part of my learning journey in Java Backend Development and Spring Boot.
