# Environmental Data Management API

This project provides an API for uploading and managing environmental data files in CSV and TXT formats. The API includes endpoints for file uploads and retrieving stored data.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

Follow these instructions to set up and run the project on your local machine.

### Prerequisites

- Java 11 or later
- Maven 3.6 or later
- PostgreSQL or any other preferred database

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/environmental-data-management.git
   cd environmental-data-management
   ```

2. Configure the database connection in `src/main/resources/application.yml`:
   ```properties
   spring:
    datasource:
        url: jdbc:postgresql://localhost:5432/your-database
        driverClassName: org.h2.Driver
        username: your-username
        password: your-password
    h2:
        console:
            enabled: true
    jpa:
        hibernate:
            ddl-auto: update
        show-sql: true
    server:
        port: 8080

   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

### Running the Application

Start the application using Maven:
```bash
mvn spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## API Endpoints

### Upload File

- **URL:** `/api/upload`
- **Method:** `POST`
- **Description:** Uploads a CSV or TXT file containing environmental data.
- **Request:**
    - **Parameter:** `file` (MultipartFile)
    - **Example:**
      ```bash
      curl -F 'file=@path/to/yourfile.csv' http://localhost:8080/api/upload
      ```
- **Response:**
    - **Success:** `{"message": "File uploaded successfully"}`
    - **Error:** `{"message": "Failed to upload file: error details"}`

### Retrieve All Data

- **URL:** `/api/data`
- **Method:** `GET`
- **Description:** Retrieves all environmental data records.
- **Response:**
  ```json
  [
    {
      "id": 1,
      "dynamicDataJson": "{...}"
    },
    "..."
  ]
  ```

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── enviro
│   │           └── assessment
│   │               └── grad001
│   │                   └── thamsanqandaba
│   │                       ├── config
│   │                       │   └── SwaggerConfig.java
│   │                       ├── controller
│   │                       │   └── FileController.java
│   │                       ├── dto
│   │                       │   └── FileResponse.java
│   │                       ├── exception
│   │                       │   └── ApiException.java
│   │                       ├── logging
│   │                       │   └── RequestResponseLogger.java
│   │                       ├── model
│   │                       │   └── EnvironmentalData.java
│   │                       ├── repository
│   │                       │   └── EnvironmentalDataRepository.java
│   │                       └── service
│   │                           └── EnvironmentalDataService.java
│   └── resources
│       ├── data
│       │   ├── data.txt
│       │   └── environmental-protection-expenditure-account-2009-2022.csv   
│       └── application.properties
└── test
    └── java
        └── com
            └── enviro
                └── assessment
                    └── grad001
                        └── thamsanqandaba
                            └── ThamsanqandabaApplicationTests.java
```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes or improvements.

## Author

👤 **THAMSANQA NDABA**
- GITHUB: [@THAM-SANQA](https://github.com/THAM-SANQA)

## License

Copyright © 2024 [THAMSANQA NDABA](https://github.com/THAM-SANQA).<br />
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)