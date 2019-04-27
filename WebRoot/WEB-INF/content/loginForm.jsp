<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 国际化需要用到spring标签  -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<!-- 用户可以选择切换语言环境 -->
  <a href="loginForm?request_locale=zh_CN">中文</a>| <a href="loginForm?request_locale=en_US">English</a>
  <br/>
  ${msg }<hr/>
	<form action="mylogin" method="post">
		<table align="center">
			<caption><spring:message code="userlogin"/></caption>
			<tr>
				<td><spring:message code="userName"/>：</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td><spring:message code="password"/>：</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr align="center">
				<td colspan="2">
				  <input type="submit" value="登录" />
				  <input type="reset" value="重填" />
				</td>
			</tr>
		</table>
	</form>
	实验5：拦截器<p>
	不加入拦截器时，在地址栏直接输入welcome会直接跳转到welcome.jsp<p>
	加入拦截器后，会跳回loginForm<p>
	实验5选做：国际化<p>
	若遇到中文乱码，需在dispatcher-servlet-xml中定义的MessageSource接口添加defaultEncoding<p>
	实验5选做：文件上传（未做）
</body>
</html>