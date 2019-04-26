<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 国际化需要用到spring标签  -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面</title>
</head>
<body>
	<spring:message code="welcome"/>！${msg }<br>
	<input type="button" value="返回" onClick="location='index.jsp'"/>
</body>
</html>