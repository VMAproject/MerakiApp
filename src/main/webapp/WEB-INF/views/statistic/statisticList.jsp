
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
                            <%--<c:forEach items="${routersList}" var="router">--%>
                                <%--<option value="${router.id}">${router.routerName}</option>--%>
                            <%--</c:forEach>--%>
                                <option value="first">First</option>
                        </select>
                    </div>
                    <c:if test="${empty statistics}">
                        There are no Event
                    </c:if>
                    <c:if test="${not empty statistics}">

                        <form action="">


                        </form>
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
