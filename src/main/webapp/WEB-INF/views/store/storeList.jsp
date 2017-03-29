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
                    <div class="panel-add"><a href="/stores/add">Add Store</a></div>
                </div>
                <div class="panel-body">
                    <c:if test="${empty eventsList}">
                        There are no Event
                    </c:if>
                    <c:if test="${not empty eventsList}">

                        <form action="/searchEvent">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group bottom-space">
                                        <input type="text" class="form-control" placeholder="Search for...">
                                        <span class="input-group-btn">
                                            <input class="btn btn-primary" type='submit' value='Search'/>
                                        </span>
                                    </div><!-- /input-group -->
                                </div>
                            </div>
                        </form>

                        <h2>All Stores</h2>
                        <table border="1">
                            <tr>
                                <th>id</th>
                                <th>name</th>
                                <th>location</th>
                            </tr>
                            <c:forEach items="${stores}" var="store">
                                <tr>
                                    <td>${store.id}</td>
                                    <td>${store.name}</td>
                                    <td>${store.location}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <table border="1">
                            <tr>
                                <th>id</th>
                                <th>name</th>
                                <th>location</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                            <c:forEach items="${allStores}" var="store">
                                <tr>
                                    <td>${store.id}</td>
                                    <td>${store.name}</td>
                                    <td>${store.location}</td>

                                    <td><a href="/editStore?id=<c:out value='${event.id}'/>">Edit</a></td>
                                    <td><a href="/deleteStore?id=<c:out value='${event.id}'/>">Delete</a></td>

                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>

        <script>
            $(function () {
                $('#shop').addClass('active');
            });
        </script>
    </jsp:body>
</t:dashboard>
</html>