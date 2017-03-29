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

                    <form action="/stores/create" method="get">

                        <div class="panel-title panel-title_bottom"><h1>Store Details</h1></div>

                        <div class="form-group">
                            <label for="name">name:</label>
                            <input id="name" class="form-control" type="text" name="name"/>
                        </div>

                        <div class="form-group">
                            <label for="location">location:</label>
                            <input id="location" class="form-control" type="text" name="location"/></p>
                        </div>

                        <div class="form-group">
                            <select class="selectpicker" name="id">
                                <c:forEach items="${routers}" var="router">
                                    <option value="${router.id}">${router.routerName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <input type="submit" id="saveStore" class="btn btn-primary button" value="Save"/>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        $(function () {
            $('#shop').addClass('active');
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

            var name = $('#name').val().trim();
            var location = $('#location').val();

            if (name <= 0) {
                alert('Please enter name');
                $('#name').focus();
                return false;
            }

            if (location <= 0) {
                alert('Please enter location');
                $('#location').focus();
                return false;
            }

            return true;
        }
    </script>

</t:dashboard>
</html>