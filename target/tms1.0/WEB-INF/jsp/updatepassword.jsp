<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户修改密码</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
    <script type="text/javascript">

        function checkPassword() {
         var oldPassInput =$("#oldpassword").val();
         var oldPass='${user.password}';
            if(oldPass==oldPassInput){
                $("#msg1").html("");
                return true;
            }
            else {
                $("#msg1").html("原密码不正确");
                return false;
            }

        }
        function  isCommon(){

            var newpassword=$("#newpassword").val();
            var password=$("#password").val();
            if(newpassword!=password) {
                $("#msg2").html("新旧密码不一致");
                return  false;
            }
            else {
                return  true;
            }

        }


    </script>
</head>

<body style="background-color: antiquewhite;">
<div style="width: 500px;margin: 20px auto">
    <form class="layui-form" action="${ctx}/updatepassword" onsubmit="return checkPassword()&&isCommon()" >
        <input type="hidden" name="id" value="${requestScope.user.id}">
        <h2 style="margin-left: 150px; margin-bottom: 20px;">用户修改密码</h2>
        <div class="layui-form-item">
            <label class="layui-form-label">旧密码</label>
            <div class="layui-input-block">
                <input type="text" name="oldpassword" id="oldpassword" lay-verify="title" autocomplete="off"  class="layui-input" onblur="checkPassword()" >
                <span id="msg1"></span>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新密码</label>
            <div class="layui-input-block">
                <input type="text" name="password" id="password" lay-verify="title" autocomplete="off"  class="layui-input" value="${user.password}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-block">
                <input type="text" name="newpassword" id="newpassword" lay-verify="title" autocomplete="off"  class="layui-input" onblur="isCommon()">
                <span id="msg2"></span>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn"  <%--onclick="doSubmit()"--%>>立即提交</button>
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