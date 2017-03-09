<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 09.03.2017
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resources/style.css">
</head>
<body>
<header>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-2 col-sm-2">
                <img class="logo" src="${contextPath}/resource/img/test.jpg" alt="logo">
            </div>
            <div class="col-lg-10 col-sm-10">
                <p>Logout</p>
            </div>
        </div>
    </div>
</header>
<div class="container-fluid">

    <div class="row">
        <div class="col-lg-6">

            <!--форма для регистрации ивента-->
            <form  method="POST" action="">

                <h2 class="form-heading">Создание мероприятия</h2>

                <!--названия ивента-->
                <div class="form-group">
                    <label for="name">Name of event</label>
                    <input type="text" class="form-control" id="name">
                </div>

                <div class="form-group">
                    <label for="location">Location</label>
                    <input type="text" class="form-control" id="location">
                </div>

                <!--начальная дата-->
                <div class="form-group">
                    <label for="date-from">Name of event</label>
                    <input type="text" class="form-control" id="date-from">
                </div>

                <!--конечная дата-->
                <div class="form-group">
                    <label for="date-to">Name of event</label>
                    <input type="text" class="form-control" id="date-to">
                </div>

                <input type="submit" value="Сохранить">

            </form>

        </div>
        <div class="col-lg-6">
            <table>
                <tr>
                    <td>events list</td>
                </tr>
            </table>
        </div>
    </div>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
