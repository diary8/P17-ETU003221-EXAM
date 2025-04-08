<%@ page import="com.itu.Servlet.*" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Login & Inscription</title>
    <link rel="stylesheet" href="assets\css\style.css">
</head>
<body>
    <div class="form-box">
        <%
        String error = request.getParameter("error");
        if ("1".equals(error)) {
    %>
        <p style="color:red;">Identifiant ou mot de passe incorrect.</p>
    <%
        }
    %>
    <%   if ("2".equals(error)) {
    %>
        <p style="color:red;">utilisateur introuvable.</p>
    <%
        }
    %>
    <div class="container">

            <h2>Connexion</h2>
            <form action="login_treat" method="post">
                <label for="email">Email :</label>
                <input type="email" placeholder="Email" id="email" name="email" required>
                <label for="pass">Password</label>
                <input type="password" placeholder="Mot de passe" id="pass" name="mdp" required>
                <button type="submit">Se connecter</button>
                <p>Pas encore inscrit ? <a href="#" onclick="showRegister()">Créer un compte</a></p>
            </form>
        </div>

        <div class="form-box" id="register-box" style="display: none;">
            <h2>Inscription</h2>
            <form action="register_treat" method="post">
                <input type="text" placeholder="Nom d'utilisateur" required>
                <input type="email" placeholder="Email" required>
                <input type="password" placeholder="Mot de passe" required>
                <input type="password" placeholder="Confirmer le mot de passe" required>
                <button type="submit">S'inscrire</button>
                <p>Déjà un compte ? <a href="#" onclick="showLogin()">Se connecter</a></p>
            </form>
        </div>
    </div>

    <script>
        function showRegister() {
            document.querySelector('.form-box').style.display = 'none';
            document.getElementById('register-box').style.display = 'block';
        }

        function showLogin() {
            document.querySelector('.form-box').style.display = 'block';
            document.getElementById('register-box').style.display = 'none';
        }
    </script>
</body>
</html>
