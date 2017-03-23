<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>

    <jsp:body>
        <div class="container-fluid myrow-container">
            <div class="form">
                <div class="panel-heading">
                    <div class="panel-title"><h1>Black Book List</h1></div>
                    <div class="panel-add"><a href="createBlackBook">Add New Appliance</a></div>
                </div>
                <div class="panel-body">
                    <c:if test="${empty blackBookList}">
                        There are no Event
                    </c:if>
                    <c:if test="${not empty blackBookList}">

                        <table class="table table-hover table-bordered">
                            <thead style="background-color: #bce8f1;">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>clientMac</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${blackBookList}" var="blackBook">
                                <tr>
                                    <td><c:out value="${blackBook.id}"/></td>
                                    <td><c:out value="${blackBook.name}"/></td>
                                    <td><c:out value="${blackBook.clientMac}"/></td>

                                    <td><a href="/editBlackBook?id=<c:out value='${blackBook.id}'/>">Edit</a></td>
                                    <td><a href="/deleteBlackBook?id=<c:out value='${blackBook.id}'/>">Delete</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>


        <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
         --%>
        <script>
            $(function () {
                $('#blackList').addClass('active');
            });
        </script>

    </jsp:body>
</t:dashboard>
</html>