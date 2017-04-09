<%@tag description="iTrack Layout" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="sidebar" fragment="true" %>
<%@attribute name="contentHeader" fragment="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>IssueTracking System</title>

    <!-- adding favicon -->
    <link rel="apple-touch-icon" sizes="57x57" href="${contextPath}
        /resources/images/favicon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="${contextPath}
        /resources/images/favicon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="${contextPath}
        /resources/images/favicon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="${contextPath}
        /resources/images/favicon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="${contextPath}
        /resources/images/favicon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="${contextPath}
        /resources/images/favicon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="${contextPath}
        /resources/images/favicon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="${contextPath}
        /resources/images/favicon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="${contextPath}
        /resources/images/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="${contextPath}
        /resources/images/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${contextPath}
        /resources/images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="${contextPath}
        /resources/images/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${contextPath}
        /resources/images/favicon/favicon-16x16.png">
    <link rel="manifest" href="${contextPath}
        /resources/images/favicon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">

    <link rel=icon href=favicon.png sizes="16x16" type="image/png">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/resources/css/AdminLTE.css">
    <!-- AdminLTE Skins
    -->
    <link rel="stylesheet" href="/resources/css/skins/skin-black-light.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/event.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/home.css"/>

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
    <!-- REQUIRED JS SCRIPTS -->

    <!-- jQuery 2.1.4 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <!-- Bootstrap 3.3.7 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="/resources/js/app.min.js"></script>
    <script src="/resources/js/faq.js"></script>
    <script src="/resources/js/validationAddForm.js"></script>

    <script src="https://momentjs.com/downloads/moment-with-locales.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <jsp:invoke fragment="header"/>
</head>
<body class="hold-transition skin-black-light sidebar-collapse">
<%--<c:url var="index" value="/" />--%>
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="/" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini">
            <img src="${contextPath}/resources/images/Sava-04.png" alt="logo">
          </span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg">
            <img src="${contextPath}/resources/images/Sava-04.png" alt="logo">
          </span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">

                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="/resources/images/faq/avatar.png" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">${user.username}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="/resources/images/faq/avatar.png" class="img-circle" alt="User Image">
                                <p>
                                    You are logged in as ${user.role.rolename}
                                    <small>Member since ${user.regdate}</small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="center-block">
                                    <a href='<c:url value="/logout"></c:url>' class="btn btn-default btn-flat">Sign
                                        out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="/resources/images/faq/avatar.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${user.firstName} ${user.lastName}</p>
                    <!-- Status -->
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- search form (Optional) -->
            <%--<form action="#" method="get" class="sidebar-form">--%>
                <%--<div class="input-group">--%>
                    <%--<input type="text" name="q" class="form-control" placeholder="Search...">--%>
                    <%--<span class="input-group-btn">--%>
                            <%--<button type="submit" name="search" id="search-btn" class="btn btn-flat"><i--%>
                                    <%--class="fa fa-search"></i></button>--%>
                          <%--</span>--%>
                <%--</div>--%>
            <%--</form>--%>
            <!-- /.search form -->

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu">
                <li id="home"><a href="<c:url value='/' />"><i class="fa fa-link"></i><span>Home</span></a></li>
                <!--             <li class="treeview">
                              <a href="#"><i class="fa fa-link"></i> <span>Multilevel</span> <i class="fa fa-angle-left pull-right"></i></a>
                              <ul class="treeview-menu">
                                <li><a href="#">Link in level 2</a></li>
                                <li><a href="#">Link in level 2</a></li>
                              </ul>
                            </li> -->
                <li id="event"><a href="<c:url value='/events/all' />"/><i
                        class="fa fa-list-alt"></i><span>Events</span></a>
                </li>
                <li id="shop"><a href="<c:url value='/stores/all' />"/><i
                        class="fa fa-shopping-cart"></i><span>Stores</span></a>
                </li>
                <li id="statistic"><a href="<c:url value='/statistic/all' />"/><i
                        class="fa fa-pie-chart"></i><span>Statistic</span></a>
                </li>
                <li id="router"><a href="<c:url value='/routers/all' />"/><i
                        class="fa fa-signal"></i><span>Access Points</span></a>
                </li>
                <li id="blackList"><a href="<c:url value='/getAllBlackBookLists' />"/><i
                        class="fa fa-file-text"></i><span>Black list</span></a>
                </li>


            </ul><!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <jsp:invoke fragment="contentHeader"/>
        </section>

        <!-- Main content -->
        <section class="content">

            <!-- Your Page Content Here -->
            <jsp:doBody/>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- Default to the left -->
        <jsp:invoke fragment="footer"/>
        Copyright &copy; 2017 by Verlamov Michail, Matushkin Rostyslav, Tsymbalenko Oleksandr, Mikhaylik Denis.
        All rights reserved.
    </footer>
</div><!-- ./wrapper -->


<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->

<!--FAQ-->
<div class="b-popup" id="popup1">
    <div class="b-popup-content">
        <input type="button" onclick="PopUpToggle()" class="great_btn">

        <div class="section">
            <ol>
                <li>
                    <div id="WindowsVista">
                        <div class="altblock" id=""><label class="method_label">Method</label> <span>1</span>
                        </div>
                        <span class="faqheader">Windows Vista, 7 или 8</span>
                    </div>
                    <img src="/resources/images/faq/windowsVista_1.webp">
                    <div class="section-description">
                        <div class="step_num">1</div>
                        <b>Connect to the network. </b>
                        This method will work only if you are actively connected to an interface that
                        needs a MAC address (Wi-Fi if you need a MAC address for a wireless card, Ethernet
                        if you need a MAC address for a wired card).
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/WindowsVista_2.webp">
                    <div class="section-description">
                        <div class="step_num">2</div>
                        <b>Click the connection icon in the system tray. </b>
                        It can look like a small graph (see figure) or as a small computer monitor.
                        From the menu, select "Open Network and Sharing Center".
                        <ul>
                            <li>In Windows 8, open the desktop. Then right-click the connection icon in the system tray.
                                From the menu, select "Network and Sharing Center".
                            </li>
                        </ul>
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/WindowsVista_3.webp">
                    <div class="section-description">
                        <div class="step_num">3</div>
                        <b>In the "Connections" row, find the name of your network connection and click on it. </b>
                        A new window will open.
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/WindowsVista_4.webp">
                    <div class="section-description">
                        <div class="step_num">4</div>
                        <b>Click "Details". </b>
                        The connection information is displayed (similar to the one displayed when
                        you enter the IPConfig command on the command line).
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/WindowsVista_5.webp">
                    <div class="section-description">
                        <div class="step_num">5</div>
                        <b>Find the line "Physical Address". </b>
                        It shows your MAC address.
                    </div>
                </li>
            </ol>
        </div>

        <div class="section">
            <ol>
                <li>
                    <div class="altblock"><label class="method_label">Method</label> <span>2</span>
                    </div>
                    <span class="faqheader">Windows 98 and Xp</span>
                    <img src="/resources/images/faq/WindowsXP_1.webp">
                    <div class="section-description">
                        <div class="step_num">1</div>
                        <b>Connect to the network. </b>
                        This method will work only if you are actively connected to an interface that
                        needs a MAC address (Wi-Fi if you need a MAC address for a wireless card, Ethernet
                        if you need a MAC address for a wired card).
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/WindowsXp_2.webp">
                    <div class="section-description">
                        <div class="step_num">2</div>
                        <b>Open "Network Connections". </b>
                        If the desktop icon does not have a "Network Connections" icon, locate it in the taskbar
                        (in the lower right corner of the Windows toolbar) and click it.
                        <ul>
                            <li>Or, click Start - Control Panel - Network Connections.</li>
                        </ul>
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/WindowsXp_3.webp">
                    <div class="section-description">
                        <div class="step_num">3</div>
                        <b>Right click on the active connection and select "Status" from the menu. </b>
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/WindowsXp_4.webp">
                    <div class="section-description">
                        <div class="step_num">4</div>
                        <b>Click "Details" (in some versions of Windows, you first need to go
                            to the "Support" tab). </b>
                        The connection information is displayed (similar to the one displayed when you
                        enter the IPConfig command on the command line).
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/WindowsXp_5.webp">
                    <div class="section-description">
                        <div class="step_num">5</div>
                        <b>Find the line "Physical address". </b>
                        It shows your MAC address.
                    </div>
                </li>
            </ol>
        </div>

        <div class="section">
            <ol>
                <li>
                    <div class="altblock"><label class="method_label">Method</label> <span>3</span>
                    </div>
                    <span class="faqheader">Any version of Windows</span>
                    <img src="/resources/images/faq/WindowsAnyWind_1.webp">
                    <div class="section-description">
                        <div class="step_num">1</div>
                        <b>Open a command prompt. </b>
                        o do this, press ⌘ Win + R and in the window that opens, enter cmd.
                        Press ⌅ Enter.
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/WindowsAnyWind_2.webp">
                    <div class="section-description">
                        <div class="step_num">2</div>
                        <b>Run GetMAC. </b>
                        At the command prompt, type "getmac / v / fo" list and press ⌅ Enter.
                        Information about all network connections is displayed.
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/WindowsAnyWind_3.webp">
                    <div class="section-description">
                        <div class="step_num">3</div>
                        <b>Find the line "Physical Address". </b>
                        It shows your MAC address. Make sure that this is the physical
                        address of the network adapter you need (usually several physical addresses are displayed,
                        for example, separately for wireless connection and separately for connection via Ethernet).
                    </div>
                </li>
            </ol>
        </div>

        <div class="section">
            <ol>
                <li>
                    <div class="altblock"><label class="method_label">Method</label> <span>4</span>
                    </div>
                    <span class="faqheader">Linux</span>
                    <img src="/resources/images/faq/Linux_1.webp">
                    <div class="section-description">
                        <div class="step_num">1</div>
                        <b>Open the terminal by pressing Ctrl + Alt + T. </b>
                        Depending on the system, the terminal can be named Terminal, Xterm, Shell,
                        Command Prompt, or something like that.
                    </div>
                </li>
                <li>
                    <img src="resources/images/faq/Linux_2.webp">
                    <div class="section-description">
                        <div class="step_num">2</div>
                        <b>Open the interface configuration. </b>
                        Type ifconfig -a and press ⌅ Enter. If this does not work, type sudo ifconfig -a,
                        press ⌅ Enter and enter the password.
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/Linux_3.webp">
                    <div class="section-description">
                        <div class="step_num">3</div>
                        <b>Find the network connection (the connection via Ethernet is called eth0). </b>
                        Find the string "HWaddr", in which the MAC address is specified.
                    </div>
                </li>
            </ol>
        </div>

        <div class="section">
            <ol>
                <li>
                    <div class="altblock"><label class="method_label">Method</label> <span>5</span>
                    </div>
                    <span class="faqheader">Mac 10-4 (Tiger) and older versions</span>
                    <img src="/resources/images/faq/Mac10-4_1.webp">
                    <div class="section-description">
                        <div class="step_num">1</div>
                        <b>Open System Preferences. </b>
                        Click the Apple icon (in the upper-left corner of the screen) and click System Preferences.
                        Make sure you are connected to the network.
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/Mac10-4_2.webp">
                    <div class="section-description">
                        <div class="step_num">2</div>
                        <b>Select "Network". </b>
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/Mac10-4_3.webp">
                    <div class="section-description">
                        <div class="step_num">3</div>
                        <b>In the drop-down menu "Show" select the connection: </b>
                        Either "Ethernet" or "AirPort".
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/Mac10-4_4.webp">
                    <div class="section-description">
                        <div class="step_num">4</div>
                        <b>Go to the "Ethernet" tab or the "AirPort" tab. </b>
                        Find the string "Ethernet ID" or "AirPort ID" in which
                        the MAC address is specified.
                    </div>
                </li>
            </ol>
        </div>

        <div class="section">
            <ol>
                <li>
                    <div class="altblock"><label class="method_label">Method</label> <span>6</span>
                    </div>
                    <span class="faqheader">Mac 10-4 (Leopard) and new versions</span>
                    <img src="/resources/images/faq/Mac10-5_1.webp">
                    <div class="section-description">
                        <div class="step_num">1</div>
                        <b>Open System Preferences. </b>
                        Click the Apple icon (in the upper-left corner of the screen) and click "System Preferences".
                        Make sure you are connected to the network.
                    </div>
                </li>
                <li>
                    <img src="/resources/images/faq/Mac10-5_2.webp">
                    <div class="section-description">
                        <div class="step_num">2</div>
                        <b>Select the connection. </b>
                        Select "Network", then "AirPort" or "Ethernet" (depending on how you connect to the network).
                        <ul>
                            <li>In the case of Ethernet, click "Advanced" and go to the "Ethernet" tab. At the top you will
                                see the line "Ethernet ID", in which the MAC-address is indicated.</li>
                            <li>In the case of AirPort, click "Advanced" and click the "AirPort" tab. You will see the line
                                "AirPort ID", in which the MAC address is specified.</li>
                        </ul>
                    </div>
                </li>
            </ol>
        </div>
    </div>
</div>
</body>
</html>
