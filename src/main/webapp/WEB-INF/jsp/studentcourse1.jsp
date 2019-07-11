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

</head>

<body style="background-color: antiquewhite;">
<div  style="padding: 10px;">

    <div id="content" style="text-align: center;">
        <form class="layui-form" action="${ctx}/studentcourse/index" method="post" id="myform">
            <h2  style="margin-bottom: 20px;margin-top: 20px;">课时信息统计</h2>
            <div class="layui-input-inline">
                <label class="layui-input-inline">学生姓名：</label>
                <div class="layui-input-inline">
                    <input type="text" name="sname" required lay-verify="required" placeholder="请输入学生姓名" autocomplete="off" class="layui-input" value="${sname}">
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
                <button class="layui-btn mgl-20"  >查询</button>
            </div>
            <hr/>
            <input type="hidden" name="pageSize" id="pageSize"  value="" >
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

    <div id="demo0"></div>

    <script type="text/javascript">

        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });

        layui.use(['laypage'], function(){
        var laypage = layui.laypage

        laypage.render({
        elem: 'demo0'
        ,count: '${pb.totalDataCount}' //数据总数
        ,limit:'${pb.everyPageSize}' // 每页显示
        ,curr: '${pb.currentPageNum}' // 服务器端回传当前页
        ,jump: function(obj,first){
                //obj包含了当前分页的所有参数，比如：
                //console.log(obj.curr);  //得到当前页，以便向服务端请求对应页的数据。
                 //console.log(obj.limit); //得到每页显示的条数
                 //首次不执行,使用原始的curr,后面需要自己通过回传来更新
         var curr = obj.curr;
         if(!first){
             $("#pageSize").val(obj.curr);
             $("#myform").submit();
                }
             }
         });
     });
    </script>

</div>












</body>
</html>
