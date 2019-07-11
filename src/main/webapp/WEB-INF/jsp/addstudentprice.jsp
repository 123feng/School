<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生缴费信息录入</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
    <script type="text/javascript">
        function doSubmit() {
            $("#myform").submit();
        }
    </script>
</head>

<body style="background-color: antiquewhite;">
<div style="width: 500px;margin: 20px auto">
    <form class="layui-form" action="${ctx}/studentpay/addstudentprice"  id="myform">
        <h2 style="margin-left: 150px; margin-bottom: 20px;">学生缴费信息录入</h2>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <select name="student.id" lay-filter="aihao">
                    <c:forEach items="${studentList}" var="obj">
                       <option value="${obj.id}">${obj.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">任课老师</label>
            <div class="layui-input-block">
                <select name="teacher.id" lay-filter="aihao">
                    <c:forEach items="${teacherList}" var="obj">
                        <option value="${obj.id}">${obj.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label">课程类别</label>
            <div class="layui-input-block">
                <select name="musicType.id" lay-filter="aihao">
                    <c:forEach items="${musicTypeList}" var="obj">
                        <option value="${obj.id}">${obj.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">等级</label>
            <div class="layui-input-block">
                <select name="level" lay-filter="level">
                    <c:forEach items="${classlevel}" var="obj">
                        <option value="${obj}">${obj}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">单价</label>
            <div class="layui-input-block">
                <input type="text" name="price" lay-verify="price" autocomplete="off"  class="layui-input" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">缴费金额</label>
            <div class="layui-input-block">
                <input type="text" name="totalprice" lay-verify="totalprice" autocomplete="off"  class="layui-input" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">缴费时间</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input"   name="time" id="time" placeholder="yyyy-MM-dd HH:mm:ss" style="width: 390px;">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">总课时</label>
            <div class="layui-input-block">
                <input type="text" name="totalclass" lay-verify="totalclass" autocomplete="off"  class="layui-input" >
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