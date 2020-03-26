<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top_admin.jsp"/>

        <section id="content" class="table-layout animated fadeIn">
            <div class="tray tray-center">
                <div class="content-header">
                    <h2> 个人信息 </h2>
                    <p class="lead"></p>
                </div>
                <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
                    <div class="panel heading-border">
                        <div class="panel-body bg-light">
                            <div class="section-divider mt20 mb40">
                                <span> 基本信息 </span>
                            </div>
                            <div class="section row">
                                <div class="col-md-2">用户名</div>
                                <div class="col-md-4">${sessionScope.admin.admin_number}</div>
                            </div>
                            <div class="section row">
                                <div class="col-md-2">姓名</div>
                                <div class="col-md-4">${sessionScope.admin.admin_name}</div>
                                <div class="col-md-2">性别</div>
                                <div class="col-md-4">${sessionScope.admin.admin_sex}</div>
                            </div>
                            <div class="section row">
                                <div class="col-md-2">电子邮箱</div>
                                <div class="col-md-4">${sessionScope.admin.admin_email}</div>
                                <div class="col-md-2">管理权限</div>
                                <div class="col-md-4">${sessionScope.admin.admin_root}</div>
                            </div>
                            <div class="panel-footer text-right">
                                <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

<jsp:include page="bottom_admin.jsp"/>