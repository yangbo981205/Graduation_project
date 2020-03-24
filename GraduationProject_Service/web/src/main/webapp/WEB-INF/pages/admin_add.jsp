<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="admin_top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 添加管理员 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/graduationproject/admin/add" modelAttribute="admin"  id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 添加管理员 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="admin_number" class="field prepend-icon">
                                    <form:input path="admin_number" cssClass="gui-input" placeholder="number"/>
                                    <label for="admin_number" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="admin_password" class="field prepend-icon">
                                    <form:input path="admin_password" cssClass="gui-input" placeholder="密码" />
                                    <label for="admin_password" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="admin_name" class="field prepend-icon">
                                    <form:input path="admin_name" cssClass="gui-input" placeholder="姓名" />
                                    <label for="admin_name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="admin_sex" class="field select">
                                    <form:select path="admin_sex" items="${select_sex}" cssClass="gui-input" placeholder="性别" />
                                    <i class="arrow double"></i>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="admin_email" class="field prepend-icon">
                                    <form:input path="admin_email" cssClass="gui-input" placeholder="邮箱" />
                                    <label for="admin_email" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section">
                                <div class="col-md-6">
                                    <label for="admin_root" class="field select">
                                        <form:select path="admin_root" items="${select_root}" cssClass="gui-input" placeholder="管理员权限等级" />
                                        <i class="arrow double"></i>
                                    </label>
                                </div>
                            </div>
                        </div>

<%--                        <div class="panel-footer text-left ml20">--%>
<%--                            <div>权限级别说明：</div>--%>
<%--                            <div>0 无权限</div>--%>
<%--                            <div>1 超级管理员</div>--%>
<%--                            <div>2 超级管理员</div>--%>
<%--                            <div>3 超级管理员</div>--%>
<%--                            <div>4 超级管理员</div>--%>
<%--                            <div>5 超级管理员</div>--%>
<%--                        </div>--%>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="admin_bottom.jsp"/>