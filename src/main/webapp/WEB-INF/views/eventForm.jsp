<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>
        <div class="container-fluid myrow-container">
            <div class="form">
                <div class="panel-body">
                    <div class="container panel-body-group">

                        <h2>Add Event</h2>
                            <%--<form action="createEvent" method="post">--%>
                        <form action="/createEvent" method="post">

                            <div class="panel-title panel-title_bottom"><h1>Event Details</h1></div>

                            <div class="form-group">
                                <label for="name">name:</label>
                                <input id="name" type="text" name="name"/>
                            </div>

                            <div class="form-group">
                                <label for="location">location:</label>
                                <input id="location" type="text" name="location"/></p>
                            </div>

                            <div class="form-group">
                                <select name="id">
                                    <c:forEach items="${allRouters}" var="router">
                                        <option value="${router.id}">${router.routerName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="dateFrom">dateFrom:</label>
                                <div class='input-group date' id='datetimepicker1'>
                                    <input id="dateFrom" type="date" name="dateFrom"/></p>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="dateTo">dateTo:</label>
                                <div class='input-group date' id='datetimepicker2'>
                                    <input id="dateTo" type="date" name="dateTo"/></p>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>

                            <div class="form-group">
                                <input type="submit" id="saveEvent" class="btn btn-primary button" value="Save"/>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $(function () {
                $('#event').addClass('active');
            });
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