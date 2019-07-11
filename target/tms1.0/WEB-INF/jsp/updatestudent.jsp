<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生修改页面</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
    <script type="text/javascript">
        function doSubmit() {
            $("#myform").submit();
            var index=parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
            window.parent.location.reload();
        }

    </script>
</head>

<body  style="background-color: antiquewhite;">
<div style="width: 500px;margin: 20px auto">
    <form class="layui-form" action="${ctx}/student/update" id="myform">
        <input type="hidden" name="id" value="${requestScope.student.id}">
        <h2 style="margin-left: 150px; margin-bottom: 20px;">学生信息修改</h2>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="name" autocomplete="off"  class="layui-input" value="${requestScope.student.name}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-block">
                <input type="text" name="age" lay-verify="age" autocomplete="off"  class="layui-input" value="${requestScope.student.age}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
               <c:choose>
                   <c:when test="${requestScope.student.sex==0}">
                       <input type="radio" name="sex" value="0" title="男" checked>
                       <input type="radio" name="sex" value="1" title="女" >
                   </c:when>
                   <c:otherwise>
                       <input type="radio" name="sex" value="0" title="男" >
                       <input type="radio" name="sex" value="1" title="女" checked>
                   </c:otherwise>
               </c:choose>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">电话号码</label>
            <div class="layui-input-block">
                <input type="text" name="telephone" lay-verify="telephone" autocomplete="off"  class="layui-input" value="${requestScope.student.telephone}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年级</label>
            <div class="layui-input-block">
                <input type="text" name="grade" lay-verify="grade" autocomplete="off"  class="layui-input" value="${requestScope.student.grade}">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">课程级别</label>
            <div class="layui-input-block">
                <select name="classlevel" lay-filter="aihao">
                    <c:forEach items="${classlevel}" var="obj">
                        <c:choose>
                            <c:when test="${obj == student.classlevel}">
                                <option value="${obj}" selected="selected">${obj}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${obj}">${obj}</option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input type="text" name="address" lay-verify="address" autocomplete="off"  class="layui-input" value="${requestScope.student.address}">
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

                        <c:choose>
                            <c:when test="${student.isrent==1}">
                                <option value="1" selected="selected">是</option>
                                <option value="0">否</option>
                            </c:when>
                            <c:otherwise>
                                <option value="1" >是</option>
                                <option value="0" selected="selected">否</option>
                            </c:otherwise>
                        </c:choose>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否购买</label>
            <div class="layui-input-block">
                <select name="isbuy" lay-filter="aihao">

                    <c:choose>
                        <c:when test="${student.isbuy==1}">
                            <option value="1" selected="selected">已购买</option>
                            <option value="0">没有购买</option>
                        </c:when>
                        <c:otherwise>
                            <option value="1" >已购买</option>
                            <option value="0" selected="selected">没有购买</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否想买</label>
            <div class="layui-input-block">
                <select name="wantbuy" lay-filter="aihao">

                    <c:choose>
                        <c:when test="${student.wantbuy==1}">
                            <option value="1" selected="selected">想买</option>
                            <option value="0">不想买</option>
                        </c:when>
                        <c:otherwise>
                            <option value="1" >想买</option>
                            <option value="0" selected="selected">不想买</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>



            <div class="layui-form-item" style="margin-top: 10px;">
                <label class="layui-form-label">是否完成</label>
                <div class="layui-input-block">
                    <select name="isfinish" lay-filter="aihao">

                        <c:choose>
                            <c:when test="${student.isfinish==0}">
                                <option value="0" selected="selected">没有完成</option>
                                <option value="1" >完成</option>
                            </c:when>

                        </c:choose>
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
