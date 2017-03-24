<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Events page</title>
    </head>
    <body>

        <p><a href="/">Back to main page</a>
        <p><a href="createEvent">Look all Events</a>

        <h2>Add Event</h2>
        <form action="/events/add" method="post">

            <p><label for="name">name:</label>
                <input id="name" type="text" name="name"/></p>

            <p><label for="location">location:</label>
                <input id="location" type="text" name="location"/></p>

            <p><label for="dateFrom">dateFrom:</label>
                <input id="dateFrom" type="date" name="dateFrom"/></p>

            <p><label for="dateTo">dateTo:</label>
                <input id="dateTo" type="date" name="dateTo"/></p>

            <select name="id">
                <c:forEach items="${allRouters}" var="router">
                    <option value="${router.id}">${router.routerName}</option>
                </c:forEach>
            </select>

            <p><input type="submit" value="Add"/></p>
        </form>
    </body>
</html>
