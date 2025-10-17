<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 16/10/2025
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creer ou Modifier Departement</title>
</head>
<body>
<div class="container">
    <h2>Submit Form (GET Method)</h2>
    <form action="departements" method="post">
        <input type="hidden" name="id" value="${departement.id}">
        <label for="nom">Nom:</label>
        <input type="text" id="name" name="nom" value="${departement.nom}" required><br>
        <button type="submit">Créer ou modifier Departement</button>
    </form>
</div>
</body>
</html>
