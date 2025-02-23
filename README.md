# RecipeFinder

RecipeFinder is a web-based application for providing cooking recipes. Users can browse, save, and manage recipes. The application leverages modern technologies for an efficient and interactive user experience.

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

### Installation Steps
1. **Clone the repository**
   ```bash
   git clone https://github.com/SatanaQ/RecipeFinder.git
   cd RecipeFinder
   ```
2. **Configure the database**
   Configure the `.env` file in the project's root directory and add the database credentials:
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

## Usage
- Access the application in your browser: `http://localhost:8080`
- Browse and save recipes
- Add and manage your own recipes


