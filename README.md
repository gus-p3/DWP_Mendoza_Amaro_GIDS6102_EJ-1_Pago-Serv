# DWP_Mendoza_Amaro_GIDS6102_EJ-1_Pago-Serv

Proyecto de Desarrollo Web Progresivo - Gestión de Pago de Servicios.

## 🚀 Tecnologías
- **Java 21**
- **Spring Boot 4.x** (Spring Data JPA)
- **HikariCP** (Pool de conexiones)
- **PostgreSQL**
- **Gradle**

## ⚙️ Configuración del Pool de Conexiones
El pool de conexiones se encuentra configurado en `com.proyecto1.pago_serv.config.PoolConexionConfig`:
- **Pool Name:** `PagoServ-Pool`
- **Max Pool Size:** 15
- **Minimum Idle:** 5
- **Idle Timeout:** 300,000 ms (5 min)
- **Connection Timeout:** 20,000 ms

## 🧪 Pruebas
Para ejecutar las pruebas unitarias y de integración de la conexión a la base de datos:
```bash
./gradlew test
```
