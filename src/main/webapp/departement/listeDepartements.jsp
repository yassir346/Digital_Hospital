<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 16/10/2025
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="departements?action=creer">Ajouter Departement</a>
<caption><h2>Liste de departements</h2></caption>
<table>
    <th>id</th>
    <th>nom</th>
    <c:forEach var="d" items="${departements}">
        <tr>
            <td>${d.id}</td>
            <td>${d.nom}</td>
            <td><a href="departements?action=modifier&id=${d.id}">Modifier</a></td>
            <td><a href="departements?action=supprimer&id=${d.id}">Supprimer</a></td>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
