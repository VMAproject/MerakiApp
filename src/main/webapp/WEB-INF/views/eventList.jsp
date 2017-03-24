<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>

        <p><a href="/">Back to main page</a>
        <p><a href="/events">Events page</a>

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
                    <td><a href="/editEvent?id=<c:out value='${event.id}'/>">Edit</a></td>
                    <td><a href="/deleteEvent?id=<c:out value='${event.id}'/>">Delete</a></td>

                </tr>
            </c:forEach>
        </table>


        <%--<div class="container-fluid myrow-container">--%>
        <%--<div class="form">--%>
        <%--<div class="panel-heading">--%>
        <%--<div class="panel-title"><h1>Events</h1></div>--%>
        <%--<div class="panel-add"><a href="createEvent">Add New Event</a></div>--%>


        <%--<p><a href="/events">Events page</a>--%>
        <%--</div>--%>
        <%--<div class="panel-body">--%>
        <%--<c:if test="${empty eventList}">--%>
        <%--There are no Event--%>
        <%--</c:if>--%>
        <%--<c:if test="${not empty eventList}">--%>

        <%--<form action="/searchEvent">--%>
        <%--<div class="row">--%>
        <%--<div class="col-md-6">--%>
        <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<label for="searchName">Search Event:</label>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="text" class="form-control" name="searchName" id="searchName"/>&ndash;%&gt;--%>
        <%--&lt;%&ndash;&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--<div class="input-group bottom-space">--%>
        <%--<input type="text" class="form-control" placeholder="Search for...">--%>
        <%--<span class="input-group-btn">--%>
        <%--<input class="btn btn-primary" type='submit' value='Search'/>--%>
        <%--</span>--%>
        <%--</div><!-- /input-group -->--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</form>--%>

        <%--<table class="table table-hover table-bordered">--%>
        <%--<thead style="background-color: #bce8f1;">--%>
        <%--<tr>--%>
        <%--<th>Id</th>--%>
        <%--<th>Name</th>--%>
        <%--<th>location</th>--%>
        <%--<th>Date From</th>--%>
        <%--<th>Date To</th>--%>
        <%--&lt;%&ndash;<th>Router</th>&ndash;%&gt;--%>
        <%--<th>Edit</th>--%>
        <%--<th>Delete</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<tbody>--%>
        <%--<c:forEach items="${eventList}" var="event">--%>
        <%--<tr>--%>
        <%--<td><c:out value="${event.id}"/></td>--%>
        <%--<td><c:out value="${event.name}"/></td>--%>
        <%--<td><c:out value="${event.location}"/></td>--%>
        <%--<td><c:out value="${event.dateFrom}"/></td>--%>
        <%--<td><c:out value="${event.dateTo}"/></td>--%>
        <%--<td><a href="/editEvent?id=<c:out value='${event.id}'/>">Edit</a></td>--%>
        <%--<td><a href="/deleteEvent?id=<c:out value='${event.id}'/>">Delete</a></td>--%>
        <%--</tr>--%>
        <%--</c:forEach>--%>
        <%--</tbody>--%>
        <%--</table>--%>
        <%--</c:if>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--<script>--%>
        <%--$(function () {--%>
        <%--$('#event').addClass('active');--%>
        <%--});--%>
        <%--</script>--%>

    </jsp:body>
</t:dashboard>
</html>