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

                        <form action="/statistic/compare" method="get">
                            <div class="form-group">
                            <select class="selectpicker" name="eventId" id="event">
                                <c:forEach items="${events}" var="event">
                                    <option value="${event.id}">${event.name}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" id="sendEvent" class="btn btn-primary button" value="Apply"/>
                            </div>
                            <div class="form-group">
                                <select class="selectpicker" name="storeId" id="store">
                                    <c:forEach items="${stores}" var="store">
                                        <option value="${store.id}">${store.name}</option>
                                    </c:forEach>
                                </select>
                                <input type="submit" id="sendStore" class="btn btn-primary button" value="Apply"/>
                            </div>
                            <button class="btn btn-primary" id="compare">Compare</button>
                        </form>
                            <h2 class="panel-add">Items: ${amount}</h2>
                    </div>
                    <c:if test="${empty observations}">
                        There are no Event
                    </c:if>
                    <c:if test="${not empty observations}">
                        <table class="table table-hover table-bordered">
                            <thead style="background-color: #bce8f1;">
                                <tr>
                                    <th>id</th>
                                    <th>clientMac</th>
                                    <th>ipv4</th>
                                    <th>ipv6</th>
                                    <th>ssid</th>
                                    <th>os</th>
                                    <th>manufacturer</th>
                                    <th>rssi</th>
                                    <th>seenEpoch</th>
                                    <th>seenTime</th>
                                </tr>
                            </thead>
                            <c:forEach items="${observations}" var="observation">
                                <tr>
                                    <td>${observation.id}</td>
                                    <td>${observation.clientMac}</td>
                                    <td>${observation.ipv4}</td>
                                    <td>${observation.ipv6}</td>
                                    <td>${observation.ssid}</td>
                                    <td>${observation.os}</td>
                                    <td>${observation.manufacturer}</td>
                                    <td>${observation.rssi}</td>
                                    <td>${observation.seenEpoch}</td>
                                    <td>${observation.seenTime}</td>
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
//            $('#compare').click(function () {
//                var event = $('#event').val();
//                var store = $('#store').val();
//                $.ajax({
//                    type: "post",
//                    contentType: 'application/json',
//                    dataType: 'json',
//                    url: "/statistic/compare",
//                    data: {
//                        "eventId": JSON.stringify(event),
//                        "storeId": JSON.stringify(store)
//                    }
//                })
//            });
        </script>

    </jsp:body>
</t:dashboard>
</html>
