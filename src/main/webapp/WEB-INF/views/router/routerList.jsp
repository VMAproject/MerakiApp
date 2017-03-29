<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>

    <jsp:body>
        <div class="container-fluid myrow-container">
            <div class="form">
                <div class="panel-heading">
                    <div class="panel-title"><h1>Routers</h1></div>
                    <%--<div class="panel-add"><a href="createRouter">Add New Router</a></div>--%>
                </div>
                <div class="panel-body">
                    <c:if test="${empty routerList}">
                        There are no Router
                    </c:if>
                    <c:if test="${not empty routerList}">


                        <table class="table table-hover table-bordered">
                            <thead style="background-color: #bce8f1;">
                            <tr>
                                <th>Id</th>
                                <th>apMac</th>
                                <th>RouterName</th>
                                <%--<th>Edit</th>--%>
                                <%--<th>Delete</th>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${routerList}" var="router">
                                <tr>
                                    <td><c:out value="${router.id}"/></td>
                                    <td><c:out value="${router.apMac}"/></td>
                                    <td><c:out value="${router.routerName}"/></td>
                                    <%--<td><a href="/editRouter?id=<c:out value='${router.id}'/>">Edit</a></td>--%>
                                    <%--<td><a href="/deleteRouter?id=<c:out value='${router.id}'/>">Delete</a></td>--%>
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
                $('#router').addClass('active');
            });
        </script>

    </jsp:body>
</t:dashboard>
</html>