package ru.atom.dao;

/**
 * Created by sergey on 3/25/17.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class DbConnector {
    private static final Logger log = LoggerFactory.getLogger(DbConnector.class);

    private static final String URL_TEMPLATE = "jdbc:postgresql://%s:%d/%s";
    private static final String URL;
    private static final String HOST = "ec2-75-101-128-10.compute-1.amazonaws.com";
    private static final int PORT = 5432;
    private static final String DB_NAME = "d3n6pav6fk0v08";
    private static final String USER = "lttxdkvpzhhozk";
    private static final String PASSWORD = "596e9c7b3b375cacdcaf609788000a7cfefb9aebfe306bb73a325085cf22789d";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.error("Failed to load jdbc driver.", e);
            System.exit(-1);
        }

        URL = String.format(URL_TEMPLATE, HOST, PORT, DB_NAME);
        log.info("Success. DbConnector init.");
    }

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private DbConnector() { }
}