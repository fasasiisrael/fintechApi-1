# Fintech API

This repository contains two implementations of a Financial API:

1. **Java/Spring Boot** implementation in `fintech-java-api`
2. **Node.js/Express** implementation in `fintech-api-nodejs`

---

## Java API

Location: `fintech-java-api`

Requirements:
- Java 8 or later
- Maven 3.x

Build and run:
```bash
cd fintech-java-api
mvn clean package
java -jar target/financial-api-java-1.0.0.jar
```

The application will start on port **8080**. Available endpoints:

### POST /transactions/deposit
Deposit funds into an account.
- Content-Type: `application/json`
- Request body:
  ```json
  {
    "sourceAccount": "string",
    "targetAccount": "string",
    "amount": 100.0
  }
  ```
- Responses:
  - `200 OK` – "Deposit successful"
  - `400 Bad Request` – invalid payload

### POST /transactions/withdraw
Withdraw funds from an account.
- Request body:
  ```json
  {
    "sourceAccount": "string",
    "amount": 50.0
  }
  ```
- Responses:
  - `200 OK` – "Withdrawal successful"
  - `400 Bad Request`

### POST /transactions/transfer
Transfer funds between accounts.
- Request body:
  ```json
  {
    "sourceAccount": "string",
    "targetAccount": "string",
    "amount": 25.0
  }
  ```
- Responses:
  - `200 OK` – "Transfer successful"
  - `400 Bad Request`

---

## Node.js API

Location: `fintech-api-nodejs`

Requirements:
- Node.js 14 or later
- npm

Install and run:
```bash
cd fintech-api-nodejs
npm install
npm start
```

The server runs on port **3000**. Swagger UI is available at:

```
http://localhost:3000/api-docs
```

### Authentication
All endpoints require a Bearer JWT in the `Authorization` header.
Use the shared secret:
```
8a*17Z#PqWgF3$xT9vHc
```

Example header:
```
Authorization: Bearer <your_jwt_token>
```

### POST /transactions/deposit
Deposit funds. Same JSON shape as Java API.

### POST /transactions/withdraw
Withdraw funds.

### POST /transactions/transfer
Transfer funds.

Each endpoint returns `200 OK` with a plain-text confirmation message on success.

---

Feel free to open issues or contribute improvements!