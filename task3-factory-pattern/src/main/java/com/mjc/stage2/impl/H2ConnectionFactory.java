package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    private final String url;
    private final String username;
    private final String password;

    public H2ConnectionFactory() {
        Properties properties = loadProperties();

        loadDriver(properties.getProperty("jdbc_driver"));

        this.url = properties.getProperty("db_url");
        this.username = properties.getProperty("user");
        this.password = properties.getProperty("password");
    }

    private void loadDriver(String driverClassName) {
        if (driverClassName == null) {
            throw new IllegalArgumentException("Not found property jdbc_driver in h2database.properties file");
        }

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(String.format("Failed to load database driver %s", driverClassName));
        }
    }

    private Properties loadProperties() {
        try (InputStream is = ClassLoader.getSystemResourceAsStream("h2database.properties")) {
            if (is == null) {
                throw new FileNotFoundException(String.format("Failed to load properties file %s", "h2database.properties"));
            }

            Properties props = new Properties();
            props.load(is);
            return props;
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to load properties", e);
        }
    }

    @Override
    public Connection createConnection() {
        try {
            return DriverManager.getConnection(this.url, this.username, this.password);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to obtain new connection", e);
        }
    }
}

