<%--
  Created by IntelliJ IDEA.
  User: garfeello
  Date: 26.09.2020
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showUser</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="card-body">
    <div class="shadow p-3 mb-5 bg-white rounded">
        <ul class="list-group list-group-flush">
            <li class="list-group-item">ID: ${user.id}</li>
            <li class="list-group-item">Nazwa użytkownika: ${user.username}</li>
            <li class="list-group-item">Adres mailowy: ${user.email}</li>
        </ul>
        <div class="col-sm-10">
            <a href="/list">
                <button type="submit" class="btn btn-primary">Wróć</button>
            </a>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
