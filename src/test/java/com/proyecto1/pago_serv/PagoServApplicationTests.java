package com.proyecto1.pago_serv;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PagoServApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
		assertNotNull(dataSource, "El DataSource no debe ser nulo");
	}

	@Test
	void testConexionPoolPostgres() throws SQLException {
		assertInstanceOf(HikariDataSource.class, dataSource, "El DataSource debe ser una instancia de HikariDataSource");
		
		HikariDataSource hikariDataSource = (HikariDataSource) dataSource;
		assertEquals("PagoServ-Pool", hikariDataSource.getPoolName(), "El nombre del pool debe ser 'PagoServ-Pool'");
		assertEquals(15, hikariDataSource.getMaximumPoolSize(), "El tamaño máximo del pool debe ser 15");
		assertEquals(5, hikariDataSource.getMinimumIdle(), "El mínimo de conexiones inactivas debe ser 5");

		// Probar conexión real activa con PostgreSQL
		try (Connection connection = dataSource.getConnection()) {
			assertNotNull(connection, "La conexión a PostgreSQL debe ser válida");
			assertTrue(connection.isValid(2), "La conexión a PostgreSQL debe responder activamente");
			System.out.println("✅ Conexión exitosa a PostgreSQL mediante pool: " + hikariDataSource.getPoolName());
			System.out.println("   Catálogo / BD actual: " + connection.getCatalog());
			System.out.println("   Driver: " + connection.getMetaData().getDriverName() + " v" + connection.getMetaData().getDriverVersion());
		}
	}

}

