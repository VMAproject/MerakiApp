<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>

        <p><a href="/">Back to main page</a>
        <p><a href="/stores/add">Add store</a>

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