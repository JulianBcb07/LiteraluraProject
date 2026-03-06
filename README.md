# 📚 Literalura - Catálogo de Libros

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-3.9-red?style=for-the-badge&logo=apachemaven)

**Literalura** es un desafío de programación propuesto por Alura Latam para el programa Oracle Next Education. Consiste en una aplicación de consola que interactúa con la API de [Gutendex](https://gutendex.com/) para buscar libros, procesar datos JSON y persistirlos en una base de datos relacional.



## 🚀 Características

* **Búsqueda Inteligente**: Localiza libros por título consumiendo datos en tiempo real de la API Gutendex.
* **Persistencia de Datos**: Almacena libros y autores en una base de datos PostgreSQL, evitando duplicados.
* **Gestión de Autores**: Mapeo de relaciones `@ManyToOne` para asociar múltiples libros a un único autor.
* **Filtros Avanzados**:
    * Listado de todos los libros y autores registrados.
    * Búsqueda de autores vivos en un año determinado.
    * Filtrado de libros por idioma (Español, Inglés, Francés, Portugués).

## 🛠️ Tecnologías Utilizadas

* **Lenguaje**: Java 21
* **Framework**: Spring Boot 3.x
* **Persistencia**: Spring Data JPA / Hibernate
* **Base de Datos**: PostgreSQL
* **Serialización**: Jackson (Formatos JSON)
* **Gestión de Dependencias**: Maven

## 📋 Requisitos Previos

1.  **Java JDK 21** o superior.
2.  **PostgreSQL** instalado y en funcionamiento.
3.  Un IDE (IntelliJ IDEA recomendado).

## ⚙️ Configuración e Instalación

1. **Clonar el repositorio:**
   ```
   bash
   git clone https://github.com/JulianBcb07/LiteraluraProject.git
   ```

2. **Configurar Variables de Entorno:**

Para proteger las credenciales, la aplicación utiliza variables de entorno. Se tienen que configurar las siguientes en el sistema o IDE:

- DB_URL: jdbc:postgresql://localhost:5432/literalura

- DB_USER: usuario_postgres

- DB_PASSWORD: contraseña

3. **Crear la Base de Datos:**

Instalar y abrir PgAdmin o la terminal de Postgres y ejecutar:

```
SQL
CREATE DATABASE literalura;
```

4. **Ejecutar la aplicación:**
El proyecto puede correr desde un IDE Java o usando Maven:

```
Bash
mvn spring-boot:run
```

## 📂 Estructura del Proyecto

- **model:** Contiene las Entidades JPA y los Records para el mapeo del JSON.

- **repository:** Interfaces que extienden de JpaRepository para el acceso a datos.

- **service:** Clases encargadas de la conexión API y la conversión de datos.

- **main:** Clase Principal que gestiona el menú interactivo.

---

Desarrollado por Julian Bacab - 2026 😁
