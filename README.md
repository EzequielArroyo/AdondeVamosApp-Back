
# Proyecto CRUD en Spring Boot

## Descripción

Este proyecto es una API REST desarrollada en **Spring Boot** que implementa un CRUD para gestionar las siguientes entidades:

- **Activity**: Representa una actividad con un título, fecha y hora, descripción, ubicación, propietario, participantes, número máximo de participantes y categoría.
- **User**: Representa un usuario con información personal, intereses y los idiomas que habla.
- **Interest**: Representa un interés específico de los usuarios.
- **Language**: Representa un idioma que los usuarios pueden hablar.

## Tabla de Contenidos
- [Uso](#uso)
- [Endpoint Disponible](#endpoint-disponible)
- [Ejemplo de Respuesta](#ejemplo-de-respuesta)
- [Tecnologías Usadas](#tecnologías-usadas)
## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL** 
- **Lombok**
- **Maven**
## Instalación y configuración

1. Clona este repositorio:
   ```sh
   git clone https://github.com/tu-usuario/tu-repo.git
   ```
2. Accede al directorio del proyecto:
   ```sh
   cd tu-repo
   ```
3. Configura la base de datos en `application.properties` o `application.yml`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Ejecuta la aplicación:
   ```sh
   mvn spring-boot:run
   ```

## Endpoints principales

## Usuarios (`/users`)

| Método | Endpoint      | Descripción               |
| ------ | ------------- | ------------------------- |
| GET    | `/users`      | Listar todos los usuarios |
| GET    | `/users/{id}` | Obtener usuario por ID    |
| POST   | `/users`      | Crear un nuevo usuario    |
| PUT    | `/users/{id}` | Actualizar un usuario     |
| DELETE | `/users/{id}` | Eliminar un usuario       |


###  EJemplo de solicitud

```bash
GET http://localhost:8080/user/JaneDoe09
```

### Respuesta Exitosa (`200 OK`)

```json
{
  "username": "JaneDoe09",
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane.doe@example.com",
  "birthdate": "1990-05-15",
  "sex": "Female",
  "phone": "+1-234-567-890",
  "location": "New York, USA",
  "languages": ["Spanish", "English"],
  "bio": "Avid traveler and foodie. Passionate about technology and education.",
  "occupation": "Software Engineer",
  "interests": ["Hiking", "Reading", "Photography"],
  "activities": [
    {
      "id": 1,
      "title": "Morning Yoga",
      "datetime": "2025-01-17T06:30:00",
      "description": "A relaxing yoga session to start the day.",
      "location": "Central Park",
      "participants": 3,
      "maxParticipants": 8,
      "category": "Health & Wellness"
    },
    {
      "id": 2,
      "title": "Team Meeting",
      "datetime": "2025-01-17T10:00:00",
      "description": "Weekly sync with the project team to review progress.",
      "location": "Office",
      "participants": 5,
      "maxParticipants": 10,
      "category": "Work"
    }
  ]
}
```

### Usuario No Encontrado (`404 Not Found`)

```json
{
  "error": "User not found"
}
```

## Actividades (`/activities`)

| Método | Endpoint           | Descripción                  |
| ------ | ------------------ | ---------------------------- |
| GET    | `/activities`      | Listar todas las actividades |
| GET    | `/activities/{id}` | Obtener actividad por ID     |
| POST   | `/activities`      | Crear una nueva actividad    |
| PUT    | `/activities/{id}` | Actualizar una actividad     |
| DELETE | `/activities/{id}` | Eliminar una actividad       |









