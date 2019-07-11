<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>等级考试页面</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
    <script type="text/javascript">
      function deleteExam(id) {
          parent.deleteExam(id);
      }
    </script>
</head>

<body class="body" style="background-color: antiquewhite;">
<h2>等级考试人数统计</h2>

<div style=" overflow-y: auto;overflow-x: auto; ">


        <span>总计：${totalCount}人</span>
        <div style="width: 100%; height: 40px; background-color:ghostwhite; margin-left: 10px;">
            <%--   <span style="margin: 5px 90px;">总计：${totalCount}人</span><br>--%>
            <p style="height: 13px;"></p>
            <c:forEach items="${nameAndCount}" var="obj">
                <span style="margin-left: 40px;">${obj.name}：${obj.musicTypeCount} 人 <span style="width: 20px"></span></span>
            </c:forEach>
        </div>


    <c:forEach items="${musicTypeList}" var="obj">


            <span>${obj.name}</span>

            <table class="layui-table">
                <colgroup>
                    <col width="250">
                    <col width="250">
                    <col width="250">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>水平</th>
                    <th>考试费用</th>
                    <th>考试时间</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="obj1">
                    <c:forEach items="${obj1}" var="obj2">
                        <c:choose>
                            <c:when test="${obj.id==obj2.musicType.id}">
                                <tr>
                                    <td>${obj2.student.name}</td>
                                    <td>${obj2.level}</td>
                                    <td>${obj2.price}</td>
                                    <td>${obj2.time}</td>
                                    <td><button class="layui-btn layui-btn-xs" onclick="deleteExam(${obj2.id })">删除</button></td>
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
