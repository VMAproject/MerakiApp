<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>

    <div class="container-fluid myrow-container">
        <div class="form">
            <div class="panel-body">
                <div class="container panel-body-group">

                    <form action="/events/createOrUpdate" method="get" class="adding-form">

                        <div class="panel-title panel-title_bottom"><h1>Event Details</h1></div>
                        <input type="hidden" value="${eventId}" name="eventId"/>
                        <div class="form-group">
                            <label for="name"><span class="form-group_red">* </span> name:</label>
                            <input id="name" class="form-control" type="text" name="name" value="${eventName}"/>
                        </div>

                        <div class="form-group">
                            <label for="location"><span class="form-group_red">* </span>location:</label>
                            <input id="location" class="form-control" type="text" name="location" value="${eventLocation}"/>
                        </div>

                        <div class="form-group">
                            <label for="dateFrom"><span class="form-group_red">* </span>dateFrom:</label>
                            <input id="dateFrom" type="date" class="form-control" name="dateFrom" value="${eventDateFrom}"/>
                        </div>

                        <div class="form-group">
                            <label for="dateTo"><span class="form-group_red">* </span>dateTo:</label>
                            <input id="dateTo" type="date" class="form-control" name="dateTo" value="${eventDateTo}"/></p>
                        </div>

                        <div class="form-group">
                            <label for="id"><span class="form-group_red">* </span>router:</label>
                            <c:if test="${not empty routers}">
                                <select class="selectpicker form-control" name="routerId" id="id">
                                    <c:forEach items="${routers}" var="router">
                                        <option value="${router.id}">${router.routerName}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                            <c:if test="${empty routers}">
                                <p class="error">You haven't available routers</p>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <p><span class="form-group_red">* </span> - Required field</p>
                        </div>

                        <div class="form-group">
                            <input type="submit" id="saveEvent" class="btn btn-primary button incorrect" value="Save"/>
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

</t:dashboard>
</html>