<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.itu.Servlet.*" %>
<%@ page import="java.util.List" %>

<%
    List<DashboardGestion> list = (List<DashboardGestion>)request.getAttribute("list_mouvement");
    String mess = (String) request.getAttribute("message");
    if(mess != null) {
        out.println("<script>alert('" + mess + "');</script>");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
    <link rel="stylesheet" href="assets\css\welcome.css">
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <a href="#">my account </a>
        <a href="/ETU003221/prevision">prevision</a>
        <a href="/ETU003221/depense">depensons notre argent </a>
        <%-- <a href="logout.jsp" style="float:right;">Déconnexion</a> --%>
    </div>

    <!-- Contenu principal -->
    <div class="content">
        <h1>accueil</h1>
        <p>mouvement </p>
        <table>
            <tr>
            <th>libelle</th>
            <th>Previsions</th>
            <th>Depenses</th>
            <th>Ecart</th>
            </tr>
        <% if(!list.isEmpty()) { %>
        <% for(DashboardGestion prev : list) { %>
            <tr>
                <td><%= prev.getLibelle() %></td>
                <td><%= prev.getMontant_prevision() %></td>
                <td><%= prev.getTotal_depense() %></td>
                <td><%= prev.getMontant_prevision() - prev.getTotal_depense() %></td>

            </tr>
        <% } %>
        <% } %>
        </table>
    </div>

    

</body>
</html>
