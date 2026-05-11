[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Xshv1j8h)
# 🧪 Lab: Build a Robust CRUD API

## 🎯 Goal

Build a Spring Boot REST API for managing a resource (student) with a nested object (address).

👉 Your task is to **build and enhance the application** by:

Implementing:
- Simple CRUD for student (with nested address)

AND adding:
- Input validation
- Nested object validation
- Proper exception handling
- Structured error responses
- (Optional) Logging / ELK integration

---

# 🚨 IMPORTANT WORKFLOW REQUIREMENTS

## ✅ Commit & Push Rules (MANDATORY)

You MUST commit and push after completing each major step.

👉 Use the EXACT commit messages below.

Minimum required commits: **8**

---

## 🤖 AI Usage Rules

- **Limited usage of LLMs are allowed, but AGENTIC AI not allowed under any circumstances.**

---

# 🧩 TODO CHECKLIST (Follow in order)

## 🔹 Step 1 — Base CRUD

- [ ] Implement all CRUD endpoints
- [ ] Test all endpoints (Postman / Swagger)

📌 Commit:
```
feat: implement basic CRUD for student with address
```

---

## 🔹 Step 2 — Validation

- [ ] Add validation annotations to Student
- [ ] Add validation annotations to Address
- [ ] Enable nested validation

📌 Commit:
```
feat: add validation for student and nested address
```

---

## 🔹 Step 3 — Validation Error Handling

- [ ] Return 400 on validation failure
- [ ] Return meaningful messages
- [ ] Ensure default Spring errors are NOT returned

📌 Commit:
```
feat: handle validation errors with proper responses
```

---

## 🔹 Step 4 — Global Exception Handling

- [ ] Create @RestControllerAdvice
- [ ] Handle validation exceptions
- [ ] Handle generic exceptions

📌 Commit:
```
feat: implement global exception handling
```

---

## 🔹 Step 5 — Custom Exception

- [ ] Create StudentNotFoundException
- [ ] Throw it when student not found
- [ ] Return 404 response when it is thrown

📌 Commit:
```
feat: add custom exception for student not found
```

---

## 🔹 Step 6 — Error Response Standardization

- [ ] Implement consistent error response format
- [ ] Include timestamp, status, message, path, details

📌 Commit:
```
feat: standardize API error responses
```

---

## 🔹 Step 7 — Logging

- [ ] Add @Slf4j
- [ ] Log important operations
- [ ] Use appropriate levels (INFO, ERROR)

📌 Commit:
```
feat: add logging with slf4j
```

---

## 🔹 Step 8 — AOP

- [ ] Implement AOP for logging
- [ ] Log when a method enters (both in controller and service layers)
- [ ] Log when a method exits (successfully or exceptionally) (both in controller and service layers)
- [ ] For create requests (around service create method), get the time taken by the operation and log it

📌 Commit:
```
feat: implement AOP for logging
```

---

# ⭐ Optional Steps (Bonus)

## 🔹 ELK Integration (BONUS - 10%)

- [ ] Send logs to Logstash
- [ ] View logs in Kibana
- [ ] Demonstrate filtering logs

📌 Commit:
```
feat: integrate ELK stack for logging
```

---

## 🔹 Production Profile with PostgreSQL (BONUS - 10%)

- [ ] Create a `prod` profile configuration  
- [ ] Configure PostgreSQL connection in `application-prod.properties` (or `.yml`)  
- [ ] Keep H2 for default (dev) profile  
- [ ] Run the application using both profiles  
- [ ] Demonstrate switching between profiles  

### 📌 Example

Run with dev (default):
```
./gradlew bootRun
```

Run with prod:
```
./gradlew bootRun --args='--spring.profiles.active=prod'
```

or:

```
java -jar app.jar --spring.profiles.active=prod
```

### 📌 Commit

```
feat: add prod profile with postgres configuration
```

---

# 🎥 VIDEO RECORDING REQUIREMENT (MANDATORY)

You MUST record your development process.

## 🎬 What to record

- Coding process
- Using AI / LLM tools (if any)
- Testing API (Postman / browser)
- Running the application
- Demonstrating results
- Make sure you discuss what you are doing during the recording.

---


### 🎬 Video Requirement (Extension for Bonus)

In your recording, you MUST:
- Show the logs from Kibana
- Show application running with **H2 (dev profile)**
- Switch to **prod profile**
- Show application running with **PostgreSQL**
- Clearly demonstrate the difference

---
👉 *Bonus Tip:* explain why ELK stack can be used and what are the advantages of using it.

👉 *Bonus Tip:* briefly explain what profiles are and why they are useful (dev vs prod).

---

## ☁️ Upload Instructions

- Upload video to **Microsoft OneDrive**
- Enable **Auto Subtitles (Captions)**

👉 This is REQUIRED so the instructor can search for keywords during grading.

---

# 📚 Domain Model

### Student
- id
- fullName
- email
- age
- address

### Address
- id
- city
- street
- postalCode

---

# ⚙️ Base Functionality (Implement First)

- POST /students
- GET /students
- GET /students/{id}
- PUT /students/{id}
- DELETE /students/{id}

---

# ✅ Validation Requirements

### Student
- fullName → not blank, 2–50 characters
- email → valid format
- age → between 16 and 100

### Address
- city → not blank
- street → not blank
- postalCode → not blank, follows AZxxxx (e.g., AZ1001)

---

# ⚠️ Exception Handling

Handle:

- Validation errors → 400
- Not found → 404
- Generic errors → 500 (optional)

---

# 📦 Deliverables

- Working CRUD API
- Validation implemented
- Exception handling implemented
- Standard error responses
- Git commits (minimum 7)
- Video recording (with subtitles enabled)

---

# 🎓 Key Idea

👉 You are NOT JUST building CRUD.

👉 You are making your API **robust, safe, and production-ready**.

---

# 💡 One-line takeaway

A good API works.  
A robust API handles errors gracefully and communicates clearly.
