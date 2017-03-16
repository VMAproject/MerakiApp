<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div class="generic-container">
    <div class="well lead">ADD EVENT Form</div>
    <form:form method="POST" modelAttribute="event" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="location">location</label>
                <div class="col-md-7">
                    <form:input type="text" path="location" id="location" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="location" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <%--<div class="row">--%>
        <%--<div class="form-group col-md-12">--%>
        <%--<label class="col-md-3 control-lable" for="lastName">Last Name</label>--%>
        <%--<div class="col-md-7">--%>
        <%--<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />--%>
        <%--<div class="has-error">--%>
        <%--<form:errors path="lastName" class="help-inline"/>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">name</label>
                <div class="col-md-7">
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" path="name" id="name" class="form-control input-sm"
                                        disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="name" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

        <%--<div class="row">--%>
        <%--<div class="form-group col-md-12">--%>
        <%--<label class="col-md-3 control-lable" for="password">Password</label>--%>
        <%--<div class="col-md-7">--%>
        <%--<form:input type="password" path="password" id="password" class="form-control input-sm" />--%>
        <%--<div class="has-error">--%>
        <%--<form:errors path="password" class="help-inline"/>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row">--%>
        <%--<div class="form-group col-md-12">--%>
        <%--<label class="col-md-3 control-lable" for="email">Email</label>--%>
        <%--<div class="col-md-7">--%>
        <%--<form:input type="text" path="email" id="email" class="form-control input-sm" />--%>
        <%--<div class="has-error">--%>
        <%--<form:errors path="email" class="help-inline"/>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="router">ROUTERS</label>
                <div class="col-md-7">
                    <form:select path="router" items="${router}" multiple="true" itemValue="id" itemLabel="type"
                                 class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="router" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/list' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/list' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>