<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx"  value="${pageContext.request.contextPath }"></c:set>
<script type="text/javascript" src="${ctx}/resources/js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/layui/css/layui.css"/>
<script type="text/javascript" src="${ctx}/resources/layui/layui.js"></script>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>