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
                        <div align="left"><b>Router List</b></div>
                        <div align="right"><a href="createRouter">Add New router</a></div>
                    </h3>
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
                                <th>EVENT</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${routerList}" var="router">
                                <tr>
                                    <th><c:out value="${router.id}"/></th>
                                    <th><c:out value="${router.apMac}"/></th>
                                    <th><c:out value="${router.routerName}"/></th>
                                    <th><c:out value="${router.event}"/></th>
                                        <%--<th><c:out value="${event.router.id}"/></th>--%>
                                    <th><a href="/editRouter?id=<c:out value='${router.id}'/>">Edit</a></th>
                                    <th><a href="/deleteRouter?id=<c:out value='${router.id}'/>">Delete</a></th>
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