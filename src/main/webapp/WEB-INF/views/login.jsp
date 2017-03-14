<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/registration.css" rel="stylesheet">
    <%--для отсчетов countdown<link rel="stylesheet" href="${contextPath}/css/styles.css" />--%>
    <%--<link rel="stylesheet" href="${contextPath}/countdown/jquery.countdown.css" />--%>


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

<div class="container-fluid">

    <%--countdown--%>
    <div id="countdown" class="countdownHolder">
	<span class="countDays">
		<span class="position">
			<span class="digit static"></span>
		</span>
		<span class="position">
			<span class="digit static"></span>
		</span>
	</span>

        <span class="countDiv countDiv0"></span>

        <span class="countHours">
		<span class="position">
			<span class="digit static"></span>
		</span>
		<span class="position">
			<span class="digit static"></span>
		</span>
	</span>

        <span class="countDiv countDiv1"></span>

        <span class="countMinutes">
		<span class="position">
			<span class="digit static"></span>
		</span>
		<span class="position">
			<span class="digit static"></span>
		</span>
	</span>

        <span class="countDiv countDiv2"></span>

        <span class="countSeconds">
		<span class="position">
			<span class="digit static"></span>
		</span>
		<span class="position">
			<span class="digit static"></span>
		</span>
	</span>

        <span class="countDiv countDiv3"></span>
    </div>

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span class="success">${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>

</div>
<!-- /container -->

<%--FOOTER--%>
<jsp:include page="includes/footer.jsp" flush="false"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/clock.js"></script>
</body>
</html>