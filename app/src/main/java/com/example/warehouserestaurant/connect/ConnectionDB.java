package com.example.warehouserestaurant.connect;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB{
    private Thread thread;
    private Connection connection;
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static final String PORT = "";
    private static final String DATABASENAME = "";
    private static final String HOST = "";
    private static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASENAME;

    public ConnectionDB(){
        connect();
    }

    private void connect() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Se ha conectado con la base de datos");
        }catch(SQLException ex){
            System.out.println("ERROR al conectarse a la base de datos" + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

}

