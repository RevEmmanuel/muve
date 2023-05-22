package africa.semicolon.muve;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MuveApplicationTest {

    @Test
    void contextLoads() {

    }

    @Test
    void testDatabaseConnection() {
        DriverManagerDataSource dataSource = new
                DriverManagerDataSource("jdbc:postgresql://localhost:5432/", "postgres", "password");
        try {
            Connection databaseConnection = dataSource.getConnection();
            System.out.println(databaseConnection);
            assertNotNull(databaseConnection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}