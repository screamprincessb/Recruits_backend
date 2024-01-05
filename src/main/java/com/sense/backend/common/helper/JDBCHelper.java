package com.sense.backend.common.helper;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCHelper {

    private HikariDataSource ds;
    private static JDBCHelper instance;

    private JDBCHelper() throws IOException, SQLException,
            PropertyVetoException {

       HikariConfig jdbcConfig = new HikariConfig();

        jdbcConfig.setMaximumPoolSize(10);
        jdbcConfig.setMinimumIdle(5);
        jdbcConfig.setJdbcUrl("jdbc:mysql://199.168.50.123:3306/check");
        jdbcConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        jdbcConfig.setUsername("");
        jdbcConfig.setPassword("");

        ds = new HikariDataSource(jdbcConfig);

    }

    public static JDBCHelper getInstance() throws IOException, SQLException,
            PropertyVetoException {
        if (instance == null) {
            instance = new JDBCHelper();
        }

        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = this.ds.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }

    public void closeConnectionPool() {
       this.ds.close();
    }

    public void clearInstance() {
        instance = null;
    }
}
