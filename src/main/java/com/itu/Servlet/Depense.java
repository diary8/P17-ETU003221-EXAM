package com.itu.Servlet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Depense extends BaseObject{
    private int libelle;
    private int montant;
    private String date;
    public Depense() {
        super();
    }
    public Depense(int id,int libelle, int montant,String date) {
        setId(id);
        this.libelle = libelle;
        this.montant = montant;
        this.date = date;
    }
    public int getLibelle() {
        return libelle;
    }
    public void setLibelle(int libelle) {
        this.libelle = libelle;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(int montant) {
        this.montant = montant;
    }
    @Override
    public void save() throws Exception {
        String sql = "INSERT INTO depense(libelle,montant,date) VALUES (?,?,?)";
        try (PreparedStatement pstmt = Connect.Connecter().prepareStatement(sql)) {
            pstmt.setInt(1, this.getLibelle());
            pstmt.setDouble(2, this.getMontant());
            pstmt.setString(3, this.getDate());
            pstmt.executeUpdate();
            System.out.println("depense du compte inséré avec succès !");
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
        String req = "SELECT * FROM depense WHERE id = " + id;
        Statement St = null;
        ResultSet RS = null;
        BaseObject Temp = null;
        try {
            St = Connect.Connecter().createStatement();
            RS = St.executeQuery(req);
            while (RS.next()) {
                Temp = new Depense (RS.getInt("id"),RS.getInt("libelle"),RS.getInt("montant"),RS.getString("date"));
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
    public int plafond(int libelle) throws Exception{
        String req = "SELECT SUM(montant) AS total FROM depense WHERE libelle = " + libelle;
        Statement St = null;
        ResultSet RS = null;
        int total = 0;
        int result = 0;
        try {
            Prevision pre = new Prevision();
            pre = (Prevision) pre.getById(libelle);
            result = pre.getMontant();
            St = Connect.Connecter().createStatement();
            RS = St.executeQuery(req);
            while (RS.next()) {
                total = RS.getInt("total");
            }
            result = result - total;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (RS != null) {
                RS.close();    
            }
            St.close();
        }
        return result;
    }
    @Override
    public void remove(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    @Override
    public Vector<BaseObject> findAll() throws Exception {
        String req = "SELECT * FROM depense";
        Statement St = null;
        ResultSet RS = null;
        Vector<BaseObject> Depenses = new Vector<>();
        try {
            St = Connect.Connecter().createStatement();
            RS = St.executeQuery(req);
            while (RS.next()) {
                Depenses.add(new Depense (RS.getInt("id"),RS.getInt("libelle"),RS.getInt("montant"),RS.getString("date")));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            St.close();
            RS.close();
        }
        return Depenses;
    }    
}
