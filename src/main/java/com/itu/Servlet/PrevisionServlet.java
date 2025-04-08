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
@WebServlet("/traitementPrevision")
public class PrevisionServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
                PrintWriter out = res.getWriter();
                // HttpSession session = req.getSession();
                String libelle = (String) req.getParameter("libelle");
                String montant = (String) req.getParameter("montant");
                int vola = Integer.parseInt(montant);
                try {
                    Prevision pre = new Prevision(0, libelle, vola);
                    pre.save();
                    DashboardGestion dash = new DashboardGestion();
                    List<DashboardGestion> list = dash.getGestion();
                    req.setAttribute("list_mouvement", list);
                    req.setAttribute("message", "La demande a été ajoutée avec succès !");
                    RequestDispatcher dispat = req.getRequestDispatcher("dashboard.jsp");
            dispat.forward(req, res);
                    }
                catch (Exception e) {
                    out.print(e);
                }
        }
    }