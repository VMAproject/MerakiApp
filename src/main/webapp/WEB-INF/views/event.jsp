<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>EVENT Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1>
    Add a EVENT
</h1>

<c:url var="addAction" value="/event/add"></c:url>

<form:form action="${addAction}" modelAttribute="event">
    <table>
        <c:if test="${!empty event.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>

        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="name">--%>
                    <%--<spring:message text="Name"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:input path="name"/>--%>
            <%--</td>--%>
        <%--</tr>--%>

        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="location">--%>
                    <%--<spring:message text="location"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:input path="location"/>--%>
            <%--</td>--%>
        <%--</tr>--%>

        <tr>
            <td colspan="2">
                <c:if test="${!empty event.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Event"/>"/>
                </c:if>
                <c:if test="${empty event.name}">
                    <input type="submit"
                           value="<spring:message text="Add Event"/>"/>
                </c:if>
            </td>
        </tr>
    </table>

    <br>

</form:form>
<h3>Event List</h3>
<c:if test="${!empty eventList}">
    <table class="tg">
        <tr>
            <th width="80"> ID</th>
            <th width="120"> Name</th>
            <th width="120"> location</th>
            <th width="120"> Routers</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${eventList}" var="event">
            <tr>
                <td>${event.eventId}</td>
                <td>${event.name}</td>
                <td>${event.location}</td>
                <td><a href="<c:url value='/router/${event.eventId}' />">View Router</a></td>
                <td><a href="<c:url value='/edit/${event.eventId}' />">Edit</a></td>
                <td><a href="<c:url value='/remove/${event.eventId}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
