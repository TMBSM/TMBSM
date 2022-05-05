<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.pagedivide.bean.MemPageDivide"%>
<%@page import="com.entity.Member"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>后台管理系统</title>
		<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="./background/css/style.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="./background/js/jquery.js"></script>
<script src="./background/js/jquery.mCustomScrollbar.concat.min.js"></script>

<script>
	(function($) {
		$(window).load(
				function() {

					$("a[rel='load-content']").click(
							function(e) {
								e.preventDefault();
								var url = $(this).attr("href");
								$.get(url, function(data) {
									$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
										//scroll-to appended content 
										$(".content").mCustomScrollbar(
												"scrollTo", "h2:last");
									});
							});

					$(".content").delegate(
							"a[href='top']",
							"click",
							function(e) {
								e.preventDefault();
								$(".content").mCustomScrollbar("scrollTo",
										$(this).attr("href"));
							});

		});
	})(jQuery);
</script>
</head>
		<!--header-->
		<header>
		<h1>
			<img src="./background/images/admin_logo.png" />
		</h1>
		<ul class="rt_nav">
			 <li><a href="/store/MerServlet?action=selectall" target="_blank" class="website_icon">站点首页</a></li>
  <li><a href="/store/GBServlet?action=selectall" class="admin_icon">DeathGhost</a></li>
  <li><a href="/store/background/login.html" class="quit_icon">安全退出</a></li>
		</ul>
		</header>

		<!--aside nav-->
		<aside class="lt_aside_nav content mCustomScrollbar">
		<h2>
			<a href="#">起始页</a>
		</h2>
		<ul>
			<li>
				<dl>
					<dt>
						商品信息
					</dt>
					当前链接则添加class:active
					<dd>
						<a href="/store/MerServlet?action=selectall" >商品列表</a>
					</dd>
					<dd>
						<a href="/store/CateServlet?actionselectall">商品分类</a>
					</dd>
					<dd>
						<a href="/store/background/meradd.html">商品添加</a>
					</dd>
				
				</dl>
			</li>
			<li>
				<dl>
					<dt>
						订单信息
					</dt>
					<dd>
						<a href="/store/OrderServlet?action=selectall">订单列表</a>
					</dd>
					
				</dl>
			</li>
			<li>
				<dl>
					<dt>
						会员管理
					</dt>
					<dd>
						<a href="/store/MemServlet?action=selectall" class="active">会员列表</a>
					</dd>
					<dd>
						<a href="/store/background/memadd.html">添加会员</a>
					</dd>
					<dd>
						<a href="/store/MLServlet?action=selectall">会员等级</a>
					</dd>
					
				</dl>
			</li>
			<li>
				<dl>
					<dt>配送方式管理</dt>
    <dd><a href="/store/DelServlet?action=selectall">配送方式列表</a></dd>
    <dd><a href="/store/background/deladd.html">添加配送方式</a></dd>
				</dl>
			</li>
			<li>
				<dl>
					<dt>Contact us</dt>
    <dd><a href="/store/GBServlet?action=selectall">留言板回复</a></dd>
				</dl>
			</li>
			<li>
				<p class="btm_infor">
					© 望唐集团 版权所有
				</p>
			</li>
		</ul>
		</aside>

		<section class="rt_wrap content mCustomScrollbar">

		<div class="page_title">
			<h2 class="fl">
				<form action="/store/MemServlet">会员详情 
	           <input type="hidden" name="action" value="select"> 
			<input type="text" name="content"> 
			<input type="submit" name="submit" value="根据用户名查询"></form>
			</h2>

		</div>
		<table class="table">
			<tr>
				<th>
					序号
				</th>
				<th>
					用户等级
				</th>
				<th>
					用户名
				</th>
				<th>
					真实姓名
				</th>
				<th>
					电话号码
				</th>
				<th>
					地址
				</th>
				<th>
					邮箱
				</th>
				<th>
					积分
				</th>
				<th>
					会员维护
				</th>
			</tr>
			<%
				MemPageDivide pd = new MemPageDivide();

					String pageShowstr = (String) session.getAttribute("pageshow");
					int pageShow = 1;
					if (pageShowstr == null) {
						pageShow = 1;
					} else {
						pageShow = Integer.parseInt(pageShowstr);
					}
					List list = (List) session.getAttribute("memlist");
					Iterator it = list.iterator();
					int i = 1;
					while (it.hasNext()) {
						Member mem = (Member) it.next();
			%>
					<form action="/store/MemServlet">
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="mid" value=<%=mem.getMid() %>>
			<tr>
				<td><%=i++%></td>
				<td><%=mem.getMlevel()%></td>
				<td><%=mem.getLoginName()%></td>
				<td><%=mem.getmName()%></td>
				<td><%=mem.getPhone()%></td>
				<td><%=mem.getAddress()%></td>
				<td><%=mem.getEmail()%></td>
				<td><input type="text" name="intergal" value=<%=mem.getIntergal()%>></td>
				  <td>  <input type="submit" value="修改">
					</form>
					<a href="/store/MemServlet?action=delete&mid=<%=mem.getMid() %>" class="inner_btn">删除</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<aside class="paging">
		<a href="/store/MermServlet?pageShow=<%=1%>">第一页</a>
		<a href="/store/MemServlet?pageShow=<%=pageShow - 1%>">上一页</a>
		<a href="/store/MemServlet?pageShow=<%=pageShow + 1%>">下一页</a>
		<a href="/store/MemServlet?pageShow=<%=pd.getPageNum()%>">最后一页</a>
		</aside>
		</section>

	<body><div align="center"><br></div></body>
</html>
