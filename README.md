# API REST en Spring Boot

Este proyecto es una API REST desarrollada en **Spring Boot** que respalda una página web donde las personas pueden crear o unirse a actividades. El backend permite gestionar y obtener información sobre actividades, usuarios, y otros datos relacionados.

## Tabla de Contenidos
- [Uso](#uso)
- [Endpoint Disponible](#endpoint-disponible)
- [Ejemplo de Respuesta](#ejemplo-de-respuesta)
- [Tecnologías Usadas](#tecnologías-usadas)
## Uso

La API está disponible en `http://localhost:8080`. A continuación, se describe el único endpoint disponible actualmente.

## Endpoint Disponible

### Obtener Perfil de Usuario

**Descripción:** Devuelve la información de un usuario basado en su ID.

- **Método:** `GET`
- **URL:** `/user/{username}`

#### Parámetros

| Parámetro  | Tipo     | Descripción                  |
|------------|----------|------------------------------|
| `username` | `String` | Identificador único del usuario |

#### Código de Respuesta

| Código | Descripción               |
|--------|---------------------------|
| `200`  | Solicitud exitosa         |
| `404`  | Usuario no encontrado     |

## Ejemplo de Respuesta

### Solicitud

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

## Tecnologías Usadas

- Java 17
- Spring Boot
- Maven
- JSON