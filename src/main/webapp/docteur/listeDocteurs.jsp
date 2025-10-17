<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Title</title>
</head>
<body>
<a href="docteurs?action=creer">Ajouter Docteur</a>
<caption><h2>Liste de docteurs</h2></caption>
<table>
    <th>id</th>
    <th>nom</th>
    <th>prenom</th>
    <th>email</th>
    <th>mot De Passe</th>
    <th>Spécialité</th>
    <c:forEach var="doc" items="${docteurs}">
        <tr>
            <td>${doc.id}</td>
            <td>${doc.nom}</td>
            <td>${doc.prenom}</td>
            <td>${doc.email}</td>
            <td>${doc.motDePasse}</td>
            <td>${doc.specialite}</td>
            <td><a href="docteurs?action=modifier&id=${doc.id}">Modifier</a></td>
            <td><a href="docteurs?action=supprimer&id=${doc.id}">Supprimer</a></td>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
