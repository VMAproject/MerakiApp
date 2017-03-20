<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>
        <div class="container myrow-container">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Event Details
                    </h3>
                </div>
                <div class="panel-body">
                    <form:form id="eventForm" cssClass="form-horizontal" modelAttribute="event" method="post"
                               action="saveEvent">

                        <div class="form-group">
                            <div class="control-label col-xs-3">
                                <form:label path="name">Name</form:label></div>
                            <div class="col-xs-6">
                                <form:hidden path="id" value="${eventObject.id}"/>

                                <form:input cssClass="form-control" path="name" value="${eventObject.name}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="location" cssClass="control-label col-xs-3">location</form:label>
                            <div class="col-xs-6">
                                <form:input cssClass="form-control" path="location" value="${eventObject.location}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="dateFrom" cssClass="control-label col-xs-3">dateFrom</form:label>
                            <div class="col-xs-6">
                                <form:input type="date" cssClass="form-control" path="dateFrom"
                                            value="${eventObject.dateFrom}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="dateTo" cssClass="control-label col-xs-3">date To</form:label>
                            <div class="col-xs-6">
                                <form:input type="date" cssClass="form-control" path="dateTo"
                                            value="${eventObject.dateTo}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-xs-4">
                                </div>
                                <div class="col-xs-4">
                                    <input type="submit" id="saveEvent" class="btn btn-primary" value="Save"
                                           onclick="return submitEventForm();"/>
                                </div>
                                <div class="col-xs-4">
                                </div>
                            </div>
                        </div>

                    </form:form>
                </div>
            </div>
        </div>

        <script type="text/javascript">
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