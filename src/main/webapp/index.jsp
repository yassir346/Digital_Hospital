<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello Clinic!" %>
    <div style="display: flex; flex-direction: row;">
        <div style="background-color: mediumaquamarine; height: 500px; width: 500px;">
            <a href="login">Log in</a>
        </div>
        <div style="background-color: lightskyblue; height: 500px; width: 500px;">
            <a href="auth">Sign up</a>
        </div>
    </div>
</h1>
<br/>
</body>
</html>