<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>

    <jsp:body>
        <div class="container-fluid myrow-container">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <div class="panel-title"><b>Statictic</b></div>
                    <div class="panel-add"><a href="getAllObservationUniqueLists">getAllObservationUniqueLists</a></div>
                </div>
                <div class="panel-body">
                    <c:if test="${empty observationList}">
                        There are no Observation
                    </c:if>
                    <c:if test="${not empty observationList}">


                        <table class="table table-hover table-bordered">
                            <thead style="background-color: #bce8f1;">
                            <tr>
                                <th>Id</th>
                                <th>client Mac</th>
                                <th>ipv4</th>
                                <th>ipv6</th>
                                <th>ssid</th>
                                <th>os</th>
                                <th>manufacturer</th>
                                <th>rssi</th>
                                <th>seenEpoch</th>
                                <th>seenTime"</th>
                                    <%--<th>routerID</th>--%>
                                    <%--<th>Edit</th>--%>
                                    <%--<th>Delete</th>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${observationList}" var="observation">
                                <tr>
                                    <td><c:out value="${observation.id}"/></td>
                                    <td><c:out value="${observation.clientMac}"/></td>
                                    <td><c:out value="${observation.ipv4}"/></td>
                                    <td><c:out value="${observation.ipv6}"/></td>
                                    <td><c:out value="${observation.ssid}"/></td>
                                    <td><c:out value="${observation.os}"/></td>
                                    <td><c:out value="${observation.manufacturer}"/></td>
                                    <td><c:out value="${observation.rssi}"/></td>
                                    <td><c:out value="${observation.seenEpoch}"/></td>
                                    <td><c:out value="${observation.seenTime}"/></td>
                                        <%--<td><c:out value="${observation.router}"/></td>--%>

                                        <%--<th><c:out value="${event.router.id}"/></th>--%>
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

    </jsp:body>
</t:dashboard>
</html>
