<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 19/10/2025
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="display: flex; flex-direction: row;">
        <div style="background-color: mediumaquamarine; height: 200px; width: 200px;">
            <a href="${pageContext.request.contextPath}/salles">Salles</a>
        </div>
        <div style="background-color: lightskyblue; height: 200px; width: 200px;">
            <a href="${pageContext.request.contextPath}/departements">Departements</a>
        </div>
        <div style="background-color: palevioletred; height: 200px; width: 200px;">
            <a href="${pageContext.request.contextPath}/docteurs">Docteurs</a>
        </div>
        <div style="background-color: lightyellow; height: 200px; width: 200px; ">
            <a href="${pageContext.request.contextPath}/consultations">Consultations</a>
        </div>
</div>
</body>
</html>
