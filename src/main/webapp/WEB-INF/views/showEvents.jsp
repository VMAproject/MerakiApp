<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>All Events</title>
    </head>
    <body>
        <p><a href="/">Back to main page</a>
        
        <h2>All Events</h2>
        <table border="1">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>location</th>
                <th>dateFrom</th>
                <th>dateTo</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${allEvents}" var="event">
                <tr>
                    <td>${event.id}</td>
                    <td>${event.name}</td>
                    <td>${event.location}</td>
                    <td>${event.dateFrom.toString()}</td>
                    <td>${event.dateTo.toString()}</td>
                    <td><a href="/events/update/${event.id}">Update</a></td>
                    <td><a href="/events/remove/${event.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
