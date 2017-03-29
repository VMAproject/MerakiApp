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
        <link rel="icon" type="image/png" sizes="192x192"  href="${contextPath}
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
        <!-- Bootstrap 3.3.5 -->
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="/resources/css/AdminLTE.css">
        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
              page. However, you can choose any other skin. Make sure you
              apply the skin class to the body tag so the changes take effect.
        -->
        <link rel="stylesheet" href="/resources/css/skins/skin-black-light.css">

        <link rel="stylesheet" href="${contextPath}/resources/css/event.css">

        <link rel="stylesheet" href="${contextPath}/resources/css/home.css"/>

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"/>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
        <!-- REQUIRED JS SCRIPTS -->

        <!-- jQuery 2.1.4 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <!-- Bootstrap 3.3.5 -->
        <script src="/resources/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="/resources/js/app.min.js"></script>
        <script src="/resources/js/faq.js"></script>

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
    <!--
    BODY TAG OPTIONS:
    =================
    Apply one or more of the following classes to get the
    desired effect
    |---------------------------------------------------------|
    | SKINS         | skin-blue                               |
    |               | skin-black                              |
    |               | skin-purple                             |
    |               | skin-yellow                             |
    |               | skin-red                                |
    |               | skin-green                              |
    |---------------------------------------------------------|
    |LAYOUT OPTIONS | fixed                                   |
    |               | layout-boxed                            |
    |               | layout-top-nav                          |
    |               | sidebar-collapse                        |
    |               | sidebar-mini                            |
    |---------------------------------------------------------|
    -->
    <body class="hold-transition skin-black-light sidebar-collapse">
        <%--<c:url var="index" value="/" />--%>
        <div class="wrapper">

            <!-- Main Header -->
            <header class="main-header">

                <!-- Logo -->
                <a href="#" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini">
            <img src="${contextPath}/resources/images/faq/CiscoMeraki.png" alt="logo">
          </span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg">
            <img src="${contextPath}/resources/images/faq/CiscoMeraki.png" alt="logo">
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
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                            <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i
                                    class="fa fa-search"></i></button>
                          </span>
                        </div>
                    </form>
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
                        <li id="router"><a href="<c:url value='/routers/all' />"/><i
                                class="fa fa-signal"></i><span>Routers</span></a>
                        </li>
                        <li id="statistic"><a href="<c:url value='/statistic/all' />"/><i
                                class="fa fa-pie-chart"></i><span>Statistic</span></a>
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
        <div class="b-popup" id="popup1">
            <div class="b-popup-content">
                <input type="button" onclick="PopUpToggle()" class="great_btn">
                <div class="container">
                    <img src="${contextPath}/resources/images/faq/Android_1.webp" alt="Android-step1">
                </div>
                <div class="container">
                    <b>Подключитесь к сети</b>
                    Это способ будет работать только при активном подключении к интерфейсу, который нуждается
                    в МАС-адресе (Wi-Fi, если вам нужен MAC-адрес карты беспроводной связи; Ethernet, если вам
                    нужен MAC-адрес проводной карты).
                </div>
                <div class="container">
                    <img src="${contextPath}/resources/images/faq/Android_2.webp" alt="Android-step2">
                </div>
            </div>
        </div>
    </body>
</html>
