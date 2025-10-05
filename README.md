# [ On-going ] - Personal Finance Tracker Backend-API

A **full-stack web application** to help users manage their personal finances.
The app allows users to **track income and expenses, view reports, and generate insights** on spending habits.

Built with **Spring Boot (backend)**, **React (frontend)**, **PostgreSQL (database)**, and **JWT authentication** for secure access.

---

## Tech Stack

* **Backend:** Spring Boot, Spring Data JPA, Spring Security (JWT)
* **Frontend:** React (Vite), React Router
* **Database:** PostgreSQL
* **Authentication:** JWT (JSON Web Token)
* **Deployment:** TBD

---

## Project Structure

```
personal-finance-tracker/
│
├── TBA
```

---

## Getting Started

### 1. Backend

```bash
./mvnw spring-boot:run
```

Server runs at: `http://localhost:8585`


### 3. Database

```bash
docker compose up
```

---

## Example API

### Register User

```http
POST /api/auth/signup
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "securePass123"
}
```

### Login

```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "john_doe",
  "password": "securePass123"
}
```

Response:

```json
{
  "token": "...."
}
```

---

## TODO

* [ ] 

---

## License

This project is open-source under the MIT License.
