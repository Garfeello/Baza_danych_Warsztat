<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Swietna aplikacja Kamila</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>
    <link href="<c:url value="/theme/css/dashboard.css"/>">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
    <a class="navbar-brand">FANTASTYCZNY MACIEK LTD</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse " id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a href="/list">
                    <button class="btn btn-outline-info btn-lg" type="button">Home</button>
                </a>
            </li>
            <ul class="navbar-nav mr-auto">
                <button class="btn btn-outline-info btn-lg" type="button">
                    <%= (new java.util.Date()).toLocaleString()%>
                </button>
            </ul>
        </ul>
        <span class="navbar-text">
    <a href="/invalidate"><button class="btn btn-outline-info btn-lg" type="button">Wyloguj</button></a>
    </span>
    </div>
</nav>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js">
</script>
<script src="<c:url value="/theme/js/dashboard.js"/>">
</script>
</body>
</html>