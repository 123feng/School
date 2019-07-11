<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生缴费信息统计页面</title>
    <link rel="stylesheet" href="${ctx}/resources/css/style.css">
    <script type="text/javascript">
        function doQuery(pageSize) {
            var sname = $("#sname").val();
            var mtname=$("#mtname").val();
            window.location.href='${ctx}/studentpay/nameandtype?pageSize='+pageSize+'&sname='+sname+'&mtname='+mtname;
        }
        function doAdd(id) {
            window.location.href='${ctx}/studentcourse/goadd/'+id
        }
    </script>
</head>

<body style="background-color: antiquewhite;">
<div  style="padding: 10px;">

    <div id="content" style="text-align: center;">
        <form class="layui-form">
            <h2  style="margin-bottom: 20px;margin-top: 20px;">学生缴费信息统计</h2>
            <div class="layui-input-inline">
                <label class="layui-input-inline">学生姓名：</label>
                <div class="layui-input-inline">
                    <input type="text" id="sname" required lay-verify="required" placeholder="请输入学生姓名" autocomplete="off" class="layui-input" value="${sname}">
                </div>
            </div>
            <div class="layui-input-inline">
                <label class="layui-input-inline">学生课程：</label>
                <div class="layui-input-inline">
                    <input type="text" id="mtname" required lay-verify="required" placeholder="请输入课程类别" autocomplete="off" class="layui-input" value="${mtname}">
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
                <col width="100">
                <col width="100">
                <col width="100">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>姓名</th>
                <th>任课老师</th>
                <th>课程类别</th>
                <th>等级</th>
                <th>单价</th>
                <th>缴费金额</th>
                <th>缴费时间</th>
                <th>总课时</th>
                <th>剩余课时</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="obj">
               <tr>
                   <td>${obj.student.name}</td>
                   <td>${obj.teacher.name}</td>
                   <td>${obj.musicType.name}</td>
                   <td>${obj.level}</td>

                   <td>${obj.price}</td>
                   <td>${obj.totalprice}</td>
                   <td>${obj.time}</td>
                   <td>${obj.totalclass}</td>
                   <td>${obj.leftclass}</td>
                   <c:choose>
                       <c:when test="${obj.leftclass==0}">
                           <td><button style="padding: 3px  5px;" ><i class="layui-icon layui-icon-edit"></i></button></td>
                       </c:when>

                       <c:otherwise>
                           <td><button style="padding: 3px  5px;" onclick="doAdd(${obj.student.id})"><i class="layui-icon layui-icon-edit"></i></button></td>
                       </c:otherwise>

                   </c:choose>


               </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<%--    <div id="demo"></div>
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
    </script>--%>

    <div style="margin-left:450px">
      <span>${pb.currentPageNum }/${pb.totalPageSize }</span>&nbsp;页&nbsp;第&nbsp;<input  type="text" id="pageSize" style="width:30px;" >&nbsp;页

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


         <%-- <nav aria-label="Page navigation" style="text-align:right">
              <ul class="pagination">
                  <!-- 后退箭头 -->
                  <c:choose>
                      <c:when test="${pb.currentPageNum== 1}">
                          <li class="disabled"><a href="javascript:void(0)" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                      </c:when>
                      <c:otherwise>
                          <li><a href="javascript:void(0)" onclick="doQuery(${pb.currentPageNum-1})" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                      </c:otherwise>
                  </c:choose>


                  <!-- 页码显示 -->
                  <c:forEach begin="1" end="${pb.totalPageSize}" var="obj">
                      <c:choose>
                          <c:when test="${obj == pb.currentPageNum}">
                              <li class="active"><a href="javascript:void(0)">${obj} <span class="sr-only">(current)</span></a></li>
                          </c:when>
                          <c:otherwise>
                              <li><a href="javascript:void(0)" onclick="doQuery(${obj})">${obj }</a></li>
                          </c:otherwise>
                      </c:choose>
                  </c:forEach>

                  <!-- 前进箭头 -->
                  <c:choose>
                      <c:when test="${pb.currentPageNum == pb.totalPageSize}">
                          <li class="disabled"><a href="javascript:void(0)" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
                      </c:when>
                      <c:otherwise>
                          <li><a href="javascript:void(0)" onclick="doQuery(${pb.currentPageNum+1})" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
                      </c:otherwise>
                  </c:choose>
              </ul>
          </nav>--%>





    </div>








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