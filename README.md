# Smart Campus API

Name: Janithya Vinuthmi Wadumethrige
Student ID: 20241447 / w2153566
Module: 5COSC022C.2 Client-Server Architectures
Assignment: Individual Coursework


## Project Description
This project is a fully RESTful API developed using Java, JAX-RS (Jersey), and the Grizzly HTTP server for a Smart Campus system.

The API is designed to manage Rooms and their associated Sensors, while also maintaining a collection of Sensor Readings over time. It allows clients to create, retrieve, filter, and manage these resources through standard RESTful endpoints.

All data is stored in-memory using efficient data structures such as HashMap, without relying on any external database. The system also includes features like query-based filtering, nested resources for sensor readings, exception handling, and request/response logging to simulate a real-world backend service.

---
## Discovery Endpoint

### GET /api/v1
```json
{
  "name": "Smart Campus API",
  "version": "v1",
  "contact": "admin@smartcampus.com",
  "links": {
    "rooms": "/api/v1/rooms",
    "sensors": "/api/v1/sensors"
  }
}
```
---
## Data Models

The system is built around three main entities that represent the Smart Campus environment.

### Room
A Room represents a location within the campus where sensors are installed.

```json
{
  "id": "CLS-102",
  "name": "Classroom 102",
  "capacity": 45,
  "sensorIds": []
}
```
### Sensor
```json
{
  "id": "SEN-001",
  "type": "Temperature",
  "status": "ACTIVE",
  "currentValue": 25.5,
  "roomId": "CLS-102"
}
```
### SensorReading
```json
{
  "id": "READ-001",
  "timestamp": 1713439200000,
  "value": 26.0
}
```
## API Endpoints

### Rooms
- GET /rooms → Get all rooms
- POST /rooms → Create a room
- GET /rooms/{id} → Get room details
- DELETE /rooms/{id} → Delete room

### Sensors
- GET /sensors → Get all sensors
- GET /sensors?type=Temperature → Filter sensors
- POST /sensors → Create sensor
- GET /sensors/{id} → Get sensor

### Sensor Readings
- GET /sensors/{id}/readings → Get readings
- POST /sensors/{id}/readings → Add reading

---

## Sample CURL Commands
### 1. Discovery endpoint
```bash
curl http://localhost:8081/api/v1/
```

### 2. Create Room
```bash
curl -X POST http://localhost:8081/api/v1/rooms \
-H "Content-Type: application/json" \
-d '{"id":"CLS-102","name":"Classroom 102","capacity":45}'
```
### 3. Get Rooms
```bash
curl http://localhost:8081/api/v1/rooms
```
### 4. Create Sensor
```bash
curl -X POST http://localhost:8081/api/v1/sensors \
-H "Content-Type: application/json" \
-d '{"id":"SEN-001","type":"Temperature","status":"ACTIVE","currentValue":25.5,"roomId":"CLS-102"}'
```
### 5.Get Sensors
```bash
curl http://localhost:8081/api/v1/sensors
```
### 6. Filter Sensors
```bash
curl http://localhost:8081/api/v1/sensors?type=Temperature
```
### 7. Add Sensor Reading
```bash
curl -X POST http://localhost:8081/api/v1/sensors/SEN-001/readings \
-H "Content-Type: application/json" \
-d '{"id":"READ-001","timestamp":1713439200000,"value":26.0}'
```
## Error Handling

- 409: Room cannot be deleted if it has sensors
- 422: Room does not exist
- 404: Resource not found
- 403 Forbidden → Sensor under maintenance
- 500 Internal Server Error → Unexpected error

## Features

- RESTful API design
- Filtering using query parameters
- Nested resources (sensor readings)
- Exception handling using mappers
- Logging filter for request and response
- In-memory data storage using HashMap

## Technologies Used

- Java
- JAX-RS (Jersey)
- Grizzly Server
- Maven
