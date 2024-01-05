package com.sense.service.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {

    public static Connection getConnection() throws Exception {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            //production
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.170.91:3306/CORE", "admin", "P@ssw0rdsit"); // TEST REPORT

            conn.setAutoCommit(false);

            return conn;
        } catch (SQLException sqle) {
            throw new Exception("1, ConnDB.getConnection : " + sqle.getMessage());
        } catch (Exception e) {
            throw new Exception("2, ConnDB.getConnection : " + e.getMessage());
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
