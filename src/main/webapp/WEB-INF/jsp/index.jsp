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

        function setIframeHeight() {
            var iframe = document.getElementById("iframe1");
            iframe.height = 0 + "px";
            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
            if (iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            }
        }

        function editUser(id) {
            layer.open({
                type: 2,
                skin: 'layui-layer-rim', //加上边框
                area: ['800px', '500px'], //宽高
                content: ['${ctx}/editUser/'+id],
            });
        }
        function deleteExam(id) {

            layer.confirm('您确定要删除该学员吗？', {
                btn: ['确定','取消'],
                offset: '10',
                //按钮
            }, function(){
                $.post("${ctx}/exam/delete",{"id":id},function(data){
                    layer.msg('删除成功', {
                        time: 1000, //20s后自动关闭
                    },function(){
                        $("#iframe1").attr('src','${ctx}/exam/index');
                    });
                });
            }, function(){
            });
        }
    </script>
</head>

<body >
<!-- layout admin -->
<div class="layui-layout layui-layout-admin"> <!-- 添加skin-1类可手动修改主题为纯白，添加skin-2类可手动修改主题为蓝白 -->
    <!-- header -->
    <h2>${ctx}</h2>
    <div class="layui-header my-header">
        <a href="index.html">

            <div class="my-header-logo">艺术培训管理系统v1.0</div>
        </a>
        <div class="my-header-btn">
            <button class="layui-btn layui-btn-small btn-nav"><i class="layui-icon">&#xe65f;</i></button>
        </div>


        <!-- 顶部右侧添加选项卡监听 -->
        <ul class="layui-nav my-header-user-nav" lay-filter="side-top-right">
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"><i class="layui-icon layui-icon-username" style="font-size: 20px;"></i>    ${sessionScope.user.truename} </a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/editPassword/${sessionScope.user.id}" ><i class="layui-icon">&#xe621;</i>修改密码</a></dd>
                    <dd><a href="#"  onclick="editUser(${sessionScope.user.id})" ><i class="layui-icon">&#xe621;</i>修改用户信息</a></dd>
                    <dd><a href="${ctx}/exitSession" ><i class="layui-icon">&#x1006;</i>退出</a></dd>
                </dl>
            </li>
        </ul>

    </div>
    <!-- side -->
    <div class="layui-side my-side" >
        <div class="layui-side-scroll">
            <!-- 左侧主菜单添加选项卡监听 -->
            <ul class="layui-nav layui-nav-tree" lay-filter="side-main" lay-shrink="all">

                <c:forEach items="${menuList}" var="obj" varStatus="s">

                    <c:choose>
                        <c:when test="${s.count==1}">
                            <li class="layui-nav-item  layui-nav-itemed">
                                <a href="javascript:;"><i class="layui-icon">&#xe620;</i>${obj.name}</a>
                                <dl class="layui-nav-child">

                                    <c:forEach items="${obj.menus}" var="o" varStatus="c">
                                        <c:choose>
                                            <c:when test="${c.count==1}">
                                                <dd class="layui-this"><a href="${o.href}" target="iframe"><i class="layui-icon">&#xe621;</i>${o.name}</a></dd>
                                            </c:when>

                                            <c:otherwise>
                                                <dd><a href="${o.href}" target="iframe"><i class="layui-icon">&#xe621;</i>${o.name}</a></dd>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </dl>
                            </li>
                        </c:when>

                        <c:otherwise>
                            <li class="layui-nav-item ">
                                <a href="javascript:;"><i class="layui-icon">&#xe620;</i>${obj.name}</a>
                                <dl class="layui-nav-child">
                                    <c:forEach items="${obj.menus}" var="o" >
                                        <dd><a href="${o.href}" target="iframe"><i class="layui-icon">&#xe621;</i>${o.name}</a></dd>
                                    </c:forEach>
                                </dl>
                            </li>
                        </c:otherwise>

                    </c:choose>
                </c:forEach>
            </ul>

        </div>
    </div>
    <!-- body -->
    <div class="layui-body my-body">
        <div class="layui-tab layui-tab-card my-tab" lay-filter="card" lay-allowClose="true">


            <ul class="layui-tab-title">

            </ul>
            <div class="layui-tab-content" >
                <div class="layui-tab-item layui-show" >
                    <iframe id="iframe1" name="iframe" src="${ctx}/student/index" frameborder="0" style="width: 100%;" onload="setIframeHeight()"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
    <div class="layui-footer my-footer">

    </div>
</div>

<!-- 右键菜单 -->
<div class="my-dblclick-box none">
    <table class="layui-tab dblclick-tab">
        <tr class="card-refresh">
            <td><i class="layui-icon">&#x1002;</i>刷新当前标签</td>
        </tr>
        <tr class="card-close">
            <td><i class="layui-icon">&#x1006;</i>关闭当前标签</td>
        </tr>
        <tr class="card-close-all">
            <td><i class="layui-icon">&#x1006;</i>关闭所有标签</td>
        </tr>
    </table>
</div>

<script type="text/javascript" src="${ctx}/resources/js/vip_comm.js"></script>
<script type="text/javascript">
    layui.use(['layer','vip_nav'], function () {

        // 操作对象
        var layer       = layui.layer
            ,vipNav     = layui.vip_nav
            ,$          = layui.jquery;

        // 顶部左侧菜单生成 [请求地址,过滤ID,是否展开,携带参数]
        vipNav.top_left('./json/nav_top_left.json','side-top-left',false);
        // 主体菜单生成 [请求地址,过滤ID,是否展开,携带参数]
        vipNav.main('./json/nav_main.json','side-main',true);

    });
</script>
</body>
</html>


