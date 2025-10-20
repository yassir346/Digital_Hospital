<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 18/10/2025
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<caption><h2>Liste des Consultations à valider</h2></caption>
<table id="table" style="border: 1px solid black;">
    <th style="border: 1px solid black;">id</th>
    <th style="border: 1px solid black;">Date et Heure</th>
    <th style="border: 1px solid black;">Statut</th>
    <th style="border: 1px solid black;">Changer Staut</th>
    <c:forEach var="con" items="${consultations}">
        <tr>
            <td style="border: 1px solid black;">${con.id}</td>
            <td style="border: 1px solid black;">${con.heureEtDate}</td>
            <td style="border: 1px solid black;">${con.statut}</td>
            <td style="border: 1px solid black;">
                <form action="/Digital_Hospital_war_exploded/consultations" method="post">
                    <input id="id" type="hidden" name="id" value="${con.id}">
                    <select name="statut" id="statut">
                        <option selected="selected">${con.statut}</option>
                        <option value="VALIDEE">Résérvation validée</option>
                        <option value="TERMINEE">Résérvation terminée</option>
                        <option value="ANNULEE">Résérvation annulée</option>
                    </select>
                    <button type="submit">Valider changement</button>
                </form>
            </td>
<%--                <a href="salles?action=edit&id=${con.id}">Modifier</a> |--%>
<%--                <a href="salles?action=delete&id=${salle.id}">Supprimer</a>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
