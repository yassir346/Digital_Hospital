<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 16/10/2025
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creer Consultation</title>
</head>
<body>
    <div class="container">
        <h2>Réservez une consultation</h2>
        <form action="consultations" method="post">
            <label for="date">Date et heure:</label>
            <input type="datetime-local" id="heureEtDate" name = "heureEtDate" value="consultation.heureEtDate">
            <button type="submit">Créer ou modifier Consultation</button>
        </form>
    </div>
    <div>
        <h2>${errorMassege}</h2>
    </div>
</body>
</html>
