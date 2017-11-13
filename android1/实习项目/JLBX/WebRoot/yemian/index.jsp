<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="yemian/css/base.css">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<link href="css/haiersoft.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<script src="js/jquery-1.10.1.min.js"></script>
<script src="js/side.js" type="text/javascript"></script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->

</head>

<body>
	<!-- wrap_left -->
<div class="wrap_left" id="frmTitle" name="fmTitle">
<!-- Logo -->
<div id="Logo"><span>Beta 1.0</span><h1 title="人单合一"></h1></div>
<!-- /Logo -->

<!-- menu_list -->
<script>
$(function() {
    $(".menu_list dd");
    $(".menu_list dt").click(function(){
        $(this).toggleClass("open").next().slideToggle("fast");
    });
});
</script>
<div class="menu_list">
<dl>
<dt><span>业务</span></dt>
<dd><a href="../SelectShow?pot=dai" title="二级分类">待修业务</a>
<a href="../SelectShow?pot=wan" title="二级分类">已完成业务</a>
<a href="../ShowReply" title="二级分类" class="active">业务评价</a>
</dl>
<dl>
<dt><span>人员</span></dt>
<dd><a href="" title="二级分类">密码修改</a>
<a href="" title="二级分类">工友查询</a>
<a href="" title="二级分类">人员登陆</a>
<a href="" title="二级分类">注销</a>
<!--<dl>
<dt><span>一级分类名称</span></dt>
<dd><a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a></dd>
</dl>
<dl>
<dt><span>一级分类名称</span></dt>
<dd><a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a></dd>
</dl>-->
<!--<dl>
<dt><span>一级分类名称</span></dt>
<dd><a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a></dd>
</dl>
<dl>
<dt><span>一级分类名称</span></dt>
<dd><a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a></dd>
</dl>
<dl>
<dt><span>一级分类名称</span></dt>
<dd><a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a>
<a href="" title="二级分类">二级分类</a></dd>
</dl>-->
</div>
<!-- /menu_list -->
</div>
<!-- /wrap_left -->

<!-- picBox -->
<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>
<!-- /picBox -->



<!-- wrap_right -->
<div class="wrap_right">
<header>
<!-- Header -->
<div id="Header">
<div class="user">
<div>
<p>欢迎登录</p>
<a href="#"><span>8</span><img src="images/common/ico02.gif" width="20" height="20" alt=""></a>
<a href="#"><img src="images/common/ico03.gif" width="20" height="20" alt=""></a>
<a href="#"><img src="images/common/ico04.gif" width="20" height="20" alt=""></a>
<a href="#"><img src="images/common/ico05.gif" width="20" height="20" alt=""></a>
<a href="#"><img src="images/common/ico06.gif" width="20" height="20" alt=""></a>
<a href="#"><img src="images/common/ico07.gif" width="20" height="20" alt=""></a>
</div>
<div class="search_box"><input name="" type="image" src="../CN_HTML5/images/common/btn_search.gif"><input name="" type="text" class="box" placeholder="Search..."></div>
</div>

<nav>
<div id="Navi">
<div class="btn_menu"><img src="images/common/btn_menu.gif" width="45" height="30" alt="主页管理"></div>
<ul>
<li class="nav01"><a href="" title="主页管理">主页管理</a></li>
<li class="nav02"><a href="../SelectShow?pot=all" title="系统管理">所有业务</a></li>
<!--<li class="active nav03"><a href="" title="合同信息">合同信息</a></li>
<li class="nav04"><a href="" title="基础数据">基础数据</a></li>
<li class="nav05"><a href="" title="预算管理">预算管理</a></li>
<li class="nav06"><a href="" title="项目管理">项目管理</a></li>
<li class="nav07"><a href="" title="资金支付-发票">资金支付-发票</a></li>
<li class="nav08"><a href="" title="产品管理信息">产品管理信息</a></li>-->
<div style="font-size: xx-large; margin-left: 30px;">
	<div style="align:center;">
	<li>——江  理  报  修  管  理  系  统——</li>
	</div>
</div> 
</ul>
</div>
</nav>
</div>
<!-- /Header -->
</header>


<!-- Contents -->
<div id="Contents">
<script type="text/javascript">
$(function(){
$(".select").each(function(){
var s=$(this);
var z=parseInt(s.css("z-index"));
var dt=$(this).children("dt");
var dd=$(this).children("dd");
var _show=function(){dd.slideDown(200);dt.addClass("cur");s.css("z-index",z+1);};
var _hide=function(){dd.slideUp(200);dt.removeClass("cur");s.css("z-index",z);};
dt.click(function(){dd.is(":hidden")?_show():_hide();});
dd.find("a").click(function(){dt.html($(this).html());_hide();});
$("body").click(function(i){ !$(i.target).parents(".select").first().is(s) ? _hide():"";});})})
</script>

<!-- MainForm -->
<div id="MainForm">
<div class="form_boxB">
<h1>江西理工大学维修报单</h1>
<table cellpadding="0" cellspacing="0">
<tr>
<td colspan="10" class="info_boxA">部门：后勤部　　类别：维修类　　</td>
</tr>
<%
	//String repair=session.getAttribute("repair").toString();
	//System.out.print(repair+"hsfddshdjsbcbdhfydgfddssadwadew");
	//request.setAttribute("repair", repair);
 %>
<tr>
<th></th>
<th>序号</th>
<th>提交人</th>
<th>提交人号码</th>
<th>地址</th>
<th>问题描述</th>
<th>状态</th>
</tr>
<c:forEach var="i" items="${sessionScope.repair}" step="1">
	<tr>
		<td><input name="Fruit" type="checkbox" value="" /></td>
		<td><c:out value="${i.id}"/></td>
		<td><c:out value="${i.stuname}"/></td>
		<td><c:out value="${i.stuphone}"/></td>
		<td><c:out value="${i.location}"/></td>
		<td><c:out value="${i.miao}"/></td>
		<td><c:out value="${i.status}"/></td>
	</tr>
</c:forEach>
</table>

</div>
</div>
<!-- /MainForm -->


</div>
<!-- /Contents -->

<!-- /footer -->
<!-- /footer -->

</div>
<!-- /wrap_right -->
</body>
</html>