package com.itu.Servlet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Prevision extends BaseObject{
    private String libelle;
    private int montant;
    public Prevision() {
        super();
    }
    public Prevision(int id,String libelle, int montant) {
        setId(id);
        this.libelle = libelle;
        this.montant = montant;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public int getMontant() {
        return montant;
    }
    public void setMontant(int montant) {
        this.montant = montant;
    }
    @Override
    public void save() throws Exception {
        String sql = "INSERT INTO prevision(libelle,montant) VALUES (?,?)";
        try (PreparedStatement pstmt = Connect.Connecter().prepareStatement(sql)) {
            pstmt.setString(1, this.getLibelle());
            pstmt.setDouble(2, this.getMontant());
            pstmt.executeUpdate();
            System.out.println("Prevision du compte inséré avec succès !");
        } catch (SQLException e) {
            throw e;
        }
    }
    @Override
    public void update(int id, String str) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public BaseObject getById(int id) throws Exception {
        String req = "SELECT * FROM prevision WHERE id = " + id;
        Statement St = null;
        ResultSet RS = null;
        BaseObject Temp = null;
        try {
            St = Connect.Connecter().createStatement();
            RS = St.executeQuery(req);
            while (RS.next()) {
                Temp = new Prevision (RS.getInt("id"),RS.getString("libelle"),RS.getInt("montant"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (RS != null) {
                RS.close();    
            }
            St.close();
        }
        return Temp;
    }
    @Override
    public void remove(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    @Override
    public Vector<BaseObject> findAll() throws Exception {
        String req = "SELECT * FROM prevision";
        Statement St = null;
        ResultSet RS = null;
        Vector<BaseObject> Previsions = new Vector<>();
        try {
            St = Connect.Connecter().createStatement();
            RS = St.executeQuery(req);
            while (RS.next()) {
                Previsions.add(new Prevision (RS.getInt("id"),RS.getString("libelle"),RS.getInt("montant")));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            St.close();
            RS.close();
        }
        return Previsions;
    }
}
