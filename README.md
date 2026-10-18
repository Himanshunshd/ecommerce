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

- Add new products.
- Retrieve all products.
- Search products by name.
- Search products by name and price.
- Update product prices using a DTO.
- Validate request data using Jakarta Bean Validation.
- Manage product categories.
- Store data in MySQL using Spring Data JPA.
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
| POST | `/products` | Add a product |
| GET | `/products` | Retrieve all products |
| GET | `/products/search/name?name=Laptop` | Search products by name |
| GET | `/products/search?name=Laptop&price=55000` | Search by name and price |
| PATCH | `/products/{id}` | Update product price, if this matches the implemented mapping |
| GET | `/categories` | Use only if this endpoint is implemented |

Check your controller mappings before adding or changing endpoint paths. Add the remaining category endpoints and product-by-ID endpoint when you confirm their exact mappings.

## ⚙️ Setup and Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Himanshunshd/ecommerce.git
   ```

2. Open the project in your IDE.

3. Create the MySQL database matching your datasource URL. For example, if your URL uses `e_commerce`:

   ```sql
   CREATE DATABASE e_commerce;
   ```

4. Configure your database URL, username, and password in `src/main/resources/application.properties`.

5. Run the application on Windows:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

6. Test the API endpoints using Postman.

## 🔐 Database Configuration

Use your own local database credentials. Never commit real passwords, API keys, or other secrets to GitHub.

For better security, store the database password in an environment variable and reference it from your application configuration.

## 📌 Future Improvements

- Retrieve a product by ID.
- Update complete product details.
- Delete products.
- Add pagination and sorting.
- Improve API documentation.
- Add automated tests.

Update this list as each feature is completed.

## 👨‍💻 Developer

**Himanshu Nishad**

GitHub: https://github.com/Himanshunshd

This project is part of my learning journey in Java Backend Development and Spring Boot.

