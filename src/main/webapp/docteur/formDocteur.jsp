<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 16/10/2025
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Docteur</title>
</head>
<body>
<div class="container">
    <h2>Submit Form (GET Method)</h2>
    <form action="${pageContext.request.contextPath}/docteurs" method="post">
        <input type="hidden" name="id" value="${docteur.id}">
        <label for="nom">Nom:</label>
        <input type="text" id="name" name="nom" value="${docteur.nom}" required><br>
        <label for="prenom">Prenom:</label>
        <input type="text" id="prenom" name="prenom" value="${docteur.prenom}" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${docteur.email}" required><br>
        <label for="password">Mot de passe:</label>
        <input type="password" id="password" name="password" value="${docteur.motDePasse}" required><br>
        <label for="specialite">Spécialité:</label>
        <input type="text" id="specialite" name="specialite" value="${docteur.specialite}" required><br>
        <button type="submit">Créer ou modifier Docteur</button>
    </form>
</div>
</body>
</html>
