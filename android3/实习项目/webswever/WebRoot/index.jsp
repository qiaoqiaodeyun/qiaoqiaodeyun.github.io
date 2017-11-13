<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>


<body>
	<form name="input" action="userinfo?todo=login" method="post">
		Username: <input type="text" name="phone" /> <br> 
		password: <input type="text" name="password" /> <br>
		 <input type="submit" value="Submit" />
	</form>
	<br />
	<a href="<%=basePath%>category?todo=category">综合练习2： 返回评论列表 JOSN</a>
	<br />
	<a href="<%=basePath%>news?todo=select&&category">综合练习2： 返回评论列表
		JOSN</a>
	<br />

	<!-- 测试通过 -->
	<a href="<%=basePath%>news?todo=keywordselect&&keyword">综合练习2：
		返回评论列表 JOSN</a>
	<br>
	<!-- categoryselect -->
	<a href="<%=basePath%>news?todo=categoryselect">综合练习2： 返回评论列表 JOSN</a>
	<br>
	<!-- categoryselect -->
	<a href="<%=basePath%>comment?todo=search">综合练习2： 返回评论列表 JOSN</a>
	<br>
	<a
		href="<%=basePath%>userinfo?todo=login&phone=1&password=1">综合练习2：
		返回评论列表 JOSN</a>


</body>
</html>
