package com.alice.WorkoutDiary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnector {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_HOST = "localhost";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "AspR4501";
    private static final int DATABASE_PORT = 3306;

    public enum DatabaseName {
        WorkoutDiaryDB
    }

    static {
        try {
            Class.forName(DRIVER).newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String getUrl(DatabaseName databaseName) {
        return String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=%s&serverTimezone=%s&useSSL=true",
                DATABASE_HOST, DATABASE_PORT, databaseName == null ? "" : databaseName.name(), "UTF-8",
                "Europe/Budapest");
    }

    public static Connection getConnection() {
        return getConnection(null);
    }

    public static Connection getConnection(DatabaseName databaseName) {
        try {
            return DriverManager.getConnection(getUrl(databaseName), DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Connection getConnection(DatabaseName databaseName, String user, String password) {
        try {
            return DriverManager.getConnection(getUrl(databaseName), user, password);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private DBConnector() {
    }

}