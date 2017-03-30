<%@ include file="/WEB-INF/tags/layout/includes.jsp" %>
<t:dashboard>


    <jsp:body>

        <h1>Hello.<c:out value="${user.username}"></c:out>, </h1>
        <p>You are in the application Cisco Meraki Analytics.</p>
        <b>Attention! The application is in the test mode, failures in work are possible.</b>
        <p>You can acquainte with basic functionality of our application:</p>
        <p>- An opportunity to create your personal events and obtain data about quantity of unique visitors.</p>
        <p>- To add shops for obtaining information about visiting of unique clients.</p>
        <p>- There is an opportunity to obtain detailed information about how many visitors of your event decided to
            visit your shop.</p>
        <p>- You can use Black list function for addition of devices which can interfere with receiving exact
            statistics.</p>
        <p></p>
        <p>Bonus! The application by itself analyzes passersby of people who are not your clients and by himself adds
            them to the black list when it's necessary.</p>


        <script>
            $(function () {
                $('#home').addClass('active');
            });
        </script>
    </jsp:body>
</t:dashboard>
</html>