
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>
        <div class="container-fluid myrow-container">
            <div class="breadcrumbs">
                <a href="/">Back to main page</a>
            </div>
            <div class="form">
                <div class="panel-heading">
                    <div class="panel-title"><h1>Statistics</h1></div>
                    <div class="panel-add"><a href="#">Add Statistic if need</a></div>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <select class="selectpicker" name="id">
                            <c:forEach items="${events}" var="event">
                                <option value="${event.id}">${event.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <c:if test="${empty observations}">
                        There are no Event
                    </c:if>
                    <c:if test="${not empty observations}">
                        <table class="table table-hover table-bordered">
                            <thead style="background-color: #bce8f1;">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>location</th>
                                <th>Date From</th>
                                <th>Date To</th>
                            </tr>
                            </thead>
                            <c:forEach items="${events}" var="event">
                                <tr>
                                    <td>${event.id}</td>
                                    <td>${event.name}</td>
                                    <td>${event.location}</td>
                                    <td>${event.dateFrom.toString()}</td>
                                    <td>${event.dateTo.toString()}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>

        <script>
            $(function () {
                $('#statistic').addClass('active');
            });
        </script>

    </jsp:body>
</t:dashboard>
</html>
