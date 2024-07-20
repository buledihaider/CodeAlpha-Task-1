package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/attendance_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Ghu123@45";
    private static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";

    
    static {
    	try {Class.forName(DRIVER_CLASS);}
    	catch(ClassNotFoundException e ) {
    		System.err.println("Failed to load JDBC driver"+e.getMessage());
    		throw new ExceptionInInitializerError(e) ;}
    	
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

