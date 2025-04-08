<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <h3>Credite votre compte :</h3>
        <form action="/ETU003180/traitementPrevision" method="get">
            <label for="libelle">Libelle :</label>
            <input type="text" name="libelle" id="libelle" required><br><br>
            <label for="montant">Montant :</label>
            <input type="number" id="montant" name="montant" required><br><br>
            <input type="submit" value="Valider la Creditation">
    </div>
</body>
</html>