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
                    <div class="panel-title"><h1>All Stores</h1></div>
                    <div class="panel-add"><a href="/stores/add">Add New Store</a></div>
                </div>
                <div class="panel-body">
                    <c:if test="${empty stores}">
                        There are no Event
                    </c:if>
                    <c:if test="${not empty stores}">

                        <table class="table table-hover table-bordered">
                            <thead>
                            <tr>
                                <th>id</th>
                                <th>name</th>
                                <th>location</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${stores}" var="store">
                            <tr>
                                <td>${store.id}</td>
                                <td>${store.name}</td>
                                <td>${store.location}</td>

                                <td><a href="/stores/edit?id=<c:out value='${store.id}'/>">Edit</a></td>
                                <td><a href="/stores/delete?id=<c:out value='${store.id}'/>">Delete</a></td>

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