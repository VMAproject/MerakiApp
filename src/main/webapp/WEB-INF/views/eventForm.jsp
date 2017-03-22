<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>
        <div class="container-fluid myrow-container">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Event Details
                    </h3>
                </div>
                <div class="panel-body">
                    <form:form id="eventForm" cssClass="form-horizontal" modelAttribute="event" method="post"
                               action="saveEvent">
                        <div class="container panel-body-group">
                            <div class="form-group">
                                <form:label path="name">Name</form:label>
                                <form:hidden path="id" value="${eventObject.id}"/>
                                <form:input cssClass="form-control" path="name" value="${eventObject.name}"/>
                            </div>
                            <div class="form-group">
                                <form:label path="location" cssClass="control-label">Location</form:label>
                                <form:input cssClass="form-control" path="location" value="${eventObject.location}"/>
                            </div>
                            <div class="form-group">
                                <label for="routerId" class="control-label">Router Id</label>
                                <input type="text" name="idr" class="form-control" id="routerId"/>
                                    <%--<form:label path="" cssClass="control-label col-xs-3">RouterID</form:label>--%>
                                    <%--<div class="col-xs-6">--%>
                                    <%--<form:input type="text" cssClass="form-control" path="routerId"--%>
                                    <%--value="${eventObject.routers}"/>--%>
                                    <%--</div>--%>
                            </div>
                            <div class="form-group">
                                <div class='input-group date' id='datetimepicker1'>
                                    <form:label path="dateFrom" cssClass="control-label">dateFrom</form:label>
                                    <form:input cssClass="form-control" path="dateFrom"
                                                value="${eventObject.dateFrom}"/>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class='input-group date' id='datetimepicker2'>
                                    <form:label path="dateTo" cssClass="control-label">dateTo</form:label>
                                        <form:input cssClass="form-control" path="dateTo"
                                        value="${eventObject.dateTo}"/>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" id="saveEvent" class="btn btn-primary button" value="Save"
                                       onclick="return submitEventForm();"/>
                            </div>

                        <%--<div class="form-group">--%>
                            <%--<form:label path="dateFrom" cssClass="control-label col-xs-3">dateFrom</form:label>--%>
                            <%--<div class="col-xs-6">--%>
                                <%--<form:input cssClass="form-control" path="dateFrom"--%>
                                            <%--value="${eventObject.dateFrom}"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="form-group">--%>
                            <%--<form:label path="dateTo" cssClass="control-label col-xs-3">date To</form:label>--%>
                            <%--<div class="col-xs-6">--%>
                                <%--<form:input cssClass="form-control" path="dateTo"--%>
                                            <%--value="${eventObject.dateTo}"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                    </form:form>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker({
                    locale: 'ru'
                });
            });
            $(function () {
                $('#datetimepicker2').datetimepicker({
                    locale: 'ru'
                });
            });
            function submitEventForm() {

                // getting the employee form values
                var name = $('#name').val().trim();
                var location = $('#location').val();
                var dateFrom = $('#dateFrom').val();
                var dateTo = $('#dateTo').val();

                if (name.length == 0) {
                    alert('Please enter name');
                    $('#name').focus();
                    return false;
                }

                if (location <= 0) {
                    alert('Please enter location');
                    $('#location').focus();
                    return false;
                }

                if (dateFrom <= 0) {
                    alert('please enter date from');
                    $('#dateFrom').focus();
                    return false;
                }

                if (dateTo.length <= 0) {
                    alert('please enter date to');
                    $('#dateTo').focus();
                    return false;
                }
                return true;
            }
        </script>

    </jsp:body>
</t:dashboard>
</html>