# CRUD MVC - Control de Usuarios

Este proyecto consiste en un sistema de gestión de usuarios desarrollado bajo el patrón de arquitectura **Model-View-Controller (MVC)**, utilizando **Java** y **MySQL**.

## 🛠️ Configuración de la Base de Datos

Para que el proyecto funcione correctamente, debes ejecutar el siguiente script en tu gestor de base de datos (MySQL Workbench, phpMyAdmin, etc.). 

> **Nota:** Se ha optimizado el script original eliminando `IDENTITY` (propio de SQL Server) por `AUTO_INCREMENT` para asegurar compatibilidad total con MySQL.

[Image of MVC architecture diagram]

### Script SQL

```sql
-- 1. Crear la base de datos
CREATE DATABASE IF NOT EXISTS Users;
USE Users;

-- 2. Crear la tabla de usuarios con ID autoincremental
CREATE TABLE Users_T (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    name_user VARCHAR(25) NOT NULL,
    lastN_user VARCHAR(25) NOT NULL,
    gmail_user VARCHAR(100) NOT NULL,
    dateCreate_user DATE,
    dateUpdate_user DATE
);

-- 3. Insertar datos de prueba
-- Nota: No es necesario pasar el id_user ya que es AUTO_INCREMENT
INSERT INTO Users_T (name_user, lastN_user, gmail_user, dateCreate_user, dateUpdate_user) 
VALUES
('Alejandro', 'García', 'alejandro.garcia@gmail.com', '2025-01-10', '2025-01-12'),
('María', 'Rodríguez', 'm.rodriguez88@gmail.com', '2025-01-15', '2025-01-15'),
('Carlos', 'López', 'carlos.lopez.dev@gmail.com', '2025-02-01', '2025-02-05'),
('Lucía', 'Fernández', 'lucia.fer.22@gmail.com', '2025-03-12', '2025-03-12'),
('Javier', 'Martínez', 'javi.mtz@gmail.com', '2025-04-20', '2025-05-01'),
('Elena', 'Sánchez', 'elena.sanchez.work@gmail.com', '2025-06-15', '2025-06-15'),
('Roberto', 'Gómez', 'roberto.gomez.92@gmail.com', '2025-07-04', '2025-07-10'),
('Sofia', 'Pérez', 'sofia.perez.contact@gmail.com', '2025-08-22', '2025-08-22'),
('Diego', 'Torres', 'diego.torres.mx@gmail.com', '2025-09-30', '2025-10-05'),
('Isabel', 'Ramírez', 'isabel.ramirez.info@gmail.com', '2025-11-12', '2025-11-12');

-- 4. Verificar la inserción
SELECT * FROM Users_T;

## 🔐 Configuración de Variables de Entorno

Para proteger las credenciales de la base de datos, este proyecto utiliza variables de entorno. Crea un archivo `.env` en la raíz de tu proyecto o configúralas en tu sistema operativo:

```properties
DB_URL=jdbc:mysql://localhost:3306/Users
DB_USER=tu_usuario
DB_PASSWORD=tu_contraseña

## 🔌 Conectividad con Base de Datos (JDBC)

Para que Java pueda comunicarse con MySQL, se requiere de un "traductor" llamado **JDBC Driver (Java Database Connectivity)**. Este actúa como un puente entre el código de la aplicación y el motor de la base de datos.



### 📦 Gestión de Dependencias (Maven)

En este proyecto utilizamos **Maven** para gestionar las librerías. La siguiente dependencia en el archivo `pom.xml` permite descargar e instalar automáticamente el conector de MySQL:

```xml
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>
