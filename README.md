# Incident Management System

This repository contains a REST API and front-end for an Incident Management System. The system is designed to allow users to register, log in, and manage incidents, providing functionalities such as creating, viewing, editing, and searching incidents.

## Features

- **User Management**: Allows for user registration, login, and Incident Management
- **Incident Management**: Users can create, view, and edit incidents. Each incident includes details such as the type of incident (Enterprise or Government), reporter details, incident details, priority, status, and reporting date.
- **Unique Incident IDs**: Automatically generates unique incident IDs in the format `RMG` + Random 5-digit number + Current year (e.g., `RMG345712022`).
- **Search Functionality**: Incidents can be searched using their unique ID.
- **Security**: Users can only view and edit their incidents.
- **Auto-fill Data**: Auto-fills reporter information if the reporter has previously entered details in the system.

## Development Environment

- **OS**: Ubuntu 18.0 or higher
- **Backend**: Java 8 or higher, Spring Boot, SpringMVC, Hibernate, Maven
- **Database**: MySQL SQL
- **Frontend**: HTML, CSS, JS, jQuery, Thymeleaf

## Setup

### Prerequisites

- Java 8 or higher
- MySQL 
- Spring Framework

### Installing

1. **Clone the repository**

2. ## Usage

### API Endpoints

# API Endpoints

## Registration Endpoints

- **GET /register**
  - **Description:** Displays the user registration form.
  - **Returns:** Registration page.

- **POST /register**
  - **Description:** Processes the user registration form, saves the user, and redirects to the login page if successful.
  - **Returns:** Redirection to the login page or registration page (on error).

## Login and Logout Endpoints

- **GET /login**
  - **Description:** Displays the login form.
  - **Returns:** Login page.

- **POST /login**
  - **Description:** Authenticates the user and sets up the session. Redirects to different dashboards based on user roles.
  - **Returns:** Redirection to the user dashboard, admin dashboard, or back to the login page (on failure).

- **POST /logout**
  - **Description:** Logs out the user by clearing the session and redirects to the login page.
  - **Returns:** Redirection to the login page.

## Dashboard and Incident Management Endpoints

- **GET /dashboard**
  - **Description:** Displays the dashboard for the logged-in user with incidents related to them. Can filter incidents by ID.
  - **Returns:** Dashboard page with incidents or redirection to login.

- **POST /addIncident**
  - **Description:** Adds a new incident for the logged-in user and redirects to the dashboard.
  - **Returns:** Redirection to the dashboard with a success message.

- **GET /modifyincident/{id}**
  - **Description:** Displays the form to edit an incident if the incident belongs to the logged-in user and is not closed.
  - **Returns:** Incident edit page or redirection to the dashboard (if unauthorized or not found).

- **POST /editIncident**
  - **Description:** Updates an existing incident's details and redirects to the dashboard.
  - **Returns:** Redirection to the dashboard with a status message.

## API for Incident Details

- **GET /api/fetchDetails**
  - **Description:** Fetches details of incidents by their 'details' attribute and returns the first matching incident.
  - **Returns:** JSON response with incident details or 404 Not Found.

## User and Administration Endpoints

- **GET /user/{userId}**
  - **Description:** Displays details for a specific user including their incidents, if found.
  - **Returns:** User details page or redirection to the admin dashboard (if user not found).

- **GET /admindashboard**
  - **Description:** Displays the admin dashboard, showing incidents for all users. Can filter incidents by ID.
  - **Returns:** Admin dashboard page.

- **POST /updateStatus/{id}**
  - **Description:** Updates the status of a specific incident via API and returns a confirmation message.
  - **Returns:** JSON response confirming the status update or 404 Not Found if incident is not found.


### Accessing the Application

- Open your web browser and navigate to `http://localhost:3000` to access the frontend application.
- Use Postman or any other API client to interact directly with the API.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

