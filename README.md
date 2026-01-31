# F1 Analyzer

A backend Spring Boot application that exposes REST APIs for analyzing Formula 1 racing data such as drivers, races, constructors, and standings.

---

## Why This Project Exists

Formula 1 datasets are widely available, but they are often consumed as static CSV files or queried manually.  
This approach does not scale well and makes it difficult to reuse the data across applications.

The intent behind this project is to:
- Convert raw Formula 1 data into a structured backend system
- Expose analytical insights through reusable REST APIs
- Demonstrate clean backend design using Java and Spring Boot
- Serve as a foundation for dashboards, analytics tools, or further extensions

This project focuses on **backend engineering practices**, not UI or visualization.

---

## What This Project Does

F1 Analyzer:
- Loads Formula 1 domain data into a relational database
- Models real-world entities such as drivers, races, circuits, and constructors
- Provides REST endpoints to query this data
- Separates responsibilities using a layered architecture
- Allows easy extension for future analytical features

---

## How the Project Is Implemented

The project follows a standard Spring Boot layered architecture to ensure clarity, maintainability, and scalability.

