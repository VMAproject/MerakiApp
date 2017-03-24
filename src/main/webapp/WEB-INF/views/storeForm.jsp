<%--
  Created by IntelliJ IDEA.
  User: Verlamov
  Date: 23.03.17
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>

    <p><a href="/">Back to main page</a>
    <p><a href="/stores/all">Look all Events</a>

    <h2>Add Event</h2>
    <form action="/storesname">name:</label>
    <input id="name" type="text" name="name"/></p>

    <p><label for="location">location:</label>
    <input id="location" type="text" name="location"/></p>

    <select name="id">
    <c:forEach items="${allRouters}" var="router">
        <option value="${router.id}">${router.routerName}</option>
    </c:forEach>
    </select>

    <p><input type="submit" value="Add"/></p>
    </form>
</body>
</html>
