<%--
  Created by IntelliJ IDEA.
  User: garfeello
  Date: 26.09.2020
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja użytkownika</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="card-body">
    <div class="shadow p-3 mb-5 bg-white rounded">
        <div class="alert alert-primary" role="alert">
            Edytuj użytkownika
        </div>
        <form action="/edit" method="post">

            <div class="form-group">
                <label for="disabledTextInput" class="col-sm-2 col-form-label">id użytkownika </label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" id="disabledTextInput" value="${user.id}"
                           name="id" readonly="readonly">
                </div>
            </div>

            <div class="form-group">
                <label for="formGroupExampleInput" class="col-sm-2 col-form-label">Wpisz nazwę użytkownika do
                    edycji</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="formGroupExampleInput" value="${user.username}"
                           name="user">
                </div>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Podaj nowy adres mailowy</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                           value="${user.email}" name="email">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" pattern=".{12,24}" class="form-control validate"
                           id="inputPassword3" name="password"
                           placeholder=" Podaj nowe hasło, które musi zawierać od 12 do 24 znaków ">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">Edytuj</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
