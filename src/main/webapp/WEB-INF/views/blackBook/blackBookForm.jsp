<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>

    <jsp:body>
        <div class="container-fluid myrow-container">
            <div class="form">
                <div class="panel-body">
                    <div class="container panel-body-group">
                        <form:form id="blackBookForm" cssClass="form-horizontal adding-form" modelAttribute="blackBook"
                                   method="post"
                                   action="saveBlackBook">
                            <div class="panel-title panel-title_bottom"><h1>Black List Details</h1></div>
                            <div class="form-group">
                                <form:label path="name"><span class="form-group_red">* </span>name</form:label>
                                <form:hidden path="id" value="${blackBookObject.id}"/>
                                <form:input cssClass="form-control" path="name" value="${blackBookObject.name}"/>
                            </div>
                            <div class="form-group">
                                <form:label path="clientMac" cssClass="control-label"><span
                                        class="form-group_red">* </span>
                                    clientMac</form:label>
                                <form:input cssClass="form-control" path="clientMac"
                                            value="${blackBookObject.clientMac}"/>
                            </div>
                            <div class="form-group">
                                <p><span class="form-group_red">* </span> - Required field</p>
                            </div>
                            <div class="form-group">
                                <input type="submit" id="saveBlackBook" class="btn btn-primary button incorrect"
                                       value="Save"/>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $(function () {
                $('#blackList').addClass('active');
            });
            //            function submitBlackBookForm() {
            //
            //                // getting the employee form values
            //                var name = $('#name').val().trim();
            //                var clientMac = $('#clientMac').val();
            ////        var salary = $('#salary').val();
            //                if (name.length == 0) {
            //                    alert('Please enter name');
            //                    $('#name').focus();
            //                    return false;
            //                }
            //
            //                if (clientMac <= 0) {
            //                    alert('Please enter clientMac');
            //                    $('#clientMac').focus();
            //                    return false;
            //                }
            //
            //                return true;
            //            }
        </script>

    </jsp:body>
</t:dashboard>
</html>