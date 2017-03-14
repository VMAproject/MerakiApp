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
</head>
<body>

<%--таблица для вывода роутеров --%>
<c:if test="${!empty listEvent}">
    <table>
        <tr>
            <th width="80">id</th>
            <th width="120">Name</th>
            <th width="120">Serial Number</th>
                <%--<th width="120">date_from</th>--%>
                <%--<th width="120">date_to</th>--%>
            <%--<th width="60">Edit</th>--%>
            <%--<th width="60">Delete</th>--%>
        </tr>
        <c:forEach items="${listEvent}" var="event">
            <tr>
                <td>${event.id}</td>
                <td>${event.name}</td>
                <td>${event.location}</td>
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
</c:if>
</body>
</html>
