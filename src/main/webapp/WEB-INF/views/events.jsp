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
    <link rel="stylesheet" href="${contextPath}/resources/style.css">
</head>
<body>
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

    <a href="<c:url value="/welcome"/> "target="_blank"> в главное меню</a>

    <br/>
    <br/>

    <h1>Event List</h1>

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

    <h1>add Event</h1>
    <c:url var="addAction" value="/events/add"/>

    <form:form action="${addAction}" commandName="event">
        <table>
            <c:if test="${!empty event.name}">
                <tr>
                    <td>
                        <form:label path="eventId">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>

                    <td>
                        <form:input path="eventId" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="eventId"/>
                    </td>
                </tr>
            </c:if>


            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="location">
                        <spring:message text="Location"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="location"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="dateFrom">
                        <spring:message text="DateFrom"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="dateFrom"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="dateTo">
                        <spring:message text="DateTo"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="dateTo"/>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <c:if test="${!empty event.name}">
                        <input type="submit"
                               value="<spring:message text="Edit Book"/>"/>
                    </c:if>
                    <c:if test="${empty event.name}">
                        <input type="submit"
                               value="<spring:message text="Add Book"/>"/>
                    </c:if>
                </td>
            </tr>

        </table>
    </form:form>


    <%--<div class="row">--%>
    <%--<div class="col-lg-6">--%>

    <%--<!--форма для регистрации ивента-->--%>
    <%--<form  method="POST" action="">--%>

    <%--<h2 class="form-heading">Создание мероприятия</h2>--%>

    <%--<!--названия ивента-->--%>
    <%--<div class="form-group">--%>
    <%--<label for="name">Name of event</label>--%>
    <%--<input type="text" class="form-control" id="name">--%>
    <%--</div>--%>

    <%--<div class="form-group">--%>
    <%--<label for="location">Location</label>--%>
    <%--<input type="text" class="form-control" id="location">--%>
    <%--</div>--%>

    <%--<!--начальная дата-->--%>
    <%--<div class="form-group">--%>
    <%--<label for="date-from">Name of event</label>--%>
    <%--<input type="text" class="form-control" id="date-from">--%>
    <%--</div>--%>

    <%--<!--конечная дата-->--%>
    <%--<div class="form-group">--%>
    <%--<label for="date-to">Name of event</label>--%>
    <%--<input type="text" class="form-control" id="date-to">--%>
    <%--</div>--%>

    <%--<input type="submit" value="Сохранить">--%>

    <%--</form>--%>

    <%--</div>--%>
    <div class="col-lg-6">
        <table>
            <tr>
                <td>events list</td>
            </tr>
        </table>
    </div>
</div>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
