<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>

        <div class="container-fluid myrow-container">
            <div class="form">
                <div class="panel-heading">
                    <div class="panel-title"><h1>Events</h1></div>
                    <div class="panel-add"><a href="/events/add">Add New Event</a></div>
                </div>
                <div class="panel-body">
                    <c:if test="${empty events}">
                        There are no Event
                    </c:if>
                    <c:if test="${not empty events}">

                        <table class="table table-hover table-bordered">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>location</th>
                                <th>Date From</th>
                                <th>Date To</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${events}" var="event">
                                <tr>
                                    <td>${event.id}</td>
                                    <td>${event.name}</td>
                                    <td>${event.location}</td>
                                    <td>${event.dateFrom.toString()}</td>
                                    <td>${event.dateTo.toString()}</td>
                                    <td><a href="/events/edit?id=<c:out value='${event.id}'/>">Edit</a></td>
                                    <td><a href="/events/delete?id=<c:out value='${event.id}'/>">Delete</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>

        <script>
            $(function () {
                $('#event').addClass('active');
            });
        </script>

    </jsp:body>
</t:dashboard>
</html>