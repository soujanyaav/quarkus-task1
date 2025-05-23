# code-with-quarkus

A simple Quarkus REST API for managing books.

## 📚 Overview

This project provides a basic RESTful service for managing a collection of books using Quarkus. It supports creating, retrieving, updating, and deleting books — all stored in memory.

---

## 📁 Endpoints

Base path: `/books`

| Method | Endpoint       | Description              |
|--------|----------------|--------------------------|
| POST   | `/books`       | Create a new book        |
| GET    | `/books/{id}`  | Get a book by ID         |
| PUT    | `/books/{id}`  | Update a book by ID      |
| DELETE | `/books/{id}`  | Delete a book by ID      |

---
