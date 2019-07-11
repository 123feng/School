<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户修改页面</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
    <script type="text/javascript">
        function doSubmit(){
            $("#myform").submit();
            var index=parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
            window.parent.location.reload();
        }
    </script>
</head>

<body style="background-color: antiquewhite;">
<div style="width: 500px;margin: 20px auto">
    <form class="layui-form" action="${ctx}/user/update" id="myform">
        <input type="hidden" name="id" value="${requestScope.user.id}">
        <h2 style="margin-left: 150px; margin-bottom: 20px;">用户修改</h2>
        <div class="layui-form-item">
            <label class="layui-form-label">登录名</label>
            <div class="layui-input-block">
                <input type="text" name="loginname" lay-verify="title" autocomplete="off"  class="layui-input" value="${requestScope.user.loginname}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="text" name="password" lay-verify="title" autocomplete="off"  class="layui-input" value="${requestScope.user.password}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">真名</label>
            <div class="layui-input-block">
                <input type="text" name="truename" lay-verify="title" autocomplete="off"  class="layui-input" value="${requestScope.user.truename}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-block">
                <input type="text" name="age" lay-verify="title" autocomplete="off"  class="layui-input" value="${requestScope.user.age}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">等级</label>
            <div class="layui-input-block">
                <input type="text" name="auth" lay-verify="title" autocomplete="off"  class="layui-input" value="${requestScope.user.auth}">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn"  onclick="doSubmit()">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
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