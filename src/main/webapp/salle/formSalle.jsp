<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 15/10/2025
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Créer Salle</title>
</head>
<body>
<div class="container">
    <h2>Submit Form (GET Method)</h2>
    <form action="salles" method="post">
        <input type="hidden" name="id" value="${salle.id}">
        <label for="nom">Nom:</label>
        <input type="text" id="name" name="nom" value="${salle.nom}" required><br>
        <label for="capacite">Capacite:</label>
        <input type="text" id="capacite" name="capacite" value="${salle.capacite}" required><br>
        <button type="submit">Créer ou modifier Salle</button>
    </form>
</div>
</body>
</html>
