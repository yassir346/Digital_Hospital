<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 19/10/2025
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="email">Email :</label>
    <input id="email" name="email" type="email" value="${param.email}"/><br>

    <label for="password">Mot de passe :</label>
    <input id="password" name="motDePasse" type="password"/><br>

    <button type="submit">Se connecter</button>
</form>

<a href="${pageContext.request.contextPath}/auth/register.jsp">S'inscrire</a>
</body>
</html>
