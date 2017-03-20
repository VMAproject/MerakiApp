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
                        Black book Details
                    </h3>
                </div>
                <div class="panel-body">
                    <form:form id="blackBookForm" cssClass="form-horizontal" modelAttribute="blackBook" method="post"
                               action="saveBlackBook">

                        <div class="form-group">
                            <div class="control-label col-xs-3">
                                <form:label path="name">Name</form:label></div>
                            <div class="col-xs-6">
                                <form:hidden path="id" value="${blackBookObject.id}"/>

                                <form:input cssClass="form-control" path="name" value="${blackBookObject.name}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="clientMac" cssClass="control-label col-xs-3">clientMac</form:label>
                            <div class="col-xs-6">
                                <form:input cssClass="form-control" path="clientMac"
                                            value="${blackBookObject.clientMac}"/>
                            </div>
                        </div>

                        <%--<div class="form-group">--%>
                        <%--<div class="control-label col-xs-3"><form:label path="salary">Salary</form:label></div>--%>
                        <%--<div class="col-xs-6">--%>
                        <%--<form:input cssClass="form-control" path="salary" value="${employeeObject.salary}"/>--%>
                        <%--</div>--%>
                        <%--</div>--%>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-xs-4">
                                </div>
                                <div class="col-xs-4">
                                    <input type="submit" id="saveBlackBook" class="btn btn-primary" value="Save"
                                           onclick="return submitBlackBookForm();"/>
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
            function submitBlackBookForm() {

                // getting the employee form values
                var name = $('#name').val().trim();
                var clientMac = $('#clientMac').val();
//        var salary = $('#salary').val();
                if (name.length == 0) {
                    alert('Please enter name');
                    $('#name').focus();
                    return false;
                }

                if (clientMac <= 0) {
                    alert('Please enter clientMac');
                    $('#clientMac').focus();
                    return false;
                }

//        if(salary <= 0) {
//            alert('Please enter proper salary');
//            $('#salary').focus();
//            return false;
//        }
                return true;
            }
        </script>

    </jsp:body>
</t:dashboard>
</html>