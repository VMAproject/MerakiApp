<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign in Login</title>

    <!-- adding favicon -->
    <link rel="apple-touch-icon" sizes="57x57" href="${contextPath}
        /resources/images/favicon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="${contextPath}
        /resources/images/favicon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="${contextPath}
        /resources/images/favicon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="${contextPath}
        /resources/images/favicon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="${contextPath}
        /resources/images/favicon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="${contextPath}
        /resources/images/favicon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="${contextPath}
        /resources/images/favicon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="${contextPath}
        /resources/images/favicon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="${contextPath}
        /resources/images/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="${contextPath}
        /resources/images/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${contextPath}
        /resources/images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="${contextPath}
        /resources/images/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${contextPath}
        /resources/images/favicon/favicon-16x16.png">
    <link rel="manifest" href="${contextPath}
        /resources/images/favicon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value='/resources/css/login/login.css' />" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Dosis" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resources/css/login/dscountdown.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/login/timer.css"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/funtions/login.js' />"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</head>

<body>

<%--header--%>
<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
    <img class="logo logo_left" src="${contextPath}/resources/images/faq/CiscoMeraki.png"
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

<%--countdown--%>
<div class="countdown">
    <div class="start">
        <h1>ДО ЗАПУСКА ПРОЕКТА ОСТАЛОСЬ</h1>
    </div>
    <div class="demo1"></div>
</div>

<div class="login-page">
    <div class="form">
        <font color="red">
				<span style="align: center">
					<c:if test="${not empty param['error']}">
                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                    </c:if>
				</span>
        </font>
        <form class="register-form" id="registerForm" action="#" method="post">
            <div class="username">
                <input type="text" placeholder="name" id="username" autocomplete="off"/>
                <%--validation--%>
                <div class="alert alert-success hidden">
                    You have success
                </div>
                <div class="alert alert-danger hidden">
                    Something wrong in your sintax
                </div>
            </div>
            <div class="password">
                <input type="password" placeholder="password" id="password"/>
                <%--validation--%>
                <div class="alert alert-success hidden">
                    You have success
                </div>
                <div class="alert alert-danger hidden">
                    Something wrong in your words
                </div>
            </div>
            <div class="email">
                <input type="email" placeholder="email address" id="email" autocomplete="off"/>
                <%--validation--%>
                <div class="alert alert-success hidden">
                    You have success
                </div>
                <div class="alert alert-danger hidden">
                    Something wrong in your sintax
                </div>
            </div>
            <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
            <input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
            <button>create</button>
            <p class="message">Already registered? <a href="#" onclick="toggle_visibility(); return false;"
                                                      class="message">Sign In</a></p>
        </form>
        <form class="login-form" action="<c:url value='/login' />" method="post">
            <input type="text" name="username" placeholder="username" autocomplete="off"/>
            <input type="password" name="password" placeholder="password"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button>log in</button>
            <p class="message">Not registered? <a href="#" onclick="toggle_visibility(); return false;" class="message">Create
                an account</a></p>
        </form>
    </div>
</div>

<%--FOOTER--%>
<footer class="footer">
    <div class="container-fluid footer_bottom">
        <p class="text-muted">Copyright &copy; 2017 by Verlamov Michail, Matushkin Rostyslav, Tsymbalenko Oleksandr,
            Mikhaylik Denis.
            All rights reserved.</p>
    </div>
</footer>

<script src="${contextPath}/resources/js/clock.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/dscountdown.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/startCountdown.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/validation.js"></script>
</body>
</html>