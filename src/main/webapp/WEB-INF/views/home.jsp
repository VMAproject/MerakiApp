<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>

        <h1>welcome <c:out value="${user.username}"></c:out>, </h1>
        <p>This is sample Miraki Project</p>
        <p><b>note :</b> If you wanna use it you should ask cool guys
            who wrote this site pages
            otherwise every time you'll hang out something may happen wrong:))
        </p>
        <p>This is a close project</p>

        <a href="<c:url value='/getAllEventLists' />">Goto Events</a>
        <a href="<c:url value='/getAllRouterLists' />">Goto Routers</a>
        <a href="<c:url value='/getAllBlackBookLists' />">Goto Black List</a>

    </jsp:body>
</t:dashboard>
</html>