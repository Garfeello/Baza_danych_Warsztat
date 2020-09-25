<%--
  Created by IntelliJ IDEA.
  User: garfeello
  Date: 25.09.2020
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pl">
<head>
    <title>Swietna zakladka dla Maciusia</title>
</head>
<body>
<%@ include file="header.jsp" %>

<!-- /.container-fluid -->


<%@ include file="footer.jsp" %>
<div class="container-fluid">
    <button type="button" class="btn btn-primary btn-lg">Large button</button>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">id</th>
            <th scope="col">Username</th>
            <th scope="col">email</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <c:forEach begin="1" items="${users}" var="user">
            <tbody>
            <tr>
                <td scope="row">${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <th scope="row">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <a href='<c:url value="/edit?id=${user.id}"/>'>
                            <button type="button" class="btn btn-primary">Edytuj</button>
                        </a>
                        <a href='<c:url value="/show?id=${user.id}"/>'>
                            <button type="button" class="btn btn-primary">Pokaż</button>
                        </a>
                        <a href='<c:url value="/delete?id=${user.id}"/>'>
                            <button type="button" class="btn btn-danger">Usuń</button>
                        </a>

                    </div>
                </th>
            </tr>
            </tbody>
        </c:forEach>
    </table>

</body>
</html>