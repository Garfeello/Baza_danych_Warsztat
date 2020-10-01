<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pl">
<head>
    <title>Swietna zakladka dla Maciusia</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="card-body">
    <div class="shadow p-3 mb-5 bg-white rounded">
        <div class="container-fluid">
            <table class="table table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">id.</th>
                    <th scope="col">Username</th>
                    <th scope="col">Email</th>
                    <th scope="col">Akcje</th>
                </tr>
                </thead>
                <c:forEach items="${users}" var="user">
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
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>