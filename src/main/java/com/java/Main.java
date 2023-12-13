package com.java;

import com.java.login.Login;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        createDatabase();
        Login.main();
    }

    static void createDatabase() {
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:stmp.db");
            Statement statement = connection.createStatement();

            statement.executeUpdate(CREATE_TABLE_PLAYER);
            statement.executeUpdate(CREATE_TABLE_TACTICS);
            statement.executeUpdate(CREATE_TABLE_USER);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String CREATE_TABLE_PLAYER =
            "CREATE TABLE IF NOT EXISTS player (" +
                    "backNum int(11) NOT NULL DEFAULT 0," +
                    "pos varchar(50) DEFAULT NULL," +
                    "name varchar(50) DEFAULT NULL," +
                    "birth varchar(50) DEFAULT NULL," +
                    "nationality varchar(50) DEFAULT NULL," +
                    "height int(11) DEFAULT NULL," +
                    "weight int(11) DEFAULT NULL," +
                    "comment varchar(50) DEFAULT NULL," +
                    "PRIMARY KEY (backNum)" +
                    ")";

    private static String CREATE_TABLE_TACTICS =
            "CREATE TABLE IF NOT EXISTS tactics (\n" +
                    "  name varchar(50) NOT NULL,\n" +
                    "  formation varchar(50) DEFAULT NULL,\n" +
                    "  p1 varchar(50) DEFAULT NULL,\n" +
                    "  p1_t varchar(50) DEFAULT NULL,\n" +
                    "  p2 varchar(50) DEFAULT NULL,\n" +
                    "  p2_t varchar(50) DEFAULT NULL,\n" +
                    "  p3 varchar(50) DEFAULT NULL,\n" +
                    "  p3_t varchar(50) DEFAULT NULL,\n" +
                    "  p4 varchar(50) DEFAULT NULL,\n" +
                    "  p4_t varchar(50) DEFAULT NULL,\n" +
                    "  p5 varchar(50) DEFAULT NULL,\n" +
                    "  p5_t varchar(50) DEFAULT NULL,\n" +
                    "  p6 varchar(50) DEFAULT NULL,\n" +
                    "  p6_t varchar(50) DEFAULT NULL,\n" +
                    "  p7 varchar(50) DEFAULT NULL,\n" +
                    "  p7_t varchar(50) DEFAULT NULL,\n" +
                    "  p8 varchar(50) DEFAULT NULL,\n" +
                    "  p8_t varchar(50) DEFAULT NULL,\n" +
                    "  p9 varchar(50) DEFAULT NULL,\n" +
                    "  p9_t varchar(50) DEFAULT NULL,\n" +
                    "  p10 varchar(50) DEFAULT NULL,\n" +
                    "  p10_t varchar(50) DEFAULT NULL,\n" +
                    "  p11 varchar(50) DEFAULT NULL,\n" +
                    "  p11_t varchar(50) DEFAULT NULL,\n" +
                    "  comment varchar(50) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (name)\n" +
                    ")";

    private static String CREATE_TABLE_USER =
            "CREATE TABLE IF NOT EXISTS user (\n" +
                    "  id varchar(50) NOT NULL,\n" +
                    "  pw varchar(50) DEFAULT NULL,\n" +
                    "  name varchar(50) DEFAULT NULL,\n" +
                    "  birth varchar(50) DEFAULT NULL,\n" +
                    "  phone varchar(50) DEFAULT NULL,\n" +
                    "  email varchar(50) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (id)\n" +
                    ")";
}