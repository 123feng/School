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
        function editStudent(id) {
            layer.open({
                type: 2,
                offset:10,
                skin: 'layui-layer-rim', //加上边框+
                area: ['800px', '700px'], //宽高
                content: ['${ctx}/student/editStudent/'+id],
            });
        }


    </script>
</head>

<body class="body" style="background-color: antiquewhite;">


<div  >
    <h2>学生人数统计</h2>
        <span>总计：${totalCount}人</span>
        <div style="width: 100%; height: 40px; background-color:ghostwhite; margin-left: 10px;">
             <p style="height: 13px;"></p>
            <c:forEach items="${nameAndCount}" var="obj">
                <span style="margin-left: 40px;">${obj.name}：${obj.musicTypeCount} 人 <span style="width: 20px"></span></span>
            </c:forEach>
        </div>


    <c:forEach items="${musicTypeList}" var="obj">

        <div class="layui-form-item">
            <span>${obj.name}</span>
        </div>

        <table class="layui-table">
            <colgroup>
                <col width="100">
                <col width="100">
                <col width="100">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>联系电话</th>
                <th>年级</th>
                <th>家庭住址</th>
                <th>购买意向</th>
                <th>是否租用钢琴</th>
                <th>是否买钢琴</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="obj1">
            <c:forEach items="${obj1}" var="obj2">
                <c:choose>
                    <c:when test="${obj.id==obj2.musicType.id}">
                        <tr>
                            <td><a href="${ctx}/student/editStudent/${obj2.id}">${obj2.name}</a></td>
                            <c:choose>
                                <c:when test="${obj2.sex==1}">
                                    <td>男</td>
                                </c:when>
                                <c:otherwise>
                                    <td>女</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${obj2.age}</td>
                            <td>${obj2.telephone}</td>
                            <td>${obj2.grade}</td>
                            <td>${obj2.address}</td>
                            <c:choose>
                                <c:when test="${obj2.wantbuy==1}">
                                    <td>是</td>
                                </c:when>
                                <c:otherwise>
                                    <td>否</td>
                                </c:otherwise>
                            </c:choose>

                            <c:choose>
                                <c:when test="${obj2.isrent==1}">
                                    <td>是</td>
                                </c:when>
                                <c:otherwise>
                                    <td>否</td>
                                </c:otherwise>
                            </c:choose>

                            <c:choose>
                                <c:when test="${obj2.isbuy==1}">
                                    <td>是</td>
                                </c:when>
                                <c:otherwise>
                                    <td>否</td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
            </c:forEach>
            </tbody>
        </table>



    </c:forEach>



</div>
</body>
</html>
