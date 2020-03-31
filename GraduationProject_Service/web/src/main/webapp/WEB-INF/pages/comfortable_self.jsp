<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top_users.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 环境区间展示 </h2>
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
                        <div class="col-md-4">${sessionScope.comfortable.username}</div>
                    </div>
                    <div class="section-divider"></div>
                    <div class="section row">
                        <div class="col-md-2">最高温度</div>
                        <div class="col-md-4">${sessionScope.comfortable.max_temperature}</div>
                        <div class="col-md-2">最低温度</div>
                        <div class="col-md-4">${sessionScope.comfortable.min_temperature}</div>
                    </div>
                    <div class="section-divider"></div>
                    <div class="section row">
                        <div class="col-md-2">最大湿度</div>
                        <div class="col-md-4">${sessionScope.comfortable.max_humidity}</div>
                        <div class="col-md-2">最小湿度</div>
                        <div class="col-md-4">${sessionScope.comfortable.min_humidity}</div>
                    </div>
                    <div class="section-divider"></div>
                    <div class="section row">
                        <div class="col-md-2">烟雾浓度</div>
                        <div class="col-md-4">${sessionScope.comfortable.smokescope}</div>
                    </div>
                    <div class="panel-footer text-right">
                        <button type="button" class="button mr10 pull-right" onclick="window.location.href='/graduationproject/comfortable/to_update?username=${sessionScope.comfortable.username}'">更改信息</button>
                        <button type="button" class="button mr10 pull-right" onclick="javascript:window.history.go(-1);"> 返回 </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom_users.jsp"/>