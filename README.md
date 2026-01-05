# AI Career Recommendation System

## 📌 Project Overview

The **AI Career Recommendation System** is a Spring Boot–based backend application that analyzes user skills, identifies skill gaps against job descriptions, and generates personalized learning roadmaps using **Hugging Face AI models**. The system follows clean layered architecture with Controllers, Services, Repositories, DTOs, Entities, and Global Exception Handling.

This project is ideal for demonstrating **Java Backend Development**, **REST API design**, **Spring Boot best practices**, and **AI integration**.

---

## 🧠 Key Features

* User authentication (Register / Login)
* Job description creation by recruiters
* Skill extraction using Hugging Face AI
* Skill gap analysis
* AI-generated learning roadmaps
* Job readiness scoring
* Global exception handling
* DTO-based request/response handling

---

## 🏗️ Project Architecture

```
com.demo
├── controller
├── service
│   ├── implementation
├── repository
├── entity
├── dto
│   ├── request
│   ├── response
├── exception
├── config
```

---

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Data JPA (Hibernate)**
* **REST APIs**
* **Hugging Face Inference API**
* **MySQL** 
* **Lombok**
* **WebClient (Reactive)**
* **Postman** (API testing)

---

## 🤖 AI Integration

* Uses **Hugging Face Inference API**
* Model: `google/flan-t5-large`
* Handles:

  * Skill extraction
  * Learning roadmap generation

AI calls are encapsulated inside `AiService` for loose coupling.

---

## 🔑 Environment Configuration

Add the following to `application.properties`:

```properties
huggingface.api.key=YOUR_HUGGINGFACE_API_KEY
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## 🚀 API Endpoints (Sample)

### Auth APIs

* `POST /api/auth/register`
* `POST /api/auth/login`

### Job APIs

* `POST /recruiter/add/job`

### Skill Analysis APIs

* `POST /api/analysis`

### Recommendation APIs

* `POST /api/recommendation`

---

## 📦 DTO Usage

* Ensures separation of API contracts from database entities
* Improves security and maintainability
* Enables clear request/response validation

---

## ⚠️ Global Exception Handling

* Centralized using `@ControllerAdvice`
* Handles:

  * Resource not found
  * Validation errors
  * AI service failures
  * Bad requests

---

## 🧪 Testing

* API testing done using **Postman**
* Hugging Face API can be tested independently
* Validation errors return proper HTTP status codes


---

## 👨‍💻 Author

**Madatha Ganesh**

---

## ⭐ Support

If you find this project helpful, please give it a ⭐ on GitHub!
