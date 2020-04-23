<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from admindesigns.com/demos/absolute/1.1/admin_forms-validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 06 Aug 2015 02:56:15 GMT -->
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">

    <title> 便携式安防系统 </title>

    <link rel="stylesheet" type="text/css" href="../assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="../assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="../assets/img/favicon.ico">
</head>

<body class="admin-validation-page" data-spy="scroll" data-target="#nav-spy" data-offset="200">
<div id="main">
    <header class="navbar navbar-fixed-top navbar-shadow">
        <div class="navbar-branding">
            <a class="navbar-brand" href="dashboard.html">
                <b>操作模块</b>
            </a>
            <span id="toggle_sidemenu_l" class="ad ad-lines"></span>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown menu-merge">
                <a href="#" class="dropdown-toggle fw600 p15" data-toggle="dropdown">
                    <img src="../assets/img/avatars/22.jpg" alt="avatar" class="mw30 br64">
                    <span class="hidden-xs pl15"> 用户 </span>
                    <span class="caret caret-tp hidden-xs"></span>
                </a>
                <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
                    <li class="list-group-item">
                        <a href="/graduationproject/login/self" class="animated animated-short fadeInUp">
                            <span class="fa fa-user"></span> 个人信息
                            <span class="label label-warning"></span>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <a href="/graduationproject/login/to_change_password" class="animated animated-short fadeInUp">
                            <span class="fa fa-gear"></span> 设置密码 </a>
                    </li>
                    <li class="dropdown-footer">
                        <a href="/graduationproject/login/users_quit" class="">
                            <span class="fa fa-power-off pr5"></span> 退出 </a>
                    </li>
                </ul>
            </li>
        </ul>
    </header>
    <aside id="sidebar_left" class="nano nano-light affix">
        <div class="sidebar-left-content nano-content">
            <header class="sidebar-header">
                <div class="sidebar-widget author-widget">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img src="../assets/img/avatars/33.jpg" class="img-responsive">
                        </a>
                        <div class="media-body">
                            <div class="media-author">用户</div>
                            <div class="media-links">
                                <a href="/graduationproject/login/users_quit">退出</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sidebar-widget search-widget hidden">
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-search"></i>
                        </span>
                        <input type="text" id="sidebar-search" class="form-control" placeholder="Search...">
                    </div>
                </div>
            </header>
            <ul class="nav sidebar-menu">
                <li class="sidebar-label pt20">个人设置</li>
                <li class="active">
                    <a href="/graduationproject/comfortable/self">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">舒适环境区间</span>
                        <span class="sidebar-title-tray">
                        </span>
                    </a>
                </li>
                <li class="active">
                    <a href="/graduationproject/userSet/self">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">移动端设置</span>
                    </a>
                </li>
                <li class="sidebar-label pt15">记录</li>
                <li class="active">
                    <a href="/graduationproject/environment/list_users">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">环境记录</span>
                    </a>
                </li>
                <li class="active">
                    <a href="/claim_voucher/self">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">操作日志查询</span>
                    </a>
                </li>
                <li class="sidebar-label pt15">管理互动</li>
                <li class="active">
                    <a href="/graduationproject/information/list_users">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">通知信息</span>
                    </a>
                </li>
                <li class="active">
                    <a href="/graduationproject/opinion/list_users">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">意见反馈</span>
                    </a>
                </li>
            </ul>
            <div class="sidebar-toggle-mini">
                <a href="#">
                    <span class="fa fa-sign-out"></span>
                </a>
            </div>
        </div>
    </aside>
    <section id="content_wrapper">