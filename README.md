# RecipeFinder

RecipeFinder is a web-based application for providing cooking recipes. Users can request recipes based on categories, tags or keywords. The application leverages modern technologies for an efficient and interactive user experience.

## Technologies
- **Java** – Main programming language for backend logic
- **HTMX** – Enables interactive web applications without extensive JavaScript
- **Thymeleaf** – Template engine for server-side rendering
- **Spring Boot** – Framework for the backend and REST APIs
- **PostgreSQL** – Database for storing recipes
- **dotenv-java** – Used to load environment variables from a `.env` file

## Installation
### Prerequisites
- Java 17 or higher
- PostgreSQL database
- Maven

### Database Setup
Before starting the application, you need to set up a PostgreSQL database:
1. Install PostgreSQL if not already installed.
2. Create a new database:
   ```sql
   CREATE DATABASE recipefinder;
   ```
3. Create a database user and grant necessary permissions:
   ```sql
   CREATE USER your-username WITH ENCRYPTED PASSWORD 'your-password';
   GRANT ALL PRIVILEGES ON DATABASE recipefinder TO your-username;
   ```

### Installation Steps
1. **Clone the repository**
   ```bash
   git clone https://github.com/SantanaQ/RecipeFinder.git
   cd RecipeFinder
   ```
2. **Configure the database**
   Create a `.env` file in the project's root directory and add the database credentials:
   ```env
   DB_URL=jdbc:postgresql://localhost:5432/recipefinder
   DB_USERNAME=your-username
   DB_PASSWORD=your-password
   ```
3. **Install dependencies and start the application**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Planned Features
- Ability to add new recipes.
- User authentication and profile management.
- Save and manage favorite recipes.

## Usage
- Access the application in your browser: `http://localhost:8080`
- Browse recipes
