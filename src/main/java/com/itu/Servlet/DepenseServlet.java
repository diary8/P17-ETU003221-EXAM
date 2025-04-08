package com.itu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/traitementDepense")
public class DepenseServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    }    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
                PrintWriter out = res.getWriter();
                // HttpSession session = req.getSession();
                String date = (String) req.getParameter("date");
                String montant = (String) req.getParameter("montant");
                int vola = Integer.parseInt(montant);
                int idlibelle = Integer.parseInt(req.getParameter("libelle"));
                try {

                    Depense dep = new Depense();
                    int plafond = dep.plafond(idlibelle);
                    if (plafond > vola) {
                        dep.setLibelle(idlibelle);
                        dep.setMontant(vola);
                        dep.setDate(date);
                        dep.save();
                        req.setAttribute("message", "La dépense a été ajoutée avec succès !");    
                    }
                    else {
                    req.setAttribute("message", "Le montant de la dépense dépasse le plafond autorisé !");
                    }
                    DashboardGestion dash = new DashboardGestion();
                    List<DashboardGestion> list = dash.getGestion();
                    req.setAttribute("list_mouvement", list);
                    RequestDispatcher dispat = req.getRequestDispatcher("dashboard.jsp");
                    dispat.forward(req, res); 
                    }
                catch (Exception e) {
                    out.print(e);
                }
        }
    }