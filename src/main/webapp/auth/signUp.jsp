<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 19/10/2025
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Register</h2>
<form action="${pageContext.request.contextPath}/auth" method="post">
    <label for="email">Email :</label>
    <input id="email" name="email" type="email" value="${param.email}"/><br>

    <label for="firstName">Prénom :</label>
    <input id="firstName" name="prenom" type="text" value="${param.firstName}"/><br>

    <label for="lastName">Nom :</label>
    <input id="lastName" name="nom" type="text" value="${param.lastName}"/><br>

    <label for="password">Mot de passe :</label>
    <input id="password" name="motDePasse" type="password"/><br>

    <button type="submit">S'inscrire</button>
</form>

<a href="${pageContext.request.contextPath}/auth/logIn.jsp">Déjà inscrit ? Se connecter</a>
</body>
</html>
