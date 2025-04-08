package com.itu.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectPost {

    public static Connection Connecter() throws ClassNotFoundException, IOException {
        Connection connection = null;
        String URL = "jdbc:postgresql://localhost:5432/exam"; // Correction de l'URL
        String User = "postgres";
        String password = " ";

        try {
            // Charger le driver PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Établir la connexion
            connection = DriverManager.getConnection(URL, User, password);
            System.out.println("Connexion réussie à la base de données !");
        } catch (SQLException e) {
            System.out.println("Erreur: Connexion à la base de données échouée. " + e.getMessage());
        }
        return connection;
    }
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Connection conn = Connect.Connecter();
    }
}
