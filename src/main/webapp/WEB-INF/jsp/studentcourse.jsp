<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>课时信息统计</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
    <script type="text/javascript">
        function doQuery(pageSize) {
            var sname = $("#sname").val();
            var starttime=$("#starttime").val();
            var endtime=$("#endtime").val();
            window.location.href='${ctx}/studentcourse/nameandtime?pageSize='+pageSize+'&sname='+sname+'&starttime='+starttime+'&endtime='+endtime;
        }
    </script>
</head>

<body style="background-color: antiquewhite;">
<div  style="padding: 10px;">

    <div id="content" style="text-align: center;">
        <form class="layui-form">
            <h2  style="margin-bottom: 20px;margin-top: 20px;">课时信息统计</h2>
            <div class="layui-input-inline">
                <label class="layui-input-inline">学生姓名：</label>
                <div class="layui-input-inline">
                    <input type="text" id="sname" required lay-verify="required" placeholder="请输入学生姓名" autocomplete="off" class="layui-input" value="${sname}">
                </div>
            </div>

            <div class="layui-input-inline">
                <label class="layui-form-label">开始时间：</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input"   name="starttime" id="starttime" placeholder="yyyy-MM-dd HH:mm:ss" value="${starttime}" >
                </div>
            </div>

            <div class="layui-input-inline">
                <label class="layui-form-label">结束时间：</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input"   name="endtime" id="endtime" placeholder="yyyy-MM-dd HH:mm:ss" value="${endtime}" >
                </div>
            </div>


            <div class="layui-input-inline">
                <button class="layui-btn mgl-20"  onclick="doQuery(1)">查询</button>
            </div>
            <hr/>
        </form>
    </div>

    <div>
        <table class="layui-table">
            <colgroup>
                <col width="200">
                <col width="200">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>姓名</th>
                <th>任课老师</th>
                <th>课程类别</th>
                <th>类型</th>
                <th>开始时间</th>
                <th>结束时间</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="obj">
                <tr>
                    <td>${obj.student.name}</td>
                    <td>${obj.teacher.name}</td>
                    <td>${obj.musicType.name}</td>
                    <td>${obj.type}</td>
                    <td>${obj.starttime}</td>
                    <td>${obj.endtime}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div style="margin-left:450px">
        <span>${pb.currentPageNum }/${pb.totalPageSize }</span>&nbsp;页&nbsp;第&nbsp;<input  type="text" id="pageSize" style="width:30px;" >&nbsp;页
        <button type="button" class="layui-btn layui-btn-primary layui-btn-sm"   onclick="doQuery(document.getElementById('pageSize').value)">跳转</button>
        <c:choose>
            <c:when test="${pb.currentPageNum == 1 }">
                上一页
            </c:when>
            <c:otherwise>
                <a href="javascript:void(0)" onclick="doQuery(${pb.currentPageNum - 1})">上一页</a>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${pb.currentPageNum == pb.totalPageSize }">
                下一页
            </c:when>
            <c:otherwise>
                <a href="javascript:void(0)" onclick="doQuery(${pb.currentPageNum + 1})">下一页</a>
            </c:otherwise>
        </c:choose>

    </div>
</div>









<script type="text/javascript">
    layui.use('form', function(){
        var form = layui.form;

    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#starttime'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#endtime'
            ,type: 'datetime'
        });
    });
</script>


</body>
</html>
