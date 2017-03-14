<%--
  Created by IntelliJ IDEA.
  User: Verlamov
  Date: 14.03.17
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Routers</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"/>
</head>
<body>

<%--header--%>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>


    <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
        <img class="logo" src="${contextPath}/resources/img/CiscoMeraki.png"
             alt="logo">
        <div class="greeting right">
            <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">
                <span class="greeting-logout">Logout</span></a>
        </div>
    </nav>
</c:if>

<%--таблица для вывода роутеров --%>
<c:if test="${!empty listRouter}">
    <div class="container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Serial Number</th>
            </tr>
            </thead>
            <c:forEach items="${listRouter}" var="router">
                <tr>
                    <td>${router.id}</td>
                    <td>${router.serialNum}</td>
                    <td>${router.routerName}</td>
                        <%--<td>${event.dateFrom}</td>--%>
                        <%--<td>${event.dateTo}</td>--%>

                        <%--<td><a href="<c:url value='/edit/${event.id}'/> ">EDIT</a></td>--%>
                        <%--<td><c:url var="updateLink" value="/remove/">--%>
                        <%--<c:param name="eventId" value="${event.id}"/>--%>
                        <%--</c:url>--%>
                        <%--<a href="${updateLink}">delete</a></td>--%>
                        <%--<td><a href="<c:url value='/remove/${event.id}}'/>">Delete</a></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>

<%--footer--%>
<footer class="footer">
    <div class="container">
        <p class="text-muted">sashkoi1234@gmail.com</p>
    </div>
</footer>

</body>
</html>
