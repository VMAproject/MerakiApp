<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>

    <jsp:body>

        <div class="container-fluid myrow-container">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">
                       Router Details
                    </h3>
                </div>
                <div class="panel-body">
                    <form:form id="routerForm" cssClass="form-horizontal" modelAttribute="router" method="post"
                               action="saveRouter">

                        <div class="form-group">
                            <div class="control-label col-xs-3">
                                <form:label path="routerName">Router Name</form:label></div>
                            <div class="col-xs-6">
                                <form:hidden path="id" value="${routerObject.id}"/>

                                <form:input cssClass="form-control" path="routerName"
                                            value="${routerObject.routerName}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="apMac" cssClass="control-label col-xs-3">apMac</form:label>
                            <div class="col-xs-6">
                                <form:input cssClass="form-control" path="apMac" value="${routerObject.apMac}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="control-label col-xs-3"><form:label path="event">Event</form:label></div>
                            <div class="col-xs-6">
                                <form:input cssClass="form-control" path="event" value="${routerObject.event}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-xs-4">
                                </div>
                                <div class="col-xs-4">
                                    <input type="submit" id="saveRouter" class="btn btn-primary" value="Save"
                                           onclick="return submitRouterForm();"/>
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
            function submitRouterForm() {

                // getting the employee form values
                var routerName = $('#routerName').val().trim();
                var apMac = $('#apMac').val();
                var event = $('#event').val();

                if (routerName.length == 0) {
                    alert('Please enter routerName');
                    $('#routerName').focus();
                    return false;
                }

                if (apMac <= 0) {
                    alert('Please enter apMac');
                    $('#apMac').focus();
                    return false;
                }

                if (event <= 0) {
                    alert('please enter event');
                    $('#event').focus();
                    return false
                }

                return true;
            }
        </script>

    </jsp:body>
</t:dashboard>
</html>