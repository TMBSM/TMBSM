<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.pagedivide.bean.MerPageDivide"%>
<%@page import="com.entity.Merchandise"%>
<%@page import="com.pagedivide.bean.OrderPageDivide"%>
<%@page import="com.entity.Orders"%>
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
					<!--当前链接则添加class:active-->
					<dd>
						<a href="/store/MerServlet?action=selectall">商品列表</a>
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
						<a href="/store/OrderServlet?action=selectall"  class="active">订单列表</a>
					</dd>
				</dl>
			</li>
			<li>
				<dl>
					<dt>
						会员管理
					</dt>
					<dd>
						<a href="/store/MemServlet?action=selectall">会员列表</a>
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
				<form action="/store/OrderServlet">订单详情 
	           <input type="hidden" name="action" value="select"> 
			<input type="text" name="content"> 
			<input type="submit" name="submit" value="根据用户编号查询"></form>
			</h2>

		</div>
		<table class="table">
			<tr>
				<th>
					序号
				</th>
				<th>
					会员编号
				</th>
				<th>
					订单编号
				</th>
				<th>
					订单时间
				</th>
				<th>
					总价
				</th>
				<th>
					订单状态
				</th>
				<th>
					快递状态
				</th>
				<th>
					付款方式
				</th>
				<th>
					订单维护
				</th>
			</tr>
			<%
				OrderPageDivide pd = new OrderPageDivide();

					String pageShowstr = (String) session.getAttribute("pageshow");
					int pageShow = 1;
					if (pageShowstr == null) {
						pageShow = 1;
					} else {
						pageShow = Integer.parseInt(pageShowstr);
					}
					List list = (List) session.getAttribute("orderlist");
					Iterator it = list.iterator();
					int i = 1;
					while (it.hasNext()) {
						Orders or = (Orders) it.next();
			%>
					<form action="/store/OrderServlet">
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="oid" value=<%=or.getOid() %>>
			<tr>
				<td><%=i++%></td>
				<td><%=or.getMid()%></td>
				<td><%=or.getOrderNo()%></td>
				<td>
				
				<%=or.getOrderdate().toString()%></td>
				<td><%=or.getSum()%></td>
				<td>
				 <%if(or.getOrderstatus()==0){ %>
				 <input type="radio" name="orderstatus" value="0" checked="checked">未付款
			    <input type="radio" name="orderstatus" value="1"> 已付款
				<%}else{ %>
				 <input type="radio" name="orderstatus" value="0" >未付款
			    <input type="radio" name="orderstatus" value="1" checked="checked"> 已付款
				<%} %>
				</td>
				<td>
				 <%if(or.getDstatus()==0){ %>
				 <input type="radio" name="dstatus" value="0" checked="checked">未发货
			    <input type="radio" name="dstatus" value="1"> 已发货
			    <input type="radio" name="dstatus" value="2"> 已签收
				<%}else if(or.getDstatus()==1){ %>
				 <input type="radio" name="dstatus" value="0" >未发货
			    <input type="radio" name="dstatus" value="1" checked="checked"> 已发货
			    <input type="radio" name="dstatus" value="2"> 已签收
				<%}else{ %>
				 <input type="radio" name="dstatus" value="0" >未发货
			    <input type="radio" name="dstatus" value="1" > 已发货
			    <input type="radio" name="dstatus" value="2" checked="checked"> 已签收
				<%} %></td>
				<td>
				 <%if(or.getPay()==0){ %>
				 <input type="radio" name="pay" value="0" checked="checked">现付
			    <input type="radio" name="pay" value="1"> 到付
				<%}else{ %>
				 <input type="radio" name="pay" value="0" >现付
			    <input type="radio" name="pay" value="1" checked="checked"> 到付
				<%} %>
				</td>
				  <td>  <input type="submit" value="修改">
					</form>
					<a href="/store/OrderServlet?action=delete&oid=<%=or.getOid() %>" class="inner_btn">删除</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<aside class="paging">
		<a href="/store/OrderServlet?pageShow=<%=1%>">第一页</a>
		<a href="/store/OrderServlet?pageShow=<%=pageShow - 1%>">上一页</a>
		<a href="/store/OrderServlet?pageShow=<%=pageShow + 1%>">下一页</a>
		<a href="/store/OrderServlet?pageShow=<%=pd.getPageNum()%>">最后一页</a>
		</aside>
		</section>

	<body></body>
</html>
