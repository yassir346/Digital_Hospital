<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 15/10/2025
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="salles?action=new">Ajouter salle</a>
<caption><h2>Liste de salles</h2></caption>
<table>
    <th>id</th>
    <th>nom</th>
    <th>capacite</th>
    <c:forEach var="salle" items="${salles}">
        <tr>
            <td>${salle.id}</td>
            <td>${salle.nom}</td>
            <td>${salle.capacite}</td>
            <td>
                <a href="salles?action=edit&id=${salle.id}">Modifier</a> |
                <a href="salles?action=delete&id=${salle.id}">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
