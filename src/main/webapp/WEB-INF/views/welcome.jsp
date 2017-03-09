<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link rel="stylesheet" href="${contextPath}/resources/style.css">
</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>

    </c:if>
    <header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-2 col-sm-2">
                    <img class="logo" src="${contextPath}/resource/img/test.jpg" alt="logo">
                </div>
                <div class="col-lg-10 col-sm-10">
                    <p>Logout</p>
                </div>
            </div>
        </div>
    </header>
    <div class="container-fluid">
        <div class="row">
            <div class="col-2 col-sm-2">
                <a href="#" class="button"/>Мероприятия</a>
            </div>
            <div class="col-2 col-sm-2">
                <a href="#" class="button"/>Магазины</a>
            </div>
        </div>
        <div class="row">
            <div class="col-2 col-sm-2">
                <a href="#" class="button"/>Роутеры</a>
            </div>
            <div class="col-2 col-sm-2">
                <a href="#" class="button"/>Черный список</a>
            </div>
        </div>
    </div>
    <footer class="footer">
        <div class="container">
            <p class="text-muted">sashkoi1234@gmail.com</p>
        </div>
    </footer>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>