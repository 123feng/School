<%@ page import="java.util.ArrayList" %>
<%@ page import="com.iflytek.tms.pojo.Week" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
    <script type="text/javascript">

        var layer = null;
        layui.use('layer', function(){
            layer = layui.layer;
        });
        function deleteCoursePlan(id) {

            layer.confirm('您确定要删除该学员吗？', {
                btn: ['确定','取消'] ,//按钮
                offset:'10'
            }, function(){
                $.post("${ctx}/courseplan/delete",{"id":id},function(data){
                    layer.msg('删除成功', {
                        time: 20000, //20s后自动关闭
                    });
                    window.location.reload();
                });
            }, function(){
            });
        }

    </script>
</head>

<body>
<% List<Week> wl=(ArrayList<Week>)request.getAttribute("oneWeekDate"); %>
<h2><%=wl.get(0).getYear()%>年<%=wl.get(0).getMonth()%>月<%=wl.get(0).getDay()%>日-<%=wl.get(wl.size()-1).getYear()%>年<%=wl.get(wl.size()-1).getMonth()%>月<%=wl.get(wl.size()-1).getDay()%>日</h2>


<div >
    <c:forEach items="${courselist}" var="obj">

        <span>${obj.musicType.name}</span>


            <table class="layui-table"  >
                <colgroup>
                    <col width="200">
                    <col width="200">
                    <col width="200">
                    <col width="200">
                    <col width="200">
                    <col width="200">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <c:forEach items="${oneWeekDate}" var="o">
                        <th>${o.year}年${o.month}月${o.day}日${o.xingqi}</th>
                    </c:forEach>
                </tr>
                </thead>
                <tbody>
                <tr>


                    <td>
                        <c:forEach items="${obj.list1}" var="obj1">
                            ${(obj1.starttime).substring(11,17)}${obj1.endtime.substring(11,17)}${obj1.teacher.name} ${obj1.student.name}<button class="layui-btn layui-btn-xs" onclick="deleteCoursePlan(${obj1.id })">删除</button>
                        </c:forEach>
                    </td>



                    <td>
                        <c:forEach items="${obj.list2}" var="obj1">
                            ${(obj1.starttime).substring(11,17)}${obj1.endtime.substring(11,17)}${obj1.teacher.name} ${obj1.student.name}<button class="layui-btn layui-btn-xs" onclick="deleteCoursePlan(${obj1.id })">删除</button>
                         </c:forEach>
                    </td>


                <td>
                <c:forEach items="${obj.list3}" var="obj1">
                    ${(obj1.starttime).substring(11,17)}${obj1.endtime.substring(11,17)}${obj1.teacher.name} ${obj1.student.name}<button class="layui-btn layui-btn-xs" onclick="deleteCoursePlan(${obj1.id })">删除</button>
                </c:forEach>
                </td>


                <td>
                <c:forEach items="${obj.list4}" var="obj1">
                   ${(obj1.starttime).substring(11,17)}${obj1.endtime.substring(11,17)}${obj1.teacher.name} ${obj1.student.name}<button class="layui-btn layui-btn-xs" onclick="deleteCoursePlan(${obj1.id })">删除</button>
                </c:forEach>
                </td>

                    <td>
                        <c:forEach items="${obj.list5}" var="obj1">
                        ${(obj1.starttime).substring(11,17)}${obj1.endtime.substring(11,17)}${obj1.teacher.name} ${obj1.student.name}<<button class="layui-btn layui-btn-xs" onclick="deleteCoursePlan(${obj1.id })">删除</button>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${obj.list6}" var="obj1">
                           ${(obj1.starttime).substring(11,17)}${obj1.endtime.substring(11,17)}${obj1.teacher.name} ${obj1.student.name}<button class="layui-btn layui-btn-xs" onclick="deleteCoursePlan(${obj1.id })">删除</button>
                        </c:forEach>
                    </td>

                    <td>
                        <c:forEach items="${obj.list7}" var="obj1">
                            ${(obj1.starttime).substring(11,17)}${obj1.endtime.substring(11,17)}${obj1.teacher.name} ${obj1.student.name}<button class="layui-btn layui-btn-xs" onclick="deleteCoursePlan(${obj1.id })">删除</button>
                        </c:forEach>
                    </td>
                </tr>
                </tbody>
            </table>
    </c:forEach>
</div>
</body>
</html>