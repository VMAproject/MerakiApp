<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page session="false" %>


<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 09.03.2017
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
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

<div class="container-fluid">

    <%--раздел с breadcrumbs--%>
    <div class="breadcrumbs">
        <a href="<c:url value="/welcome"/> "> в главное меню</a>
    </div>

    <%--форма добавления ивентов--%>
    <div class="container header">
        <h1>ADDING EVENTS</h1>
    </div>
    <c:url var="addAction" value="/events/add"/>

    <div class="row">
        <div class="col-lg-5">

            <c:url var="addAction" value="/events/add"/>

            <!--форма для регистрации ивента-->
            <form:form action="${addAction}" commandName="event">

                <h2 class="form-heading">Создание мероприятия</h2>

                    <!--id event-->
                <c:if test="${!empty event.name}">
                    <div class="form-group">
                        <label for="name">
                            <form:label path="eventId">
                                <spring:message text="ID"/>
                            </form:label>
                        </label>
                        <form:input path="eventId" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="eventId"/>
                    </div>
                </c:if>

                    <!--названия ивента-->
                    <div class="form-group">
                        <label for="name">
                            <form:label path="name">
                                <spring:message text="Name"/>
                            </form:label>
                        </label>
                        <form:input class="form-control" path="name"/>
                    </div>

                    <div class="form-group">
                        <label for="location">
                            <form:label path="location">
                                <spring:message text="Location"/>
                            </form:label>
                        </label>
                        <form:input class="form-control" path="location"/>
                    </div>

                    <!--начальная дата-->
                    <div class="form-group">
                        <label for="date-from">
                            <form:label path="dateFrom">
                                <spring:message text="DateFrom"/>
                            </form:label>
                        </label>
                        <form:input class="form-control" path="dateFrom"/>
                    </div>

                    <!--конечная дата-->
                    <div class="form-group">
                        <%--@declare id="date-to"--%><label for="date-to">
                            <form:label path="dateTo">
                                <spring:message text="DateTo"/>
                            </form:label>
                        </label>
                        <form:input class="form-control" path="dateTo"/>
                    </div>

                <c:if test="${!empty event.name}">
                    <input type="submit" class="btn btn-primary"
                           value="<spring:message text="Edit event"/>"/>
                </c:if>
                <c:if test="${empty event.name}">
                    <input type="submit" class="btn btn-primary"
                           value="<spring:message text="Add event"/>"/>
                </c:if>
            </form:form>
        </div>

        <div class="col-lg-offset-1 col-lg-6">

            <h2>Event List</h2>
            <table>
                <tr>
                    <td>events list</td>
                </tr>

            </table>

            <%--таблица для вывода ивентов--%>
            <c:if test="${!empty listEvent}">
                <table>
                    <tr>
                        <th width="80">id</th>
                        <th width="120">Name</th>
                        <th width="120">location</th>
                        <th width="120">date_from</th>
                        <th width="120">date_to</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listEvent}" var="event">
                        <tr>
                            <td>${event.eventId}</td>
                            <td>${event.name}</td>
                            <td>${event.location}</td>
                            <td>${event.dateFrom}</td>
                            <td>${event.dateTo}</td>
                            <td><a href="<c:url value='/edit/${event.eventId}'/> ">EDIT</a></td>
                            <td><a href="<c:url value='/remove/${event.eventId}}'/>">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
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
