<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生新增页面</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
    <script type="text/javascript">
        function doSubmit() {
            $("#myform").submit();
        }

    </script>
</head>

<body style="background-color: antiquewhite;">
<div style="width: 500px;margin: 20px auto;">
    <form class="layui-form" action="${ctx}/student/addStudentSub" id="myform">
        <h2 style="margin-left: 150px; margin-bottom: 20px;">新学员录入</h2>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="name" autocomplete="off"  class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-block">
                <input type="text" name="age" lay-verify="age" autocomplete="off"  class="layui-input" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="0" title="男">
                <input type="radio" name="sex" value="1" title="女" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">电话号码</label>
            <div class="layui-input-block">
                <input type="text" name="telephone" lay-verify="telephone" autocomplete="off"  class="layui-input" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">年级</label>
            <div class="layui-input-block">
                <input type="text" name="grade" lay-verify="grade" autocomplete="off"  class="layui-input" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input type="text" name="address" lay-verify="address" autocomplete="off"  class="layui-input" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">课程</label>
            <div class="layui-input-block">
                <select name="musicType.id" lay-filter="aihao">
                    <c:forEach items="${musicTypeList}" var="obj">
                        <c:choose>
                            <c:when test="${obj.id == student.musicType.id}">
                                <option value="${obj.id}" selected="selected">${obj.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${obj.id}">${obj.name}</option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">是否租赁</label>
            <div class="layui-input-block">
                <select name="isrent" lay-filter="aihao">
                    <option value="0" >是</option>
                    <option value="1" >否</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否购买</label>
            <div class="layui-input-block">
                <select name="isbuy" lay-filter="aihao">
                    <option value="0" >已购买</option>
                    <option value="1">没有购买</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否想买</label>
            <div class="layui-input-block">
                <select name="wantbuy" lay-filter="aihao">
                    <option value="0" >想买</option>
                    <option value="1">不想买</option>
                </select>
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

