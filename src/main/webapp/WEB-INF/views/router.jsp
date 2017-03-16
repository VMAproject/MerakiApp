<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Rooms Page</title>
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
    Add a Room
</h1>

<c:url var="addAction" value="/router/add"></c:url>

<form:form action="${addAction}" modelAttribute="router">
    <table>
        <c:if test="${!empty router.routerName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="eventId"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:hidden path="id"/>
                <form:hidden path="eventId"/>
            </td>
            <td>
                <form:label path="name">
                    <spring:message text="router Name"/><br/>
                </form:label>

            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty router.routerName}">
                    <input type="submit"
                           value="<spring:message text="Edit Router"/>"/>
                </c:if>
                <c:if test="${empty router.routerName}">
                    <input type="submit"
                           value="<spring:message text="Add Router"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>


<h3>Router List</h3>
<c:if test="${!empty routerList}">
    <table class="tg">
        <tr>
            <th width="80">Room ID</th>
            <th width="120">Router Name</th>
            <th width="120">Serial name</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${routerList}" var="routers">
            <tr>
                <td>${routers.routerId}</td>
                <td>${routers.routerName}</td>
                <td>${routers.serialNum}</td>
                <td><a href="<c:url value='/edit_router/${routers.routerId}' />">Edit</a></td>
                <td><a href="<c:url value='/film/${routers.routerId}/remove_filmRoom/${routers.routerId}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<br>
<br>
<a href="/events">Events list</a>

</body>
</html>
