<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
</head>

<body >
<div class="login-main" >
    <header class="layui-elip">训练管理系统</header>
    <form class="layui-form" action="${ctx}/login" method="post">
        <span style="color: red">${msg}</span>
        <div class="layui-input-inline">
            <input type="text" name="loginname" required lay-verify="required" placeholder="用户名" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" class="layui-btn">登录</button>
        </div>
        <hr/>
        <p><a href="javascript:;" class="fl">立即注册</a><a href="javascript:;" class="fr">忘记密码？</a></p>
    </form>
</div>

<script type="text/javascript">
    layui.use('form', function(){
        var form = layui.form;

    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#time'
            ,type: 'datetime'
        });
    });
</script>


</body>
</html>