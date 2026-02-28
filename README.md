# Online Corona Consultation System

A Spring Boot REST API backend for managing an online corona consultation system, including patients, doctors, departments, medicines, wards, rooms, and more.

## Tech Stack

- **Java 17** (LTS)
- **Spring Boot 3.4.3**
- **Spring Data JPA** (Jakarta Persistence)
- **Spring Validation** (Jakarta Validation)
- **PostgreSQL** (runtime driver managed by Spring Boot BOM)
- **Lombok**
- **SpringDoc OpenAPI 2.8.4** (Swagger UI)

## Prerequisites

- Java 17 or later
- PostgreSQL (running locally on port 5432)
- Gradle 8.x (or use the included `./gradlew` wrapper)

## Database Setup

Create a PostgreSQL database named `CoronaConsultationProject`:

```sql
CREATE DATABASE "CoronaConsultationProject";
```

The default credentials configured in `application.properties` are:
- **URL**: `jdbc:postgresql://localhost:5432/CoronaConsultationProject`
- **Username**: `postgres`
- **Password**: `postgres-d postgres` *(update this to your actual PostgreSQL password)*

Edit `src/main/resources/application.properties` to match your local setup.

## Build & Run

```bash
# Build the project
./gradlew build

# Run the application
./gradlew bootRun
```

The application starts on `http://localhost:8080` by default.

## API Documentation

Once running, the Swagger UI is available at:

```
http://localhost:8080/swagger-ui.html
```

The OpenAPI JSON spec is at:

```
http://localhost:8080/v3/api-docs
```

## Running Tests

```bash
./gradlew test
```
