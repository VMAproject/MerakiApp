<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>

        <h1>Welcome <c:out value="${user.username}"></c:out>, </h1>
        <p>This is sample Miraki Project</p>
        <p> We hope your visit will help you understand the opportunities
            and potential rewards that are available when you use this application
        </p>
        <p>This is a close project</p>

        <%--<a href="<c:url value='/getAllEventLists' />">Goto Events</a>--%>
        <%--<a href="<c:url value='/getAllRouterLists' />">Goto Routers</a>--%>
        <%--<a href="<c:url value='/getAllBlackBookLists' />">Goto Black List</a>--%>

        <script>
            $(function () {
                $('#home').addClass('active');
            });
        </script>
    </jsp:body>
</t:dashboard>
</html>