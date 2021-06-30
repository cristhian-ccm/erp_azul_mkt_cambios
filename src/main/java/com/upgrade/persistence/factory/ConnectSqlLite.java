/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author darko
 */
public class ConnectSqlLite {

    public Connection connection;
    public Statement statement;   
    public String ruta;

    /**
     * Constructor for objects of class Conexion
     */
    public ConnectSqlLite() {
        ruta = "/Jetty/bd/BDFacturador.db";
    }

    public void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
