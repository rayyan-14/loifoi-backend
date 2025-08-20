# LOI-FOI Backend (Lost & Found Portal)

A Spring Boot based backend for a **Lost & Found web application**, designed to simplify the process of reporting, tracking, and recovering lost items.  

This project demonstrates **secure backend development** with authentication, data persistence, and scheduled maintenance: built with **Spring Boot, Spring Security, and MySQL**.

---

## Features

- **Item Submission**  
  Users can submit lost/found items with details and images (stored in Base64).  

- **Admin Dashboard**  
  Admins can view pending submissions, approve or reject items, and manage the item database.  

- **Secure Authentication**  
  Role-based access via Spring Security (admin endpoints protected).  

- **Auto-Cleanup**  
  Scheduled job automatically removes stale entries after 7 days (configurable).  

- **Timestamps**  
  All entries are auto-timestamped for better tracking and history.  

---

## Tech Stack

- **Backend:** Java, Spring Boot, Spring Data JPA, Spring Security  
- **Database:** MySQL  
- **Frontend (basic integration):** HTML + JavaScript (fetch API calls)  

---

## Getting Started

### Prerequisites
- Java 17+  
- Maven  
- MySQL  

### Setup
1. Clone the repository:  
   ```bash
   git clone https://github.com/rayyan-14/loifoi-backend.git
   ```
2. Configure database credentials in `application.properties`.  
3. Run the application:  
   ```bash
   mvn spring-boot:run
   ```
4. Access the backend at:  
   ```
   http://localhost:8081
   ```

---

## Example Endpoints

- `POST /items` → Submit new item  
- `GET /items/pending` → View pending items (admin only)  
- `PUT /items/{id}/approve` → Approve item (admin only)  
- `DELETE /items/{id}` → Delete item  

---

## Future Improvements

- JWT-based authentication  
- File storage (instead of Base64) for images  
- Containerization with Docker  
- Deployment to cloud (Heroku/AWS)  

---

## 👤 Author

**Rayyan Hanchanal**  
[GitHub](https://github.com/rayyan-14) | [LinkedIn](https://linkedin.com/in/rayyan-mh)  
