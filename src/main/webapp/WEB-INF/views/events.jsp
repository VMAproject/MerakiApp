<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Dosis" rel="stylesheet">
</head>
<body>

<%--header--%>
<jsp:include page="includes/header.jsp" flush="false"/>

<div class="container-fluid">

    <%--форма добавления ивентов--%>
    <c:url var="addAction" value="/events/add"/>

    <div class="row">
        <div class="col-lg-offset-1 col-lg-3">

            <%--раздел с breadcrumbs--%>
            <div class="breadcrumbs">
                <a href="<c:url value="/welcome"/> "> в главное меню</a>
            </div>

            <c:url var="addAction" value="/events/add"/>

            <!--форма для регистрации ивента-->
            <form:form action="${addAction}" commandName="event">

                <h2 class="form-heading">Создание мероприятия</h2>

                <!--id event-->
                <c:if test="${!empty event.id}">
                    <div class="form-group">
                        <label for="name">
                            <form:label path="id">
                                <spring:message text="ID"/>
                            </form:label>
                        </label>
                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="id"/>
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

                <%--<!--начальная дата-->--%>
                <%--<div class="form-group">--%>
                <%--&lt;%&ndash;@declare id="date-from"&ndash;%&gt;<label for="date-from">--%>
                <%--<form:label path="dateFrom">--%>
                <%--<spring:message text="DateFrom"/>--%>
                <%--</form:label>--%>
                <%--</label>--%>
                <%--<form:input class="form-control" path="dateFrom"/>--%>
                <%--</div>--%>

                <%--<!--конечная дата-->--%>
                <%--<div class="form-group">--%>
                <%--&lt;%&ndash;@declare id="date-to"&ndash;%&gt;<label for="date-to">--%>
                <%--<form:label path="dateTo">--%>
                <%--<spring:message text="DateTo"/>--%>
                <%--</form:label>--%>
                <%--</label>--%>
                <%--<form:input class="form-control" path="dateTo"/>--%>
                <%--</div>--%>

                <c:if test="${!empty event.id}">
                    <input type="submit" class="btn btn-primary"
                           value="<spring:message text="Edit event"/>"/>
                </c:if>

                <%--<td><a href="<c:url value='/edites/${event.id}'/> ">EDIT</a></td>--%>
                <c:if test="${empty event.id}">
                    <input type="submit" class="btn btn-primary"
                           value="<spring:message text="Add event"/>"/>
                </c:if>
            </form:form>
        </div>

        <div class="col-lg-offset-1 col-lg-6">
            <div class="header">
                <h2>ADDING EVENTS</h2>
            </div>

            <%--таблица для вывода ивентов--%>
            <c:if test="${!empty listEvent}">
                <table class="table table-bordered">
                    <tr>
                        <thead class="thead">
                            <th width="80">id</th>
                            <th width="120">Name</th>
                            <th width="120">Location</th>
                            <th width="120">RouterName</th>
                            <%--<th width="120">date_from</th>--%>
                            <%--<th width="120">date_to</th>--%>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </thead>
                    </tr>
                    <c:forEach items="${listEvent}" var="event">
                        <tr>
                            <td>${event.id}</td>
                            <td>${event.name}</td>
                            <td>${event.location}</td>
                            <td>${event.router.routerName}</td>
                                <%--<td>${event.dateFrom}</td>--%>
                                <%--<td>${event.dateTo}</td>--%>

                            <td><a href="<c:url value='/edit/${event.id}'/> ">EDIT</a></td>
                            <td><c:url var="updateLink" value="/remove/">
                                <c:param name="eventId" value="${event.id}"/>
                            </c:url>
                                <a href="${updateLink}">delete</a></td>
                                <%--<td><a href="<c:url value='/remove/${event.id}}'/>">Delete</a></td>--%>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>

    </div>
</div>

<%--footer--%>
<jsp:include page="includes/footer.jsp" flush="false"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
