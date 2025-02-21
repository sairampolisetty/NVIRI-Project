# NVIRI-Project (Employee Management)

## Overview

It is a full-stack web application designed to manage employee information. It allows users to add, edit, delete, and search employee records.

## Features

* Add new employees with name, manager, and salary details.
* View a list of employees with pagination.
* Search for employees by name.
* Edit existing employee records.
* Delete employee records.

## Technologies Used

* **Frontend:**
    * React.js
* **Backend:**
    * Spring Boot (Java)
* **Database:**
    * PostgreSQL

## Getting Started

### Prerequisites

* Java Development Kit (JDK) [Specify version]
* Maven or Gradle (for building the Spring Boot application)
* PostgreSQL (installed and running)
* Node.js and npm (for the React frontend)

### Installation

1.  Clone the repository:

    ```bash
    git clone [https://github.com/sairampolisetty/NVIRI-Project.git](https://www.google.com/search?q=https://github.com/sairampolisetty/NVIRI-Project.git)
    cd NVIRI-Project
    ```

2.  **Backend (Spring Boot):**
    * Navigate to the Spring Boot backend directory.
    * Configure your PostgreSQL database connection in the `application.properties` or `application.yml` file.
    * Build the application using Maven or Gradle.
    * Run the Spring Boot application.

3.  **Frontend (React):**
    * Navigate to the React frontend directory (`client`).
    * Install dependencies: `npm install` or `yarn install`.
    * Start the React application: `npm start`.

4.  Open your browser and navigate to `http://localhost:3000` (or the appropriate port).

## API Endpoints

[**Document your Spring Boot REST API endpoints here. Include the HTTP method, URL, request parameters, and response format.**]

* **GET /api/employees:**
    * Description: Retrieves a list of all employees.
    * Request: None
    * Response: JSON array of employee objects.
* **POST /api/employees:**
    * Description: Adds a new employee.
    * Request: JSON object containing employee details.
    * Response: JSON object representing the created employee.
  
This is the picture of the project
![Screenshot 2025-02-21 142113](https://github.com/user-attachments/assets/be964a0e-9cc7-4129-9872-72bc64861a94)
