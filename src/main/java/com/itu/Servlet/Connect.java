package com.itu.Servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect 
{
    public static Connection Connecter() throws ClassNotFoundException 
    {
        Connection Connection;
        String URL = "jdbc:mysql://localhost:3306/db_s2_ETU003221";
        String User = "ETU003221";
        String password = "Y6FTyeoA";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection = DriverManager.getConnection(URL, User, password);
            if (Connection != null) {
                System.out.println("Connexion réussie à la base de données !");
                return Connection;
            }
        } catch (SQLException e) {
            System.out.println("Erreur: Connexion à la base de données échouée.");
            e.printStackTrace();
        }
        return null;
    }    
}
