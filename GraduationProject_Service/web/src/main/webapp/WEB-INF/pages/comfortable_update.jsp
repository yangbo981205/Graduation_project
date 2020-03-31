<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top_users.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 修改 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/graduationproject/comfortable/update" modelAttribute="comfortable"  id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 修改适宜环境信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <div class="col-md-4">用户名:</div>
                                <div class="section-divider"></div>
                                <label for="username" class="field prepend-icon">
                                    <form:input path="username" cssClass="gui-input" placeholder="用户名" readonly="true"/>
                                    <label for="username" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <div class="col-md-4">最高温度:</div>
                                <div class="section-divider"></div>
                                <label for="max_temperature" class="field prepend-icon">
                                    <form:input path="max_temperature" cssClass="gui-input" placeholder="最高温度" />
                                    <label for="max_temperature" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <div class="col-md-4">最低温度:</div>
                                <div class="section-divider"></div>
                                <label for="min_temperature" class="field prepend-icon">
                                    <form:input path="min_temperature" cssClass="gui-input" placeholder="最低温度" />
                                    <label for="min_temperature" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <div class="col-md-4">最大湿度:</div>
                                <div class="section-divider"></div>
                                <label for="min_temperature" class="field prepend-icon">
                                    <form:input path="max_humidity" cssClass="gui-input" placeholder="最大湿度" />
                                    <label for="min_temperature" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <div class="col-md-4">最小湿度:</div>
                                <div class="section-divider"></div>
                                <label for="min_humidity" class="field prepend-icon">
                                    <form:input path="min_humidity" cssClass="gui-input" placeholder="最小湿度" />
                                    <label for="min_humidity" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <div class="col-md-4">烟雾浓度:</div>
                                <div class="section-divider"></div>
                                <label for="smokescope" class="field prepend-icon">
                                    <form:input path="smokescope" cssClass="gui-input" placeholder="烟雾浓度" />
                                    <label for="smokescope" class="field-icon">
                                        <i class="fa fa-user"></i>
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

<jsp:include page="bottom_users.jsp"/>