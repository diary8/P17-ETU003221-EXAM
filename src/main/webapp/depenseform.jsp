<%@ page import="com.itu.Servlet.*" %>
<%@ page import="java.util.List" %>

<%
    List<BaseObject> list = (List<BaseObject>)request.getAttribute("previsions");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
 <h3>Credite votre compte :</h3>
        <form action="/ETU003180/traitementDepense" method="get">
            <label for="libelle">Libelle :</label>
            <select name="libelle" id="libelle">
                <option value="">-- Choisir un libelle --</option>
                <% for(BaseObject obj : list) { %>
                    <% Prevision prev = (Prevision) obj; %>
                    <option value="<%= prev.getId() %>"><%= prev.getLibelle() %></option>
                <% } %>
            </select>
            <label for="montant">Montant :</label>
            <input type="number" id="montant" name="montant" required><br><br>
            <label for="date">Date :</label>
            <input type="date" name="date" id="date">
            <input type="submit" value="Valider">
</body>
</html>