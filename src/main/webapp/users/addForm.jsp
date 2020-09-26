<%--
  Created by IntelliJ IDEA.
  User: garfeello
  Date: 26.09.2020
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie użytkownika</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="card-body">
    <div class="shadow p-3 mb-5 bg-white rounded">
        <div class="alert alert-primary" role="alert">
            Stwórz użytkownika
        </div>
        <form action="/add" method="post">
            <div class="form-group">
                <label for="formGroupExampleInput" class="col-sm-2 col-form-label">Wpisz nazwę użytkownika</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="formGroupExampleInput"
                           placeholder="np. Maciek_Swietny_Programista69" name="user">
                </div>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Podaj adres mailowy</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                           placeholder="np. Maciek69@amazon.com" name="email">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" pattern=".{12,24}" class="form-control validate"
                           id="inputPassword3" name="password"
                           placeholder="Musi zawierać od 12 do 24 znaków ">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">Stwórz konto</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
