<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top_admin.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 新建通知 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/graduationproject/information/add" modelAttribute="information"  id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 新建通知 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="time" class="field prepend-icon">
                                    <form:input path="time" value="${information.time}" cssClass="gui-input" placeholder="时间" readonly="true"/>
                                    <label for="time" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="admin_number" class="field prepend-icon">
                                    <form:input path="admin_number" value="${information.admin_number}" cssClass="gui-input" placeholder="管理员" readonly="true"/>
                                    <label for="admin_number" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="information" class="field prepend-icon">
                                    <form:input path="information" cssClass="gui-input" placeholder="通知内容" />
                                    <label for="information" class="field-icon">
                                        <i class="fa fa-book"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
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

<jsp:include page="bottom_admin.jsp"/>