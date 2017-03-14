<%--
  Created by IntelliJ IDEA.
  User: Verlamov
  Date: 14.03.17
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>W</title>

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
        <img class="logo" src="${contextPath}/resources/img/CiscoMeraki.png"
             alt="logo">
        <div class="greeting right">
            <div class="greeting-img">
                <img src="${contextPath}/resources/img/user-image.png" alt="user" />
            </div>
            <div class="greeting-user">
                Welcome ${pageContext.request.userPrincipal.name} | <br>
                <a onclick="document.forms['logoutForm'].submit()">
                    <span class="greeting-logout">Logout</span></a>
            </div>
        </div>
    </nav>
</c:if>
</body>
</html>
