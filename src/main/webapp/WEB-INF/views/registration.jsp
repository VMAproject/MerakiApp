<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/registration.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/validation.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Dosis" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
    <img class="logo" src="${contextPath}/resources/img/CiscoMeraki.png"
         alt="logo">
    <div class="greeting right">
        <div class="clock">
            <div id="Date"></div>
            <ul>
                <li id="hours"></li>
                <li id="point">:</li>
                <li id="min"></li>
                <li id="point">:</li>
                <li id="sec"></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="breadcrumbs">
        <a href="<c:url value="/login"/> ">Главная</a>
    </div>
</div>

<div class="container-fluid">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true" title="should be app symbols"></form:input>
                <form:errors path="username"></form:errors>

                    <%--validation--%>
                <div class="alert alert-success hidden">
                    You have success
                </div>
                <div class="alert alert-danger hidden">
                    Something wrong in your sintax
                </div>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"
                            title="should be app symbols"></form:input>
                <form:errors path="password"></form:errors>

                    <%--validation--%>
                <div class="alert alert-success hidden">
                    You have success
                </div>
                <div class="alert alert-danger hidden">
                    Something wrong in your sintax
                </div>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="confirmPassword" class="form-control"
                            placeholder="Confirm your password" title="should be app symbols"></form:input>
                <form:errors path="confirmPassword"></form:errors>

                    <%--validation--%>
                <div class="alert alert-success hidden">
                    You have success
                </div>
                <div class="alert alert-danger hidden">
                    Something wrong in your sintax
                </div>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->

<%--FOOTER--%>
<jsp:include page="includes/footer.jsp" flush="false"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/validation.js"></script>
<script src="${contextPath}/resources/js/clock.js"></script>
</body>
</html>