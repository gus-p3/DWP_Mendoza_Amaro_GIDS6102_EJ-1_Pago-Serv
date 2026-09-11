package com.proyecto1.pago_serv.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class PoolConexionConfig {

    // Lee las variables de tu application.properties
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        // 1. Credenciales y driver
        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPassword);
        config.setDriverClassName("org.postgresql.Driver");

        // 2. Configuración específica del Pool (HikariCP)
        config.setMaximumPoolSize(15);       // Máximo de conexiones simultáneas
        config.setMinimumIdle(5);            // Conexiones mínimas mantenidas abiertas
        config.setIdleTimeout(300000);       // Tiempo en ms antes de cerrar conexión inactiva
        config.setConnectionTimeout(20000);  // Tiempo máximo de espera por una conexión
        config.setPoolName("PagoServ-Pool"); // Nombre personalizado para identificarlo en los logs

        // 3. Retornar la conexión construida
        return new HikariDataSource(config);
    }
}