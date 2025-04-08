package com.itu.Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login_treat")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("email");
        String password = request.getParameter("mdp");
        HttpSession session = request.getSession();
        if (username != null && password != null) {
            // Logique de validation des informations d'identification
            if (username.equals("admin@admin.com") && password.equals("admin")) {
                response.sendRedirect("Welcome.jsp"); // Rediriger vers la page de bienvenue
                session.setAttribute("username", username); // Stocker le nom d'utilisateur dans la session
                session.setAttribute(password, password); 
            } else {
                response.sendRedirect("login.jsp?error=1"); // Rediriger vers la page de connexion avec une erreur
            }
        } else {
            response.sendRedirect("login.jsp?error=2"); // Rediriger vers la page de connexion avec une erreur
        }
    }

}
