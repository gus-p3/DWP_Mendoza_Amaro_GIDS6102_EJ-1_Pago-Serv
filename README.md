# DWP_Mendoza_Amaro_GIDS6102_EJ-1_Pago-Serv

Proyecto de Desarrollo Web Progresivo - Gestión de Pago de Servicios con Spring Boot, HikariCP y PostgreSQL.

---

## 📋 Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:
- **Java JDK 21** o superior: [Descargar Java 21](https://www.oracle.com/java/technologies/downloads/#java21)
- **PostgreSQL**: [Descargar PostgreSQL](https://www.postgresql.org/download/)
- **Git**: [Descargar Git](https://git-scm.com/)

---

## 🛠️ Instalación y Puesta en Marcha

### 1. Clonar el repositorio
Abre tu terminal y ejecuta el siguiente comando para clonar el proyecto:
```bash
git clone https://github.com/gus-p3/DWP_Mendoza_Amaro_GIDS6102_EJ-1_Pago-Serv.git
cd DWP_Mendoza_Amaro_GIDS6102_EJ-1_Pago-Serv
```

### 2. Configurar la Base de Datos PostgreSQL
Asegúrate de que tu servicio de PostgreSQL esté en ejecución y crea la base de datos:
```sql
CREATE DATABASE "pago-serv";
```

Verifica o ajusta las credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pago-serv
spring.datasource.username=postgres
spring.datasource.password=tu_password
```

### 3. Descargar dependencias y paquetes
Ejecuta el siguiente comando para descargar todos los paquetes y dependencias del proyecto:

- **En Windows:**
  ```bash
  .\gradlew.bat build -x test
  ```
- **En Linux / macOS:**
  ```bash
  ./gradlew build -x test
  ```

---

## 🧪 Ejecutar Pruebas y Verificar Conexión

Para validar que la conexión a PostgreSQL y el pool de conexiones funcionen correctamente:

- **En Windows:**
  ```bash
  .\gradlew.bat test
  ```
- **En Linux / macOS:**
  ```bash
  ./gradlew test
  ```

---

## ▶️ Ejecutar la Aplicación

Para iniciar el servidor Spring Boot en modo desarrollo:

- **En Windows:**
  ```bash
  .\gradlew.bat bootRun
  ```
- **En Linux / macOS:**
  ```bash
  ./gradlew bootRun
  ```

---

## ⚙️ Configuración del Pool de Conexiones (HikariCP)
La configuración del pool de conexiones se gestiona en `com.proyecto1.pago_serv.config.PoolConexionConfig`:
- **Pool Name:** `PagoServ-Pool`
- **Max Pool Size:** 15
- **Minimum Idle:** 5
- **Idle Timeout:** 300,000 ms (5 min)
- **Connection Timeout:** 20,000 ms
