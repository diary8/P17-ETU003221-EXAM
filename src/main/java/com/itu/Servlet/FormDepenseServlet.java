package com.itu.Servlet;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/depense")
public class FormDepenseServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Prevision prevision = new Prevision();
        try {
            Vector<BaseObject> previsions = prevision.findAll();
            request.setAttribute("previsions", previsions);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.getRequestDispatcher("depenseform.jsp").forward(request, response);
    }
    
}
