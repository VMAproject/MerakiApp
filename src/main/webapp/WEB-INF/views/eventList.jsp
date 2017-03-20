<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>
        <div class="container myrow-container">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <div align="left"><b>Employees List</b></div>
                        <div align="right"><a href="createEvent">Add New Event</a></div>
                    </h3>
                </div>
                <div class="panel-body">
                    <c:if test="${empty eventList}">
                        There are no Event
                    </c:if>
                    <c:if test="${not empty eventList}">

                        <form action="/searchEvent">
                            <div class="row">
                                <div class="col-md-6">
                                    <%--<div class="form-group">--%>
                                        <%--<label for="searchName">Search Event:</label>--%>
                                        <%--<input type="text" class="form-control" name="searchName" id="searchName"/>--%>
                                        <%----%>
                                    <%--</div>--%>
                                        <div class="input-group bottom-space">
                                            <input type="text" class="form-control" placeholder="Search for...">
                                            <span class="input-group-btn">
                                                <input class="btn btn-success" type='submit' value='Search'/>
                                            </span>
                                        </div><!-- /input-group -->
                                </div>
                            </div>
                        </form>

                        <table class="table table-hover table-bordered">
                            <thead style="background-color: #bce8f1;">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>location</th>
                                <th>Date From</th>
                                <th>Date To</th>
                                    <%--<th>Router</th>--%>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${eventList}" var="event">
                                <tr>
                                    <th><c:out value="${event.id}"/></th>
                                    <th><c:out value="${event.name}"/></th>
                                    <th><c:out value="${event.location}"/></th>
                                    <th><c:out value="${event.dateFrom}"/></th>
                                    <th><c:out value="${event.dateTo}"/></th>
                                        <%--<th><c:out value="${event.routers}"/></th>--%>
                                    <th><a href="/editEvent?id=<c:out value='${event.id}'/>">Edit</a></th>
                                    <th><a href="/deleteEvent?id=<c:out value='${event.id}'/>">Delete</a></th>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>

    </jsp:body>
</t:dashboard>
</html>