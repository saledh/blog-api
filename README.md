# Blog Manager API

## Overview

The Blog Manager API is a RESTful API built using the Jooby framework. It allows users to manage blog posts, user authentication, and roles in a multi-tenant environment.

## Features

- User authentication with JWT
- Role-based access control (Admin, Editor)
- CRUD operations for blog posts
- MySQL database integration
- Ebean ORM for database interactions

## Requirements

- Java JDK 17 or higher
- Maven 3.8 or higher
- MySQL 8.x
- Git (optional, for cloning the repository)

## Setup Instructions

### 1. Clone the Repository

- git clone https://github.com/saledh/blog-api.git

### 2. Setup MySQL Database

1. Install MySQL 8.x.
1.1 Sfruttando un container Docker: 
```shell
$ docker run --name mysql-8.4 -e MYSQL_ROOT_PASSWORD=Root1234! -p 3306:3306 -d mysql:8.4
```
2. Create a new database:

```sql
   CREATE DATABASE BLOG_DB;
 ```

### 3. Build the Project

Run the following command to build the project:

```shell
mvn clean package
```

### 4. Run the Application

You can run the application using:

```shell
mvn jooby:run
```

The application will be available at `http://localhost:8080`.

## API Endpoints

### Authentication

- **POST /auth/login**: Authenticate a user and return a JWT token.