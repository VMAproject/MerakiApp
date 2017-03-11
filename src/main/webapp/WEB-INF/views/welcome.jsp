<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"/>

</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>


    <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
        <a class="navbar-brand" href="#"><img class="logo" src="${contextPath}/resources/img/CiscoMeraki.png" alt="logo"></a>
        <div class="greeting right">
            <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">
                <span class="greeting-logout">Logout</span></a>
        </div>
    </nav>
</c:if>

<div class="container">

    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-offset-1 col-lg-4 col-md-4 col-sm-4">
                <div class="size right">
                    <a href="<c:url value="/events"/> "  class="button"> Мероприятия</a>
                </div>
            </div>
            <div class="col-lg-offset-2 col-lg-4 col-md-4 col-sm-4">
                <div class="size">
                    <a href="#" class="button"/>Магазины</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-offset-1 col-lg-4 col-md-4 col-sm-4">
                <div class="size right">
                    <a href="#" class="button"/>Роутеры</a>
                </div>
            </div>
            <div class="col-lg-offset-2 col-lg-4 col-md-4 col-sm-4">
                <div class="size">
                    <a href="#" class="button"/>Черный список</a>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted">sashkoi1234@gmail.com</p>
    </div>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
