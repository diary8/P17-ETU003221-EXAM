package com.itu.Servlet;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class DashboardGestion {
    private String libelle;
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    private int montant_prevision;
    public int getMontant_prevision() {
        return montant_prevision;
    }
    public void setMontant_prevision(int montant_prevision) {
        this.montant_prevision = montant_prevision;
    }
    private int total_depense;
    public int getTotal_depense() {
        return total_depense;
    }
    public void setTotal_depense(int total_depense) {
        this.total_depense = total_depense;
    }
    DashboardGestion () {
        super();
    }
    DashboardGestion (String libelle, int montant_prevision, int total_depense) {
        this.libelle = libelle;
        this.montant_prevision = montant_prevision;
        this.total_depense = total_depense;
    }
    public List<DashboardGestion> getGestion() throws Exception {
        String sql = "SELECT p.libelle, \r\n" + //
                     "       p.montant AS montant_prevision, \r\n" + //
                     "       COALESCE(SUM(d.montant), 0) AS total_depense\r\n" + //
                     "FROM prevision p\r\n" + //
                     "LEFT JOIN depense d ON p.id = d.libelle\r\n" + //
                     "GROUP BY p.libelle, p.montant\r\n" + //
                    "ORDER BY p.libelle;";
        Statement St = null;
        ResultSet RS = null;
        List<DashboardGestion> tab = new ArrayList<>(); // Initialisation de la liste

        try {
            St = Connect.Connecter().createStatement();
            RS = St.executeQuery(sql);
            while (RS.next()) {
                DashboardGestion temp = new DashboardGestion();
                temp.setLibelle(RS.getString("libelle"));
                temp.setMontant_prevision(RS.getInt("montant_prevision"));
                temp.setTotal_depense(RS.getInt("total_depense"));
                tab.add(temp); // Ajout à la liste
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (RS != null) {
                RS.close();
            }
            if (St != null) {
                St.close();
            }
        }
        return tab; // Retourne la liste
    }
}
